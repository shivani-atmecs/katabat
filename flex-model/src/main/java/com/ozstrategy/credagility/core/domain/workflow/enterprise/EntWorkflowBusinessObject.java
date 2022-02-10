package com.ozstrategy.credagility.core.domain.workflow.enterprise;


import com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/17/2014 13:49
 */
public abstract class EntWorkflowBusinessObject extends WorkflowBusinessObject {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * createWorkflowAuditInstance.
   *
   * @return  WorkflowAuditInstance
   */
  @Override public abstract WorkflowAuditInstance createWorkflowAuditInstance();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * createWorkflowAuditStep.
   *
   * @return  WorkflowAuditStep
   */
  @Override public abstract WorkflowAuditStep createWorkflowAuditStep();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * createWorkflowInstance.
   *
   * @return  WorkflowInstance
   */
  @Override public abstract WorkflowInstance createWorkflowInstance();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * createWorkflowSchedule.
   *
   * @return  WorkflowSchedule
   */
  @Override public abstract WorkflowSchedule createWorkflowSchedule();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * createWorkflowStep.
   *
   * @return  WorkflowStep
   */
  @Override public abstract WorkflowStep createWorkflowStep();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * createWorkflowTaskElementAnswer.
   *
   * @return  WorkflowTaskElementAnswer
   */
  @Override public abstract WorkflowTaskElementAnswer createWorkflowTaskElementAnswer();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * createWorkflowTaskElementTempAnswer.
   *
   * @return  WorkflowTaskElementTempAnswer
   */
  @Override public abstract WorkflowTaskElementTempAnswer createWorkflowTaskElementTempAnswer();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * createWorkflowVariableValue.
   *
   * @return  WorkflowVariableValue
   */
  @Override public abstract WorkflowVariableValue createWorkflowVariableValue();
} // end class EntWorkflowBusinessObject
