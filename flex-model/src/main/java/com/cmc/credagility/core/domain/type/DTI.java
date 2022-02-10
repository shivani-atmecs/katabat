package com.cmc.credagility.core.domain.type;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/16/2014 14:21
 */
public enum DTI {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  D1, // LT 40
  D2, // 40 - 50
  D3, // 50 - 60
  D4; // 60 +

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * toDTI.
   *
   * @param   strValue  String
   *
   * @return  DTI
   */
  public static DTI toDTI(String strValue) {
    try {
      return valueOf(strValue.toUpperCase());
    } catch (Exception e) {
      return null;
    }
  }
}
