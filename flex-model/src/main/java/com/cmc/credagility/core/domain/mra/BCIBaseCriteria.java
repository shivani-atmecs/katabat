package com.cmc.credagility.core.domain.mra;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.cmc.credagility.core.domain.base.CreatorEntity;
import com.cmc.credagility.core.domain.businesscontext.BCAvailableMappingField;
import com.cmc.credagility.core.domain.businesscontext.BCVariableMetaDataField;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:pan.kang@ozstrategy.com">Pan Kang</a>
 * @version  10/15/2014 12:46
 */
@MappedSuperclass public class BCIBaseCriteria extends CreatorEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  public static final String MappingFiled = "MappingFiled";

  /** TODO: DOCUMENT ME! */
  public static final String MetaData = "MetaData";

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "bcAvailableMappingFieldId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne protected BCAvailableMappingField bcAvailableMappingField;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "bcVariableMetaDataFieldId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne protected BCVariableMetaDataField bcVariableMetaDataField;

  // AbstractBaseCriteria.MappingFiled / AbstractBaseCriteria.MetaData
  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String fieldType;


  /** Priority for the criteria. */
  @Column(nullable = false)
  private Integer priority = 1;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for bc available mapping field.
   *
   * @return  BCAvailableMappingField
   */
  public BCAvailableMappingField getBcAvailableMappingField() {
    return bcAvailableMappingField;
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
   * getter method for field type.
   *
   * @return  String
   */
  public String getFieldType() {
    return fieldType;
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
   * setter method for bc available mapping field.
   *
   * @param  bcAvailableMappingField  BCAvailableMappingField
   */
  public void setBcAvailableMappingField(BCAvailableMappingField bcAvailableMappingField) {
    this.bcAvailableMappingField = bcAvailableMappingField;
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
   * setter method for field type.
   *
   * @param  fieldType  String
   */
  public void setFieldType(String fieldType) {
    this.fieldType = fieldType;
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
} // end class BCIBaseCriteria
