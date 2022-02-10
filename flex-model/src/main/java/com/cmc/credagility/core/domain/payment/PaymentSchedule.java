package com.cmc.credagility.core.domain.payment;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * Created by IntelliJ IDEA. User: adevan Date: Dec 19, 2010 Time: 11:59:23 AM To change this template use File |
 * Settings | File Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(
  name    = "PaymentSchedule",
  indexes = {
    @Index(
      name = "scheduleBatchIdIndex",
      columnList = "scheduleBatchId"
    )
  }

  /*uniqueConstraints = { @UniqueConstraint(columnNames = {}) }*/
)
public class PaymentSchedule extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -7751174048396380965L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Account Number which account number in used. */
  @JoinColumn(
    name      = "accountNum",
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Account account;

  /** <code>true</code> is this payment schedule was deleted. */
  @Column(
    name             = "deleted",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean deleted = Boolean.FALSE;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "gstAmount",
    precision = 20,
    scale     = 4
  )
  protected BigDecimal gstAmount;

  /** Payment date <code>Date.</code> */
  @Column(name = "paymentDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date paymentDate;

  /** Payment gross amount <code>BigDecimal.</code> */
  @Column(
    name      = "paymentGrossAmount",
    precision = 20,
    scale     = 4
  )
  protected BigDecimal paymentGrossAmount;

  /** Payment net amount <code>BigDecimal.</code> */
  @Column(
    name      = "paymentNetAmount",
    precision = 20,
    scale     = 4
  )
  protected BigDecimal paymentNetAmount;

  /** Payment number <code>Integer.</code> */
  @Column(
    name   = "paymentNumber",
    length = 30
  )
  protected Integer paymentNumber;

  /** Payment other net amount <code>BigDecimal.</code> */
  @Column(
    name      = "paymentOtherNetAmount",
    precision = 20,
    scale     = 4
  )
  protected BigDecimal paymentOtherNetAmount;

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long paymentScheduleId;

  /** Payment type. */
  @Column(
    name   = "paymentType",
    length = 10
  )
  protected String paymentType;

  /** DOCUMENT ME! */
  @Column(name = "scheduleUpdateDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date scheduleUpdateDate;

  @Column(
    name   = "scheduleBatchId",
    length = 30
  )
  private String scheduleBatchId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   o  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean businessEquals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof PaymentSchedule)) {
      return false;
    }

    PaymentSchedule that = (PaymentSchedule) o;

    if ((gstAmount != null) ? (!(gstAmount.compareTo(that.gstAmount) == 0)) : (that.gstAmount != null)) {
      return false;
    }

    if ((paymentDate != null) ? (!paymentDate.equals(that.paymentDate)) : (that.paymentDate != null)) {
      return false;
    }

    if ((paymentGrossAmount != null) ? (!(paymentGrossAmount.compareTo(that.paymentGrossAmount) == 0))
                                     : (that.paymentGrossAmount != null)) {
      return false;
    }

    if ((paymentNetAmount != null) ? (!(paymentNetAmount.compareTo(that.paymentNetAmount) == 0))
                                   : (that.paymentNetAmount != null)) {
      return false;
    }

    if ((paymentOtherNetAmount != null) ? (!(paymentOtherNetAmount.compareTo(that.paymentOtherNetAmount) == 0))
                                        : (that.paymentOtherNetAmount != null)) {
      return false;
    }

    if ((paymentType != null) ? (!paymentType.equals(that.paymentType)) : (that.paymentType != null)) {
      return false;
    }

    if ((scheduleUpdateDate != null) ? (!scheduleUpdateDate.equals(that.scheduleUpdateDate))
                                     : (that.scheduleUpdateDate != null)) {
      return false;
    }

    return true;
  } // end method businessEquals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof PaymentSchedule)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    PaymentSchedule that = (PaymentSchedule) o;

    if ((account != null) ? (!account.equals(that.account)) : (that.account != null)) {
      return false;
    }

    if ((gstAmount != null) ? (!gstAmount.equals(that.gstAmount)) : (that.gstAmount != null)) {
      return false;
    }

    if ((paymentDate != null) ? (!paymentDate.equals(that.paymentDate)) : (that.paymentDate != null)) {
      return false;
    }

    if ((paymentGrossAmount != null) ? (!paymentGrossAmount.equals(that.paymentGrossAmount))
                                     : (that.paymentGrossAmount != null)) {
      return false;
    }

    if ((paymentNetAmount != null) ? (!paymentNetAmount.equals(that.paymentNetAmount))
                                   : (that.paymentNetAmount != null)) {
      return false;
    }

    if ((paymentNumber != null) ? (!paymentNumber.equals(that.paymentNumber)) : (that.paymentNumber != null)) {
      return false;
    }

    if ((paymentOtherNetAmount != null) ? (!paymentOtherNetAmount.equals(that.paymentOtherNetAmount))
                                        : (that.paymentOtherNetAmount != null)) {
      return false;
    }

    if ((paymentScheduleId != null) ? (!paymentScheduleId.equals(that.paymentScheduleId))
                                    : (that.paymentScheduleId != null)) {
      return false;
    }

    if ((paymentType != null) ? (!paymentType.equals(that.paymentType)) : (that.paymentType != null)) {
      return false;
    }

    if ((scheduleUpdateDate != null) ? (!scheduleUpdateDate.equals(that.scheduleUpdateDate))
                                     : (that.scheduleUpdateDate != null)) {
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
  public Boolean getDeleted() {
    return deleted;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getGstAmount() {
    return gstAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getPaymentDate() {
    return paymentDate;
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
  public BigDecimal getPaymentNetAmount() {
    return paymentNetAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getPaymentNumber() {
    return paymentNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getPaymentOtherNetAmount() {
    return paymentOtherNetAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getPaymentScheduleId() {
    return paymentScheduleId;
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
   * getter method for schedule batch id.
   *
   * @return  String
   */
  public String getScheduleBatchId() {
    return scheduleBatchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getScheduleUpdateDate() {
    return scheduleUpdateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((account != null) ? account.hashCode() : 0);
    result = (31 * result) + ((gstAmount != null) ? gstAmount.hashCode() : 0);
    result = (31 * result) + ((paymentDate != null) ? paymentDate.hashCode() : 0);
    result = (31 * result) + ((paymentGrossAmount != null) ? paymentGrossAmount.hashCode() : 0);
    result = (31 * result) + ((paymentNetAmount != null) ? paymentNetAmount.hashCode() : 0);
    result = (31 * result) + ((paymentNumber != null) ? paymentNumber.hashCode() : 0);
    result = (31 * result) + ((paymentOtherNetAmount != null) ? paymentOtherNetAmount.hashCode() : 0);
    result = (31 * result) + ((paymentScheduleId != null) ? paymentScheduleId.hashCode() : 0);
    result = (31 * result) + ((paymentType != null) ? paymentType.hashCode() : 0);
    result = (31 * result) + ((scheduleUpdateDate != null) ? scheduleUpdateDate.hashCode() : 0);

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
   * @param  deleted  DOCUMENT ME!
   */
  public void setDeleted(Boolean deleted) {
    this.deleted = deleted;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  gstAmount  DOCUMENT ME!
   */
  public void setGstAmount(BigDecimal gstAmount) {
    this.gstAmount = gstAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentDate  DOCUMENT ME!
   */
  public void setPaymentDate(Date paymentDate) {
    this.paymentDate = paymentDate;
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
   * @param  paymentNetAmount  DOCUMENT ME!
   */
  public void setPaymentNetAmount(BigDecimal paymentNetAmount) {
    this.paymentNetAmount = paymentNetAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentNumber  DOCUMENT ME!
   */
  public void setPaymentNumber(Integer paymentNumber) {
    this.paymentNumber = paymentNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentOtherNetAmount  DOCUMENT ME!
   */
  public void setPaymentOtherNetAmount(BigDecimal paymentOtherNetAmount) {
    this.paymentOtherNetAmount = paymentOtherNetAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentScheduleId  DOCUMENT ME!
   */
  public void setPaymentScheduleId(Long paymentScheduleId) {
    this.paymentScheduleId = paymentScheduleId;
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
   * setter method for schedule batch id.
   *
   * @param  scheduleBatchId  String
   */
  public void setScheduleBatchId(String scheduleBatchId) {
    this.scheduleBatchId = scheduleBatchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  scheduleUpdateDate  DOCUMENT ME!
   */
  public void setScheduleUpdateDate(Date scheduleUpdateDate) {
    this.scheduleUpdateDate = scheduleUpdateDate;
  }
} // end class PaymentSchedule
