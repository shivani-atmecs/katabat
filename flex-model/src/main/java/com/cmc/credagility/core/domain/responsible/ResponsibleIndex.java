package com.cmc.credagility.core.domain.responsible;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.address.Timezone;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.customer.Customer;
import com.cmc.credagility.core.domain.portfolio.PortfolioCallChannelPrerequisite;
import com.cmc.credagility.core.domain.portfolio.PortfolioJurisdictionCallTime;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * This class is used to store ResponsibleIndex information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/17/2014 14:33
 */
@Entity
@Table(
  indexes = {
    @Index(
      name = "deletedIndex",
      columnList = "deleted"
    ),
    @Index(
      name = "doNotCallIndex",
      columnList = "doNotCall"
    ),
    @Index(
      name = "responsibleUniqueIdIndex",
      columnList = "responsibleUniqueId"
    ),
    @Index(
      name = "customerLinkUpdateDateIndex",
      columnList = "customerLinkUpdateDate"
    ),
    @Index(
      name = "earliestEligibleCallDateIndex",
      columnList = "earliestEligibleCallDate"
    ),
    @Index(
      name = "endCallTimeIndex",
      columnList = "endCallTime"
    ),
    @Index(
      name = "eSignProvidedIndex",
      columnList = "eSignProvided"
    ),
    @Index(
      name = "ssnHashIndex",
      columnList = "ssnHash"
    ),
    @Index(
      name = "startCallTimeIndex",
      columnList = "startCallTime"
    ),
    @Index(
      name = "noCallablePhoneIndex",
      columnList = "noCallablePhone"
    ), @Index(
      name = "callTimeCrossDayIndex",
      columnList = "callTimeCrossDay"
    ),
    @Index(
      name = "responsibleDeleteDateIndex",
      columnList = "responsibleDeleteDate"
    ),
    @Index(
      name = "nextEffectiveDateIndex",
      columnList = "nextEffectiveDate"
    ),
    @Index(
      name = "responsibleIdentificationNumberHashIndex",
      columnList = "responsibleIdentificationNumberHash"
    )
  }
)
public class ResponsibleIndex extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -4246489995185163044L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "customerInfoId",
    nullable = true
  )
  @ManyToOne protected Customer customer;

  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean deleted;


  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean doNotCall = Boolean.FALSE;

  /** Responsible Index id PK. */
  @Column
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long         id;

  /** TODO: DOCUMENT ME! */
  @Column(name = "lastClickToDialAttemptDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date lastClickToDialAttemptDate;

  /** TODO: DOCUMENT ME! */
  @Column(name = "lastDialerAttemptDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date lastDialerAttemptDate;

  /** DOCUMENT ME! */
  @Column(name = "lastEmailAttemptDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date lastEmailAttemptDate;

  /** DOCUMENT ME! */
  @Column(name = "lastLetterAttemptDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date lastLetterAttemptDate;

  /** DOCUMENT ME! */
  @Column(name = "lastOutboundIvrAttemptDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date lastOutboundIvrAttemptDate;

  /** DOCUMENT ME! */
  @Column(name = "lastSmsAttemptDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date lastSmsAttemptDate;

  /** TODO: DOCUMENT ME! */
  @Column(name = "nextEffectiveDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date nextEffectiveDate;


  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean noCallablePhone = Boolean.FALSE;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "responsibleType",
    length   = 50,
    nullable = true
  )
  protected String responsibleType;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "responsibleUniqueId",
    length = 255
  )
  protected String responsibleUniqueId;

  @JoinColumn(
    name       = "appliedEndCallTimeZoneId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private Timezone appliedEndCallTimeZone;

  @JoinColumn(
    name       = "appliedStartCallTimeZoneId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private Timezone appliedStartCallTimeZone;

  @JoinColumn(
    name       = "endCallTimeId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private PortfolioJurisdictionCallTime applyEndCallTime;

  @JoinColumn(
    name       = "startCallTimeId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private PortfolioJurisdictionCallTime applyStartCallTime;

  @Column(
    name             = "callTimeCrossDay",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean callTimeCrossDay;

  @Column(name = "customerLinkUpdateDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date customerLinkUpdateDate;

  @Column(name = "earliestEligibleCallDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date earliestEligibleCallDate;

  @Column(name = "endCallTime")
  @Temporal(TemporalType.TIME)
  private Date endCallTime;


  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean eSignProvided = Boolean.FALSE;

  @Column(
    length   = 10,
    nullable = true
  )
  private String lastLoginMethod;

  @JoinColumn(
    name       = "prerequisiteId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private PortfolioCallChannelPrerequisite prerequisite;

  /** Responsible link responsibleId. */
  @JoinColumn(
    name     = "responsibleId",
    unique   = true,
    nullable = false
  )
  @ManyToOne private Responsible responsible;

  @Column(name = "responsibleDeleteDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date responsibleDeleteDate;

  @Column(
    length   = 100,
    nullable = true
  )
  private String responsibleDeleteReason;

  @Column(
    length   = 48,
    nullable = false
  )
  private String ssnHash;

  @Column(name = "startCallTime")
  @Temporal(TemporalType.TIME)
  private Date startCallTime;

  @Column(
    name   = "strategyID",
    length = 255
  )
  private String strategyID;

  @Column(
          length   = 48,
          nullable = true,
          name="responsibleIdentificationNumberHash"
  )
  private String responsibleIdentificationNumberHash;


  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
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

    ResponsibleIndex that = (ResponsibleIndex) o;

    if ((responsible != null) ? (!responsible.equals(that.responsible)) : (that.responsible != null)) {
      return false;
    }

    if ((ssnHash != null) ? (!ssnHash.equals(that.ssnHash)) : (that.ssnHash != null)) {
      return false;
    }

    if ((eSignProvided != null) ? (!eSignProvided.equals(that.eSignProvided)) : (that.eSignProvided != null)) {
      return false;
    }

    if ((responsibleUniqueId != null) ? (!responsibleUniqueId.equals(that.responsibleUniqueId))
                                      : (that.responsibleUniqueId != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for applied end call time zone.
   *
   * @return  Timezone
   */
  public Timezone getAppliedEndCallTimeZone() {
    return appliedEndCallTimeZone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for applied start call time zone.
   *
   * @return  Timezone
   */
  public Timezone getAppliedStartCallTimeZone() {
    return appliedStartCallTimeZone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for apply end call time.
   *
   * @return  PortfolioJurisdictionCallTime
   */
  public PortfolioJurisdictionCallTime getApplyEndCallTime() {
    return applyEndCallTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for apply start call time.
   *
   * @return  PortfolioJurisdictionCallTime
   */
  public PortfolioJurisdictionCallTime getApplyStartCallTime() {
    return applyStartCallTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for call time cross day.
   *
   * @return  Boolean
   */
  public Boolean getCallTimeCrossDay() {
    return callTimeCrossDay;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for customer.
   *
   * @return  Customer
   */
  public Customer getCustomer() {
    return customer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for customer link update date.
   *
   * @return  Date
   */
  public Date getCustomerLinkUpdateDate() {
    return customerLinkUpdateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for deleted.
   *
   * @return  Boolean
   */
  public Boolean getDeleted() {
    if (deleted == null) {
      return Boolean.FALSE;
    }

    return deleted;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for do not call.
   *
   * @return  Boolean
   */
  public Boolean getDoNotCall() {
    return doNotCall;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for earliest eligible call date.
   *
   * @return  Date
   */
  public Date getEarliestEligibleCallDate() {
    return earliestEligibleCallDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for end call time.
   *
   * @return  Date
   */
  public Date getEndCallTime() {
    return endCallTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * geteSignProvided.
   *
   * @return  Boolean
   */
  public Boolean geteSignProvided() {
    return eSignProvided;
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
   * getter method for last click to dial attempt date.
   *
   * @return  Date
   */
  public Date getLastClickToDialAttemptDate() {
    return lastClickToDialAttemptDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last dialer attempt date.
   *
   * @return  Date
   */
  public Date getLastDialerAttemptDate() {
    return lastDialerAttemptDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last email attempt date.
   *
   * @return  Date
   */
  public Date getLastEmailAttemptDate() {
    return lastEmailAttemptDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last letter attempt date.
   *
   * @return  Date
   */
  public Date getLastLetterAttemptDate() {
    return lastLetterAttemptDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last login method.
   *
   * @return  String
   */
  public String getLastLoginMethod() {
    return lastLoginMethod;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last outbound ivr attempt date.
   *
   * @return  Date
   */
  public Date getLastOutboundIvrAttemptDate() {
    return lastOutboundIvrAttemptDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last sms attempt date.
   *
   * @return  Date
   */
  public Date getLastSmsAttemptDate() {
    return lastSmsAttemptDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for next effective date.
   *
   * @return  Date
   */
  public Date getNextEffectiveDate() {
    return nextEffectiveDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for no callable phone.
   *
   * @return  Boolean
   */
  public Boolean getNoCallablePhone() {
    return noCallablePhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for prerequisite.
   *
   * @return  PortfolioCallChannelPrerequisite
   */
  public PortfolioCallChannelPrerequisite getPrerequisite() {
    return prerequisite;
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
   * getter method for responsible delete date.
   *
   * @return  Date
   */
  public Date getResponsibleDeleteDate() {
    return responsibleDeleteDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible delete reason.
   *
   * @return  String
   */
  public String getResponsibleDeleteReason() {
    return responsibleDeleteReason;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible type.
   *
   * @return  String
   */
  public String getResponsibleType() {
    return responsibleType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible unique id.
   *
   * @return  String
   */
  public String getResponsibleUniqueId() {
    return responsibleUniqueId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ssn hash.
   *
   * @return  String
   */
  public String getSsnHash() {
    return ssnHash;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for start call time.
   *
   * @return  Date
   */
  public Date getStartCallTime() {
    return startCallTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((responsible != null) ? responsible.hashCode() : 0);
    result = (31 * result) + ((ssnHash != null) ? ssnHash.hashCode() : 0);
    result = (31 * result) + ((eSignProvided != null) ? eSignProvided.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for applied end call time zone.
   *
   * @param  appliedEndCallTimeZone  Timezone
   */
  public void setAppliedEndCallTimeZone(Timezone appliedEndCallTimeZone) {
    this.appliedEndCallTimeZone = appliedEndCallTimeZone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for applied start call time zone.
   *
   * @param  appliedStartCallTimeZone  Timezone
   */
  public void setAppliedStartCallTimeZone(Timezone appliedStartCallTimeZone) {
    this.appliedStartCallTimeZone = appliedStartCallTimeZone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for apply end call time.
   *
   * @param  applyEndCallTime  PortfolioJurisdictionCallTime
   */
  public void setApplyEndCallTime(PortfolioJurisdictionCallTime applyEndCallTime) {
    this.applyEndCallTime = applyEndCallTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for apply start call time.
   *
   * @param  applyStartCallTime  PortfolioJurisdictionCallTime
   */
  public void setApplyStartCallTime(PortfolioJurisdictionCallTime applyStartCallTime) {
    this.applyStartCallTime = applyStartCallTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for call time cross day.
   *
   * @param  callTimeCrossDay  Boolean
   */
  public void setCallTimeCrossDay(Boolean callTimeCrossDay) {
    this.callTimeCrossDay = callTimeCrossDay;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for customer.
   *
   * @param  customer  Customer
   */
  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for customer link update date.
   *
   * @param  customerLinkUpdateDate  Date
   */
  public void setCustomerLinkUpdateDate(Date customerLinkUpdateDate) {
    this.customerLinkUpdateDate = customerLinkUpdateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for deleted.
   *
   * @param  deleted  Boolean
   */
  public void setDeleted(Boolean deleted) {
    this.deleted = deleted;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for do not call.
   *
   * @param  doNotCall  Boolean
   */
  public void setDoNotCall(Boolean doNotCall) {
    this.doNotCall = doNotCall;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for earliest eligible call date.
   *
   * @param  earliestEligibleCallDate  Date
   */
  public void setEarliestEligibleCallDate(Date earliestEligibleCallDate) {
    this.earliestEligibleCallDate = earliestEligibleCallDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for end call time.
   *
   * @param  endCallTime  Date
   */
  public void setEndCallTime(Date endCallTime) {
    this.endCallTime = endCallTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * seteSignProvided.
   *
   * @param  eSignProvided  Boolean
   */
  public void seteSignProvided(Boolean eSignProvided) {
    this.eSignProvided = eSignProvided;
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
   * setter method for last click to dial attempt date.
   *
   * @param  lastClickToDialAttemptDate  Date
   */
  public void setLastClickToDialAttemptDate(Date lastClickToDialAttemptDate) {
    this.lastClickToDialAttemptDate = lastClickToDialAttemptDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last dialer attempt date.
   *
   * @param  lastDialerAttemptDate  Date
   */
  public void setLastDialerAttemptDate(Date lastDialerAttemptDate) {
    this.lastDialerAttemptDate = lastDialerAttemptDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last email attempt date.
   *
   * @param  lastEmailAttemptDate  Date
   */
  public void setLastEmailAttemptDate(Date lastEmailAttemptDate) {
    this.lastEmailAttemptDate = lastEmailAttemptDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last letter attempt date.
   *
   * @param  lastLetterAttemptDate  Date
   */
  public void setLastLetterAttemptDate(Date lastLetterAttemptDate) {
    this.lastLetterAttemptDate = lastLetterAttemptDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last login method.
   *
   * @param  lastLoginMethod  String
   */
  public void setLastLoginMethod(String lastLoginMethod) {
    this.lastLoginMethod = lastLoginMethod;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last outbound ivr attempt date.
   *
   * @param  lastOutboundIvrAttemptDate  Date
   */
  public void setLastOutboundIvrAttemptDate(Date lastOutboundIvrAttemptDate) {
    this.lastOutboundIvrAttemptDate = lastOutboundIvrAttemptDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last sms attempt date.
   *
   * @param  lastSmsAttemptDate  Date
   */
  public void setLastSmsAttemptDate(Date lastSmsAttemptDate) {
    this.lastSmsAttemptDate = lastSmsAttemptDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for next effective date.
   *
   * @param  nextEffectiveDate  Date
   */
  public void setNextEffectiveDate(Date nextEffectiveDate) {
    this.nextEffectiveDate = nextEffectiveDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for no callable phone.
   *
   * @param  noCallablePhone  Boolean
   */
  public void setNoCallablePhone(Boolean noCallablePhone) {
    this.noCallablePhone = noCallablePhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for prerequisite.
   *
   * @param  prerequisite  PortfolioCallChannelPrerequisite
   */
  public void setPrerequisite(PortfolioCallChannelPrerequisite prerequisite) {
    this.prerequisite = prerequisite;
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
   * setter method for responsible delete date.
   *
   * @param  responsibleDeleteDate  Date
   */
  public void setResponsibleDeleteDate(Date responsibleDeleteDate) {
    this.responsibleDeleteDate = responsibleDeleteDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for responsible delete reason.
   *
   * @param  responsibleDeleteReason  String
   */
  public void setResponsibleDeleteReason(String responsibleDeleteReason) {
    this.responsibleDeleteReason = responsibleDeleteReason;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for responsible type.
   *
   * @param  responsibleType  String
   */
  public void setResponsibleType(String responsibleType) {
    this.responsibleType = responsibleType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for responsible unique id.
   *
   * @param  responsibleUniqueId  String
   */
  public void setResponsibleUniqueId(String responsibleUniqueId) {
    this.responsibleUniqueId = responsibleUniqueId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ssn hash.
   *
   * @param  ssnHash  String
   */
  public void setSsnHash(String ssnHash) {
    this.ssnHash = ssnHash;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for start call time.
   *
   * @param  startCallTime  Date
   */
  public void setStartCallTime(Date startCallTime) {
    this.startCallTime = startCallTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  public String getStrategyID() {
    return strategyID;
  }

  public void setStrategyID(String strategyID) {
    this.strategyID = strategyID;
  }

  public String getResponsibleIdentificationNumberHash() {
    return responsibleIdentificationNumberHash;
  }

  public void setResponsibleIdentificationNumberHash(String responsibleIdentificationNumberHash) {
    this.responsibleIdentificationNumberHash = responsibleIdentificationNumberHash;
  }

  /**
   * @see  java.lang.Object#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("ResponsibleIndex");
    sb.append("{id=").append(id);
    sb.append(", responsible=").append(responsible);
    sb.append(", lastLoginMethod=").append(lastLoginMethod);
    sb.append(", ssnHash='").append(ssnHash).append('\'');
    sb.append('}');

    return sb.toString();
  }
} // end class ResponsibleIndex
