package com.ozstrategy.credagility.exceptions;

/**
 * The workflow cannot match any outgoing link of the workflow root node.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  11/21/2014 16:46 PM
 */
public class WorkflowMismatchRootException extends RuntimeException {
  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new WorkflowMismatchRootException object.
   */
  public WorkflowMismatchRootException() {
    super("Cannot access any branch of 'ROOT_NODE' node.");
  }

  /**
   * Creates a new WorkflowMismatchRootException object.
   *
   * @param  s  String
   */
  public WorkflowMismatchRootException(String s) {
    super(s);
  }
}
