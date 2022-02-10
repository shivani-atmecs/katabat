package com.ozstrategy.credagility.core.domain.workflow.enterprise;

import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskElement;
import com.ozstrategy.credagility.core.domain.workflow.enterprise.version.EnterpriseWorkflowTaskElementVersion;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/17/2014 13:42
 */
@Entity
@Table(
  name    = "EnterpriseWorkflowTaskElementAudit",
  indexes = {
    @Index(
      name = "idx_questionCode",
      columnList = "questionCode"
    )
  }
)
public class EnterpriseWorkflowTaskElementAudit extends BasicWorkflowTaskElement implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -4993659539056609978L;

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
   */
  @Column(
    nullable = false,
    length   = 32
  )
  protected String action;

  /** DOCUMENT ME! */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String answerOptions;

// /** DOCUMENT ME! */
// @Column(
// insertable = false,
// updatable  = false
// )
// protected Long documentId;


  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;

  /** DOCUMENT ME! */
  protected Long refContext;

  /** DOCUMENT ME! */
  protected Long taskElement;

  /** DOCUMENT ME! */

  protected Long taskElementVersion;

  /** DOCUMENT ME! */
  protected Long variable;

  /** DOCUMENT ME! */
  protected Integer version;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * copyFrom.
   *
   * @param  element  EnterpriseWorkflowTaskElementVersion
   */
  public void copyFrom(EnterpriseWorkflowTaskElementVersion element) {
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
    this.roundType             = element.getRoundType();
    this.documentContentType   = element.getDocumentContentType();
    this.contextType           = element.getContextType();
    this.version               = element.getVersion();
    this.contextInstanceScope  = element.getContextInstanceScope();
    this.status                = element.getStatus();
    this.active                = element.getActive();
    this.roundType             = element.getRoundType();
    this.scale                 = element.getScale();
    this.setRefContext((element.getRefContext() != null) ? element.getRefContext().getId() : null);
    this.setTaskElement(element.getWorkflowTaskElement().getId());
    this.setDocument(element.getDocument());
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

    if (!(o instanceof EnterpriseWorkflowTaskElementAudit)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    EnterpriseWorkflowTaskElementAudit that = (EnterpriseWorkflowTaskElementAudit) o;

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
   * getter method for action.
   *
   * @return  String
   */
  public String getAction() {
    return action;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for answer options.
   *
   * @return  String
   */
  public String getAnswerOptions() {
    return answerOptions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

// public Long getDocumentId() {
// return documentId;
// }


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
   * getter method for ref context.
   *
   * @return  Long
   */
  public Long getRefContext() {
    return refContext;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for task element.
   *
   * @return  Long
   */
  public Long getTaskElement() {
    return taskElement;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for task element version.
   *
   * @return  Long
   */
  public Long getTaskElementVersion() {
    return taskElementVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for variable.
   *
   * @return  Long
   */
  public Long getVariable() {
    return variable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for version.
   *
   * @return  Integer
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
    int result = super.hashCode();
    result = (31 * result) + answerOptions.hashCode();
    result = (31 * result) + refContext.hashCode();
    result = (31 * result) + variable.hashCode();
    result = (31 * result) + action.hashCode();

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for action.
   *
   * @param  action  String
   */
  public void setAction(String action) {
    this.action = action;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for answer options.
   *
   * @param  answerOptions  String
   */
  public void setAnswerOptions(String answerOptions) {
    this.answerOptions = answerOptions;
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
   * setter method for ref context.
   *
   * @param  refContext  Long
   */
  public void setRefContext(Long refContext) {
    this.refContext = refContext;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for task element.
   *
   * @param  taskElement  Long
   */
  public void setTaskElement(Long taskElement) {
    this.taskElement = taskElement;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for task element version.
   *
   * @param  taskElementVersion  Long
   */
  public void setTaskElementVersion(Long taskElementVersion) {
    this.taskElementVersion = taskElementVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for variable.
   *
   * @param  variable  Long
   */
  public void setVariable(Long variable) {
    this.variable = variable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for version.
   *
   * @param  version  Integer
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
    final StringBuilder sb = new StringBuilder("EnterpriseWorkflowTaskElementAudit{");
    sb.append("answerOptions='").append(answerOptions).append('\'');
    sb.append(", id=").append(id);
    sb.append(", refContext=").append(refContext);
    sb.append(", action=").append(action);
    sb.append(", variable=").append(variable);
    sb.append('}');

    return sb.toString();
  }


} // end class EnterpriseWorkflowTaskElementAudit
