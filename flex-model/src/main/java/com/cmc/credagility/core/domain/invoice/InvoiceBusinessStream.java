package com.cmc.credagility.core.domain.invoice;

import java.io.Serializable;

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

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * Data example:
 *
 * <pre>
 Invoice Date:                    Jan-12-2012
 Invoice ID:                      1-430-DFG
 Payment Due Date:                Feb-9-2012
 Fixed Charge for Water:          £0.00
 Volume Charge for Water:         £116.00
 Fixed Charge for Waste Water:    £90.00
 Volume Charge for Waste Water:   £0.00
 Property Drainage Charge:        £10.00
 Road Drainage Charge:            £10.00
 Total Charges this Invoice:      £0.00
 Credits this Invoice:            £0.00
 Current Due Amount:              £216.00
 Past Due Amount:                 £413.00
 Total Due Amount:                £629.00
 * </pre>
 *
 * @author   <a href="mailto:pan.kang@ozstrategy.com">Pan Kang</a>
 * @version  10/14/2014 16:42
 */
@Entity
@Table(name = "InvoiceBusinessStream")
public class InvoiceBusinessStream extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -7619851895339630534L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "accountNum",
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Account account;

  /** Credits this Invoice. */
  @Column(
    name     = "creditsCharge",
    nullable = true
  )
  protected BigDecimal creditsCharge;

  /** Current Due Amount. */
  @Column(
    name     = "currentDueAmount",
    nullable = false
  )
  protected BigDecimal currentDueAmount;

  /** invoice description. */
  @Column(
    name   = "description",
    length = 255
  )
  protected String description;

  /** Fixed Charge for Water. */
  @Column(
    name     = "fixedCharge",
    nullable = true
  )
  protected BigDecimal fixedCharge;

  /** invoice date. */
  @Column(
    name     = "invoiceDate",
    nullable = false
  )
  @Temporal(TemporalType.TIMESTAMP)
  protected Date invoiceDate;

  /** invoice id PK. */
  @Column(
    name     = "invoiceId",
    unique   = true,
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

  /** Past Due Amount. */
  @Column(
    name     = "pastDueAmount",
    nullable = false
  )
  protected BigDecimal pastDueAmount;

  /** Payment Due Date. */
  @Column(name = "paymentDueDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date paymentDueDate;

  /** Property Drainage Charge. */
  @Column(
    name     = "propertyDrainageCharge",
    nullable = true
  )
  protected BigDecimal propertyDrainageCharge;

  /** Road Drainage Charge. */
  @Column(
    name     = "roadDrainageCharge",
    nullable = true
  )
  protected BigDecimal roadDrainageCharge;

  /** Total Charges this Invoice. */
  @Column(
    name     = "totalCharge",
    nullable = true
  )
  protected BigDecimal totalCharge;

  /** Total Due Amount. */
  @Column(
    name     = "totalDueAmount",
    nullable = false
  )
  protected BigDecimal totalDueAmount;

  /** Volume Charge for Water. */
  @Column(
    name     = "volumeCharge",
    nullable = true
  )
  protected BigDecimal volumeCharge;

  /** Fixed Charge for Waste Water. */
  @Column(
    name     = "wasteFixedCharge",
    nullable = true
  )
  protected BigDecimal wasteFixedCharge;

  /** Volume Charge for Waste Water. */
  @Column(
    name     = "wasteVolumeCharge",
    nullable = true
  )
  protected BigDecimal wasteVolumeCharge;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
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

    InvoiceBusinessStream that = (InvoiceBusinessStream) o;

    if ((account != null) ? (!account.equals(that.account)) : (that.account != null)) {
      return false;
    }

    if ((creditsCharge != null) ? (!creditsCharge.equals(that.creditsCharge)) : (that.creditsCharge != null)) {
      return false;
    }

    if (!currentDueAmount.equals(that.currentDueAmount)) {
      return false;
    }

    if ((description != null) ? (!description.equals(that.description)) : (that.description != null)) {
      return false;
    }

    if ((fixedCharge != null) ? (!fixedCharge.equals(that.fixedCharge)) : (that.fixedCharge != null)) {
      return false;
    }

    if (!invoiceDate.equals(that.invoiceDate)) {
      return false;
    }

    if (!invoiceId.equals(that.invoiceId)) {
      return false;
    }

    if (!invoiceNum.equals(that.invoiceNum)) {
      return false;
    }

    if (!pastDueAmount.equals(that.pastDueAmount)) {
      return false;
    }

    if ((paymentDueDate != null) ? (!paymentDueDate.equals(that.paymentDueDate)) : (that.paymentDueDate != null)) {
      return false;
    }

    if ((propertyDrainageCharge != null) ? (!propertyDrainageCharge.equals(that.propertyDrainageCharge))
                                         : (that.propertyDrainageCharge != null)) {
      return false;
    }

    if ((roadDrainageCharge != null) ? (!roadDrainageCharge.equals(that.roadDrainageCharge))
                                     : (that.roadDrainageCharge != null)) {
      return false;
    }

    if ((totalCharge != null) ? (!totalCharge.equals(that.totalCharge)) : (that.totalCharge != null)) {
      return false;
    }

    if (!totalDueAmount.equals(that.totalDueAmount)) {
      return false;
    }

    if ((volumeCharge != null) ? (!volumeCharge.equals(that.volumeCharge)) : (that.volumeCharge != null)) {
      return false;
    }

    if ((wasteFixedCharge != null) ? (!wasteFixedCharge.equals(that.wasteFixedCharge))
                                   : (that.wasteFixedCharge != null)) {
      return false;
    }

    if ((wasteVolumeCharge != null) ? (!wasteVolumeCharge.equals(that.wasteVolumeCharge))
                                    : (that.wasteVolumeCharge != null)) {
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
    return account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for credits charge.
   *
   * @return  BigDecimal
   */
  public BigDecimal getCreditsCharge() {
    return creditsCharge;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for current due amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getCurrentDueAmount() {
    return currentDueAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for description.
   *
   * @return  String
   */
  public String getDescription() {
    return description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for fixed charge.
   *
   * @return  BigDecimal
   */
  public BigDecimal getFixedCharge() {
    return fixedCharge;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for invoice date.
   *
   * @return  Date
   */
  public Date getInvoiceDate() {
    return invoiceDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for invoice id.
   *
   * @return  Long
   */
  public Long getInvoiceId() {
    return invoiceId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for invoice num.
   *
   * @return  String
   */
  public String getInvoiceNum() {
    return invoiceNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for past due amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPastDueAmount() {
    return pastDueAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment due date.
   *
   * @return  Date
   */
  public Date getPaymentDueDate() {
    return paymentDueDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for property drainage charge.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPropertyDrainageCharge() {
    return propertyDrainageCharge;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for road drainage charge.
   *
   * @return  BigDecimal
   */
  public BigDecimal getRoadDrainageCharge() {
    return roadDrainageCharge;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for total charge.
   *
   * @return  BigDecimal
   */
  public BigDecimal getTotalCharge() {
    return totalCharge;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for total due amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getTotalDueAmount() {
    return totalDueAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for volume charge.
   *
   * @return  BigDecimal
   */
  public BigDecimal getVolumeCharge() {
    return volumeCharge;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for waste fixed charge.
   *
   * @return  BigDecimal
   */
  public BigDecimal getWasteFixedCharge() {
    return wasteFixedCharge;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for waste volume charge.
   *
   * @return  BigDecimal
   */
  public BigDecimal getWasteVolumeCharge() {
    return wasteVolumeCharge;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((account != null) ? account.hashCode() : 0);
    result = (31 * result) + ((description != null) ? description.hashCode() : 0);
    result = (31 * result) + invoiceDate.hashCode();
    result = (31 * result) + invoiceId.hashCode();
    result = (31 * result) + invoiceNum.hashCode();
    result = (31 * result) + ((paymentDueDate != null) ? paymentDueDate.hashCode() : 0);
    result = (31 * result) + ((fixedCharge != null) ? fixedCharge.hashCode() : 0);
    result = (31 * result) + ((volumeCharge != null) ? volumeCharge.hashCode() : 0);
    result = (31 * result) + ((wasteFixedCharge != null) ? wasteFixedCharge.hashCode() : 0);
    result = (31 * result) + ((wasteVolumeCharge != null) ? wasteVolumeCharge.hashCode() : 0);
    result = (31 * result) + ((propertyDrainageCharge != null) ? propertyDrainageCharge.hashCode() : 0);
    result = (31 * result) + ((roadDrainageCharge != null) ? roadDrainageCharge.hashCode() : 0);
    result = (31 * result) + ((totalCharge != null) ? totalCharge.hashCode() : 0);
    result = (31 * result) + ((creditsCharge != null) ? creditsCharge.hashCode() : 0);
    result = (31 * result) + currentDueAmount.hashCode();
    result = (31 * result) + pastDueAmount.hashCode();
    result = (31 * result) + totalDueAmount.hashCode();

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
   * setter method for credits charge.
   *
   * @param  creditsCharge  BigDecimal
   */
  public void setCreditsCharge(BigDecimal creditsCharge) {
    this.creditsCharge = creditsCharge;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for current due amount.
   *
   * @param  currentDueAmount  BigDecimal
   */
  public void setCurrentDueAmount(BigDecimal currentDueAmount) {
    this.currentDueAmount = currentDueAmount;
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
   * setter method for fixed charge.
   *
   * @param  fixedCharge  BigDecimal
   */
  public void setFixedCharge(BigDecimal fixedCharge) {
    this.fixedCharge = fixedCharge;
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
   * setter method for past due amount.
   *
   * @param  pastDueAmount  BigDecimal
   */
  public void setPastDueAmount(BigDecimal pastDueAmount) {
    this.pastDueAmount = pastDueAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for payment due date.
   *
   * @param  paymentDueDate  Date
   */
  public void setPaymentDueDate(Date paymentDueDate) {
    this.paymentDueDate = paymentDueDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for property drainage charge.
   *
   * @param  propertyDrainageCharge  BigDecimal
   */
  public void setPropertyDrainageCharge(BigDecimal propertyDrainageCharge) {
    this.propertyDrainageCharge = propertyDrainageCharge;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for road drainage charge.
   *
   * @param  roadDrainageCharge  BigDecimal
   */
  public void setRoadDrainageCharge(BigDecimal roadDrainageCharge) {
    this.roadDrainageCharge = roadDrainageCharge;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for total charge.
   *
   * @param  totalCharge  BigDecimal
   */
  public void setTotalCharge(BigDecimal totalCharge) {
    this.totalCharge = totalCharge;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for total due amount.
   *
   * @param  totalDueAmount  BigDecimal
   */
  public void setTotalDueAmount(BigDecimal totalDueAmount) {
    this.totalDueAmount = totalDueAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for volume charge.
   *
   * @param  volumeCharge  BigDecimal
   */
  public void setVolumeCharge(BigDecimal volumeCharge) {
    this.volumeCharge = volumeCharge;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for waste fixed charge.
   *
   * @param  wasteFixedCharge  BigDecimal
   */
  public void setWasteFixedCharge(BigDecimal wasteFixedCharge) {
    this.wasteFixedCharge = wasteFixedCharge;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for waste volume charge.
   *
   * @param  wasteVolumeCharge  BigDecimal
   */
  public void setWasteVolumeCharge(BigDecimal wasteVolumeCharge) {
    this.wasteVolumeCharge = wasteVolumeCharge;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#toString()
   */
  @Override public String toString() {
    final StringBuffer sb = new StringBuffer();
    sb.append("InvoiceBusinessStream");
    sb.append("{account=").append(account);
    sb.append(", description='").append(description).append('\'');
    sb.append(", invoiceDate=").append(invoiceDate);
    sb.append(", invoiceId=").append(invoiceId);
    sb.append(", invoiceNum='").append(invoiceNum).append('\'');
    sb.append(", paymentDueDate=").append(paymentDueDate);
    sb.append(", fixedCharge=").append(fixedCharge);
    sb.append(", volumeCharge=").append(volumeCharge);
    sb.append(", wasteFixedCharge=").append(wasteFixedCharge);
    sb.append(", wasteVolumeCharge=").append(wasteVolumeCharge);
    sb.append(", propertyDrainageCharge=").append(propertyDrainageCharge);
    sb.append(", roadDrainageCharge=").append(roadDrainageCharge);
    sb.append(", totalCharge=").append(totalCharge);
    sb.append(", creditsCharge=").append(creditsCharge);
    sb.append(", currentDueAmount=").append(currentDueAmount);
    sb.append(", pastDueAmount=").append(pastDueAmount);
    sb.append(", totalDueAmount=").append(totalDueAmount);
    sb.append('}');

    return sb.toString();
  }
} // end class InvoiceBusinessStream
