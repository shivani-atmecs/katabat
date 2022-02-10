package com.ozstrategy.credagility.core.domain.type;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/16/2014 16:37
 */
public enum KeyWords {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  ANSWER("answer");

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String strValue;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  private KeyWords() {
    this.strValue = this.name();
  }

  private KeyWords(String strValue) {
    this.strValue = strValue;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  Enum#toString()
   */
  @Override public String toString() {
    return strValue;
  }

}
