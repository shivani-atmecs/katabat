package com.cmc.credagility.core.domain.twilio;

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
 * @version  10/15/2014 15:20
 */
@Entity
@Table(
  name    = "TwilioAgentInfo",
  indexes = {
    @javax.persistence.Index(
      name = "idx_TwilioAgentInfo_agentCallSid",
      columnList = "agentCallSid"
    ),
    @javax.persistence.Index(
      name = "idx_TwilioAgentInfo_agentId",
      columnList = "agentId"
    ),
    @javax.persistence.Index(
      name = "idx_TwilioAgentInfo_createDate",
      columnList = "createDate"
    )
  }
)
public class TwilioAgentInfo implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 1484672778750924836L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    unique = true,
    length = 64
  )
  protected String agentCallSid;


  /** TODO: DOCUMENT ME! */
  protected Long agentId;


  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1,
    nullable         = false
  )
  @Convert(converter = StringBooleanConverter.class)
  protected boolean clickDisconnect = false;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String connectPhoneNumber;


  /** TODO: DOCUMENT ME! */
  protected Date createDate;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String currentConferenceName;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String currentConferenceSid;


  /** TODO: DOCUMENT ME! */
  protected Date disconnectDate;


  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1,
    nullable         = false
  )
  @Convert(converter = StringBooleanConverter.class)
  protected boolean hangup = false;


  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;


  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1,
    nullable         = false
  )
  @Convert(converter = StringBooleanConverter.class)
  protected boolean inboundConnect = false;


  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1,
    nullable         = false
  )
  @Convert(converter = StringBooleanConverter.class)
  protected boolean isReleasing = false;


  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1,
    nullable         = false
  )
  @Convert(converter = StringBooleanConverter.class)
  protected boolean isTalking = false;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "lastOperationId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected TwilioOperation lastOperation;


  /** TODO: DOCUMENT ME! */
  protected Date lastUpdateDate;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "notHoldOperationId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected TwilioOperation  notHoldOperation;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "twilioSubAccountId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected TwilioSubAccount twilioSubAccount;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new TwilioAgentInfo object.
   */
  public TwilioAgentInfo() { }

  /**
   * Creates a new TwilioAgentInfo object.
   *
   * @param  agentCallSid           DOCUMENT ME!
   * @param  agentId                DOCUMENT ME!
   * @param  clickDisconnect        DOCUMENT ME!
   * @param  connectPhoneNumber     DOCUMENT ME!
   * @param  createDate             DOCUMENT ME!
   * @param  currentConferenceName  DOCUMENT ME!
   * @param  currentConferenceSid   DOCUMENT ME!
   * @param  disconnectDate         DOCUMENT ME!
   * @param  hangup                 DOCUMENT ME!
   * @param  inboundConnect         DOCUMENT ME!
   * @param  talking                DOCUMENT ME!
   * @param  lastOperation          DOCUMENT ME!
   * @param  lastUpdateDate         DOCUMENT ME!
   * @param  notHoldOperation       DOCUMENT ME!
   * @param  twilioSubAccount       TwilioSubAccount
   */
  public TwilioAgentInfo(String agentCallSid, Long agentId, boolean clickDisconnect, String connectPhoneNumber,
    Date createDate, String currentConferenceName, String currentConferenceSid, Date disconnectDate, boolean hangup,
    boolean inboundConnect, boolean talking, TwilioOperation lastOperation, Date lastUpdateDate,
    TwilioOperation notHoldOperation, TwilioSubAccount twilioSubAccount) {
    this.agentCallSid          = agentCallSid;
    this.agentId               = agentId;
    this.clickDisconnect       = clickDisconnect;
    this.connectPhoneNumber    = connectPhoneNumber;
    this.createDate            = createDate;
    this.currentConferenceName = currentConferenceName;
    this.currentConferenceSid  = currentConferenceSid;
    this.disconnectDate        = disconnectDate;
    this.hangup                = hangup;
    this.inboundConnect        = inboundConnect;
    isTalking                  = talking;
    this.lastOperation         = lastOperation;
    this.lastUpdateDate        = lastUpdateDate;
    this.notHoldOperation      = notHoldOperation;
    this.twilioSubAccount      = twilioSubAccount;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

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
   * getter method for connect phone number.
   *
   * @return  String
   */
  public String getConnectPhoneNumber() {
    return connectPhoneNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for create date.
   *
   * @return  Date
   */
  public Date getCreateDate() {
    return createDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for current conference name.
   *
   * @return  String
   */
  public String getCurrentConferenceName() {
    return currentConferenceName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for current conference sid.
   *
   * @return  String
   */
  public String getCurrentConferenceSid() {
    return currentConferenceSid;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for disconnect date.
   *
   * @return  Date
   */
  public Date getDisconnectDate() {
    return disconnectDate;
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
   * getter method for last operation.
   *
   * @return  TwilioOperation
   */
  public TwilioOperation getLastOperation() {
    return lastOperation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last update date.
   *
   * @return  Date
   */
  public Date getLastUpdateDate() {
    return lastUpdateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for not hold operation.
   *
   * @return  TwilioOperation
   */
  public TwilioOperation getNotHoldOperation() {
    return notHoldOperation;
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
   * getter method for click disconnect.
   *
   * @return  boolean
   */
  public boolean isClickDisconnect() {
    return clickDisconnect;
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
   * getter method for inbound connect.
   *
   * @return  boolean
   */
  public boolean isInboundConnect() {
    return inboundConnect;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for releasing.
   *
   * @return  boolean
   */
  public boolean isReleasing() {
    return isReleasing;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for talking.
   *
   * @return  boolean
   */
  public boolean isTalking() {
    return isTalking;
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
   * setter method for click disconnect.
   *
   * @param  clickDisconnect  boolean
   */
  public void setClickDisconnect(boolean clickDisconnect) {
    this.clickDisconnect = clickDisconnect;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for connect phone number.
   *
   * @param  connectPhoneNumber  String
   */
  public void setConnectPhoneNumber(String connectPhoneNumber) {
    this.connectPhoneNumber = connectPhoneNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for create date.
   *
   * @param  createDate  Date
   */
  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for current conference name.
   *
   * @param  currentConferenceName  String
   */
  public void setCurrentConferenceName(String currentConferenceName) {
    this.currentConferenceName = currentConferenceName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for current conference sid.
   *
   * @param  currentConferenceSid  String
   */
  public void setCurrentConferenceSid(String currentConferenceSid) {
    this.currentConferenceSid = currentConferenceSid;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for disconnect date.
   *
   * @param  disconnectDate  Date
   */
  public void setDisconnectDate(Date disconnectDate) {
    this.disconnectDate = disconnectDate;
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
   * setter method for id.
   *
   * @param  id  Long
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for inbound connect.
   *
   * @param  inboundConnect  boolean
   */
  public void setInboundConnect(boolean inboundConnect) {
    this.inboundConnect = inboundConnect;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last operation.
   *
   * @param  lastOperation  TwilioOperation
   */
  public void setLastOperation(TwilioOperation lastOperation) {
    this.lastOperation = lastOperation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last update date.
   *
   * @param  lastUpdateDate  Date
   */
  public void setLastUpdateDate(Date lastUpdateDate) {
    this.lastUpdateDate = lastUpdateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for not hold operation.
   *
   * @param  notHoldOperation  TwilioOperation
   */
  public void setNotHoldOperation(TwilioOperation notHoldOperation) {
    this.notHoldOperation = notHoldOperation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for releasing.
   *
   * @param  releasing  boolean
   */
  public void setReleasing(boolean releasing) {
    isReleasing = releasing;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for talking.
   *
   * @param  talking  boolean
   */
  public void setTalking(boolean talking) {
    isTalking = talking;
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
} // end class TwilioAgentInfo
