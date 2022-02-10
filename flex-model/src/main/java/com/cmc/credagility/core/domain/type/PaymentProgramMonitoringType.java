package com.cmc.credagility.core.domain.type;

/**
 * Created by wangjp on 16/8/2.
 *
 * @author   <a href="mailto:jianping.wang@ozstrategy.com">Jianping Wang</a>
 * @version  08/03/2016 09:33
 */
public enum PaymentProgramMonitoringType {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  NONMONITORING("NonMonitoring"), TOTALAMOUNTMONITORING("TotalAmountMonitoring"),
  INSTALLMENTAMOUNTMONITORING("InstallmentAmountMonitoring");

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** String value. */
  private String strValue;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Define enum.
   */
  private PaymentProgramMonitoringType() {
    this.strValue = this.name();
  }

  /**
   * Define enum with string value.
   *
   * @param  strValue  DOCUMENT ME!
   */
  private PaymentProgramMonitoringType(String strValue) {
    this.strValue = strValue;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * toPaymentProgramMonitoringType.
   *
   * @param   strValue  String
   *
   * @return  PaymentProgramMonitoringType
   */
  public static PaymentProgramMonitoringType toPaymentProgramMonitoringType(String strValue) {
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
