package com.cmc.credagility.core.domain.preview;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.schedule.BaseStrategyResult;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/15/2014 10:19
 */
@Entity
@Table(
  indexes = {
    @Index(
      name = "runType_idx",
      columnList = "runType"
    )
  }
)
public class PreviewRuleNodeResult extends BaseStrategyResult {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 1559583983794657748L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "previewRequestId",
    updatable = false,
    nullable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PreviewRequest previewRequest;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "previewRequestItemId",
    updatable = false,
    nullable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PreviewRequestItem previewRequestItem;

  /** TODO: DOCUMENT ME! */
  @Column protected Long processorId;

  /** TODO: DOCUMENT ME! */
  @Column protected Long ruleNodeId;

  /** TODO: DOCUMENT ME! */
  @Column(
    length   = 32,
    nullable = false
  )
  protected String strategyType;

  /** List of rules of schedule to be run. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "previewRuleNodeResult",
    cascade       = { CascadeType.ALL, CascadeType.REMOVE },
    orphanRemoval = true
  )
  private Set<PreviewNodeActionResult> actionResults = new LinkedHashSet<PreviewNodeActionResult>();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addActionResult.
   *
   * @param  actionResult  PreviewNodeActionResult
   */
  public void addActionResult(PreviewNodeActionResult actionResult) {
    actionResult.setPreviewPreviewRuleResult(this);
    this.actionResults.add(actionResult);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.schedule.BaseStrategyResult#equals(java.lang.Object)
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

    PreviewRuleNodeResult that = (PreviewRuleNodeResult) o;

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

    if ((ruleNodeId != null) ? (!ruleNodeId.equals(that.ruleNodeId)) : (that.ruleNodeId != null)) {
      return false;
    }

    if ((strategyType != null) ? (!strategyType.equals(that.strategyType)) : (that.strategyType != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for action results.
   *
   * @return  Set
   */
  public Set<PreviewNodeActionResult> getActionResults() {
    return actionResults;
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
   * getter method for processor id.
   *
   * @return  Long
   */
  public Long getProcessorId() {
    return processorId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for rule id.
   *
   * @return  Long
   */
  public Long getRuleId() {
    return ruleNodeId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for rule node id.
   *
   * @return  Long
   */
  public Long getRuleNodeId() {
    return ruleNodeId;
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
   * @see  com.cmc.credagility.core.domain.schedule.BaseStrategyResult#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((previewRequest != null) ? previewRequest.hashCode() : 0);
    result = (31 * result) + ((previewRequestItem != null) ? previewRequestItem.hashCode() : 0);
    result = (31 * result) + ((ruleNodeId != null) ? ruleNodeId.hashCode() : 0);
    result = (31 * result) + ((processorId != null) ? processorId.hashCode() : 0);
    result = (31 * result) + ((strategyType != null) ? strategyType.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for action results.
   *
   * @param  actionResults  Set
   */
  public void setActionResults(Set<PreviewNodeActionResult> actionResults) {
    this.actionResults = actionResults;
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
   * setter method for processor id.
   *
   * @param  processorId  Long
   */
  public void setProcessorId(Long processorId) {
    this.processorId = processorId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for rule id.
   *
   * @param  ruleId  Long
   */
  public void setRuleId(Long ruleId) {
    this.ruleNodeId = ruleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for rule node id.
   *
   * @param  ruleNodeId  Long
   */
  public void setRuleNodeId(Long ruleNodeId) {
    this.ruleNodeId = ruleNodeId;
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
   * @see  com.cmc.credagility.core.domain.schedule.BaseStrategyResult#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("PreviewRuleNodeResult");
    sb.append("{previewRequest=").append(previewRequest);
    sb.append(", previewRequestItem=").append(previewRequestItem);
    sb.append(", ruleId=").append(ruleNodeId);
    sb.append(", processorId=").append(processorId);
    sb.append(", strategyType='").append(strategyType).append('\'');
    sb.append('}');

    return sb.toString();
  }
} // end class PreviewRuleNodeResult
