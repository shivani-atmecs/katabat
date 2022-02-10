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
 * @version  10/15/2014 09:56
 */
@Entity
@Table(name = "TemporaryAuthorizedUserPhoneNextEligibleCallDateAudit")
public class TemporaryAuthorizedUserPhoneNextEligibleCallDateAudit extends BaseNextEligibleCallDateAudit {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "phoneId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected TemporaryAuthorizedUserPhone temporaryAuthorizedUserPhone;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.portfolio.BaseNextEligibleCallDateAudit#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof TemporaryAuthorizedUserPhoneNextEligibleCallDateAudit)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    TemporaryAuthorizedUserPhoneNextEligibleCallDateAudit that = (TemporaryAuthorizedUserPhoneNextEligibleCallDateAudit)
      o;

    if ((temporaryAuthorizedUserPhone != null)
          ? (!temporaryAuthorizedUserPhone.equals(that.temporaryAuthorizedUserPhone))
          : (that.temporaryAuthorizedUserPhone != null)) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for temporary authorized user phone.
   *
   * @return  TemporaryAuthorizedUserPhone
   */
  public TemporaryAuthorizedUserPhone getTemporaryAuthorizedUserPhone() {
    return temporaryAuthorizedUserPhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.portfolio.BaseNextEligibleCallDateAudit#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((temporaryAuthorizedUserPhone != null) ? temporaryAuthorizedUserPhone.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for temporary authorized user phone.
   *
   * @param  temporaryAuthorizedUserPhone  TemporaryAuthorizedUserPhone
   */
  public void setTemporaryAuthorizedUserPhone(TemporaryAuthorizedUserPhone temporaryAuthorizedUserPhone) {
    this.temporaryAuthorizedUserPhone = temporaryAuthorizedUserPhone;
  }
} // end class TemporaryAuthorizedUserPhoneNextEligibleCallDateAudit
