package com.cmc.credagility.core.domain.type;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/16/2014 14:19
 */
public enum CTMRefinanceIndicator {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  REM("REM", "I'd like to refinance the existing mortgage balance on my home."),
  RHC("RHC", "I'd like to refinance my home and obtain cash at closing."), RPH("RPH", "I am purchasing a home.");
  // , AI("AI"), AJS("AJS"), AJP("AJP"), AWO(
  // "AWO"), PRP("PRP"), SRP("SRP"), IRP("IRP");
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
  private CTMRefinanceIndicator(String code, String description) {
    this.code        = code;
    this.description = description;

  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * toCTMRefinanceIndicator.
   *
   * @param   code  String
   *
   * @return  CTMRefinanceIndicator
   */
  public static CTMRefinanceIndicator toCTMRefinanceIndicator(String code) {
    if (code == null) {
      return null;
    }

    for (CTMRefinanceIndicator b : CTMRefinanceIndicator.values()) {
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
