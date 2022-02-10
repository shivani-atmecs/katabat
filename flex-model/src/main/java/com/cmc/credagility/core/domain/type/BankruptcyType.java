package com.cmc.credagility.core.domain.type;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/16/2014 14:15
 */
public enum BankruptcyType {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  B07("B07", new Long[] { 15L, 18L }), B13("B13", new Long[] { 16L, 19L }), UNKNOWN("Unknown", new Long[] { 17L, 20L });

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private Long[] resultIds;

  /** String value. */
  private String strValue;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Define enum with string value.
   *
   * @param  strValue   $param.type$
   * @param  resultIds  Long[]
   */
  private BankruptcyType(String strValue, Long[] resultIds) {
    this.strValue  = strValue;
    this.resultIds = resultIds;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * toBankruptcyType.
   *
   * @param   resultId  Long
   *
   * @return  BankruptcyType
   */
  public static BankruptcyType toBankruptcyType(Long resultId) {
    if (resultId == null) {
      return null;
    }

    for (BankruptcyType b : BankruptcyType.values()) {
      if (isInResultIds(resultId, b.getResultIds())) {
        return b;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for result ids.
   *
   * @return  Long[]
   */
  public Long[] getResultIds() {
    return this.resultIds;
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

  //~ ------------------------------------------------------------------------------------------------------------------

  private static boolean isInResultIds(Long resultId, Long[] resultIds) {
    if (resultId == null) {
      return false;
    }

    for (Long rid : resultIds) {
      if (rid.compareTo(resultId) == 0) {
        return true;
      }
    }

    return false;

  }

}
