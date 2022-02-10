package com.cmc.credagility.core.domain.webactivity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/16/2014 09:44
 */
public class ChargeOffDelayActivity extends BaseWebActivity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String chargeOffDelayDate;

  private String chargeOffDelayReason;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for charge off delay date.
   *
   * @return  String
   */
  public String getChargeOffDelayDate() {
    return chargeOffDelayDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for charge off delay reason.
   *
   * @return  String
   */
  public String getChargeOffDelayReason() {
    return chargeOffDelayReason;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for charge off delay date.
   *
   * @param  chargeOffDelayDate  String
   */
  public void setChargeOffDelayDate(String chargeOffDelayDate) {
    this.chargeOffDelayDate = chargeOffDelayDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for charge off delay reason.
   *
   * @param  chargeOffDelayReason  String
   */
  public void setChargeOffDelayReason(String chargeOffDelayReason) {
    this.chargeOffDelayReason = chargeOffDelayReason;
  }
} // end class ChargeOffDelayActivity
