package com.ozstrategy.credagility.core.domain.workflow.basic;

import com.cmc.credagility.core.domain.type.QuestionLayout;
import com.cmc.credagility.core.domain.type.RoundType;
import com.cmc.credagility.core.domain.user.User;
import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.CreatorEntity;
import com.ozstrategy.credagility.core.domain.decisiontree.businesscontext.WorkflowAnswerOptionConfig;
import com.ozstrategy.credagility.core.domain.document.EnterpriseDocument;
import com.ozstrategy.credagility.core.domain.type.BusinessDataType;
import com.ozstrategy.credagility.core.domain.workflow.enterprise.EnterpriseWorkflowTaskElement;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * Created with IntelliJ IDEA.
 *
 * @author   $author$
 * @version  $Revision$, $Date$ : Wang Yang : 13-2-19 : PM5:57
 */
@MappedSuperclass public class BasicWorkflowTaskElement extends CreatorEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -5048389290828965474L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** <code>true</code> this element is active. */
  @Column(
    name             = "active",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean active;

  /** Active user. */
  @JoinColumn(
    name       = "activeBy",
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected User activeBy;

  /** Active Date. */
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
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowAudit = true;

  /** <code>true</code> this element's answer must encrypt. */
  @Column(
    name             = "allowEncrypt",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowEncrypt = true;

  /**
   * Type List.
   *
   * <ul>
   *   <li>TextField</li>
   *   <li>TextArea</li>
   *   <li>DropDown</li>
   *   <li>Radio</li>
   *   <li>File</li>
   * </ul>
   */
  @Column(length = 255)
  protected String answerType = "TextField";

  /** Answer Validator. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String answerValidator;

  /**
   * Type List.
   *
   * <ul>
   *   <li>String</li>
   *   <li>Currency</li>
   *   <li>Percentage</li>
   *   <li>Decimal</li>
   *   <li>Integer</li>
   *   <li>Boolean</li>
   *   <li>Date</li>
   *   <li>Document Upload</li>
   *   <li>Document Status</li>
   *   <li>Document Preview</li>
   *   <li>Agency Context</li>
   *   <li>Agent Context</li>
   * </ul>
   */
  @Column(length = 32)
  protected String businessDataType;

  /** flow,element,login. */
  @Column(length = 64)
  protected String contextInstanceScope;

  /**
   * Type List.
   *
   * <ul>
   *   <li>Agency</li>
   *   <li>Agent</li>
   * </ul>
   */
  @Column(
    length   = 32,
    nullable = true
  )
  protected String contextType;

  /** Date type. */
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
   *   <li>ALL</li>
   *   <li>PDF</li>
   *   <li>DOC</li>
   *   <li>EXCEL</li>
   * </ul>
   */
  @Column(length = 50)
  protected String documentContentType;

  /** Locale. */
  @Column(
    length   = 64,
    nullable = false
  )
  protected String locale;

  /** Maximum size. */
  @Column protected Integer maxSize;

  /** Minimum size. */
  @Column protected Integer minSize;

  /** Survey question answer variable name. */
  @Column(
    length   = 100,
    nullable = false
  )
  protected String name;

  /** Using this expression to populate the default value of this question. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String prePopulateExpression;

  /** Question code. */
  @Column(length = 16)
  protected String questionCode;

  // npelleti 08/17 set the length to 16
  /**
   * @see  com.cmc.credagility.core.domain.type.QuestionLayout
   */
  @Column(length = 16)
  @Enumerated(EnumType.STRING)
  protected QuestionLayout questionLayout = QuestionLayout.QA;

  /** Question text. */
  @Column(
    columnDefinition = "LONGTEXT",
    nullable         = false
  )
  @Lob protected String questionText;

  /** Question text 2. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String questionText2;

  /** <code>true</code> this question's answer can not be null. */
  @Column(
    name             = "requireAnswer",
    length           = 1,
    nullable         = false,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean requireAnswer = true;

  /** <code>true</code> next question will show in next line. */
  @Column(
    name             = "requireNewLine",
    length           = 1,
    nullable         = false,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean requireNewLine = true;

  /**
   * @see  com.cmc.credagility.core.domain.type.RoundType
   */
  @Column(
    name   = "roundType",
    length = 255
  )
  @Enumerated(value = EnumType.STRING)
  protected RoundType roundType = RoundType.CENTS_UP;

  /** TODO: DOCUMENT ME! */
  @Column protected Integer rows;

  /** number of decimal points number. */
  protected Integer scale;

  /** Status. */
  @Column(length = 16)
  protected String status = "DRAFT";

  /** Text area columns. */
  @Column protected Integer textAreaColumns;

  /** Text area rows. */
  @Column protected Integer textAreaRows;

  /** Value format. */
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

  public Boolean getAllowDataProvider() {
    if(allowDataProvider == null){
      return Boolean.FALSE;
    }
    return allowDataProvider;
  }

  public void setAllowDataProvider(Boolean allowDataProvider) {
    this.allowDataProvider = allowDataProvider;
  }

  public WorkflowAnswerOptionConfig getWorkflowAnswerOptionConfig() {
    return workflowAnswerOptionConfig;
  }

  public void setWorkflowAnswerOptionConfig(WorkflowAnswerOptionConfig workflowAnswerOptionConfig) {
    this.workflowAnswerOptionConfig = workflowAnswerOptionConfig;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  element  DOCUMENT ME!
   */
  public void copy(BasicWorkflowTaskElement element) {
    this.name                  = element.getName();
    this.businessDataType      = element.getBusinessDataType();
    this.dataType              = element.getDataType();
    this.questionCode          = element.getQuestionCode();
    this.questionText          = element.getQuestionText();
    this.questionText2         = element.getQuestionText2();
    this.answerType            = element.getAnswerType();
    this.maxSize               = element.getMaxSize();
    this.minSize               = element.getMinSize();
    this.requireAnswer         = element.getRequireAnswer();
    this.requireNewLine        = element.getRequireNewLine();
    this.allowEncrypt          = element.getAllowEncrypt();
    this.locale                = element.getLocale();
    this.questionLayout        = element.getQuestionLayout();
    this.answerValidator       = element.getAnswerValidator();
    this.prePopulateExpression = element.getPrePopulateExpression();
    this.allowAudit            = element.getAllowAudit();
    this.roundType             = element.getRoundType();
    this.contextInstanceScope  = element.getContextInstanceScope();
    this.valueFormat           = element.getValueFormat();
    this.documentContentType   = element.getDocumentContentType();
    this.contextType           = element.getContextType();
    this.status                = element.getStatus();
    this.active                = element.getActive();
    this.activeBy              = element.getActiveBy();
    this.activeDate            = element.getActiveDate();
    this.roundType             = element.getRoundType();
    this.scale                 = element.getScale();
    this.width                 = element.getWidth();
    this.rows                  = element.getRows();
    this.allowDataProvider     = element.getAllowDataProvider();

    this.setDocument(element.getDocument());
    this.setActiveBy(element.getActiveBy());
    this.setActiveDate(element.getActiveDate());
    this.setLastUpdateDate(element.getLastUpdateDate());
    this.setLastUpdater(element.getLastUpdater());
    this.setCreateDate(new Date());
    this.setCreator(element.getCreator());
    this.setWorkflowAnswerOptionConfig(element.getWorkflowAnswerOptionConfig());
  } // end method copy

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   */
  public void detectDataType() {
    if ("String".equalsIgnoreCase(businessDataType) || "Text".equalsIgnoreCase(businessDataType)) {
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
    } else if (BusinessDataType.AGENCY_CONTEXT.toString().equalsIgnoreCase(businessDataType)) {
      dataType = "String";
    } else if (BusinessDataType.AGENT_CONTEXT.toString().equalsIgnoreCase(businessDataType)) {
      dataType = "String";
    } // end if-else
  }   // end method detectDataType

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#equals(Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof EnterpriseWorkflowTaskElement)) {
      return false;
    }

    BasicWorkflowTaskElement question = (BasicWorkflowTaskElement) o;


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
  public String getContextInstanceScope() {
    return contextInstanceScope;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getContextType() {
    return contextType;
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
   * @return  DOCUMENT ME!
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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getRequireAnswer() {
    if (requireAnswer == null) {
      return false;
    }

    return requireAnswer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getRequireNewLine() {
    if (requireNewLine == null) {
      return false;
    }

    return requireNewLine;
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
   * @see  Object#hashCode()
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
   * DOCUMENT ME! //~
   * ------------------------------------------------------------------------------------------------------------------
   * /** DOCUMENT ME!
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
   * @param  contextInstanceScope  DOCUMENT ME!
   */
  public void setContextInstanceScope(String contextInstanceScope) {
    this.contextInstanceScope = contextInstanceScope;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  contextType  DOCUMENT ME!
   */
  public void setContextType(String contextType) {
    this.contextType = contextType;
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
   * setter method for scale.
   *
   * @param  scale  Integer
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
   * @see  com.ozstrategy.credagility.core.domain.CreatorEntity#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("EnterpriseWorkflowTaskElement");
    sb.append(", name='").append(name).append('\'');
    sb.append(", dataType='").append(dataType).append('\'');
    sb.append(", businessDataType='").append(businessDataType).append('\'');
    sb.append(", questionCode='").append(questionCode).append('\'');
    sb.append(", questionText='").append(questionText).append('\'');
    sb.append(", questionText2='").append(questionText2).append('\'');
    sb.append(", answerType=").append(answerType);
    sb.append(", requireAnswer=").append(requireAnswer);
    sb.append(", requireNewLine=").append(requireNewLine);
    sb.append(", allowEncrypt=").append(allowEncrypt);
    sb.append(", locale='").append(locale).append('\'');
    sb.append(", questionLayout=").append(questionLayout);
    sb.append('}');

    return sb.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   businessDataType  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  protected String getProcessedBusinessDataType(String businessDataType) {
    if (BusinessDataType.DOCUMENT_PREVIEW.toString().equalsIgnoreCase(businessDataType)
          || BusinessDataType.DOCUMENT_UPLOAD.toString().equalsIgnoreCase(businessDataType)
          || BusinessDataType.DOCUMENT_STATUS.toString().equalsIgnoreCase(businessDataType)) {
      return "Integer";
    }

    return businessDataType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   dataType  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  protected String getProcessedDataType(String dataType) {
    if (BusinessDataType.DOCUMENT_PREVIEW.toString().equalsIgnoreCase(dataType)
          || BusinessDataType.DOCUMENT_UPLOAD.toString().equalsIgnoreCase(dataType)
          || BusinessDataType.DOCUMENT_STATUS.toString().equalsIgnoreCase(dataType)) {
      return "Long";
    }

    return dataType;
  }
} // end class BasicWorkflowTaskElement
