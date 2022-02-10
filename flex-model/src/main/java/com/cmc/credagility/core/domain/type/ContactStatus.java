package com.cmc.credagility.core.domain.type;

/**
 * Typesafe enumeration class for contact status types.
 *
 * <p><a href="ContactStatus.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 * @version  $Revision$, $Date$
 */
public enum ContactStatus {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  UNVERIFIED("Unverified"), VERIFIED("Verified"), BAD("Bad"), WRONG("Wrong");

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** String value. */
  private String strValue;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Define enum.
   */
  private ContactStatus() {
    this.strValue = this.name();
  }

  /**
   * Define enum with string value.
   *
   * @param  strValue  DOCUMENT ME!
   */
  private ContactStatus(String strValue) {
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
