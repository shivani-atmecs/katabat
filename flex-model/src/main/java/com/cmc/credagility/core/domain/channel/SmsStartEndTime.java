package com.cmc.credagility.core.domain.channel;

import java.io.Serializable;

import java.util.Date;

import com.cmc.credagility.core.domain.address.Timezone;
import com.cmc.credagility.core.domain.portfolio.PortfolioJurisdictionSmsTime;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/14/2014 17:09
 */
public class SmsStartEndTime implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -7026465445437201664L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private Timezone                     appliedEndSmsTimeZone;
  private Timezone                     appliedStartSmsTimeZone;
  private PortfolioJurisdictionSmsTime endSmsTime;
  private Date                         endTime;
  private PortfolioJurisdictionSmsTime startSmsTime;
  private Date                         startTime;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for applied end sms time zone.
   *
   * @return  Timezone
   */
  public Timezone getAppliedEndSmsTimeZone() {
    return appliedEndSmsTimeZone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for applied start sms time zone.
   *
   * @return  Timezone
   */
  public Timezone getAppliedStartSmsTimeZone() {
    return appliedStartSmsTimeZone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for end sms time.
   *
   * @return  PortfolioJurisdictionSmsTime
   */
  public PortfolioJurisdictionSmsTime getEndSmsTime() {
    return endSmsTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for end time.
   *
   * @return  Date
   */
  public Date getEndTime() {
    return endTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for start sms time.
   *
   * @return  PortfolioJurisdictionSmsTime
   */
  public PortfolioJurisdictionSmsTime getStartSmsTime() {
    return startSmsTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for start time.
   *
   * @return  Date
   */
  public Date getStartTime() {
    return startTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for applied end sms time zone.
   *
   * @param  appliedEndSmsTimeZone  Timezone
   */
  public void setAppliedEndSmsTimeZone(Timezone appliedEndSmsTimeZone) {
    this.appliedEndSmsTimeZone = appliedEndSmsTimeZone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for applied start sms time zone.
   *
   * @param  appliedStartSmsTimeZone  Timezone
   */
  public void setAppliedStartSmsTimeZone(Timezone appliedStartSmsTimeZone) {
    this.appliedStartSmsTimeZone = appliedStartSmsTimeZone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for end sms time.
   *
   * @param  endSmsTime  PortfolioJurisdictionSmsTime
   */
  public void setEndSmsTime(PortfolioJurisdictionSmsTime endSmsTime) {
    this.endSmsTime = endSmsTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for end time.
   *
   * @param  endTime  Date
   */
  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for start sms time.
   *
   * @param  startSmsTime  PortfolioJurisdictionSmsTime
   */
  public void setStartSmsTime(PortfolioJurisdictionSmsTime startSmsTime) {
    this.startSmsTime = startSmsTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for start time.
   *
   * @param  startTime  Date
   */
  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }
} // end class SmsStartEndTime
