package com.cmc.credagility.core.domain.type;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/16/2014 14:22
 */
public enum FormType {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  FORBEARANCE, DEFERMENT;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * toFormType.
   *
   * @param   strValue  String
   *
   * @return  FormType
   */
  public static FormType toFormType(String strValue) {
    try {
      return valueOf(strValue.toUpperCase());
    } catch (Exception e) {
      return null;
    }
  }
}
