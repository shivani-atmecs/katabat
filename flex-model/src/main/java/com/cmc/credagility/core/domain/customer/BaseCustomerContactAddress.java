package com.cmc.credagility.core.domain.customer;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.MappedSuperclass;

import com.cmc.credagility.core.domain.contact.GeneralContactAddress;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/14/2014 16:23
 */
@MappedSuperclass public abstract class BaseCustomerContactAddress extends BaseCustomerContact
  implements GeneralContactAddress {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "addressForeignFlag",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean addressForeignFlag;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * deepCopy.
   *
   * @param  address  BaseCustomerContactAddress
   */
  public void deepCopy(BaseCustomerContactAddress address) {
    if (address != null) {
      super.deepCopy(address);
      this.addressForeignFlag = address.getAddressForeignFlag();
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for address foreign flag.
   *
   * @return  Boolean
   */
  public Boolean getAddressForeignFlag() {
    return addressForeignFlag;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for address foreign flag.
   *
   * @param  addressForeignFlag  Boolean
   */
  public void setAddressForeignFlag(Boolean addressForeignFlag) {
    this.addressForeignFlag = addressForeignFlag;
  }
} // end class BaseCustomerContactAddress
