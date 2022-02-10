package com.ozstrategy.credagility.core.domain.workflow.customer;


import com.ozstrategy.credagility.core.domain.CreatorEntity;
import com.ozstrategy.credagility.core.domain.document.EnterpriseDocument;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * Created by Yang Wang on 4/6/17.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  04/06/2017 16:42
 */
@Entity
@Table(name = "CustomerWorkflowInstanceDocumentTemplateVariable")
public class CustomerWorkflowInstanceDocumentTemplateVariable extends CreatorEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -5625513373957753417L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "documentId",
    nullable  = false,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseDocument document;

  /** DOCUMENT ME! */
  @Column(
    name     = "id",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "templateId",
    nullable  = false,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CustomerWorkflowInstanceDocumentTemplate template;

  /** TODO: DOCUMENT ME! */
  protected String value;

  /** TODO: DOCUMENT ME! */
  protected String variable;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "workflowInstanceId",
    nullable  = true,
    updatable = false
  )
  @ManyToOne protected CustomerWorkflowInstance workflowInstance;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#equals(Object)
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

    CustomerWorkflowInstanceDocumentTemplateVariable that = (CustomerWorkflowInstanceDocumentTemplateVariable) o;

    if ((variable != null) ? (!variable.equals(that.variable)) : (that.variable != null)) {
      return false;
    }

    if ((template != null) ? (!template.equals(that.template)) : (that.template != null)) {
      return false;
    }

    if ((document != null) ? (!document.equals(that.document)) : (that.document != null)) {
      return false;
    }

    return (workflowInstance != null) ? workflowInstance.equals(that.workflowInstance)
                                      : (that.workflowInstance == null);
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
   * getter method for template.
   *
   * @return  CustomerWorkflowInstanceDocumentTemplate
   */
  public CustomerWorkflowInstanceDocumentTemplate getTemplate() {
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
   * getter method for workflow instance.
   *
   * @return  CustomerWorkflowInstance
   */
  public CustomerWorkflowInstance getWorkflowInstance() {
    return workflowInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((variable != null) ? variable.hashCode() : 0);
    result = (31 * result) + ((template != null) ? template.hashCode() : 0);
    result = (31 * result) + ((document != null) ? document.hashCode() : 0);
    result = (31 * result) + ((workflowInstance != null) ? workflowInstance.hashCode() : 0);

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
   * setter method for template.
   *
   * @param  template  CustomerWorkflowInstanceDocumentTemplate
   */
  public void setTemplate(CustomerWorkflowInstanceDocumentTemplate template) {
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
   * setter method for workflow instance.
   *
   * @param  workflowInstance  CustomerWorkflowInstance
   */
  public void setWorkflowInstance(CustomerWorkflowInstance workflowInstance) {
    this.workflowInstance = workflowInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.CreatorEntity#toString()
   */
  @Override public String toString() {
    final StringBuffer sb = new StringBuffer("CustomerWorkflowInstanceDocumentTemplateVariable{");
    sb.append("id=").append(id);
    sb.append(", variable='").append(variable).append('\'');
    sb.append(", value='").append(value).append('\'');
    sb.append(", template=").append(template);
    sb.append(", document=").append(document);
    sb.append(", workflowInstance=").append(workflowInstance);
    sb.append('}');

    return sb.toString();
  }
} // end class CustomerWorkflowInstanceDocumentTemplateVariable
