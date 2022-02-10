package com.cmc.credagility.core.domain.payment;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * Created with IntelliJ IDEA. User: yongliu Date: 11/23/12 Time: 9:02 AM To change this template use File | Settings |
 * File Templates.
 *
 * @author   <a href="mailto:yong.liu@ozstrategy.com">Yong Liu</a>
 * @version  10/14/2014 17:34
 */
@Entity
@Table(
  name              = "PaymentCalculatorConfig",
  uniqueConstraints = { @UniqueConstraint(columnNames = { "categoryName" }) }
)
public class PaymentCalculatorConfig extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 2954883297308593832L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Additional Fee. */
  @Column(length = 255)
  protected String additionalFee;

  /** Category name. */
  @Column(
    length   = 255,
    nullable = false
  )
  protected String categoryName;

  /** Current APR. */
  @Column(length = 255)
  protected String currentAPR;

  /** Current balance <code>String.</code> */
  @Column(length = 255)
  protected String currentBalance;

  /** Primary key. */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;

  /** Last close window date <code>String.</code> */
  @Column(length = 255)
  protected String lastClosingDate;

  /** Pay out date <code>String.</code> */
  @Column(
    nullable = true,
    length   = 255
  )
  protected String payoutDate;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * equals.
   *
   * @param   o  Object
   *
   * @return  boolean
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    PaymentCalculatorConfig that = (PaymentCalculatorConfig) o;

    if ((additionalFee != null) ? (!additionalFee.equals(that.additionalFee)) : (that.additionalFee != null)) {
      return false;
    }

    if ((categoryName != null) ? (!categoryName.equals(that.categoryName)) : (that.categoryName != null)) {
      return false;
    }

    if ((currentAPR != null) ? (!currentAPR.equals(that.currentAPR)) : (that.currentAPR != null)) {
      return false;
    }

    if ((currentBalance != null) ? (!currentBalance.equals(that.currentBalance)) : (that.currentBalance != null)) {
      return false;
    }

    if ((lastClosingDate != null) ? (!lastClosingDate.equals(that.lastClosingDate)) : (that.lastClosingDate != null)) {
      return false;
    }

    if ((payoutDate != null) ? (!payoutDate.equals(that.payoutDate)) : (that.payoutDate != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for additional fee.
   *
   * @return  String
   */
  public String getAdditionalFee() {
    return additionalFee;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for category name.
   *
   * @return  String
   */
  public String getCategoryName() {
    return categoryName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for current APR.
   *
   * @return  String
   */
  public String getCurrentAPR() {
    return currentAPR;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for current balance.
   *
   * @return  String
   */
  public String getCurrentBalance() {
    return currentBalance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for id.
   *
   * @return  Long
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last closing date.
   *
   * @return  String
   */
  public String getLastClosingDate() {
    return lastClosingDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payout date.
   *
   * @return  String
   */
  public String getPayoutDate() {
    return payoutDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = (additionalFee != null) ? additionalFee.hashCode() : 0;
    result = (31 * result) + ((categoryName != null) ? categoryName.hashCode() : 0);
    result = (31 * result) + ((currentAPR != null) ? currentAPR.hashCode() : 0);
    result = (31 * result) + ((currentBalance != null) ? currentBalance.hashCode() : 0);
    result = (31 * result) + ((lastClosingDate != null) ? lastClosingDate.hashCode() : 0);
    result = (31 * result) + ((payoutDate != null) ? payoutDate.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for additional fee.
   *
   * @param  additionalFee  String
   */
  public void setAdditionalFee(String additionalFee) {
    this.additionalFee = additionalFee;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for category name.
   *
   * @param  categoryName  String
   */
  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for current APR.
   *
   * @param  currentAPR  String
   */
  public void setCurrentAPR(String currentAPR) {
    this.currentAPR = currentAPR;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for current balance.
   *
   * @param  currentBalance  String
   */
  public void setCurrentBalance(String currentBalance) {
    this.currentBalance = currentBalance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for id.
   *
   * @param  id  Long
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last closing date.
   *
   * @param  lastClosingDate  String
   */
  public void setLastClosingDate(String lastClosingDate) {
    this.lastClosingDate = lastClosingDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for payout date.
   *
   * @param  payoutDate  String
   */
  public void setPayoutDate(String payoutDate) {
    this.payoutDate = payoutDate;
  }
} // end class PaymentCalculatorConfig
