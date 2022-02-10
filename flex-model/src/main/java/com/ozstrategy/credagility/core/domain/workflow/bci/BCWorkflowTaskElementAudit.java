package com.ozstrategy.credagility.core.domain.workflow.bci;

import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskElement;
import com.ozstrategy.credagility.core.domain.workflow.bci.version.BCWorkflowTaskElementVersion;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * DOCUMENT ME!
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(
  name    = "BCWorkflowTaskElementAudit",
  indexes = {
    @Index(
      name = "idx_questionCode",
      columnList = "questionCode"
    )
  }
)
public class BCWorkflowTaskElementAudit extends BasicWorkflowTaskElement implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -7955008753334739835L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /**
   * Action List.
   *
   * <ul>
   *   <li>Create</li>
   *   <li>Update</li>
   *   <li>Delete</li>
   *   <li>Disable</li>
   *   <li>Enable</li>
   *   <li>Publish</li>
   * </ul>
   *
   * @see  com.ozstrategy.credagility.core.domain.AuditOperation
   */
  @Column(
    nullable = false,
    length   = 32
  )
  protected String action;

  /** CA-11591 Show/Hide Dependent Task Elements in Customer Portal Default is False. */
  @Column
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean         allowShowOrHideDependentTaskElements = Boolean.FALSE;

  /** Answer options. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String answerOptions;

  /** BC Field id PK BCField. */
  @Column(
    insertable = true,
    updatable  = false
  )
  protected Long bcFieldId;

  /** BC Mapping field id. */
  @Column(
    insertable = true,
    updatable  = false
  )
  protected Long bcMappingFieldId;

  /** DOCUMENT ME! */
// @Column(
// insertable = false,
// updatable  = false
// )
// protected Long documentId;


  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;

  /** Reference conrtext. */
  protected Long refContext;

  /** Task element id. */
  protected Long taskElement;

  /** Task element verison id. */
  protected Long taskElementVersion;

  /** Variable id. */
  protected Long variable;

  /** Version number. */
  protected Integer version;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  element  DOCUMENT ME!
   */
  public void copyFrom(BCWorkflowTaskElementVersion element) {
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
    this.variable              = (element.getVariable() != null) ? element.getVariable().getId() : null;
    this.valueFormat           = element.getValueFormat();
    this.documentContentType   = element.getDocumentContentType();
    this.contextType           = element.getContextType();
    this.version               = element.getVersion();
    this.contextInstanceScope  = element.getContextInstanceScope();
    this.status                = element.getStatus();
    this.active                = element.getActive();
    this.bcMappingFieldId      = element.getBcMappingFieldId();
    this.roundType             = element.getRoundType();
    this.scale                 = element.getScale();
    this.setRefContext((element.getRefContext() != null) ? element.getRefContext().getId() : null);
    this.setTaskElement(element.getWorkflowTaskElement().getId());
    this.setAllowDataProvider(element.getAllowDataProvider());
    this.setWorkflowAnswerOptionConfig(element.getWorkflowAnswerOptionConfig());
    this.setAllowShowOrHideDependentTaskElements(element.getAllowShowOrHideDependentTaskElements());

    // this.setDocumentId((element.getDocument() != null) ? element.getDocument().getId() : null);
    this.setDocument(element.getDocument());
    this.setBcFieldId((element.getBcMetaDataField() != null) ? element.getBcMetaDataField().getId() : null);
    this.setActiveBy(element.getActiveBy());
    this.setActiveDate(element.getActiveDate());
    this.setLastUpdateDate(element.getLastUpdateDate());
    this.setLastUpdater(element.getLastUpdater());
    this.setCreateDate(new Date());
    this.setCreator(element.getCreator());

    if ((element.getAnswerOptions() != null) && !element.getAnswerOptions().isEmpty()) {
      this.setAnswerOptions(element.getAnswerOptions().toString());
    }

    if ((element.getAnswerValidators() != null) && !element.getAnswerValidators().isEmpty()) {
      this.setAnswerValidator(element.getAnswerValidators().toString());
    }
  } // end method copyFrom

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskElement#equals(Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof BCWorkflowTaskElementAudit)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    BCWorkflowTaskElementAudit that = (BCWorkflowTaskElementAudit) o;

    if (!answerOptions.equals(that.answerOptions)) {
      return false;
    }

    if (!action.equals(that.action)) {
      return false;
    }


    if (!refContext.equals(that.refContext)) {
      return false;
    }

    if (!variable.equals(that.variable)) {
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
  public String getAction() {
    return action;
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
   * @return  DOCUMENT ME!
   */
  public String getAnswerOptions() {
    return answerOptions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getBcFieldId() {
    return bcFieldId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getBcMappingFieldId() {
    return bcMappingFieldId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
// public Long getDocumentId() {
// return documentId;
// }

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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getRefContext() {
    return refContext;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getTaskElement() {
    return taskElement;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getTaskElementVersion() {
    return taskElementVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getVariable() {
    return variable;
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
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + answerOptions.hashCode();
    result = (31 * result) + refContext.hashCode();
    result = (31 * result) + variable.hashCode();
    result = (31 * result) + action.hashCode();

    return result;
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
   * @param  allowShowOrHideDependentTaskElements  DOCUMENT ME!
   */
  public void setAllowShowOrHideDependentTaskElements(Boolean allowShowOrHideDependentTaskElements) {
    this.allowShowOrHideDependentTaskElements = allowShowOrHideDependentTaskElements;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  answerOptions  DOCUMENT ME!
   */
  public void setAnswerOptions(String answerOptions) {
    this.answerOptions = answerOptions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  bcFieldId  DOCUMENT ME!
   */
  public void setBcFieldId(Long bcFieldId) {
    this.bcFieldId = bcFieldId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  bcMappingFieldId  DOCUMENT ME!
   */
  public void setBcMappingFieldId(Long bcMappingFieldId) {
    this.bcMappingFieldId = bcMappingFieldId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  id  documentId DOCUMENT ME!
   */
// public void setDocumentId(Long documentId) {
// this.documentId = documentId;
// }

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
   * @param  refContext  DOCUMENT ME!
   */
  public void setRefContext(Long refContext) {
    this.refContext = refContext;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  taskElement  DOCUMENT ME!
   */
  public void setTaskElement(Long taskElement) {
    this.taskElement = taskElement;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  taskElementVersion  DOCUMENT ME!
   */
  public void setTaskElementVersion(Long taskElementVersion) {
    this.taskElementVersion = taskElementVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  variable  DOCUMENT ME!
   */
  public void setVariable(Long variable) {
    this.variable = variable;
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
   * @see  Object#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder("BCWorkflowTaskElementAudit{");
    sb.append("answerOptions='").append(answerOptions).append('\'');
    sb.append(", id=").append(id);
    sb.append(", refContext=").append(refContext);
    sb.append(", action=").append(action);
    sb.append(", variable=").append(variable);
    sb.append('}');

    return sb.toString();
  }


} // end class BCWorkflowTaskElementAudit
