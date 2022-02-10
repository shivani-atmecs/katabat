package com.cmc.credagility.core.domain.type;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/16/2014 14:25
 */
public enum PaymentMethod {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  CHECKORACH, MONEYORDER, CREDITCARD, DEBITCARD, WESTERNUNION, MONEYGRAM, UNKNOWN, OTHER;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * toPaymentMethod.
   *
   * @param   strValue  String
   *
   * @return  PaymentMethod
   */
  public static PaymentMethod toPaymentMethod(String strValue) {
    try {
      return valueOf(strValue.toUpperCase());
    } catch (Exception e) {
      return null;
    }
  }
}
