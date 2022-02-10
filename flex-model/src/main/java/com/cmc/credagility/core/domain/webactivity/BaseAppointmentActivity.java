package com.cmc.credagility.core.domain.webactivity;

import java.util.Date;
import java.util.Map;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/16/2014 09:39
 */
public abstract class BaseAppointmentActivity extends BaseWebActivity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -7696438015192149586L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private Date                appointmentDateTime;
  private String              appointmentId;
  private String              comment;
  private String              language;
  private Map<String, String> phoneNums;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for appointment date time.
   *
   * @return  Date
   */
  public Date getAppointmentDateTime() {
    return appointmentDateTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for appointment id.
   *
   * @return  String
   */
  public String getAppointmentId() {
    return appointmentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for comment.
   *
   * @return  String
   */
  public String getComment() {
    return comment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for language.
   *
   * @return  String
   */
  public String getLanguage() {
    return language;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for phone nums.
   *
   * @return  Map
   */
  public Map<String, String> getPhoneNums() {
    return phoneNums;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for appointment date time.
   *
   * @param  appointmentDateTime  Date
   */
  public void setAppointmentDateTime(Date appointmentDateTime) {
    this.appointmentDateTime = appointmentDateTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for appointment id.
   *
   * @param  appointmentId  String
   */
  public void setAppointmentId(String appointmentId) {
    this.appointmentId = appointmentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for comment.
   *
   * @param  comment  String
   */
  public void setComment(String comment) {
    this.comment = comment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for language.
   *
   * @param  language  String
   */
  public void setLanguage(String language) {
    this.language = language;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for phone nums.
   *
   * @param  phoneNums  Map
   */
  public void setPhoneNums(Map<String, String> phoneNums) {
    this.phoneNums = phoneNums;
  }

} // end class BaseAppointmentActivity
