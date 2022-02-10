package com.ozstrategy.credagility.core.helper;

import java.util.Map;


/**
 * Created by IntelliJ IDEA. User: rojer Date: Sep 10, 2010 Time: 10:11:42 PM To change this template use File |
 * Settings | File Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public interface EvaluateHelper {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   object  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  Object calculate(Object object);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   object  DOCUMENT ME!
   * @param   type    DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  Object calculate(Object object, String type);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Evaluate the node.
   *
   * @param   object  node to evaluate
   *
   * @return  evaluate result
   */
  Boolean evaluate(Object object);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * evaluateEEVariable.
   *
   * @param   eeVariableName  String
   *
   * @return  Long
   */
  Long evaluateEEVariable(String eeVariableName);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  Map<String, Object> getParameters();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Verify node criteria.
   *
   * @param  object  node to verify
   */
  void verify(Object object);
} // end interface EvaluateHelper
