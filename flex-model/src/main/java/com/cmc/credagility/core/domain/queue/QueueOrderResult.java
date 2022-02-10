package com.cmc.credagility.core.domain.queue;

import com.cmc.credagility.core.domain.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * This class is used to store the pre-populated sort order information for all the queues.
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/15/2014 11:13
 */
@Entity
@Table(
  name    = "QueueOrderResult",
  indexes = {
    @Index(
      name = "ix_accountNum",
      columnList = "accountNum"
    ),
    @Index(
      name = "ix_queueActionId",
      columnList = "queueActionId"
    ),
    @Index(
      name = "ix_lastLoadDate",
      columnList = "lastLoadDate"
    )
  }
)
public class QueueOrderResult extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 8180108635564147910L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @Column(
    name     = "accountNum",
    nullable = true
  )
  private Long         accountNum;
  @Column
  @Temporal(TemporalType.TIMESTAMP)
  private Date         lastLoadDate;

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
   * getter method for account num.
   *
   * @return  Long
   */
  public Long getAccountNum() {
    return accountNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last load date.
   *
   * @return  Date
   */
  public Date getLastLoadDate() {
    return lastLoadDate;
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
   * setter method for account num.
   *
   * @param  accountNum  Long
   */
  public void setAccountNum(Long accountNum) {
    this.accountNum = accountNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last load date.
   *
   * @param  lastLoadDate  Date
   */
  public void setLastLoadDate(Date lastLoadDate) {
    this.lastLoadDate = lastLoadDate;
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
} // end class QueueOrderResult
