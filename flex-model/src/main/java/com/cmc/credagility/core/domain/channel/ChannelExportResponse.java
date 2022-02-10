package com.cmc.credagility.core.domain.channel;

import java.io.Serializable;

import java.util.Map;


/**
 * Channel Export Response!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/15/2014 14:54
 */
public class ChannelExportResponse implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -7648339295602668442L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String              accountNum;
  private String              channelResultId;
  private Boolean             error           = Boolean.FALSE;
  private Map<String, String> errorMap;
  private String              errorMessage;
  private String              fromNumber;
  private Boolean             isMraAccount    = Boolean.FALSE;
  private String              portfolioId;
  private Integer             responseCode;
  private String              responseMessage;
  private String              responsibleId;
  private String              smsStatus;
  private String              successMessage;
  private String              templateName;
  private String              uniqueSmsId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof ChannelExportResponse)) {
      return false;
    }

    ChannelExportResponse that = (ChannelExportResponse) o;

    if ((accountNum != null) ? (!accountNum.equals(that.accountNum)) : (that.accountNum != null)) {
      return false;
    }

    if ((channelResultId != null) ? (!channelResultId.equals(that.channelResultId)) : (that.channelResultId != null)) {
      return false;
    }

    if ((error != null) ? (!error.equals(that.error)) : (that.error != null)) {
      return false;
    }

    if ((errorMap != null) ? (!errorMap.equals(that.errorMap)) : (that.errorMap != null)) {
      return false;
    }

    if ((errorMessage != null) ? (!errorMessage.equals(that.errorMessage)) : (that.errorMessage != null)) {
      return false;
    }

    if ((isMraAccount != null) ? (!isMraAccount.equals(that.isMraAccount)) : (that.isMraAccount != null)) {
      return false;
    }

    if ((portfolioId != null) ? (!portfolioId.equals(that.portfolioId)) : (that.portfolioId != null)) {
      return false;
    }

    if ((responseCode != null) ? (!responseCode.equals(that.responseCode)) : (that.responseCode != null)) {
      return false;
    }

    if ((responseMessage != null) ? (!responseMessage.equals(that.responseMessage)) : (that.responseMessage != null)) {
      return false;
    }

    if ((responsibleId != null) ? (!responsibleId.equals(that.responsibleId)) : (that.responsibleId != null)) {
      return false;
    }

    if ((smsStatus != null) ? (!smsStatus.equals(that.smsStatus)) : (that.smsStatus != null)) {
      return false;
    }

    if ((successMessage != null) ? (!successMessage.equals(that.successMessage)) : (that.successMessage != null)) {
      return false;
    }

    if ((templateName != null) ? (!templateName.equals(that.templateName)) : (that.templateName != null)) {
      return false;
    }

    if ((uniqueSmsId != null) ? (!uniqueSmsId.equals(that.uniqueSmsId)) : (that.uniqueSmsId != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account num.
   *
   * @return  String
   */
  public String getAccountNum() {
    return accountNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for channel result id.
   *
   * @return  String
   */
  public String getChannelResultId() {
    return channelResultId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for error.
   *
   * @return  Boolean
   */
  public Boolean getError() {
    return error;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for error map.
   *
   * @return  Map
   */
  public Map<String, String> getErrorMap() {
    return errorMap;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for error message.
   *
   * @return  String
   */
  public String getErrorMessage() {
    return errorMessage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for from number.
   *
   * @return  String
   */
  public String getFromNumber() {
    return fromNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for mra account.
   *
   * @return  Boolean
   */
  public Boolean getMraAccount() {
    return isMraAccount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio id.
   *
   * @return  String
   */
  public String getPortfolioId() {
    return portfolioId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for response code.
   *
   * @return  Integer
   */
  public Integer getResponseCode() {
    return responseCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for response message.
   *
   * @return  String
   */
  public String getResponseMessage() {
    return responseMessage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible id.
   *
   * @return  String
   */
  public String getResponsibleId() {
    return responsibleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for sms status.
   *
   * @return  String
   */
  public String getSmsStatus() {
    return smsStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for success message.
   *
   * @return  String
   */
  public String getSuccessMessage() {
    return successMessage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for template name.
   *
   * @return  String
   */
  public String getTemplateName() {
    return templateName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for unique sms id.
   *
   * @return  String
   */
  public String getUniqueSmsId() {
    return uniqueSmsId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    int result = (accountNum != null) ? accountNum.hashCode() : 0;
    result = (31 * result) + ((channelResultId != null) ? channelResultId.hashCode() : 0);
    result = (31 * result) + ((error != null) ? error.hashCode() : 0);
    result = (31 * result) + ((errorMap != null) ? errorMap.hashCode() : 0);
    result = (31 * result) + ((errorMessage != null) ? errorMessage.hashCode() : 0);
    result = (31 * result) + ((isMraAccount != null) ? isMraAccount.hashCode() : 0);
    result = (31 * result) + ((portfolioId != null) ? portfolioId.hashCode() : 0);
    result = (31 * result) + ((responseCode != null) ? responseCode.hashCode() : 0);
    result = (31 * result) + ((responseMessage != null) ? responseMessage.hashCode() : 0);
    result = (31 * result) + ((responsibleId != null) ? responsibleId.hashCode() : 0);
    result = (31 * result) + ((smsStatus != null) ? smsStatus.hashCode() : 0);
    result = (31 * result) + ((successMessage != null) ? successMessage.hashCode() : 0);
    result = (31 * result) + ((templateName != null) ? templateName.hashCode() : 0);
    result = (31 * result) + ((uniqueSmsId != null) ? uniqueSmsId.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account num.
   *
   * @param  accountNum  String
   */
  public void setAccountNum(String accountNum) {
    this.accountNum = accountNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for channel result id.
   *
   * @param  channelResultId  String
   */
  public void setChannelResultId(String channelResultId) {
    this.channelResultId = channelResultId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for error.
   *
   * @param  error  Boolean
   */
  public void setError(Boolean error) {
    this.error = error;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for error map.
   *
   * @param  errorMap  Map
   */
  public void setErrorMap(Map<String, String> errorMap) {
    this.errorMap = errorMap;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for error message.
   *
   * @param  errorMessage  String
   */
  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for from number.
   *
   * @param  fromNumber  String
   */
  public void setFromNumber(String fromNumber) {
    this.fromNumber = fromNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for mra account.
   *
   * @param  mraAccount  Boolean
   */
  public void setMraAccount(Boolean mraAccount) {
    isMraAccount = mraAccount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio id.
   *
   * @param  portfolioId  String
   */
  public void setPortfolioId(String portfolioId) {
    this.portfolioId = portfolioId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for response code.
   *
   * @param  responseCode  Integer
   */
  public void setResponseCode(Integer responseCode) {
    this.responseCode = responseCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for response message.
   *
   * @param  responseMessage  String
   */
  public void setResponseMessage(String responseMessage) {
    this.responseMessage = responseMessage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for responsible id.
   *
   * @param  responsibleId  String
   */
  public void setResponsibleId(String responsibleId) {
    this.responsibleId = responsibleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for sms status.
   *
   * @param  smsStatus  String
   */
  public void setSmsStatus(String smsStatus) {
    this.smsStatus = smsStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for success message.
   *
   * @param  successMessage  String
   */
  public void setSuccessMessage(String successMessage) {
    this.successMessage = successMessage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for template name.
   *
   * @param  templateName  String
   */
  public void setTemplateName(String templateName) {
    this.templateName = templateName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for unique sms id.
   *
   * @param  uniqueSmsId  String
   */
  public void setUniqueSmsId(String uniqueSmsId) {
    this.uniqueSmsId = uniqueSmsId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#toString()
   */
  @Override public String toString() {
    return "ChannelExportResponse{"
      + "accountNum='" + accountNum + '\''
      + ", channelResultId='" + channelResultId + '\''
      + ", error=" + error
      + ", errorMap=" + errorMap
      + ", errorMessage='" + errorMessage + '\''
      + ", isMraAccount=" + isMraAccount
      + ", portfolioId='" + portfolioId + '\''
      + ", responseCode=" + responseCode
      + ", responseMessage='" + responseMessage + '\''
      + ", responsibleId='" + responsibleId + '\''
      + ", smsStatus='" + smsStatus + '\''
      + ", successMessage='" + successMessage + '\''
      + ", templateName='" + templateName + '\''
      + ", uniqueSmsId='" + uniqueSmsId + '\''
      + '}';
  }

} // end class ChannelExportResponse
