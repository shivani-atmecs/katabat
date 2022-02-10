package com.ozstrategy.credagility.core.domain.document;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Lob;
import java.io.Serializable;


/**
 * This class is used to store EnterpriseDocumentVersionHTMLTemplate information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/16/2014 14:39
 */
@DiscriminatorValue("HTML")
@Entity public class EnterpriseDocumentVersionHTMLTemplate extends EnterpriseDocumentVersionTemplate
  implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 5426619722947461845L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @Lob private String content;

  @Lob private String textContent;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  BasicEnterpriseDocumentTemplate#copy()
   */
  @Override public EnterpriseDocumentVersionHTMLTemplate copy() {
    EnterpriseDocumentVersionHTMLTemplate content = new EnterpriseDocumentVersionHTMLTemplate();
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

    EnterpriseDocumentVersionHTMLTemplate that = (EnterpriseDocumentVersionHTMLTemplate) o;

    if ((content != null) && !content.equals(that.content)) {
      return false;
    }

    if ((textContent != null) && !textContent.equals(that.textContent)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for content.
   *
   * @return  String
   */
  public String getContent() {
    return content;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for text content.
   *
   * @return  String
   */
  public String getTextContent() {
    return textContent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  BasicEnterpriseDocumentTemplate#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((content != null) ? content.hashCode() : 0);
    result = (31 * result) + ((textContent != null) ? textContent.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * paste.
   *
   * @param  content  EnterpriseDocumentVersionHTMLTemplate
   */
  public void paste(EnterpriseDocumentVersionHTMLTemplate content) {
    super.paste(content);
    content.setContent(this.content);
    content.setTextContent(this.textContent);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for content.
   *
   * @param  content  String
   */
  public void setContent(String content) {
    this.content = content;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for text content.
   *
   * @param  textContent  String
   */
  public void setTextContent(String textContent) {
    this.textContent = textContent;
  }
} // end class EnterpriseDocumentVersionHTMLTemplate
