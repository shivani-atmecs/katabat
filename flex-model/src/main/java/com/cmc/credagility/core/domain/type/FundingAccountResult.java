package com.cmc.credagility.core.domain.type;

/**
 * Created by rkodali on 2/26/2018.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public enum FundingAccountResult {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  SUCCESS("Success"), RECOVERABLE_ERROR("Recoverable_Error"), NON_RECOVERABLE_ERROR("NonRecoverable_Error"),
  SERVICE_DOWN("Service_Down");

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** String value. */
  private String strValue;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Define enum.
   */
  private FundingAccountResult() {
    this.strValue = this.name();
  }

  /**
   * Define enum with string value.
   *
   * @param  strValue  DOCUMENT ME!
   */
  private FundingAccountResult(String strValue) {
    this.strValue = strValue;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * Get the string value for the enum.
   *
   * @return  enum string value
   */
  @Override public String toString() {
    return strValue;
  }
}
