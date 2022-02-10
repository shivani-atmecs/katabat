package com.ozstrategy.credagility.core.domain.workflow.customer;

import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowStepTaskSnapshot;
import com.ozstrategy.credagility.core.domain.workflow.customer.version.CustomerWorkflowTaskVersion;

import javax.persistence.*;
import java.io.Serializable;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  04/10/2017 11:25
 */
@Entity
@Table(name = "CustomerWorkflowStepTaskSnapshot")
public class CustomerWorkflowStepTaskSnapshot extends BasicWorkflowStepTaskSnapshot implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 7452625579288300998L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  @JoinColumn(
    name       = "stepId",
    nullable   = false,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CustomerWorkflowStep workflowStep;


  /** DOCUMENT ME! */
  @JoinColumn(
    name       = "taskId",
    nullable   = false,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CustomerWorkflowTask workflowTask;

  /** DOCUMENT ME! */
  @JoinColumn(
    name       = "taskVersionId",
    nullable   = false,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CustomerWorkflowTaskVersion workflowTaskVersion;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public CustomerWorkflowStepTaskSnapshot copy() {
    CustomerWorkflowStepTaskSnapshot taskSnapshot = new CustomerWorkflowStepTaskSnapshot();
    taskSnapshot.setAgentIntroduction(this.getAgentIntroduction());
    taskSnapshot.setAgentPostText(this.getAgentPostText());
    taskSnapshot.setFlexStationNAText(this.getFlexStationNAText());
    taskSnapshot.setFlexStationNATitle(this.getFlexStationNATitle());
    taskSnapshot.setWorkflowTask(this.getWorkflowTask());
    taskSnapshot.setWorkflowTaskVersion(this.getWorkflowTaskVersion());

    return taskSnapshot;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public CustomerWorkflowStep getWorkflowStep() {
    return workflowStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public CustomerWorkflowTask getWorkflowTask() {
    return workflowTask;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public CustomerWorkflowTaskVersion getWorkflowTaskVersion() {
    return workflowTaskVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  workflowStep  DOCUMENT ME!
   */
  public void setWorkflowStep(CustomerWorkflowStep workflowStep) {
    this.workflowStep = workflowStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  workflowTask  DOCUMENT ME!
   */
  public void setWorkflowTask(CustomerWorkflowTask workflowTask) {
    this.workflowTask = workflowTask;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  workflowTaskVersion  DOCUMENT ME!
   */
  public void setWorkflowTaskVersion(CustomerWorkflowTaskVersion workflowTaskVersion) {
    this.workflowTaskVersion = workflowTaskVersion;
  }
} // end class CustomerWorkflowStepTaskSnapshot
