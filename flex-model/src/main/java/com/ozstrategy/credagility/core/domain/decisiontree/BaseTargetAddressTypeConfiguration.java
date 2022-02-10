package com.ozstrategy.credagility.core.domain.decisiontree;

import com.cmc.credagility.core.domain.address.AddressType;
import com.ozstrategy.credagility.core.domain.TargetBaseTypeConfiguration;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;


/**
 * Used for storage Base Target AddressType Configuration.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/15/2014 17:46
 */
@MappedSuperclass public class BaseTargetAddressTypeConfiguration extends TargetBaseTypeConfiguration {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Address Type. */
  @JoinColumn(
    name       = "addressTypeId",
    nullable   = false,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected AddressType addressType;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.TargetBaseTypeConfiguration#equals(Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    BaseTargetAddressTypeConfiguration that = (BaseTargetAddressTypeConfiguration) o;

    if ((addressType != null) ? (!addressType.equals(that.addressType)) : (that.addressType != null)) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for address type.
   *
   * @return  AddressType
   */
  public AddressType getAddressType() {
    return addressType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.TargetBaseTypeConfiguration#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((addressType != null) ? addressType.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for address type.
   *
   * @param  addressType  AddressType
   */
  public void setAddressType(AddressType addressType) {
    this.addressType = addressType;
  }
} // end class BaseTargetAddressTypeConfiguration
