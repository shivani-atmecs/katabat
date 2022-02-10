package com.ozstrategy.credagility.core.domain;

/**
 * Created by david on 7/29/15.
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  09/23/2015 17:39
 */
public enum RecallResultStatus {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  INIT, EXPORTED;

  //~ Methods ----------------------------------------------------------------------------------------------------------


  /**
   * convert.
   *
   * @param   strType  String
   *
   * @return  RecallResultStatus
   */
  public static RecallResultStatus convert(String strType) {
    if ((strType == null) || strType.trim().isEmpty()) {
      return null;
    } else {
      return valueOf(strType.toUpperCase());
    }
  }
}
