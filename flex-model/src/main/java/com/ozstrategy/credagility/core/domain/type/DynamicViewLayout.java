package com.ozstrategy.credagility.core.domain.type;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  07/17/2015 17:29
 */
public enum DynamicViewLayout {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  TABLE, COLUMN;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DynamicViewLayout.
   *
   * @param   value  $param.type$
   *
   * @return  DynamicViewLayout.
   */
  public static DynamicViewLayout convert(String value) {
    try {
      return DynamicViewLayout.valueOf(value);
    } catch (Exception e) { }

    return null;
  }
}
