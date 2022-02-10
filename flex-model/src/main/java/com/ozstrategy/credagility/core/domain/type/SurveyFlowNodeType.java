package com.ozstrategy.credagility.core.domain.type;

/**
 * Created by IntelliJ IDEA. User: wangy Date: 12-3-26 Time: PM12:32 To change this template use File | Settings | File
 * Templates.
 */
public enum SurveyFlowNodeType {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  STATIC_PAGE_NODE, SUB_FLOW_NODE, SURVEY_NODE, END_NODE, ROOT_NODE;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   strType  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static SurveyFlowNodeType toLayoutType(String strType) {
    if ((strType == null) || strType.trim().isEmpty()) {
      return null;
    }
    else {
      return valueOf(strType.toUpperCase());
    }
  }
}
