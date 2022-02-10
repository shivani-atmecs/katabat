package com.ozstrategy.credagility.core.domain;

import com.ozstrategy.credagility.core.domain.document.EnterpriseDocument;
import com.ozstrategy.credagility.core.domain.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * SurveyFlowInstance DocumentTemplate Variable.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/16/2014 11:41
 */
@Entity
@Table(name = "SurveyFlowInstanceDocumentTemplateVariable")
public class SurveyFlowInstanceDocumentTemplateVariable extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -828794798180480009L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** EnterpriseDocument. */
  @JoinColumn(
    name      = "documentId",
    nullable  = false,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseDocument document;

  /** PK. */
  @Column(
    name     = "id",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;


  /** SurveyFlow Instance. */
  @JoinColumn(
    name      = "instanceId",
    nullable  = true,
    updatable = false
  )
  @ManyToOne protected SurveyFlowInstance instance;


  /** SurveyFlow Instance Document Template. */
  @JoinColumn(
    name      = "templateId",
    nullable  = false,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected SurveyFlowInstanceDocumentTemplate template;

  /** variable value. */
  protected String value;

  /** variable. */
  protected String variable;

  //~ Methods ----------------------------------------------------------------------------------------------------------

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

    SurveyFlowInstanceDocumentTemplateVariable that = (SurveyFlowInstanceDocumentTemplateVariable) o;

    if ((variable != null) && !variable.equals(that.getVariable())) {
      return false;
    }

    if ((document != null) && !document.equals(that.getDocument())) {
      return false;
    }

    if ((instance != null) && !instance.equals(that.getInstance())) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for document.
   *
   * @return  EnterpriseDocument
   */
  public EnterpriseDocument getDocument() {
    return document;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

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
   * getter method for instance.
   *
   * @return  SurveyFlowInstance
   */
  public SurveyFlowInstance getInstance() {
    return instance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for template.
   *
   * @return  SurveyFlowInstanceDocumentTemplate
   */
  public SurveyFlowInstanceDocumentTemplate getTemplate() {
    return template;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for value.
   *
   * @return  String
   */
  public String getValue() {
    return value;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for variable.
   *
   * @return  String
   */
  public String getVariable() {
    return variable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((variable != null) ? variable.hashCode() : 0);
    result = (31 * result) + ((document != null) ? document.hashCode() : 0);
    result = (31 * result) + ((instance != null) ? instance.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for document.
   *
   * @param  document  EnterpriseDocument
   */
  public void setDocument(EnterpriseDocument document) {
    this.document = document;
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
   * setter method for instance.
   *
   * @param  instance  SurveyFlowInstance
   */
  public void setInstance(SurveyFlowInstance instance) {
    this.instance = instance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for template.
   *
   * @param  template  SurveyFlowInstanceDocumentTemplate
   */
  public void setTemplate(SurveyFlowInstanceDocumentTemplate template) {
    this.template = template;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for value.
   *
   * @param  value  String
   */
  public void setValue(String value) {
    this.value = value;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for variable.
   *
   * @param  variable  String
   */
  public void setVariable(String variable) {
    this.variable = variable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#toString()
   */
  @Override public String toString() {
    return "SurveyFlowInstanceDocumentTemplateVariable{"
      + "id=" + id
      + ", variable='" + variable + '\''
      + ", value='" + value + '\''
      + ", template=" + template
      + ", document=" + document
      + ", instance=" + instance
      + '}';
  }
} // end class SurveyFlowInstanceDocumentTemplateVariable
