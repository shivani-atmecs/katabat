package com.ozstrategy.credagility.core.domain.workflow.enterprise;

import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskElement;
import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskGroup;
import com.ozstrategy.credagility.core.domain.workflow.enterprise.version.EnterpriseWorkflowTaskGroupElementVersion;
import com.ozstrategy.credagility.core.domain.workflow.enterprise.version.EnterpriseWorkflowTaskGroupVersion;
import com.ozstrategy.credagility.core.domain.workflow.enterprise.version.EnterpriseWorkflowTaskVersion;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/17/2014 13:39
 */
@Entity
@Table(name = "EnterpriseWorkflowTaskGroup")
public class EnterpriseWorkflowTaskGroup extends BasicWorkflowTaskGroup implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 6521042468583409790L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Task Group Elements. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "group",
    cascade  = CascadeType.ALL
  )
  @OrderBy("displayOrder asc")
  protected Set<EnterpriseWorkflowTaskGroupElement> groupElements =
    new LinkedHashSet<EnterpriseWorkflowTaskGroupElement>();

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
  protected EnterpriseWorkflowTask task;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addGroupElement.
   *
   * @param  groupElement  EnterpriseWorkflowTaskGroupElement
   */
  public void addGroupElement(EnterpriseWorkflowTaskGroupElement groupElement) {
    groupElement.setGroup(this);
    this.groupElements.add(groupElement);
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
    newGroup.displayOrder = displayOrder;
    newGroup.groupHeader  = groupHeader;

    for (EnterpriseWorkflowTaskGroupElement groupElement : groupElements) {
      newGroup.addGroupElement(groupElement.duplicate(task));
    }
// for (PortfolioSurveyGroupQuestion groupQuestion : groupElements) {
// newGroup.addGroupQuestion(groupQuestion.duplicate(survey));
// }

    return newGroup;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * duplicateGroupVersion.
   *
   * @param   taskVersion  EnterpriseWorkflowTaskVersion
   *
   * @return  EnterpriseWorkflowTaskGroupVersion
   */
  public EnterpriseWorkflowTaskGroupVersion duplicateGroupVersion(EnterpriseWorkflowTaskVersion taskVersion) {
    EnterpriseWorkflowTaskGroupVersion groupVersion = new EnterpriseWorkflowTaskGroupVersion();

    groupVersion.setTaskGroupId(this.getId());
    groupVersion.setGroupHeader(this.getGroupHeader());
    groupVersion.setDisplayOrder(this.getDisplayOrder());
    groupVersion.setTask(taskVersion);

    for (EnterpriseWorkflowTaskGroupElement groupElement : groupElements) {
      EnterpriseWorkflowTaskGroupElementVersion groupElementVersion = groupElement.duplicateVersion();
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

    EnterpriseWorkflowTaskGroup taskGroup = (EnterpriseWorkflowTaskGroup) o;

    if ((task != null) ? (!task.equals(taskGroup.task)) : (taskGroup.task != null)) {
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
   * getter method for elements.
   *
   * @return  Set
   */
  @Override public Set<EnterpriseWorkflowTaskElement> getElements() {
    Set<EnterpriseWorkflowTaskElement> questions = new LinkedHashSet<EnterpriseWorkflowTaskElement>();

    for (EnterpriseWorkflowTaskGroupElement groupQuestion : groupElements) {
      questions.add(groupQuestion.getTaskElement());
    }

    return questions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskGroup#getGroupElements()
   */
  @Override public Set<EnterpriseWorkflowTaskGroupElement> getGroupElements() {
    return groupElements;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for group questions map.
   *
   * @return  Map
   */
  public Map<Long, EnterpriseWorkflowTaskGroupElement> getGroupQuestionsMap() {
    Map<Long, EnterpriseWorkflowTaskGroupElement> result = new HashMap<Long, EnterpriseWorkflowTaskGroupElement>();

    for (EnterpriseWorkflowTaskGroupElement groupQuestion : groupElements) {
      result.put(groupQuestion.getTaskElement().getId(), groupQuestion);
    }

    return result;
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
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((task != null) ? task.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * removeGroupElement.
   *
   * @param   elementId  Long
   *
   * @return  EnterpriseWorkflowTaskGroupElement
   */
  public EnterpriseWorkflowTaskGroupElement removeGroupElement(Long elementId) {
    for (EnterpriseWorkflowTaskGroupElement groupElement : groupElements) {
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
   * setter method for group elements.
   *
   * @param  groupElements  Set
   */
  public void setGroupElements(Set<EnterpriseWorkflowTaskGroupElement> groupElements) {
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
   * @param  task  EnterpriseWorkflowTask
   */
  public void setTask(EnterpriseWorkflowTask task) {
    this.task = task;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * toString.
   *
   * @return  String
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("EnterpriseWorkflowTaskGroup");
    sb.append("{id=").append(id);
    sb.append(", task=").append(task);
    sb.append(", displayOrder=").append(displayOrder);
    sb.append(", groupHeader='").append(groupHeader).append('\'');
    sb.append('}');

    return sb.toString();
  }
} // end class EnterpriseWorkflowTaskGroup
