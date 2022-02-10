package com.cmc.credagility.core.domain.contact;

import com.cmc.credagility.core.domain.portfolio.PortfolioContactResultAccountLevelLimit;
import com.cmc.credagility.core.domain.portfolio.PortfolioContactResultPhoneTypeLevelDelay;
import com.cmc.credagility.core.domain.portfolio.PortfolioContactResultPhoneTypeLevelLimit;
import com.cmc.credagility.core.domain.portfolio.PortfolioPhoneTypeDependency;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import java.util.Date;


/**
 * Responsible level phone need implement this class.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/14/2014 17:22
 */
@MappedSuperclass public abstract class BaseContactPhone extends BaseContact implements GeneralContactPhone {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -9147210777741907618L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Compliance triggered account level limit, Refers {@link PortfolioContactResultAccountLevelLimit}. */
  @JoinColumn(
    name       = "appliedContactResultLimitId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PortfolioContactResultAccountLevelLimit appliedContactResultLimit;

  /** Compliance triggered phoneType level delay, Refers {@link PortfolioContactResultPhoneTypeLevelDelay}. */
  @JoinColumn(
    name       = "appliedPhoneTypeDelayId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PortfolioContactResultPhoneTypeLevelDelay appliedPhoneTypeDelay;


  /** Compliance triggered phoneType level limit, Refers {@link PortfolioContactResultPhoneTypeLevelLimit}. */
  @JoinColumn(
    name       = "appliedPhoneTypeLimitId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PortfolioContactResultPhoneTypeLevelLimit appliedPhoneTypeLimit;


  /** Connect audit, Refers {@link ConnectAudit}. */
  @JoinColumn(
    name       = "connectAuditId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected ConnectAudit connectAudit;


  /** Contact result audit, Refers {@link ContactResultAudit}. */
  @JoinColumn(
    name       = "contactResultAuditId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected ContactResultAudit contactResultAudit;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "countryCode",
    length = 3
  )
  protected String             countryCode;


  /** If do not call. */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean doNotCall = Boolean.FALSE;


  /** Last dialer export date. */
  @Column(
    name     = "lastDialerExportDate",
    nullable = true
  )
  protected Date lastDialerExportDate;

  /** Next eligible call date. */
  @Column(
    name     = "nextEligibleCallDate",
    nullable = true
  )
  protected Date nextEligibleCallDate;


  /** Next eligible reason. */
  protected String nextEligibleReason;


  /** Phone number attempt audit, Refers {@link PhoneNumberAttemptAudit}. */
  @JoinColumn(
    name       = "phoneNumberAttemptAuditId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PhoneNumberAttemptAudit phoneNumberAttemptAudit;


  /** Portfolio phone type dependency, Refers {@link PortfolioPhoneTypeDependency}. */
  @JoinColumn(
    name       = "phoneTypeDependencyId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PortfolioPhoneTypeDependency phoneTypeDependency;


  /** RPC audit, Refers {@link RPCAudit}. */
  @JoinColumn(
    name       = "rpcAuditId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected RPCAudit rpcAudit;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "telephoneCountryCode",
    length = 10
  )
  protected String telephoneCountryCode;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for applied contact result limit.
   *
   * @return  PortfolioContactResultAccountLevelLimit
   */
  public PortfolioContactResultAccountLevelLimit getAppliedContactResultLimit() {
    return appliedContactResultLimit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for applied phone type delay.
   *
   * @return  PortfolioContactResultPhoneTypeLevelDelay
   */
  public PortfolioContactResultPhoneTypeLevelDelay getAppliedPhoneTypeDelay() {
    return appliedPhoneTypeDelay;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for applied phone type limit.
   *
   * @return  PortfolioContactResultPhoneTypeLevelLimit
   */
  public PortfolioContactResultPhoneTypeLevelLimit getAppliedPhoneTypeLimit() {
    return appliedPhoneTypeLimit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for connect audit.
   *
   * @return  ConnectAudit
   */
  public ConnectAudit getConnectAudit() {
    return connectAudit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for contact result audit.
   *
   * @return  ContactResultAudit
   */
  public ContactResultAudit getContactResultAudit() {
    return contactResultAudit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for country code.
   *
   * @return  String
   */
  public String getCountryCode() {
    return countryCode;
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
   * getter method for last dialer export date.
   *
   * @return  Date
   */
  public Date getLastDialerExportDate() {
    return lastDialerExportDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for next eligible call date.
   *
   * @return  Date
   */
  public Date getNextEligibleCallDate() {
    return nextEligibleCallDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for next eligible reason.
   *
   * @return  String
   */
  public String getNextEligibleReason() {
    return nextEligibleReason;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for phone number attempt audit.
   *
   * @return  PhoneNumberAttemptAudit
   */
  public PhoneNumberAttemptAudit getPhoneNumberAttemptAudit() {
    return phoneNumberAttemptAudit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for phone type dependency.
   *
   * @return  PortfolioPhoneTypeDependency
   */
  public PortfolioPhoneTypeDependency getPhoneTypeDependency() {
    return phoneTypeDependency;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for rpc audit.
   *
   * @return  RPCAudit
   */
  public RPCAudit getRpcAudit() {
    return rpcAudit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for telephone country code.
   *
   * @return  String
   */
  public String getTelephoneCountryCode() {
    return telephoneCountryCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for applied contact result limit.
   *
   * @param  appliedContactResultLimit  PortfolioContactResultAccountLevelLimit
   */
  public void setAppliedContactResultLimit(PortfolioContactResultAccountLevelLimit appliedContactResultLimit) {
    this.appliedContactResultLimit = appliedContactResultLimit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for applied phone type delay.
   *
   * @param  appliedPhoneTypeDelay  PortfolioContactResultPhoneTypeLevelDelay
   */
  public void setAppliedPhoneTypeDelay(PortfolioContactResultPhoneTypeLevelDelay appliedPhoneTypeDelay) {
    this.appliedPhoneTypeDelay = appliedPhoneTypeDelay;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for applied phone type limit.
   *
   * @param  appliedPhoneTypeLimit  PortfolioContactResultPhoneTypeLevelLimit
   */
  public void setAppliedPhoneTypeLimit(PortfolioContactResultPhoneTypeLevelLimit appliedPhoneTypeLimit) {
    this.appliedPhoneTypeLimit = appliedPhoneTypeLimit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for connect audit.
   *
   * @param  connectAudit  ConnectAudit
   */
  public void setConnectAudit(ConnectAudit connectAudit) {
    this.connectAudit = connectAudit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for contact result audit.
   *
   * @param  contactResultAudit  ContactResultAudit
   */
  public void setContactResultAudit(ContactResultAudit contactResultAudit) {
    this.contactResultAudit = contactResultAudit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for country code.
   *
   * @param  countryCode  String
   */
  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for do not call.
   *
   * @param  doNotCall  Boolean
   */
  @Override public void setDoNotCall(Boolean doNotCall) {
    this.doNotCall = doNotCall;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last dialer export date.
   *
   * @param  lastDialerExportDate  Date
   */
  public void setLastDialerExportDate(Date lastDialerExportDate) {
    this.lastDialerExportDate = lastDialerExportDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for next eligible call date.
   *
   * @param  nextEligibleCallDate  Date
   */
  public void setNextEligibleCallDate(Date nextEligibleCallDate) {
    this.nextEligibleCallDate = nextEligibleCallDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for next eligible reason.
   *
   * @param  nextEligibleReason  String
   */
  public void setNextEligibleReason(String nextEligibleReason) {
    this.nextEligibleReason = nextEligibleReason;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for phone number attempt audit.
   *
   * @param  phoneNumberAttemptAudit  PhoneNumberAttemptAudit
   */
  public void setPhoneNumberAttemptAudit(PhoneNumberAttemptAudit phoneNumberAttemptAudit) {
    this.phoneNumberAttemptAudit = phoneNumberAttemptAudit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for phone type dependency.
   *
   * @param  phoneTypeDependency  PortfolioPhoneTypeDependency
   */
  @Override public void setPhoneTypeDependency(PortfolioPhoneTypeDependency phoneTypeDependency) {
    this.phoneTypeDependency = phoneTypeDependency;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for rpc audit.
   *
   * @param  rpcAudit  RPCAudit
   */
  public void setRpcAudit(RPCAudit rpcAudit) {
    this.rpcAudit = rpcAudit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for telephone country code.
   *
   * @param  telephoneCountryCode  String
   */
  public void setTelephoneCountryCode(String telephoneCountryCode) {
    this.telephoneCountryCode = telephoneCountryCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * toString.
   *
   * @return  String
   */
  @Override public String toString() {
    final String TAB = "    ";

    StringBuilder retValue = new StringBuilder();

    retValue.append("BaseContactPhone ( ").append(super.toString()).append(TAB).append("nextEligibleCallDate= ").append(
      this.nextEligibleCallDate).append(TAB).append(
      "source = ").append(this.source).append(TAB).append("status = ").append(this.status).append(TAB).append(" )");

    return retValue.toString();
  }
} // end class BaseContactPhone
