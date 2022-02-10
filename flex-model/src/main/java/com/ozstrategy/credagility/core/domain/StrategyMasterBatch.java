package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.portfolio.Portfolio;

import javax.persistence.*;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/16/2014 15:06
 */
@Entity
@Table(
  indexes = {
    @Index(
      name = "loaderBatchIdIndex",
      columnList = "loaderBatchId"
    )
  }
)
public class StrategyMasterBatch extends BaseStrategyMasterBatch {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "portfolioId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Portfolio portfolio = new Portfolio();


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "scheduleId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Schedule schedule = new Schedule();

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
   * getter method for schedule.
   *
   * @return  Schedule
   */
  public Schedule getSchedule() {
    return schedule;
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
   * setter method for schedule.
   *
   * @param  schedule  Schedule
   */
  public void setSchedule(Schedule schedule) {
    this.schedule = schedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * toString.
   *
   * @return  String
   */
  @Override public String toString() {
    return "StrategyMasterBatch{"
      + "endDate=" + endDate
      + ", id=" + id
      + ", masterBatchId='" + masterBatchId + '\''
      + ", portfolio=" + portfolio
      + ", schedule=" + schedule
      + ", strategyReportType='" + strategyReportType + '\''
      + ", startDate=" + startDate
      + ", status='" + status + '\''
      + '}';
  }
} // end class StrategyMasterBatch
