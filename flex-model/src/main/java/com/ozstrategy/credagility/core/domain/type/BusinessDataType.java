package com.ozstrategy.credagility.core.domain.type;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/16/2014 16:34
 */
public enum BusinessDataType {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  STRING("String"), CURRENCY("Currency"), PERCENTAGE("Percentage"), DECIMAL("Decimal"), INTEGER("Integer"),
  BOOLEAN("Boolean"), DATE("Date"), DOCUMENT_UPLOAD("Document Upload"), DOCUMENT_STATUS("Document Status"),
  DOCUMENT_PREVIEW("Document Preview"), AGENCY_CONTEXT("Agency Context"), AGENT_CONTEXT("Agent Context"),
  BusinessDataType, EXTERNAL_ENTITY("External Entity");

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** String value. */
  private String strValue;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Define enum.
   */
  private BusinessDataType() {
    this.strValue = this.name();
  }

  private BusinessDataType(String strValue) {
    this.strValue = strValue;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  Enum#toString()
   */
  @Override public String toString() {
    return strValue;
  }
}
