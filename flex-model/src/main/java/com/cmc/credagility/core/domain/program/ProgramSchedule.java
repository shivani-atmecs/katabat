package com.cmc.credagility.core.domain.program;

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
 * This class is used to store Portfolio Program schedule information.
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/15/2014 11:31
 */
@Entity
@Table(
  name    = "ProgramSchedule",
  indexes = {
    @Index(
      name = "statusIndex",
      columnList = "scheduleStatus"
    )
  }
)
public class ProgramSchedule extends BaseSchedule {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -8217232649220272193L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** The deployed program rules. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "programSchedule",
    cascade       = { CascadeType.ALL, CascadeType.REMOVE },
    orphanRemoval = true
  )
  @OrderBy("priority desc")
  @Where(clause = "deployed='Y'")
  private Set<ProgramRule> deployedProgramRules = new LinkedHashSet<ProgramRule>();

  /** The draft program rules. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "programSchedule",
    cascade       = { CascadeType.ALL, CascadeType.REMOVE },
    orphanRemoval = true
  )
  @OrderBy("priority desc")
  @Where(clause = "deployed='N'")
  private Set<ProgramRule> draftProgramRules = new LinkedHashSet<ProgramRule>();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * Add or Update draft rule.
   *
   * @param   userId       $param.type$
   * @param   programRule  $param.type$
   *
   * @return  add or Update draft rule.
   */
  public ProgramRule addOrUpdateDraftRule(Long userId, ProgramRule programRule) {
    Map<Long, ProgramRule> myRules = getDraftProgramRuleMap();
    Long                   ruleId  = programRule.getRuleId();

    if (ruleId != null) {
      // do update if it exists
      ProgramRule myProgramRule = myRules.get(ruleId);
      myProgramRule.updateRule(programRule);
      myProgramRule.setLastUpdateAgentId(userId);
      myProgramRule.setLastUpdateDate(new Date());

// myProgramRule.setDeployed(false);
// myProgramRule.setComplied(false);
      myProgramRule.setValid(programRule.getValid());

      return myProgramRule;
    } else {
      programRule.setCreateAgentId(userId);
      programRule.setCreateDate(new Date());

      programRule.setDeployed(false);
      programRule.setComplied(false);
      programRule.setValid(false);

      programRule.setProgramSchedule(this);
      this.draftProgramRules.add(programRule);

      return programRule;
    } // end if-else
  }   // end method addOrUpdateDraftRule

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Add program rule to schedule.
   *
   * @param   programRule  $param.type$
   *
   * @return  add program rule to schedule.
   */
  public boolean addProgramRule(ProgramRule programRule) {
    Long portfolioId = this.getPortfolio().getPortfolioId();

    if (portfolioId != null) {
      programRule.setPortfolioId(portfolioId.longValue());
    }

    programRule.setProgramSchedule(this);

    return draftProgramRules.add(programRule);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Deploy rules from draft set and discard the current deployed set.
   *
   * @return  DOCUMENT ME!
   */
  @Override public boolean deployRules() {
    boolean          ret           = true;
    Set<ProgramRule> rulesToDeploy = new LinkedHashSet<ProgramRule>();

    for (ProgramRule programRule : draftProgramRules) {
      // double confirm the rule status before deploy
      // only valid rule could be deploy
      if (Boolean.TRUE.equals(programRule.getValid())) {
        ProgramRule newProgramRule = new ProgramRule();
        newProgramRule.deepCopy(programRule);

        if (programRule.getCreateAgentId() != null) {
          newProgramRule.setCreateAgentId(new Long(programRule.getCreateAgentId()));
        }

        newProgramRule.setDeployed(true);
        newProgramRule.setValid(true);
        newProgramRule.setComplied(false);
        newProgramRule.setRuleContent(null);

        Long portfolioId = this.getPortfolio().getPortfolioId();

        if (portfolioId != null) {
          newProgramRule.setPortfolioId(portfolioId.longValue());
        }

        newProgramRule.setProgramSchedule(this);

        // add to deploy set
        rulesToDeploy.add(newProgramRule);
      } else {
        // deploy fail if the draft rule is not valid
        ret = false;

        break;
      } // end if-else
    }   // end for

    if (ret) {
      setScheduleStatus(ScheduleStatus.SCHEDULED);

      // all done, update the deployed set now
      deployedProgramRules.clear();
      deployedProgramRules.addAll(rulesToDeploy);
    }

    return ret;
  } // end method deployRules

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.schedule.BaseSchedule#duplicate()
   */
  @Override public BaseSchedule duplicate() {
    ProgramSchedule newSchedule = new ProgramSchedule();
    newSchedule.init(this);

    // duplicate rules to schedule
    for (ProgramRule rule : this.draftProgramRules) {
      ProgramRule newRule = new ProgramRule();
      newRule.deepCopy(rule);
      newSchedule.addProgramRule(newRule);
    }

    return newSchedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.schedule.BaseSchedule#duplicate(com.cmc.credagility.core.domain.portfolio.Portfolio)
   */
  @Override public BaseSchedule duplicate(Portfolio portfolio) {
    boolean samePortfolio = this.getPortfolio().isSame(portfolio);

    ProgramSchedule newSchedule = new ProgramSchedule();
    newSchedule.init(this);
    newSchedule.setPortfolio(portfolio);

    // duplicate rules to schedule
    for (ProgramRule rule : this.draftProgramRules) {
      ProgramRule newRule = new ProgramRule();

      if (samePortfolio) {
        newRule.deepCopy(rule);
      } else {
        newRule.copyCriteria(rule);
      }

      newSchedule.addProgramRule(newRule);
    }

    return newSchedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the map for the Deploy program Rule using ruleId as key.
   *
   * @return  get the map for the Deploy program Rule using ruleId as key.
   */
  public Map<Long, ProgramRule> getDeployedProgramRuleMap() {
    Map<Long, ProgramRule> map = new HashMap<Long, ProgramRule>();

    for (ProgramRule programRule : deployedProgramRules) {
      map.put(programRule.getRuleId(), programRule);
    }

    return map;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for deployed program rules.
   *
   * @return  Set
   */
  public Set<ProgramRule> getDeployedProgramRules() {
    return deployedProgramRules;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.schedule.BaseSchedule#getDeployedRules()
   */
  @Override public Set<BaseRule> getDeployedRules() {
    Set<BaseRule> rules = new LinkedHashSet<BaseRule>();
    rules.addAll(deployedProgramRules);

    return rules;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for draft program rule map.
   *
   * @return  Map
   */
  public Map<Long, ProgramRule> getDraftProgramRuleMap() {
    Map<Long, ProgramRule> map = new HashMap<Long, ProgramRule>();

    for (ProgramRule programRule : draftProgramRules) {
      map.put(programRule.getRuleId(), programRule);
    }

    return map;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for draft program rules.
   *
   * @return  Set
   */
  public Set<ProgramRule> getDraftProgramRules() {
    return draftProgramRules;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.schedule.BaseSchedule#getDraftRules()
   */
  @Override public Set<BaseRule> getDraftRules() {
    Set<BaseRule> rules = new LinkedHashSet<BaseRule>();
    rules.addAll(draftProgramRules);

    return rules;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.schedule.BaseSchedule#getScheduleType()
   */
  @Override public String getScheduleType() {
    return "ProgramSchedule";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.schedule.BaseSchedule#isDeployed()
   */
  @Override public boolean isDeployed() {
    for (@SuppressWarnings("unused")
      ProgramRule rule : deployedProgramRules) {
      return true;
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.schedule.BaseSchedule#reloadRules()
   */
  @Override public void reloadRules() {
    // clear the current set
    draftProgramRules.clear();

    for (ProgramRule programRule : deployedProgramRules) {
      ProgramRule newProgramRule = new ProgramRule();
      newProgramRule.deepCopy(programRule);

      if (programRule.getCreateAgentId() != null) {
        newProgramRule.setCreateAgentId(new Long(programRule.getCreateAgentId()));
      }

      newProgramRule.setDeployed(false);
      newProgramRule.setValid(true);
      newProgramRule.setComplied(true);
      newProgramRule.setRuleContent(programRule.getRuleContent());

      Long portfolioId = this.getPortfolio().getPortfolioId();

      if (portfolioId != null) {
        newProgramRule.setPortfolioId(portfolioId.longValue());
      }

      newProgramRule.setProgramSchedule(this);

      // add to draft set
      draftProgramRules.add(newProgramRule);
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
      ProgramRule programRule = getDraftProgramRuleMap().get(ruleId);

      draftProgramRules.remove(programRule);
      programRule.setProgramSchedule(null);

      return true;
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for deployed program rules.
   *
   * @param  deployedProgramRules  Set
   */
  public void setDeployedProgramRules(Set<ProgramRule> deployedProgramRules) {
    this.deployedProgramRules = deployedProgramRules;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for draft program rules.
   *
   * @param  programRules  Set
   */
  public void setDraftProgramRules(Set<ProgramRule> programRules) {
    this.draftProgramRules = programRules;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.schedule.BaseSchedule#toString()
   */
  @Override public String toString() {
    final String TAB = "    ";

    StringBuilder retValue = new StringBuilder();

    retValue.append("ProgramSchedule ( ").append(super.toString()).append(TAB).append("deployedProgramRules = ").append(
      this.deployedProgramRules).append(TAB).append("draftProgramRules = ").append(
      this.draftProgramRules).append(TAB).append(" )");

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
  public boolean updateDraftRules(Long userId, List<ProgramRule> rules) {
    Set<ProgramRule>       programRules = new LinkedHashSet<ProgramRule>();
    Map<Long, ProgramRule> myRules      = getDraftProgramRuleMap();

    for (ProgramRule programRule : rules) {
      Long ruleId = programRule.getRuleId();

      programRule.setCreateAgentId(userId);
      programRule.setCreateDate(new Date());
      programRule.setDeployed(false);

      if (ruleId != null) {
        // do update if it exists
        ProgramRule myProgramRule = myRules.get(ruleId);
        myProgramRule.updateRule(programRule);
        programRule = myProgramRule;
      }

      Long portfolioId = this.getPortfolio().getPortfolioId();

      if (portfolioId != null) {
        programRule.setPortfolioId(portfolioId.longValue());
      }

      // add rule to set with the order
      programRule.setProgramSchedule(this);
      programRules.add(programRule);
    } // end for

    this.draftProgramRules.clear();
    this.draftProgramRules.addAll(programRules);

    return true;
  } // end method updateDraftRules
} // end class ProgramSchedule
