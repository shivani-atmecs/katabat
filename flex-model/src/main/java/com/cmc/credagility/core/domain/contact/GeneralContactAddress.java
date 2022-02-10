package com.cmc.credagility.core.domain.contact;

import com.cmc.credagility.core.domain.address.Address;
import com.cmc.credagility.core.domain.address.AddressType;


/**
 * All level address need implement this class.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/14/2014 18:17
 */
public interface GeneralContactAddress {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for address.
   *
   * @return  Address
   */
  Address getAddress();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for address type.
   *
   * @return  AddressType
   */
  AddressType getAddressType();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for address.
   *
   * @param  address  Address
   */
  void setAddress(Address address);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for address type.
   *
   * @param  addressType  AddressType
   */
  void setAddressType(AddressType addressType);
} // end interface GeneralContactAddress
