package com.ozstrategy.credagility.core.domain.document;

import javax.persistence.*;


/**
 * This class is used to store EnterpriseDocumentVersionMetaDataAnswerOption information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/16/2014 14:41
 */
@Entity
@Table(name = "EnterpriseDocumentVersionMetaDataAnswerOption")
public class EnterpriseDocumentVersionMetaDataAnswerOption extends BaseDocumentMetaDataAnswerOption {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -7665635650288885373L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "documentVersionMetaDataId",
    nullable   = false,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseDocumentVersionMetaData documentVersionMetaData;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for document version meta data.
   *
   * @return  EnterpriseDocumentVersionMetaData
   */
  public EnterpriseDocumentVersionMetaData getDocumentVersionMetaData() {
    return documentVersionMetaData;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for document version meta data.
   *
   * @param  documentVersionMetaData  EnterpriseDocumentVersionMetaData
   */
  public void setDocumentVersionMetaData(EnterpriseDocumentVersionMetaData documentVersionMetaData) {
    this.documentVersionMetaData = documentVersionMetaData;
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
} // end class EnterpriseDocumentVersionMetaDataAnswerOption
