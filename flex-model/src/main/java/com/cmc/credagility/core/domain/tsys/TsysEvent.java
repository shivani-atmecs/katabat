package com.cmc.credagility.core.domain.tsys;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.user.User;
import com.cmc.credagility.core.domain.webactivity.Session;


/**
 * This class is used to store Tsys Event.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/15/2014 17:40
 */
@Entity
@Table(
  name    = "TsysEvent",
  indexes = {
    @Index(
      name = "eventTransViewKeyIndex",
      columnList = "transViewKey"
    )
  }
)
public class TsysEvent extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -952437332095678984L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "accountNum",
    updatable = false
  )
  @ManyToOne protected Account account;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "agentId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected User agent;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "eventDataKey",
    updatable = false,
    length    = 255
  )
  protected String eventDataKey;


  /** TODO: DOCUMENT ME! */
  @Column(name = "eventDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date eventDate;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "eventName",
    length = 5000
  )
  protected String eventName;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "eventType",
    nullable = false,
    length   = 255
  )
  protected String eventType;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "tsysEventId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "operatorId",
    length = 25
  )
  protected String operatorId;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "sessionId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected Session session;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "transViewKey",
    nullable = false,
    length   = 255
  )
  protected String transViewKey;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    TsysEvent tsysEvent = (TsysEvent) o;

    if (!eventDate.equals(tsysEvent.getEventDate())) {
      return false;
    }

    if (!eventName.equals(tsysEvent.getEventName())) {
      return false;
    }

    if (!eventDataKey.equals(tsysEvent.eventDataKey)) {
      return false;
    }

    if (!eventType.equals(tsysEvent.eventType)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

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
   * getter method for agent.
   *
   * @return  User
   */
  public User getAgent() {
    return agent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for event data key.
   *
   * @return  String
   */
  public String getEventDataKey() {
    return eventDataKey;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for event date.
   *
   * @return  Date
   */
  public Date getEventDate() {
    return eventDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for event name.
   *
   * @return  String
   */
  public String getEventName() {
    return eventName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for event type.
   *
   * @return  String
   */
  public String getEventType() {
    return eventType;
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
   * getter method for operator id.
   *
   * @return  String
   */
  public String getOperatorId() {
    return operatorId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for session.
   *
   * @return  Session
   */
  public Session getSession() {
    return session;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for trans view key.
   *
   * @return  String
   */
  public String getTransViewKey() {
    return transViewKey;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((eventDate != null) ? eventDate.hashCode() : 0);
    result = (31 * result) + ((eventDataKey != null) ? eventDataKey.hashCode() : 0);
    result = (31 * result) + ((eventType != null) ? eventType.hashCode() : 0);
    result = (31 * result) + ((eventName != null) ? eventName.hashCode() : 0);

    return result;
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
   * setter method for agent.
   *
   * @param  agent  User
   */
  public void setAgent(User agent) {
    this.agent = agent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for event data key.
   *
   * @param  eventDataKey  String
   */
  public void setEventDataKey(String eventDataKey) {
    this.eventDataKey = eventDataKey;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for event date.
   *
   * @param  eventDate  Date
   */
  public void setEventDate(Date eventDate) {
    this.eventDate = eventDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for event name.
   *
   * @param  eventName  String
   */
  public void setEventName(String eventName) {
    this.eventName = eventName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for event type.
   *
   * @param  eventType  String
   */
  public void setEventType(String eventType) {
    this.eventType = eventType;
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
   * setter method for operator id.
   *
   * @param  operatorId  String
   */
  public void setOperatorId(String operatorId) {
    this.operatorId = operatorId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for session.
   *
   * @param  session  Session
   */
  public void setSession(Session session) {
    this.session = session;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for trans view key.
   *
   * @param  transViewKey  String
   */
  public void setTransViewKey(String transViewKey) {
    this.transViewKey = transViewKey;
  }
} // end class TsysEvent
