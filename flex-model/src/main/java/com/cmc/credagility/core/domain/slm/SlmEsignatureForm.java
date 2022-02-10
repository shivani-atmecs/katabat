package com.cmc.credagility.core.domain.slm;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.responsible.ResponsibleDetail;
import com.cmc.credagility.core.domain.type.FormStatus;
import com.cmc.credagility.core.domain.type.FormType;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/15/2014 14:24
 */
@Entity
@Table(name = "SlmEsignatureForm")
public class SlmEsignatureForm extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -7969878792796662856L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(name = "exportedDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date exportedDate;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "forbearanceMonths",
    nullable = false
  )
  protected Integer forbearanceMonths;

  /** TODO: DOCUMENT ME! */
  @OneToOne(
    fetch         = FetchType.LAZY,
    mappedBy      = "slmEsignatureForm",
    cascade       = { CascadeType.ALL, CascadeType.REMOVE },
    orphanRemoval = true
  )
  protected SlmEsignatureFormBlob slmEsignatureFormBlob = null;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "slmEsignatureFormId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long slmEsignatureFormId;

  /** TODO: DOCUMENT ME! */
  @Column(name = "submittedDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date submittedDate;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "submittedFileName",
    length = 100
  )
  protected String submittedFileName;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "submittedFirstName",
    length = 50
  )
  protected String submittedFirstName;

  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "formType",
    length    = 50,
    nullable  = false,
    updatable = false
  )
  @Enumerated(value = EnumType.STRING)
  protected FormType submittedFormType;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "submittedLastName",
    length = 50
  )
  protected String submittedLastName;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "submittedMiddleName",
    length = 50
  )
  protected String submittedMiddleName;

  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "submittedStatus",
    length    = 50,
    nullable  = false,
    updatable = true
  )
  @Enumerated(value = EnumType.STRING)
  protected FormStatus submittedStatus;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "submittedSuffix",
    length = 5
  )
  protected String submittedSuffix;

  @JoinColumn(
    name     = "responsibleDetailId",
    unique   = false,
    nullable = false
  )
  @ManyToOne(cascade = { CascadeType.ALL, CascadeType.REMOVE })
  private ResponsibleDetail responsibleDetail;

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

    final SlmEsignatureForm other = (SlmEsignatureForm) obj;

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

    if (getSubmittedFormType() == null) {
      if (other.getSubmittedFormType() != null) {
        return false;
      }
    } else if (!getSubmittedFormType().equals(
            other.getSubmittedFormType())) {
      return false;
    }

    if (getSubmittedFileName() == null) {
      if (other.getSubmittedFileName() != null) {
        return false;
      }
    } else if (!getSubmittedFileName().equals(
            getSubmittedFileName())) {
      return false;
    }

    if (getSubmittedFirstName() == null) {
      if (other.getSubmittedFirstName() != null) {
        return false;
      }
    } else if (!getSubmittedFirstName().equals(
            other.getSubmittedFirstName())) {
      return false;
    }

    if (getSubmittedMiddleName() == null) {
      if (other.getSubmittedMiddleName() != null) {
        return false;
      }
    } else if (!getSubmittedMiddleName().equals(
            other.getSubmittedMiddleName())) {
      return false;
    }

    if (getSubmittedLastName() == null) {
      if (other.getSubmittedLastName() != null) {
        return false;
      }
    } else if (!getSubmittedLastName().equals(
            other.getSubmittedLastName())) {
      return false;
    }

    if (getSubmittedSuffix() == null) {
      if (other.getSubmittedSuffix() != null) {
        return false;
      }
    } else if (!getSubmittedSuffix().equals(
            other.getSubmittedSuffix())) {
      return false;
    }

    if (getSubmittedStatus() == null) {
      if (other.getSubmittedStatus() != null) {
        return false;
      }
    } else if (!getSubmittedStatus().equals(
            other.getSubmittedStatus())) {
      return false;
    }

    if (getSubmittedDate() == null) {
      if (other.getSubmittedDate() != null) {
        return false;
      }
    } else if (!getSubmittedDate().equals(
            other.getSubmittedDate())) {
      return false;
    }

    if (getExportedDate() == null) {
      if (other.getExportedDate() != null) {
        return false;
      }
    } else if (!getExportedDate().equals(
            other.getExportedDate())) {
      return false;
    }

    if (getResponsibleDetail().getResponsibleDetailId() == null) {
      if (other.getResponsibleDetail().getResponsibleDetailId() != null) {
        return false;
      }
    } else if (
      !getResponsibleDetail().getResponsibleDetailId().equals(
            other.getResponsibleDetail().getResponsibleDetailId())) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for exported date.
   *
   * @return  Date
   */
  public Date getExportedDate() {
    return exportedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for forbearance months.
   *
   * @return  Integer
   */
  public Integer getForbearanceMonths() {
    return forbearanceMonths;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible detail.
   *
   * @return  ResponsibleDetail
   */
  public ResponsibleDetail getResponsibleDetail() {
    return responsibleDetail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for slm esignature form blob.
   *
   * @return  SlmEsignatureFormBlob
   */
  public SlmEsignatureFormBlob getSlmEsignatureFormBlob() {
    return slmEsignatureFormBlob;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for slm esignature form id.
   *
   * @return  Long
   */
  public Long getSlmEsignatureFormId() {
    return slmEsignatureFormId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for submitted date.
   *
   * @return  Date
   */
  public Date getSubmittedDate() {
    return submittedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for submitted file name.
   *
   * @return  String
   */
  public String getSubmittedFileName() {
    return submittedFileName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for submitted first name.
   *
   * @return  String
   */
  public String getSubmittedFirstName() {
    return submittedFirstName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for submitted form type.
   *
   * @return  FormType
   */
  public FormType getSubmittedFormType() {
    return submittedFormType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for submitted last name.
   *
   * @return  String
   */
  public String getSubmittedLastName() {
    return submittedLastName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for submitted middle name.
   *
   * @return  String
   */
  public String getSubmittedMiddleName() {
    return submittedMiddleName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for submitted status.
   *
   * @return  FormStatus
   */
  public FormStatus getSubmittedStatus() {
    return submittedStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for submitted suffix.
   *
   * @return  String
   */
  public String getSubmittedSuffix() {
    return submittedSuffix;
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
      + ((getSubmittedFileName() == null) ? 0 : getSubmittedFileName().hashCode());

    result = (prime * result)
      + ((getSubmittedFormType() == null) ? 0 : getSubmittedFormType().hashCode());

    result = (prime * result)
      + ((getSubmittedFirstName() == null) ? 0 : getSubmittedFirstName().hashCode());

    result = (prime * result)
      + ((getSubmittedMiddleName() == null) ? 0 : getSubmittedMiddleName().hashCode());

    result = (prime * result)
      + ((getSubmittedLastName() == null) ? 0 : getSubmittedLastName().hashCode());

    result = (prime * result)
      + ((getSubmittedSuffix() == null) ? 0 : getSubmittedSuffix().hashCode());

    result = (prime * result)
      + ((getSubmittedStatus() == null) ? 0 : getSubmittedStatus().hashCode());

    result = (prime * result)
      + ((getExportedDate() == null) ? 0 : getExportedDate().hashCode());

    result = (prime * result)
      + ((getResponsibleDetail().getResponsibleDetailId() == null)
        ? 0 : getResponsibleDetail().getResponsibleDetailId().hashCode());

    return result;
  } // end method hashCode

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for exported date.
   *
   * @param  exportedDate  Date
   */
  public void setExportedDate(Date exportedDate) {
    this.exportedDate = exportedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for forbearance months.
   *
   * @param  forbearanceMonths  Integer
   */
  public void setForbearanceMonths(Integer forbearanceMonths) {
    this.forbearanceMonths = forbearanceMonths;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for responsible detail.
   *
   * @param  responsibleDetail  ResponsibleDetail
   */
  public void setResponsibleDetail(ResponsibleDetail responsibleDetail) {
    this.responsibleDetail = responsibleDetail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for slm esignature form blob.
   *
   * @param  slmEsignatureFormBlob  SlmEsignatureFormBlob
   */
  public void setSlmEsignatureFormBlob(SlmEsignatureFormBlob slmEsignatureFormBlob) {
    this.slmEsignatureFormBlob = slmEsignatureFormBlob;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for slm esignature form id.
   *
   * @param  slmEsignatureFormId  Long
   */
  public void setSlmEsignatureFormId(Long slmEsignatureFormId) {
    this.slmEsignatureFormId = slmEsignatureFormId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for submitted date.
   *
   * @param  submittedDate  Date
   */
  public void setSubmittedDate(Date submittedDate) {
    this.submittedDate = submittedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for submitted file name.
   *
   * @param  submittedFileName  String
   */
  public void setSubmittedFileName(String submittedFileName) {
    this.submittedFileName = submittedFileName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for submitted first name.
   *
   * @param  submittedFirstName  String
   */
  public void setSubmittedFirstName(String submittedFirstName) {
    this.submittedFirstName = submittedFirstName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for submitted form type.
   *
   * @param  submittedFormType  FormType
   */
  public void setSubmittedFormType(FormType submittedFormType) {
    this.submittedFormType = submittedFormType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for submitted last name.
   *
   * @param  submittedLastName  String
   */
  public void setSubmittedLastName(String submittedLastName) {
    this.submittedLastName = submittedLastName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for submitted middle name.
   *
   * @param  submittedMiddleName  String
   */
  public void setSubmittedMiddleName(String submittedMiddleName) {
    this.submittedMiddleName = submittedMiddleName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for submitted status.
   *
   * @param  submittedStatus  FormStatus
   */
  public void setSubmittedStatus(FormStatus submittedStatus) {
    this.submittedStatus = submittedStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for submitted suffix.
   *
   * @param  submittedSuffix  String
   */
  public void setSubmittedSuffix(String submittedSuffix) {
    this.submittedSuffix = submittedSuffix;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#toString()
   */
  @Override public String toString() {
    StringBuffer retStr = new StringBuffer();
    retStr.append("SlmEsignatureFormId: " + getSlmEsignatureFormId() + "\n");
    retStr.append("Create Date: " + getCreateDate() + "\n");
    retStr.append("Last Update Date: " + getLastUpdateDate() + "\n");
    retStr.append("Submitted File Name: " + getSubmittedFileName() + "\n");
    retStr.append("Submitted Form Type: " + getSubmittedFormType() + "\n");
    retStr.append("Submitted First Name: " + getSubmittedFirstName() + "\n");
    retStr.append("Submitted Middle Name: " + getSubmittedMiddleName() + "\n");
    retStr.append("Submitted Last Name: " + getSubmittedLastName() + "\n");
    retStr.append("Submitted Suffix: " + getSubmittedSuffix() + "\n");
    retStr.append("Submitted Status: " + getSubmittedStatus() + "\n");
    retStr.append("Exported Date: " + getExportedDate() + "\n");
    retStr.append("Responsible Detail: " + getResponsibleDetail() + "\n");

    return retStr.toString();
  }
} // end class SlmEsignatureForm
