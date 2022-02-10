package com.ozstrategy.credagility.core.util;

import com.cmc.credagility.core.domain.type.MetaDataValueType;
import com.cmc.credagility.util.DateUtil;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created with IntelliJ IDEA.
 *
 * <p>: wangy : 12-8-27 : PM12:50 To change this template use File | Settings | File Templates.</p>
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public class DataFormatter {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static String       defaultDatePattern     = null;
  private static StringBuffer DEFAULT_DATE_FORMATTER = new StringBuffer("MM/dd/yyyy");

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String dateFormat;
  private String decimalFormat;
  private String format;

  private String toType;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new DataFormatter object.
   */
  public DataFormatter() {
    this.dateFormat = DEFAULT_DATE_FORMATTER.toString();
  }

  /**
   * Creates a new DataFormatter object.
   *
   * @param  dateFormat  DOCUMENT ME!
   */
  public DataFormatter(String dateFormat) {
    this.dateFormat = dateFormat;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static String getDefaultDatePattern() {
    return DEFAULT_DATE_FORMATTER.toString();
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
    SimpleDateFormat sdf  = new SimpleDateFormat(getDefaultDatePattern());
    Date             date = null;

    if (StringUtils.hasText(value)) {
      try {
        date = sdf.parse(value);
      } catch (ParseException e) { }
    }

    return date;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  dateFormat  DOCUMENT ME!
   */
  public static void updateDefaultDateFormatter(String dateFormat) {
    DEFAULT_DATE_FORMATTER.delete(0, DEFAULT_DATE_FORMATTER.length());
    DEFAULT_DATE_FORMATTER.append(dateFormat);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   obj  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String format(Object obj) {
    if (obj == null) {
      return "";
    }

    if (toType != null) {
      MetaDataValueType valueType = MetaDataValueType.valueOf(toType);

      switch (valueType) {
        case DATE: {
          return DateUtil.getDateAsString((Date) obj, getDateFormatStr());
        }

        case BIGDECIMAL: {
          String strFormat = getDecimalFormat();

          if (StringUtils.hasText(strFormat)) {
            DecimalFormat formatter = new DecimalFormat(strFormat);
            String        output    = formatter.format((BigDecimal) obj);

            return output;
          } else {
            return ((BigDecimal) obj).toString();
          }
        }

        case BOOLEAN: {
          return ((Boolean) obj).toString();
        }

        case INTEGER: {
          return ((Integer) obj).toString();
        }

        case LONG: {
          return ((Long) obj).toString();
        }

        case STRING: {
          return (String) obj;
        }
      } // end switch
    }   // end if

    if (obj instanceof Date) {
      return getDateAsString((Date) obj, getDateFormatStr());
    }

    return obj.toString();
  } // end method format

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDateFormat() {
    if (format != null) {
      return format;
    }

    return dateFormat;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDateFormatStr() {
    String strFormat = getDateFormat();

    if (!StringUtils.hasText(strFormat)) {
      strFormat = "yyyy-MM-dd HH:mm:ss";
    }

    return strFormat;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDecimalFormat() {
    if (format != null) {
      return format;
    }

    return decimalFormat;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  dateFormat  DOCUMENT ME!
   */
  public void setDateFormat(String dateFormat) {
    this.dateFormat = dateFormat;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  decimalFormat  DOCUMENT ME!
   */
  public void setDecimalFormat(String decimalFormat) {
    this.decimalFormat = decimalFormat;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  format  DOCUMENT ME!
   */
  public void setFormat(String format) {
    this.format = format;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  toType  DOCUMENT ME!
   */
  public void setToType(String toType) {
    this.toType = toType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   date    DOCUMENT ME!
   * @param   format  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  private static String getDateAsString(Date date, String format) {
    if (!StringUtils.hasText(format)) {
      format = getDefaultDatePattern();
    }

    SimpleDateFormat sdf        = new SimpleDateFormat(format);
    String           dateString = "";

    if (date != null) {
      dateString = sdf.format(date);
    }

    return dateString;
  }
} // end class DataFormatter
