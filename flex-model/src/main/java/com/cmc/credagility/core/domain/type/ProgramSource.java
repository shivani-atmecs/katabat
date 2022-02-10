package com.cmc.credagility.core.domain.type;

/**
 * Typesafe enumeration class for payment program status.
 *
 * <p><a href="ProgramStatus.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:bshuai@ozstrategy.com">Bin Shuai</a>
 * @version  $Revision$, $Date$
 */
public enum ProgramSource {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  AGENT("Agent"),                           //
  AGENTTEMPLATE("AgentTemplate"),           //
  BATCH("Batch"),                           //
  CID("CID"),                               //
  DEBTORSITETEMPLATE("DebtorSiteTemplate"), //
  STRATEGY("Strategy"), EVENT("Event");     //

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** String value. */
  private String strValue;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Define enum.
   */
  private ProgramSource() {
    this.strValue = this.name();
  }

  /**
   * Define enum with string value.
   *
   * @param  strValue  DOCUMENT ME!
   */
  private ProgramSource(String strValue) {
    this.strValue = strValue;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * toProgramSource.
   *
   * @param   strValue  String
   *
   * @return  ProgramSource
   */
  public static ProgramSource toProgramSource(String strValue) {
    try {
      return valueOf(strValue.toUpperCase());
    } catch (Exception e) {
      return null;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the string value for the enum.
   *
   * @return  enum string value
   */
  @Override public String toString() {
    return strValue;
  }
}
