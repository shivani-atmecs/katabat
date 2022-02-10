package com.cmc.credagility.core.domain.portfolio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.contact.ConnectAudit;
import com.cmc.credagility.core.domain.contact.ContactResultAudit;
import com.cmc.credagility.core.domain.contact.PhoneNumberAttemptAudit;
import com.cmc.credagility.core.domain.contact.RPCAudit;


/**
 * Created with IntelliJ IDEA. User: wushuang Date: 13-4-7 To change this template use File | Settings | File Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */

@MappedSuperclass public abstract class BaseNextEligibleCallDateAudit extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** PortfolioContactResultAccountLevelLimit PK appliedContactResultLimitId. */
  @JoinColumn(
    name       = "appliedContactResultLimitId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PortfolioContactResultAccountLevelLimit appliedContactResultLimit;

  /** PortfolioContactResultPhoneTypeLevelDelay PK appliedPhoneTypeDelayId. */
  @JoinColumn(
    name       = "appliedPhoneTypeDelayId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PortfolioContactResultPhoneTypeLevelDelay appliedPhoneTypeDelay;

  /** PortfolioContactResultPhoneTypeLevelLimit PK appliedPhoneTypeLimitId. */
  @JoinColumn(
    name       = "appliedPhoneTypeLimitId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PortfolioContactResultPhoneTypeLevelLimit appliedPhoneTypeLimit;

  /** DOCUMENT ME! */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long auditId;

  /** ConnectAudit PK connectAuditId. */
  @JoinColumn(
    name       = "connectAuditId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected ConnectAudit connectAudit;

  /** ContactResultAudit PK contactResultAuditId. */
  @JoinColumn(
    name       = "contactResultAuditId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected ContactResultAudit contactResultAudit;

  /** nextEligibleCallDate PK nextEligibleCallDate. */
  @Column(
    name     = "nextEligibleCallDate",
    nullable = true
  )
  protected Date nextEligibleCallDate;

  /** Phone number. */
  protected String phoneNum;

  /** Phone number attempt audit. */
  @JoinColumn(
    name       = "phoneNumberAttemptAuditId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PhoneNumberAttemptAudit phoneNumberAttemptAudit;


  /** RPCAudit PK rpcAuditId. */
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
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof BaseNextEligibleCallDateAudit)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    BaseNextEligibleCallDateAudit that = (BaseNextEligibleCallDateAudit) o;

    if ((appliedContactResultLimit != null) ? (!appliedContactResultLimit.equals(that.appliedContactResultLimit))
                                            : (that.appliedContactResultLimit != null)) {
      return false;
    }

    if ((appliedPhoneTypeDelay != null) ? (!appliedPhoneTypeDelay.equals(that.appliedPhoneTypeDelay))
                                        : (that.appliedPhoneTypeDelay != null)) {
      return false;
    }

    if ((appliedPhoneTypeLimit != null) ? (!appliedPhoneTypeLimit.equals(that.appliedPhoneTypeLimit))
                                        : (that.appliedPhoneTypeLimit != null)) {
      return false;
    }

    if ((auditId != null) ? (!auditId.equals(that.auditId)) : (that.auditId != null)) {
      return false;
    }

    if ((connectAudit != null) ? (!connectAudit.equals(that.connectAudit)) : (that.connectAudit != null)) {
      return false;
    }

    if ((contactResultAudit != null) ? (!contactResultAudit.equals(that.contactResultAudit))
                                     : (that.contactResultAudit != null)) {
      return false;
    }

    if ((nextEligibleCallDate != null) ? (!nextEligibleCallDate.equals(that.nextEligibleCallDate))
                                       : (that.nextEligibleCallDate != null)) {
      return false;
    }

    if ((phoneNum != null) ? (!phoneNum.equals(that.phoneNum)) : (that.phoneNum != null)) {
      return false;
    }

    if ((phoneNumberAttemptAudit != null) ? (!phoneNumberAttemptAudit.equals(that.phoneNumberAttemptAudit))
                                          : (that.phoneNumberAttemptAudit != null)) {
      return false;
    }

    if ((rpcAudit != null) ? (!rpcAudit.equals(that.rpcAudit)) : (that.rpcAudit != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PortfolioContactResultAccountLevelLimit getAppliedContactResultLimit() {
    return appliedContactResultLimit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PortfolioContactResultPhoneTypeLevelDelay getAppliedPhoneTypeDelay() {
    return appliedPhoneTypeDelay;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PortfolioContactResultPhoneTypeLevelLimit getAppliedPhoneTypeLimit() {
    return appliedPhoneTypeLimit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getAuditId() {
    return auditId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public ConnectAudit getConnectAudit() {
    return connectAudit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public ContactResultAudit getContactResultAudit() {
    return contactResultAudit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getNextEligibleCallDate() {
    return nextEligibleCallDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPhoneNum() {
    return phoneNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PhoneNumberAttemptAudit getPhoneNumberAttemptAudit() {
    return phoneNumberAttemptAudit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public RPCAudit getRpcAudit() {
    return rpcAudit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((appliedContactResultLimit != null) ? appliedContactResultLimit.hashCode() : 0);
    result = (31 * result) + ((appliedPhoneTypeDelay != null) ? appliedPhoneTypeDelay.hashCode() : 0);
    result = (31 * result) + ((appliedPhoneTypeLimit != null) ? appliedPhoneTypeLimit.hashCode() : 0);
    result = (31 * result) + ((auditId != null) ? auditId.hashCode() : 0);
    result = (31 * result) + ((connectAudit != null) ? connectAudit.hashCode() : 0);
    result = (31 * result) + ((contactResultAudit != null) ? contactResultAudit.hashCode() : 0);
    result = (31 * result) + ((nextEligibleCallDate != null) ? nextEligibleCallDate.hashCode() : 0);
    result = (31 * result) + ((phoneNum != null) ? phoneNum.hashCode() : 0);
    result = (31 * result) + ((phoneNumberAttemptAudit != null) ? phoneNumberAttemptAudit.hashCode() : 0);
    result = (31 * result) + ((rpcAudit != null) ? rpcAudit.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  phoneNum              DOCUMENT ME!
   * @param  accountRevisionAudit  DOCUMENT ME!
   */
  public void populate(String phoneNum, BaseNextEligibleCallDateAudit accountRevisionAudit) {
    this.phoneNum                  = phoneNum;
    this.nextEligibleCallDate      = accountRevisionAudit.getNextEligibleCallDate();
    this.appliedContactResultLimit = accountRevisionAudit.getAppliedContactResultLimit();
    this.appliedPhoneTypeDelay     = accountRevisionAudit.getAppliedPhoneTypeDelay();
    this.appliedPhoneTypeLimit     = accountRevisionAudit.getAppliedPhoneTypeLimit();
    this.rpcAudit                  = accountRevisionAudit.getRpcAudit();
    this.phoneNumberAttemptAudit   = accountRevisionAudit.getPhoneNumberAttemptAudit();
    this.contactResultAudit        = accountRevisionAudit.getContactResultAudit();
    this.connectAudit              = accountRevisionAudit.getConnectAudit();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  appliedContactResultLimit  DOCUMENT ME!
   */
  public void setAppliedContactResultLimit(PortfolioContactResultAccountLevelLimit appliedContactResultLimit) {
    this.appliedContactResultLimit = appliedContactResultLimit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  appliedPhoneTypeDelay  DOCUMENT ME!
   */
  public void setAppliedPhoneTypeDelay(PortfolioContactResultPhoneTypeLevelDelay appliedPhoneTypeDelay) {
    this.appliedPhoneTypeDelay = appliedPhoneTypeDelay;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  appliedPhoneTypeLimit  DOCUMENT ME!
   */
  public void setAppliedPhoneTypeLimit(PortfolioContactResultPhoneTypeLevelLimit appliedPhoneTypeLimit) {
    this.appliedPhoneTypeLimit = appliedPhoneTypeLimit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  auditId  DOCUMENT ME!
   */
  public void setAuditId(Long auditId) {
    this.auditId = auditId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  connectAudit  DOCUMENT ME!
   */
  public void setConnectAudit(ConnectAudit connectAudit) {
    this.connectAudit = connectAudit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  contactResultAudit  DOCUMENT ME!
   */
  public void setContactResultAudit(ContactResultAudit contactResultAudit) {
    this.contactResultAudit = contactResultAudit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  nextEligibleCallDate  DOCUMENT ME!
   */
  public void setNextEligibleCallDate(Date nextEligibleCallDate) {
    this.nextEligibleCallDate = nextEligibleCallDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  phoneNum  DOCUMENT ME!
   */
  public void setPhoneNum(String phoneNum) {
    this.phoneNum = phoneNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  phoneNumberAttemptAudit  DOCUMENT ME!
   */
  public void setPhoneNumberAttemptAudit(PhoneNumberAttemptAudit phoneNumberAttemptAudit) {
    this.phoneNumberAttemptAudit = phoneNumberAttemptAudit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  rpcAudit  DOCUMENT ME!
   */
  public void setRpcAudit(RPCAudit rpcAudit) {
    this.rpcAudit = rpcAudit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#toString()
   */
  @Override public String toString() {
    return "BaseNextEligibleCallDateAudit{"
      + "appliedContactResultLimit=" + appliedContactResultLimit
      + ", auditId=" + auditId
      + ", phoneNum='" + phoneNum + '\''
      + ", nextEligibleCallDate=" + nextEligibleCallDate
      + ", phoneNumberAttemptAudit=" + phoneNumberAttemptAudit
      + ", contactResultAudit=" + contactResultAudit
      + ", rpcAudit=" + rpcAudit
      + ", connectAudit=" + connectAudit
      + ", appliedPhoneTypeDelay=" + appliedPhoneTypeDelay
      + ", appliedPhoneTypeLimit=" + appliedPhoneTypeLimit
      + '}';
  }
} // end class BaseNextEligibleCallDateAudit
