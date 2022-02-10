package com.cmc.credagility.core.domain.type;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/16/2014 14:19
 */
public enum CTMResidenceIndicator {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  PRP("PRP", "This is my primary residence."), SRP("SRP", "This is a second home."),
  IRP("IRP", "This is an investment property.");
  // Refinance Existing Mortgage - REM
  // Refinance Home and obtain Cash - RHC
  // Purchasing a Home - RPH
  // Applying Individually - AI
  // Applying Individually + Spouse - AJS
  // Applying Individually + Another Person - AJP
  // Applying 2 + more other Person - AWO
  // Primary Residence - PRP
  // secondary Residence - SRP
  // Investment Residence - IRP

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** String value. */
  private String code;
  private String description;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Define enum with string value.
   *
   * @param  code         String
   * @param  description  String
   */
  private CTMResidenceIndicator(String code, String description) {
    this.code        = code;
    this.description = description;

  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * toCTMResidenceIndicator.
   *
   * @param   code  String
   *
   * @return  CTMResidenceIndicator
   */
  public static CTMResidenceIndicator toCTMResidenceIndicator(String code) {
    if (code == null) {
      return null;
    }

    for (CTMResidenceIndicator b : CTMResidenceIndicator.values()) {
      if (b.toString().equalsIgnoreCase(code)) {
        return b;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for code.
   *
   * @return  String
   */
  public String getCode() {
    return this.code;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for description.
   *
   * @return  String
   */
  public String getDescription() {
    return this.description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the string value for the enum.
   *
   * @return  enum string value
   */
  @Override public String toString() {
    return this.code;
  }

}
