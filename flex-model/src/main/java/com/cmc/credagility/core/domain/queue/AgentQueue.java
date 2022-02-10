package com.cmc.credagility.core.domain.queue;

import java.util.LinkedHashSet;
import java.util.Set;

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
import com.cmc.credagility.core.domain.agency.AgencyTeamQueue;
import com.cmc.credagility.core.domain.schedule.BaseQueue;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/15/2014 11:09
 */
@Entity
@Table(name = "AgentQueue")
public class AgentQueue extends BaseQueue {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 6410982811724672496L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "agentQueue"
  )
  @OrderBy("balance desc, priorityScore desc, accountNum asc")
  protected Set<Account> accounts = new LinkedHashSet<Account>();

// npelleti, 07/29, USB, Added Annotation for column NotNull
  /** parent agencyQueue. */
  @JoinColumn(
    name      = "teamQueueId",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected AgencyTeamQueue agencyTeamQueue;

  /** Agent Queue Id, PK. */
  // npelleti, 07/29, USB, Dropped Key AgentQueueId.
  @Column(
    name     = "agentQueueId", /*unique = true,*/
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long agentQueueId;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "agentQueue"
  )
  @OrderBy("priorityScore desc, accountNum asc")
  @Where(clause = "agentId is null or lockExpirationTime < current_timestamp()")
  protected Set<Account> availableAccounts = new LinkedHashSet<Account>();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * Create default agent queue.
   *
   * @param  agencyTeamQueue    DOCUMENT ME!
   * @param  defaultAgentQueue  DOCUMENT ME!
   */
  public void createDefaultQueue(AgencyTeamQueue agencyTeamQueue,
    String defaultAgentQueue) {
    this.agencyTeamQueue = agencyTeamQueue;
    super.createDefaultQueue(agencyTeamQueue.getPortfolioId(),
      defaultAgentQueue, "");

    agencyTeamQueue.addAgentQueue(this);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get all accounts related to this agentQueue.
   *
   * @return  the accounts
   */
  @Override public Set<Account> getAccounts() {
    return accounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agency team queue.
   *
   * @return  AgencyTeamQueue
   */
  public AgencyTeamQueue getAgencyTeamQueue() {
    return agencyTeamQueue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agent queue id.
   *
   * @return  Long
   */
  public Long getAgentQueueId() {
    return agentQueueId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The available accounts for the queue.
   *
   * @return  the available accounts for the queue
   */
  @Override public Set<Account> getAvailableAccounts() {
    return availableAccounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.schedule.BaseQueue#getQueueId()
   */
  @Override public Long getQueueId() {
    return agentQueueId;
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
    // TODO Auto-generated method stub
    return "AgentQueue";
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
   * setter method for agency team queue.
   *
   * @param  agencyTeamQueue  AgencyTeamQueue
   */
  public void setAgencyTeamQueue(AgencyTeamQueue agencyTeamQueue) {
    this.agencyTeamQueue = agencyTeamQueue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agent queue id.
   *
   * @param  agentQueueId  Long
   */
  public void setAgentQueueId(Long agentQueueId) {
    this.agentQueueId = agentQueueId;
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
   * @see  com.cmc.credagility.core.domain.schedule.BaseQueue#toString()
   */
  @Override public String toString() {
    final String TAB = "    ";

    StringBuilder retValue = new StringBuilder();

    retValue.append("AgentQueue ( ").append(super.toString()).append(TAB).append("accounts = ").append(this.accounts)
      .append(TAB).append("agencyTeamQueue = ").append(this.agencyTeamQueue).append(TAB).append("agentQueueId = ")
      .append(this.agentQueueId).append(TAB).append(" )");

    return retValue.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Update queue form other rule return false if there is no difference return true if there are some difference and
   * update success.
   *
   * @param   agentQueue  DOCUMENT ME!
   *
   * @return  update queue form other rule return false if there is no difference return true if there are some
   *          difference and update success.
   */
  public boolean updateQueue(AgentQueue agentQueue) {
    this.copy(agentQueue);

    return true;
  }
} // end class AgentQueue
