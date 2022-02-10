package com.cmc.credagility.core.domain.twilio;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
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

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.user.User;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/15/2014 15:11
 */
@Entity
@Table(
  name    = "CallDetail",
  indexes = {
    @Index(
      name = "idx_CallDetail_agentCallSid",
      columnList = "agentCallSid"
    ),
    @Index(
      name = "idx_CallDetail_customerCallSid",
      columnList = "customerCallSid"
    ),
    @Index(
      name = "idx_CallDetail_dialedNumber",
      columnList = "dialedNumber"
    )
  }
)
public class CallDetail extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -394951762470321144L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  protected Long accountNum;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "agentId",
    insertable = true,
    updatable  = false,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected User agent;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String agentCallSid;


  /** TODO: DOCUMENT ME! */
  @Column
  @Enumerated(EnumType.STRING)
  protected CallType         callType = CallType.DialPad;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String conferenceCallSid;

  /** TODO: DOCUMENT ME! */
  protected Long conferenceToAgentId;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String conferenceToPhoneNumber;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String customerCallSid;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String dialedNumber;


  /** TODO: DOCUMENT ME! */
  protected Date endDate;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "fromAgentId",
    insertable = false,
    updatable  = false,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected User fromAgent;


  /** TODO: DOCUMENT ME! */
  protected Long fromAgentId;


  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String fromNumber;


  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;


  /** TODO: DOCUMENT ME! */
  protected Long responsibleId;


  /** TODO: DOCUMENT ME! */
  protected Date startDate;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String transferCallSid;


  /** TODO: DOCUMENT ME! */
  protected Long transferToAgentId;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String transferToPhoneNumber;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new CallDetail object.
   */
  public CallDetail() { }

  /**
   * Creates a new CallDetail object.
   *
   * @param  accountNum               DOCUMENT ME!
   * @param  agent                    DOCUMENT ME!
   * @param  agentCallSid             DOCUMENT ME!
   * @param  callType                 DOCUMENT ME!
   * @param  conferenceCallSid        DOCUMENT ME!
   * @param  conferenceToAgentId      DOCUMENT ME!
   * @param  conferenceToPhoneNumber  DOCUMENT ME!
   * @param  customerCallSid          DOCUMENT ME!
   * @param  dialedNumber             DOCUMENT ME!
   * @param  endDate                  DOCUMENT ME!
   * @param  fromAgent                DOCUMENT ME!
   * @param  fromAgentId              DOCUMENT ME!
   * @param  fromNumber               DOCUMENT ME!
   * @param  responsibleId            DOCUMENT ME!
   * @param  startDate                DOCUMENT ME!
   * @param  transferCallSid          DOCUMENT ME!
   * @param  transferToAgentId        DOCUMENT ME!
   * @param  transferToPhoneNumber    DOCUMENT ME!
   */
  public CallDetail(Long accountNum, User agent, String agentCallSid, CallType callType, String conferenceCallSid,
    Long conferenceToAgentId, String conferenceToPhoneNumber, String customerCallSid, String dialedNumber,
    Date endDate, User fromAgent, Long fromAgentId, String fromNumber, Long responsibleId, Date startDate,
    String transferCallSid, Long transferToAgentId, String transferToPhoneNumber) {
    this.accountNum              = accountNum;
    this.agent                   = agent;
    this.agentCallSid            = agentCallSid;
    this.callType                = callType;
    this.conferenceCallSid       = conferenceCallSid;
    this.conferenceToAgentId     = conferenceToAgentId;
    this.conferenceToPhoneNumber = conferenceToPhoneNumber;
    this.customerCallSid         = customerCallSid;
    this.dialedNumber            = dialedNumber;
    this.endDate                 = endDate;
    this.fromAgent               = fromAgent;
    this.fromAgentId             = fromAgentId;
    this.fromNumber              = fromNumber;
    this.responsibleId           = responsibleId;
    this.startDate               = startDate;
    this.transferCallSid         = transferCallSid;
    this.transferToAgentId       = transferToAgentId;
    this.transferToPhoneNumber   = transferToPhoneNumber;
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
   * getter method for agent call sid.
   *
   * @return  String
   */
  public String getAgentCallSid() {
    return agentCallSid;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for call type.
   *
   * @return  CallType
   */
  public CallType getCallType() {
    return callType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for conference call sid.
   *
   * @return  String
   */
  public String getConferenceCallSid() {
    return conferenceCallSid;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for conference to agent id.
   *
   * @return  Long
   */
  public Long getConferenceToAgentId() {
    return conferenceToAgentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for conference to phone number.
   *
   * @return  String
   */
  public String getConferenceToPhoneNumber() {
    return conferenceToPhoneNumber;
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
   * getter method for dialed number.
   *
   * @return  String
   */
  public String getDialedNumber() {
    return dialedNumber;
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
   * getter method for from agent.
   *
   * @return  User
   */
  public User getFromAgent() {
    return fromAgent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for from agent id.
   *
   * @return  Long
   */
  public Long getFromAgentId() {
    return fromAgentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for from number.
   *
   * @return  String
   */
  public String getFromNumber() {
    return fromNumber;
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
   * getter method for responsible id.
   *
   * @return  Long
   */
  public Long getResponsibleId() {
    return responsibleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for start date.
   *
   * @return  Date
   */
  public Date getStartDate() {
    return startDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for transfer call sid.
   *
   * @return  String
   */
  public String getTransferCallSid() {
    return transferCallSid;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for transfer to agent id.
   *
   * @return  Long
   */
  public Long getTransferToAgentId() {
    return transferToAgentId;
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
   * setter method for account num.
   *
   * @param  accountNum  Long
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
   * setter method for agent call sid.
   *
   * @param  agentCallSid  String
   */
  public void setAgentCallSid(String agentCallSid) {
    this.agentCallSid = agentCallSid;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for call type.
   *
   * @param  callType  CallType
   */
  public void setCallType(CallType callType) {
    this.callType = callType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for conference call sid.
   *
   * @param  conferenceCallSid  String
   */
  public void setConferenceCallSid(String conferenceCallSid) {
    this.conferenceCallSid = conferenceCallSid;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for conference to agent id.
   *
   * @param  conferenceToAgentId  Long
   */
  public void setConferenceToAgentId(Long conferenceToAgentId) {
    this.conferenceToAgentId = conferenceToAgentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for conference to phone number.
   *
   * @param  conferenceToPhoneNumber  String
   */
  public void setConferenceToPhoneNumber(String conferenceToPhoneNumber) {
    this.conferenceToPhoneNumber = conferenceToPhoneNumber;
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
   * setter method for dialed number.
   *
   * @param  dialedNumber  String
   */
  public void setDialedNumber(String dialedNumber) {
    this.dialedNumber = dialedNumber;
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
   * setter method for from agent.
   *
   * @param  fromAgent  User
   */
  public void setFromAgent(User fromAgent) {
    this.fromAgent = fromAgent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for from agent id.
   *
   * @param  fromAgentId  Long
   */
  public void setFromAgentId(Long fromAgentId) {
    this.fromAgentId = fromAgentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for from number.
   *
   * @param  fromNumber  String
   */
  public void setFromNumber(String fromNumber) {
    this.fromNumber = fromNumber;
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
   * setter method for responsible id.
   *
   * @param  responsibleId  Long
   */
  public void setResponsibleId(Long responsibleId) {
    this.responsibleId = responsibleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for start date.
   *
   * @param  startDate  Date
   */
  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for transfer call sid.
   *
   * @param  transferCallSid  String
   */
  public void setTransferCallSid(String transferCallSid) {
    this.transferCallSid = transferCallSid;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for transfer to agent id.
   *
   * @param  transferToAgentId  Long
   */
  public void setTransferToAgentId(Long transferToAgentId) {
    this.transferToAgentId = transferToAgentId;
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
} // end class CallDetail
