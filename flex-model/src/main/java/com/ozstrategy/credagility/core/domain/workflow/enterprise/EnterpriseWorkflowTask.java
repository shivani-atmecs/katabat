package com.ozstrategy.credagility.core.domain.workflow.enterprise;

import com.ozstrategy.credagility.core.domain.workflow.WorkflowTaskStatus;
import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTask;
import com.ozstrategy.credagility.core.domain.workflow.enterprise.version.EnterpriseWorkflowTaskGroupVersion;
import com.ozstrategy.credagility.core.domain.workflow.enterprise.version.EnterpriseWorkflowTaskVersion;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/17/2014 12:33
 */
@Entity
@Table(name = "EnterpriseWorkflowTask")
public class EnterpriseWorkflowTask extends BasicWorkflowTask implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -7465084938915748236L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "activeVersionId",
    nullable   = true,
    insertable = true,
    updatable  = true,
    unique     = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseWorkflowTaskVersion activeVersion;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "currentVersionId",
    nullable   = true,
    insertable = true,
    updatable  = true,
    unique     = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseWorkflowTaskVersion currentVersion;

  /** Task Element Group. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "task",
    cascade       = { javax.persistence.CascadeType.ALL, javax.persistence.CascadeType.REMOVE },
    orphanRemoval = true
  )
  @OrderBy("displayOrder asc, lastUpdateDate DESC")
  protected Set<EnterpriseWorkflowTaskGroup> groups = new LinkedHashSet<EnterpriseWorkflowTaskGroup>();

  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;

  /** Task Elements belonged to this task. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "task",
    cascade       = { javax.persistence.CascadeType.ALL, javax.persistence.CascadeType.REMOVE },
    orphanRemoval = true
  )
  @OrderBy("displayOrder asc")
  protected Set<EnterpriseWorkflowTaskGroupElement> taskElements =
    new LinkedHashSet<EnterpriseWorkflowTaskGroupElement>();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addGroup.
   *
   * @param  group  $param.type$
   */
  public void addGroup(EnterpriseWorkflowTaskGroup group) {
    group.setTask(this);
    this.groups.add(group);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addGroupElement.
   *
   * @param  groupElement  $param.type$
   */
  public void addGroupElement(EnterpriseWorkflowTaskGroupElement groupElement) {
    if (groupElement != null) {
      this.taskElements.add(groupElement);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTask#copy(com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTask)
   */
  @Override public void copy(BasicWorkflowTask o) {
    super.copy(o);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * EnterpriseWorkflowTask.
   *
   * @return  EnterpriseWorkflowTask.
   */
  public EnterpriseWorkflowTask duplicate() {
    EnterpriseWorkflowTask newTask = new EnterpriseWorkflowTask();

    newTask.duplicate(this);

// for (PortfolioSurveyAction action : actions) {
// newSurvey.addAction(action.duplicate());
// }

// for (EnterpriseWorkflowTaskGroup group : groups) {
// newTask.addGroup(group.duplicate(newTask));
// }

    for (EnterpriseWorkflowTaskGroupVersion group : currentVersion.getGroups()) {
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
   * EnterpriseWorkflowTaskVersion.
   *
   * @return  EnterpriseWorkflowTaskVersion.
   */
  public EnterpriseWorkflowTaskVersion getActiveVersion() {
    return activeVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * EnterpriseWorkflowTaskVersion.
   *
   * @return  EnterpriseWorkflowTaskVersion.
   */
  public EnterpriseWorkflowTaskVersion getCurrentVersion() {
    return currentVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Map.
   *
   * @return  Map.
   */
  public Map<String, EnterpriseWorkflowTaskGroup> getGroupNameMap() {
    Map<String, EnterpriseWorkflowTaskGroup> map = new LinkedHashMap<String, EnterpriseWorkflowTaskGroup>();

    for (EnterpriseWorkflowTaskGroup group : this.groups) {
      map.put(group.getGroupHeader(), group);
    }

    return map;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTask#getGroups()
   */
  @Override public Set<EnterpriseWorkflowTaskGroup> getGroups() {
    return groups;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   */
  @Override public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTask#getTaskElements()
   */
  @Override public Set<EnterpriseWorkflowTaskGroupElement> getTaskElements() {
    return taskElements;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * EnterpriseWorkflowTaskGroup.
   *
   * @param   groupId  $param.type$
   *
   * @return  EnterpriseWorkflowTaskGroup.
   */
  public EnterpriseWorkflowTaskGroup removeGroup(Long groupId) {
    for (EnterpriseWorkflowTaskGroup group : groups) {
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
   * setActiveVersion.
   *
   * @param  activeVersion  $param.type$
   */
  public void setActiveVersion(EnterpriseWorkflowTaskVersion activeVersion) {
    this.activeVersion = activeVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setCurrentVersion.
   *
   * @param  currentVersion  $param.type$
   */
  public void setCurrentVersion(EnterpriseWorkflowTaskVersion currentVersion) {
    this.currentVersion = currentVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setGroups.
   *
   * @param  groups  $param.type$
   */
  public void setGroups(Set<EnterpriseWorkflowTaskGroup> groups) {
    this.groups = groups;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setId.
   *
   * @param  id  $param.type$
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setTaskElements.
   *
   * @param  taskElements  $param.type$
   */
  public void setTaskElements(Set<EnterpriseWorkflowTaskGroupElement> taskElements) {
    this.taskElements = taskElements;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * update.
   *
   * @param  other  $param.type$
   */
  public void update(EnterpriseWorkflowTask other) {
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

    // add showAgentPrintButton,endFlow in task
    this.showAgentPrintButton                  = other.getShowAgentPrintButton();
    this.endFlow                               = other.getEndFlow();
    this.flexStationEndFlowTextAfterSubmission = other.getFlexStationEndFlowTextAfterSubmission();
  } // end method update
} // end class EnterpriseWorkflowTask
