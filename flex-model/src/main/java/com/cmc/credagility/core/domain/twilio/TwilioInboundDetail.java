package com.cmc.credagility.core.domain.twilio;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.customer.Customer;
import com.cmc.credagility.core.domain.responsible.Responsible;
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
 * @version  10/15/2014 17:08
 */
@Entity
@Table(
  name    = "TwilioInboundDetail",
  indexes = {
    @javax.persistence.Index(
      name = "idx_TwilioInboundDetail_agentCallSid",
      columnList = "agentCallSid"
    ),
    @javax.persistence.Index(
      name = "idx_TwilioInboundDetail_agentId",
      columnList = "agentId"
    ),
    @javax.persistence.Index(
      name = "idx_TwilioInboundDetail_answerDate",
      columnList = "answerDate"
    ),
    @javax.persistence.Index(
      name = "idx_TwilioInboundDetail_endDate",
      columnList = "endDate"
    ),
    @javax.persistence.Index(
      name = "idx_TwilioInboundDetail_huntGroupName",
      columnList = "huntGroupName"
    ),
    @javax.persistence.Index(
      name = "idx_TwilioInboundDetail_createDate",
      columnList = "createDate"
    )
  }
)
public class TwilioInboundDetail extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 937592528120069992L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  protected Long abandonReasonId;

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
  @Column(length = 255)
  protected String agentCallSid;


  /** TODO: DOCUMENT ME! */
  protected Long agentId;


  /** TODO: DOCUMENT ME! */
  protected Date answerDate;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String calledNumber;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String callResult;


  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String callSid;

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
  protected Long customerId;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String customerNumber;


  /** TODO: DOCUMENT ME! */
  protected Long duration;


  /** TODO: DOCUMENT ME! */
  protected Date endDate;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String fromCity;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String fromCountry;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String fromState;

  /** TODO: DOCUMENT ME! */
  protected Long huntGroupId;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String huntGroupName;


  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean ivr = false;


  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char",
    nullable         = false
  )
  @Convert(converter = StringBooleanConverter.class)
  protected boolean onlineAgent = true;

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

  @Column(length = 255)
  protected String toCity;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String toState;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "twilioIVRFlowId",
    insertable = false,
    updatable  = false,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected TwilioIVRFlow twilioIVRFlow;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "twilioSubAccountId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected TwilioSubAccount twilioSubAccount;

  /** TODO: DOCUMENT ME! */
  protected Long waitTime;


  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char",
    nullable         = false
  )
  @Convert(converter = StringBooleanConverter.class)
  protected boolean workTime = true;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new TwilioInboundDetail object.
   */
  public TwilioInboundDetail() { }

  /**
   * Creates a new TwilioInboundDetail object.
   *
   * @param  agentCallSid      DOCUMENT ME!
   * @param  agentId           DOCUMENT ME!
   * @param  answerDate        DOCUMENT ME!
   * @param  calledNumber      DOCUMENT ME!
   * @param  callSid           DOCUMENT ME!
   * @param  createDate        DOCUMENT ME!
   * @param  customerNumber    DOCUMENT ME!
   * @param  endDate           DOCUMENT ME!
   * @param  fromCity          DOCUMENT ME!
   * @param  fromCountry       DOCUMENT ME!
   * @param  fromState         DOCUMENT ME!
   * @param  huntGroupName     DOCUMENT ME!
   * @param  huntGroupId       DOCUMENT ME!
   * @param  toCity            DOCUMENT ME!
   * @param  toState           DOCUMENT ME!
   * @param  workTime          DOCUMENT ME!
   * @param  onlineAgent       DOCUMENT ME!
   * @param  twilioSubAccount  TwilioSubAccount
   */
  public TwilioInboundDetail(String agentCallSid, Long agentId, Date answerDate, String calledNumber, String callSid,
    Date createDate, String customerNumber, Date endDate, String fromCity, String fromCountry, String fromState,
    String huntGroupName, Long huntGroupId, String toCity, String toState, boolean workTime, boolean onlineAgent,
    TwilioSubAccount twilioSubAccount) {
    this.agentCallSid     = agentCallSid;
    this.agentId          = agentId;
    this.answerDate       = answerDate;
    this.calledNumber     = calledNumber;
    this.callSid          = callSid;
    this.createDate       = createDate;
    this.customerNumber   = customerNumber;
    this.endDate          = endDate;
    this.fromCity         = fromCity;
    this.fromCountry      = fromCountry;
    this.fromState        = fromState;
    this.huntGroupName    = huntGroupName;
    this.huntGroupId      = huntGroupId;
    this.toCity           = toCity;
    this.toState          = toState;
    this.workTime         = workTime;
    this.onlineAgent      = onlineAgent;
    this.twilioSubAccount = twilioSubAccount;
  }

  /**
   * Creates a new TwilioInboundDetail object.
   *
   * @param  abandonReasonId   DOCUMENT ME!
   * @param  agentCallSid      DOCUMENT ME!
   * @param  agentId           DOCUMENT ME!
   * @param  answerDate        DOCUMENT ME!
   * @param  calledNumber      DOCUMENT ME!
   * @param  callSid           DOCUMENT ME!
   * @param  connected         DOCUMENT ME!
   * @param  createDate        DOCUMENT ME!
   * @param  customerNumber    DOCUMENT ME!
   * @param  duration          DOCUMENT ME!
   * @param  endDate           DOCUMENT ME!
   * @param  fromCity          DOCUMENT ME!
   * @param  fromCountry       DOCUMENT ME!
   * @param  fromState         DOCUMENT ME!
   * @param  huntGroupId       DOCUMENT ME!
   * @param  huntGroupName     DOCUMENT ME!
   * @param  onlineAgent       DOCUMENT ME!
   * @param  toCity            DOCUMENT ME!
   * @param  toState           DOCUMENT ME!
   * @param  waitTime          DOCUMENT ME!
   * @param  workTime          DOCUMENT ME!
   * @param  twilioSubAccount  TwilioSubAccount
   */
  public TwilioInboundDetail(Long abandonReasonId, String agentCallSid, Long agentId, Date answerDate,
    String calledNumber, String callSid, boolean connected, Date createDate, String customerNumber, Long duration,
    Date endDate, String fromCity, String fromCountry, String fromState, Long huntGroupId, String huntGroupName,
    boolean onlineAgent, String toCity, String toState, Long waitTime, boolean workTime,
    TwilioSubAccount twilioSubAccount) {
    this.abandonReasonId  = abandonReasonId;
    this.agentCallSid     = agentCallSid;
    this.agentId          = agentId;
    this.answerDate       = answerDate;
    this.calledNumber     = calledNumber;
    this.callSid          = callSid;
    this.connected        = connected;
    this.createDate       = createDate;
    this.customerNumber   = customerNumber;
    this.duration         = duration;
    this.endDate          = endDate;
    this.fromCity         = fromCity;
    this.fromCountry      = fromCountry;
    this.fromState        = fromState;
    this.huntGroupId      = huntGroupId;
    this.huntGroupName    = huntGroupName;
    this.onlineAgent      = onlineAgent;
    this.toCity           = toCity;
    this.toState          = toState;
    this.waitTime         = waitTime;
    this.workTime         = workTime;
    this.twilioSubAccount = twilioSubAccount;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for abandon reason id.
   *
   * @return  Long
   */
  public Long getAbandonReasonId() {
    return abandonReasonId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

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
   * getter method for agent call sid.
   *
   * @return  String
   */
  public String getAgentCallSid() {
    return agentCallSid;
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
   * getter method for called number.
   *
   * @return  String
   */
  public String getCalledNumber() {
    return calledNumber;
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
   * getter method for call sid.
   *
   * @return  String
   */
  public String getCallSid() {
    return callSid;
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
   * getter method for from city.
   *
   * @return  String
   */
  public String getFromCity() {
    return fromCity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for from country.
   *
   * @return  String
   */
  public String getFromCountry() {
    return fromCountry;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for from state.
   *
   * @return  String
   */
  public String getFromState() {
    return fromState;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for hunt group id.
   *
   * @return  Long
   */
  public Long getHuntGroupId() {
    return huntGroupId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for hunt group name.
   *
   * @return  String
   */
  public String getHuntGroupName() {
    return huntGroupName;
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
   * getter method for ivr.
   *
   * @return  Boolean
   */
  public Boolean getIvr() {
    return ivr;
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
   * getter method for to city.
   *
   * @return  String
   */
  public String getToCity() {
    return toCity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for to state.
   *
   * @return  String
   */
  public String getToState() {
    return toState;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for twilio IVRFlow.
   *
   * @return  TwilioIVRFlow
   */
  public TwilioIVRFlow getTwilioIVRFlow() {
    return twilioIVRFlow;
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
   * getter method for wait time.
   *
   * @return  Long
   */
  public Long getWaitTime() {
    return waitTime;
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
   * getter method for online agent.
   *
   * @return  boolean
   */
  public boolean isOnlineAgent() {
    return onlineAgent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for work time.
   *
   * @return  boolean
   */
  public boolean isWorkTime() {
    return workTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for abandon reason id.
   *
   * @param  abandonReasonId  Long
   */
  public void setAbandonReasonId(Long abandonReasonId) {
    this.abandonReasonId = abandonReasonId;
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
   * setter method for agent call sid.
   *
   * @param  agentCallSid  String
   */
  public void setAgentCallSid(String agentCallSid) {
    this.agentCallSid = agentCallSid;
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
   * setter method for called number.
   *
   * @param  calledNumber  String
   */
  public void setCalledNumber(String calledNumber) {
    this.calledNumber = calledNumber;
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
   * setter method for call sid.
   *
   * @param  callSid  String
   */
  public void setCallSid(String callSid) {
    this.callSid = callSid;
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
   * setter method for from city.
   *
   * @param  fromCity  String
   */
  public void setFromCity(String fromCity) {
    this.fromCity = fromCity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for from country.
   *
   * @param  fromCountry  String
   */
  public void setFromCountry(String fromCountry) {
    this.fromCountry = fromCountry;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for from state.
   *
   * @param  fromState  String
   */
  public void setFromState(String fromState) {
    this.fromState = fromState;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for hunt group id.
   *
   * @param  huntGroupId  Long
   */
  public void setHuntGroupId(Long huntGroupId) {
    this.huntGroupId = huntGroupId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for hunt group name.
   *
   * @param  huntGroupName  String
   */
  public void setHuntGroupName(String huntGroupName) {
    this.huntGroupName = huntGroupName;
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
   * setter method for ivr.
   *
   * @param  ivr  Boolean
   */
  public void setIvr(Boolean ivr) {
    if (null != ivr) {
      this.ivr = ivr;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for online agent.
   *
   * @param  onlineAgent  boolean
   */
  public void setOnlineAgent(boolean onlineAgent) {
    this.onlineAgent = onlineAgent;
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
   * setter method for to city.
   *
   * @param  toCity  String
   */
  public void setToCity(String toCity) {
    this.toCity = toCity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for to state.
   *
   * @param  toState  String
   */
  public void setToState(String toState) {
    this.toState = toState;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for twilio IVRFlow.
   *
   * @param  twilioIVRFlow  TwilioIVRFlow
   */
  public void setTwilioIVRFlow(TwilioIVRFlow twilioIVRFlow) {
    this.twilioIVRFlow = twilioIVRFlow;
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

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for wait time.
   *
   * @param  waitTime  Long
   */
  public void setWaitTime(Long waitTime) {
    this.waitTime = waitTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for work time.
   *
   * @param  workTime  boolean
   */
  public void setWorkTime(boolean workTime) {
    this.workTime = workTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#toString()
   */
  @Override public String toString() {
    return "TwilioInboundDetail{"
      + "agentCallSid='" + agentCallSid + '\''
      + ", agentId=" + agentId
      + ", answerDate=" + answerDate
      + ", calledNumber='" + calledNumber + '\''
      + ", callSid='" + callSid + '\''
      + ", createDate=" + createDate
      + ", customerNumber='" + customerNumber + '\''
      + ", endDate=" + endDate
      + ", fromCity='" + fromCity + '\''
      + ", fromCountry='" + fromCountry + '\''
      + ", fromState='" + fromState + '\''
      + ", huntGroupName='" + huntGroupName + '\''
      + ", onlineAgent=" + onlineAgent
      + ", toCity='" + toCity + '\''
      + ", toState='" + toState + '\''
      + ", workTime=" + workTime
      + '}';
  }
} // end class TwilioInboundDetail
