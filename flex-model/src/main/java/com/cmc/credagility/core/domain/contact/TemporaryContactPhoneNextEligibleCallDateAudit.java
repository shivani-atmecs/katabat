package com.cmc.credagility.core.domain.contact;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.portfolio.BaseNextEligibleCallDateAudit;


/**
 * This class is used to store TemporaryContactPhoneNextEligibleCallDateAudit information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/15/2014 10:45
 */
@Entity
@Table(name = "TemporaryContactPhoneNextEligibleCallDateAudit")
public class TemporaryContactPhoneNextEligibleCallDateAudit extends BaseNextEligibleCallDateAudit {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Temporary contact phone, Refers {@link TemporaryContactPhone}. */
  @JoinColumn(
    name       = "phoneId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected TemporaryContactPhone temporaryContactPhone;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.portfolio.BaseNextEligibleCallDateAudit#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof TemporaryContactPhoneNextEligibleCallDateAudit)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    TemporaryContactPhoneNextEligibleCallDateAudit that = (TemporaryContactPhoneNextEligibleCallDateAudit) o;

    if ((temporaryContactPhone != null) ? (!temporaryContactPhone.equals(that.temporaryContactPhone))
                                        : (that.temporaryContactPhone != null)) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for temporary contact phone.
   *
   * @return  TemporaryContactPhone
   */
  public TemporaryContactPhone getTemporaryContactPhone() {
    return temporaryContactPhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.portfolio.BaseNextEligibleCallDateAudit#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((temporaryContactPhone != null) ? temporaryContactPhone.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for temporary contact phone.
   *
   * @param  temporaryContactPhone  TemporaryContactPhone
   */
  public void setTemporaryContactPhone(TemporaryContactPhone temporaryContactPhone) {
    this.temporaryContactPhone = temporaryContactPhone;
  }
} // end class TemporaryContactPhoneNextEligibleCallDateAudit
