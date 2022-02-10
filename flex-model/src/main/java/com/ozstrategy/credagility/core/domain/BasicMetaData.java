package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.util.DateUtil;
import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.entity.BaseEntity;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/16/2014 11:31
 */
@MappedSuperclass public class BasicMetaData extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "metaDataDateValue",
    nullable = true
  )
  @Temporal(TemporalType.TIMESTAMP)
  public Date metaDataDateValue;


  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = false,
    length   = 255
  )
  protected String dataType;


  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "metaDataBooleanValue",
    nullable         = true,
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean metaDataBooleanValue;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "metaDataDecimalValue",
    nullable  = true,
    precision = 19,
    scale     = 8
  )
  protected BigDecimal metaDataDecimalValue;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "metaDataIntegerValue",
    nullable = true
  )
  protected Integer metaDataIntegerValue;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "metaDataLongValue",
    nullable = true
  )
  protected Long metaDataLongValue;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "metaDataStringValue",
    length   = 2048,
    nullable = true
  )
  protected String metaDataStringValue;


  /** TODO: DOCUMENT ME! */
  @Column(nullable = true)
  protected String value;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * clearValue.
   */
  public void clearValue() {
    this.setMetaDataBooleanValue(null);
    this.setMetaDataDateValue(null);
    this.setMetaDataDecimalValue(null);
    this.setMetaDataIntegerValue(null);
    this.setMetaDataLongValue(null);
    this.setMetaDataStringValue(null);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * detectDataType.
   *
   * @param  businessDataType  String
   */
  public void detectDataType(String businessDataType) {
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
   * equals.
   *
   * @param   o  Object
   *
   * @return  boolean
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    BasicMetaData that = (BasicMetaData) o;

    if (!dataType.equals(that.dataType)) {
      return false;
    }

    if ((value != null) ? (!value.equals(that.value)) : (that.value != null)) {
      return false;
    }

    return true;
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
   * getter method for meta data boolean value.
   *
   * @return  Boolean
   */
  public Boolean getMetaDataBooleanValue() {
    return metaDataBooleanValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for meta data date value.
   *
   * @return  Date
   */
  public Date getMetaDataDateValue() {
    return metaDataDateValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for meta data decimal value.
   *
   * @return  BigDecimal
   */
  public BigDecimal getMetaDataDecimalValue() {
    return metaDataDecimalValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for meta data integer value.
   *
   * @return  Integer
   */
  public Integer getMetaDataIntegerValue() {
    return metaDataIntegerValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for meta data long value.
   *
   * @return  Long
   */
  public Long getMetaDataLongValue() {
    return metaDataLongValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for meta data string value.
   *
   * @return  String
   */
  public String getMetaDataStringValue() {
    return metaDataStringValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for meta data value.
   *
   * @return  Object
   */
  public Object getMetaDataValue() {
    String type = this.dataType;

    if ("Integer".equalsIgnoreCase(type)
          || "java.lang.Integer".equalsIgnoreCase(type)) {
      return getMetaDataIntegerValue();
    } else if ("Long".equalsIgnoreCase(type)
          || "java.lang.Long".equalsIgnoreCase(type)) {
      return getMetaDataLongValue();
    } else if ("BigDecimal".equalsIgnoreCase(type)
          || "java.math.BigDecimal".equalsIgnoreCase(type)) {
      if (StringUtils.hasText(value)) {
        try {
          return new BigDecimal(value);
        } catch (Exception e) { }
      }

      return getMetaDataDecimalValue();
    } else if ("Boolean".equalsIgnoreCase(type)
          || "java.lang.Boolean".equalsIgnoreCase(type)) {
      return getMetaDataBooleanValue();
    } else if ("Date".equalsIgnoreCase(type)
          || "java.util.Date".equalsIgnoreCase(type)) {
      return getMetaDataDateValue();
    } else if ("String".equalsIgnoreCase(type)
          || "java.lang.String".equalsIgnoreCase(type)) {
      return getMetaDataStringValue();
    }

    return null;
  } // end method getMetaDataValue

  //~ ------------------------------------------------------------------------------------------------------------------

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
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = dataType.hashCode();
    result = (31 * result) + ((value != null) ? value.hashCode() : 0);

    return result;
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
   * setter method for meta data boolean value.
   *
   * @param  metaDataBooleanValue  Boolean
   */
  public void setMetaDataBooleanValue(Boolean metaDataBooleanValue) {
    this.metaDataBooleanValue = metaDataBooleanValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for meta data date value.
   *
   * @param  metaDataDateValue  Date
   */
  public void setMetaDataDateValue(Date metaDataDateValue) {
    this.metaDataDateValue = metaDataDateValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for meta data decimal value.
   *
   * @param  metaDataDecimalValue  BigDecimal
   */
  public void setMetaDataDecimalValue(BigDecimal metaDataDecimalValue) {
    this.metaDataDecimalValue = metaDataDecimalValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for meta data integer value.
   *
   * @param  metaDataIntegerValue  Integer
   */
  public void setMetaDataIntegerValue(Integer metaDataIntegerValue) {
    this.metaDataIntegerValue = metaDataIntegerValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for meta data long value.
   *
   * @param  metaDataLongValue  Long
   */
  public void setMetaDataLongValue(Long metaDataLongValue) {
    this.metaDataLongValue = metaDataLongValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for meta data string value.
   *
   * @param  metaDataStringValue  String
   */
  public void setMetaDataStringValue(String metaDataStringValue) {
    this.metaDataStringValue = metaDataStringValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for meta data value.
   *
   * @param  value  Object
   */
  public void setMetaDataValue(Object value) {
    String type = this.dataType;
    clearValue();

    String tempValue = (value != null) ? value.toString() : null;

    if ("Integer".equalsIgnoreCase(type)
          || "java.lang.Integer".equalsIgnoreCase(type)) {
      setMetaDataIntegerValue((tempValue != null) ? new Integer(tempValue) : null);
    } else if ("Long".equalsIgnoreCase(type)
          || "java.lang.Long".equalsIgnoreCase(type)) {
      setMetaDataLongValue((tempValue != null) ? new Long(tempValue) : null);
    } else if ("BigDecimal".equalsIgnoreCase(type)
          || "java.math.BigDecimal".equalsIgnoreCase(type)) {
      setMetaDataDecimalValue((tempValue != null) ? new BigDecimal(tempValue.replaceAll(",", "")) : null);
    } else if ("Boolean".equalsIgnoreCase(type)
          || "java.lang.Boolean".equalsIgnoreCase(type)) {
      setMetaDataBooleanValue(new Boolean(tempValue));
    } else if ("Date".equalsIgnoreCase(type)
          || "java.util.Date".equalsIgnoreCase(type)) {
      if (value != null) {
        if (value instanceof Date) {
          setMetaDataDateValue((Date) value);
        } else if (value instanceof String) {
          setMetaDataDateValue((tempValue != null) ? DateUtil.toDate(tempValue) : null);
        }
      }
    } else if ("String".equalsIgnoreCase(type)
          || "java.lang.String".equalsIgnoreCase(type)) {
      setMetaDataStringValue(tempValue);
    }

    this.value = tempValue;
  } // end method setMetaDataValue

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for value.
   *
   * @param  value  String
   */
  public void setValue(String value) {
    this.value = value;
  }
} // end class BasicMetaData
