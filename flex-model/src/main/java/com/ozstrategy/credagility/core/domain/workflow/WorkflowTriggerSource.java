package com.ozstrategy.credagility.core.domain.workflow;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/16/2014 17:01
 */
public enum WorkflowTriggerSource {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  AGENCY, DEBTOR_SITE, BATCH, EVENT, BCC;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * convert.
   *
   * @param   strType  String
   *
   * @return  WorkflowTriggerSource
   */
  public static WorkflowTriggerSource convert(String strType) {
    if ((strType == null) || strType.trim().isEmpty()) {
      return null;
    } else {
      return valueOf(strType.toUpperCase());
    }
  }
}
