package com.cmc.credagility.core.domain.businesscontext;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 11:23
 */
@Entity
@Table(
  name              = "BCIVariableMetaData",
  uniqueConstraints = { @UniqueConstraint(columnNames = { "businessContextInstanceId", "bcVariableMetaDataFieldId" }) },
  indexes           = {
    @Index(
      columnList    = "metaDataBooleanValue",
      name          = "meta_boolean_value_idx"
    ),
    @Index(
      columnList    = "metaDataDateValue",
      name          = "meta_date_value_idx"
    ),
    @Index(
      columnList    = "metaDataDecimalValue",
      name          = "meta_decimal_value_idx"
    ),
    @Index(
      columnList    = "metaDataIntegerValue",
      name          = "meta_integer_value_idx"
    ),
    @Index(
      columnList    = "metaDataLongValue",
      name          = "meta_long_value_idx"
    )
  }
)
public class BCIVariableMetaData extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -3981107905640508590L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1,
    name             = "metaDataBooleanValue",
    nullable         = true
  )
  @Convert(converter = StringBooleanConverter.class)
  public Boolean metaDataBooleanValue;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "metaDataDateValue",
    nullable = true
  )
  @Temporal(TemporalType.TIMESTAMP)
  public Date metaDataDateValue;

  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "metaDataDecimalValue",
    nullable  = true,
    precision = 19,
    scale     = 8
  )
  public BigDecimal metaDataDecimalValue;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "metaDataIntegerValue",
    nullable = true
  )
  public Integer metaDataIntegerValue;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "metaDataLongValue",
    nullable = true
  )
  public Long metaDataLongValue;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "metaDataStringValue",
    nullable = true,
    length   = 2048
  )
  public String metaDataStringValue;

  /** TODO: DOCUMENT ME! */
  @OneToOne(
    mappedBy = "bciVariableMetaData",
    cascade  = { CascadeType.REMOVE, CascadeType.ALL }
  )
  protected BCIVariableMetaDataValueBoolean bciVariableMetaDataValueBoolean = null;

  /** TODO: DOCUMENT ME! */
  @OneToOne(
    mappedBy = "bciVariableMetaData",
    cascade  = { CascadeType.REMOVE, CascadeType.ALL }
  )
  protected BCIVariableMetaDataValueDate bciVariableMetaDataValueDate = null;

  /** TODO: DOCUMENT ME! */
  @OneToOne(
    mappedBy = "bciVariableMetaData",
    cascade  = { CascadeType.REMOVE, CascadeType.ALL }
  )
  protected BCIVariableMetaDataValueDecimal bciVariableMetaDataValueDecimal = null;

  /** TODO: DOCUMENT ME! */
  @OneToOne(
    mappedBy = "bciVariableMetaData",
    cascade  = { CascadeType.REMOVE, CascadeType.ALL }
  )
  protected BCIVariableMetaDataValueInteger bciVariableMetaDataValueInteger = null;

  /** TODO: DOCUMENT ME! */
  @OneToOne(
    mappedBy = "bciVariableMetaData",
    cascade  = { CascadeType.REMOVE, CascadeType.ALL }
  )
  protected BCIVariableMetaDataValueLong bciVariableMetaDataValueLong = null;

  /** TODO: DOCUMENT ME! */
  @OneToOne(
    mappedBy = "bciVariableMetaData",
    cascade  = { CascadeType.REMOVE, CascadeType.ALL }
  )
  protected BCIVariableMetaDataValueString bciVariableMetaDataValueString = null;

  /** TODO: DOCUMENT ME! */
  @OneToOne(
    mappedBy = "bciVariableMetaData",
    cascade  = { CascadeType.REMOVE, CascadeType.ALL }
  )
  protected BCIVariableMetaDataValueText bciVariableMetaDataValueText = null;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "bcVariableMetaDataFieldId",
    insertable = true,
    updatable  = false,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected BCVariableMetaDataField bcVariableMetaDataField;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "businessContextInstanceId",
    insertable = true,
    updatable  = false,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BusinessContextInstance businessContextInstance;

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @Lob protected String textValue;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "value",
    length   = 2048,
    nullable = true
  )
  protected String value;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
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

    BCIVariableMetaData that = (BCIVariableMetaData) o;

    if ((bcVariableMetaDataField != null) ? (!bcVariableMetaDataField.equals(that.bcVariableMetaDataField))
                                          : (that.bcVariableMetaDataField != null)) {
      return false;
    }

    if ((businessContextInstance != null) ? (!businessContextInstance.equals(that.businessContextInstance))
                                          : (that.businessContextInstance != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bci variable meta data value boolean.
   *
   * @return  BCIVariableMetaDataValueBoolean
   */
  public BCIVariableMetaDataValueBoolean getBciVariableMetaDataValueBoolean() {
    return bciVariableMetaDataValueBoolean;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bci variable meta data value date.
   *
   * @return  BCIVariableMetaDataValueDate
   */
  public BCIVariableMetaDataValueDate getBciVariableMetaDataValueDate() {
    return bciVariableMetaDataValueDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bci variable meta data value decimal.
   *
   * @return  BCIVariableMetaDataValueDecimal
   */
  public BCIVariableMetaDataValueDecimal getBciVariableMetaDataValueDecimal() {
    return bciVariableMetaDataValueDecimal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bci variable meta data value integer.
   *
   * @return  BCIVariableMetaDataValueInteger
   */
  public BCIVariableMetaDataValueInteger getBciVariableMetaDataValueInteger() {
    return bciVariableMetaDataValueInteger;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bci variable meta data value long.
   *
   * @return  BCIVariableMetaDataValueLong
   */
  public BCIVariableMetaDataValueLong getBciVariableMetaDataValueLong() {
    return bciVariableMetaDataValueLong;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bci variable meta data value string.
   *
   * @return  BCIVariableMetaDataValueString
   */
  public BCIVariableMetaDataValueString getBciVariableMetaDataValueString() {
    return bciVariableMetaDataValueString;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bci variable meta data value text.
   *
   * @return  BCIVariableMetaDataValueText
   */
  public BCIVariableMetaDataValueText getBciVariableMetaDataValueText() {
    return bciVariableMetaDataValueText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bc variable meta data field.
   *
   * @return  BCVariableMetaDataField
   */
  public BCVariableMetaDataField getBcVariableMetaDataField() {
    return bcVariableMetaDataField;
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
   * getter method for id.
   *
   * @return  Long
   */
  public Long getId() {
    return id;
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
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = 31;
    result = (31 * result) + ((bcVariableMetaDataField != null) ? bcVariableMetaDataField.hashCode() : 0);
    result = (31 * result) + ((businessContextInstance != null) ? businessContextInstance.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bci variable meta data value boolean.
   *
   * @param  bciVariableMetaDataValueBoolean  BCIVariableMetaDataValueBoolean
   */
  public void setBciVariableMetaDataValueBoolean(BCIVariableMetaDataValueBoolean bciVariableMetaDataValueBoolean) {
    this.bciVariableMetaDataValueBoolean = bciVariableMetaDataValueBoolean;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bci variable meta data value date.
   *
   * @param  bciVariableMetaDataValueDate  BCIVariableMetaDataValueDate
   */
  public void setBciVariableMetaDataValueDate(BCIVariableMetaDataValueDate bciVariableMetaDataValueDate) {
    this.bciVariableMetaDataValueDate = bciVariableMetaDataValueDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bci variable meta data value decimal.
   *
   * @param  bciVariableMetaDataValueDecimal  BCIVariableMetaDataValueDecimal
   */
  public void setBciVariableMetaDataValueDecimal(BCIVariableMetaDataValueDecimal bciVariableMetaDataValueDecimal) {
    this.bciVariableMetaDataValueDecimal = bciVariableMetaDataValueDecimal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bci variable meta data value integer.
   *
   * @param  bciVariableMetaDataValueInteger  BCIVariableMetaDataValueInteger
   */
  public void setBciVariableMetaDataValueInteger(BCIVariableMetaDataValueInteger bciVariableMetaDataValueInteger) {
    this.bciVariableMetaDataValueInteger = bciVariableMetaDataValueInteger;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bci variable meta data value long.
   *
   * @param  bciVariableMetaDataValueLong  BCIVariableMetaDataValueLong
   */
  public void setBciVariableMetaDataValueLong(BCIVariableMetaDataValueLong bciVariableMetaDataValueLong) {
    this.bciVariableMetaDataValueLong = bciVariableMetaDataValueLong;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bci variable meta data value string.
   *
   * @param  bciVariableMetaDataValueString  BCIVariableMetaDataValueString
   */
  public void setBciVariableMetaDataValueString(BCIVariableMetaDataValueString bciVariableMetaDataValueString) {
    this.bciVariableMetaDataValueString = bciVariableMetaDataValueString;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bci variable meta data value text.
   *
   * @param  bciVariableMetaDataValueText  BCIVariableMetaDataValueText
   */
  public void setBciVariableMetaDataValueText(BCIVariableMetaDataValueText bciVariableMetaDataValueText) {
    this.bciVariableMetaDataValueText = bciVariableMetaDataValueText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bc variable meta data field.
   *
   * @param  bcVariableMetaDataField  BCVariableMetaDataField
   */
  public void setBcVariableMetaDataField(BCVariableMetaDataField bcVariableMetaDataField) {
    this.bcVariableMetaDataField = bcVariableMetaDataField;
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
   * setter method for id.
   *
   * @param  id  Long
   */
  public void setId(Long id) {
    this.id = id;
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
   * updateMetaData.
   *
   * @param  metaData  BCIVariableMetaData
   */
  public void updateMetaData(BCIVariableMetaData metaData) {
    this.businessContextInstance         = metaData.getBusinessContextInstance();
    this.bcVariableMetaDataField         = metaData.getBcVariableMetaDataField();
    this.bciVariableMetaDataValueBoolean = metaData.getBciVariableMetaDataValueBoolean();
    this.bciVariableMetaDataValueDate    = metaData.getBciVariableMetaDataValueDate();
    this.bciVariableMetaDataValueDecimal = metaData.getBciVariableMetaDataValueDecimal();
    this.bciVariableMetaDataValueInteger = metaData.getBciVariableMetaDataValueInteger();
    this.bciVariableMetaDataValueLong    = metaData.getBciVariableMetaDataValueLong();
    this.bciVariableMetaDataValueString  = metaData.getBciVariableMetaDataValueString();
    this.bciVariableMetaDataValueText    = metaData.getBciVariableMetaDataValueText();
  }
} // end class BCIVariableMetaData
