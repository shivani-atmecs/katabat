package com.ozstrategy.credagility.core.domain.workflow.enterprise;

import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowStepTaskElementSnapshot;
import com.ozstrategy.credagility.core.domain.workflow.enterprise.version.EnterpriseWorkflowTaskElementVersion;
import com.ozstrategy.credagility.core.domain.workflow.enterprise.version.EnterpriseWorkflowTaskVersion;

import javax.persistence.*;
import java.io.Serializable;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/17/2014 12:30
 */
@Entity @Table public class EnterpriseWorkflowStepTaskElementSnapshot extends BasicWorkflowStepTaskElementSnapshot
  implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 4148159291593717591L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "taskElementId",
    nullable   = false,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseWorkflowTaskElement taskElement;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "taskElementVersionId",
    nullable   = false,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseWorkflowTaskElementVersion taskElementVersion;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "taskVersionId",
    nullable   = true,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseWorkflowTaskVersion taskVersion;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "stepId",
    nullable   = false,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected WorkflowStep workflowStep;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new EnterpriseWorkflowStepTaskElementSnapshot object.
   */
  public EnterpriseWorkflowStepTaskElementSnapshot() { }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * EnterpriseWorkflowStepTaskElementSnapshot.
   *
   * @return  EnterpriseWorkflowStepTaskElementSnapshot.
   */
  public EnterpriseWorkflowStepTaskElementSnapshot copy() {
    EnterpriseWorkflowStepTaskElementSnapshot elementSnapshot = new EnterpriseWorkflowStepTaskElementSnapshot();
    elementSnapshot.setTaskElementVersion(this.getTaskElementVersion());
    elementSnapshot.setTaskElement(this.getTaskElement());
    elementSnapshot.setQuestionText(this.getQuestionText());
    elementSnapshot.setQuestionText2(this.getQuestionText2());
    elementSnapshot.setTaskVersion(this.getTaskVersion());

    return elementSnapshot;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * EnterpriseWorkflowTaskElement.
   *
   * @return  EnterpriseWorkflowTaskElement.
   */
  public EnterpriseWorkflowTaskElement getTaskElement() {
    return taskElement;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * EnterpriseWorkflowTaskElementVersion.
   *
   * @return  EnterpriseWorkflowTaskElementVersion.
   */
  public EnterpriseWorkflowTaskElementVersion getTaskElementVersion() {
    return taskElementVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * EnterpriseWorkflowTaskVersion.
   *
   * @return  EnterpriseWorkflowTaskVersion.
   */
  public EnterpriseWorkflowTaskVersion getTaskVersion() {
    return taskVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * WorkflowStep.
   *
   * @return  WorkflowStep.
   */
  public WorkflowStep getWorkflowStep() {
    return workflowStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setTaskElement.
   *
   * @param  taskElement  $param.type$
   */
  public void setTaskElement(EnterpriseWorkflowTaskElement taskElement) {
    this.taskElement = taskElement;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setTaskElementVersion.
   *
   * @param  taskElementVersion  $param.type$
   */
  public void setTaskElementVersion(EnterpriseWorkflowTaskElementVersion taskElementVersion) {
    this.taskElementVersion = taskElementVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setTaskVersion.
   *
   * @param  taskVersion  $param.type$
   */
  public void setTaskVersion(EnterpriseWorkflowTaskVersion taskVersion) {
    this.taskVersion = taskVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setWorkflowStep.
   *
   * @param  workflowStep  $param.type$
   */
  public void setWorkflowStep(WorkflowStep workflowStep) {
    this.workflowStep = workflowStep;
  }
} // end class EnterpriseWorkflowStepTaskElementSnapshot
