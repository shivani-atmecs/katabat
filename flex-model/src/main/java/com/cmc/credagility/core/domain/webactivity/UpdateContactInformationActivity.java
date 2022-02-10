package com.cmc.credagility.core.domain.webactivity;

import org.apache.commons.lang3.StringUtils;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/16/2014 10:01
 */
public class UpdateContactInformationActivity extends BaseWebActivity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -2991193421494401999L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  protected String address1;

  /** TODO: DOCUMENT ME! */
  protected String address2;

  /** TODO: DOCUMENT ME! */
  protected String address3;

  /** TODO: DOCUMENT ME! */
  protected String city;

  /** TODO: DOCUMENT ME! */
  protected String country;

  /** TODO: DOCUMENT ME! */
  protected String emailAddress;

  /** TODO: DOCUMENT ME! */
  protected String homePhone;

  /** TODO: DOCUMENT ME! */
  protected String mobilePhone;

  /** TODO: DOCUMENT ME! */
  protected String otherPhone;

  /** TODO: DOCUMENT ME! */
  protected String postalCode;

  /** TODO: DOCUMENT ME! */
  protected String province;

  /** TODO: DOCUMENT ME! */
  protected String sms;

  /** TODO: DOCUMENT ME! */
  protected String workPhone;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for formatted phone.
   *
   * @param   num  String
   *
   * @return  String
   */
  public static String getFormattedPhone(String num) {
    if (!StringUtils.isBlank(num) && (num.length() == 10)) {
      StringBuffer buffer = new StringBuffer();
      buffer.append(num.substring(0, 3));
      buffer.append("-");
      buffer.append(num.substring(3, 6));
      buffer.append("-");
      buffer.append(num.substring(6, 10));

      return buffer.toString();
    } else {
      return num;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for formatted zip.
   *
   * @param   num  String
   *
   * @return  String
   */
  public static String getFormattedZip(String num) {
    if (!StringUtils.isBlank(num) && (num.length() == 9)) {
      StringBuffer buffer = new StringBuffer();
      buffer.append(num.substring(0, 5));
      buffer.append("-");
      buffer.append(num.substring(5, 9));

      return buffer.toString();
    } else {
      return num;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for address1.
   *
   * @return  String
   */
  public String getAddress1() {
    return address1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for address2.
   *
   * @return  String
   */
  public String getAddress2() {
    return address2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for address3.
   *
   * @return  String
   */
  public String getAddress3() {
    return address3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for city.
   *
   * @return  String
   */
  public String getCity() {
    return city;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for country.
   *
   * @return  String
   */
  public String getCountry() {
    return country;
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
   * getter method for home phone.
   *
   * @return  String
   */
  public String getHomePhone() {
    return homePhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for mobile phone.
   *
   * @return  String
   */
  public String getMobilePhone() {
    return mobilePhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for other phone.
   *
   * @return  String
   */
  public String getOtherPhone() {
    return otherPhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for postal code.
   *
   * @return  String
   */
  public String getPostalCode() {
    return postalCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for province.
   *
   * @return  String
   */
  public String getProvince() {
    return province;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for sms.
   *
   * @return  String
   */
  public String getSms() {
    return sms;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for work phone.
   *
   * @return  String
   */
  public String getWorkPhone() {
    return workPhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for address1.
   *
   * @param  address1  String
   */
  public void setAddress1(String address1) {
    this.address1 = address1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for address2.
   *
   * @param  address2  String
   */
  public void setAddress2(String address2) {
    this.address2 = address2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for address3.
   *
   * @param  address3  String
   */
  public void setAddress3(String address3) {
    this.address3 = address3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for city.
   *
   * @param  city  String
   */
  public void setCity(String city) {
    this.city = city;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for country.
   *
   * @param  country  String
   */
  public void setCountry(String country) {
    this.country = country;
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
   * setter method for home phone.
   *
   * @param  homePhone  String
   */
  public void setHomePhone(String homePhone) {
    this.homePhone = homePhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for mobile phone.
   *
   * @param  mobilePhone  String
   */
  public void setMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for other phone.
   *
   * @param  otherPhone  String
   */
  public void setOtherPhone(String otherPhone) {
    this.otherPhone = otherPhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for postal code.
   *
   * @param  postalCode  String
   */
  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for province.
   *
   * @param  province  String
   */
  public void setProvince(String province) {
    this.province = province;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for sms.
   *
   * @param  sms  String
   */
  public void setSms(String sms) {
    this.sms = sms;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for work phone.
   *
   * @param  workPhone  String
   */
  public void setWorkPhone(String workPhone) {
    this.workPhone = workPhone;
  }
} // end class UpdateContactInformationActivity
