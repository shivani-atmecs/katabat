package com.cmc.credagility.core.domain.payment;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.type.PaymentStatus;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * Batch create payment for Loan Summary page
 *
 * Created by wangy on 12/29/14.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  12/29/2014 11:24 AM
 */
@Entity
@Table(name = "AggregatedPayment")
public class AggregatedPayment extends BaseEntity implements Serializable {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  @Column(
      name     = "aggregatedPaymentId",
      nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long aggregatedPaymentId;

  /** Funding Object information, keep a copy from funding account. */
  @Embedded
  protected FundingInformation fundingInformation = new FundingInformation();

  /** payment status - Processed, Scheduled, Rejected, NSF. */
  @Column(
      name     = "paymentStatus",
      nullable = false,
      length   = 20
  )
  @Enumerated(EnumType.STRING)
  protected PaymentStatus paymentStatus;

  /** total payment amount. */
  @Column(
      name      = "amount",
      nullable  = false,
      precision = 19,
      scale     = 2
  )
  protected BigDecimal amount;

  public FundingInformation getFundingInformation() {
    return fundingInformation;
  }

  public void setFundingInformation(FundingInformation fundingInformation) {
    this.fundingInformation = fundingInformation;
  }

  public PaymentStatus getPaymentStatus() {
    return paymentStatus;
  }

  public void setPaymentStatus(PaymentStatus paymentStatus) {
    this.paymentStatus = paymentStatus;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }
//~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new AggregatedPayment object.
   */
  public AggregatedPayment() { }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    AggregatedPayment that = (AggregatedPayment) o;

    if ((aggregatedPaymentId != null) ? (!aggregatedPaymentId.equals(that.aggregatedPaymentId))
                                      : (that.aggregatedPaymentId != null)) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for aggregated payment id.
   *
   * @return  Long
   */
  public Long getAggregatedPaymentId() {
    return aggregatedPaymentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  @Override public int hashCode() {
    return (aggregatedPaymentId != null) ? aggregatedPaymentId.hashCode() : 0;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for aggregated payment id.
   *
   * @param  aggregatedPaymentId  Long
   */
  public void setAggregatedPaymentId(Long aggregatedPaymentId) {
    this.aggregatedPaymentId = aggregatedPaymentId;
  }
} // end class AggregatedPayment
