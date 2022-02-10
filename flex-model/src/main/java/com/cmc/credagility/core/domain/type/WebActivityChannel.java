package com.cmc.credagility.core.domain.type;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/16/2014 14:32
 */
public enum WebActivityChannel {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  AGENCY("Agency"), DEBTORSITE("DebtorSite"), IVR("Ivr"), BATCH("Batch"), BCC("Bcc"), FLEXCHANNEL("FlexChannel"),
  WEBSERVICE("WebService"), API("Api");

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** String value. */
  private String strValue;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Define enum.
   */
  private WebActivityChannel() {
    this.strValue = this.name();
  }

  /**
   * Define enum with string value.
   *
   * @param  strValue  $param.type$
   */
  private WebActivityChannel(String strValue) {
    this.strValue = strValue;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * convert.
   *
   * @param   strValue  String
   *
   * @return  WebActivityChannel
   */
  public static WebActivityChannel convert(String strValue) {
    if ((strValue == null) || strValue.trim().isEmpty()) {
      return null;
    }

    return valueOf(strValue);
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
