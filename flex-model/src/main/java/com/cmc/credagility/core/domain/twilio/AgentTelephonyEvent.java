package com.cmc.credagility.core.domain.twilio;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.customer.Customer;
import com.cmc.credagility.core.domain.user.User;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/15/2014 15:06
 */
@Entity
@Table(
  name    = "AgentTelephonyEvent",
  indexes = {
    @Index(
      name = "idx_AgentTelephonyEvent_customerCallSid",
      columnList = "customerCallSid"
    ),
    @Index(
      name = "idx_AgentTelephonyEvent_eventDate",
      columnList = "eventDate"
    ),
    @Index(
      name = "idx_AgentTelephonyEvent_eventName",
      columnList = "eventName"
    ),
    @Index(
      name = "idx_AgentTelephonyEvent_notReadyReasonId",
      columnList = "notReadyReasonId"
    ),
    @Index(
      name = "idx_AgentTelephonyEvent_createDate",
      columnList = "createDate"
    )
  }
)
public class AgentTelephonyEvent extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 4983471376283893962L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  protected Long accountNum;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "agentId",
    insertable = false,
    updatable  = false,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected User agent;


  /** TODO: DOCUMENT ME! */
  protected Long agentId;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String callStatus;

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
  @Column(length = 255)
  protected String customerCallSid;

  /** TODO: DOCUMENT ME! */
  @Column(length = 10)
  @Enumerated(EnumType.STRING)
  protected EventCallType customerCallType;

  /** TODO: DOCUMENT ME! */
  protected Long customerId;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String customerPhoneNumber;


  /** TODO: DOCUMENT ME! */
  protected Date eventDate;


  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = false,
    length   = 32
  )
  @Enumerated(EnumType.STRING)
  protected TelephonyEventName eventName;


  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;


  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean isDialPad;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "notReadyReasonId",
    insertable = false,
    updatable  = false,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected TwilioNotReadyReason notReadyReason;


  /** TODO: DOCUMENT ME! */
  protected Long notReadyReasonId;


  /** TODO: DOCUMENT ME! */
  protected Long responsibleId;


  /** TODO: DOCUMENT ME! */
  protected Long statusDuration;


  /** TODO: DOCUMENT ME! */
  protected Date statusEntryTime;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String statusName;


  /** TODO: DOCUMENT ME! */
  protected Long wrapUpTime;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new AgentTelephonyEvent object.
   */
  public AgentTelephonyEvent() { }

  /**
   * Creates a new AgentTelephonyEvent object.
   *
   * @param  accountNum           DOCUMENT ME!
   * @param  agent                DOCUMENT ME!
   * @param  agentId              DOCUMENT ME!
   * @param  callStatus           DOCUMENT ME!
   * @param  createDate           DOCUMENT ME!
   * @param  customerCallSid      DOCUMENT ME!
   * @param  customerCallType     DOCUMENT ME!
   * @param  customerPhoneNumber  DOCUMENT ME!
   * @param  eventDate            DOCUMENT ME!
   * @param  eventName            DOCUMENT ME!
   * @param  dialPad              DOCUMENT ME!
   * @param  notReadyReason       DOCUMENT ME!
   * @param  notReadyReasonId     DOCUMENT ME!
   * @param  responsibleId        DOCUMENT ME!
   */
  public AgentTelephonyEvent(Long accountNum, User agent, Long agentId, String callStatus, Date createDate,
    String customerCallSid, EventCallType customerCallType, String customerPhoneNumber, Date eventDate,
    TelephonyEventName eventName, Boolean dialPad, TwilioNotReadyReason notReadyReason, Long notReadyReasonId,
    Long responsibleId) {
    this.accountNum          = accountNum;
    this.agent               = agent;
    this.agentId             = agentId;
    this.callStatus          = callStatus;
    this.createDate          = createDate;
    this.customerCallSid     = customerCallSid;
    this.customerCallType    = customerCallType;
    this.customerPhoneNumber = customerPhoneNumber;
    this.eventDate           = eventDate;
    this.eventName           = eventName;
    isDialPad                = dialPad;
    this.notReadyReason      = notReadyReason;
    this.notReadyReasonId    = notReadyReasonId;
    this.responsibleId       = responsibleId;
  }

  /**
   * Creates a new AgentTelephonyEvent object.
   *
   * @param  accountNum           DOCUMENT ME!
   * @param  agent                DOCUMENT ME!
   * @param  agentId              DOCUMENT ME!
   * @param  callStatus           DOCUMENT ME!
   * @param  createDate           DOCUMENT ME!
   * @param  customerCallSid      DOCUMENT ME!
   * @param  customerCallType     DOCUMENT ME!
   * @param  customerPhoneNumber  DOCUMENT ME!
   * @param  eventDate            DOCUMENT ME!
   * @param  eventName            DOCUMENT ME!
   * @param  dialPad              DOCUMENT ME!
   * @param  notReadyReason       DOCUMENT ME!
   * @param  notReadyReasonId     DOCUMENT ME!
   * @param  responsibleId        DOCUMENT ME!
   * @param  statusEntryTime      DOCUMENT ME!
   * @param  statusName           DOCUMENT ME!
   * @param  wrapUpTime           DOCUMENT ME!
   */
  public AgentTelephonyEvent(Long accountNum, User agent, Long agentId, String callStatus, Date createDate,
    String customerCallSid, EventCallType customerCallType, String customerPhoneNumber, Date eventDate,
    TelephonyEventName eventName, Boolean dialPad, TwilioNotReadyReason notReadyReason, Long notReadyReasonId,
    Long responsibleId, Date statusEntryTime, String statusName, Long wrapUpTime) {
    this.accountNum          = accountNum;
    this.agent               = agent;
    this.agentId             = agentId;
    this.callStatus          = callStatus;
    this.createDate          = createDate;
    this.customerCallSid     = customerCallSid;
    this.customerCallType    = customerCallType;
    this.customerPhoneNumber = customerPhoneNumber;
    this.eventDate           = eventDate;
    this.eventName           = eventName;
    isDialPad                = dialPad;
    this.notReadyReason      = notReadyReason;
    this.notReadyReasonId    = notReadyReasonId;
    this.responsibleId       = responsibleId;
    this.statusEntryTime     = statusEntryTime;
    this.statusName          = statusName;
    this.wrapUpTime          = wrapUpTime;
  }

  /**
   * Creates a new AgentTelephonyEvent object.
   *
   * @param  accountNum           DOCUMENT ME!
   * @param  agent                DOCUMENT ME!
   * @param  agentId              DOCUMENT ME!
   * @param  callStatus           DOCUMENT ME!
   * @param  createDate           DOCUMENT ME!
   * @param  customerCallSid      DOCUMENT ME!
   * @param  customerCallType     DOCUMENT ME!
   * @param  customerPhoneNumber  DOCUMENT ME!
   * @param  eventDate            DOCUMENT ME!
   * @param  eventName            DOCUMENT ME!
   * @param  dialPad              DOCUMENT ME!
   * @param  notReadyReason       DOCUMENT ME!
   * @param  notReadyReasonId     DOCUMENT ME!
   * @param  responsibleId        DOCUMENT ME!
   * @param  statusDuration       DOCUMENT ME!
   * @param  statusEntryTime      DOCUMENT ME!
   * @param  statusName           DOCUMENT ME!
   * @param  wrapUpTime           DOCUMENT ME!
   * @param  customerId           Long
   */
  public AgentTelephonyEvent(Long accountNum, User agent, Long agentId, String callStatus, Date createDate,
    String customerCallSid, EventCallType customerCallType, String customerPhoneNumber, Date eventDate,
    TelephonyEventName eventName, Boolean dialPad, TwilioNotReadyReason notReadyReason, Long notReadyReasonId,
    Long responsibleId, Long statusDuration, Date statusEntryTime, String statusName, Long wrapUpTime,
    Long customerId) {
    this.accountNum          = accountNum;
    this.agent               = agent;
    this.agentId             = agentId;
    this.callStatus          = callStatus;
    this.createDate          = createDate;
    this.customerCallSid     = customerCallSid;
    this.customerCallType    = customerCallType;
    this.customerPhoneNumber = customerPhoneNumber;
    this.eventDate           = eventDate;
    this.eventName           = eventName;
    isDialPad                = dialPad;
    this.notReadyReason      = notReadyReason;
    this.notReadyReasonId    = notReadyReasonId;
    this.responsibleId       = responsibleId;
    this.statusDuration      = statusDuration;
    this.statusEntryTime     = statusEntryTime;
    this.statusName          = statusName;
    this.wrapUpTime          = wrapUpTime;
    this.customerId          = customerId;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for account num.
   *
   * @return  Long
   */
  public Long getAccountNum() {
    return accountNum;
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
   * getter method for agent id.
   *
   * @return  Long
   */
  public Long getAgentId() {
    return agentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for call status.
   *
   * @return  String
   */
  public String getCallStatus() {
    return callStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#getCreateDate()
   */
  @Override public Date getCreateDate() {
    return createDate;
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
   * getter method for customer call sid.
   *
   * @return  String
   */
  public String getCustomerCallSid() {
    return customerCallSid;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for customer call type.
   *
   * @return  EventCallType
   */
  public EventCallType getCustomerCallType() {
    return customerCallType;
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
   * getter method for customer phone number.
   *
   * @return  String
   */
  public String getCustomerPhoneNumber() {
    return customerPhoneNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for dial pad.
   *
   * @return  Boolean
   */
  public Boolean getDialPad() {
    return isDialPad;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for event date.
   *
   * @return  Date
   */
  public Date getEventDate() {
    return eventDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for event name.
   *
   * @return  TelephonyEventName
   */
  public TelephonyEventName getEventName() {
    return eventName;
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
   * getter method for not ready reason.
   *
   * @return  TwilioNotReadyReason
   */
  public TwilioNotReadyReason getNotReadyReason() {
    return notReadyReason;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for not ready reason id.
   *
   * @return  Long
   */
  public Long getNotReadyReasonId() {
    return notReadyReasonId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible id.
   *
   * @return  Long
   */
  public Long getResponsibleId() {
    return responsibleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status duration.
   *
   * @return  Long
   */
  public Long getStatusDuration() {
    return statusDuration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status entry time.
   *
   * @return  Date
   */
  public Date getStatusEntryTime() {
    return statusEntryTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status name.
   *
   * @return  String
   */
  public String getStatusName() {
    return statusName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for wrap up time.
   *
   * @return  Long
   */
  public Long getWrapUpTime() {
    return wrapUpTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  accountNum  DOCUMENT ME!
   */
  public void setAccountNum(Long accountNum) {
    this.accountNum = accountNum;
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
   * setter method for agent id.
   *
   * @param  agentId  Long
   */
  public void setAgentId(Long agentId) {
    this.agentId = agentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for call status.
   *
   * @param  callStatus  String
   */
  public void setCallStatus(String callStatus) {
    this.callStatus = callStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#setCreateDate(java.util.Date)
   */
  @Override public void setCreateDate(Date createDate) {
    this.createDate = createDate;
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
   * setter method for customer call sid.
   *
   * @param  customerCallSid  String
   */
  public void setCustomerCallSid(String customerCallSid) {
    this.customerCallSid = customerCallSid;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for customer call type.
   *
   * @param  customerCallType  EventCallType
   */
  public void setCustomerCallType(EventCallType customerCallType) {
    this.customerCallType = customerCallType;
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
   * setter method for customer phone number.
   *
   * @param  customerPhoneNumber  String
   */
  public void setCustomerPhoneNumber(String customerPhoneNumber) {
    this.customerPhoneNumber = customerPhoneNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for dial pad.
   *
   * @param  dialPad  Boolean
   */
  public void setDialPad(Boolean dialPad) {
    isDialPad = dialPad;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for event date.
   *
   * @param  eventDate  Date
   */
  public void setEventDate(Date eventDate) {
    this.eventDate = eventDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for event name.
   *
   * @param  eventName  TelephonyEventName
   */
  public void setEventName(TelephonyEventName eventName) {
    this.eventName = eventName;
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
   * setter method for not ready reason.
   *
   * @param  notReadyReason  TwilioNotReadyReason
   */
  public void setNotReadyReason(TwilioNotReadyReason notReadyReason) {
    this.notReadyReason = notReadyReason;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for not ready reason id.
   *
   * @param  notReadyReasonId  Long
   */
  public void setNotReadyReasonId(Long notReadyReasonId) {
    this.notReadyReasonId = notReadyReasonId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for responsible id.
   *
   * @param  responsibleId  Long
   */
  public void setResponsibleId(Long responsibleId) {
    this.responsibleId = responsibleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for status duration.
   *
   * @param  statusDuration  Long
   */
  public void setStatusDuration(Long statusDuration) {
    this.statusDuration = statusDuration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for status entry time.
   *
   * @param  statusEntryTime  Date
   */
  public void setStatusEntryTime(Date statusEntryTime) {
    this.statusEntryTime = statusEntryTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for status name.
   *
   * @param  statusName  String
   */
  public void setStatusName(String statusName) {
    this.statusName = statusName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for wrap up time.
   *
   * @param  wrapUpTime  Long
   */
  public void setWrapUpTime(Long wrapUpTime) {
    this.wrapUpTime = wrapUpTime;
  }
} // end class AgentTelephonyEvent
