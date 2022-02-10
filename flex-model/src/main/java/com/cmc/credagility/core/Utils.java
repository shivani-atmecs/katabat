package com.cmc.credagility.core;

/**
 * Created by yongliu on 10/27/17.
 *
 * @author   <a href="mailto:yong.liu@ozstrategy.com">Yong Liu</a>
 * @version  10/27/2017 14:54
 */
public class Utils {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * convertToBoolean.
   *
   * @param   value  String
   *
   * @return  Boolean
   */
  public static Boolean convertToBoolean(String value) {
    if (value == null) {
      return Boolean.FALSE;
    }

    return "true".equalsIgnoreCase(value.trim()) || "y".equalsIgnoreCase(value.trim()) || "yes".equalsIgnoreCase(value);
  }
}
