package com.cmc.credagility.core.domain.mra;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:pan.kang@ozstrategy.com">Pan Kang</a>
 * @version  10/15/2014 13:06
 */
@Entity
@Table(
  name              = "NextQueueAccountPointer",
  uniqueConstraints = {
    @UniqueConstraint(
      name          = "queueActionId",
      columnNames   = { "queueActionId", "portfolioId" }
    )
  },
  indexes           = {
    @Index(
      name          = "currentAccountNumIndex",
      columnList    = "currentAccountNum"
    ),
    @Index(
      name          = "portfolioIdIndex",
      columnList    = "portfolioId"
    ),
    @Index(
      name          = "queueActionIdIndex",
      columnList    = "queueActionId"
    ),
    @Index(
      name          = "queueOrderResultIdIndex",
      columnList    = "queueOrderResultId"
    )
  }
)
public class NextQueueAccountPointer extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  @Column private Long currentAccountNum;

  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long id;

  @Column private Long portfolioId;

  @Column private Long queueActionId;

  @Column private Long queueOrderResultId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for current account num.
   *
   * @return  Long
   */
  public Long getCurrentAccountNum() {
    return currentAccountNum;
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
   * getter method for portfolio id.
   *
   * @return  Long
   */
  public Long getPortfolioId() {
    return portfolioId;
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
   * getter method for queue order result id.
   *
   * @return  Long
   */
  public Long getQueueOrderResultId() {
    return queueOrderResultId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for current account num.
   *
   * @param  currentAccountNum  Long
   */
  public void setCurrentAccountNum(Long currentAccountNum) {
    this.currentAccountNum = currentAccountNum;
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
   * setter method for portfolio id.
   *
   * @param  portfolioId  Long
   */
  public void setPortfolioId(Long portfolioId) {
    this.portfolioId = portfolioId;
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
   * setter method for queue order result id.
   *
   * @param  queueOrderResultId  Long
   */
  public void setQueueOrderResultId(Long queueOrderResultId) {
    this.queueOrderResultId = queueOrderResultId;
  }
} // end class NextQueueAccountPointer
