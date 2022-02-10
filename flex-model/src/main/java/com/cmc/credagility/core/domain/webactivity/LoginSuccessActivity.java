package com.cmc.credagility.core.domain.webactivity;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/16/2014 09:47
 */
public class LoginSuccessActivity extends BaseWebActivity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 111220694951702727L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String channelOrigination = "";

  //~ Methods ----------------------------------------------------------------------------------------------------------

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
   * setter method for channel origination.
   *
   * @param  channelOrigination  String
   */
  public void setChannelOrigination(String channelOrigination) {
    this.channelOrigination = channelOrigination;
  }
} // end class LoginSuccessActivity
