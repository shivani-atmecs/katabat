package com.cmc.credagility.core.domain.preview;

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


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/15/2014 10:07
 */
@Entity public class PreviewRequestSplit extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = true,
    length   = 512
  )
  protected String cmcRandomDigits = null;

  /** TODO: DOCUMENT ME! */
  @Column(nullable = true)
  protected Integer cmcRandomEndDigit = null;

  /** TODO: DOCUMENT ME! */
  @Column(nullable = true)
  protected Integer cmcRandomStartDigit = null;

  /** TODO: DOCUMENT ME! */
  @Column protected long completedCount = 0L;

  /** TODO: DOCUMENT ME! */
  @Column
  @Temporal(TemporalType.TIMESTAMP)
  protected Date         completeTime;

  /** TODO: DOCUMENT ME! */
  @Column protected Long endAccountNum;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "previewRequestId",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected PreviewRequest previewRequest;

  /** TODO: DOCUMENT ME! */
  @Column protected Long processorId;

  /** TODO: DOCUMENT ME! */
  @Column protected Long startAccountNum;

  /** TODO: DOCUMENT ME! */
  @Column
  @Temporal(TemporalType.TIMESTAMP)
  protected Date         startTime;

  /** status should INIT/STARTED/FAIL/SUCCESS/CANCEL. */
  @Column(length = 16)
  protected String status = "INIT";

  /** TODO: DOCUMENT ME! */
  @Column protected long targetCount = 0L;

  @GeneratedValue(strategy = IDENTITY)
  @Id private Long previewRequestSplitId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof PreviewRequestSplit)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    PreviewRequestSplit that = (PreviewRequestSplit) o;

    if (targetCount != that.targetCount) {
      return false;
    }

    if ((cmcRandomDigits != null) ? (!cmcRandomDigits.equals(that.cmcRandomDigits)) : (that.cmcRandomDigits != null)) {
      return false;
    }

    if ((endAccountNum != null) ? (!endAccountNum.equals(that.endAccountNum)) : (that.endAccountNum != null)) {
      return false;
    }

    if ((startAccountNum != null) ? (!startAccountNum.equals(that.startAccountNum)) : (that.startAccountNum != null)) {
      return false;
    }

    if ((status != null) ? (!status.equals(that.status)) : (that.status != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for cmc random digits.
   *
   * @return  String
   */
  public String getCmcRandomDigits() {
    return cmcRandomDigits;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for cmc random end digit.
   *
   * @return  Integer
   */
  public Integer getCmcRandomEndDigit() {
    return cmcRandomEndDigit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for cmc random start digit.
   *
   * @return  Integer
   */
  public Integer getCmcRandomStartDigit() {
    return cmcRandomStartDigit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for completed count.
   *
   * @return  long
   */
  public long getCompletedCount() {
    return completedCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for complete time.
   *
   * @return  Date
   */
  public Date getCompleteTime() {
    return completeTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for end account num.
   *
   * @return  Long
   */
  public Long getEndAccountNum() {
    return endAccountNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for preview request.
   *
   * @return  PreviewRequest
   */
  public PreviewRequest getPreviewRequest() {
    return previewRequest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for preview request split id.
   *
   * @return  Long
   */
  public Long getPreviewRequestSplitId() {
    return previewRequestSplitId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for processor id.
   *
   * @return  Long
   */
  public Long getProcessorId() {
    return processorId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for start account num.
   *
   * @return  Long
   */
  public Long getStartAccountNum() {
    return startAccountNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for start time.
   *
   * @return  Date
   */
  public Date getStartTime() {
    return startTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status.
   *
   * @return  String
   */
  public String getStatus() {
    return status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for target count.
   *
   * @return  long
   */
  public long getTargetCount() {
    return targetCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((cmcRandomDigits != null) ? cmcRandomDigits.hashCode() : 0);
    result = (31 * result) + ((endAccountNum != null) ? endAccountNum.hashCode() : 0);
    result = (31 * result) + ((startAccountNum != null) ? startAccountNum.hashCode() : 0);
    result = (31 * result) + ((status != null) ? status.hashCode() : 0);
    result = (31 * result) + (int) (targetCount ^ (targetCount >>> 32));

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for using digits string.
   *
   * @return  boolean
   */
  public boolean isUsingDigitsString() {
    return (cmcRandomDigits != null);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for using digit start end.
   *
   * @return  boolean
   */
  public boolean isUsingDigitStartEnd() {
    return ((cmcRandomStartDigit != null) && (cmcRandomEndDigit != null));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for cmc random digits.
   *
   * @param  cmcRandomDigits  String
   */
  public void setCmcRandomDigits(String cmcRandomDigits) {
    this.cmcRandomDigits = cmcRandomDigits;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for cmc random end digit.
   *
   * @param  cmcRandomEndDigit  Integer
   */
  public void setCmcRandomEndDigit(Integer cmcRandomEndDigit) {
    this.cmcRandomEndDigit = cmcRandomEndDigit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for cmc random start digit.
   *
   * @param  cmcRandomStartDigit  Integer
   */
  public void setCmcRandomStartDigit(Integer cmcRandomStartDigit) {
    this.cmcRandomStartDigit = cmcRandomStartDigit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for completed count.
   *
   * @param  completedCount  long
   */
  public void setCompletedCount(long completedCount) {
    this.completedCount = completedCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for complete time.
   *
   * @param  completeTime  Date
   */
  public void setCompleteTime(Date completeTime) {
    this.completeTime = completeTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for end account num.
   *
   * @param  endAccountNum  Long
   */
  public void setEndAccountNum(Long endAccountNum) {
    this.endAccountNum = endAccountNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for preview request.
   *
   * @param  previewRequest  PreviewRequest
   */
  public void setPreviewRequest(PreviewRequest previewRequest) {
    this.previewRequest = previewRequest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for preview request split id.
   *
   * @param  previewRequestSplitId  Long
   */
  public void setPreviewRequestSplitId(Long previewRequestSplitId) {
    this.previewRequestSplitId = previewRequestSplitId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for processor id.
   *
   * @param  processorId  Long
   */
  public void setProcessorId(Long processorId) {
    this.processorId = processorId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for start account num.
   *
   * @param  startAccountNum  Long
   */
  public void setStartAccountNum(Long startAccountNum) {
    this.startAccountNum = startAccountNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for start time.
   *
   * @param  startTime  Date
   */
  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for status.
   *
   * @param  status  String
   */
  public void setStatus(String status) {
    this.status = status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for target count.
   *
   * @param  targetCount  long
   */
  public void setTargetCount(long targetCount) {
    this.targetCount = targetCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("PreviewRequestSplit");
    sb.append("{cmcRandomDigits='").append(cmcRandomDigits).append('\'');
    sb.append(", processorId=").append(processorId);
    sb.append(", cmcRandomEndDigit=").append(cmcRandomEndDigit);
    sb.append(", cmcRandomStartDigit=").append(cmcRandomStartDigit);
    sb.append(", completedCount=").append(completedCount);
    sb.append(", endAccountNum=").append(endAccountNum);
    sb.append(", previewRequest=").append(previewRequest);
    sb.append(", startAccountNum=").append(startAccountNum);
    sb.append(", status='").append(status).append('\'');
    sb.append(", targetCount=").append(targetCount);
    sb.append(", previewRequestSplitId=").append(previewRequestSplitId);
    sb.append('}');

    return sb.toString();
  }

} // end class PreviewRequestSplit
