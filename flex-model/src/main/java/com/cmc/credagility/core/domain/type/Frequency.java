package com.cmc.credagility.core.domain.type;

/**
 * Frequency type.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  03/20/2015 15:48 PM
 */
public enum Frequency {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  MONTHLY, WEEKLY, BIWEEKLY;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * toPaymentChannel.
   *
   * @param   strValue  String
   *
   * @return  PaymentChannel
   */
  public static Frequency convert(String strValue) {
    try {
      return valueOf(strValue.toUpperCase());
    } catch (Exception e) {
      return null;
    }
  }
}
