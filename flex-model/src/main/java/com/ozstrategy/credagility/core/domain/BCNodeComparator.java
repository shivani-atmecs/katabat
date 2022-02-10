package com.ozstrategy.credagility.core.domain;

import com.ozstrategy.credagility.core.domain.decisiontree.businesscontext.BCNode;

import java.io.Serializable;
import java.util.Comparator;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/16/2014 11:33
 */
public class BCNodeComparator implements Comparator<BCNode>, Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 1398661273602105839L;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * compare.
   *
   * @param   o1  BCNode
   * @param   o2  BCNode
   *
   * @return  int
   */
  @Override public int compare(BCNode o1, BCNode o2) {
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
} // end class BCNodeComparator
