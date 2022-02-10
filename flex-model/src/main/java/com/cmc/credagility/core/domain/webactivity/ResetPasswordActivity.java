package com.cmc.credagility.core.domain.webactivity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/16/2014 09:50
 */
public class ResetPasswordActivity extends BCCActivity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 8985546904470837228L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String resetUserName;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new ResetPasswordActivity object.
   *
   * @param  webActivity  WebActivity
   */
  public ResetPasswordActivity(WebActivity webActivity) {
    super(webActivity);
    this.resetUserName = webActivity.getData1();
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for reset user name.
   *
   * @return  String
   */
  public String getResetUserName() {
    return resetUserName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for reset user name.
   *
   * @param  resetUserName  String
   */
  public void setResetUserName(String resetUserName) {
    this.resetUserName = resetUserName;
  }
} // end class ResetPasswordActivity
