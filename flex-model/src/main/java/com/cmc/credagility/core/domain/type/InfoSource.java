package com.cmc.credagility.core.domain.type;

/**
 * This is a helper enum simply describe where you get a piece of info.
 *
 * @author   Ye Zhang
 * @version  10/16/2014 14:23
 */
public enum InfoSource {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  CLIENT("Client"), SKIP("Skip"), DEBTOR("Debtor");

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** String value. */
  private String strValue;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Define enum.
   */
  private InfoSource() {
    this.strValue = this.name();
  }

  /**
   * Define enum with string value.
   *
   * @param  strValue  $param.type$
   */
  private InfoSource(String strValue) {
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
