package com.cmc.credagility.core.domain.type;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/16/2014 14:13
 */
public enum AmountType {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  TOTAL_AMOUNT, MONTHLY_AMOUNT, INDIVIDUAL_AMOUNT;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * toAmountType.
   *
   * @param   strValue  String
   *
   * @return  AmountType
   */
  public static AmountType toAmountType(String strValue) {
    try {
      return valueOf(strValue.toUpperCase());
    } catch (Exception e) {
      return null;
    }
  }
}
