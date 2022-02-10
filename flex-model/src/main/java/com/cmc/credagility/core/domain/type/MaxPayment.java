package com.cmc.credagility.core.domain.type;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/16/2014 14:24
 */
public enum MaxPayment {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  P1, // 0 - 250
  P2, // 250 - 500
  P3, // 500 - 750
  P4, // 750 - 1000
  P5; // 1000 +

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * toMaxPayment.
   *
   * @param   strValue  String
   *
   * @return  MaxPayment
   */
  public static MaxPayment toMaxPayment(String strValue) {
    try {
      return valueOf(strValue.toUpperCase());
    } catch (Exception e) {
      return null;
    }
  }
}
