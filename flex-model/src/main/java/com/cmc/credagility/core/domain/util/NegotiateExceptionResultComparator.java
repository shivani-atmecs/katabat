package com.cmc.credagility.core.domain.util;

import java.util.Comparator;

import com.cmc.credagility.core.domain.negotiate.NegotiateExceptionResult;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 17:15
 */
public class NegotiateExceptionResultComparator implements Comparator<NegotiateExceptionResult> {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.util.Comparator#compare(com.cmc.credagility.core.domain.negotiate.NegotiateExceptionResult, com.cmc.credagility.core.domain.negotiate.NegotiateExceptionResult)
   */
  @Override public int compare(NegotiateExceptionResult o1, NegotiateExceptionResult o2) {
    Integer priority2 = o2.getExceptionRule().getPriority();
    Integer priority1 = o1.getExceptionRule().getPriority();

    return priority1 - priority2;
  }
}
