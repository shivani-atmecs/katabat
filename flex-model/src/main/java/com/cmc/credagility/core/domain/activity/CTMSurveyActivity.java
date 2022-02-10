package com.cmc.credagility.core.domain.activity;

import com.cmc.credagility.core.domain.homeequity.HomeEquityCTMSurvey;
import com.cmc.credagility.core.domain.survey.SurveyActivity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/16/2014 10:53
 */
public class CTMSurveyActivity extends SurveyActivity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** activity type. */
  private static String CHANNEL = "CTMSurvey";

  /** activity type. */
  private static String NAME = "CTMSurveyActivity";

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.survey.SurveyActivity#getChannel()
   */
  @Override public String getChannel() {
    return CHANNEL;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.survey.SurveyActivity#getName()
   */
  @Override public String getName() {
    return NAME;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * populateBasicInfo.
   *
   * @param  survey  HomeEquityCTMSurvey
   */
  public void populateBasicInfo(HomeEquityCTMSurvey survey) {
    this.setAccount(survey.getAccount());
    this.setBalance(survey.getAccount().getBalance());
    this.setDelinquencyDays(survey.getAccount().getDelinquencyDays());
    this.setResponsible(survey.getResponsible());
  }

} // end class CTMSurveyActivity
