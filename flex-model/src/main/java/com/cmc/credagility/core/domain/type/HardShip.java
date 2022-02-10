package com.cmc.credagility.core.domain.type;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/16/2014 14:22
 */
public enum HardShip {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  ST, // Short Term <= 18 Month
  LT, // Long Term > 18 Month
  NA; // Not Available

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * toHardShip.
   *
   * @param   strValue  String
   *
   * @return  HardShip
   */
  public static HardShip toHardShip(String strValue) {
    try {
      return valueOf(strValue.toUpperCase());
    } catch (Exception e) {
      return null;
    }
  }
}
