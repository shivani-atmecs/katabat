package com.ozstrategy.credagility.core.domain.workflow.enterprise;

import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowAuditTaskElement;

import javax.persistence.*;
import java.io.Serializable;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/17/2014 11:32
 */
@Entity
@Table(name = "EnterpriseWorkflowAuditTaskElement")
public class EnterpriseWorkflowAuditTaskElement extends BasicWorkflowAuditTaskElement implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 8760681952137597105L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "taskId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseWorkflowTask task;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "taskElementId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseWorkflowTaskElement taskElement;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "taskElementAnswerId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected WorkflowTaskElementAnswer taskElementAnswer;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "workflowAuditStepId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected WorkflowAuditStep workflowAuditStep;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * copy.
   *
   * @param  auditTaskElement  $param.type$
   */
  public void copy(EnterpriseWorkflowAuditTaskElement auditTaskElement) {
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

    EnterpriseWorkflowAuditTaskElement that = (EnterpriseWorkflowAuditTaskElement) o;

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
   * Long.
   *
   * @return  Long.
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * EnterpriseWorkflowTask.
   *
   * @return  EnterpriseWorkflowTask.
   */
  public EnterpriseWorkflowTask getTask() {
    return task;
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
   * WorkflowTaskElementAnswer.
   *
   * @return  WorkflowTaskElementAnswer.
   */
  public WorkflowTaskElementAnswer getTaskElementAnswer() {
    return taskElementAnswer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * WorkflowAuditStep.
   *
   * @return  WorkflowAuditStep.
   */
  public WorkflowAuditStep getWorkflowAuditStep() {
    return workflowAuditStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((taskElement != null) ? taskElement.hashCode() : 0);
    result = (31 * result) + ((taskElementAnswer != null) ? taskElementAnswer.hashCode() : 0);
    result = (31 * result) + ((workflowAuditStep != null) ? workflowAuditStep.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setId.
   *
   * @param  id  $param.type$
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setTask.
   *
   * @param  task  $param.type$
   */
  public void setTask(EnterpriseWorkflowTask task) {
    this.task = task;
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
   * setTaskElementAnswer.
   *
   * @param  taskElementAnswer  $param.type$
   */
  public void setTaskElementAnswer(WorkflowTaskElementAnswer taskElementAnswer) {
    this.taskElementAnswer = taskElementAnswer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setWorkflowAuditStep.
   *
   * @param  workflowAuditStep  $param.type$
   */
  public void setWorkflowAuditStep(WorkflowAuditStep workflowAuditStep) {
    this.workflowAuditStep = workflowAuditStep;
  }

} // end class EnterpriseWorkflowAuditTaskElement
