package com.cmc.credagility.core.domain.type;

/**
 * Chat initiated type.
 *
 * @author   Selva Dharmaraj
 * @version  1.0, 10/08/2010
 */
public enum ChatInitiatedType {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  BUTTON, PROACTIVE;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * Returns Chat Initiated Type.
   *
   * @param   strValue  type
   *
   * @return  Chat Initiated Type
   */
  public static ChatInitiatedType toPaymentChannel(String strValue) {
    try {
      return ChatInitiatedType.valueOf(strValue.toUpperCase());
    } catch (Exception e) {
      return null;
    }
  }
}
