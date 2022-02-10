package com.ozstrategy.credagility.core.domain;

import java.io.Serializable;
import java.util.Comparator;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/16/2014 13:39
 */
public class NodeComparator implements Comparator<Node>, Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -6495861305859000627L;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * compare.
   *
   * @param   o1  Node
   * @param   o2  Node
   *
   * @return  int
   */
  @Override public int compare(Node o1, Node o2) {
    if (o1 == null) {
      if (o2 == null) {
        return 0;
      } else {
        return 1;
      }
    } else {
      if (o2 == null) {
        return -1;
      } else {
        return o1.getBizHashCode().compareTo(o2.getBizHashCode());
      }
    }
  }
} // end class NodeComparator
