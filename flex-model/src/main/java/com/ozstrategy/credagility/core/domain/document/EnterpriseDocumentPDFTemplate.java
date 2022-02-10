package com.ozstrategy.credagility.core.domain.document;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Lob;
import java.io.Serializable;
import java.util.Arrays;


/**
 * This class is used to store EnterpriseDocumentPDFTemplate information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/16/2014 14:33
 */
@DiscriminatorValue("PDF")
@Entity public class EnterpriseDocumentPDFTemplate extends EnterpriseDocumentTemplate implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 1129039919427311729L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  @Column(columnDefinition = "MEDIUMBLOB")
  @Lob protected byte[] fileContent;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  BasicEnterpriseDocumentTemplate#copy()
   */
  @Override public EnterpriseDocumentPDFTemplate copy() {
    EnterpriseDocumentPDFTemplate content = new EnterpriseDocumentPDFTemplate();
    paste(content);
    content.setFileContent(this.fileContent);

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

    EnterpriseDocumentPDFTemplate that = (EnterpriseDocumentPDFTemplate) o;

    if (!Arrays.equals(fileContent, that.fileContent)) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  EnterpriseDocumentTemplate#generateVersionInfo()
   */
  @Override public EnterpriseDocumentVersionPDFTemplate generateVersionInfo() {
    EnterpriseDocumentVersionPDFTemplate cont = new EnterpriseDocumentVersionPDFTemplate();
    paste(cont);
    cont.setFileContent(this.fileContent);

    return cont;
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
   * @param  content  EnterpriseDocumentPDFTemplate
   */
  public void paste(EnterpriseDocumentPDFTemplate content) {
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

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("EnterpriseDocumentHTMLTemplate");
    sb.append("{version='").append(version).append('\'');
    sb.append("{locale='").append(locale.toString()).append('\'');
    sb.append('}');

    return sb.toString();
  }
} // end class EnterpriseDocumentPDFTemplate
