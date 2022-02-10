package com.ozstrategy.credagility.core.domain.document;

import com.cmc.credagility.core.domain.document.DocumentStatus;

import javax.persistence.Entity;


/**
 * This class is used to store EnterpriseDocumentStatus information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/16/2014 14:34
 */
@Entity public class EnterpriseDocumentStatus extends BasicEnterpriseDocumentStatus {
  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new EnterpriseDocumentStatus object.
   */
  public EnterpriseDocumentStatus() { }

  /**
   * Creates a new EnterpriseDocumentStatus object.
   *
   * @param  documentStatus  DocumentStatus
   */
  public EnterpriseDocumentStatus(DocumentStatus documentStatus) {
    super(documentStatus);
  }

  /**
   * Creates a new EnterpriseDocumentStatus object.
   *
   * @param  documentStatus  DocumentStatus
   * @param  flowPosition    String
   */
  public EnterpriseDocumentStatus(DocumentStatus documentStatus, String flowPosition) {
    super(documentStatus, flowPosition);
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  BasicEnterpriseDocumentStatus#copy()
   */
  @Override public EnterpriseDocumentStatus copy() {
    EnterpriseDocumentStatus status = new EnterpriseDocumentStatus();
    paste(status);

    return status;
  }
} // end class EnterpriseDocumentStatus
