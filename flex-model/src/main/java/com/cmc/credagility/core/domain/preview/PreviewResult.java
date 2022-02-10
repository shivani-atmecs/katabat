package com.cmc.credagility.core.domain.preview;

import java.io.Serializable;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.portfolio.Portfolio;


/**
 * Preview request capture all request of preview.
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/15/2014 10:16
 */
@Entity public class PreviewResult extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 4839212639371622143L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column protected Long accountError;

  /** TODO: DOCUMENT ME! */
  @Column protected Long accountNotTriggered;

  /** TODO: DOCUMENT ME! */
  @Column protected Long accountProcessed;

  /** TODO: DOCUMENT ME! */
  @Column protected Long accountSkipped;

  /** TODO: DOCUMENT ME! */
  @Column protected Long accountTotal;

  /** TODO: DOCUMENT ME! */
  @Column protected Long accountTriggered;


  /** TODO: DOCUMENT ME! */
  @Column protected Long duration;

  /** TODO: DOCUMENT ME! */
  @Column
  @Temporal(TemporalType.TIMESTAMP)
  protected Date         endTime;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "portfolioId",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Portfolio portfolio;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "requestId",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PreviewRequest previewRequest;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "requestItemId",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PreviewRequestItem previewRequestItem;

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long previewResultId;

  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  protected Long processorId;

  /** TODO: DOCUMENT ME! */
  @Column protected Long responsibleError;

  /** TODO: DOCUMENT ME! */
  @Column protected Long responsibleNotTriggered;

  /** TODO: DOCUMENT ME! */
  @Column protected Long responsibleProcessed;

  /** TODO: DOCUMENT ME! */
  @Column protected Long responsibleSkipped;

  /** TODO: DOCUMENT ME! */
  @Column protected Long responsibleTotal;

  /** TODO: DOCUMENT ME! */
  @Column protected Long responsibleTriggered;

  /** TODO: DOCUMENT ME! */
  @Column
  @Temporal(TemporalType.TIMESTAMP)
  protected Date         startTime;

  /** TODO: DOCUMENT ME! */
  @Column(
    length   = 32,
    nullable = false
  )
  protected String                 strategyType;
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "previewResult",
    cascade       = { CascadeType.ALL, CascadeType.REMOVE },
    orphanRemoval = true
  )
  private Set<PreviewActionResult> actionResults = new LinkedHashSet<PreviewActionResult>();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addActionResult.
   *
   * @param  actionResult  PreviewActionResult
   */
  public void addActionResult(PreviewActionResult actionResult) {
    actionResult.setPreviewResult(this);
    this.actionResults.add(actionResult);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

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

    PreviewResult that = (PreviewResult) o;

    if ((previewRequest != null) ? (!previewRequest.equals(that.previewRequest)) : (that.previewRequest != null)) {
      return false;
    }

    if ((previewRequestItem != null) ? (!previewRequestItem.equals(that.previewRequestItem))
                                     : (that.previewRequestItem != null)) {
      return false;
    }

    if ((processorId != null) ? (!processorId.equals(that.processorId)) : (that.processorId != null)) {
      return false;
    }

    if ((strategyType != null) ? (!strategyType.equals(that.strategyType)) : (that.strategyType != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account error.
   *
   * @return  Long
   */
  public Long getAccountError() {
    return accountError;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account not triggered.
   *
   * @return  Long
   */
  public Long getAccountNotTriggered() {
    return accountNotTriggered;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account processed.
   *
   * @return  Long
   */
  public Long getAccountProcessed() {
    return accountProcessed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account skipped.
   *
   * @return  Long
   */
  public Long getAccountSkipped() {
    return accountSkipped;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account total.
   *
   * @return  Long
   */
  public Long getAccountTotal() {
    return accountTotal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account triggered.
   *
   * @return  Long
   */
  public Long getAccountTriggered() {
    return accountTriggered;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for action results.
   *
   * @return  Set
   */
  public Set<PreviewActionResult> getActionResults() {
    return actionResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for duration.
   *
   * @return  Long
   */
  public Long getDuration() {
    return duration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for end time.
   *
   * @return  Date
   */
  public Date getEndTime() {
    return endTime;
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
   * getter method for preview request.
   *
   * @return  PreviewRequest
   */
  public PreviewRequest getPreviewRequest() {
    return previewRequest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for preview request item.
   *
   * @return  PreviewRequestItem
   */
  public PreviewRequestItem getPreviewRequestItem() {
    return previewRequestItem;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for preview result id.
   *
   * @return  Long
   */
  public Long getPreviewResultId() {
    return previewResultId;
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
   * getter method for responsible error.
   *
   * @return  Long
   */
  public Long getResponsibleError() {
    return responsibleError;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible not triggered.
   *
   * @return  Long
   */
  public Long getResponsibleNotTriggered() {
    return responsibleNotTriggered;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible processed.
   *
   * @return  Long
   */
  public Long getResponsibleProcessed() {
    return responsibleProcessed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible skipped.
   *
   * @return  Long
   */
  public Long getResponsibleSkipped() {
    return responsibleSkipped;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible total.
   *
   * @return  Long
   */
  public Long getResponsibleTotal() {
    return responsibleTotal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible triggered.
   *
   * @return  Long
   */
  public Long getResponsibleTriggered() {
    return responsibleTriggered;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for rule criteria.
   *
   * @return  String
   */
  public String getRuleCriteria() {
    if (previewRequestItem != null) {
      return previewRequestItem.getRuleCriteria();
    } else {
      return null;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for rule id.
   *
   * @return  Long
   */
  public Long getRuleId() {
    if (previewRequestItem != null) {
      return previewRequestItem.getRuleId();
    } else {
      return null;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for rule name.
   *
   * @return  String
   */
  public String getRuleName() {
    if (previewRequestItem != null) {
      return previewRequestItem.getRuleName();
    } else {
      return null;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for rule priority.
   *
   * @return  Integer
   */
  public Integer getRulePriority() {
    if (previewRequestItem != null) {
      return previewRequestItem.getRulePriority();
    } else {
      return null;
    }
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
   * getter method for strategy type.
   *
   * @return  String
   */
  public String getStrategyType() {
    return strategyType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((previewRequest != null) ? previewRequest.hashCode() : 0);
    result = (31 * result) + ((previewRequestItem != null) ? previewRequestItem.hashCode() : 0);
    result = (31 * result) + ((processorId != null) ? processorId.hashCode() : 0);
    result = (31 * result) + ((strategyType != null) ? strategyType.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account error.
   *
   * @param  accountError  Long
   */
  public void setAccountError(Long accountError) {
    this.accountError = accountError;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account not triggered.
   *
   * @param  accountNotTriggered  Long
   */
  public void setAccountNotTriggered(Long accountNotTriggered) {
    this.accountNotTriggered = accountNotTriggered;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account processed.
   *
   * @param  accountProcessed  Long
   */
  public void setAccountProcessed(Long accountProcessed) {
    this.accountProcessed = accountProcessed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account skipped.
   *
   * @param  accountSkipped  Long
   */
  public void setAccountSkipped(Long accountSkipped) {
    this.accountSkipped = accountSkipped;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account total.
   *
   * @param  accountTotal  Long
   */
  public void setAccountTotal(Long accountTotal) {
    this.accountTotal = accountTotal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account triggered.
   *
   * @param  accountTriggered  Long
   */
  public void setAccountTriggered(Long accountTriggered) {
    this.accountTriggered = accountTriggered;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for action results.
   *
   * @param  actionResults  Set
   */
  public void setActionResults(Set<PreviewActionResult> actionResults) {
    this.actionResults = actionResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for duration.
   *
   * @param  duration  Long
   */
  public void setDuration(Long duration) {
    this.duration = duration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for end time.
   *
   * @param  endTime  Date
   */
  public void setEndTime(Date endTime) {
    this.endTime = endTime;
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
   * setter method for preview request.
   *
   * @param  previewRequest  PreviewRequest
   */
  public void setPreviewRequest(PreviewRequest previewRequest) {
    this.previewRequest = previewRequest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for preview request item.
   *
   * @param  previewRequestItem  PreviewRequestItem
   */
  public void setPreviewRequestItem(PreviewRequestItem previewRequestItem) {
    this.previewRequestItem = previewRequestItem;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for preview result id.
   *
   * @param  previewResultId  Long
   */
  public void setPreviewResultId(Long previewResultId) {
    this.previewResultId = previewResultId;
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
   * setter method for responsible error.
   *
   * @param  responsibleError  Long
   */
  public void setResponsibleError(Long responsibleError) {
    this.responsibleError = responsibleError;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for responsible not triggered.
   *
   * @param  responsibleNotTriggered  Long
   */
  public void setResponsibleNotTriggered(Long responsibleNotTriggered) {
    this.responsibleNotTriggered = responsibleNotTriggered;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for responsible processed.
   *
   * @param  responsibleProcessed  Long
   */
  public void setResponsibleProcessed(Long responsibleProcessed) {
    this.responsibleProcessed = responsibleProcessed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for responsible skipped.
   *
   * @param  responsibleSkipped  Long
   */
  public void setResponsibleSkipped(Long responsibleSkipped) {
    this.responsibleSkipped = responsibleSkipped;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for responsible total.
   *
   * @param  responsibleTotal  Long
   */
  public void setResponsibleTotal(Long responsibleTotal) {
    this.responsibleTotal = responsibleTotal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for responsible triggered.
   *
   * @param  responsibleTriggered  Long
   */
  public void setResponsibleTriggered(Long responsibleTriggered) {
    this.responsibleTriggered = responsibleTriggered;
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
   * setter method for strategy type.
   *
   * @param  strategyType  String
   */
  public void setStrategyType(String strategyType) {
    this.strategyType = strategyType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("PreviewResult");
    sb.append("{accountError=").append(accountError);
    sb.append(", accountNotTriggered=").append(accountNotTriggered);
    sb.append(", accountProcessed=").append(accountProcessed);
    sb.append(", accountSkipped=").append(accountSkipped);
    sb.append(", accountTotal=").append(accountTotal);
    sb.append(", accountTriggered=").append(accountTriggered);
    sb.append(", duration=").append(duration);
    sb.append(", endTime=").append(endTime);
    sb.append(", portfolio=").append(portfolio);
    sb.append(", previewRequest=").append(previewRequest);
    sb.append(", previewRequestItem=").append(previewRequestItem);
    sb.append(", previewResultId=").append(previewResultId);
    sb.append(", processorId=").append(processorId);
    sb.append(", responsibleError=").append(responsibleError);
    sb.append(", responsibleNotTriggered=").append(responsibleNotTriggered);
    sb.append(", responsibleProcessed=").append(responsibleProcessed);
    sb.append(", responsibleSkipped=").append(responsibleSkipped);
    sb.append(", responsibleTotal=").append(responsibleTotal);
    sb.append(", responsibleTriggered=").append(responsibleTriggered);
    sb.append(", startTime=").append(startTime);
    sb.append(", strategyType='").append(strategyType).append('\'');
    sb.append(", actionResults=").append(actionResults);
    sb.append('}');

    return sb.toString();
  } // end method toString
} // end class PreviewResult
