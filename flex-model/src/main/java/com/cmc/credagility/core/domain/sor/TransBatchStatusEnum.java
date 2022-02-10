package com.cmc.credagility.core.domain.sor;

/**
 * Created by zhubq on 3/4/16.
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  03/04/2016 14:21
 */
public enum TransBatchStatusEnum {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  SAVED("Saved"), SUBMITTED("Submitted"), POSTED("Posted"), DELETED("Deleted"), RELEASED("Released"),
  INPROCESS("In Process"), REJECTED("Rejected");

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String strValue;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new TransCreatorTypeEnum object.
   */
  TransBatchStatusEnum() {
    this.strValue = this.name();
  }

  /**
   * Creates a new TransCreatorTypeEnum object.
   *
   * @param  strValue  String
   */
  TransBatchStatusEnum(String strValue) {
    this.strValue = strValue;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for by name.
   *
   * @param   name  String
   *
   * @return  TransBatchStatusEnum
   */
  public static TransBatchStatusEnum getByName(String name) {
    for (TransBatchStatusEnum transBatchStatusEnum : TransBatchStatusEnum.values()) {
      if (transBatchStatusEnum.name().equals(name)) {
        return transBatchStatusEnum;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

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
    return this.strValue;
  }
}
