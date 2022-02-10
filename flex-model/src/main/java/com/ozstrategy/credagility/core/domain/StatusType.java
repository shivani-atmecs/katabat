package com.ozstrategy.credagility.core.domain;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/16/2014 15:00
 */
public enum StatusType {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  DELETED, ENABLE, DISABLE, ACTIVE, DRAFT, OLD, DELETE;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * convert.
   *
   * @param   statusType  String
   *
   * @return  StatusType
   */
  public static StatusType convert(String statusType) {
    if ((statusType == null) || statusType.trim().isEmpty()) {
      return null;
    }

    return valueOf(statusType);
  }


}
