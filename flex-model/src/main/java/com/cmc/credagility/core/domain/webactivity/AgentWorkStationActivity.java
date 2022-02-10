package com.cmc.credagility.core.domain.webactivity;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/16/2014 09:39
 */
public class AgentWorkStationActivity extends BaseWebActivity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 8590891623493352208L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  protected String agentUserName;

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
   * setter method for agent user name.
   *
   * @param  agentUserName  String
   */
  public void setAgentUserName(String agentUserName) {
    this.agentUserName = agentUserName;
  }
} // end class AgentWorkStationActivity
