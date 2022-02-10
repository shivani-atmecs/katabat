package com.ozstrategy.credagility.core.util;

import java.io.Serializable;
import java.util.Comparator;


/**
 * Created by IntelliJ IDEA. User: rojer Date: 11-03-27 Time: 4:59 PM To change this template use File | Settings | File
 * Templates.
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo</a>
 * @version  10/18/2014 11:49
 */
public class ConvertableStringComparator implements Comparator<String>, Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -6923713384062536820L;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   str1  s DOCUMENT ME!
   * @param   str2  s1 DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Override public int compare(String str1, String str2) {
    if ((str1 == null) && (str2 == null)) {
      return 0;
    } else if (str1 == null) {
      return -1;
    } else if (str2 == null) {
      return 1;
    } else if (ConvertUtil.isIntegerValue(str1) && ConvertUtil.isIntegerValue(str2)) {
      return ConvertUtil.toInteger(str1).compareTo(ConvertUtil.toInteger(str2));
    } else if (ConvertUtil.isLongValue(str1) && ConvertUtil.isLongValue(str2)) {
      return ConvertUtil.toLong(str1).compareTo(ConvertUtil.toLong(str2));
    }

    if (ConvertUtil.isBigDecimalValue(str1) && ConvertUtil.isBigDecimalValue(str2)) {
      return ConvertUtil.toBigDecimal(str1).compareTo(ConvertUtil.toBigDecimal(str2));
    }

    if (ConvertUtil.isBooleanValue(str1) && ConvertUtil.isBooleanValue(str2)) {
      return ConvertUtil.toBoolean(str1).compareTo(ConvertUtil.toBoolean(str2));
    }

    if (ConvertUtil.isDateValue(str1) && ConvertUtil.isDateValue(str2)) {
      return ConvertUtil.toDate(str1).compareTo(ConvertUtil.toDate(str2));
    }

    return str1.compareTo(str2);
  } // end method compare
} // end class ConvertableStringComparator
