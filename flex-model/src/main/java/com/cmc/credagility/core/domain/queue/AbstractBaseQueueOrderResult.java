package com.cmc.credagility.core.domain.queue;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * This class is used to store the pre-populated sort order information for all the queues.
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/15/2014 11:02
 */
@MappedSuperclass public abstract class AbstractBaseQueueOrderResult extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 8180108635564147910L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

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

  //~ Methods ----------------------------------------------------------------------------------------------------------

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

  //~ ------------------------------------------------------------------------------------------------------------------
  
  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!super.equals(o)) {
      return false;
    }

    AbstractBaseQueueOrderResult that = (AbstractBaseQueueOrderResult) o;

    if ((queueActionId != null) ? (!queueActionId.equals(that.queueActionId)) : (that.queueActionId != null)) {
      return false;
    }

    return (queueOrderResultsId != null) ? queueOrderResultsId.equals(that.queueOrderResultsId)
                                         : (that.queueOrderResultsId == null);

  }

  //~ ------------------------------------------------------------------------------------------------------------------
  
  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((queueActionId != null) ? queueActionId.hashCode() : 0);
    result = (31 * result) + ((queueOrderResultsId != null) ? queueOrderResultsId.hashCode() : 0);

    return result;
  }
} // end class AbstractBaseQueueOrderResult
