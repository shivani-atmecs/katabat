package com.cmc.credagility.core.domain.payment;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * Created by Yang Wang on 11/27/15.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  11/27/2015 11:13 AM
 */
@Entity public class PaymentGroup extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -3536727486050889355L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "groupId",
    length = 125
  )
  protected String groupId;


  /** TODO: DOCUMENT ME! */
  @Column(
    unique   = true,
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long paymentGroupId;


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "paymentGroup",
    cascade  = { CascadeType.REMOVE, CascadeType.ALL }
  )
  @OrderBy("createDate asc")
  protected Set<Payment> payments = new LinkedHashSet<Payment>();

  /** DOCUMENT ME! */
  @Column(
    name             = "recurring",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean recurring;

  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "totalPaymentAmount",
    nullable  = false,
    precision = 19,
    scale     = 2
  )
  protected BigDecimal totalPaymentAmount;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addPayment.
   *
   * @param   payment  Payment
   *
   * @return  boolean
   */
  public boolean addPayment(Payment payment) {
    payment.setPaymentGroup(this);

    return getPayments().add(payment);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for group id.
   *
   * @return  String
   */
  public String getGroupId() {
    return groupId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment group id.
   *
   * @return  Long
   */
  public Long getPaymentGroupId() {
    return paymentGroupId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payments.
   *
   * @return  Set
   */
  public Set<Payment> getPayments() {
    return payments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for recurring flag.
   *
   * @return  Boolean
   */
  public Boolean getRecurring() {
    return recurring;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for total payment amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getTotalPaymentAmount() {
    return totalPaymentAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for group id.
   *
   * @param  groupId  String
   */
  public void setGroupId(String groupId) {
    this.groupId = groupId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for payment group id.
   *
   * @param  paymentGroupId  Long
   */
  public void setPaymentGroupId(Long paymentGroupId) {
    this.paymentGroupId = paymentGroupId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for payments.
   *
   * @param  payments  Set
   */
  public void setPayments(Set<Payment> payments) {
    this.payments = payments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for recurring flag.
   *
   * @param  recurring  Boolean
   */
  public void setRecurring(Boolean recurring) {
    this.recurring = recurring;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for total payment amount.
   *
   * @param  totalPaymentAmount  BigDecimal
   */
  public void setTotalPaymentAmount(BigDecimal totalPaymentAmount) {
    this.totalPaymentAmount = totalPaymentAmount;
  }
} // end class PaymentGroup
