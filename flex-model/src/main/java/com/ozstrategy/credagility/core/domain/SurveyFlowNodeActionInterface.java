package com.ozstrategy.credagility.core.domain;


import com.ozstrategy.credagility.core.domain.workflow.WorkflowNodeActionTriggerType;


/**
 * Survey FlowNode Action Interface.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/16/2014 14:47
 */
public interface SurveyFlowNodeActionInterface {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for action name.
   *
   * @return  String
   */
  String getActionName();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for criteria.
   *
   * @return  String
   */
  String getCriteria();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for trigger type.
   *
   * @return  WorkflowNodeActionTriggerType
   */
  WorkflowNodeActionTriggerType getTriggerType();
} // end interface SurveyFlowNodeActionInterface
