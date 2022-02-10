package com.ozstrategy.credagility.core.domain.workflow.customer.version;

import com.cmc.credagility.core.domain.user.User;
import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskVersion;
import com.ozstrategy.credagility.core.domain.workflow.customer.CustomerWorkflowSpecialFunction;
import com.ozstrategy.credagility.core.domain.workflow.customer.CustomerWorkflowTask;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Type;

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
@Table(name = "CustomerWorkflowTaskVersion")
public class CustomerWorkflowTaskVersion extends BasicWorkflowTaskVersion implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -2636760832014858551L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  @Column
  @Type(type = "yes_no")
  protected Boolean         asGather;

  /** Task Element Group. */
  @Cascade({ org.hibernate.annotations.CascadeType.DELETE_ORPHAN, org.hibernate.annotations.CascadeType.ALL })
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "task"
  )
  @OrderBy("displayOrder asc")
  protected Set<CustomerWorkflowTaskGroupVersion> groups = new LinkedHashSet<CustomerWorkflowTaskGroupVersion>();

  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "specialFunctionId",
    nullable   = true,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CustomerWorkflowSpecialFunction specialFunction;

  /** TODO: DOCUMENT ME! */
  @Column
  @Type(type = "yes_no")
  protected Boolean         specialTask;


  /** Task Elements belonged to this task. */
  @Cascade({ org.hibernate.annotations.CascadeType.DELETE_ORPHAN, org.hibernate.annotations.CascadeType.ALL })
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "taskVersion"
  )
  @OrderBy("displayOrder asc")
  protected Set<CustomerWorkflowTaskGroupElementVersion> taskElements =
    new LinkedHashSet<CustomerWorkflowTaskGroupElementVersion>();

  /** DOCUMENT ME! */
  @Cascade({ org.hibernate.annotations.CascadeType.DELETE_ORPHAN, org.hibernate.annotations.CascadeType.ALL })
  @JoinColumn(
    name       = "workflowTaskId",
    nullable   = false,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CustomerWorkflowTask workflowTask;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  group  DOCUMENT ME!
   */
  public void addGroup(CustomerWorkflowTaskGroupVersion group) {
    group.setTask(this);
    this.groups.add(group);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  groupElementVersion  DOCUMENT ME!
   */
  public void addGroupElement(CustomerWorkflowTaskGroupElementVersion groupElementVersion) {
    groupElementVersion.setTaskVersion(this);
    this.taskElements.add(groupElementVersion);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  o  DOCUMENT ME!
   */
  public void copy(CustomerWorkflowTask o) {
    super.copy(o);
    this.version  = (o.getCurrentVersion() != null) ? (o.getCurrentVersion().getVersion() + 1) : 1;
    this.asGather = o.getAsGather();
    this.setSpecialTask(o.getSpecialTask());
    this.setSpecialFunction(o.getSpecialFunction());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  o  DOCUMENT ME!
   */
  public void copyFrom(CustomerWorkflowTask o) {
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
  public Map<Long, CustomerWorkflowTaskGroupVersion> getGroupMap() {
    Map<Long, CustomerWorkflowTaskGroupVersion> map = new LinkedHashMap<Long, CustomerWorkflowTaskGroupVersion>();

    for (CustomerWorkflowTaskGroupVersion group : this.groups) {
      map.put(group.getTaskGroupId(), group);
    }

    return map;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTask#getGroups()
   */
  @Override public Set<CustomerWorkflowTaskGroupVersion> getGroups() {
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
   * getter method for special function.
   *
   * @return  CustomerWorkflowSpecialFunction
   */
  public CustomerWorkflowSpecialFunction getSpecialFunction() {
    return specialFunction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for special task.
   *
   * @return  Boolean
   */
  public Boolean getSpecialTask() {
    return specialTask;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTask#getTaskElements()
   */
  @Override public Set<CustomerWorkflowTaskGroupElementVersion> getTaskElements() {
    return taskElements;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public CustomerWorkflowTask getWorkflowTask() {
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
  public CustomerWorkflowTaskGroupVersion removeGroup(Long groupId) {
    for (CustomerWorkflowTaskGroupVersion group : groups) {
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
  public void setGroups(Set<CustomerWorkflowTaskGroupVersion> groups) {
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
   * setter method for special function.
   *
   * @param  specialFunction  CustomerWorkflowSpecialFunction
   */
  public void setSpecialFunction(CustomerWorkflowSpecialFunction specialFunction) {
    this.specialFunction = specialFunction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for special task.
   *
   * @param  specialTask  Boolean
   */
  public void setSpecialTask(Boolean specialTask) {
    this.specialTask = specialTask;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  taskElements  DOCUMENT ME!
   */
  public void setTaskElements(Set<CustomerWorkflowTaskGroupElementVersion> taskElements) {
    this.taskElements = taskElements;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  workflowTask  DOCUMENT ME!
   */
  public void setWorkflowTask(CustomerWorkflowTask workflowTask) {
    this.workflowTask = workflowTask;
  }
} // end class CustomerWorkflowTaskVersion
