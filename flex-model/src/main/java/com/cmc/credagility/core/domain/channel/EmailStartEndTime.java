package com.cmc.credagility.core.domain.channel;

import java.io.Serializable;

import java.util.Date;

import com.cmc.credagility.core.domain.address.Timezone;
import com.cmc.credagility.core.domain.portfolio.PortfolioJurisdictionEmailTime;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/15/2014 11:27
 */
public class EmailStartEndTime implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 7790816397530870813L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private Timezone                       appliedEndEmailTimeZone;
  private Timezone                       appliedStartEmailTimeZone;
  private PortfolioJurisdictionEmailTime endEmailTime;
  private Date                           endTime;
  private PortfolioJurisdictionEmailTime startEmailTime;
  private Date                           startTime;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for applied end email time zone.
   *
   * @return  Timezone
   */
  public Timezone getAppliedEndEmailTimeZone() {
    return appliedEndEmailTimeZone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for applied start email time zone.
   *
   * @return  Timezone
   */
  public Timezone getAppliedStartEmailTimeZone() {
    return appliedStartEmailTimeZone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for end email time.
   *
   * @return  PortfolioJurisdictionEmailTime
   */
  public PortfolioJurisdictionEmailTime getEndEmailTime() {
    return endEmailTime;
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
   * getter method for start email time.
   *
   * @return  PortfolioJurisdictionEmailTime
   */
  public PortfolioJurisdictionEmailTime getStartEmailTime() {
    return startEmailTime;
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
   * setter method for applied end email time zone.
   *
   * @param  appliedEndEmailTimeZone  Timezone
   */
  public void setAppliedEndEmailTimeZone(Timezone appliedEndEmailTimeZone) {
    this.appliedEndEmailTimeZone = appliedEndEmailTimeZone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for applied start email time zone.
   *
   * @param  appliedStartEmailTimeZone  Timezone
   */
  public void setAppliedStartEmailTimeZone(Timezone appliedStartEmailTimeZone) {
    this.appliedStartEmailTimeZone = appliedStartEmailTimeZone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for end email time.
   *
   * @param  endEmailTime  PortfolioJurisdictionEmailTime
   */
  public void setEndEmailTime(PortfolioJurisdictionEmailTime endEmailTime) {
    this.endEmailTime = endEmailTime;
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
   * setter method for start email time.
   *
   * @param  startEmailTime  PortfolioJurisdictionEmailTime
   */
  public void setStartEmailTime(PortfolioJurisdictionEmailTime startEmailTime) {
    this.startEmailTime = startEmailTime;
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
} // end class EmailStartEndTime
