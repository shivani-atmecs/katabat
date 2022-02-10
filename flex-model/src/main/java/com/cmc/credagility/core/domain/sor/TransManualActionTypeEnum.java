package com.cmc.credagility.core.domain.sor;

/**
 * Created by zhubq on 3/1/16.
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  03/01/2016 14:18
 */
public enum TransManualActionTypeEnum {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  REVERSAL("Reversal"), REINSTATEMENT("Reinstatement");

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String strValue;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new TransCreatorTypeEnum object.
   */
  TransManualActionTypeEnum() {
    this.strValue = this.name();
  }

  /**
   * Creates a new TransCreatorTypeEnum object.
   *
   * @param  strValue  String
   */
  TransManualActionTypeEnum(String strValue) {
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
