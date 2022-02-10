package com.ozstrategy.credagility.core.domain.document;

import javax.persistence.*;
import java.io.Serializable;


/**
 * This class is used to store EnterpriseDocumentVersionTemplate information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/16/2014 14:42
 */
@DiscriminatorColumn(
  name              = "contentType",
  discriminatorType = DiscriminatorType.STRING
)
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "EnterpriseDocumentVersionTemplate")
public abstract class EnterpriseDocumentVersionTemplate extends BasicEnterpriseDocumentTemplate
  implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 2627121747032189531L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "documentVersionId",
    nullable  = false,
    updatable = false
  )
  @ManyToOne protected EnterpriseDocumentVersion documentVersion;

  //~ Methods ----------------------------------------------------------------------------------------------------------

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
   * setter method for document version.
   *
   * @param  documentVersion  EnterpriseDocumentVersion
   */
  public void setDocumentVersion(EnterpriseDocumentVersion documentVersion) {
    this.documentVersion = documentVersion;
  }
} // end class EnterpriseDocumentVersionTemplate
