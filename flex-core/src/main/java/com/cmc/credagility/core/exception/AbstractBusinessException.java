package com.cmc.credagility.core.exception;

import org.springframework.core.NestedRuntimeException;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  01/16/2015 17:21 PM
 */
public abstract class AbstractBusinessException extends NestedRuntimeException {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 8527169370692217407L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  protected Object businessClass;

  /** TODO: DOCUMENT ME! */
  protected Object identifier;
  private String   methodName;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new AbstractBusinessException object.
   *
   * @param  msg  String
   */
  public AbstractBusinessException(String msg) {
    super(msg);
  }

  /**
   * Creates a new AbstractBusinessException object.
   *
   * @param  msg    String
   * @param  cause  Throwable
   */
  public AbstractBusinessException(String msg, Throwable cause) {
    super(msg, cause);
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * Return the business class that causes security violation. If no Class was specified, this method returns null.
   *
   * @return  return the business class that causes security violation.
   */
  @SuppressWarnings("unchecked")
  public Class getBusinessClass() {
    return ((this.businessClass instanceof Class) ? (Class) this.businessClass : null);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Return the name of the persistent class of the object that was not found. Will work for both Class objects and
   * String names.
   *
   * @return  return the name of the persistent class of the object that was not found.
   */
  @SuppressWarnings("unchecked")
  public String getBusinessClassName() {
    if (this.businessClass instanceof Class) {
      return ((Class) this.businessClass).getName();
    }

    return ((this.businessClass != null) ? this.businessClass.toString() : null);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Return the principal identifier that causes he security exception.
   *
   * @return  return the principal identifier that causes he security exception.
   */
  public Object getIdentifier() {
    return identifier;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for method name.
   *
   * @return  String
   */
  public String getMethodName() {
    return methodName;
  }

} // end class AbstractBusinessException
