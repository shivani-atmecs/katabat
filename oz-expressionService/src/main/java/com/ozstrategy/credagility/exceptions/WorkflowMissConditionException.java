package com.ozstrategy.credagility.exceptions;

/**
 * The workflow cannot match any outgoing link of the workflow node.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  11/21/2014 14:43 PM
 */
public class WorkflowMissConditionException extends RuntimeException {
  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new WorkflowMissConditionException object.
   */
  public WorkflowMissConditionException() {
    super("Do not match the criteria.");
  }

  /**
   * Creates a new WorkflowMissConditionException object.
   *
   * @param  s  String
   */
  public WorkflowMissConditionException(String s) {
    super(s);
  }
}
