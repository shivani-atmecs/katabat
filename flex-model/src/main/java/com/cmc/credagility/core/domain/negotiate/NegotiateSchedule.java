package com.cmc.credagility.core.domain.negotiate;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.cmc.credagility.core.domain.schedule.BaseRule;
import com.cmc.credagility.core.domain.schedule.BaseSchedule;
import com.cmc.credagility.core.domain.type.ScheduleStatus;


/**
 * This class is used to store Portfolio Negotiate schedule information.
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/14/2014 18:01
 */
@Entity
@Table(
  name    = "NegotiateSchedule",
  indexes = {
    @Index(
      name = "statusIndex",
      columnList = "scheduleStatus"
    )
  }
)
public class NegotiateSchedule extends BaseSchedule {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -8217232649220272193L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** The deployed negotiate rules. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "negotiateSchedule",
    cascade       = { CascadeType.ALL, CascadeType.REMOVE },
    orphanRemoval = true
  )
  @OrderBy("priority asc")
  @Where(clause = "deployed='Y'")
  private Set<NegotiateRule> deployedNegotiateRules = new LinkedHashSet<NegotiateRule>();

  /** The draft negotiate rules. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "negotiateSchedule",
    cascade       = { CascadeType.ALL, CascadeType.REMOVE },
    orphanRemoval = true
  )
  @OrderBy("priority asc")
  @Where(clause = "deployed='N'")
  private Set<NegotiateRule> draftNegotiateRules = new LinkedHashSet<NegotiateRule>();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * Add negotiate rule to schedule.
   *
   * @param   negotiateRule  $param.type$
   *
   * @return  add negotiate rule to schedule.
   */
  public boolean addNegotiateRule(NegotiateRule negotiateRule) {
    Long portfolioId = this.getPortfolio().getPortfolioId();

    if (portfolioId != null) {
      negotiateRule.setPortfolioId(portfolioId.longValue());
    }

    negotiateRule.setNegotiateSchedule(this);

    return draftNegotiateRules.add(negotiateRule);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Add or Update draft rule.
   *
   * @param   userId         $param.type$
   * @param   negotiateRule  $param.type$
   *
   * @return  add or Update draft rule.
   */
  public NegotiateRule addOrUpdateDraftRule(Long userId, NegotiateRule negotiateRule) {
    Map<Long, NegotiateRule> myRules = getDraftNegotiateRuleMap();
    Long                     ruleId  = negotiateRule.getRuleId();

    if (ruleId != null) {
      // do update if it exists
      NegotiateRule myNegotiateRule = myRules.get(ruleId);
      myNegotiateRule.updateRule(negotiateRule);
      myNegotiateRule.setLastUpdateAgentId(userId);
      myNegotiateRule.setLastUpdateDate(new Date());

// myNegotiateRule.setDeployed(false);
// myNegotiateRule.setComplied(false);
      myNegotiateRule.setValid(negotiateRule.getValid());

      return myNegotiateRule;
    } else {
      negotiateRule.setCreateAgentId(userId);
      negotiateRule.setCreateDate(new Date());

      negotiateRule.setDeployed(false);
      negotiateRule.setComplied(false);
      negotiateRule.setValid(false);

      negotiateRule.setNegotiateSchedule(this);
      this.draftNegotiateRules.add(negotiateRule);

      return negotiateRule;
    } // end if-else
  }   // end method addOrUpdateDraftRule

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Deploy rules from draft set and discard the current deployed set.
   *
   * @return  DOCUMENT ME!
   */
  @Override public boolean deployRules() {
    boolean            ret           = true;
    Set<NegotiateRule> rulesToDeploy = new LinkedHashSet<NegotiateRule>();

    for (NegotiateRule negotiateRule : draftNegotiateRules) {
      // double confirm the rule status before deploy
      // only valid and compiled rule could be deploy
      if (Boolean.TRUE.equals(negotiateRule.getValid())) {
        NegotiateRule newNegotiateRule = new NegotiateRule();
        newNegotiateRule.deepCopy(negotiateRule);

        if (negotiateRule.getCreateAgentId() != null) {
          newNegotiateRule.setCreateAgentId(new Long(negotiateRule.getCreateAgentId()));
        }

        newNegotiateRule.setDeployed(true);
        newNegotiateRule.setValid(true);
        newNegotiateRule.setComplied(true);
        newNegotiateRule.setRuleContent(negotiateRule.getRuleContent());

        Long portfolioId = this.getPortfolio().getPortfolioId();

        if (portfolioId != null) {
          newNegotiateRule.setPortfolioId(portfolioId.longValue());
        }

        newNegotiateRule.setNegotiateSchedule(this);

        // add to deploy set
        rulesToDeploy.add(newNegotiateRule);
      } else {
        // deploy fail if the draft rule is not compiled or not valid
        ret = false;

        break;
      } // end if-else
    }   // end for

    if (ret) {
      setScheduleStatus(ScheduleStatus.SCHEDULED);

      // all done, update the deployed set now
      deployedNegotiateRules.clear();
      deployedNegotiateRules.addAll(rulesToDeploy);
    }

    return ret;
  } // end method deployRules

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * duplicate.
   *
   * @return  BaseSchedule
   */
  @Override public BaseSchedule duplicate() {
    NegotiateSchedule newSchedule = new NegotiateSchedule();
    newSchedule.init(this);

    // duplicate rules to schedule
    for (NegotiateRule rule : this.draftNegotiateRules) {
      NegotiateRule newRule = new NegotiateRule();
      newRule.deepCopy(rule);
      newSchedule.addNegotiateRule(newRule);
    }

    return newSchedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * duplicate.
   *
   * @param   portfolio  Portfolio
   *
   * @return  BaseSchedule
   */
  @Override public BaseSchedule duplicate(Portfolio portfolio) {
    boolean samePortfolio = this.getPortfolio().isSame(portfolio);

    NegotiateSchedule newSchedule = new NegotiateSchedule();
    newSchedule.init(this);
    newSchedule.setPortfolio(portfolio);

    // duplicate rules to schedule
    for (NegotiateRule rule : this.draftNegotiateRules) {
      NegotiateRule newRule = new NegotiateRule();

      if (samePortfolio) {
        newRule.deepCopy(rule);
      } else {
        newRule.copyCriteria(rule);
      }

      newSchedule.addNegotiateRule(newRule);
    }

    return newSchedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the map for the Deploy negotiate Rule using ruleId as key.
   *
   * @return  get the map for the Deploy negotiate Rule using ruleId as key.
   */
  public Map<Long, NegotiateRule> getDeployedNegotiateRuleMap() {
    Map<Long, NegotiateRule> map = new HashMap<Long, NegotiateRule>();

    for (NegotiateRule negotiateRule : deployedNegotiateRules) {
      map.put(negotiateRule.getRuleId(), negotiateRule);
    }

    return map;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for deployed negotiate rules.
   *
   * @return  Set
   */
  public Set<NegotiateRule> getDeployedNegotiateRules() {
    return deployedNegotiateRules;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for deployed rules.
   *
   * @return  Set
   */
  @Override public Set<BaseRule> getDeployedRules() {
    Set<BaseRule> rules = new LinkedHashSet<BaseRule>();
    rules.addAll(deployedNegotiateRules);

    return rules;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the map for the draft negotiate rule using ruleId as key.
   *
   * @return  get the map for the draft negotiate rule using ruleId as key.
   */
  public Map<Long, NegotiateRule> getDraftNegotiateRuleMap() {
    Map<Long, NegotiateRule> map = new HashMap<Long, NegotiateRule>();

    for (NegotiateRule negotiateRule : draftNegotiateRules) {
      map.put(negotiateRule.getRuleId(), negotiateRule);
    }

    return map;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for draft negotiate rules.
   *
   * @return  Set
   */
  public Set<NegotiateRule> getDraftNegotiateRules() {
    return draftNegotiateRules;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see com.cmc.credagility.BaseSchedule#getDraftRules()
   */
  @Override public Set<BaseRule> getDraftRules() {
    Set<BaseRule> rules = new LinkedHashSet<BaseRule>();
    rules.addAll(draftNegotiateRules);

    return rules;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see com.cmc.credagility.BaseSchedule#getScheduleType()
   */
  @Override public String getScheduleType() {
    return "NegotiateSchedule";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for deployed.
   *
   * @return  boolean
   */
  @Override public boolean isDeployed() {
    for (@SuppressWarnings("unused")
      NegotiateRule rule : deployedNegotiateRules) {
      return true;
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Reload rules from deployed set and discard the current draft set.
   */
  @Override public void reloadRules() {
    // clear the current set
    draftNegotiateRules.clear();

    for (NegotiateRule negotiateRule : deployedNegotiateRules) {
      NegotiateRule newNegotiateRule = new NegotiateRule();
      newNegotiateRule.deepCopy(negotiateRule);

      if (negotiateRule.getCreateAgentId() != null) {
        newNegotiateRule.setCreateAgentId(new Long(negotiateRule.getCreateAgentId()));
      }

      newNegotiateRule.setDeployed(false);
      newNegotiateRule.setValid(true);
      newNegotiateRule.setComplied(true);
      newNegotiateRule.setRuleContent(negotiateRule.getRuleContent());

      Long portfolioId = this.getPortfolio().getPortfolioId();

      if (portfolioId != null) {
        newNegotiateRule.setPortfolioId(portfolioId.longValue());
      }

      newNegotiateRule.setNegotiateSchedule(this);

      // add to draft set
      draftNegotiateRules.add(newNegotiateRule);
    }
  } // end method reloadRules

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * removeDraftRule.
   *
   * @param   userId  Long
   * @param   ruleId  Long
   *
   * @return  boolean
   */
  public boolean removeDraftRule(Long userId, Long ruleId) {
    if (ruleId != null) {
      // do update if it exists
      NegotiateRule negotiateRule = getDraftNegotiateRuleMap().get(ruleId);

      draftNegotiateRules.remove(negotiateRule);
      negotiateRule.setNegotiateSchedule(null);

      return true;
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for deployed negotiate rules.
   *
   * @param  deployedNegotiateRules  Set
   */
  public void setDeployedNegotiateRules(Set<NegotiateRule> deployedNegotiateRules) {
    this.deployedNegotiateRules = deployedNegotiateRules;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for draft negotiate rules.
   *
   * @param  negotiateRules  Set
   */
  public void setDraftNegotiateRules(Set<NegotiateRule> negotiateRules) {
    this.draftNegotiateRules = negotiateRules;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Constructs a <code>String</code> with all attributes in name = value format.
   *
   * @return  a <code>String</code> representation of this object.
   */
  @Override public String toString() {
    final String TAB = "    ";

    StringBuilder retValue = new StringBuilder();

    retValue.append("NegotiateSchedule ( ").append(super.toString()).append(TAB).append("deployedNegotiateRules = ")
      .append(
        this.deployedNegotiateRules).append(TAB).append(
      "draftNegotiateRules = ").append(this.draftNegotiateRules).append(
      TAB).append(" )");

    return retValue.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updateDraftRules.
   *
   * @param   userId  Long
   * @param   rules   List
   *
   * @return  boolean
   */
  public boolean updateDraftRules(Long userId, List<NegotiateRule> rules) {
    Date                     now            = new Date();
    Set<NegotiateRule>       negotiateRules = new LinkedHashSet<NegotiateRule>();
    Map<Long, NegotiateRule> myRules        = getDraftNegotiateRuleMap();

    for (NegotiateRule negotiateRule : rules) {
      Long ruleId = negotiateRule.getRuleId();

      negotiateRule.setCreateAgentId(userId);
      negotiateRule.setCreateDate(now);
      negotiateRule.setDeployed(false);

      if (ruleId != null) {
        // do update if it exists
        NegotiateRule myNegotiateRule = myRules.get(ruleId);
        myNegotiateRule.updateRule(negotiateRule);
        myNegotiateRule.setLastUpdateAgentId(ruleId);
        myNegotiateRule.setLastUpdateDate(now);
        negotiateRule = myNegotiateRule;
      }

      Long portfolioId = this.getPortfolio().getPortfolioId();

      if (portfolioId != null) {
        negotiateRule.setPortfolioId(portfolioId.longValue());
      }

      // add rule to set with the order
      negotiateRule.setNegotiateSchedule(this);
      negotiateRules.add(negotiateRule);
    } // end for

    this.draftNegotiateRules.clear();
    this.draftNegotiateRules.addAll(negotiateRules);

    return true;
  } // end method updateDraftRules
} // end class NegotiateSchedule
