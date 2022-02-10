package com.ozstrategy.credagility.core.domain;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  09/23/2015 17:40
 */
public enum RecallResultSourceType {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  DECISIONTREE, WORKFLOW;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * convert.
   *
   * @param   strType  String
   *
   * @return  RecallResultSourceType
   */
  public static RecallResultSourceType convert(String strType) {
    if ((strType == null) || strType.trim().isEmpty()) {
      return null;
    } else {
      return valueOf(strType.toUpperCase());
    }
  }
}
