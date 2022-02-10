package com.cmc.credagility.core.domain.payment;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * Created by IntelliJ IDEA. User: adevan Date: Dec 19, 2010 Time: 11:59:23 AM To change this template use File |
 * Settings | File Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(
  name    = "Receipt",

  /*uniqueConstraints = { @UniqueConstraint(columnNames = {}) }*/
  indexes = {
    @Index(
      name = "idx_receiptNumber",
      columnList = "receiptNumber"
    )
  }
)
public class Receipt extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -7751174048396380965L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Account Number which account in used. */
  @JoinColumn(
    name      = "accountNum",
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Account account;

  /** Batch ID <code>Integer.</code> */
  @Column(
    name   = "batchId",
    length = 30
  )
  protected Integer batchId;

  /** Batch Type. */
  @Column(
    name   = "batchType",
    length = 255
  )
  protected String batchType;

  /** Dishonour reason. */
  @Column(
    name   = "dishonourReason",
    length = 255
  )
  protected String dishonourReason;

  /** Dishonour type. */
  @Column(
    name   = "dishonourType",
    length = 1
  )
  protected String dishonourType;

  /** Drawer bsb. */
  @Column(
    name   = "drawerBsb",
    length = 255
  )
  protected String drawerBsb;

  /** Drawer cheque number. */
  @Column(
    name   = "drawerChequeNumber",
    length = 255
  )
  protected String drawerChequeNumber;

  /** Drawer name. */
  @Column(
    name   = "drawerName",
    length = 255
  )
  protected String drawerName;

  /** Payment PK paymentId. */
  @JoinColumn(
    name      = "paymentId",
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Payment payment;

  /** Payment gross amount. */
  @Column(
    name   = "paymentGrossAmount",
    length = 20
  )
  protected BigDecimal paymentGrossAmount;

  /** Payment type. */
  @Column(
    name   = "paymentType",
    length = 50
  )
  protected String paymentType;

  /** Post Date <code>Date.</code> */
  @Column(name = "postedDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date postedDate;

  /** receipt Date <code>Date.</code> */
  @Column(name = "receiptDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date receiptDate;


  /** ReceiptId. */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long receiptId;

  /** Receipt Number <code>Integer.</code> */
  @Column(
    name     = "receiptNumber",
    length   = 30,
    nullable = false
  )
  protected Integer receiptNumber;

  /** Receipt type. */
  @Column(
    name   = "receiptType",
    length = 255
  )
  protected String receiptType;

  /** reference. */
  @Column(
    name   = "reference",
    length = 60
  )
  protected String reference;

  /** Reject Type <code>Char.</code> */
  @Column(
    name   = "rejectType",
    length = 1
  )
  protected String rejectType;

  /** Status. */
  @Column(
    name   = "status",
    length = 50
  )
  protected String status;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof Receipt)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    Receipt receipt = (Receipt) o;

    if ((account != null) ? (!account.equals(receipt.account)) : (receipt.account != null)) {
      return false;
    }

    if ((batchId != null) ? (!batchId.equals(receipt.batchId)) : (receipt.batchId != null)) {
      return false;
    }

    if ((batchType != null) ? (!batchType.equals(receipt.batchType)) : (receipt.batchType != null)) {
      return false;
    }

    if ((dishonourReason != null) ? (!dishonourReason.equals(receipt.dishonourReason))
                                  : (receipt.dishonourReason != null)) {
      return false;
    }

    if ((dishonourType != null) ? (!dishonourType.equals(receipt.dishonourType)) : (receipt.dishonourType != null)) {
      return false;
    }

    if ((drawerBsb != null) ? (!drawerBsb.equals(receipt.drawerBsb)) : (receipt.drawerBsb != null)) {
      return false;
    }

    if ((drawerChequeNumber != null) ? (!drawerChequeNumber.equals(receipt.drawerChequeNumber))
                                     : (receipt.drawerChequeNumber != null)) {
      return false;
    }

    if ((drawerName != null) ? (!drawerName.equals(receipt.drawerName)) : (receipt.drawerName != null)) {
      return false;
    }

    if ((payment != null) ? (!payment.equals(receipt.payment)) : (receipt.payment != null)) {
      return false;
    }

    if ((paymentGrossAmount != null) ? (!paymentGrossAmount.equals(receipt.paymentGrossAmount))
                                     : (receipt.paymentGrossAmount != null)) {
      return false;
    }

    if ((paymentType != null) ? (!paymentType.equals(receipt.paymentType)) : (receipt.paymentType != null)) {
      return false;
    }

    if ((postedDate != null) ? (!postedDate.equals(receipt.postedDate)) : (receipt.postedDate != null)) {
      return false;
    }

    if ((receiptDate != null) ? (!receiptDate.equals(receipt.receiptDate)) : (receipt.receiptDate != null)) {
      return false;
    }

    if ((receiptId != null) ? (!receiptId.equals(receipt.receiptId)) : (receipt.receiptId != null)) {
      return false;
    }

    if ((receiptNumber != null) ? (!receiptNumber.equals(receipt.receiptNumber)) : (receipt.receiptNumber != null)) {
      return false;
    }

    if ((receiptType != null) ? (!receiptType.equals(receipt.receiptType)) : (receipt.receiptType != null)) {
      return false;
    }

    if ((reference != null) ? (!reference.equals(receipt.reference)) : (receipt.reference != null)) {
      return false;
    }

    if ((rejectType != null) ? (!rejectType.equals(receipt.rejectType)) : (receipt.rejectType != null)) {
      return false;
    }

    if ((status != null) ? (!status.equals(receipt.status)) : (receipt.status != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Account getAccount() {
    return account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getBatchId() {
    return batchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getBatchType() {
    return batchType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDishonourReason() {
    return dishonourReason;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDishonourType() {
    return dishonourType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDrawerBsb() {
    return drawerBsb;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDrawerChequeNumber() {
    return drawerChequeNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDrawerName() {
    return drawerName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Payment getPayment() {
    return payment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getPaymentGrossAmount() {
    return paymentGrossAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPaymentType() {
    return paymentType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getPostedDate() {
    return postedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getReceiptDate() {
    return receiptDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getReceiptId() {
    return receiptId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getReceiptNumber() {
    return receiptNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getReceiptType() {
    return receiptType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getReference() {
    return reference;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getRejectType() {
    return rejectType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getStatus() {
    return status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((account != null) ? account.hashCode() : 0);
    result = (31 * result) + ((batchId != null) ? batchId.hashCode() : 0);
    result = (31 * result) + ((batchType != null) ? batchType.hashCode() : 0);
    result = (31 * result) + ((dishonourReason != null) ? dishonourReason.hashCode() : 0);
    result = (31 * result) + ((dishonourType != null) ? dishonourType.hashCode() : 0);
    result = (31 * result) + ((drawerBsb != null) ? drawerBsb.hashCode() : 0);
    result = (31 * result) + ((drawerChequeNumber != null) ? drawerChequeNumber.hashCode() : 0);
    result = (31 * result) + ((drawerName != null) ? drawerName.hashCode() : 0);
    result = (31 * result) + ((payment != null) ? payment.hashCode() : 0);
    result = (31 * result) + ((paymentGrossAmount != null) ? paymentGrossAmount.hashCode() : 0);
    result = (31 * result) + ((paymentType != null) ? paymentType.hashCode() : 0);
    result = (31 * result) + ((postedDate != null) ? postedDate.hashCode() : 0);
    result = (31 * result) + ((receiptDate != null) ? receiptDate.hashCode() : 0);
    result = (31 * result) + ((receiptId != null) ? receiptId.hashCode() : 0);
    result = (31 * result) + ((receiptNumber != null) ? receiptNumber.hashCode() : 0);
    result = (31 * result) + ((receiptType != null) ? receiptType.hashCode() : 0);
    result = (31 * result) + ((reference != null) ? reference.hashCode() : 0);
    result = (31 * result) + ((rejectType != null) ? rejectType.hashCode() : 0);
    result = (31 * result) + ((status != null) ? status.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  account  DOCUMENT ME!
   */
  public void setAccount(Account account) {
    this.account = account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  batchId  DOCUMENT ME!
   */
  public void setBatchId(Integer batchId) {
    this.batchId = batchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  batchType  DOCUMENT ME!
   */
  public void setBatchType(String batchType) {
    this.batchType = batchType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  dishonourReason  DOCUMENT ME!
   */
  public void setDishonourReason(String dishonourReason) {
    this.dishonourReason = dishonourReason;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  dishonourType  DOCUMENT ME!
   */
  public void setDishonourType(String dishonourType) {
    this.dishonourType = dishonourType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  drawerBsb  DOCUMENT ME!
   */
  public void setDrawerBsb(String drawerBsb) {
    this.drawerBsb = drawerBsb;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  drawerChequeNumber  DOCUMENT ME!
   */
  public void setDrawerChequeNumber(String drawerChequeNumber) {
    this.drawerChequeNumber = drawerChequeNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  drawerName  DOCUMENT ME!
   */
  public void setDrawerName(String drawerName) {
    this.drawerName = drawerName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  payment  DOCUMENT ME!
   */
  public void setPayment(Payment payment) {
    this.payment = payment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentGrossAmount  DOCUMENT ME!
   */
  public void setPaymentGrossAmount(BigDecimal paymentGrossAmount) {
    this.paymentGrossAmount = paymentGrossAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentType  DOCUMENT ME!
   */
  public void setPaymentType(String paymentType) {
    this.paymentType = paymentType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  postedDate  DOCUMENT ME!
   */
  public void setPostedDate(Date postedDate) {
    this.postedDate = postedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  receiptDate  DOCUMENT ME!
   */
  public void setReceiptDate(Date receiptDate) {
    this.receiptDate = receiptDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  receiptId  DOCUMENT ME!
   */
  public void setReceiptId(Long receiptId) {
    this.receiptId = receiptId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  receiptNumber  DOCUMENT ME!
   */
  public void setReceiptNumber(Integer receiptNumber) {
    this.receiptNumber = receiptNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  receiptType  DOCUMENT ME!
   */
  public void setReceiptType(String receiptType) {
    this.receiptType = receiptType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  reference  DOCUMENT ME!
   */
  public void setReference(String reference) {
    this.reference = reference;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  rejectType  DOCUMENT ME!
   */
  public void setRejectType(String rejectType) {
    this.rejectType = rejectType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  status  DOCUMENT ME!
   */
  public void setStatus(String status) {
    this.status = status;
  }


} // end class Receipt
