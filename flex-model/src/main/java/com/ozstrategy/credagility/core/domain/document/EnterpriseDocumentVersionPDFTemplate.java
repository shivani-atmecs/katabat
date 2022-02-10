package com.ozstrategy.credagility.core.domain.document;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Lob;
import java.io.Serializable;
import java.util.Arrays;


/**
 * This class is used to store EnterpriseDocumentVersionPDFTemplate information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/16/2014 14:41
 */
@DiscriminatorValue("PDF")
@Entity public class EnterpriseDocumentVersionPDFTemplate extends EnterpriseDocumentVersionTemplate
  implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -3267248439082395234L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(columnDefinition = "MEDIUMBLOB")
  @Lob protected byte[] fileContent;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  BasicEnterpriseDocumentTemplate#copy()
   */
  @Override public EnterpriseDocumentVersionPDFTemplate copy() {
    EnterpriseDocumentVersionPDFTemplate content = new EnterpriseDocumentVersionPDFTemplate();
    paste(content);

    return content;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#equals(Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    EnterpriseDocumentVersionPDFTemplate that = (EnterpriseDocumentVersionPDFTemplate) o;

    if ((fileContent != null) && !Arrays.equals(fileContent, that.fileContent)) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for file content.
   *
   * @return  byte[]
   */
  public byte[] getFileContent() {
    return fileContent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  BasicEnterpriseDocumentTemplate#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((fileContent != null) ? Arrays.hashCode(fileContent) : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * paste.
   *
   * @param  content  EnterpriseDocumentVersionPDFTemplate
   */
  public void paste(EnterpriseDocumentVersionPDFTemplate content) {
    super.paste(content);
    content.setFileContent(this.fileContent);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for file content.
   *
   * @param  fileContent  byte[]
   */
  public void setFileContent(byte[] fileContent) {
    this.fileContent = fileContent;
  }
} // end class EnterpriseDocumentVersionPDFTemplate
