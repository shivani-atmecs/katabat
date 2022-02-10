package com.cmc.credagility.core.domain.type;

/**
 * Typesafe enumeration class for credit/debit card type.
 *
 * <p><a href="CardType.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 * @version  $Revision$, $Date$
 */
public enum CardType {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  VISA("Visa"), MASTERCARD("MasterCard"), AMERICANEEXPRESS("AmericanExpress"), DISCOVER("Discover"),
  DINERSCLUB("DinersClub"), JCB("JCB"), VisaElectron("VisaElectron"), VisaDebit("VisaDebit");

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** String value. */
  private String strValue;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Define enum.
   */
  private CardType() {
    this.strValue = this.name();
  }

  /**
   * Define enum with string value.
   *
   * @param  strValue  DOCUMENT ME!
   */
  private CardType(String strValue) {
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
