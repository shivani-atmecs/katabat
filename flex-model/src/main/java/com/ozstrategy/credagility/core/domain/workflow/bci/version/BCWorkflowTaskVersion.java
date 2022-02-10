package com.ozstrategy.credagility.core.domain.workflow.bci.version;

import com.cmc.credagility.core.domain.user.User;
import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskVersion;
import com.ozstrategy.credagility.core.domain.workflow.bci.BCWorkflowTask;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


/**
 * Created with IntelliJ IDEA. User: yongliu Date: 10/9/13 Time: 2:36 PM To change this template use File | Settings |
 * File Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(name = "BCWorkflowTaskVersion")
public class BCWorkflowTaskVersion extends BasicWorkflowTaskVersion implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 4156197510982628372L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** <code>true</code> this workflow is business workflow. */
  @Column(
    name             = "asGather",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean asGather;

  /** Task Element Group. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "task",
    cascade  = { CascadeType.ALL, CascadeType.REMOVE }
  )
  @OrderBy("displayOrder asc")
  protected Set<BCWorkflowTaskGroupVersion> groups = new LinkedHashSet<BCWorkflowTaskGroupVersion>();

  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;


  /** Task Elements belonged to this task. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "taskVersion",
    cascade  = { CascadeType.ALL, CascadeType.REMOVE }
  )
  @OrderBy("displayOrder asc")
  protected Set<BCWorkflowTaskGroupElementVersion> taskElements =
    new LinkedHashSet<BCWorkflowTaskGroupElementVersion>();

  /** BCWorkflowTask PK workflowTaskId. */
  @JoinColumn(
    name       = "workflowTaskId",
    nullable   = false,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = { CascadeType.ALL, CascadeType.REMOVE }
  )
  protected BCWorkflowTask workflowTask;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  group  DOCUMENT ME!
   */
  public void addGroup(BCWorkflowTaskGroupVersion group) {
    group.setTask(this);
    this.groups.add(group);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  groupElementVersion  DOCUMENT ME!
   */
  public void addGroupElement(BCWorkflowTaskGroupElementVersion groupElementVersion) {
    groupElementVersion.setTaskVersion(this);
    this.taskElements.add(groupElementVersion);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  o  DOCUMENT ME!
   */
  public void copy(BCWorkflowTask o) {
    super.copy(o);
    this.version  = (o.getCurrentVersion() != null) ? (o.getCurrentVersion().getVersion() + 1) : 1;
    this.asGather = o.getAsGather();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  o  DOCUMENT ME!
   */
  public void copyFrom(BCWorkflowTask o) {
    copy(o);

  } // end method copyFrom

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Override public User getActiveBy() {
    return activeBy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Override public Date getActiveDate() {
    return activeDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAsGather() {
    if (asGather == null) {
      return Boolean.FALSE;
    }

    return asGather;

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Map<Long, BCWorkflowTaskGroupVersion> getGroupMap() {
    Map<Long, BCWorkflowTaskGroupVersion> map = new LinkedHashMap<Long, BCWorkflowTaskGroupVersion>();

    for (BCWorkflowTaskGroupVersion group : this.groups) {
      map.put(group.getTaskGroupId(), group);
    }

    return map;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTask#getGroups()
   */
  @Override public Set<BCWorkflowTaskGroupVersion> getGroups() {
    return groups;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Override public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTask#getTaskElements()
   */
  @Override public Set<BCWorkflowTaskGroupElementVersion> getTaskElements() {
    return taskElements;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BCWorkflowTask getWorkflowTask() {
    return workflowTask;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   groupId  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BCWorkflowTaskGroupVersion removeGroup(Long groupId) {
    for (BCWorkflowTaskGroupVersion group : groups) {
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
   * DOCUMENT ME!
   *
   * @param  activeBy  DOCUMENT ME!
   */
  @Override public void setActiveBy(User activeBy) {
    this.activeBy = activeBy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  activeDate  DOCUMENT ME!
   */
  @Override public void setActiveDate(Date activeDate) {
    this.activeDate = activeDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  asGather  DOCUMENT ME!
   */
  public void setAsGather(Boolean asGather) {
    this.asGather = asGather;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  groups  DOCUMENT ME!
   */
  public void setGroups(Set<BCWorkflowTaskGroupVersion> groups) {
    this.groups = groups;
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
   * @param  taskElements  DOCUMENT ME!
   */
  public void setTaskElements(Set<BCWorkflowTaskGroupElementVersion> taskElements) {
    this.taskElements = taskElements;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  workflowTask  DOCUMENT ME!
   */
  public void setWorkflowTask(BCWorkflowTask workflowTask) {
    this.workflowTask = workflowTask;
  }
} // end class BCWorkflowTaskVersion
