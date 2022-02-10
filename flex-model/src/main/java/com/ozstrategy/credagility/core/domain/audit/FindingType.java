package com.ozstrategy.credagility.core.domain.audit;


/**
 * Finding Type enum class.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/15/2014 17:13
 */
public enum FindingType {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  YES, NO, NOT_APPLICABLE, NOT_ASSESSED;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * convert.
   *
   * @param   strType  String
   *
   * @return  FindingType
   */
  public static FindingType convert(String strType) {
    if ((strType == null) || strType.trim().isEmpty()) {
      return null;
    } else {
      return valueOf(strType.toUpperCase());
    }
  }
}
