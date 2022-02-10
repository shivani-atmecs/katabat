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
 * @version  10/15/2014 09:39
 */
@Entity
@Table(name = "AuthorizedUserPhoneNextEligibleCallDateAudit")
public class AuthorizedUserPhoneNextEligibleCallDateAudit extends BaseNextEligibleCallDateAudit {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "phoneId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected AuthorizedUserPhone authorizedUserPhone;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.portfolio.BaseNextEligibleCallDateAudit#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof AuthorizedUserPhoneNextEligibleCallDateAudit)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    AuthorizedUserPhoneNextEligibleCallDateAudit that = (AuthorizedUserPhoneNextEligibleCallDateAudit) o;

    if ((authorizedUserPhone != null) ? (!authorizedUserPhone.equals(that.authorizedUserPhone))
                                      : (that.authorizedUserPhone != null)) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for authorized user phone.
   *
   * @return  AuthorizedUserPhone
   */
  public AuthorizedUserPhone getAuthorizedUserPhone() {
    return authorizedUserPhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.portfolio.BaseNextEligibleCallDateAudit#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((authorizedUserPhone != null) ? authorizedUserPhone.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for authorized user phone.
   *
   * @param  authorizedUserPhone  AuthorizedUserPhone
   */
  public void setAuthorizedUserPhone(AuthorizedUserPhone authorizedUserPhone) {
    this.authorizedUserPhone = authorizedUserPhone;
  }
} // end class AuthorizedUserPhoneNextEligibleCallDateAudit
