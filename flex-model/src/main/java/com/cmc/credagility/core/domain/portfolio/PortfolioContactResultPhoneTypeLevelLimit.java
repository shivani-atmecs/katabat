package com.cmc.credagility.core.domain.portfolio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Created with IntelliJ IDEA. User: liaodongming Date: 13-3-29 Time: PM2:25 To change this template use File | Settings
 * | File Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(name = "PortfolioContactResultPhoneTypeLevelLimit")
public class PortfolioContactResultPhoneTypeLevelLimit extends AbstractPortfolioTypeCallObject {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** How long the contact Result Phone Type Level call limit. */
  private Integer callLimit;

  @Column(name = "daysOfLimit")
  private Integer daysOfLimit;

  /** Contact Result Phone Type Level duration of limit. */
  private Integer durationOfLimit;

  @Column(
    name     = "portfolioPhoneTypeCallingLimitId",

    // unique = true,
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long portfolioPhoneTypeCallingLimitId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof PortfolioContactResultPhoneTypeLevelLimit)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    PortfolioContactResultPhoneTypeLevelLimit that = (PortfolioContactResultPhoneTypeLevelLimit) o;

    if ((callLimit != null) ? (!callLimit.equals(that.callLimit)) : (that.callLimit != null)) {
      return false;
    }

    if ((durationOfLimit != null) ? (!durationOfLimit.equals(that.durationOfLimit)) : (that.durationOfLimit != null)) {
      return false;
    }

    if ((portfolioPhoneTypeCallingLimitId != null)
          ? (!portfolioPhoneTypeCallingLimitId.equals(that.portfolioPhoneTypeCallingLimitId))
          : (that.portfolioPhoneTypeCallingLimitId != null)) {
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
  public Integer getCallLimit() {
    return callLimit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for days of limit.
   *
   * @return  Integer
   */
  public Integer getDaysOfLimit() {
    return daysOfLimit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getDurationOfLimit() {
    return durationOfLimit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getPortfolioPhoneTypeCallingLimitId() {
    return portfolioPhoneTypeCallingLimitId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((callLimit != null) ? callLimit.hashCode() : 0);
    result = (31 * result) + ((durationOfLimit != null) ? durationOfLimit.hashCode() : 0);
    result = (31 * result)
      + ((portfolioPhoneTypeCallingLimitId != null) ? portfolioPhoneTypeCallingLimitId.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  callLimit  DOCUMENT ME!
   */
  public void setCallLimit(Integer callLimit) {
    this.callLimit = callLimit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for days of limit.
   *
   * @param  daysOfLimit  Integer
   */
  public void setDaysOfLimit(Integer daysOfLimit) {
    this.daysOfLimit = daysOfLimit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  durationOfLimit  DOCUMENT ME!
   */
  public void setDurationOfLimit(Integer durationOfLimit) {
    this.durationOfLimit = durationOfLimit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  portfolioPhoneTypeCallingLimitId  DOCUMENT ME!
   */
  public void setPortfolioPhoneTypeCallingLimitId(Long portfolioPhoneTypeCallingLimitId) {
    this.portfolioPhoneTypeCallingLimitId = portfolioPhoneTypeCallingLimitId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.CreatorEntity#toString()
   */
  @Override public String toString() {
    return "PortfolioContactResultPhoneTypeLevelLimit{"
      + "callLimit=" + callLimit
      + ", durationOfLimit=" + durationOfLimit
      + ", portfolioPhoneTypeCallingLimitId=" + portfolioPhoneTypeCallingLimitId
      + '}';
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  portfolioContactResultPhoneTypeLevelLimit  DOCUMENT ME!
   */
  public void update(PortfolioContactResultPhoneTypeLevelLimit portfolioContactResultPhoneTypeLevelLimit) {
    this.callLimit      = portfolioContactResultPhoneTypeLevelLimit.getCallLimit();
    this.lastUpdater    = portfolioContactResultPhoneTypeLevelLimit.getLastUpdater();
    this.lastUpdateDate = portfolioContactResultPhoneTypeLevelLimit.getLastUpdateDate();
  }
} // end class PortfolioContactResultPhoneTypeLevelLimit
