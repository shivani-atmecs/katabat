package com.cmc.credagility.core.domain.webactivity;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/16/2014 10:32
 */
public class WorkOnAccountActivity extends BaseWebActivity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -3686534796623759484L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String agentName;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for agent name.
   *
   * @return  String
   */
  public String getAgentName() {
    return agentName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agent name.
   *
   * @param  agentName  String
   */
  public void setAgentName(String agentName) {
    this.agentName = agentName;
  }
} // end class WorkOnAccountActivity
