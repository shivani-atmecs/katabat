package com.cmc.credagility.core.domain.type;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/16/2014 14:30
 */
public enum Treatment {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  PP, // Payment Plan
  LM, // Load Modification
  SL, // Settlement
  RF; // Refi

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * toTreatment.
   *
   * @param   strValue  String
   *
   * @return  Treatment
   */
  public static Treatment toTreatment(String strValue) {
    try {
      return valueOf(strValue.toUpperCase());
    } catch (Exception e) {
      return null;
    }
  }
}
