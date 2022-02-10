package com.ozstrategy.credagility.core.info;

import java.util.Date;


/**
 * Created by yongliu on 2/9/15.
 *
 * @author   <a href="mailto:yong.liu@ozstrategy.com">Yong Liu</a>
 * @version  02/09/2015 10:14
 */
public class DocumentInfo {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String  categoryName;
  private String  categoryPath;
  private Date    createDate;
  private Long    creatorId;
  private String  creatorName;
  private Long    docId;
  private String  docName;
  private Long    documentCategoryId;
  private String  extension;
  private String  fileName;
  private Long    fileSize;
  private Integer insCount;
  private Long    instanceId;
  private Long    statusId;
  private String  statusName;
  private Boolean uploaded;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new DocumentInfo object.
   */
  public DocumentInfo() { }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for category name.
   *
   * @return  String
   */
  public String getCategoryName() {
    return categoryName;
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
   * getter method for create date.
   *
   * @return  Date
   */
  public Date getCreateDate() {
    if (createDate == null) {
      return null;
    }

    return (Date) createDate.clone();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for creator id.
   *
   * @return  Long
   */
  public Long getCreatorId() {
    return creatorId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for creator name.
   *
   * @return  String
   */
  public String getCreatorName() {
    return creatorName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for doc id.
   *
   * @return  Long
   */
  public Long getDocId() {
    return docId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for doc name.
   *
   * @return  String
   */
  public String getDocName() {
    return docName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for document category id.
   *
   * @return  Long
   */
  public Long getDocumentCategoryId() {
    return documentCategoryId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for extension.
   *
   * @return  String
   */
  public String getExtension() {
    if (extension == null) {
      return "";
    }

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
   * getter method for ins count.
   *
   * @return  Integer
   */
  public Integer getInsCount() {
    return insCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for instance id.
   *
   * @return  Long
   */
  public Long getInstanceId() {
    return instanceId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status id.
   *
   * @return  Long
   */
  public Long getStatusId() {
    return statusId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status name.
   *
   * @return  String
   */
  public String getStatusName() {
    return statusName;
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
   * setter method for category name.
   *
   * @param  categoryName  String
   */
  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
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
   * setter method for create date.
   *
   * @param  createDate  Date
   */
  public void setCreateDate(Date createDate) {
    if (createDate != null) {
      this.createDate = new Date(createDate.getTime());
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for creator id.
   *
   * @param  creatorId  Long
   */
  public void setCreatorId(Long creatorId) {
    this.creatorId = creatorId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for creator name.
   *
   * @param  creatorName  String
   */
  public void setCreatorName(String creatorName) {
    this.creatorName = creatorName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for doc id.
   *
   * @param  docId  Long
   */
  public void setDocId(Long docId) {
    this.docId = docId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for doc name.
   *
   * @param  docName  String
   */
  public void setDocName(String docName) {
    this.docName = docName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for document category id.
   *
   * @param  documentCategoryId  Long
   */
  public void setDocumentCategoryId(Long documentCategoryId) {
    this.documentCategoryId = documentCategoryId;
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
   * setter method for ins count.
   *
   * @param  insCount  Integer
   */
  public void setInsCount(Integer insCount) {
    this.insCount = insCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for instance id.
   *
   * @param  instanceId  Long
   */
  public void setInstanceId(Long instanceId) {
    this.instanceId = instanceId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for status id.
   *
   * @param  statusId  Long
   */
  public void setStatusId(Long statusId) {
    this.statusId = statusId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for status name.
   *
   * @param  statusName  String
   */
  public void setStatusName(String statusName) {
    this.statusName = statusName;
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
} // end class DocumentInfo
