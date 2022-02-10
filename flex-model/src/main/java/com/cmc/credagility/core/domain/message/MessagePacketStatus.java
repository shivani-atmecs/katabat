package com.cmc.credagility.core.domain.message;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.type.ExternalStatus;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:pan.kang@ozstrategy.com">Pan Kang</a>
 * @version  10/15/2014 12:19
 */
@Entity
@Table(name = "MessagePacketStatus")
public class MessagePacketStatus extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 6372527947764137814L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "externalStatus",
    nullable = true,
    length   = 20
  )
  @Enumerated(EnumType.STRING)
  protected ExternalStatus externalStatus;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "externalStatusDescription",
    nullable = true,
    length   = 250
  )
  protected String externalStatusDescription;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "messagePacketId",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected MessagePacket messagePacket;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "messagePacketStatusId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long messagePacketStatusId;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "messageStagingId",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected MessageStaging messageStaging;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for external status.
   *
   * @return  ExternalStatus
   */
  public ExternalStatus getExternalStatus() {
    return externalStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for external status description.
   *
   * @return  String
   */
  public String getExternalStatusDescription() {
    return externalStatusDescription;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for message packet.
   *
   * @return  MessagePacket
   */
  public MessagePacket getMessagePacket() {
    return messagePacket;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for message packet status id.
   *
   * @return  Long
   */
  public Long getMessagePacketStatusId() {
    return messagePacketStatusId;
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
   * setter method for external status.
   *
   * @param  externalStatus  ExternalStatus
   */
  public void setExternalStatus(ExternalStatus externalStatus) {
    this.externalStatus = externalStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for external status description.
   *
   * @param  externalStatusDescription  String
   */
  public void setExternalStatusDescription(String externalStatusDescription) {
    this.externalStatusDescription = externalStatusDescription;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for message packet.
   *
   * @param  messagePacket  MessagePacket
   */
  public void setMessagePacket(MessagePacket messagePacket) {
    this.messagePacket = messagePacket;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for message packet status id.
   *
   * @param  messagePacketStatusId  Long
   */
  public void setMessagePacketStatusId(Long messagePacketStatusId) {
    this.messagePacketStatusId = messagePacketStatusId;
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
} // end class MessagePacketStatus
