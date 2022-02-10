package com.cmc.credagility.core.domain.businesscontext;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.queue.AbstractBaseQueueOrderResult;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 11:07
 */
@Entity
@Table(
  indexes = {
    @Index(
      name = "ix_businessContextInstanceId",
      columnList = "businessContextInstanceId"
    ),
    @Index(
      name = "ix_queueActionId",
      columnList = "queueActionId"
    )
  }
)
public class BCIQueueOrderResult extends AbstractBaseQueueOrderResult {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  @Column(
    name     = "businessContextInstanceId",
    nullable = true
  )
  private Long businessContextInstanceId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for business context instance id.
   *
   * @return  Long
   */
  public Long getBusinessContextInstanceId() {
    return businessContextInstanceId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for business context instance id.
   *
   * @param  businessContextInstanceId  Long
   */
  public void setBusinessContextInstanceId(Long businessContextInstanceId) {
    this.businessContextInstanceId = businessContextInstanceId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------
  
  /**
   * @see  com.cmc.credagility.core.domain.queue.AbstractBaseQueueOrderResult#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!super.equals(o)) {
      return false;
    }

    BCIQueueOrderResult that = (BCIQueueOrderResult) o;


    return (businessContextInstanceId != null) ? businessContextInstanceId.equals(that.businessContextInstanceId)
                                               : (that.businessContextInstanceId == null);

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.queue.AbstractBaseQueueOrderResult#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((businessContextInstanceId != null) ? businessContextInstanceId.hashCode() : 0);

    return result;
  }
} // end class BCIQueueOrderResult
