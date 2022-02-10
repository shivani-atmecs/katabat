package com.ozstrategy.credagility.core.domain.workflow.basic;

import com.ozstrategy.credagility.core.domain.BasicMetaData;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowNodeActionTriggerType;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;


/**
 * Created with IntelliJ IDEA.
 *
 * <p>: Wang Yang : 11/19/13 : 3:31 PM</p>
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@MappedSuperclass public abstract class BasicWorkflowVariableValue extends BasicMetaData implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 1279074946824005491L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Workflow instance id PK WorkflowInstance. */
  @Column(nullable = true)
  public Long workflowInstanceId;

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowNodeActionTriggerType
   */
  @Column(length = 32)
  @Enumerated(value = EnumType.STRING)
  protected WorkflowNodeActionTriggerType triggerType;

  /** Ref WorkflowStep. */
  @Column(name = "workflowStepId")
  protected Long workflowStepId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public abstract WorkflowBusinessObject createBusinessObject();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  businessObject  DOCUMENT ME!
   */
  public abstract void setBusinessObject(Object businessObject);

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

    BasicWorkflowVariableValue that = (BasicWorkflowVariableValue) o;

    if (triggerType != that.triggerType) {
      return false;
    }

    if ((workflowInstanceId != null) ? (!workflowInstanceId.equals(that.workflowInstanceId))
                                     : (that.workflowInstanceId != null)) {
      return false;
    }

    if ((workflowStepId != null) ? (!workflowStepId.equals(that.workflowStepId)) : (that.workflowStepId != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public WorkflowNodeActionTriggerType getTriggerType() {
    return triggerType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getWorkflowInstanceId() {
    return workflowInstanceId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getWorkflowStepId() {
    return workflowStepId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((workflowInstanceId != null) ? workflowInstanceId.hashCode() : 0);
    result = (31 * result) + ((triggerType != null) ? triggerType.hashCode() : 0);
    result = (31 * result) + ((workflowStepId != null) ? workflowStepId.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  triggerType  DOCUMENT ME!
   */
  public void setTriggerType(WorkflowNodeActionTriggerType triggerType) {
    this.triggerType = triggerType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  workflowInstanceId  DOCUMENT ME!
   */
  public void setWorkflowInstanceId(Long workflowInstanceId) {
    this.workflowInstanceId = workflowInstanceId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  workflowStepId  DOCUMENT ME!
   */
  public void setWorkflowStepId(Long workflowStepId) {
    this.workflowStepId = workflowStepId;
  }
} // end class BasicWorkflowVariableValue
