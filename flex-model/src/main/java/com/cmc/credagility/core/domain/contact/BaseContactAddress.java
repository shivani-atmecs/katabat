package com.cmc.credagility.core.domain.contact;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.MappedSuperclass;

import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/14/2014 17:19
 */
@MappedSuperclass public abstract class BaseContactAddress extends BaseContact implements GeneralContactAddress {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "addressForeignFlag",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean addressForeignFlag;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * deepCopy.
   *
   * @param  address  BaseContactAddress
   */
  public void deepCopy(BaseContactAddress address) {
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
} // end class BaseContactAddress
