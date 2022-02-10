package com.cmc.credagility.core.domain.type;

import org.springframework.util.StringUtils;

import com.cmc.credagility.util.StringUtil;


/**
 * Document for new class.
 *
 * @author   Wang Yang : 12-11-6 : PM12:32
 * @version  $Revision$, $Date$
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo</a>
 */
public enum LocaleType {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  // English (United States)
  ENGLISH("en", "US"),

  // Spanish
  SPANISH("es", "SP"),

  // Chinese (China)
  SIMPLIFIED_CHINESE("zh", "CN"),

  // French
  FRENCH("fr", "FR"),

  // Chinese (Taiwan)
  TRADITIONAL_CHINESE("zh", "TW"),

  // for Czech language (cs), Czech Republic (CZ)
  CZECH_REPUBLIC("cs", "CZ");

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String country;

  private String lang;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  private LocaleType(String lang) {
    this.lang = lang;
  }

  private LocaleType(String lang, String country) {
    this.lang    = lang;
    this.country = country;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * convert.
   *
   * @param   strType  String
   *
   * @return  LocaleType
   */
  public static LocaleType convert(String strType) {
    if ((strType == null) || !StringUtils.hasText(strType)) {
      return null;
    }

    String[]   arr     = strType.split("-|_");
    String     lang    = arr[0];
    String     country = (arr.length > 1) ? arr[1] : null;
    LocaleType result  = null;

    for (LocaleType localeType : LocaleType.values()) {
      if (localeType.lang.equals(lang)) {
        if ((localeType.country == null) && (country == null)) {
          return localeType;
        } else if ((localeType.country != null) && localeType.country.equalsIgnoreCase(country)) {
          return localeType;
        }

        result = localeType;
      }
    }

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for country.
   *
   * @return  String
   */
  public String getCountry() {
    return country;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for lang.
   *
   * @return  String
   */
  public String getLang() {
    return lang;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Enum#toString()
   */
  @Override public String toString() {
    if ((this.country == null) || this.country.trim().isEmpty()) {
      return this.lang;
    } else {
      return this.lang + "-" + this.country.toUpperCase();
    }
  }
}
