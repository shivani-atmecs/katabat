package com.cmc.credagility.core.domain.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.zone.ZoneRulesException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.LocalDate;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import org.springframework.util.StringUtils;

import com.cmc.credagility.core.domain.portfolio.FrequencyDuration;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/16/2014 14:38
 */
public class DateUtil {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static Log log = LogFactory.getLog(DateUtil.class);

  /** default date formats. */
  private static List<String> dateFormats = Arrays.asList(
      "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd'T'HH:mm:ss",
      "MM/dd/yyyy HH:mm:ss", "MM/dd/yyyy'T'HH:mm:ss", "yyyy-MM-dd",
      "MM/dd/yyyy");

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * This method is used to add number of business days to a given date. The definition of "busines day" is any way that
   * is not Saturday or Sunday.
   *
   * @param   date  DOCUMENT ME!
   * @param   days  DOCUMENT ME!
   *
   * @return  this method is used to add number of business days to a given date.
   */
  public static Date addBusinessDays(Date date, int days) {
    if (date == null) {
      return null;
    }

    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);

    int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

    // Sunday: 1 Saturday :7
    int rest = 7 - dayOfWeek;

    if (days < rest) {
      return addDays(date, days);
    } else if (days == rest) {
      return addDays(date, rest + 2);
    } else {
      date = addDays(date, rest); // handles rest -1 business days

      int businessDaysHandled = 0;

      if (rest > 0) {
        // rest > 0, handled rest -1 business days
        businessDaysHandled = rest - 1;
      }

      int weeks     = (days - businessDaysHandled) / 5;
      int remainder = (days - businessDaysHandled) % 5;

      if (remainder == 0) {
        // remainder == 0, then deduct Sunday
        remainder = -1;
      } else {
        // remainder > 0, then add a Sunday
        remainder += 1;
      }

      return addDays(date, (weeks * 7) + remainder);
    } // end if-else
  }   // end method addBusinessDays

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addDateFormats.
   *
   * @param  dateFormat  String
   */
  public static void addDateFormats(String dateFormat) {
    List<String> formatList = new ArrayList<String>();
    formatList.addAll(DateUtil.dateFormats);
    formatList.add(dateFormat);

    DateUtil.dateFormats = formatList;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addDays.
   *
   * @param   date  Date
   * @param   days  int
   *
   * @return  Date
   */
  public static Date addDays(Date date, int days) {
    if (date == null) {
      return null;
    }

    DateTime d = new DateTime(date);

    return d.plusDays(days).toDate();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addMonths.
   *
   * @param   date    Date
   * @param   months  int
   *
   * @return  Date
   */
  public static Date addMonths(Date date, int months) {
    if (date == null) {
      return null;
    }

    DateTime d = new DateTime(date);

    return d.plusMonths(months).toDate();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * checkIsToday.
   *
   * @param   date  Date
   *
   * @return  boolean
   */
  public static boolean checkIsToday(Date date) {
    Calendar current = Calendar.getInstance();

    Calendar today0 = Calendar.getInstance();

    today0.set(Calendar.YEAR, current.get(Calendar.YEAR));
    today0.set(Calendar.MONTH, current.get(Calendar.MONTH));
    today0.set(Calendar.DAY_OF_MONTH, current.get(Calendar.DAY_OF_MONTH));
    today0.set(Calendar.HOUR_OF_DAY, 0);
    today0.set(Calendar.MINUTE, 0);
    today0.set(Calendar.SECOND, 0);

    Calendar today23 = Calendar.getInstance();

    today23.set(Calendar.YEAR, current.get(Calendar.YEAR));
    today23.set(Calendar.MONTH, current.get(Calendar.MONTH));
    today23.set(Calendar.DAY_OF_MONTH, current.get(Calendar.DAY_OF_MONTH));
    today23.set(Calendar.HOUR_OF_DAY, 23);
    today23.set(Calendar.MINUTE, 59);
    today23.set(Calendar.SECOND, 59);

    current.setTime(date);


    return current.after(today0) && current.before(today23);
  } // end method checkIsToday

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * clearTime.
   *
   * @param   cal  Calendar
   *
   * @return  Calendar
   */
  public static Calendar clearTime(Calendar cal) {
    cal.clear(Calendar.MILLISECOND);
    cal.clear(Calendar.MINUTE);
    cal.clear(Calendar.SECOND);
    cal.clear(Calendar.HOUR);
    cal.set(Calendar.HOUR_OF_DAY, 0);

    return cal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * compareDateByYMD.
   *
   * @param   cal1  Calendar
   * @param   cal2  Calendar
   *
   * @return  int
   *
   * @throws  IllegalArgumentException  exception
   */
  public static int compareDateByYMD(Calendar cal1, Calendar cal2) {
    if ((cal1 == null) || (cal2 == null)) {
      throw new IllegalArgumentException("The date must not be null");
    }

    int yearResult = Integer.valueOf(cal1.get(Calendar.YEAR)).compareTo(Integer.valueOf(cal2.get(Calendar.YEAR)));

    if (yearResult == 0) {
      int monthResult = Integer.valueOf(cal1.get(Calendar.MONTH)).compareTo(Integer.valueOf(cal2.get(Calendar.MONTH)));

      if (monthResult == 0) {
        return Integer.valueOf(cal1.get(Calendar.DAY_OF_YEAR)).compareTo(Integer.valueOf(
              cal2.get(Calendar.DAY_OF_YEAR)));
      } else {
        return monthResult;
      }
    } else {
      return yearResult;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * compareDateOnly.
   *
   * @param   date1  Date
   * @param   date2  Date
   *
   * @return  int
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

    LocalDate d1 = new LocalDate(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH));
    cal.setTime(date2);

    LocalDate d2 = new LocalDate(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH));

    return d1.compareTo(d2);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * convertJsDateFormatToJaveDateFormat.
   *
   * @param   jsDateFormat  String
   *
   * @return  String
   */
  public static String convertJsDateFormatToJaveDateFormat(String jsDateFormat) {
    String dateFormat = "MM/dd/yyyy";

    if ((jsDateFormat != null) && StringUtils.hasText(jsDateFormat)) {
      dateFormat = jsDateFormat.replace("m", "MM").replace("d", "dd").replace("Y", "yyyy");
    }

    return dateFormat;
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
   * @param   dateStr    String
   * @param   formatter  String
   *
   * @return  Date
   */
  public static Date formatDate(String dateStr, String formatter) {
    if (StringUtils.hasText(dateStr)) {
      try {
        SimpleDateFormat sdf = new SimpleDateFormat(formatter);

        return sdf.parse(dateStr);

      } catch (ParseException e) {
        log.error("ParseException: date string: " + dateStr + ", expected format: " + formatter, e);
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for age.
   *
   * @param   birthday  Date
   *
   * @return  int
   */
  public static int getAge(Date birthday) {
    Calendar calendar = Calendar.getInstance();
    int      year     = calendar.get(Calendar.YEAR);
    int      month    = calendar.get(Calendar.MONTH);
    int      date     = calendar.get(Calendar.DATE);

    calendar.setTime(birthday);

    int age = year - calendar.get(Calendar.YEAR);

    // adjust based on month and date
    if (month == calendar.get(Calendar.MONTH)) {
      // need to compare the date
      if (date < calendar.get(Calendar.DATE)) {
        age--;
      }
    } else if (month < calendar.get(Calendar.MONTH)) {
      age--;
    }

    return age;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for date only date.
   *
   * @param   date  Date
   *
   * @return  LocalDate
   */
  public static LocalDate getDateOnlyDate(Date date) {
    if (date == null) {
      return null;
    }

    // Tried to use LocalDate now = new LocalDate(). However, in production
    // server Ubuntu 7.1 + jdk 1.6.0_03-b05, the LocalDate is always one day
    // in
    // advance.
    Calendar cal = GregorianCalendar.getInstance();
    cal.setTime(date);

    LocalDate ld = new LocalDate(cal.get(Calendar.YEAR),
        cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH));

    return ld;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for date start.
   *
   * @param   date  Date
   *
   * @return  Date
   */
  public static Date getDateStart(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    calendar.set(Calendar.MILLISECOND, 0);

    return calendar.getTime();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for date time.
   *
   * @param   date  Date
   * @param   time  Date
   *
   * @return  Date
   */
  public static Date getDateTime(Date date, Date time) {
    if ((date != null) || (time != null)) {
      String           dateTimeStr = "";
      SimpleDateFormat sdf         = new SimpleDateFormat("yyyyMMdd");
      dateTimeStr = sdf.format(date);
      sdf         = new SimpleDateFormat("HH:mm:ss");
      dateTimeStr += sdf.format(time);
      sdf         = new SimpleDateFormat("yyyyMMddHH:mm:ss");

      try {
        return sdf.parse(trim(dateTimeStr));
      } catch (Exception e) { }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get an immutable DateTime instance from date time String using default timeZone. Simply call toDate() to get a
   * java.util.Date instance.
   *
   * @param   str     the date time string source
   * @param   format  the date time string format. Example: "MM/dd/yyyy HH:mm:ss"
   *
   * @return  the DateTime object from the string source
   */
  public static DateTime getDateTimeFromString(final String str,
    final String format) {
    DateTimeFormatter formatter = DateTimeFormat.forPattern(format);

    return formatter.parseDateTime(str);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get an immutable DateTime instance from date time String and timeZone Id. Simply call toDate() to get a
   * java.util.Date instance.
   *
   * @param   str     the date time string source
   * @param   format  the date time string format. Example: "MM/dd/yyyy HH:mm:ss"
   * @param   tzId    the timeZone Id. Example: "US/Eastern"
   *
   * @return  get an immutable DateTime instance from date time String and timeZone Id.
   */
  public static DateTime getDateTimeFromString(final String str,
    final String format, final String tzId) {
    DateTimeFormatter formatter = DateTimeFormat.forPattern(format);

    return formatter.withZone(DateTimeZone.forID(tzId)).parseDateTime(str);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for day difference.
   *
   * @param   start  Date
   * @param   end    Date
   *
   * @return  int
   */
  public static int getDayDifference(Date start, Date end) {
    return getDayDifference(start, end, true);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for day difference.
   *
   * @param   start            Date
   * @param   end              Date
   * @param   isAbsoluteValue  boolean
   *
   * @return  int
   */
  public static int getDayDifference(Date start, Date end,
    boolean isAbsoluteValue) {
// // use hour of day 6 and 6 to avoid any Day Light Saving issue
// Date firstDate = toDateOnly(start, 6);
// Date secondDate = toDateOnly(end, 6);
// long difference = firstDate.getTime() - secondDate.getTime();
//
// if (isAbsoluteValue) {
// difference = Math.abs(difference);
// }
//
// difference /= (1000 * 60 * 60 * 24); // difference in date
//
// return (int) difference;
    DateTime startDateTime = new DateTime(toDateOnly(start));
    DateTime endDateTime   = new DateTime(toDateOnly(end));

    Days days       = Days.daysBetween(endDateTime, startDateTime);
    int  difference = days.getDays();

    if (isAbsoluteValue) {
      return Math.abs(difference);
    } else {
      return difference;
    }
  } // end method getDayDifference

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for day of date.
   *
   * @param   date  Date
   *
   * @return  int
   */
  public static int getDayOfDate(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);

    return calendar.get(Calendar.DAY_OF_MONTH);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // Added by Etisbew on 05/14/09 for Post Charge Off account Validation-END

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static Date getDFSLastBusinessDayInMonth() {
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));

    int lastWorkingDay = calendar.get(Calendar.DAY_OF_WEEK);

    while (lastWorkingDay == Calendar.SATURDAY) {
      calendar.add(Calendar.DATE, -1);
      lastWorkingDay = calendar.get(Calendar.DAY_OF_WEEK);
    }

    return calendar.getTime();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for hour difference.
   *
   * @param   start            Date
   * @param   end              Date
   * @param   isAbsoluteValue  boolean
   *
   * @return  int
   */
  public static int getHourDifference(Date start, Date end,
    boolean isAbsoluteValue) {
    DateTime startDateTime = new DateTime(start);
    DateTime endDateTime   = new DateTime(end);
    Hours    hours         = Hours.hoursBetween(endDateTime, startDateTime);
    int      difference    = hours.getHours();

    if (isAbsoluteValue) {
      return Math.abs(difference);
    } else {
      return difference;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last day of current month.
   *
   * @return  int
   */
  public static int getLastDayOfCurrentMonth() {
    return getLastDayOfMonth(new Date());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last day of month.
   *
   * @param   date  Date
   *
   * @return  int
   */
  public static int getLastDayOfMonth(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.set(Calendar.DAY_OF_MONTH, 1);
    calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1);

    calendar.add(Calendar.DAY_OF_MONTH, -1);

    return calendar.get(Calendar.DAY_OF_MONTH);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last month.
   *
   * @return  Date
   */
  public static Date getLastMonth() {
    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.MONTH, -1);

    return DateUtil.toDateOnly(cal.getTime());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last week.
   *
   * @return  Date
   */
  public static Date getLastWeek() {
    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.DATE, -7);

    return DateUtil.toDateOnly(cal.getTime());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last working day in month.
   *
   * @return  Date
   */
  public static Date getLastWorkingDayInMonth() {
    return getLastWorkingDayInMonth((Calendar.getInstance()).get(
          Calendar.MONTH));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // Added by Etisbew on 05/14/09 for Post Charge Off account Validation-START
  /**
   * Returns the last business day date for the month passed in (except Saturday &amp; Sunday).
   *
   * @param   month  DOCUMENT ME!
   *
   * @return  Date
   */
  public static Date getLastWorkingDayInMonth(int month) {
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.MONTH, month);
    calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));

    int lastWorkingDay = calendar.get(Calendar.DAY_OF_WEEK);

    while ((lastWorkingDay == 1) || (lastWorkingDay == 7)) {
      calendar.add(Calendar.DATE, -1);
      lastWorkingDay = calendar.get(Calendar.DAY_OF_WEEK);
    }

    return calendar.getTime();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last year.
   *
   * @return  Date
   */
  public static Date getLastYear() {
    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.YEAR, -1);

    return DateUtil.toDateOnly(cal.getTime());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for next month.
   *
   * @return  Date
   */
  public static Date getNextMonth() {
    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.MONTH, 1);

    return DateUtil.toDateOnly(cal.getTime());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for next week.
   *
   * @return  Date
   */
  public static Date getNextWeek() {
    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.DATE, 7);

    return DateUtil.toDateOnly(cal.getTime());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for next year.
   *
   * @return  Date
   */
  public static Date getNextYear() {
    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.YEAR, 1);

    return DateUtil.toDateOnly(cal.getTime());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   n  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static Date getPreviousMonth(int n) {
    return new DateTime().minusMonths(n).toDate();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for selected frequency.
   *
   * @param   fd  FrequencyDuration
   *
   * @return  String
   */
  public static String getSelectedFrequency(FrequencyDuration fd) {
    if ((fd == null) || (fd.getFrequency() == null)) {
      return null;
    }

    if (fd.getFrequency() == 7) {
      return "weekly";
    } else if (fd.getFrequency() == 1) {
      return "daily";
    } else if (fd.getFrequency() == 14) {
      return "fortnightly";
    } else if ((fd.getFrequency() == 0) || (fd.getFrequency() == -1)) {
      return "monthly";
    }

    return fd.getFrequency() + "";

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for term in days by frequency duration.
   *
   * @param   start  Date
   * @param   fd     FrequencyDuration
   *
   * @return  Integer
   */
  public static Integer getTermInDaysByFrequencyDuration(Date start,
    FrequencyDuration fd) {
    if (fd == null) {
      return null;
    }

    if ((fd.getFrequency() == null) || (fd.getDuration() == null)) {
      return null;
    }

    if (fd.getFrequency() == 0) {
      return getDayDifference(addMonths(start, fd.getDuration()), start);
    } else if (fd.getFrequency() < 0) {
      return getDayDifference(addMonths(start,
            (-1) * (fd.getFrequency()) * (fd.getDuration())),
          start);
    } else {
      return (fd.getFrequency()) * (fd.getDuration());
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for term in days from now by frequency duration.
   *
   * @param   fd  FrequencyDuration
   *
   * @return  Integer
   */
  public static Integer getTermInDaysFromNowByFrequencyDuration(
    FrequencyDuration fd) {
    return getTermInDaysByFrequencyDuration(new Date(), fd);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for term in months by frequency duration.
   *
   * @param   start  Date
   * @param   fd     FrequencyDuration
   *
   * @return  Integer
   */
  public static Integer getTermInMonthsByFrequencyDuration(Date start,
    FrequencyDuration fd) {
    Integer days = getTermInDaysByFrequencyDuration(start, fd);

    if (days == null) {
      return null;
    } else {
      int m = 0;
      int r = 0;

      if (days >= 365) {
        m = (days / 365) * 12;
      }

      r = days % 365;

      if (r > 363) {
        r = 363;
      }

      return m + (r / 28);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for term in months from now by frequency duration.
   *
   * @param   fd  FrequencyDuration
   *
   * @return  Integer
   */
  public static Integer getTermInMonthsFromNowByFrequencyDuration(
    FrequencyDuration fd) {
    return getTermInMonthsByFrequencyDuration(new Date(), fd);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for time zone date.
   *
   * @param   timeZone  String
   * @param   date      Date
   *
   * @return  Date
   *
   * @throws  ParseException  exception
   */
  public static Date getTimeZoneDate(String timeZone, Date date) throws ParseException {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    format.setTimeZone(TimeZone.getTimeZone(timeZone));

    String fdate = format.format(date);

    // Here Second format reference used for parse string date to Date in GMT
    // format
    format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    Date now = format.parse(fdate);

    return now;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for today.
   *
   * @return  Date
   */
  public static Date getToday() {
    return DateUtil.toDateOnly(new Date());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for today start.
   *
   * @return  Date
   */
  public static Date getTodayStart() {
    Calendar today = Calendar.getInstance();
    today.set(Calendar.HOUR_OF_DAY, 0);
    today.set(Calendar.MINUTE, 0);
    today.set(Calendar.SECOND, 0);

    return today.getTime();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   timezone  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static LocalDateTime getTodayWithTimeZone(String timezone) {
    LocalDateTime localDateTime = LocalDateTime.now();

    if (StringUtils.hasText(timezone)) {
      try {
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of(timezone));
        localDateTime = LocalDateTime.of(zonedDateTime.getYear(), zonedDateTime.getMonth(),
            zonedDateTime.getDayOfMonth(),
            zonedDateTime.getHour(), zonedDateTime.getMinute(), zonedDateTime.getSecond());
      } catch (ZoneRulesException e) {
        log.error("Timezone is not valid, returns LocalDateTime with system default timezone");

        return localDateTime;
      }
    }

    return localDateTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for tommorrow.
   *
   * @return  Date
   */
  public static Date getTommorrow() {
    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.DATE, 1);

    return DateUtil.toDateOnly(cal.getTime());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for tomorrow.
   *
   * @return  Date
   */
  public static Date getTomorrow() {
    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.DATE, 1);

    return DateUtil.toDateOnly(cal.getTime());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for way back date.
   *
   * @param   numberOfDays  int
   * @param   hour          int
   * @param   minutes       int
   * @param   seconds       int
   * @param   milliSeconds  int
   *
   * @return  Date
   */
  public static Date getWayBackDate(int numberOfDays, int hour, int minutes, int seconds, int milliSeconds) {
    Calendar cal = GregorianCalendar.getInstance();
    cal.add(Calendar.DATE, numberOfDays);
    cal.set(Calendar.HOUR_OF_DAY, hour);
    cal.set(Calendar.MINUTE, minutes);
    cal.set(Calendar.SECOND, seconds);
    cal.set(Calendar.MILLISECOND, milliSeconds);

    return cal.getTime();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get week difference, Note: Sunday is the first day of a week if start day is Saturday, the end day is Sunday then
   * should return 1, consider one week different
   *
   * <p>This method return only absolute difference</p>
   *
   * @param   start  DOCUMENT ME!
   * @param   end    DOCUMENT ME!
   *
   * @return  get week difference, Note:
   */
  public static int getWeekDifference(Date start, Date end) {
    return getWeekDifference(start, end, true);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get week difference, Note: Sunday is the first day of a week if start day is Saturday, the end day is Sunday then
   * should return 1, consider one week different
   *
   * @param   start            DOCUMENT ME!
   * @param   end              DOCUMENT ME!
   * @param   isAbsoluteValue  DOCUMENT ME!
   *
   * @return  get week difference, Note:
   */
  public static int getWeekDifference(Date start, Date end,
    boolean isAbsoluteValue) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(start);

    int dateOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
    int difDay     = getDayDifference(start, end, isAbsoluteValue);

    return (dateOfWeek - 1 + difDay) / 7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for yesterday.
   *
   * @return  Date
   */
  public static Date getYesterday() {
    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.DATE, -1);

    return DateUtil.toDateOnly(cal.getTime());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hasDaysEarlierThanNow.
   *
   * @param   date  Date
   * @param   days  int
   *
   * @return  Boolean
   */
  public static Boolean hasDaysEarlierThanNow(Date date, int days) {
    Date     now = new Date();
    Calendar cal = Calendar.getInstance();
    cal.setTime(now);

    int dayOfMonthOfNow = cal.get(Calendar.DAY_OF_MONTH);
    int monthOfNow      = cal.get(Calendar.MONTH);
    int yearOfNow       = cal.get(Calendar.YEAR);

    cal.setTime(date);

    int dayOfMonthOfDate = cal.get(Calendar.DAY_OF_MONTH);
    int monthOfDate      = cal.get(Calendar.MONTH);
    int yearOfDate       = cal.get(Calendar.YEAR);

    return (yearOfNow > yearOfDate)
      || ((yearOfNow == yearOfDate) && (monthOfNow > monthOfDate))
      || ((yearOfNow == yearOfDate) && (monthOfNow == monthOfDate)
        && ((dayOfMonthOfNow - dayOfMonthOfDate) >= days));

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * intervalDays.
   *
   * @param   date1  Date
   * @param   date2  Date
   *
   * @return  int
   *
   * @throws  ParseException  exception
   */
  public static Integer intervalDays(Date date1, Date date2) throws ParseException {
    if ((date1 == null) || (date2 == null)) {
      return null;
    }

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    try {
      date1 = sdf.parse(sdf.format(date1));
      date2 = sdf.parse(sdf.format(date2));
    } catch (ParseException e) {
      throw new ParseException(e.getMessage(), e.getErrorOffset());
    }

    Calendar cal = GregorianCalendar.getInstance();
    cal.setTime(date1);

    Long time1 = cal.getTimeInMillis();
    cal.setTime(date2);

    Long time2 = cal.getTimeInMillis();

    long between_days = (time2 - time1) / (1000 * 3600 * 24);

    return Integer.valueOf(String.valueOf(between_days));
  } // end method intervalDays

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for after date.
   *
   * @param   dateToCheck  Date
   * @param   start        Date
   *
   * @return  boolean
   */
  public static boolean isAfterDate(final Date dateToCheck, final Date start) {
// Calendar dateToCheckCal = Calendar.getInstance();
// dateToCheckCal.setTime(dateToCheck);
//
// DateTime dateTimeToCheck = new DateTime(dateToCheckCal.get(Calendar.YEAR),
// dateToCheckCal.get(Calendar.MONTH) + 1,
// dateToCheckCal.get(Calendar.DAY_OF_MONTH), 0, 0, 0, 0);
//
// Calendar startCal = Calendar.getInstance();
// startCal.setTime(start);
//
// DateTime startDateTime = new DateTime(startCal.get(Calendar.YEAR), startCal.get(Calendar.MONTH),
// startCal.get(Calendar.DAY_OF_MONTH), 0, 0, 0, 0);
//
// return dateTimeToCheck.isAfter(startDateTime);
    if ((start == null) || (dateToCheck == null)) {
      return false;
    }

    Date left  = getDateStart(start);
    Date right = getDateStart(dateToCheck);

    return right.after(left);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for after date time.
   *
   * @param   dateTimeToCheck  DateTime
   * @param   start            DateTime
   *
   * @return  boolean
   */
  public static boolean isAfterDateTime(final DateTime dateTimeToCheck,
    final DateTime start) {
    return dateTimeToCheck.isAfter(start);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Check whether dateTimeToCheck is after a period from baseDateTime.
   *
   * @param   dt                    DateTime
   * @param   baseDateTime          DateTime
   * @param   startDaysFromBase     int
   * @param   startHoursFromBase    int
   * @param   startMinutesFromBase  int
   *
   * @return  true if the date time to check is after the base instant plus period
   */
  public static boolean isAfterDateTime(final DateTime dt,
    DateTime baseDateTime, final int startDaysFromBase,
    final int startHoursFromBase, final int startMinutesFromBase) {
    Period p = new Period().withDays(startDaysFromBase).withHours(
        startHoursFromBase).withMinutes(startMinutesFromBase);

    return dt.isAfter(baseDateTime.plus(p));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Convenient method to check whether dateTimeToCheck is after a period from now.
   *
   * @param   dateTimeToCheck      DateTime
   * @param   startDaysFromNow     int
   * @param   startHoursFromNow    int
   * @param   startMinutesFromNow  int
   *
   * @return  true if the date time to check is after now plus period
   */
  public static boolean isAfterDateTimeFromNow(final DateTime dateTimeToCheck,
    final int startDaysFromNow, final int startHoursFromNow,
    final int startMinutesFromNow) {
    return isAfterDateTime(dateTimeToCheck, new DateTime(),
        startDaysFromNow, startHoursFromNow, startMinutesFromNow);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for before date time.
   *
   * @param   dateTimeToCheck  DateTime
   * @param   end              DateTime
   *
   * @return  boolean
   */
  public static boolean isBeforeDateTime(final DateTime dateTimeToCheck,
    final DateTime end) {
    return dateTimeToCheck.isBefore(end);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Check whether dateTimeToCheck is before a period from baseDateTime.
   *
   * @param   dateTimeToCheck     DOCUMENT ME!
   * @param   baseDateTime        DOCUMENT ME!
   * @param   endDaysFromBase     DOCUMENT ME!
   * @param   endHoursFromBase    DOCUMENT ME!
   * @param   endMinutesFromBase  DOCUMENT ME!
   *
   * @return  true if the date time to check is before the base instant plus period
   */
  public static boolean isBeforeDateTime(final DateTime dateTimeToCheck,
    final DateTime baseDateTime, final int endDaysFromBase,
    final int endHoursFromBase, final int endMinutesFromBase) {
    Period p = new Period().withDays(endDaysFromBase).withHours(
        endHoursFromBase).withMinutes(endMinutesFromBase);

    return dateTimeToCheck.isBefore(baseDateTime.plus(p));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Convenient method to check whether dateTimeToCheck is before a period from now.
   *
   * @param   dateTimeToCheck    DOCUMENT ME!
   * @param   endDaysFromNow     DOCUMENT ME!
   * @param   endHoursFromNow    DOCUMENT ME!
   * @param   endMinutesFromNow  DOCUMENT ME!
   *
   * @return  true if the date time to check is before now plus period
   */
  public static boolean isBeforeDateTimeFromNow(
    final DateTime dateTimeToCheck, final int endDaysFromNow,
    final int endHoursFromNow, final int endMinutesFromNow) {
    return isBeforeDateTime(dateTimeToCheck, new DateTime(), endDaysFromNow,
        endHoursFromNow, endMinutesFromNow);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for between today and plus days.
   *
   * @param   plusDays     int
   * @param   dateToCheck  Date
   *
   * @return  boolean
   */
  public static boolean isBetweenTodayAndPlusDays(int plusDays, Date dateToCheck) {
    LocalDate now     = new DateTime().toLocalDate();
    LocalDate endDate = now.plusDays(plusDays);
    LocalDate event   = new DateTime(dateToCheck).toLocalDate();

    if (!event.isBefore(now) && !event.isAfter(endDate)) {
      // Event is between now and plus days (inclusive).
      return true;
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for equal and after date time.
   *
   * @param   dateTimeToCheck  DateTime
   * @param   start            DateTime
   *
   * @return  boolean
   */
  public static boolean isEqualAndAfterDateTime(
    final DateTime dateTimeToCheck, final DateTime start) {
    return (dateTimeToCheck.isEqual(start)
        || dateTimeToCheck.isAfter(start));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for equal and before date time.
   *
   * @param   dateTimeToCheck  DateTime
   * @param   end              DateTime
   *
   * @return  boolean
   */
  public static boolean isEqualAndBeforeDateTime(
    final DateTime dateTimeToCheck, final DateTime end) {
    return (dateTimeToCheck.isEqual(end) || dateTimeToCheck.isBefore(end));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Check whether today is Friday of even week, same week is the first week.
   *
   * @param   boarding  DOCUMENT ME!
   *
   * @return  check whether today is Friday of even week, same week is the first week
   */
  public static boolean isEvenFriday(Date boarding) {
    Calendar calendar = Calendar.getInstance();

    if (Calendar.FRIDAY == calendar.get(Calendar.DAY_OF_WEEK)) {
      if ((getWeekDifference(boarding, new Date()) % 2) == 1) {
        // today is an odd week from boarding date
        return true;
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Check whether today is Monday of even week, same week is the first week.
   *
   * @param   boarding  DOCUMENT ME!
   *
   * @return  check whether today is Monday of even week, same week is the first week
   */
  public static boolean isEvenMonday(Date boarding) {
    Calendar calendar = Calendar.getInstance();

    if (Calendar.MONDAY == calendar.get(Calendar.DAY_OF_WEEK)) {
      if ((getWeekDifference(boarding, new Date()) % 2) == 1) {
        // today is an odd week from boarding date
        return true;
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Check whether today is Saturday of even week, same week is the first week.
   *
   * @param   boarding  DOCUMENT ME!
   *
   * @return  check whether today is Saturday of even week, same week is the first week
   */
  public static boolean isEvenSaturday(Date boarding) {
    Calendar calendar = Calendar.getInstance();

    if (Calendar.SATURDAY == calendar.get(Calendar.DAY_OF_WEEK)) {
      if ((getWeekDifference(boarding, new Date()) % 2) == 1) {
        // today is an odd week from boarding date
        return true;
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Check whether today is Sunday of even week, same week is the first week.
   *
   * @param   boarding  DOCUMENT ME!
   *
   * @return  check whether today is Sunday of even week, same week is the first week
   */
  public static boolean isEvenSunday(Date boarding) {
    Calendar calendar = Calendar.getInstance();

    if (Calendar.SUNDAY == calendar.get(Calendar.DAY_OF_WEEK)) {
      if ((getWeekDifference(boarding, new Date()) % 2) == 1) {
        // today is an odd week from boarding date
        return true;
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Check whether today is Thursday of even week, same week is the first week.
   *
   * @param   boarding  DOCUMENT ME!
   *
   * @return  check whether today is Thursday of even week, same week is the first week
   */
  public static boolean isEvenThursday(Date boarding) {
    Calendar calendar = Calendar.getInstance();

    if (Calendar.THURSDAY == calendar.get(Calendar.DAY_OF_WEEK)) {
      if ((getWeekDifference(boarding, new Date()) % 2) == 1) {
        // today is an odd week from boarding date
        return true;
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Check whether today is Tuesday of even week, same week is the first week.
   *
   * @param   boarding  DOCUMENT ME!
   *
   * @return  check whether today is Tuesday of even week, same week is the first week
   */
  public static boolean isEvenTuesday(Date boarding) {
    Calendar calendar = Calendar.getInstance();

    if (Calendar.TUESDAY == calendar.get(Calendar.DAY_OF_WEEK)) {
      if ((getWeekDifference(boarding, new Date()) % 2) == 1) {
        // today is an odd week from boarding date
        return true;
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Check whether today is Wednesday of even week, same week is the first week.
   *
   * @param   boarding  DOCUMENT ME!
   *
   * @return  check whether today is Wednesday of even week, same week is the first week
   */
  public static boolean isEvenWednesday(Date boarding) {
    Calendar calendar = Calendar.getInstance();

    if (Calendar.WEDNESDAY == calendar.get(Calendar.DAY_OF_WEEK)) {
      if ((getWeekDifference(boarding, new Date()) % 2) == 1) {
        // today is an odd week from boarding date
        return true;
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Check whether today is Friday.
   *
   * @return  check whether today is Friday
   */
  public static boolean isFriday() {
    Calendar calendar = Calendar.getInstance();

    return (Calendar.FRIDAY == calendar.get(Calendar.DAY_OF_WEEK));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for friday.
   *
   * @param   date  Date
   *
   * @return  boolean
   */
  public static boolean isFriday(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);

    return (Calendar.FRIDAY == calendar.get(Calendar.DAY_OF_WEEK));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for in date time range.
   *
   * @param   dateTimeToCheck  DateTime
   * @param   start            DateTime
   * @param   end              DateTime
   *
   * @return  boolean
   */
  public static boolean isInDateTimeRange(final DateTime dateTimeToCheck,
    final DateTime start, final DateTime end) {
    return (dateTimeToCheck.isAfter(start)
        || dateTimeToCheck.isEqual(start))
      && dateTimeToCheck.isBefore(end);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for in date time range.
   *
   * @param   dateToCheck  Date
   * @param   start        Date
   * @param   end          Date
   *
   * @return  boolean
   */
  public static boolean isInDateTimeRange(final Date dateToCheck,
    final Date start, final Date end) {
    return isInDateTimeRange(new DateTime(dateToCheck), new DateTime(start),
        new DateTime(end));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Check whether dateTimeToCheck is within a range from baseDateTime.
   *
   * @param   dateTimeToCheck       DOCUMENT ME!
   * @param   baseDateTime          DOCUMENT ME!
   * @param   startDaysFromBase     DOCUMENT ME!
   * @param   startHoursFromBase    DOCUMENT ME!
   * @param   startMinutesFromBase  DOCUMENT ME!
   * @param   endDaysFromBase       DOCUMENT ME!
   * @param   endHoursFromBase      DOCUMENT ME!
   * @param   endMinutesFromBase    DOCUMENT ME!
   *
   * @return  true if in range
   */
  public static boolean isInDateTimeRange(final DateTime dateTimeToCheck,
    DateTime baseDateTime, final int startDaysFromBase,
    final int startHoursFromBase, final int startMinutesFromBase,
    final int endDaysFromBase, final int endHoursFromBase,
    final int endMinutesFromBase) {
    Period p1 = new Period().withDays(startDaysFromBase).withHours(
        startHoursFromBase).withMinutes(startMinutesFromBase);
    Period p2 = new Period().withDays(startDaysFromBase).withHours(
        endHoursFromBase).withMinutes(endMinutesFromBase);

    return (dateTimeToCheck.isAfter(baseDateTime.plus(p1))
        || dateTimeToCheck.isEqual(baseDateTime.plus(p1)))
      && dateTimeToCheck.isBefore(baseDateTime.plus(p2));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Convient method to check whether dateTimeToCheck is within a range from now.
   *
   * @param   dateTimeToCheck      DOCUMENT ME!
   * @param   startDaysFromNow     DOCUMENT ME!
   * @param   startHoursFromNow    DOCUMENT ME!
   * @param   startMinutesFromNow  DOCUMENT ME!
   * @param   endDaysFromNow       DOCUMENT ME!
   * @param   endHoursFromNow      DOCUMENT ME!
   * @param   endMinutesFromNow    DOCUMENT ME!
   *
   * @return  convient method to check whether dateTimeToCheck is within a range from now.
   */
  public static boolean isInDateTimeRangeFromNow(
    final DateTime dateTimeToCheck, final int startDaysFromNow,
    final int startHoursFromNow, final int startMinutesFromNow,
    final int endDaysFromNow, final int endHoursFromNow,
    final int endMinutesFromNow) {
    return isInDateTimeRange(dateTimeToCheck, new DateTime(),
        startDaysFromNow, startHoursFromNow, startMinutesFromNow,
        endDaysFromNow, endHoursFromNow, endMinutesFromNow);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Check whether today is Monday.
   *
   * @return  check whether today is Monday
   */
  public static boolean isMonday() {
    Calendar calendar = Calendar.getInstance();

    return (Calendar.MONDAY == calendar.get(Calendar.DAY_OF_WEEK));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for monday.
   *
   * @param   date  Date
   *
   * @return  boolean
   */
  public static boolean isMonday(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);

    return (Calendar.MONDAY == calendar.get(Calendar.DAY_OF_WEEK));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Check whether today is Friday of odd week, same week is the first week.
   *
   * @param   boarding  DOCUMENT ME!
   *
   * @return  check whether today is Friday of odd week, same week is the first week
   */
  public static boolean isOddFriday(Date boarding) {
    Calendar calendar = Calendar.getInstance();

    if (Calendar.FRIDAY == calendar.get(Calendar.DAY_OF_WEEK)) {
      if ((getWeekDifference(boarding, new Date()) % 2) == 0) {
        // today is an odd week from boarding date
        return true;
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Check whether today is Monday of odd week, same week is the first week.
   *
   * @param   boarding  DOCUMENT ME!
   *
   * @return  check whether today is Monday of odd week, same week is the first week
   */
  public static boolean isOddMonday(Date boarding) {
    Calendar calendar = Calendar.getInstance();

    if (Calendar.MONDAY == calendar.get(Calendar.DAY_OF_WEEK)) {
      if ((getWeekDifference(boarding, new Date()) % 2) == 0) {
        // today is an odd week from boarding date
        return true;
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Check whether today is Saturday of odd week, same week is the first week.
   *
   * @param   boarding  DOCUMENT ME!
   *
   * @return  check whether today is Saturday of odd week, same week is the first week
   */
  public static boolean isOddSaturday(Date boarding) {
    Calendar calendar = Calendar.getInstance();

    if (Calendar.SATURDAY == calendar.get(Calendar.DAY_OF_WEEK)) {
      if ((getWeekDifference(boarding, new Date()) % 2) == 0) {
        // today is an odd week from boarding date
        return true;
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Check whether today is Sunday of odd week, same week is the first week.
   *
   * @param   boarding  DOCUMENT ME!
   *
   * @return  check whether today is Sunday of odd week, same week is the first week
   */
  public static boolean isOddSunday(Date boarding) {
    Calendar calendar = Calendar.getInstance();

    if (Calendar.SUNDAY == calendar.get(Calendar.DAY_OF_WEEK)) {
      if ((getWeekDifference(boarding, new Date()) % 2) == 0) {
        // today is an odd week from boarding date
        return true;
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Check whether today is Thursday of odd week, same week is the first week.
   *
   * @param   boarding  DOCUMENT ME!
   *
   * @return  check whether today is Thursday of odd week, same week is the first week
   */
  public static boolean isOddThursday(Date boarding) {
    Calendar calendar = Calendar.getInstance();

    if (Calendar.THURSDAY == calendar.get(Calendar.DAY_OF_WEEK)) {
      if ((getWeekDifference(boarding, new Date()) % 2) == 0) {
        // today is an odd week from boarding date
        return true;
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Check whether today is Tuesday of odd week, same week is the first week.
   *
   * @param   boarding  DOCUMENT ME!
   *
   * @return  check whether today is Tuesday of odd week, same week is the first week
   */
  public static boolean isOddTuesday(Date boarding) {
    Calendar calendar = Calendar.getInstance();

    if (Calendar.TUESDAY == calendar.get(Calendar.DAY_OF_WEEK)) {
      if ((getWeekDifference(boarding, new Date()) % 2) == 0) {
        // today is an odd week from boarding date
        return true;
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Check whether today is Wednesday of odd week, same week is the first week.
   *
   * @param   boarding  DOCUMENT ME!
   *
   * @return  check whether today is Wednesday of odd week, same week is the first week
   */
  public static boolean isOddWednesday(Date boarding) {
    Calendar calendar = Calendar.getInstance();

    if (Calendar.WEDNESDAY == calendar.get(Calendar.DAY_OF_WEEK)) {
      if ((getWeekDifference(boarding, new Date()) % 2) == 0) {
        // today is an odd week from boarding date
        return true;
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for same day.
   *
   * @param   cal1  Calendar
   * @param   cal2  Calendar
   *
   * @return  boolean
   *
   * @throws  IllegalArgumentException  exception
   */
  public static boolean isSameDay(Calendar cal1, Calendar cal2) {
    if ((cal1 == null) || (cal2 == null)) {
      throw new IllegalArgumentException("The date must not be null");
    }

    return ((cal1.get(Calendar.ERA) == cal2.get(Calendar.ERA))
        && (cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR))
        && (cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR)));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for same day.
   *
   * @param   date1  Date
   * @param   date2  Date
   *
   * @return  boolean
   */
  public static boolean isSameDay(Date date1, Date date2) {
    if ((date1 == null) || (date2 == null)) {
      return false;
    }

    Calendar cal1 = Calendar.getInstance();
    cal1.setTime(date1);

    Calendar cal2 = Calendar.getInstance();
    cal2.setTime(date2);

    return isSameDay(cal1, cal2);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Check whetjer today is the same day of the.
   *
   * @param   dayOfMonth  DOCUMENT ME!
   *
   * @return  check whetjer today is the same day of the
   */
  public static boolean isSameDayOfMonth(int dayOfMonth) {
    Calendar calendar = Calendar.getInstance();

    if (dayOfMonth == calendar.get(Calendar.DAY_OF_MONTH)) {
      return true;
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for saturday.
   *
   * @return  boolean
   */
  public static boolean isSaturday() {
    Calendar calendar = Calendar.getInstance();

    return (Calendar.SATURDAY == calendar.get(Calendar.DAY_OF_WEEK));
  }
  // Added by Etisbew on 09/11/2009 for CTA-Start

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Check whether the given date is Saturday.
   *
   * @param   date  DOCUMENT ME!
   *
   * @return  check whether today is Saturday
   *
   *          <p>returns true if it is saturday</p>
   */
  public static boolean isSaturday(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);

    return (Calendar.SATURDAY == calendar.get(Calendar.DAY_OF_WEEK));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Check whether today is Sunday.
   *
   * @return  check whether today is Sunday
   */
  public static boolean isSunday() {
    Calendar calendar = Calendar.getInstance();

    return (Calendar.SUNDAY == calendar.get(Calendar.DAY_OF_WEEK));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Check whether today is Sunday.
   *
   * @param   date  DOCUMENT ME!
   *
   * @return  check whether today is Sunday
   */
  public static boolean isSunday(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);

    return (Calendar.SUNDAY == calendar.get(Calendar.DAY_OF_WEEK));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // Added by Etisbew on 09/11/2009 for CTA-End
  /**
   * Check whether today is Thursday.
   *
   * @return  check whether today is Thursday
   */
  public static boolean isThursday() {
    Calendar calendar = Calendar.getInstance();

    return (Calendar.THURSDAY == calendar.get(Calendar.DAY_OF_WEEK));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for today.
   *
   * @param   paymentDate  Date
   *
   * @return  Boolean
   */
  public static Boolean isToday(Date paymentDate) {
    Calendar today = Calendar.getInstance();

    Calendar paymentDateCal = Calendar.getInstance();
    paymentDateCal.setTime(paymentDate);

    return DateUtil.isSameDay(today, paymentDateCal);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Check whether today is Tuesday.
   *
   * @return  check whether today is Tuesday
   */
  public static boolean isTuesday() {
    Calendar calendar = Calendar.getInstance();

    return (Calendar.TUESDAY == calendar.get(Calendar.DAY_OF_WEEK));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for valid date string.
   *
   * @param   dataString  String
   *
   * @return  boolean
   */
  public static boolean isValidDateString(String dataString) {
    if (StringUtils.hasText(dataString)) {
      for (String dateFormat : dateFormats) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);

        try {
          Date testDate = sdf.parse(trim(dataString));

          if (!sdf.format(testDate).equals(trim(dataString))) {
            return false;
          }

          return true;
        } catch (ParseException e) {
          // not match for this pattern, try next one
        }
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Check whether today is Wednesday.
   *
   * @return  check whether today is Wednesday
   */
  public static boolean isWednesday() {
    Calendar calendar = Calendar.getInstance();

    return (Calendar.WEDNESDAY == calendar.get(Calendar.DAY_OF_WEEK));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for yesterday.
   *
   * @param   paymentDate  Date
   *
   * @return  Boolean
   */
  public static Boolean isYesterday(Date paymentDate) {
    Calendar yesterdayCal = Calendar.getInstance();
    yesterdayCal.add(Calendar.DATE, -1);

    Calendar paymentDateCal = Calendar.getInstance();
    paymentDateCal.setTime(paymentDate);

    return DateUtil.isSameDay(yesterdayCal, paymentDateCal);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for yesterday.
   *
   * @param   inputDate  Date
   * @param   validate   Boolean
   *
   * @return  Boolean
   */
  public static Boolean isYesterday(Date inputDate, Boolean validate) {
    if (validate && (inputDate == null)) {
      return Boolean.FALSE;
    }

    Calendar yesterdayCal = Calendar.getInstance();
    yesterdayCal.add(Calendar.DATE, -1);

    Calendar paymentDateCal = Calendar.getInstance();
    paymentDateCal.setTime(inputDate);

    return DateUtil.isSameDay(yesterdayCal, paymentDateCal);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * minusDays.
   *
   * @param   date  Date
   * @param   days  int
   *
   * @return  Date
   */
  public static Date minusDays(Date date, int days) {
    if (date == null) {
      return null;
    }

    DateTime d = new DateTime(date);

    return d.minusDays(days).toDate();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * minusMonths.
   *
   * @param   date    Date
   * @param   months  int
   *
   * @return  Date
   */
  public static Date minusMonths(Date date, int months) {
    if (date == null) {
      return null;
    }

    DateTime d = new DateTime(date);

    return d.minusMonths(months).toDate();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * parseCutOffTime.
   *
   * @param   cutOffTime  String
   *
   * @return  Date
   */
  public static Date parseCutOffTime(String cutOffTime) {
    try {
      Calendar cutOffTimeCal = Calendar.getInstance();
      Calendar tempCal       = Calendar.getInstance();

      Date cufOffTimeDate = DateUtils.parseDate(cutOffTime, new String[] { "hh:mma", "hh:mm a" });
      tempCal.setTime(cufOffTimeDate);
      cutOffTimeCal.set(Calendar.HOUR_OF_DAY, tempCal.get(Calendar.HOUR_OF_DAY));
      cutOffTimeCal.set(Calendar.MINUTE, tempCal.get(Calendar.MINUTE));
      cutOffTimeCal.set(Calendar.SECOND, tempCal.get(Calendar.SECOND));

      return cutOffTimeCal.getTime();
    } catch (ParseException e) {
      e.printStackTrace();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for date formats.
   *
   * @param  dateFormats  List
   */
  public static void setDateFormats(List<String> dateFormats) {
    DateUtil.dateFormats = dateFormats;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * toDate.
   *
   * @param   dataString  String
   *
   * @return  Date
   */
  public static Date toDate(String dataString) {
    if (StringUtils.hasText(dataString)) {
      for (String dateFormat : dateFormats) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);

        try {
          Date date = sdf.parse(trim(dataString));

          return date;
        } catch (ParseException e) {
          // not match for this pattern, try next one
        }
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * toDateOnly.
   *
   * @param   date  Date
   *
   * @return  Date
   */
  public static Date toDateOnly(Date date) {
    return toDateOnly(date, 0);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * toDateOnly.
   *
   * @param   date       Date
   * @param   hourOfDay  int
   *
   * @return  Date
   */
  public static Date toDateOnly(Date date, int hourOfDay) {
    Calendar cal = GregorianCalendar.getInstance();
    cal.setTime(date);
    cal.set(Calendar.HOUR_OF_DAY, hourOfDay);
    cal.set(Calendar.MINUTE, 0);
    cal.set(Calendar.SECOND, 0);
    cal.set(Calendar.MILLISECOND, 0);

    return cal.getTime();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * trim.
   *
   * @param   input  String
   *
   * @return  String
   */
  public static String trim(String input) {
    if (input != null) {
      String output = input.trim();
      output = output.replaceAll("^\"*\'*\"*|\"*\'*\"*$", "");

      return output;
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private static DateFormat createDateFormat(String pattern) {
    SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    TimeZone         gmt = TimeZone.getTimeZone("GMT");
    sdf.setTimeZone(gmt);
    sdf.setLenient(true);

    return sdf;
  }

} // end class DateUtil
