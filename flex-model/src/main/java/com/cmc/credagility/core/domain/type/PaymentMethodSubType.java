package com.cmc.credagility.core.domain.type;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/16/2014 14:25
 */
public enum PaymentMethodSubType {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  VISA("Visa"), MASTER("MasterCard"), AMERICANEXPRESS("AmericanExpress"), DISCOVER("Discover"),
  DINERSCLUB("DinersClub"), JCB("JCB"), SAVING("Saving"), CHECKING("Checking");

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** String value. */
  private String strValue;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Define enum.
   */
  private PaymentMethodSubType() {
    this.strValue = this.name();
  }

  /**
   * Define enum with string value.
   *
   * @param  strValue  DOCUMENT ME!
   */
  private PaymentMethodSubType(String strValue) {
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
