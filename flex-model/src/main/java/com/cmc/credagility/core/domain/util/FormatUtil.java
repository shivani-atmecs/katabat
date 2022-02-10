package com.cmc.credagility.core.domain.util;

import java.math.BigDecimal;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.util.StringUtils;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 17:14
 */
public class FormatUtil {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * currencyFormat.
   *
   * @param   num  BigDecimal
   *
   * @return  String
   */
  public static String currencyFormat(BigDecimal num) {
    return currencyFormat(num, "N/A");
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * currencyFormat.
   *
   * @param   num         BigDecimal
   * @param   defaultStr  String
   *
   * @return  String
   */
  public static String currencyFormat(BigDecimal num, String defaultStr) {
    NumberFormat nf = NumberFormat.getCurrencyInstance();

    try {
      return nf.format(num);
    } catch (Exception e) {
      return defaultStr;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * formatDate.
   *
   * @param   date          String
   * @param   inputFormat   String
   * @param   outputFormat  String
   *
   * @return  String
   *
   * @throws  ParseException  exception
   * @throws  Exception       exception
   */
  public static String formatDate(String date, String inputFormat, String outputFormat) throws ParseException,
    Exception {
    DateFormat df = new SimpleDateFormat(inputFormat);
    DateFormat f  = new SimpleDateFormat(outputFormat);

    return f.format(df.parse(date));

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   value   DOCUMENT ME!
   * @param   digits  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static String formatZeroFillString(String value, int digits) {
    if (value.contains(".")) {
      value = value.replace(".", "");
    }

    if (value.length() < digits) {
      digits = digits - value.length();
      value  = getNDigitFormat(digits) + value;
    }


    return value;

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * currencyFormat.
   *
   * @param   accNum  String
   * @param   digits  int
   *
   * @return  String
   */

  public static String maskAccountNumber(String accNum, int digits) {
    if (StringUtils.hasText(accNum)) {
      int total   = accNum.length();
      int masklen = total - digits;

      if (masklen > 0) {
        StringBuffer maskedbuf = new StringBuffer("");

        for (int i = 0; i <= masklen; i++) {
          maskedbuf.append('X');
        }

        maskedbuf.append(accNum.substring(masklen, total));

        String masked = maskedbuf.toString();

        return masked;
      } else {
        return accNum;
      }
    }

    return "";
  } // end method maskAccountNumber

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * nullSafeSubstring.
   *
   * @param   val  String
   * @param   len  int
   *
   * @return  String
   */
  public static String nullSafeSubstring(String val, int len) {
    return nullSafeSubstring(val, 0, len);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * nullSafeSubstring.
   *
   * @param   val         String
   * @param   startIndex  int
   * @param   endIndex    int
   *
   * @return  String
   */
  public static String nullSafeSubstring(String val, int startIndex,
    int endIndex) {
    if (val == null) {
      return null;
    }

    if (startIndex > endIndex) {
      return "";
    } else if (val.length() > endIndex) {
      return val.substring(startIndex, endIndex);
    } else if (val.length() > startIndex) {
      return val.substring(startIndex);
    } else {
      return "";
    }

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * stringNullFormat.
   *
   * @param   val  String
   *
   * @return  String
   */
  public static String stringNullFormat(String val) {
    return stringNullFormat(val, "N/A");
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * stringNullFormat.
   *
   * @param   val         String
   * @param   defaultStr  String
   *
   * @return  String
   */
  public static String stringNullFormat(String val, String defaultStr) {
    if (val == null) {
      return defaultStr;
    }

    return val;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private static String getNDigitFormat(int digits) {
    if (digits <= 0) {
      return "";
    }

    String formatString = "";

    for (int c = 0; c < digits; c++) {
      formatString += "0";
    }

    return formatString;
  }
} // end class FormatUtil
