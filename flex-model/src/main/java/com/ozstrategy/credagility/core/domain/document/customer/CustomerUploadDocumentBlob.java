package com.ozstrategy.credagility.core.domain.document.customer;

import com.ozstrategy.credagility.core.domain.document.BasicDocumentInstance;
import com.ozstrategy.credagility.core.domain.document.BasicUploadDocumentBlob;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "CustomerUploadDocumentBlob")
public class CustomerUploadDocumentBlob extends BasicUploadDocumentBlob implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------


  //~ Instance fields --------------------------------------------------------------------------------------------------

  @Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE })
  @JoinColumn(name = "documentInstanceId")
  @ManyToOne(
    fetch    = FetchType.LAZY,
    optional = false
  )
  private CustomerDocumentInstance documentInstance;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.document.BasicUploadDocumentBlob#equals(Object)
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

    CustomerUploadDocumentBlob that = (CustomerUploadDocumentBlob) o;

    if ((documentInstance != null) ? (!documentInstance.equals(that.documentInstance))
                                   : (that.documentInstance != null)) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.document.BasicUploadDocumentBlob#getDocInstance()
   */
  @Override public BasicDocumentInstance getDocInstance() {
    return getDocumentInstance();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public CustomerDocumentInstance getDocumentInstance() {
    return documentInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.document.BasicUploadDocumentBlob#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((documentInstance != null) ? documentInstance.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  documentInstance  DOCUMENT ME!
   */
  public void setDocumentInstance(CustomerDocumentInstance documentInstance) {
    this.documentInstance = documentInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.document.BasicUploadDocumentBlob#updateDocumentInstance(com.ozstrategy.credagility.core.domain.document.BasicDocumentInstance)
   */
  @Override public void updateDocumentInstance(BasicDocumentInstance docInstance) {
    setDocumentInstance((CustomerDocumentInstance) docInstance);
  }
} // end class BCIUploadDocumentBlob
