package com.ozstrategy.credagility.core.domain;


import com.ozstrategy.credagility.core.helper.EvaluateHelper;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/16/2014 12:30
 */
public interface Calculatable {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * Calculate.
   *
   * @param   helper  for calculate
   *
   * @return  Calculate result
   */
  Object calculate(EvaluateHelper helper);
}
