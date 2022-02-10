package com.cmc.credagility.core.domain.webactivity;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/16/2014 09:44
 */
public class CancelPaymentProgramActivity extends BaseWebActivity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 6095513164699104869L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String cancelAgentId;
  private String cancelledBy;
  private String programId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for cancel agent id.
   *
   * @return  String
   */
  public String getCancelAgentId() {
    return cancelAgentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for cancelled by.
   *
   * @return  String
   */
  public String getCancelledBy() {
    return cancelledBy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for program id.
   *
   * @return  String
   */
  public String getProgramId() {
    return programId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for cancel agent id.
   *
   * @param  cancelAgentId  String
   */
  public void setCancelAgentId(String cancelAgentId) {
    this.cancelAgentId = cancelAgentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for cancelled by.
   *
   * @param  cancelledBy  String
   */
  public void setCancelledBy(String cancelledBy) {
    this.cancelledBy = cancelledBy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for program id.
   *
   * @param  programId  String
   */
  public void setProgramId(String programId) {
    this.programId = programId;
  }


} // end class CancelPaymentProgramActivity
