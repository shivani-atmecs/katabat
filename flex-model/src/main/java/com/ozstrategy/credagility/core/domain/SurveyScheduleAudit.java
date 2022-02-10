package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.cmc.credagility.core.domain.type.ScheduleStatus;
import com.ozstrategy.credagility.core.converter.StringBooleanConverter;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * SurveySchedule Audit.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/16/2014 17:27
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
public class SurveyScheduleAudit extends BaseSchedule {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -8072734584723218959L;

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
  @Enumerated(EnumType.STRING)
  private ScheduleStatus preStatus;

  /** primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long scheduleAuditId;

  @Column(nullable = false)
  private Long scheduleId;

  @Column(
    nullable         = true,
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean sentEmail = false;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new ScheduleAudit object.
   */
  public SurveyScheduleAudit() { }


  /**
   * Creates a new SurveyScheduleAudit object.
   *
   * @param  schedule  SurveySchedule
   */
  public SurveyScheduleAudit(SurveySchedule schedule) {
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
    this.setScheduleId(schedule.getId());
  }


  /**
   * Creates a new SurveyScheduleAudit object.
   *
   * @param  schedule   SurveySchedule
   * @param  preStatus  ScheduleStatus
   */
  public SurveyScheduleAudit(SurveySchedule schedule, ScheduleStatus preStatus) {
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
} // end class SurveyScheduleAudit
