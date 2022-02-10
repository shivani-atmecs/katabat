package com.ozstrategy.credagility.core.domain.workflow.customer;

import com.cmc.credagility.core.domain.type.LocaleType;
import com.ozstrategy.credagility.core.domain.CreatorEntity;
import com.ozstrategy.credagility.core.domain.document.EnterpriseDocument;
import com.ozstrategy.credagility.core.domain.document.EnterpriseDocumentVersionTemplate;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by Yang Wang on 4/6/17.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  04/06/2017 16:43
 */
@Entity
@Table(name = "CustomerWorkflowInstanceDocumentTemplate")
public class CustomerWorkflowInstanceDocumentTemplate extends CreatorEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -8839101975885884202L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  @JoinColumn(
    name      = "documentId",
    nullable  = false,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseDocument document;

  /** DOCUMENT ME! */
  @Column(
    name   = "extension",
    length = 10
  )
  protected String extension;

  /** fileContent. */
  @Column(columnDefinition = "MEDIUMBLOB")
  @Lob
  protected byte[] fileContent;

  /** LocaleType. */
  @Column(
          name   = "locale",
          length = 5
  )
  @Enumerated(EnumType.STRING)
  protected LocaleType locale = LocaleType.ENGLISH;



  /** DOCUMENT ME! */
  @Column(
    name   = "originalName",
    length = 255
  )
  protected String originalName;

  /** DOCUMENT ME! */
  @Cascade({ org.hibernate.annotations.CascadeType.DELETE_ORPHAN, org.hibernate.annotations.CascadeType.ALL })
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "template"
  )
  protected Set<CustomerWorkflowInstanceDocumentTemplateVariable> templateVariables =
    new HashSet<CustomerWorkflowInstanceDocumentTemplateVariable>();

  /** DOCUMENT ME! */
  @JoinColumn(
    name      = "enterpriseDocumentVersionTemplateId",
    nullable  = false,
    updatable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseDocumentVersionTemplate versionTemplate;

  /** DOCUMENT ME! */
  @JoinColumn(
    name      = "workflowInstanceId",
    nullable  = true,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CustomerWorkflowInstance workflowInstance;

  /** DOCUMENT ME! */
  @JoinColumn(
    name      = "workflowTaskElementId",
    nullable  = true,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CustomerWorkflowTaskElement workflowTaskElement;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
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
      CustomerWorkflowInstanceDocumentTemplateVariable templateVariable = null;

      if ((templateVariables != null) && (templateVariables.size() > 0)) {
        for (CustomerWorkflowInstanceDocumentTemplateVariable var : templateVariables) {
          if (variable.equals(var.getVariable())) {
            templateVariable = var;

            break;
          }
        }
      }

      if (templateVariable == null) {
        templateVariable = new CustomerWorkflowInstanceDocumentTemplateVariable();
        templateVariable.setVariable(variable);
      }

      templateVariable.setValue(value);
      templateVariable.setTemplate(this);
      templateVariable.setDocument(this.getDocument());
      templateVariable.setWorkflowInstance(this.getWorkflowInstance());

      getTemplateVariables().add(templateVariable);
    } // end if
  }   // end method addTemplateVariable

  //~ ------------------------------------------------------------------------------------------------------------------

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

    CustomerWorkflowInstanceDocumentTemplate that = (CustomerWorkflowInstanceDocumentTemplate) o;

    if ((document != null) ? (!document.equals(that.document)) : (that.document != null)) {
      return false;
    }

    if (locale != that.locale) {
      return false;
    }

    if ((versionTemplate != null) ? (!versionTemplate.equals(that.versionTemplate)) : (that.versionTemplate != null)) {
      return false;
    }

    if ((workflowInstance != null) ? (!workflowInstance.equals(that.workflowInstance))
                                   : (that.workflowInstance != null)) {
      return false;
    }

    return (workflowTaskElement != null) ? workflowTaskElement.equals(that.workflowTaskElement)
                                         : (that.workflowTaskElement == null);
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
   * getter method for template variables.
   *
   * @return  Set
   */
  public Set<CustomerWorkflowInstanceDocumentTemplateVariable> getTemplateVariables() {
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
   * getter method for workflow instance.
   *
   * @return  CustomerWorkflowInstance
   */
  public CustomerWorkflowInstance getWorkflowInstance() {
    return workflowInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for workflow task element.
   *
   * @return  CustomerWorkflowTaskElement
   */
  public CustomerWorkflowTaskElement getWorkflowTaskElement() {
    return workflowTaskElement;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((document != null) ? document.hashCode() : 0);
    result = (31 * result) + ((locale != null) ? locale.hashCode() : 0);
    result = (31 * result) + ((versionTemplate != null) ? versionTemplate.hashCode() : 0);
    result = (31 * result) + ((workflowInstance != null) ? workflowInstance.hashCode() : 0);
    result = (31 * result) + ((workflowTaskElement != null) ? workflowTaskElement.hashCode() : 0);

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
   * setter method for template variables.
   *
   * @param  templateVariables  Set
   */
  public void setTemplateVariables(Set<CustomerWorkflowInstanceDocumentTemplateVariable> templateVariables) {
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
   * setter method for workflow task element.
   *
   * @param  workflowTaskElement  CustomerWorkflowTaskElement
   */
  public void setWorkflowTaskElement(CustomerWorkflowTaskElement workflowTaskElement) {
    this.workflowTaskElement = workflowTaskElement;
  }
} // end class CustomerWorkflowInstanceDocumentTemplate
