package com.cmc.credagility.core.domain.sor;

/**
 * Created by zhubq on 2/29/16.
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  02/29/2016 13:45
 */
public enum TransCreatorTypeEnum {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  SYSTEM("System"), WEBSITE("Website"), AGENT("Agent");

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String strValue;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new TransCreatorTypeEnum object.
   */
  TransCreatorTypeEnum() {
    this.strValue = this.name();
  }

  /**
   * Creates a new TransCreatorTypeEnum object.
   *
   * @param  strValue  String
   */
  TransCreatorTypeEnum(String strValue) {
    this.strValue = strValue;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Enum#toString()
   */
  @Override public String toString() {
    return this.strValue;
  }
}
