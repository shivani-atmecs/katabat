package com.cmc.credagility.core.domain.payment;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.domain.type.PaymentChannel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * Auto Debit Enrollment Request.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  03/20/2015 15:52 PM
 */
@Entity
@Table(name = "AutoDebitEnrollment")
public class AutoDebitEnrollment extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -3050790020943038159L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "autoDebitEnrollmentId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long autoDebitEnrollmentId;

  /** payment channel. */
  @Column(
    name      = "paymentChannel",
    nullable  = false,
    updatable = false,
    length    = 20
  )
  @Enumerated(EnumType.STRING)
  protected PaymentChannel channel;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "enrolledBy",
    nullable  = false,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Responsible enrolledBy;

  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "enrolledDate",
    nullable  = false,
    updatable = false
  )
  protected Date enrolledDate;

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

    AutoDebitEnrollment that = (AutoDebitEnrollment) o;

    if (channel != that.channel) {
      return false;
    }

    if ((enrolledBy != null) ? (!enrolledBy.equals(that.enrolledBy)) : (that.enrolledBy != null)) {
      return false;
    }

    if ((enrolledDate != null) ? (!enrolledDate.equals(that.enrolledDate)) : (that.enrolledDate != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for auto debit enrollment id.
   *
   * @return  Long
   */
  public Long getAutoDebitEnrollmentId() {
    return autoDebitEnrollmentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for channel.
   *
   * @return  PaymentChannel
   */
  public PaymentChannel getChannel() {
    return channel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for enrolled by.
   *
   * @return  Responsible
   */
  public Responsible getEnrolledBy() {
    return enrolledBy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for enrolled date.
   *
   * @return  Date
   */
  public Date getEnrolledDate() {
    return enrolledDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = (channel != null) ? channel.hashCode() : 0;
    result = (31 * result) + ((enrolledBy != null) ? enrolledBy.hashCode() : 0);
    result = (31 * result) + ((enrolledDate != null) ? enrolledDate.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for auto debit enrollment id.
   *
   * @param  autoDebitEnrollmentId  Long
   */
  public void setAutoDebitEnrollmentId(Long autoDebitEnrollmentId) {
    this.autoDebitEnrollmentId = autoDebitEnrollmentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for channel.
   *
   * @param  channel  PaymentChannel
   */
  public void setChannel(PaymentChannel channel) {
    this.channel = channel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for enrolled by.
   *
   * @param  enrolledBy  Responsible
   */
  public void setEnrolledBy(Responsible enrolledBy) {
    this.enrolledBy = enrolledBy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for enrolled date.
   *
   * @param  enrolledDate  Date
   */
  public void setEnrolledDate(Date enrolledDate) {
    this.enrolledDate = enrolledDate;
  }

} // end class AutoDebitEnrollment
