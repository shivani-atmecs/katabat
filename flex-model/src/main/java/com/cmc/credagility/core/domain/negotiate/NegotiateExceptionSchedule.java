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
 * @version  10/14/2014 17:44
 */
@Entity
@Table(
  indexes = {
    @Index(
      name = "statusIndex",
      columnList = "scheduleStatus"
    )
  }
)
public class NegotiateExceptionSchedule extends BaseSchedule {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -8217232649220272193L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** The deployed negotiate rules. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "exceptionSchedule",
    cascade       = { CascadeType.ALL, CascadeType.REMOVE },
    orphanRemoval = true
  )
  @OrderBy("priority asc")
  @Where(clause = "deployed='Y'")
  private Set<NegotiateExceptionRule> deployedExceptionRules = new LinkedHashSet<NegotiateExceptionRule>();

  /** The draft negotiate rules. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "exceptionSchedule",
    cascade       = { CascadeType.ALL, CascadeType.REMOVE },
    orphanRemoval = true
  )
  @OrderBy("priority asc")
  @Where(clause = "deployed='N'")
  private Set<NegotiateExceptionRule> draftExceptionRules = new LinkedHashSet<NegotiateExceptionRule>();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * Add negotiate rule to schedule.
   *
   * @param   exceptionRule  $param.type$
   *
   * @return  add negotiate rule to schedule.
   */
  public boolean addExceptionRule(NegotiateExceptionRule exceptionRule) {
    Long portfolioId = this.getPortfolio().getPortfolioId();

    if (portfolioId != null) {
      exceptionRule.setPortfolioId(portfolioId.longValue());
    }

    exceptionRule.setExceptionSchedule(this);

    return draftExceptionRules.add(exceptionRule);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Add or Update draft rule.
   *
   * @param   userId         $param.type$
   * @param   exceptionRule  $param.type$
   *
   * @return  add or Update draft rule.
   */
  public NegotiateExceptionRule addOrUpdateDraftRule(Long userId, NegotiateExceptionRule exceptionRule) {
    Map<Long, NegotiateExceptionRule> myRules = getDraftExceptionRuleMap();
    Long                              ruleId  = exceptionRule.getRuleId();

    if (ruleId != null) {
      // do update if it exists
      NegotiateExceptionRule myNegotiateExceptionRule = myRules.get(ruleId);
      myNegotiateExceptionRule.updateRule(exceptionRule);
      myNegotiateExceptionRule.setLastUpdateAgentId(userId);
      myNegotiateExceptionRule.setLastUpdateDate(new Date());

// myNegotiateExceptionRule.setDeployed(false);
// myNegotiateExceptionRule.setComplied(false);
      myNegotiateExceptionRule.setValid(exceptionRule.getValid());

      return myNegotiateExceptionRule;
    } else {
      exceptionRule.setCreateAgentId(userId);
      exceptionRule.setCreateDate(new Date());

      exceptionRule.setDeployed(false);
      exceptionRule.setComplied(false);
      exceptionRule.setValid(false);

      exceptionRule.setExceptionSchedule(this);
      this.draftExceptionRules.add(exceptionRule);

      return exceptionRule;
    } // end if-else
  }   // end method addOrUpdateDraftRule

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Deploy rules from draft set and discard the current deployed set.
   *
   * @return  DOCUMENT ME!
   */
  @Override public boolean deployRules() {
    boolean                     ret           = true;
    Set<NegotiateExceptionRule> rulesToDeploy = new LinkedHashSet<NegotiateExceptionRule>();

    for (NegotiateExceptionRule exceptionRule : draftExceptionRules) {
      // double confirm the rule status before deploy
      // only valid and compiled rule could be deploy
      if (Boolean.TRUE.equals(exceptionRule.getValid())) {
        NegotiateExceptionRule newNegotiateExceptionRule = new NegotiateExceptionRule();
        newNegotiateExceptionRule.deepCopy(exceptionRule);

        if (exceptionRule.getCreateAgentId() != null) {
          newNegotiateExceptionRule.setCreateAgentId(new Long(exceptionRule.getCreateAgentId()));
        }

        newNegotiateExceptionRule.setDeployed(true);
        newNegotiateExceptionRule.setValid(true);
        newNegotiateExceptionRule.setComplied(true);
        newNegotiateExceptionRule.setRuleContent(exceptionRule.getRuleContent());

        Long portfolioId = this.getPortfolio().getPortfolioId();

        if (portfolioId != null) {
          newNegotiateExceptionRule.setPortfolioId(portfolioId.longValue());
        }

        newNegotiateExceptionRule.setExceptionSchedule(this);

        // add to deploy set
        rulesToDeploy.add(newNegotiateExceptionRule);
      } else {
        // deploy fail if the draft rule is not compiled or not valid
        ret = false;

        break;
      } // end if-else
    }   // end for

    if (ret) {
      setScheduleStatus(ScheduleStatus.SCHEDULED);

      // all done, update the deployed set now
      deployedExceptionRules.clear();
      deployedExceptionRules.addAll(rulesToDeploy);
    }

    return ret;
  } // end method deployRules

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  BaseSchedule#duplicate()
   */
  @Override public BaseSchedule duplicate() {
    NegotiateExceptionSchedule newSchedule = new NegotiateExceptionSchedule();
    newSchedule.init(this);

    // duplicate rules to schedule
    for (NegotiateExceptionRule rule : this.draftExceptionRules) {
      NegotiateExceptionRule newRule = rule.duplicate();
      newSchedule.addExceptionRule(newRule);
    }

    return newSchedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  BaseSchedule#duplicate(com.cmc.credagility.core.domain.portfolio.Portfolio)
   */
  @Override public BaseSchedule duplicate(Portfolio portfolio) {
    boolean samePortfolio = this.getPortfolio().isSame(portfolio);

    NegotiateExceptionSchedule newSchedule = new NegotiateExceptionSchedule();
    newSchedule.init(this);
    newSchedule.setPortfolio(portfolio);

    // duplicate rules to schedule
    for (NegotiateExceptionRule rule : this.draftExceptionRules) {
      NegotiateExceptionRule newRule = new NegotiateExceptionRule();

      if (samePortfolio) {
        newRule = rule.duplicate();
      } else {
        newRule.copyCriteria(rule);
      }

      newSchedule.addExceptionRule(newRule);
    }

    return newSchedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the map for the Deploy negotiate Rule using ruleId as key.
   *
   * @return  get the map for the Deploy negotiate Rule using ruleId as key.
   */
  public Map<Long, NegotiateExceptionRule> getDeployedExceptionRuleMap() {
    Map<Long, NegotiateExceptionRule> map = new HashMap<Long, NegotiateExceptionRule>();

    for (NegotiateExceptionRule exceptionRule : deployedExceptionRules) {
      map.put(exceptionRule.getRuleId(), exceptionRule);
    }

    return map;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for deployed exception rules.
   *
   * @return  Set
   */
  public Set<NegotiateExceptionRule> getDeployedExceptionRules() {
    return deployedExceptionRules;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  BaseSchedule#getDeployedRules()
   */
  @Override public Set<BaseRule> getDeployedRules() {
    Set<BaseRule> rules = new LinkedHashSet<BaseRule>();
    rules.addAll(deployedExceptionRules);

    return rules;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the map for the draft negotiate rule using ruleId as key.
   *
   * @return  get the map for the draft negotiate rule using ruleId as key.
   */
  public Map<Long, NegotiateExceptionRule> getDraftExceptionRuleMap() {
    Map<Long, NegotiateExceptionRule> map = new HashMap<Long, NegotiateExceptionRule>();

    for (NegotiateExceptionRule exceptionRule : draftExceptionRules) {
      map.put(exceptionRule.getRuleId(), exceptionRule);
    }

    return map;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for draft exception rules.
   *
   * @return  Set
   */
  public Set<NegotiateExceptionRule> getDraftExceptionRules() {
    return draftExceptionRules;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see com.cmc.credagility.BaseSchedule#getDraftRules()
   */
  @Override public Set<BaseRule> getDraftRules() {
    Set<BaseRule> rules = new LinkedHashSet<BaseRule>();
    rules.addAll(draftExceptionRules);

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
   * DOCUMENT ME!
   *
   * @return  the deployed
   */
  @Override public boolean isDeployed() {
    for (@SuppressWarnings("unused")
      NegotiateExceptionRule rule : deployedExceptionRules) {
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
    draftExceptionRules.clear();

    for (NegotiateExceptionRule exceptionRule : deployedExceptionRules) {
      NegotiateExceptionRule newNegotiateExceptionRule = new NegotiateExceptionRule();
      newNegotiateExceptionRule.deepCopy(exceptionRule);

      if (exceptionRule.getCreateAgentId() != null) {
        newNegotiateExceptionRule.setCreateAgentId(new Long(exceptionRule.getCreateAgentId()));
      }

      newNegotiateExceptionRule.setDeployed(false);
      newNegotiateExceptionRule.setValid(true);
      newNegotiateExceptionRule.setComplied(true);
      newNegotiateExceptionRule.setRuleContent(exceptionRule.getRuleContent());

      Long portfolioId = this.getPortfolio().getPortfolioId();

      if (portfolioId != null) {
        newNegotiateExceptionRule.setPortfolioId(portfolioId.longValue());
      }

      newNegotiateExceptionRule.setExceptionSchedule(this);

      // add to draft set
      draftExceptionRules.add(newNegotiateExceptionRule);
    }
  } // end method reloadRules

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Remove draft rule.
   *
   * @param   userId  $param.type$
   * @param   ruleId  agencyQueueId
   *
   * @return  DOCUMENT ME!
   */
  public boolean removeDraftRule(Long userId, Long ruleId) {
    if (ruleId != null) {
      // do update if it exists
      NegotiateExceptionRule exceptionRule = getDraftExceptionRuleMap().get(ruleId);

      draftExceptionRules.remove(exceptionRule);
      exceptionRule.setExceptionSchedule(null);

      return true;
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  deployedExceptionRules  DOCUMENT ME!
   */
  public void setDeployedExceptionRules(Set<NegotiateExceptionRule> deployedExceptionRules) {
    this.deployedExceptionRules = deployedExceptionRules;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  deployedExceptionRules  the deployedExceptionRules to set
   */
  public void setDeployedNegotiateExceptionRules(Set<NegotiateExceptionRule> deployedExceptionRules) {
    this.deployedExceptionRules = deployedExceptionRules;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  draftExceptionRules  DOCUMENT ME!
   */
  public void setDraftExceptionRules(Set<NegotiateExceptionRule> draftExceptionRules) {
    this.draftExceptionRules = draftExceptionRules;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  exceptionRules  the draftExceptionRules to set
   */
  public void setDraftNegotiateExceptionRules(Set<NegotiateExceptionRule> exceptionRules) {
    this.draftExceptionRules = exceptionRules;
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

    retValue.append("NegotiateSchedule ( ").append(super.toString()).append(TAB).append("deployedExceptionRules = ")
      .append(
        this.deployedExceptionRules).append(TAB).append(
      "draftExceptionRules = ").append(this.draftExceptionRules).append(
      TAB).append(" )");

    return retValue.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Update draft rule set.
   *
   * @param   userId  $param.type$
   * @param   rules   $param.type$
   *
   * @return  DOCUMENT ME!
   */
  public boolean updateDraftRules(Long userId, List<NegotiateExceptionRule> rules) {
    Date                              now            = new Date();
    Set<NegotiateExceptionRule>       exceptionRules = new LinkedHashSet<NegotiateExceptionRule>();
    Map<Long, NegotiateExceptionRule> myRules        = getDraftExceptionRuleMap();

    for (NegotiateExceptionRule exceptionRule : rules) {
      Long ruleId = exceptionRule.getRuleId();

      exceptionRule.setCreateAgentId(userId);
      exceptionRule.setCreateDate(now);
      exceptionRule.setDeployed(false);

      if (ruleId != null) {
        // do update if it exists
        NegotiateExceptionRule myNegotiateExceptionRule = myRules.get(ruleId);
        myNegotiateExceptionRule.updateRule(exceptionRule);
        myNegotiateExceptionRule.setLastUpdateAgentId(ruleId);
        myNegotiateExceptionRule.setLastUpdateDate(now);
        exceptionRule = myNegotiateExceptionRule;
      }

      Long portfolioId = this.getPortfolio().getPortfolioId();

      if (portfolioId != null) {
        exceptionRule.setPortfolioId(portfolioId.longValue());
      }

      // add rule to set with the order
      exceptionRule.setExceptionSchedule(this);
      exceptionRules.add(exceptionRule);
    } // end for

    this.draftExceptionRules.clear();
    this.draftExceptionRules.addAll(exceptionRules);

    return true;
  } // end method updateDraftRules
} // end class NegotiateExceptionSchedule
