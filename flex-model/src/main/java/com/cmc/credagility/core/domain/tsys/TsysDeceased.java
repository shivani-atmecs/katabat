package com.cmc.credagility.core.domain.tsys;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.responsible.Responsible;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/15/2014 17:31
 */
@Entity
@Table(name = "TsysDeceased")
public class TsysDeceased extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -7214866647882067658L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long tsysDeceasedId;

  @Column(
    name   = "assetIndicator",
    length = 255
  )
  private String assetIndicator;

  @Column(name = "bankNotifiedDate")
  private Date bankNotifiedDate;

  @Column(
    name   = "caseNumber",
    length = 255
  )
  private String caseNumber;

  @Column(name = "claimDate")
  private Date claimDate;

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
    name   = "CTF",
    length = 255
  )
  private String CTF;

  @Column(name = "deceasedDate")
  private Date deceasedDate;

  @Column(
    name   = "deceaseFlag",
    length = 255
  )
  private String deceaseFlag;

  @Column(name = "insuranceFiledDate")
  private Date insuranceFiledDate;

  @Column(
    name   = "notes",
    length = 255
  )
  private String notes;

  @JoinColumn(
    name      = "responsibleId",
    unique    = true,
    updatable = false,
    nullable  = false
  )
  @OneToOne(
    cascade       = { CascadeType.ALL, CascadeType.REMOVE },
    orphanRemoval = true
  )
  private Responsible responsible;

  //~ Methods ----------------------------------------------------------------------------------------------------------

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
   * getter method for bank notified date.
   *
   * @return  Date
   */
  public Date getBankNotifiedDate() {
    return bankNotifiedDate;
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
   * getter method for claim date.
   *
   * @return  Date
   */
  public Date getClaimDate() {
    return claimDate;
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
   * getter method for CTF.
   *
   * @return  String
   */
  public String getCTF() {
    return CTF;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for deceased date.
   *
   * @return  Date
   */
  public Date getDeceasedDate() {
    return deceasedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for decease flag.
   *
   * @return  String
   */
  public String getDeceaseFlag() {
    return deceaseFlag;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for insurance filed date.
   *
   * @return  Date
   */
  public Date getInsuranceFiledDate() {
    return insuranceFiledDate;
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
   * getter method for tsys deceased id.
   *
   * @return  Long
   */
  public Long getTsysDeceasedId() {
    return tsysDeceasedId;
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
   * setter method for bank notified date.
   *
   * @param  bankNotifiedDate  Date
   */
  public void setBankNotifiedDate(Date bankNotifiedDate) {
    this.bankNotifiedDate = bankNotifiedDate;
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
   * setter method for claim date.
   *
   * @param  claimDate  Date
   */
  public void setClaimDate(Date claimDate) {
    this.claimDate = claimDate;
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
   * setter method for CTF.
   *
   * @param  CTF  String
   */
  public void setCTF(String CTF) {
    this.CTF = CTF;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for deceased date.
   *
   * @param  deceasedDate  Date
   */
  public void setDeceasedDate(Date deceasedDate) {
    this.deceasedDate = deceasedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for decease flag.
   *
   * @param  deceaseFlag  String
   */
  public void setDeceaseFlag(String deceaseFlag) {
    this.deceaseFlag = deceaseFlag;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for insurance filed date.
   *
   * @param  insuranceFiledDate  Date
   */
  public void setInsuranceFiledDate(Date insuranceFiledDate) {
    this.insuranceFiledDate = insuranceFiledDate;
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
   * setter method for tsys deceased id.
   *
   * @param  tsysDeceasedId  Long
   */
  public void setTsysDeceasedId(Long tsysDeceasedId) {
    this.tsysDeceasedId = tsysDeceasedId;
  }
} // end class TsysDeceased
