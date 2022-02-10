package com.cmc.credagility.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.TimeZone;

import org.apache.commons.lang3.StringEscapeUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.i18n.LocaleContextHolder;

import org.springframework.util.StringUtils;

import com.cmc.credagility.util.constant.Constants;


/**
 * Date Utility Class This is used to convert Strings to Dates and Timestamps.
 *
 * @author   <a href="mailto:matt@raibledesigns.com">Matt Raible</a> Modified by <a href="mailto:dan@getrolling.com">Dan
 *           Kibler</a> to correct time pattern. Minutes should be mm not MM (MM is month).
 * @version  $Revision: 1.7.2.1 $ $Date: 2006-10-03 12:58:45 -0600 (Tue, 03 Oct 2006) $
 */
public class DateUtil {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static Logger log                = LoggerFactory.getLogger(DateUtil.class);
  private static String defaultDatePattern = null;
  private static String defaultTimezone    = null;
  private static String timePattern        = "HH:mm";

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * checkNowIsBetweenStartAndEndTime.
   *
   * @param   startTime  Date
   * @param   endTime    Date
   *
   * @return  boolean
   */
  public static boolean checkNowIsBetweenStartAndEndTime(Date startTime, Date endTime) {
    boolean          rs;
    SimpleDateFormat df          = new SimpleDateFormat("HH:mm:ss");
    Date             now         = new Date();
    long             startSecond = timeToSecond(startTime);
    long             endSecond   = timeToSecond(endTime);
    long             nowSecond   = timeToSecond(now);
    log.info("startSecond: " + startSecond);
    log.info("endSecond: " + endSecond);
    log.info("nowSecond: " + nowSecond);

    if (startSecond < endSecond) {
      rs = (nowSecond >= startSecond) && (nowSecond < endSecond);
    } else {
      try {
        Date tempEndTime   = df.parse("23:59:59");
        Date tempStartTime = df.parse("00:00:01");

        long tempStartSecond = timeToSecond(tempStartTime);
        long tempEndSecond   = timeToSecond(tempEndTime);
        log.info("tempStartSecond.." + tempStartSecond);
        log.info("tempEndSecond.." + tempEndSecond);
        rs = ((nowSecond >= startSecond) && (nowSecond < tempEndSecond))
          || ((nowSecond >= tempStartSecond) && (nowSecond < endSecond));


      } catch (ParseException e) {
        e.printStackTrace();
        rs = false;
      }

    }

    return rs;
  } // end method checkNowIsBetweenStartAndEndTime

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * This method generates a string representation of a date based on the System Property 'dateFormat' in the format you
   * specify on input.
   *
   * @param   aDate  A date to convert
   *
   * @return  a string representation of the date
   */
  public static final String convertDateToString(Date aDate) {
    return getDateTime(getDatePattern(), aDate);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * This method converts a String to a date using the datePattern.
   *
   * @param   strDate  String
   *
   * @return  Date
   *
   * @throws  java.text.ParseException  exception
   * @throws  ParseException            DOCUMENT ME!
   */
  public static Date convertStringToDate(String strDate) throws ParseException {
    Date aDate = null;

    try {
      if (log.isDebugEnabled()) {
        log.debug("converting date with pattern: " + getDatePattern());
      }

      aDate = convertStringToDate(getDatePattern(), strDate);
    } catch (ParseException pe) {
      log.error("Could not convert '" + strDate
        + "' to a date, throwing exception", pe);
      throw new ParseException(pe.getMessage(), pe.getErrorOffset());

    }

    return aDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * This method generates a string representation of a date/time in the format you specify on input.
   *
   * @param   aMask    String
   * @param   strDate  String
   *
   * @return  Date
   *
   * @throws  java.text.ParseException  exception
   * @throws  ParseException            DOCUMENT ME!
   */
  public static final Date convertStringToDate(String aMask, String strDate) throws ParseException {
    if ((strDate == null) || strDate.equals("")) {
      return null;
    }

    SimpleDateFormat df   = null;
    Date             date = null;
    df = new SimpleDateFormat(aMask);

    if (log.isDebugEnabled()) {
      log.debug("converting '" + StringEscapeUtils.escapeXml10(strDate) + "' to date with mask '" + aMask
        + "'");
    }

    try {
      date = df.parse(strDate);
    } catch (ParseException pe) {
      // log.error("ParseException: " + pe);
      throw new ParseException(pe.getMessage(), pe.getErrorOffset());
    }

    return (date);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // Not throw exception from this method
  /**
   * DOCUMENT ME!
   *
   * @param   aMask    DOCUMENT ME!
   * @param   strDate  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static final Date convertStringToDate2(String aMask, String strDate) {
    Date date = null;

    if (StringUtils.hasText(strDate)) {
      try {
        SimpleDateFormat df = new SimpleDateFormat(aMask);

        date = df.parse(strDate);
      } catch (ParseException pe) {
        log.error("ParseException: date string: " + strDate + ", expected format: " + aMask, pe);
      }
    }

    return (date);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * excludeDateZoneOffset.
   *
   * @param   inputDate  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static Calendar excludeDateZoneOffset(Date inputDate) {
    Calendar inputCalendar = Calendar.getInstance();
    inputCalendar.clear();
    inputCalendar.setTime(inputDate);

    Calendar now = (Calendar) inputCalendar.clone(); // save current timestamp
    inputCalendar.clear();                           // this clears the fields, including Calendar.ZONE_OFFSET
    inputCalendar.set(                               // set all fields back from the saved copy
      now.get(Calendar.YEAR),
      now.get(Calendar.MONTH),
      now.get(Calendar.DAY_OF_MONTH));

    return inputCalendar;

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * excludeTimeZoneOffset.
   *
   * @param   inputDate  Date
   *
   * @return  Calendar
   */
  public static Calendar excludeTimeZoneOffset(Date inputDate) {
    Calendar inputCalendar = Calendar.getInstance();
    inputCalendar.clear();
    inputCalendar.setTime(inputDate);

    Calendar now = (Calendar) inputCalendar.clone(); // save current timestamp
    inputCalendar.clear();                           // this clears the fields, including Calendar.ZONE_OFFSET
    inputCalendar.set(                               // set all fields back from the saved copy
      now.get(Calendar.YEAR),
      now.get(Calendar.MONTH),
      now.get(Calendar.DAY_OF_MONTH),
      now.get(Calendar.HOUR_OF_DAY),
      now.get(Calendar.MINUTE),
      now.get(Calendar.SECOND));

    inputCalendar.set(Calendar.MILLISECOND, now.get(Calendar.MILLISECOND));

    return inputCalendar;

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   date     DOCUMENT ME!
   * @param   pattern  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static String format(Date date, String pattern) {
    DateFormat df = createDateFormat(pattern);

    return df.format(date);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * formatDate.
   *
   * @param   date       Date
   * @param   formatter  String
   *
   * @return  Date
   */
  public static Date formatDate(Date date, String formatter) {
    if (date == null) {
      return null;
    }

    try {
      formatter = (formatter == null) ? "yyyy-MM-dd" : formatter;

      SimpleDateFormat sdf = new SimpleDateFormat(formatter);

      return sdf.parse(sdf.format(date));
    } catch (ParseException e) {
      e.printStackTrace();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   date  businessDataType DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static Date formatDateTime(Date date) {
    return formatDate(date, "yyyy-MM-dd HH:mm:ss");
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * This method attempts to convert an Oracle-formatted date in the form dd-MMM-yyyy to mm/dd/yyyy.
   *
   * @param   aDate  date from database as a string
   *
   * @return  formatted string for the ui
   */
  public static final String getDate(Date aDate) {
    SimpleDateFormat df          = null;
    String           returnValue = "";

    if (aDate != null) {
      df          = new SimpleDateFormat(getDatePattern());
      returnValue = df.format(aDate);
    }

    return (returnValue);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for date as string.
   *
   * @param   date    Date
   * @param   format  String
   *
   * @return  String
   */
  public static String getDateAsString(Date date, String format) {
    if ("Date".equalsIgnoreCase(format)) {
      format = getDatePattern();
    }

    SimpleDateFormat sdf        = new SimpleDateFormat(format);
    String           dateString = "";

    if (date != null) {
      dateString = sdf.format(date);
    }

    return dateString;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Return default datePattern (MM/dd/yyyy).
   *
   * @return  a string representing the date pattern on the UI
   */
  public static String getDatePattern() {
    Locale locale = LocaleContextHolder.getLocale();

    try {
      defaultDatePattern = ResourceBundle.getBundle(Constants.BUNDLE_KEY,
          locale).getString("date.format");
    } catch (MissingResourceException mse) {
      defaultDatePattern = "MM/dd/yyyy";
    }

    return defaultDatePattern;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * This method generates a string representation of a date's date/time in the format you specify on input.
   *
   * @param   aMask  the date pattern the string is in
   * @param   aDate  a date object
   *
   * @return  a formatted string representation of the date
   *
   * @see     java.text.SimpleDateFormat
   */
  public static final String getDateTime(String aMask, Date aDate) {
    SimpleDateFormat df          = null;
    String           returnValue = "";

    if (aDate == null) {
      log.error("aDate is null!");
    } else {
      df          = new SimpleDateFormat(aMask);
      returnValue = df.format(aDate);
    }

    return (returnValue);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for date time pattern.
   *
   * @return  String
   */
  public static String getDateTimePattern() {
    return DateUtil.getDatePattern() + " HH:mm:ss.S";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for date without time.
   *
   * @return  Date
   */
  public static Date getDateWithoutTime() {
    Calendar cal = Calendar.getInstance();
    cal.setTime(new Date());
    cal.set(Calendar.HOUR_OF_DAY, 0);
    cal.set(Calendar.MINUTE, 0);
    cal.set(Calendar.SECOND, 0);
    cal.set(Calendar.MILLISECOND, 0);

    return cal.getTime();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   date  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static Date getDateWithoutTime(Date date) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    cal.set(Calendar.HOUR_OF_DAY, 0);
    cal.set(Calendar.MINUTE, 0);
    cal.set(Calendar.SECOND, 0);
    cal.set(Calendar.MILLISECOND, 0);

    return cal.getTime();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~ Methods
  // ================================================================
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static String getSystemTimezone() {
    Locale locale = LocaleContextHolder.getLocale();

    try {
      defaultTimezone = ResourceBundle.getBundle(Constants.BUNDLE_KEY, locale).getString("ystem.timezone");
    } catch (MissingResourceException mse) {
      defaultTimezone = "US/Central";
    }

    return defaultTimezone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * This method returns the current date time in the format: MM/dd/yyyy HH:MM a
   *
   * @param   theTime  the current time
   *
   * @return  the current date/time
   */
  public static String getTimeNow(Date theTime) {
    return getDateTime(timePattern, theTime);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * This method returns the current date in the format: MM/dd/yyyy
   *
   * @return  Calendar
   *
   * @throws  java.text.ParseException  exception
   * @throws  ParseException            DOCUMENT ME!
   */
  public static Calendar getToday() throws ParseException {
    Date             today = new Date();
    SimpleDateFormat df    = new SimpleDateFormat(getDatePattern());

    // This seems like quite a hack (date -> string -> date),
    // but it works ;-)
    String   todayAsString = df.format(today);
    Calendar cal           = new GregorianCalendar();
    cal.setTime(convertStringToDate(todayAsString));

    return cal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * timeToSecond.
   *
   * @param   time  Date
   *
   * @return  long
   */
  public static long timeToSecond(Date time) {
    SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");

    String timeStr = df.format(time);

    if ("00:00:00".equals(timeStr)) {
      return 0L;
    } else {
      String[] timeArray = timeStr.split(":");

      return (Long.valueOf(timeArray[0]) * 3600) + (Long.valueOf(timeArray[1]) * 60) + Long.valueOf(timeArray[2]);
    }

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Check if new payment date is after cut off time.
   *
   * @param   newDate       DOCUMENT ME!
   * @param   originalDate  DOCUMENT ME!
   * @param   cutOffTime    DOCUMENT ME!
   *
   * @return  True - after cut off False - before cut off
   */
  public static boolean validateCutOffTime(Date newDate, Date originalDate, String cutOffTime) {
    if (!StringUtils.hasText(cutOffTime)) {
      return Boolean.FALSE;
    }

    try {
      // I. Define the current date time, new payment date, original payment date and cut off payment date time
      DateTimeFormatter formatterDate     = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      DateTimeFormatter formatterDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd h:mm a");
      StringBuilder     cutOffDateTimeSB  = new StringBuilder();

      LocalDate     today             = LocalDate.now(ZoneId.systemDefault());
      LocalDate     newLocalDate      = null;
      LocalDate     originalLocalDate = null;
      LocalDateTime currentDateTime   = today.atTime(LocalTime.now(ZoneId.systemDefault()));

      // get the cut off date time
      cutOffDateTimeSB.append(today.format(formatterDate));
      cutOffDateTimeSB.append(" ");
      cutOffDateTimeSB.append(cutOffTime);

      LocalDateTime cutOffDateTime = LocalDateTime.parse(cutOffDateTimeSB.toString(), formatterDateTime);

      // II. Check date for creating, editing and deleting payment
      // 1. new payment : originalDate = null && null != newDate
      if ((null == originalDate) && (null != newDate)) {
        newLocalDate = newDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // payment is scheduled (newDate isAfter today)
        if (newLocalDate.isAfter(today)) {
          return Boolean.FALSE;
        }

        // payment date is current day, check cut off time in part III
      }

      // 2. delete payment : newDate=null && originalDate != null
      if ((null == newDate) && (null != originalDate)) {
        originalLocalDate = originalDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // is payment date after today? (originalDate isAfter today)
        if (originalLocalDate.isAfter(today)) {
          return Boolean.FALSE;
        }

        // payment date is current day, check cut off time in part III
      }

      // 3. edit existing payment : newDate != null && originalDate != null
      if ((null != newDate) && (null != originalDate)) {
        originalLocalDate = originalDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // is original payment date after today? (originalDate isAfter today)
        if (originalLocalDate.isAfter(today)) {
          newLocalDate = newDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

          // is the new payment date today? (newDate isAfter today)
          if (newLocalDate.isAfter(today)) {
            return Boolean.FALSE;
          }

          // new payment date is current day, check cut off time in part III
        }

        // original payment date is current day, check cut off time in part III
      }

      // III. is after cut off time? (now isAfter cutOff)
      if (currentDateTime.isAfter(cutOffDateTime)) {
        return Boolean.TRUE;
      } else {
        return Boolean.FALSE;
      }
    } catch (Exception e) {
      log.error("Exceptions in validateCutOffTime: ", e);

      return Boolean.TRUE;
    } // end try-catch
  }   // end method validateCutOffTime

  //~ ------------------------------------------------------------------------------------------------------------------

  private static DateFormat createDateFormat(String pattern) {
    SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    TimeZone         gmt = TimeZone.getTimeZone("GMT");
    sdf.setTimeZone(gmt);
    sdf.setLenient(true);

    return sdf;
  }
} // end class DateUtil
