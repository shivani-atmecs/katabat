package com.ozstrategy.credagility.core.domain;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/16/2014 12:58
 */
public enum LayoutType {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  CIRCLE, COMPACT_TREE, COMPACT_TREE_HORIZONTAL, EDGE_LABEL, FAST_ORGANIC, ORGANIC, PARALLEL_EDGE, PARTITION,
  PARTITION_HORIZONTAL, STACK, STACK_HORIZONTAL;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * toLayoutType.
   *
   * @param   strType  String
   *
   * @return  LayoutType
   */
  public static LayoutType toLayoutType(String strType) {
    if ((strType == null) || strType.trim().isEmpty()) {
      return null;
    } else {
      return valueOf(strType.toUpperCase());
    }
  }
}
