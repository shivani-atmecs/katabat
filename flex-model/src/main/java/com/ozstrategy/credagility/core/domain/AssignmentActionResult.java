package com.ozstrategy.credagility.core.domain;

import java.util.HashMap;
import java.util.Map;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/16/2014 10:54
 */
public class AssignmentActionResult extends ActionResult {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  protected String actionType;


  /** TODO: DOCUMENT ME! */
  protected Map<String, Object[]> result = new HashMap<String, Object[]>();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for action type.
   *
   * @return  String
   */
  public String getActionType() {
    return actionType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for result.
   *
   * @return  Map
   */
  public Map<String, Object[]> getResult() {
    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for action type.
   *
   * @param  actionType  String
   */
  public void setActionType(String actionType) {
    this.actionType = actionType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for result.
   *
   * @param  result  Map
   */
  public void setResult(Map<String, Object[]> result) {
    this.result = result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#toString()
   */
  @Override public String toString() {
    return "AssignmentActionResult{"
      + "actionType='" + actionType + '\''
      + ", result=" + result
      + '}';
  }
} // end class AssignmentActionResult
