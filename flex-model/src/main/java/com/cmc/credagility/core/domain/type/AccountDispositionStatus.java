package com.cmc.credagility.core.domain.type;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/16/2014 14:11
 */
public enum AccountDispositionStatus {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  ACCOUNTNOTINUSE, NOTDISPOSED, ACCOUNTINUSE;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * toAccountDispositionStatus.
   *
   * @param   strValue  String
   *
   * @return  AccountDispositionStatus
   */
  public static AccountDispositionStatus toAccountDispositionStatus(String strValue) {
    try {
      return valueOf(strValue.toUpperCase());
    } catch (Exception e) {
      return null;
    }
  }

}
