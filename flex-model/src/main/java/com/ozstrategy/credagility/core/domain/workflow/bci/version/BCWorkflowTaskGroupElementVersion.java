package com.ozstrategy.credagility.core.domain.workflow.bci.version;

import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTask;
import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskGroup;
import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskGroupElement;
import com.ozstrategy.credagility.core.domain.workflow.bci.BCWorkflowTask;
import com.ozstrategy.credagility.core.domain.workflow.bci.BCWorkflowTaskElement;
import com.ozstrategy.credagility.core.domain.workflow.bci.BCWorkflowTaskGroupElement;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Created with IntelliJ IDEA. User: yongliu Date: 10/9/13 Time: 3:45 PM To change this template use File | Settings |
 * File Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */

@Entity
@Table(name = "BCWorkflowTaskGroupElementVersion")
public class BCWorkflowTaskGroupElementVersion extends BasicWorkflowTaskGroupElement implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -2598082815637783668L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** BCWorkflowTaskGroup. */
  @JoinColumn(
    name       = "groupId",
    updatable  = true,
    insertable = true,
    nullable   = false
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = { CascadeType.ALL, CascadeType.REMOVE }
  )
  protected BCWorkflowTaskGroupVersion group;

  /** Group element id. */
  @Column(
    name       = "groupElementId",
    updatable  = false,
    insertable = true,
    nullable   = false
  )
  protected Long groupElementId;

  /** Id, PK. */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;

  /** BCWorkflowTaskElement PK questionId. */
  @JoinColumn(
    name       = "questionId",
    updatable  = true,
    insertable = true,
    nullable   = false
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = { CascadeType.ALL }
  )
  protected BCWorkflowTaskElement taskElement;

  /** BCWorkflowTask. */
  @JoinColumn(
    name       = "taskId",
    updatable  = true,
    insertable = true,
    nullable   = false
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = { CascadeType.ALL }
  )
  protected BCWorkflowTaskVersion taskVersion;


  /** Version number. */
  protected Integer version = 1;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   task  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BCWorkflowTaskGroupElementVersion duplicate(BCWorkflowTaskVersion task) {
    BCWorkflowTaskGroupElementVersion groupElement = new BCWorkflowTaskGroupElementVersion();
    groupElement.setDisplayOrder(displayOrder);
    groupElement.setTaskElement(taskElement);
    groupElement.setTaskVersion(task);
    groupElement.setGroupElementId(this.getGroupElementId());
    groupElement.setGroup((BCWorkflowTaskGroupVersion) this.getGroup());

    return groupElement;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   task  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BCWorkflowTaskGroupElement duplicate(BCWorkflowTask task) {
    BCWorkflowTaskGroupElement groupElement = new BCWorkflowTaskGroupElement();
    groupElement.setDisplayOrder(displayOrder);
    groupElement.setTaskElement(taskElement);
    groupElement.setTask(task);

    return groupElement;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * equals.
   *
   * @param   o  Object
   *
   * @return  boolean
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof BCWorkflowTaskGroupElementVersion)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    BCWorkflowTaskGroupElementVersion that = (BCWorkflowTaskGroupElementVersion) o;

    if ((version != null) ? (!version.equals(that.version)) : (that.version != null)) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for group.
   *
   * @return  BasicWorkflowTaskGroup
   */
  @Override public BasicWorkflowTaskGroup getGroup() {
    return group;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getGroupElementId() {
    return groupElementId;
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
   * getter method for task.
   *
   * @return  BasicWorkflowTask
   */
  @Override public BasicWorkflowTask getTask() {
    return taskVersion; // To change body of implemented methods use File | Settings | File Templates.
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for task element.
   *
   * @return  BCWorkflowTaskElement
   */
  @Override public BCWorkflowTaskElement getTaskElement() {
    return taskElement;
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
  public Integer getVersion() {
    return version;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((version != null) ? version.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  group  DOCUMENT ME!
   */
  public void setGroup(BCWorkflowTaskGroupVersion group) {
    this.group = group;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  groupElementId  DOCUMENT ME!
   */
  public void setGroupElementId(Long groupElementId) {
    this.groupElementId = groupElementId;
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
   * @param  taskElement  DOCUMENT ME!
   */
  public void setTaskElement(BCWorkflowTaskElement taskElement) {
    this.taskElement = taskElement;
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
   * @param  version  DOCUMENT ME!
   */
  public void setVersion(Integer version) {
    this.version = version;
  }
} // end class BCWorkflowTaskGroupElementVersion
