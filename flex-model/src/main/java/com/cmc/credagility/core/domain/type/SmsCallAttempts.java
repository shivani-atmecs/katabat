package com.cmc.credagility.core.domain.type;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/16/2014 14:30
 */
public enum SmsCallAttempts {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  BEST_OF_CALL_ATTEMPTS("1"),

  NOT_BEST_OF_CALL_ATTEMPTS("0");

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** String value. */
  private String strValue;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Define enum with string value.
   *
   * @param  strValue  $param.type$
   */
  private SmsCallAttempts(String strValue) {
    this.strValue = strValue;

  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * toSmsCallAttempts.
   *
   * @param   strValue  String
   *
   * @return  SmsCallAttempts
   */
  public static SmsCallAttempts toSmsCallAttempts(String strValue) {
    if (strValue == null) {
      return null;
    }

    for (SmsCallAttempts b : SmsCallAttempts.values()) {
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
