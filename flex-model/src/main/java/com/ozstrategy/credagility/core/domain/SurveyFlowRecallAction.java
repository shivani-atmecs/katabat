package com.ozstrategy.credagility.core.domain;

import com.ozstrategy.credagility.core.domain.workflow.WorkflowNodeActionInterface;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowNodeActionTriggerType;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  09/23/2015 17:10
 */
@Entity @Table public class SurveyFlowRecallAction extends CreatorEntity implements Serializable,
  WorkflowNodeActionInterface {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 2863682024802984511L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String criteria;

  /** node . */
  @JoinColumn(
    name       = "flowId",
    nullable   = false,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected SurveyFlow flow = new SurveyFlow();

  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** node . */
  @JoinColumn(
    name       = "recallActionId",
    nullable   = false,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected RecallAction recallAction = new RecallAction();


  /** TODO: DOCUMENT ME! */
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
   * @param  copyFrom  $param.type$
   */
  public void deepCopy(SurveyFlowRecallAction copyFrom) {
    setCriteria(copyFrom.getCriteria());
    setTriggerType(copyFrom.getTriggerType());
    setRecallAction(copyFrom.getRecallAction());
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

    SurveyFlowRecallAction that = (SurveyFlowRecallAction) o;

    if ((criteria != null) ? (!criteria.equals(that.criteria)) : (that.criteria != null)) {
      return false;
    }

    if ((id != null) ? (!id.equals(that.id)) : (that.id != null)) {
      return false;
    }

    if (!flow.equals(that.flow)) {
      return false;
    }

    if (triggerType != that.triggerType) {
      return false;
    }

    if ((recallAction != null) ? (!recallAction.equals(that.recallAction)) : (that.recallAction != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for action name.
   *
   * @return  String
   */
  @Override public String getActionName() {
    if (this.recallAction != null) {
      return this.recallAction.getName();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  @Override public String getCriteria() {
    return criteria;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * SurveyFlow.
   *
   * @return  SurveyFlow.
   */
  public SurveyFlow getFlow() {
    return flow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * RecallAction.
   *
   * @return  RecallAction.
   */
  public RecallAction getRecallAction() {
    return recallAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for trigger type.
   *
   * @return  WorkflowNodeActionTriggerType
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
    result = (31 * result) + flow.hashCode();
    result = (31 * result) + triggerType.hashCode();
    result = (31 * result) + ((recallAction != null) ? recallAction.hashCode() : 0);

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
   * setter method for flow.
   *
   * @param  flow  SurveyFlow
   */
  public void setFlow(SurveyFlow flow) {
    this.flow = flow;
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
   * setter method for recall action.
   *
   * @param  recallAction  RecallAction
   */
  public void setRecallAction(RecallAction recallAction) {
    this.recallAction = recallAction;
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
} // end class SurveyFlowRecallAction
