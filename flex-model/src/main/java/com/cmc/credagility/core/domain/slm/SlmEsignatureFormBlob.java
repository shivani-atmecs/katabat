package com.cmc.credagility.core.domain.slm;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/15/2014 14:33
 */
@Entity
@Table(name = "SlmEsignatureFormBlob")
public class SlmEsignatureFormBlob extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 778846939221853744L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "slmEsignatureFormId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @OneToOne(cascade = { CascadeType.ALL })
  protected SlmEsignatureForm slmEsignatureForm = null;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "slmEsignatureFormBlobId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long slmEsignatureFormBlobId;

  /** TODO: DOCUMENT ME! */
  @Basic(fetch = FetchType.LAZY)
  @Column(
    name             = "submittedForm",
    nullable         = false,
    columnDefinition = "LONGBLOB"
  )
  @Lob protected byte[] submittedForm;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (obj == null) {
      return false;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    final SlmEsignatureFormBlob other = (SlmEsignatureFormBlob) obj;

    if (getCreateDate() == null) {
      if (other.getCreateDate() != null) {
        return false;
      }
    } else if (!getCreateDate().equals(other.getCreateDate())) {
      return false;
    }

    if (getLastUpdateDate() == null) {
      if (other.getLastUpdateDate() != null) {
        return false;
      }
    } else if (!getLastUpdateDate().equals(other.getLastUpdateDate())) {
      return false;
    }

    if (getSubmittedForm() == null) {
      if (other.getSubmittedForm() != null) {
        return false;
      }
    } else if (!getSubmittedForm().equals(other.getSubmittedForm())) {
      return false;
    }

    if (getSlmEsignatureForm() == null) {
      if (other.getSlmEsignatureForm() != null) {
        return false;
      }
    } else if (!getSlmEsignatureForm().equals(other.getSlmEsignatureForm())) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for slm esignature form.
   *
   * @return  SlmEsignatureForm
   */
  public SlmEsignatureForm getSlmEsignatureForm() {
    return slmEsignatureForm;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for slm esignature form blob id.
   *
   * @return  Long
   */
  public Long getSlmEsignatureFormBlobId() {
    return slmEsignatureFormBlobId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for submitted form.
   *
   * @return  byte[]
   */
  public byte[] getSubmittedForm() {
    return submittedForm;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int       result = 1;
    final int prime  = 31;

    result = (prime * result)
      + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());

    result = (prime * result)
      + ((getLastUpdateDate() == null) ? 0 : getLastUpdateDate().hashCode());

    result = (prime * result)
      + ((getSubmittedForm() == null) ? 0 : getSubmittedForm().hashCode());

    return result;
  } // end method hashCode

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for slm esignature form.
   *
   * @param  slmEsignatureForm  SlmEsignatureForm
   */
  public void setSlmEsignatureForm(SlmEsignatureForm slmEsignatureForm) {
    this.slmEsignatureForm = slmEsignatureForm;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for slm esignature form blob id.
   *
   * @param  slmEsignatureFormBlobId  Long
   */
  public void setSlmEsignatureFormBlobId(Long slmEsignatureFormBlobId) {
    this.slmEsignatureFormBlobId = slmEsignatureFormBlobId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for submitted form.
   *
   * @param  submittedForm  byte[]
   */
  public void setSubmittedForm(byte[] submittedForm) {
    this.submittedForm = submittedForm;
  }
} // end class SlmEsignatureFormBlob
