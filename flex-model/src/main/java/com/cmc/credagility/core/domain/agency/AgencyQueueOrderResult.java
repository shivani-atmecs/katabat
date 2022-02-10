package com.cmc.credagility.core.domain.agency;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.queue.AbstractBaseQueueOrderResult;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/15/2014 11:25
 */
@Entity
@Table(
  name    = "AgencyQueueOrderResult",
  indexes = {
    @Index(
      name = "ix_agencyId",
      columnList = "agencyId"
    ),
    @Index(
      name = "ix_queueActionId",
      columnList = "queueActionId"
    )
  }
)
public class AgencyQueueOrderResult extends AbstractBaseQueueOrderResult {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 3591819795241613748L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @Column(
    name     = "agencyId",
    nullable = true
  )
  private Long agencyId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for agency id.
   *
   * @return  Long
   */
  public Long getAgencyId() {
    return agencyId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agency id.
   *
   * @param  agencyId  Long
   */
  public void setAgencyId(Long agencyId) {
    this.agencyId = agencyId;
  }
} // end class AgencyQueueOrderResult
