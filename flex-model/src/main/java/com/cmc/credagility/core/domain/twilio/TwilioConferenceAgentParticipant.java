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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.user.User;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/15/2014 16:15
 */
@Entity
@Table(
  name    = "TwilioConferenceAgentParticipant",
  indexes = {
    @javax.persistence.Index(
      name = "idx_TwilioConferenceAgentParticipant_agentCallSid",
      columnList = "agentCallSid"
    ),
    @javax.persistence.Index(
      name = "idx_TwilioConferenceAgentParticipant_nonAgentCallSid",
      columnList = "nonAgentCallSid"
    ),
    @javax.persistence.Index(
      name = "idx_TwilioConferenceAgentParticipant_twilioConferenceId",
      columnList = "twilioConferenceId"
    )
  }
)
public class TwilioConferenceAgentParticipant extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 4324562101267865432L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

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
  @Column(
    length           = 1,
    columnDefinition = "char",
    nullable         = false
  )
  @Convert(converter = StringBooleanConverter.class)
  protected boolean disconnected = false;


  /** TODO: DOCUMENT ME! */
  protected Date disconnectedDate;


  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char",
    nullable         = false
  )
  @Convert(converter = StringBooleanConverter.class)
  protected boolean dropped = false;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "droppedByUserId",
    insertable = true,
    updatable  = false,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected User droppedByUser;


  /** TODO: DOCUMENT ME! */
  protected Date droppedDate;


  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char",
    nullable         = false
  )
  @Convert(converter = StringBooleanConverter.class)
  protected boolean hangup = false;


  /** TODO: DOCUMENT ME! */
  protected Date hangupDate;


  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "invitedByUserId",
    insertable = true,
    updatable  = false,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected User invitedByUser;


  /** TODO: DOCUMENT ME! */
  protected String nonAgentCallSid;


  /** TODO: DOCUMENT ME! */
  protected String nonAgentPhoneNumber;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "twilioConferenceId",
    insertable = true,
    updatable  = false,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected TwilioConference twilioConference;

  //~ Methods ----------------------------------------------------------------------------------------------------------

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
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#getCreateDate()
   */
  @Override public Date getCreateDate() {
    return createDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for disconnected date.
   *
   * @return  Date
   */
  public Date getDisconnectedDate() {
    return disconnectedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for dropped by user.
   *
   * @return  User
   */
  public User getDroppedByUser() {
    return droppedByUser;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for dropped date.
   *
   * @return  Date
   */
  public Date getDroppedDate() {
    return droppedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for hangup date.
   *
   * @return  Date
   */
  public Date getHangupDate() {
    return hangupDate;
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
   * getter method for invited by user.
   *
   * @return  User
   */
  public User getInvitedByUser() {
    return invitedByUser;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for non agent call sid.
   *
   * @return  String
   */
  public String getNonAgentCallSid() {
    return nonAgentCallSid;
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
   * getter method for twilio conference.
   *
   * @return  TwilioConference
   */
  public TwilioConference getTwilioConference() {
    return twilioConference;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for disconnected.
   *
   * @return  boolean
   */
  public boolean isDisconnected() {
    return disconnected;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for dropped.
   *
   * @return  boolean
   */
  public boolean isDropped() {
    return dropped;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for hangup.
   *
   * @return  boolean
   */
  public boolean isHangup() {
    return hangup;
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
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#setCreateDate(java.util.Date)
   */
  @Override public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for disconnected.
   *
   * @param  disconnected  boolean
   */
  public void setDisconnected(boolean disconnected) {
    this.disconnected = disconnected;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for disconnected date.
   *
   * @param  disconnectedDate  Date
   */
  public void setDisconnectedDate(Date disconnectedDate) {
    this.disconnectedDate = disconnectedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for dropped.
   *
   * @param  dropped  boolean
   */
  public void setDropped(boolean dropped) {
    this.dropped = dropped;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for dropped by user.
   *
   * @param  droppedByUser  User
   */
  public void setDroppedByUser(User droppedByUser) {
    this.droppedByUser = droppedByUser;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for dropped date.
   *
   * @param  droppedDate  Date
   */
  public void setDroppedDate(Date droppedDate) {
    this.droppedDate = droppedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for hangup.
   *
   * @param  hangup  boolean
   */
  public void setHangup(boolean hangup) {
    this.hangup = hangup;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for hangup date.
   *
   * @param  hangupDate  Date
   */
  public void setHangupDate(Date hangupDate) {
    this.hangupDate = hangupDate;
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
   * setter method for invited by user.
   *
   * @param  invitedByUser  User
   */
  public void setInvitedByUser(User invitedByUser) {
    this.invitedByUser = invitedByUser;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for non agent call sid.
   *
   * @param  nonAgentCallSid  String
   */
  public void setNonAgentCallSid(String nonAgentCallSid) {
    this.nonAgentCallSid = nonAgentCallSid;
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
   * setter method for twilio conference.
   *
   * @param  twilioConference  TwilioConference
   */
  public void setTwilioConference(TwilioConference twilioConference) {
    this.twilioConference = twilioConference;
  }
} // end class TwilioConferenceAgentParticipant
