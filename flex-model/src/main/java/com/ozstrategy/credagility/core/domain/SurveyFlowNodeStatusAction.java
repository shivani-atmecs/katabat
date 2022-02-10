package com.ozstrategy.credagility.core.domain;

import com.ozstrategy.credagility.core.domain.workflow.WorkflowNodeActionTriggerType;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * Trigger this action will update account overall status.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/16/2014 14:57
 */
@Entity @Table public class SurveyFlowNodeStatusAction extends CreatorEntity implements Serializable,
  SurveyFlowNodeActionInterface {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 1288336137839146423L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** trigger the action criteria. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String criteria;

  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** node . */
  @JoinColumn(
    name       = "nodeId",
    nullable   = false,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected SurveyFlowNode node = new SurveyFlowNode();

  /** node . */
  @JoinColumn(
    name       = "statusActionId",
    nullable   = false,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected StatusAction statusAction = new StatusAction();


  /** triggerType contains DAILY, ENTRY, EXIT, REAL_TIME. */
  @Column(
    length   = 32,
    nullable = false
  )
  @Enumerated(value = EnumType.STRING)
  protected WorkflowNodeActionTriggerType triggerType = WorkflowNodeActionTriggerType.ENTRY;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * deepCopy.
   *
   * @param  copyFrom  SurveyFlowNodeStatusAction
   */
  public void deepCopy(SurveyFlowNodeStatusAction copyFrom) {
    setCriteria(copyFrom.getCriteria());
    setTriggerType(copyFrom.getTriggerType());
    setStatusAction(copyFrom.getStatusAction());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#equals(Object)
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

    SurveyFlowNodeStatusAction that = (SurveyFlowNodeStatusAction) o;

    if ((criteria != null) ? (!criteria.equals(that.criteria)) : (that.criteria != null)) {
      return false;
    }

    if ((id != null) ? (!id.equals(that.id)) : (that.id != null)) {
      return false;
    }

    if (!node.equals(that.node)) {
      return false;
    }

    if (triggerType != that.triggerType) {
      return false;
    }

    if ((statusAction != null) ? (!statusAction.equals(that.statusAction)) : (that.statusAction != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  SurveyFlowNodeActionInterface#getActionName()
   */
  @Override public String getActionName() {
    if ((this.statusAction != null) && (this.statusAction.getOverallStatusDetail() != null)) {
      return this.statusAction.getOverallStatusDetail().getStatusCode() + ":"
        + this.statusAction.getOverallStatusDetail().getStatusDescription();
    } else if (this.statusAction != null) {
      return this.statusAction.getName();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  SurveyFlowNodeActionInterface#getCriteria()
   */
  @Override public String getCriteria() {
    return criteria;
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
   * getter method for node.
   *
   * @return  SurveyFlowNode
   */
  public SurveyFlowNode getNode() {
    return node;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status action.
   *
   * @return  StatusAction
   */
  public StatusAction getStatusAction() {
    return statusAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  SurveyFlowNodeActionInterface#getTriggerType()
   */
  @Override public WorkflowNodeActionTriggerType getTriggerType() {
    return triggerType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((criteria != null) ? criteria.hashCode() : 0);
    result = (31 * result) + ((id != null) ? id.hashCode() : 0);
    result = (31 * result) + node.hashCode();
    result = (31 * result) + triggerType.hashCode();
    result = (31 * result) + ((statusAction != null) ? statusAction.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for criteria.
   *
   * @param  criteria  String
   */
  public void setCriteria(String criteria) {
    this.criteria = criteria;
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
   * setter method for node.
   *
   * @param  node  SurveyFlowNode
   */
  public void setNode(SurveyFlowNode node) {
    this.node = node;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for status action.
   *
   * @param  statusAction  StatusAction
   */
  public void setStatusAction(StatusAction statusAction) {
    this.statusAction = statusAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for trigger type.
   *
   * @param  triggerType  WorkflowNodeActionTriggerType
   */
  public void setTriggerType(WorkflowNodeActionTriggerType triggerType) {
    this.triggerType = triggerType;
  }
} // end class SurveyFlowNodeStatusAction
