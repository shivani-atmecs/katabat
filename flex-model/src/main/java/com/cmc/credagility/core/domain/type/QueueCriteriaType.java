package com.cmc.credagility.core.domain.type;

/**
 * Add the type of criteria.
 *
 * @author   Rojer Jun Luo
 * @version  10/16/2014 14:27
 */
public enum QueueCriteriaType {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  PERCENTAGE("Percentage"), FREEFORM("FreeForm");

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** String value. */
  private String strValue;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Define enum.
   */
  private QueueCriteriaType() {
    this.strValue = this.name();
  }

  /**
   * Define enum with string value.
   *
   * @param  strValue  $param.type$
   */
  private QueueCriteriaType(String strValue) {
    this.strValue = strValue;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * Get the string value for the enum.
   *
   * @return  enum string value
   */
  @Override public String toString() {
    return strValue;
  }

}
