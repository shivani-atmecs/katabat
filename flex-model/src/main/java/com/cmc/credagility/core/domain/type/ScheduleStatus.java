package com.cmc.credagility.core.domain.type;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/16/2014 14:28
 */
public enum ScheduleStatus {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  ACTIVE("Active"), DELETED("Deleted"), DRAFT("Draft"), ERROR("Error"), OLD("Old"), PREVIEW("Preview"),
  PUBLISHED("Published"), SCHEDULED("Scheduled");

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** String value. */
  private String strValue;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Define enum.
   */
  private ScheduleStatus() {
    this.strValue = this.name();
  }

  /**
   * Define enum with string value.
   *
   * @param  strValue  DOCUMENT ME!
   */
  private ScheduleStatus(String strValue) {
    this.strValue = strValue;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for ordinal.
   *
   * @return  Integer
   */
  public Integer getOrdinal() {
    if (this.equals(ACTIVE)) {
      return 1;
    } else if (this.equals(SCHEDULED)) {
      return 2;
    } else if (this.equals(DRAFT)) {
      return 3;
    }

    if (this.equals(OLD)) {
      return 4;
    }

    return 5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the string value for the enum.
   *
   * @return  enum string value
   */
  @Override public String toString() {
    return strValue;
  }
}
