package com.cmc.credagility.core.domain.type;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/16/2014 14:22
 */
public enum FLXGroupImportActionType {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  M("M"), // Modify/Create
  D("D"); // Delete

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String strValue;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  private FLXGroupImportActionType() {
    this.strValue = this.name();
  }

  private FLXGroupImportActionType(String strValue) {
    this.strValue = strValue;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * convert.
   *
   * @param   strValue  String
   *
   * @return  FLXGroupImportActionType
   */
  public static FLXGroupImportActionType convert(String strValue) {
    try {
      return valueOf(strValue.toUpperCase());
    } catch (Exception e) {
      return null;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Enum#toString()
   */
  @Override public String toString() {
    return strValue;
  }

}
