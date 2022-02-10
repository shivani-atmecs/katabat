package com.cmc.credagility.core.domain.schedule;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * <p>This class is used to store account strategy result information</p>
 *
 * <p><a href="BaseStrategyResult.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 * @version  $Revision$, $Date$
 */
@MappedSuperclass public abstract class BaseStrategyResult extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** the schedule result belong to. */
  @JoinColumn(
    name      = "accountNum",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Account account;

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean deltaBatch = Boolean.FALSE;

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable         = true,
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean evalError;

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable         = true,
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean evalResult;

  /** the schedule result belong to. */
  @JoinColumn(
    name      = "portfolioId",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Portfolio portfolio;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "responsibleId",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Responsible responsible;

  /** primary key. */
  @Column
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long         strategyResultId;

  /** result rule type. */
  @Column(
    nullable = false,
    length   = 32
  )
  private String runType;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    BaseStrategyResult that = (BaseStrategyResult) o;

    if ((account != null) ? (!account.equals(that.account)) : (that.account != null)) {
      return false;
    }

    if ((strategyResultId != null) ? (!strategyResultId.equals(that.strategyResultId))
                                   : (that.strategyResultId != null)) {
      return false;
    }

    if ((evalError != null) ? (!evalError.equals(that.evalError)) : (that.evalError != null)) {
      return false;
    }

    if ((evalResult != null) ? (!evalResult.equals(that.evalResult)) : (that.evalResult != null)) {
      return false;
    }

    if ((responsible != null) ? (!responsible.equals(that.responsible)) : (that.responsible != null)) {
      return false;
    }

    if ((runType != null) ? (!runType.equals(that.runType)) : (that.runType != null)) {
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
   * getter method for delta batch.
   *
   * @return  Boolean
   */
  public Boolean getDeltaBatch() {
    return deltaBatch;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for eval error.
   *
   * @return  Boolean
   */
  public Boolean getEvalError() {
    return evalError;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for eval result.
   *
   * @return  Boolean
   */
  public Boolean getEvalResult() {
    return evalResult;
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
   * getter method for responsible.
   *
   * @return  Responsible
   */
  public Responsible getResponsible() {
    return responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for run type.
   *
   * @return  String
   */
  public String getRunType() {
    return runType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for strategy result id.
   *
   * @return  Long
   */
  public Long getStrategyResultId() {
    return strategyResultId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = 31;
    result = (31 * result) + ((account != null) ? account.hashCode() : 0);
    result = (31 * result) + ((strategyResultId != null) ? strategyResultId.hashCode() : 0);
    result = (31 * result) + ((evalError != null) ? evalError.hashCode() : 0);
    result = (31 * result) + ((evalResult != null) ? evalResult.hashCode() : 0);
    result = (31 * result) + ((responsible != null) ? responsible.hashCode() : 0);
    result = (31 * result) + ((runType != null) ? runType.hashCode() : 0);

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
   * setter method for delta batch.
   *
   * @param  deltaBatch  Boolean
   */
  public void setDeltaBatch(Boolean deltaBatch) {
    this.deltaBatch = deltaBatch;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for eval error.
   *
   * @param  evalError  Boolean
   */
  public void setEvalError(Boolean evalError) {
    this.evalError = evalError;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for eval result.
   *
   * @param  evalResult  Boolean
   */
  public void setEvalResult(Boolean evalResult) {
    this.evalResult = evalResult;
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
   * setter method for responsible.
   *
   * @param  responsible  Responsible
   */
  public void setResponsible(Responsible responsible) {
    this.responsible = responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for run type.
   *
   * @param  runType  String
   */
  public void setRunType(String runType) {
    this.runType = runType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for strategy result id.
   *
   * @param  strategyResultId  Long
   */
  public void setStrategyResultId(Long strategyResultId) {
    this.strategyResultId = strategyResultId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("BaseStrategyResult");
    sb.append("{account=").append(account);
    sb.append(", accountStrategyResultId=").append(strategyResultId);
    sb.append(", evalError=").append(evalError);
    sb.append(", evalResult=").append(evalResult);
    sb.append(", responsible=").append(responsible);
    sb.append(", runType='").append(runType).append('\'');
    sb.append('}');

    return sb.toString();
  }
} // end class BaseStrategyResult
