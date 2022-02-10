package com.cmc.credagility.core.domain.twilio;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.customer.Customer;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/15/2014 17:19
 */
@Entity
@Table(
  name    = "TwilioOutboundDetail",
  indexes = {
    @Index(
      name = "idx_TwilioOutboundDetail_agentId",
      columnList = "agentId"
    ),
    @Index(
      name = "idx_TwilioOutboundDetail_answerDate",
      columnList = "answerDate"
    ),
    @Index(
      name = "idx_TwilioOutboundDetail_customerCallSid",
      columnList = "customerCallSid"
    ),
    @Index(
      name = "idx_TwilioOutboundDetail_endDate",
      columnList = "endDate"
    ),
    @Index(
      name = "idx_TwilioOutboundDetail_createDate",
      columnList = "createDate"
    )
  }
)
public class TwilioOutboundDetail extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 4827291735810069992L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "accountNum",
    insertable = false,
    updatable  = false,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Account account;

  /** TODO: DOCUMENT ME! */
  protected Long accountNum;


  /** TODO: DOCUMENT ME! */
  protected Long agentId;


  /** TODO: DOCUMENT ME! */
  protected Date answerDate;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String callResult;

  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char",
    nullable         = false
  )
  @Convert(converter = StringBooleanConverter.class)
  protected boolean connected = false;

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
  protected Long customerId;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String customerPhoneNumber;

  /** TODO: DOCUMENT ME! */
  protected Long duration;


  /** TODO: DOCUMENT ME! */
  protected Date endDate;


  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;


  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char",
    nullable         = false
  )
  @Convert(converter = StringBooleanConverter.class)
  protected boolean isDialPad;

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean outOfComplianceRule;

  /** TODO: DOCUMENT ME! */
  @Column(length = 1000)
  protected String outOfRuleReason;

  /** TODO: DOCUMENT ME! */
  protected Long phoneTypeId;

  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean processDisposed = Boolean.FALSE;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "responsibleId",
    insertable = false,
    updatable  = false,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Responsible responsible;


  /** TODO: DOCUMENT ME! */
  protected Long responsibleId;


  /** TODO: DOCUMENT ME! */
  protected Long ringDuration;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "twilioSubAccountId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected TwilioSubAccount twilioSubAccount;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for account.
   *
   * @return  Account
   */
  public Account getAccount() {
    return account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

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
   * getter method for agent id.
   *
   * @return  Long
   */
  public Long getAgentId() {
    return agentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for answer date.
   *
   * @return  Date
   */
  public Date getAnswerDate() {
    return answerDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for call result.
   *
   * @return  String
   */
  public String getCallResult() {
    return callResult;
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
   * getter method for customer phone number.
   *
   * @return  String
   */
  public String getCustomerPhoneNumber() {
    return customerPhoneNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for duration.
   *
   * @return  Long
   */
  public Long getDuration() {
    return duration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for end date.
   *
   * @return  Date
   */
  public Date getEndDate() {
    return endDate;
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
   * getter method for out of compliance rule.
   *
   * @return  Boolean
   */
  public Boolean getOutOfComplianceRule() {
    return outOfComplianceRule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for out of rule reason.
   *
   * @return  String
   */
  public String getOutOfRuleReason() {
    return outOfRuleReason;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for phone type id.
   *
   * @return  Long
   */
  public Long getPhoneTypeId() {
    return phoneTypeId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for process disposed.
   *
   * @return  Boolean
   */
  public Boolean getProcessDisposed() {
    return processDisposed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible.
   *
   * @return  Responsible
   */
  public Responsible getResponsible() {
    return responsible;
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
   * getter method for ring duration.
   *
   * @return  Long
   */
  public Long getRingDuration() {
    return ringDuration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for twilio sub account.
   *
   * @return  TwilioSubAccount
   */
  public TwilioSubAccount getTwilioSubAccount() {
    return twilioSubAccount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for connected.
   *
   * @return  boolean
   */
  public boolean isConnected() {
    return connected;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for dial pad.
   *
   * @return  boolean
   */
  public boolean isDialPad() {
    return isDialPad;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account.
   *
   * @param  account  Account
   */
  public void setAccount(Account account) {
    this.account = account;
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
   * setter method for agent id.
   *
   * @param  agentId  Long
   */
  public void setAgentId(Long agentId) {
    this.agentId = agentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for answer date.
   *
   * @param  answerDate  Date
   */
  public void setAnswerDate(Date answerDate) {
    this.answerDate = answerDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for call result.
   *
   * @param  callResult  String
   */
  public void setCallResult(String callResult) {
    this.callResult = callResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for connected.
   *
   * @param  connected  boolean
   */
  public void setConnected(boolean connected) {
    this.connected = connected;
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
   * @param  dialPad  boolean
   */
  public void setDialPad(boolean dialPad) {
    isDialPad = dialPad;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for duration.
   *
   * @param  duration  Long
   */
  public void setDuration(Long duration) {
    this.duration = duration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for end date.
   *
   * @param  endDate  Date
   */
  public void setEndDate(Date endDate) {
    this.endDate = endDate;
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
   * setter method for out of compliance rule.
   *
   * @param  outOfComplianceRule  Boolean
   */
  public void setOutOfComplianceRule(Boolean outOfComplianceRule) {
    this.outOfComplianceRule = outOfComplianceRule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for out of rule reason.
   *
   * @param  outOfRuleReason  String
   */
  public void setOutOfRuleReason(String outOfRuleReason) {
    this.outOfRuleReason = outOfRuleReason;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for phone type id.
   *
   * @param  phoneTypeId  Long
   */
  public void setPhoneTypeId(Long phoneTypeId) {
    this.phoneTypeId = phoneTypeId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for process disposed.
   *
   * @param  processDisposed  Boolean
   */
  public void setProcessDisposed(Boolean processDisposed) {
    this.processDisposed = processDisposed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for responsible.
   *
   * @param  responsible  Responsible
   */
  public void setResponsible(Responsible responsible) {
    this.responsible = responsible;
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
   * setter method for ring duration.
   *
   * @param  ringDuration  Long
   */
  public void setRingDuration(Long ringDuration) {
    this.ringDuration = ringDuration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for twilio sub account.
   *
   * @param  twilioSubAccount  TwilioSubAccount
   */
  public void setTwilioSubAccount(TwilioSubAccount twilioSubAccount) {
    this.twilioSubAccount = twilioSubAccount;
  }
} // end class TwilioOutboundDetail
