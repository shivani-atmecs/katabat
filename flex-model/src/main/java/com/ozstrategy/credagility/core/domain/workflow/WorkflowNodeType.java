package com.ozstrategy.credagility.core.domain.workflow;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/16/2014 17:00
 */
public enum WorkflowNodeType {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  /** Static page node. Comments out temporarily */
  STATIC_PAGE_NODE,

  /** Sub flow. */
  SUB_FLOW_NODE,

  /** Task node. */
  SURVEY_NODE,

  /** End Node (Task Level: As End Flow) */
  END_NODE,

  /** Root Every flow must has a root node. */
  ROOT_NODE;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * convert.
   *
   * @param   strType  String
   *
   * @return  WorkflowNodeType
   */
  public static WorkflowNodeType convert(String strType) {
    if ((strType == null) || strType.trim().isEmpty()) {
      return null;
    } else {
      return valueOf(strType.toUpperCase());
    }
  }
}
