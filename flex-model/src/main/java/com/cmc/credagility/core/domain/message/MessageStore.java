package com.cmc.credagility.core.domain.message;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:pan.kang@ozstrategy.com">Pan Kang</a>
 * @version  10/15/2014 12:27
 */
@Entity
@Table(name = "MessageStore")
public class MessageStore extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -7023068407456213787L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "messagePayload",
    nullable         = false,
    columnDefinition = "LONGBLOB",
    updatable        = false
  )
  protected byte[] messagePayload;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "messageStagingId",
    nullable = false
  )
  @ManyToOne(cascade = CascadeType.ALL)
  protected MessageStaging messageStaging;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "messageId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long messageStoreId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for message payload.
   *
   * @return  byte[]
   */
  public byte[] getMessagePayload() {
    return messagePayload;
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
   * getter method for message store id.
   *
   * @return  Long
   */
  public Long getMessageStoreId() {
    return messageStoreId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for message payload.
   *
   * @param  messagePayload  byte[]
   */
  public void setMessagePayload(String messagePayload) {
    this.messagePayload = messagePayload.getBytes();
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
   * setter method for message store id.
   *
   * @param  messageStoreId  Long
   */
  public void setMessageStoreId(Long messageStoreId) {
    this.messageStoreId = messageStoreId;
  }
} // end class MessageStore
