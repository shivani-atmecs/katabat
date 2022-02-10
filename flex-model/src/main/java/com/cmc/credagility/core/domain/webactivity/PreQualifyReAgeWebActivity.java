package com.cmc.credagility.core.domain.webactivity;

import java.util.Date;


/**
 * PreQualifyReAgeWebActivity.java is the class for defining setters and getters for the Transaction a_PreQualifyReage.
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/16/2014 09:48
 */
public class PreQualifyReAgeWebActivity extends BaseAppointmentActivity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 1L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String delinquencyReason;

  private String delinquencyResolution;

  private Date preQualifyDate;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for delinquency reason.
   *
   * @return  String
   */
  public String getDelinquencyReason() {
    return delinquencyReason;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for delinquency resolution.
   *
   * @return  String
   */
  public String getDelinquencyResolution() {
    return delinquencyResolution;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for pre qualify date.
   *
   * @return  Date
   */
  public Date getPreQualifyDate() {
    return preQualifyDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for delinquency reason.
   *
   * @param  delinquencyReason  String
   */
  public void setDelinquencyReason(String delinquencyReason) {
    this.delinquencyReason = delinquencyReason;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for delinquency resolution.
   *
   * @param  delinquencyResolution  String
   */
  public void setDelinquencyResolution(String delinquencyResolution) {
    this.delinquencyResolution = delinquencyResolution;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for pre qualify date.
   *
   * @param  preQualifyDate  Date
   */
  public void setPreQualifyDate(Date preQualifyDate) {
    this.preQualifyDate = preQualifyDate;
  }

} // end class PreQualifyReAgeWebActivity
