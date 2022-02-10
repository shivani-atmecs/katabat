package com.cmc.credagility.core.domain.metadata;

import java.io.Serializable;

import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:pan.kang@ozstrategy.com">Pan Kang</a>
 * @version  10/15/2014 12:32
 */
@MappedSuperclass public abstract class MetaDataValueText extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 1505457948078338559L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Lob public String value;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for value.
   *
   * @return  String
   */
  public String getValue() {
    return value;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for value.
   *
   * @param  value  String
   */
  public void setValue(String value) {
    this.value = value;
  }
} // end class MetaDataValueText
