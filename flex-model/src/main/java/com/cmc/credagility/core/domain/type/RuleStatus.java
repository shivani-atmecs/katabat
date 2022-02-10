package com.cmc.credagility.core.domain.type;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/16/2014 14:28
 */
public enum RuleStatus {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  DRAFT("Draft"),       // rule have not be valid yet
  VALID("Valid"),       // rule is valid
  INVALID("Invalid"),   // rule is invalid, contains some validation error
  COMPILED("Compiled"), // complete rule content has generated
  DEPLOYED("Deployed");

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** String value. */
  private String strValue;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Define enum.
   */
  private RuleStatus() {
    this.strValue = this.name();
  }

  /**
   * Define enum with string value.
   *
   * @param  strValue  $param.type$
   */
  private RuleStatus(String strValue) {
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
