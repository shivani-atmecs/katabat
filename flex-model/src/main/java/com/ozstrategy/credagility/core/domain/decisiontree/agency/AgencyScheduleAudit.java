package com.ozstrategy.credagility.core.domain.decisiontree.agency;

import com.cmc.credagility.core.domain.type.ScheduleStatus;
import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.BaseSchedule;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * This class is used to store AgencyScheduleAudit information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/15/2014 17:16
 */
@Entity
@Table(
  indexes = {
    @Index(
      name = "statusIndex",
      columnList = "scheduleStatus,preStatus"
    )
  }
)
public class AgencyScheduleAudit extends BaseSchedule implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 8729673484822063897L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @Column(
    length   = 12,
    nullable = true
  )
  @Enumerated(EnumType.STRING)
  private ScheduleStatus preStatus;

  /** primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long scheduleAuditId;

  @Column(nullable = false)
  private Long scheduleId;


  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean sentEmail = false;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new ScheduleAudit object.
   */
  public AgencyScheduleAudit() { }

  /**
   * Creates a new AgencyScheduleAudit object.
   *
   * @param  schedule  AgencySchedule
   */
  public AgencyScheduleAudit(AgencySchedule schedule) {
    this.description    = schedule.getDescription();
    this.name           = schedule.getName();
    this.scheduleDate   = schedule.getScheduleDate();
    this.scheduleStatus = schedule.getScheduleStatus();
    this.createDate     = schedule.getCreateDate();
    this.creator        = schedule.getCreator();
    this.lastUpdateDate = schedule.getLastUpdateDate();
    this.lastUpdater    = schedule.getLastUpdater();
    this.activeDate     = schedule.getActiveDate();
    this.publishDate    = schedule.getPublishDate();
    this.publishUser    = schedule.getPublishUser();
    this.retireDate     = schedule.getRetireDate();
    this.retireUser     = schedule.getRetireUser();
    this.setScheduleId(schedule.getScheduleId());
  }

  /**
   * Creates a new AgencyScheduleAudit object.
   *
   * @param  schedule   AgencySchedule
   * @param  preStatus  ScheduleStatus
   */
  public AgencyScheduleAudit(AgencySchedule schedule, ScheduleStatus preStatus) {
    this(schedule);
    this.preStatus = preStatus;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for pre status.
   *
   * @return  ScheduleStatus
   */
  public ScheduleStatus getPreStatus() {
    return preStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for schedule audit id.
   *
   * @return  Long
   */
  public Long getScheduleAuditId() {
    return scheduleAuditId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for schedule id.
   *
   * @return  Long
   */
  public Long getScheduleId() {
    return scheduleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for sent email.
   *
   * @return  Boolean
   */
  public Boolean getSentEmail() {
    if (sentEmail == null) {
      return Boolean.FALSE;
    }

    return sentEmail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for pre status.
   *
   * @param  preStatus  ScheduleStatus
   */
  public void setPreStatus(ScheduleStatus preStatus) {
    this.preStatus = preStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for schedule audit id.
   *
   * @param  scheduleAuditId  Long
   */
  public void setScheduleAuditId(Long scheduleAuditId) {
    this.scheduleAuditId = scheduleAuditId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for schedule date.
   *
   * @param  scheduleDate  Date
   */
  public void setScheduleDate(Date scheduleDate) {
    this.scheduleDate = scheduleDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for schedule id.
   *
   * @param  scheduleId  Long
   */
  public void setScheduleId(Long scheduleId) {
    this.scheduleId = scheduleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for sent email.
   *
   * @param  sentEmail  Boolean
   */
  public void setSentEmail(Boolean sentEmail) {
    this.sentEmail = sentEmail;
  }
} // end class AgencyScheduleAudit
