package com.ozstrategy.credagility.core.domain.decisiontree.agency;

import com.ozstrategy.credagility.core.domain.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * Abstract class for saving agency queue.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/15/2014 16:19
 */
@MappedSuperclass public class AgencyAbstractQueue extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  @Column(
    name     = "agencyId",
    nullable = true
  )
  private Long agencyId;

  @Column(
    name     = "queueActionId",
    nullable = true
  )
  private Long queueActionId;

  @Column(
    name     = "queueOrderResultsId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long queueOrderResultsId;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new AgencyAbstractQueue object.
   */
  public AgencyAbstractQueue() { }

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
   * getter method for queue action id.
   *
   * @return  Long
   */
  public Long getQueueActionId() {
    return queueActionId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for queue order results id.
   *
   * @return  Long
   */
  public Long getQueueOrderResultsId() {
    return queueOrderResultsId;
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

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for queue action id.
   *
   * @param  queueActionId  Long
   */
  public void setQueueActionId(Long queueActionId) {
    this.queueActionId = queueActionId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for queue order results id.
   *
   * @param  queueOrderResultsId  Long
   */
  public void setQueueOrderResultsId(Long queueOrderResultsId) {
    this.queueOrderResultsId = queueOrderResultsId;
  }
} // end class AgencyAbstractQueue
