package com.cmc.credagility.core.domain.businesscontext;

import com.cmc.credagility.core.domain.base.CreatorEntity;
import com.cmc.credagility.core.domain.type.MetaDataValueType;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.workflow.BCMetaDataFieldItem;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 11:00
 */
@Entity
@Table(
  indexes = {
    @Index(
      columnList = "booleanValue",
      name = "booleanValueIndex"
    ),
    @Index(
      columnList = "dateValue",
      name = "dateValueIndex"
    ),
    @Index(
      columnList = "decimalValue",
      name = "decimalValueIndex"
    ),
    @Index(
      columnList = "fieldName",
      name = "fieldNameIndex"
    ),
    @Index(
      columnList = "intValue",
      name = "intValueIndex"
    ),
    @Index(
      columnList = "longValue",
      name = "longValueIndex"
    )
  }
)
public class BCIMetaDataValue extends CreatorEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 342610149912798102L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean booleanValue;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "businessContextInstanceId")
  @ManyToOne protected BusinessContextInstance businessContextInstance;

  /** TODO: DOCUMENT ME! */
  @Temporal(TemporalType.TIMESTAMP)
  protected Date dateValue;

  /** TODO: DOCUMENT ME! */
  @Column(
    precision = 19,
    scale     = 8
  )
  protected BigDecimal decimalValue;

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = false,
    length   = 255
  )
  protected String fieldName;

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @Column protected Integer intValue;

  /** TODO: DOCUMENT ME! */
  @Column protected Long longValue;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "metaDataFieldId")
  @ManyToOne protected BCMetaDataField metaDataField;

  /** TODO: DOCUMENT ME! */
  @Column(length = 2048)
  protected String stringValue;

  /** TODO: DOCUMENT ME! */
  @Lob protected String textValue;

  /** TODO: DOCUMENT ME! */
  @Lob
  protected String          value;
  @Transient private String oldValue;

  @Transient private boolean valueChanged = false;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof BCIMetaDataValue)) {
      return false;
    }

    BCIMetaDataValue that = (BCIMetaDataValue) o;

    if ((booleanValue != null) ? (!booleanValue.equals(that.booleanValue)) : (that.booleanValue != null)) {
      return false;
    }

    if ((businessContextInstance != null) ? (!businessContextInstance.equals(that.businessContextInstance))
                                          : (that.businessContextInstance != null)) {
      return false;
    }

    if ((dateValue != null) ? (!dateValue.equals(that.dateValue)) : (that.dateValue != null)) {
      return false;
    }

    if ((decimalValue != null) ? (!decimalValue.equals(that.decimalValue)) : (that.decimalValue != null)) {
      return false;
    }

    if ((intValue != null) ? (!intValue.equals(that.intValue)) : (that.intValue != null)) {
      return false;
    }

    if ((longValue != null) ? (!longValue.equals(that.longValue)) : (that.longValue != null)) {
      return false;
    }

    if ((metaDataField != null) ? (!metaDataField.equals(that.metaDataField)) : (that.metaDataField != null)) {
      return false;
    }

    if ((fieldName != null) ? (!fieldName.equals(that.fieldName)) : (that.fieldName != null)) {
      return false;
    }


    if ((stringValue != null) ? (!stringValue.equals(that.stringValue)) : (that.stringValue != null)) {
      return false;
    }

    if ((textValue != null) ? (!textValue.equals(that.textValue)) : (that.textValue != null)) {
      return false;
    }

    if ((value != null) ? (!value.equals(that.value)) : (that.value != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for boolean value.
   *
   * @return  Boolean
   */
  public Boolean getBooleanValue() {
    return booleanValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for business context instance.
   *
   * @return  BusinessContextInstance
   */
  public BusinessContextInstance getBusinessContextInstance() {
    return businessContextInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for date value.
   *
   * @return  Date
   */
  public Date getDateValue() {
    return dateValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for decimal value.
   *
   * @return  BigDecimal
   */
  public BigDecimal getDecimalValue() {
    return decimalValue;
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
   * getter method for int value.
   *
   * @return  Integer
   */
  public Integer getIntValue() {
    return intValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for long value.
   *
   * @return  Long
   */
  public Long getLongValue() {
    return longValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for meta data field.
   *
   * @return  BCMetaDataField
   */
  public BCMetaDataField getMetaDataField() {
    return metaDataField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for old value.
   *
   * @return  String
   */
  public String getOldValue() {
    return oldValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for safe null value by type.
   *
   * @return  String
   */
  public String getSafeNullValueByType() {
    Object val = null;

    if (MetaDataValueType.BOOLEAN.equals(metaDataField.getType())) {
      val = this.getBooleanValue();
    } else if (MetaDataValueType.STRING.equals(metaDataField.getType())) {
      val = this.getStringValue();
    } else if (MetaDataValueType.TEXT.equals(metaDataField.getType())) {
      val = this.getTextValue();
    } else if (MetaDataValueType.DATE.equals(metaDataField.getType())) {
      val = this.getDateValue();
    } else if (MetaDataValueType.INTEGER.equals(metaDataField.getType())) {
      val = this.getIntValue();
    } else if (MetaDataValueType.BIGDECIMAL.equals(metaDataField.getType())) {
      val = this.getDecimalValue();
    } else if (MetaDataValueType.LONG.equals(metaDataField.getType())) {
      val = this.getLongValue();
    }else if (MetaDataValueType.EXTERNALENTITY.equals(metaDataField.getType())) {
      val = this.getLongValue();
    }
    

    if (val == null) {
      return null;
    }

    return String.valueOf(val);
  } // end method getSafeNullValueByType

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for string value.
   *
   * @return  String
   */
  public String getStringValue() {
    return stringValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for text value.
   *
   * @return  String
   */
  public String getTextValue() {
    return textValue;
  }

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
   * getter method for value by type.
   *
   * @return  String
   */
  public String getValueByType() {
    if (MetaDataValueType.BOOLEAN.equals(metaDataField.getType())) {
      return String.valueOf(this.getBooleanValue());
    } else if (MetaDataValueType.STRING.equals(metaDataField.getType())) {
      return this.getStringValue();
    } else if (MetaDataValueType.TEXT.equals(metaDataField.getType())) {
      return this.getTextValue();
    } else if (MetaDataValueType.DATE.equals(metaDataField.getType())) {
      return String.valueOf(this.getDateValue());
    } else if (MetaDataValueType.INTEGER.equals(metaDataField.getType())) {
      return String.valueOf(this.getIntValue());
    } else if (MetaDataValueType.BIGDECIMAL.equals(metaDataField.getType())) {
      return String.valueOf(this.getDecimalValue());
    } else if (MetaDataValueType.LONG.equals(metaDataField.getType())) {
      return String.valueOf(this.getLongValue());
    } else if (MetaDataValueType.EXTERNALENTITY.equals(metaDataField.getType())) {
      return String.valueOf(this.getLongValue());
    }

    return "";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = 31;
    result = (31 * result) + ((booleanValue != null) ? booleanValue.hashCode() : 0);
    result = (31 * result) + ((businessContextInstance != null) ? businessContextInstance.hashCode() : 0);
    result = (31 * result) + ((dateValue != null) ? dateValue.hashCode() : 0);
    result = (31 * result) + ((decimalValue != null) ? decimalValue.hashCode() : 0);
    result = (31 * result) + ((intValue != null) ? intValue.hashCode() : 0);
    result = (31 * result) + ((longValue != null) ? longValue.hashCode() : 0);
    result = (31 * result) + ((metaDataField != null) ? metaDataField.hashCode() : 0);
    result = (31 * result) + ((fieldName != null) ? fieldName.hashCode() : 0);
    result = (31 * result) + ((stringValue != null) ? stringValue.hashCode() : 0);
    result = (31 * result) + ((textValue != null) ? textValue.hashCode() : 0);
    result = (31 * result) + ((value != null) ? value.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for value changed.
   *
   * @return  boolean
   */
  public boolean isValueChanged() {
    return valueChanged;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for boolean value.
   *
   * @param  booleanValue  Boolean
   */
  public void setBooleanValue(Boolean booleanValue) {
    this.booleanValue = booleanValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for business context instance.
   *
   * @param  businessContextInstance  BusinessContextInstance
   */
  public void setBusinessContextInstance(BusinessContextInstance businessContextInstance) {
    this.businessContextInstance = businessContextInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for business meta data value.
   *
   * @param  valueObj  BCMetaDataFieldItem
   */
  public void setBusinessMetaDataValue(BCMetaDataFieldItem valueObj) {
    if (MetaDataValueType.BOOLEAN.equals(metaDataField.getType())) {
      this.setBooleanValue(valueObj.getBooleanValue());
    } else if (MetaDataValueType.STRING.equals(metaDataField.getType())) {
      this.setStringValue(valueObj.getValue());
    } else if (MetaDataValueType.TEXT.equals(metaDataField.getType())) {
      this.setTextValue(valueObj.getValue());
    } else if (MetaDataValueType.DATE.equals(metaDataField.getType())) {
      this.setDateValue(valueObj.getDateValue());
    } else if (MetaDataValueType.INTEGER.equals(metaDataField.getType())) {
      this.setIntValue(valueObj.getIntValue());
    } else if (MetaDataValueType.BIGDECIMAL.equals(metaDataField.getType())) {
      this.setDecimalValue(valueObj.getDecimalValue());
    } else if (MetaDataValueType.LONG.equals(metaDataField.getType())) {
      this.setLongValue(valueObj.getLongValue());
    } else if (MetaDataValueType.EXTERNALENTITY.equals(metaDataField.getType())) {
      this.setLongValue(valueObj.getLongValue());
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for date value.
   *
   * @param  dateValue  Date
   */
  public void setDateValue(Date dateValue) {
    this.dateValue = dateValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for decimal value.
   *
   * @param  decimalValue  BigDecimal
   */
  public void setDecimalValue(BigDecimal decimalValue) {
    this.decimalValue = decimalValue;
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
   * setter method for int value.
   *
   * @param  intValue  Integer
   */
  public void setIntValue(Integer intValue) {
    this.intValue = intValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for long value.
   *
   * @param  longValue  Long
   */
  public void setLongValue(Long longValue) {
    this.longValue = longValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for meta data field.
   *
   * @param  metaDataField  BCMetaDataField
   */
  public void setMetaDataField(BCMetaDataField metaDataField) {
    this.metaDataField = metaDataField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for string value.
   *
   * @param  stringValue  String
   */
  public void setStringValue(String stringValue) {
    this.stringValue = stringValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for text value.
   *
   * @param  textValue  String
   */
  public void setTextValue(String textValue) {
    this.textValue = textValue;
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

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.CreatorEntity#toString()
   */
  @Override public String toString() {
    return "BCIMetaDataValue{"
      + "id=" + id
      + ", businessContextInstance=" + businessContextInstance
      + ", metaDataField=" + metaDataField
      + ", fieldName='" + fieldName + '\''
      + ", value='" + value + '\''
      + ", booleanValue=" + booleanValue
      + ", dateValue=" + dateValue
      + ", decimalValue=" + decimalValue
      + ", intValue=" + intValue
      + ", longValue=" + longValue
      + ", stringValue='" + stringValue + '\''
      + ", textValue='" + textValue + '\''
      + '}';
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * update.
   *
   * @param  item  BCMetaDataFieldItem
   */
  public void update(BCMetaDataFieldItem item) {
    if (MetaDataValueType.BOOLEAN.equals(metaDataField.getType())) {
      if (!valueEquals(this.booleanValue, item.getBooleanValue())) {
        this.valueChanged = true;
        this.oldValue     = (this.booleanValue == null) ? null : this.booleanValue.toString();
      }

      this.setBooleanValue(item.getBooleanValue());
    } else if (MetaDataValueType.STRING.equals(metaDataField.getType())) {
      if (!valueEquals(this.stringValue, item.getValue())) {
        this.valueChanged = true;
        this.oldValue     = (this.stringValue == null) ? null : this.stringValue.toString();
      }

      this.setStringValue(item.getValue());
    } else if (MetaDataValueType.DATE.equals(metaDataField.getType())) {
      if (!valueEquals(this.dateValue, item.getDateValue())) {
        this.valueChanged = true;
        this.oldValue     = (this.dateValue == null) ? null : this.dateValue.toString();
      }

      this.setDateValue(item.getDateValue());
    } else if (MetaDataValueType.INTEGER.equals(metaDataField.getType())) {
      if (!valueEquals(this.intValue, item.getIntValue())) {
        this.valueChanged = true;
        this.oldValue     = (this.intValue == null) ? null : this.intValue.toString();
      }

      this.setIntValue(item.getIntValue());
    } else if (MetaDataValueType.BIGDECIMAL.equals(metaDataField.getType())) {
      if (!valueEquals(this.decimalValue, item.getDecimalValue())) {
        this.valueChanged = true;
        this.oldValue     = (this.decimalValue == null) ? null : this.decimalValue.toString();
      }

      this.setDecimalValue(item.getDecimalValue());
    } else if (MetaDataValueType.LONG.equals(metaDataField.getType())) {
      if (!valueEquals(this.longValue, item.getLongValue())) {
        this.valueChanged = true;
        this.oldValue     = (this.longValue == null) ? null : this.longValue.toString();
      }

      this.setLongValue(item.getLongValue());
    } else if (MetaDataValueType.TEXT.equals(metaDataField.getType())) {
      if (!valueEquals(this.textValue, item.getValue())) {
        this.valueChanged = true;
        this.oldValue     = (this.textValue == null) ? null : this.textValue.toString();
      }

      this.setTextValue(item.getValue());
    } // end if-else
    else if (MetaDataValueType.EXTERNALENTITY.equals(metaDataField.getType())) {
      if (!valueEquals(this.longValue, item.getLongValue())) {
        this.valueChanged = true;
        this.oldValue     = (this.longValue == null) ? null : this.longValue.toString();
      }

      this.setLongValue(item.getLongValue());
    }
  }   // end method update

  //~ ------------------------------------------------------------------------------------------------------------------

  private boolean valueEquals(Object v1, Object v2) {
    if ((v1 == null) && (v2 == null)) {
      return true;
    } else {
      if ((v1 == null) || (v2 == null)) {
        return false;
      }

      return v1.equals(v2);
    }
  }
} // end class BCIMetaDataValue
