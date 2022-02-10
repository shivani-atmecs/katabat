package com.cmc.credagility.core.domain.webactivity;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/16/2014 09:47
 */
public class LoginFailureActivity extends BaseWebActivity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 3895491559785144194L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String attemptedResponsibleId;
  private String channelOrigination = "";
  private String loginTokens        = "";

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for attempted responsible id.
   *
   * @return  String
   */
  public String getAttemptedResponsibleId() {
    return attemptedResponsibleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for channel origination.
   *
   * @return  String
   */
  public String getChannelOrigination() {
    return channelOrigination;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for login tokens.
   *
   * @return  String
   */
  public String getLoginTokens() {
    return loginTokens;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for attempted responsible id.
   *
   * @param  attemptedResponsibleId  String
   */
  public void setAttemptedResponsibleId(String attemptedResponsibleId) {
    this.attemptedResponsibleId = attemptedResponsibleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for channel origination.
   *
   * @param  channelOrigination  String
   */
  public void setChannelOrigination(String channelOrigination) {
    this.channelOrigination = channelOrigination;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for login tokens.
   *
   * @param  loginTokens  String
   */
  public void setLoginTokens(String loginTokens) {
    this.loginTokens = loginTokens;
  }
} // end class LoginFailureActivity
