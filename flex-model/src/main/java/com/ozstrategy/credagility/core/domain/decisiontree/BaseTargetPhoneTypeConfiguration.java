package com.ozstrategy.credagility.core.domain.decisiontree;

import com.cmc.credagility.core.domain.contact.PhoneType;
import com.ozstrategy.credagility.core.domain.TargetBaseTypeConfiguration;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;


/**
 * Used for storage Base Target PhoneType Configuration.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/15/2014 17:49
 */
@MappedSuperclass public class BaseTargetPhoneTypeConfiguration extends TargetBaseTypeConfiguration {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** PhoneType. */
  @JoinColumn(
    name       = "phoneTypeId",
    nullable   = false,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PhoneType phoneType;

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

    BaseTargetPhoneTypeConfiguration that = (BaseTargetPhoneTypeConfiguration) o;

    if ((phoneType != null) ? (!phoneType.equals(that.phoneType)) : (that.phoneType != null)) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for phone type.
   *
   * @return  PhoneType
   */
  public PhoneType getPhoneType() {
    return phoneType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.TargetBaseTypeConfiguration#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((phoneType != null) ? phoneType.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for phone type.
   *
   * @param  phoneType  PhoneType
   */
  public void setPhoneType(PhoneType phoneType) {
    this.phoneType = phoneType;
  }
} // end class BaseTargetPhoneTypeConfiguration
