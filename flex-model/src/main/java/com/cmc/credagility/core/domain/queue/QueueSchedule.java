package com.cmc.credagility.core.domain.queue;

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

import com.cmc.credagility.core.domain.agency.AgencyQueue;
import com.cmc.credagility.core.domain.agency.AgencyTeamQueue;
import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.cmc.credagility.core.domain.schedule.BaseRule;
import com.cmc.credagility.core.domain.schedule.BaseSchedule;
import com.cmc.credagility.core.domain.type.QueueCriteriaType;
import com.cmc.credagility.core.domain.type.ScheduleStatus;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/15/2014 12:17
 */
@Entity
@Table(
  name    = "QueueSchedule",
  indexes = {
    @Index(
      name = "statusIndex",
      columnList = "scheduleStatus"
    )
  }
)
public class QueueSchedule extends BaseSchedule {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 5327205489744814610L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** The deployed Agency Queues. */

  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "queueSchedule",
    cascade       = { CascadeType.ALL, CascadeType.REMOVE },
    orphanRemoval = true
  )
  @OrderBy("queueCriteriaType asc, priority asc")
  @Where(clause = "deployed='Y'")
  private Set<AgencyQueue> deployedAgencyQueues = new LinkedHashSet<AgencyQueue>();

  /** The draft Agency Queues. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "queueSchedule",
    cascade       = { CascadeType.ALL, CascadeType.REMOVE },
    orphanRemoval = true
  )
  @OrderBy("queueCriteriaType asc, priority asc")
  @Where(clause = "deployed='N'")
  private Set<AgencyQueue> draftAgencyQueues = new LinkedHashSet<AgencyQueue>();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * Add an agency queue to draft queue list.
   *
   * @param   agencyQueue  DOCUMENT ME!
   *
   * @return  add an agency queue to draft queue list.
   */
  public boolean addDraftQueue(AgencyQueue agencyQueue) {
    agencyQueue.setQueueSchedule(this);

    return draftAgencyQueues.add(agencyQueue);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Update draft rule set, return remove set.
   *
   * @param   userId       DOCUMENT ME!
   * @param   agencyQueue  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public AgencyQueue addOrUpdateDraftRule(Long userId, AgencyQueue agencyQueue) {
    Map<Long, AgencyQueue> myRules = getDraftAgencyQueueMap();
    Long                   ruleId  = agencyQueue.getAgencyQueueId();

    if (ruleId != null) {
      // do update if it exists
      AgencyQueue myAgencyQueue = myRules.get(ruleId);
      myAgencyQueue.updateQueue(agencyQueue);
      myAgencyQueue.setLastUpdateAgentId(userId);
      myAgencyQueue.setLastUpdateDate(new Date());

// myAgencyQueue.setDeployed(false);
// myAgencyQueue.setComplied(false);
      myAgencyQueue.setValid(agencyQueue.getValid());

      return myAgencyQueue;
    } else {
      agencyQueue.setCreateAgentId(userId);
      agencyQueue.setCreateDate(new Date());

      agencyQueue.setDeployed(false);
      agencyQueue.setComplied(false);
      agencyQueue.setValid(false);

      agencyQueue.setQueueSchedule(this);

      AgencyTeamQueue defaultTeamQueue = new AgencyTeamQueue();

      /*defaultTeamQueue.createDefaultQueue(agencyQueue, agencyQueue.getRuleName(), agencyQueue.getRuleName());*/
      this.draftAgencyQueues.add(agencyQueue);

      return agencyQueue;
    } // end if-else
  }   // end method addOrUpdateDraftRule

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Deploy rules from draft set and discard the current deployed set.
   *
   * @return  DOCUMENT ME!
   */
  @Override public boolean deployRules() {
    boolean          ret           = true;
    Set<AgencyQueue> rulesToDeploy = new LinkedHashSet<AgencyQueue>();

    for (AgencyQueue agencyQueue : draftAgencyQueues) {
      // double confirm the rule status before deploy
      // only valid and compiled rule could be deploy
      if (Boolean.TRUE.equals(agencyQueue.getValid())
            || QueueCriteriaType.PERCENTAGE.equals(agencyQueue.getQueueCriteriaType())) {
        AgencyQueue newAgencyQueue = new AgencyQueue();
        newAgencyQueue.deepCopy(agencyQueue);

        if (agencyQueue.getCreateAgentId() != null) {
          newAgencyQueue.setCreateAgentId(new Long(agencyQueue.getCreateAgentId()));
        }

        newAgencyQueue.setDeployed(true);
        newAgencyQueue.setValid(true);
        newAgencyQueue.setComplied(true);
        newAgencyQueue.setRuleContent(agencyQueue.getRuleContent());

        Long portfolioId = this.getPortfolio().getPortfolioId();

        if (portfolioId != null) {
          newAgencyQueue.setPortfolioId(portfolioId.longValue());
        }

        newAgencyQueue.setQueueSchedule(this);

        // add to deploy set
        rulesToDeploy.add(newAgencyQueue);
        updateAllQueuesStatus(rulesToDeploy, true, true, true);
      } else {
        // deploy fail if the draft rule is not compiled or not valid
        ret = false;

        break;
      } // end if-else
    }   // end for

    if (ret) {
      setScheduleStatus(ScheduleStatus.SCHEDULED);

      // all done, update the deployed set now
      deployedAgencyQueues.clear();
      deployedAgencyQueues.addAll(rulesToDeploy);
    }

    return ret;

  } // end method deployRules

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.schedule.BaseSchedule#duplicate()
   */
  @Override public BaseSchedule duplicate() {
    QueueSchedule newSchedule = new QueueSchedule();
    newSchedule.init(this);

    Set<AgencyQueue> toCopy = this.draftAgencyQueues;

    if (getScheduleStatus().equals(ScheduleStatus.ACTIVE)) {
      // Copy deployed queues for active schedule
      toCopy = this.deployedAgencyQueues;
    }

    // duplicate rules to schedule
    for (AgencyQueue queue : toCopy) {
      AgencyQueue newQueue = new AgencyQueue();
      newQueue.deepCopy(queue);
      newSchedule.addDraftQueue(newQueue);
    }

    return newSchedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.schedule.BaseSchedule#duplicate(com.cmc.credagility.core.domain.portfolio.Portfolio)
   */
  @Override public BaseSchedule duplicate(Portfolio portfolio) {
    boolean samePortfolio = this.getPortfolio().isSame(portfolio);

    QueueSchedule newSchedule = new QueueSchedule();
    newSchedule.init(this);
    newSchedule.setPortfolio(portfolio);

    Set<AgencyQueue> toCopy = this.draftAgencyQueues;

    if (getScheduleStatus().equals(ScheduleStatus.ACTIVE)) {
      // Copy deployed queues for active schedule
      toCopy = this.deployedAgencyQueues;
    }

    // duplicate rules to schedule
    for (AgencyQueue queue : toCopy) {
      AgencyQueue newQueue = new AgencyQueue();

      if (samePortfolio) {
        newQueue.deepCopy(queue);
      } else {
        newQueue.deepCopyWithoutAssignment(queue);
      }

      newSchedule.addDraftQueue(newQueue);
    }

    return newSchedule;
  } // end method duplicate

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.schedule.BaseSchedule#getAllDeployedRules()
   */
  @Override public Set<BaseRule> getAllDeployedRules() {
    Set<BaseRule> buildRules = new LinkedHashSet<BaseRule>();

    for (AgencyQueue agencyQueue : getDeployedAgencyQueues()) {
      // build rule content
      if (QueueCriteriaType.FREEFORM.equals(agencyQueue.getQueueCriteriaType())) {
        buildRules.add(agencyQueue);
      }

      for (AgencyTeamQueue teamQueue : agencyQueue.getAgencyTeamQueues()) {
        if (QueueCriteriaType.FREEFORM.equals(teamQueue.getQueueCriteriaType())) {
          buildRules.add(teamQueue);
        }

        for (AgentQueue agentQueue : teamQueue.getAgentQueues()) {
          if (QueueCriteriaType.FREEFORM.equals(agentQueue.getQueueCriteriaType())) {
            buildRules.add(agentQueue);
          }
        }
      }
    }

    return buildRules;
  } // end method getAllDeployedRules

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.schedule.BaseSchedule#getAllDraftRules()
   */
  @Override public Set<BaseRule> getAllDraftRules() {
    Set<BaseRule> buildRules = new LinkedHashSet<BaseRule>();

    for (AgencyQueue agencyQueue : getDraftAgencyQueues()) {
      // build rule content
      if (QueueCriteriaType.FREEFORM.equals(agencyQueue.getQueueCriteriaType())) {
        buildRules.add(agencyQueue);
      }

      for (AgencyTeamQueue teamQueue : agencyQueue.getAgencyTeamQueues()) {
        if (QueueCriteriaType.FREEFORM.equals(teamQueue.getQueueCriteriaType())) {
          buildRules.add(teamQueue);
        }

        for (AgentQueue agentQueue : teamQueue.getAgentQueues()) {
          if (QueueCriteriaType.FREEFORM.equals(agentQueue.getQueueCriteriaType())) {
            buildRules.add(agentQueue);
          }
        }
      }
    }

    return buildRules;
  } // end method getAllDraftRules

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the map for the Deploy program Rule using ruleId as key.
   *
   * @return  get the map for the Deploy program Rule using ruleId as key.
   */
  public Map<Long, AgencyQueue> getDeployedAgencyQueueMap() {
    Map<Long, AgencyQueue> map = new HashMap<Long, AgencyQueue>();

    for (AgencyQueue agencyQueue : deployedAgencyQueues) {
      map.put(agencyQueue.getAgencyQueueId(), agencyQueue);
    }

    return map;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for deployed agency queues.
   *
   * @return  Set
   */
  public Set<AgencyQueue> getDeployedAgencyQueues() {
    return deployedAgencyQueues;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.schedule.BaseSchedule#getDeployedRules()
   */
  @Override public Set<BaseRule> getDeployedRules() {
    Set<BaseRule> rules = new LinkedHashSet<BaseRule>();
    rules.addAll(deployedAgencyQueues);

    return rules;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the map for the draft program rule using ruleId as key.
   *
   * @return  get the map for the draft program rule using ruleId as key.
   */
  public Map<Long, AgencyQueue> getDraftAgencyQueueMap() {
    Map<Long, AgencyQueue> map = new HashMap<Long, AgencyQueue>();

    for (AgencyQueue agencyQueue : draftAgencyQueues) {
      map.put(agencyQueue.getAgencyQueueId(), agencyQueue);
    }

    return map;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for draft agency queues.
   *
   * @return  Set
   */
  public Set<AgencyQueue> getDraftAgencyQueues() {
    return draftAgencyQueues;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.schedule.BaseSchedule#getDraftRules()
   */
  @Override public Set<BaseRule> getDraftRules() {
    Set<BaseRule> rules = new LinkedHashSet<BaseRule>();
    rules.addAll(draftAgencyQueues);

    return rules;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.schedule.BaseSchedule#getScheduleType()
   */
  @Override public String getScheduleType() {
    return "QueueSchedule";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Looking for free form rule which would be in rule repository.
   *
   * @return  looking for free form rule which would be in rule repository.
   */
  @Override public boolean hasRuleInRepo() {
    // loop through all queues to find any free form criteria
    for (AgencyQueue agencyQueue : deployedAgencyQueues) {
      if (QueueCriteriaType.FREEFORM == agencyQueue.getQueueCriteriaType()) {
        return true;
      } else {
        for (AgencyTeamQueue teamQueue : agencyQueue.getAgencyTeamQueues()) {
          if (QueueCriteriaType.FREEFORM == teamQueue.getQueueCriteriaType()) {
            return true;
          } else {
            for (AgentQueue agentQueue : teamQueue.getAgentQueues()) {
              if (QueueCriteriaType.FREEFORM == agentQueue.getQueueCriteriaType()) {
                return true;
              }
            }
          }
        }
      }
    }

    return false;
  } // end method hasRuleInRepo

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.schedule.BaseSchedule#isDeployed()
   */
  @Override public boolean isDeployed() {
    for (@SuppressWarnings("unused")
      AgencyQueue rule : deployedAgencyQueues) {
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
    draftAgencyQueues.clear();

    for (AgencyQueue agencyQueue : deployedAgencyQueues) {
      AgencyQueue newAgencyQueue = new AgencyQueue();
      newAgencyQueue.deepCopy(agencyQueue);
      newAgencyQueue.setQueueSchedule(this);

      // add to draft set
      draftAgencyQueues.add(newAgencyQueue);
    }

    // update queue status
    updateAllQueuesStatus(draftAgencyQueues, false, true, true);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * removeDraftRule.
   *
   * @param   userId         Long
   * @param   agencyQueueId  Long
   *
   * @return  boolean
   */
  public boolean removeDraftRule(Long userId, Long agencyQueueId) {
    if (agencyQueueId != null) {
      // do update if it exists
      AgencyQueue agencyQueue = getDraftAgencyQueueMap().get(agencyQueueId);

      draftAgencyQueues.remove(agencyQueue);

      agencyQueue.setAgency(null);
      agencyQueue.setAssignDate(null);
      agencyQueue.setQueueSchedule(null);

      return true;
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for deployed agency queues.
   *
   * @param  deployedAgencyQueues  Set
   */
  public void setDeployedAgencyQueues(Set<AgencyQueue> deployedAgencyQueues) {
    this.deployedAgencyQueues = deployedAgencyQueues;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for draft agency queues.
   *
   * @param  agencyQueues  Set
   */
  public void setDraftAgencyQueues(Set<AgencyQueue> agencyQueues) {
    this.draftAgencyQueues = agencyQueues;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Update draft rule set, return remove set.
   *
   * @param   userId  DOCUMENT ME!
   * @param   rules   DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean updateDraftRules(Long userId, List<AgencyQueue> rules) {
    Set<AgencyQueue>       agencyQueues = new LinkedHashSet<AgencyQueue>();
    Map<Long, AgencyQueue> myRules      = getDraftAgencyQueueMap();

    for (AgencyQueue newAgencyQueue : rules) {
      Long ruleId = newAgencyQueue.getAgencyQueueId();

      newAgencyQueue.setCreateAgentId(userId);
      newAgencyQueue.setCreateDate(new Date());

      if (ruleId != null) {
        // do update if it exists
        AgencyQueue myAgencyQueue = myRules.get(ruleId);
        myAgencyQueue.updateQueue(newAgencyQueue);
        newAgencyQueue = myAgencyQueue;
      } else {
        newAgencyQueue.setDeployed(false);
        newAgencyQueue.setComplied(false);
        newAgencyQueue.setValid(false);
      }

      // add rule to set with the order
      newAgencyQueue.setQueueSchedule(this);
      agencyQueues.add(newAgencyQueue);
    }

    this.draftAgencyQueues.clear();
    this.draftAgencyQueues.addAll(agencyQueues);

    return true;
  } // end method updateDraftRules

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * update all queues and sub queues status.
   *
   * @param  agencyQueues  DOCUMENT ME!
   * @param  deployed      DOCUMENT ME!
   * @param  valid         DOCUMENT ME!
   * @param  compiled      DOCUMENT ME!
   */
  protected void updateAllQueuesStatus(Set<AgencyQueue> agencyQueues, boolean deployed, boolean valid,
    boolean compiled) {
    for (AgencyQueue agencyQueue : agencyQueues) {
      // loop though all queues and sub queue to update deploy status
      // deploy current draft rule
      agencyQueue.setDeployed(deployed);
      agencyQueue.setValid(valid);
      agencyQueue.setComplied(compiled);

      // loop through the child queue
      for (AgencyTeamQueue teamQueue : agencyQueue.getAgencyTeamQueues()) {
        teamQueue.setDeployed(deployed);
        teamQueue.setValid(valid);
        teamQueue.setComplied(compiled);

        for (AgentQueue agentQueue : teamQueue.getAgentQueues()) {
          agentQueue.setDeployed(deployed);
          agentQueue.setValid(valid);
          agentQueue.setComplied(compiled);
        }
      }
    }
  }
} // end class QueueSchedule
