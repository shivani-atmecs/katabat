package com.cmc.credagility.core.domain.type;

import org.springframework.util.StringUtils;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/16/2014 14:21
 */
public enum ExpressConsentType {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  NA("NA"), NO("NO"), YES("YES");

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String strValue;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  private ExpressConsentType(String strValue) {
    if (StringUtils.hasText(strValue)) {
      this.strValue = strValue;
    } else {
      this.strValue = "NA";
    }
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * convert.
   *
   * @param   strValue  String
   *
   * @return  ExpressConsentType
   */
  public static ExpressConsentType convert(String strValue) {
    if ("YES".equalsIgnoreCase(strValue)) {
      return ExpressConsentType.YES;
    } else if ("NO".equalsIgnoreCase(strValue)) {
      return ExpressConsentType.NO;
    } else {
      return ExpressConsentType.NA;
    }

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Enum#toString()
   */
  @Override public String toString() {
    return strValue;
  }
}
