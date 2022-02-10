package com.cmc.credagility.core.domain.fundingAccount;

/**
 * Created by rkodali on 2/26/2018.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public class FundingAccountException {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  protected String exceptionMessage;

  /** DOCUMENT ME! */
  protected Long fundingAccountId;

  /** DOCUMENT ME! */
  protected boolean hasError;

  /** DOCUMENT ME! */
  protected String userLogon;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /* Constructors */
  public FundingAccountException() {}

  public FundingAccountException(Long fundingAccountId, String exceptionMessage) {
    this.fundingAccountId = fundingAccountId;
    this.exceptionMessage = exceptionMessage;
    this.hasError = true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getExceptionMessage() {
    return exceptionMessage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getFundingAccountId() {
    return fundingAccountId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getUserLogon() {
    return userLogon;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isHasError() {
    return hasError;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  exceptionMessage  DOCUMENT ME!
   */
  public void setExceptionMessage(String exceptionMessage) {
    this.exceptionMessage = exceptionMessage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  fundingAccountId  DOCUMENT ME!
   */
  public void setFundingAccountId(Long fundingAccountId) {
    this.fundingAccountId = fundingAccountId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  hasError  DOCUMENT ME!
   */
  public void setHasError(boolean hasError) {
    this.hasError = hasError;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  userLogon  DOCUMENT ME!
   */
  public void setUserLogon(String userLogon) {
    this.userLogon = userLogon;
  }
} // end class FundingAccountException
