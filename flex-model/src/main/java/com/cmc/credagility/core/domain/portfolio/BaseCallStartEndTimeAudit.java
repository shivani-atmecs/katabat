package com.cmc.credagility.core.domain.portfolio;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.address.Timezone;
import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:dongming.liao@ozstrategy.com">Dongming Liao</a>
 * @version  10/14/2014 17:01
 */
@MappedSuperclass public class BaseCallStartEndTimeAudit extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 2221323662795812351L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "appliedEndCallTimeZoneId",
    insertable = true,
    updatable  = false,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private Timezone appliedEndCallTimeZone;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "appliedStartCallTimeZoneId",
    insertable = true,
    updatable  = false,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private Timezone appliedStartCallTimeZone;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "endCallTimeId",
    insertable = true,
    updatable  = false,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private PortfolioJurisdictionCallTime endCallTime;

  /** TODO: DOCUMENT ME! */
  @Column(name = "endTime")
  @Temporal(TemporalType.TIMESTAMP)
  private Date endTime;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "startCallTimeId",
    insertable = true,
    updatable  = false,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private PortfolioJurisdictionCallTime startCallTime;

  /** TODO: DOCUMENT ME! */
  @Column(name = "startTime")
  @Temporal(TemporalType.TIMESTAMP)
  private Date startTime;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for applied end call time zone.
   *
   * @return  Timezone
   */
  public Timezone getAppliedEndCallTimeZone() {
    return appliedEndCallTimeZone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for applied start call time zone.
   *
   * @return  Timezone
   */
  public Timezone getAppliedStartCallTimeZone() {
    return appliedStartCallTimeZone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for end call time.
   *
   * @return  PortfolioJurisdictionCallTime
   */
  public PortfolioJurisdictionCallTime getEndCallTime() {
    return endCallTime;
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
   * getter method for start call time.
   *
   * @return  PortfolioJurisdictionCallTime
   */
  public PortfolioJurisdictionCallTime getStartCallTime() {
    return startCallTime;
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
   * setter method for applied end call time zone.
   *
   * @param  appliedEndCallTimeZone  Timezone
   */
  public void setAppliedEndCallTimeZone(Timezone appliedEndCallTimeZone) {
    this.appliedEndCallTimeZone = appliedEndCallTimeZone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for applied start call time zone.
   *
   * @param  appliedStartCallTimeZone  Timezone
   */
  public void setAppliedStartCallTimeZone(Timezone appliedStartCallTimeZone) {
    this.appliedStartCallTimeZone = appliedStartCallTimeZone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for end call time.
   *
   * @param  endCallTime  PortfolioJurisdictionCallTime
   */
  public void setEndCallTime(PortfolioJurisdictionCallTime endCallTime) {
    this.endCallTime = endCallTime;
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
   * setter method for start call time.
   *
   * @param  startCallTime  PortfolioJurisdictionCallTime
   */
  public void setStartCallTime(PortfolioJurisdictionCallTime startCallTime) {
    this.startCallTime = startCallTime;
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
} // end class BaseCallStartEndTimeAudit
