package com.cmc.credagility.core.domain.webactivity;

import java.util.Date;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/16/2014 09:41
 */
public class BCCActivity extends BaseWebActivity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -4879972163307226907L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  protected Date activityTime;

  /** TODO: DOCUMENT ME! */
  protected String agentUserName;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new BCCActivity object.
   */
  public BCCActivity() { }

  /**
   * Creates a new BCCActivity object.
   *
   * @param  webActivity  WebActivity
   */
  public BCCActivity(WebActivity webActivity) {
    agentUserName = webActivity.getAgent().getUsername();
    activityTime  = webActivity.getCreateDate();
    activityName  = webActivity.getName();
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for activity time.
   *
   * @return  Date
   */
  public Date getActivityTime() {
    return activityTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

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
   * setter method for activity time.
   *
   * @param  activityTime  Date
   */
  public void setActivityTime(Date activityTime) {
    this.activityTime = activityTime;
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
} // end class BCCActivity
