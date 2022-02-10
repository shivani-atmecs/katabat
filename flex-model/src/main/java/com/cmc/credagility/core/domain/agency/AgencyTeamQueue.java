package com.cmc.credagility.core.domain.agency;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.queue.AgentQueue;
import com.cmc.credagility.core.domain.queue.QueueSchedule;
import com.cmc.credagility.core.domain.schedule.BaseQueue;
import com.cmc.credagility.core.domain.type.QueueStatus;
import com.cmc.credagility.core.domain.type.ScheduleStatus;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/17/2014 10:25
 */
@Entity
@Table(name = "AgencyTeamQueue")
public class AgencyTeamQueue extends BaseQueue {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 9081707182279296314L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "agencyTeamQueue"
  )
  protected Set<Account> accounts = new LinkedHashSet<Account>();


  // npelleti, 07/29, USB, Added Annotation for column NotNull
  /** parent agencyQueue. */
  @JoinColumn(
    name       = "agencyQueueId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected AgencyQueue agencyQueue;

  /** owner: a team inside an agency */
  @JoinColumn(
    name       = "teamId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected AgencyTeam agencyTeam;

  /** child agencyQueues. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "agencyTeamQueue",
    cascade  = CascadeType.ALL
  )
  @OrderBy("queueCriteriaType asc, priority asc")
  protected Set<AgentQueue> agentQueues = new LinkedHashSet<AgentQueue>();

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "agencyTeamQueue"
  )
  @OrderBy("priorityScore desc, accountNum asc")
  @Where(clause = "agentId is null or lockExpirationTime < current_timestamp()")
  protected Set<Account> availableAccounts = new LinkedHashSet<Account>();

  // npelleti, 07/30, USBank, Removed unique constraint
  /** Agency team Queue Id, PK. */
  @Column(
    name     = "teamQueueId", /*unique = true,*/
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long teamQueueId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addAgentQueue.
   *
   * @param   agentQueue  AgentQueue
   *
   * @return  boolean
   */
  public boolean addAgentQueue(AgentQueue agentQueue) {
    agentQueue.setAgencyTeamQueue(this);

    return agentQueues.add(agentQueue);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addOrUpdateAgentQueue.
   *
   * @param   userId      Long
   * @param   agentQueue  AgentQueue
   *
   * @return  AgentQueue
   */
  public AgentQueue addOrUpdateAgentQueue(Long userId, AgentQueue agentQueue) {
    Long queueId = agentQueue.getAgentQueueId();

    if (queueId != null) {
      // do update if it exists
      AgentQueue myAgentQueue = getAgentQueueMap().get(queueId);
      myAgentQueue.updateQueue(agentQueue);

      myAgentQueue.setLastUpdateAgentId(userId);
      myAgentQueue.setLastUpdateDate(new Date());

      myAgentQueue.setDeployed(false);
      myAgentQueue.setComplied(false);
      myAgentQueue.setValid(false);

      return myAgentQueue;
    } else {
      agentQueue.setQueueStatus(QueueStatus.NEW);
      agentQueue.setCreateAgentId(userId);
      agentQueue.setCreateDate(new Date());

      agentQueue.setDeployed(false);
      agentQueue.setComplied(false);
      agentQueue.setValid(false);

      Long portfolioId = this.getPortfolioId();

      if (portfolioId != null) {
        agentQueue.setPortfolioId(portfolioId.longValue());
      }

      // add rule to set with the order
      agentQueue.setAgencyTeamQueue(this);
      this.agentQueues.add(agentQueue);

      return agentQueue;
    } // end if-else
  }   // end method addOrUpdateAgentQueue

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get all accounts related to this agencyQueue.
   *
   * @return  get all accounts related to this agencyQueue.
   */
  @Override public Set<Account> getAccounts() {
    return accounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agency queue.
   *
   * @return  AgencyQueue
   */
  public AgencyQueue getAgencyQueue() {
    return agencyQueue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Assigned agency team. This could be null if no agency team assigned yet. For example, if a AgencyQueue is broken
   * into a couple of AgencyTeamQueues, it is not necessary that all of them have been assigned.
   *
   * @return  assigned agency team.
   */
  public AgencyTeam getAgencyTeam() {
    return agencyTeam;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agent queue map.
   *
   * @return  Map
   */
  public Map<Long, AgentQueue> getAgentQueueMap() {
    Map<Long, AgentQueue> queueMap = new HashMap<Long, AgentQueue>();

    for (AgentQueue agentQueue : agentQueues) {
      queueMap.put(agentQueue.getAgentQueueId(), agentQueue);
    }

    return queueMap;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agent queues.
   *
   * @return  Set
   */
  public Set<AgentQueue> getAgentQueues() {
    return agentQueues;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.schedule.BaseQueue#getAvailableAccounts()
   */
  @Override public Set<Account> getAvailableAccounts() {
    return availableAccounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.schedule.BaseQueue#getQueueId()
   */
  @Override public Long getQueueId() {
    return teamQueueId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.schedule.BaseQueue#getQueueType()
   */
  @Override public String getQueueType() {
    return getRuleType();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.schedule.BaseRule#getRuleType()
   */
  @Override public String getRuleType() {
    return "TeamQueue";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for team queue id.
   *
   * @return  Long
   */
  public Long getTeamQueueId() {
    return teamQueueId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Falg for the team queue is contained by active schedule.
   *
   * @return  falg for the team queue is contained by active schedule.
   */
  public boolean hasActiveSchedule() {
    QueueSchedule  queueSchedule = agencyQueue.getQueueSchedule();
    ScheduleStatus status        = queueSchedule.getScheduleStatus();

    if ((status != null)
          && (ScheduleStatus.ACTIVE.equals(status) || ScheduleStatus.SCHEDULED.equals(status))) {
      return true;
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * removeAgentQueue.
   *
   * @param   userId        Long
   * @param   agentQueueId  Long
   *
   * @return  boolean
   */
  public boolean removeAgentQueue(Long userId, Long agentQueueId) {
    if (agentQueueId != null) {
      // do update if it exists
      AgentQueue agentQueue = getAgentQueueMap().get(agentQueueId);

      agentQueues.remove(agentQueue);
      this.setLastUpdateAgentId(userId);
      this.setLastUpdateDate(new Date());

      agentQueue.setAgency(null);
      agentQueue.setAssignDate(null);
      agentQueue.setAgencyTeamQueue(null);

      return true;
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for accounts.
   *
   * @param  accounts  Set
   */
  public void setAccounts(Set<Account> accounts) {
    this.accounts = accounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agency queue.
   *
   * @param  agencyQueue  AgencyQueue
   */
  public void setAgencyQueue(AgencyQueue agencyQueue) {
    this.agencyQueue = agencyQueue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agency team.
   *
   * @param  agencyTeam  AgencyTeam
   */
  public void setAgencyTeam(AgencyTeam agencyTeam) {
    this.agencyTeam = agencyTeam;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agent queues.
   *
   * @param  agentQueues  Set
   */
  public void setAgentQueues(Set<AgentQueue> agentQueues) {
    this.agentQueues = agentQueues;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for available accounts.
   *
   * @param  availableAccounts  Set
   */
  public void setAvailableAccounts(Set<Account> availableAccounts) {
    this.availableAccounts = availableAccounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for queue.
   *
   * @param  agencyQueue  AgencyQueue
   */
  public void setQueue(AgencyQueue agencyQueue) {
    this.agencyQueue = agencyQueue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for team queue id.
   *
   * @param  teamQueueId  Long
   */
  public void setTeamQueueId(Long teamQueueId) {
    this.teamQueueId = teamQueueId;
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

    retValue.append("AgencyTeamQueue ( ").append(super.toString()).append(TAB).append("teamQueueId = ").append(
      this.teamQueueId).append(TAB).append(
      " )");

    return retValue.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updateAgentQueues.
   *
   * @param   userId  Long
   * @param   queues  List
   *
   * @return  boolean
   */
  public boolean updateAgentQueues(Long userId, List<AgentQueue> queues) {
    Set<AgentQueue>       agentQueues = new LinkedHashSet<AgentQueue>();
    Map<Long, AgentQueue> myQueues    = getAgentQueueMap();

    for (AgentQueue agentQueue : queues) {
      Long queueId = agentQueue.getAgentQueueId();

      agentQueue.setCreateAgentId(userId);
      agentQueue.setCreateDate(new Date());
      agentQueue.setDeployed(false);

      if (queueId != null) {
        // do update if it exists
        AgentQueue myAgentQueue = myQueues.get(queueId);
        myAgentQueue.updateQueue(agentQueue);
        agentQueue = myAgentQueue;
      }

      Long portfolioId = this.getPortfolioId();

      if (portfolioId != null) {
        agentQueue.setPortfolioId(portfolioId.longValue());
      }

      // add rule to set with the order
      agentQueue.setAgencyTeamQueue(this);
      agentQueues.add(agentQueue);
    } // end for

    this.agentQueues.clear();
    this.agentQueues.addAll(agentQueues);

    return true;
  } // end method updateAgentQueues

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Update queue form other rule return false if there is no difference return true if there are some difference and
   * update success.
   *
   * @param   agencyTeamQueue  DOCUMENT ME!
   *
   * @return  update queue form other rule return false if there is no difference return true if there are some
   *          difference and update success.
   */
  public boolean updateQueue(AgencyTeamQueue agencyTeamQueue) {
    this.copy(agencyTeamQueue);

    return true;
  }
} // end class AgencyTeamQueue
