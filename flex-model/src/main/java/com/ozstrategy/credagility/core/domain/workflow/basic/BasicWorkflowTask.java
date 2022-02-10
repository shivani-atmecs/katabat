package com.ozstrategy.credagility.core.domain.workflow.basic;

import com.cmc.credagility.core.domain.user.User;
import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.CreatorEntity;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowTaskStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;


/**
 * Created with IntelliJ IDEA.
 *
 * <p>: Wang Yang : 13-2-19 : PM5:48</p>
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@MappedSuperclass public abstract class BasicWorkflowTask extends CreatorEntity implements Serializable {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** <code>true</code> this task is active. */
  @Column(
    name             = "active",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean active;

  /** Acitve user. */
  @JoinColumn(
    name       = "activeBy",
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected User activeBy;
  @Column(columnDefinition = "LONGTEXT")
  @Lob
  protected String         skipButtonText;

  /** DOCUMENT ME! */
  @Column(columnDefinition = "LONGTEXT")
  @Lob
  protected String         skipButtonWarningText;
  @Column(columnDefinition = "char",length = 1)
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean         allowSkip;

  public String getSkipButtonText() {
    return skipButtonText;
  }

  public void setSkipButtonText(String skipButtonText) {
    this.skipButtonText = skipButtonText;
  }

  public String getSkipButtonWarningText() {
    return skipButtonWarningText;
  }

  public void setSkipButtonWarningText(String skipButtonWarningText) {
    this.skipButtonWarningText = skipButtonWarningText;
  }

  public Boolean getAllowSkip() {
    return allowSkip;
  }

  public void setAllowSkip(Boolean allowSkip) {
    this.allowSkip = allowSkip;
  }

  /** Acitve date. */
  @Column(
    name      = "activeDate",
    nullable  = true,
    updatable = false
  )
  @Temporal(TemporalType.TIMESTAMP)
  protected Date activeDate;

  /** agent footer on agent workstation. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String agentFooter;

  /** Show task introduction on agent workstation. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String agentIntroduction;

  /** Post Task Text on Agent Workstation. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String agentPostText;

  /** agent footer on agent workstation. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String agentTitle;

  /** <code>true</code> allow across group. */
  @Column(
    name             = "alignAcrossGroup",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean alignAcrossGroup;

  /** <code>true</code> allow cancel, control cancel button show or not <code>true</code> show cancel button. */
  @Column(
    name             = "allowCancel",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowCancel;

  /** <code>true</code> allow confirm, control confirm button show or not <code>true</code> show confirm button. */
  @Column(
    name             = "allowConfirm",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowConfirm;

  /** <code>true</code> allow next, control next button show or not <code>true</code> show next button. */
  @Column(
    name             = "allowNext",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowNext;

  /** <code>true</code> allow previous, control previous button show or not <code>true</code> show previous button. */
  @Column(
    name             = "allowPrevious",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowPrevious;

  /** Allow customer to temporary save task and come back later. */
  @Column(
    name             = "allowTempSave",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowTempSave;

  /** Buttons Alignment Mode: Default, LEFT, RIGHT */
  @Column(length = 10)
  protected String btnAlignmentMode;

  /** Cancel button text. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String cancelButtonText;

  /** Cancel button url. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String cancelButtonURL;

  /** Change button text. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String changeButtonText;

  /** Task footer on agent workstation. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String customerFooter;

  /** Show task introduction on agent workstation. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String customerIntroduction;

  /** Only customer. */
  @Column(
    name             = "customerOnly",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean customerOnly;

  /** Post Task Text on Customer Site. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String customerPostText;

  /** agent footer on agent workstation. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String customerTitle;


  /** Task description. */
  @Column(length = 1024)
  protected String description;

  /** <code>true</code> this task is end task. */
  @Column(
    name             = "endFlow",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean endFlow;

  /** End flow url, it will trigger after exit end flow node. */
  @Column protected String endFlowUrl;

  /** No Access Text on FlexSite. */
  @Column protected String flexSiteNAText;

  /** No Access Title on FlexSite. */
  @Column protected String flexSiteNATitle;

  /** The text after click submit which on end flow node on flexStation. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String flexStationEndFlowTextAfterSubmission;

  /** No Access Text on FlexStation. */
  @Column protected String flexStationNAText;

  /** No Access Title on FlexStation. */
  @Column protected String flexStationNATitle;

  /** How many times can re-do in frequencyMinutes. */
  @Column protected Long frequencyMinutes;

  /** How many groups in perRow. */
  @Column protected Integer groupsPerRow;

  /** <code>true</code> this task is locked, can not update. */
  @Column(
    name             = "locked",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean locked;

  /** Task Name. Should be unique within Owner */
  @Column(
    length   = 256,
    nullable = false
  )
  protected String name;

  /** Next button text. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String nextButtonText;

  /** Previous button text. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String previousButtonText;

  /** <code>true</code> fixed layout. */
  @Column(
    name             = "qaFixedTableLayOut",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean qaFixedTableLayOut;

  /** Text Width. */
  @Column protected BigDecimal qaTextWidth;

  /** Questions per row in group. */
  @Column protected Integer questionsPerRowInGroup;

  /** <code>true</code> allow question table header. */
  @Column(
    name             = "questionTableHeader",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean questionTableHeader;

  /** Question width with percentage. */
  @Column protected Integer questionWidthPercentage;

  /** <code>true</code> allow restart number per-group. */
  @Column(
    name             = "restartNumberPerGroup",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean restartNumberPerGroup;


  /** flag for show introduction on agent workstation. */
  @Column(
    name             = "showAgentIntroduction",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean showAgentIntroduction;

  /** flag for show post-task text on agent workstation. */
  @Column(
    name             = "showAgentPostText",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean showAgentPostText;

  /** flag for show agent print button on agent workstation. */
  @Column(
    name             = "showAgentPrintButton",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean showAgentPrintButton;

  /** flag for show introduction on customer web site. */
  @Column(
    name             = "showCustomerIntroduction",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean showCustomerIntroduction;

  /** flag for show post-task text on customer web site. */
  @Column(
    name             = "showCustomerPostText",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean showCustomerPostText;

  /** Show Header for task group. */
  @Column(
    name             = "showGroupHeader",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean showGroupHeader = true;

  /** <code>true</code> show question number start with NO.1. */
  @Column(
    name             = "showQuestionNumber",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean showQuestionNumber;

  /**
   * <p>Task status: 'DRAFT'/'RETIRED'/'ACTIVE'. Default is 'DRAFT'.</p>
   *
   * <ul>
   *   <li>1. Only 'DRAFT' task can be edited;</li>
   *   <li>2. When status="RETIRED" and locked="Y", this task can not be removed;</li>
   *   <li>3. When adding and editing a task: a. find the "CURRENT" task with the same task code, set it to "RETIRED".
   *     b. If no "CURRENT", do nothing.Set itself to "CURRENT"</li>
   *   <li>4. When publishing task schedule: a. find all ACTIVE task in DB and set to "RETIRED" b. find all tasks in
   *     schedule and set to "ACTIVE", locked='Y'</li>
   * </ul>
   */
  @Column(length = 16)
  @Enumerated(value = EnumType.STRING)
  protected WorkflowTaskStatus status = WorkflowTaskStatus.DRAFT;

  /** Submit button text. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String submitButtonText;

  /** Client defined code for task. */
  @Column(length = 16)
  protected String taskCode;

  /** How many time re-do this task. */
  @Column protected Integer taskFrequency;

  /** Temp save button text. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String tempSaveButtonText;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public abstract Set<? extends BasicWorkflowTaskGroup> getGroups();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public abstract Long getId();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public abstract Set<? extends BasicWorkflowTaskGroupElement> getTaskElements();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  o  DOCUMENT ME!
   */
  public void copy(BasicWorkflowTask o) {
    this.agentFooter                           = o.getAgentFooter();
    this.agentIntroduction                     = o.getAgentIntroduction();
    this.agentPostText                         = o.getAgentPostText();
    this.agentTitle                            = o.getAgentTitle();
    this.alignAcrossGroup                      = o.getAlignAcrossGroup();
    this.allowConfirm                          = o.getAllowConfirm();
    this.allowTempSave                         = o.getAllowTempSave();
    this.allowPrevious                         = o.getAllowPrevious();
    this.allowNext                             = o.getAllowNext();
    this.allowCancel                           = o.getAllowCancel();
    this.tempSaveButtonText                    = o.getTempSaveButtonText();
    this.previousButtonText                    = o.getPreviousButtonText();
    this.nextButtonText                        = o.getNextButtonText();
    this.cancelButtonText                      = o.getCancelButtonText();
    this.cancelButtonURL                       = o.getCancelButtonURL();
    this.customerFooter                        = o.getCustomerFooter();
    this.customerIntroduction                  = o.getCustomerIntroduction();
    this.customerPostText                      = o.getCustomerPostText();
    this.customerTitle                         = o.getCustomerTitle();
    this.description                           = o.getDescription();
    this.groupsPerRow                          = o.getGroupsPerRow();
    this.name                                  = o.getName();
    this.customerOnly                          = o.getCustomerOnly();
    this.active                                = o.getActive();
    this.qaFixedTableLayOut                    = o.getQaFixedTableLayOut();
    this.qaTextWidth                           = o.getQaTextWidth();
    this.questionsPerRowInGroup                = o.getQuestionsPerRowInGroup();
    this.questionTableHeader                   = o.getQuestionTableHeader();
    this.questionWidthPercentage               = o.getQuestionWidthPercentage();
    this.restartNumberPerGroup                 = o.getRestartNumberPerGroup();
    this.showAgentIntroduction                 = o.getShowAgentIntroduction();
    this.showAgentPostText                     = o.getShowAgentPostText();
    this.showCustomerIntroduction              = o.getShowCustomerIntroduction();
    this.showCustomerPostText                  = o.getShowCustomerPostText();
    this.showGroupHeader                       = o.getShowGroupHeader();
    this.showQuestionNumber                    = o.getShowQuestionNumber();
    this.status                                = o.getStatus();
    this.flexSiteNATitle                       = o.getFlexSiteNATitle();
    this.flexSiteNAText                        = o.getFlexSiteNAText();
    this.flexStationNATitle                    = o.getFlexStationNATitle();
    this.flexStationNAText                     = o.getFlexStationNAText();
    this.submitButtonText                      = o.getSubmitButtonText();
    this.changeButtonText                      = o.getChangeButtonText();
    this.btnAlignmentMode                      = o.getBtnAlignmentMode();
    this.endFlow                               = o.getEndFlow();
    this.endFlowUrl                            = o.getEndFlowUrl();
    this.activeBy                              = o.getActiveBy();
    this.activeDate                            = o.getActiveDate();
    this.taskCode                              = o.getTaskCode();
    this.showAgentPrintButton                  = o.getShowAgentPrintButton();
    this.flexStationEndFlowTextAfterSubmission = o.getFlexStationEndFlowTextAfterSubmission();
    this.allowSkip                             = o.getAllowSkip();
    this.skipButtonText                        = o.getSkipButtonText();
    this.skipButtonWarningText                 = o.getSkipButtonWarningText();

  } // end method copy

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  o  DOCUMENT ME!
   */
  public void duplicate(BasicWorkflowTask o) {
    this.agentFooter          = o.getAgentFooter();
    this.agentIntroduction    = o.getAgentIntroduction();
    this.agentPostText        = o.getAgentPostText();
    this.agentTitle           = o.getAgentTitle();
    this.alignAcrossGroup     = o.getAlignAcrossGroup();
    this.allowConfirm         = o.getAllowConfirm();
    this.allowTempSave        = o.getAllowTempSave();
    this.allowPrevious        = o.getAllowPrevious();
    this.allowNext            = o.getAllowNext();
    this.allowCancel          = o.getAllowCancel();
    this.tempSaveButtonText   = o.getTempSaveButtonText();
    this.previousButtonText   = o.getPreviousButtonText();
    this.nextButtonText       = o.getNextButtonText();
    this.cancelButtonText     = o.getCancelButtonText();
    this.cancelButtonURL      = o.getCancelButtonURL();
    this.customerFooter       = o.getCustomerFooter();
    this.customerIntroduction = o.getCustomerIntroduction();
    this.customerPostText     = o.getCustomerPostText();
    this.customerTitle        = o.getCustomerTitle();
    this.description          = o.getDescription();
    this.groupsPerRow         = o.getGroupsPerRow();
    this.name                 = o.getName();
    this.customerOnly         = o.getCustomerOnly();

    // this.publishedDate = o.getPublishedDate();
    this.qaFixedTableLayOut      = o.getQaFixedTableLayOut();
    this.qaTextWidth             = o.getQaTextWidth();
    this.questionsPerRowInGroup  = o.getQuestionsPerRowInGroup();
    this.questionTableHeader     = o.getQuestionTableHeader();
    this.questionWidthPercentage = o.getQuestionWidthPercentage();
    this.restartNumberPerGroup   = o.getRestartNumberPerGroup();

    // this.retiredDate = o.getRetiredDate();
    this.showAgentIntroduction    = o.getShowAgentIntroduction();
    this.showAgentPostText        = o.getShowAgentPostText();
    this.showCustomerIntroduction = o.getShowCustomerIntroduction();
    this.showCustomerPostText     = o.getShowCustomerPostText();
    this.showGroupHeader          = o.getShowGroupHeader();
    this.showQuestionNumber       = o.getShowQuestionNumber();
    this.status                   = o.getStatus();
    this.taskCode                 = o.getTaskCode();
    this.taskFrequency            = o.getTaskFrequency();

    this.flexSiteNATitle    = o.getFlexSiteNATitle();
    this.flexSiteNAText     = o.getFlexSiteNAText();
    this.flexStationNATitle = o.getFlexStationNATitle();
    this.flexStationNAText  = o.getFlexStationNAText();
    this.submitButtonText   = o.getSubmitButtonText();
    this.changeButtonText   = o.getChangeButtonText();

    this.endFlow                               = o.getEndFlow();
    this.endFlowUrl                            = o.getEndFlowUrl();
    this.btnAlignmentMode                      = o.getBtnAlignmentMode();
    this.showAgentPrintButton                  = o.getShowAgentPrintButton();
    this.flexStationEndFlowTextAfterSubmission = o.getFlexStationEndFlowTextAfterSubmission();
    this.allowSkip                             = o.getAllowSkip();
    this.skipButtonText                        = o.getSkipButtonText();
    this.skipButtonWarningText                 = o.getSkipButtonWarningText();

  } // end method duplicate

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

    BasicWorkflowTask that = (BasicWorkflowTask) o;

    if (!name.equals(that.name)) {
      return false;
    }

    if (!taskCode.equals(that.taskCode)) {
      return false;
    }

    if (!status.equals(that.status)) {
      return false;
    }

    if ((active != null) ? (!active.equals(that.active)) : (that.active != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getActive() {
    if (active == null) {
      return false;
    }

    return active;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public User getActiveBy() {
    return activeBy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getActiveDate() {
    return activeDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getAgentFooter() {
    return agentFooter;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getAgentIntroduction() {
    return agentIntroduction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getAgentPostText() {
    return agentPostText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getAgentTitle() {
    return agentTitle;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAlignAcrossGroup() {
    if (alignAcrossGroup == null) {
      return Boolean.FALSE;
    }

    return alignAcrossGroup;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAllowCancel() {
    if (allowCancel == null) {
      return Boolean.FALSE;
    }

    return allowCancel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAllowConfirm() {
    if (allowConfirm == null) {
      return Boolean.FALSE;
    }

    return allowConfirm;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAllowNext() {
    if (allowNext == null) {
      return Boolean.FALSE;
    }

    return allowNext;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAllowPrevious() {
    if (allowPrevious == null) {
      return Boolean.FALSE;
    }

    return allowPrevious;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAllowTempSave() {
    if (allowTempSave == null) {
      return Boolean.FALSE;
    }

    return allowTempSave;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getBtnAlignmentMode() {
    return btnAlignmentMode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getCancelButtonText() {
    return cancelButtonText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getCancelButtonURL() {
    return cancelButtonURL;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getChangeButtonText() {
    return changeButtonText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getCustomerFooter() {
    return customerFooter;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getCustomerIntroduction() {
    return customerIntroduction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getCustomerOnly() {
    if (customerOnly == null) {
      return Boolean.FALSE;
    }

    return customerOnly;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getCustomerPostText() {
    return customerPostText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getCustomerTitle() {
    return customerTitle;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDescription() {
    return description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getEndFlow() {
    if (endFlow == null) {
      return Boolean.FALSE;
    }

    return endFlow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getEndFlowUrl() {
    return endFlowUrl;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getFlexSiteNAText() {
    return flexSiteNAText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getFlexSiteNATitle() {
    return flexSiteNATitle;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for flex station end flow text after submission.
   *
   * @return  String
   */
  public String getFlexStationEndFlowTextAfterSubmission() {
    return flexStationEndFlowTextAfterSubmission;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getFlexStationNAText() {
    return flexStationNAText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getFlexStationNATitle() {
    return flexStationNATitle;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getFrequencyMinutes() {
    return frequencyMinutes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getGroupsPerRow() {
    return groupsPerRow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getLocked() {
    if (locked == null) {
      return Boolean.FALSE;
    }

    return locked;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getName() {
    return name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getNextButtonText() {
    return nextButtonText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPreviousButtonText() {
    return previousButtonText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getQaFixedTableLayOut() {
    if (qaFixedTableLayOut == null) {
      return Boolean.FALSE;
    }

    return qaFixedTableLayOut;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getQaTextWidth() {
    return qaTextWidth;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getQuestionsPerRowInGroup() {
    return questionsPerRowInGroup;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getQuestionTableHeader() {
    if (questionTableHeader == null) {
      return Boolean.FALSE;
    }

    return questionTableHeader;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getQuestionWidthPercentage() {
    return questionWidthPercentage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getRestartNumberPerGroup() {
    if (restartNumberPerGroup == null) {
      return Boolean.FALSE;
    }

    return restartNumberPerGroup;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getShowAgentIntroduction() {
    if (showAgentIntroduction == null) {
      return Boolean.FALSE;
    }

    return showAgentIntroduction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getShowAgentPostText() {
    if (showAgentPostText == null) {
      return Boolean.FALSE;
    }

    return showAgentPostText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getShowAgentPrintButton() {
    if (showAgentPrintButton == null) {
      return Boolean.FALSE;
    }

    return showAgentPrintButton;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getShowCustomerIntroduction() {
    if (showCustomerIntroduction == null) {
      return Boolean.FALSE;
    }

    return showCustomerIntroduction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getShowCustomerPostText() {
    if (showCustomerPostText == null) {
      return Boolean.FALSE;
    }

    return showCustomerPostText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getShowGroupHeader() {
    if (showGroupHeader == null) {
      return Boolean.FALSE;
    }

    return showGroupHeader;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getShowQuestionNumber() {
    if (showQuestionNumber == null) {
      return Boolean.FALSE;
    }

    return showQuestionNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public WorkflowTaskStatus getStatus() {
    return status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getSubmitButtonText() {
    return submitButtonText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTaskCode() {
    return taskCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getTaskFrequency() {
    return taskFrequency;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTempSaveButtonText() {
    return tempSaveButtonText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + name.hashCode();
    result = (31 * result) + ((taskCode != null) ? taskCode.hashCode() : 0);
    result = (31 * result) + status.hashCode();
    result = (31 * result) + ((active != null) ? active.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  active  DOCUMENT ME!
   */
  public void setActive(Boolean active) {
    this.active = active;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  activeBy  DOCUMENT ME!
   */
  public void setActiveBy(User activeBy) {
    this.activeBy = activeBy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  activeDate  DOCUMENT ME!
   */
  public void setActiveDate(Date activeDate) {
    this.activeDate = activeDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  agentFooter  DOCUMENT ME!
   */
  public void setAgentFooter(String agentFooter) {
    this.agentFooter = agentFooter;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  agentIntroduction  DOCUMENT ME!
   */
  public void setAgentIntroduction(String agentIntroduction) {
    this.agentIntroduction = agentIntroduction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  agentPostText  DOCUMENT ME!
   */
  public void setAgentPostText(String agentPostText) {
    this.agentPostText = agentPostText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  agentTitle  DOCUMENT ME!
   */
  public void setAgentTitle(String agentTitle) {
    this.agentTitle = agentTitle;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  alignAcrossGroup  DOCUMENT ME!
   */
  public void setAlignAcrossGroup(Boolean alignAcrossGroup) {
    this.alignAcrossGroup = alignAcrossGroup;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  allowCancel  DOCUMENT ME!
   */
  public void setAllowCancel(Boolean allowCancel) {
    this.allowCancel = allowCancel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  allowConfirm  DOCUMENT ME!
   */
  public void setAllowConfirm(Boolean allowConfirm) {
    this.allowConfirm = allowConfirm;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  allowNext  DOCUMENT ME!
   */
  public void setAllowNext(Boolean allowNext) {
    this.allowNext = allowNext;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  allowPrevious  DOCUMENT ME!
   */
  public void setAllowPrevious(Boolean allowPrevious) {
    this.allowPrevious = allowPrevious;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  allowTempSave  DOCUMENT ME!
   */
  public void setAllowTempSave(Boolean allowTempSave) {
    this.allowTempSave = allowTempSave;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  btnAlignmentMode  DOCUMENT ME!
   */
  public void setBtnAlignmentMode(String btnAlignmentMode) {
    this.btnAlignmentMode = btnAlignmentMode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  cancelButtonText  DOCUMENT ME!
   */
  public void setCancelButtonText(String cancelButtonText) {
    this.cancelButtonText = cancelButtonText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  cancelButtonURL  DOCUMENT ME!
   */
  public void setCancelButtonURL(String cancelButtonURL) {
    this.cancelButtonURL = cancelButtonURL;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  changeButtonText  DOCUMENT ME!
   */
  public void setChangeButtonText(String changeButtonText) {
    this.changeButtonText = changeButtonText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  customerFooter  DOCUMENT ME!
   */
  public void setCustomerFooter(String customerFooter) {
    this.customerFooter = customerFooter;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  customerIntroduction  DOCUMENT ME!
   */
  public void setCustomerIntroduction(String customerIntroduction) {
    this.customerIntroduction = customerIntroduction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  customerOnly  DOCUMENT ME!
   */
  public void setCustomerOnly(Boolean customerOnly) {
    this.customerOnly = customerOnly;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  customerPostText  DOCUMENT ME!
   */
  public void setCustomerPostText(String customerPostText) {
    this.customerPostText = customerPostText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  customerTitle  DOCUMENT ME!
   */
  public void setCustomerTitle(String customerTitle) {
    this.customerTitle = customerTitle;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  description  DOCUMENT ME!
   */
  public void setDescription(String description) {
    this.description = description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  endFlow  DOCUMENT ME!
   */
  public void setEndFlow(Boolean endFlow) {
    this.endFlow = endFlow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  endFlowUrl  DOCUMENT ME!
   */
  public void setEndFlowUrl(String endFlowUrl) {
    this.endFlowUrl = endFlowUrl;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  flexSiteNAText  DOCUMENT ME!
   */
  public void setFlexSiteNAText(String flexSiteNAText) {
    this.flexSiteNAText = flexSiteNAText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  flexSiteNATitle  DOCUMENT ME!
   */
  public void setFlexSiteNATitle(String flexSiteNATitle) {
    this.flexSiteNATitle = flexSiteNATitle;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for flex station end flow text after submission.
   *
   * @param  flexStationEndFlowTextAfterSubmission  String
   */
  public void setFlexStationEndFlowTextAfterSubmission(String flexStationEndFlowTextAfterSubmission) {
    this.flexStationEndFlowTextAfterSubmission = flexStationEndFlowTextAfterSubmission;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  flexStationNAText  DOCUMENT ME!
   */
  public void setFlexStationNAText(String flexStationNAText) {
    this.flexStationNAText = flexStationNAText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  flexStationNATitle  DOCUMENT ME!
   */
  public void setFlexStationNATitle(String flexStationNATitle) {
    this.flexStationNATitle = flexStationNATitle;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  frequencyMinutes  DOCUMENT ME!
   */
  public void setFrequencyMinutes(Long frequencyMinutes) {
    this.frequencyMinutes = frequencyMinutes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  groupsPerRow  DOCUMENT ME!
   */
  public void setGroupsPerRow(Integer groupsPerRow) {
    this.groupsPerRow = groupsPerRow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  locked  DOCUMENT ME!
   */
  public void setLocked(Boolean locked) {
    this.locked = locked;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  name  DOCUMENT ME!
   */
  public void setName(String name) {
    this.name = name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  nextButtonText  DOCUMENT ME!
   */
  public void setNextButtonText(String nextButtonText) {
    this.nextButtonText = nextButtonText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  previousButtonText  DOCUMENT ME!
   */
  public void setPreviousButtonText(String previousButtonText) {
    this.previousButtonText = previousButtonText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  qaFixedTableLayOut  DOCUMENT ME!
   */
  public void setQaFixedTableLayOut(Boolean qaFixedTableLayOut) {
    this.qaFixedTableLayOut = qaFixedTableLayOut;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  qaTextWidth  DOCUMENT ME!
   */
  public void setQaTextWidth(BigDecimal qaTextWidth) {
    this.qaTextWidth = qaTextWidth;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  questionsPerRowInGroup  DOCUMENT ME!
   */
  public void setQuestionsPerRowInGroup(Integer questionsPerRowInGroup) {
    this.questionsPerRowInGroup = questionsPerRowInGroup;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  questionTableHeader  DOCUMENT ME!
   */
  public void setQuestionTableHeader(Boolean questionTableHeader) {
    this.questionTableHeader = questionTableHeader;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  questionWidthPercentage  DOCUMENT ME!
   */
  public void setQuestionWidthPercentage(Integer questionWidthPercentage) {
    this.questionWidthPercentage = questionWidthPercentage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  restartNumberPerGroup  DOCUMENT ME!
   */
  public void setRestartNumberPerGroup(Boolean restartNumberPerGroup) {
    this.restartNumberPerGroup = restartNumberPerGroup;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  showAgentIntroduction  DOCUMENT ME!
   */
  public void setShowAgentIntroduction(Boolean showAgentIntroduction) {
    this.showAgentIntroduction = showAgentIntroduction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  showAgentPostText  DOCUMENT ME!
   */
  public void setShowAgentPostText(Boolean showAgentPostText) {
    this.showAgentPostText = showAgentPostText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  showAgentPrintButton  DOCUMENT ME!
   */
  public void setShowAgentPrintButton(Boolean showAgentPrintButton) {
    this.showAgentPrintButton = showAgentPrintButton;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  showCustomerIntroduction  DOCUMENT ME!
   */
  public void setShowCustomerIntroduction(Boolean showCustomerIntroduction) {
    this.showCustomerIntroduction = showCustomerIntroduction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  showCustomerPostText  DOCUMENT ME!
   */
  public void setShowCustomerPostText(Boolean showCustomerPostText) {
    this.showCustomerPostText = showCustomerPostText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  showGroupHeader  DOCUMENT ME!
   */
  public void setShowGroupHeader(Boolean showGroupHeader) {
    this.showGroupHeader = showGroupHeader;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  showQuestionNumber  DOCUMENT ME!
   */
  public void setShowQuestionNumber(Boolean showQuestionNumber) {
    this.showQuestionNumber = showQuestionNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  status  DOCUMENT ME!
   */
  public void setStatus(WorkflowTaskStatus status) {
    this.status = status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  submitButtonText  DOCUMENT ME!
   */
  public void setSubmitButtonText(String submitButtonText) {
    this.submitButtonText = submitButtonText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  taskCode  DOCUMENT ME!
   */
  public void setTaskCode(String taskCode) {
    this.taskCode = taskCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  taskFrequency  DOCUMENT ME!
   */
  public void setTaskFrequency(Integer taskFrequency) {
    this.taskFrequency = taskFrequency;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  tempSaveButtonText  DOCUMENT ME!
   */
  public void setTempSaveButtonText(String tempSaveButtonText) {
    this.tempSaveButtonText = tempSaveButtonText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * toString.
   *
   * @return  String
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("WorkflowTask");
    sb.append("{name='").append(name).append('\'');
    sb.append(", status='").append(status).append('\'');
    sb.append(", taskCode='").append(taskCode).append('\'');
    sb.append('}');

    return sb.toString();
  }
} // end class BasicWorkflowTask
