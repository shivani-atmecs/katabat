package com.cmc.credagility.core.domain.authorizedcontact;

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
 * @version  10/14/2014 17:45
 */
@Entity
@Table(name = "AuthorizedContactPhoneNextEligibleCallDateAudit")
public class AuthorizedContactPhoneNextEligibleCallDateAudit extends BaseNextEligibleCallDateAudit {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "phoneId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected AuthorizedContactPhone authorizedContactPhone;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.portfolio.BaseNextEligibleCallDateAudit#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof AuthorizedContactPhoneNextEligibleCallDateAudit)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    AuthorizedContactPhoneNextEligibleCallDateAudit that = (AuthorizedContactPhoneNextEligibleCallDateAudit) o;

    if ((authorizedContactPhone != null) ? (!authorizedContactPhone.equals(that.authorizedContactPhone))
                                         : (that.authorizedContactPhone != null)) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for authorized contact phone.
   *
   * @return  AuthorizedContactPhone
   */
  public AuthorizedContactPhone getAuthorizedContactPhone() {
    return authorizedContactPhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.portfolio.BaseNextEligibleCallDateAudit#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((authorizedContactPhone != null) ? authorizedContactPhone.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for authorized contact phone.
   *
   * @param  authorizedContactPhone  AuthorizedContactPhone
   */
  public void setAuthorizedContactPhone(AuthorizedContactPhone authorizedContactPhone) {
    this.authorizedContactPhone = authorizedContactPhone;
  }
} // end class AuthorizedContactPhoneNextEligibleCallDateAudit
