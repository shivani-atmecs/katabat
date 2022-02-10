package com.cmc.credagility.core.domain.webactivity;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/16/2014 09:54
 */
public class SLMBaseAppointmentActivity extends BaseAppointmentActivity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -6339600744304297006L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String appointmentTimeZone;
  private String firstName;
  private String lastName;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for appointment time zone.
   *
   * @return  String
   */
  public String getAppointmentTimeZone() {
    return appointmentTimeZone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for first name.
   *
   * @return  String
   */
  public String getFirstName() {
    return firstName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last name.
   *
   * @return  String
   */
  public String getLastName() {
    return lastName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for appointment time zone.
   *
   * @param  appointmentTimeZone  String
   */
  public void setAppointmentTimeZone(String appointmentTimeZone) {
    this.appointmentTimeZone = appointmentTimeZone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for first name.
   *
   * @param  firstName  String
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last name.
   *
   * @param  lastName  String
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

} // end class SLMBaseAppointmentActivity
