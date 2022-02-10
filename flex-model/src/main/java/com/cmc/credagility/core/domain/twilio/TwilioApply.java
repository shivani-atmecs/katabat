package com.cmc.credagility.core.domain.twilio;

import java.io.Serializable;

import java.util.Date;

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

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.user.User;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/15/2014 15:26
 */
@Entity
@Table(
  name    = "TwilioApply",
  indexes = {
    @javax.persistence.Index(
      name = "idx_TwilioApply_apply",
      columnList = "applyId"
    ),
    @javax.persistence.Index(
      name = "idx_TwilioApply_customerCallSid",
      columnList = "customerCallSid"
    ),
    @javax.persistence.Index(
      name = "idx_TwilioApply_recipientId",
      columnList = "recipientId"
    )
  }
)
public class TwilioApply extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 6917537139678712403L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "applyId",
    insertable = true,
    updatable  = false,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected User apply;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String applyCallSid;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String applyConferenceName;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String applyConferenceSid;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String callSerial;


  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char",
    nullable         = false
  )
  @Convert(converter = StringBooleanConverter.class)
  protected boolean cancelRead = false;


  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String customerCallSid;

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
  protected Boolean isInbound;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "recipientId",
    insertable = true,
    updatable  = false,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected User recipient;


  /** TODO: DOCUMENT ME! */
  @Column(length = 10)
  @Enumerated(EnumType.STRING)
  protected TwilioApplyAnswer recipientAnswer = TwilioApplyAnswer.Send;


  /** TODO: DOCUMENT ME! */
  protected long timeout = 60 * 1000;


  /** TODO: DOCUMENT ME! */
  @Column(length = 32)
  @Enumerated(EnumType.STRING)
  protected TwilioApplyType type = TwilioApplyType.Conference;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for apply.
   *
   * @return  User
   */
  public User getApply() {
    return apply;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for apply call sid.
   *
   * @return  String
   */
  public String getApplyCallSid() {
    return applyCallSid;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for apply conference name.
   *
   * @return  String
   */
  public String getApplyConferenceName() {
    return applyConferenceName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for apply conference sid.
   *
   * @return  String
   */
  public String getApplyConferenceSid() {
    return applyConferenceSid;
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
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#getCreateDate()
   */
  @Override public Date getCreateDate() {
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
   * getter method for recipient.
   *
   * @return  User
   */
  public User getRecipient() {
    return recipient;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for recipient answer.
   *
   * @return  TwilioApplyAnswer
   */
  public TwilioApplyAnswer getRecipientAnswer() {
    return recipientAnswer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for timeout.
   *
   * @return  long
   */
  public long getTimeout() {
    return timeout;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for type.
   *
   * @return  TwilioApplyType
   */
  public TwilioApplyType getType() {
    return type;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for cancel read.
   *
   * @return  boolean
   */
  public boolean isCancelRead() {
    return cancelRead;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for apply.
   *
   * @param  apply  User
   */
  public void setApply(User apply) {
    this.apply = apply;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for apply call sid.
   *
   * @param  applyCallSid  String
   */
  public void setApplyCallSid(String applyCallSid) {
    this.applyCallSid = applyCallSid;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for apply conference name.
   *
   * @param  applyConferenceName  String
   */
  public void setApplyConferenceName(String applyConferenceName) {
    this.applyConferenceName = applyConferenceName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for apply conference sid.
   *
   * @param  applyConferenceSid  String
   */
  public void setApplyConferenceSid(String applyConferenceSid) {
    this.applyConferenceSid = applyConferenceSid;
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
   * setter method for cancel read.
   *
   * @param  cancelRead  boolean
   */
  public void setCancelRead(boolean cancelRead) {
    this.cancelRead = cancelRead;
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
   * setter method for recipient.
   *
   * @param  recipient  User
   */
  public void setRecipient(User recipient) {
    this.recipient = recipient;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for recipient answer.
   *
   * @param  recipientAnswer  TwilioApplyAnswer
   */
  public void setRecipientAnswer(TwilioApplyAnswer recipientAnswer) {
    this.recipientAnswer = recipientAnswer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for timeout.
   *
   * @param  timeout  long
   */
  public void setTimeout(long timeout) {
    this.timeout = timeout;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for type.
   *
   * @param  type  TwilioApplyType
   */
  public void setType(TwilioApplyType type) {
    this.type = type;
  }
} // end class TwilioApply
