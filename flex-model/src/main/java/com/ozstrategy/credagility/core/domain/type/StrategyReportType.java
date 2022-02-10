package com.ozstrategy.credagility.core.domain.type;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/16/2014 16:38
 */
public enum StrategyReportType {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  STRATEGY, LOADER, ALL;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * toStrategyReportType.
   *
   * @param   strVar  String
   *
   * @return  StrategyReportType
   */
  public static StrategyReportType toStrategyReportType(String strVar) {
    try {
      return valueOf(strVar.toUpperCase());
    } catch (Exception e) {
      return STRATEGY;
    }
  }
}
