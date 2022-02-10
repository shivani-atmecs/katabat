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
@DiscriminatorValue("PDF")
@Entity public class PortfolioChannelTemplatePDFContent extends BasePortfolioChannelTemplateContent
  implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 4690321635621743303L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Portfolio channel template pdf content. */
  @Column(columnDefinition = "MEDIUMBLOB")
  @Lob protected byte[] fileContent;

  //~ Methods ----------------------------------------------------------------------------------------------------------

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

    PortfolioChannelTemplatePDFContent that = (PortfolioChannelTemplatePDFContent) o;

    if ((fileContent != null) ? (!fileContent.equals(that.fileContent)) : (that.fileContent != null)) {
      return false;
    }

    if ((id != null) ? (!id.equals(that.id)) : (that.id != null)) {
      return false;
    }

    return super.equals(o);
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public byte[] getFileContent() {
    return fileContent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Override public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = (id != null) ? id.hashCode() : 0;
    result = (31 * result) + ((fileContent != null) ? fileContent.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  fileContent  DOCUMENT ME!
   */
  public void setFileContent(byte[] fileContent) {
    this.fileContent = fileContent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  id  DOCUMENT ME!
   */
  @Override public void setId(Long id) {
    this.id = id;
  }
} // end class PortfolioChannelTemplatePDFContent
