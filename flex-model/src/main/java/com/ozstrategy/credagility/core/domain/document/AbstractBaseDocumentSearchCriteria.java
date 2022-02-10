package com.ozstrategy.credagility.core.domain.document;

import com.cmc.credagility.core.domain.variable.Variable;
import com.ozstrategy.credagility.core.domain.CreatorEntity;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;


/**
 * DocumentSearchCriteria Abstract Class.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/16/2014 11:23
 */
@MappedSuperclass public class AbstractBaseDocumentSearchCriteria extends CreatorEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  public static final String MappingFiled = "MappingFiled";


  /** TODO: DOCUMENT ME! */
  public static final String MetaData = "MetaData";

  //~ Instance fields --------------------------------------------------------------------------------------------------

  // AbstractBaseDocumentSearchCriteria.MappingFiled / AbstractBaseDocumentSearchCriteria.MetaData
  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String fieldType;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "mappingFieldId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne protected DocumentSearchMappingField mappingField;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "metaDataFieldId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne protected Variable metaDataField;


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
   * @return  DocumentSearchMappingField
   */
  public DocumentSearchMappingField getMappingField() {
    return mappingField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for meta data field.
   *
   * @return  Variable
   */
  public Variable getMetaDataField() {
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
   * @param  mappingField  DocumentSearchMappingField
   */
  public void setMappingField(DocumentSearchMappingField mappingField) {
    this.mappingField = mappingField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for meta data field.
   *
   * @param  metaDataField  Variable
   */
  public void setMetaDataField(Variable metaDataField) {
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
} // end class AbstractBaseDocumentSearchCriteria
