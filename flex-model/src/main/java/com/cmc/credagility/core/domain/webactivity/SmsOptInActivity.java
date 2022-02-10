package com.cmc.credagility.core.domain.webactivity;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/16/2014 09:57
 */
public class SmsOptInActivity extends BaseWebActivity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  private boolean smsOptIn = false;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for sms opt in.
   *
   * @return  boolean
   */
  public boolean isSmsOptIn() {
    return smsOptIn;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for sms opt in.
   *
   * @param  smsOptIn  boolean
   */
  public void setSmsOptIn(boolean smsOptIn) {
    this.smsOptIn = smsOptIn;
  }
} // end class SmsOptInActivity
