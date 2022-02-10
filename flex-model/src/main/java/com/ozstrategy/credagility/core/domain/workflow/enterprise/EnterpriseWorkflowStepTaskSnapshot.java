package com.ozstrategy.credagility.core.domain.workflow.enterprise;

import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowStepTaskSnapshot;
import com.ozstrategy.credagility.core.domain.workflow.enterprise.version.EnterpriseWorkflowTaskVersion;

import javax.persistence.*;
import java.io.Serializable;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/17/2014 12:31
 */
@Entity @Table public class EnterpriseWorkflowStepTaskSnapshot extends BasicWorkflowStepTaskSnapshot
  implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 2042955180752765712L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "taskId",
    nullable   = false,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseWorkflowTask enterpriseWorkflowTask;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "taskVersionId",
    nullable   = false,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseWorkflowTaskVersion enterpriseWorkflowTaskVersion;


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
   * Creates a new EnterpriseWorkflowStepTaskSnapshot object.
   */
  public EnterpriseWorkflowStepTaskSnapshot() { }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * EnterpriseWorkflowStepTaskSnapshot.
   *
   * @return  EnterpriseWorkflowStepTaskSnapshot.
   */
  public EnterpriseWorkflowStepTaskSnapshot copy() {
    EnterpriseWorkflowStepTaskSnapshot taskSnapshot = new EnterpriseWorkflowStepTaskSnapshot();
    taskSnapshot.setAgentIntroduction(this.getAgentIntroduction());
    taskSnapshot.setAgentPostText(this.getAgentPostText());
    taskSnapshot.setFlexStationNAText(this.getFlexStationNAText());
    taskSnapshot.setFlexStationNATitle(this.getFlexStationNATitle());
    taskSnapshot.setEnterpriseWorkflowTask(this.getEnterpriseWorkflowTask());
    taskSnapshot.setEnterpriseWorkflowTaskVersion(this.getEnterpriseWorkflowTaskVersion());

    return taskSnapshot;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * EnterpriseWorkflowTask.
   *
   * @return  EnterpriseWorkflowTask.
   */
  public EnterpriseWorkflowTask getEnterpriseWorkflowTask() {
    return enterpriseWorkflowTask;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * EnterpriseWorkflowTaskVersion.
   *
   * @return  EnterpriseWorkflowTaskVersion.
   */
  public EnterpriseWorkflowTaskVersion getEnterpriseWorkflowTaskVersion() {
    return enterpriseWorkflowTaskVersion;
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
   * setEnterpriseWorkflowTask.
   *
   * @param  enterpriseWorkflowTask  $param.type$
   */
  public void setEnterpriseWorkflowTask(EnterpriseWorkflowTask enterpriseWorkflowTask) {
    this.enterpriseWorkflowTask = enterpriseWorkflowTask;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setEnterpriseWorkflowTaskVersion.
   *
   * @param  enterpriseWorkflowTaskVersion  $param.type$
   */
  public void setEnterpriseWorkflowTaskVersion(EnterpriseWorkflowTaskVersion enterpriseWorkflowTaskVersion) {
    this.enterpriseWorkflowTaskVersion = enterpriseWorkflowTaskVersion;
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
} // end class EnterpriseWorkflowStepTaskSnapshot
