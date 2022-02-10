package com.ozstrategy.credagility.core.domain.workflow.enterprise;

import com.cmc.credagility.core.domain.type.LocaleType;
import com.ozstrategy.credagility.core.converter.ByteEncryptedConverter;
import com.ozstrategy.credagility.core.domain.CreatorEntity;
import com.ozstrategy.credagility.core.domain.document.EnterpriseDocument;
import com.ozstrategy.credagility.core.domain.document.EnterpriseDocumentVersionTemplate;
import com.ozstrategy.credagility.core.domain.workflow.bci.BCIWorkflowInstance;
import com.ozstrategy.credagility.core.domain.workflow.bci.BCWorkflowTaskElement;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/17/2014 14:03
 */
@Entity
@Table(name = "WorkflowInstanceDocumentTemplate")
public class WorkflowInstanceDocumentTemplate extends CreatorEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 576341645390593277L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "bciWorkflowInstanceId",
    nullable  = true,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCIWorkflowInstance bciInstance;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "bciTaskElementId",
    nullable  = true,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCWorkflowTaskElement bciTaskElement;


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
    name   = "extension",
    length = 10
  )
  protected String extension;


  /** TODO: DOCUMENT ME! */
  @Column(columnDefinition = "MEDIUMBLOB")
  @Convert(converter = ByteEncryptedConverter.class)
  protected byte[] fileContent;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "instanceId",
    nullable  = true,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected WorkflowInstance instance;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "locale",
    length = 5
  )
  @Enumerated(EnumType.STRING)
  protected LocaleType locale = LocaleType.ENGLISH;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "originalName",
    length = 255
  )
  protected String originalName;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "taskElementId",
    nullable  = true,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseWorkflowTaskElement taskElement;


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "template",
    cascade  = CascadeType.ALL
  )
  protected Set<WorkflowInstanceDocumentTemplateVariable> templateVariables =
    new HashSet<WorkflowInstanceDocumentTemplateVariable>();


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "enterpriseDocumentVersionTemplateId",
    nullable  = false,
    updatable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseDocumentVersionTemplate versionTemplate;

  @Column(
    name     = "id",
    nullable = false,
    length   = 19
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long id;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addTemplateVariable.
   *
   * @param  variable  String
   * @param  value     String
   */
  public void addTemplateVariable(String variable, String value) {
    if ((variable != null) && !"".equals(variable)) {
      WorkflowInstanceDocumentTemplateVariable templateVariable = null;

      if ((templateVariables != null) && (templateVariables.size() > 0)) {
        for (WorkflowInstanceDocumentTemplateVariable var : templateVariables) {
          if (variable.equals(var.getVariable())) {
            templateVariable = var;

            break;
          }
        }
      }

      if (templateVariable == null) {
        templateVariable = new WorkflowInstanceDocumentTemplateVariable();
        templateVariable.setVariable(variable);
      }

      templateVariable.setValue(value);
      templateVariable.setTemplate(this);
      templateVariable.setDocument(this.getDocument());
      templateVariable.setInstance(this.getInstance());

      getTemplateVariables().add(templateVariable);
    } // end if
  }   // end method addTemplateVariable

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

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    WorkflowInstanceDocumentTemplate that = (WorkflowInstanceDocumentTemplate) o;

    if (!document.equals(that.document)) {
      return false;
    }

    if ((extension != null) ? (!extension.equals(that.extension)) : (that.extension != null)) {
      return false;
    }

    if (!Arrays.equals(fileContent, that.fileContent)) {
      return false;
    }

    if (!instance.equals(that.instance)) {
      return false;
    }

    if (locale != that.locale) {
      return false;
    }

    if ((originalName != null) ? (!originalName.equals(that.originalName)) : (that.originalName != null)) {
      return false;
    }

    if ((templateVariables != null) ? (!templateVariables.equals(that.templateVariables))
                                    : (that.templateVariables != null)) {
      return false;
    }

    if (!versionTemplate.equals(that.versionTemplate)) {
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
   * getter method for bci task element.
   *
   * @return  BCWorkflowTaskElement
   */
  public BCWorkflowTaskElement getBciTaskElement() {
    return bciTaskElement;
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
   * getter method for extension.
   *
   * @return  String
   */
  public String getExtension() {
    return extension;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for file content.
   *
   * @return  byte[]
   */
  public byte[] getFileContent() {
    return fileContent;
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
   * getter method for locale.
   *
   * @return  LocaleType
   */
  public LocaleType getLocale() {
    return locale;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for original name.
   *
   * @return  String
   */
  public String getOriginalName() {
    return originalName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for task element.
   *
   * @return  EnterpriseWorkflowTaskElement
   */
  public EnterpriseWorkflowTaskElement getTaskElement() {
    return taskElement;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for template variables.
   *
   * @return  Set
   */
  public Set<WorkflowInstanceDocumentTemplateVariable> getTemplateVariables() {
    return templateVariables;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for version template.
   *
   * @return  EnterpriseDocumentVersionTemplate
   */
  public EnterpriseDocumentVersionTemplate getVersionTemplate() {
    return versionTemplate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + locale.hashCode();
    result = (31 * result) + ((originalName != null) ? originalName.hashCode() : 0);
    result = (31 * result) + ((extension != null) ? extension.hashCode() : 0);
    result = (31 * result) + ((versionTemplate != null) ? versionTemplate.hashCode() : 0);
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
   * setter method for bci task element.
   *
   * @param  bciTaskElement  BCWorkflowTaskElement
   */
  public void setBciTaskElement(BCWorkflowTaskElement bciTaskElement) {
    this.bciTaskElement = bciTaskElement;
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
   * setter method for extension.
   *
   * @param  extension  String
   */
  public void setExtension(String extension) {
    this.extension = extension;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for file content.
   *
   * @param  fileContent  byte[]
   */
  public void setFileContent(byte[] fileContent) {
    this.fileContent = fileContent;
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
   * setter method for locale.
   *
   * @param  locale  LocaleType
   */
  public void setLocale(LocaleType locale) {
    this.locale = locale;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for original name.
   *
   * @param  originalName  String
   */
  public void setOriginalName(String originalName) {
    this.originalName = originalName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for task element.
   *
   * @param  taskElement  EnterpriseWorkflowTaskElement
   */
  public void setTaskElement(EnterpriseWorkflowTaskElement taskElement) {
    this.taskElement = taskElement;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for template variables.
   *
   * @param  templateVariables  Set
   */
  public void setTemplateVariables(Set<WorkflowInstanceDocumentTemplateVariable> templateVariables) {
    this.templateVariables = templateVariables;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for version template.
   *
   * @param  versionTemplate  EnterpriseDocumentVersionTemplate
   */
  public void setVersionTemplate(EnterpriseDocumentVersionTemplate versionTemplate) {
    this.versionTemplate = versionTemplate;
  }
  public void addBCITemplateVariable(String variable, String value) {
    if ((variable != null) && !"".equals(variable)) {
      WorkflowInstanceDocumentTemplateVariable templateVariable = null;

      if ((templateVariables != null) && (templateVariables.size() > 0)) {
        for (WorkflowInstanceDocumentTemplateVariable var : templateVariables) {
          if (variable.equals(var.getVariable())) {
            templateVariable = var;

            break;
          }
        }
      }

      if (templateVariable == null) {
        templateVariable = new WorkflowInstanceDocumentTemplateVariable();
        templateVariable.setVariable(variable);
      }

      templateVariable.setValue(value);
      templateVariable.setTemplate(this);
      templateVariable.setDocument(this.getDocument());
      templateVariable.setBciInstance(this.getBciInstance());

      getTemplateVariables().add(templateVariable);
    } // end if
  }   // end method addBCITemplateVariable
} // end class WorkflowInstanceDocumentTemplate
