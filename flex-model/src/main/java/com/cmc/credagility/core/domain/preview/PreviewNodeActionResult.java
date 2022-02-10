package com.cmc.credagility.core.domain.preview;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * Preview request item capture all request detail item of preview.
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/14/2014 18:23
 */
@Entity public class PreviewNodeActionResult extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 7674439940650597979L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String actionType;

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long previewNodeActionResultId;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "previewRuleNodeResultId",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected PreviewRuleNodeResult previewRuleNodeResult;

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

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    PreviewNodeActionResult that = (PreviewNodeActionResult) o;

    if ((actionType != null) ? (!actionType.equals(that.actionType)) : (that.actionType != null)) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for action type.
   *
   * @return  String
   */
  public String getActionType() {
    return actionType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for preview node action result id.
   *
   * @return  Long
   */
  public Long getPreviewNodeActionResultId() {
    return previewNodeActionResultId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for preview preview rule result.
   *
   * @return  PreviewRuleNodeResult
   */
  public PreviewRuleNodeResult getPreviewPreviewRuleResult() {
    return previewRuleNodeResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((actionType != null) ? actionType.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for action type.
   *
   * @param  actionType  String
   */
  public void setActionType(String actionType) {
    this.actionType = actionType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for preview node action result id.
   *
   * @param  previewNodeActionResultId  Long
   */
  public void setPreviewNodeActionResultId(Long previewNodeActionResultId) {
    this.previewNodeActionResultId = previewNodeActionResultId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for preview preview rule result.
   *
   * @param  previewPreviewRuleResult  PreviewRuleNodeResult
   */
  public void setPreviewPreviewRuleResult(PreviewRuleNodeResult previewPreviewRuleResult) {
    this.previewRuleNodeResult = previewPreviewRuleResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * toString.
   *
   * @return  String
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("PreviewNodeActionResult");
    sb.append("{actionType='").append(actionType).append('\'');
    sb.append(", previewNodeActionResultId=").append(previewNodeActionResultId);
    sb.append(", previewPreviewRuleResult=").append(previewRuleNodeResult);
    sb.append('}');

    return sb.toString();
  }
} // end class PreviewNodeActionResult
