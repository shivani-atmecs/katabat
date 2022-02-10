package com.ozstrategy.credagility.core.domain.etlFileLayout;

import com.ozstrategy.credagility.core.domain.CreatorEntity;

import javax.persistence.*;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/16/2014 15:56
 */
@MappedSuperclass public class BaseEtlFileLayoutColumn extends CreatorEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column protected Integer displayOrder = 1;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "formatId",
    nullable   = true,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EtlFileLayoutColumnDataFormat format;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#equals(Object)
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

    BaseEtlFileLayoutColumn that = (BaseEtlFileLayoutColumn) o;

    if ((displayOrder != null) ? (!displayOrder.equals(that.displayOrder)) : (that.displayOrder != null)) {
      return false;
    }

    if ((format != null) ? (!format.equals(that.format)) : (that.format != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for display order.
   *
   * @return  Integer
   */
  public Integer getDisplayOrder() {
    return displayOrder;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for format.
   *
   * @return  EtlFileLayoutColumnDataFormat
   */
  public EtlFileLayoutColumnDataFormat getFormat() {
    return format;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = 31;
    result = (31 * result) + ((displayOrder != null) ? displayOrder.hashCode() : 0);
    result = (31 * result) + ((format != null) ? format.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for display order.
   *
   * @param  displayOrder  Integer
   */
  public void setDisplayOrder(Integer displayOrder) {
    this.displayOrder = displayOrder;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for format.
   *
   * @param  format  EtlFileLayoutColumnDataFormat
   */
  public void setFormat(EtlFileLayoutColumnDataFormat format) {
    this.format = format;
  }
} // end class BaseEtlFileLayoutColumn
