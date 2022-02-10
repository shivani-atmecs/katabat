package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.businesscontext.BusinessContext;
import com.ozstrategy.credagility.core.domain.decisiontree.businesscontext.BCSchedule;

import javax.persistence.*;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/16/2014 11:35
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
public class BCStrategyMasterBatch extends BaseStrategyMasterBatch {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "businessContextId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BusinessContext businessContext;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "bcScheduleId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCSchedule schedule;

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
   * getter method for schedule.
   *
   * @return  BCSchedule
   */
  public BCSchedule getSchedule() {
    return schedule;
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
   * setter method for schedule.
   *
   * @param  schedule  BCSchedule
   */
  public void setSchedule(BCSchedule schedule) {
    this.schedule = schedule;
  }
} // end class BCStrategyMasterBatch
