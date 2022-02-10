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


/**
 * This class is used to present the agencyQueue information.
 *
 * <p><a href="AgencyQueue.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/17/2014 10:13
 */
@Entity
@Table(name = "AgencyQueue")
public class AgencyQueue extends BaseQueue {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -4915700651906812099L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "agencyQueue"
  )
  protected Set<Account> accounts = new LinkedHashSet<Account>();

  // npelleti, 07/30, USBank, Removed unique constraint
  /** Agency Queue Id, PK. */
  @Column(
    name     = "agencyQueueId", /*unique = true,*/
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long agencyQueueId;

  /** child agencyQueues: one agencyQueue could be broken into multiple agency team agencyQueues */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "agencyQueue",
    cascade  = CascadeType.ALL
  )
  @OrderBy("queueCriteriaType asc, priority asc")
  protected Set<AgencyTeamQueue> agencyTeamQueues = new LinkedHashSet<AgencyTeamQueue>();

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "agencyQueue",
    cascade  = CascadeType.ALL
  )
  @OrderBy("priorityScore desc, accountNum asc")
  @Where(clause = "agentId is null or lockExpirationTime < current_timestamp()")
  protected Set<Account> availableAccounts = new LinkedHashSet<Account>();

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "scheduleId",
    insertable = true,
    updatable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected QueueSchedule queueSchedule;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addAgencyTeamQueue.
   *
   * @param   agencyTeamQueue  AgencyTeamQueue
   *
   * @return  boolean
   */
  public boolean addAgencyTeamQueue(AgencyTeamQueue agencyTeamQueue) {
    agencyTeamQueue.setAgencyQueue(this);

    return this.agencyTeamQueues.add(agencyTeamQueue);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addOrUpdateTeamQueue.
   *
   * @param   userId     Long
   * @param   teamQueue  AgencyTeamQueue
   *
   * @return  AgencyTeamQueue
   */
  public AgencyTeamQueue addOrUpdateTeamQueue(Long userId, AgencyTeamQueue teamQueue) {
    Long queueId = teamQueue.getTeamQueueId();

    if (queueId != null) {
      // do update if it exists
      AgencyTeamQueue myTeamQueue = getAgencyTeamQueueMap().get(queueId);
      myTeamQueue.updateQueue(teamQueue);

      myTeamQueue.setLastUpdateAgentId(userId);
      myTeamQueue.setLastUpdateDate(new Date());

      myTeamQueue.setDeployed(false);
      myTeamQueue.setComplied(false);
      myTeamQueue.setValid(false);

      return myTeamQueue;
    } else {
      teamQueue.setQueueStatus(QueueStatus.NEW);

      teamQueue.setCreateAgentId(userId);
      teamQueue.setCreateDate(new Date());

      teamQueue.setDeployed(false);
      teamQueue.setComplied(false);
      teamQueue.setValid(false);

      Long portfolioId = this.getPortfolioId();

      if (portfolioId != null) {
        teamQueue.setPortfolioId(portfolioId.longValue());
      }

      // add rule to set with the order
      teamQueue.setAgencyQueue(this);

      // create a default agent queue
      AgentQueue agentQueue = new AgentQueue();
      agentQueue.createDefaultQueue(teamQueue, this.getRuleName());

      this.agencyTeamQueues.add(teamQueue);

      return teamQueue;
    } // end if-else
  }   // end method addOrUpdateTeamQueue

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * createDefaultQueue.
   *
   * @param  queueSchedule       QueueSchedule
   * @param  defaultAgencyQueue  String
   * @param  defaultTeamQueue    String
   * @param  defaultAgentQueue   String
   */
  public void createDefaultQueue(QueueSchedule queueSchedule, String defaultAgencyQueue, String defaultTeamQueue,
    String defaultAgentQueue) {
    this.queueSchedule = queueSchedule;
    super.createDefaultQueue(queueSchedule.getPortfolio().getPortfolioId(),
      defaultAgencyQueue, "");

    // create a default team queue
    AgencyTeamQueue agencyTeamQueue = new AgencyTeamQueue();
/*    agencyTeamQueue.createDefaultQueue(this, defaultTeamQueue,
      defaultAgentQueue);*/

    queueSchedule.addDraftQueue(this);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.schedule.BaseQueue#getAccounts()
   */
  @Override public Set<Account> getAccounts() {
    return accounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agency queue id.
   *
   * @return  Long
   */
  public Long getAgencyQueueId() {
    return agencyQueueId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agency team queue map.
   *
   * @return  Map
   */
  public Map<Long, AgencyTeamQueue> getAgencyTeamQueueMap() {
    Map<Long, AgencyTeamQueue> queueMap = new HashMap<Long, AgencyTeamQueue>();

    for (AgencyTeamQueue agencyTeamQueue : agencyTeamQueues) {
      queueMap.put(agencyTeamQueue.getTeamQueueId(), agencyTeamQueue);
    }

    return queueMap;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agency team queues.
   *
   * @return  Set
   */
  public Set<AgencyTeamQueue> getAgencyTeamQueues() {
    return agencyTeamQueues;
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
    return agencyQueueId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for queue schedule.
   *
   * @return  QueueSchedule
   */
  public QueueSchedule getQueueSchedule() {
    return queueSchedule;
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
    return "AgencyQueue";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * removeTeamQueue.
   *
   * @param   userId       Long
   * @param   teamQueueId  Long
   *
   * @return  boolean
   */
  public boolean removeTeamQueue(Long userId, Long teamQueueId) {
    if (teamQueueId != null) {
      // do update if it exists
      AgencyTeamQueue teamQueue = getAgencyTeamQueueMap().get(teamQueueId);

      agencyTeamQueues.remove(teamQueue);
      this.setLastUpdateAgentId(userId);
      this.setLastUpdateDate(new Date());

      teamQueue.setAgency(null);
      teamQueue.setAgencyTeam(null);
      teamQueue.setAssignDate(null);
      teamQueue.setAgencyQueue(null);

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
   * setter method for agency queue id.
   *
   * @param  agencyQueueId  Long
   */
  public void setAgencyQueueId(Long agencyQueueId) {
    this.agencyQueueId = agencyQueueId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agency team queues.
   *
   * @param  agencyTeamQueues  Set
   */
  public void setAgencyTeamQueues(Set<AgencyTeamQueue> agencyTeamQueues) {
    this.agencyTeamQueues = agencyTeamQueues;
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
   * setter method for queue schedule.
   *
   * @param  queueSchedule  QueueSchedule
   */
  public void setQueueSchedule(QueueSchedule queueSchedule) {
    this.queueSchedule = queueSchedule;
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

    retValue.append("AgencyQueue ( ").append(super.toString()).append(TAB).append("agencyQueueId = ").append(
      this.agencyQueueId).append(TAB).append(TAB).append(" )");

    return retValue.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Update queue from other rule return false if there is no difference return true if there are some difference and
   * update success.
   *
   * @param   agencyQueue  DOCUMENT ME!
   *
   * @return  update queue from other rule return false if there is no difference return true if there are some
   *          difference and update success.
   */
  public boolean updateQueue(AgencyQueue agencyQueue) {
    // there are difference, copy form it
    this.copy(agencyQueue);

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updateTeamQueues.
   *
   * @param   userId  Long
   * @param   queues  List
   *
   * @return  boolean
   */
  public boolean updateTeamQueues(Long userId, List<AgencyTeamQueue> queues) {
    Set<AgencyTeamQueue>       agencyTeamQueues = new LinkedHashSet<AgencyTeamQueue>();
    Map<Long, AgencyTeamQueue> myQueues         = getAgencyTeamQueueMap();

    for (AgencyTeamQueue agencyTeamQueue : queues) {
      Long queueId = agencyTeamQueue.getTeamQueueId();

      agencyTeamQueue.setCreateAgentId(userId);
      agencyTeamQueue.setCreateDate(new Date());
      agencyTeamQueue.setDeployed(false);

      if (queueId != null) {
        // do update if it exists
        AgencyTeamQueue myAgencyTeamQueue = myQueues.get(queueId);
        myAgencyTeamQueue.updateQueue(agencyTeamQueue);
        agencyTeamQueue = myAgencyTeamQueue;
      }

      Long portfolioId = this.getPortfolioId();

      if (portfolioId != null) {
        agencyTeamQueue.setPortfolioId(portfolioId.longValue());
      }

      // add rule to set with the order
      agencyTeamQueue.setAgencyQueue(this);
      agencyTeamQueues.add(agencyTeamQueue);
    } // end for

    this.agencyTeamQueues.clear();
    this.agencyTeamQueues.addAll(agencyTeamQueues);

    return true;
  } // end method updateTeamQueues
} // end class AgencyQueue
