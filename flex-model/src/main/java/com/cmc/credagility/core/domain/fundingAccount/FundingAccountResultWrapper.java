package com.cmc.credagility.core.domain.fundingAccount;

import java.io.Serializable;

import java.util.Map;

import com.cmc.credagility.core.domain.payment.FundingAccount;
import com.cmc.credagility.core.domain.type.FundingAccountResult;


/**
 * Created by rkodali on 2/26/2018.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public class FundingAccountResultWrapper implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 4523707513253025499L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  private Boolean deletePaymentsSuccess = null;

  private Map<String, String> errorMap = null;

  private FundingAccount          fundingAccount          = null;
  private FundingAccountException fundingAccountException = null;
  private FundingAccountResult    fundingAccountResult    = null;

  private String fundingAccountType;

  private String last4FundingAccountNumber;
  private String nickName;

  private String statusCode = null;
  private String statusText = null;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getDeletePaymentsSuccess() {
    return deletePaymentsSuccess;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Map<String, String> getErrorMap() {
    return errorMap;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public FundingAccount getFundingAccount() {
    return fundingAccount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public FundingAccountException getFundingAccountException() {
    return fundingAccountException;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public FundingAccountResult getFundingAccountResult() {
    return fundingAccountResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getFundingAccountType() {
    return fundingAccountType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getLast4FundingAccountNumber() {
    return last4FundingAccountNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getNickName() {
    return nickName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getStatusCode() {
    return statusCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getStatusText() {
    return statusText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  deletePaymentsSuccess  DOCUMENT ME!
   */
  public void setDeletePaymentsSuccess(Boolean deletePaymentsSuccess) {
    this.deletePaymentsSuccess = deletePaymentsSuccess;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  errorMap  DOCUMENT ME!
   */
  public void setErrorMap(Map<String, String> errorMap) {
    this.errorMap = errorMap;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  fundingAccount  DOCUMENT ME!
   */
  public void setFundingAccount(FundingAccount fundingAccount) {
    this.fundingAccount = fundingAccount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  fundingAccountException  DOCUMENT ME!
   */
  public void setFundingAccountException(FundingAccountException fundingAccountException) {
    this.fundingAccountException = fundingAccountException;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  fundingAccountResult  DOCUMENT ME!
   */
  public void setFundingAccountResult(FundingAccountResult fundingAccountResult) {
    this.fundingAccountResult = fundingAccountResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  fundingAccountType  DOCUMENT ME!
   */
  public void setFundingAccountType(String fundingAccountType) {
    this.fundingAccountType = fundingAccountType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  last4FundingAccountNumber  DOCUMENT ME!
   */
  public void setLast4FundingAccountNumber(String last4FundingAccountNumber) {
    this.last4FundingAccountNumber = last4FundingAccountNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  nickName  DOCUMENT ME!
   */
  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  statusCode  DOCUMENT ME!
   */
  public void setStatusCode(String statusCode) {
    this.statusCode = statusCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  statusText  DOCUMENT ME!
   */
  public void setStatusText(String statusText) {
    this.statusText = statusText;
  }
} // end class FundingAccountResultWrapper
