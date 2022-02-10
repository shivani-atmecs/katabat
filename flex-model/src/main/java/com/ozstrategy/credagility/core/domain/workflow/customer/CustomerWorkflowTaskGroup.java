package com.ozstrategy.credagility.core.domain.workflow.customer;

import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskElement;
import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskGroup;
import com.ozstrategy.credagility.core.domain.workflow.customer.version.CustomerWorkflowTaskGroupElementVersion;
import com.ozstrategy.credagility.core.domain.workflow.customer.version.CustomerWorkflowTaskGroupVersion;
import com.ozstrategy.credagility.core.domain.workflow.customer.version.CustomerWorkflowTaskVersion;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:wei.tang@ozstrategy.com">Wei Tang</a>
 * @version  06/27/2017 17:04
 */
@Entity
@Table(name = "CustomerWorkflowTaskGroup")
public class CustomerWorkflowTaskGroup extends BasicWorkflowTaskGroup implements Serializable {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Task Group Elements. */
  @Cascade({ CascadeType.DELETE_ORPHAN, CascadeType.ALL })
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "group"
  )
  @OrderBy("displayOrder asc")
  protected Set<CustomerWorkflowTaskGroupElement> groupElements = new LinkedHashSet<CustomerWorkflowTaskGroupElement>();

  /** Document Type PK. */
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
  protected CustomerWorkflowTask task;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  groupElement  DOCUMENT ME!
   */
  public void addGroupElement(CustomerWorkflowTaskGroupElement groupElement) {
    groupElement.setGroup(this);
    this.groupElements.add(groupElement);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   task  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public CustomerWorkflowTaskGroup duplicate(CustomerWorkflowTask task) {
    CustomerWorkflowTaskGroup newGroup = new CustomerWorkflowTaskGroup();
    newGroup.displayOrder = displayOrder;
    newGroup.groupHeader  = groupHeader;

    for (CustomerWorkflowTaskGroupElement groupElement : groupElements) {
      newGroup.addGroupElement(groupElement.duplicate(task));
    }

    return newGroup;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   taskVersion  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public CustomerWorkflowTaskGroupVersion duplicateGroupVersion(CustomerWorkflowTaskVersion taskVersion) {
    CustomerWorkflowTaskGroupVersion groupVersion = new CustomerWorkflowTaskGroupVersion();

    groupVersion.setTaskGroupId(this.getId());
    groupVersion.setGroupHeader(this.getGroupHeader());
    groupVersion.setDisplayOrder(this.getDisplayOrder());
    groupVersion.setTask(taskVersion);

    for (CustomerWorkflowTaskGroupElement groupElement : groupElements) {
      CustomerWorkflowTaskGroupElementVersion groupElementVersion = groupElement.duplicateVersion();
      groupElementVersion.setTaskVersion(taskVersion);
      groupElementVersion.setGroup(groupVersion);
      groupVersion.addGroupElement(groupElementVersion);
    }

    return groupVersion;
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

    CustomerWorkflowTaskGroup that = (CustomerWorkflowTaskGroup) o;

    if ((task != null) ? (!task.equals(that.task)) : (that.task != null)) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskGroup#getActiveElements()
   */
  @Override public Set<? extends BasicWorkflowTaskElement> getActiveElements() {
    return Collections.emptySet();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskGroup#getElements()
   */
  @Override public Set<CustomerWorkflowTaskElement> getElements() {
    Set<CustomerWorkflowTaskElement> questions = new LinkedHashSet<CustomerWorkflowTaskElement>();

    for (CustomerWorkflowTaskGroupElement groupQuestion : groupElements) {
      questions.add(groupQuestion.getTaskElement());
    }

    return questions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskGroup#getGroupElements()
   */
  @Override public Set<CustomerWorkflowTaskGroupElement> getGroupElements() {
    return groupElements;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Map<Long, CustomerWorkflowTaskGroupElement> getGroupQuestionsMap() {
    Map<Long, CustomerWorkflowTaskGroupElement> result = new HashMap<Long, CustomerWorkflowTaskGroupElement>();

    for (CustomerWorkflowTaskGroupElement groupQuestion : groupElements) {
      result.put(groupQuestion.getTaskElement().getId(), groupQuestion);
    }

    return result;
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
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskGroup#getTask()
   */
  @Override public CustomerWorkflowTask getTask() {
    return task;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskGroup#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((task != null) ? task.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   elementId  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public CustomerWorkflowTaskGroupElement removeGroupElement(Long elementId) {
    for (CustomerWorkflowTaskGroupElement groupElement : groupElements) {
      if (groupElement.getTaskElement().getId().equals(elementId)) {
        this.groupElements.remove(groupElement);
        groupElement.setGroup(null);

        return groupElement;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  groupElements  DOCUMENT ME!
   */
  public void setGroupElements(Set<CustomerWorkflowTaskGroupElement> groupElements) {
    this.groupElements = groupElements;
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
   * @see  com.ozstrategy.credagility.core.domain.CreatorEntity#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("CustomerWorkflowTaskGroup");
    sb.append("{id=").append(id);
    sb.append(", task=").append(task);
    sb.append(", displayOrder=").append(displayOrder);
    sb.append(", groupHeader='").append(groupHeader).append('\'');
    sb.append('}');

    return sb.toString();
  }
} // end class CustomerWorkflowTaskGroup
