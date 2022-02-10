package com.cmc.credagility.core.domain.schedule;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * <p>This class is used to store portfolio schedule preview individule rule result information</p>
 *
 * <p><a href="BaseSchedule.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 * @version  10/15/2014 14:00
 */
@Entity
@Table(name = "RunRuleResult")
public class RunRuleResult extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  private static final long serialVersionUID = 308884863828255256L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  // npelleti, 07/30, USBank, Removed unique constraint
  /** primary key. */
  @Column(
    name     = "resultId", /*unique = true,*/
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long resultId;

  /** the running rule id. */
  @Column(
    name     = "ruleId",
    nullable = false
  )
  private Long ruleId;

  /** result rule type. */
  @Column(
    name     = "ruleType",
    nullable = false,
    length   = 32
  )
  private String ruleType;

  /** the schedule result belong to. */
  @JoinColumn(
    name      = "scheduleResultId",
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private RunScheduleResult scheduleResult;

  /** the tiggered account count. */
  @Column(
    name     = "triggeredCount",
    nullable = false
  )
  private Integer triggeredCount;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    final RunRuleResult other = (RunRuleResult) obj;

    if ((this.scheduleResult != other.scheduleResult)
          && ((this.scheduleResult == null) || !this.scheduleResult.equals(other.scheduleResult))) {
      return false;
    }

    if ((this.ruleId != other.ruleId) && ((this.ruleId == null) || !this.ruleId.equals(other.ruleId))) {
      return false;
    }

    if ((this.triggeredCount != other.triggeredCount)
          && ((this.triggeredCount == null) || !this.triggeredCount.equals(other.triggeredCount))) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for result id.
   *
   * @return  Long
   */
  public Long getResultId() {
    return resultId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for rule id.
   *
   * @return  Long
   */
  public Long getRuleId() {
    return ruleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for rule type.
   *
   * @return  String
   */
  public String getRuleType() {
    return ruleType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for schedule result.
   *
   * @return  RunScheduleResult
   */
  public RunScheduleResult getScheduleResult() {
    return scheduleResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for triggered count.
   *
   * @return  Integer
   */
  public Integer getTriggeredCount() {
    return triggeredCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int hash = 7;
    hash = (97 * hash) + ((this.scheduleResult != null) ? this.scheduleResult.hashCode() : 0);
    hash = (97 * hash) + ((this.ruleId != null) ? this.ruleId.hashCode() : 0);
    hash = (97 * hash) + ((this.triggeredCount != null) ? this.triggeredCount.hashCode() : 0);

    return hash;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for result id.
   *
   * @param  resultId  Long
   */
  public void setResultId(Long resultId) {
    this.resultId = resultId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for rule id.
   *
   * @param  ruleId  Long
   */
  public void setRuleId(Long ruleId) {
    this.ruleId = ruleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for rule type.
   *
   * @param  ruleType  String
   */
  public void setRuleType(String ruleType) {
    this.ruleType = ruleType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for schedule result.
   *
   * @param  scheduleResult  RunScheduleResult
   */
  public void setScheduleResult(RunScheduleResult scheduleResult) {
    this.scheduleResult = scheduleResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for triggered count.
   *
   * @param  triggeredCount  Integer
   */
  public void setTriggeredCount(Integer triggeredCount) {
    this.triggeredCount = triggeredCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#toString()
   */
  @Override public String toString() {
    StringBuilder toStringBuilder = new StringBuilder();
    toStringBuilder.append(super.toString());
    toStringBuilder.append("\n");
    toStringBuilder.append("\nresultId: ");
    toStringBuilder.append(resultId);
    toStringBuilder.append("\nscheduleResult: ");
    toStringBuilder.append(scheduleResult);
    toStringBuilder.append("\nruleId: ");
    toStringBuilder.append(ruleId);
    toStringBuilder.append("\ntiggeredAccounts: ");
    toStringBuilder.append(triggeredCount);

    return toStringBuilder.toString();
  }
} // end class RunRuleResult
