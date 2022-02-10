package com.cmc.credagility.core.domain.twilio;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/15/2014 15:15
 */
@Entity
@Table(
  name    = "CallRecording",
  indexes = {
    @javax.persistence.Index(
      name = "idx_CallRecording_callSid",
      columnList = "callSid"
    ),
    @javax.persistence.Index(
      name = "idx_CallRecording_recordFrom",
      columnList = "recordFrom"
    ),
    @javax.persistence.Index(
      name = "idx_CallRecording_recordTo",
      columnList = "recordTo"
    ),
    @javax.persistence.Index(
      name = "idx_CallRecording_userName",
      columnList = "userName"
    ),
    @javax.persistence.Index(
      name = "idx_CallRecording_fromAgentName",
      columnList = "fromAgentName"
    ),
    @javax.persistence.Index(
      name = "idx_CallRecording_recordingStartDate",
      columnList = "recordingStartDate"
    )
  }
)
public class CallRecording extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -323765762470321144L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  protected Long accountNum;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String calledCountry;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String callSid;


  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  @Enumerated(EnumType.STRING)
  protected CallType callType = CallType.DialPad;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String conference;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String dialCallDuration;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String dialCallStatus;


  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String fromAgentName;


  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String recordFrom;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String recordingDuration;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String recordingSid;


  /** TODO: DOCUMENT ME! */
  protected Date recordingStartDate;


  /** TODO: DOCUMENT ME! */
  @Column(length = 512)
  protected String recordingUrl;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String recordTo;


  /** TODO: DOCUMENT ME! */
  protected Long responsibleId;


  /** TODO: DOCUMENT ME! */
  protected Date sortDate;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String userName;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof CallRecording)) {
      return false;
    }

    CallRecording that = (CallRecording) o;

    if ((callSid != null) ? (!callSid.equals(that.callSid)) : (that.callSid != null)) {
      return false;
    }

    if ((calledCountry != null) ? (!calledCountry.equals(that.calledCountry)) : (that.calledCountry != null)) {
      return false;
    }

    if ((conference != null) ? (!conference.equals(that.conference)) : (that.conference != null)) {
      return false;
    }

    if ((createDate != null) ? (!createDate.equals(that.createDate)) : (that.createDate != null)) {
      return false;
    }

    if ((dialCallDuration != null) ? (!dialCallDuration.equals(that.dialCallDuration))
                                   : (that.dialCallDuration != null)) {
      return false;
    }

    if ((dialCallStatus != null) ? (!dialCallStatus.equals(that.dialCallStatus)) : (that.dialCallStatus != null)) {
      return false;
    }

    if ((recordFrom != null) ? (!recordFrom.equals(that.recordFrom)) : (that.recordFrom != null)) {
      return false;
    }

    if ((recordTo != null) ? (!recordTo.equals(that.recordTo)) : (that.recordTo != null)) {
      return false;
    }

    if ((recordingDuration != null) ? (!recordingDuration.equals(that.recordingDuration))
                                    : (that.recordingDuration != null)) {
      return false;
    }

    if ((recordingSid != null) ? (!recordingSid.equals(that.recordingSid)) : (that.recordingSid != null)) {
      return false;
    }

    if ((recordingUrl != null) ? (!recordingUrl.equals(that.recordingUrl)) : (that.recordingUrl != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account num.
   *
   * @return  Long
   */
  public Long getAccountNum() {
    return accountNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for called country.
   *
   * @return  String
   */
  public String getCalledCountry() {
    return calledCountry;
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
   * getter method for call type.
   *
   * @return  CallType
   */
  public CallType getCallType() {
    return callType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for conference.
   *
   * @return  String
   */
  public String getConference() {
    return conference;
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
   * getter method for dial call duration.
   *
   * @return  String
   */
  public String getDialCallDuration() {
    return dialCallDuration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for dial call status.
   *
   * @return  String
   */
  public String getDialCallStatus() {
    return dialCallStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for from agent name.
   *
   * @return  String
   */
  public String getFromAgentName() {
    return fromAgentName;
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
   * getter method for record from.
   *
   * @return  String
   */
  public String getRecordFrom() {
    return recordFrom;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for recording duration.
   *
   * @return  String
   */
  public String getRecordingDuration() {
    return recordingDuration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for recording sid.
   *
   * @return  String
   */
  public String getRecordingSid() {
    return recordingSid;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for recording start date.
   *
   * @return  Date
   */
  public Date getRecordingStartDate() {
    return recordingStartDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for recording url.
   *
   * @return  String
   */
  public String getRecordingUrl() {
    return recordingUrl;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for record to.
   *
   * @return  String
   */
  public String getRecordTo() {
    return recordTo;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible id.
   *
   * @return  Long
   */
  public Long getResponsibleId() {
    return responsibleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for sort date.
   *
   * @return  Date
   */
  public Date getSortDate() {
    return sortDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for user name.
   *
   * @return  String
   */
  public String getUserName() {
    return userName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    int result = (calledCountry != null) ? calledCountry.hashCode() : 0;
    result = (31 * result) + ((callSid != null) ? callSid.hashCode() : 0);
    result = (31 * result) + ((conference != null) ? conference.hashCode() : 0);
    result = (31 * result) + ((createDate != null) ? createDate.hashCode() : 0);
    result = (31 * result) + ((dialCallDuration != null) ? dialCallDuration.hashCode() : 0);
    result = (31 * result) + ((dialCallStatus != null) ? dialCallStatus.hashCode() : 0);
    result = (31 * result) + ((recordFrom != null) ? recordFrom.hashCode() : 0);
    result = (31 * result) + ((recordingDuration != null) ? recordingDuration.hashCode() : 0);
    result = (31 * result) + ((recordingSid != null) ? recordingSid.hashCode() : 0);
    result = (31 * result) + ((recordingUrl != null) ? recordingUrl.hashCode() : 0);
    result = (31 * result) + ((recordTo != null) ? recordTo.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account num.
   *
   * @param  accountNum  Long
   */
  public void setAccountNum(Long accountNum) {
    this.accountNum = accountNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for called country.
   *
   * @param  calledCountry  String
   */
  public void setCalledCountry(String calledCountry) {
    this.calledCountry = calledCountry;
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
   * setter method for call type.
   *
   * @param  callType  CallType
   */
  public void setCallType(CallType callType) {
    this.callType = callType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for conference.
   *
   * @param  conference  String
   */
  public void setConference(String conference) {
    this.conference = conference;
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
   * setter method for dial call duration.
   *
   * @param  dialCallDuration  String
   */
  public void setDialCallDuration(String dialCallDuration) {
    this.dialCallDuration = dialCallDuration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for dial call status.
   *
   * @param  dialCallStatus  String
   */
  public void setDialCallStatus(String dialCallStatus) {
    this.dialCallStatus = dialCallStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for from agent name.
   *
   * @param  fromAgentName  String
   */
  public void setFromAgentName(String fromAgentName) {
    this.fromAgentName = fromAgentName;
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
   * setter method for record from.
   *
   * @param  recordFrom  String
   */
  public void setRecordFrom(String recordFrom) {
    this.recordFrom = recordFrom;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for recording duration.
   *
   * @param  recordingDuration  String
   */
  public void setRecordingDuration(String recordingDuration) {
    this.recordingDuration = recordingDuration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for recording sid.
   *
   * @param  recordingSid  String
   */
  public void setRecordingSid(String recordingSid) {
    this.recordingSid = recordingSid;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for recording start date.
   *
   * @param  recordingStartDate  Date
   */
  public void setRecordingStartDate(Date recordingStartDate) {
    this.recordingStartDate = recordingStartDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for recording url.
   *
   * @param  recordingUrl  String
   */
  public void setRecordingUrl(String recordingUrl) {
    this.recordingUrl = recordingUrl;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for record to.
   *
   * @param  recordTo  String
   */
  public void setRecordTo(String recordTo) {
    this.recordTo = recordTo;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for responsible id.
   *
   * @param  responsibleId  Long
   */
  public void setResponsibleId(Long responsibleId) {
    this.responsibleId = responsibleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for sort date.
   *
   * @param  sortDate  Date
   */
  public void setSortDate(Date sortDate) {
    this.sortDate = sortDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for user name.
   *
   * @param  userName  String
   */
  public void setUserName(String userName) {
    this.userName = userName;
  }
} // end class CallRecording
