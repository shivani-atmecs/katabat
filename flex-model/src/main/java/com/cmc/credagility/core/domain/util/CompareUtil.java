package com.cmc.credagility.core.domain.util;

import java.math.BigDecimal;

import java.time.LocalDate;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.joda.time.LocalDateTime;
import org.springframework.util.StringUtils;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 17:11
 */
public class CompareUtil {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * lt0: date 1 is earlier than date 2 ==0: same day gt0: date 1 is later than date 2
   *
   * @param   date1  DOCUMENT ME!
   * @param   date2  DOCUMENT ME!
   *
   * @return  lt0:
   */
  public static int compareDateOnly(Date date1, Date date2) {
    if ((date1 == null) && (date2 == null)) {
      return 0;
    }

    if ((date1 == null) || (date2 == null)) {
      return 1; // at least we know they are not equals
    }

    // Tried to use LocalDate now = new LocalDate(). However, in production
    // server Ubuntu 7.1 + jdk 1.6.0_03-b05, the LocalDate is always one day in
    // advance.
    Calendar cal = GregorianCalendar.getInstance();
    cal.setTime(date1);

    LocalDate d1 = LocalDate.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH));
    cal.setTime(date2);

    LocalDate d2 = LocalDate.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH));

    return d1.compareTo(d2);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for all zeros or no digits.
   *
   * @param   candidate  String
   *
   * @return  boolean
   */
  public static boolean isAllZerosOrNoDigits(String candidate) {
    if (!StringUtils.hasText(candidate)) {
      return true;
    }

    // replace all non digits characters to empty
    candidate = candidate.replaceAll("[^0-9]", "");

    Long val = 0L;

    try {
      val = Long.valueOf(candidate);
    } catch (Exception e) {
      // Should be all digits
      return false;
    }

    // all 0
    return val.compareTo(0L) == 0;

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for date earlier.
   *
   * @param   date1  Date
   * @param   date2  Date
   *
   * @return  boolean
   */
  public static boolean isDateEarlier(Date date1, Date date2) {
    if (date1 == null) { // date1 is abnormal, return false
      return false;
    }

    if (date2 == null) { // date2 condition not specified, always true
      return true;
    }

    return compareDateOnly(date1, date2) < 0;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for date earlier or equal.
   *
   * @param   date1  Date
   * @param   date2  Date
   *
   * @return  boolean
   */
  public static boolean isDateEarlierOrEqual(Date date1, Date date2) {
    if (date1 == null) { // date1 is abnormal, return false
      return false;
    }

    if (date2 == null) { // date2 condition not specified, always true
      return true;
    }

    return compareDateOnly(date1, date2) <= 0;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for date equal.
   *
   * @param   date1  Date
   * @param   date2  Date
   *
   * @return  boolean
   */
  public static boolean isDateEqual(Date date1, Date date2) {
    if ((date1 == null) && (date2 == null)) {
      return true;
    }

    if ((date1 == null) || (date2 == null)) {
      return false;
    }

    return compareDateOnly(date1, date2) == 0;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for date later.
   *
   * @param   date1  Date
   * @param   date2  Date
   *
   * @return  boolean
   */
  public static boolean isDateLater(Date date1, Date date2) {
    if (date1 == null) { // date1 is abnormal
      return false;
    }

    if (date2 == null) {
      return true;
    }

    return compareDateOnly(date1, date2) > 0;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for date later or equal.
   *
   * @param   date1  Date
   * @param   date2  Date
   *
   * @return  boolean
   */
  public static boolean isDateLaterOrEqual(Date date1, Date date2) {
    if (date1 == null) { // date1 is abnormal
      return false;
    }

    if (date2 == null) {
      return true;
    }

    return compareDateOnly(date1, date2) >= 0;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Case-insensitively check if a String element is in a String Array.
   *
   * @param   element  DOCUMENT ME!
   * @param   array    DOCUMENT ME!
   *
   * @return  case-insensitively check if a String element is in a String Array.
   */
  public static boolean isInArray(String element, String[] array) {
    if (element == null) {
      return false;
    }

    for (String a : array) {
      if (element.equalsIgnoreCase(a)) {
        return true;
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Case-insensitively check if a String element is in an enum. The second parameter is normally provided by
   * enum.values().
   *
   * @param   e       DOCUMENT ME!
   * @param   values  enum.values()
   *
   * @return  case-insensitively check if a String element is in an enum.
   */
  public static boolean isInEnum(String e, Object[] values) {
    if (e == null) {
      return false;
    }

    for (Object o : values) {
      if (e.equalsIgnoreCase(o.toString())) {
        return true;
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Return the max of all. Ignore null. If all null, return null.
   *
   * @param   vs  DOCUMENT ME!
   *
   * @return  return the max of all.
   */
  public static BigDecimal max(BigDecimal... vs) {
    BigDecimal retVal = null;

    for (BigDecimal v : vs) {
      retVal = max(retVal, v);
    }

    return retVal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Return bigger of the two. If one is null, return the other.
   *
   * @param   v1  DOCUMENT ME!
   * @param   v2  DOCUMENT ME!
   *
   * @return  return bigger of the two.
   */
  public static BigDecimal max(BigDecimal v1, BigDecimal v2) {
    if (v1 == null) {
      return v2;
    }

    if (v2 == null) {
      return v1;
    }

    return (v1.compareTo(v2) > 0) ? v1 : v2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Return the min of all. Ignore null. If all null, return null.
   *
   * @param   vs  DOCUMENT ME!
   *
   * @return  return the min of all.
   */
  public static BigDecimal min(BigDecimal... vs) {
    BigDecimal retVal = null;

    for (BigDecimal v : vs) {
      retVal = min(retVal, v);
    }

    return retVal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Return smaller of the two. If one is null, return the other.
   *
   * @param   v1  DOCUMENT ME!
   * @param   v2  DOCUMENT ME!
   *
   * @return  return smaller of the two.
   */
  public static BigDecimal min(BigDecimal v1, BigDecimal v2) {
    if (v1 == null) {
      return v2;
    }

    if (v2 == null) {
      return v1;
    }

    return (v1.compareTo(v2) < 0) ? v1 : v2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * nullSafeEquals.
   *
   * @param   object1  Object
   * @param   object2  Object
   *
   * @return  boolean
   */
  public static boolean nullSafeEquals(Object object1, Object object2) {
    if ((object1 != null) && (object2 != null)) {
      return object1.equals(object2);
    } else if ((object1 == null) && (object2 == null)) {
      return true;
    }

    return false;
  }

  public static int compareTimeOnly(Date date1, Date date2) {
    if ((date1 == null) && (date2 == null)) {
      return 0;
    }

    if ((date1 == null) || (date2 == null)) {
      return 1; // at least we know they are not equals
    }

    LocalDateTime d1 = new LocalDateTime(date1.getTime());
    LocalDateTime d2 = new LocalDateTime(date2.getTime());

    return d1.compareTo(d2);
  }
} // end class CompareUtil
