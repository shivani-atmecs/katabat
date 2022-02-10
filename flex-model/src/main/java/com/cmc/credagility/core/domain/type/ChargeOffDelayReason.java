package com.cmc.credagility.core.domain.type;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/16/2014 14:17
 */
public enum ChargeOffDelayReason {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  Chapter7ChargeOff("07", "Chapter 7 Charge Off"), ChargeOffFraud("FR", "Charge Off Fraud"), BadDebt("BD", "Bad Debt"),
  COSettlement("ST", "C/O Settlement"), CODeceased("DC", "C/O Deceased"),
  Chapter13ChargeOff("12", "Chapter 13 Charge Off");

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** String value. */
  private String code;
  private String description;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Define enum with string value.
   *
   * @param  code         strValue DOCUMENT ME!
   * @param  description  DOCUMENT ME!
   */
  private ChargeOffDelayReason(String code, String description) {
    this.code        = code;
    this.description = description;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * convert.
   *
   * @param   strType  String
   *
   * @return  ChargeOffDelayReason
   */
  public static ChargeOffDelayReason convert(String strType) {
    if ((strType == null) || strType.trim().isEmpty()) {
      return null;
    } else {
      return valueOf(strType);


    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for reason.
   *
   * @return  String
   */
  public String getReason() {
    return this.code + " - " + this.description;
  }
}
