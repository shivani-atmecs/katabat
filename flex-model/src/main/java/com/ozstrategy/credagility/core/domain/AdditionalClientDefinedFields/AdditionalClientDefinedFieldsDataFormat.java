package com.ozstrategy.credagility.core.domain.AdditionalClientDefinedFields;

import com.ozstrategy.credagility.core.domain.CreatorEntity;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/22/2015 14:54
 */
@Entity
@Table(name = "AdditionalClientDefinedFieldsDataFormat")
public class AdditionalClientDefinedFieldsDataFormat extends CreatorEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
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
  private AdditionalClientDefinedFieldsDataType dataType;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new AdditionalClientDefinedFieldsDataFormat object.
   */
  public AdditionalClientDefinedFieldsDataFormat() { }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#equals(Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof AdditionalClientDefinedFieldsDataFormat)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    AdditionalClientDefinedFieldsDataFormat that = (AdditionalClientDefinedFieldsDataFormat) o;

    if ((format != null) ? (!format.equals(that.format)) : (that.format != null)) {
      return false;
    }

    if ((id != null) ? (!id.equals(that.id)) : (that.id != null)) {
      return false;
    }

    return !((dataType != null) ? (!dataType.equals(that.dataType)) : (that.dataType != null));

  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data type.
   *
   * @return  AdditionalClientDefinedFieldsDataType
   */
  public AdditionalClientDefinedFieldsDataType getDataType() {
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
   * @param  dataType  AdditionalClientDefinedFieldsDataType
   */
  public void setDataType(AdditionalClientDefinedFieldsDataType dataType) {
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
} // end class AdditionalClientDefinedFieldsDataFormat
