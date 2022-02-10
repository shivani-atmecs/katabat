package com.cmc.credagility.core.domain.disclosure;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.portfolio.Portfolio;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/15/2014 11:06
 */
@Entity
@Table(
  name              = "DisclosureEvent",
  uniqueConstraints = { @UniqueConstraint(columnNames = { "eventName", "portfolioId" }) }
)
public class DisclosureEvent extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "eventId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long eventId;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "eventName",
    length   = 50,
    nullable = false
  )
  protected String eventName;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "portfolioId",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Portfolio portfolio;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    DisclosureEvent that = (DisclosureEvent) o;

    if (!eventName.equals(that.eventName)) {
      return false;
    }

    if (!portfolio.equals(that.portfolio)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for event id.
   *
   * @return  Long
   */
  public Long getEventId() {
    return eventId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for event name.
   *
   * @return  String
   */
  public String getEventName() {
    return eventName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio.
   *
   * @return  Portfolio
   */
  public Portfolio getPortfolio() {
    return portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + eventName.hashCode();
    result = (31 * result) + portfolio.hashCode();

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for event id.
   *
   * @param  eventId  Long
   */
  public void setEventId(Long eventId) {
    this.eventId = eventId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for event name.
   *
   * @param  eventName  String
   */
  public void setEventName(String eventName) {
    this.eventName = eventName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio.
   *
   * @param  portfolio  Portfolio
   */
  public void setPortfolio(Portfolio portfolio) {
    this.portfolio = portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#toString()
   */
  @Override public String toString() {
    return "DisclosureEvent{"
      + "eventId=" + eventId
      + ", eventName='" + eventName + '\''
      + ", portfolioId=" + portfolio.getPortfolioId()
      + '}';
  }
} // end class DisclosureEvent
