package com.ozstrategy.credagility.core.domain;

import com.ozstrategy.credagility.core.domain.entity.BaseEntity;
import com.ozstrategy.credagility.core.domain.type.StrategyMasterBatchStatus;
import com.ozstrategy.credagility.core.domain.type.StrategyReportType;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/16/2014 10:33
 */
@MappedSuperclass public class BaseStrategyMasterBatch extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  protected Date endDate;


  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;


  /** TODO: DOCUMENT ME! */
  @Column(nullable = true)
  protected Long loaderBatchId;


  /** TODO: DOCUMENT ME! */
  protected Long masterBatchId;


  /** TODO: DOCUMENT ME! */
  protected Date startDate;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "status",
    nullable = true,
    length   = 30
  )
  @Enumerated(value = EnumType.STRING)
  protected StrategyMasterBatchStatus status;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "strategyReportType",
    nullable = true,
    length   = 30
  )
  @Enumerated(value = EnumType.STRING)
  protected StrategyReportType strategyReportType;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for end date.
   *
   * @return  Date
   */
  public Date getEndDate() {
    return endDate;
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
   * getter method for loader batch id.
   *
   * @return  Long
   */
  public Long getLoaderBatchId() {
    return loaderBatchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for master batch id.
   *
   * @return  Long
   */
  public Long getMasterBatchId() {
    return masterBatchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for start date.
   *
   * @return  Date
   */
  public Date getStartDate() {
    return startDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status.
   *
   * @return  StrategyMasterBatchStatus
   */
  public StrategyMasterBatchStatus getStatus() {
    return status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for strategy report type.
   *
   * @return  StrategyReportType
   */
  public StrategyReportType getStrategyReportType() {
    return strategyReportType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for end date.
   *
   * @param  endDate  Date
   */
  public void setEndDate(Date endDate) {
    this.endDate = endDate;
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
   * setter method for loader batch id.
   *
   * @param  loaderBatchId  Long
   */
  public void setLoaderBatchId(Long loaderBatchId) {
    this.loaderBatchId = loaderBatchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for master batch id.
   *
   * @param  masterBatchId  Long
   */
  public void setMasterBatchId(Long masterBatchId) {
    this.masterBatchId = masterBatchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for start date.
   *
   * @param  startDate  Date
   */
  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for status.
   *
   * @param  status  StrategyMasterBatchStatus
   */
  public void setStatus(StrategyMasterBatchStatus status) {
    this.status = status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for strategy report type.
   *
   * @param  strategyReportType  StrategyReportType
   */
  public void setStrategyReportType(StrategyReportType strategyReportType) {
    this.strategyReportType = strategyReportType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * toString.
   *
   * @return  String
   */
  @Override public String toString() {
    return "BaseStrategyMasterBatch{"
      + "endDate=" + endDate
      + ", id=" + id
      + ", masterBatchId='" + masterBatchId + '\''
      + ", strategyReportType='" + strategyReportType + '\''
      + ", startDate=" + startDate
      + ", status='" + status + '\''
      + '}';
  }
} // end class BaseStrategyMasterBatch
