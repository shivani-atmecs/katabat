package com.ozstrategy.credagility.core.domain.workflow.customer;

import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskGroupElement;
import com.ozstrategy.credagility.core.domain.workflow.customer.version.CustomerWorkflowTaskGroupElementVersion;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.io.Serializable;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:wei.tang@ozstrategy.com">Wei Tang</a>
 * @version  06/27/2017 17:04
 */
@Entity
@Table(name = "CustomerWorkflowTaskGroupElement")
public class CustomerWorkflowTaskGroupElement extends BasicWorkflowTaskGroupElement implements Serializable {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** CustomerWorkflowTaskGroup. */
  @Cascade(CascadeType.SAVE_UPDATE)
  @JoinColumn(
    name       = "groupId",
    updatable  = true,
    insertable = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CustomerWorkflowTaskGroup group;

  /** Id, PK. */
  @Column(
    unique   = true,
    nullable = false
  )
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;

  /** CustomerWorkflowTask. */
  @Cascade(CascadeType.SAVE_UPDATE)
  @JoinColumn(
    name       = "taskId",
    updatable  = true,
    insertable = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CustomerWorkflowTask task;

  /** CustomerWorkflowTaskElement. */
  @Cascade(CascadeType.SAVE_UPDATE)
  @JoinColumn(
    name       = "questionId",
    updatable  = true,
    insertable = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CustomerWorkflowTaskElement taskElement;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   task  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public CustomerWorkflowTaskGroupElement duplicate(CustomerWorkflowTask task) {
    CustomerWorkflowTaskGroupElement groupElement = new CustomerWorkflowTaskGroupElement();
    groupElement.setDisplayOrder(displayOrder);
    groupElement.setTaskElement(taskElement);
    groupElement.setTask(task);

    return groupElement;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public CustomerWorkflowTaskGroupElementVersion duplicateVersion() {
    CustomerWorkflowTaskGroupElementVersion groupElementVersion = new CustomerWorkflowTaskGroupElementVersion();
    groupElementVersion.setDisplayOrder(displayOrder);
    groupElementVersion.setTaskElement(taskElement);
    groupElementVersion.setGroupElementId(this.getId());

    return groupElementVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskGroupElement#getGroup()
   */
  @Override public CustomerWorkflowTaskGroup getGroup() {
    return group;
  }

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
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskGroupElement#getTask()
   */
  @Override public CustomerWorkflowTask getTask() {
    return task;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskGroupElement#getTaskElement()
   */
  @Override public CustomerWorkflowTaskElement getTaskElement() {
    return taskElement;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  group  DOCUMENT ME!
   */
  public void setGroup(CustomerWorkflowTaskGroup group) {
    this.group = group;
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
  public void setTask(CustomerWorkflowTask task) {
    this.task = task;
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
} // end class CustomerWorkflowTaskGroupElement
