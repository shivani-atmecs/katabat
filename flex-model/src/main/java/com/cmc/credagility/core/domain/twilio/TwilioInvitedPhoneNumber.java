package com.cmc.credagility.core.domain.twilio;

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/15/2014 17:11
 */
@Entity
@Table(
  name    = "TwilioInvitedPhoneNumber",
  indexes = {
    @javax.persistence.Index(
      name = "idx_TwilioInvitedPhoneNumber_callSid",
      columnList = "callSid"
    ),
    @javax.persistence.Index(
      name = "idx_TwilioInvitedPhoneNumber_createDate",
      columnList = "createDate"
    )
  }
)
public class TwilioInvitedPhoneNumber implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 5919393538835757175L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  protected Date answeredDate;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String callSid;


  /** TODO: DOCUMENT ME! */
  protected Date createDate;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String currentConferenceSid;


  /** TODO: DOCUMENT ME! */
  protected Date disconnectDate;


  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char",
    nullable         = false
  )
  @Convert(converter = StringBooleanConverter.class)
  protected boolean hangup = false;


  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;


  /** TODO: DOCUMENT ME! */
  protected Long inviter;

  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char",
    nullable         = false
  )
  @Convert(converter = StringBooleanConverter.class)
  protected boolean kicked = false;


  /** TODO: DOCUMENT ME! */
  protected Date lastUpdateDate;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String phoneNumber;


  /** TODO: DOCUMENT ME! */
  @Column(length = 20)
  @Enumerated(EnumType.STRING)
  protected TwilioCallNumberStatus status = TwilioCallNumberStatus.Ringing;

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
   * Creates a new TwilioInvitedPhoneNumber object.
   */
  public TwilioInvitedPhoneNumber() { }

  /**
   * Creates a new TwilioInvitedPhoneNumber object.
   *
   * @param  answeredDate          DOCUMENT ME!
   * @param  callSid               DOCUMENT ME!
   * @param  createDate            DOCUMENT ME!
   * @param  currentConferenceSid  DOCUMENT ME!
   * @param  disconnectDate        DOCUMENT ME!
   * @param  hangup                DOCUMENT ME!
   * @param  inviter               DOCUMENT ME!
   * @param  kicked                DOCUMENT ME!
   * @param  lastUpdateDate        DOCUMENT ME!
   * @param  phoneNumber           DOCUMENT ME!
   * @param  status                DOCUMENT ME!
   * @param  twilioSubAccount      TwilioSubAccount
   */
  public TwilioInvitedPhoneNumber(Date answeredDate, String callSid, Date createDate, String currentConferenceSid,
    Date disconnectDate, boolean hangup, Long inviter, boolean kicked, Date lastUpdateDate, String phoneNumber,
    TwilioCallNumberStatus status, TwilioSubAccount twilioSubAccount) {
    this.answeredDate         = answeredDate;
    this.callSid              = callSid;
    this.createDate           = createDate;
    this.currentConferenceSid = currentConferenceSid;
    this.disconnectDate       = disconnectDate;
    this.hangup               = hangup;
    this.inviter              = inviter;
    this.kicked               = kicked;
    this.lastUpdateDate       = lastUpdateDate;
    this.phoneNumber          = phoneNumber;
    this.status               = status;
    this.twilioSubAccount     = twilioSubAccount;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for answered date.
   *
   * @return  Date
   */
  public Date getAnsweredDate() {
    return answeredDate;
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
   * getter method for create date.
   *
   * @return  Date
   */
  public Date getCreateDate() {
    return createDate;
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
   * getter method for inviter.
   *
   * @return  Long
   */
  public Long getInviter() {
    return inviter;
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
   * getter method for phone number.
   *
   * @return  String
   */
  public String getPhoneNumber() {
    return phoneNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status.
   *
   * @return  TwilioCallNumberStatus
   */
  public TwilioCallNumberStatus getStatus() {
    return status;
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
   * getter method for hangup.
   *
   * @return  boolean
   */
  public boolean isHangup() {
    return hangup;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for kicked.
   *
   * @return  boolean
   */
  public boolean isKicked() {
    return kicked;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for answered date.
   *
   * @param  answeredDate  Date
   */
  public void setAnsweredDate(Date answeredDate) {
    this.answeredDate = answeredDate;
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
   * setter method for create date.
   *
   * @param  createDate  Date
   */
  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
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
   * setter method for inviter.
   *
   * @param  inviter  Long
   */
  public void setInviter(Long inviter) {
    this.inviter = inviter;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for kicked.
   *
   * @param  kicked  boolean
   */
  public void setKicked(boolean kicked) {
    this.kicked = kicked;
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
   * setter method for phone number.
   *
   * @param  phoneNumber  String
   */
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for status.
   *
   * @param  status  TwilioCallNumberStatus
   */
  public void setStatus(TwilioCallNumberStatus status) {
    this.status = status;
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
} // end class TwilioInvitedPhoneNumber
