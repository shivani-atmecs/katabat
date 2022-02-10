package com.cmc.credagility.core.domain.type;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/16/2014 14:29
 */
public enum SLMDelinquencyReason {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  UNEM("Unemployment"), INRE("Income Reduction"), SLFE("Self-Employed - slowdown"), OVER("Overextended"),
  UDRE("Under Employed"), KNOW("Unaware Repayment Began"), UNKW("Other");

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String value;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  private SLMDelinquencyReason(String value) {
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
