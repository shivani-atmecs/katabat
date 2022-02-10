package com.ozstrategy.credagility.core.domain.workflow;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/16/2014 17:01
 */
public enum WorkflowTaskStatus {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  CURRENT, DRAFT, ACTIVE, RETIRED, DELETED;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * convert.
   *
   * @param   taskStatus  String
   *
   * @return  WorkflowTaskStatus
   */
  public static WorkflowTaskStatus convert(String taskStatus) {
    if ((taskStatus == null) || taskStatus.trim().isEmpty()) {
      return null;
    }

    return valueOf(taskStatus);
  }
}
