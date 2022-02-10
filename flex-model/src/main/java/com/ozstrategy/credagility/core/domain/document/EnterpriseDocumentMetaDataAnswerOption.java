package com.ozstrategy.credagility.core.domain.document;

import javax.persistence.*;


/**
 * This class is used to store EnterpriseDocumentMetaDataAnswerOption information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/16/2014 14:29
 */
@Entity
@Table(name = "EnterpriseDocumentMetaDataAnswerOption")
public class EnterpriseDocumentMetaDataAnswerOption extends BaseDocumentMetaDataAnswerOption {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -7665635650288885373L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "documentMetaDataId",
    nullable   = false,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseDocumentMetaData documentMetaData;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for document meta data.
   *
   * @return  EnterpriseDocumentMetaData
   */
  public EnterpriseDocumentMetaData getDocumentMetaData() {
    return documentMetaData;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for document meta data.
   *
   * @param  documentMetaData  EnterpriseDocumentMetaData
   */
  public void setDocumentMetaData(EnterpriseDocumentMetaData documentMetaData) {
    this.documentMetaData = documentMetaData;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("EnterpriseDocumentMetaDataAnswerOption");
    sb.append("{displayName=").append(displayName);
    sb.append(",value=").append(value);
    sb.append(",displayOrder=").append(displayOrder);
    sb.append(",isDefault=").append(isDefault);
    sb.append('}');

    return sb.toString();
  }
} // end class EnterpriseDocumentMetaDataAnswerOption
