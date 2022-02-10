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
 * @version  10/15/2014 16:08
 */
@Entity
@Table(
  name    = "TwilioConference",
  indexes = {
    @javax.persistence.Index(
      name = "idx_TwilioConference_createAgentId",
      columnList = "createAgentId"
    ),
    @javax.persistence.Index(
      name = "idx_TwilioConference_customerCallSid",
      columnList = "customerCallSid"
    )
  }
)
public class TwilioConference extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 3258367901267865432L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char",
    nullable         = false
  )
  @Convert(converter = StringBooleanConverter.class)
  protected boolean cancel = false;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String conferenceName;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String conferenceSid;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "createAgentId",
    insertable = true,
    updatable  = false,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected User createAgent;

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
    columnDefinition = "char",
    nullable         = false
  )
  @Convert(converter = StringBooleanConverter.class)
  protected boolean inbound = true;

  //~ Methods ----------------------------------------------------------------------------------------------------------

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
   * getter method for create agent.
   *
   * @return  User
   */
  public User getCreateAgent() {
    return createAgent;
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
   * getter method for cancel.
   *
   * @return  boolean
   */
  public boolean isCancel() {
    return cancel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for inbound.
   *
   * @return  boolean
   */
  public boolean isInbound() {
    return inbound;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for cancel.
   *
   * @param  cancel  boolean
   */
  public void setCancel(boolean cancel) {
    this.cancel = cancel;
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
   * setter method for create agent.
   *
   * @param  createAgent  User
   */
  public void setCreateAgent(User createAgent) {
    this.createAgent = createAgent;
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
   * @param  inbound  boolean
   */
  public void setInbound(boolean inbound) {
    this.inbound = inbound;
  }
} // end class TwilioConference
