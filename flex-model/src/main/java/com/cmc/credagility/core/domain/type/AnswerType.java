package com.cmc.credagility.core.domain.type;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/16/2014 14:14
 */
public enum AnswerType {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  DROPDOWN, TEXTBOX, HIDEFIELD;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * toAnswerType.
   *
   * @param   strValue  String
   *
   * @return  AnswerType
   */
  public static AnswerType toAnswerType(String strValue) {
    try {
      return AnswerType.valueOf(strValue.toUpperCase());
    } catch (Exception e) {
      return null;
    }
  }
}
