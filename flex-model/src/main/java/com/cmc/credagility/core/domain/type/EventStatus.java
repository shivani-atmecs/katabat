package com.cmc.credagility.core.domain.type;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/16/2014 14:21
 */
public enum EventStatus {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  INIT("INIT"), INPROCESS("INPROCESS"), RETRY("RETRY"), FAILED("FAILED"), SUCCEEDED("SUCCEEDED"),
  CANCELLED("CANCELLED");

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String strValue;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  private EventStatus() {
    this.strValue = this.name();
  }

  private EventStatus(String strValue) {
    this.strValue = strValue;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Enum#toString()
   */
  @Override public String toString() {
    return strValue;
  }
}
