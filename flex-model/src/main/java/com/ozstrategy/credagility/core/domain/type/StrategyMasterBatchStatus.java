package com.ozstrategy.credagility.core.domain.type;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/16/2014 16:38
 */
public enum StrategyMasterBatchStatus {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  IN_PROCESS, ENDED, SUCCESS;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * convert.
   *
   * @param   statusType  String
   *
   * @return  StrategyMasterBatchStatus
   */
  public static StrategyMasterBatchStatus convert(String statusType) {
    try {
      return valueOf(statusType.toUpperCase());
    } catch (Exception e) {
      return IN_PROCESS;
    }
  }

}
