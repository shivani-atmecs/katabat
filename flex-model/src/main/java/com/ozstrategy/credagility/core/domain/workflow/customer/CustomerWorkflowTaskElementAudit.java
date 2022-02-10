package com.ozstrategy.credagility.core.domain.workflow.customer;

import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskElement;
import com.ozstrategy.credagility.core.domain.workflow.customer.version.CustomerWorkflowTaskElementVersion;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * Created by tangwei on 17/3/21.
 *
 * @author   <a href="mailto:wei.tang@ozstrategy.com">Wei Tang</a>
 * @version  06/27/2017 17:01
 */
@Entity
@Table(name = "CustomerWorkflowTaskElementAudit")
public class CustomerWorkflowTaskElementAudit extends BasicWorkflowTaskElement implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 6995249943146208302L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = false,
    length   = 32
  )
  protected String action;

  /** DOCUMENT ME! */
  @Type(type = "text")
  protected String answerOptions;

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
   * DOCUMENT ME!
   *
   * @param  element  DOCUMENT ME!
   */
  public void copyFrom(CustomerWorkflowTaskElementVersion element) {
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
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskElement#equals(Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof CustomerWorkflowTaskElementAudit)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    CustomerWorkflowTaskElementAudit that = (CustomerWorkflowTaskElementAudit) o;

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
  public String getAnswerOptions() {
    return answerOptions;
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
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskElement#hashCode()
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
   * @param  answerOptions  DOCUMENT ME!
   */
  public void setAnswerOptions(String answerOptions) {
    this.answerOptions = answerOptions;
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
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskElement#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder("CustomerWorkflowTaskElementAudit{");
    sb.append("answerOptions='").append(answerOptions).append('\'');
    sb.append(", id=").append(id);
    sb.append(", refContext=").append(refContext);
    sb.append(", action=").append(action);
    sb.append(", variable=").append(variable);
    sb.append('}');

    return sb.toString();
  }

} // end class CustomerWorkflowTaskElementAudit
