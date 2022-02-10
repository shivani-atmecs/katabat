package com.cmc.credagility.core.domain.authorizeduser;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.portfolio.BaseNextEligibleCallDateAudit;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 09:53
 */
@Entity
@Table(name = "FuturePermanentAuthorizedUserPhoneNextEligibleCallDateAudit")
public class FuturePermanentAuthorizedUserPhoneNextEligibleCallDateAudit extends BaseNextEligibleCallDateAudit {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "phoneId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected FuturePermanentAuthorizedUserPhone futurePermanentAuthorizedUserPhone;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.portfolio.BaseNextEligibleCallDateAudit#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof FuturePermanentAuthorizedUserPhoneNextEligibleCallDateAudit)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    FuturePermanentAuthorizedUserPhoneNextEligibleCallDateAudit that =
      (FuturePermanentAuthorizedUserPhoneNextEligibleCallDateAudit) o;

    if ((futurePermanentAuthorizedUserPhone != null)
          ? (!futurePermanentAuthorizedUserPhone.equals(that.futurePermanentAuthorizedUserPhone))
          : (that.futurePermanentAuthorizedUserPhone != null)) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for future permanent authorized user phone.
   *
   * @return  FuturePermanentAuthorizedUserPhone
   */
  public FuturePermanentAuthorizedUserPhone getFuturePermanentAuthorizedUserPhone() {
    return futurePermanentAuthorizedUserPhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.portfolio.BaseNextEligibleCallDateAudit#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result)
      + ((futurePermanentAuthorizedUserPhone != null) ? futurePermanentAuthorizedUserPhone.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for future permanent authorized user phone.
   *
   * @param  futurePermanentAuthorizedUserPhone  FuturePermanentAuthorizedUserPhone
   */
  public void setFuturePermanentAuthorizedUserPhone(
    FuturePermanentAuthorizedUserPhone futurePermanentAuthorizedUserPhone) {
    this.futurePermanentAuthorizedUserPhone = futurePermanentAuthorizedUserPhone;
  }
} // end class FuturePermanentAuthorizedUserPhoneNextEligibleCallDateAudit
