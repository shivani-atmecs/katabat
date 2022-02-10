package com.cmc.credagility.core.jpa.converter;

import javax.persistence.AttributeConverter;


/**
 * Converts a Boolean entity attribute to a single-character Y/N string that will be stored in the database, and
 * vice-versa.
 *
 * @author   Yang Wang
 * @version  $Revision$, 09/29/2014 16:47 PM
 */
public class StringBooleanConverter implements AttributeConverter<Boolean, String> {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * This implementation will return "Y" if the parameter is Boolean.TRUE, otherwise it will return "N" when the
   * parameter is Boolean.FALSE. A null input value will yield a null return value.
   *
   * @param   b  Boolean
   *
   * @return  this implementation will return "Y" if the parameter is Boolean.TRUE, otherwise it will return "N" when
   *          the parameter is Boolean.FALSE.
   */
  @Override public String convertToDatabaseColumn(Boolean b) {
    if (b == null) {
      return null;
    } else if (b.toString().trim().length() == 0) {
      return null;
    }

    if (b.booleanValue()) {
      return "Y";
    }

    return "N";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * This implementation will return Boolean.TRUE if the string is "Y" or "y", otherwise it will ignore the value and
   * return Boolean.FALSE (it does not actually look for "N") for any other non-null string. A null input value will
   * yield a null return value.
   *
   * @param   s  String
   *
   * @return  this implementation will return Boolean.TRUE if the string is "Y" or "y", otherwise it will ignore the
   *          value and return Boolean.FALSE (it does not actually look for "N") for any other non-null string.
   */
  @Override public Boolean convertToEntityAttribute(String s) {
    if (s == null) {
      return null;
    } else if (s.trim().length() == 0) {
      return null;
    }

    if (s.equals("Y") || s.equals("y")) {
      return Boolean.TRUE;
    }

    return Boolean.FALSE;
  }

} // end class StringBooleanConverter
