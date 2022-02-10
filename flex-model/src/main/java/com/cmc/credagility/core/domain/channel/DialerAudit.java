package com.cmc.credagility.core.domain.channel;

import java.util.Date;

import javax.persistence.CascadeType;
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

import com.cmc.credagility.core.domain.contact.BaseContactAudit;
import com.cmc.credagility.core.domain.contact.ContactPhone;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * This class is used to store ivr channel return information.
 *
 * <p><a href="DialerAudit.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/15/2014 14:20
 */
@Entity
@Table(
  name    = "DialerAudit",
  indexes =
    @Index(
      name = "",
      columnList = "recoveryKey"
    )
)
public class DialerAudit extends BaseContactAudit {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -1554185027854694871L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "agentActionCode",
    length = 2
  )
  protected String agentActionCode;


  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "agentConnected",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean agentConnected;


  /** agent. */
  @Column(
    name   = "agentId",
    length = 60
  )
  protected String agentId;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "agentResultCode",
    length = 3
  )
  protected String agentResultCode;


  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "answerMachine",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean answerMachine;


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
    name       = "resultCodeId",
    insertable = true,
    updatable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected IvrResultCodeType callResultCode;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "callSeconds",
    length = 20
  )
  protected String callSeconds;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "campaignNumber",
    length = 100
  )
  protected String campaignNumber;


  /** TODO: DOCUMENT ME! */
  @Column(name = "connectDuration")
  protected Integer connectDuration;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "phoneId",
    insertable = true,
    updatable  = false
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

  // npelleti, 07/30, USBank, Removed unique constraint
  /** Return Id, PK. */
  @Column(
    name     = "dialerAuditId",

    /*unique   = true,*/
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long dialerAuditId;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "dialerResultId",
    insertable = true,
    updatable  = false
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  protected DialerChannelResult dialerChannelResult;


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


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "phoneNumber",
    length = 20
  )
  protected String phoneNumber;


  /** TODO: DOCUMENT ME! */
  @Column(name = "recoveryKey")
  protected Long recoveryKey;


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
// CascadeType.SAVE_UPDATE
  @JoinColumn(name = "vendorResultCodeId")
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  protected VendorChannelResultCode vendorChannelResultCode;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "vendorResultCode",
    length = 150
  )
  protected String vendorResultCode;

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

    final DialerAudit other = (DialerAudit) obj;

    if (agentConnected == null) {
      if (other.agentConnected != null) {
        return false;
      }
    } else if (!agentConnected.equals(other.agentConnected)) {
      return false;
    }

    if (answerMachine == null) {
      if (other.answerMachine != null) {
        return false;
      }
    } else if (!answerMachine.equals(other.answerMachine)) {
      return false;
    }

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

    if (batchId == null) {
      if (other.batchId != null) {
        return false;
      }
    } else if (!batchId.equals(other.batchId)) {
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

    if (contactPhone == null) {
      if (other.contactPhone != null) {
        return false;
      }
    } else if (!contactPhone.equals(other.contactPhone)) {
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

    if (dialerChannelResult == null) {
      if (other.dialerChannelResult != null) {
        return false;
      }
    } else if (!dialerChannelResult.equals(other.dialerChannelResult)) {
      return false;
    }

    if (phoneNumber == null) {
      if (other.phoneNumber != null) {
        return false;
      }
    } else if (!phoneNumber.equals(other.phoneNumber)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agent action code.
   *
   * @return  String
   */
  public String getAgentActionCode() {
    return agentActionCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agent connected.
   *
   * @return  Boolean
   */
  public Boolean getAgentConnected() {
    return agentConnected;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agent id.
   *
   * @return  String
   */
  public String getAgentId() {
    return agentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agent result code.
   *
   * @return  String
   */
  public String getAgentResultCode() {
    return agentResultCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for answer machine.
   *
   * @return  Boolean
   */
  public Boolean getAnswerMachine() {
    return answerMachine;
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
   * getter method for call result code.
   *
   * @return  IvrResultCodeType
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
   * getter method for campaign number.
   *
   * @return  String
   */
  public String getCampaignNumber() {
    return campaignNumber;
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
   * getter method for contact phone.
   *
   * @return  ContactPhone
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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   *          <p>length = "100"</p>
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
   * Primary key.
   *
   * @return  primary key.
   *
   *          <p>generator-class = "native" unsaved-value = "null"</p>
   */
  public Long getDialerAuditId() {
    return dialerAuditId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The dialerChannelResult.
   *
   * @return  the dialerChannelResult
   *
   *          <p>lazy = "proxy" column = "dialerResultId" not-null = "false" class =
   *          "com.cmc.credagility.DialerChannelResult" insert = "true" update = "false" cascade = "save-update"</p>
   */
  public DialerChannelResult getDialerChannelResult() {
    return this.dialerChannelResult;
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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   *          <p>length = "20"</p>
   */
  public String getPhoneNumber() {
    return phoneNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for recovery key.
   *
   * @return  Long
   */
  public Long getRecoveryKey() {
    return recoveryKey;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for script id.
   *
   * @return  String
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
   * getter method for vendor result code.
   *
   * @return  String
   */
  public String getVendorResultCode() {
    return vendorResultCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.contact.BaseContactAudit#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = super.hashCode();
    result = (prime * result)
      + ((agentConnected == null) ? 0 : agentConnected.hashCode());
    result = (prime * result)
      + ((answerMachine == null) ? 0 : answerMachine.hashCode());
    result = (prime * result)
      + ((attemptDuration == null) ? 0 : attemptDuration.hashCode());
    result = (prime * result)
      + ((attemptFinishTime == null) ? 0 : attemptFinishTime.hashCode());
    result = (prime * result)
      + ((attemptStartTime == null) ? 0 : attemptStartTime.hashCode());
    result = (prime * result) + ((batchId == null) ? 0 : batchId.hashCode());
    result = (prime * result)
      + ((callResultCode == null) ? 0 : callResultCode.hashCode());
    result = (prime * result)
      + ((connectDuration == null) ? 0 : connectDuration.hashCode());
    result = (prime * result)
      + ((contactPhone == null) ? 0 : contactPhone.hashCode());
    result = (prime * result)
      + ((debtorName == null) ? 0 : debtorName.hashCode());
    result = (prime * result)
      + ((debtorName2 == null) ? 0 : debtorName2.hashCode());
    result = (prime * result)
      + ((dialerChannelResult == null) ? 0 : dialerChannelResult.hashCode());
    result = (prime * result)
      + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());

    return result;
  } // end method hashCode

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agent action code.
   *
   * @param  agentActionCode  String
   */
  public void setAgentActionCode(String agentActionCode) {
    this.agentActionCode = agentActionCode;
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
   * setter method for agent id.
   *
   * @param  agentId  String
   */
  public void setAgentId(String agentId) {
    this.agentId = agentId;
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
   * setter method for answer machine.
   *
   * @param  answerMachine  Boolean
   */
  public void setAnswerMachine(Boolean answerMachine) {
    this.answerMachine = answerMachine;
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
   * setter method for campaign number.
   *
   * @param  campaignNumber  String
   */
  public void setCampaignNumber(String campaignNumber) {
    this.campaignNumber = campaignNumber;
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
   * setter method for dialer audit id.
   *
   * @param  ivrReturnId  Long
   */
  public void setDialerAuditId(Long ivrReturnId) {
    this.dialerAuditId = ivrReturnId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for dialer channel result.
   *
   * @param  dialerChannelResult  DialerChannelResult
   */
  public void setDialerChannelResult(DialerChannelResult dialerChannelResult) {
    this.dialerChannelResult = dialerChannelResult;
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
   * setter method for phone number.
   *
   * @param  phoneNumber  String
   */
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for recovery key.
   *
   * @param  recoveryKey  Long
   */
  public void setRecoveryKey(Long recoveryKey) {
    this.recoveryKey = recoveryKey;
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
   * setter method for vendor result code.
   *
   * @param  vendorResultCode  String
   */
  public void setVendorResultCode(String vendorResultCode) {
    this.vendorResultCode = vendorResultCode;
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

    retValue = "DialerAudit ( " + super.toString() + TAB + "dialerReturnId = "
      + this.dialerAuditId + TAB + "debtorName = " + this.debtorName + TAB
      + "debtorName2 = " + this.debtorName2 + TAB + "phoneNumber = "
      + this.phoneNumber + TAB + "attemptStartTime = "
      + this.attemptStartTime + TAB + "attemptFinishTime = "
      + this.attemptFinishTime + TAB + "attemptDuration = "
      + this.attemptDuration + TAB + "connectDuration = "
      + this.connectDuration + TAB + "callResultCode = "
      + this.callResultCode + TAB + "duration = " + TAB + " )";

    return retValue;
  }
} // end class DialerAudit
