package com.ozstrategy.credagility.core.domain.type;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/16/2014 16:36
 */
public enum DashboardType {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  GRID;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * toDashboardType.
   *
   * @param   strValue  String
   *
   * @return  DashboardType
   */
  public static DashboardType toDashboardType(String strValue) {
    try {
      return valueOf(strValue.toUpperCase());
    } catch (Exception e) {
      return null;
    }
  }

}
