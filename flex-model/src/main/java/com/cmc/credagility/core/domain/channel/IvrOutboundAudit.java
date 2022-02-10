package com.cmc.credagility.core.domain.channel;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
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
import javax.persistence.UniqueConstraint;

import com.cmc.credagility.core.domain.contact.BaseContactAudit;
import com.cmc.credagility.core.domain.contact.ContactPhone;
import com.cmc.credagility.core.domain.payment.Payment;
import com.cmc.credagility.core.domain.payment.PaymentProgram;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * This class is used to store ivr channel return information.
 *
 * <p><a href="IvrOutboundAudit.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/15/2014 11:07
 */
@Entity
@Table(
  name              = "IvrOutboundAudit",
  uniqueConstraints = { @UniqueConstraint(columnNames = "paymentId"), @UniqueConstraint(columnNames = "vmId") }
)
public class IvrOutboundAudit extends BaseContactAudit {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -1554185027854694871L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** accepted Payment Program. */
  @JoinColumn(
    name      = "programId",
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PaymentProgram acceptedProgram;


  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "agentConnected",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean agentConnected;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "agentResultCode",
    length = 3
  )
  protected String agentResultCode;


  /** TODO: DOCUMENT ME! */
  @Column(name = "attemptDuration")
  protected Integer attemptDuration;


  /** TODO: DOCUMENT ME! */
  @Column(name = "attemptFinishTime")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date attemptFinishTime;


  /** TODO: DOCUMENT ME! */
  @Column(name = "attemptStartTime")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date attemptStartTime;

  /** Import batch job Id. */
  @Column(name = "batchId")
  protected Long batchId;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "callAudit",
    length = 100
  )
  protected String callAudit;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "callerIdShortCodeReplyTo",
    length = 20
  )
  protected String callerIdShortCodeReplyTo;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "callPass",
    length = 20
  )
  protected String callPass;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "resultCodeId",
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected IvrResultCodeType callResultCode;
  // Use Amount find most recent payment which is from IVR channel


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "callSeconds",
    length = 20
  )
  protected String callSeconds;


  /** TODO: DOCUMENT ME! */
  @Column(name = "connectDuration")
  protected Integer connectDuration;


  /** Contact Phone. */
  @JoinColumn(
    name      = "phoneId",
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected ContactPhone contactPhone;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "debtorName",
    length = 100
  )
  protected String debtorName;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "debtorName2",
    length = 100
  )
  protected String debtorName2;


  /** TODO: DOCUMENT ME! */
  @Column(name = "deliveryDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date deliveryDate;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "deviceAttempted",
    length = 128
  )
  protected String deviceAttempted;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "deviceTimezone",
    length = 80
  )
  protected String deviceTimezone;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "directConnectAgentId",
    length = 25
  )
  protected String directConnectAgentId;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "directConnectAutoManage",
    length = 20
  )
  protected String directConnectAutoManage;


  /** TODO: DOCUMENT ME! */
  @Column(name = "directConnectDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date directConnectDate;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "directConnectDispositionCategory",
    length = 50
  )
  protected String directConnectDispositionCategory;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "directConnectDispositionCode",
    length = 50
  )
  protected String directConnectDispositionCode;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "directConnectDispositionValue",
    length = 20
  )
  protected String directConnectDispositionValue;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "ivrResultId",
    updatable = false
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  protected IvrChannelResult ivrChannelResult;

  /** Return Id, PK. */
  @Column(
    name     = "ivrReturnId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long ivrReturnId;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "lastState",
    length = 80
  )
  protected String lastState;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "lastStateSeconds",
    length = 20
  )
  protected String lastStateSeconds;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "numberOfAttempts",
    length = 20
  )
  protected String numberOfAttempts;


  /** Payment. */
  @JoinColumn(
    name      = "paymentId",
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Payment payment;


  /** payment Amount. */
  @Column(name = "paymentAmount")
  protected BigDecimal paymentAmount;


  /** phone Number. */
  @Column(
    name   = "phoneNumber",
    length = 20
  )
  protected String phoneNumber;


  /** TODO: DOCUMENT ME! */
  @Column(name = "programIndex")
  protected Integer programIndex;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "scriptId",
    length = 255
  )
  protected String scriptId;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "status",
    length = 250
  )
  protected String status;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "subCampaign",
    length = 100
  )
  protected String subCampaign;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "vendorResultCodeId")
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  protected VendorChannelResultCode vendorChannelResultCode;


  /** TODO: DOCUMENT ME! */
  @Column(name = "vendorCompleteDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date vendorCompleteDate;


  /** TODO: DOCUMENT ME! */
  @Column(name = "vendorReceiveDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date vendorReceiveDate;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "vendorResultCode",
    length = 150
  )
  protected String vendorResultCode;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "vmId",
    updatable = false
  )
  @OneToOne(
    fetch   = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  protected VoiceMailActivity voiceMail;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.contact.BaseContactAudit#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (!super.equals(obj)) {
      return false;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    final IvrOutboundAudit other = (IvrOutboundAudit) obj;

    if (attemptDuration == null) {
      if (other.attemptDuration != null) {
        return false;
      }
    } else if (!attemptDuration.equals(other.attemptDuration)) {
      return false;
    }

    if (attemptFinishTime == null) {
      if (other.attemptFinishTime != null) {
        return false;
      }
    } else if (!attemptFinishTime.equals(other.attemptFinishTime)) {
      return false;
    }

    if (attemptStartTime == null) {
      if (other.attemptStartTime != null) {
        return false;
      }
    } else if (!attemptStartTime.equals(other.attemptStartTime)) {
      return false;
    }

    if (callAudit == null) {
      if (other.callAudit != null) {
        return false;
      }
    } else if (!callAudit.equals(other.callAudit)) {
      return false;
    }

    if (callResultCode == null) {
      if (other.callResultCode != null) {
        return false;
      }
    } else if (!callResultCode.equals(other.callResultCode)) {
      return false;
    }

    if (connectDuration == null) {
      if (other.connectDuration != null) {
        return false;
      }
    } else if (!connectDuration.equals(other.connectDuration)) {
      return false;
    }

    if (debtorName == null) {
      if (other.debtorName != null) {
        return false;
      }
    } else if (!debtorName.equals(other.debtorName)) {
      return false;
    }

    if (debtorName2 == null) {
      if (other.debtorName2 != null) {
        return false;
      }
    } else if (!debtorName2.equals(other.debtorName2)) {
      return false;
    }

    if (phoneNumber == null) {
      if (other.phoneNumber != null) {
        return false;
      }
    } else if (!phoneNumber.equals(other.phoneNumber)) {
      return false;
    }

    if (scriptId == null) {
      if (other.scriptId != null) {
        return false;
      }
    } else if (!scriptId.equals(other.scriptId)) {
      return false;
    }

    if (vendorCompleteDate == null) {
      if (other.vendorCompleteDate != null) {
        return false;
      }
    } else if (!vendorCompleteDate.equals(other.vendorCompleteDate)) {
      return false;
    }

    if (vendorReceiveDate == null) {
      if (other.vendorReceiveDate != null) {
        return false;
      }
    } else if (!vendorReceiveDate.equals(other.vendorReceiveDate)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getAcceptedProgram.
   *
   * @return  PaymentProgram
   *
   *          <p>lazy = "proxy" column = "programId" not-null = "false" class = "com.cmc.credagility.PaymentProgram"
   *          insert = "true" update = "false"</p>
   */
  public PaymentProgram getAcceptedProgram() {
    return acceptedProgram;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getAgentConnected.
   *
   * @return  Boolean
   *
   *          <p>type = "yes_no"</p>
   */
  public Boolean getAgentConnected() {
    return agentConnected;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getAgentResultCode.
   *
   * @return  String
   *
   *          <p>length = "3"</p>
   */
  public String getAgentResultCode() {
    return agentResultCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for attempt duration.
   *
   * @return  Integer
   */
  public Integer getAttemptDuration() {
    return attemptDuration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for attempt finish time.
   *
   * @return  Date
   */
  public Date getAttemptFinishTime() {
    return attemptFinishTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for attempt start time.
   *
   * @return  Date
   */
  public Date getAttemptStartTime() {
    return attemptStartTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for batch id.
   *
   * @return  Long
   */
  public Long getBatchId() {
    return this.batchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for call audit.
   *
   * @return  String
   */
  public String getCallAudit() {
    return callAudit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for caller id short code reply to.
   *
   * @return  String
   */
  public String getCallerIdShortCodeReplyTo() {
    return callerIdShortCodeReplyTo;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for call pass.
   *
   * @return  String
   */
  public String getCallPass() {
    return callPass;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   *          <p>column = "resultCodeId" not-null = "false" class = "com.cmc.credagility.IvrResultCodeType" insert =
   *          "true" update = "false"</p>
   */
  public IvrResultCodeType getCallResultCode() {
    return callResultCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for call seconds.
   *
   * @return  String
   */
  public String getCallSeconds() {
    return callSeconds;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for connect duration.
   *
   * @return  Integer
   */
  public Integer getConnectDuration() {
    return connectDuration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getContactPhone.
   *
   * @return  ContactPhone
   *
   *          <p>lazy = "proxy" column = "phoneId" not-null = "false" class = "com.cmc.credagility.ContactPhone" insert
   *          = "true" update = "false"</p>
   */
  public ContactPhone getContactPhone() {
    return contactPhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for debtor name.
   *
   * @return  String
   */
  public String getDebtorName() {
    return debtorName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for debtor name2.
   *
   * @return  String
   */
  public String getDebtorName2() {
    return debtorName2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for delivery date.
   *
   * @return  Date
   */
  public Date getDeliveryDate() {
    return deliveryDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for device attempted.
   *
   * @return  String
   */
  public String getDeviceAttempted() {
    return deviceAttempted;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for device timezone.
   *
   * @return  String
   */
  public String getDeviceTimezone() {
    return deviceTimezone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for direct connect agent id.
   *
   * @return  String
   */
  public String getDirectConnectAgentId() {
    return directConnectAgentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for direct connect auto manage.
   *
   * @return  String
   */
  public String getDirectConnectAutoManage() {
    return directConnectAutoManage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for direct connect date.
   *
   * @return  Date
   */
  public Date getDirectConnectDate() {
    return directConnectDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for direct connect disposition category.
   *
   * @return  String
   */
  public String getDirectConnectDispositionCategory() {
    return directConnectDispositionCategory;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for direct connect disposition code.
   *
   * @return  String
   */
  public String getDirectConnectDispositionCode() {
    return directConnectDispositionCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for direct connect disposition value.
   *
   * @return  String
   */
  public String getDirectConnectDispositionValue() {
    return directConnectDispositionValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The ivrChannelResult.
   *
   * @return  the ivrChannelResult
   *
   *          <p>lazy = "proxy" column = "ivrResultId" not-null = "false" class = "com.cmc.credagility.IvrChannelResult"
   *          insert = "true" update = "false" cascade = "save-update"</p>
   */
  public IvrChannelResult getIvrChannelResult() {
    return this.ivrChannelResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Primary key.
   *
   * @return  primary key.
   *
   *          <p>generator-class = "native" unsaved-value = "null"</p>
   */
  public Long getIvrReturnId() {
    return ivrReturnId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last state.
   *
   * @return  String
   */
  public String getLastState() {
    return lastState;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last state seconds.
   *
   * @return  String
   */
  public String getLastStateSeconds() {
    return lastStateSeconds;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for number of attempts.
   *
   * @return  String
   */
  public String getNumberOfAttempts() {
    return numberOfAttempts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getPayment.
   *
   * @return  Payment
   *
   *          <p>unique = "true" lazy = "proxy" column = "paymentId" not-null = "false" class =
   *          "com.cmc.credagility.Payment" insert = "true" update = "false"</p>
   */
  public Payment getPayment() {
    return payment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPaymentAmount() {
    return paymentAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for phone number.
   *
   * @return  String
   */
  public String getPhoneNumber() {
    return phoneNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for program index.
   *
   * @return  Integer
   */
  public Integer getProgramIndex() {
    return programIndex;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * IVR Script Id.
   *
   * @return  iVR Script Id.
   */
  public String getScriptId() {
    return scriptId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status.
   *
   * @return  String
   */
  public String getStatus() {
    return status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for sub campaign.
   *
   * @return  String
   */
  public String getSubCampaign() {
    return subCampaign;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for vendor channel result code.
   *
   * @return  VendorChannelResultCode
   */
  public VendorChannelResultCode getVendorChannelResultCode() {
    return vendorChannelResultCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for vendor complete date.
   *
   * @return  Date
   */
  public Date getVendorCompleteDate() {
    return vendorCompleteDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for vendor receive date.
   *
   * @return  Date
   */
  public Date getVendorReceiveDate() {
    return vendorReceiveDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for vendor result code.
   *
   * @return  String
   */
  public String getVendorResultCode() {
    return vendorResultCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for voice mail.
   *
   * @return  VoiceMailActivity
   */
  public VoiceMailActivity getVoiceMail() {
    return voiceMail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.contact.BaseContactAudit#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = super.hashCode();
    result = (prime * result)
      + ((attemptDuration == null) ? 0 : attemptDuration.hashCode());
    result = (prime * result)
      + ((attemptFinishTime == null) ? 0 : attemptFinishTime.hashCode());
    result = (prime * result)
      + ((attemptStartTime == null) ? 0 : attemptStartTime.hashCode());
    result = (prime * result) + ((callAudit == null) ? 0 : callAudit.hashCode());
    result = (prime * result)
      + ((callResultCode == null) ? 0 : callResultCode.hashCode());
    result = (prime * result)
      + ((connectDuration == null) ? 0 : connectDuration.hashCode());
    result = (prime * result)
      + ((debtorName == null) ? 0 : debtorName.hashCode());
    result = (prime * result)
      + ((debtorName2 == null) ? 0 : debtorName2.hashCode());
    result = (prime * result)
      + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
    result = (prime * result) + ((scriptId == null) ? 0 : scriptId.hashCode());
    result = (prime * result)
      + ((vendorCompleteDate == null) ? 0 : vendorCompleteDate.hashCode());
    result = (prime * result)
      + ((vendorReceiveDate == null) ? 0 : vendorReceiveDate.hashCode());

    return result;
  } // end method hashCode

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for accepted program.
   *
   * @param  acceptedProgram  PaymentProgram
   */
  public void setAcceptedProgram(PaymentProgram acceptedProgram) {
    this.acceptedProgram = acceptedProgram;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agent connected.
   *
   * @param  agentConnected  Boolean
   */
  public void setAgentConnected(Boolean agentConnected) {
    this.agentConnected = agentConnected;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agent result code.
   *
   * @param  agentResultCode  String
   */
  public void setAgentResultCode(String agentResultCode) {
    this.agentResultCode = agentResultCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for attempt duration.
   *
   * @param  attemptDuration  Integer
   */
  public void setAttemptDuration(Integer attemptDuration) {
    this.attemptDuration = attemptDuration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for attempt finish time.
   *
   * @param  attemptFinishTime  Date
   */
  public void setAttemptFinishTime(Date attemptFinishTime) {
    this.attemptFinishTime = attemptFinishTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for attempt start time.
   *
   * @param  attemptStartTime  Date
   */
  public void setAttemptStartTime(Date attemptStartTime) {
    this.attemptStartTime = attemptStartTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for batch id.
   *
   * @param  batchId  Long
   */
  public void setBatchId(Long batchId) {
    this.batchId = batchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for call audit.
   *
   * @param  callAudit  String
   */
  public void setCallAudit(String callAudit) {
    this.callAudit = callAudit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for caller id short code reply to.
   *
   * @param  callerIdShortCodeReplyTo  String
   */
  public void setCallerIdShortCodeReplyTo(String callerIdShortCodeReplyTo) {
    this.callerIdShortCodeReplyTo = callerIdShortCodeReplyTo;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for call pass.
   *
   * @param  callPass  String
   */
  public void setCallPass(String callPass) {
    this.callPass = callPass;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for call result code.
   *
   * @param  callResultCode  IvrResultCodeType
   */
  public void setCallResultCode(IvrResultCodeType callResultCode) {
    this.callResultCode = callResultCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for call seconds.
   *
   * @param  callSeconds  String
   */
  public void setCallSeconds(String callSeconds) {
    this.callSeconds = callSeconds;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for connect duration.
   *
   * @param  connectDuration  Integer
   */
  public void setConnectDuration(Integer connectDuration) {
    this.connectDuration = connectDuration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for contact phone.
   *
   * @param  contactPhone  ContactPhone
   */
  public void setContactPhone(ContactPhone contactPhone) {
    this.contactPhone = contactPhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for debtor name.
   *
   * @param  debtorName  String
   */
  public void setDebtorName(String debtorName) {
    this.debtorName = debtorName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for debtor name2.
   *
   * @param  debtorName2  String
   */
  public void setDebtorName2(String debtorName2) {
    this.debtorName2 = debtorName2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for delivery date.
   *
   * @param  deliveryDate  Date
   */
  public void setDeliveryDate(Date deliveryDate) {
    this.deliveryDate = deliveryDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for device attempted.
   *
   * @param  deviceAttempted  String
   */
  public void setDeviceAttempted(String deviceAttempted) {
    this.deviceAttempted = deviceAttempted;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for device timezone.
   *
   * @param  deviceTimezone  String
   */
  public void setDeviceTimezone(String deviceTimezone) {
    this.deviceTimezone = deviceTimezone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for direct connect agent id.
   *
   * @param  directConnectAgentId  String
   */
  public void setDirectConnectAgentId(String directConnectAgentId) {
    this.directConnectAgentId = directConnectAgentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for direct connect auto manage.
   *
   * @param  directConnectAutoManage  String
   */
  public void setDirectConnectAutoManage(String directConnectAutoManage) {
    this.directConnectAutoManage = directConnectAutoManage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for direct connect date.
   *
   * @param  directConnectDate  Date
   */
  public void setDirectConnectDate(Date directConnectDate) {
    this.directConnectDate = directConnectDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for direct connect disposition category.
   *
   * @param  directConnectDispositionCategory  String
   */
  public void setDirectConnectDispositionCategory(String directConnectDispositionCategory) {
    this.directConnectDispositionCategory = directConnectDispositionCategory;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for direct connect disposition code.
   *
   * @param  directConnectDispositionCode  String
   */
  public void setDirectConnectDispositionCode(String directConnectDispositionCode) {
    this.directConnectDispositionCode = directConnectDispositionCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for direct connect disposition value.
   *
   * @param  directConnectDispositionValue  String
   */
  public void setDirectConnectDispositionValue(String directConnectDispositionValue) {
    this.directConnectDispositionValue = directConnectDispositionValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ivr channel result.
   *
   * @param  ivrChannelResult  IvrChannelResult
   */
  public void setIvrChannelResult(IvrChannelResult ivrChannelResult) {
    this.ivrChannelResult = ivrChannelResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ivr return id.
   *
   * @param  ivrReturnId  Long
   */
  public void setIvrReturnId(Long ivrReturnId) {
    this.ivrReturnId = ivrReturnId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last state.
   *
   * @param  lastState  String
   */
  public void setLastState(String lastState) {
    this.lastState = lastState;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last state seconds.
   *
   * @param  lastStateSeconds  String
   */
  public void setLastStateSeconds(String lastStateSeconds) {
    this.lastStateSeconds = lastStateSeconds;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for number of attempts.
   *
   * @param  numberOfAttempts  String
   */
  public void setNumberOfAttempts(String numberOfAttempts) {
    this.numberOfAttempts = numberOfAttempts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for payment.
   *
   * @param  payment  Payment
   */
  public void setPayment(Payment payment) {
    this.payment = payment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for payment amount.
   *
   * @param  paymentAmount  BigDecimal
   */
  public void setPaymentAmount(BigDecimal paymentAmount) {
    this.paymentAmount = paymentAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for phone number.
   *
   * @param  phoneNumber  String
   */
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for program index.
   *
   * @param  programIndex  Integer
   */
  public void setProgramIndex(Integer programIndex) {
    this.programIndex = programIndex;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for script id.
   *
   * @param  scriptId  String
   */
  public void setScriptId(String scriptId) {
    this.scriptId = scriptId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for status.
   *
   * @param  status  String
   */
  public void setStatus(String status) {
    this.status = status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for sub campaign.
   *
   * @param  subCampaign  String
   */
  public void setSubCampaign(String subCampaign) {
    this.subCampaign = subCampaign;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for vendor channel result code.
   *
   * @param  vendorChannelResultCode  VendorChannelResultCode
   */
  public void setVendorChannelResultCode(VendorChannelResultCode vendorChannelResultCode) {
    this.vendorChannelResultCode = vendorChannelResultCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for vendor complete date.
   *
   * @param  vendorCompleteDate  Date
   */
  public void setVendorCompleteDate(Date vendorCompleteDate) {
    this.vendorCompleteDate = vendorCompleteDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for vendor receive date.
   *
   * @param  vendorReceiveDate  Date
   */
  public void setVendorReceiveDate(Date vendorReceiveDate) {
    this.vendorReceiveDate = vendorReceiveDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for vendor result code.
   *
   * @param  vendorResultCode  String
   */
  public void setVendorResultCode(String vendorResultCode) {
    this.vendorResultCode = vendorResultCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for voice mail.
   *
   * @param  voiceMail  VoiceMailActivity
   */
  public void setVoiceMail(VoiceMailActivity voiceMail) {
    this.voiceMail = voiceMail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Constructs a <code>String</code> with all attributes in name = value format.
   *
   * @return  a <code>String</code> representation of this object.
   */
  @Override public String toString() {
    final String TAB = "    ";

    String retValue = "";

    retValue = "IvrOutboundAudit ( " + super.toString() + TAB
      + "ivrReturnId = " + this.ivrReturnId + TAB + "scriptId = "
      + this.scriptId + TAB + "vendorReceiveDate = " + this.vendorReceiveDate
      + TAB + "vendorCompleteDate = " + this.vendorCompleteDate + TAB
      + "debtorName = " + this.debtorName + TAB + "debtorName2 = "
      + this.debtorName2 + TAB + "phoneNumber = " + this.phoneNumber + TAB
      + "attemptStartTime = " + this.attemptStartTime + TAB
      + "attemptFinishTime = " + this.attemptFinishTime + TAB
      + "attemptDuration = " + this.attemptDuration + TAB
      + "connectDuration = " + this.connectDuration + TAB + "callAudit = "
      + this.callAudit + TAB + "callResultCode = " + this.callResultCode
      + TAB + "payment = " + this.payment + TAB + "duration = " + TAB
      + "acceptedProgram = " + this.acceptedProgram + TAB + " )";

    return retValue;
  }

} // end class IvrOutboundAudit
