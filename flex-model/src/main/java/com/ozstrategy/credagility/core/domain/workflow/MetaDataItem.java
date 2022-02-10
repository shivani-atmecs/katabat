package com.ozstrategy.credagility.core.domain.workflow;

import java.io.Serializable;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/16/2014 16:45
 */
public class MetaDataItem implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -722492934749682423L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  protected String dataType;

  /** TODO: DOCUMENT ME! */
  protected String displayValue;

  /** TODO: DOCUMENT ME! */
  protected Long id;

  /** TODO: DOCUMENT ME! */
  protected String name;

  /** TODO: DOCUMENT ME! */
  protected String value;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new MetaDataItem object.
   */
  public MetaDataItem() { }

  /**
   * Creates a new MetaDataItem object.
   *
   * @param  id        DOCUMENT ME!
   * @param  name      DOCUMENT ME!
   * @param  dataType  DOCUMENT ME!
   * @param  value     DOCUMENT ME!
   */
  public MetaDataItem(Long id, String name, String dataType, String value) {
    this.id       = id;
    this.name     = name;
    this.dataType = dataType;
    this.value    = value;
  }

  /**
   * Creates a new MetaDataItem object.
   *
   * @param  id            DOCUMENT ME!
   * @param  name          DOCUMENT ME!
   * @param  dataType      DOCUMENT ME!
   * @param  value         DOCUMENT ME!
   * @param  displayValue  DOCUMENT ME!
   */
  public MetaDataItem(Long id, String name, String dataType, String value, String displayValue) {
    this.id           = id;
    this.name         = name;
    this.dataType     = dataType;
    this.value        = value;
    this.displayValue = displayValue;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

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
   * getter method for display value.
   *
   * @return  String
   */
  public String getDisplayValue() {
    return displayValue;
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
   * getter method for name.
   *
   * @return  String
   */
  public String getName() {
    return name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for value.
   *
   * @return  String
   */
  public String getValue() {
    if ((value == null) || "".equals(value.trim()) || "null".equalsIgnoreCase(value.trim())) {
      return null;
    }

    return value;
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
   * setter method for display value.
   *
   * @param  displayValue  String
   */
  public void setDisplayValue(String displayValue) {
    this.displayValue = displayValue;
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
   * setter method for name.
   *
   * @param  name  String
   */
  public void setName(String name) {
    this.name = name;
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
} // end class MetaDataItem
