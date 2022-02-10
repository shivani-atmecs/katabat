package com.ozstrategy.credagility.core.domain.document.responsible;

import com.ozstrategy.credagility.core.domain.document.BasicDocumentInstance;
import com.ozstrategy.credagility.core.domain.document.BasicUploadDocumentBlob;

import javax.persistence.*;
import java.io.Serializable;


/**
 * This class is used to store ResponsibleUploadDocumentBlob information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/16/2014 15:03
 */
@Entity
@Table(name = "ResponsibleUploadDocumentBlob")
public class ResponsibleUploadDocumentBlob extends BasicUploadDocumentBlob implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 1477239501087119169L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @JoinColumn(name = "documentInstanceId")
  @ManyToOne(
    fetch    = FetchType.LAZY,
    optional = false,
    cascade  = CascadeType.ALL
  )
  private ResponsibleDocumentInstance documentInstance;

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

    ResponsibleUploadDocumentBlob that = (ResponsibleUploadDocumentBlob) o;

    if (documentInstance.getId().equals(that.documentInstance.getId())) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.document.BasicUploadDocumentBlob#getDocInstance()
   */
  @Override public BasicDocumentInstance getDocInstance() {
    return getDocumentInstance();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for document instance.
   *
   * @return  ResponsibleDocumentInstance
   */
  public ResponsibleDocumentInstance getDocumentInstance() {
    return documentInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.document.BasicUploadDocumentBlob#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + documentInstance.hashCode();

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for document instance.
   *
   * @param  documentInstance  ResponsibleDocumentInstance
   */
  public void setDocumentInstance(ResponsibleDocumentInstance documentInstance) {
    this.documentInstance = documentInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.document.BasicUploadDocumentBlob#updateDocumentInstance(com.ozstrategy.credagility.core.domain.document.BasicDocumentInstance)
   */
  @Override public void updateDocumentInstance(BasicDocumentInstance docInstance) {
    setDocumentInstance((ResponsibleDocumentInstance) docInstance);
  }
} // end class ResponsibleUploadDocumentBlob
