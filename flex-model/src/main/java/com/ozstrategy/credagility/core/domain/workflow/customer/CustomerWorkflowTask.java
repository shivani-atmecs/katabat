package com.ozstrategy.credagility.core.domain.workflow.customer;

import com.ozstrategy.credagility.core.domain.workflow.WorkflowTaskStatus;
import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTask;
import com.ozstrategy.credagility.core.domain.workflow.customer.version.CustomerWorkflowTaskGroupVersion;
import com.ozstrategy.credagility.core.domain.workflow.customer.version.CustomerWorkflowTaskVersion;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:wei.tang@ozstrategy.com">Wei Tang</a>
 * @version  03/23/2017 16:25
 */
@Entity
@Table(name = "CustomerWorkflowTask")
public class CustomerWorkflowTask extends BasicWorkflowTask implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -337311817233801708L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  @JoinColumn(
    name       = "activeVersionId",
    nullable   = true,
    insertable = true,
    updatable  = true,
    unique     = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CustomerWorkflowTaskVersion activeVersion;

  /** DOCUMENT ME! */
  @Column
  @Type(type = "yes_no")
  protected Boolean         asGather;

  /** DOCUMENT ME! */
  @JoinColumn(
    name       = "currentVersionId",
    nullable   = true,
    insertable = true,
    updatable  = true,
    unique     = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CustomerWorkflowTaskVersion currentVersion;

  /** Task Element Group. */
  @Cascade({ CascadeType.DELETE_ORPHAN, CascadeType.ALL })
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "task"
  )
  @OrderBy("displayOrder asc, lastUpdateDate DESC")
  protected Set<CustomerWorkflowTaskGroup> groups = new LinkedHashSet<CustomerWorkflowTaskGroup>();

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
  @Cascade({ CascadeType.DELETE_ORPHAN, CascadeType.ALL })
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "task"
  )
  @OrderBy("displayOrder asc")
  protected Set<CustomerWorkflowTaskGroupElement> taskElements = new LinkedHashSet<CustomerWorkflowTaskGroupElement>();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  group  DOCUMENT ME!
   */
  public void addGroup(CustomerWorkflowTaskGroup group) {
    group.setTask(this);
    this.groups.add(group);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  groupElement  DOCUMENT ME!
   */
  public void addGroupElement(CustomerWorkflowTaskGroupElement groupElement) {
    if (groupElement != null) {
      this.taskElements.add(groupElement);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public CustomerWorkflowTask duplicate() {
    CustomerWorkflowTask newTask = new CustomerWorkflowTask();

    newTask.duplicate(this);

// for (PortfolioSurveyAction action : actions) {
// newSurvey.addAction(action.duplicate());
// }

// for (CustomerWorkflowTaskGroup group : groups) {
// newTask.addGroup(group.duplicate(newTask));
// }

    for (CustomerWorkflowTaskGroupVersion group : currentVersion.getGroups()) {
      newTask.addGroup(group.duplicate(newTask));
    }


// for (PortfolioSurveyNextPage nextPage : nextPages) {
// newSurvey.addOrUpdateNextPage(nextPage.duplicate());
// }

    newTask.setStatus(WorkflowTaskStatus.CURRENT);

    return newTask;
  } // end method duplicate

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public CustomerWorkflowTaskVersion getActiveVersion() {
    return activeVersion;
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
  public CustomerWorkflowTaskVersion getCurrentVersion() {
    return currentVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Map<String, CustomerWorkflowTaskGroup> getGroupNameMap() {
    Map<String, CustomerWorkflowTaskGroup> map = new LinkedHashMap<String, CustomerWorkflowTaskGroup>();

    for (CustomerWorkflowTaskGroup group : this.groups) {
      map.put(group.getGroupHeader(), group);
    }

    return map;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTask#getGroups()
   */
  @Override public Set<CustomerWorkflowTaskGroup> getGroups() {
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
    if (specialTask == null) {
      return Boolean.FALSE;
    }

    return specialTask;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTask#getTaskElements()
   */
  @Override public Set<CustomerWorkflowTaskGroupElement> getTaskElements() {
    return taskElements;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   groupId  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public CustomerWorkflowTaskGroup removeGroup(Long groupId) {
    for (CustomerWorkflowTaskGroup group : groups) {
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
   * @param  activeVersion  DOCUMENT ME!
   */
  public void setActiveVersion(CustomerWorkflowTaskVersion activeVersion) {
    this.activeVersion = activeVersion;
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
   * @param  currentVersion  DOCUMENT ME!
   */
  public void setCurrentVersion(CustomerWorkflowTaskVersion currentVersion) {
    this.currentVersion = currentVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  groups  DOCUMENT ME!
   */
  public void setGroups(Set<CustomerWorkflowTaskGroup> groups) {
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
  public void setTaskElements(Set<CustomerWorkflowTaskGroupElement> taskElements) {
    this.taskElements = taskElements;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  other  DOCUMENT ME!
   */
  public void update(CustomerWorkflowTask other) {
    this.alignAcrossGroup        = other.getAlignAcrossGroup();
    this.agentFooter             = other.getAgentFooter();
    this.agentIntroduction       = other.getAgentIntroduction();
    this.agentPostText           = other.getAgentPostText();
    this.agentTitle              = other.getAgentTitle();
    this.allowTempSave           = other.getAllowTempSave();
    this.allowConfirm            = other.getAllowConfirm();
    this.allowPrevious           = other.getAllowPrevious();
    this.allowNext               = other.getAllowNext();
    this.allowCancel             = other.getAllowCancel();
    this.tempSaveButtonText      = other.getTempSaveButtonText();
    this.nextButtonText          = other.getNextButtonText();
    this.previousButtonText      = other.getPreviousButtonText();
    this.cancelButtonText        = other.getCancelButtonText();
    this.cancelButtonURL         = other.getCancelButtonURL();
    this.customerFooter          = other.getCustomerFooter();
    this.customerIntroduction    = other.getCustomerIntroduction();
    this.customerPostText        = other.getCustomerPostText();
    this.customerTitle           = other.getCustomerTitle();
    this.description             = other.getDescription();
    this.groupsPerRow            = other.getGroupsPerRow();
    this.name                    = other.getName();
    this.qaFixedTableLayOut      = other.getQaFixedTableLayOut();
    this.qaTextWidth             = other.getQaTextWidth();
    this.questionsPerRowInGroup  = other.getQuestionsPerRowInGroup();
    this.questionWidthPercentage = other.getQuestionWidthPercentage();

    this.questionTableHeader      = other.getQuestionTableHeader();
    this.restartNumberPerGroup    = other.getRestartNumberPerGroup();
    this.showAgentIntroduction    = other.getShowAgentIntroduction();
    this.showAgentPostText        = other.getShowAgentPostText();
    this.showCustomerIntroduction = other.getShowCustomerIntroduction();
    this.showCustomerPostText     = other.getShowCustomerPostText();
    this.showGroupHeader          = other.getShowGroupHeader();
    this.showQuestionNumber       = other.getShowQuestionNumber();
    this.status                   = WorkflowTaskStatus.DRAFT;
    this.taskCode                 = other.getTaskCode();
    this.setTaskFrequency(other.getTaskFrequency());
    this.customerOnly = other.getCustomerOnly();

    this.flexSiteNATitle    = other.getFlexSiteNATitle();
    this.flexSiteNAText     = other.getFlexSiteNAText();
    this.flexStationNATitle = other.getFlexStationNATitle();
    this.flexStationNAText  = other.getFlexStationNAText();
    this.submitButtonText   = other.getSubmitButtonText();
    this.changeButtonText   = other.getChangeButtonText();
    this.btnAlignmentMode   = other.getBtnAlignmentMode();

    this.lastUpdateDate = new Date();
    this.activeDate     = other.getActiveDate();
    this.activeBy       = other.getActiveBy();

    // add showAgentPrintButton in task
    this.showAgentPrintButton                  = other.getShowAgentPrintButton();
    this.flexStationEndFlowTextAfterSubmission = other.getFlexStationEndFlowTextAfterSubmission();
    this.allowSkip                             = other.getAllowSkip();
    this.skipButtonText                        = other.getSkipButtonText();
    this.skipButtonWarningText                 = other.getSkipButtonWarningText();
  } // end method update
} // end class CustomerWorkflowTask
