package com.ozstrategy.credagility.core.domain.workflow.enterprise.version;

import com.cmc.credagility.core.domain.user.User;
import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskVersion;
import com.ozstrategy.credagility.core.domain.workflow.enterprise.EnterpriseWorkflowTask;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


/**
 * Enterprise WorkflowTask Version.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/17/2014 11:35
 */
@Entity
@Table(name = "EnterpriseWorkflowTaskVersion")
public class EnterpriseWorkflowTaskVersion extends BasicWorkflowTaskVersion implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 8862685445383169544L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Task Element Group. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "task",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @OrderBy("displayOrder asc")
  protected Set<EnterpriseWorkflowTaskGroupVersion> groups = new LinkedHashSet<EnterpriseWorkflowTaskGroupVersion>();

  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;


  /** Task Elements belonged to this task. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "taskVersion",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @OrderBy("displayOrder asc")
  protected Set<EnterpriseWorkflowTaskGroupElementVersion> taskElements =
    new LinkedHashSet<EnterpriseWorkflowTaskGroupElementVersion>();

  /** EnterpriseWorkflow Task. */
  @JoinColumn(
    name       = "workflowTaskId",
    nullable   = false,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  protected EnterpriseWorkflowTask workflowTask;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addGroup.
   *
   * @param  group  EnterpriseWorkflowTaskGroupVersion
   */
  public void addGroup(EnterpriseWorkflowTaskGroupVersion group) {
    group.setTask(this);
    this.groups.add(group);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addGroupElement.
   *
   * @param  groupElementVersion  EnterpriseWorkflowTaskGroupElementVersion
   */
  public void addGroupElement(EnterpriseWorkflowTaskGroupElementVersion groupElementVersion) {
    groupElementVersion.setTaskVersion(this);
    this.taskElements.add(groupElementVersion);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * copy.
   *
   * @param  o  EnterpriseWorkflowTask
   */
  public void copy(EnterpriseWorkflowTask o) {
    super.copy(o);
    this.version = (o.getCurrentVersion() != null) ? (o.getCurrentVersion().getVersion() + 1) : 1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * copyFrom.
   *
   * @param  o  EnterpriseWorkflowTask
   */
  public void copyFrom(EnterpriseWorkflowTask o) {
    copy(o);
  } // end method copyFrom

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTask#getActiveBy()
   */
  @Override public User getActiveBy() {
    return activeBy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTask#getActiveDate()
   */
  @Override public Date getActiveDate() {
    return activeDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for group map.
   *
   * @return  Map
   */
  public Map<Long, EnterpriseWorkflowTaskGroupVersion> getGroupMap() {
    Map<Long, EnterpriseWorkflowTaskGroupVersion> map = new LinkedHashMap<Long, EnterpriseWorkflowTaskGroupVersion>();

    for (EnterpriseWorkflowTaskGroupVersion group : this.groups) {
      map.put(group.getTaskGroupId(), group);
    }

    return map;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTask#getGroups()
   */
  @Override public Set<EnterpriseWorkflowTaskGroupVersion> getGroups() {
    return groups;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTask#getId()
   */
  @Override public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTask#getTaskElements()
   */
  @Override public Set<EnterpriseWorkflowTaskGroupElementVersion> getTaskElements() {
    return taskElements;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskVersion#getVersion()
   */
  @Override public Integer getVersion() {
    return version;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for workflow task.
   *
   * @return  EnterpriseWorkflowTask
   */
  public EnterpriseWorkflowTask getWorkflowTask() {
    return workflowTask;
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
   * removeGroup.
   *
   * @param   groupId  Long
   *
   * @return  EnterpriseWorkflowTaskGroupVersion
   */
  public EnterpriseWorkflowTaskGroupVersion removeGroup(Long groupId) {
    for (EnterpriseWorkflowTaskGroupVersion group : groups) {
      if (group.getId().equals(groupId)) {
        // found and try to remove it
        if (this.groups.remove(group)) {
          group.setTask(null);

          return group;
        } else {
          break;
        }
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTask#setActiveBy(com.cmc.credagility.core.domain.user.User)
   */
  @Override public void setActiveBy(User activeBy) {
    this.activeBy = activeBy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTask#setActiveDate(java.util.Date)
   */
  @Override public void setActiveDate(Date activeDate) {
    this.activeDate = activeDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for groups.
   *
   * @param  groups  Set
   */
  public void setGroups(Set<EnterpriseWorkflowTaskGroupVersion> groups) {
    this.groups = groups;
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
   * setter method for task elements.
   *
   * @param  taskElements  Set
   */
  public void setTaskElements(Set<EnterpriseWorkflowTaskGroupElementVersion> taskElements) {
    this.taskElements = taskElements;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskVersion#setVersion(Integer)
   */
  @Override public void setVersion(Integer version) {
    this.version = version;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for workflow task.
   *
   * @param  workflowTask  EnterpriseWorkflowTask
   */
  public void setWorkflowTask(EnterpriseWorkflowTask workflowTask) {
    this.workflowTask = workflowTask;
  }
} // end class EnterpriseWorkflowTaskVersion
