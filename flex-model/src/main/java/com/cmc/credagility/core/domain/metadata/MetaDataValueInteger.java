package com.cmc.credagility.core.domain.metadata;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:pan.kang@ozstrategy.com">Pan Kang</a>
 * @version  10/15/2014 12:31
 */
@MappedSuperclass public abstract class MetaDataValueInteger extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -5268167904552980458L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "value",
    nullable = true
  )
  public Integer value;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for value.
   *
   * @return  Integer
   */
  public Integer getValue() {
    return value;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for value.
   *
   * @param  value  Integer
   */
  public void setValue(Integer value) {
    this.value = value;
  }
} // end class AccountMetaDataValueInteger
