package com.cmc.credagility.core.domain.channel;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.contact.ContactPhone;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/15/2014 10:21
 */
@MappedSuperclass public class PhoneChannelResultDestination extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** phone id pk. */
  @JoinColumn(
    name     = "phoneId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  ContactPhone phone;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for phone.
   *
   * @return  ContactPhone
   */
  public ContactPhone getPhone() {
    return phone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for phone.
   *
   * @param  phone  ContactPhone
   */
  public void setPhone(ContactPhone phone) {
    this.phone = phone;
  }
} // end class PhoneChannelResultDestination
