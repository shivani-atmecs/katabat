package com.ozstrategy.credagility.core.domain.workflow;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/16/2014 16:47
 */
public class UploadDocFileItem extends FileItem {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  protected Long insId;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new UploadDocFileItem object.
   */
  public UploadDocFileItem() { }

  /**
   * Creates a new UploadDocFileItem object.
   *
   * @param  fromUploaded  DOCUMENT ME!
   */
  public UploadDocFileItem(Boolean fromUploaded) {
    super(fromUploaded);
  }

  /**
   * Creates a new UploadDocFileItem object.
   *
   * @param  contentType  DOCUMENT ME!
   * @param  content      DOCUMENT ME!
   */
  public UploadDocFileItem(String contentType, byte[] content) {
    super(contentType, content);
  }

  /**
   * Creates a new UploadDocFileItem object.
   *
   * @param  content    DOCUMENT ME!
   * @param  extension  DOCUMENT ME!
   */
  public UploadDocFileItem(byte[] content, String extension) {
    super(content, extension);
  }

  /**
   * Creates a new UploadDocFileItem object.
   *
   * @param  contentType  DOCUMENT ME!
   * @param  extension    DOCUMENT ME!
   * @param  content      DOCUMENT ME!
   */
  public UploadDocFileItem(String contentType, String extension, byte[] content) {
    super(contentType, extension, content);
  }

  /**
   * Creates a new UploadDocFileItem object.
   *
   * @param  content       DOCUMENT ME!
   * @param  extension     DOCUMENT ME!
   * @param  originalName  DOCUMENT ME!
   */
  public UploadDocFileItem(byte[] content, String extension, String originalName) {
    super(content, extension, originalName);
  }

  /**
   * Creates a new UploadDocFileItem object.
   *
   * @param  content       DOCUMENT ME!
   * @param  extension     DOCUMENT ME!
   * @param  originalName  DOCUMENT ME!
   * @param  fromUploaded  DOCUMENT ME!
   */
  public UploadDocFileItem(byte[] content, String extension, String originalName, Boolean fromUploaded) {
    super(content, extension, originalName, fromUploaded);
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for file size.
   *
   * @return  int
   */
  public int getFileSize() {
    if (content != null) {
      return content.length;
    }

    return 0;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ins id.
   *
   * @return  Long
   */
  public Long getInsId() {
    return insId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ins id.
   *
   * @param  insId  Long
   */
  public void setInsId(Long insId) {
    this.insId = insId;
  }
} // end class UploadDocFileItem
