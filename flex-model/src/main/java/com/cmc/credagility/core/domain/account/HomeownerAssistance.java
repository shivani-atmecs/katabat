package com.cmc.credagility.core.domain.account;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:dongming.liao@ozstrategy.com">Dongming Liao</a>
 * @version  10/16/2014 14:19
 */
@Entity
@Table(
  name              = "HomeownerAssistance",
  uniqueConstraints = { @UniqueConstraint(columnNames = "id") }
)
public class HomeownerAssistance extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -5579087971478503380L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** account number. */
  @JoinColumn(
    name       = "accountNum",
    insertable = true,
    updatable  = false,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Account account;

  /** best Contact Day. */
  @Column(
    name     = "bestContactDay",
    length   = 10,
    nullable = true
  )
  protected String bestContactDay;

  /** best Contact Num. */
  @Column(
    name     = "bestContactNum",
    length   = 20,
    nullable = true
  )
  protected String bestContactNum;

  /** best Contact Time. */
  @Column(
    name     = "bestContactTime",
    length   = 20,
    nullable = true
  )
  protected String bestContactTime;

  // npelleti made clientPortfolioId to 5
  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "clientPortfolioId",
    length   = 5,
    nullable = true
  )
  protected String clientPortfolioId;

  /** decline Date. */
  @Column(
    name     = "declineDate",
    nullable = true
  )
  @Temporal(TemporalType.TIMESTAMP)
  protected Date declineDate;

  /** delinquency Reason. */
  @Column(
    name     = "delinquencyReason",
    length   = 50,
    nullable = true
  )
  protected String delinquencyReason;

  /** hard Ship Duration. */
  @Column(
    name     = "hardShipDuration",
    length   = 50,
    nullable = true
  )
  protected String hardShipDuration;

  /** hardShip Reason. */
  @Column(
    name     = "hardShipReason",
    length   = 50,
    nullable = true
  )
  protected String hardShipReason;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "HOAProduct1",
    length   = 5,
    nullable = true
  )
  protected String HOAProduct1;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "HOAProduct2",
    length   = 5,
    nullable = true
  )
  protected String HOAProduct2;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "HOAProduct3",
    length   = 5,
    nullable = true
  )
  protected String HOAProduct3;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "HOAProduct4",
    length   = 5,
    nullable = true
  )
  protected String HOAProduct4;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "HOAProduct5",
    length   = 5,
    nullable = true
  )
  protected String HOAProduct5;

  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean homeForSale;

  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean householdIncome;

  /** id PK. */

  // npelleti, 07/30, USBank, Removed unique constraint
  @Column(
    name     = "id", /*unique = true,*/
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** location Code. */
  @Column(
    name     = "locationCode",
    length   = 6,
    nullable = true
  )
  protected String locationCode;

  // npelleti, 07/30, USBank added notnull constraint
  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char",
    nullable         = false
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean notInterestedHOA;

  /** phone Type. */
  @Column(
    name     = "phoneType",
    length   = 20,
    nullable = true
  )
  protected String phoneType;

  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean primaryResidence;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "reason",
    length   = 100,
    nullable = true
  )
  protected String reason;

  /** responsible Id. */
  @JoinColumn(
    name       = "responsibleId",
    insertable = true,
    updatable  = false,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Responsible responsible;

  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean salePriceSufficient;

  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean stayInHome;

  // npelleti, 07/30, USBank added notnull constraint
  /** transaction type. */
  @Column(
    name     = "transactionType",
    nullable = false,
    length   = 50
  )
  protected String transactionType;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for account.
   *
   * @return  Account
   */
  public Account getAccount() {
    return account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for best contact day.
   *
   * @return  String
   */
  public String getBestContactDay() {
    return bestContactDay;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for best contact num.
   *
   * @return  String
   */
  public String getBestContactNum() {
    return bestContactNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for best contact time.
   *
   * @return  String
   */
  public String getBestContactTime() {
    return bestContactTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client portfolio id.
   *
   * @return  String
   */
  public String getClientPortfolioId() {
    return clientPortfolioId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for decline date.
   *
   * @return  Date
   */
  public Date getDeclineDate() {
    return declineDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for delinquency reason.
   *
   * @return  String
   */
  public String getDelinquencyReason() {
    return delinquencyReason;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for hard ship duration.
   *
   * @return  String
   */
  public String getHardShipDuration() {
    return hardShipDuration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for hard ship reason.
   *
   * @return  String
   */
  public String getHardShipReason() {
    return hardShipReason;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for HOAProduct1.
   *
   * @return  String
   */
  public String getHOAProduct1() {
    return HOAProduct1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for HOAProduct2.
   *
   * @return  String
   */
  public String getHOAProduct2() {
    return HOAProduct2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for HOAProduct3.
   *
   * @return  String
   */
  public String getHOAProduct3() {
    return HOAProduct3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for HOAProduct4.
   *
   * @return  String
   */
  public String getHOAProduct4() {
    return HOAProduct4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for HOAProduct5.
   *
   * @return  String
   */
  public String getHOAProduct5() {
    return HOAProduct5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for home for sale.
   *
   * @return  Boolean
   */
  public Boolean getHomeForSale() {
    return homeForSale;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for household income.
   *
   * @return  Boolean
   */
  public Boolean getHouseholdIncome() {
    return householdIncome;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for id.
   *
   * @return  Long
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for location code.
   *
   * @return  String
   */
  public String getLocationCode() {
    return locationCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for not interested HOA.
   *
   * @return  Boolean
   */
  public Boolean getNotInterestedHOA() {
    return notInterestedHOA;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for phone type.
   *
   * @return  String
   */
  public String getPhoneType() {
    return phoneType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for primary residence.
   *
   * @return  Boolean
   */
  public Boolean getPrimaryResidence() {
    return primaryResidence;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for reason.
   *
   * @return  String
   */
  public String getReason() {
    return reason;
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
   * getter method for sale price sufficient.
   *
   * @return  Boolean
   */
  public Boolean getSalePriceSufficient() {
    return salePriceSufficient;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for stay in home.
   *
   * @return  Boolean
   */
  public Boolean getStayInHome() {
    return stayInHome;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for transaction type.
   *
   * @return  String
   */
  public String getTransactionType() {
    return transactionType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account.
   *
   * @param  account  Account
   */
  public void setAccount(Account account) {
    this.account = account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for best contact day.
   *
   * @param  bestContactDay  String
   */
  public void setBestContactDay(String bestContactDay) {
    this.bestContactDay = bestContactDay;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for best contact num.
   *
   * @param  bestContactNum  String
   */
  public void setBestContactNum(String bestContactNum) {
    this.bestContactNum = bestContactNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for best contact time.
   *
   * @param  bestContactTime  String
   */
  public void setBestContactTime(String bestContactTime) {
    this.bestContactTime = bestContactTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client portfolio id.
   *
   * @param  clientPortfolioId  String
   */
  public void setClientPortfolioId(String clientPortfolioId) {
    this.clientPortfolioId = clientPortfolioId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for decline date.
   *
   * @param  declineDate  Date
   */
  public void setDeclineDate(Date declineDate) {
    this.declineDate = declineDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for delinquency reason.
   *
   * @param  delinquencyReason  String
   */
  public void setDelinquencyReason(String delinquencyReason) {
    this.delinquencyReason = delinquencyReason;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for hard ship duration.
   *
   * @param  hardShipDuration  String
   */
  public void setHardShipDuration(String hardShipDuration) {
    this.hardShipDuration = hardShipDuration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for hard ship reason.
   *
   * @param  hardShipReason  String
   */
  public void setHardShipReason(String hardShipReason) {
    this.hardShipReason = hardShipReason;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for HOAProduct1.
   *
   * @param  HOAProduct1  String
   */
  public void setHOAProduct1(String HOAProduct1) {
    this.HOAProduct1 = HOAProduct1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for HOAProduct2.
   *
   * @param  HOAProduct2  String
   */
  public void setHOAProduct2(String HOAProduct2) {
    this.HOAProduct2 = HOAProduct2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for HOAProduct3.
   *
   * @param  HOAProduct3  String
   */
  public void setHOAProduct3(String HOAProduct3) {
    this.HOAProduct3 = HOAProduct3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for HOAProduct4.
   *
   * @param  HOAProduct4  String
   */
  public void setHOAProduct4(String HOAProduct4) {
    this.HOAProduct4 = HOAProduct4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for HOAProduct5.
   *
   * @param  HOAProduct5  String
   */
  public void setHOAProduct5(String HOAProduct5) {
    this.HOAProduct5 = HOAProduct5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for home for sale.
   *
   * @param  homeForSale  Boolean
   */
  public void setHomeForSale(Boolean homeForSale) {
    this.homeForSale = homeForSale;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for household income.
   *
   * @param  householdIncome  Boolean
   */
  public void setHouseholdIncome(Boolean householdIncome) {
    this.householdIncome = householdIncome;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for id.
   *
   * @param  id  Long
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for location code.
   *
   * @param  locationCode  String
   */
  public void setLocationCode(String locationCode) {
    this.locationCode = locationCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for not interested HOA.
   *
   * @param  notInterestedHOA  Boolean
   */
  public void setNotInterestedHOA(Boolean notInterestedHOA) {
    this.notInterestedHOA = notInterestedHOA;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for phone type.
   *
   * @param  phoneType  String
   */
  public void setPhoneType(String phoneType) {
    this.phoneType = phoneType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for primary residence.
   *
   * @param  primaryResidence  Boolean
   */
  public void setPrimaryResidence(Boolean primaryResidence) {
    this.primaryResidence = primaryResidence;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for reason.
   *
   * @param  reason  String
   */
  public void setReason(String reason) {
    this.reason = reason;
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
   * setter method for sale price sufficient.
   *
   * @param  salePriceSufficient  Boolean
   */
  public void setSalePriceSufficient(Boolean salePriceSufficient) {
    this.salePriceSufficient = salePriceSufficient;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for stay in home.
   *
   * @param  stayInHome  Boolean
   */
  public void setStayInHome(Boolean stayInHome) {
    this.stayInHome = stayInHome;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for transaction type.
   *
   * @param  transactionType  String
   */
  public void setTransactionType(String transactionType) {
    this.transactionType = transactionType;
  }
} // end class HomeownerAssistance
