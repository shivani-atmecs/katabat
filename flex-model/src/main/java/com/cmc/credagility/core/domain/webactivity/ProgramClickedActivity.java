package com.cmc.credagility.core.domain.webactivity;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/16/2014 09:49
 */
public class ProgramClickedActivity extends BaseAppointmentActivity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -5002490320204632027L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String agentUserName;

  private String selectedOffer;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for agent user name.
   *
   * @return  String
   */
  public String getAgentUserName() {
    return agentUserName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for selected offer.
   *
   * @return  String
   */
  public String getSelectedOffer() {
    return selectedOffer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agent user name.
   *
   * @param  agentUserName  String
   */
  public void setAgentUserName(String agentUserName) {
    this.agentUserName = agentUserName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for selected offer.
   *
   * @param  selectedOffer  String
   */
  public void setSelectedOffer(String selectedOffer) {
    this.selectedOffer = selectedOffer;
  }
} // end class ProgramClickedActivity
