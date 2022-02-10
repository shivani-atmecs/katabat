package com.cmc.credagility.core.domain.contact;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.portfolio.BaseNextEligibleCallDateAudit;


/**
 * This class is used to store FuturePermanentContactPhoneNextEligibleCallDateAudit information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/15/2014 11:08
 */
@Entity
@Table(name = "FuturePermanentContactPhoneNextEligibleCallDateAudit")
public class FuturePermanentContactPhoneNextEligibleCallDateAudit extends BaseNextEligibleCallDateAudit {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Future permanent contact phone, Refers {@link FuturePermanentContactPhone}. */
  @JoinColumn(
    name       = "phoneId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected FuturePermanentContactPhone futurePermanentContactPhone;

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

    if (!(o instanceof FuturePermanentContactPhoneNextEligibleCallDateAudit)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    FuturePermanentContactPhoneNextEligibleCallDateAudit that = (FuturePermanentContactPhoneNextEligibleCallDateAudit)
      o;

    if ((futurePermanentContactPhone != null) ? (!futurePermanentContactPhone.equals(
              that.futurePermanentContactPhone)) : (that.futurePermanentContactPhone != null)) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for future permanent contact phone.
   *
   * @return  FuturePermanentContactPhone
   */
  public FuturePermanentContactPhone getFuturePermanentContactPhone() {
    return futurePermanentContactPhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((futurePermanentContactPhone != null) ? futurePermanentContactPhone.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for future permanent contact phone.
   *
   * @param  futurePermanentContactPhone  FuturePermanentContactPhone
   */
  public void setFuturePermanentContactPhone(FuturePermanentContactPhone futurePermanentContactPhone) {
    this.futurePermanentContactPhone = futurePermanentContactPhone;
  }
} // end class FuturePermanentContactPhoneNextEligibleCallDateAudit
