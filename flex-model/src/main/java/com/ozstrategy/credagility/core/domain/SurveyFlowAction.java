package com.ozstrategy.credagility.core.domain;

import com.ozstrategy.credagility.core.domain.workflow.WorkflowNodeActionInterface;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowNodeActionTriggerType;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * The supper class for action!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/16/2014 10:20
 */
@MappedSuperclass public abstract class SurveyFlowAction<T> extends CreatorEntity implements Serializable,
  WorkflowNodeActionInterface {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 2425362267184351723L;


  /** Action type. */
  public static final String CHANNEL_ACTION = "CHANNEL";


  /** Action type. */
  public static final String PROGRAM_ACTION = "PROGRAM";


  /** Action type. */
  public static final String RE_QUEUE_ACTION = "RE_QUEUE";


  /** Action type. */
  public static final String FLOW_ACTION = "FLOW";
  
  /** Action type. */
  public static final String REQUEUE_ACTION = "REQUEUE";

  /** Action type. */
  public static final String BUREAU_IMPORT_ACTION = "BUREAU_IMPORT";

  /** Action type. */
  public static final String DATA_EXPORT_ACTION = "DATA_EXPORT";


  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** The trigger action condition. */
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


  /** trigger Type. */
  @Column(
    length   = 32,
    nullable = false
  )
  @Enumerated(value = EnumType.STRING)
  protected WorkflowNodeActionTriggerType triggerType;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for flow action.
   *
   * @return  T
   */
  public abstract T getFlowAction();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for flow action.
   *
   * @param  flowAction  T
   */
  public abstract void setFlowAction(T flowAction);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * deepCopy.
   *
   * @param  copyFrom  SurveyFlowAction
   */
  public void deepCopy(SurveyFlowAction copyFrom) {
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

    SurveyFlowAction that = (SurveyFlowAction) o;

    if ((id != null) ? (!id.equals(that.id)) : (that.id != null)) {
      return false;
    }

    if (((criteria != null) ? (!criteria.equals(that.criteria)) : (that.criteria != null))) {
      return false;
    }

    if (((flow != null) ? (!flow.equals(that.flow)) : (that.flow != null))) {
      return false;
    }

    if (((getFlowAction() != null) ? (!getFlowAction().equals(that.getFlowAction()))
                                   : (that.getFlowAction() != null))) {
      return false;
    }

    if (((triggerType != null) ? (triggerType != that.triggerType) : (that.triggerType != null))) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowNodeActionInterface#getCriteria()
   */
  @Override public String getCriteria() {
    return criteria;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for flow.
   *
   * @return  SurveyFlow
   */
  public SurveyFlow getFlow() {
    return flow;
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
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowNodeActionInterface#getTriggerType()
   */
  @Override public WorkflowNodeActionTriggerType getTriggerType() {
    return triggerType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = (criteria != null) ? criteria.hashCode() : 0;
    result = (31 * result) + ((flow != null) ? flow.hashCode() : 0);
    result = (31 * result) + ((triggerType != null) ? triggerType.hashCode() : 0);
    result = (31 * result) + ((getFlowAction() != null) ? getFlowAction().hashCode() : 0);

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
   * setter method for trigger type.
   *
   * @param  triggerType  WorkflowNodeActionTriggerType
   */
  public void setTriggerType(WorkflowNodeActionTriggerType triggerType) {
    this.triggerType = triggerType;
  }
} // end class SurveyFlowAction
