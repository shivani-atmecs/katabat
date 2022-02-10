package com.cmc.credagility.core.domain.type;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/16/2014 14:16
 */
public enum CampaignStatus {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  START("Start"), STOP("Stop"), INPROCESS("Inprocess"), COMPLETED("Completed");

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** String value. */
  private String strValue;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Define enum.
   */
  private CampaignStatus() {
    this.strValue = this.name();
  }

  /**
   * Define enum with string value.
   *
   * @param  strValue  DOCUMENT ME!
   */
  private CampaignStatus(String strValue) {
    this.strValue = strValue;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * toCampaignStatus.
   *
   * @param   strValue  String
   *
   * @return  CampaignStatus
   */
  public static CampaignStatus toCampaignStatus(String strValue) {
    try {
      return valueOf(strValue.toUpperCase());
    } catch (Exception e) {
      return null;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the string value for the enum.
   *
   * @return  enum string value
   */
  @Override public String toString() {
    return strValue;
  }
}
