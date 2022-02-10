package com.ozstrategy.credagility.core.domain.workflow.enterprise;

import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskGroupElement;
import com.ozstrategy.credagility.core.domain.workflow.enterprise.version.EnterpriseWorkflowTaskGroupElementVersion;

import javax.persistence.*;
import java.io.Serializable;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/17/2014 13:44
 */
@Entity
@Table(name = "EnterpriseWorkflowTaskGroupElement")
public class EnterpriseWorkflowTaskGroupElement extends BasicWorkflowTaskGroupElement implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 5754548746427529258L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** EnterpriseWorkflowTaskGroup. */
  @JoinColumn(
    name       = "groupId",
    updatable  = true,
    insertable = true,
    nullable   = false
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  protected EnterpriseWorkflowTaskGroup group;

  /** Id, PK. */
  @Column(
    unique   = true,
    nullable = false
  )
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;

  /** EnterpriseWorkflowTask. */
  @JoinColumn(
    name       = "taskId",
    updatable  = true,
    insertable = true,
    nullable   = false
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  protected EnterpriseWorkflowTask task;

  /** EnterpriseWorkflowTaskElement. */
  @JoinColumn(
    name       = "questionId",
    updatable  = true,
    insertable = true,
    nullable   = false
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  protected EnterpriseWorkflowTaskElement taskElement;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * duplicate.
   *
   * @param   task  EnterpriseWorkflowTask
   *
   * @return  EnterpriseWorkflowTaskGroupElement
   */
  public EnterpriseWorkflowTaskGroupElement duplicate(EnterpriseWorkflowTask task) {
    EnterpriseWorkflowTaskGroupElement groupElement = new EnterpriseWorkflowTaskGroupElement();
    groupElement.setDisplayOrder(displayOrder);
    groupElement.setTaskElement(taskElement);
    groupElement.setTask(task);

    return groupElement;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * duplicateVersion.
   *
   * @return  EnterpriseWorkflowTaskGroupElementVersion
   */
  public EnterpriseWorkflowTaskGroupElementVersion duplicateVersion() {
    EnterpriseWorkflowTaskGroupElementVersion groupElementVersion = new EnterpriseWorkflowTaskGroupElementVersion();
    groupElementVersion.setDisplayOrder(displayOrder);
    groupElementVersion.setTaskElement(taskElement);
    groupElementVersion.setGroupElementId(this.getId());

    return groupElementVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for group.
   *
   * @return  EnterpriseWorkflowTaskGroup
   */
  @Override public EnterpriseWorkflowTaskGroup getGroup() {
    return group;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for id.
   *
   * @return  Long
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for task.
   *
   * @return  EnterpriseWorkflowTask
   */
  @Override public EnterpriseWorkflowTask getTask() {
    return task;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for task element.
   *
   * @return  EnterpriseWorkflowTaskElement
   */
  @Override public EnterpriseWorkflowTaskElement getTaskElement() {
    return taskElement;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for group.
   *
   * @param  group  EnterpriseWorkflowTaskGroup
   */
  public void setGroup(EnterpriseWorkflowTaskGroup group) {
    this.group = group;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for id.
   *
   * @param  id  Long
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for task.
   *
   * @param  task  EnterpriseWorkflowTask
   */
  public void setTask(EnterpriseWorkflowTask task) {
    this.task = task;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for task element.
   *
   * @param  taskElement  EnterpriseWorkflowTaskElement
   */
  public void setTaskElement(EnterpriseWorkflowTaskElement taskElement) {
    this.taskElement = taskElement;
  }
} // end class EnterpriseWorkflowTaskGroupElement
