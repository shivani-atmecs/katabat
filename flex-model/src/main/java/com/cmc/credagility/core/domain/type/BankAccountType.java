package com.cmc.credagility.core.domain.type;

/**
 * Typesafe enumeration class for funding account type.
 *
 * <p><a href="BankAccountType.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 * @version  $Revision$, $Date$
 */
public enum BankAccountType {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  CHECKING("Checking"), SAVING("Saving"), MONEY_MARKET("Money Market"), BANKING("Banking"), CURRENT("Current"),
  CHEQUE("Cheque");

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** String value. */
  private String strValue;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Define enum.
   */
  private BankAccountType() {
    this.strValue = this.name();
  }

  /**
   * Define enum with string value.
   *
   * @param  strValue  DOCUMENT ME!
   */
  private BankAccountType(String strValue) {
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
