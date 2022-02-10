package com.cmc.credagility.core.domain.strategy;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * <p>This class is used to store extends strategy result information</p>
 *
 * <p><a href="BaseStrategyResult.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 * @version  $Revision$, $Date$
 */
@MappedSuperclass public abstract class BaseExtendStrategyResult extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  @Column(
    nullable         = true,
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean evalError;

  /** DOCUMENT ME! */
  @Column(
    nullable         = true,
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean evalResult;

  /** DOCUMENT ME! */
  @Column
  @Temporal(TemporalType.TIMESTAMP)
  protected Date         strategyDate;


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

    BaseExtendStrategyResult that = (BaseExtendStrategyResult) o;

    if ((evalError != null) ? (!evalError.equals(that.evalError)) : (that.evalError != null)) {
      return false;
    }

    if ((evalResult != null) ? (!evalResult.equals(that.evalResult)) : (that.evalResult != null)) {
      return false;
    }

    if ((runType != null) ? (!runType.equals(that.runType)) : (that.runType != null)) {
      return false;
    }

    if ((strategyDate != null) ? (!strategyDate.equals(that.strategyDate)) : (that.strategyDate != null)) {
      return false;
    }

    if ((strategyResultId != null) ? (!strategyResultId.equals(that.strategyResultId))
                                   : (that.strategyResultId != null)) {
      return false;
    }

    return true;
  } // end method equals

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
   * getter method for run type.
   *
   * @return  String
   */
  public String getRunType() {
    return runType;
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
    result = (31 * result) + ((evalError != null) ? evalError.hashCode() : 0);
    result = (31 * result) + ((evalResult != null) ? evalResult.hashCode() : 0);
    result = (31 * result) + ((strategyDate != null) ? strategyDate.hashCode() : 0);
    result = (31 * result) + ((strategyResultId != null) ? strategyResultId.hashCode() : 0);
    result = (31 * result) + ((runType != null) ? runType.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  evalError  DOCUMENT ME!
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
   * setter method for run type.
   *
   * @param  runType  String
   */
  public void setRunType(String runType) {
    this.runType = runType;
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
   * setter method for strategy result id.
   *
   * @param  strategyResultId  Long
   */
  public void setStrategyResultId(Long strategyResultId) {
    this.strategyResultId = strategyResultId;
  }
} // end class BaseExtendStrategyResult
