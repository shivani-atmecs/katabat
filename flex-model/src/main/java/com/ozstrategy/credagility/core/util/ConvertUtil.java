package com.ozstrategy.credagility.core.util;

import com.cmc.credagility.core.domain.util.DateUtil;

import java.math.BigDecimal;
import java.util.Date;


/**
 * Created by IntelliJ IDEA. User: rojer Date: 11-03-27 Time: 5:09 PM To change this template use File | Settings | File
 * Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public class ConvertUtil {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   value  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static boolean isBigDecimalValue(String value) {
    if (toBigDecimal(value) == null) {
      return false;
    } else {
      return true;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   value  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static boolean isBooleanValue(String value) {
    if (toBoolean(value) == null) {
      return false;
    } else {
      return true;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   value  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static boolean isDateValue(String value) {
    if (toDate(value) == null) {
      return false;
    } else {
      return true;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   value  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static boolean isIntegerValue(String value) {
    if (toInteger(value) == null) {
      return false;
    } else {
      return true;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   value  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static boolean isLongValue(String value) {
    if (toLong(value) == null) {
      return false;
    } else {
      return true;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   value  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static BigDecimal toBigDecimal(String value) {
    try {
      return new BigDecimal(value);
    } catch (NumberFormatException e) { }
    catch (Exception e) { }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   value  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static Boolean toBoolean(String value) {
    if ("Y".equalsIgnoreCase(value)
          || "Yes".equalsIgnoreCase(value)
          || "T".equalsIgnoreCase(value)
          || "True".equalsIgnoreCase(value)) {
      return true;
    } else if ("N".equalsIgnoreCase(value)
          || "No".equalsIgnoreCase(value)
          || "F".equalsIgnoreCase(value)
          || "False".equalsIgnoreCase(value)) {
      return false;
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   value  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static Date toDate(String value) {
    try {
      return DateUtil.toDate(value);
    } catch (Exception e) { }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   value  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static Integer toInteger(String value) {
    try {
      return Integer.valueOf(value);
    } catch (NumberFormatException e) { }
    catch (Exception e) { }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   value  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static Long toLong(String value) {
    try {
      return Long.valueOf(value);
    } catch (NumberFormatException e) { }
    catch (Exception e) { }

    return null;
  }
} // end class ConvertUtil
