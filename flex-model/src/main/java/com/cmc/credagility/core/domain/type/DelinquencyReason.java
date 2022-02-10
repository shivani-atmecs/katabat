package com.cmc.credagility.core.domain.type;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/16/2014 14:20
 */
public enum DelinquencyReason {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  LOJ("Loss of Job"), MTE("Major Tax Expense"), MDE("Medical/Dental Expenses"), AE("Attorney Expense"),
  OR("Other Reason"), NEW("Newly employed"), NLP("Newly employed with less pay"), FIL("Family illness"), DIV("Divorce"),
  TMD("Too much debt"), UME("Unexpected major expense"), OST("Oversight"),
  UOI("Unemployed but have other income source"), DOI("Disability - only income"), RET("Retired"),
  SOI("Social Security - only income"), BCL("Business closed"), BSL("Business slow");

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String value;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  private DelinquencyReason(String value) {
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
