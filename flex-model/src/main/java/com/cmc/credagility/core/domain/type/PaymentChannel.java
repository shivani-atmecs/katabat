package com.cmc.credagility.core.domain.type;

/**
 * Typesafe enumeration class for payment channel types.
 *
 * <p><a href="PaymentChannel.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 * @version  $Revision$, $Date$
 */
public enum PaymentChannel {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  IVR, DEBTORSITE, AGENCY, CLIENT, CHECKTOCMC, CHECKTOCLIENT, MAIL, UNKNOWN, OTHER, REGULARMAIL, PRIORITYMAIL,
  WIRETRANSFER, ONLINE, BRANCH, EXTERNALENTITY, AGENT, OCA, API,IVRAPI,APPAPI;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * toPaymentChannel.
   *
   * @param   strValue  String
   *
   * @return  PaymentChannel
   */
  public static PaymentChannel toPaymentChannel(String strValue) {
    try {
      return valueOf(strValue.toUpperCase());
    } catch (Exception e) {
      return null;
    }
  }
}
