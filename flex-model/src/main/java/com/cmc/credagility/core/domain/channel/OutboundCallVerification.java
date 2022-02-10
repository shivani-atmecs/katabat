package com.cmc.credagility.core.domain.channel;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.activity.AgentCallActivity;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.customer.Customer;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.domain.user.User;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.LinkedHashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/15/2014 10:31
 */
@Entity
@Table(name = "OutboundCallVerification")
public class OutboundCallVerification extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "outboundCallVerification",
    cascade  = CascadeType.ALL
  )
  protected Set<AgentCallActivity> activitys = new LinkedHashSet<AgentCallActivity>();

  /** agent id. */
  @JoinColumn(
    name     = "agentId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected User agent;

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean callOutcomeDisposed;


  /** channel type of out bound call. */
  @Column(
    name     = "channelType",
    length   = 100,
    nullable = false
  )
  protected String channelType;


  /** customer id map to customer. */
  @JoinColumn(name = "customerId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected Customer customer;


  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String destinationType;


  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String disposeOutcome;


  /** pk. */
  @Column
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long         id;

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean isRPC;


  /** phone number. */
  @Column(
    name     = "phoneNumber",
    length   = 20,
    nullable = false
  )
  protected String phoneNumber;

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean processDisposed;


  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String spokeTo;


  /** verification status. */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean verified;

  @JoinColumn(name = "accountNum")
  @ManyToOne(fetch = FetchType.LAZY)
  private Account account;

  @Column private Long outboundId;

  @JoinColumn(name = "responsibleId")
  @ManyToOne(fetch = FetchType.LAZY)
  private Responsible responsible;

  //~ Methods ----------------------------------------------------------------------------------------------------------

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
   * getter method for activitys.
   *
   * @return  Set
   */
  public Set<AgentCallActivity> getActivitys() {
    return activitys;
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
   * getter method for call outcome disposed.
   *
   * @return  Boolean
   */
  public Boolean getCallOutcomeDisposed() {
    return callOutcomeDisposed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for channel type.
   *
   * @return  String
   */
  public String getChannelType() {
    return channelType;
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
   * getter method for destination type.
   *
   * @return  String
   */
  public String getDestinationType() {
    return destinationType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for dispose outcome.
   *
   * @return  String
   */
  public String getDisposeOutcome() {
    return disposeOutcome;
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
   * getter method for is RPC.
   *
   * @return  Boolean
   */
  public Boolean getIsRPC() {
    return isRPC;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for outbound id.
   *
   * @return  Long
   */
  public Long getOutboundId() {
    return outboundId;
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
   * getter method for spoke to.
   *
   * @return  String
   */
  public String getSpokeTo() {
    return spokeTo;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for verified.
   *
   * @return  Boolean
   */
  public Boolean getVerified() {
    return verified;
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
   * setter method for activitys.
   *
   * @param  activitys  Set
   */
  public void setActivitys(Set<AgentCallActivity> activitys) {
    this.activitys = activitys;
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
   * setter method for call outcome disposed.
   *
   * @param  callOutcomeDisposed  Boolean
   */
  public void setCallOutcomeDisposed(Boolean callOutcomeDisposed) {
    this.callOutcomeDisposed = callOutcomeDisposed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for channel type.
   *
   * @param  channelType  String
   */
  public void setChannelType(String channelType) {
    this.channelType = channelType;
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
   * setter method for destination type.
   *
   * @param  destinationType  String
   */
  public void setDestinationType(String destinationType) {
    this.destinationType = destinationType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for dispose outcome.
   *
   * @param  disposeOutcome  String
   */
  public void setDisposeOutcome(String disposeOutcome) {
    this.disposeOutcome = disposeOutcome;
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
   * setter method for is RPC.
   *
   * @param  isRPC  Boolean
   */
  public void setIsRPC(Boolean isRPC) {
    this.isRPC = isRPC;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for outbound id.
   *
   * @param  outboundId  Long
   */
  public void setOutboundId(Long outboundId) {
    this.outboundId = outboundId;
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
   * setter method for spoke to.
   *
   * @param  spokeTo  String
   */
  public void setSpokeTo(String spokeTo) {
    this.spokeTo = spokeTo;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for verified.
   *
   * @param  verified  Boolean
   */
  public void setVerified(Boolean verified) {
    this.verified = verified;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#toString()
   */
  @Override public String toString() {
    return "OutboundCallVerification{"
      + "id=" + id
      + ", agent=" + agent
      + ", phoneNumber='" + phoneNumber + '\''
      + ", channelType='" + channelType + '\''
      + ", destinationType='" + destinationType + '\''
      + ", spokeTo='" + spokeTo + '\''
      + ", disposeOutcome='" + disposeOutcome + '\''
      + ", verified=" + verified
      + ", customer=" + customer
      + ", account=" + account
      + ", responsible=" + responsible
      + ", outboundId=" + outboundId
      + '}';
  }
} // end class OutboundCallVerification
