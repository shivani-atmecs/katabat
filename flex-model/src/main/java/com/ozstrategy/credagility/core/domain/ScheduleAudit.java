package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.cmc.credagility.core.domain.type.ScheduleStatus;
import com.ozstrategy.credagility.core.converter.StringBooleanConverter;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/16/2014 14:46
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
public class ScheduleAudit extends BaseSchedule {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -6775571497019946083L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** The portfolio which schedule belong to. */
  @JoinColumn(
    name       = "portfolioId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected Portfolio portfolio = new Portfolio();

  @Column(
    length   = 12,
    nullable = true
  )
  @Enumerated(value = EnumType.STRING)
  private ScheduleStatus preStatus;

  /** primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long scheduleAuditId;

  @Column(nullable = false)
  private Long scheduleId;

  @Column(
    nullable         = true,
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean sentEmail = false;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new ScheduleAudit object.
   */
  public ScheduleAudit() { }

  /**
   * Creates a new ScheduleAudit object.
   *
   * @param  schedule  Schedule
   */
  public ScheduleAudit(Schedule schedule) {
    this.description    = schedule.getDescription();
    this.name           = schedule.getName();
    this.portfolio      = schedule.getPortfolio();
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
   * Creates a new ScheduleAudit object.
   *
   * @param  schedule   Schedule
   * @param  preStatus  ScheduleStatus
   */
  public ScheduleAudit(Schedule schedule, ScheduleStatus preStatus) {
    this(schedule);
    this.preStatus = preStatus;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

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
   * getter method for portfolio id.
   *
   * @return  Long
   */
  public Long getPortfolioId() {
    return portfolio.getPortfolioId();
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
   * setter method for portfolio.
   *
   * @param  portfolio  Portfolio
   */
  public void setPortfolio(Portfolio portfolio) {
    this.portfolio = portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio id.
   *
   * @param  portfolioId  Long
   */
  public void setPortfolioId(Long portfolioId) {
    this.portfolio.setPortfolioId(portfolioId);
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
} // end class ScheduleAudit
