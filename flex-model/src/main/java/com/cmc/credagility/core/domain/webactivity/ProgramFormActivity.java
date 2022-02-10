package com.cmc.credagility.core.domain.webactivity;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/16/2014 09:49
 */
public class ProgramFormActivity extends BaseAppointmentActivity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -3141406463939896087L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String agentUserName;

  private String primaryOffer;
  private String secondaryOffer;

  private String tertiaryOffer;

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
   * getter method for primary offer.
   *
   * @return  String
   */
  public String getPrimaryOffer() {
    return primaryOffer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for secondary offer.
   *
   * @return  String
   */
  public String getSecondaryOffer() {
    return secondaryOffer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for tertiary offer.
   *
   * @return  String
   */
  public String getTertiaryOffer() {
    return tertiaryOffer;
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
   * setter method for primary offer.
   *
   * @param  primaryOffer  String
   */
  public void setPrimaryOffer(String primaryOffer) {
    this.primaryOffer = primaryOffer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for secondary offer.
   *
   * @param  secondaryOffer  String
   */
  public void setSecondaryOffer(String secondaryOffer) {
    this.secondaryOffer = secondaryOffer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for tertiary offer.
   *
   * @param  tertiaryOffer  String
   */
  public void setTertiaryOffer(String tertiaryOffer) {
    this.tertiaryOffer = tertiaryOffer;
  }

} // end class ProgramFormActivity
