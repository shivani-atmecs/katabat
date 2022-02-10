package com.ozstrategy.credagility.core.domain.workflow.customer.version;

import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTask;
import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskElement;
import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskGroup;
import com.ozstrategy.credagility.core.domain.workflow.customer.CustomerWorkflowTask;
import com.ozstrategy.credagility.core.domain.workflow.customer.CustomerWorkflowTaskElement;
import com.ozstrategy.credagility.core.domain.workflow.customer.CustomerWorkflowTaskGroup;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:wei.tang@ozstrategy.com">Wei Tang</a>
 * @version  03/18/2017 15:49
 */
@Entity
@Table(name = "CustomerWorkflowTaskGroupVersion")
public class CustomerWorkflowTaskGroupVersion extends BasicWorkflowTaskGroup implements Serializable {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  @Cascade({ org.hibernate.annotations.CascadeType.ALL, org.hibernate.annotations.CascadeType.DELETE_ORPHAN })
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "group"
  )
  @OrderBy("displayOrder asc")
  protected Set<CustomerWorkflowTaskGroupElementVersion> groupElements =
    new LinkedHashSet<CustomerWorkflowTaskGroupElementVersion>();

  /** DOCUMENT ME! */
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
  protected CustomerWorkflowTaskVersion task;

  /** DOCUMENT ME! */
  @Column(
    name       = "taskGroupId",
    updatable  = false,
    insertable = true,
    nullable   = false
  )
  protected Long taskGroupId;

  /** DOCUMENT ME! */
  protected Integer version = 1;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  groupElement  DOCUMENT ME!
   */
  public void addGroupElement(CustomerWorkflowTaskGroupElementVersion groupElement) {
    groupElement.setGroup(this);
    this.getGroupElements().add(groupElement);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   task  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public CustomerWorkflowTaskGroupVersion duplicate(CustomerWorkflowTaskVersion task) {
    CustomerWorkflowTaskGroupVersion newGroup = new CustomerWorkflowTaskGroupVersion();
    newGroup.displayOrder = displayOrder;
    newGroup.groupHeader  = groupHeader;
    newGroup.setTaskGroupId(this.getTaskGroupId());

    for (CustomerWorkflowTaskGroupElementVersion groupElement : groupElements) {
      newGroup.addGroupElement(groupElement.duplicate(task));
    }

    return newGroup;
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
    newGroup.setDisplayOrder(displayOrder);
    newGroup.setGroupHeader(groupHeader);

    for (CustomerWorkflowTaskGroupElementVersion groupElement : groupElements) {
      newGroup.addGroupElement(groupElement.duplicate(task));
    }
// for (PortfolioSurveyGroupQuestion groupQuestion : groupElements) {
// newGroup.addGroupQuestion(groupQuestion.duplicate(survey));
// }

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

    if (!(o instanceof CustomerWorkflowTaskGroupVersion)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    CustomerWorkflowTaskGroupVersion that = (CustomerWorkflowTaskGroupVersion) o;

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
  @Override public Set<? extends BasicWorkflowTaskElement> getActiveElements() {
    Set<CustomerWorkflowTaskElementVersion> questions = new LinkedHashSet<CustomerWorkflowTaskElementVersion>();

    for (CustomerWorkflowTaskGroupElementVersion groupQuestion : groupElements) {
      questions.add(groupQuestion.getTaskElement().getActiveVersion());
    }

    return questions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Override public Set<CustomerWorkflowTaskElement> getElements() {
    Set<CustomerWorkflowTaskElement> questions = new LinkedHashSet<CustomerWorkflowTaskElement>();

    for (CustomerWorkflowTaskGroupElementVersion groupQuestion : groupElements) {
      questions.add(groupQuestion.getTaskElement());
    }

    return questions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskGroup#getGroupElements()
   */
  @Override public Set<CustomerWorkflowTaskGroupElementVersion> getGroupElements() {
    return groupElements;
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
  @Override public BasicWorkflowTask getTask() {
    return task;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getTaskGroupId() {
    return taskGroupId;
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
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskGroup#hashCode()
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
   * @param   elementId  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public CustomerWorkflowTaskGroupElementVersion removeGroupElement(Long elementId) {
    for (CustomerWorkflowTaskGroupElementVersion groupElement : groupElements) {
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
   * DOCUMENT ME!
   *
   * @param  groupElements  DOCUMENT ME!
   */
  public void setGroupElements(Set<CustomerWorkflowTaskGroupElementVersion> groupElements) {
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
  public void setTask(CustomerWorkflowTaskVersion task) {
    this.task = task;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  taskGroupId  DOCUMENT ME!
   */
  public void setTaskGroupId(Long taskGroupId) {
    this.taskGroupId = taskGroupId;
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
} // end class CustomerWorkflowTaskGroupVersion
