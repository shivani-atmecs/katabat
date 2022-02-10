package com.cmc.credagility.core.domain.webactivity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/16/2014 09:53
 */
public class SettlementConfirmationActivity extends BaseWebActivity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 6655441544362778547L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String acceptedAmount;

  private String firstThreeInstallments = "";
  private String percentageAccepted     = "";

  private String programId            = "";
  private String settlementPreference = "";

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for accepted amount.
   *
   * @return  String
   */
  public String getAcceptedAmount() {
    return acceptedAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for first three installments.
   *
   * @return  String
   */
  public String getFirstThreeInstallments() {
    return firstThreeInstallments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for percentage accepted.
   *
   * @return  String
   */
  public String getPercentageAccepted() {
    return percentageAccepted;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for program id.
   *
   * @return  String
   */
  public String getProgramId() {
    return programId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for settlement preference.
   *
   * @return  String
   */
  public String getSettlementPreference() {
    return settlementPreference;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for accepted amount.
   *
   * @param  acceptedAmount  String
   */
  public void setAcceptedAmount(String acceptedAmount) {
    this.acceptedAmount = acceptedAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for first three installments.
   *
   * @param  firstThreeInstallments  String
   */
  public void setFirstThreeInstallments(String firstThreeInstallments) {
    this.firstThreeInstallments = firstThreeInstallments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for percentage accepted.
   *
   * @param  percentageAccepted  String
   */
  public void setPercentageAccepted(String percentageAccepted) {
    this.percentageAccepted = percentageAccepted;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for program id.
   *
   * @param  programId  String
   */
  public void setProgramId(String programId) {
    this.programId = programId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for settlement preference.
   *
   * @param  settlementPreference  String
   */
  public void setSettlementPreference(String settlementPreference) {
    this.settlementPreference = settlementPreference;
  }
} // end class SettlementConfirmationActivity
