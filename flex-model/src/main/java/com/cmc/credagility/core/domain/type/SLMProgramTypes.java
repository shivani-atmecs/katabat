package com.cmc.credagility.core.domain.type;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/16/2014 14:29
 */
public enum SLMProgramTypes {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  SETTLEMENT(121, "SPS", "Settlement Program Selection"), LOAN(122, "LMS", "Loan Modification Selection"),
  SELECT_STEP(123, "SSS", "Select Step Selection"), FUTURE_PROGRAM_1(124, "FPS1", "Future Program Selection 1"),
  FUTURE_PROGRAM_2(125, "FPS2", "Future Program Selection 2"),
  FUTURE_PROGRAM_3(126, "FPS3", "Future Program Selection 3"), NOT_ELIGIBLE_PROGRAM(999, "NEP", "No Eligible Program");

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String descrption;

  private int    programTypeId;
  private String shortCode;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new SLMProgramTypes object.
   *
   * @param  programTypeId  int
   * @param  shortCode      String
   * @param  descrption     String
   */
  SLMProgramTypes(int programTypeId, String shortCode, String descrption) {
    this.programTypeId = programTypeId;
    this.shortCode     = shortCode;
    this.descrption    = descrption;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for descrption.
   *
   * @return  String
   */
  public String getDescrption() {
    return descrption;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for program type id.
   *
   * @return  int
   */
  public int getProgramTypeId() {
    return programTypeId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for short code.
   *
   * @return  String
   */
  public String getShortCode() {
    return shortCode;
  }
}
