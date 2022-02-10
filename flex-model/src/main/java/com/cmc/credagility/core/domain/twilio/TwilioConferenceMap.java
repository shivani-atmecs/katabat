package com.cmc.credagility.core.domain.twilio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/15/2014 16:17
 */
@Entity
@Table(name = "TwilioConferenceMap")
public class TwilioConferenceMap extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 3027673946901265432L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String callSid;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String callStatus;


  /** TODO: DOCUMENT ME! */
  @Column(
    unique = true,
    length = 255
  )
  protected String conferenceName;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String conferenceSid;


  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;

  //~ Methods ----------------------------------------------------------------------------------------------------------

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
   * getter method for call status.
   *
   * @return  String
   */
  public String getCallStatus() {
    return callStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

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
   * getter method for id.
   *
   * @return  Long
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  callSid  DOCUMENT ME!
   */
  public void setCallSid(String callSid) {
    this.callSid = callSid;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for call status.
   *
   * @param  callStatus  String
   */
  public void setCallStatus(String callStatus) {
    this.callStatus = callStatus;
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
   * setter method for id.
   *
   * @param  id  Long
   */
  public void setId(Long id) {
    this.id = id;
  }
} // end class TwilioConferenceMap
