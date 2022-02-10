package com.ozstrategy.credagility.core.domain.workflow.bci;

import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowAuditTaskElement;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Created with IntelliJ IDEA.
 *
 * <p>: Wang Yang : 11/18/13 : 2:56 PM</p>
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(name = "BCIWorkflowAuditTaskElement")
public class BCIWorkflowAuditTaskElement extends BasicWorkflowAuditTaskElement implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -2123303343179974880L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;

  /** BCWorkflowTask PK taskId. */
  @JoinColumn(
    name       = "taskId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCWorkflowTask task;

  /** BCWorkflowTaskElement PK taskElementId. */
  @JoinColumn(
    name       = "taskElementId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCWorkflowTaskElement taskElement;

  /** BCIWorkflowTaskElementAnswer PK taskElementAnswerId. */
  @JoinColumn(
    name       = "taskElementAnswerId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCIWorkflowTaskElementAnswer taskElementAnswer;

  /** BCIWorkflowAuditStep PK workflowAuditStepId. */
  @JoinColumn(
    name       = "workflowAuditStepId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCIWorkflowAuditStep workflowAuditStep;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  auditTaskElement  DOCUMENT ME!
   */
  public void copy(BCIWorkflowAuditTaskElement auditTaskElement) {
    super.copy(auditTaskElement);
    this.setTask(auditTaskElement.getTask());
    this.setTaskElement(auditTaskElement.getTaskElement());
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

    if (!super.equals(o)) {
      return false;
    }

    BCIWorkflowAuditTaskElement that = (BCIWorkflowAuditTaskElement) o;

    if ((task != null) ? (!task.equals(that.task)) : (that.task != null)) {
      return false;
    }

    if ((taskElement != null) ? (!taskElement.equals(that.taskElement)) : (that.taskElement != null)) {
      return false;
    }

    if ((taskElementAnswer != null) ? (!taskElementAnswer.equals(that.taskElementAnswer))
                                    : (that.taskElementAnswer != null)) {
      return false;
    }

    if ((workflowAuditStep != null) ? (!workflowAuditStep.equals(that.workflowAuditStep))
                                    : (that.workflowAuditStep != null)) {
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
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BCWorkflowTask getTask() {
    return task;
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
  public BCIWorkflowTaskElementAnswer getTaskElementAnswer() {
    return taskElementAnswer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BCIWorkflowAuditStep getWorkflowAuditStep() {
    return workflowAuditStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowAuditTaskElement#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((task != null) ? task.hashCode() : 0);
    result = (31 * result) + ((taskElement != null) ? taskElement.hashCode() : 0);
    result = (31 * result) + ((taskElementAnswer != null) ? taskElementAnswer.hashCode() : 0);
    result = (31 * result) + ((workflowAuditStep != null) ? workflowAuditStep.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  id  DOCUMENT ME!
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  task  DOCUMENT ME!
   */
  public void setTask(BCWorkflowTask task) {
    this.task = task;
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
   * @param  taskElementAnswer  DOCUMENT ME!
   */
  public void setTaskElementAnswer(BCIWorkflowTaskElementAnswer taskElementAnswer) {
    this.taskElementAnswer = taskElementAnswer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  workflowAuditStep  DOCUMENT ME!
   */
  public void setWorkflowAuditStep(BCIWorkflowAuditStep workflowAuditStep) {
    this.workflowAuditStep = workflowAuditStep;
  }
} // end class BCIWorkflowAuditTaskElement
