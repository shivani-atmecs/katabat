package com.cmc.credagility.core.domain.webactivity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/16/2014 09:50
 */
public class RemoveUserActivity extends BCCActivity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 6951204933971375295L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String removedUserName;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new RemoveUserActivity object.
   *
   * @param  webActivity  WebActivity
   */
  public RemoveUserActivity(WebActivity webActivity) {
    super(webActivity);
    this.removedUserName = webActivity.getData1();
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for removed user name.
   *
   * @return  String
   */
  public String getRemovedUserName() {
    return removedUserName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for removed user name.
   *
   * @param  removedUserName  String
   */
  public void setRemovedUserName(String removedUserName) {
    this.removedUserName = removedUserName;
  }

} // end class RemoveUserActivity
