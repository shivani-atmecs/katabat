package com.cmc.credagility.core.domain.mra;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;

import com.cmc.credagility.core.domain.base.CreatorEntity;


/**
 * Created with IntelliJ IDEA. User: liaodongming Date: 12-9-18 Time: PM3:02 To change this template use File | Settings
 * | File Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity public class QueueAccountMappingField extends CreatorEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  @Column(
    length   = 32,
    nullable = false
  )
  /** data business type: ex. Percentage, Amount... */
  protected String businessDataType;

  /** DOCUMENT ME! */
  @Column(length = 255)
  protected String dataType;

  /** DOCUMENT ME! */
  @Column(length = 255)
  protected String displayName;

  /** DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** DOCUMENT ME! */
  @Column(length = 255)
  protected String mappingField;

  /** DOCUMENT ME! */
  @Column(length = 255)
  protected String mappingTable;

  /** DOCUMENT ME! */
  @Column(length = 255)
  protected String tableAlias;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getBusinessDataType() {
    return businessDataType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDataType() {
    return dataType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDisplayName() {
    return displayName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getMappingField() {
    return mappingField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getMappingTable() {
    return mappingTable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTableAlias() {
    return tableAlias;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  businessDataType  DOCUMENT ME!
   */
  public void setBusinessDataType(String businessDataType) {
    this.businessDataType = businessDataType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  dataType  DOCUMENT ME!
   */
  public void setDataType(String dataType) {
    this.dataType = dataType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  displayName  DOCUMENT ME!
   */
  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  id  DOCUMENT ME!
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  mappingField  DOCUMENT ME!
   */
  public void setMappingField(String mappingField) {
    this.mappingField = mappingField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  mappingTable  DOCUMENT ME!
   */
  public void setMappingTable(String mappingTable) {
    this.mappingTable = mappingTable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  tableAlias  DOCUMENT ME!
   */
  public void setTableAlias(String tableAlias) {
    this.tableAlias = tableAlias;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  field  DOCUMENT ME!
   */
  public void update(QueueAccountMappingField field) {
    this.mappingTable     = field.getMappingTable();
    this.tableAlias       = field.getTableAlias();
    this.mappingField     = field.getMappingField();
    this.dataType         = field.getDataType();
    this.businessDataType = field.getBusinessDataType();
    this.displayName      = field.getDisplayName();
    this.lastUpdateDate   = field.getLastUpdateDate();
    this.lastUpdater      = field.getLastUpdater();
  }
} // end class QueueAccountMappingField
