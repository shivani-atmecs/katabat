package com.cmc.credagility.core.domain.payment;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
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

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.responsible.Responsible;


/**
 * Created with IntelliJ IDEA. User: yongliu Date: 11/20/12 Time: 8:52 AM To change this template use File | Settings |
 * File Templates.
 *
 * @author   <a href="mailto:yong.liu@ozstrategy.com">Yong Liu</a>
 * @version  10/15/2014 11:52
 */
@Entity
@Table(name = "RecurringPayment")
public class RecurringPayment extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 2184352386461602181L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** payment amount <code>String.</code> */
  protected String amount;

  /** The expression of amount. */
  @Column(
    nullable = true,
    length   = 255
  )
  protected String amountExpression;

  /** The expression of date. */
  @Column(
    nullable = true,
    length   = 255
  )
  protected String dateExpression;

  /** The payment date <code>String.</code> */
  protected String dateOfPayment;

  /** end date. */
  @Temporal(value = TemporalType.TIMESTAMP)
  protected Date endDate;

  /** this will be persisted. */
  @JoinColumn(
    name     = "fundingAccountId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected FundingAccount fundingAccount;

  /** Recurrence number. */
  protected Integer numberOfRecurrence;

  /** Primary key. */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long paymentId;

  /** responsible id. */
  @JoinColumn(
    name      = "responsibleId",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Responsible responsible;

  /** status. */
  protected String status;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    RecurringPayment payment = (RecurringPayment) obj;


    if (this.paymentId == null) {
      if (payment.getPaymentId() != null) {
        return false;
      }
    } else if (this.paymentId.compareTo(payment.getPaymentId()) > 0) {
      return false;
    }

    if (this.amount == null) {
      if (payment.getAmount() != null) {
        return false;
      }
    } else if (this.amount.compareTo(payment.getAmount()) > 0) {
      return false;
    }

    if (this.endDate == null) {
      if (payment.getEndDate() != null) {
        return false;
      }
    } else if (this.endDate.compareTo(payment.getEndDate()) > 0) {
      return false;
    }

    if (this.numberOfRecurrence == null) {
      if (payment.getNumberOfRecurrence() != null) {
        return false;
      }
    } else if (this.numberOfRecurrence.compareTo(payment.getNumberOfRecurrence()) > 0) {
      return false;
    }

    if (this.status == null) {
      if (payment.getStatus() != null) {
        return false;
      }
    } else if (this.status.compareTo(payment.getStatus()) > 0) {
      return false;
    }

    if (this.fundingAccount == null) {
      if (payment.getFundingAccount() != null) {
        return false;
      }
    } else if (!this.fundingAccount.equals(payment.getFundingAccount())) {
      return false;
    }

    if (this.amountExpression == null) {
      if (payment.getAmountExpression() != null) {
        return false;
      }
    } else if (!this.amountExpression.equals(payment.getAmountExpression())) {
      return false;
    }

    if (this.dateExpression == null) {
      if (payment.getDateExpression() != null) {
        return false;
      }
    } else if (!this.dateExpression.equals(payment.getDateExpression())) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for amount.
   *
   * @return  String
   */
  public String getAmount() {
    return amount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for amount expression.
   *
   * @return  String
   */
  public String getAmountExpression() {
    return amountExpression;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for date expression.
   *
   * @return  String
   */
  public String getDateExpression() {
    return dateExpression;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for date of payment.
   *
   * @return  String
   */
  public String getDateOfPayment() {
    return dateOfPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for end date.
   *
   * @return  Date
   */
  public Date getEndDate() {
    return endDate;
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
   * getter method for number of recurrence.
   *
   * @return  Integer
   */
  public Integer getNumberOfRecurrence() {
    return numberOfRecurrence;
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
   * getter method for responsible.
   *
   * @return  Responsible
   */
  public Responsible getResponsible() {
    return responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status.
   *
   * @return  String
   */
  public String getStatus() {
    return status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    final int PRIME  = 31;
    int       result = super.hashCode();
    result = (PRIME * result) + ((this.paymentId == null) ? 0 : this.paymentId.hashCode());
    result = (PRIME * result) + ((this.dateOfPayment == null) ? 0 : this.dateOfPayment.hashCode());
    result = (PRIME * result) + ((this.amount == null) ? 0 : this.amount.hashCode());
    result = (PRIME * result) + ((this.endDate == null) ? 0 : this.endDate.hashCode());
    result = (PRIME * result) + ((this.numberOfRecurrence == null) ? 0 : this.numberOfRecurrence.hashCode());
    result = (PRIME * result) + ((this.status == null) ? 0 : this.status.hashCode());
    result = (PRIME * result) + ((this.fundingAccount == null) ? 0 : this.fundingAccount.hashCode());
    result = (PRIME * result) + ((this.amountExpression == null) ? 0 : this.amountExpression.hashCode());
    result = (PRIME * result) + ((this.dateExpression == null) ? 0 : this.dateExpression.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for amount.
   *
   * @param  amount  String
   */
  public void setAmount(String amount) {
    this.amount = amount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for amount expression.
   *
   * @param  amountExpression  String
   */
  public void setAmountExpression(String amountExpression) {
    this.amountExpression = amountExpression;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for date expression.
   *
   * @param  dateExpression  String
   */
  public void setDateExpression(String dateExpression) {
    this.dateExpression = dateExpression;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for date of payment.
   *
   * @param  dateOfPayment  String
   */
  public void setDateOfPayment(String dateOfPayment) {
    this.dateOfPayment = dateOfPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for end date.
   *
   * @param  endDate  Date
   */
  public void setEndDate(Date endDate) {
    this.endDate = endDate;
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
   * setter method for number of recurrence.
   *
   * @param  numberOfRecurrence  Integer
   */
  public void setNumberOfRecurrence(Integer numberOfRecurrence) {
    this.numberOfRecurrence = numberOfRecurrence;
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
   * setter method for responsible.
   *
   * @param  responsible  Responsible
   */
  public void setResponsible(Responsible responsible) {
    this.responsible = responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for status.
   *
   * @param  status  String
   */
  public void setStatus(String status) {
    this.status = status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updateRecurringPayment.
   *
   * @param  payment  RecurringPayment
   */
  public void updateRecurringPayment(RecurringPayment payment) {
    if (payment == null) {
      return;
    }

    this.amount             = payment.getAmount();
    this.dateOfPayment      = payment.getDateOfPayment();
    this.endDate            = payment.getEndDate();
    this.numberOfRecurrence = payment.getNumberOfRecurrence();
    this.status             = payment.getStatus();

    if (payment.getFundingAccount() != null) {
      this.fundingAccount.deepCopy(payment.getFundingAccount());
    }

    this.setLastUpdateDate(new Date());
  }
} // end class RecurringPayment
