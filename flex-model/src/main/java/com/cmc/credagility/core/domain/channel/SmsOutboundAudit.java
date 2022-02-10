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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.contact.BaseContactAudit;
import com.cmc.credagility.core.domain.contact.ContactPhone;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * This class is used to store Sms channel return information.
 *
 * <p><a href="SmsOutboundAudit.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/14/2014 17:14
 */
@Entity
@Table(name = "SmsOutboundAudit")
public class SmsOutboundAudit extends BaseContactAudit {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -1574185027854694871L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Import batch job Id. */
  @Column(name = "batchId")
  protected Long batchId;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "bestContact",
    length = 255
  )
  protected String bestContact;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "callPass",
    length = 255
  )
  protected String callPass;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "callSeconds",
    length = 255
  )
  protected String callSeconds;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "phoneId",
    updatable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected ContactPhone contactPhone;


  /** TODO: DOCUMENT ME! */
  @Column(name = "deliveryDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date deliveryDate;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "deviceDNC",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean deviceDNC;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "deviceLocale",
    length = 255
  )
  protected String deviceLocale;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "fromPhoneNumber",
    length = 20
  )
  protected String fromPhoneNumber;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "lastState",
    length = 255
  )
  protected String lastState;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String lastStateSeconds;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "messageReference",
    length = 50
  )
  protected String messageReference;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "outgoingMessage",
    length = 255
  )
  protected String outgoingMessage;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "phoneNumber",
    length = 20
  )
  protected String phoneNumber;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "scriptId",
    length = 255
  )
  protected String scriptId;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "smsActualResultId",
    updatable = false
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  protected SmsChannelActualResult smsChannelActualResult;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "smsResultId",
    updatable = false
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  protected SmsChannelResult smsChannelResult;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "typeId",
    updatable = true
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  protected SmsResultCodeType smsResultCode;


  // npelleti, 07/30, USBank, Removed unique constraint
  /** Return Id, PK. */
  @Column(
    name     = "smsReturnId",

    // unique   = true,
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long smsReturnId;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "subCampaign",
    length = 255
  )
  protected String subCampaign;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "timeZone",
    length = 255
  )
  protected String timeZone;

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
    length = 100
  )
  protected String vendorResultCode;

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

    if (!super.equals(obj)) {
      return false;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    final SmsOutboundAudit other = (SmsOutboundAudit) obj;

    if (smsResultCode == null) {
      if (other.smsResultCode != null) {
        return false;
      }
    } else if (!smsResultCode.equals(other.smsResultCode)) {
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

    if (messageReference == null) {
      if (other.messageReference != null) {
        return false;
      }
    } else if (!messageReference.equals(other.messageReference)) {
      return false;
    }

    if ((smsChannelActualResult != null) ? (!smsChannelActualResult.equals(other.smsChannelActualResult))
                                         : (other.smsChannelActualResult != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The batchId.
   *
   * @return  the batchId
   *
   *          <p>not-null = "false"</p>
   */
  public Long getBatchId() {
    return this.batchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BestContact.
   *
   * @return  bestContact.
   */
  public String getBestContact() {
    return bestContact;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Call Pass.
   *
   * @return  call Pass.
   */
  public String getCallPass() {
    return callPass;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The callSeconds.
   *
   * @return  the callSeconds
   */
  public String getCallSeconds() {
    return callSeconds;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getContactPhone.
   *
   * @return  ContactPhone
   *
   *          <p>lazy = "proxy" column = "phoneId" not-null = "false" class = "com.cmc.credagility.ContactPhone" insert
   *          = "true" update = "true"</p>
   */
  public ContactPhone getContactPhone() {
    return contactPhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The deliveryDate.
   *
   * @return  the deliveryDate
   */
  public Date getDeliveryDate() {
    return deliveryDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The deviceLocale.
   *
   * @return  the deviceLocale
   */
  public String getDeviceLocale() {
    return deviceLocale;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for from phone number.
   *
   * @return  String
   */
  public String getFromPhoneNumber() {
    return fromPhoneNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The lastState.
   *
   * @return  the lastState
   */
  public String getLastState() {
    return lastState;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The lastStateSeconds.
   *
   * @return  the lastStateSeconds
   */
  public String getLastStateSeconds() {
    return lastStateSeconds;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for message reference.
   *
   * @return  String
   */
  public String getMessageReference() {
    return messageReference;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for outgoing message.
   *
   * @return  String
   */
  public String getOutgoingMessage() {
    return outgoingMessage;
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
   * Sms Script Id.
   *
   * @return  sms Script Id.
   */
  public String getScriptId() {
    return scriptId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for sms channel actual result.
   *
   * @return  SmsChannelActualResult
   */
  public SmsChannelActualResult getSmsChannelActualResult() {
    return smsChannelActualResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The smsChannelResult.
   *
   * @return  the smsChannelResult
   *
   *          <p>lazy = "proxy" column = "smsResultId" not-null = "false" class = "com.cmc.credagility.SmsChannelResult"
   *          insert = "true" update = "false" cascade = "save-update"</p>
   */
  public SmsChannelResult getSmsChannelResult() {
    return this.smsChannelResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getSmsResultCode.
   *
   * @return  SmsResultCodeType
   *
   *          <p>column = "typeId" not-null = "false" class = "com.cmc.credagility.SmsResultCodeType" insert = "true"
   *          update = "true" cascade = "all"</p>
   */
  public SmsResultCodeType getSmsResultCode() {
    return smsResultCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Primary key.
   *
   * @return  primary key.
   *
   *          <p>generator-class = "native" unsaved-value = "null"</p>
   */
  public Long getSmsReturnId() {
    return smsReturnId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The subCampaign.
   *
   * @return  the subCampaign
   */
  public String getSubCampaign() {
    return subCampaign;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The timeZone.
   *
   * @return  the timeZone
   */
  public String getTimeZone() {
    return timeZone;
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
   * @see  com.cmc.credagility.core.domain.contact.BaseContactAudit#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = super.hashCode();
    result = (prime * result)
      + ((smsResultCode == null) ? 0 : smsResultCode.hashCode());
    result = (prime * result)
      + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
    result = (prime * result)
      + ((scriptId == null) ? 0 : scriptId.hashCode());
    result = (prime
        * result)
      + ((vendorCompleteDate == null) ? 0 : vendorCompleteDate.hashCode());
    result = (prime
        * result)
      + ((vendorReceiveDate == null) ? 0 : vendorReceiveDate.hashCode());
    result = (31 * result) + ((smsChannelActualResult != null) ? smsChannelActualResult.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The deviceDNC.
   *
   * @return  the deviceDNC
   */
  public Boolean isDeviceDNC() {
    if (deviceDNC == null) {
      return Boolean.FALSE;
    }

    return deviceDNC;
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
   * setter method for best contact.
   *
   * @param  bestContact  String
   */
  public void setBestContact(String bestContact) {
    this.bestContact = bestContact;
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
   * @param  callResultCode  SmsResultCodeType
   */
  public void setCallResultCode(SmsResultCodeType callResultCode) {
    this.smsResultCode = callResultCode;
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
   * setter method for contact phone.
   *
   * @param  contactPhone  ContactPhone
   */
  public void setContactPhone(ContactPhone contactPhone) {
    this.contactPhone = contactPhone;
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
   * setter method for device DNC.
   *
   * @param  deviceDNC  Boolean
   */
  public void setDeviceDNC(Boolean deviceDNC) {
    this.deviceDNC = deviceDNC;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for device locale.
   *
   * @param  deviceLocale  String
   */
  public void setDeviceLocale(String deviceLocale) {
    this.deviceLocale = deviceLocale;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for from phone number.
   *
   * @param  fromPhoneNumber  String
   */
  public void setFromPhoneNumber(String fromPhoneNumber) {
    this.fromPhoneNumber = fromPhoneNumber;
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
   * setter method for message reference.
   *
   * @param  messageReference  String
   */
  public void setMessageReference(String messageReference) {
    this.messageReference = messageReference;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for outgoing message.
   *
   * @param  outgoingMessage  String
   */
  public void setOutgoingMessage(String outgoingMessage) {
    this.outgoingMessage = outgoingMessage;
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
   * setter method for script id.
   *
   * @param  scriptId  String
   */
  public void setScriptId(String scriptId) {
    this.scriptId = scriptId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for sms channel actual result.
   *
   * @param  smsChannelActualResult  SmsChannelActualResult
   */
  public void setSmsChannelActualResult(SmsChannelActualResult smsChannelActualResult) {
    this.smsChannelActualResult = smsChannelActualResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for sms channel result.
   *
   * @param  smsChannelResult  SmsChannelResult
   */
  public void setSmsChannelResult(SmsChannelResult smsChannelResult) {
    this.smsChannelResult = smsChannelResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for smsr channel result.
   *
   * @param  smsChannelResult  SmsChannelResult
   */
  public void setSmsrChannelResult(SmsChannelResult smsChannelResult) {
    this.smsChannelResult = smsChannelResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for sms result code.
   *
   * @param  smsResultCode  SmsResultCodeType
   */
  public void setSmsResultCode(SmsResultCodeType smsResultCode) {
    this.smsResultCode = smsResultCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for sms return id.
   *
   * @param  smsReturnId  Long
   */
  public void setSmsReturnId(Long smsReturnId) {
    this.smsReturnId = smsReturnId;
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
   * setter method for time zone.
   *
   * @param  timeZone  String
   */
  public void setTimeZone(String timeZone) {
    this.timeZone = timeZone;
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
   * Constructs a <code>String</code> with all attributes in name = value format.
   *
   * @return  a <code>String</code> representation of this object.
   */
  @Override public String toString() {
    final String TAB = "    ";

    String retValue = "";

    retValue = "SmsOutboundAudit ( " + super.toString() + TAB
      + "smsReturnId = " + this.smsReturnId + TAB + "scriptId = "
      + this.scriptId + TAB + "vendorReceiveDate = "
      + this.vendorReceiveDate + TAB + "vendorCompleteDate = "
      + this.vendorCompleteDate + TAB + "phoneNumber = "
      + this.phoneNumber + TAB + "smsChannelActualResult = "
      + this.smsChannelActualResult + TAB + "smsResultCode = "
      + this.smsResultCode + TAB + " )";

    return retValue;
  }

} // end class SmsOutboundAudit
