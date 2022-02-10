package com.cmc.credagility.core.domain.portfolio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Lob;

import com.cmc.credagility.core.domain.channel.BasePortfolioChannelTemplateContent;


/**
 * Document for new class.
 *
 * <p>: Wang Yang : 12-11-6 : PM12:30</p>
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */

@DiscriminatorValue("HTML")
@Entity public class PortfolioChannelTemplateHTMLContent extends BasePortfolioChannelTemplateContent
  implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 4690321635621743303L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Portfolio channel template html content. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob private String content;

  /** Portfolio channel template html text content. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob private String textContent;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.channel.BasePortfolioChannelTemplateContent#equals(java.lang.Object)
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

    PortfolioChannelTemplateHTMLContent that = (PortfolioChannelTemplateHTMLContent) o;

    if (!content.equals(that.content)) {
      return false;
    }

    if (!textContent.equals(that.textContent)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getContent() {
    return content;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTextContent() {
    return textContent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((content != null) ? content.hashCode() : 0);
    result = (31 * result) + ((textContent != null) ? textContent.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  content  DOCUMENT ME!
   */
  public void setContent(String content) {
    this.content = content;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  textContent  DOCUMENT ME!
   */
  public void setTextContent(String textContent) {
    this.textContent = textContent;
  }
} // end class PortfolioChannelTemplateHTMLContent
