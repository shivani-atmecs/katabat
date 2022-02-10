package com.cmc.credagility.core.domain.mra;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.cmc.credagility.core.domain.agency.AgencyMetaDataField;
import com.cmc.credagility.core.domain.agency.AgencyQueueMappingField;
import com.cmc.credagility.core.domain.base.CreatorEntity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:pan.kang@ozstrategy.com">Pan Kang</a>
 * @version  10/15/2014 12:34
 */
@MappedSuperclass public class AgencyBaseCriteria extends CreatorEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  public static final String MappingFiled = "MappingFiled";

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "agencyMetaDataFieldId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne protected AgencyMetaDataField agencyMetaDataField;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "agencyQueueMappingFieldId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne protected AgencyQueueMappingField agencyQueueMappingField;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String fieldType;

  /** Priority for the criteria. */
  @Column(nullable = false)
  private Integer priority = 1;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for mapping filed.
   *
   * @return  String
   */
  public static String getMappingFiled() {
    return MappingFiled;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agency meta data field.
   *
   * @return  AgencyMetaDataField
   */
  public AgencyMetaDataField getAgencyMetaDataField() {
    return agencyMetaDataField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agency queue mapping field.
   *
   * @return  AgencyQueueMappingField
   */
  public AgencyQueueMappingField getAgencyQueueMappingField() {
    return agencyQueueMappingField;
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
   * setter method for agency meta data field.
   *
   * @param  agencyMetaDataField  AgencyMetaDataField
   */
  public void setAgencyMetaDataField(AgencyMetaDataField agencyMetaDataField) {
    this.agencyMetaDataField = agencyMetaDataField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agency queue mapping field.
   *
   * @param  agencyQueueMappingField  AgencyQueueMappingField
   */
  public void setAgencyQueueMappingField(AgencyQueueMappingField agencyQueueMappingField) {
    this.agencyQueueMappingField = agencyQueueMappingField;
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
} // end class AgencyBaseCriteria
