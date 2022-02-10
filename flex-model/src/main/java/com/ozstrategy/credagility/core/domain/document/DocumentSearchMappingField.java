package com.ozstrategy.credagility.core.domain.document;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * This class is used to store DocumentSearchMappingField information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/16/2014 14:17
 */
@Entity public class DocumentSearchMappingField implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 7273481253301567216L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** data business type: ex. Percentage, Amount... */
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
   * @param  field  DocumentSearchMappingField
   */
  public void update(DocumentSearchMappingField field) {
    this.mappingTable     = field.getMappingTable();
    this.tableAlias       = field.getTableAlias();
    this.mappingField     = field.getMappingField();
    this.dataType         = field.getDataType();
    this.businessDataType = field.getBusinessDataType();
    this.displayName      = field.getDisplayName();
  }
} // end class DocumentSearchMappingField
