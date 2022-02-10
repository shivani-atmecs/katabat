package com.cmc.credagility.core.domain.export;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;

import com.ozstrategy.credagility.core.domain.CreatorEntity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/15/2014 13:16
 */
@Entity public class AvailableAccountExportLayoutMappingField extends CreatorEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

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

    if (!super.equals(o)) {
      return false;
    }

    AvailableAccountExportLayoutMappingField that = (AvailableAccountExportLayoutMappingField) o;

    if ((businessDataType != null) ? (!businessDataType.equals(that.businessDataType))
                                   : (that.businessDataType != null)) {
      return false;
    }

    if ((dataType != null) ? (!dataType.equals(that.dataType)) : (that.dataType != null)) {
      return false;
    }

    if ((displayName != null) ? (!displayName.equals(that.displayName)) : (that.displayName != null)) {
      return false;
    }

    if (!id.equals(that.id)) {
      return false;
    }

    if ((mappingField != null) ? (!mappingField.equals(that.mappingField)) : (that.mappingField != null)) {
      return false;
    }

    if ((mappingTable != null) ? (!mappingTable.equals(that.mappingTable)) : (that.mappingTable != null)) {
      return false;
    }

    if ((tableAlias != null) ? (!tableAlias.equals(that.tableAlias)) : (that.tableAlias != null)) {
      return false;
    }

    return true;
  } // end method equals

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
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((businessDataType != null) ? businessDataType.hashCode() : 0);
    result = (31 * result) + ((dataType != null) ? dataType.hashCode() : 0);
    result = (31 * result) + ((displayName != null) ? displayName.hashCode() : 0);
    result = (31 * result) + id.hashCode();
    result = (31 * result) + ((mappingField != null) ? mappingField.hashCode() : 0);
    result = (31 * result) + ((mappingTable != null) ? mappingTable.hashCode() : 0);
    result = (31 * result) + ((tableAlias != null) ? tableAlias.hashCode() : 0);

    return result;
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
} // end class AvailableAccountExportLayoutMappingField
