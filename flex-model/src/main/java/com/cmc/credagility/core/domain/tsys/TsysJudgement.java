package com.cmc.credagility.core.domain.tsys;

import java.io.Serializable;

import java.math.BigDecimal;

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
 * @version  10/16/2014 09:22
 */
@Entity
@Table(name = "TsysJudgement")
public class TsysJudgement extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 8341652797576054665L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long tsysJudgementId;

  @Column(
    name   = "assetIndicator",
    length = 255
  )
  private String assetIndicator;

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

  @Column(name = "judgmentAmount")
  private BigDecimal judgmentAmount;

  @Column(name = "judgmentDate")
  private Date judgmentDate;

  @Column(
    name   = "judgmentStatus",
    length = 255
  )
  private String judgmentStatus;

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

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
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

    TsysJudgement other = (TsysJudgement) o;

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

    if (judgmentAmount == null) {
      if (other.judgmentAmount != null) {
        return false;
      }
    } else if (!judgmentAmount.equals(other.judgmentAmount)) {
      return false;
    }

    if (judgmentDate == null) {
      if (other.judgmentDate != null) {
        return false;
      }
    } else if (!judgmentDate.equals(other.judgmentDate)) {
      return false;
    }

    if (judgmentStatus == null) {
      if (other.judgmentStatus != null) {
        return false;
      }
    } else if (!judgmentStatus.equals(other.judgmentStatus)) {
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

    if (tsysJudgementId == null) {
      if (other.tsysJudgementId != null) {
        return false;
      }
    } else if (!tsysJudgementId.equals(other.tsysJudgementId)) {
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
   * getter method for judgment amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getJudgmentAmount() {
    return judgmentAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for judgment date.
   *
   * @return  Date
   */
  public Date getJudgmentDate() {
    return judgmentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for judgment status.
   *
   * @return  String
   */
  public String getJudgmentStatus() {
    return judgmentStatus;
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
   * getter method for tsys judgement id.
   *
   * @return  Long
   */
  public Long getTsysJudgementId() {
    return tsysJudgementId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((tsysJudgementId != null) ? tsysJudgementId.hashCode() : 0);
    result = (31 * result) + ((responsible != null) ? responsible.hashCode() : 0);
    result = (31 * result) + ((caseNumber != null) ? caseNumber.hashCode() : 0);
    result = (31 * result) + ((courtCity != null) ? courtCity.hashCode() : 0);
    result = (31 * result) + ((courtCounty != null) ? courtCounty.hashCode() : 0);
    result = (31 * result) + ((courtName != null) ? courtName.hashCode() : 0);
    result = (31 * result) + ((courtState != null) ? courtState.hashCode() : 0);
    result = (31 * result) + ((judgmentAmount != null) ? judgmentAmount.hashCode() : 0);
    result = (31 * result) + ((judgmentDate != null) ? judgmentDate.hashCode() : 0);
    result = (31 * result) + ((judgmentStatus != null) ? judgmentStatus.hashCode() : 0);
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
   * setter method for judgment amount.
   *
   * @param  judgmentAmount  BigDecimal
   */
  public void setJudgmentAmount(BigDecimal judgmentAmount) {
    this.judgmentAmount = judgmentAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for judgment date.
   *
   * @param  judgmentDate  Date
   */
  public void setJudgmentDate(Date judgmentDate) {
    this.judgmentDate = judgmentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for judgment status.
   *
   * @param  judgmentStatus  String
   */
  public void setJudgmentStatus(String judgmentStatus) {
    this.judgmentStatus = judgmentStatus;
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
   * setter method for tsys judgement id.
   *
   * @param  tsysJudgementId  Long
   */
  public void setTsysJudgementId(Long tsysJudgementId) {
    this.tsysJudgementId = tsysJudgementId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("TsysJudgement");
    sb.append("{responsible=").append(responsible);
    sb.append(super.toString());
    sb.append('}');

    return sb.toString();
  }
} // end class TsysJudgement
