package com.cmc.credagility.core.domain.tranche;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/15/2014 15:35
 */
@Entity
@Table(name = "TrancheInfoAudit")
public class TrancheInfoAudit extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "billingGroupId",
    nullable = true
  )
  protected Long billingGroupId;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "commissionRate",
    precision = 19,
    scale     = 3,
    nullable  = true
  )
  protected BigDecimal commissionRate;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "commissionType",
    length   = 12,
    nullable = true
  )
  protected String commissionType;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "externalEntityId",
    nullable = true
  )
  protected Long externalEntityId;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "paymentId",
    nullable = true
  )
  protected Long paymentId;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "trancheBalance",
    precision = 19,
    scale     = 2,
    nullable  = true
  )
  protected BigDecimal trancheBalance;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "trancheCommission",
    nullable = true
  )
  protected BigDecimal trancheCommission;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "trancheInfoId",
    nullable = true
  )
  protected Long trancheInfoId;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "trancheSalesPrice",
    precision = 19,
    scale     = 4,
    nullable  = true
  )
  protected BigDecimal trancheSalesPrice;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long id;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for billing group id.
   *
   * @return  Long
   */
  public Long getBillingGroupId() {
    return billingGroupId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for commission rate.
   *
   * @return  BigDecimal
   */
  public BigDecimal getCommissionRate() {
    return commissionRate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for commission type.
   *
   * @return  String
   */
  public String getCommissionType() {
    return commissionType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for external entity id.
   *
   * @return  Long
   */
  public Long getExternalEntityId() {
    return externalEntityId;
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
   * getter method for payment id.
   *
   * @return  Long
   */
  public Long getPaymentId() {
    return paymentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for tranche balance.
   *
   * @return  BigDecimal
   */
  public BigDecimal getTrancheBalance() {
    return trancheBalance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for tranche commission.
   *
   * @return  BigDecimal
   */
  public BigDecimal getTrancheCommission() {
    return trancheCommission;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for tranche info id.
   *
   * @return  Long
   */
  public Long getTrancheInfoId() {
    return trancheInfoId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for tranche sales price.
   *
   * @return  BigDecimal
   */
  public BigDecimal getTrancheSalesPrice() {
    return trancheSalesPrice;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for billing group id.
   *
   * @param  billingGroupId  Long
   */
  public void setBillingGroupId(Long billingGroupId) {
    this.billingGroupId = billingGroupId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for commission rate.
   *
   * @param  commissionRate  BigDecimal
   */
  public void setCommissionRate(BigDecimal commissionRate) {
    this.commissionRate = commissionRate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for commission type.
   *
   * @param  commissionType  String
   */
  public void setCommissionType(String commissionType) {
    this.commissionType = commissionType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for external entity id.
   *
   * @param  externalEntityId  Long
   */
  public void setExternalEntityId(Long externalEntityId) {
    this.externalEntityId = externalEntityId;
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
   * setter method for payment id.
   *
   * @param  paymentId  Long
   */
  public void setPaymentId(Long paymentId) {
    this.paymentId = paymentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for tranche balance.
   *
   * @param  trancheBalance  BigDecimal
   */
  public void setTrancheBalance(BigDecimal trancheBalance) {
    this.trancheBalance = trancheBalance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for tranche commission.
   *
   * @param  trancheCommission  BigDecimal
   */
  public void setTrancheCommission(BigDecimal trancheCommission) {
    this.trancheCommission = trancheCommission;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for tranche info id.
   *
   * @param  trancheInfoId  Long
   */
  public void setTrancheInfoId(Long trancheInfoId) {
    this.trancheInfoId = trancheInfoId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for tranche sales price.
   *
   * @param  trancheSalesPrice  BigDecimal
   */
  public void setTrancheSalesPrice(BigDecimal trancheSalesPrice) {
    this.trancheSalesPrice = trancheSalesPrice;
  }


} // end class TrancheInfoAudit
