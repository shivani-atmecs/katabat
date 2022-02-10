package com.cmc.credagility.core.domain.type;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/16/2014 14:19
 */
public enum CTMAccountIndicator {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  CHAP("C"), WHIT("W"), FDIC("F"), TREA("T"), SETL("S"), HASP("H"), REFI("R"), MOD("M");

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** String value. */
  private String strValue;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Define enum with string value.
   *
   * @param  strValue  $param.type$
   */
  private CTMAccountIndicator(String strValue) {
    this.strValue = strValue;

  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * toCTMAccountIndicator.
   *
   * @param   strValue  String
   *
   * @return  CTMAccountIndicator
   */
  public static CTMAccountIndicator toCTMAccountIndicator(String strValue) {
    if (strValue == null) {
      return null;
    }

    for (CTMAccountIndicator b : CTMAccountIndicator.values()) {
      if (b.toString().equalsIgnoreCase(strValue)) {
        return b;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the string value for the enum.
   *
   * @return  enum string value
   */
  @Override public String toString() {
    return strValue;
  }

}
