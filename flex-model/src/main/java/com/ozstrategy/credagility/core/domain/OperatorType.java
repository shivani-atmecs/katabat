package com.ozstrategy.credagility.core.domain;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/16/2014 13:39
 */
public enum OperatorType {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  MAXLENGTH("MaxLength"), MINLENGTH("MinLength");

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String strValue;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new OperatorType object.
   *
   * @param  strValue  String
   */
  OperatorType(String strValue) {
    this.strValue = strValue;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for str value.
   *
   * @return  String
   */
  public String getStrValue() {
    return strValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for str value.
   *
   * @param  strValue  String
   */
  public void setStrValue(String strValue) {
    this.strValue = strValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * toString.
   *
   * @return  String
   */
  @Override public String toString() {
    return strValue;
  }
}
