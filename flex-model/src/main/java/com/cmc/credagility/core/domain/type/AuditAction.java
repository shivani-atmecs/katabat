package com.cmc.credagility.core.domain.type;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/16/2014 14:14
 */
public enum AuditAction {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  ADD, UPDATE, DELETE;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * toEnumAction.
   *
   * @param   strValue  String
   *
   * @return  AuditAction
   */
  public static AuditAction toEnumAction(String strValue) {
    try {
      return valueOf(strValue.toUpperCase());
    } catch (Exception e) {
      return null;
    }
  }
}
