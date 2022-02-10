package com.cmc.credagility.core.domain.queue;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.portfolio.Portfolio;


/**
 * This class is used to store Queue work status information.
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/15/2014 12:21
 */
@Entity
@Table(name = "QueueWorkStatus")
public class QueueWorkStatus extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 6469829389950536178L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  // npelleti, 07/30, USBank, Removed unique constraint
  /** Queue work status Id, PK. */
  @Column(
    name     = "id", /*unique = true,*/
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "portfolioId",
    nullable  = false,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Portfolio portfolio;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "workingAccountNum")
  @ManyToOne(fetch = FetchType.LAZY)
  protected Account workingAccount;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "workingAgentQueueId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected AgentQueue workingAgentQueue;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    QueueWorkStatus other = (QueueWorkStatus) obj;

    if (portfolio == null) {
      if (other.portfolio != null) {
        return false;
      }
    } else if (!portfolio.equals(other.portfolio)) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for id.
   *
   * @return  Long
   */
  public Long getId() {
    return this.id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio.
   *
   * @return  Portfolio
   */
  public Portfolio getPortfolio() {
    return portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for working account.
   *
   * @return  Account
   */
  public Account getWorkingAccount() {
    return workingAccount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for working agent queue.
   *
   * @return  AgentQueue
   */
  public AgentQueue getWorkingAgentQueue() {
    return this.workingAgentQueue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = 1;
    result = (prime * result) + ((portfolio == null) ? 0 : portfolio.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for id.
   *
   * @param  id  Long
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio.
   *
   * @param  portfolio  Portfolio
   */
  public void setPortfolio(Portfolio portfolio) {
    this.portfolio = portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for working account.
   *
   * @param  workingAccount  Account
   */
  public void setWorkingAccount(Account workingAccount) {
    this.workingAccount = workingAccount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for working agent queue.
   *
   * @param  workingAgentQueue  AgentQueue
   */
  public void setWorkingAgentQueue(AgentQueue workingAgentQueue) {
    this.workingAgentQueue = workingAgentQueue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#toString()
   */
  @Override public String toString() {
    final String TAB = "    ";

    StringBuilder retValue = new StringBuilder();

    retValue.append("QueueWorkStatus ( ").append(super.toString()).append(TAB).append("id = ").append(this.id).append(
      TAB).append("portfolio = ").append(this.portfolio).append(TAB).append("workingAgentQueue = ").append(
      this.workingAgentQueue).append(TAB).append(TAB).append(" )");

    return retValue.toString();
  }
} // end class QueueWorkStatus
