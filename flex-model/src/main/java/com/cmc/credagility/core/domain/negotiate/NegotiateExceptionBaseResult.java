package com.cmc.credagility.core.domain.negotiate;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * This class is used to store negotiate exception result information.
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/14/2014 17:36
 */
@MappedSuperclass public abstract class NegotiateExceptionBaseResult extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "accountNum",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Account account;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "ruleId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected NegotiateExceptionRule exceptionRule = new NegotiateExceptionRule();

  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "scheduleId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected NegotiateExceptionSchedule exceptionSchedule = new NegotiateExceptionSchedule();

  /** Rule Id, PK. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @Column protected Long ruleBatchId;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String source;

  /** TODO: DOCUMENT ME! */
  @Column
  @Temporal(TemporalType.TIMESTAMP)
  protected Date strategyDate;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new NegotiateExceptionBaseResult object.
   */
  protected NegotiateExceptionBaseResult() { }

  /**
   * Creates a new NegotiateExceptionBaseResult object.
   *
   * @param  other  NegotiateExceptionBaseResult
   */
  protected NegotiateExceptionBaseResult(NegotiateExceptionBaseResult other) {
    this.account           = other.getAccount();
    this.exceptionRule     = other.getExceptionRule();
    this.exceptionSchedule = other.getExceptionSchedule();
    this.ruleBatchId       = other.getRuleBatchId();
    this.strategyDate      = other.getStrategyDate();
    this.source            = other.getSource();
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * equals.
   *
   * @param   o  Object
   *
   * @return  boolean
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof NegotiateExceptionBaseResult)) {
      return false;
    }

    NegotiateExceptionBaseResult that = (NegotiateExceptionBaseResult) o;

    if ((exceptionRule != null) ? (!exceptionRule.getRuleId().equals(that.exceptionRule.getRuleId()))
                                : (that.exceptionRule != null)) {
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
   * getter method for exception rule.
   *
   * @return  NegotiateExceptionRule
   */
  public NegotiateExceptionRule getExceptionRule() {
    return exceptionRule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for exception schedule.
   *
   * @return  NegotiateExceptionSchedule
   */
  public NegotiateExceptionSchedule getExceptionSchedule() {
    return exceptionSchedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for id.
   *
   * @return  Long
   */
  public Long getId() {
    return id;
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
   * getter method for source.
   *
   * @return  String
   */
  public String getSource() {
    return source;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for strategy date.
   *
   * @return  Date
   */
  public Date getStrategyDate() {
    return strategyDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = 31;
    result = (31 * result) + ((exceptionRule != null) ? exceptionRule.getRuleId().hashCode() : 0);

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
   * setter method for exception rule.
   *
   * @param  exceptionRule  NegotiateExceptionRule
   */
  public void setExceptionRule(NegotiateExceptionRule exceptionRule) {
    this.exceptionRule = exceptionRule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for exception schedule.
   *
   * @param  exceptionSchedule  NegotiateExceptionSchedule
   */
  public void setExceptionSchedule(NegotiateExceptionSchedule exceptionSchedule) {
    this.exceptionSchedule = exceptionSchedule;
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
   * setter method for rule batch id.
   *
   * @param  ruleBatchId  Long
   */
  public void setRuleBatchId(Long ruleBatchId) {
    this.ruleBatchId = ruleBatchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for source.
   *
   * @param  source  String
   */
  public void setSource(String source) {
    this.source = source;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for strategy date.
   *
   * @param  strategyDate  Date
   */
  public void setStrategyDate(Date strategyDate) {
    this.strategyDate = strategyDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * toString.
   *
   * @return  String
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("NegotiateExceptionBaseResult");
    sb.append("{account=").append(account);
    sb.append(", exceptionRule=").append(exceptionRule);
    sb.append(", exceptionSchedule=").append(exceptionSchedule);
    sb.append(", id=").append(id);
    sb.append(", strategyDate=").append(strategyDate);
    sb.append('}');

    return sb.toString();
  }
} // end class NegotiateExceptionBaseResult
