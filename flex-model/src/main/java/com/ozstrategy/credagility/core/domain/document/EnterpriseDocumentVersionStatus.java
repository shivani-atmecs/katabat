package com.ozstrategy.credagility.core.domain.document;

import com.cmc.credagility.core.domain.document.DocumentStatus;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;


/**
 * This class is used to store EnterpriseDocumentVersionStatus information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/16/2014 14:42
 */
@Entity public class EnterpriseDocumentVersionStatus extends BasicEnterpriseDocumentStatus implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -6508742460975857964L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** PortfolioDocumentVersion. */
  @JoinColumn(
    name      = "documentVersionId",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseDocumentVersion documentVersion;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new EnterpriseDocumentVersionStatus object.
   */
  public EnterpriseDocumentVersionStatus() { }

  /**
   * Creates a new EnterpriseDocumentVersionStatus object.
   *
   * @param  documentStatus  DocumentStatus
   */
  public EnterpriseDocumentVersionStatus(DocumentStatus documentStatus) {
    super(documentStatus);
  }

  /**
   * Creates a new EnterpriseDocumentVersionStatus object.
   *
   * @param  documentStatus  DocumentStatus
   * @param  flowPosition    String
   */
  public EnterpriseDocumentVersionStatus(DocumentStatus documentStatus, String flowPosition) {
    super(documentStatus, flowPosition);
  }

  /**
   * Creates a new EnterpriseDocumentVersionStatus object.
   *
   * @param  documentStatus  DocumentStatus
   * @param  flowPosition    String
   * @param  asDefault       Boolean
   */
  public EnterpriseDocumentVersionStatus(DocumentStatus documentStatus, String flowPosition, Boolean asDefault) {
    super(documentStatus, flowPosition, asDefault);
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  BasicEnterpriseDocumentStatus#copy()
   */
  @Override public EnterpriseDocumentVersionStatus copy() {
    EnterpriseDocumentVersionStatus status = new EnterpriseDocumentVersionStatus();
    paste(status);
    status.setDocumentVersion(documentVersion);

    return status;
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
   * setter method for document version.
   *
   * @param  documentVersion  EnterpriseDocumentVersion
   */
  public void setDocumentVersion(EnterpriseDocumentVersion documentVersion) {
    this.documentVersion = documentVersion;
  }
} // end class EnterpriseDocumentVersionStatus
