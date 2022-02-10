package com.cmc.credagility.core.domain.payment;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.CascadeType;
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

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.portfolio.Portfolio;


/**
 * This class is used to store Payment information for Scottish Power Account Loader.
 *
 * <p><a href="PaymentStaging.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:kattasrinivas@etisbew.com">Srinivasa Katta</a>
 * @version  $Revision$, $Date$
 *
 *           <p>table = "PaymentStaging"</p>
 */
@Entity
@Table(name = "PaymentStaging")
public class PaymentStaging extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -5579087971478503377L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** accountNum. */
  // Fields
// @Column(
// name   = "accountNum",
// length = 20
// )
// protected Long accountNum;
  @JoinColumn(
    name     = "accountNum",
    nullable = false
  )
  @ManyToOne(cascade = { CascadeType.ALL })
  protected Account account;

  /** payment amount. */
  @Column(
    name   = "amount",
    length = 19
  )
  protected BigDecimal amount;

  /** Payment Staging id PK. */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long paymentStagingId;

  /** account portfolio. */
  @JoinColumn(
    name      = "portfolioId",
    updatable = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected Portfolio portfolio;

  // npelleti 08/17 Made processedDate column Date Type.
  /** processed date. */
  @Column(name = "processedDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date processedDate;

  @Column(
    name   = "processedStatus",
    length = 20
  )
  private String processedStatus;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  // Constructors

  /**
   * default constructor.
   */
  public PaymentStaging() { }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for account.
   *
   * @return  Account
   */
  public Account getAccount() {
    return this.account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The amount.
   *
   * @return  the amount
   *
   *          <p>not-null = "true"</p>
   */
  public BigDecimal getAmount() {
    return amount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // Property accessors

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   *          <p>generator-class = "native" unsaved-value = "null"</p>
   */
  public Long getPaymentStagingId() {
    return this.paymentStagingId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Portfolio getPortfolio() {
    return portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The amount.
   *
   * @return  the amount
   *
   *          <p>not-null = "true"</p>
   */
  public Date getProcessedDate() {
    return processedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The amount.
   *
   * @return  the amount
   *
   *          <p>not-null = "true" length = "5"</p>
   */
  public String getProcessedStatus() {
    return processedStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setAccount.
   *
   * @param  account  account number the accountNum to set
   */
  public void setAccount(Account account) {
    this.account = account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  amount  the amount to set
   */
  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentStagingId  DOCUMENT ME!
   */
  public void setpaymentStagingId(Long paymentStagingId) {
    this.paymentStagingId = paymentStagingId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  portfolio  DOCUMENT ME!
   */
  public void setPortfolio(Portfolio portfolio) {
    this.portfolio = portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  processedDate  amount the amount to set
   */
  public void setProcessedDate(Date processedDate) {
    this.processedDate = processedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  processedStatus  amount the amount to set
   */
  public void setProcessedStatus(String processedStatus) {
    this.processedStatus = processedStatus;
  }

} // end class PaymentStaging
