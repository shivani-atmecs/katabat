package com.cmc.credagility.core.domain.payment;

import java.util.HashMap;
import java.util.Map;


/**
 * Return data structure for payment processor. Could be used in general purpose.
 *
 * @author   Ye Zhang
 * @version  10/15/2014 11:22
 */
public class InfoCode {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String              infoCode = null;
  private Map<Object, Object> infoData = new HashMap<Object, Object>();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for info code.
   *
   * @return  String
   */
  public String getInfoCode() {
    return infoCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for info data.
   *
   * @return  Map
   */
  public Map<Object, Object> getInfoData() {
    return infoData;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for info code.
   *
   * @param  infoCode  String
   */
  public void setInfoCode(String infoCode) {
    this.infoCode = infoCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for info data.
   *
   * @param  infoData  Map
   */
  public void setInfoData(Map<Object, Object> infoData) {
    this.infoData = infoData;
  }

} // end class InfoCode
