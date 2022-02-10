package com.cmc.credagility.core.domain.channel;


import java.io.Serializable;

import java.util.Date;

import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.contact.ContactPhone;
import com.cmc.credagility.core.domain.customer.Customer;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.domain.twilio.TwilioInboundDetail;
import com.cmc.credagility.core.domain.twilio.TwilioOutboundDetail;
import com.cmc.credagility.core.domain.user.User;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * TODO:
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  01/26/2015 15:13
 */
@Entity
@Table(
  name    = "TelephonyActivity",
  indexes = {
    @Index(
      name = "idx_TelephonyActivity_callSid",
      columnList = "callSid"
    ),
    @Index(
      name = "idx_TelephonyActivity_outboundId",
      columnList = "outboundId"
    ),
    @Index(
      name = "idx_TelephonyActivity_inboundId",
      columnList = "inboundId"
    )
  }
)
public class TelephonyActivity extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

/*
--* * Table * *--
outboundManualCallRequestId long,
phoneNumber String,
phoneId long,
responsibleId long,
accountNum long,
requestUrl String,
requestData String,
status String,
createDate Date,
lastUpdateDate Date
--* * Table * *--
 * */
  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 4149739284317745435L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: */
  @Column(
    name     = "callEndTime",
    length   = 24,
    nullable = true
  )
  public Date callEndTime;

  /** TODO: */
  @Column(
    name     = "callStartTime",
    length   = 24,
    nullable = true
  )
  public Date callStartTime;

  /** TODO: */
  public String phoneNumber;

  /** TODO: */
  @Column(
    name     = "requestData",
    length   = 2048,
    nullable = true
  )
  public String requestData;


  /** TODO: */
  @Column(
    name     = "requestUrl",
    length   = 2048,
    nullable = true
  )
  public String requestUrl;


  /** TODO: */
  @Column(
    name     = "status",
    length   = 24,
    nullable = true
  )
  public String status;

  /** account. */
  @JoinColumn(
    name     = "accountNum",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Account account;

  /** TODO: */
  @JoinColumn(
    name     = "agentId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected User agent;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "callSid",
    length = 50
  )
  protected String callSid;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "callType",
    length = 50
  )
  protected String callType;

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean complianceOverride;


  /** TODO: */
  @JoinColumn(
    name     = "phoneId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected ContactPhone contactPhone;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "customerId",
    insertable = false,
    updatable  = false,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Customer customer;

  /** TODO: DOCUMENT ME! */
  protected Long customerId;

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean dialPadAttempt;

  /** responsible. */
  @JoinColumn(
    name     = "responsibleId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Responsible responsible;

  /** TODO: */
  @Column(
    name     = "telephonyActivityId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long telephonyActivityId;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "inboundId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected TwilioInboundDetail twilioInboundDetail;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "outboundId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected TwilioOutboundDetail twilioOutboundDetail;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
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

    TelephonyActivity that = (TelephonyActivity) o;

    if ((phoneNumber != null) ? (!phoneNumber.equals(that.phoneNumber)) : (that.phoneNumber != null)) {
      return false;
    }

    if ((requestData != null) ? (!requestData.equals(that.requestData)) : (that.requestData != null)) {
      return false;
    }

    if ((requestUrl != null) ? (!requestUrl.equals(that.requestUrl)) : (that.requestUrl != null)) {
      return false;
    }

    if ((status != null) ? (!status.equals(that.status)) : (that.status != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Account.
   *
   * @return  Account.
   */
  public Account getAccount() {
    return account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agent.
   *
   * @return  User
   */
  public User getAgent() {
    return agent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Date.
   *
   * @return  Date.
   */

  public Date getCallEndTime() {
    return callEndTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for call sid.
   *
   * @return  String
   */
  public String getCallSid() {
    return callSid;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Date.
   *
   * @return  Date.
   */

  public Date getCallStartTime() {
    return callStartTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for call type.
   *
   * @return  String
   */
  public String getCallType() {
    return callType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for compliance override.
   *
   * @return  Boolean
   */
  public Boolean getComplianceOverride() {
    return complianceOverride;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * ContactPhone.
   *
   * @return  ContactPhone.
   */
  public ContactPhone getContactPhone() {
    return contactPhone;
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
   * getter method for customer id.
   *
   * @return  Long
   */
  public Long getCustomerId() {
    return customerId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for dial pad attempt.
   *
   * @return  Boolean
   */
  public Boolean getDialPadAttempt() {
    return dialPadAttempt;
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
   * String.
   *
   * @return  String.
   */
  public String getRequestData() {
    return requestData;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getRequestUrl() {
    return requestUrl;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Responsible.
   *
   * @return  Responsible.
   */
  public Responsible getResponsible() {
    return responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getStatus() {
    return status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for telephony activity id.
   *
   * @return  Long
   */
  public Long getTelephonyActivityId() {
    return telephonyActivityId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for twilio inbound detail.
   *
   * @return  TwilioInboundDetail
   */
  public TwilioInboundDetail getTwilioInboundDetail() {
    return twilioInboundDetail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for twilio outbound detail.
   *
   * @return  TwilioOutboundDetail
   */
  public TwilioOutboundDetail getTwilioOutboundDetail() {
    return twilioOutboundDetail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();

    result = (31 * result) + ((phoneNumber != null) ? phoneNumber.hashCode() : 0);
    result = (31 * result) + ((requestUrl != null) ? requestUrl.hashCode() : 0);
    result = (31 * result) + ((requestData != null) ? requestData.hashCode() : 0);
    result = (31 * result) + ((status != null) ? status.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setAccount.
   *
   * @param  account  Account
   */
  public void setAccount(Account account) {
    this.account = account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agent.
   *
   * @param  agent  User
   */
  public void setAgent(User agent) {
    this.agent = agent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setCallEndTime.
   *
   * @param  callEndTime  String
   */

  public void setCallEndTime(Date callEndTime) {
    this.callEndTime = callEndTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for call sid.
   *
   * @param  callSid  String
   */
  public void setCallSid(String callSid) {
    this.callSid = callSid;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for call start time.
   *
   * @param  callStartTime  String
   */
  public void setCallStartTime(Date callStartTime) {
    this.callStartTime = callStartTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for call type.
   *
   * @param  callType  String
   */
  public void setCallType(String callType) {
    this.callType = callType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for compliance override.
   *
   * @param  complianceOverride  Boolean
   */
  public void setComplianceOverride(Boolean complianceOverride) {
    this.complianceOverride = complianceOverride;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setContactPhone.
   *
   * @param  contactPhone  ContactPhone
   */
  public void setContactPhone(ContactPhone contactPhone) {
    this.contactPhone = contactPhone;
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
   * setter method for customer id.
   *
   * @param  customerId  Long
   */
  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for dial pad attempt.
   *
   * @param  dialPadAttempt  Boolean
   */
  public void setDialPadAttempt(Boolean dialPadAttempt) {
    this.dialPadAttempt = dialPadAttempt;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setPhoneNumber.
   *
   * @param  phoneNumber  String
   */
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setRequestData.
   *
   * @param  requestData  String
   */
  public void setRequestData(String requestData) {
    this.requestData = requestData;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setRequestUrl.
   *
   * @param  requestUrl  String
   */
  public void setRequestUrl(String requestUrl) {
    this.requestUrl = requestUrl;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setResponsible.
   *
   * @param  responsible  Responsible
   */
  public void setResponsible(Responsible responsible) {
    this.responsible = responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setStatus.
   *
   * @param  status  String
   */
  public void setStatus(String status) {
    this.status = status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for telephony activity id.
   *
   * @param  telephonyActivityId  Long
   */
  public void setTelephonyActivityId(Long telephonyActivityId) {
    this.telephonyActivityId = telephonyActivityId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for twilio inbound detail.
   *
   * @param  twilioInboundDetail  TwilioInboundDetail
   */
  public void setTwilioInboundDetail(TwilioInboundDetail twilioInboundDetail) {
    this.twilioInboundDetail = twilioInboundDetail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for twilio outbound detail.
   *
   * @param  twilioOutboundDetail  TwilioOutboundDetail
   */
  public void setTwilioOutboundDetail(TwilioOutboundDetail twilioOutboundDetail) {
    this.twilioOutboundDetail = twilioOutboundDetail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#toString()
   */
  @Override public String toString() {
    return "OutboundManualCallRequest{"
      + "telephonyActivityId=" + telephonyActivityId
      + ", phoneNumber='" + phoneNumber + '\''
      + ", contactPhone=" + contactPhone
      + ", responsible=" + responsible
      + ", account=" + account
      + ", requestUrl='" + requestUrl + '\''
      + ", requestData='" + requestData + '\''
      + ", status='" + status + '\''
      + ", agent='" + agent + '\''
      + ", callStartTime='" + callStartTime + '\''
      + ", callEndTime='" + callEndTime + '\''
      + '}';
  }
} // end class TelephonyActivity
