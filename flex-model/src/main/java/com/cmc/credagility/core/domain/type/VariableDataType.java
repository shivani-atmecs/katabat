package com.cmc.credagility.core.domain.type;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/16/2014 14:31
 */
public enum VariableDataType {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  BOOLEAN("BOOLEAN", "Boolean"), CURRENCY("CURRENCY", "BigDecimal"), DATE("DATE", "Date"),
  DECIMAL("BIGDECIMAL", "BigDecimal"), INTEGER("INTEGER", "Long"), PERCENTAGE("PERCENTAGE", "BigDecimal"),
  STRING("STRING", "String");

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** String value. */
  private String businessDataType;
  private String dataType;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Define enum.
   */
  private VariableDataType() {
    this.businessDataType = this.name();
  }

  /**
   * Define enum with string value.
   *
   * @param  businessDataType  strValue
   * @param  dataType          DOCUMENT ME!
   */
  private VariableDataType(String businessDataType, String dataType) {
    this.businessDataType = businessDataType;
    this.dataType         = dataType;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for business data type.
   *
   * @return  String
   */
  public String getBusinessDataType() {
    return this.businessDataType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data type.
   *
   * @return  String
   */
  public String getDataType() {
    return this.dataType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the string value for the enum.
   *
   * @return  enum string value
   */
  @Override public String toString() {
    return businessDataType + ":" + dataType;
  }
}
