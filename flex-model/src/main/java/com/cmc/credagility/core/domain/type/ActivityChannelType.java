package com.cmc.credagility.core.domain.type;

/**
 * Created by yongliu on 6/5/15.
 *
 * @author   <a href="mailto:yong.liu@ozstrategy.com">Yong Liu</a>
 * @version  06/05/2015 14:59
 */
public enum ActivityChannelType {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  AGENCY, DEBTOR_SITE;

  //~ Methods ----------------------------------------------------------------------------------------------------------


  /**
   * convert.
   *
   * @param   strType  String
   *
   * @return  ActivityChannelType
   */
  public static ActivityChannelType convert(String strType) {
    if ((strType == null) || strType.trim().isEmpty()) {
      return null;
    } else {
      return valueOf(strType.toUpperCase());
    }
  }
}
