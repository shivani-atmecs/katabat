package com.ozstrategy.credagility.core.domain.etlFileLayout;

import com.ozstrategy.credagility.core.domain.CreatorEntity;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/16/2014 16:15
 */
@Entity
@Table(name = "EtlFileLayoutColumnDataFormat")
public class EtlFileLayoutColumnDataFormat extends CreatorEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  protected String format;

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  @JoinColumn(
    name      = "dataTypeId",
    nullable  = false,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private EtlFileLayoutColumnDataType dataType;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new EtlFileLayoutColumnDataFormat object.
   */
  public EtlFileLayoutColumnDataFormat() { }

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

    EtlFileLayoutColumnDataFormat that = (EtlFileLayoutColumnDataFormat) o;

    if ((dataType != null) ? (!dataType.equals(that.dataType)) : (that.dataType != null)) {
      return false;
    }

    if ((format != null) ? (!format.equals(that.format)) : (that.format != null)) {
      return false;
    }

    if ((id != null) ? (!id.equals(that.id)) : (that.id != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data type.
   *
   * @return  EtlFileLayoutColumnDataType
   */
  public EtlFileLayoutColumnDataType getDataType() {
    return dataType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for format.
   *
   * @return  String
   */
  public String getFormat() {
    return format;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for id.
   *
   * @return  Long
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((format != null) ? format.hashCode() : 0);
    result = (31 * result) + ((id != null) ? id.hashCode() : 0);
    result = (31 * result) + ((dataType != null) ? dataType.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data type.
   *
   * @param  dataType  EtlFileLayoutColumnDataType
   */
  public void setDataType(EtlFileLayoutColumnDataType dataType) {
    this.dataType = dataType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for format.
   *
   * @param  format  String
   */
  public void setFormat(String format) {
    this.format = format;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for id.
   *
   * @param  id  Long
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.CreatorEntity#toString()
   */
  @Override public String toString() {
    return "EtlFileLayoutColumnDataFormat{"
      + "format='" + format + '\''
      + ", id=" + id
      + ", dataType=" + dataType
      + '}';
  }
} // end class EtlFileLayoutColumnDataFormat
