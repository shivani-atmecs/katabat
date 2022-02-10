package com.cmc.credagility.core.domain.webactivity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/16/2014 09:46
 */
public class ExpressConsentActivity extends BaseWebActivity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String activityAgentId;

  private String activitySource;

  private String address;
  private String consentIndicator;

  private String contactType;
  private String emailAddress;
  private String phoneNumber;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for activity agent id.
   *
   * @return  String
   */
  public String getActivityAgentId() {
    return activityAgentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for activity source.
   *
   * @return  String
   */
  public String getActivitySource() {
    return activitySource;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for address.
   *
   * @return  String
   */
  public String getAddress() {
    return address;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for consent indicator.
   *
   * @return  String
   */
  public String getConsentIndicator() {
    return consentIndicator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for contact type.
   *
   * @return  String
   */
  public String getContactType() {
    return contactType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for email address.
   *
   * @return  String
   */
  public String getEmailAddress() {
    return emailAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for phone number.
   *
   * @return  String
   */
  public String getPhoneNumber() {
    return phoneNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for activity agent id.
   *
   * @param  activityAgentId  String
   */
  public void setActivityAgentId(String activityAgentId) {
    this.activityAgentId = activityAgentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for activity source.
   *
   * @param  activitySource  String
   */
  public void setActivitySource(String activitySource) {
    this.activitySource = activitySource;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for address.
   *
   * @param  address  String
   */
  public void setAddress(String address) {
    this.address = address;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for consent indicator.
   *
   * @param  consentIndicator  String
   */
  public void setConsentIndicator(String consentIndicator) {
    this.consentIndicator = consentIndicator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for contact type.
   *
   * @param  contactType  String
   */
  public void setContactType(String contactType) {
    this.contactType = contactType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for email address.
   *
   * @param  emailAddress  String
   */
  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for phone number.
   *
   * @param  phoneNumber  String
   */
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }


} // end class ExpressConsentActivity
