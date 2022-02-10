package com.cmc.credagility.core.domain.webactivity;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/16/2014 09:39
 */
public abstract class BaseFundingAccountActivity extends BaseWebActivity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 6003382049055056259L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String fundingAccountId;
  private String fundingAccountNickName;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for funding account id.
   *
   * @return  String
   */
  public String getFundingAccountId() {
    return fundingAccountId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for funding account nick name.
   *
   * @return  String
   */
  public String getFundingAccountNickName() {
    return fundingAccountNickName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for funding account id.
   *
   * @param  fundingAccountId  String
   */
  public void setFundingAccountId(String fundingAccountId) {
    this.fundingAccountId = fundingAccountId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for funding account nick name.
   *
   * @param  fundingAccountNickName  String
   */
  public void setFundingAccountNickName(String fundingAccountNickName) {
    this.fundingAccountNickName = fundingAccountNickName;
  }

} // end class BaseFundingAccountActivity
