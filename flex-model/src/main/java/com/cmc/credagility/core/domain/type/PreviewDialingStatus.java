package com.cmc.credagility.core.domain.type;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/16/2014 14:26
 */
public enum PreviewDialingStatus {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  WAITING, INPROCESS, FINISHED, CANCELED, PAUSED, EXPIRED;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * toPreviewDialingStatus.
   *
   * @param   strValue  String
   *
   * @return  PreviewDialingStatus
   */
  public static PreviewDialingStatus toPreviewDialingStatus(String strValue) {
    try {
      return PreviewDialingStatus.valueOf(strValue.toUpperCase());
    } catch (Exception e) {
      return null;
    }
  }
}
