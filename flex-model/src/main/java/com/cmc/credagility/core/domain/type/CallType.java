package com.cmc.credagility.core.domain.type;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/16/2014 14:15
 */
public enum CallType {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  IVRINBOUND, IVROUTBOUND, AGENTCALL, DIRECTINBOUND, NONCALLDOC, EMAIL, DIALER, GETNEXTCALL, OTHER;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * toCallType.
   *
   * @param   strValue  String
   *
   * @return  CallType
   */
  public static CallType toCallType(String strValue) {
    try {
      return valueOf(strValue.toUpperCase());
    } catch (Exception e) {
      return null;
    }

  }
}
