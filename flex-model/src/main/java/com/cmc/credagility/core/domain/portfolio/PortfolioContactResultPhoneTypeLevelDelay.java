package com.cmc.credagility.core.domain.portfolio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Created with IntelliJ IDEA. User: liaodongming Date: 13-3-29 Time: PM2:26 To change this template use File | Settings
 * | File Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(name = "PortfolioContactResultPhoneTypeLevelDelay")
public class PortfolioContactResultPhoneTypeLevelDelay extends AbstractPortfolioTypeCallObject {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  @Column(name = "delayDays")
  private Integer delayDays;

  /** How long the portfolio contact result phone type level delay to call. */
  private Integer delayToCall;

  @Column(
    name     = "portfolioPhoneTypeCallingDelayId",

    // unique = true,
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long portfolioPhoneTypeCallingDelayId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof PortfolioContactResultPhoneTypeLevelDelay)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    PortfolioContactResultPhoneTypeLevelDelay that = (PortfolioContactResultPhoneTypeLevelDelay) o;

    if ((delayToCall != null) ? (!delayToCall.equals(that.delayToCall)) : (that.delayToCall != null)) {
      return false;
    }

    if ((portfolioPhoneTypeCallingDelayId != null)
          ? (!portfolioPhoneTypeCallingDelayId.equals(that.portfolioPhoneTypeCallingDelayId))
          : (that.portfolioPhoneTypeCallingDelayId != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for delay days.
   *
   * @return  Integer
   */
  public Integer getDelayDays() {
    return delayDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getDelayToCall() {
    return delayToCall;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getPortfolioPhoneTypeCallingDelayId() {
    return portfolioPhoneTypeCallingDelayId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((delayToCall != null) ? delayToCall.hashCode() : 0);
    result = (31 * result)
      + ((portfolioPhoneTypeCallingDelayId != null) ? portfolioPhoneTypeCallingDelayId.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for delay days.
   *
   * @param  delayDays  Integer
   */
  public void setDelayDays(Integer delayDays) {
    this.delayDays = delayDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  delayToCall  DOCUMENT ME!
   */
  public void setDelayToCall(Integer delayToCall) {
    this.delayToCall = delayToCall;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  portfolioPhoneTypeCallingDelayId  DOCUMENT ME!
   */
  public void setPortfolioPhoneTypeCallingDelayId(Long portfolioPhoneTypeCallingDelayId) {
    this.portfolioPhoneTypeCallingDelayId = portfolioPhoneTypeCallingDelayId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.CreatorEntity#toString()
   */
  @Override public String toString() {
    return "PortfolioContactResultPhoneTypeLevelDelay{"
      + "delayToCall=" + delayToCall
      + ", portfolioPhoneTypeCallingDelayId=" + portfolioPhoneTypeCallingDelayId
      + '}';
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  portfolioContactResultPhoneTypeLevelDelay  DOCUMENT ME!
   */
  public void update(PortfolioContactResultPhoneTypeLevelDelay portfolioContactResultPhoneTypeLevelDelay) {
    this.delayToCall    = portfolioContactResultPhoneTypeLevelDelay.getDelayToCall();
    this.lastUpdater    = portfolioContactResultPhoneTypeLevelDelay.getLastUpdater();
    this.lastUpdateDate = portfolioContactResultPhoneTypeLevelDelay.getLastUpdateDate();
  }
} // end class PortfolioContactResultPhoneTypeLevelDelay
