package com.ozstrategy.credagility.core.domain;

import com.ozstrategy.credagility.core.domain.decisiontree.agency.AgencySchedule;

import javax.persistence.*;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/16/2014 10:27
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
public class AgencyStrategyMasterBatch extends BaseStrategyMasterBatch {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "agencyScheduleId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected AgencySchedule schedule;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for schedule.
   *
   * @return  AgencySchedule
   */
  public AgencySchedule getSchedule() {
    return schedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for schedule.
   *
   * @param  schedule  AgencySchedule
   */
  public void setSchedule(AgencySchedule schedule) {
    this.schedule = schedule;
  }
} // end class AgencyStrategyMasterBatch
