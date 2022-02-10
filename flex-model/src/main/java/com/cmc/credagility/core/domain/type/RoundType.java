package com.cmc.credagility.core.domain.type;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/16/2014 14:28
 */
public enum RoundType {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  CENTS_HALF_UP,   //
  CENTS_DOWN,      //
  CENTS_UP,        //
  DOLLARS_UP,      //
  REMAINDER_FIRST, // remainder
  SPREAD_REMAINDER; // remainder

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * toRoundType.
   *
   * @param   strValue  String
   *
   * @return  RoundType
   */
  public static RoundType toRoundType(String strValue) {
    try {
      return valueOf(strValue.toUpperCase());
    } catch (Exception e) {
      return null;
    }
  }

  @Override
  public String toString() {
    return name().toUpperCase();
  }
}
