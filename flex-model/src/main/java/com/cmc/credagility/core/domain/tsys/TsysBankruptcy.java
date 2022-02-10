package com.cmc.credagility.core.domain.tsys;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.responsible.Responsible;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/15/2014 17:29
 */
@Entity
@Table(name = "TsysBankruptcy")
public class TsysBankruptcy extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 8380547453801847534L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long tsysBankruptcyId;

  @Column(
    name   = "assetIndicator",
    length = 255
  )
  private String assetIndicator;

  @Column(
    name   = "bankruptcyChapterType",
    length = 25
  )
  private String bankruptcyChapterType;

  @Column(name = "bankruptcyFileDate")
  private Date bankruptcyFileDate;

  @Column(
    name   = "caseNumber",
    length = 255
  )
  private String caseNumber;

  @Column(
    name   = "courtCity",
    length = 255
  )
  private String courtCity;

  @Column(
    name   = "courtCounty",
    length = 255
  )
  private String courtCounty;

  @Column(
    name   = "courtName",
    length = 255
  )
  private String courtName;

  @Column(
    name   = "courtState",
    length = 255
  )
  private String courtState;

  @Column(
    name   = "jointIndicator",
    length = 255
  )
  private String jointIndicator;

  @Column(name = "meetingOfCreditorsDate")
  private Date meetingOfCreditorsDate;

  @Column(
    name   = "notes",
    length = 255
  )
  private String notes;

  @JoinColumn(
    name     = "responsibleId",
    nullable = false
  )
  @ManyToOne private Responsible responsible;

  @Column(
    name   = "trusteeName",
    length = 255
  )
  private String trusteeName;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * equals.
   *
   * @param   o  Object
   *
   * @return  boolean
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

    TsysBankruptcy other = (TsysBankruptcy) o;

    if (responsible == null) {
      if (other.responsible != null) {
        return false;
      }
    } else if (!responsible.equals(other.responsible)) {
      return false;
    }

    if (assetIndicator == null) {
      if (other.assetIndicator != null) {
        return false;
      }
    } else if (!assetIndicator.equals(other.assetIndicator)) {
      return false;
    }

    if (caseNumber == null) {
      if (other.caseNumber != null) {
        return false;
      }
    } else if (!caseNumber.equals(other.caseNumber)) {
      return false;
    }

    if (courtCity == null) {
      if (other.courtCity != null) {
        return false;
      }
    } else if (!courtCity.equals(other.courtCity)) {
      return false;
    }

    if (courtCounty == null) {
      if (other.courtCounty != null) {
        return false;
      }
    } else if (!courtCounty.equals(other.courtCounty)) {
      return false;
    }

    if (courtName == null) {
      if (other.courtName != null) {
        return false;
      }
    } else if (!courtName.equals(other.courtName)) {
      return false;
    }

    if (courtState == null) {
      if (other.courtState != null) {
        return false;
      }
    } else if (!courtState.equals(other.courtState)) {
      return false;
    }

    if (jointIndicator == null) {
      if (other.jointIndicator != null) {
        return false;
      }
    } else if (!jointIndicator.equals(other.jointIndicator)) {
      return false;
    }

    if (trusteeName == null) {
      if (other.trusteeName != null) {
        return false;
      }
    } else if (!trusteeName.equals(other.trusteeName)) {
      return false;
    }

    if (bankruptcyFileDate == null) {
      if (other.bankruptcyFileDate != null) {
        return false;
      }
    } else if (!bankruptcyFileDate.equals(other.bankruptcyFileDate)) {
      return false;
    }

    if (meetingOfCreditorsDate == null) {
      if (other.meetingOfCreditorsDate != null) {
        return false;
      }
    } else if (!meetingOfCreditorsDate.equals(other.meetingOfCreditorsDate)) {
      return false;
    }

    if (notes == null) {
      if (other.notes != null) {
        return false;
      }
    } else if (!notes.equals(other.notes)) {
      return false;
    }

    if (responsible == null) {
      if (other.responsible != null) {
        return false;
      }
    } else if (!responsible.equals(other.responsible)) {
      return false;
    }

    if (tsysBankruptcyId == null) {
      if (other.tsysBankruptcyId != null) {
        return false;
      }
    } else if (!tsysBankruptcyId.equals(other.tsysBankruptcyId)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for asset indicator.
   *
   * @return  String
   */
  public String getAssetIndicator() {
    return assetIndicator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bankruptcy chapter type.
   *
   * @return  String
   */
  public String getBankruptcyChapterType() {
    return bankruptcyChapterType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bankruptcy file date.
   *
   * @return  Date
   */
  public Date getBankruptcyFileDate() {
    return bankruptcyFileDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for case number.
   *
   * @return  String
   */
  public String getCaseNumber() {
    return caseNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for court city.
   *
   * @return  String
   */
  public String getCourtCity() {
    return courtCity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for court county.
   *
   * @return  String
   */
  public String getCourtCounty() {
    return courtCounty;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for court name.
   *
   * @return  String
   */
  public String getCourtName() {
    return courtName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for court state.
   *
   * @return  String
   */
  public String getCourtState() {
    return courtState;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for joint indicator.
   *
   * @return  String
   */
  public String getJointIndicator() {
    return jointIndicator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for meeting of creditors date.
   *
   * @return  Date
   */
  public Date getMeetingOfCreditorsDate() {
    return meetingOfCreditorsDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for notes.
   *
   * @return  String
   */
  public String getNotes() {
    return notes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible.
   *
   * @return  Responsible
   */
  public Responsible getResponsible() {
    return responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for trustee name.
   *
   * @return  String
   */
  public String getTrusteeName() {
    return trusteeName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for tsys bankruptcy id.
   *
   * @return  Long
   */
  public Long getTsysBankruptcyId() {
    return tsysBankruptcyId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((tsysBankruptcyId != null) ? tsysBankruptcyId.hashCode() : 0);
    result = (31 * result) + ((responsible != null) ? responsible.hashCode() : 0);
    result = (31 * result) + ((caseNumber != null) ? caseNumber.hashCode() : 0);
    result = (31 * result) + ((courtCity != null) ? courtCity.hashCode() : 0);
    result = (31 * result) + ((courtCounty != null) ? courtCounty.hashCode() : 0);
    result = (31 * result) + ((courtName != null) ? courtName.hashCode() : 0);
    result = (31 * result) + ((courtState != null) ? courtState.hashCode() : 0);
    result = (31 * result) + ((jointIndicator != null) ? jointIndicator.hashCode() : 0);
    result = (31 * result) + ((bankruptcyFileDate != null) ? bankruptcyFileDate.hashCode() : 0);
    result = (31 * result) + ((trusteeName != null) ? trusteeName.hashCode() : 0);
    result = (31 * result) + ((meetingOfCreditorsDate != null) ? meetingOfCreditorsDate.hashCode() : 0);
    result = (31 * result) + ((notes != null) ? notes.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for asset indicator.
   *
   * @param  assetIndicator  String
   */
  public void setAssetIndicator(String assetIndicator) {
    this.assetIndicator = assetIndicator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bankruptcy chapter type.
   *
   * @param  bankruptcyChapterType  String
   */
  public void setBankruptcyChapterType(String bankruptcyChapterType) {
    this.bankruptcyChapterType = bankruptcyChapterType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bankruptcy file date.
   *
   * @param  bankruptcyFileDate  Date
   */
  public void setBankruptcyFileDate(Date bankruptcyFileDate) {
    this.bankruptcyFileDate = bankruptcyFileDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for case number.
   *
   * @param  caseNumber  String
   */
  public void setCaseNumber(String caseNumber) {
    this.caseNumber = caseNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for court city.
   *
   * @param  courtCity  String
   */
  public void setCourtCity(String courtCity) {
    this.courtCity = courtCity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for court county.
   *
   * @param  courtCounty  String
   */
  public void setCourtCounty(String courtCounty) {
    this.courtCounty = courtCounty;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for court name.
   *
   * @param  courtName  String
   */
  public void setCourtName(String courtName) {
    this.courtName = courtName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for court state.
   *
   * @param  courtState  String
   */
  public void setCourtState(String courtState) {
    this.courtState = courtState;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for joint indicator.
   *
   * @param  jointIndicator  String
   */
  public void setJointIndicator(String jointIndicator) {
    this.jointIndicator = jointIndicator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for meeting of creditors date.
   *
   * @param  meetingOfCreditorsDate  Date
   */
  public void setMeetingOfCreditorsDate(Date meetingOfCreditorsDate) {
    this.meetingOfCreditorsDate = meetingOfCreditorsDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for notes.
   *
   * @param  notes  String
   */
  public void setNotes(String notes) {
    this.notes = notes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for responsible.
   *
   * @param  responsible  Responsible
   */
  public void setResponsible(Responsible responsible) {
    this.responsible = responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for trustee name.
   *
   * @param  trusteeName  String
   */
  public void setTrusteeName(String trusteeName) {
    this.trusteeName = trusteeName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for tsys bankruptcy id.
   *
   * @param  tsysBankruptcyId  Long
   */
  public void setTsysBankruptcyId(Long tsysBankruptcyId) {
    this.tsysBankruptcyId = tsysBankruptcyId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * toString.
   *
   * @return  String
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("TsysBankruptcy");
    sb.append("{responsible=").append(responsible);
    sb.append(super.toString());
    sb.append('}');

    return sb.toString();
  }
} // end class TsysBankruptcy
