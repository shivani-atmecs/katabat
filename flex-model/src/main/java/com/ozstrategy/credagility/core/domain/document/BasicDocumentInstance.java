package com.ozstrategy.credagility.core.domain.document;

import com.cmc.credagility.core.domain.document.DocumentCategory;
import com.cmc.credagility.core.domain.document.DocumentStatus;
import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.CreatorEntity;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 * DocumentInstance Abstract Class.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/16/2014 11:30
 */
@MappedSuperclass public abstract class BasicDocumentInstance extends CreatorEntity implements Serializable {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean active = false;

  /** Category Name Path. */
  @Column(length = 1024)
  protected String categoryPath;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "documentId",
    nullable  = false,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseDocument document;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "documentCategoryId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected DocumentCategory documentCategory;

  /** Document Status. */
  @JoinColumn(
    name      = "statusId",
    updatable = false,
    nullable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected DocumentStatus documentStatus;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "documentVersionId",
    nullable  = false,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseDocumentVersion documentVersion;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "documentVersionTemplateId",
    nullable  = true,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseDocumentVersionTemplate documentVersionTemplate;


  /** TODO: DOCUMENT ME! */
  @Column(length = 128)
  protected String extension;

  /** File OriginalName. */
  @Column(length = 1024)
  protected String fileName;

  /**byte*/
  @Column protected Long fileSize;


  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String fileType;


  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;


  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean uploaded;


  /** Ref WorkflowStep or SurveyFlowStep. */
  @Column(name = "workflowStepId")
  protected Long workflowStepId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addMetaDataValue.
   *
   * @param   metaDataValue  DocumentMetaDataValue
   *
   * @return  boolean
   */
  public abstract boolean addMetaDataValue(DocumentMetaDataValue metaDataValue);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * clearAllMetaDataValue.
   */
  public abstract void clearAllMetaDataValue();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for meta data values.
   *
   * @return  Set
   */
  public abstract Set<? extends DocumentMetaDataValue> getMetaDataValues();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for owner.
   *
   * @return  Object
   */
  public abstract Object getOwner();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for previous instance.
   *
   * @return  BasicDocumentInstance
   */
  public abstract BasicDocumentInstance getPreviousInstance();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for business object.
   *
   * @param  businessObject  WorkflowBusinessObject
   */
  public abstract void setBusinessObject(WorkflowBusinessObject businessObject);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updatePreviousInstance.
   *
   * @param  currentInstance  BasicDocumentInstance
   */
  public abstract void updatePreviousInstance(BasicDocumentInstance currentInstance);

  //~ ------------------------------------------------------------------------------------------------------------------

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

    BasicDocumentInstance that = (BasicDocumentInstance) o;

    if ((active != null) ? (!active.equals(that.active)) : (that.active != null)) {
      return false;
    }

    if ((categoryPath != null) ? (!categoryPath.equals(that.categoryPath)) : (that.categoryPath != null)) {
      return false;
    }

    if (!document.equals(that.document)) {
      return false;
    }

    if ((documentCategory != null) ? (!documentCategory.equals(that.documentCategory))
                                   : (that.documentCategory != null)) {
      return false;
    }

    if (!documentStatus.equals(that.documentStatus)) {
      return false;
    }

    if (!documentVersion.equals(that.documentVersion)) {
      return false;
    }

    if ((documentVersionTemplate != null) ? (!documentVersionTemplate.equals(that.documentVersionTemplate))
                                          : (that.documentVersionTemplate != null)) {
      return false;
    }

    if ((extension != null) ? (!extension.equals(that.extension)) : (that.extension != null)) {
      return false;
    }

    if ((fileName != null) ? (!fileName.equals(that.fileName)) : (that.fileName != null)) {
      return false;
    }

    if ((fileType != null) ? (!fileType.equals(that.fileType)) : (that.fileType != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for active.
   *
   * @return  Boolean
   */
  public Boolean getActive() {
    if (active == null) {
      return Boolean.FALSE;
    }

    return active;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for category path.
   *
   * @return  String
   */
  public String getCategoryPath() {
    return categoryPath;
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
   * getter method for document category.
   *
   * @return  DocumentCategory
   */
  public DocumentCategory getDocumentCategory() {
    return documentCategory;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for document meta data name values.
   *
   * @return  Map
   */
  public Map<String, DocumentMetaDataValue> getDocumentMetaDataNameValues() {
    Map<String, DocumentMetaDataValue> metaDataValueMap = new HashMap<String, DocumentMetaDataValue>();

    for (DocumentMetaDataValue metaDataValue : getMetaDataValues()) {
      metaDataValueMap.put(metaDataValue.getMetaData().getName(), metaDataValue);
    }

    return metaDataValueMap;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for document meta data values.
   *
   * @return  Map
   */
  public Map<Long, DocumentMetaDataValue> getDocumentMetaDataValues() {
    Map<Long, DocumentMetaDataValue> metaDataValueMap = new HashMap<Long, DocumentMetaDataValue>();

    for (DocumentMetaDataValue metaDataValue : getMetaDataValues()) {
      metaDataValueMap.put(metaDataValue.getMetaData().getId(), metaDataValue);
    }

    return metaDataValueMap;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for document status.
   *
   * @return  DocumentStatus
   */
  public DocumentStatus getDocumentStatus() {
    return documentStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for document version.
   *
   * @return  EnterpriseDocumentVersion
   */
  public EnterpriseDocumentVersion getDocumentVersion() {
    return documentVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for document version template.
   *
   * @return  EnterpriseDocumentVersionTemplate
   */
  public EnterpriseDocumentVersionTemplate getDocumentVersionTemplate() {
    return documentVersionTemplate;
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
   * getter method for file name.
   *
   * @return  String
   */
  public String getFileName() {
    return fileName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for file size.
   *
   * @return  Long
   */
  public Long getFileSize() {
    return fileSize;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for file type.
   *
   * @return  String
   */
  public String getFileType() {
    return fileType;
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
   * getter method for uploaded.
   *
   * @return  Boolean
   */
  public Boolean getUploaded() {
    if (uploaded == null) {
      return Boolean.FALSE;
    }

    return uploaded;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for workflow step id.
   *
   * @return  Long
   */
  public Long getWorkflowStepId() {
    return workflowStepId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((document != null) ? document.hashCode() : 0);
    result = (31 * result) + ((documentStatus != null) ? documentStatus.hashCode() : 0);
    result = (31 * result) + ((documentVersion != null) ? documentVersion.hashCode() : 0);
    result = (31 * result) + ((documentVersionTemplate != null) ? documentVersionTemplate.hashCode() : 0);
    result = (31 * result) + ((active != null) ? active.hashCode() : 0);
    result = (31 * result) + ((documentCategory != null) ? documentCategory.hashCode() : 0);
    result = (31 * result) + ((fileType != null) ? fileType.hashCode() : 0);
    result = (31 * result) + ((fileName != null) ? fileName.hashCode() : 0);
    result = (31 * result) + ((categoryPath != null) ? categoryPath.hashCode() : 0);
    result = (31 * result) + ((extension != null) ? extension.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * processDocumentCategory.
   *
   * @param   category  DocumentCategory
   *
   * @return  String
   */
  public String processDocumentCategory(DocumentCategory category) {
    StringBuffer categoryPath = new StringBuffer();

    if (category != null) {
      categoryPath.append(category.getName());

      DocumentCategory parentCategory = category.getParentCategory();

      while (parentCategory != null) {
        categoryPath.insert(0, parentCategory.getName() + "/");
        parentCategory = parentCategory.getParentCategory();
      }
    }

    return categoryPath.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for active.
   *
   * @param  active  Boolean
   */
  public void setActive(Boolean active) {
    this.active = active;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for category path.
   *
   * @param  categoryPath  String
   */
  public void setCategoryPath(String categoryPath) {
    this.categoryPath = categoryPath;
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
   * setter method for document category.
   *
   * @param  documentCategory  DocumentCategory
   */
  public void setDocumentCategory(DocumentCategory documentCategory) {
    this.documentCategory = documentCategory;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for document status.
   *
   * @param  documentStatus  DocumentStatus
   */
  public void setDocumentStatus(DocumentStatus documentStatus) {
    this.documentStatus = documentStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for document version.
   *
   * @param  documentVersion  EnterpriseDocumentVersion
   */
  public void setDocumentVersion(EnterpriseDocumentVersion documentVersion) {
    this.documentVersion = documentVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for document version template.
   *
   * @param  documentVersionTemplate  EnterpriseDocumentVersionTemplate
   */
  public void setDocumentVersionTemplate(EnterpriseDocumentVersionTemplate documentVersionTemplate) {
    this.documentVersionTemplate = documentVersionTemplate;
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
   * setter method for file name.
   *
   * @param  fileName  String
   */
  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for file size.
   *
   * @param  fileSize  Long
   */
  public void setFileSize(Long fileSize) {
    this.fileSize = fileSize;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for file type.
   *
   * @param  fileType  String
   */
  public void setFileType(String fileType) {
    this.fileType = fileType;
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
   * setter method for uploaded.
   *
   * @param  uploaded  Boolean
   */
  public void setUploaded(Boolean uploaded) {
    this.uploaded = uploaded;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for workflow step id.
   *
   * @param  workflowStepId  Long
   */
  public void setWorkflowStepId(Long workflowStepId) {
    this.workflowStepId = workflowStepId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updateCategoryPath.
   */
  public void updateCategoryPath() {
    this.setCategoryPath(processDocumentCategory(this.documentCategory));
  }
} // end class BasicDocumentInstance
