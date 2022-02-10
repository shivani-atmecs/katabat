package com.cmc.credagility.core.domain.type;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/16/2014 14:16
 */
public enum ChannelSource {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  BATCH("Batch"), EVENT("Event");

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** String value. */
  private String strValue;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Define enum.
   */
  private ChannelSource() {
    this.strValue = this.name();
  }

  /**
   * Define enum with string value.
   *
   * @param  strValue  DOCUMENT ME!
   */
  private ChannelSource(String strValue) {
    this.strValue = strValue;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * toChannelSource.
   *
   * @param   strValue  String
   *
   * @return  ChannelSource
   */
  public static ChannelSource toChannelSource(String strValue) {
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
