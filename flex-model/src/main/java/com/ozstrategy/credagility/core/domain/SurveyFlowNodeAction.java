package com.ozstrategy.credagility.core.domain;

import com.ozstrategy.credagility.core.domain.workflow.WorkflowNodeActionTriggerType;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * the supper class for SurveyFlow Node Action.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/16/2014 14:43
 */
@MappedSuperclass public abstract class SurveyFlowNodeAction<T> extends CreatorEntity implements Serializable,
  SurveyFlowNodeActionInterface {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -6759606547451945433L;

  /** action type. */
  public static final String CHANNEL_ACTION = "CHANNEL";

  /** action type. */
  public static final String PROGRAM_ACTION = "PROGRAM";

  /** action type. */
  public static final String RE_QUEUE_ACTION = "RE_QUEUE";

  /** action type. */
  public static final String FLOW_ACTION = "FLOW";

  /** action type. */
  public static final String REQUEUE_ACTION = "REQUEUE";

  /**  bureau import action type. */
  public static final String BUREAU_IMPORT_ACTION = "BUREAU_IMPORT";

  /**  data export action type. */
  public static final String DATA_EXPORT_ACTION = "DATA_EXPORT";

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** action type. */
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

  /** triggerType contains DAILY, ENTRY, EXIT, REAL_TIME. */
  @Column(
    length   = 32,
    nullable = false
  )
  @Enumerated(value = EnumType.STRING)
  protected WorkflowNodeActionTriggerType triggerType;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for node action.
   *
   * @return  T
   */
  public abstract T getNodeAction();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  nodeAction  DOCUMENT ME!
   */
  public abstract void setNodeAction(T nodeAction);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  copyFrom  DOCUMENT ME!
   */
  public void deepCopy(SurveyFlowNodeAction copyFrom) {
    setTriggerType(copyFrom.getTriggerType());
    setCriteria(copyFrom.getCriteria());
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

    SurveyFlowNodeAction that = (SurveyFlowNodeAction) o;

    if ((id != null) ? (!id.equals(that.id)) : (that.id != null)) {
      return false;
    }

    if (((criteria != null) ? (!criteria.equals(that.criteria)) : (that.criteria != null))) {
      return false;
    }

    if (((node != null) ? (!node.equals(that.node)) : (that.node != null))) {
      return false;
    }

    if (((getNodeAction() != null) ? (!getNodeAction().equals(that.getNodeAction()))
                                   : (that.getNodeAction() != null))) {
      return false;
    }

    if (((triggerType != null) ? (triggerType != that.triggerType) : (that.triggerType != null))) {
      return false;
    }

    return true;
  } // end method equals

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
    int result = (criteria != null) ? criteria.hashCode() : 0;
    result = (31 * result) + ((node != null) ? node.hashCode() : 0);
    result = (31 * result) + ((triggerType != null) ? triggerType.hashCode() : 0);
    result = (31 * result) + ((getNodeAction() != null) ? getNodeAction().hashCode() : 0);

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
   * setter method for trigger type.
   *
   * @param  triggerType  WorkflowNodeActionTriggerType
   */
  public void setTriggerType(WorkflowNodeActionTriggerType triggerType) {
    this.triggerType = triggerType;
  }


} // end class SurveyFlowNodeAction
