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
 * @version  10/15/2014 16:03
 */
@Entity
@Table(
  name    = "TwilioCall",
  indexes = {
    @javax.persistence.Index(
      name = "idx_TwilioCall_agentInfo",
      columnList = "agentInfoId"
    ),
    @javax.persistence.Index(
      name = "idx_TwilioCall_conferenceSid",
      columnList = "conferenceSid"
    ),
    @javax.persistence.Index(
      name = "idx_TwilioCall_createDate",
      columnList = "createDate"
    ),
    @javax.persistence.Index(
      name = "idx_TwilioCall_customerCallSid",
      columnList = "customerCallSid"
    ),
    @javax.persistence.Index(
      name = "idx_TwilioCall_customerInfo",
      columnList = "customerInfoId"
    ),
    @javax.persistence.Index(
      name = "idx_TwilioCall_invitedPhoneNumber",
      columnList = "invitedPhoneNumberId"
    )
  }
)
public class TwilioCall implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -2963009253253390525L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "agentInfoId",
    insertable = true,
    updatable  = false,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected TwilioAgentInfo agentInfo;

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean         allowSyncDisposeInfo = false;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String conferenceName;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String conferenceSid;


  /** TODO: DOCUMENT ME! */
  protected Date createDate;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String customerCallSid;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "customerInfoId",
    insertable = true,
    updatable  = false,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected TwilioCustomerInfo customerInfo;


  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char",
    nullable         = false
  )
  @Convert(converter = StringBooleanConverter.class)
  protected boolean exited = false;


  /** TODO: DOCUMENT ME! */
  protected Date exitedDate;


  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "invitedPhoneNumberId",
    insertable = true,
    updatable  = false,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected TwilioInvitedPhoneNumber invitedPhoneNumber;


  /** TODO: DOCUMENT ME! */
  protected Date lastUpdateDate;


  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char",
    nullable         = false
  )
  @Convert(converter = StringBooleanConverter.class)
  protected boolean needDisposed = true;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new TwilioCall object.
   */
  public TwilioCall() { }

  /**
   * Creates a new TwilioCall object.
   *
   * @param  agentInfo           DOCUMENT ME!
   * @param  conferenceName      DOCUMENT ME!
   * @param  conferenceSid       DOCUMENT ME!
   * @param  createDate          DOCUMENT ME!
   * @param  customerCallSid     DOCUMENT ME!
   * @param  customerInfo        DOCUMENT ME!
   * @param  exited              DOCUMENT ME!
   * @param  exitedDate          DOCUMENT ME!
   * @param  invitedPhoneNumber  DOCUMENT ME!
   * @param  lastUpdateDate      DOCUMENT ME!
   */
  public TwilioCall(TwilioAgentInfo agentInfo, String conferenceName, String conferenceSid, Date createDate,
    String customerCallSid, TwilioCustomerInfo customerInfo, boolean exited, Date exitedDate,
    TwilioInvitedPhoneNumber invitedPhoneNumber, Date lastUpdateDate) {
    this.agentInfo          = agentInfo;
    this.conferenceName     = conferenceName;
    this.conferenceSid      = conferenceSid;
    this.createDate         = createDate;
    this.customerCallSid    = customerCallSid;
    this.customerInfo       = customerInfo;
    this.exited             = exited;
    this.exitedDate         = exitedDate;
    this.invitedPhoneNumber = invitedPhoneNumber;
    this.lastUpdateDate     = lastUpdateDate;
  }

  /**
   * Creates a new TwilioCall object.
   *
   * @param  agentInfo           DOCUMENT ME!
   * @param  conferenceName      DOCUMENT ME!
   * @param  conferenceSid       DOCUMENT ME!
   * @param  createDate          DOCUMENT ME!
   * @param  customerCallSid     DOCUMENT ME!
   * @param  customerInfo        DOCUMENT ME!
   * @param  exited              DOCUMENT ME!
   * @param  exitedDate          DOCUMENT ME!
   * @param  invitedPhoneNumber  DOCUMENT ME!
   * @param  lastUpdateDate      DOCUMENT ME!
   * @param  needDisposed        DOCUMENT ME!
   */
  public TwilioCall(TwilioAgentInfo agentInfo, String conferenceName, String conferenceSid, Date createDate,
    String customerCallSid, TwilioCustomerInfo customerInfo, boolean exited, Date exitedDate,
    TwilioInvitedPhoneNumber invitedPhoneNumber, Date lastUpdateDate, boolean needDisposed) {
    this.agentInfo          = agentInfo;
    this.conferenceName     = conferenceName;
    this.conferenceSid      = conferenceSid;
    this.createDate         = createDate;
    this.customerCallSid    = customerCallSid;
    this.customerInfo       = customerInfo;
    this.exited             = exited;
    this.exitedDate         = exitedDate;
    this.invitedPhoneNumber = invitedPhoneNumber;
    this.lastUpdateDate     = lastUpdateDate;
    this.needDisposed       = needDisposed;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for agent info.
   *
   * @return  TwilioAgentInfo
   */
  public TwilioAgentInfo getAgentInfo() {
    return agentInfo;
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
   * getter method for create date.
   *
   * @return  Date
   */
  public Date getCreateDate() {
    return createDate;
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
   * getter method for customer info.
   *
   * @return  TwilioCustomerInfo
   */
  public TwilioCustomerInfo getCustomerInfo() {
    return customerInfo;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for exited date.
   *
   * @return  Date
   */
  public Date getExitedDate() {
    return exitedDate;
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
   * getter method for invited phone number.
   *
   * @return  TwilioInvitedPhoneNumber
   */
  public TwilioInvitedPhoneNumber getInvitedPhoneNumber() {
    return invitedPhoneNumber;
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
   * getter method for exited.
   *
   * @return  boolean
   */
  public boolean isExited() {
    return exited;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for need disposed.
   *
   * @return  boolean
   */
  public boolean isNeedDisposed() {
    return needDisposed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agent info.
   *
   * @param  agentInfo  TwilioAgentInfo
   */
  public void setAgentInfo(TwilioAgentInfo agentInfo) {
    this.agentInfo = agentInfo;
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
   * setter method for create date.
   *
   * @param  createDate  Date
   */
  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
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
   * setter method for customer info.
   *
   * @param  customerInfo  TwilioCustomerInfo
   */
  public void setCustomerInfo(TwilioCustomerInfo customerInfo) {
    this.customerInfo = customerInfo;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for exited.
   *
   * @param  exited  boolean
   */
  public void setExited(boolean exited) {
    this.exited = exited;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for exited date.
   *
   * @param  exitedDate  Date
   */
  public void setExitedDate(Date exitedDate) {
    this.exitedDate = exitedDate;
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
   * setter method for invited phone number.
   *
   * @param  invitedPhoneNumber  TwilioInvitedPhoneNumber
   */
  public void setInvitedPhoneNumber(TwilioInvitedPhoneNumber invitedPhoneNumber) {
    this.invitedPhoneNumber = invitedPhoneNumber;
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
   * setter method for need disposed.
   *
   * @param  needDisposed  boolean
   */
  public void setNeedDisposed(boolean needDisposed) {
    this.needDisposed = needDisposed;
  }
} // end class TwilioCall
