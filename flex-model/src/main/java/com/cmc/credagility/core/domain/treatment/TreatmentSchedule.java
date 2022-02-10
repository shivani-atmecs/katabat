package com.cmc.credagility.core.domain.treatment;

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
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.cmc.credagility.core.domain.schedule.BaseRule;
import com.cmc.credagility.core.domain.schedule.BaseSchedule;
import com.cmc.credagility.core.domain.type.ScheduleStatus;


/**
 * This class is used to store Portfolio treatment schedule information.
 *
 * <p><a href="TreatmentSchedule.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 * @version  10/15/2014 16:08
 */
@Entity
@Table(
  name    = "TreatmentSchedule",
  indexes = {
    @Index(
      name = "statusIndex",
      columnList = "scheduleStatus"
    )
  }
)
public class TreatmentSchedule extends BaseSchedule {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -8217232649220272193L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** The deployed treatment rules. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "treatmentSchedule",
    cascade       = { CascadeType.ALL, CascadeType.REMOVE },
    orphanRemoval = true
  )
  @Where(clause = "deployed='Y'")
  private Set<TreatmentRule> deployedTreatmentRules = new LinkedHashSet<TreatmentRule>();

  /** The draft treatment rules. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "treatmentSchedule",
    cascade       = { CascadeType.ALL, CascadeType.REMOVE },
    orphanRemoval = true
  )
  @Where(clause = "deployed='N'")
  private Set<TreatmentRule> draftTreatmentRules = new LinkedHashSet<TreatmentRule>();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * Add or Update draft rule.
   *
   * @param   userId         $param.type$
   * @param   treatmentRule  $param.type$
   *
   * @return  add or Update draft rule.
   */
  public TreatmentRule addOrUpdateDraftRule(Long userId, TreatmentRule treatmentRule) {
    Map<Long, TreatmentRule> myRules = getDraftTreatmentRuleMap();
    Long                     ruleId  = treatmentRule.getRuleId();

    if (ruleId != null) {
      // do update if it exists
      TreatmentRule myTreatmentRule = myRules.get(ruleId);
      myTreatmentRule.updateRule(treatmentRule);
      myTreatmentRule.setLastUpdateAgentId(userId);
      myTreatmentRule.setLastUpdateDate(new Date());

// myTreatmentRule.setDeployed(false);
// myTreatmentRule.setComplied(false);
      myTreatmentRule.setValid(treatmentRule.getValid());

      return myTreatmentRule;
    } else {
      treatmentRule.setCreateAgentId(userId);
      treatmentRule.setCreateDate(new Date());

      treatmentRule.setDeployed(false);
      treatmentRule.setComplied(false);
      treatmentRule.setValid(false);

      treatmentRule.setTreatmentSchedule(this);
      this.draftTreatmentRules.add(treatmentRule);

      return treatmentRule;
    } // end if-else
  }   // end method addOrUpdateDraftRule

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Add treatment rule to schedule.
   *
   * @param   treatmentRule  $param.type$
   *
   * @return  add treatment rule to schedule.
   */
  public boolean addTreatmentRule(TreatmentRule treatmentRule) {
    Long portfolioId = this.getPortfolio().getPortfolioId();

    if (portfolioId != null) {
      treatmentRule.setPortfolioId(portfolioId.longValue());
    }

    treatmentRule.setTreatmentSchedule(this);

    return draftTreatmentRules.add(treatmentRule);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Deploy rules from draft set and discard the current deployed set.
   *
   * @return  deploy rules from draft set and discard the current deployed set.
   */
  @Override public boolean deployRules() {
    boolean            ret           = true;
    Set<TreatmentRule> rulesToDeploy = new LinkedHashSet<TreatmentRule>();

    for (TreatmentRule treatmentRule : draftTreatmentRules) {
      // double confirm the rule status before deploy
      // only valid rule could be deploy
      if (Boolean.TRUE.equals(treatmentRule.getValid())) {
        TreatmentRule newTreatmentRule = new TreatmentRule();
        newTreatmentRule.deepCopy(treatmentRule);

        if (treatmentRule.getCreateAgentId() != null) {
          newTreatmentRule.setCreateAgentId(new Long(treatmentRule.getCreateAgentId()));
        }

        newTreatmentRule.setDeployed(true);
        newTreatmentRule.setValid(true);
        newTreatmentRule.setComplied(false);
        newTreatmentRule.setRuleContent(null);

        Long portfolioId = this.getPortfolio().getPortfolioId();

        if (portfolioId != null) {
          newTreatmentRule.setPortfolioId(portfolioId.longValue());
        }

        newTreatmentRule.setTreatmentSchedule(this);

        // add to deploy set
        rulesToDeploy.add(newTreatmentRule);
      } else {
        // deploy fail if the draft rule is not valid
        ret = false;

        break;
      } // end if-else
    }   // end for

    if (ret) {
      setScheduleStatus(ScheduleStatus.SCHEDULED);

      // all done, update the deployed set now
      deployedTreatmentRules.clear();
      deployedTreatmentRules.addAll(rulesToDeploy);
    }

    return ret;
  } // end method deployRules

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  BaseSchedule#duplicate()
   */
  @Override public BaseSchedule duplicate() {
    TreatmentSchedule newSchedule = new TreatmentSchedule();
    newSchedule.init(this);

    // duplicate rules to schedule
    for (TreatmentRule rule : this.draftTreatmentRules) {
      TreatmentRule newRule = new TreatmentRule();
      newRule.deepCopy(rule);
      newSchedule.addTreatmentRule(newRule);
    }

    return newSchedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  BaseSchedule#duplicate(com.cmc.credagility.core.domain.portfolio.Portfolio)
   */
  @Override public BaseSchedule duplicate(Portfolio portfolio) {
    boolean samePortfolio = this.getPortfolio().isSame(portfolio);

    TreatmentSchedule newSchedule = new TreatmentSchedule();
    newSchedule.init(this);
    newSchedule.setPortfolio(portfolio);

    // duplicate rules to schedule
    for (TreatmentRule rule : this.draftTreatmentRules) {
      TreatmentRule newRule = new TreatmentRule();

      if (samePortfolio) {
        newRule.deepCopy(rule);
      } else {
        newRule.copyCriteria(rule);
      }

      newSchedule.addTreatmentRule(newRule);
    }

    return newSchedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see com.cmc.credagility.BaseSchedule#getDeployedRules()
   */
  @Override public Set<BaseRule> getDeployedRules() {
    Set<BaseRule> rules = new LinkedHashSet<BaseRule>();
    rules.addAll(deployedTreatmentRules);

    return rules;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the map for the Deploy treatment Rule using ruleId as key.
   *
   * @return  get the map for the Deploy treatment Rule using ruleId as key.
   */
  public Map<Long, TreatmentRule> getDeployedTreatmentRuleMap() {
    Map<Long, TreatmentRule> map = new HashMap<Long, TreatmentRule>();

    for (TreatmentRule treatmentRule : deployedTreatmentRules) {
      map.put(treatmentRule.getRuleId(), treatmentRule);
    }

    return map;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for deployed treatment rules.
   *
   * @return  Set
   */
  public Set<TreatmentRule> getDeployedTreatmentRules() {
    return deployedTreatmentRules;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see com.cmc.credagility.BaseSchedule#getDraftRules()
   */
  @Override public Set<BaseRule> getDraftRules() {
    Set<BaseRule> rules = new LinkedHashSet<BaseRule>();
    rules.addAll(draftTreatmentRules);

    return rules;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the map for the draft treatment rule using ruleId as key.
   *
   * @return  get the map for the draft treatment rule using ruleId as key.
   */
  public Map<Long, TreatmentRule> getDraftTreatmentRuleMap() {
    Map<Long, TreatmentRule> map = new HashMap<Long, TreatmentRule>();

    for (TreatmentRule treatmentRule : draftTreatmentRules) {
      map.put(treatmentRule.getRuleId(), treatmentRule);
    }

    return map;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for draft treatment rules.
   *
   * @return  Set
   */
  public Set<TreatmentRule> getDraftTreatmentRules() {
    return draftTreatmentRules;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see com.cmc.credagility.BaseSchedule#getScheduleType()
   */
  @Override public String getScheduleType() {
    return "TreatmentSchedule";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.schedule.BaseSchedule#isDeployed()
   */
  @Override public boolean isDeployed() {
    for (@SuppressWarnings("unused")
      TreatmentRule rule : deployedTreatmentRules) {
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
    draftTreatmentRules.clear();

    for (TreatmentRule treatmentRule : deployedTreatmentRules) {
      TreatmentRule newTreatmentRule = new TreatmentRule();
      newTreatmentRule.deepCopy(treatmentRule);

      if (treatmentRule.getCreateAgentId() != null) {
        newTreatmentRule.setCreateAgentId(new Long(treatmentRule.getCreateAgentId()));
      }

      newTreatmentRule.setDeployed(false);
      newTreatmentRule.setValid(true);
      newTreatmentRule.setComplied(true);
      newTreatmentRule.setRuleContent(treatmentRule.getRuleContent());

      Long portfolioId = this.getPortfolio().getPortfolioId();

      if (portfolioId != null) {
        newTreatmentRule.setPortfolioId(portfolioId.longValue());
      }

      newTreatmentRule.setTreatmentSchedule(this);

      // add to draft set
      draftTreatmentRules.add(newTreatmentRule);
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
      TreatmentRule treatmentRule = getDraftTreatmentRuleMap().get(ruleId);

      draftTreatmentRules.remove(treatmentRule);
      treatmentRule.setTreatmentSchedule(null);

      return true;
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for deployed treatment rules.
   *
   * @param  deployedTreatmentRules  Set
   */
  public void setDeployedTreatmentRules(Set<TreatmentRule> deployedTreatmentRules) {
    this.deployedTreatmentRules = deployedTreatmentRules;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for draft treatment rules.
   *
   * @param  treatmentRules  Set
   */
  public void setDraftTreatmentRules(Set<TreatmentRule> treatmentRules) {
    this.draftTreatmentRules = treatmentRules;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.schedule.BaseSchedule#toString()
   */
  @Override public String toString() {
    final String TAB = "    ";

    StringBuilder retValue = new StringBuilder();

    retValue.append("TreatmentSchedule ( ").append(super.toString()).append(TAB).append("deployedTreatmentRules = ")
      .append(this.deployedTreatmentRules).append(TAB).append("draftTreatmentRules = ").append(
      this.draftTreatmentRules).append(TAB).append(" )");

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
  public boolean updateDraftRules(Long userId, List<TreatmentRule> rules) {
    Set<TreatmentRule>       treatmentRules = new LinkedHashSet<TreatmentRule>();
    Map<Long, TreatmentRule> myRules        = getDraftTreatmentRuleMap();

    for (TreatmentRule treatmentRule : rules) {
      Long ruleId = treatmentRule.getRuleId();

      treatmentRule.setCreateAgentId(userId);
      treatmentRule.setCreateDate(new Date());
      treatmentRule.setDeployed(false);

      if (ruleId != null) {
        // do update if it exists
        TreatmentRule myTreatmentRule = myRules.get(ruleId);
        myTreatmentRule.updateRule(treatmentRule);
        treatmentRule = myTreatmentRule;
      }

      Long portfolioId = this.getPortfolio().getPortfolioId();

      if (portfolioId != null) {
        treatmentRule.setPortfolioId(portfolioId.longValue());
      }

      // add rule to set with the order
      treatmentRule.setTreatmentSchedule(this);
      treatmentRules.add(treatmentRule);
    } // end for

    this.draftTreatmentRules.clear();
    this.draftTreatmentRules.addAll(treatmentRules);

    return true;
  } // end method updateDraftRules
} // end class TreatmentSchedule
