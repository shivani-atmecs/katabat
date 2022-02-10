package com.cmc.credagility.core.domain.businesscontext;

import java.io.Serializable;

import java.math.BigDecimal;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.util.StringUtils;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;

import com.ozstrategy.credagility.core.util.DataFormatter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 10:43
 */
@Entity
@Table(name = "BCAssociatedField")
public class BCAssociatedField extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 1703982479198132596L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "businessDataType",
    length   = 32,
    nullable = false
  )
  protected String businessDataType;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "dataType",
    nullable = false,
    length   = 32
  )
  protected String dataType;

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = true,
    length   = 255
  )
  protected String description;

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = false,
    length   = 255
  )
  protected String fieldName;

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean idField = false;

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = false,
    length   = 255
  )
  protected String modelName;

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = true,
    length   = 255
  )
  protected String subModelName;

  @Transient private Object value;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * convertData.
   *
   * @param   dataType  String
   * @param   data      String
   *
   * @return  Object
   */
  public Object convertData(String dataType, String data) {
    if ((data == null) || !StringUtils.hasText(data)) {
      return null;
    }

    if ("String".equalsIgnoreCase(dataType)) {
      return data;
    } else if ("Integer".equalsIgnoreCase(dataType)) {
      return Integer.parseInt(data);
    } else if ("Long".equalsIgnoreCase(dataType)) {
      return Long.parseLong(data);
    } else if ("BigDecimal".equalsIgnoreCase(dataType) || "Decimal".equalsIgnoreCase(dataType)) {
      return new BigDecimal(data);
    } else if ("Float".equalsIgnoreCase(dataType)) {
      return Float.parseFloat(data);
    } else if ("Double".equalsIgnoreCase(dataType)) {
      return Double.parseDouble(data);
    } else if ("Date".equalsIgnoreCase(dataType)) {
      try {
        return new SimpleDateFormat(DataFormatter.getDefaultDatePattern()).parse(data);
      } catch (ParseException e) {
        e.printStackTrace();
      }
    }

    return null;
  } // end method convertData

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * detectDataType.
   */
  public void detectDataType() {
    if ("String".equalsIgnoreCase(businessDataType)) {
      dataType = "String";
    } else if ("Currency".equalsIgnoreCase(businessDataType)) {
      dataType = "BigDecimal";
    } else if ("Percentage".equalsIgnoreCase(businessDataType)) {
      dataType = "BigDecimal";
    } else if ("Decimal".equalsIgnoreCase(businessDataType)) {
      dataType = "BigDecimal";
    } else if ("Integer".equalsIgnoreCase(businessDataType)) {
      dataType = "Long";
    } else if ("Boolean".equalsIgnoreCase(businessDataType)) {
      dataType = "Boolean";
    } else if ("Date".equalsIgnoreCase(businessDataType)) {
      dataType = "Date";
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof BCAssociatedField)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    BCAssociatedField that = (BCAssociatedField) o;

    if (dataType != that.dataType) {
      return false;
    }

    if ((fieldName != null) ? (!fieldName.equals(that.fieldName)) : (that.fieldName != null)) {
      return false;
    }

    if ((modelName != null) ? (!modelName.equals(that.modelName)) : (that.modelName != null)) {
      return false;
    }

    if ((subModelName != null) ? (!subModelName.equals(that.subModelName)) : (that.subModelName != null)) {
      return false;
    }

    if ((idField != null) ? (!idField.equals(that.idField)) : (that.idField != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for business data type.
   *
   * @return  String
   */
  public String getBusinessDataType() {
    return businessDataType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data type.
   *
   * @return  String
   */
  public String getDataType() {
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
   * getter method for id field.
   *
   * @return  Boolean
   */
  public Boolean getIdField() {
    if (idField == null) {
      return Boolean.FALSE;
    }

    return idField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for model name.
   *
   * @return  String
   */
  public String getModelName() {
    return modelName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for sub model name.
   *
   * @return  String
   */
  public String getSubModelName() {
    return subModelName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for value.
   *
   * @return  Object
   */
  public Object getValue() {
    return value;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((dataType != null) ? dataType.hashCode() : 0);
    result = (31 * result) + ((fieldName != null) ? fieldName.hashCode() : 0);
    result = (31 * result) + ((modelName != null) ? modelName.hashCode() : 0);
    result = (31 * result) + ((subModelName != null) ? subModelName.hashCode() : 0);
    result = (31 * result) + ((idField != null) ? idField.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for business data type.
   *
   * @param  businessDataType  String
   */
  public void setBusinessDataType(String businessDataType) {
    this.businessDataType = businessDataType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data type.
   *
   * @param  dataType  String
   */
  public void setDataType(String dataType) {
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

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for id field.
   *
   * @param  idField  Boolean
   */
  public void setIdField(Boolean idField) {
    this.idField = idField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for model name.
   *
   * @param  modelName  String
   */
  public void setModelName(String modelName) {
    this.modelName = modelName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for sub model name.
   *
   * @param  subModelName  String
   */
  public void setSubModelName(String subModelName) {
    this.subModelName = subModelName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for value.
   *
   * @param  value  Object
   */
  public void setValue(Object value) {
    this.value = value;
  }
} // end class BCAssociatedField
