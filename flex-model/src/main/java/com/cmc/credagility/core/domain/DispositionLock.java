package com.cmc.credagility.core.domain;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * Created by zhubq on 15/5/7.
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  06/11/2015 15:36
 */
@Entity
@Table(
  name    = "DispositionLock",
  indexes = {
    @Index(
      name = "idx_DispositionLock_expiredDte",
      columnList = "expiredDate"
    )
  }
)
public class DispositionLock extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 1286554779565339233L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  @Column(
    name     = "accountNum",
    unique   = true,
    nullable = false
  )
  protected Long accountNum;

  /** DOCUMENT ME! */
  @Column(
    name     = "agentId",
    nullable = false
  )
  protected Long agentId;

  /** TODO: DOCUMENT ME! */
  @Column
  @Temporal(TemporalType.TIMESTAMP)
  protected Date         expiredDate;

  /** DOCUMENT ME! */
  @Column(
    name     = "id",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getAccountNum() {
    return accountNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getAgentId() {
    return agentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for expired date.
   *
   * @return  Date
   */
  public Date getExpiredDate() {
    return expiredDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  accountNum  DOCUMENT ME!
   */
  public void setAccountNum(Long accountNum) {
    this.accountNum = accountNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  agentId  DOCUMENT ME!
   */
  public void setAgentId(Long agentId) {
    this.agentId = agentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for expired date.
   *
   * @param  expiredDate  Date
   */
  public void setExpiredDate(Date expiredDate) {
    this.expiredDate = expiredDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  id  DOCUMENT ME!
   */
  public void setId(Long id) {
    this.id = id;
  }
} // end class DispositionLock
