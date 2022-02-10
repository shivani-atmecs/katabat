package com.cmc.credagility.core.domain.schedule;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.agency.Agency;
import com.cmc.credagility.core.domain.type.QueueCriteriaType;
import com.cmc.credagility.core.domain.type.QueueStatus;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/15/2014 13:19
 */
@MappedSuperclass public abstract class BaseQueue extends BaseRule implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 3546605027262396199L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** total account in the queue. */
  @Column(name = "accountCount")
  protected Long accountCount;

  /**
   * This is different than assignDate. This date is when all accounts belong to this agencyQueue are labeled. When the
   * account is labeled, it does not mean the agencyQueue is assigned. Although normally it is.
   */
  @Column(name = "accountLabeledDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date accountLabeledDate;

  /** agencyQueue owner - agency. */
  @JoinColumn(
    name       = "agencyId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Agency agency;

  /** allow next working dates. */
  @Transient protected int allowedBackDays = 30;

  /**
   * agencyQueue assign Date. This date is when agencyQueue is in assigned. For example,
   *
   * <p>1. if this is an agencyQueue, it means its agency property is not null any more.</p>
   *
   * <p>2. If it is an agencyTeamQueue, then its agencyTeam property is not null any more.</p>
   *
   * <p>3. If it is an agentQueue, then its agent property is not null any more.</p>
   */
  @Column(name = "assignDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date assignDate;

  /** cache next account. */
  @Transient protected Account nextAccount = null;

  /** percentage of accounts. */
  @Column(name = "percentage")
  protected BigDecimal percentage;


  // npelleti, 07/30, USBank, Added NotNull Annotation
  /** queue criteria type. */
  @Column(
    name     = "queueCriteriaType",
    nullable = false,
    length   = 12
  )
  @Enumerated(value = EnumType.STRING)
  protected QueueCriteriaType queueCriteriaType;


  // npelleti, 07/30, USBank, Added NotNull Annotation
  /** agencyQueue status New/Labeled/Assigned/Closed. */
  @Column(
    name     = "queueStatus",
    nullable = false,
    length   = 10
  )
  @Enumerated(value = EnumType.STRING)
  protected QueueStatus queueStatus;

  /** working roundCounter. */
  @Column(
    name     = "roundCounter",
    nullable = false
  )
  protected Integer roundCounter = 0;

  /** TODO: DOCUMENT ME! */
  @Column(name = "ruleBatchId")
  protected Long ruleBatchId;

  /** total workable account. */
  @Column(name = "totalWorkableAccount")
  protected Long totalWorkableAccount;

  /** TODO: DOCUMENT ME! */
  @Column(name = "workingAccountNum")
  protected Long workingAccountNum;
  // protected Account currentAccount;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for accounts.
   *
   * @return  Set
   */
  public abstract Set<Account> getAccounts();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for available accounts.
   *
   * @return  Set
   */
  public abstract Set<Account> getAvailableAccounts();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for queue id.
   *
   * @return  Long
   */
  public abstract Long getQueueId();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for queue type.
   *
   * @return  String
   */
  public abstract String getQueueType();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Copy properties from other rule.
   *
   * @param  other  DOCUMENT ME!
   */
  public void copy(BaseQueue other) {
    super.deepCopy(other);

    this.percentage        = other.getPercentage();
    this.queueCriteriaType = other.getQueueCriteriaType();
    this.queueStatus       = other.getQueueStatus();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Create default queue.
   *
   * @param  portfolioId  DOCUMENT ME!
   * @param  queueName    DOCUMENT ME!
   * @param  description  DOCUMENT ME!
   */
  public void createDefaultQueue(Long portfolioId, String queueName,
    String description) {
    if (portfolioId != null) {
      this.portfolioId = portfolioId.longValue();
    } else {
      this.portfolioId = null;
    }

    this.ruleName     = queueName;
    this.description  = description;
    this.ruleCriteria = null;

    // clear the content
    this.ruleContent = null;
    this.deployed    = false;
    this.valid       = null;
    this.complied    = false;
    this.priority    = 1;

    this.percentage        = new BigDecimal("100.00");
    this.queueCriteriaType = QueueCriteriaType.PERCENTAGE;
    this.queueStatus       = QueueStatus.NEW;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Copy queue properties with assignment.
   *
   * @param  other  DOCUMENT ME!
   */
  public void deepCopy(BaseQueue other) {
    deepCopyWithoutAssignment(other);

    // copy assignment
    this.agency = other.getAgency();

    if (other.getAssignDate() != null) {
      this.assignDate = new Date(other.getAssignDate().getTime());
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Deep copy queue without assignment information.
   *
   * @param  other  DOCUMENT ME!
   */
  public void deepCopyWithoutAssignment(BaseQueue other) {
    super.deepCopy(other);

    this.percentage        = other.getPercentage();
    this.queueCriteriaType = other.getQueueCriteriaType();
    this.queueStatus       = other.getQueueStatus();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.schedule.BaseRule#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (!super.equals(obj)) {
      return false;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    final BaseQueue other = (BaseQueue) obj;

    if (percentage == null) {
      if (other.getPercentage() != null) {
        return false;
      }
    } else if (!percentage.equals(other.getPercentage())) {
      return false;
    }

    if (queueCriteriaType == null) {
      if (other.getQueueCriteriaType() != null) {
        return false;
      }
    } else if (!queueCriteriaType.equals(other.getQueueCriteriaType())) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account count.
   *
   * @return  Long
   */
  public Long getAccountCount() {
    return accountCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account labeled date.
   *
   * @return  Date
   */
  public Date getAccountLabeledDate() {
    return accountLabeledDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agency.
   *
   * @return  Agency
   */
  public Agency getAgency() {
    return this.agency;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for assign date.
   *
   * @return  Date
   */
  public Date getAssignDate() {
    return assignDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.schedule.BaseRule#getDescription()
   */
  @Override public String getDescription() {
    return description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // public Account getCurrentAccount() {
  // return this.currentAccount;
  // }

  /**
   * getter method for next account.
   *
   * @return  Account
   */
  public Account getNextAccount() {
    return this.nextAccount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for percentage.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPercentage() {
    return percentage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for queue criteria type.
   *
   * @return  QueueCriteriaType
   */
  public QueueCriteriaType getQueueCriteriaType() {
    return queueCriteriaType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for queue status.
   *
   * @return  QueueStatus
   */
  public QueueStatus getQueueStatus() {
    return queueStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Queue Working times roundCounter.
   *
   * @return  queue Working times roundCounter
   */
  public Integer getRoundCounter() {
    return roundCounter;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for rule batch id.
   *
   * @return  Long
   */
  public Long getRuleBatchId() {
    return ruleBatchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.schedule.BaseRule#getRuleId()
   */
  @Override public Long getRuleId() {
    return this.getQueueId();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for total workable account.
   *
   * @return  Long
   */
  public Long getTotalWorkableAccount() {
    return totalWorkableAccount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for working account num.
   *
   * @return  Long
   */
  public Long getWorkingAccountNum() {
    return workingAccountNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.schedule.BaseRule#hashCode()
   */
  @Override public int hashCode() {
    final int PRIME  = 31;
    int       result = super.hashCode();
    result = (PRIME * result)
      + ((this.percentage == null) ? 0 : this.percentage.hashCode());
    result = (PRIME
        * result)
      + ((this.queueCriteriaType == null) ? 0 : this.queueCriteriaType.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * increase round counter by 1.
   */
  public void increaseRoundCounter() {
    if ((roundCounter == null) || (roundCounter <= 0)) {
      roundCounter = 0;
    }

    roundCounter++;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // /**
  // * Wheather an account is available
  // * @param account
  // * @return
  // */
  // private boolean isAvailable(Account account){
  // // only look for active accounts
  // // no agent lock this account or the account lock is expired
  // Date now = new Date();
  // Calendar cal = Calendar.getInstance();
  // cal.setTime(now);
  // cal.add(Calendar.DATE, -allowedBackDays);
  // Date earlyAllowedDate = cal.getTime();
  // Date nextWorkDate = account.getNextWorkDate();
  // if(account != null && account.getActive()
  // && ((nextWorkDate == null || (nextWorkDate.before(now)) &&
  // (nextWorkDate.after(earlyAllowedDate))))
  // && (account.getAgent() == null ||
  // account.getLockExpirationTime().before(now))){
  // return true;
  // }
  // else{
  // return false;
  // }
  // }

  // protected Account getNextWorkingAccount(Account workingAccount, Account
  // nextAccount){
  // if(nextAccount == null){
  // return null;
  // }
  //
  // if(workingAccount == null){
  // // no current working account
  // return nextAccount;
  // }
  // // if the two accounts are in different queue,
  // // just return the next account
  // if(nextAccount.getAgentQueue().isSameQueue(workingAccount.getAgentQueue())){
  // // if the two accounts are in the same queue,
  // // return the nextAccount only if the nextAccount is after the
  // workingAccount
  // if(nextAccount.getAccountNum() > workingAccount.getAccountNum()){
  // return nextAccount;
  // }
  // else{
  // // the account is run out for this workingAccount interation
  // return null;
  // }
  // }
  // else{
  // // not the same queue,
  // return nextAccount;
  // }
  // }

  // /**
  // * Get next available account in the queue
  // *
  // * @return
  // */
  // public Account getNextAccount(Account workingAccount) {
  // Set<Account> accounts = getAccounts();
  // Account defaultAccount = null;
  // Iterator<Account> iter = accounts.iterator();
  // while (iter.hasNext()) {
  // Account account = iter.next();
  // if (isAvailable(account)) {
  // // default account is the first availble account
  // if(defaultAccount == null){
  // defaultAccount = account;
  // }
  //
  // if (currentAccount == null) {
  // // workingAccount is not the same queue, just returnt the deault account
  // return getNextWorkingAccount(workingAccount, defaultAccount);
  // } else if (currentAccount.hasSameAccountNum(account)) {
  // // get next first available account
  // while (iter.hasNext()) {
  // Account nextAccount = iter.next();
  // if (isAvailable(nextAccount)) {
  // return getNextWorkingAccount(workingAccount, nextAccount);
  // }
  // }
  // }
  // }
  // }
  //
  // // loop to the end of the queue, return the default account
  // return getNextWorkingAccount(workingAccount, defaultAccount);
  // }

  // /**
  // * Whether there is any account left
  // *
  // * @return
  // */
  // public boolean hasNextAccount() {
  // Set<Account> accounts = getAccounts();
  //
  // if (accounts.size() <= 0) {
  // // no more account in the queue
  // return false;
  // } else if (currentAccount == null) {
  // // no account processed yet
  // return true;
  // }
  //
  // Iterator<Account> iter = accounts.iterator();
  // while (iter.hasNext()) {
  // Account nextAccount = iter.next();
  // if (currentAccount.hasSameAccountNum(nextAccount)) {
  // // found the same account, look for next available account
  // while (iter.hasNext()) {
  // nextAccount = iter.next();
  // if (isAvailable(nextAccount)) {
  // return true;
  // }
  // }
  // }
  // }
  //
  // return false;
  // }

  /**
   * Whether the two queue got same id.
   *
   * @param   other  DOCUMENT ME!
   *
   * @return  whether the two queue got same id
   */
  public boolean isSameQueue(BaseQueue other) {
    if (!this.getQueueType().equals(other.getQueueType())) {
      return false;
    }

    if ((this.getQueueId() == null) || (other.getQueueId() == null)) {
      return false;
    }

    return this.getQueueId().equals(other.getQueueId());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account count.
   *
   * @param  accountCount  Long
   */
  public void setAccountCount(Long accountCount) {
    this.accountCount = accountCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account labeled date.
   *
   * @param  accountLabeledDate  Date
   */
  public void setAccountLabeledDate(Date accountLabeledDate) {
    this.accountLabeledDate = accountLabeledDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agency.
   *
   * @param  agency  Agency
   */
  public void setAgency(Agency agency) {
    this.agency = agency;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for assign date.
   *
   * @param  assignDate  Date
   */
  public void setAssignDate(Date assignDate) {
    this.assignDate = assignDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.schedule.BaseRule#setDescription(java.lang.String)
   */
  @Override public void setDescription(String description) {
    this.description = description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // /**
  // * @param currentAccount
  // * the currentAccount to set
  // */
  // public void setCurrentAccount(Account currentAccount) {
  // this.currentAccount = currentAccount;
  // this.nextAccount = null;
  // }

  /**
   * setter method for next account.
   *
   * @param  nextAccount  Account
   */
  public void setNextAccount(Account nextAccount) {
    this.nextAccount = nextAccount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for percentage.
   *
   * @param  percentage  BigDecimal
   */
  public void setPercentage(BigDecimal percentage) {
    this.percentage = percentage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for queue criteria type.
   *
   * @param  queueCriteriaType  QueueCriteriaType
   */
  public void setQueueCriteriaType(QueueCriteriaType queueCriteriaType) {
    this.queueCriteriaType = queueCriteriaType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for queue status.
   *
   * @param  queueStatus  QueueStatus
   */
  public void setQueueStatus(QueueStatus queueStatus) {
    this.queueStatus = queueStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for round counter.
   *
   * @param  roundCounter  Integer
   */
  public void setRoundCounter(Integer roundCounter) {
    this.roundCounter = roundCounter;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for rule batch id.
   *
   * @param  ruleBatchId  Long
   */
  public void setRuleBatchId(Long ruleBatchId) {
    this.ruleBatchId = ruleBatchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for total workable account.
   *
   * @param  totalWorkableAccount  Long
   */
  public void setTotalWorkableAccount(Long totalWorkableAccount) {
    this.totalWorkableAccount = totalWorkableAccount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for working account num.
   *
   * @param  workingAccountNum  Long
   */
  public void setWorkingAccountNum(Long workingAccountNum) {
    this.workingAccountNum = workingAccountNum;
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

    retValue.append("AgencyQueue ( ").append(super.toString()).append(TAB).append("assignDate = ").append(
      this.assignDate).append(TAB).append(
      "description = ").append(this.description).append(TAB).append(
      "priorityScore = ").append(this.priority).append(TAB).append(
      "queueStatus = ").append(this.queueStatus).append(TAB).append(" )");

    return retValue.toString();
  }
} // end class BaseQueue
