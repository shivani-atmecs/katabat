package com.ozstrategy.credagility.core.domain.workflow;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/16/2014 16:59
 */
public enum WorkflowNodeActionTriggerType {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  DAILY, ENTRY, EXIT, REAL_TIME, SKIP_EXIT;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * convert.
   *
   * @param   strType  String
   *
   * @return  WorkflowNodeActionTriggerType
   */
  public static WorkflowNodeActionTriggerType convert(String strType) {
    if ((strType == null) || strType.trim().isEmpty()) {
      return null;
    } else {
      return valueOf(strType.toUpperCase());
    }
  }
}
