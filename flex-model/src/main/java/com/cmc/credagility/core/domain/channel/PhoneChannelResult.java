package com.cmc.credagility.core.domain.channel;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.cmc.credagility.core.domain.contact.ContactPhone;


/**
 * The phone channel result.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/15/2014 10:26
 */
@MappedSuperclass public abstract class PhoneChannelResult extends BaseChannelResult {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** pk contact phone id. */
  @JoinColumn(
    name     = "contactPhoneId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected ContactPhone contactPhone;

  /** phone number. */
  @Column(
    name   = "phoneNumber",
    length = 255
  )
  protected String phoneNumber;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.channel.AbstractChannelResult#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof PhoneChannelResult)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    PhoneChannelResult that = (PhoneChannelResult) o;

    if ((contactPhone != null) ? (!contactPhone.equals(that.contactPhone)) : (that.contactPhone != null)) {
      return false;
    }

    if ((phoneNumber != null) ? (!phoneNumber.equals(that.phoneNumber)) : (that.phoneNumber != null)) {
      return false;
    }

    return true;
  } // end method equals

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
   * getter method for phone number.
   *
   * @return  String
   */
  public String getPhoneNumber() {
    return this.phoneNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.channel.AbstractChannelResult#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((contactPhone != null) ? contactPhone.hashCode() : 0);
    result = (31 * result) + ((phoneNumber != null) ? phoneNumber.hashCode() : 0);

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

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for phone number.
   *
   * @param  phoneNumber  String
   */
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.channel.AbstractChannelResult#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("PhoneChannelResult");
    sb.append("{contactPhone=").append(contactPhone);
    sb.append(", phoneNumber='").append(phoneNumber).append('\'');
    sb.append('}');

    return sb.toString();
  }
} // end class PhoneChannelResult
