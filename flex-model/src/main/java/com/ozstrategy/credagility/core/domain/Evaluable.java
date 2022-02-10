package com.ozstrategy.credagility.core.domain;


import com.ozstrategy.credagility.core.helper.EvaluateHelper;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/16/2014 12:48
 */
public interface Evaluable {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * Evaluate.
   *
   * @param   helper  for evaluate
   *
   * @return  evaluate result
   */
  boolean evaluate(EvaluateHelper helper);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Verify.
   *
   * @param  helper  for verify
   */
  void verify(EvaluateHelper helper);
} // end interface Evaluable
