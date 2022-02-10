package com.ozstrategy.credagility.exceptions;

import com.ozstrategy.credagility.core.domain.SurveyFlowStep;
import com.ozstrategy.credagility.core.domain.workflow.bci.BCIWorkflowStep;
import com.ozstrategy.credagility.core.domain.workflow.enterprise.WorkflowStep;


/**
 * This exception means the user do not have access to visit this workflow step.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  11/25/2014 12:29 PM
 */

public class WorkflowStepNoAccessException extends RuntimeException {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  private SurveyFlowStep flowStep;

  private WorkflowStep step;

  private String text;
  private String title;
  private Long   workflowId;
  private Long   workflowInstanceId;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  title  DOCUMENT ME!
   * @param  text   DOCUMENT ME!
   */

  public WorkflowStepNoAccessException(String title, String text) {
    super("{Title:" + title + ", Text:" + text + "}");
    this.title = title;
    this.text  = text;
  }

  /**
   * Creates a new WorkflowStepNoAccessException object.
   *
   * @param  title               DOCUMENT ME!
   * @param  text                DOCUMENT ME!
   * @param  step                DOCUMENT ME!
   * @param  workflowInstanceId  DOCUMENT ME!
   * @param  workflowId          DOCUMENT ME!
   */
  public WorkflowStepNoAccessException(String title, String text, WorkflowStep step, Long workflowInstanceId,
    Long workflowId) {
    super("{Title:" + title + ", Text:" + text + "}");
    this.title              = title;
    this.text               = text;
    this.step               = step;
    this.workflowInstanceId = workflowInstanceId;
    this.workflowId         = workflowId;
  }

  /**
   * Creates a new WorkflowStepNoAccessException object.
   *
   * @param  title               DOCUMENT ME!
   * @param  text                DOCUMENT ME!
   * @param  step                DOCUMENT ME!
   * @param  workflowInstanceId  DOCUMENT ME!
   * @param  workflowId          DOCUMENT ME!
   */
  public WorkflowStepNoAccessException(String title, String text, BCIWorkflowStep step, Long workflowInstanceId,
    Long workflowId) {
    super("{Title:" + title + ", Text:" + text + "}");
    this.title = title;
    this.text  = text;
// this.step               = step;
    this.workflowInstanceId = workflowInstanceId;
    this.workflowId         = workflowId;
  }

  /**
   * Creates a new WorkflowStepNoAccessException object.
   *
   * @param  title               DOCUMENT ME!
   * @param  text                DOCUMENT ME!
   * @param  flowStep            DOCUMENT ME!
   * @param  workflowInstanceId  DOCUMENT ME!
   * @param  workflowId          DOCUMENT ME!
   */
  public WorkflowStepNoAccessException(String title, String text, SurveyFlowStep flowStep, Long workflowInstanceId,
    Long workflowId) {
    super("{Title:" + title + ", Text:" + text + "}");
    this.title              = title;
    this.text               = text;
    this.flowStep           = flowStep;
    this.workflowInstanceId = workflowInstanceId;
    this.workflowId         = workflowId;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public SurveyFlowStep getFlowStep() {
    return flowStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public WorkflowStep getStep() {
    return step;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getText() {
    return text;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTitle() {
    return title;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getWorkflowId() {
    return workflowId;
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
   * @param  flowStep  DOCUMENT ME!
   */
  public void setFlowStep(SurveyFlowStep flowStep) {
    this.flowStep = flowStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  step  DOCUMENT ME!
   */
  public void setStep(WorkflowStep step) {
    this.step = step;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  text  DOCUMENT ME!
   */
  public void setText(String text) {
    this.text = text;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  title  DOCUMENT ME!
   */
  public void setTitle(String title) {
    this.title = title;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  workflowId  DOCUMENT ME!
   */
  public void setWorkflowId(Long workflowId) {
    this.workflowId = workflowId;
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
} // end class WorkflowStepNoAccessException
