package com.cmc.credagility.core.domain.mra;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.cmc.credagility.core.domain.account.AccountMetaDataField;
import com.cmc.credagility.core.domain.base.CreatorEntity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:pan.kang@ozstrategy.com">Pan Kang</a>
 * @version  10/14/2014 17:39
 */
@MappedSuperclass public abstract class AbstractBaseCriteria extends CreatorEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  public static final String MappingFiled = "MappingFiled";

  /** TODO: DOCUMENT ME! */
  public static final String MetaData = "MetaData";

  //~ Instance fields --------------------------------------------------------------------------------------------------

  // AbstractBaseCriteria.MappingFiled / AbstractBaseCriteria.MetaData
  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String fieldType;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "mappingFieldId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne protected QueueAccountMappingField mappingField;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "metaDataFieldId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne protected AccountMetaDataField metaDataField;


  /** Priority for the criteria. */
  @Column(nullable = false)
  private Integer priority = 1;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for field type.
   *
   * @return  String
   */
  public String getFieldType() {
    return fieldType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for mapping field.
   *
   * @return  QueueAccountMappingField
   */
  public QueueAccountMappingField getMappingField() {
    return mappingField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for meta data field.
   *
   * @return  AccountMetaDataField
   */
  public AccountMetaDataField getMetaDataField() {
    return metaDataField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for priority.
   *
   * @return  Integer
   */
  public Integer getPriority() {
    return priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for field type.
   *
   * @param  fieldType  String
   */
  public void setFieldType(String fieldType) {
    this.fieldType = fieldType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for mapping field.
   *
   * @param  mappingField  QueueAccountMappingField
   */
  public void setMappingField(QueueAccountMappingField mappingField) {
    this.mappingField = mappingField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for meta data field.
   *
   * @param  metaDataField  AccountMetaDataField
   */
  public void setMetaDataField(AccountMetaDataField metaDataField) {
    this.metaDataField = metaDataField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for priority.
   *
   * @param  priority  Integer
   */
  public void setPriority(Integer priority) {
    this.priority = priority;
  }
} // end class AbstractBaseCriteria
