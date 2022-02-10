package com.cmc.credagility.core.domain.type;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/16/2014 14:27
 */
public enum PromiseToPayChannel {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  DEBTORSITE, AGENCY, CLIENT, EXTERNALENTITY;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * toPTPChannel.
   *
   * @param   strValue  String
   *
   * @return  PromiseToPayChannel
   */
  public static PromiseToPayChannel toPTPChannel(String strValue) {
    try {
      return valueOf(strValue.toUpperCase());
    } catch (Exception e) {
      return null;
    }
  }
}
