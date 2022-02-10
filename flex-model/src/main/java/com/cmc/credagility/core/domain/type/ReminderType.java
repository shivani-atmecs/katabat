package com.cmc.credagility.core.domain.type;

/**
 * Typesafe enumeration class for reminder type.
 *
 * <p><a href="ReminderType.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 * @version  10/16/2014 14:28
 */
public enum ReminderType {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  EMAIL("Email"), SMS("SMS"), IVR("IVR"), LETTER("Letter"), NONE("None");

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** String value. */
  private String strValue;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Define enum.
   */
  private ReminderType() {
    this.strValue = this.name();
  }

  /**
   * Define enum with string value.
   *
   * @param  strValue  $param.type$
   */
  private ReminderType(String strValue) {
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
