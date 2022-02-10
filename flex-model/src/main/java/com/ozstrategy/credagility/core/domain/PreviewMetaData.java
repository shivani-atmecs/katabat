package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.domain.type.MetaDataValueType;
import com.ozstrategy.credagility.core.converter.StringBooleanConverter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/16/2014 13:59
 */
@Entity
@Table(
  name              = "PreviewMetaData",
  uniqueConstraints = { @UniqueConstraint(columnNames = { "responsibleId", "previewMetaDataId" }) }
)
public class PreviewMetaData extends CreatorEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 4149739284317745434L;

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
    length   = 2048,
    nullable = true
  )
  public String metaDataStringValue;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "metaDataValue",
    nullable = true,
    length   = 255
  )
  public String metaDataValue;


  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "metaDataBooleanValue",
    nullable         = true,
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean metaDataBooleanValue;

  /** Meta Data Value Type. */
  @Column(
    name     = "type",
    nullable = false,
    length   = 255
  )
  @Enumerated(value = EnumType.STRING)
  protected MetaDataValueType metaDataType;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "previewMetaDataFieldId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected PreviewMetaDataField previewMetaDataField;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "previewMetaDataId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long previewMetaDataId;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "responsibleId",
    insertable = true,
    updatable  = false,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Responsible responsible;

  //~ Methods ----------------------------------------------------------------------------------------------------------

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
   * getter method for meta data type.
   *
   * @return  MetaDataValueType
   */
  public MetaDataValueType getMetaDataType() {
    return metaDataType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for meta data value.
   *
   * @return  String
   */
  public String getMetaDataValue() {
    return metaDataValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for preview meta data field.
   *
   * @return  PreviewMetaDataField
   */
  public PreviewMetaDataField getPreviewMetaDataField() {
    return previewMetaDataField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for preview meta data id.
   *
   * @return  Long
   */
  public Long getPreviewMetaDataId() {
    return previewMetaDataId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible.
   *
   * @return  Responsible
   */
  public Responsible getResponsible() {
    return responsible;
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
   * setter method for meta data type.
   *
   * @param  metaDataType  MetaDataValueType
   */
  public void setMetaDataType(MetaDataValueType metaDataType) {
    this.metaDataType = metaDataType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for meta data value.
   *
   * @param  metaDataValue  String
   */
  public void setMetaDataValue(String metaDataValue) {
    this.metaDataValue = metaDataValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for preview meta data field.
   *
   * @param  previewMetaDataField  PreviewMetaDataField
   */
  public void setPreviewMetaDataField(PreviewMetaDataField previewMetaDataField) {
    this.previewMetaDataField = previewMetaDataField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for preview meta data id.
   *
   * @param  previewMetaDataId  Long
   */
  public void setPreviewMetaDataId(Long previewMetaDataId) {
    this.previewMetaDataId = previewMetaDataId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for responsible.
   *
   * @param  responsible  Responsible
   */
  public void setResponsible(Responsible responsible) {
    this.responsible = responsible;
  }
} // end class PreviewMetaData
