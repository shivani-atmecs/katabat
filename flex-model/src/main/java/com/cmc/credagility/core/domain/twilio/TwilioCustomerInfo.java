package com.cmc.credagility.core.domain.twilio;

import com.cmc.credagility.core.domain.customer.Customer;
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
 * @version  10/15/2014 16:55
 */
@Entity
@Table(
  name    = "TwilioCustomerInfo",
  indexes = {
    @javax.persistence.Index(
      name = "idx_TwilioCustomerInfo_createDate",
      columnList = "createDate"
    ),
    @javax.persistence.Index(
      name = "idx_TwilioCustomerInfo_customerCallSid",
      columnList = "customerCallSid"
    )
  }
)
public class TwilioCustomerInfo implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -8926923759634485468L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  protected Long accountNum;

  /** TODO: DOCUMENT ME! */
  protected Date createDate;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String currentConferenceSid;

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
  protected Date disconnectDate;


  /** TODO: DOCUMENT ME! */
  protected Long firstAgentId;

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
  @Column(
    length           = 1,
    columnDefinition = "char",
    nullable         = false
  )
  @Convert(converter = StringBooleanConverter.class)
  protected boolean isHold = false;


  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean isInbound;


  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char",
    nullable         = false
  )
  @Convert(converter = StringBooleanConverter.class)
  protected boolean isRecording = true;


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
  @Enumerated(EnumType.STRING)
  protected TwilioMode mode = TwilioMode.Normal;


  /** TODO: DOCUMENT ME! */
  protected Long responsibleId;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "twilioSubAccountId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected TwilioSubAccount twilioSubAccount;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new TwilioCustomerInfo object.
   */
  public TwilioCustomerInfo() { }

  /**
   * Creates a new TwilioCustomerInfo object.
   *
   * @param  createDate            DOCUMENT ME!
   * @param  currentConferenceSid  DOCUMENT ME!
   * @param  customerCallSid       DOCUMENT ME!
   * @param  customerPhoneNumber   DOCUMENT ME!
   * @param  disconnectDate        DOCUMENT ME!
   * @param  firstAgentId          DOCUMENT ME!
   * @param  hangup                DOCUMENT ME!
   * @param  hold                  DOCUMENT ME!
   * @param  inbound               DOCUMENT ME!
   * @param  kicked                DOCUMENT ME!
   * @param  lastUpdateDate        DOCUMENT ME!
   * @param  mode                  DOCUMENT ME!
   */
  public TwilioCustomerInfo(Date createDate, String currentConferenceSid, String customerCallSid,
    String customerPhoneNumber, Date disconnectDate, Long firstAgentId, boolean hangup, boolean hold, Boolean inbound,
    boolean kicked, Date lastUpdateDate, TwilioMode mode) {
    this.createDate           = createDate;
    this.currentConferenceSid = currentConferenceSid;
    this.customerCallSid      = customerCallSid;
    this.customerPhoneNumber  = customerPhoneNumber;
    this.disconnectDate       = disconnectDate;
    this.firstAgentId         = firstAgentId;
    this.hangup               = hangup;
    isHold                    = hold;
    isInbound                 = inbound;
    this.kicked               = kicked;
    this.lastUpdateDate       = lastUpdateDate;
    this.mode                 = mode;
  }

  /**
   * Creates a new TwilioCustomerInfo object.
   *
   * @param  accountNum            DOCUMENT ME!
   * @param  createDate            DOCUMENT ME!
   * @param  currentConferenceSid  DOCUMENT ME!
   * @param  customerCallSid       DOCUMENT ME!
   * @param  customerPhoneNumber   DOCUMENT ME!
   * @param  disconnectDate        DOCUMENT ME!
   * @param  firstAgentId          DOCUMENT ME!
   * @param  hangup                DOCUMENT ME!
   * @param  hold                  DOCUMENT ME!
   * @param  inbound               DOCUMENT ME!
   * @param  kicked                DOCUMENT ME!
   * @param  lastUpdateDate        DOCUMENT ME!
   * @param  mode                  DOCUMENT ME!
   * @param  responsibleId         DOCUMENT ME!
   * @param  customerId            Long
   */
  public TwilioCustomerInfo(Long accountNum, Date createDate, String currentConferenceSid, String customerCallSid,
    String customerPhoneNumber, Date disconnectDate, Long firstAgentId, boolean hangup, boolean hold, Boolean inbound,
    boolean kicked, Date lastUpdateDate, TwilioMode mode, Long responsibleId, Long customerId) {
    this.accountNum           = accountNum;
    this.createDate           = createDate;
    this.currentConferenceSid = currentConferenceSid;
    this.customerCallSid      = customerCallSid;
    this.customerPhoneNumber  = customerPhoneNumber;
    this.disconnectDate       = disconnectDate;
    this.firstAgentId         = firstAgentId;
    this.hangup               = hangup;
    isHold                    = hold;
    isInbound                 = inbound;
    this.kicked               = kicked;
    this.lastUpdateDate       = lastUpdateDate;
    this.mode                 = mode;
    this.responsibleId        = responsibleId;
    this.customerId           = customerId;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for account num.
   *
   * @return  Long
   */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  public Long getAccountNum() {
    return accountNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for create date.
   *
   * @return  Date
   */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  public Date getCreateDate() {
    return createDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for current conference sid.
   *
   * @return  String
   */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  public String getCurrentConferenceSid() {
    return currentConferenceSid;
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
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
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
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  public String getCustomerPhoneNumber() {
    return customerPhoneNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for disconnect date.
   *
   * @return  Date
   */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  public Date getDisconnectDate() {
    return disconnectDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for first agent id.
   *
   * @return  Long
   */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  public Long getFirstAgentId() {
    return firstAgentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for id.
   *
   * @return  Long
   */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for inbound.
   *
   * @return  Boolean
   */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  public Boolean getInbound() {
    return isInbound;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last update date.
   *
   * @return  Date
   */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  public Date getLastUpdateDate() {
    return lastUpdateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for mode.
   *
   * @return  TwilioMode
   */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  public TwilioMode getMode() {
    return mode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible id.
   *
   * @return  Long
   */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  public Long getResponsibleId() {
    return responsibleId;
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
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  public boolean isHangup() {
    return hangup;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for hold.
   *
   * @return  boolean
   */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  public boolean isHold() {
    return isHold;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for kicked.
   *
   * @return  boolean
   */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  public boolean isKicked() {
    return kicked;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for recording.
   *
   * @return  boolean
   */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  public boolean isRecording() {
    return isRecording;
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
   * setter method for disconnect date.
   *
   * @param  disconnectDate  Date
   */
  public void setDisconnectDate(Date disconnectDate) {
    this.disconnectDate = disconnectDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for first agent id.
   *
   * @param  firstAgentId  Long
   */
  public void setFirstAgentId(Long firstAgentId) {
    this.firstAgentId = firstAgentId;
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
   * setter method for hold.
   *
   * @param  hold  boolean
   */
  public void setHold(boolean hold) {
    isHold = hold;
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
   * setter method for mode.
   *
   * @param  mode  TwilioMode
   */
  public void setMode(TwilioMode mode) {
    this.mode = mode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for recording.
   *
   * @param  isRecording  boolean
   */
  public void setRecording(boolean isRecording) {
    this.isRecording = isRecording;
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
   * setter method for twilio sub account.
   *
   * @param  twilioSubAccount  TwilioSubAccount
   */
  public void setTwilioSubAccount(TwilioSubAccount twilioSubAccount) {
    this.twilioSubAccount = twilioSubAccount;
  }
} // end class TwilioCustomerInfo
