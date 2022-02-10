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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.user.User;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/15/2014 14:59
 */
@Entity
@Table(
  name    = "AgentTelephoneTalk",
  indexes = {
    @Index(
      name = "idx_AgentTelephoneTalk_callSid",
      columnList = "callSid"
    ),
    @Index(
      name = "idx_AgentTelephoneTalk_customerCallSid",
      columnList = "customerCallSid"
    )
  }
)
public class AgentTelephoneTalk extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -1003332468733534676L;

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
  protected Date callEndDate;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String callSid;


  /** TODO: DOCUMENT ME! */
  protected Date callStartDate;


  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String customerCallSid;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String customerNumber;


  /** TODO: DOCUMENT ME! */
  protected Long duration;


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


  /** TODO: DOCUMENT ME! */
  protected Long responsibleId;

  @JoinColumn(
    name       = "eventId",
    insertable = true,
    updatable  = true
  )
  @OneToOne(fetch = FetchType.LAZY)
  private AgentTelephonyEvent event;

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
   * getter method for call end date.
   *
   * @return  Date
   */
  public Date getCallEndDate() {
    return callEndDate;
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
   * getter method for call start date.
   *
   * @return  Date
   */
  public Date getCallStartDate() {
    return callStartDate;
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
   * getter method for event.
   *
   * @return  AgentTelephonyEvent
   */
  public AgentTelephonyEvent getEvent() {
    return event;
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
   * getter method for is inbound.
   *
   * @return  Boolean
   */
  public Boolean getIsInbound() {
    return isInbound;
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
   * setter method for call end date.
   *
   * @param  callEndDate  Date
   */
  public void setCallEndDate(Date callEndDate) {
    this.callEndDate = callEndDate;
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
   * setter method for call start date.
   *
   * @param  callStartDate  Date
   */
  public void setCallStartDate(Date callStartDate) {
    this.callStartDate = callStartDate;
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
   * setter method for event.
   *
   * @param  event  AgentTelephonyEvent
   */
  public void setEvent(AgentTelephonyEvent event) {
    this.event = event;
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
   * setter method for is inbound.
   *
   * @param  isInbound  Boolean
   */
  public void setIsInbound(Boolean isInbound) {
    this.isInbound = isInbound;
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

} // end class AgentTelephoneTalk
