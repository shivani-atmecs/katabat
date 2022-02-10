package com.cmc.credagility.core.domain.portfolio;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.*;

import com.cmc.credagility.core.domain.base.CreatorEntity;
import com.cmc.credagility.core.domain.user.User;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * Created by IntelliJ IDEA. User: ye Date: May 6, 2010 Time: 4:03:42 PM To change this template use File | Settings |
 * File Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@MappedSuperclass public class AbstractPortfolioSurvey extends CreatorEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 9160191996925838711L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  @Column(
    name             = "active",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean active;

  /** DOCUMENT ME! */
  @JoinColumn(
    name       = "activeBy",
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected User activeBy;

  /** DOCUMENT ME! */
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

  /** Show survey introduction on agent workstation. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String agentIntroduction;

  /** Post Survey Text on Agent Workstation. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String agentPostText;

  /** agent footer on agent workstation. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String agentTitle;

  /** DOCUMENT ME! */
  @Column(
    name             = "alignAcrossGroup",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean alignAcrossGroup;

  /** DOCUMENT ME! */
  @Column(
    name             = "allowCancel",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowCancel;

  /** When <code>true</code> workflow instance will cancelled when click cancel button in flexSite. */
  @Column(
    name             = "allowCancelWorkflowInFlexSite",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowCancelWorkflowInFlexSite;

  /** When <code>true</code> workflow instance will cancelled when click cancel button in flexStation. */
  @Column(
    name             = "allowCancelWorkflowInFlexStation",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowCancelWorkflowInFlexStation;

  /** DOCUMENT ME! */
  @Column(
    name             = "allowConfirm",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowConfirm;

  /** DOCUMENT ME! */
  @Column(
    name             = "allowNext",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowNext;

  /** DOCUMENT ME! */
  @Column(
    name             = "allowPrevious",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowPrevious;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "allowSkip",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowSkip;

  /** Allow customer to temparory save survey and come back later. */
  @Column(
    name             = "allowTempSave",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowTempSave;

  /** Buttons Alignment Mode: Default, LEFT, RIGHT */
  @Column(length = 10)
  protected String btnAlignmentMode;

  /** Set the cancel button text default is 'Cancel'. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String cancelButtonText;

  /** The page will go when cancel button clicked. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String cancelButtonURL;

  /** Set the change button text default is 'Change'. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String changeButtonText;

  /** The text after clicking next button which on end flow node on flexStation. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String customerEndFlowTextAfterNext;

  /** The text after click submit which on end flow node on flexSite. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String customerEndFlowTextAfterSubmission;

  /** survey footer on agent workstation. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String customerFooter;

  /** Show survey introduction on agent workstation. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String customerIntroduction;

  /** The survey can only be used in customer site. */
  @Column(
    name             = "customerOnly",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean customerOnly;

  /** Post Survey Text on Customer Site. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String customerPostText;

  /** agent footer on agent workstation. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String customerTitle;

  /** Survey description. */
  @Column(length = 1024)
  protected String description;

  /** DOCUMENT ME! */
  @Column(
    name             = "endFlow",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean endFlow;

  /** DOCUMENT ME! */
  @Column protected String endFlowUrl;

  /** Criteria for enter this survey. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String entryCriteria;

  /** The date of expiration expression. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String expirationDateExpression;

  /** No Access Text on FlexSite. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String flexSiteNAText;

  /** No Access Title on FlexSite. */
  @Column(length = 255)
  protected String flexSiteNATitle;

  /** The text after clicking next button which on end flow node on flexSite. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String flexStationEndFlowTextAfterNext;


  /** The text after click submit which on end flow node on flexStation. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String flexStationEndFlowTextAfterSubmission;

  /** No Access Text on FlexStation. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String flexStationNAText;

  /** No Access Title on FlexStation. */
  @Column(length = 255)
  protected String flexStationNATitle;

  /** how much groups in per row default is 1. */
  @Column protected Integer groupsPerRow;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "locked",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean locked;


  /** Survey Name. Should be uni within Portfolio */
  @Column(
    length   = 256,
    nullable = false
  )
  protected String name;

  /** Set next button text default is 'Next'. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String nextButtonText;


  /** The portfolio which schedule belong to. */
  @JoinColumn(
    name       = "portfolioId",
    nullable   = false,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Portfolio portfolio = new Portfolio();

  /** Set the previous button text default is 'Previous'. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String previousButtonText;

  /** allow survey to be prioritized. */
  @Column protected Integer priority;


  /** DOCUMENT ME! */
  @Column(
    name      = "publishedDate",
    nullable  = true,
    updatable = true
  )
  @Temporal(TemporalType.TIMESTAMP)
  protected Date publishedDate;

  /** Create date. */
  @JoinColumn(
    name       = "publisherId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected User publisher;

  /** DOCUMENT ME! */
  @Column(
    name             = "qaFixedTableLayOut",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean qaFixedTableLayOut;

  /** DOCUMENT ME! */
  @Column protected BigDecimal qaTextWidth;

  /** DOCUMENT ME! */
  @Column protected Integer questionsPerRowInGroup;

  /** DOCUMENT ME! */
  @Column(
    name             = "questionTableHeader",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean questionTableHeader;


  /** DOCUMENT ME! */
  @Column protected Integer questionWidthPercentage;

  /** DOCUMENT ME! */
  @Column(
    name             = "restartNumberPerGroup",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean restartNumberPerGroup;

  /** DOCUMENT ME! */
  @Column(
    name      = "retiredDate",
    nullable  = true,
    updatable = true
  )
  @Temporal(TemporalType.TIMESTAMP)
  protected Date retiredDate;

  /** Last Updater. */
  @JoinColumn(
    name       = "retirerId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected User retirer;

  /** flag for show introduction on agent workstation. */
  @Column(
    name             = "showAgentIntroduction",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean showAgentIntroduction;

  /** flag for show post-survey text on agent workstation. */
  @Column(
    name             = "showAgentPostText",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean showAgentPostText;

  /** DOCUMENT ME! */
  @Column(
    name             = "showAgentPrintButton",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean showAgentPrintButton;

  /** flag for show introduction on customer web site. */
  @Column(
    name             = "showCustomerIntroduction",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean showCustomerIntroduction;

  /** flag for show post-survey text on customer web site. */
  @Column(
    name             = "showCustomerPostText",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean showCustomerPostText;

  /** DOCUMENT ME! */
  @Column(
    name             = "showCustomerPrintButton",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean showCustomerPrintButton;


  /** Show Header for survey group. */
  @Column(
    name             = "showGroupHeader",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean showGroupHeader = true;

  /** DOCUMENT ME! */
  @Column(
    name             = "showQuestionNumber",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean showQuestionNumber;

  /** Set the skip button text default is 'Skip'. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String skipButtonText;

  /** Show warning message when click 'Skip' button. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String skipButtonWarningText;

  /** Survey staus 'DRAFT'/'PUBLISH'. */
  /**
   * Wang Yang[2012-03-21]: Survey status 'DRAFT'/'RETIRED'/'ACTIVE', default 'CURRENT' 1. Only 'CURRENT' survey can be
   * edited; 2. When status="RETIRED" and locked="Y", this survey can not be removed; 3. When adding and editing a
   * survey: a. find the "CURRENT" survey with the same survey code, set it to "RETIRED". b. If no "CURRENT", do
   * nothing.Set itself to "CURRENT" 4. When publishing survey schedule: a. find all ACTIVE survey in DB and set to
   * "RETIRED" b. find all surveys in schedule and set to "ACTIVE", locked='Y'
   */
  @Column(length = 16)
  protected String status = "DRAFT";

  /** Set the submit button text default is 'submit'. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String submitButtonText;

  /** The url of after submit 'submit' button on end task. */
  @Column(length = 255)
  protected String submitEndFlowUrl;

  /** Client defined code for survey. */
  @Column(length = 16)
  protected String surveyCode;

  /** Allowed survey frequency in hours. */
  @Column protected Integer surveyFrequency;

  /** Set the tempSave button text default is 'Temp Save'. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String tempSaveButtonText;

  /** Set the tempSave button text default is 'Temp Save'. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String confirmButtonText;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  o  DOCUMENT ME!
   */
  public void copy(PortfolioSurvey o) {
    this.agentFooter           = o.getAgentFooter();
    this.agentIntroduction     = o.getAgentIntroduction();
    this.agentPostText         = o.getAgentPostText();
    this.agentTitle            = o.getAgentTitle();
    this.alignAcrossGroup      = o.getAlignAcrossGroup();
    this.allowConfirm          = o.getAllowConfirm();
    this.allowTempSave         = o.getAllowTempSave();
    this.allowPrevious         = o.getAllowPrevious();
    this.allowSkip             = o.getAllowSkip();
    this.allowNext             = o.getAllowNext();
    this.allowCancel           = o.getAllowCancel();
    this.tempSaveButtonText    = o.getTempSaveButtonText();
    this.confirmButtonText     = o.getConfirmButtonText();
    this.previousButtonText    = o.getPreviousButtonText();
    this.nextButtonText        = o.getNextButtonText();
    this.cancelButtonText      = o.getCancelButtonText();
    this.cancelButtonURL       = o.getCancelButtonURL();
    this.skipButtonText        = o.getSkipButtonText();
    this.skipButtonWarningText = o.getSkipButtonWarningText();
    this.customerFooter        = o.getCustomerFooter();
    this.customerIntroduction  = o.getCustomerIntroduction();
    this.customerPostText      = o.getCustomerPostText();
    this.customerTitle         = o.getCustomerTitle();
    this.description           = o.getDescription();
    this.entryCriteria         = o.getEntryCriteria();
    this.groupsPerRow          = o.getGroupsPerRow();
    this.name                  = o.getName();
    this.portfolio             = o.getPortfolio();
    this.priority              = o.getPriority();
    this.customerOnly          = o.getCustomerOnly();
    // this.active               = o.getActive();

    // this.publishedDate = o.getPublishedDate();
    this.publisher               = o.getPublisher();
    this.qaFixedTableLayOut      = o.getQaFixedTableLayOut();
    this.qaTextWidth             = o.getQaTextWidth();
    this.questionsPerRowInGroup  = o.getQuestionsPerRowInGroup();
    this.questionTableHeader     = o.getQuestionTableHeader();
    this.questionWidthPercentage = o.getQuestionWidthPercentage();
    this.restartNumberPerGroup   = o.getRestartNumberPerGroup();

    // this.retiredDate = o.getRetiredDate();
    this.retirer                  = o.getRetirer();
    this.showAgentIntroduction    = o.getShowAgentIntroduction();
    this.showAgentPrintButton     = o.getShowAgentPrintButton();
    this.showAgentPostText        = o.getShowAgentPostText();
    this.showCustomerIntroduction = o.getShowCustomerIntroduction();
    this.showCustomerPrintButton  = o.getShowCustomerPrintButton();
    this.showCustomerPostText     = o.getShowCustomerPostText();
    this.showGroupHeader          = o.getShowGroupHeader();
    this.showQuestionNumber       = o.getShowQuestionNumber();
// this.status                   = o.getStatus();
    this.surveyCode      = o.getSurveyCode();
    this.surveyFrequency = o.getSurveyFrequency();

    this.flexSiteNATitle    = o.getFlexSiteNATitle();
    this.flexSiteNAText     = o.getFlexSiteNAText();
    this.flexStationNATitle = o.getFlexStationNATitle();
    this.flexStationNAText  = o.getFlexStationNAText();
    this.submitButtonText   = o.getSubmitButtonText();
    this.changeButtonText   = o.getChangeButtonText();
    this.btnAlignmentMode   = o.getBtnAlignmentMode();

    this.endFlow                  = o.getEndFlow();
    this.endFlowUrl               = o.getEndFlowUrl();
    this.expirationDateExpression = o.getExpirationDateExpression();

    // this.activeBy                 = o.getActiveBy();
    this.activeDate                            = o.getActiveDate();
    this.allowCancelWorkflowInFlexSite         = o.getAllowCancelWorkflowInFlexSite();
    this.allowCancelWorkflowInFlexStation      = o.getAllowCancelWorkflowInFlexStation();
    this.flexStationEndFlowTextAfterSubmission = o.getFlexStationEndFlowTextAfterSubmission();
    this.customerEndFlowTextAfterSubmission    = o.getCustomerEndFlowTextAfterSubmission();
    this.submitEndFlowUrl                      = o.getSubmitEndFlowUrl();
    this.customerEndFlowTextAfterNext          = o.getCustomerEndFlowTextAfterNext();
    this.flexStationEndFlowTextAfterNext       = o.getFlexStationEndFlowTextAfterNext();
  } // end method copy

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  o  DOCUMENT ME!
   */
  public void copy(AbstractPortfolioSurvey o) {
    this.agentFooter           = o.getAgentFooter();
    this.agentIntroduction     = o.getAgentIntroduction();
    this.agentPostText         = o.getAgentPostText();
    this.agentTitle            = o.getAgentTitle();
    this.alignAcrossGroup      = o.getAlignAcrossGroup();
    this.allowConfirm          = o.getAllowConfirm();
    this.allowTempSave         = o.getAllowTempSave();
    this.allowPrevious         = o.getAllowPrevious();
    this.allowSkip             = o.getAllowSkip();
    this.allowNext             = o.getAllowNext();
    this.allowCancel           = o.getAllowCancel();
    this.tempSaveButtonText    = o.getTempSaveButtonText();
    this.confirmButtonText     = o.getConfirmButtonText();
    this.previousButtonText    = o.getPreviousButtonText();
    this.nextButtonText        = o.getNextButtonText();
    this.cancelButtonText      = o.getCancelButtonText();
    this.cancelButtonURL       = o.getCancelButtonURL();
    this.skipButtonText        = o.getSkipButtonText();
    this.skipButtonWarningText = o.getSkipButtonWarningText();
    this.customerFooter        = o.getCustomerFooter();
    this.customerIntroduction  = o.getCustomerIntroduction();
    this.customerPostText      = o.getCustomerPostText();
    this.customerTitle         = o.getCustomerTitle();
    this.description           = o.getDescription();
    this.entryCriteria         = o.getEntryCriteria();
    this.groupsPerRow          = o.getGroupsPerRow();
    this.name                  = o.getName();
    this.portfolio             = o.getPortfolio();
    this.priority              = o.getPriority();
    this.customerOnly          = o.getCustomerOnly();

    // this.publishedDate = o.getPublishedDate();
    this.publisher               = o.getPublisher();
    this.qaFixedTableLayOut      = o.getQaFixedTableLayOut();
    this.qaTextWidth             = o.getQaTextWidth();
    this.questionsPerRowInGroup  = o.getQuestionsPerRowInGroup();
    this.questionTableHeader     = o.getQuestionTableHeader();
    this.questionWidthPercentage = o.getQuestionWidthPercentage();
    this.restartNumberPerGroup   = o.getRestartNumberPerGroup();

    // this.retiredDate = o.getRetiredDate();
    this.retirer                  = o.getRetirer();
    this.showAgentIntroduction    = o.getShowAgentIntroduction();
    this.showAgentPrintButton     = o.getShowAgentPrintButton();
    this.showAgentPostText        = o.getShowAgentPostText();
    this.showCustomerIntroduction = o.getShowCustomerIntroduction();
    this.showCustomerPrintButton  = o.getShowCustomerPrintButton();
    this.showCustomerPostText     = o.getShowCustomerPostText();
    this.showGroupHeader          = o.getShowGroupHeader();
    this.showQuestionNumber       = o.getShowQuestionNumber();
    this.status                   = o.getStatus();
    this.surveyCode               = o.getSurveyCode();
    this.surveyFrequency          = o.getSurveyFrequency();

    this.flexSiteNATitle    = o.getFlexSiteNATitle();
    this.flexSiteNAText     = o.getFlexSiteNAText();
    this.flexStationNATitle = o.getFlexStationNATitle();
    this.flexStationNAText  = o.getFlexStationNAText();
    this.submitButtonText   = o.getSubmitButtonText();
    this.changeButtonText   = o.getChangeButtonText();
    this.btnAlignmentMode   = o.getBtnAlignmentMode();

    this.endFlow                               = o.getEndFlow();
    this.endFlowUrl                            = o.getEndFlowUrl();
    this.expirationDateExpression              = o.getExpirationDateExpression();
    this.allowCancelWorkflowInFlexSite         = o.getAllowCancelWorkflowInFlexSite();
    this.allowCancelWorkflowInFlexStation      = o.getAllowCancelWorkflowInFlexStation();
    this.customerEndFlowTextAfterSubmission    = o.getCustomerEndFlowTextAfterSubmission();
    this.flexStationEndFlowTextAfterSubmission = o.getFlexStationEndFlowTextAfterSubmission();
    this.submitEndFlowUrl                      = o.getSubmitEndFlowUrl();
    this.customerEndFlowTextAfterNext          = o.getCustomerEndFlowTextAfterNext();
    this.flexStationEndFlowTextAfterNext       = o.getFlexStationEndFlowTextAfterNext();
  } // end method copy

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof AbstractPortfolioSurvey)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    AbstractPortfolioSurvey that = (AbstractPortfolioSurvey) o;

    if ((name != null) ? (!name.equals(that.name)) : (that.name != null)) {
      return false;
    }

    if ((createDate != null) ? (!createDate.equals(that.createDate)) : (that.createDate != null)) {
      return false;
    }

    if ((surveyCode != null) ? (!surveyCode.equals(that.surveyCode)) : (that.surveyCode != null)) {
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
      return Boolean.FALSE;
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
    if (alignAcrossGroup != null) {
      return alignAcrossGroup;
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAllowCancel() {
    if (allowCancel != null) {
      return allowCancel;
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for allow cancel workflow in flex site.
   *
   * @return  Boolean
   */
  public Boolean getAllowCancelWorkflowInFlexSite() {
    if (allowCancelWorkflowInFlexSite == null) {
      return Boolean.FALSE;
    }

    return allowCancelWorkflowInFlexSite;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for allow cancel workflow in flex station.
   *
   * @return  Boolean
   */
  public Boolean getAllowCancelWorkflowInFlexStation() {
    if (allowCancelWorkflowInFlexStation == null) {
      return Boolean.FALSE;
    }

    return allowCancelWorkflowInFlexStation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAllowConfirm() {
    if (allowConfirm != null) {
      return allowConfirm;
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAllowNext() {
    if (allowNext != null) {
      return allowNext;
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAllowPrevious() {
    if (allowPrevious != null) {
      return allowPrevious;
    }

    return Boolean.FALSE;

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for allow skip.
   *
   * @return  Boolean
   */
  public Boolean getAllowSkip() {
    if (allowSkip != null) {
      return allowSkip;
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAllowTempSave() {
    if (allowTempSave != null) {
      return allowTempSave;
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getBtnAlignmentMode() {
    if (btnAlignmentMode != null) {
      return btnAlignmentMode;
    }

    return "DEFAULT";
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
   * getter method for customer end flow text after next.
   *
   * @return  String
   */
  public String getCustomerEndFlowTextAfterNext() {
    return customerEndFlowTextAfterNext;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for customer end flow text after submission.
   *
   * @return  String
   */
  public String getCustomerEndFlowTextAfterSubmission() {
    return customerEndFlowTextAfterSubmission;
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
      return false;
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
  public String getEntryCriteria() {
    return entryCriteria;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getExpirationDateExpression() {
    return expirationDateExpression;
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
   * getter method for flex station end flow text after next.
   *
   * @return  String
   */
  public String getFlexStationEndFlowTextAfterNext() {
    return flexStationEndFlowTextAfterNext;
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
    if (locked != null) {
      return locked;
    }

    return Boolean.FALSE;
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
  public Portfolio getPortfolio() {
    return portfolio;
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
  public Integer getPriority() {
    return priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getPublishedDate() {
    return publishedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public User getPublisher() {
    return publisher;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getQaFixedTableLayOut() {
    if (qaFixedTableLayOut != null) {
      return qaFixedTableLayOut;
    }

    return Boolean.FALSE;
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
    if (questionTableHeader != null) {
      return questionTableHeader;
    }

    return Boolean.FALSE;
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
    if (restartNumberPerGroup != null) {
      return restartNumberPerGroup;
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getRetiredDate() {
    return retiredDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public User getRetirer() {
    return retirer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getShowAgentIntroduction() {
    if (this.showAgentIntroduction == null) {
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
    if (this.showAgentPostText == null) {
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
    if (this.showAgentPrintButton == null) {
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
    if (this.showCustomerIntroduction == null) {
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
    if (this.showCustomerPostText == null) {
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
  public Boolean getShowCustomerPrintButton() {
    if (this.showCustomerPrintButton == null) {
      return Boolean.FALSE;
    }

    return showCustomerPrintButton;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getShowGroupHeader() {
    if (this.showGroupHeader == null) {
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
    if (this.showQuestionNumber == null) {
      return Boolean.FALSE;
    }

    return showQuestionNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for skip button text.
   *
   * @return  String
   */
  public String getSkipButtonText() {
    return skipButtonText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for skip button warning text.
   *
   * @return  String
   */
  public String getSkipButtonWarningText() {
    return skipButtonWarningText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getStatus() {
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
   * getter method for submit end flow url.
   *
   * @return  String
   */
  public String getSubmitEndFlowUrl() {
    return submitEndFlowUrl;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getSurveyCode() {
    return surveyCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getSurveyFrequency() {
    return surveyFrequency;
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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getConfirmButtonText() {
    return confirmButtonText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((name != null) ? name.hashCode() : 0);
    result = (31 * result) + ((createDate != null) ? createDate.hashCode() : 0);
    result = (31 * result) + ((surveyCode != null) ? surveyCode.hashCode() : 0);
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
   * setter method for allow cancel workflow in flex site.
   *
   * @param  allowCancelWorkflowInFlexSite  Boolean
   */
  public void setAllowCancelWorkflowInFlexSite(Boolean allowCancelWorkflowInFlexSite) {
    this.allowCancelWorkflowInFlexSite = allowCancelWorkflowInFlexSite;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for allow cancel workflow in flex station.
   *
   * @param  allowCancelWorkflowInFlexStation  Boolean
   */
  public void setAllowCancelWorkflowInFlexStation(Boolean allowCancelWorkflowInFlexStation) {
    this.allowCancelWorkflowInFlexStation = allowCancelWorkflowInFlexStation;
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
   * setter method for allow skip.
   *
   * @param  allowSkip  Boolean
   */
  public void setAllowSkip(Boolean allowSkip) {
    this.allowSkip = allowSkip;
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
   * setter method for customer end flow text after next.
   *
   * @param  customerEndFlowTextAfterNext  String
   */
  public void setCustomerEndFlowTextAfterNext(String customerEndFlowTextAfterNext) {
    this.customerEndFlowTextAfterNext = customerEndFlowTextAfterNext;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for customer end flow text after submission.
   *
   * @param  customerEndFlowTextAfterSubmission  String
   */
  public void setCustomerEndFlowTextAfterSubmission(String customerEndFlowTextAfterSubmission) {
    this.customerEndFlowTextAfterSubmission = customerEndFlowTextAfterSubmission;
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
   * @param  entryCriteria  DOCUMENT ME!
   */
  public void setEntryCriteria(String entryCriteria) {
    this.entryCriteria = entryCriteria;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  expirationDateExpression  DOCUMENT ME!
   */
  public void setExpirationDateExpression(String expirationDateExpression) {
    this.expirationDateExpression = expirationDateExpression;
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
   * setter method for flex station end flow text after next.
   *
   * @param  flexStationEndFlowTextAfterNext  String
   */
  public void setFlexStationEndFlowTextAfterNext(String flexStationEndFlowTextAfterNext) {
    this.flexStationEndFlowTextAfterNext = flexStationEndFlowTextAfterNext;
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
   * @param  portfolio  DOCUMENT ME!
   */
  public void setPortfolio(Portfolio portfolio) {
    this.portfolio = portfolio;
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
   * @param  priority  DOCUMENT ME!
   */
  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  publishedDate  DOCUMENT ME!
   */
  public void setPublishedDate(Date publishedDate) {
    this.publishedDate = publishedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  publisher  DOCUMENT ME!
   */
  public void setPublisher(User publisher) {
    this.publisher = publisher;
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
   * @param  retiredDate  DOCUMENT ME!
   */
  public void setRetiredDate(Date retiredDate) {
    this.retiredDate = retiredDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  retirer  DOCUMENT ME!
   */
  public void setRetirer(User retirer) {
    this.retirer = retirer;
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
   * @param  showCustomerPrintButton  DOCUMENT ME!
   */
  public void setShowCustomerPrintButton(Boolean showCustomerPrintButton) {
    this.showCustomerPrintButton = showCustomerPrintButton;
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
   * setter method for skip button text.
   *
   * @param  skipButtonText  String
   */
  public void setSkipButtonText(String skipButtonText) {
    this.skipButtonText = skipButtonText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for skip button warning text.
   *
   * @param  skipButtonWarningText  String
   */
  public void setSkipButtonWarningText(String skipButtonWarningText) {
    this.skipButtonWarningText = skipButtonWarningText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  status  DOCUMENT ME!
   */
  public void setStatus(String status) {
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
   * setter method for submit end flow url.
   *
   * @param  submitEndFlowUrl  String
   */
  public void setSubmitEndFlowUrl(String submitEndFlowUrl) {
    this.submitEndFlowUrl = submitEndFlowUrl;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  surveyCode  DOCUMENT ME!
   */
  public void setSurveyCode(String surveyCode) {
    this.surveyCode = surveyCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  surveyFrequency  DOCUMENT ME!
   */
  public void setSurveyFrequency(Integer surveyFrequency) {
    this.surveyFrequency = surveyFrequency;
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
   * DOCUMENT ME!
   *
   * @param  confirmButtonText  DOCUMENT ME!
   */

  public void setConfirmButtonText(String confirmButtonText) {
    this.confirmButtonText = confirmButtonText;
  }

} // end class AbstractPortfolioSurvey
