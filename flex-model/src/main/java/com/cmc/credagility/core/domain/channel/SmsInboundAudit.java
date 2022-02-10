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
import org.hibernate.annotations.Cascade;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/14/2014 17:24
 */
@Entity
@Table(name = "SmsInboundAudit")
public class SmsInboundAudit extends BaseContactAudit {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -5796552017876255995L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "phoneId",
    updatable = true,
    nullable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected ContactPhone contactPhone;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "deviceDNC",
    columnDefinition = "char",
    length           = 1
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
    name   = "incomingMessage",
    length = 255
  )
  protected String incomingMessage;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "lastState",
    length = 255
  )
  protected String lastState;

  /** TODO: DOCUMENT ME! */
  @Column(name = "lastStatusUpdateDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date lastStatusUpdateDate;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "messageReference",
    length = 250
  )
  protected String messageReference;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "outgoingMessage",
    length = 255
  )
  protected String outgoingMessage;

  /** TODO: DOCUMENT ME! */
  @Column(name = "receivedDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date receivedDate;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "smsActualResultId",
    updatable = false,
    nullable  = true
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  protected SmsChannelActualResult smsChannelActualResult;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "smsResultId",
    updatable = false,
    nullable  = true
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  protected SmsChannelResult smsChannelResult;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "smsInboundAuditId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long smsInboundAuditId;

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

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "timeZone",
    length = 255
  )
  protected String timeZone;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "toPhoneNumber",
    length = 20
  )
  protected String toPhoneNumber;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "vendorResultCodeId")
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  protected VendorChannelResultCode vendorChannelResultCode;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "vendorResultCode",
    length = 100
  )
  protected String vendorResultCode;


  /** DOCUMENT ME! */
  @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
  @JoinColumn(
          name      = "smsKeywordId",
          updatable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected SmsKeyword smsKeyword;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * equals.
   *
   * @param   o  Object
   *
   * @return  boolean
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

    SmsInboundAudit that = (SmsInboundAudit) o;

    if (deviceDNC != that.deviceDNC) {
      return false;
    }

    if ((contactPhone != null) ? (!contactPhone.equals(that.contactPhone)) : (that.contactPhone != null)) {
      return false;
    }

    if ((deviceLocale != null) ? (!deviceLocale.equals(that.deviceLocale)) : (that.deviceLocale != null)) {
      return false;
    }

    if ((lastState != null) ? (!lastState.equals(that.lastState)) : (that.lastState != null)) {
      return false;
    }

    if ((lastStatusUpdateDate != null) ? (!lastStatusUpdateDate.equals(that.lastStatusUpdateDate))
                                       : (that.lastStatusUpdateDate != null)) {
      return false;
    }

    if ((messageReference != null) ? (!messageReference.equals(that.messageReference))
                                   : (that.messageReference != null)) {
      return false;
    }

    if ((fromPhoneNumber != null) ? (!fromPhoneNumber.equals(that.fromPhoneNumber)) : (that.fromPhoneNumber != null)) {
      return false;
    }

    if ((toPhoneNumber != null) ? (!toPhoneNumber.equals(that.toPhoneNumber)) : (that.toPhoneNumber != null)) {
      return false;
    }

    if ((receivedDate != null) ? (!receivedDate.equals(that.receivedDate)) : (that.receivedDate != null)) {
      return false;
    }

    if ((smsChannelActualResult != null) ? (!smsChannelActualResult.equals(that.smsChannelActualResult))
                                         : (that.smsChannelActualResult != null)) {
      return false;
    }

    if ((smsChannelResult != null) ? (!smsChannelResult.equals(that.smsChannelResult))
                                   : (that.smsChannelResult != null)) {
      return false;
    }

    if ((smsResultCode != null) ? (!smsResultCode.equals(that.smsResultCode)) : (that.smsResultCode != null)) {
      return false;
    }

    if ((timeZone != null) ? (!timeZone.equals(that.timeZone)) : (that.timeZone != null)) {
      return false;
    }

    if ((vendorChannelResultCode != null) ? (!vendorChannelResultCode.equals(that.vendorChannelResultCode))
                                          : (that.vendorChannelResultCode != null)) {
      return false;
    }

    if ((vendorResultCode != null) ? (!vendorResultCode.equals(that.vendorResultCode))
                                   : (that.vendorResultCode != null)) {
      return false;
    }

    return true;
  } // end method equals

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
   * getter method for device locale.
   *
   * @return  String
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
   * getter method for incoming message.
   *
   * @return  String
   */
  public String getIncomingMessage() {
    return incomingMessage;
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
   * getter method for last status update date.
   *
   * @return  Date
   */
  public Date getLastStatusUpdateDate() {
    return lastStatusUpdateDate;
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
   * getter method for received date.
   *
   * @return  Date
   */
  public Date getReceivedDate() {
    return receivedDate;
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
   * getter method for sms channel result.
   *
   * @return  SmsChannelResult
   */
  public SmsChannelResult getSmsChannelResult() {
    return smsChannelResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for sms result code.
   *
   * @return  SmsResultCodeType
   */
  public SmsResultCodeType getSmsResultCode() {
    return smsResultCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for time zone.
   *
   * @return  String
   */
  public String getTimeZone() {
    return timeZone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for to phone number.
   *
   * @return  String
   */
  public String getToPhoneNumber() {
    return toPhoneNumber;
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
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((contactPhone != null) ? contactPhone.hashCode() : 0);
    result = (31 * result) + (deviceDNC ? 1 : 0);
    result = (31 * result) + ((deviceLocale != null) ? deviceLocale.hashCode() : 0);
    result = (31 * result) + ((lastState != null) ? lastState.hashCode() : 0);
    result = (31 * result) + ((lastStatusUpdateDate != null) ? lastStatusUpdateDate.hashCode() : 0);
    result = (31 * result) + ((messageReference != null) ? messageReference.hashCode() : 0);
    result = (31 * result) + ((fromPhoneNumber != null) ? fromPhoneNumber.hashCode() : 0);
    result = (31 * result) + ((toPhoneNumber != null) ? toPhoneNumber.hashCode() : 0);
    result = (31 * result) + ((receivedDate != null) ? receivedDate.hashCode() : 0);
    result = (31 * result) + ((smsChannelActualResult != null) ? smsChannelActualResult.hashCode() : 0);
    result = (31 * result) + ((smsChannelResult != null) ? smsChannelResult.hashCode() : 0);
    result = (31 * result) + ((smsResultCode != null) ? smsResultCode.hashCode() : 0);
    result = (31 * result) + ((timeZone != null) ? timeZone.hashCode() : 0);
    result = (31 * result) + ((vendorChannelResultCode != null) ? vendorChannelResultCode.hashCode() : 0);
    result = (31 * result) + ((vendorResultCode != null) ? vendorResultCode.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for device DNC.
   *
   * @return  Boolean
   */
  public Boolean isDeviceDNC() {
    if (deviceDNC == null) {
      return Boolean.FALSE;
    }

    return deviceDNC;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  contactPhone  DOCUMENT ME!
   */
  public void setContactPhone(ContactPhone contactPhone) {
    this.contactPhone = contactPhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  deviceDNC  DOCUMENT ME!
   */
  public void setDeviceDNC(Boolean deviceDNC) {
    this.deviceDNC = deviceDNC;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  deviceLocale  DOCUMENT ME!
   */
  public void setDeviceLocale(String deviceLocale) {
    this.deviceLocale = deviceLocale;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  fromPhoneNumber  DOCUMENT ME!
   */
  public void setFromPhoneNumber(String fromPhoneNumber) {
    this.fromPhoneNumber = fromPhoneNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  incomingMessage  DOCUMENT ME!
   */
  public void setIncomingMessage(String incomingMessage) {
    this.incomingMessage = incomingMessage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  lastState  DOCUMENT ME!
   */
  public void setLastState(String lastState) {
    this.lastState = lastState;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  lastStatusUpdateDate  DOCUMENT ME!
   */
  public void setLastStatusUpdateDate(Date lastStatusUpdateDate) {
    this.lastStatusUpdateDate = lastStatusUpdateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  messageReference  DOCUMENT ME!
   */
  public void setMessageReference(String messageReference) {
    this.messageReference = messageReference;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  outgoingMessage  DOCUMENT ME!
   */
  public void setOutgoingMessage(String outgoingMessage) {
    this.outgoingMessage = outgoingMessage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  receivedDate  DOCUMENT ME!
   */
  public void setReceivedDate(Date receivedDate) {
    this.receivedDate = receivedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  smsChannelActualResult  DOCUMENT ME!
   */
  public void setSmsChannelActualResult(SmsChannelActualResult smsChannelActualResult) {
    this.smsChannelActualResult = smsChannelActualResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  smsChannelResult  DOCUMENT ME!
   */
  public void setSmsChannelResult(SmsChannelResult smsChannelResult) {
    this.smsChannelResult = smsChannelResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  smsResultCode  DOCUMENT ME!
   */
  public void setSmsResultCode(SmsResultCodeType smsResultCode) {
    this.smsResultCode = smsResultCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  timeZone  DOCUMENT ME!
   */
  public void setTimeZone(String timeZone) {
    this.timeZone = timeZone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  toPhoneNumber  DOCUMENT ME!
   */
  public void setToPhoneNumber(String toPhoneNumber) {
    this.toPhoneNumber = toPhoneNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  vendorChannelResultCode  DOCUMENT ME!
   */
  public void setVendorChannelResultCode(VendorChannelResultCode vendorChannelResultCode) {
    this.vendorChannelResultCode = vendorChannelResultCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  vendorResultCode  DOCUMENT ME!
   */
  public void setVendorResultCode(String vendorResultCode) {
    this.vendorResultCode = vendorResultCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * toString.
   *
   * @return  String
   */
  @Override public String toString() {
    return "SmsInboundAudit{"
      + ", deviceDNC=" + deviceDNC
      + ", deviceLocale='" + deviceLocale + '\''
      + ", lastState='" + lastState + '\''
      + ", lastStatusUpdateDate=" + lastStatusUpdateDate
      + ", messageReference='" + messageReference + '\''
      + ", fromPhoneNumber='" + fromPhoneNumber + '\''
      + ", toPhoneNumber='" + toPhoneNumber + '\''
      + ", receivedDate=" + receivedDate
      + ", smsResultCode=" + smsResultCode
      + ", timeZone='" + timeZone + '\''
      + '}';
  }
} // end class SmsInboundAudit
