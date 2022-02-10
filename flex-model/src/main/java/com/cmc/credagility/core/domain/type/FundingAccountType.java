package com.cmc.credagility.core.domain.type;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Typesafe enumeration class for funding account type.
 *
 * <p><a href="FundingAccountType.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 * @version  10/16/2014 14:22
 */
public enum FundingAccountType {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  CREDITCARD("CreditCard"), DEBITCARD("DebitCard"), BANKACCOUNT("BankAccount"), CARD("Card"),
  MONEYMARKET("MoneyMarket"), UNKNOWN("Unknown"), MAESTRO("Maestro");

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** String value. */
  private String strValue;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Define enum.
   */
  private FundingAccountType() {
    this.strValue = this.name();
  }

  /**
   * Define enum with string value.
   *
   * @param  strValue  $param.type$
   */
  private FundingAccountType(String strValue) {
    this.strValue = strValue;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   value  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   * @throws  IllegalArgumentException  DOCUMENT ME!
   */
  @JsonCreator
  public static FundingAccountType fromStrValue(String value) {
    for (FundingAccountType c : values()) {
      if (c.toString().equalsIgnoreCase(value)) {
        return c;
      }
    }
    return null;
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
