package com.cmc.credagility.core.exception;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  01/16/2015 17:23 PM
 */
public class PaymentNotEditableException extends AbstractBusinessException {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -1334604148596847707L;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Constructor for PaymentNotEditableException.
   *
   * @param  msg  the detail message
   */
  public PaymentNotEditableException(String msg) {
    super(msg);
  }

  /**
   * Constructor for PaymentNotEditableException.
   *
   * @param  msg    the detail message
   * @param  cause  $param.type$
   */
  public PaymentNotEditableException(String msg, Throwable cause) {
    super(msg, cause);
  }

  /**
   * Constructor to identify business and method names that cause exception. Also support a custom message.
   *
   * @param  businessClass  $param.type$
   * @param  id             $param.type$
   * @param  methodName     $param.type$
   * @param  message        $param.type$
   */
  @SuppressWarnings("unchecked")
  public PaymentNotEditableException(Class businessClass, Object id,
    String methodName, String message) {
    this(businessClass, id, methodName,
      "Business class ["
      + businessClass.getName() + "]'s method [" + methodName
      + "]: security violation: " + message, null);
  }

  /**
   * Creates a new PaymentNotEditableException object.
   *
   * @param  businessClass  Class
   * @param  identifier     Object
   * @param  methodName     String
   * @param  msg            String
   * @param  cause          Throwable
   */
  @SuppressWarnings("unchecked")
  public PaymentNotEditableException(Class businessClass, Object identifier,
    String methodName, String msg, Throwable cause) {
    super(msg, cause);
    this.businessClass = businessClass;
    this.identifier    = identifier;
  }
} // end class PaymentNotEditableException
