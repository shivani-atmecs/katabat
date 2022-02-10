package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.type.ScheduleStatus;
import com.cmc.credagility.core.domain.user.User;

import javax.persistence.*;
import java.util.Date;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/16/2014 11:20
 */
@MappedSuperclass public class BaseSchedule extends CreatorEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** active date. */
  @Column
  @Temporal(TemporalType.TIMESTAMP)
  protected Date         activeDate;

  /** Description for the schedule. */
  @Column(length = 255)
  protected String description;

  /** Name for the schedule. */
  @Column(
    length   = 255,
    nullable = false
  )
  protected String name;

  /** published date. */
  @Column
  @Temporal(TemporalType.TIMESTAMP)
  protected Date         publishDate;

  /** Publish User . */
  @JoinColumn(
    name       = "publishUserId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected User publishUser;

  /** retire date. */
  @Column
  @Temporal(TemporalType.TIMESTAMP)
  protected Date         retireDate;

  /** Retire User . */
  @JoinColumn(
    name       = "retireUserId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected User retireUser;

  /** scheduled date. */
  @Column
  @Temporal(TemporalType.TIMESTAMP)
  protected Date         scheduleDate;

  /** Scheduled status. */
  @Column(
    length   = 12,
    nullable = false
  )
  @Enumerated(value = EnumType.STRING)
  protected ScheduleStatus scheduleStatus;

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

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    BaseSchedule that = (BaseSchedule) o;

    if ((description != null) ? (!description.equals(that.description)) : (that.description != null)) {
      return false;
    }

    if ((name != null) ? (!name.equals(that.name)) : (that.name != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for active date.
   *
   * @return  Date
   */
  public Date getActiveDate() {
    return activeDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The description.
   *
   * @return  the description
   */
  public String getDescription() {
    return description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for name.
   *
   * @return  String
   */
  public String getName() {
    return name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for publish date.
   *
   * @return  Date
   */
  public Date getPublishDate() {
    return publishDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for publish user.
   *
   * @return  User
   */
  public User getPublishUser() {
    return publishUser;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for publish user name.
   *
   * @return  String
   */
  public String getPublishUserName() {
    if (getPublishUser() != null) {
      return getPublishUser().getFullName();
    } else {
      return "";
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for retire date.
   *
   * @return  Date
   */
  public Date getRetireDate() {
    return retireDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for retire user.
   *
   * @return  User
   */
  public User getRetireUser() {
    return retireUser;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for retire user name.
   *
   * @return  String
   */
  public String getRetireUserName() {
    if (getRetireUser() != null) {
      return getRetireUser().getFullName();
    } else {
      return "";
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for schedule date.
   *
   * @return  Date
   */
  public Date getScheduleDate() {
    return scheduleDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for schedule status.
   *
   * @return  ScheduleStatus
   */
  public ScheduleStatus getScheduleStatus() {
    return scheduleStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = 47;
    result = (31 * result) + ((description != null) ? description.hashCode() : 0);
    result = (31 * result) + ((name != null) ? name.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for active date.
   *
   * @param  activeDate  Date
   */
  public void setActiveDate(Date activeDate) {
    this.activeDate = activeDate;
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
   * setter method for name.
   *
   * @param  name  String
   */
  public void setName(String name) {
    this.name = name;

    if (this.name != null) {
      this.name = this.name.trim();
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for publish date.
   *
   * @param  publishDate  Date
   */
  public void setPublishDate(Date publishDate) {
    this.publishDate = publishDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for publish user.
   *
   * @param  publishUser  User
   */
  public void setPublishUser(User publishUser) {
    this.publishUser = publishUser;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for publish user name.
   *
   * @param  name  String
   */
  public void setPublishUserName(String name) { }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for retire date.
   *
   * @param  retireDate  Date
   */
  public void setRetireDate(Date retireDate) {
    this.retireDate = retireDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for retire user.
   *
   * @param  retireUser  User
   */
  public void setRetireUser(User retireUser) {
    this.retireUser = retireUser;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for retire user name.
   *
   * @param  name  String
   */
  public void setRetireUserName(String name) { }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for schedule status.
   *
   * @param  scheduleStatus  ScheduleStatus
   */
  public void setScheduleStatus(ScheduleStatus scheduleStatus) {
    this.scheduleStatus = scheduleStatus;
  }


} // end class BaseSchedule
