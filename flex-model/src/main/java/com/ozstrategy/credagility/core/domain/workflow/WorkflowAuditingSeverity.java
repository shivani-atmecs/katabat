package com.ozstrategy.credagility.core.domain.workflow;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/16/2014 16:47
 */
public enum WorkflowAuditingSeverity {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  HIGH, MEDIUM, LOW;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * convert.
   *
   * @param   statusType  String
   *
   * @return  WorkflowAuditingSeverity
   */
  public static WorkflowAuditingSeverity convert(String statusType) {
    if ((statusType == null) || statusType.trim().isEmpty()) {
      return null;
    }

    return valueOf(statusType);
  }
}
