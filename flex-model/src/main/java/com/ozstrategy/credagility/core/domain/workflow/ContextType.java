package com.ozstrategy.credagility.core.domain.workflow;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/16/2014 16:43
 */
public enum ContextType {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  ENTERPRISE,

  AGENCY,

  AGENT,

  // TODO @Deprecated
  ACCOUNT,

  RESPONSIBLE,

  // TODO @Deprecated
  PORTFOLIO,

  SYSTEM,

  // TODO @Deprecated
  GLOBAL,

  PAYMENT,

  PROGRAM,

  PROMISE,

  CUSTOMER,

  BUSINESS;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * convert.
   *
   * @param   value  String
   *
   * @return  ContextType
   */
  public static ContextType convert(String value) {
    try {
      return valueOf(value.toUpperCase());
    } catch (Exception e) {
      return null;
    }
  }
}
