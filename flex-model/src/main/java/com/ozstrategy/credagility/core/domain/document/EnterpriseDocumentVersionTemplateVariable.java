package com.ozstrategy.credagility.core.domain.document;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;


/**
 * This class is used to store EnterpriseDocumentVersionTemplateVariable information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/16/2014 14:42
 */
@Entity public class EnterpriseDocumentVersionTemplateVariable extends BasicEnterpriseDocumentTemplateVariable
  implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 5429928810629574446L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** PortfolioDocumentVersion. */
  @JoinColumn(
    name      = "documentVersionId",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseDocumentVersion documentVersion;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  BasicEnterpriseDocumentTemplateVariable#copy()
   */
  @Override public EnterpriseDocumentVersionTemplateVariable copy() {
    EnterpriseDocumentVersionTemplateVariable variable = new EnterpriseDocumentVersionTemplateVariable();
    paste(variable);
    variable.setDocumentVersion(documentVersion);

    return variable;
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
} // end class EnterpriseDocumentVersionTemplateVariable
