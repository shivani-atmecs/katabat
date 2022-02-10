package com.ozstrategy.credagility.core.domain.etlFileLayout;

import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.CreatorEntity;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/16/2014 15:59
 */
@Entity public class EtlAccountLoaderVariable extends CreatorEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = false,
    length   = 32
  )
  @Enumerated(value = EnumType.STRING)
  protected EtlAccountLoaderCategoryEnum category;

  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean allowNull = Boolean.TRUE;

  @Column(
    nullable = false,
    length   = 32
  )
  @Enumerated(value = EnumType.STRING)
  private EtlDataTypeEnum dataType;

  @Column(length = 255)
  private String description;

  @Column(
    nullable = false,
    length   = 255
  )
  private String expression;
  @Column(length = 128)
  private String fieldName;

  @GeneratedValue(strategy = IDENTITY)
  @Id private Long id;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#equals(Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof EtlAccountLoaderVariable)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    EtlAccountLoaderVariable that = (EtlAccountLoaderVariable) o;

    if ((allowNull != null) ? (!allowNull.equals(that.allowNull)) : (that.allowNull != null)) {
      return false;
    }

    if (category != that.category) {
      return false;
    }

    if (dataType != that.dataType) {
      return false;
    }

    if ((description != null) ? (!description.equals(that.description)) : (that.description != null)) {
      return false;
    }

    if ((expression != null) ? (!expression.equals(that.expression)) : (that.expression != null)) {
      return false;
    }

    if ((fieldName != null) ? (!fieldName.equals(that.fieldName)) : (that.fieldName != null)) {
      return false;
    }

    if ((id != null) ? (!id.equals(that.id)) : (that.id != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for allow null.
   *
   * @return  Boolean
   */
  public Boolean getAllowNull() {
    return allowNull;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for category.
   *
   * @return  EtlAccountLoaderCategoryEnum
   */
  public EtlAccountLoaderCategoryEnum getCategory() {
    return category;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data type.
   *
   * @return  EtlDataTypeEnum
   */
  public EtlDataTypeEnum getDataType() {
    return dataType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for description.
   *
   * @return  String
   */
  public String getDescription() {
    return description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for expression.
   *
   * @return  String
   */
  public String getExpression() {
    return expression;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for field name.
   *
   * @return  String
   */
  public String getFieldName() {
    return fieldName;
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
    result = (31 * result) + ((category != null) ? category.hashCode() : 0);
    result = (31 * result) + ((allowNull != null) ? allowNull.hashCode() : 0);
    result = (31 * result) + ((dataType != null) ? dataType.hashCode() : 0);
    result = (31 * result) + ((description != null) ? description.hashCode() : 0);
    result = (31 * result) + ((expression != null) ? expression.hashCode() : 0);
    result = (31 * result) + ((fieldName != null) ? fieldName.hashCode() : 0);
    result = (31 * result) + ((id != null) ? id.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for allow null.
   *
   * @param  allowNull  Boolean
   */
  public void setAllowNull(Boolean allowNull) {
    this.allowNull = allowNull;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for category.
   *
   * @param  category  EtlAccountLoaderCategoryEnum
   */
  public void setCategory(EtlAccountLoaderCategoryEnum category) {
    this.category = category;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data type.
   *
   * @param  dataType  EtlDataTypeEnum
   */
  public void setDataType(EtlDataTypeEnum dataType) {
    this.dataType = dataType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for description.
   *
   * @param  description  String
   */
  public void setDescription(String description) {
    this.description = description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for expression.
   *
   * @param  expression  String
   */
  public void setExpression(String expression) {
    this.expression = expression;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for field name.
   *
   * @param  fieldName  String
   */
  public void setFieldName(String fieldName) {
    this.fieldName = fieldName;
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
} // end class EtlAccountLoaderVariable
