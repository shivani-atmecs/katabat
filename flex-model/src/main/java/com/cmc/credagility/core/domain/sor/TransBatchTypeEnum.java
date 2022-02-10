package com.cmc.credagility.core.domain.sor;

/**
 * Created by zhubq on 3/4/16.
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  03/04/2016 14:03
 */
public enum TransBatchTypeEnum {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  FEE("Fee"), PAYMENT("Payment");

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String strValue;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new TransCreatorTypeEnum object.
   */
  TransBatchTypeEnum() {
    this.strValue = this.name();
  }

  /**
   * Creates a new TransCreatorTypeEnum object.
   *
   * @param  strValue  String
   */
  TransBatchTypeEnum(String strValue) {
    this.strValue = strValue;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  Enum#toString()
   */
  @Override
  public String toString() {
    return this.strValue;
  }
}
