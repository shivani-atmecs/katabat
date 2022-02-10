package com.cmc.credagility.core.domain.type;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/16/2014 14:20
 */
public enum CustomerType {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  // ~ Enum constants
  // ---------------------------------------------------------------------------------------------------
  /**
   * Added the Customer Type (B,G) for RBS UK Account Loader B-- Business G-- Guarantor -- 09/15/2009 Added Customer
   * Type S for NCC-- 10/02/2009.
   */
  I("I"), // Individual
  C("C"), // Corporate
  P("P"), // Primary
  A("A"), // Associate
  B("B"), // Business
  G("G"), // Guarantor [Cosigner]
  R("R"), // Reference
  J("J"), // Joint Borrower [Secondary]
  D("D"), // Director
  S("S"); // Student

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
  private CustomerType() {
    this.strValue = this.name();
  }

  /**
   * Define enum with string value.
   *
   * @param  strValue  DOCUMENT ME!
   */
  private CustomerType(String strValue) {
    this.strValue = strValue;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   strValue  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static CustomerType toCustomerType(String strValue) {
    try {
      return valueOf(strValue.toUpperCase());
    } catch (Exception e) {
      return null;
    }
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
