package com.cmc.credagility.core.domain.webactivity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.message.MessageStaging;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/16/2014 09:58
 */
@Entity
@Table(
  name    = "SynchronousMQCallStatus",
  indexes = {
    @Index(
      columnList = "transViewKey",
      name = "transViewKeyIndex"
    )
  }
)
public class SynchronousMQCallStatus extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 360642983026229608L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "sessionId")
  @OneToOne(fetch = FetchType.LAZY)
  protected Session dataSession;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "messageStagingId")
  @OneToOne(fetch = FetchType.LAZY)
  protected MessageStaging messageStaging;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "synchronousMQCallStatusId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long synchronousMQCallStatusId;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "transViewKey",
    nullable = false,
    length   = 255
  )
  protected String transViewKey;

  @Column(
    name   = "messageType",
    length = 100
  )
  private String messageType;


  @Column(
    name   = "restartToken",
    length = 255
  )
  private String restartToken;

  @Column(
    name   = "status",
    length = 100
  )
  private String status;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for data session.
   *
   * @return  Session
   */
  public Session getDataSession() {
    return dataSession;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for message staging.
   *
   * @return  MessageStaging
   */
  public MessageStaging getMessageStaging() {
    return messageStaging;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for message type.
   *
   * @return  String
   */
  public String getMessageType() {
    return messageType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for restart token.
   *
   * @return  String
   */
  public String getRestartToken() {
    return restartToken;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status.
   *
   * @return  String
   */
  public String getStatus() {
    return status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for synchronous MQCall status id.
   *
   * @return  Long
   */
  public Long getSynchronousMQCallStatusId() {
    return synchronousMQCallStatusId;
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
   * setter method for data session.
   *
   * @param  dataSession  Session
   */
  public void setDataSession(Session dataSession) {
    this.dataSession = dataSession;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for message staging.
   *
   * @param  messageStaging  MessageStaging
   */
  public void setMessageStaging(MessageStaging messageStaging) {
    this.messageStaging = messageStaging;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for message type.
   *
   * @param  messageType  String
   */
  public void setMessageType(String messageType) {
    this.messageType = messageType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for restart token.
   *
   * @param  restartToken  String
   */
  public void setRestartToken(String restartToken) {
    this.restartToken = restartToken;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for status.
   *
   * @param  status  String
   */
  public void setStatus(String status) {
    this.status = status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for synchronous MQCall status id.
   *
   * @param  synchronousMQCallStatusId  Long
   */
  public void setSynchronousMQCallStatusId(Long synchronousMQCallStatusId) {
    this.synchronousMQCallStatusId = synchronousMQCallStatusId;
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
} // end class SynchronousMQCallStatus
