package com.ozstrategy.credagility.exceptions;

/**
 * WorkflowNoAccessException. Throwing this exception when there is no access to start workflow.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  11/21/2014 11:50 AM
 */
public class WorkflowNoAccessException extends RuntimeException {
  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new WorkflowNoAccessException object.
   */
  public WorkflowNoAccessException() {
    super();
  }

  /**
   * Creates a new WorkflowNoAccessException object.
   *
   * @param  s  String
   */
  public WorkflowNoAccessException(String s) {
    super(s);
  }

}
