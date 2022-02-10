package com.cmc.credagility.core.domain.portfolio;

import com.cmc.credagility.core.domain.base.CreatorEntity;
import com.cmc.credagility.core.domain.type.QuestionLayout;
import com.cmc.credagility.core.domain.type.RoundType;
import com.cmc.credagility.core.domain.user.User;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.document.EnterpriseDocument;
import com.ozstrategy.credagility.core.domain.type.BusinessDataType;
import com.ozstrategy.credagility.core.domain.decisiontree.businesscontext.WorkflowAnswerOptionConfig;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;


/**
 * Created by IntelliJ IDEA. User: ye Date: Apr 30, 2010 Time: 11:17:34 PM To change this template use File | Settings |
 * File Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@MappedSuperclass public class AbstractPortfolioQuestion extends CreatorEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
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

  /** Enable workflow auditing. */
  @Column(
    name             = "allowAudit",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowAudit = true;

  /** DOCUMENT ME! */
  @Column(
    name             = "allowEncrypt",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowEncrypt = true;


  /** CA-11591 Show/Hide Dependent Task Elements in Customer Portal Default is False. */
  @Column
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean         allowShowOrHideDependentTaskElements = Boolean.FALSE;

  // npelleti 08/17 Set the length to 255
  /** DOCUMENT ME! */
  @Column(length = 255)
  protected String answerType = "TextField";

  /** DOCUMENT ME! */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String answerValidator;

  /** DOCUMENT ME! */
  @Column(length = 32)
  protected String businessDataType;

  /** DOCUMENT ME! */
  @Column(
    length   = 32,
    nullable = false
  )
  protected String dataType;

  /** When 'businessDataType' is 'Document Upload'/'Document Status', this field is required. */
  @JoinColumn(
    name       = "documentId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseDocument document;

  /**
   * Content Type of the Document:
   *
   * <ul>
   *   <li>PDF</li>
   *   <li>DOC</li>
   *   <li>EXCEL</li>
   * </ul>
   */
  @Column(length = 50)
  protected String documentContentType;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String leftText;

  /** DOCUMENT ME! */
  @Column(
    length   = 64,
    nullable = false
  )
  protected String locale;

  /** DOCUMENT ME! */
  @Column protected Integer maxSize;

  /** DOCUMENT ME! */
  @Column protected Integer minSize;

  /** Survey question answer variable name. */
  @Column(
    length   = 100,
    nullable = false
  )
  protected String name;

  /** DOCUMENT ME! */
  @Column(nullable = true)
  protected Integer page;

  /** The portfolio which schedule belong to. */
  @JoinColumn(
    name       = "portfolioId",
    nullable   = false,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Portfolio portfolio = new Portfolio();


  /** Using this expression to populate the default value of this question. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String prePopulateExpression;

  /** DOCUMENT ME! */
  @Column(length = 16)
  protected String questionCode;

  // npelleti 08/17 set the length to 16
  /** DOCUMENT ME! */
  @Column(length = 16)
  @Enumerated(EnumType.STRING)
  protected QuestionLayout questionLayout = QuestionLayout.QA;

  /** DOCUMENT ME! */
  @Column(
    columnDefinition = "LONGTEXT",
    nullable         = false
  )
  @Lob protected String questionText;

  /** DOCUMENT ME! */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String questionText2;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String radioAlignment;

  /** DOCUMENT ME! */
  @Column(
    name             = "requireAnswer",
    columnDefinition = "char",
    nullable         = false,
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean requireAnswer = true;

  /** DOCUMENT ME! */
  @Column(
    name             = "requireNewLine",
    columnDefinition = "char",
    length           = 1,
    nullable         = false
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean requireNewLine = true;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String rightText;

  /** DOCUMENT ME! */
  @Column(
    name   = "roundType",
    length = 255
  )
  @Enumerated(value = EnumType.STRING)
  protected RoundType roundType = RoundType.CENTS_UP;

  /** TODO: DOCUMENT ME! */
  @Column protected Integer rows;

  /* number of decimal points number */
  /** DOCUMENT ME! */
  protected Integer scale;

  /** DOCUMENT ME! */
  @Column(length = 16)
  protected String status = "DRAFT";

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String style;

  /** DOCUMENT ME! */
  @Column protected Integer textAreaColumns;

  /** DOCUMENT ME! */
  @Column protected Integer textAreaRows;


  /** DOCUMENT ME! */
  @Column(length = 255)
  protected String valueFormat;

  /** TODO: DOCUMENT ME! */
  @Column protected Integer width;

  @Column(
      columnDefinition = "char",
      length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean allowDataProvider;

  @JoinColumn(
      name     = "workflowAnswerOptionConfigId",
      nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private WorkflowAnswerOptionConfig workflowAnswerOptionConfig;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  question  DOCUMENT ME!
   */
  public void copyFrom(AbstractPortfolioQuestion question) {
    this.name             = question.getName();
    this.businessDataType = question.getBusinessDataType();
    this.dataType         = question.getDataType();
    this.questionCode     = question.getQuestionCode();
    this.questionText     = question.getQuestionText();

    this.questionText2 = question.getQuestionText2();
    this.answerType    = question.getAnswerType();
    this.portfolio     = question.getPortfolio();
    this.status        = question.getStatus();

    this.textAreaColumns       = question.getTextAreaColumns();
    this.textAreaRows          = question.getTextAreaRows();
    this.prePopulateExpression = question.getPrePopulateExpression();
    this.requireAnswer         = question.getRequireAnswer();
    this.requireNewLine        = question.getRequireNewLine();
    this.allowEncrypt          = question.getAllowEncrypt();
    this.locale                = question.getLocale();
    this.questionLayout        = question.getQuestionLayout();
    this.page                  = question.getPage();
    this.valueFormat           = question.getValueFormat();
    this.roundType             = question.getRoundType();
    this.minSize               = question.getMinSize();
    this.maxSize               = question.getMaxSize();
    this.document              = question.getDocument();
    this.documentContentType   = question.getDocumentContentType();
    this.creator               = question.getCreator();
    this.lastUpdater           = question.getLastUpdater();
    this.lastUpdateDate        = new Date();
    this.active                = question.getActive();
    this.activeBy              = question.getActiveBy();
    this.activeDate            = question.getActiveDate();
    this.roundType             = question.getRoundType();
    this.scale                 = question.getScale();
    this.style                 = question.getStyle();
    this.leftText              = question.getLeftText();
    this.rightText             = question.getRightText();
    this.rows                  = question.getRows();
    this.width                 = question.getWidth();
    this.radioAlignment        = question.getRadioAlignment();
    this.allowDataProvider          = question.getAllowDataProvider();
    this.workflowAnswerOptionConfig = question.getWorkflowAnswerOptionConfig();
    this.allowShowOrHideDependentTaskElements = question.getAllowShowOrHideDependentTaskElements();


  } // end method copyFrom

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   */
  public void detectDataType() {
    if ("String".equalsIgnoreCase(businessDataType)) {
      dataType = "String";
    } else if ("Currency".equalsIgnoreCase(businessDataType)) {
      dataType = "BigDecimal";
    } else if ("Percentage".equalsIgnoreCase(businessDataType)) {
      dataType = "BigDecimal";
    } else if ("Decimal".equalsIgnoreCase(businessDataType)) {
      dataType = "BigDecimal";
    } else if ("Integer".equalsIgnoreCase(businessDataType)) {
      dataType = "Long";
    } else if ("Boolean".equalsIgnoreCase(businessDataType)) {
      dataType = "Boolean";
    } else if ("Date".equalsIgnoreCase(businessDataType)) {
      dataType = "Date";
    } else if (BusinessDataType.DOCUMENT_UPLOAD.toString().equalsIgnoreCase(businessDataType)) {
      dataType = "Long";
    } else if (BusinessDataType.DOCUMENT_STATUS.toString().equalsIgnoreCase(businessDataType)) {
      dataType = "Long";
    } else if (BusinessDataType.DOCUMENT_PREVIEW.toString().equalsIgnoreCase(businessDataType)) {
      dataType = "Long";
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof PortfolioQuestion)) {
      return false;
    }

    AbstractPortfolioQuestion question = (AbstractPortfolioQuestion) o;


    if ((answerType != null) ? (!answerType.equals(question.answerType)) : (question.answerType != null)) {
      return false;
    }

    if ((dataType != null) ? (!dataType.equals(question.dataType)) : (question.dataType != null)) {
      return false;
    }

    if ((businessDataType != null) ? (!businessDataType.equals(question.businessDataType))
                                   : (question.businessDataType != null)) {
      return false;
    }

    if ((locale != null) ? (!locale.equals(question.locale)) : (question.locale != null)) {
      return false;
    }

    if ((name != null) ? (!name.equals(question.name)) : (question.name != null)) {
      return false;
    }

    if (questionLayout != question.questionLayout) {
      return false;
    }

    if ((questionText != null) ? (!questionText.equals(question.questionText)) : (question.questionText != null)) {
      return false;
    }

    if ((questionText2 != null) ? (!questionText2.equals(question.questionText2)) : (question.questionText2 != null)) {
      return false;
    }

    if ((questionCode != null) ? (!questionCode.equals(question.questionCode)) : (question.questionCode != null)) {
      return false;
    }

    if ((active != null) ? (!active.equals(question.active)) : (question.active != null)) {
      return false;
    }

    if ((roundType != null) ? (!roundType.equals(question.roundType)) : (question.roundType != null)) {
      return false;
    }

    if ((scale != null) ? (!scale.equals(question.scale)) : (question.scale != null)) {
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
  public Boolean getAllowAudit() {
    if (allowAudit == null) {
      return Boolean.FALSE;
    }

    return allowAudit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAllowEncrypt() {
    if (allowEncrypt == null) {
      return Boolean.FALSE;
    }

    return allowEncrypt;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getAnswerType() {
    return answerType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getAnswerValidator() {
    return answerValidator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getBusinessDataType() {
    return businessDataType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDataType() {
    return dataType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public EnterpriseDocument getDocument() {
    return document;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDocumentContentType() {
    return documentContentType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getEnterpriseDocumentId() {
    if (document != null) {
      return document.getId();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for left text.
   *
   * @return  String
   */
  public String getLeftText() {
    return leftText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The question text locale.
   *
   * @return  DOCUMENT ME!
   *
   *          <p>length = "64" not-null = "true"</p>
   */
  public String getLocale() {
    return locale;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getMaxSize() {
    return maxSize;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getMinSize() {
    return minSize;
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
   * The page number of the question.
   *
   * @return  the page number of the question.
   */
  public Integer getPage() {
    return page;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  dOCUMENT ME!
   *
   *          <p>lazy = "proxy" column = "portfolioId" not-null = "true" class = "com.cmc.credagility.Portfolio" insert
   *          = "true" update = "true"</p>
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
  public String getPrePopulateExpression() {
    return prePopulateExpression;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getQuestionCode() {
    return questionCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  the questionLayout
   *
   *          <p>not-null = "true" length = "10" type = "com.cmc.dao.hibernate.support.QuestionLayoutUserType"</p>
   */
  public QuestionLayout getQuestionLayout() {
    return questionLayout;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getQuestionText() {
    return questionText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getQuestionText2() {
    return questionText2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for radio alignment.
   *
   * @return  String
   */
  public String getRadioAlignment() {
    return radioAlignment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * True means this question requires an answer.
   *
   * @return  true means this question requires an answer.
   *
   *          <p>type = "yes_no" not-null = "true"</p>
   */
  public Boolean getRequireAnswer() {
    if (requireAnswer == null) {
      return Boolean.FALSE;
    }

    return requireAnswer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * True means this question requires to began with an new line.
   *
   * @return  true means this question requires to began with an new line.
   *
   *          <p>type = "yes_no" not-null = "true"</p>
   */
  public Boolean getRequireNewLine() {
    return requireNewLine;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for right text.
   *
   * @return  String
   */
  public String getRightText() {
    return rightText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public RoundType getRoundType() {
    return roundType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for rows.
   *
   * @return  Integer
   */
  public Integer getRows() {
    return rows;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getScale() {
    return scale;
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
   * getter method for style.
   *
   * @return  String
   */
  public String getStyle() {
    return style;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getTextAreaColumns() {
    return textAreaColumns;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getTextAreaRows() {
    return textAreaRows;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getValueFormat() {
    return valueFormat;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for width.
   *
   * @return  Integer
   */
  public Integer getWidth() {
    return width;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = 31;
    result = (31 * result) + ((name != null) ? name.hashCode() : 0);
    result = (31 * result) + ((dataType != null) ? dataType.hashCode() : 0);
    result = (31 * result) + ((businessDataType != null) ? businessDataType.hashCode() : 0);
    result = (31 * result) + ((questionCode != null) ? questionCode.hashCode() : 0);
    result = (31 * result) + ((questionText != null) ? questionText.hashCode() : 0);
    result = (31 * result) + ((questionText2 != null) ? questionText2.hashCode() : 0);
    result = (31 * result) + ((answerType != null) ? answerType.hashCode() : 0);
    result = (31 * result) + ((locale != null) ? locale.hashCode() : 0);
    result = (31 * result) + ((questionLayout != null) ? questionLayout.hashCode() : 0);
    result = (31 * result) + ((active != null) ? active.hashCode() : 0);
    result = (31 * result) + ((roundType != null) ? roundType.hashCode() : 0);
    result = (31 * result) + ((scale != null) ? scale.hashCode() : 0);

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
   * @param  allowAudit  DOCUMENT ME!
   */
  public void setAllowAudit(Boolean allowAudit) {
    this.allowAudit = allowAudit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  allowEncrypt  DOCUMENT ME!
   */
  public void setAllowEncrypt(Boolean allowEncrypt) {
    this.allowEncrypt = allowEncrypt;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  answerType  DOCUMENT ME!
   */
  public void setAnswerType(String answerType) {
    this.answerType = answerType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  answerValidator  DOCUMENT ME!
   */
  public void setAnswerValidator(String answerValidator) {
    this.answerValidator = answerValidator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  businessDataType  DOCUMENT ME!
   */
  public void setBusinessDataType(String businessDataType) {
    this.businessDataType = businessDataType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  dataType  DOCUMENT ME!
   */
  public void setDataType(String dataType) {
    this.dataType = dataType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  document  DOCUMENT ME!
   */
  public void setDocument(EnterpriseDocument document) {
    this.document = document;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  documentContentType  DOCUMENT ME!
   */
  public void setDocumentContentType(String documentContentType) {
    this.documentContentType = documentContentType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for left text.
   *
   * @param  leftText  String
   */
  public void setLeftText(String leftText) {
    this.leftText = leftText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  locale  DOCUMENT ME!
   */
  public void setLocale(String locale) {
    this.locale = locale;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  maxSize  DOCUMENT ME!
   */
  public void setMaxSize(Integer maxSize) {
    this.maxSize = maxSize;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  minSize  DOCUMENT ME!
   */
  public void setMinSize(Integer minSize) {
    this.minSize = minSize;
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
   * @param  page  DOCUMENT ME!
   */
  public void setPage(Integer page) {
    this.page = page;
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
   * @param  prePopulateExpression  DOCUMENT ME!
   */
  public void setPrePopulateExpression(String prePopulateExpression) {
    this.prePopulateExpression = prePopulateExpression;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  questionCode  DOCUMENT ME!
   */
  public void setQuestionCode(String questionCode) {
    this.questionCode = questionCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  questionLayout  DOCUMENT ME!
   */
  public void setQuestionLayout(QuestionLayout questionLayout) {
    this.questionLayout = questionLayout;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  questionText  DOCUMENT ME!
   */
  public void setQuestionText(String questionText) {
    this.questionText = questionText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  questionText2  DOCUMENT ME!
   */
  public void setQuestionText2(String questionText2) {
    this.questionText2 = questionText2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for radio alignment.
   *
   * @param  radioAlignment  String
   */
  public void setRadioAlignment(String radioAlignment) {
    this.radioAlignment = radioAlignment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  requireAnswer  DOCUMENT ME!
   */
  public void setRequireAnswer(Boolean requireAnswer) {
    this.requireAnswer = requireAnswer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  requireNewLine  DOCUMENT ME!
   */
  public void setRequireNewLine(Boolean requireNewLine) {
    this.requireNewLine = requireNewLine;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for right text.
   *
   * @param  rightText  String
   */
  public void setRightText(String rightText) {
    this.rightText = rightText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  roundType  DOCUMENT ME!
   */
  public void setRoundType(RoundType roundType) {
    this.roundType = roundType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for rows.
   *
   * @param  rows  Integer
   */
  public void setRows(Integer rows) {
    this.rows = rows;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  scale  DOCUMENT ME!
   */
  public void setScale(Integer scale) {
    this.scale = scale;
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
   * setter method for style.
   *
   * @param  style  String
   */
  public void setStyle(String style) {
    this.style = style;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  textAreaColumns  DOCUMENT ME!
   */
  public void setTextAreaColumns(Integer textAreaColumns) {
    this.textAreaColumns = textAreaColumns;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  textAreaRows  DOCUMENT ME!
   */
  public void setTextAreaRows(Integer textAreaRows) {
    this.textAreaRows = textAreaRows;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  valueFormat  DOCUMENT ME!
   */
  public void setValueFormat(String valueFormat) {
    this.valueFormat = valueFormat;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for width.
   *
   * @param  width  Integer
   */
  public void setWidth(Integer width) {
    this.width = width;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.CreatorEntity#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("PortfolioQuestion");
    sb.append(", portfolio=").append(portfolio);
    sb.append(", name='").append(name).append('\'');
    sb.append(", dataType='").append(dataType).append('\'');
    sb.append(", businessDataType='").append(businessDataType).append('\'');
    sb.append(", questionCode='").append(questionCode).append('\'');
    sb.append(", questionText='").append(questionText).append('\'');
    sb.append(", questionText2='").append(questionText2).append('\'');
    sb.append(", answerType=").append(answerType);
// sb.append(", answerOptions='").append(answerOptions).append('\'');
    sb.append(", requireAnswer=").append(requireAnswer);
    sb.append(", requireNewLine=").append(requireNewLine);
    sb.append(", allowEncrypt=").append(allowEncrypt);
    sb.append(", locale='").append(locale).append('\'');
    sb.append(", questionLayout=").append(questionLayout);
    sb.append(", page=").append(page);
    sb.append('}');

    return sb.toString();
  }

  public Boolean getAllowDataProvider() {
    if (allowDataProvider == null) {
      return Boolean.FALSE;
    }

    return allowDataProvider;
  }

  public WorkflowAnswerOptionConfig getWorkflowAnswerOptionConfig() {
    return workflowAnswerOptionConfig;
  }


  public void setAllowDataProvider(Boolean allowDataProvider) {
    this.allowDataProvider = allowDataProvider;
  }

  public void setWorkflowAnswerOptionConfig(WorkflowAnswerOptionConfig workflowAnswerOptionConfig) {
    this.workflowAnswerOptionConfig = workflowAnswerOptionConfig;
  }

  //~ ------------------------------------------------------------------------------------------------------------------
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAllowShowOrHideDependentTaskElements() {
    if (allowShowOrHideDependentTaskElements == null) {
      return Boolean.FALSE;
    }

    return allowShowOrHideDependentTaskElements;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  allowShowOrHideDependentTaskElements  DOCUMENT ME!
   */
  public void setAllowShowOrHideDependentTaskElements(Boolean allowShowOrHideDependentTaskElements) {
    this.allowShowOrHideDependentTaskElements = allowShowOrHideDependentTaskElements;
  }
} // end class AbstractPortfolioQuestion
