package com.cmc.credagility.util;

import java.sql.Timestamp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;

import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.lang3.StringUtils;


/**
 * This class is converts a java.util.Date to a String and a String to a java.util.Date.
 *
 * @author   <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 * @version  10/23/2014 12:00
 */
public class DateConverter implements Converter {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  org.apache.commons.beanutils.Converter#convert(java.lang.Class, java.lang.Object)
   */
  @Override public Object convert(Class type, Object value) {
    if (value == null) {
      return null;
    } else if (type == Timestamp.class) {
      return convertToDate(type, value, DateUtil.getDateTimePattern());
    } else if (type == Date.class) {
      return convertToDate(type, value, DateUtil.getDatePattern());
    } else if (type == String.class) {
      return convertToString(type, value);
    }

    throw new ConversionException("Could not convert "
      + value.getClass().getName() + " to " + type.getName());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * convertToDate.
   *
   * @param   type     Class
   * @param   value    Object
   * @param   pattern  String
   *
   * @return  Object
   *
   * @throws  ConversionException  exception
   */
  protected Object convertToDate(Class type, Object value, String pattern) {
    DateFormat df = new SimpleDateFormat(pattern);

    if (value instanceof String) {
      try {
        if (StringUtils.isEmpty(value.toString())) {
          return null;
        }

        Date date = df.parse((String) value);

        if (type.equals(Timestamp.class)) {
          return new Timestamp(date.getTime());
        }

        return date;
      } catch (Exception pe) {
        pe.printStackTrace();
        throw new ConversionException("Error converting String to Date");
      }
    }

    throw new ConversionException("Could not convert "
      + value.getClass().getName() + " to " + type.getName());
  } // end method convertToDate

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * convertToString.
   *
   * @param   type   Class
   * @param   value  Object
   *
   * @return  Object
   *
   * @throws  ConversionException  exception
   */
  protected Object convertToString(Class type, Object value) {
    if (value instanceof Date) {
      DateFormat df = new SimpleDateFormat(DateUtil.getDatePattern());

      if (value instanceof Timestamp) {
        df = new SimpleDateFormat(DateUtil.getDateTimePattern());
      }

      try {
        return df.format(value);
      } catch (Exception e) {
        e.printStackTrace();
        throw new ConversionException("Error converting Date to String");
      }
    } else {
      return value.toString();
    }
  }
} // end class DateConverter
