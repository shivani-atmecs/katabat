package com.ozstrategy.credagility.core.domain.workflow;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/16/2014 17:00
 */
public enum WorkflowPageType {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  DEFAULT_THANKYOU_PAGE("thankYou"), STATIC_PAGE("static"), ANOTHER_SURVEY("anotherSurvey"),
  PRESENT_PROGRAM("presentProgram");

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String strValue;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  private WorkflowPageType(String strValue) {
    this.strValue = strValue;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for str value.
   *
   * @return  String
   */
  public String getStrValue() {
    return strValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for str value.
   *
   * @param  strValue  String
   */
  public void setStrValue(String strValue) {
    this.strValue = strValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Enum#toString()
   */
  @Override public String toString() {
    return strValue;
  }
}
