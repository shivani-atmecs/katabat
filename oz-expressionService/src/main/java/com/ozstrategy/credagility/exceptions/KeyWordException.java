package com.ozstrategy.credagility.exceptions;

/**
 * Created with IntelliJ IDEA. User: yongliu Date: 6/4/14 Time: 5:18 PM To change this template use File | Settings |
 * File Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public class KeyWordException extends RuntimeException {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -2378273308277110182L;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new KeyWordException object.
   *
   * @param  s  DOCUMENT ME!
   */
  public KeyWordException(String s) {
    super(s);
  }

  /**
   * Creates a new ScheduleIOException object.
   *
   * @param  s          DOCUMENT ME!
   * @param  throwable  DOCUMENT ME!
   */
  public KeyWordException(String s, Throwable throwable) {
    super(s, throwable);
  }
} // end class KeyWordException
