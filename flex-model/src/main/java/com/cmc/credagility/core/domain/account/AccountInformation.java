package com.cmc.credagility.core.domain.account;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.user.User;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:dongming.liao@ozstrategy.com">Dongming Liao</a>
 * @version  10/15/2014 11:13
 */
@Entity public class AccountInformation extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -2387352226608500812L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long         accountInformationId;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "channelOrigination",
    length = 20
  )
  protected String channelOrigination;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "creditLimit",
    nullable  = true,
    precision = 19,
    scale     = 2
  )
  protected BigDecimal creditLimit;


  /** TODO: DOCUMENT ME! */
  @Column(name = "daysInBillingCycle")
  protected Integer daysInBillingCycle = 0;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "lastStatementBalance",
    nullable  = true,
    precision = 19,
    scale     = 2
  )
  protected BigDecimal lastStatementBalance;


  /** TODO: DOCUMENT ME! */
  @Column(name = "lastStatementDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date lastStatementDate;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "lastStatementMinimumPayDue",
    nullable  = true,
    precision = 19,
    scale     = 2
  )
  protected BigDecimal lastStatementMinimumPayDue;


  /** TODO: DOCUMENT ME! */
  @Column(name = "lastStatementPaymentDueDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date lastStatementPaymentDueDate;


  /** TODO: DOCUMENT ME! */
  @Column(name = "nextStatementDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date nextStatementDate;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "spocAgentId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected User spocAgent = null;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "totalAvailableCredit",
    nullable  = true,
    precision = 19,
    scale     = 2
  )
  protected BigDecimal totalAvailableCredit;

  /** Account link accountNum. */
  @JoinColumn(
    name     = "accountNum",
    unique   = true,
    nullable = false
  )
  @ManyToOne private Account account;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    AccountInformation that = (AccountInformation) o;

    if ((account != null) ? (!account.equals(that.account)) : (that.account != null)) {
      return false;
    }

    if ((lastStatementBalance != null) ? (!lastStatementBalance.equals(that.lastStatementBalance))
                                       : (that.lastStatementBalance != null)) {
      return false;
    }

    if ((lastStatementDate != null) ? (!lastStatementDate.equals(that.lastStatementDate))
                                    : (that.lastStatementDate != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account.
   *
   * @return  Account
   */
  public Account getAccount() {
    return account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account information id.
   *
   * @return  Long
   */
  public Long getAccountInformationId() {
    return accountInformationId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for channel origination.
   *
   * @return  String
   */
  public String getChannelOrigination() {
    return channelOrigination;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for credit limit.
   *
   * @return  BigDecimal
   */
  public BigDecimal getCreditLimit() {
    return creditLimit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for days in billing cycle.
   *
   * @return  Integer
   */
  public Integer getDaysInBillingCycle() {
    return daysInBillingCycle;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last statement balance.
   *
   * @return  BigDecimal
   */
  public BigDecimal getLastStatementBalance() {
    return lastStatementBalance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last statement date.
   *
   * @return  Date
   */
  public Date getLastStatementDate() {
    return lastStatementDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last statement minimum pay due.
   *
   * @return  BigDecimal
   */
  public BigDecimal getLastStatementMinimumPayDue() {
    return lastStatementMinimumPayDue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last statement payment due date.
   *
   * @return  Date
   */
  public Date getLastStatementPaymentDueDate() {
    return lastStatementPaymentDueDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for next statement date.
   *
   * @return  Date
   */
  public Date getNextStatementDate() {
    return nextStatementDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for spoc agent.
   *
   * @return  User
   */
  public User getSpocAgent() {
    return spocAgent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for total available credit.
   *
   * @return  BigDecimal
   */
  public BigDecimal getTotalAvailableCredit() {
    return totalAvailableCredit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((account != null) ? account.hashCode() : 0);
    result = (31 * result) + ((lastStatementBalance != null) ? lastStatementBalance.hashCode() : 0);
    result = (31 * result) + ((lastStatementDate != null) ? lastStatementDate.hashCode() : 0);
    result = (31 * result) + ((lastStatementPaymentDueDate != null) ? lastStatementPaymentDueDate.hashCode() : 0);
    result = (31 * result) + ((lastStatementMinimumPayDue != null) ? lastStatementMinimumPayDue.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account.
   *
   * @param  account  Account
   */
  public void setAccount(Account account) {
    this.account = account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account information id.
   *
   * @param  accountInformationId  Long
   */
  public void setAccountInformationId(Long accountInformationId) {
    this.accountInformationId = accountInformationId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for channel origination.
   *
   * @param  channelOrigination  String
   */
  public void setChannelOrigination(String channelOrigination) {
    this.channelOrigination = channelOrigination;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for credit limit.
   *
   * @param  creditLimit  BigDecimal
   */
  public void setCreditLimit(BigDecimal creditLimit) {
    this.creditLimit = creditLimit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for days in billing cycle.
   *
   * @param  daysInBillingCycle  Integer
   */
  public void setDaysInBillingCycle(Integer daysInBillingCycle) {
    this.daysInBillingCycle = daysInBillingCycle;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last statement balance.
   *
   * @param  lastStatementBalance  BigDecimal
   */
  public void setLastStatementBalance(BigDecimal lastStatementBalance) {
    this.lastStatementBalance = lastStatementBalance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last statement date.
   *
   * @param  lastStatementDate  Date
   */
  public void setLastStatementDate(Date lastStatementDate) {
    this.lastStatementDate = lastStatementDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last statement minimum pay due.
   *
   * @param  lastStatementMinimumPayDue  BigDecimal
   */
  public void setLastStatementMinimumPayDue(BigDecimal lastStatementMinimumPayDue) {
    this.lastStatementMinimumPayDue = lastStatementMinimumPayDue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last statement payment due date.
   *
   * @param  lastStatementPaymentDueDate  Date
   */
  public void setLastStatementPaymentDueDate(Date lastStatementPaymentDueDate) {
    this.lastStatementPaymentDueDate = lastStatementPaymentDueDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for next statement date.
   *
   * @param  nextStatementDate  Date
   */
  public void setNextStatementDate(Date nextStatementDate) {
    this.nextStatementDate = nextStatementDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for spoc agent.
   *
   * @param  spocAgent  User
   */
  public void setSpocAgent(User spocAgent) {
    this.spocAgent = spocAgent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for total available credit.
   *
   * @param  totalAvailableCredit  BigDecimal
   */
  public void setTotalAvailableCredit(BigDecimal totalAvailableCredit) {
    this.totalAvailableCredit = totalAvailableCredit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("AccountInformation");
    sb.append("{id=").append(accountInformationId);
    sb.append(", account=").append(account);
    sb.append(", lastStatementBalance='").append(lastStatementBalance).append('\'');
    sb.append(", lastStatementDate='").append(lastStatementDate).append('\'');
    sb.append(", lastStatementMinimumPayDue='").append(lastStatementMinimumPayDue).append('\'');
    sb.append(", lastStatementPaymentDueDate='").append(lastStatementPaymentDueDate).append('\'');
    sb.append('}');

    return sb.toString();
  }
} // end class AccountInformation
