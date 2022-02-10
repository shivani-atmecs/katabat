package com.cmc.credagility.core.domain.webactivity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/16/2014 10:01
 */
public class UpdateUserActivity extends BCCActivity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 504583801582759063L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String updatedUserName;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new UpdateUserActivity object.
   *
   * @param  webActivity  WebActivity
   */
  public UpdateUserActivity(WebActivity webActivity) {
    super(webActivity);
    this.updatedUserName = webActivity.getData1();
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for updated user name.
   *
   * @return  String
   */
  public String getUpdatedUserName() {
    return updatedUserName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for updated user name.
   *
   * @param  updatedUserName  String
   */
  public void setUpdatedUserName(String updatedUserName) {
    this.updatedUserName = updatedUserName;
  }
} // end class UpdateUserActivity
