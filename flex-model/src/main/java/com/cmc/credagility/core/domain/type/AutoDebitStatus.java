package com.cmc.credagility.core.domain.type;

/**
 * Typesafe enumeration class for Auto Debit Status.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  03/20/2015 15:48 PM
 */
public enum AutoDebitStatus {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  ENROLLED, NOT_ENROLLED, ENROLL_PENDING, CANCEL_PENDING, UPDATE_PENDING;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * toPaymentChannel.
   *
   * @param   strValue  String
   *
   * @return  PaymentChannel
   */
  public static AutoDebitStatus convert(String strValue) {
    try {
      return valueOf(strValue.toUpperCase());
    } catch (Exception e) {
      return null;
    }
  }
}
