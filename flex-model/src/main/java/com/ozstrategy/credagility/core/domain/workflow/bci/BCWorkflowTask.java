package com.ozstrategy.credagility.core.domain.workflow.bci;

import com.cmc.credagility.core.domain.businesscontext.BusinessContext;
import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowTaskStatus;
import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTask;
import com.ozstrategy.credagility.core.domain.workflow.bci.version.BCWorkflowTaskGroupVersion;
import com.ozstrategy.credagility.core.domain.workflow.bci.version.BCWorkflowTaskVersion;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


/**
 * Created with IntelliJ IDEA.
 *
 * <p>: Wang Yang : 13-2-26 : PM5:17</p>
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(name = "BCWorkflowTask")
public class BCWorkflowTask extends BasicWorkflowTask implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -7834182109289418939L;

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
  protected BCWorkflowTaskVersion activeVersion;

  /** <code>true</code> this workflow is business workflow. */
  @Column(
    name             = "asGather",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean asGather;

  /** BusinessContext PK businessContextId. */
  @JoinColumn(
    name       = "businessContextId",
    nullable   = false,
    insertable = true,
    updatable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BusinessContext businessContext;

  /** BCWorkflowTaskVersion PK currentVersionId. */
  @JoinColumn(
    name       = "currentVersionId",
    nullable   = true,
    insertable = true,
    updatable  = true,
    unique     = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCWorkflowTaskVersion currentVersion;

  /** Task Element Group. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "task",
    cascade  = { CascadeType.REMOVE, CascadeType.ALL }
  )
  @OrderBy("displayOrder asc, lastUpdateDate DESC")
  protected Set<BCWorkflowTaskGroup> groups = new LinkedHashSet<BCWorkflowTaskGroup>();

  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;

  /** Task Elements belonged to this task. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "task",
    cascade  = { CascadeType.REMOVE, CascadeType.ALL }
  )
  @OrderBy("displayOrder asc")
  protected Set<BCWorkflowTaskGroupElement> taskElements = new LinkedHashSet<BCWorkflowTaskGroupElement>();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  group  DOCUMENT ME!
   */
  public void addGroup(BCWorkflowTaskGroup group) {
    group.setTask(this);
    this.groups.add(group);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  groupElement  DOCUMENT ME!
   */
  public void addGroupElement(BCWorkflowTaskGroupElement groupElement) {
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
  public BCWorkflowTask duplicate() {
    BCWorkflowTask newTask = new BCWorkflowTask();

    newTask.duplicate(this);

// for (PortfolioSurveyAction action : actions) {
// newSurvey.addAction(action.duplicate());
// }

// for (BCWorkflowTaskGroup group : groups) {
// newTask.addGroup(group.duplicate(newTask));
// }

    for (BCWorkflowTaskGroupVersion group : currentVersion.getGroups()) {
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
  public BCWorkflowTaskVersion getActiveVersion() {
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
  public BusinessContext getBusinessContext() {
    return businessContext;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BCWorkflowTaskVersion getCurrentVersion() {
    return currentVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Map<String, BCWorkflowTaskGroup> getGroupNameMap() {
    Map<String, BCWorkflowTaskGroup> map = new LinkedHashMap<String, BCWorkflowTaskGroup>();

    for (BCWorkflowTaskGroup group : this.groups) {
      map.put(group.getGroupHeader(), group);
    }

    return map;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTask#getGroups()
   */
  @Override public Set<BCWorkflowTaskGroup> getGroups() {
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
  @Override public Set<BCWorkflowTaskGroupElement> getTaskElements() {
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
  public BCWorkflowTaskGroup removeGroup(Long groupId) {
    for (BCWorkflowTaskGroup group : groups) {
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
  public void setActiveVersion(BCWorkflowTaskVersion activeVersion) {
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
   * @param  businessContext  DOCUMENT ME!
   */
  public void setBusinessContext(BusinessContext businessContext) {
    this.businessContext = businessContext;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  currentVersion  DOCUMENT ME!
   */
  public void setCurrentVersion(BCWorkflowTaskVersion currentVersion) {
    this.currentVersion = currentVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  groups  DOCUMENT ME!
   */
  public void setGroups(Set<BCWorkflowTaskGroup> groups) {
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
  public void setTaskElements(Set<BCWorkflowTaskGroupElement> taskElements) {
    this.taskElements = taskElements;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  other  DOCUMENT ME!
   */
  public void update(BCWorkflowTask other) {
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
  } // end method update
} // end class BCWorkflowTask
