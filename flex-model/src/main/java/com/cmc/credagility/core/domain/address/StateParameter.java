package com.cmc.credagility.core.domain.address;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * This calss is used to store State compliance information. When process account actions, this calss provides
 * compliance measurements for that particular state.
 *
 * <p>Although it is called "state parameters" (sounds very much US), it can be used internationally. "State" should be
 * understood as a demographic region which has some collection laws regulating collection activities. These parameters
 * need to reflect those regulations.</p>
 *
 * @author   Ye Zhang
 * @version  10/17/2014 10:19
 */
@Entity
@Table(name = "StateParameter")
public class StateParameter extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 3748217158287066478L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @Column(name = "paymentFee")
  private BigDecimal paymentFee = new BigDecimal("0.0");


// npelleti, 07/30, USBank, Removed unique constraint
  @Column(
    name     = "state", /*unique = true,*/
    nullable = false,
    length   = 100
  )
  @Id private String state;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
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

    final StateParameter other = (StateParameter) obj;

    if (paymentFee == null) {
      if (other.getPaymentFee() != null) {
        return false;
      }
    } else if (!paymentFee.equals(other.getPaymentFee())) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getPaymentFee() {
    return paymentFee;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getState() {
    return state;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    final int PRIME  = 31;
    int       result = super.hashCode();
    result = (PRIME * result)
      + ((paymentFee == null) ? 0 : paymentFee.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for payment fee.
   *
   * @param  paymentFee  BigDecimal
   */
  public void setPaymentFee(BigDecimal paymentFee) {
    this.paymentFee = paymentFee;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for state.
   *
   * @param  state  String
   */
  public void setState(String state) {
    this.state = state;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#toString()
   */
  @Override public String toString() {
    final String TAB = "    ";

    StringBuilder retValue = new StringBuilder();

    retValue.append("StateParameter ( ").append(super.toString()).append(TAB).append("paymentFee = ").append(
      this.paymentFee).append(TAB).append(
      " )");

    return retValue.toString();
  }

} // end class StateParameter
