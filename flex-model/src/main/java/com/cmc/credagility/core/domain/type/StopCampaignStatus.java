package com.cmc.credagility.core.domain.type;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/16/2014 14:30
 */
public enum StopCampaignStatus {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  INIT, TERMINATED, TERMINATION_PENDING;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * toStopCampaignStatus.
   *
   * @param   strValue  String
   *
   * @return  StopCampaignStatus
   */
  public static StopCampaignStatus toStopCampaignStatus(String strValue) {
    try {
      return valueOf(strValue.toUpperCase());
    } catch (Exception e) {
      return null;
    }
  }
}
