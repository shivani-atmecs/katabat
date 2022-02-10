package com.ozstrategy.credagility.core.domain.decisiontree.businesscontext;

import com.cmc.credagility.core.domain.businesscontext.BusinessContext;
import com.cmc.credagility.core.domain.type.ScheduleStatus;
import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.BaseSchedule;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * This class is used to store BCScheduleAudit information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/16/2014 11:08
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
public class BCScheduleAudit extends BaseSchedule {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 4405333109468285894L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** The portfolio which schedule belong to. */
  @JoinColumn(
    name       = "businessContextId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BusinessContext businessContext = new BusinessContext();

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
  public BCScheduleAudit() { }

  /**
   * Creates a new BCScheduleAudit object.
   *
   * @param  schedule  BCSchedule
   */
  public BCScheduleAudit(BCSchedule schedule) {
    this.description     = schedule.getDescription();
    this.name            = schedule.getName();
    this.businessContext = schedule.getBusinessContext();
    this.scheduleDate    = schedule.getScheduleDate();
    this.scheduleStatus  = schedule.getScheduleStatus();
    this.createDate      = schedule.getCreateDate();
    this.creator         = schedule.getCreator();
    this.lastUpdateDate  = schedule.getLastUpdateDate();
    this.lastUpdater     = schedule.getLastUpdater();
    this.activeDate      = schedule.getActiveDate();
    this.publishDate     = schedule.getPublishDate();
    this.publishUser     = schedule.getPublishUser();
    this.retireDate      = schedule.getRetireDate();
    this.retireUser      = schedule.getRetireUser();
    this.setScheduleId(schedule.getScheduleId());
  }

  /**
   * Creates a new BCScheduleAudit object.
   *
   * @param  schedule   BCSchedule
   * @param  preStatus  ScheduleStatus
   */
  public BCScheduleAudit(BCSchedule schedule, ScheduleStatus preStatus) {
    this(schedule);
    this.preStatus = preStatus;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for business context.
   *
   * @return  BusinessContext
   */
  public BusinessContext getBusinessContext() {
    return businessContext;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

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
   * setter method for business context.
   *
   * @param  businessContext  BusinessContext
   */
  public void setBusinessContext(BusinessContext businessContext) {
    this.businessContext = businessContext;
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
} // end class BCScheduleAudit
