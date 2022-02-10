package com.cmc.credagility.core.domain.twilio;

import java.io.Serializable;

import java.sql.Time;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/15/2014 17:23
 */
@Entity
@Table(name = "TwilioVoiceRule")
public class TwilioVoiceRule extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -3381908880378262615L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(unique = true)
  protected String dayOfWeek;


  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;


  /** TODO: DOCUMENT ME! */
  protected Time workingHoursFrom;


  /** TODO: DOCUMENT ME! */
  protected Time workingHoursTo;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#getCreateDate()
   */
  @Override public Date getCreateDate() {
    return createDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for day of week.
   *
   * @return  String
   */
  public String getDayOfWeek() {
    return dayOfWeek;
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
   * getter method for working hours from.
   *
   * @return  Time
   */
  public Time getWorkingHoursFrom() {
    return workingHoursFrom;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for working hours to.
   *
   * @return  Time
   */
  public Time getWorkingHoursTo() {
    return workingHoursTo;
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
   * setter method for day of week.
   *
   * @param  dayOfWeek  String
   */
  public void setDayOfWeek(String dayOfWeek) {
    this.dayOfWeek = dayOfWeek;
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
   * setter method for working hours from.
   *
   * @param  workingHoursFrom  Time
   */
  public void setWorkingHoursFrom(Time workingHoursFrom) {
    this.workingHoursFrom = workingHoursFrom;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for working hours to.
   *
   * @param  workingHoursTo  Time
   */
  public void setWorkingHoursTo(Time workingHoursTo) {
    this.workingHoursTo = workingHoursTo;
  }


} // end class TwilioVoiceRule
