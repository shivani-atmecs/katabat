package com.cmc.credagility.core.domain.type;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/16/2014 14:30
 */
public enum TreatmentType {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  MODIFICATION, //
  REFINANCE,    //
  SHORTSALE,    //
  FORBEARANCE,  //
  REPAYMENT;    //

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * toTreatmentType.
   *
   * @param   strValue  String
   *
   * @return  TreatmentType
   */
  public static TreatmentType toTreatmentType(String strValue) {
    try {
      return TreatmentType.valueOf(strValue.toUpperCase());
    } catch (Exception e) {
      return null;
    }
  }
}
