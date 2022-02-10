package com.cmc.credagility.core.domain.type;

/**
 * Typesafe enumeration class for contact source types.
 *
 * <p><a href="ContactSource.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 * @version  $Revision$, $Date$
 */
public enum ContactSource {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  DEMOGAPI("DemogApi"),CLIENT("Client"), AGENT("Agent"), SKIP("Skip"), DEBTOR("Debtor"), AGENCY("Agency"), EXTERNALENTITY("External Entity");

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** String value. */
  private String strValue;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Define enum.
   */
  private ContactSource() {
    this.strValue = this.name();
  }

  /**
   * Define enum with string value.
   *
   * @param  strValue  DOCUMENT ME!
   */
  private ContactSource(String strValue) {
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
