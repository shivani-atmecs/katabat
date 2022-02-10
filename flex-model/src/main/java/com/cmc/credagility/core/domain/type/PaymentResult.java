package com.cmc.credagility.core.domain.type;

/**
 * Typesafe enumeration class for payment result types from payment service.
 *
 * <p><a href="PaymentStatus.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 * @version  10/16/2014 14:26
 */
public enum PaymentResult {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  SUCCESS("Success"), RECOVERABLE_ERROR("Recoverable_Error"), NON_RECOVERABLE_ERROR("NonRecoverable_Error"),
  SERVICE_DOWN("Service_Down");

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** String value. */
  private String strValue;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Define enum.
   */
  private PaymentResult() {
    this.strValue = this.name();
  }

  /**
   * Define enum with string value.
   *
   * @param  strValue  $param.type$
   */
  private PaymentResult(String strValue) {
    this.strValue = strValue;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * Get the string value for the enum.
   *
   * @return  enum string value
   */
  @Override public String toString() {
    return strValue;
  }
}
