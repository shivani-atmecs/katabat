package com.ozstrategy.credagility.exceptions;

/**
 * Created by Yang Wang on 3/2/15.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  03/02/2015 10:54 AM
 */
public class CanNotOpenURLException extends RuntimeException {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 6101552092755694902L;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new CanNotOpenURLException object.
   */
  public CanNotOpenURLException() {
    super();
  }

  /**
   * Creates a new CanNotOpenURLException object.
   *
   * @param  message  String
   */
  public CanNotOpenURLException(String message) {
    super(message);
  }

  /**
   * Creates a new CanNotOpenURLException object.
   *
   * @param  cause  Throwable
   */
  public CanNotOpenURLException(Throwable cause) {
    super(cause);
  }

  /**
   * Creates a new CanNotOpenURLException object.
   *
   * @param  message  String
   * @param  cause    Throwable
   */
  public CanNotOpenURLException(String message, Throwable cause) {
    super(message, cause);
  }

} // end class CanNotOpenURLException
