package com.cmc.credagility.core.domain.type;

/**
 * Typesafe enumeration class for payment status types.
 *
 * <p><a href="PaymentStatus.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 * @version  $Revision$, $Date$
 */
public enum PaymentStatus {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  // npelleti, 08/13, SM-50, Added new PaymentStatusCode: SUBMITTED
  // selva 2009/09/20 Removed SUBMITTED payment status
  INPROCESS("InProcess"), SCHEDULED("Scheduled"), PAID("Paid"), DELETED("Deleted"), REMOVED("Removed"),
  REJECTED("Rejected");

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** String value. */
  private String strValue;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Define enum.
   */
  private PaymentStatus() {
    this.strValue = this.name();
  }

  /**
   * Define enum with string value.
   *
   * @param  strValue  DOCUMENT ME!
   */
  private PaymentStatus(String strValue) {
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
