package com.cmc.credagility.core.domain.customer;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  02/27/2015 11:17
 */
public enum CustomerScoreSource {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  CLIENT("Client");

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** String value. */
  private String strValue;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Define enum.
   */
  private CustomerScoreSource() {
    this.strValue = this.name();
  }

  /**
   * Define enum with string value.
   *
   * @param  strValue  $param.type$
   */
  private CustomerScoreSource(String strValue) {
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
