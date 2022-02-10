package com.cmc.credagility.core.domain.webactivity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/16/2014 09:39
 */
public class AddUserActivity extends BCCActivity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -2197899469391016599L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String addedUserName;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new AddUserActivity object.
   *
   * @param  webActivity  WebActivity
   */
  public AddUserActivity(WebActivity webActivity) {
    super(webActivity);
    this.addedUserName = webActivity.getData1();
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for added user name.
   *
   * @return  String
   */
  public String getAddedUserName() {
    return addedUserName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for added user name.
   *
   * @param  addedUserName  String
   */
  public void setAddedUserName(String addedUserName) {
    this.addedUserName = addedUserName;
  }
} // end class AddUserActivity
