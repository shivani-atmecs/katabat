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
@MappedSuperclass public abstract class MetaDataValueLong extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -5268167904552980458L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "value",
    nullable = true
  )
  public Long value;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for value.
   *
   * @return  Long
   */
  public Long getValue() {
    return value;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for value.
   *
   * @param  value  Long
   */
  public void setValue(Long value) {
    this.value = value;
  }
} // end class MetaDataValueLong
