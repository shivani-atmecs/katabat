package com.ozstrategy.credagility.core.domain.workflow;

import com.ozstrategy.credagility.core.util.MediaTypeUtils;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/16/2014 16:45
 */
public class FileItem implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 4790729848061175875L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  protected byte[] content;

  /** TODO: DOCUMENT ME! */
  protected String contentType;

  /** TODO: DOCUMENT ME! */
  protected String extension;

  /** true: uploaded a new file, false: keep the old data */
  protected Boolean fromUploaded = Boolean.TRUE;

  /** TODO: DOCUMENT ME! */
  protected List<MetaDataItem> metaDataItems = new ArrayList<MetaDataItem>(20);

  /** TODO: DOCUMENT ME! */
  protected List<String> metaDataWithNoValue = new ArrayList<String>(20);

  /** TODO: DOCUMENT ME! */
  protected String originalName;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new FileItem object.
   */
  public FileItem() { }

  /**
   * Creates a new FileItem object.
   *
   * @param  fromUploaded  DOCUMENT ME!
   */
  public FileItem(Boolean fromUploaded) {
    this.fromUploaded = fromUploaded;
  }

  /**
   * Creates a new FileItem object.
   *
   * @param  contentType  DOCUMENT ME!
   * @param  content      DOCUMENT ME!
   */
  public FileItem(String contentType, byte[] content) {
    this.contentType = contentType;
    this.extension   = populateExtension(contentType);
    this.content     = content;
  }

  /**
   * Creates a new FileItem object.
   *
   * @param  content    DOCUMENT ME!
   * @param  extension  DOCUMENT ME!
   */
  public FileItem(byte[] content, String extension) {
    this.content     = content;
    this.extension   = extension;
    this.contentType = populateContentType(extension);
  }

  /**
   * Creates a new FileItem object.
   *
   * @param  contentType  DOCUMENT ME!
   * @param  extension    DOCUMENT ME!
   * @param  content      DOCUMENT ME!
   */
  public FileItem(String contentType, String extension, byte[] content) {
    this.contentType = contentType;
    this.extension   = extension;
    this.content     = content;
  }

  /**
   * Creates a new FileItem object.
   *
   * @param  content       DOCUMENT ME!
   * @param  extension     DOCUMENT ME!
   * @param  originalName  DOCUMENT ME!
   */
  public FileItem(byte[] content, String extension, String originalName) {
    this.content      = content;
    this.extension    = extension;
    this.contentType  = populateContentType(extension);
    this.originalName = (originalName != null) ? originalName.replaceAll(" ", "_") : UUID.randomUUID().toString();
  }

  /**
   * Creates a new FileItem object.
   *
   * @param  content       DOCUMENT ME!
   * @param  extension     DOCUMENT ME!
   * @param  originalName  DOCUMENT ME!
   * @param  fromUploaded  DOCUMENT ME!
   */
  public FileItem(byte[] content, String extension, String originalName, Boolean fromUploaded) {
    this.content      = content;
    this.extension    = extension;
    this.contentType  = populateContentType(extension);
    this.originalName = (originalName != null) ? originalName.replaceAll(" ", "_") : UUID.randomUUID().toString();
    this.fromUploaded = fromUploaded;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * populateContentType.
   *
   * @param   extension  String
   *
   * @return  String
   */
  public static String populateContentType(String extension) {
//    if ("pdf".equalsIgnoreCase(extension) || ".pdf".equalsIgnoreCase(extension)) {
//      return "application/pdf";
//    } else if ("xls".equalsIgnoreCase(extension) || ".xls".equalsIgnoreCase(extension)) {
//      return "application/vnd.ms-excel";
//    } else if ("xlsx".equalsIgnoreCase(extension) || ".xlsx".equalsIgnoreCase(extension)) {
//      return "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
//    } else if ("doc".equalsIgnoreCase(extension) || ".doc".equalsIgnoreCase(extension)) {
//      return "application/msword";
//    } else if ("docx".equalsIgnoreCase(extension) || ".docx".equalsIgnoreCase(extension)) {
//      return "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
//    }

    return MediaTypeUtils.getContentType(extension);

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * populateExtension.
   *
   * @param   contentType  String
   *
   * @return  String
   */
  public static String populateExtension(String contentType) {
//    if ("application/pdf".equals(contentType)) {
//      return "pdf";
//    } else if ("application/vnd.ms-excel".equals(contentType)) {
//      return "xls";
//    } else if ("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet".equals(contentType)) {
//      return "xlsx";
//    } else if ("application/msword".equals(contentType)) {
//      return "doc";
//    } else if ("application/vnd.openxmlformats-officedocument.wordprocessingml.document".equals(contentType)) {
//      return "docx";
//    }
//
//    return "";
    
    return MediaTypeUtils.getExtension(contentType);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * appendMetaDataItems.
   *
   * @param  metaDataItems  List
   */
  public void appendMetaDataItems(List<MetaDataItem> metaDataItems) {
    this.metaDataItems.addAll(metaDataItems);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * appendMetaDataWithoutValue.
   *
   * @param  metaDataName  String
   */
  public void appendMetaDataWithoutValue(String metaDataName) {
    if ((metaDataName != null) && StringUtils.hasText(metaDataName)) {
      this.metaDataWithNoValue.add(metaDataName);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for content.
   *
   * @return  byte[]
   */
  public byte[] getContent() {
    return content;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for content type.
   *
   * @return  String
   */
  public String getContentType() {
    return contentType;
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
   * getter method for from uploaded.
   *
   * @return  Boolean
   */
  public Boolean getFromUploaded() {
    return fromUploaded;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for meta data items.
   *
   * @return  List
   */
  public List<MetaDataItem> getMetaDataItems() {
    return metaDataItems;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for meta data with no value.
   *
   * @return  List
   */
  public List<String> getMetaDataWithNoValue() {
    return metaDataWithNoValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for original name.
   *
   * @return  String
   */
  public String getOriginalName() {
    if ((originalName == null) || "".equals(originalName.trim())) {
      if ((content == null) || (content.length == 0)) {
        return null;
      }

      return UUID.randomUUID().toString();
    }

    return originalName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for content.
   *
   * @param  content  byte[]
   */
  public void setContent(byte[] content) {
    this.content = content;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for content type.
   *
   * @param  contentType  String
   */
  public void setContentType(String contentType) {
    this.contentType = contentType;
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
   * setter method for from uploaded.
   *
   * @param  fromUploaded  Boolean
   */
  public void setFromUploaded(Boolean fromUploaded) {
    this.fromUploaded = fromUploaded;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for meta data items.
   *
   * @param  metaDataItems  List
   */
  public void setMetaDataItems(List<MetaDataItem> metaDataItems) {
    this.metaDataItems = metaDataItems;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for meta data with no value.
   *
   * @param  metaDataWithNoValue  List
   */
  public void setMetaDataWithNoValue(List<String> metaDataWithNoValue) {
    this.metaDataWithNoValue = metaDataWithNoValue;
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
} // end class FileItem
