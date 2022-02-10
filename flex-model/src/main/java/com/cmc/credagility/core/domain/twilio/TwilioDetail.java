package com.cmc.credagility.core.domain.twilio;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.customer.Customer;
import com.cmc.credagility.core.domain.user.User;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/15/2014 17:02
 */
@Entity
@Table(
  name    = "TwilioDetail",
  indexes = {
    @javax.persistence.Index(
      name = "idx_TwilioDetail_callSid",
      columnList = "callSid"
    ),
    @javax.persistence.Index(
      name = "idx_TwilioDetail_customerCallSid",
      columnList = "customerCallSid"
    ),
    @javax.persistence.Index(
      name = "idx_TwilioDetail_userId",
      columnList = "userId"
    ),
    @javax.persistence.Index(
      name = "idx_TwilioDetail_createDate",
      columnList = "createDate"
    )
  }
)
public class TwilioDetail extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 3258367900699993962L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  protected Long accountNum;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String callSerial;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String callSid;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String conferenceName;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String conferenceSid;

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
  protected Long   customerId;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String customerNumber;

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;


  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean isInbound = null;

  /** Sid for join conference. */
  @Column(length = 255)
  protected String joinConferenceSid;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "joinConferenceUserId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected User joinConferenceUser;


  /** TODO: DOCUMENT ME! */
  protected Date nonAgentAnsweredDate;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String nonAgentPhoneNumber;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "operationId",
    insertable = true,
    updatable  = false,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected TwilioOperation operation;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "reasonId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected TwilioNotReadyReason reason;

  /** TODO: DOCUMENT ME! */
  protected Long responsibleId;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String transferConferenceSid;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String transferToPhoneNumber;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String transferToPhoneNumberCallSid;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "transferToUserId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected User transferToUser;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "userId",
    insertable = true,
    updatable  = false,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected User user;

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
   * getter method for call serial.
   *
   * @return  String
   */
  public String getCallSerial() {
    return callSerial;
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
   * getter method for conference name.
   *
   * @return  String
   */
  public String getConferenceName() {
    return conferenceName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for conference sid.
   *
   * @return  String
   */
  public String getConferenceSid() {
    return conferenceSid;
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
   * getter method for customer id.
   *
   * @return  Long
   */
  public Long getCustomerId() {
    return customerId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for customer number.
   *
   * @return  String
   */
  public String getCustomerNumber() {
    return customerNumber;
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
   * getter method for inbound.
   *
   * @return  Boolean
   */
  public Boolean getInbound() {
    return isInbound;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for join conference sid.
   *
   * @return  String
   */
  public String getJoinConferenceSid() {
    return joinConferenceSid;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for join conference user.
   *
   * @return  User
   */
  public User getJoinConferenceUser() {
    return joinConferenceUser;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#getLastUpdateDate()
   */
  @Override public Date getLastUpdateDate() {
    return lastUpdateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for non agent answered date.
   *
   * @return  Date
   */
  public Date getNonAgentAnsweredDate() {
    return nonAgentAnsweredDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for non agent phone number.
   *
   * @return  String
   */
  public String getNonAgentPhoneNumber() {
    return nonAgentPhoneNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for operation.
   *
   * @return  TwilioOperation
   */
  public TwilioOperation getOperation() {
    return operation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for reason.
   *
   * @return  TwilioNotReadyReason
   */
  public TwilioNotReadyReason getReason() {
    return reason;
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
   * getter method for transfer conference sid.
   *
   * @return  String
   */
  public String getTransferConferenceSid() {
    return transferConferenceSid;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for transfer to phone number.
   *
   * @return  String
   */
  public String getTransferToPhoneNumber() {
    return transferToPhoneNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for transfer to phone number call sid.
   *
   * @return  String
   */
  public String getTransferToPhoneNumberCallSid() {
    return transferToPhoneNumberCallSid;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for transfer to user.
   *
   * @return  User
   */
  public User getTransferToUser() {
    return transferToUser;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for user.
   *
   * @return  User
   */
  public User getUser() {
    return user;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account num.
   *
   * @param  accountNum  Long
   */
  public void setAccountNum(Long accountNum) {
    this.accountNum = accountNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for call serial.
   *
   * @param  callSerial  String
   */
  public void setCallSerial(String callSerial) {
    this.callSerial = callSerial;
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
   * setter method for conference name.
   *
   * @param  conferenceName  String
   */
  public void setConferenceName(String conferenceName) {
    this.conferenceName = conferenceName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for conference sid.
   *
   * @param  conferenceSid  String
   */
  public void setConferenceSid(String conferenceSid) {
    this.conferenceSid = conferenceSid;
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
   * setter method for customer id.
   *
   * @param  customerId  Long
   */
  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for customer number.
   *
   * @param  customerNumber  String
   */
  public void setCustomerNumber(String customerNumber) {
    this.customerNumber = customerNumber;
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
   * setter method for inbound.
   *
   * @param  inbound  Boolean
   */
  public void setInbound(Boolean inbound) {
    isInbound = inbound;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for join conference sid.
   *
   * @param  joinConferenceSid  String
   */
  public void setJoinConferenceSid(String joinConferenceSid) {
    this.joinConferenceSid = joinConferenceSid;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for join conference user.
   *
   * @param  joinConferenceUser  User
   */
  public void setJoinConferenceUser(User joinConferenceUser) {
    this.joinConferenceUser = joinConferenceUser;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#setLastUpdateDate(java.util.Date)
   */
  @Override public void setLastUpdateDate(Date lastUpdateDate) {
    this.lastUpdateDate = lastUpdateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for non agent answered date.
   *
   * @param  nonAgentAnsweredDate  Date
   */
  public void setNonAgentAnsweredDate(Date nonAgentAnsweredDate) {
    this.nonAgentAnsweredDate = nonAgentAnsweredDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for non agent phone number.
   *
   * @param  nonAgentPhoneNumber  String
   */
  public void setNonAgentPhoneNumber(String nonAgentPhoneNumber) {
    this.nonAgentPhoneNumber = nonAgentPhoneNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for operation.
   *
   * @param  operation  TwilioOperation
   */
  public void setOperation(TwilioOperation operation) {
    this.operation = operation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for reason.
   *
   * @param  reason  TwilioNotReadyReason
   */
  public void setReason(TwilioNotReadyReason reason) {
    this.reason = reason;
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
   * setter method for transfer conference sid.
   *
   * @param  transferConferenceSid  String
   */
  public void setTransferConferenceSid(String transferConferenceSid) {
    this.transferConferenceSid = transferConferenceSid;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for transfer to phone number.
   *
   * @param  transferToPhoneNumber  String
   */
  public void setTransferToPhoneNumber(String transferToPhoneNumber) {
    this.transferToPhoneNumber = transferToPhoneNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for transfer to phone number call sid.
   *
   * @param  transferToPhoneNumberCallSid  String
   */
  public void setTransferToPhoneNumberCallSid(String transferToPhoneNumberCallSid) {
    this.transferToPhoneNumberCallSid = transferToPhoneNumberCallSid;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for transfer to user.
   *
   * @param  transferToUser  User
   */
  public void setTransferToUser(User transferToUser) {
    this.transferToUser = transferToUser;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for user.
   *
   * @param  user  User
   */
  public void setUser(User user) {
    this.user = user;
  }
} // end class TwilioDetail
