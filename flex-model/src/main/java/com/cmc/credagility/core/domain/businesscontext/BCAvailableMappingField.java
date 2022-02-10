package com.cmc.credagility.core.domain.businesscontext;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.cmc.credagility.core.domain.base.CreatorEntity;
import com.cmc.credagility.core.domain.type.MetaDataValueType;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 10:47
 */
@Entity public class BCAvailableMappingField extends CreatorEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "businessContextId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected BusinessContext businessContext;

  /** TODO: DOCUMENT ME! */
  @Column(
    length   = 32,
    nullable = false
  )
  protected String businessDataType;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String dataType;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String displayName;

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String mappingField;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String mappingTable;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String tableAlias;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * detectDataType.
   */
  public void detectDataType() {
    if ("String".equalsIgnoreCase(businessDataType)) {
      dataType = MetaDataValueType.STRING.getStrValue();
    } else if ("Currency".equalsIgnoreCase(businessDataType)) {
      dataType = MetaDataValueType.BIGDECIMAL.getStrValue();
    } else if ("Percentage".equalsIgnoreCase(businessDataType)) {
      dataType = MetaDataValueType.BIGDECIMAL.getStrValue();
    } else if ("Decimal".equalsIgnoreCase(businessDataType)) {
      dataType = MetaDataValueType.BIGDECIMAL.getStrValue();
    } else if ("Integer".equalsIgnoreCase(businessDataType)) {
      dataType = MetaDataValueType.LONG.getStrValue();
    } else if ("Boolean".equalsIgnoreCase(businessDataType)) {
      dataType = MetaDataValueType.BOOLEAN.getStrValue();
    } else if ("Date".equalsIgnoreCase(businessDataType)) {
      dataType = MetaDataValueType.DATE.getStrValue();
    } else if ("Text".equalsIgnoreCase(businessDataType)) {
      dataType = MetaDataValueType.TEXT.getStrValue();
    } else if ("Float".equalsIgnoreCase(businessDataType) || "Double".equalsIgnoreCase(businessDataType)) {
      dataType = MetaDataValueType.BIGDECIMAL.getStrValue();
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for business context.
   *
   * @return  BusinessContext
   */
  public BusinessContext getBusinessContext() {
    return businessContext;
  }

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
   * getter method for display name.
   *
   * @return  String
   */
  public String getDisplayName() {
    return displayName;
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
   * getter method for mapping field.
   *
   * @return  String
   */
  public String getMappingField() {
    return mappingField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for mapping table.
   *
   * @return  String
   */
  public String getMappingTable() {
    return mappingTable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for table alias.
   *
   * @return  String
   */
  public String getTableAlias() {
    return tableAlias;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for business context.
   *
   * @param  businessContext  BusinessContext
   */
  public void setBusinessContext(BusinessContext businessContext) {
    this.businessContext = businessContext;
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
   * setter method for display name.
   *
   * @param  displayName  String
   */
  public void setDisplayName(String displayName) {
    this.displayName = displayName;
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
   * setter method for mapping field.
   *
   * @param  mappingField  String
   */
  public void setMappingField(String mappingField) {
    this.mappingField = mappingField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for mapping table.
   *
   * @param  mappingTable  String
   */
  public void setMappingTable(String mappingTable) {
    this.mappingTable = mappingTable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for table alias.
   *
   * @param  tableAlias  String
   */
  public void setTableAlias(String tableAlias) {
    this.tableAlias = tableAlias;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * update.
   *
   * @param  field  BCAvailableMappingField
   */
  public void update(BCAvailableMappingField field) {
    this.mappingTable     = field.getMappingTable();
    this.tableAlias       = field.getTableAlias();
    this.mappingField     = field.getMappingField();
    this.dataType         = field.getDataType();
    this.businessDataType = field.getBusinessDataType();
    this.displayName      = field.getDisplayName();
    this.lastUpdateDate   = field.getLastUpdateDate();
    this.lastUpdater      = field.getLastUpdater();
    this.businessContext  = field.getBusinessContext();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * update.
   *
   * @param  bcMetaDataField  BCMetaDataField
   */
  public void update(BCMetaDataField bcMetaDataField) {
    this.setMappingTable("BCIMetaDataValue");
    this.setTableAlias("bcimdv");
    this.setBusinessDataType(bcMetaDataField.getBusinessDataType());
    this.setDisplayName(bcMetaDataField.getDisplayName());
    this.setMappingField(bcMetaDataField.getFieldName());
    this.setCreator(bcMetaDataField.getCreator());
    this.setBusinessContext(bcMetaDataField.getBusinessContext());
    this.detectDataType();

  }
} // end class BCAvailableMappingField
