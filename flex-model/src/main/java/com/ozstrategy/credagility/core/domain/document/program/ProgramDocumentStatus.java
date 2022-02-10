package com.ozstrategy.credagility.core.domain.document.program;

/**
 * Created by zhubq on 12/11/15.
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  12/11/2015 22:53
 */
public enum ProgramDocumentStatus {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  INIT("Init"), FAIlED("Failed"), SEND("Send");

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String strValue;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new StatusCodeEnum object.
   */
  ProgramDocumentStatus() {
    this.strValue = this.name();
  }

  /**
   * Creates a new StatusCodeEnum object.
   *
   * @param  strValue  String
   */
  ProgramDocumentStatus(String strValue) {
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
