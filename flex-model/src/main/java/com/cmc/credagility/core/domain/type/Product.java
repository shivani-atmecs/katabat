package com.cmc.credagility.core.domain.type;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/16/2014 14:26
 */
public enum Product {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  LOAN, LINE;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * toCallType.
   *
   * @param   strValue  String
   *
   * @return  Product
   */
  public static Product toCallType(String strValue) {
    try {
      return valueOf(strValue.toUpperCase());
    } catch (Exception e) {
      return null;
    }
  }
}
