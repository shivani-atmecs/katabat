package com.cmc.credagility.core.domain.metadata;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:pan.kang@ozstrategy.com">Pan Kang</a>
 * @version  10/15/2014 12:30
 */
@MappedSuperclass public abstract class MetaDataValueDecimal extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 5091634510582639701L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "value",
    nullable = true
  )
  public BigDecimal value;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for value.
   *
   * @return  BigDecimal
   */
  public BigDecimal getValue() {
    return value;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for value.
   *
   * @param  value  BigDecimal
   */
  public void setValue(BigDecimal value) {
    this.value = value;
  }
} // end class AccountMetaDataValueDecimal
