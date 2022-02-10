package com.cmc.credagility.core.domain.type;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/16/2014 14:20
 */
public enum DelinquencyResolution {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  NE("Newly Employed"), TP("Tax Expense Paid"), MP("Medical/Dental Expense Paid"), AP("Attorney Expense Paid"),
  OT("Other");

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String value;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  private DelinquencyResolution(String value) {
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
