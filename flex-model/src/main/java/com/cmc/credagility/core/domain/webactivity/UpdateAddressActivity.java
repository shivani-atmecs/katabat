package com.cmc.credagility.core.domain.webactivity;


import com.cmc.credagility.core.domain.address.Address;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/16/2014 09:59
 */
public class UpdateAddressActivity extends BaseWebActivity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -2716497828531063483L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String  addressType;
  private Address newAddress;
  private Address oldAddress;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for address type.
   *
   * @return  String
   */
  public String getAddressType() {
    return addressType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for new address.
   *
   * @return  Address
   */
  public Address getNewAddress() {
    return newAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for old address.
   *
   * @return  Address
   */
  public Address getOldAddress() {
    return oldAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for address type.
   *
   * @param  addressType  String
   */
  public void setAddressType(String addressType) {
    this.addressType = addressType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for new address.
   *
   * @param  newAddress  Address
   */
  public void setNewAddress(Address newAddress) {
    this.newAddress = newAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for old address.
   *
   * @param  oldAddress  Address
   */
  public void setOldAddress(Address oldAddress) {
    this.oldAddress = oldAddress;
  }

} // end class UpdateAddressActivity
