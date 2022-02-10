package com.cmc.credagility.core.domain.type;

/**
 * DelinquencyReasonNCCCard.java is the enum class for populating the Delinquency Reasons only for NCC Card.
 *
 * @author   Katta Srinivas CMC - Karthikeyan Palanivelu Etisbew - Praveen Batchu
 * @version  1.0 Apr 27, 2009; Created
 */

public enum DelinquencyReasonNCCCard {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  LOJ("Loss of job"), NEW("Newly employed"), NLP("Newly employed with less pay"), FIL("Family illness"), DIV("Divorce"),
  TMD("Too much debt"), UME("Unexpected major expense"), OST("Oversight"),
  UOI("Unemployed but have other income source"), DOI("Disability - only income"), RET("Retired"),
  SOI("Social Security - only income"), BCL("Business closed"), BSL("Business slow");

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String value;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  private DelinquencyReasonNCCCard(String value) {
    this.value = value;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for value.
   *
   * @return  String
   */
  public String getValue() {
    return this.value;
  }

}
