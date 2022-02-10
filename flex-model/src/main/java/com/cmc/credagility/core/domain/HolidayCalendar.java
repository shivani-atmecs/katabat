package com.cmc.credagility.core.domain;

import java.io.Serializable;

import java.util.Date;

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
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/30/2014 16:49
 */
@Entity
@Table(name = "HolidayCalendar")
public class HolidayCalendar extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -1739690457774377258L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: */
  @Column(
    name     = "context",
    nullable = true
  )
  protected String context;


  /** TODO: */
  @Column(
    name     = "description",
    nullable = true
  )
  protected String description;


  /** TODO: */
  @Column(
    name     = "holidayDate",
    nullable = false
  )
  protected Date holidayDate;


  /** TODO: */
  @Column(
    name     = "holidayId",
    nullable = false
  )
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long holidayId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof HolidayCalendar)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    HolidayCalendar that = (HolidayCalendar) o;

    if ((context != null) ? (!context.equals(that.context)) : (that.context != null)) {
      return false;
    }

    if ((description != null) ? (!description.equals(that.description)) : (that.description != null)) {
      return false;
    }

    if ((holidayDate != null) ? (!holidayDate.equals(that.holidayDate)) : (that.holidayDate != null)) {
      return false;
    }

    if ((holidayId != null) ? (!holidayId.equals(that.holidayId)) : (that.holidayId != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getContext() {
    return context;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for description.
   *
   * @return  String
   */
  public String getDescription() {
    return description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Date.
   *
   * @return  Date.
   */
  public Date getHolidayDate() {
    return holidayDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for holiday id.
   *
   * @return  Long
   */
  public Long getHolidayId() {
    return holidayId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((context != null) ? context.hashCode() : 0);
    result = (31 * result) + ((description != null) ? description.hashCode() : 0);
    result = (31 * result) + ((holidayDate != null) ? holidayDate.hashCode() : 0);
    result = (31 * result) + ((holidayId != null) ? holidayId.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setContext.
   *
   * @param  context  $param.type$
   */
  public void setContext(String context) {
    this.context = context;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for description.
   *
   * @param  description  String
   */
  public void setDescription(String description) {
    this.description = description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setHolidayDate.
   *
   * @param  holidayDate  $param.type$
   */
  public void setHolidayDate(Date holidayDate) {
    this.holidayDate = holidayDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for holiday id.
   *
   * @param  holidayId  Long
   */
  public void setHolidayId(Long holidayId) {
    this.holidayId = holidayId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#toString()
   */
  @Override public String toString() {
    return "HolidayCalendar{"
      + "context='" + context + '\''
      + ", holidayDate=" + holidayDate
      + ", description=" + description
      + '}';

  }
} // end class HolidayCalendar
