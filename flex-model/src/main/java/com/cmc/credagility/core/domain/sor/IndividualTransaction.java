package com.cmc.credagility.core.domain.sor;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.base.CreatorEntity;
import com.cmc.credagility.core.domain.payment.FundingAccount;
import com.cmc.credagility.core.jpa.converter.StringEncryptionConverter;


/**
 * Created by zhubq on 3/4/16.
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  03/04/2016 14:38
 */
@Entity
@Table(name = "IndividualTransaction")
public class IndividualTransaction extends CreatorEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -4330186306975131322L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "accountNum",
    insertable = true,
    updatable  = false,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Account account;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = " batchHeaderId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected TransactionBatchHeader batchHeader;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "batchStatus",
    nullable = false,
    length   = 10
  )
  protected String batchStatus;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "effectiveDate",
    nullable = true
  )
  @Temporal(TemporalType.TIMESTAMP)
  protected Date effectiveDate;

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = true,
    length   = 4
  )
  protected String feeTransCode;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = " fundingAccountId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected FundingAccount fundingAccount;

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = true,
    length   = 102
  )
  protected String fundingSource;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "paymentId",
    nullable = true
  )
  protected Long paymentId;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = " paymentMethodId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PaymentMethod paymentMethod;


  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = true,
    length   = 12
  )
  protected String productType;


  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  protected BigDecimal transAmount;

  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long transBatchId;


  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = false,
    length   = 4
  )
  protected String transCode;

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

    IndividualTransaction that = (IndividualTransaction) o;

    if ((batchHeader != null) ? (!batchHeader.equals(that.batchHeader)) : (that.batchHeader != null)) {
      return false;
    }

    if (batchStatus != that.batchStatus) {
      return false;
    }

    if ((effectiveDate != null) ? (!effectiveDate.equals(that.effectiveDate)) : (that.effectiveDate != null)) {
      return false;
    }

    if ((feeTransCode != null) ? (!feeTransCode.equals(that.feeTransCode)) : (that.feeTransCode != null)) {
      return false;
    }

    if ((fundingSource != null) ? (!fundingSource.equals(that.fundingSource)) : (that.fundingSource != null)) {
      return false;
    }


    if ((paymentMethod != null) ? (!paymentMethod.equals(that.paymentMethod)) : (that.paymentMethod != null)) {
      return false;
    }

    if ((productType != null) ? (!productType.equals(that.productType)) : (that.productType != null)) {
      return false;
    }

    if ((transAmount != null) ? (!transAmount.equals(that.transAmount)) : (that.transAmount != null)) {
      return false;
    }

    if ((transBatchId != null) ? (!transBatchId.equals(that.transBatchId)) : (that.transBatchId != null)) {
      return false;
    }

    if ((account != null) ? (!account.equals(that.account)) : (that.account != null)) {
      return false;
    }

    if ((paymentId != null) ? (!paymentId.equals(that.paymentId)) : (that.paymentId != null)) {
      return false;
    }

    return !((transCode != null) ? (!transCode.equals(that.transCode)) : (that.transCode != null));

  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account.
   *
   * @return  Account
   */
  public Account getAccount() {
    return account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for batch header.
   *
   * @return  TransactionBatchHeader
   */
  public TransactionBatchHeader getBatchHeader() {
    return batchHeader;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for batch status.
   *
   * @return  String
   */
  public String getBatchStatus() {
    return batchStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for effective date.
   *
   * @return  String
   */
  public Date getEffectiveDate() {
    return effectiveDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for fee trans code.
   *
   * @return  String
   */
  public String getFeeTransCode() {
    return feeTransCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for funding account.
   *
   * @return  FundingAccount
   */
  public FundingAccount getFundingAccount() {
    return fundingAccount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for funding source.
   *
   * @return  String
   */
  public String getFundingSource() {
    return fundingSource;
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
   * getter method for payment method.
   *
   * @return  PaymentMethod
   */
  public PaymentMethod getPaymentMethod() {
    return paymentMethod;
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
   * getter method for trans amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getTransAmount() {
    return transAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for trans batch id.
   *
   * @return  Long
   */
  public Long getTransBatchId() {
    return transBatchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for trans code.
   *
   * @return  String
   */
  public String getTransCode() {
    return transCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((batchHeader != null) ? batchHeader.hashCode() : 0);
    result = (31 * result) + ((batchStatus != null) ? batchStatus.hashCode() : 0);
    result = (31 * result) + ((effectiveDate != null) ? effectiveDate.hashCode() : 0);
    result = (31 * result) + ((feeTransCode != null) ? feeTransCode.hashCode() : 0);
    result = (31 * result) + ((fundingSource != null) ? fundingSource.hashCode() : 0);
    result = (31 * result) + ((paymentMethod != null) ? paymentMethod.hashCode() : 0);
    result = (31 * result) + ((productType != null) ? productType.hashCode() : 0);
    result = (31 * result) + ((account != null) ? account.hashCode() : 0);
    result = (31 * result) + ((transAmount != null) ? transAmount.hashCode() : 0);
    result = (31 * result) + ((transBatchId != null) ? transBatchId.hashCode() : 0);
    result = (31 * result) + ((paymentId != null) ? paymentId.hashCode() : 0);
    result = (31 * result) + ((transCode != null) ? transCode.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account.
   *
   * @param  account  Account
   */
  public void setAccount(Account account) {
    this.account = account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for batch header.
   *
   * @param  batchHeader  TransactionBatchHeader
   */
  public void setBatchHeader(TransactionBatchHeader batchHeader) {
    this.batchHeader = batchHeader;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for batch status.
   *
   * @param  batchStatus  String
   */
  public void setBatchStatus(String batchStatus) {
    this.batchStatus = batchStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for effective date.
   *
   * @param  effectiveDate  String
   */
  public void setEffectiveDate(Date effectiveDate) {
    this.effectiveDate = effectiveDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for fee trans code.
   *
   * @param  feeTransCode  String
   */
  public void setFeeTransCode(String feeTransCode) {
    this.feeTransCode = feeTransCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for funding account.
   *
   * @param  fundingAccount  FundingAccount
   */
  public void setFundingAccount(FundingAccount fundingAccount) {
    this.fundingAccount = fundingAccount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for funding source.
   *
   * @param  fundingSource  String
   */
  public void setFundingSource(String fundingSource) {
    this.fundingSource = fundingSource;
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
   * setter method for payment method.
   *
   * @param  paymentMethod  PaymentMethod
   */
  public void setPaymentMethod(PaymentMethod paymentMethod) {
    this.paymentMethod = paymentMethod;
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
   * setter method for trans amount.
   *
   * @param  transAmount  BigDecimal
   */
  public void setTransAmount(BigDecimal transAmount) {
    this.transAmount = transAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for trans batch id.
   *
   * @param  transBatchId  Long
   */
  public void setTransBatchId(Long transBatchId) {
    this.transBatchId = transBatchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for trans code.
   *
   * @param  transCode  String
   */
  public void setTransCode(String transCode) {
    this.transCode = transCode;
  }
} // end class IndividualTransaction
