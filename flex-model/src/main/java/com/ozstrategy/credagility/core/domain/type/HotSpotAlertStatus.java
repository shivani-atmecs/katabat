package com.ozstrategy.credagility.core.domain.type;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/16/2014 16:37
 */
public enum HotSpotAlertStatus {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  DRAFT, ACTIVE, RETIRED, DELETED, ENABLE, DISABLE;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * convert.
   *
   * @param   statusType  String
   *
   * @return  HotSpotAlertStatus
   */
  public static HotSpotAlertStatus convert(String statusType) {
    if ((statusType == null) || statusType.trim().isEmpty()) {
      return null;
    }

    return valueOf(statusType);
  }

}
