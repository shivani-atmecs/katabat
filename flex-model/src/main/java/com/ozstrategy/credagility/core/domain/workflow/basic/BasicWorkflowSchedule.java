package com.ozstrategy.credagility.core.domain.workflow.basic;

import com.cmc.credagility.core.domain.type.ScheduleStatus;
import com.cmc.credagility.core.domain.user.User;
import com.ozstrategy.credagility.core.domain.CreatorEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;


/**
 * Created with IntelliJ IDEA.
 *
 * <p>: Wang Yang : 13-2-19 : PM3:48</p>
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@MappedSuperclass public abstract class BasicWorkflowSchedule<S extends BasicWorkflowSchedule> extends CreatorEntity
  implements Serializable {
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
  @ManyToOne(fetch = FetchType.LAZY)
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
  @ManyToOne(fetch = FetchType.LAZY)
  protected User retireUser;

  /** Scheduled status. */
  @Column(
    length   = 12,
    nullable = false
  )
  @Enumerated(value = EnumType.STRING)
  protected ScheduleStatus scheduleStatus;

  @Column(nullable = true)
  private Long copyFromId;

  @Transient private Date processEndTime;

  @Transient private Date processStartTime;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public abstract BasicWorkflowSchedule createSchedule();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  schedule  DOCUMENT ME!
   * @param  user      DOCUMENT ME!
   */
  public abstract void deepCopy(S schedule, User user);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public abstract Set<? extends BasicWorkflow> getFlows();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public abstract Long getId();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public abstract BasicWorkflowSchedule paste();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  id  DOCUMENT ME!
   */
  public abstract void setId(Long id);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  schedule  DOCUMENT ME!
   */
  public abstract void updateSchedule(S schedule);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#equals(Object)
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

    BasicWorkflowSchedule that = (BasicWorkflowSchedule) o;

    if ((description != null) ? (!description.equals(that.description)) : (that.description != null)) {
      return false;
    }

    if (!name.equals(that.name)) {
      return false;
    }

    if ((publishDate != null) ? (!publishDate.equals(that.publishDate)) : (that.publishDate != null)) {
      return false;
    }

    if ((publishUser != null) ? (!publishUser.equals(that.publishUser)) : (that.publishUser != null)) {
      return false;
    }

    if ((retireDate != null) ? (!retireDate.equals(that.retireDate)) : (that.retireDate != null)) {
      return false;
    }

    if ((retireUser != null) ? (!retireUser.equals(that.retireUser)) : (that.retireUser != null)) {
      return false;
    }

    if (scheduleStatus != that.scheduleStatus) {
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
  public Date getActiveDate() {
    return activeDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getCopyFromId() {
    return copyFromId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDescription() {
    return description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getName() {
    return name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getProcessEndTime() {
    return processEndTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getProcessStartTime() {
    return processStartTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getPublishDate() {
    return publishDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public User getPublishUser() {
    return publishUser;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getRetireDate() {
    return retireDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public User getRetireUser() {
    return retireUser;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public ScheduleStatus getScheduleStatus() {
    return scheduleStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + name.hashCode();
    result = (31 * result) + ((description != null) ? description.hashCode() : 0);
    result = (31 * result) + ((publishDate != null) ? publishDate.hashCode() : 0);
    result = (31 * result) + ((publishUser != null) ? publishUser.hashCode() : 0);
    result = (31 * result) + ((retireDate != null) ? retireDate.hashCode() : 0);
    result = (31 * result) + ((retireUser != null) ? retireUser.hashCode() : 0);
    result = (31 * result) + ((scheduleStatus != null) ? scheduleStatus.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isEditableStatus() {
    if (this.scheduleStatus != null) {
      if (ScheduleStatus.DRAFT.equals(this.scheduleStatus) || ScheduleStatus.SCHEDULED.equals(this.scheduleStatus)
            || ScheduleStatus.ACTIVE.equals(this.scheduleStatus)) {
        // base on 05/12/2013 zhang ye said: both TAG and HotSPOT should be able to change
        // so add ScheduleStatus.ACTIVE.equals(this.scheduleStatus)
        return true;
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isReadOnly() {
    if ((getScheduleStatus() == ScheduleStatus.ACTIVE)
          || (getScheduleStatus() == ScheduleStatus.OLD)) {
      return true;
    } else {
      return false;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  schedule  DOCUMENT ME!
   */
  public void paste(BasicWorkflowSchedule schedule) {
    schedule.setName(this.getName());
    schedule.setDescription(this.getDescription());
    schedule.setLastUpdateDate(new Date());
    schedule.setLastUpdater(this.getLastUpdater());
    schedule.setScheduleStatus(this.getScheduleStatus());
    schedule.setActiveDate(this.getActiveDate());
    schedule.setRetireUser(this.getRetireUser());
    schedule.setRetireDate(this.getRetireDate());
    schedule.setPublishUser(this.getPublishUser());
    schedule.setPublishDate(this.getPublishDate());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  activeDate  DOCUMENT ME!
   */
  public void setActiveDate(Date activeDate) {
    this.activeDate = activeDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  copyFromId  DOCUMENT ME!
   */
  public void setCopyFromId(Long copyFromId) {
    this.copyFromId = copyFromId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  description  DOCUMENT ME!
   */
  public void setDescription(String description) {
    this.description = description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  name  DOCUMENT ME!
   */
  public void setName(String name) {
    this.name = name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  processEndTime  DOCUMENT ME!
   */
  public void setProcessEndTime(Date processEndTime) {
    this.processEndTime = processEndTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  processStartTime  DOCUMENT ME!
   */
  public void setProcessStartTime(Date processStartTime) {
    this.processStartTime = processStartTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  publishDate  DOCUMENT ME!
   */
  public void setPublishDate(Date publishDate) {
    this.publishDate = publishDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  publishUser  DOCUMENT ME!
   */
  public void setPublishUser(User publishUser) {
    this.publishUser = publishUser;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  retireDate  DOCUMENT ME!
   */
  public void setRetireDate(Date retireDate) {
    this.retireDate = retireDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  retireUser  DOCUMENT ME!
   */
  public void setRetireUser(User retireUser) {
    this.retireUser = retireUser;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  scheduleStatus  DOCUMENT ME!
   */
  public void setScheduleStatus(ScheduleStatus scheduleStatus) {
    this.scheduleStatus = scheduleStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   */
  public void startProcess() {
    if (processStartTime == null) {
      processStartTime = new Date();
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("WorkflowSchedule");
    sb.append("{copyFromId=").append(copyFromId);
    sb.append(", name='").append(name).append('\'');
    sb.append(", description='").append(description).append('\'');
    sb.append(", publishDate=").append(publishDate);
    sb.append(", publishUser=").append((publishUser == null) ? null : publishUser.getFullName());
    sb.append(", retireDate=").append(retireDate);
    sb.append(", retireUser=").append((retireUser == null) ? null : retireUser.getFullName());
    sb.append(", scheduleStatus=").append(scheduleStatus);
    sb.append('}');

    return sb.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  schedule  DOCUMENT ME!
   */
  public void update(BasicWorkflowSchedule schedule) {
    this.setName(schedule.getName());
    this.setCopyFromId(schedule.getId());
    this.setDescription(schedule.getDescription());
    this.setLastUpdateDate(new Date());
    this.setLastUpdater(schedule.getLastUpdater());
    this.setScheduleStatus(schedule.getScheduleStatus());
    this.setActiveDate(schedule.getActiveDate());
    this.setRetireUser(schedule.getRetireUser());
    this.setRetireDate(schedule.getRetireDate());
    this.setPublishUser(schedule.getPublishUser());
    this.setPublishDate(schedule.getPublishDate());
  }

} // end class BasicWorkflowSchedule
