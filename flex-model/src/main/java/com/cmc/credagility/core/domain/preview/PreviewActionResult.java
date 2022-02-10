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
 * Preview action result capture all request action result detail item of preview.
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/14/2014 18:09
 */
@Entity public class PreviewActionResult extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -3951606372944730044L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column protected Long accountTriggered;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String actionType;

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long previewActionResultId;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "previewResultId",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected PreviewResult previewResult;

  /** TODO: DOCUMENT ME! */
  protected Long responsibleTriggered;

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

    PreviewActionResult that = (PreviewActionResult) o;

    if ((actionType != null) ? (!actionType.equals(that.actionType)) : (that.actionType != null)) {
      return false;
    }

    return true;
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
   * getter method for action type.
   *
   * @return  String
   */
  public String getActionType() {
    return actionType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for preview action result id.
   *
   * @return  Long
   */
  public Long getPreviewActionResultId() {
    return previewActionResultId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for preview result.
   *
   * @return  PreviewResult
   */
  public PreviewResult getPreviewResult() {
    return previewResult;
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
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = 31;
    result = (31 * result) + ((actionType != null) ? actionType.hashCode() : 0);

    return result;
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
   * setter method for action type.
   *
   * @param  actionType  String
   */
  public void setActionType(String actionType) {
    this.actionType = actionType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for preview action result id.
   *
   * @param  previewActionResultId  Long
   */
  public void setPreviewActionResultId(Long previewActionResultId) {
    this.previewActionResultId = previewActionResultId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for preview result.
   *
   * @param  previewResult  PreviewResult
   */
  public void setPreviewResult(PreviewResult previewResult) {
    this.previewResult = previewResult;
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
   * toString.
   *
   * @return  String
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("PreviewActionResult");
    sb.append("{actionType='").append(actionType).append('\'');
    sb.append(", previewActionResultId=").append(previewActionResultId);
    sb.append(", previewResult=").append(previewResult);
    sb.append(", triggerCount=").append(accountTriggered);
    sb.append('}');

    return sb.toString();
  }
} // end class PreviewActionResult
