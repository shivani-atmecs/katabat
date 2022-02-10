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
 * @version  10/15/2014 12:21
 */
@Entity
@Table(name = "MessageResponseStore")
public class MessageResponseStore extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 8484453908813259827L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "messageId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long messageResponseStoreId;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "messageStagingId",
    nullable = false,
    unique   = true
  )
  @ManyToOne(cascade = CascadeType.ALL)
  protected MessageStaging messageStaging;


  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "responsePayLoad",
    nullable         = false,
    columnDefinition = "LONGBLOB",
    updatable        = false
  )
  protected byte[] responsePayLoad;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for message response store id.
   *
   * @return  Long
   */
  public Long getMessageResponseStoreId() {
    return messageResponseStoreId;
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
   * getter method for response pay load.
   *
   * @return  byte[]
   */
  public byte[] getResponsePayLoad() {
    return responsePayLoad;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for message response store id.
   *
   * @param  messageResponseStoreId  Long
   */
  public void setMessageResponseStoreId(Long messageResponseStoreId) {
    this.messageResponseStoreId = messageResponseStoreId;
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
   * setter method for response pay load.
   *
   * @param  responsePayLoad  byte[]
   */
  public void setResponsePayLoad(byte[] responsePayLoad) {
    this.responsePayLoad = responsePayLoad;
  }
} // end class MessageResponseStore
