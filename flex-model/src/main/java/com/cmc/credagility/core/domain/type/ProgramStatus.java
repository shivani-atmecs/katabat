package com.cmc.credagility.core.domain.type;

/**
 * Typesafe enumeration class for payment program status.
 *
 * <p><a href="ProgramStatus.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:bshuai@ozstrategy.com">Bin Shuai</a>
 * @version  $Revision$, $Date$
 */
public enum ProgramStatus {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  // ~ Enum constants
  // ---------------------------------------------------------------------------------------------------

  INIT("Init"), ACCEPTED("Accepted"), CANCELLEDBYDEBTOR("CancelledByDebtor"), // debtor

  // called
  // agent
  // or
  // edit/delete
  // a
  // payment
  CANCELLEDBYBROKENPROMISE("CancelledByBrokenPromise"), // debtor did not pay on

  // time
  PENDINGCANCELLATION("PendingCancellation"), FULFILLED("Fulfilled"), CANCELLEDBYCLIENT("CanceledByClient"),
  CANCELLEDBYGRANTOR("CancelledByGrantor"), ENDED("ENDED"), COMPLETED("Completed"),
  CANCELLEDBYAGENT("CancelledByAgent"), CANCELLEDBYCUSTOMER("CancelledByCustomer"),
  CANCELLEDBYREJECTEDPAYMENT("CancelledByRejectedPayment"), FAILED("Failed"), UNFULFILLED("Unfulfilled");

  //~ Instance fields --------------------------------------------------------------------------------------------------

  // ~ Instance fields
  // --------------------------------------------------------------------------------------------------

  /** String value. */
  private String strValue;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  // ~ Constructors
  // -----------------------------------------------------------------------------------------------------

  /**
   * Define enum.
   */
  private ProgramStatus() {
    this.strValue = this.name();
  }

  /**
   * Define enum with string value.
   *
   * @param  strValue  DOCUMENT ME!
   */
  private ProgramStatus(String strValue) {
    this.strValue = strValue;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isCancelled() {
    return "CancelledByBrokenPromise".equals(strValue)
      || "CanceledByClient".endsWith(strValue) || "CancelledByDebtor".equals(strValue)
      || "CancelledByAgent".equals(strValue)
      || "CancelledByGrantor".equals(strValue) || "CancelledByCustomer".equals(strValue)
      || "CancelledByRejectedPayment".equals(strValue);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~ Methods
  // ----------------------------------------------------------------------------------------------------------

  /**
   * Get the string value for the enum.
   *
   * @return  enum string value
   */
  @Override public String toString() {
    return strValue;
  }
}
