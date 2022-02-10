package com.cmc.credagility.core.domain.type;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/16/2014 14:22
 */
public enum FormStatus {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  SUBMITTED, EXPORTED;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * toFormStatus.
   *
   * @param   strValue  String
   *
   * @return  FormStatus
   */
  public static FormStatus toFormStatus(String strValue) {
    try {
      return valueOf(strValue.toUpperCase());
    } catch (Exception e) {
      return null;
    }
  }
}
