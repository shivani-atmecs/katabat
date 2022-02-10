package com.ozstrategy.credagility.core.domain.document.agent;

import com.ozstrategy.credagility.core.domain.document.BasicDocumentInstance;
import com.ozstrategy.credagility.core.domain.document.BasicUploadDocumentBlob;

import javax.persistence.*;
import java.io.Serializable;


/**
 * This class is used to store AgentUploadDocumentBlob information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/16/2014 14:56
 */
@Entity
@Table(name = "AgentUploadDocumentBlob")
public class AgentUploadDocumentBlob extends BasicUploadDocumentBlob implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 1477239501087119169L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @JoinColumn(name = "documentInstanceId")
  @ManyToOne(
    fetch    = FetchType.LAZY,
    optional = false,
    cascade  = CascadeType.ALL
  )
  private AgentDocumentInstance documentInstance;

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

    if (!super.equals(o)) {
      return false;
    }

    AgentUploadDocumentBlob that = (AgentUploadDocumentBlob) o;

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
   * getter method for document instance.
   *
   * @return  AgentDocumentInstance
   */
  public AgentDocumentInstance getDocumentInstance() {
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
   * setter method for document instance.
   *
   * @param  documentInstance  AgentDocumentInstance
   */
  public void setDocumentInstance(AgentDocumentInstance documentInstance) {
    this.documentInstance = documentInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.document.BasicUploadDocumentBlob#updateDocumentInstance(com.ozstrategy.credagility.core.domain.document.BasicDocumentInstance)
   */
  @Override public void updateDocumentInstance(BasicDocumentInstance docInstance) {
    setDocumentInstance((AgentDocumentInstance) docInstance);
  }
} // end class AgentUploadDocumentBlob
