package com.ozstrategy.credagility.core.domain.document;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/16/2014 11:54
 */
public class DocumentItem {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  private Long docInstanceId;

  private Long docTemplateId;

  private Boolean uploaded;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new DocumentItem object.
   */
  public DocumentItem() { }

  /**
   * Creates a new DocumentItem object.
   *
   * @param  docInstanceId  Long
   * @param  docTemplateId  Long
   * @param  uploaded       Boolean
   */
  public DocumentItem(Long docInstanceId, Long docTemplateId, Boolean uploaded) {
    this.docInstanceId = docInstanceId;
    this.docTemplateId = docTemplateId;
    this.uploaded      = uploaded;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for doc instance id.
   *
   * @return  Long
   */
  public Long getDocInstanceId() {
    return docInstanceId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for doc template id.
   *
   * @return  Long
   */
  public Long getDocTemplateId() {
    return docTemplateId;
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
   * setter method for doc instance id.
   *
   * @param  docInstanceId  Long
   */
  public void setDocInstanceId(Long docInstanceId) {
    this.docInstanceId = docInstanceId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for doc template id.
   *
   * @param  docTemplateId  Long
   */
  public void setDocTemplateId(Long docTemplateId) {
    this.docTemplateId = docTemplateId;
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
} // end class DocumentItem
