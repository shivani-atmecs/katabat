package com.ozstrategy.credagility.core.domain;

import com.ozstrategy.credagility.core.domain.decisiontree.agency.AgencyNode;

import java.io.Serializable;
import java.util.Comparator;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/16/2014 10:24
 */
public class AgencyNodeComparator implements Comparator<AgencyNode>, Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 4110260990366924560L;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * compare.
   *
   * @param   o1  AgencyNode
   * @param   o2  AgencyNode
   *
   * @return  int
   */
  @Override public int compare(AgencyNode o1, AgencyNode o2) {
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
} // end class AgencyNodeComparator
