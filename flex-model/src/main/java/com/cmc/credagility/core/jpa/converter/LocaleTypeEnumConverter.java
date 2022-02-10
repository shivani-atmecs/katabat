package com.cmc.credagility.core.jpa.converter;

import com.cmc.credagility.core.domain.type.LocaleType;

import javax.persistence.AttributeConverter;


/**
 * Converts a Boolean entity attribute to a single-character Y/N string that will be stored in the database, and
 * vice-versa.
 *
 * @author   Yang Wang
 * @version  $Revision$, 09/29/2014 16:47 PM
 */
public class LocaleTypeEnumConverter implements AttributeConverter<LocaleType, String> {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * This implementation will return "Y" if the parameter is Boolean.TRUE, otherwise it will return "N" when the
   * parameter is Boolean.FALSE. A null input value will yield a null return value.
   *
   * @param   locale  b Boolean
   *
   * @return  this implementation will return "Y" if the parameter is Boolean.TRUE, otherwise it will return "N" when
   *          the parameter is Boolean.FALSE.
   */
  @Override public String convertToDatabaseColumn(LocaleType locale) {
    if (locale == null) {
      return null;
    }

    return locale.toString();
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
  @Override public LocaleType convertToEntityAttribute(String s) {
    if (s == null) {
      return null;
    }

    LocaleType locale = LocaleType.convert(s);

    if (locale == null) {
      return LocaleType.ENGLISH;
    }

    return locale;
  }

} // end class LocaleTypeEnumConverter
