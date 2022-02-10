package com.cmc.credagility.core.domain.sor;


/**
 * Created by zhubq on 11/26/15.
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  11/26/2015 11:29
 */
public enum TransSourceTypeEnum {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  JOBIMPORT("JobImport"), OCAJOBIMPORT("OCAJobImport"), ONLINEBATCH("OnlineBatch"), LOCAL("Local"),
  TRANSACTION("TransAction");

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String strValue;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new StatusCodeEnum object.
   */
  TransSourceTypeEnum() {
    this.strValue = this.name();
  }

  /**
   * Creates a new StatusCodeEnum object.
   *
   * @param  strValue  String
   */
  TransSourceTypeEnum(String strValue) {
    this.strValue = strValue;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  Enum#toString()
   */
  @Override public String toString() {
    return this.strValue;
  }


}
