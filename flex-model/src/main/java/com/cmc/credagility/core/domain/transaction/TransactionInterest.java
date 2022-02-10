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
import com.cmc.credagility.core.domain.util.DateUtil;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/15/2014 15:49
 */
@Entity
@Table(name = "TransactionInterest")
public class TransactionInterest extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  @Column(
    name      = "amount",
    nullable  = false,
    precision = 19,
    scale     = 2
  )
  private BigDecimal amount = new BigDecimal(0.00);

  @Column(name = "cycleDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date cycleDate;

  @GeneratedValue(strategy = IDENTITY)
  @Id private Long id;

  @Column(
    name      = "interest",
    nullable  = false,
    precision = 19,
    scale     = 2
  )
  private BigDecimal interest;

  @Column(name = "interestEndDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date interestEndDate;


  @Column(name = "interestStartDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date interestStartDate;


  @JoinColumn(
    name       = "transactionId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private TransactionData transaction;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new TransactionInterest object.
   */
  public TransactionInterest() { }


  /**
   * Creates a new TransactionInterest object.
   *
   * @param  transaction   TransactionData
   * @param  interestRate  BigDecimal
   * @param  cycleDate     Date
   */
  public TransactionInterest(TransactionData transaction, BigDecimal interestRate, Date cycleDate) {
    this.transaction       = transaction;
    this.amount            = transaction.getAmount();
    this.cycleDate         = cycleDate;
    this.interestEndDate   = cycleDate;
    this.interestStartDate = transaction.getInterestStartDate();
    this.interest          = calculationInterest(interestRate);
  }

  /**
   * Creates a new TransactionInterest object.
   *
   * @param  amount             BigDecimal
   * @param  transaction        TransactionData
   * @param  cycleDate          Date
   * @param  interestEndDate    Date
   * @param  interestStartDate  Date
   * @param  interestRate       BigDecimal
   */
  public TransactionInterest(BigDecimal amount, TransactionData transaction, Date cycleDate,
    Date interestEndDate, Date interestStartDate, BigDecimal interestRate) {
    this.amount            = amount;
    this.transaction       = transaction;
    this.cycleDate         = cycleDate;
    this.interestEndDate   = interestEndDate;
    this.interestStartDate = interestStartDate;
    this.interest          = calculationInterest(interestRate);
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * calculationInterest.
   *
   * @param   interestRate  BigDecimal
   *
   * @return  BigDecimal
   */
  public BigDecimal calculationInterest(BigDecimal interestRate) {
    BigDecimal interest = BigDecimal.ZERO;

    if (interestRate != null) {
      BigDecimal dayInterest = (this.amount.multiply(interestRate)).divide(new BigDecimal("365"), 4);
      Integer    day         = DateUtil.getDayDifference(interestStartDate, interestEndDate);
      interest = dayInterest.multiply(new BigDecimal(day.toString()));
    }

    return interest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getAmount() {
    return amount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for cycle date.
   *
   * @return  Date
   */
  public Date getCycleDate() {
    return cycleDate;
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
   * getter method for interest.
   *
   * @return  BigDecimal
   */
  public BigDecimal getInterest() {
    return interest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for interest end date.
   *
   * @return  Date
   */
  public Date getInterestEndDate() {
    return interestEndDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for interest start date.
   *
   * @return  Date
   */
  public Date getInterestStartDate() {
    return interestStartDate;
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
   * setter method for amount.
   *
   * @param  amount  BigDecimal
   */
  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for cycle date.
   *
   * @param  cycleDate  Date
   */
  public void setCycleDate(Date cycleDate) {
    this.cycleDate = cycleDate;
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
   * setter method for interest.
   *
   * @param  interest  BigDecimal
   */
  public void setInterest(BigDecimal interest) {
    this.interest = interest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for interest end date.
   *
   * @param  interestEndDate  Date
   */
  public void setInterestEndDate(Date interestEndDate) {
    this.interestEndDate = interestEndDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for interest start date.
   *
   * @param  interestStartDate  Date
   */
  public void setInterestStartDate(Date interestStartDate) {
    this.interestStartDate = interestStartDate;
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

} // end class TransactionInterest
