package com.cmc.credagility.core.domain.tsys;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/16/2014 09:25
 */
public class TsysMessages extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 1L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "message",
    length = 255
  )
  protected String message;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "messageNumber",
    length = 255
  )
  protected String messageNumber;

  /** TODO: DOCUMENT ME! */
  @Column(name = "timeStamp")
  protected Date timeStamp;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "type",
    length = 255
  )
  protected String type;

  //~ Methods ----------------------------------------------------------------------------------------------------------

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
   * getter method for message.
   *
   * @return  String
   */
  public String getMessage() {
    return message;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for message number.
   *
   * @return  String
   */
  public String getMessageNumber() {
    return messageNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for time stamp.
   *
   * @return  Date
   */
  public Date getTimeStamp() {
    return timeStamp;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for type.
   *
   * @return  String
   */
  public String getType() {
    return type;
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
   * setter method for message.
   *
   * @param  message  String
   */
  public void setMessage(String message) {
    this.message = message;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for message number.
   *
   * @param  messageNumber  String
   */
  public void setMessageNumber(String messageNumber) {
    this.messageNumber = messageNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for time stamp.
   *
   * @param  timeStamp  Date
   */
  public void setTimeStamp(Date timeStamp) {
    this.timeStamp = timeStamp;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for type.
   *
   * @param  type  String
   */
  public void setType(String type) {
    this.type = type;
  }
} // end class TsysMessages
