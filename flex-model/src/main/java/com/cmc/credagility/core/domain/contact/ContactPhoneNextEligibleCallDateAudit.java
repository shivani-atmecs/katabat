package com.cmc.credagility.core.domain.contact;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.portfolio.BaseNextEligibleCallDateAudit;


/**
 * This class is used to store ContactPhoneNextEligibleCallDateAudit information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/15/2014 11:22
 */
@Entity
@Table(name = "ContactPhoneNextEligibleCallDateAudit")
public class ContactPhoneNextEligibleCallDateAudit extends BaseNextEligibleCallDateAudit {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Contact phone. Refers {@link ContactPhone} */
  @JoinColumn(
    name       = "phoneId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected ContactPhone contactPhone;

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

    if (!(o instanceof ContactPhoneNextEligibleCallDateAudit)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    ContactPhoneNextEligibleCallDateAudit that = (ContactPhoneNextEligibleCallDateAudit) o;

    if ((contactPhone != null) ? (!contactPhone.equals(that.contactPhone)) : (that.contactPhone != null)) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for contact phone.
   *
   * @return  ContactPhone
   */
  public ContactPhone getContactPhone() {
    return contactPhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((contactPhone != null) ? contactPhone.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for contact phone.
   *
   * @param  contactPhone  ContactPhone
   */
  public void setContactPhone(ContactPhone contactPhone) {
    this.contactPhone = contactPhone;
  }
} // end class ContactPhoneNextEligibleCallDateAudit
