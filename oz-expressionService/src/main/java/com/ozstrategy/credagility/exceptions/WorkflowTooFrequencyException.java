package com.ozstrategy.credagility.exceptions;

/**
 * WorkflowTooFrequencyException. Throwing this exception when someone starting a workflow too frequently.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  11/21/2014 11:49 AM
 */
public class WorkflowTooFrequencyException extends RuntimeException {
  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new WorkflowTooFrequencyException object.
   */
  public WorkflowTooFrequencyException() { }

  /**
   * Creates a new WorkflowTooFrequencyException object.
   *
   * @param  s  String
   */
  public WorkflowTooFrequencyException(String s) {
    super(s);
  }

  /**
   * Creates a new WorkflowTooFrequencyException object.
   *
   * @param  throwable  Throwable
   */
  public WorkflowTooFrequencyException(Throwable throwable) {
    super(throwable);
  }

  /**
   * Creates a new WorkflowTooFrequencyException object.
   *
   * @param  s          String
   * @param  throwable  Throwable
   */
  public WorkflowTooFrequencyException(String s, Throwable throwable) {
    super(s, throwable);
  }
} // end class WorkflowTooFrequencyException
