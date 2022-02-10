package com.ozstrategy.credagility.core.domain.type;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/16/2014 16:35
 */
public enum Context {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  RESPONSIBLE, PAYMENT;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * toContext.
   *
   * @param   strVar  String
   *
   * @return  Context
   */
  public static Context toContext(String strVar) {
    try {
      return valueOf(strVar.toUpperCase());
    } catch (Exception e) {
      return RESPONSIBLE;
    }
  }
}
