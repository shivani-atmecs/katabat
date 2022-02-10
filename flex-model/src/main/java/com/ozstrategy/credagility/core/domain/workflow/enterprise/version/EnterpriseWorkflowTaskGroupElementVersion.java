package com.ozstrategy.credagility.core.domain.workflow.enterprise.version;

import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTask;
import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskGroup;
import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskGroupElement;
import com.ozstrategy.credagility.core.domain.workflow.enterprise.EnterpriseWorkflowTask;
import com.ozstrategy.credagility.core.domain.workflow.enterprise.EnterpriseWorkflowTaskElement;
import com.ozstrategy.credagility.core.domain.workflow.enterprise.EnterpriseWorkflowTaskGroupElement;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Enterprise Workflow TaskGroupElement Version.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/17/2014 11:03
 */
@Entity
@Table(name = "EnterpriseWorkflowTaskGroupElementVersion")
public class EnterpriseWorkflowTaskGroupElementVersion extends BasicWorkflowTaskGroupElement implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -3860186028379910039L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** EnterpriseWorkflowTaskGroup Version. */
  @JoinColumn(
    name       = "groupId",
    updatable  = true,
    insertable = true,
    nullable   = false
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = { CascadeType.PERSIST, CascadeType.MERGE }
  )
  protected EnterpriseWorkflowTaskGroupVersion group;

  /** groupElementId. */
  @Column(
    name       = "groupElementId",
    updatable  = false,
    insertable = true,
    nullable   = false
  )
  protected Long groupElementId;

  /** Id, PK. */
  @Column(
    unique   = true,
    nullable = false
  )
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;

  /** taskElement. */
  @JoinColumn(
    name       = "questionId",
    updatable  = true,
    insertable = true,
    nullable   = false
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = { CascadeType.PERSIST, CascadeType.MERGE }
  )
  protected EnterpriseWorkflowTaskElement taskElement;

  /** EnterpriseWorkflowTask. */
  @JoinColumn(
    name       = "taskId",
    updatable  = true,
    insertable = true,
    nullable   = false
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = { CascadeType.PERSIST, CascadeType.MERGE }
  )
  protected EnterpriseWorkflowTaskVersion taskVersion;


  /** version. */
  protected Integer version = 1;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * duplicate.
   *
   * @param   task  EnterpriseWorkflowTaskVersion
   *
   * @return  EnterpriseWorkflowTaskGroupElementVersion
   */
  public EnterpriseWorkflowTaskGroupElementVersion duplicate(EnterpriseWorkflowTaskVersion task) {
    EnterpriseWorkflowTaskGroupElementVersion groupElement = new EnterpriseWorkflowTaskGroupElementVersion();
    groupElement.setDisplayOrder(displayOrder);
    groupElement.setTaskElement(taskElement);
    groupElement.setTaskVersion(task);
    groupElement.setGroupElementId(this.getGroupElementId());
    groupElement.setGroup((EnterpriseWorkflowTaskGroupVersion) this.getGroup());

    return groupElement;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

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
   * @see  Object#equals(Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof EnterpriseWorkflowTaskGroupElementVersion)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    EnterpriseWorkflowTaskGroupElementVersion that = (EnterpriseWorkflowTaskGroupElementVersion) o;

    if ((version != null) ? (!version.equals(that.version)) : (that.version != null)) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskGroupElement#getGroup()
   */
  @Override public BasicWorkflowTaskGroup getGroup() {
    return group;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for group element id.
   *
   * @return  Long
   */
  public Long getGroupElementId() {
    return groupElementId;
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
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskGroupElement#getTask()
   */
  @Override public BasicWorkflowTask getTask() {
    return taskVersion; // To change body of implemented methods use File | Settings | File Templates.
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskGroupElement#getTaskElement()
   */
  @Override public EnterpriseWorkflowTaskElement getTaskElement() {
    return taskElement;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for task version.
   *
   * @return  EnterpriseWorkflowTaskVersion
   */
  public EnterpriseWorkflowTaskVersion getTaskVersion() {
    return taskVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for version.
   *
   * @return  Integer
   */
  public Integer getVersion() {
    return version;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((version != null) ? version.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for group.
   *
   * @param  group  EnterpriseWorkflowTaskGroupVersion
   */
  public void setGroup(EnterpriseWorkflowTaskGroupVersion group) {
    this.group = group;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for group element id.
   *
   * @param  groupElementId  Long
   */
  public void setGroupElementId(Long groupElementId) {
    this.groupElementId = groupElementId;
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
   * setter method for task element.
   *
   * @param  taskElement  EnterpriseWorkflowTaskElement
   */
  public void setTaskElement(EnterpriseWorkflowTaskElement taskElement) {
    this.taskElement = taskElement;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for task version.
   *
   * @param  taskVersion  EnterpriseWorkflowTaskVersion
   */
  public void setTaskVersion(EnterpriseWorkflowTaskVersion taskVersion) {
    this.taskVersion = taskVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for version.
   *
   * @param  version  Integer
   */
  public void setVersion(Integer version) {
    this.version = version;
  }
} // end class EnterpriseWorkflowTaskGroupElementVersion
