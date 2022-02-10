package com.cmc.credagility.core.domain.webactivity;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/16/2014 10:01
 */
public class UpdateEmailActivity extends BaseWebActivity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 6172179065074205394L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String emailType;
  private String newEmailAddress;
  private String oldEmailAddress;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for email type.
   *
   * @return  String
   */
  public String getEmailType() {
    return emailType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for new email address.
   *
   * @return  String
   */
  public String getNewEmailAddress() {
    return newEmailAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for old email address.
   *
   * @return  String
   */
  public String getOldEmailAddress() {
    return oldEmailAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for email type.
   *
   * @param  emailType  String
   */
  public void setEmailType(String emailType) {
    this.emailType = emailType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for new email address.
   *
   * @param  newEmailAddress  String
   */
  public void setNewEmailAddress(String newEmailAddress) {
    this.newEmailAddress = newEmailAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for old email address.
   *
   * @param  oldEmailAddress  String
   */
  public void setOldEmailAddress(String oldEmailAddress) {
    this.oldEmailAddress = oldEmailAddress;
  }

} // end class UpdateEmailActivity
