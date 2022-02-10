package com.ozstrategy.credagility.core.domain.workflow.bci;

import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowStepTaskElementSnapshot;
import com.ozstrategy.credagility.core.domain.workflow.bci.version.BCWorkflowTaskElementVersion;
import com.ozstrategy.credagility.core.domain.workflow.bci.version.BCWorkflowTaskVersion;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Created with IntelliJ IDEA. User: yongliu Date: 12/5/13 Time: 11:51 AM To change this template use File | Settings |
 * File Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(name = "BCIWorkflowStepTaskElementSnapshot")
public class BCIWorkflowStepTaskElementSnapshot extends BasicWorkflowStepTaskElementSnapshot implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -4152687318233913769L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** BCWorkflowTaskElement PK taskElementId. */
  @JoinColumn(
    name       = "taskElementId",
    nullable   = false,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCWorkflowTaskElement taskElement;

  /** BCWorkflowTaskElementVersion PK taskElementVersionId. */
  @JoinColumn(
    name       = "taskElementVersionId",
    nullable   = false,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCWorkflowTaskElementVersion taskElementVersion;

  /** BCWorkflowTaskVersion PK taskVersionId. */
  @JoinColumn(
    name       = "taskVersionId",
    nullable   = true,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCWorkflowTaskVersion taskVersion;

  /** BCIWorkflowStep PK setepId. */
  @JoinColumn(
    name       = "stepId",
    nullable   = false,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCIWorkflowStep workflowStep;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BCIWorkflowStepTaskElementSnapshot copy() {
    BCIWorkflowStepTaskElementSnapshot elementSnapshot = new BCIWorkflowStepTaskElementSnapshot();
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
  public BCWorkflowTaskElement getTaskElement() {
    return taskElement;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BCWorkflowTaskElementVersion getTaskElementVersion() {
    return taskElementVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BCWorkflowTaskVersion getTaskVersion() {
    return taskVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BCIWorkflowStep getWorkflowStep() {
    return workflowStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  taskElement  DOCUMENT ME!
   */
  public void setTaskElement(BCWorkflowTaskElement taskElement) {
    this.taskElement = taskElement;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  taskElementVersion  DOCUMENT ME!
   */
  public void setTaskElementVersion(BCWorkflowTaskElementVersion taskElementVersion) {
    this.taskElementVersion = taskElementVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  taskVersion  DOCUMENT ME!
   */
  public void setTaskVersion(BCWorkflowTaskVersion taskVersion) {
    this.taskVersion = taskVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  workflowStep  DOCUMENT ME!
   */
  public void setWorkflowStep(BCIWorkflowStep workflowStep) {
    this.workflowStep = workflowStep;
  }
} // end class BCIWorkflowStepTaskElementSnapshot
