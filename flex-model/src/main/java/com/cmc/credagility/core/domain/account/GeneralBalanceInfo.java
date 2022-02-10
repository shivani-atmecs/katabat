package com.cmc.credagility.core.domain.account;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.user.User;
import com.cmc.credagility.core.domain.webactivity.Session;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:dongming.liao@ozstrategy.com">Dongming Liao</a>
 * @version  10/16/2014 14:12
 */
@Entity
@Table(
  name    = "GeneralBalanceInfo",
  indexes = {
    @Index(
      name = "genBalTransViewKeyIndex",
      columnList = "transViewKey"
    )
  }
)
public class GeneralBalanceInfo extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -8295399662776380629L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "accountNum",
    updatable = false
  )
  @ManyToOne protected Account account;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "agentId",
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected User agent;


  /** TODO: DOCUMENT ME! */
  @Column(name = "cashAdvance")
  protected BigDecimal cashAdvance = new BigDecimal(0.0);


  /** TODO: DOCUMENT ME! */
  @Column(name = "creditAdjustmentsCycleToDate")
  protected BigDecimal creditAdjustmentsCycleToDate = new BigDecimal(0.0);


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "generalBalanceInfoId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long generalBalanceInfoId;


  /** TODO: DOCUMENT ME! */
  @Column(name = "previousStatementBalance")
  protected BigDecimal previousStatementBalance = new BigDecimal(0.0);


  /** TODO: DOCUMENT ME! */
  @Column(name = "purchasesAmount")
  protected BigDecimal purchasesAmount = new BigDecimal(0.0);


  /** TODO: DOCUMENT ME! */
  @Column(name = "purchasesAmountCycleToDate")
  protected BigDecimal purchasesAmountCycleToDate = new BigDecimal(0.0);


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "sessionId",
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Session session;

  /** Transaction key. */
  @Column(
    name     = "transViewKey",
    nullable = false,
    length   = 255
  )
  protected String transViewKey;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if ((obj == null) || (getClass() != obj.getClass())) {
      return false;
    }

    if (!super.equals(obj)) {
      return false;
    }

    GeneralBalanceInfo other = (GeneralBalanceInfo) obj;

    if ((account != null) ? (!account.equals(other.account)) : (other.account != null)) {
      return false;
    }

    if ((agent != null) ? (!agent.equals(other.agent)) : (other.agent != null)) {
      return false;
    }

    if ((transViewKey != null) ? (!transViewKey.equals(other.transViewKey)) : (other.transViewKey != null)) {
      return false;
    }

    if ((purchasesAmount != null) && !(purchasesAmount.compareTo(other.purchasesAmount) == 0)) {
      return false;
    }

    if ((cashAdvance != null) && !(cashAdvance.compareTo(other.cashAdvance) == 0)) {
      return false;
    }

    if ((creditAdjustmentsCycleToDate != null)
          && !(creditAdjustmentsCycleToDate.compareTo(other.creditAdjustmentsCycleToDate) == 0)) {
      return false;
    }

    if ((purchasesAmountCycleToDate != null)
          && !(purchasesAmountCycleToDate.compareTo(other.purchasesAmountCycleToDate) == 0)) {
      return false;
    }

    if ((previousStatementBalance != null)
          && !(previousStatementBalance.compareTo(other.previousStatementBalance) == 0)) {
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
   * getter method for agent.
   *
   * @return  User
   */
  public User getAgent() {
    return agent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for cash advance.
   *
   * @return  BigDecimal
   */
  public BigDecimal getCashAdvance() {
    return cashAdvance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for credit adjustments cycle to date.
   *
   * @return  BigDecimal
   */
  public BigDecimal getCreditAdjustmentsCycleToDate() {
    return creditAdjustmentsCycleToDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for general balance info id.
   *
   * @return  Long
   */
  public Long getGeneralBalanceInfoId() {
    return generalBalanceInfoId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for previous statement balance.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPreviousStatementBalance() {
    return previousStatementBalance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for purchases amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPurchasesAmount() {
    return purchasesAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for purchases amount cycle to date.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPurchasesAmountCycleToDate() {
    return purchasesAmountCycleToDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for session.
   *
   * @return  Session
   */
  public Session getSession() {
    return session;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for trans view key.
   *
   * @return  String
   */
  public String getTransViewKey() {
    return transViewKey;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((account != null) ? account.hashCode() : 0);
    result = (31 * result) + ((agent != null) ? agent.hashCode() : 0);
    result = (31 * result) + ((transViewKey != null) ? transViewKey.hashCode() : 0);
    result = (31 * result) + ((purchasesAmount != null) ? purchasesAmount.hashCode() : 0);
    result = (31 * result) + ((cashAdvance != null) ? cashAdvance.hashCode() : 0);
    result = (31 * result) + ((creditAdjustmentsCycleToDate != null) ? creditAdjustmentsCycleToDate.hashCode() : 0);
    result = (31 * result) + ((previousStatementBalance != null) ? previousStatementBalance.hashCode() : 0);
    result = (31 * result) + ((purchasesAmountCycleToDate != null) ? purchasesAmountCycleToDate.hashCode() : 0);

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
   * setter method for agent.
   *
   * @param  agent  User
   */
  public void setAgent(User agent) {
    this.agent = agent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for cash advance.
   *
   * @param  cashAdvance  BigDecimal
   */
  public void setCashAdvance(BigDecimal cashAdvance) {
    this.cashAdvance = cashAdvance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for credit adjustments cycle to date.
   *
   * @param  creditAdjustmentsCycleToDate  BigDecimal
   */
  public void setCreditAdjustmentsCycleToDate(BigDecimal creditAdjustmentsCycleToDate) {
    this.creditAdjustmentsCycleToDate = creditAdjustmentsCycleToDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for general balance info id.
   *
   * @param  generalBalanceInfoId  Long
   */
  public void setGeneralBalanceInfoId(Long generalBalanceInfoId) {
    this.generalBalanceInfoId = generalBalanceInfoId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for previous statement balance.
   *
   * @param  previousStatementBalance  BigDecimal
   */
  public void setPreviousStatementBalance(BigDecimal previousStatementBalance) {
    this.previousStatementBalance = previousStatementBalance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for purchases amount.
   *
   * @param  purchasesAmount  BigDecimal
   */
  public void setPurchasesAmount(BigDecimal purchasesAmount) {
    this.purchasesAmount = purchasesAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for purchases amount cycle to date.
   *
   * @param  purchasesAmountCycleToDate  BigDecimal
   */
  public void setPurchasesAmountCycleToDate(BigDecimal purchasesAmountCycleToDate) {
    this.purchasesAmountCycleToDate = purchasesAmountCycleToDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for session.
   *
   * @param  session  Session
   */
  public void setSession(Session session) {
    this.session = session;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for trans view key.
   *
   * @param  transViewKey  String
   */
  public void setTransViewKey(String transViewKey) {
    this.transViewKey = transViewKey;
  }
} // end class GeneralBalanceInfo
