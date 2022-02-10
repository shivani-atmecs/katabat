package com.ozstrategy.credagility.core.domain;


/**
 * node action type.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/16/2014 14:48
 */
public enum SurveyFlowNodeActionType {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  CHANNEL, PROGRAM, VARIABLE, STATUS, UPDATEVARIABLE, FLOW;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * convert.
   *
   * @param   strType  String
   *
   * @return  SurveyFlowNodeActionType
   */
  public static SurveyFlowNodeActionType convert(String strType) {
    if ((strType == null) || strType.trim().isEmpty()) {
      return null;
    } else {
      return valueOf(strType.toUpperCase());
    }
  }
}
