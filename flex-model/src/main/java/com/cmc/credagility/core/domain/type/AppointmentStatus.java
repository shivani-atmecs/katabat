package com.cmc.credagility.core.domain.type;

/**
 * Typesafe enumeration class for appointment status.
 *
 * <p><a href="AppointmentStatus.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:bshuai@ozstrategy.com">Bin Shuai</a>
 * @version  10/16/2014 14:14
 */
public enum AppointmentStatus {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  SCHEDULED("Scheduled"), PROCESSED("Processed"), POSTPONED("Postponed"), CANCELLED("Cancelled"), MISSED("Missed");

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** String value. */
  private String strValue;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Define enum.
   */
  private AppointmentStatus() {
    this.strValue = this.name();
  }

  /**
   * Define enum with string value.
   *
   * @param  strValue  $param.type$
   */
  private AppointmentStatus(String strValue) {
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
