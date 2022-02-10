package com.ozstrategy.credagility.core.domain.workflow.customer;


import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowStepTaskElementSnapshot;
import com.ozstrategy.credagility.core.domain.workflow.customer.version.CustomerWorkflowTaskElementVersion;
import com.ozstrategy.credagility.core.domain.workflow.customer.version.CustomerWorkflowTaskVersion;

import javax.persistence.*;
import java.io.Serializable;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  04/10/2017 11:24
 */
@Entity
@Table(name = "CustomerWorkflowStepTaskElementSnapshot")
public class CustomerWorkflowStepTaskElementSnapshot extends BasicWorkflowStepTaskElementSnapshot
  implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 6630102978251867014L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  @JoinColumn(
    name       = "taskElementId",
    nullable   = false,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CustomerWorkflowTaskElement taskElement;

  /** DOCUMENT ME! */
  @JoinColumn(
    name       = "taskElementVersionId",
    nullable   = false,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CustomerWorkflowTaskElementVersion taskElementVersion;

  /** DOCUMENT ME! */
  @JoinColumn(
    name       = "taskVersionId",
    nullable   = true,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CustomerWorkflowTaskVersion taskVersion;

  /** DOCUMENT ME! */
  @JoinColumn(
    name       = "stepId",
    nullable   = false,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CustomerWorkflowStep workflowStep;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public CustomerWorkflowStepTaskElementSnapshot copy() {
    CustomerWorkflowStepTaskElementSnapshot elementSnapshot = new CustomerWorkflowStepTaskElementSnapshot();
    elementSnapshot.setTaskElementVersion(this.getTaskElementVersion());
    elementSnapshot.setTaskElement(this.getTaskElement());
    elementSnapshot.setQuestionText(this.getQuestionText());
    elementSnapshot.setQuestionText2(this.getQuestionText2());
    elementSnapshot.setTaskVersion(this.getTaskVersion());

    return elementSnapshot;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public CustomerWorkflowTaskElement getTaskElement() {
    return taskElement;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public CustomerWorkflowTaskElementVersion getTaskElementVersion() {
    return taskElementVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public CustomerWorkflowTaskVersion getTaskVersion() {
    return taskVersion;
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
   * @param  taskElement  DOCUMENT ME!
   */
  public void setTaskElement(CustomerWorkflowTaskElement taskElement) {
    this.taskElement = taskElement;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  taskElementVersion  DOCUMENT ME!
   */
  public void setTaskElementVersion(CustomerWorkflowTaskElementVersion taskElementVersion) {
    this.taskElementVersion = taskElementVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  taskVersion  DOCUMENT ME!
   */
  public void setTaskVersion(CustomerWorkflowTaskVersion taskVersion) {
    this.taskVersion = taskVersion;
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
} // end class CustomerWorkflowStepTaskElementSnapshot
