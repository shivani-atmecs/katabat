package com.ozstrategy.credagility.exceptions;

import com.ozstrategy.strategy.exception.GenericException;

/**
 * Created by IntelliJ IDEA. User: rojer Date: Mar 25, 2010 Time: 5:10:00 PM To change this template use File | Settings
 * | File Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public class InvalidAccountException extends GenericException {
  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Constructs a new exception with the specified detail message. The cause is not initialized, and may subsequently be
   * initialized by a call to {@link #initCause}.
   *
   * @param  message  the detail message. The detail message is saved for later retrieval by the {@link #getMessage()}
   *                  method.
   */
  public InvalidAccountException(String message) {
    super(message);
  }
}
