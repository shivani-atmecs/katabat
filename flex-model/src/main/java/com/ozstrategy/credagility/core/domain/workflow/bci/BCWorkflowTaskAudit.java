package com.ozstrategy.credagility.core.domain.workflow.bci;

import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTask;
import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskGroup;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * Created with IntelliJ IDEA. User: weitang Date: 13-3-6 Time: PM2:46 To change this template use File | Settings |
 * File Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(name = "BCWorkflowTaskAudit")
public class BCWorkflowTaskAudit extends BasicWorkflowTask implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -803707043621307366L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Possible values are. */
  @Column(
    nullable = false,
    length   = 32
  )
  protected String action;

  /** Action String. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String actionsString;

  /** <code>true</code> this workflow is business workflow. */
  @Column(
    name             = "asGather",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean asGather;

  /** Group task string. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String groupTasksString;

  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** Next pages string. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String nextPagesString;

  /** Task id. */
  @Column protected Long taskId;

  /** Version number. */
  @Column protected Integer version;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * equals.
   *
   * @param   o  Object
   *
   * @return  boolean
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

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getAction() {
    return action;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getActionsString() {
    return actionsString;
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
   * getter method for groups.
   *
   * @return  Set
   */
  @Override public Set<? extends BasicWorkflowTaskGroup> getGroups() {
    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getGroupTasksString() {
    return groupTasksString;
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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getNextPagesString() {
    return nextPagesString;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for task elements.
   *
   * @return  Set
   */
  @Override public Set<BCWorkflowTaskGroupElement> getTaskElements() {
    return null;
// return taskElements;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getTaskId() {
    return taskId;
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
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    return super.hashCode();

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  action  DOCUMENT ME!
   */
  public void setAction(String action) {
    this.action = action;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  actionsString  DOCUMENT ME!
   */
  public void setActionsString(String actionsString) {
    this.actionsString = actionsString;
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
   * @param  groupTasksString  DOCUMENT ME!
   */
  public void setGroupTasksString(String groupTasksString) {
    this.groupTasksString = groupTasksString;
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
   * @param  nextPagesString  DOCUMENT ME!
   */
  public void setNextPagesString(String nextPagesString) {
    this.nextPagesString = nextPagesString;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  taskId  DOCUMENT ME!
   */
  public void setTaskId(Long taskId) {
    this.taskId = taskId;
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

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * toString.
   *
   * @return  String
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("BCWorkflowTaskAudit");
    sb.append("{id=").append(id);
    sb.append(", name='").append(name).append('\'');
    sb.append(", description='").append(description).append('\'');
// sb.append(", questions=").append(questions);
    sb.append('}');

    return sb.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  other  DOCUMENT ME!
   */
  public void update(BCWorkflowTask other) {
    this.taskId               = other.getId();
    this.alignAcrossGroup     = other.getAlignAcrossGroup();
    this.agentFooter          = other.getAgentFooter();
    this.agentIntroduction    = other.getAgentIntroduction();
    this.agentTitle           = other.getAgentTitle();
    this.allowTempSave        = other.getAllowTempSave();
    this.allowConfirm         = other.getAllowConfirm();
    this.customerFooter       = other.getCustomerFooter();
    this.customerIntroduction = other.getCustomerIntroduction();
    this.customerTitle        = other.getCustomerTitle();
    this.description          = other.getDescription();
// this.entryCriteria            = other.getEntryCriteria();  ==NEW
    this.groupsPerRow = other.getGroupsPerRow();
    this.name         = other.getName();
// this.priority                 = other.getPriority();  ===NEW
    this.qaFixedTableLayOut       = other.getQaFixedTableLayOut();
    this.questionsPerRowInGroup   = other.getQuestionsPerRowInGroup();
    this.questionWidthPercentage  = other.getQuestionWidthPercentage();
    this.questionTableHeader      = other.getQuestionTableHeader();
    this.restartNumberPerGroup    = other.getRestartNumberPerGroup();
    this.showAgentIntroduction    = other.getShowAgentIntroduction();
    this.showCustomerIntroduction = other.getShowCustomerIntroduction();
    this.showGroupHeader          = other.getShowGroupHeader();
    this.showQuestionNumber       = other.getShowQuestionNumber();
    this.status                   = other.getStatus();
    this.taskCode                 = other.getTaskCode();
    this.taskFrequency            = other.getTaskFrequency();
    this.frequencyMinutes         = other.getFrequencyMinutes();

// this.publishedDate            = other.getPublishedDate();
// this.publisher                = other.getPublisher();
// this.retirer                  = other.getRetirer();
// this.retiredDate              = other.getRetiredDate();
// this.actionsString            = other.getActions().toString();
// this.nextPagesString          = other.getNextPages().toString();
    this.groupTasksString = other.getGroups().toString();
    this.locked           = other.getLocked();
    this.customerOnly     = other.getCustomerOnly();
    this.submitButtonText = other.getSubmitButtonText();
    this.changeButtonText = other.getChangeButtonText();
    this.btnAlignmentMode = other.getBtnAlignmentMode();
    this.version          = (other.getCurrentVersion() != null) ? other.getCurrentVersion().getVersion() : 1;
    this.active           = other.getActive();
    this.creator          = other.getCreator();
    this.lastUpdater      = other.getLastUpdater();
    this.lastUpdateDate   = new Date();

    this.showAgentPrintButton = other.getShowAgentPrintButton();
    this.showAgentPostText    = other.getShowAgentPostText();
    this.showCustomerPostText = other.getShowCustomerPostText();

    this.endFlow            = other.getEndFlow();
    this.endFlowUrl         = other.getEndFlowUrl();
    this.agentPostText      = other.getAgentPostText();
    this.allowPrevious      = other.getAllowPrevious();
    this.allowNext          = other.getAllowNext();
    this.allowCancel        = other.getAllowCancel();
    this.tempSaveButtonText = other.getTempSaveButtonText();
    this.previousButtonText = other.getPreviousButtonText();
    this.nextButtonText     = other.getNextButtonText();
    this.cancelButtonText   = other.getCancelButtonText();
    this.cancelButtonURL    = other.getCancelButtonURL();
    this.qaTextWidth        = other.getQaTextWidth();
    this.flexSiteNATitle    = other.getFlexSiteNATitle();
    this.flexSiteNAText     = other.getFlexSiteNAText();
    this.flexStationNATitle = other.getFlexStationNATitle();
    this.flexStationNAText  = other.getFlexStationNAText();
    this.activeBy           = other.getActiveBy();
    this.activeDate         = other.getActiveDate();

    this.asGather                              = other.getAsGather();
    this.flexStationEndFlowTextAfterSubmission = other.getFlexStationEndFlowTextAfterSubmission();
    this.allowSkip             = other.getAllowSkip();
    this.skipButtonText        = other.getSkipButtonText();
    this.skipButtonWarningText = other.getSkipButtonWarningText();
  } // end method update
} // end class BCWorkflowTaskAudit
