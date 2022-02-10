package com.ozstrategy.credagility.core.domain;


/**
 * the flow node action trugger time.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/16/2014 14:48
 */
public enum SurveyFlowNodeActionTriggerTime {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  ENTRY, EXIT;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * toLayoutType.
   *
   * @param   strType  String
   *
   * @return  SurveyFlowNodeActionTriggerTime
   */
  public static SurveyFlowNodeActionTriggerTime toLayoutType(String strType) {
    if ((strType == null) || strType.trim().isEmpty()) {
      return null;
    } else {
      return valueOf(strType.toUpperCase());
    }
  }
}
