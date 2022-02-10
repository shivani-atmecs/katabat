package com.ozstrategy.credagility.core.domain.workflow;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/16/2014 16:59
 */
public enum WorkflowLinkDrivenType {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  /** Drive by manual Operation. */
  MANUALLY,

  /** Drive by Daily System Batch. */
  BATCH,

  /** Drive by Event. */
  EVENT;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * convert.
   *
   * @param   strType  String
   *
   * @return  WorkflowLinkDrivenType
   */
  public static WorkflowLinkDrivenType convert(String strType) {
    if ((strType == null) || strType.trim().isEmpty()) {
      return null;
    } else {
      return valueOf(strType.toUpperCase());
    }
  }
}
