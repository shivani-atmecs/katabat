package com.cmc.credagility.core.domain.type;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/16/2014 14:19
 */
public enum CTMBorrowerIndicator {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  AI("AI", "I will be applying individually."), AJS("AJS", "I will be applying jointly with my spouse."),
  AJP("AJP", "I will be applying jointly with another person."),
  AWO("AWO", "More than 2 people will be applying for this loan.");
  // , PRP("PRP"), SRP("SRP"), IRP("IRP");
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
  private CTMBorrowerIndicator(String code, String description) {
    this.code        = code;
    this.description = description;

  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * toCTMBorrowerIndicator.
   *
   * @param   code  String
   *
   * @return  CTMBorrowerIndicator
   */
  public static CTMBorrowerIndicator toCTMBorrowerIndicator(String code) {
    if (code == null) {
      return null;
    }

    for (CTMBorrowerIndicator b : CTMBorrowerIndicator.values()) {
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
