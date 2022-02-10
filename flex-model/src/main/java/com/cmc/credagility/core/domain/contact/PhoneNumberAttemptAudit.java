package com.cmc.credagility.core.domain.contact;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * This class is used to store PhoneNumberAttemptAudit information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/15/2014 10:56
 */
@Entity
@Table(name = "PhoneNumberAttemptAudit")
public class PhoneNumberAttemptAudit extends BasePhoneNumberAudit {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -8397750218220007251L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @Column(name = "attemptDate")
  private Date attemptDate = new Date();

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new PhoneNumberAttemptAudit object.
   */
  public PhoneNumberAttemptAudit() { }

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

    if (!(o instanceof PhoneNumberAttemptAudit)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    PhoneNumberAttemptAudit that = (PhoneNumberAttemptAudit) o;

    if ((attemptDate != null) ? (!attemptDate.equals(that.attemptDate)) : (that.attemptDate != null)) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for attempt date.
   *
   * @return  Date
   */
  public Date getAttemptDate() {
    return attemptDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((attemptDate != null) ? attemptDate.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for attempt date.
   *
   * @param  attemptDate  Date
   */
  public void setAttemptDate(Date attemptDate) {
    this.attemptDate = attemptDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * toString.
   *
   * @return  String
   */
  @Override public String toString() {
    return "PhoneNumberAttemptAudit{"
      + "id=" + id
      + ", activity=" + activity
      + ", phoneNum='" + phoneNum + '\''
      + ", account=" + account
      + ", attemptDate=" + attemptDate
      + ", callType=" + callType
      + '}';
  }
} // end class PhoneNumberAttemptAudit
