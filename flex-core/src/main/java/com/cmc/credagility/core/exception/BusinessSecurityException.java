package com.cmc.credagility.core.exception;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  01/16/2015 17:21 PM
 */
public class BusinessSecurityException extends AbstractBusinessException {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 3794386660479631776L;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Constructor for BusinessSecurityException.
   *
   * @param  msg  the detail message
   */
  public BusinessSecurityException(String msg) {
    super(msg);
  }

  /**
   * Constructor for BusinessSecurityException.
   *
   * @param  msg    the detail message
   * @param  cause  the root cause (usually from using a underlying data access API such as JDBC)
   */
  public BusinessSecurityException(String msg, Throwable cause) {
    super(msg, cause);
  }

  /**
   * Constructor to identify business and method names that cause exception. Also support a custom message
   * securityMessage.
   *
   * @param  businessClass    $param.type$
   * @param  id               $param.type$
   * @param  methodName       $param.type$
   * @param  securityMessage  $param.type$
   */
  @SuppressWarnings("unchecked")
  public BusinessSecurityException(Class businessClass, Object id,
    String methodName, String securityMessage) {
    this(businessClass, id, methodName,
      "Business class ["
      + businessClass.getName() + "]'s method [" + methodName
      + "]: security violation: " + securityMessage, null);
  }

  /**
   * Creates a new BusinessSecurityException object.
   *
   * @param  businessClass  Class
   * @param  identifier     Object
   * @param  methodName     String
   * @param  msg            String
   * @param  cause          Throwable
   */
  @SuppressWarnings("unchecked")
  public BusinessSecurityException(Class businessClass, Object identifier,
    String methodName, String msg, Throwable cause) {
    super(msg, cause);
    this.businessClass = businessClass;
    this.identifier    = identifier;
  }
} // end class BusinessSecurityException
