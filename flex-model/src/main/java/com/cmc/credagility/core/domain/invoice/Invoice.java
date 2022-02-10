package com.cmc.credagility.core.domain.invoice;

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
import javax.persistence.UniqueConstraint;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * This class is used to store User Invoice information.
 *
 * @author   <a href="mailto:pan.kang@ozstrategy.com">Pan Kang</a>
 * @version  10/14/2014 16:20
 */
@Entity
@Table(
  name              = "Invoice",
  uniqueConstraints = {
    @UniqueConstraint(
      name          = "ttDataId",
      columnNames   = "ttDataId"
    ), @UniqueConstraint(
      name          = "medDataId",
      columnNames   = "medDataId"
    )
  }
)
public class Invoice extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 3687254978622063978L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** FK link to account. */
  @JoinColumn(
    name      = "accountNum",
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Account account;

  /** The number of account on the invoice under same customer, which use for job in flexi group. */
  @Column(name = "accountCount")
  protected Integer accountCount;

  /** original account number and invoice number. */
  @Column(
    name   = "accountInvoiceNo",
    length = 256
  )
  protected String accountInvoiceNo;

  /** amount of invoice. */
  @Column(
    name     = "amount",
    nullable = false
  )
  protected BigDecimal amount;

  /** description for invoice. */
  @Column(
    name   = "description",
    length = 255
  )
  protected String description;

  /** The invoice due date. */
  @Column(name = "dueDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date dueDate;

  /** The payment gst amount. */
  @Column(name = "gstAmount")
  protected BigDecimal gstAmount;

  /** The invoice sent date. */
  @Column(name = "invoiceDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date invoiceDate;

  // npelleti, 07/30, USBank, Removed unique constraint
  /** PK of invoice. */
  @Column(
    name     = "invoiceId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long invoiceId;

  /** invoice number. */
  @Column(
    name     = "invoiceNum",
    nullable = false,
    length   = 22
  )
  protected String invoiceNum;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "medDataId",
    updatable = false,
    unique    = true
  )
  @ManyToOne(
    cascade = CascadeType.ALL,
    fetch   = FetchType.LAZY
  )
  protected InvoiceMedicalData medicalData;

  /** The payment net amount. */
  @Column(name = "netAmount")
  protected BigDecimal netAmount;

  /** The other charges amount. */
  @Column(name = "otherAmount")
  protected BigDecimal otherAmount;

  /** The invoice status. */
  @Column(
    name   = "status",
    length = 10
  )
  protected String status;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "ttDataId",
    updatable = false,
    unique    = true
  )
  @ManyToOne(
    cascade = CascadeType.ALL,
    fetch   = FetchType.LAZY
  )
  protected InvoiceTobaccoTaxData tobaccoTaxData;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (!super.equals(obj)) {
      return false;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    final Invoice other = (Invoice) obj;

    if (amount == null) {
      if (other.amount != null) {
        return false;
      }
    } else if (!amount.equals(other.amount)) {
      return false;
    }

    if (description == null) {
      if (other.description != null) {
        return false;
      }
    } else if (!description.equals(other.description)) {
      return false;
    }

    if (invoiceDate == null) {
      if (other.invoiceDate != null) {
        return false;
      }
    } else if (!invoiceDate.equals(other.invoiceDate)) {
      return false;
    }

    if (invoiceNum == null) {
      if (other.invoiceNum != null) {
        return false;
      }
    } else if (!invoiceNum.equals(other.invoiceNum)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

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
   * getter method for account count.
   *
   * @return  Integer
   */
  public Integer getAccountCount() {
    return accountCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account invoice no.
   *
   * @return  String
   */
  public String getAccountInvoiceNo() {
    return accountInvoiceNo;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getAmount() {
    return this.amount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for description.
   *
   * @return  String
   */
  public String getDescription() {
    return this.description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for due date.
   *
   * @return  Date
   */
  public Date getDueDate() {
    return dueDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for gst amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getGstAmount() {
    return gstAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for invoice date.
   *
   * @return  Date
   */
  public Date getInvoiceDate() {
    return this.invoiceDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for invoice id.
   *
   * @return  Long
   */
  public Long getInvoiceId() {
    return this.invoiceId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for invoice num.
   *
   * @return  String
   */
  public String getInvoiceNum() {
    return this.invoiceNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for medical data.
   *
   * @return  InvoiceMedicalData
   */
  public InvoiceMedicalData getMedicalData() {
    return medicalData;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for net amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getNetAmount() {
    return netAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for other amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getOtherAmount() {
    return otherAmount;
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
   * getter method for tobacco tax data.
   *
   * @return  InvoiceTobaccoTaxData
   */
  public InvoiceTobaccoTaxData getTobaccoTaxData() {
    return tobaccoTaxData;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = super.hashCode();
    result = (prime * result) + ((amount == null) ? 0 : amount.hashCode());
    result = (prime * result)
      + ((description == null) ? 0 : description.hashCode());
    result = (prime * result)
      + ((invoiceDate == null) ? 0 : invoiceDate.hashCode());
    result = (prime * result)
      + ((invoiceNum == null) ? 0 : invoiceNum.hashCode());

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
   * setter method for account count.
   *
   * @param  accountCount  Integer
   */
  public void setAccountCount(Integer accountCount) {
    this.accountCount = accountCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account invoice no.
   *
   * @param  accountInvoiceNo  String
   */
  public void setAccountInvoiceNo(String accountInvoiceNo) {
    this.accountInvoiceNo = accountInvoiceNo;
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
   * setter method for description.
   *
   * @param  description  String
   */
  public void setDescription(String description) {
    this.description = description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for due date.
   *
   * @param  dueDate  Date
   */
  public void setDueDate(Date dueDate) {
    this.dueDate = dueDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for gst amount.
   *
   * @param  gstAmount  BigDecimal
   */
  public void setGstAmount(BigDecimal gstAmount) {
    this.gstAmount = gstAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for invoice date.
   *
   * @param  invoiceDate  Date
   */
  public void setInvoiceDate(Date invoiceDate) {
    this.invoiceDate = invoiceDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for invoice id.
   *
   * @param  invoiceId  Long
   */
  public void setInvoiceId(Long invoiceId) {
    this.invoiceId = invoiceId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for invoice num.
   *
   * @param  invoiceNum  String
   */
  public void setInvoiceNum(String invoiceNum) {
    this.invoiceNum = invoiceNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for medical data.
   *
   * @param  medicalData  InvoiceMedicalData
   */
  public void setMedicalData(InvoiceMedicalData medicalData) {
    this.medicalData = medicalData;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for net amount.
   *
   * @param  netAmount  BigDecimal
   */
  public void setNetAmount(BigDecimal netAmount) {
    this.netAmount = netAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for other amount.
   *
   * @param  otherAmount  BigDecimal
   */
  public void setOtherAmount(BigDecimal otherAmount) {
    this.otherAmount = otherAmount;
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
   * setter method for tobacco tax data.
   *
   * @param  tobaccoTaxData  InvoiceTobaccoTaxData
   */
  public void setTobaccoTaxData(InvoiceTobaccoTaxData tobaccoTaxData) {
    this.tobaccoTaxData = tobaccoTaxData;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#toString()
   */
  @Override public String toString() {
    final String TAB = "    ";

    StringBuilder retValue = new StringBuilder();

    retValue.append("Invoice ( ").append(super.toString()).append(TAB).append(
      "amount = ").append(this.amount).append(TAB).append("description = ").append(this.description).append(TAB).append(
      "invoiceDate = ").append(
      this.invoiceDate).append(TAB).append("invoiceId = ").append(
      this.invoiceId).append(TAB).append("invoiceNum = ").append(
      this.invoiceNum).append(TAB).append(" )");

    return retValue.toString();
  }
} // end class Invoice
