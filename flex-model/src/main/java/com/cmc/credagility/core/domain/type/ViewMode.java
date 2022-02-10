package com.cmc.credagility.core.domain.type;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/16/2014 14:31
 */
public enum ViewMode {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  MANUAL, READ_ONLY, PREVIEW_DIALING;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * toViewMode.
   *
   * @param   strValue  String
   *
   * @return  ViewMode
   */
  public static ViewMode toViewMode(String strValue) {
    try {
      return ViewMode.valueOf(strValue.toUpperCase());
    } catch (Exception e) {
      return null;
    }
  }
}
