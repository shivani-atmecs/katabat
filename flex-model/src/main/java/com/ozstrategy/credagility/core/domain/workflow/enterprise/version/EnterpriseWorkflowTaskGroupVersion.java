package com.ozstrategy.credagility.core.domain.workflow.enterprise.version;

import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTask;
import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskGroup;
import com.ozstrategy.credagility.core.domain.workflow.enterprise.EnterpriseWorkflowTask;
import com.ozstrategy.credagility.core.domain.workflow.enterprise.EnterpriseWorkflowTaskElement;
import com.ozstrategy.credagility.core.domain.workflow.enterprise.EnterpriseWorkflowTaskGroup;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;


/**
 * Enterprise Workflow TaskGroup Version.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/17/2014 11:26
 */
@Entity
@Table(name = "EnterpriseWorkflowTaskGroupVersion")
public class EnterpriseWorkflowTaskGroupVersion extends BasicWorkflowTaskGroup implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 7832536544135172565L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** group Elements Version. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "group",
    orphanRemoval = true,
    cascade       = CascadeType.ALL
  )
  @OrderBy("displayOrder asc")
  protected Set<EnterpriseWorkflowTaskGroupElementVersion> groupElements =
    new LinkedHashSet<EnterpriseWorkflowTaskGroupElementVersion>();


  /** PK. */
  @Column(
    unique   = true,
    nullable = false
  )
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;

  /** Task group. */
  @JoinColumn(
    name     = "taskId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected EnterpriseWorkflowTaskVersion task;


  /** taskGroup. */
  @Column(
    name       = "taskGroupId",
    updatable  = false,
    insertable = true,
    nullable   = false
  )
  protected Long taskGroupId;


  /** version. */
  protected Integer version = 1;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addGroupElement.
   *
   * @param  groupElement  EnterpriseWorkflowTaskGroupElementVersion
   */
  public void addGroupElement(EnterpriseWorkflowTaskGroupElementVersion groupElement) {
    groupElement.setGroup(this);
    this.getGroupElements().add(groupElement);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * duplicate.
   *
   * @param   task  EnterpriseWorkflowTaskVersion
   *
   * @return  EnterpriseWorkflowTaskGroupVersion
   */
  public EnterpriseWorkflowTaskGroupVersion duplicate(EnterpriseWorkflowTaskVersion task) {
    EnterpriseWorkflowTaskGroupVersion newGroup = new EnterpriseWorkflowTaskGroupVersion();
    newGroup.displayOrder = displayOrder;
    newGroup.groupHeader  = groupHeader;
    newGroup.setTaskGroupId(this.getTaskGroupId());

    for (EnterpriseWorkflowTaskGroupElementVersion groupElement : groupElements) {
      newGroup.addGroupElement(groupElement.duplicate(task));
    }

    return newGroup;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * duplicate.
   *
   * @param   task  EnterpriseWorkflowTask
   *
   * @return  EnterpriseWorkflowTaskGroup
   */
  public EnterpriseWorkflowTaskGroup duplicate(EnterpriseWorkflowTask task) {
    EnterpriseWorkflowTaskGroup newGroup = new EnterpriseWorkflowTaskGroup();
    newGroup.setDisplayOrder(displayOrder);
    newGroup.setGroupHeader(groupHeader);

    for (EnterpriseWorkflowTaskGroupElementVersion groupElement : groupElements) {
      newGroup.addGroupElement(groupElement.duplicate(task));
    }


    return newGroup;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#equals(Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof EnterpriseWorkflowTaskGroupVersion)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    EnterpriseWorkflowTaskGroupVersion that = (EnterpriseWorkflowTaskGroupVersion) o;

    if ((version != null) ? (!version.equals(that.version)) : (that.version != null)) {
      return false;
    }

    if ((displayOrder != null) ? (!displayOrder.equals(that.displayOrder)) : (that.displayOrder != null)) {
      return false;
    }

    if ((groupHeader != null) ? (!groupHeader.equals(that.groupHeader)) : (that.groupHeader != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskGroup#getActiveElements()
   */
  @Override public Set<EnterpriseWorkflowTaskElementVersion> getActiveElements() {
    Set<EnterpriseWorkflowTaskElementVersion> questions = new LinkedHashSet<EnterpriseWorkflowTaskElementVersion>();

    for (EnterpriseWorkflowTaskGroupElementVersion groupQuestion : groupElements) {
      questions.add(groupQuestion.getTaskElement().getActiveVersion());
    }

    return questions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskGroup#getElements()
   */
  @Override public Set<EnterpriseWorkflowTaskElement> getElements() {
    Set<EnterpriseWorkflowTaskElement> questions = new LinkedHashSet<EnterpriseWorkflowTaskElement>();

    for (EnterpriseWorkflowTaskGroupElementVersion groupQuestion : groupElements) {
      questions.add(groupQuestion.getTaskElement());
    }

    return questions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskGroup#getGroupElements()
   */
  @Override public Set<EnterpriseWorkflowTaskGroupElementVersion> getGroupElements() {
    return groupElements;
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
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskGroup#getTask()
   */
  @Override public BasicWorkflowTask getTask() {
    return task; // To change body of implemented methods use File | Settings | File Templates.
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for task group id.
   *
   * @return  Long
   */
  public Long getTaskGroupId() {
    return taskGroupId;
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
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskGroup#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((version != null) ? version.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * removeGroupElement.
   *
   * @param   elementId  Long
   *
   * @return  EnterpriseWorkflowTaskGroupElementVersion
   */
  public EnterpriseWorkflowTaskGroupElementVersion removeGroupElement(Long elementId) {
    for (EnterpriseWorkflowTaskGroupElementVersion groupElement : groupElements) {
      if (groupElement.getTaskElement().getId().equals(elementId)) {
        this.getGroupElements().remove(groupElement);
        groupElement.setGroup(null);

        return groupElement;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for group elements.
   *
   * @param  groupElements  Set
   */
  public void setGroupElements(Set<EnterpriseWorkflowTaskGroupElementVersion> groupElements) {
    this.groupElements = groupElements;
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
   * @param  task  EnterpriseWorkflowTaskVersion
   */
  public void setTask(EnterpriseWorkflowTaskVersion task) {
    this.task = task;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for task group id.
   *
   * @param  taskGroupId  Long
   */
  public void setTaskGroupId(Long taskGroupId) {
    this.taskGroupId = taskGroupId;
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
} // end class EnterpriseWorkflowTaskGroupVersion
