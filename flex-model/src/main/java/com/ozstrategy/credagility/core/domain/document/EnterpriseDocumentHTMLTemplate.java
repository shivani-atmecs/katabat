package com.ozstrategy.credagility.core.domain.document;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Lob;
import java.io.Serializable;


/**
 * This class is used to store EnterpriseDocumentHTMLTemplate information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/16/2014 14:26
 */
@DiscriminatorValue("HTML")
@Entity public class EnterpriseDocumentHTMLTemplate extends EnterpriseDocumentTemplate implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -2217871056191183331L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @Lob private String content;

  @Lob private String textContent;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  BasicEnterpriseDocumentTemplate#copy()
   */
  @Override public EnterpriseDocumentHTMLTemplate copy() {
    EnterpriseDocumentHTMLTemplate content = new EnterpriseDocumentHTMLTemplate();
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

    EnterpriseDocumentHTMLTemplate that = (EnterpriseDocumentHTMLTemplate) o;

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
   * @see  EnterpriseDocumentTemplate#generateVersionInfo()
   */
  @Override public EnterpriseDocumentVersionHTMLTemplate generateVersionInfo() {
    EnterpriseDocumentVersionHTMLTemplate cont = new EnterpriseDocumentVersionHTMLTemplate();
    paste(cont);
    cont.setTextContent(this.textContent);
    cont.setContent(this.content);

    return cont;
  }

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
   * @param  content  EnterpriseDocumentHTMLTemplate
   */
  public void paste(EnterpriseDocumentHTMLTemplate content) {
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

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("EnterpriseDocumentHTMLTemplate");
    sb.append("{content='").append(content).append('\'');
    sb.append(", textContent='").append(textContent).append('\'');
    sb.append("{version='").append(version).append('\'');
    sb.append("{locale='").append(locale.toString()).append('\'');
    sb.append('}');

    return sb.toString();
  }
} // end class EnterpriseDocumentHTMLTemplate
