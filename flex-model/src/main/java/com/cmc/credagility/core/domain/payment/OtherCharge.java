package com.cmc.credagility.core.domain.payment;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:pan.kang@ozstrategy.com">Pan Kang</a>
 * @version  11/24/2015 10:28
 */
@Entity
@Table(name = "OtherCharge")
public class OtherCharge extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -6831174048396380912L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "action",
    nullable = false,
    length   = 1
  )
  protected String action;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "batchId",
    length = 30
  )
  protected Long batchId;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "deleted",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean deleted = Boolean.FALSE;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "description",
    length = 60
  )
  protected String description;

  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "grossAmount",
    nullable  = false,
    precision = 20,
    scale     = 4
  )
  protected BigDecimal grossAmount;

  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "gstAmount",
    nullable  = false,
    precision = 20,
    scale     = 4
  )
  protected BigDecimal gstAmount;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "netAmount",
    nullable  = false,
    precision = 20,
    scale     = 4
  )
  protected BigDecimal netAmount;


  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long otherChangeId;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "paymentDate",
    nullable = false
  )
  @Temporal(TemporalType.TIMESTAMP)
  protected Date paymentDate;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "paymentScheduleId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @OneToOne protected PaymentSchedule paymentSchedule;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "paymentType",
    length = 10
  )
  protected String paymentType;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "spare1",
    length = 300
  )
  protected String spare1;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "spare10",
    length = 30
  )
  protected Integer spare10;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "spare2",
    length = 300
  )
  protected String spare2;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "spare3",
    length = 300
  )
  protected String spare3;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "spare4",
    length = 300
  )
  protected String spare4;

  /** TODO: DOCUMENT ME! */
  @Column(name = "spare5")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date spare5;

  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "spare6",
    precision = 20,
    scale     = 4
  )
  protected BigDecimal spare6;

  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "spare7",
    precision = 20,
    scale     = 4
  )
  protected BigDecimal spare7;

  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "spare8",
    precision = 20,
    scale     = 4
  )
  protected BigDecimal spare8;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "spare9",
    length = 30
  )
  protected Integer spare9;

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

    OtherCharge that = (OtherCharge) o;

    if (!paymentSchedule.equals(that.paymentSchedule)) {
      return false;
    }

    if (!deleted.equals(that.deleted)) {
      return false;
    }

    if (!action.equals(that.action)) {
      return false;
    }

    if ((batchId != null) ? (!batchId.equals(that.batchId)) : (that.batchId != null)) {
      return false;
    }

    if ((description != null) ? (!description.equals(that.description)) : (that.description != null)) {
      return false;
    }

    if (!grossAmount.equals(that.grossAmount)) {
      return false;
    }

    if (!gstAmount.equals(that.gstAmount)) {
      return false;
    }

    if (!netAmount.equals(that.netAmount)) {
      return false;
    }

    if (!otherChangeId.equals(that.otherChangeId)) {
      return false;
    }

    if (!paymentDate.equals(that.paymentDate)) {
      return false;
    }

    if (!paymentType.equals(that.paymentType)) {
      return false;
    }

    if ((spare10 != null) ? (!spare10.equals(that.spare10)) : (that.spare10 != null)) {
      return false;
    }

    if ((spare5 != null) ? (!spare5.equals(that.spare5)) : (that.spare5 != null)) {
      return false;
    }

    if ((spare6 != null) ? (!spare6.equals(that.spare6)) : (that.spare6 != null)) {
      return false;
    }

    if ((spare7 != null) ? (!spare7.equals(that.spare7)) : (that.spare7 != null)) {
      return false;
    }

    if ((spare8 != null) ? (!spare8.equals(that.spare8)) : (that.spare8 != null)) {
      return false;
    }

    if ((spare9 != null) ? (!spare9.equals(that.spare9)) : (that.spare9 != null)) {
      return false;
    }

    if ((spare1 != null) ? (!spare1.equals(that.spare1)) : (that.spare1 != null)) {
      return false;
    }

    if ((spare2 != null) ? (!spare2.equals(that.spare2)) : (that.spare2 != null)) {
      return false;
    }

    if ((spare3 != null) ? (!spare3.equals(that.spare3)) : (that.spare3 != null)) {
      return false;
    }

    return !((spare4 != null) ? (!spare4.equals(that.spare4)) : (that.spare4 != null));

  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for action.
   *
   * @return  String
   */
  public String getAction() {
    return action;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for batch id.
   *
   * @return  Long
   */
  public Long getBatchId() {
    return batchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for deleted.
   *
   * @return  Boolean
   */
  public Boolean getDeleted() {
    return deleted;
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
   * getter method for gross amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getGrossAmount() {
    return grossAmount;
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
   * getter method for net amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getNetAmount() {
    return netAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for other change id.
   *
   * @return  Long
   */
  public Long getOtherChangeId() {
    return otherChangeId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment date.
   *
   * @return  Date
   */
  public Date getPaymentDate() {
    return paymentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment schedule.
   *
   * @return  PaymentSchedule
   */
  public PaymentSchedule getPaymentSchedule() {
    return paymentSchedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment type.
   *
   * @return  String
   */
  public String getPaymentType() {
    return paymentType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for spare1.
   *
   * @return  String
   */
  public String getSpare1() {
    return spare1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for spare10.
   *
   * @return  Integer
   */
  public Integer getSpare10() {
    return spare10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for spare2.
   *
   * @return  String
   */
  public String getSpare2() {
    return spare2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for spare3.
   *
   * @return  String
   */
  public String getSpare3() {
    return spare3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for spare4.
   *
   * @return  String
   */
  public String getSpare4() {
    return spare4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for spare5.
   *
   * @return  Date
   */
  public Date getSpare5() {
    return spare5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for spare6.
   *
   * @return  BigDecimal
   */
  public BigDecimal getSpare6() {
    return spare6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for spare7.
   *
   * @return  BigDecimal
   */
  public BigDecimal getSpare7() {
    return spare7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for spare8.
   *
   * @return  BigDecimal
   */
  public BigDecimal getSpare8() {
    return spare8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for spare9.
   *
   * @return  Integer
   */
  public Integer getSpare9() {
    return spare9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------


  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + paymentSchedule.hashCode();
    result = (31 * result) + deleted.hashCode();
    result = (31 * result) + action.hashCode();
    result = (31 * result) + ((batchId != null) ? batchId.hashCode() : 0);
    result = (31 * result) + ((description != null) ? description.hashCode() : 0);
    result = (31 * result) + grossAmount.hashCode();
    result = (31 * result) + gstAmount.hashCode();
    result = (31 * result) + netAmount.hashCode();
    result = (31 * result) + otherChangeId.hashCode();
    result = (31 * result) + paymentDate.hashCode();
    result = (31 * result) + paymentType.hashCode();
    result = (31 * result) + ((spare10 != null) ? spare10.hashCode() : 0);
    result = (31 * result) + ((spare5 != null) ? spare5.hashCode() : 0);
    result = (31 * result) + ((spare6 != null) ? spare6.hashCode() : 0);
    result = (31 * result) + ((spare7 != null) ? spare7.hashCode() : 0);
    result = (31 * result) + ((spare8 != null) ? spare8.hashCode() : 0);
    result = (31 * result) + ((spare9 != null) ? spare9.hashCode() : 0);
    result = (31 * result) + ((spare1 != null) ? spare1.hashCode() : 0);
    result = (31 * result) + ((spare2 != null) ? spare2.hashCode() : 0);
    result = (31 * result) + ((spare3 != null) ? spare3.hashCode() : 0);
    result = (31 * result) + ((spare4 != null) ? spare4.hashCode() : 0);

    return result;
  } // end method hashCode

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for action.
   *
   * @param  action  String
   */
  public void setAction(String action) {
    this.action = action;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for batch id.
   *
   * @param  batchId  Long
   */
  public void setBatchId(Long batchId) {
    this.batchId = batchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for deleted.
   *
   * @param  deleted  Boolean
   */
  public void setDeleted(Boolean deleted) {
    this.deleted = deleted;
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
   * setter method for gross amount.
   *
   * @param  grossAmount  BigDecimal
   */
  public void setGrossAmount(BigDecimal grossAmount) {
    this.grossAmount = grossAmount;
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
   * setter method for net amount.
   *
   * @param  netAmount  BigDecimal
   */
  public void setNetAmount(BigDecimal netAmount) {
    this.netAmount = netAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for other change id.
   *
   * @param  otherChangeId  Long
   */
  public void setOtherChangeId(Long otherChangeId) {
    this.otherChangeId = otherChangeId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for payment date.
   *
   * @param  paymentDate  Date
   */
  public void setPaymentDate(Date paymentDate) {
    this.paymentDate = paymentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for payment schedule.
   *
   * @param  paymentSchedule  PaymentSchedule
   */
  public void setPaymentSchedule(PaymentSchedule paymentSchedule) {
    this.paymentSchedule = paymentSchedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for payment type.
   *
   * @param  paymentType  String
   */
  public void setPaymentType(String paymentType) {
    this.paymentType = paymentType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for spare1.
   *
   * @param  spare1  String
   */
  public void setSpare1(String spare1) {
    this.spare1 = spare1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for spare10.
   *
   * @param  spare10  Integer
   */
  public void setSpare10(Integer spare10) {
    this.spare10 = spare10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for spare2.
   *
   * @param  spare2  String
   */
  public void setSpare2(String spare2) {
    this.spare2 = spare2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for spare3.
   *
   * @param  spare3  String
   */
  public void setSpare3(String spare3) {
    this.spare3 = spare3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for spare4.
   *
   * @param  spare4  String
   */
  public void setSpare4(String spare4) {
    this.spare4 = spare4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for spare5.
   *
   * @param  spare5  Date
   */
  public void setSpare5(Date spare5) {
    this.spare5 = spare5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for spare6.
   *
   * @param  spare6  BigDecimal
   */
  public void setSpare6(BigDecimal spare6) {
    this.spare6 = spare6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for spare7.
   *
   * @param  spare7  BigDecimal
   */
  public void setSpare7(BigDecimal spare7) {
    this.spare7 = spare7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for spare8.
   *
   * @param  spare8  BigDecimal
   */
  public void setSpare8(BigDecimal spare8) {
    this.spare8 = spare8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for spare9.
   *
   * @param  spare9  Integer
   */
  public void setSpare9(Integer spare9) {
    this.spare9 = spare9;
  }
} // end class OtherCharge
