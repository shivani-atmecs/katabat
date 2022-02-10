package com.cmc.credagility.core.domain.transaction;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.payment.Payment;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/15/2014 15:50
 */
@Entity
@Table(name = "TransactionPaymentApplication")
public class TransactionPaymentApplication extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  @Column(name = "appliedDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date appliedDate;

  @GeneratedValue(strategy = IDENTITY)
  @Id private Long id;

  @Column(
    name      = "paidAmount",
    nullable  = false,
    precision = 19,
    scale     = 2
  )
  private BigDecimal paidAmount = new BigDecimal(0.00);

  @JoinColumn(
    name       = "paymentId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private Payment         payment;
  @JoinColumn(
    name       = "transactionId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private TransactionData transaction;

  @Column(
    name      = "unpaidAmount",
    nullable  = true,
    precision = 19,
    scale     = 2
  )
  private BigDecimal unpaidAmount;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new TransactionPaymentApplication object.
   */
  public TransactionPaymentApplication() { }

  /**
   * Creates a new TransactionPaymentApplication object.
   *
   * @param  payment      Payment
   * @param  transaction  TransactionData
   */
  public TransactionPaymentApplication(Payment payment, TransactionData transaction) {
    this.payment      = payment;
    this.transaction  = transaction;
    this.paidAmount   = transaction.getPaidAmount();
    this.unpaidAmount = transaction.getAmount().subtract(transaction.getPaidAmount());
    this.appliedDate  = new Date();
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for applied date.
   *
   * @return  Date
   */
  public Date getAppliedDate() {
    return appliedDate;
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
   * getter method for paid amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPaidAmount() {
    return paidAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment.
   *
   * @return  Payment
   */
  public Payment getPayment() {
    return payment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for transaction.
   *
   * @return  TransactionData
   */
  public TransactionData getTransaction() {
    return transaction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for unpaid amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getUnpaidAmount() {
    return unpaidAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for applied date.
   *
   * @param  appliedDate  Date
   */
  public void setAppliedDate(Date appliedDate) {
    this.appliedDate = appliedDate;
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
   * setter method for paid amount.
   *
   * @param  paidAmount  BigDecimal
   */
  public void setPaidAmount(BigDecimal paidAmount) {
    this.paidAmount = paidAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for payment.
   *
   * @param  payment  Payment
   */
  public void setPayment(Payment payment) {
    this.payment = payment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for transaction.
   *
   * @param  transaction  TransactionData
   */
  public void setTransaction(TransactionData transaction) {
    this.transaction = transaction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for unpaid amount.
   *
   * @param  unpaidAmount  BigDecimal
   */
  public void setUnpaidAmount(BigDecimal unpaidAmount) {
    this.unpaidAmount = unpaidAmount;
  }
} // end class TransactionPaymentApplication
