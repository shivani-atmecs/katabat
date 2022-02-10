package com.cmc.credagility.core.domain.authorizeduser;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.cmc.credagility.core.domain.contact.ConnectAudit;
import com.cmc.credagility.core.domain.contact.ContactResultAudit;
import com.cmc.credagility.core.domain.contact.GeneralContactPhone;
import com.cmc.credagility.core.domain.contact.PhoneNumberAttemptAudit;
import com.cmc.credagility.core.domain.contact.RPCAudit;
import com.cmc.credagility.core.domain.portfolio.PortfolioContactResultAccountLevelLimit;
import com.cmc.credagility.core.domain.portfolio.PortfolioContactResultPhoneTypeLevelDelay;
import com.cmc.credagility.core.domain.portfolio.PortfolioContactResultPhoneTypeLevelLimit;
import com.cmc.credagility.core.domain.portfolio.PortfolioPhoneTypeDependency;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 09:43
 */
@MappedSuperclass public abstract class BaseAuthorizedUserPhone extends BaseAuthorizedUser
  implements GeneralContactPhone {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -6813813016642654459L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "appliedContactResultLimitId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PortfolioContactResultAccountLevelLimit appliedContactResultLimit;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "appliedPhoneTypeDelayId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PortfolioContactResultPhoneTypeLevelDelay appliedPhoneTypeDelay;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "appliedPhoneTypeLimitId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PortfolioContactResultPhoneTypeLevelLimit appliedPhoneTypeLimit;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "connectAuditId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected ConnectAudit connectAudit;


  /** TODO: DOCUMENT ME! */
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
    name             = "doNotCall",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean doNotCall = Boolean.FALSE;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "lastDialerExportDate",
    nullable = true
  )
  protected Date lastDialerExportDate;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "nextEligibleCallDate",
    nullable = true
  )
  protected Date nextEligibleCallDate;

  /** TODO: DOCUMENT ME! */
  protected String nextEligibleReason;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "phoneNumberAttemptAuditId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PhoneNumberAttemptAudit phoneNumberAttemptAudit;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "phoneTypeDependencyId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PortfolioPhoneTypeDependency phoneTypeDependency;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "rpcAuditId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected RPCAudit rpcAudit;

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
   * @see  com.cmc.credagility.core.domain.contact.GeneralContactPhone#setDoNotCall(java.lang.Boolean)
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
   * @see  com.cmc.credagility.core.domain.contact.GeneralContactPhone#setPhoneTypeDependency(com.cmc.credagility.core.domain.portfolio.PortfolioPhoneTypeDependency)
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
} // end class BaseAuthorizedUserPhone
