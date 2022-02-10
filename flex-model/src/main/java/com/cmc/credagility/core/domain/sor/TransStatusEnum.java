package com.cmc.credagility.core.domain.sor;


/**
 * Created by zhubq on 11/26/15.
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  11/26/2015 11:29
 */
public enum TransStatusEnum {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  PROCESSED("Processed"), CANCELLED("Cancelled"), REPLAY("Replay"), INIT("Init"), REVERSAL_PENDING("ReversalPending"),
  REINSTATEMENT_PENDING("ReinstatementPending"), REINSTATED("Reinstated"), REVERSED("Reversed");

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String strValue;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new StatusCodeEnum object.
   */
  TransStatusEnum() {
    this.strValue = this.name();
  }

  /**
   * Creates a new StatusCodeEnum object.
   *
   * @param  strValue  String
   */
  TransStatusEnum(String strValue) {
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
