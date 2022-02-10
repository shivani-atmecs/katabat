package com.cmc.credagility.core.domain.portfolio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * Created by IntelliJ IDEA. User: knandyala Date: 6/16/11 Time: 11:39 AM To change this template use File | Settings |
 * File Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(name = "PortfolioCycleDate")
public class PortfolioCycleDate extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** The number of cycle. */
  @Column(
    name     = "cycleNumber",
    nullable = false
  )
  protected Integer cycleNumber;

  /** The days of range. */
  @Column(name = "daysInRange")
  protected Integer daysInRange;

  /** The range of days from. */
  @Column(name = "fromDayOfRange")
  protected Integer fromDayRange;

  /** The maximum cycle days. */
  @Column(name = "maxCycleDays")
  protected Integer maxCycleDays;

  /** The minimum cycle days. */
  @Column(name = "minCycleDays")
  protected Integer minCycleDays;

  /** Portfolio PK portfolioId. */
  @JoinColumn(
    name      = "portfolioId",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Portfolio portfolio;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "portfolioCycleDateId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long portfolioCycleDateId;

  /** The range of days to. */
  @Column(name = "toDayOfRange")
  protected Integer toDayRange;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * equals.
   *
   * @param   o  Object
   *
   * @return  boolean
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof PortfolioCycleDate)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    PortfolioCycleDate that = (PortfolioCycleDate) o;

    if ((cycleNumber != null) ? (!cycleNumber.equals(that.cycleNumber)) : (that.cycleNumber != null)) {
      return false;
    }

    if ((daysInRange != null) ? (!daysInRange.equals(that.daysInRange)) : (that.daysInRange != null)) {
      return false;
    }

    if ((fromDayRange != null) ? (!fromDayRange.equals(that.fromDayRange)) : (that.fromDayRange != null)) {
      return false;
    }

    if ((maxCycleDays != null) ? (!maxCycleDays.equals(that.maxCycleDays)) : (that.maxCycleDays != null)) {
      return false;
    }

    if ((minCycleDays != null) ? (!minCycleDays.equals(that.minCycleDays)) : (that.minCycleDays != null)) {
      return false;
    }

    if ((portfolio != null) ? (!portfolio.equals(that.portfolio)) : (that.portfolio != null)) {
      return false;
    }

    if ((portfolioCycleDateId != null) ? (!portfolioCycleDateId.equals(that.portfolioCycleDateId))
                                       : (that.portfolioCycleDateId != null)) {
      return false;
    }

    if ((toDayRange != null) ? (!toDayRange.equals(that.toDayRange)) : (that.toDayRange != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getCycleNumber() {
    return cycleNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getDaysInRange() {
    return daysInRange;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getFromDayRange() {
    return fromDayRange;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getMaxCycleDays() {
    return maxCycleDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getMinCycleDays() {
    return minCycleDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Portfolio getPortfolio() {
    return portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getPortfolioCycleDateId() {
    return portfolioCycleDateId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getToDayRange() {
    return toDayRange;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((cycleNumber != null) ? cycleNumber.hashCode() : 0);
    result = (31 * result) + ((daysInRange != null) ? daysInRange.hashCode() : 0);
    result = (31 * result) + ((fromDayRange != null) ? fromDayRange.hashCode() : 0);
    result = (31 * result) + ((maxCycleDays != null) ? maxCycleDays.hashCode() : 0);
    result = (31 * result) + ((minCycleDays != null) ? minCycleDays.hashCode() : 0);
    result = (31 * result) + ((portfolio != null) ? portfolio.hashCode() : 0);
    result = (31 * result) + ((portfolioCycleDateId != null) ? portfolioCycleDateId.hashCode() : 0);
    result = (31 * result) + ((toDayRange != null) ? toDayRange.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  cycleNumber  DOCUMENT ME!
   */
  public void setCycleNumber(Integer cycleNumber) {
    this.cycleNumber = cycleNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  daysInRange  DOCUMENT ME!
   */
  public void setDaysInRange(Integer daysInRange) {
    this.daysInRange = daysInRange;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  fromDayRange  DOCUMENT ME!
   */
  public void setFromDayRange(Integer fromDayRange) {
    this.fromDayRange = fromDayRange;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  maxCycleDays  DOCUMENT ME!
   */
  public void setMaxCycleDays(Integer maxCycleDays) {
    this.maxCycleDays = maxCycleDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  minCycleDays  DOCUMENT ME!
   */
  public void setMinCycleDays(Integer minCycleDays) {
    this.minCycleDays = minCycleDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  portfolio  DOCUMENT ME!
   */
  public void setPortfolio(Portfolio portfolio) {
    this.portfolio = portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  portfolioCycleDateId  DOCUMENT ME!
   */
  public void setPortfolioCycleDateId(Long portfolioCycleDateId) {
    this.portfolioCycleDateId = portfolioCycleDateId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  toDayRange  DOCUMENT ME!
   */
  public void setToDayRange(Integer toDayRange) {
    this.toDayRange = toDayRange;
  }
} // end class PortfolioCycleDate
