package com.cmc.credagility.core.domain.type;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/16/2014 14:20
 */
public enum DeferralSuspensionRecordType {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  D("D"), // Deferral
  S("S"); // Suspension

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String strValue;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  private DeferralSuspensionRecordType() {
    this.strValue = this.name();
  }

  private DeferralSuspensionRecordType(String strValue) {
    this.strValue = strValue;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * convert.
   *
   * @param   strValue  String
   *
   * @return  DeferralSuspensionRecordType
   */
  public static DeferralSuspensionRecordType convert(String strValue) {
    try {
      return valueOf(strValue.toUpperCase());
    } catch (Exception e) {
      return null;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Enum#toString()
   */
  @Override public String toString() {
    return strValue;
  }

}
