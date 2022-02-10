package com.cmc.credagility.core.domain.disposition;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.domain.user.User;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/15/2014 11:15
 */
@Entity
@Table(name = "PhoneCallDisposition")
public class PhoneCallDisposition extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
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

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = false,
    length   = 255
  )
  protected String callSid;


  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String channelType;


  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String destinationType;


  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean disposed = false;


  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String disposeOutcome;


  /** TODO: DOCUMENT ME! */
  @Column
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long         id;


  /** TODO: DOCUMENT ME! */
  @Column protected Long inboundId;

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean isRPC;


  /** TODO: DOCUMENT ME! */
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
  @JoinColumn(name = "responsibleId")
  @ManyToOne(fetch = FetchType.EAGER)
  protected Responsible responsible;


  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String spokeTo;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    PhoneCallDisposition that = (PhoneCallDisposition) o;

    if ((id != null) ? (!id.equals(that.id)) : (that.id != null)) {
      return false;
    }

    return true;
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
   * getter method for call sid.
   *
   * @return  String
   */
  public String getCallSid() {
    return callSid;
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
   * getter method for destination type.
   *
   * @return  String
   */
  public String getDestinationType() {
    return destinationType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for disposed.
   *
   * @return  Boolean
   */
  public Boolean getDisposed() {
    return disposed;
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
   * getter method for inbound id.
   *
   * @return  Long
   */
  public Long getInboundId() {
    return inboundId;
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
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = 31;
    result = (31 * result) + ((id != null) ? id.hashCode() : 0);

    return result;
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
   * setter method for call sid.
   *
   * @param  callSid  String
   */
  public void setCallSid(String callSid) {
    this.callSid = callSid;
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
   * setter method for destination type.
   *
   * @param  destinationType  String
   */
  public void setDestinationType(String destinationType) {
    this.destinationType = destinationType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for disposed.
   *
   * @param  disposed  Boolean
   */
  public void setDisposed(Boolean disposed) {
    this.disposed = disposed;
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
   * DOCUMENT ME!
   *
   * @param  inboundId  DOCUMENT ME!
   */
  public void setInboundId(Long inboundId) {
    this.inboundId = inboundId;
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
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#toString()
   */
  @Override public String toString() {
    return "PhoneCallDisposition{"
      + "id=" + id
      + ", agent=" + ((agent == null) ? null : agent.getId())
      + ", callSid=" + callSid
      + ", inboundId=" + inboundId
      + ", phoneNumber='" + phoneNumber + '\''
      + ", responsibleId=" + ((responsible == null) ? null : responsible.getResponsibleId())
      + ", disposed=" + disposed
      + ", channelType=" + channelType
      + ", destinationType=" + destinationType
      + ", spokeTo=" + spokeTo
      + ", disposeOutcome=" + disposeOutcome
      + '}';
  }
} // end class PhoneCallDisposition
