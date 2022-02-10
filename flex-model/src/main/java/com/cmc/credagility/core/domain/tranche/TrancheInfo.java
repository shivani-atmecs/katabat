package com.cmc.credagility.core.domain.tranche;

import java.math.BigDecimal;
import java.math.BigInteger;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.user.Role;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/15/2014 15:34
 */
@Entity
@Table(
  name    = "TrancheInfo",
  indexes = {
    @Index(
      name = "masterBatchIdIndex",
      columnList = "masterBatchId"
    )
  }
)
public class TrancheInfo extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "billingGroupId",
    nullable = true
  )
  protected Long billingGroupId;

  /** TODO: DOCUMENT ME! */
  @Column(name = "initialTrancheAssignmentDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date initialTrancheAssignmentDate;

  /** TODO: DOCUMENT ME! */
  @Column(name = "masterBatchId")
  protected Long masterBatchId;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "productType",
    length = 12
  )
  protected String productType;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "roleId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected Role role;


  /** TODO: DOCUMENT ME! */
  @Column(name = "totalAccountCount")
  protected BigInteger totalAccountCount;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "trancheBalance",
    precision = 19,
    scale     = 2
  )
  protected BigDecimal trancheBalance;


  /** TODO: DOCUMENT ME! */
  @Column(name = "trancheCommission")
  protected BigDecimal trancheCommission;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "trancheId ",
    length = 255
  )
  protected String trancheId;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "trancheSalesPrice",
    precision = 19,
    scale     = 4
  )
  protected BigDecimal trancheSalesPrice;


  /** TODO: DOCUMENT ME! */
  @Column(name = "trancheTotalPayments ")
  protected BigDecimal trancheTotalPayments;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long id;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new AccountSaleInfo object.
   */
  public TrancheInfo() { }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    TrancheInfo that = (TrancheInfo) o;

    if ((billingGroupId != null) ? (!billingGroupId.equals(that.billingGroupId)) : (that.billingGroupId != null)) {
      return false;
    }

    if ((id != null) ? (!id.equals(that.id)) : (that.id != null)) {
      return false;
    }

    if ((initialTrancheAssignmentDate != null)
          ? (!initialTrancheAssignmentDate.equals(that.initialTrancheAssignmentDate))
          : (that.initialTrancheAssignmentDate != null)) {
      return false;
    }

    if ((masterBatchId != null) ? (!masterBatchId.equals(that.masterBatchId)) : (that.masterBatchId != null)) {
      return false;
    }

    if ((productType != null) ? (!productType.equals(that.productType)) : (that.productType != null)) {
      return false;
    }

    if ((role != null) ? (!role.equals(that.role)) : (that.role != null)) {
      return false;
    }

    if ((totalAccountCount != null) ? (!totalAccountCount.equals(that.totalAccountCount))
                                    : (that.totalAccountCount != null)) {
      return false;
    }

    if ((trancheBalance != null) ? (!trancheBalance.equals(that.trancheBalance)) : (that.trancheBalance != null)) {
      return false;
    }

    if ((trancheCommission != null) ? (!trancheCommission.equals(that.trancheCommission))
                                    : (that.trancheCommission != null)) {
      return false;
    }

    if ((trancheId != null) ? (!trancheId.equals(that.trancheId)) : (that.trancheId != null)) {
      return false;
    }

    if ((trancheSalesPrice != null) ? (!trancheSalesPrice.equals(that.trancheSalesPrice))
                                    : (that.trancheSalesPrice != null)) {
      return false;
    }

    if ((trancheTotalPayments != null) ? (!trancheTotalPayments.equals(that.trancheTotalPayments))
                                       : (that.trancheTotalPayments != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

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
   * getter method for id.
   *
   * @return  Long
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for initial tranche assignment date.
   *
   * @return  Date
   */
  public Date getInitialTrancheAssignmentDate() {
    return initialTrancheAssignmentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for master batch id.
   *
   * @return  Long
   */
  public Long getMasterBatchId() {
    return masterBatchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for product type.
   *
   * @return  String
   */
  public String getProductType() {
    return productType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for role.
   *
   * @return  Role
   */
  public Role getRole() {
    return role;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for total account count.
   *
   * @return  BigInteger
   */
  public BigInteger getTotalAccountCount() {
    return totalAccountCount;
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
   * getter method for tranche id.
   *
   * @return  String
   */
  public String getTrancheId() {
    return trancheId;
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
   * getter method for tranche total payments.
   *
   * @return  BigDecimal
   */
  public BigDecimal getTrancheTotalPayments() {
    return trancheTotalPayments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((initialTrancheAssignmentDate != null) ? initialTrancheAssignmentDate.hashCode() : 0);
    result = (31 * result) + ((masterBatchId != null) ? masterBatchId.hashCode() : 0);
    result = (31 * result) + ((productType != null) ? productType.hashCode() : 0);
    result = (31 * result) + ((role != null) ? role.hashCode() : 0);
    result = (31 * result) + ((totalAccountCount != null) ? totalAccountCount.hashCode() : 0);
    result = (31 * result) + ((trancheBalance != null) ? trancheBalance.hashCode() : 0);
    result = (31 * result) + ((billingGroupId != null) ? billingGroupId.hashCode() : 0);
    result = (31 * result) + ((trancheCommission != null) ? trancheCommission.hashCode() : 0);
    result = (31 * result) + ((trancheId != null) ? trancheId.hashCode() : 0);
    result = (31 * result) + ((trancheSalesPrice != null) ? trancheSalesPrice.hashCode() : 0);
    result = (31 * result) + ((trancheTotalPayments != null) ? trancheTotalPayments.hashCode() : 0);
    result = (31 * result) + ((id != null) ? id.hashCode() : 0);

    return result;
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
   * setter method for id.
   *
   * @param  id  Long
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for initial tranche assignment date.
   *
   * @param  initialTrancheAssignmentDate  Date
   */
  public void setInitialTrancheAssignmentDate(Date initialTrancheAssignmentDate) {
    this.initialTrancheAssignmentDate = initialTrancheAssignmentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for master batch id.
   *
   * @param  masterBatchId  Long
   */
  public void setMasterBatchId(Long masterBatchId) {
    this.masterBatchId = masterBatchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for product type.
   *
   * @param  productType  String
   */
  public void setProductType(String productType) {
    this.productType = productType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for role.
   *
   * @param  role  Role
   */
  public void setRole(Role role) {
    this.role = role;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for total account count.
   *
   * @param  totalAccountCount  BigInteger
   */
  public void setTotalAccountCount(BigInteger totalAccountCount) {
    this.totalAccountCount = totalAccountCount;
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
   * setter method for tranche id.
   *
   * @param  trancheId  String
   */
  public void setTrancheId(String trancheId) {
    this.trancheId = trancheId;
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

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for tranche total payments.
   *
   * @param  trancheTotalPayments  BigDecimal
   */
  public void setTrancheTotalPayments(BigDecimal trancheTotalPayments) {
    this.trancheTotalPayments = trancheTotalPayments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#toString()
   */
  @Override public String toString() {
    return "TrancheInfo{"
      + "billingGroupId=" + billingGroupId
      + ", initialTrancheAssignmentDate=" + initialTrancheAssignmentDate
      + ", masterBatchId=" + masterBatchId
      + ", productType='" + productType + '\''
      + ", role=" + role
      + ", totalAccountCount=" + totalAccountCount
      + ", trancheBalance=" + trancheBalance
      + ", trancheCommission=" + trancheCommission
      + ", trancheId='" + trancheId + '\''
      + ", trancheSalesPrice=" + trancheSalesPrice
      + ", trancheTotalPayments=" + trancheTotalPayments
      + ", id=" + id
      + '}';
  }

} // end class TrancheInfo
