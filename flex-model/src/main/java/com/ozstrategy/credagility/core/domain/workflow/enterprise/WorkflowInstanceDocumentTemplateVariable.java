package com.ozstrategy.credagility.core.domain.workflow.enterprise;

import com.ozstrategy.credagility.core.domain.document.EnterpriseDocument;
import com.ozstrategy.credagility.core.domain.entity.BaseEntity;
import com.ozstrategy.credagility.core.domain.workflow.bci.BCIWorkflowInstance;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/17/2014 14:05
 */
@Entity
@Table(name = "WorkflowInstanceDocumentTemplateVariable")
public class WorkflowInstanceDocumentTemplateVariable extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -2473749827728997411L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "bciInstanceId",
    nullable  = true,
    updatable = false
  )
  @ManyToOne protected BCIWorkflowInstance bciInstance;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "documentId",
    nullable  = false,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseDocument document;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "id",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "instanceId",
    nullable  = true,
    updatable = false
  )
  @ManyToOne protected WorkflowInstance instance;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "templateId",
    nullable  = false,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected WorkflowInstanceDocumentTemplate template;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String value;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String variable;

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

    WorkflowInstanceDocumentTemplateVariable that = (WorkflowInstanceDocumentTemplateVariable) o;

    if (!document.equals(that.document)) {
      return false;
    }

    if (!instance.equals(that.instance)) {
      return false;
    }

    if (!template.equals(that.template)) {
      return false;
    }

    if ((value != null) ? (!value.equals(that.value)) : (that.value != null)) {
      return false;
    }

    if (!variable.equals(that.variable)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bci instance.
   *
   * @return  BCIWorkflowInstance
   */
  public BCIWorkflowInstance getBciInstance() {
    return bciInstance;
  }

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
   * @return  WorkflowInstance
   */
  public WorkflowInstance getInstance() {
    return instance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for template.
   *
   * @return  WorkflowInstanceDocumentTemplate
   */
  public WorkflowInstanceDocumentTemplate getTemplate() {
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
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + variable.hashCode();
    result = (31 * result) + ((value != null) ? value.hashCode() : 0);
    result = (31 * result) + ((template != null) ? template.hashCode() : 0);
    result = (31 * result) + ((document != null) ? document.hashCode() : 0);
    result = (31 * result) + ((instance != null) ? instance.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bci instance.
   *
   * @param  bciInstance  BCIWorkflowInstance
   */
  public void setBciInstance(BCIWorkflowInstance bciInstance) {
    this.bciInstance = bciInstance;
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
   * @param  instance  WorkflowInstance
   */
  public void setInstance(WorkflowInstance instance) {
    this.instance = instance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for template.
   *
   * @param  template  WorkflowInstanceDocumentTemplate
   */
  public void setTemplate(WorkflowInstanceDocumentTemplate template) {
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
} // end class WorkflowInstanceDocumentTemplateVariable
