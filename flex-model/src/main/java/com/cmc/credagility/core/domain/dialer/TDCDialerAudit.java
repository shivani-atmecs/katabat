package com.cmc.credagility.core.domain.dialer;

import java.io.Serializable;

import java.util.Date;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/15/2014 10:56
 */
public class TDCDialerAudit implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 6078668086263629605L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String  CALL_STATUS_ZONE_1;
  private String  CALL_STATUS_ZONE_2;
  private String  calledNumber;
  private String  callResult;
  private String  campaignNumber;
  private String  channelResultId;
  private Integer duration;
  private Long    recoveryKey;
  private Date    time;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for CALL_STATUS_ZONE_1.
   *
   * @return  String
   */
  public String getCALL_STATUS_ZONE_1() {
    return CALL_STATUS_ZONE_1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for CALL_STATUS_ZONE_2.
   *
   * @return  String
   */
  public String getCALL_STATUS_ZONE_2() {
    return CALL_STATUS_ZONE_2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for called number.
   *
   * @return  String
   */
  public String getCalledNumber() {
    return calledNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for call result.
   *
   * @return  String
   */
  public String getCallResult() {
    return callResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for campaign number.
   *
   * @return  String
   */
  public String getCampaignNumber() {
    return campaignNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for channel result id.
   *
   * @return  String
   */
  public String getChannelResultId() {
    return channelResultId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for duration.
   *
   * @return  Integer
   */
  public Integer getDuration() {
    return duration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for recovery key.
   *
   * @return  Long
   */
  public Long getRecoveryKey() {
    return recoveryKey;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for time.
   *
   * @return  Date
   */
  public Date getTime() {
    return time;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  CALL_STATUS_ZONE_1  DOCUMENT ME!
   */
  public void setCALL_STATUS_ZONE_1(String CALL_STATUS_ZONE_1) {
    this.CALL_STATUS_ZONE_1 = CALL_STATUS_ZONE_1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  CALL_STATUS_ZONE_2  DOCUMENT ME!
   */
  public void setCALL_STATUS_ZONE_2(String CALL_STATUS_ZONE_2) {
    this.CALL_STATUS_ZONE_2 = CALL_STATUS_ZONE_2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for called number.
   *
   * @param  calledNumber  String
   */
  public void setCalledNumber(String calledNumber) {
    this.calledNumber = calledNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for call result.
   *
   * @param  callResult  String
   */
  public void setCallResult(String callResult) {
    this.callResult = callResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for campaign number.
   *
   * @param  campaignNumber  String
   */
  public void setCampaignNumber(String campaignNumber) {
    this.campaignNumber = campaignNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for channel result id.
   *
   * @param  channelResultId  String
   */
  public void setChannelResultId(String channelResultId) {
    this.channelResultId = channelResultId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for duration.
   *
   * @param  duration  Integer
   */
  public void setDuration(Integer duration) {
    this.duration = duration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for recovery key.
   *
   * @param  recoveryKey  Long
   */
  public void setRecoveryKey(Long recoveryKey) {
    this.recoveryKey = recoveryKey;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for time.
   *
   * @param  time  Date
   */
  public void setTime(Date time) {
    this.time = time;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#toString()
   */
  @Override public String toString() {
    return "TDCDialerAudit{"
      + "channelResultId='" + channelResultId + '\''
      + ", CALL_STATUS_ZONE_1='" + CALL_STATUS_ZONE_1 + '\''
      + ", CALL_STATUS_ZONE_2='" + CALL_STATUS_ZONE_2 + '\''
      + ", calledNumber='" + calledNumber + '\''
      + ", callResult='" + callResult + '\''
      + ", campaignNumber='" + campaignNumber + '\''
      + ", duration=" + duration
      + ", recoveryKey=" + recoveryKey
      + ", time=" + time
      + '}';
  }
} // end class TDCDialerAudit
