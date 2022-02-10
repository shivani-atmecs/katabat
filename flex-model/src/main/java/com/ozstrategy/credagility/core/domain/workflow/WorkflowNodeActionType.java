package com.ozstrategy.credagility.core.domain.workflow;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/16/2014 17:00
 */
public enum WorkflowNodeActionType {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  CHANNEL, PROGRAM, VARIABLE, STATUS, UPDATEVARIABLE, FLOW;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * convert.
   *
   * @param   strType  String
   *
   * @return  WorkflowNodeActionType
   */
  public static WorkflowNodeActionType convert(String strType) {
    if ((strType == null) || strType.trim().isEmpty()) {
      return null;
    } else {
      return valueOf(strType.toUpperCase());
    }
  }
}
