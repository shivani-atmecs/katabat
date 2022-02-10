package com.ozstrategy.credagility.core.domain;


import com.ozstrategy.credagility.core.helper.EvaluateHelper;
import com.ozstrategy.credagility.core.helper.ExecuteHelper;


/**
 * TODO:
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/16/2014 12:48
 */
public interface Executable {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * beforeExecute.
   */
  void beforeExecute();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * execute.
   *
   * @param  evaluateHelper  helper toExecute
   * @param  executeHelper   $param.type$
   */
  void execute(EvaluateHelper evaluateHelper, ExecuteHelper executeHelper);
}
