package com.cmc.credagility.core.domain.type;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/16/2014 14:28
 */
public enum ScoreTypeEnum {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  BUREAU("Bureau", 1L), COLLECTION("Collection", 2L), RISK("Risk", 3L), CONTACTABILITY("Contactability", 4L),
  RECOVERY("Recovery", 5L), BEHAVIOR("Behavior", 6L);

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** String value. */
  private String strValue;

  private Long typeId;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Define enum with string value.
   *
   * @param  strValue  $param.type$
   * @param  typeId    Long
   */
  private ScoreTypeEnum(String strValue, Long typeId) {
    this.strValue = strValue;
    this.typeId   = typeId;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for score type id.
   *
   * @return  Long
   */
  public Long getScoreTypeId() {
    return this.typeId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for score type name.
   *
   * @return  String
   */
  public String getScoreTypeName() {
    return this.strValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the string value for the enum.
   *
   * @return  enum string value
   */
  @Override public String toString() {
    return strValue + " Score";
  }

}
