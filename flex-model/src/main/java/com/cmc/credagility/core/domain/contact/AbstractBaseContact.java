package com.cmc.credagility.core.domain.contact;

import com.cmc.credagility.core.domain.type.ContactChannel;
import com.cmc.credagility.core.domain.type.ContactSource;
import com.cmc.credagility.core.domain.type.ContactStatus;
import com.cmc.credagility.core.domain.type.ExpressConsentType;
import com.cmc.credagility.core.domain.user.User;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import java.util.Date;


/**
 * All level address,email and phone need extend this class.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/14/2014 17:10
 */
@MappedSuperclass public abstract class AbstractBaseContact extends ContactableBaseObject {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 4946060941645459677L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** This is when the debtor actually use this contact venue. */
  @Column(name = "actualEndDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date actualEndDate;

  /** This is when the debtor actually use this contact venue. CreateDate is the system entry date. */
  @Column(name = "actualStartDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date actualStartDate;


  /** TODO: DOCUMENT ME! */
  @Column(name = "entryDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date entryDate;


  /** TODO: DOCUMENT ME! */
  @Column(name = "exitDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date exitDate;


  /** Express consent type, Refers {@link ExpressConsentType}. */
  @Column(
    name     = "expressConsent",
    nullable = true,
    length   = 5
  )
  @Enumerated(EnumType.STRING)
  protected ExpressConsentType expressConsent;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "externalReferenceId",
    length = 100
  )
  protected String externalReferenceId;


  /** TODO: need add @Index(name = "historicalIndex") */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean historical        = Boolean.FALSE;

  /** TODO: DOCUMENT ME! */
  @Column(
    name                              = "lastContactStatus",
    length                            = 3
  )
  protected String  lastContactStatus;

  /** TODO: DOCUMENT ME! */
  @Column(name = "lastContactStatusDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date lastContactStatusDate;


  /** Last update the express consent agent, Refers {@link User}. */
  @JoinColumn(
    name       = "lastExpressConsentAgentId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected User lastExpressConsentAgent;


  /** Last update the express consent date. */
  @Column(name = "lastExpressConsentUpdateDate")
  protected Date lastExpressConsentUpdateDate;

  /** TODO: DOCUMENT ME! */
  @Column(name = "lastOutBoundAuditId")
  protected Long lastOutBoundAuditId;


  /** If mark this contact's status to wrong. */
  @Transient protected boolean markWrong = false;

  /** TODO: need add @Index(name = "optOutIndex") */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean optOut = Boolean.FALSE;


  // npelleti, 07/30, USBank, Add NOT NULL constraint
  /** contact source. */
  @Column(
    name     = "source",
    nullable = false,
    length   = 20
  )
  @Enumerated(EnumType.STRING)
  protected ContactSource source;

  // npelleti, 07/30, USBank, Add NOT NULL constraint
  /** contact status. */
  @Column(
    name     = "status",
    nullable = false,
    length   = 20
  )
  @Enumerated(EnumType.STRING)
  protected ContactStatus status;


  /** TODO: DOCUMENT ME! */
  @Column(name = "verifiedDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date verifiedDate;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * equals.
   *
   * @param   obj  Object
   *
   * @return  boolean
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

    if (!super.equals(obj)) {
      return false;
    }

    AbstractBaseContact other = (AbstractBaseContact) obj;

    // if (this.status == null) {
    // if (other.status != null) {
    // return false;
    // }
    // } else if (!this.status.equals(other.status)) {
    // return false;
    // }

    if (externalReferenceId == null) {
      if (other.getExternalReferenceId() != null) {
        return false;
      }
    } else if (!externalReferenceId.equals(other.getExternalReferenceId())) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for actual end date.
   *
   * @return  Date
   */
  public Date getActualEndDate() {
    return actualEndDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for actual start date.
   *
   * @return  Date
   */
  public Date getActualStartDate() {
    return actualStartDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for entry date.
   *
   * @return  Date
   */
  public Date getEntryDate() {
    return entryDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for exit date.
   *
   * @return  Date
   */
  public Date getExitDate() {
    return exitDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for express consent.
   *
   * @return  ExpressConsentType
   */
  public ExpressConsentType getExpressConsent() {
    if (ExpressConsentType.YES.equals(expressConsent)) {
      return ExpressConsentType.YES;
    } else if (ExpressConsentType.NO.equals(expressConsent)) {
      return ExpressConsentType.NO;
    } else {
      return ExpressConsentType.NA;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for external reference id.
   *
   * @return  String
   */
  public String getExternalReferenceId() {
    return externalReferenceId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for historical.
   *
   * @return  Boolean
   */
  public Boolean getHistorical() {
    return historical;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last contact status.
   *
   * @return  String
   */
  public String getLastContactStatus() {
    return lastContactStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last contact status date.
   *
   * @return  Date
   */
  public Date getLastContactStatusDate() {
    return lastContactStatusDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last express consent agent.
   *
   * @return  User
   */
  public User getLastExpressConsentAgent() {
    return lastExpressConsentAgent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last express consent update date.
   *
   * @return  Date
   */
  public Date getLastExpressConsentUpdateDate() {
    return lastExpressConsentUpdateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last out bound audit id.
   *
   * @return  Long
   */
  public Long getLastOutBoundAuditId() {
    return lastOutBoundAuditId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for opt out.
   *
   * @return  Boolean
   */
  public Boolean getOptOut() {
    if (optOut == null) {
      return Boolean.FALSE;
    }

    return optOut;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for source.
   *
   * @return  ContactSource
   */
  public ContactSource getSource() {
    return source;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status.
   *
   * @return  ContactStatus
   */
  public ContactStatus getStatus() {
    return status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for verified date.
   *
   * @return  Date
   */
  public Date getVerifiedDate() {
    return verifiedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The wrongInfo.
   *
   * @return  the wrongInfo
   */
  public Boolean getWrongInfo() {
    return ContactStatus.BAD.equals(status);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    return 31;
      // final int prime  = 31;
      // int       result = 31;
      // result = (prime * result)
      // + ((this.status == null) ? 0 : this.status.hashCode());
      //
      // return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for mark wrong.
   *
   * @return  boolean
   */
  public boolean isMarkWrong() {
    return markWrong;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for actual end date.
   *
   * @param  actualEndDate  Date
   */
  public void setActualEndDate(Date actualEndDate) {
    this.actualEndDate = actualEndDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for actual start date.
   *
   * @param  actualStartDate  Date
   */
  public void setActualStartDate(Date actualStartDate) {
    this.actualStartDate = actualStartDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for entry date.
   *
   * @param  entryDate  Date
   */
  public void setEntryDate(Date entryDate) {
    this.entryDate = entryDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for exit date.
   *
   * @param  exitDate  Date
   */
  public void setExitDate(Date exitDate) {
    this.exitDate = exitDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for express consent.
   *
   * @param  expressConsent  ExpressConsentType
   */
  public void setExpressConsent(ExpressConsentType expressConsent) {
    this.expressConsent = expressConsent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for external reference id.
   *
   * @param  externalReferenceId  String
   */
  public void setExternalReferenceId(String externalReferenceId) {
    this.externalReferenceId = externalReferenceId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for historical.
   *
   * @param  historical  Boolean
   */
  public void setHistorical(Boolean historical) {
    this.historical = historical;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last contact status.
   *
   * @param  lastContactStatus  String
   */
  public void setLastContactStatus(String lastContactStatus) {
    this.lastContactStatus = lastContactStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last contact status date.
   *
   * @param  lastContactStatusDate  Date
   */
  public void setLastContactStatusDate(Date lastContactStatusDate) {
    this.lastContactStatusDate = lastContactStatusDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last express consent agent.
   *
   * @param  lastExpressConsentAgent  User
   */
  public void setLastExpressConsentAgent(User lastExpressConsentAgent) {
    this.lastExpressConsentAgent = lastExpressConsentAgent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last express consent update date.
   *
   * @param  lastExpressConsentUpdateDate  Date
   */
  public void setLastExpressConsentUpdateDate(Date lastExpressConsentUpdateDate) {
    this.lastExpressConsentUpdateDate = lastExpressConsentUpdateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last out bound audit id.
   *
   * @param  lastOutBoundAuditId  Long
   */
  public void setLastOutBoundAuditId(Long lastOutBoundAuditId) {
    this.lastOutBoundAuditId = lastOutBoundAuditId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for mark wrong.
   *
   * @param  markWrong  boolean
   */
  public void setMarkWrong(boolean markWrong) {
    this.markWrong = markWrong;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for opt out.
   *
   * @param  optOut  Boolean
   */
  public void setOptOut(Boolean optOut) {
    this.optOut = optOut;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for source.
   *
   * @param  source  ContactSource
   */
  public void setSource(ContactSource source) {
    this.source = source;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for status.
   *
   * @param  status  ContactStatus
   */
  public void setStatus(ContactStatus status) {
    this.status = status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for verified date.
   *
   * @param  verifiedDate  Date
   */
  public void setVerifiedDate(Date verifiedDate) {
    this.verifiedDate = verifiedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for wrong info.
   *
   * @param  wrongInfo  Boolean
   */
  public void setWrongInfo(Boolean wrongInfo) {
    if (Boolean.TRUE.equals(wrongInfo)) {
      if (!ContactStatus.BAD.equals(status)) {
        // change to 'BAD'
        // need to mark as wrong
        markWrong = true;
        status    = ContactStatus.BAD;
      }
    } else {
      if (ContactStatus.BAD.equals(status)) {
        // remove wrong info flag
        markWrong = false;
        status    = ContactStatus.UNVERIFIED;
      }
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The ContactChannel enum.
   *
   * @return  the ContactChannel enum.
   */
  public abstract ContactChannel getContactChannel();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * deepCopy.
   *
   * @param  baseContact  AbstractBaseContact
   */
  protected void deepCopy(AbstractBaseContact baseContact) {
    if (baseContact != null) {
      super.deepCopy(baseContact);
      this.source              = baseContact.getSource();
      this.status              = baseContact.getStatus();
      this.externalReferenceId = baseContact.getExternalReferenceId();

      if (baseContact.getActualStartDate() != null) {
        this.actualStartDate = baseContact.getActualStartDate();
      }

      if (baseContact.getVerifiedDate() != null) {
        this.verifiedDate = baseContact.getVerifiedDate();
      }

      this.expressConsent               = baseContact.getExpressConsent();
      this.lastExpressConsentAgent      = baseContact.getLastExpressConsentAgent();
      this.lastExpressConsentUpdateDate = baseContact.getLastExpressConsentUpdateDate();
    }
  }
} // end class AbstractBaseContact
