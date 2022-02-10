package com.cmc.credagility.core.domain.jms;

import java.io.Serializable;

import java.util.Map;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:pan.kang@ozstrategy.com">Pan Kang</a>
 * @version  10/15/2014 10:50
 */
public class CmcMqRequest implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -3730119771609918609L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String              accountNum;
  private String              channel            = "BATCH";
  private String              channelResultId;
  private Boolean             emailFailed        = Boolean.FALSE;
  private Map<String, String> errorMap;
  private String              errorMessage;
  private String              messageDestination = "EMAIL";
  private String              messageStagingId;
  private String              messageType        = "SendEmail";
  private String              portfolioId;
  private String              portfolioName;
  private String              responsibleId;
  private Boolean             smsFailed          = Boolean.FALSE;
  private String              transactionName;
  private String              uniqueSessionId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

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
   * getter method for channel.
   *
   * @return  String
   */
  public String getChannel() {
    return channel;
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
   * getter method for email failed.
   *
   * @return  Boolean
   */
  public Boolean getEmailFailed() {
    return emailFailed;
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
   * getter method for message destination.
   *
   * @return  String
   */
  public String getMessageDestination() {
    return messageDestination;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for message staging id.
   *
   * @return  String
   */
  public String getMessageStagingId() {
    return messageStagingId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for message type.
   *
   * @return  String
   */
  public String getMessageType() {
    return messageType;
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
   * getter method for portfolio name.
   *
   * @return  String
   */
  public String getPortfolioName() {
    return portfolioName;
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
   * getter method for sms failed.
   *
   * @return  Boolean
   */
  public Boolean getSmsFailed() {
    return smsFailed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for transaction name.
   *
   * @return  String
   */
  public String getTransactionName() {
    return transactionName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for unique session id.
   *
   * @return  String
   */
  public String getUniqueSessionId() {
    return uniqueSessionId;
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
   * setter method for channel.
   *
   * @param  channel  String
   */
  public void setChannel(String channel) {
    this.channel = channel;
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
   * setter method for email failed.
   *
   * @param  emailFailed  Boolean
   */
  public void setEmailFailed(Boolean emailFailed) {
    this.emailFailed = emailFailed;
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
   * setter method for message destination.
   *
   * @param  messageDestination  String
   */
  public void setMessageDestination(String messageDestination) {
    this.messageDestination = messageDestination;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for message staging id.
   *
   * @param  messageStagingId  String
   */
  public void setMessageStagingId(String messageStagingId) {
    this.messageStagingId = messageStagingId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for message type.
   *
   * @param  messageType  String
   */
  public void setMessageType(String messageType) {
    this.messageType = messageType;
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
   * setter method for portfolio name.
   *
   * @param  portfolioName  String
   */
  public void setPortfolioName(String portfolioName) {
    this.portfolioName = portfolioName;
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
   * setter method for sms failed.
   *
   * @param  smsFailed  Boolean
   */
  public void setSmsFailed(Boolean smsFailed) {
    this.smsFailed = smsFailed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for transaction name.
   *
   * @param  transactionName  String
   */
  public void setTransactionName(String transactionName) {
    this.transactionName = transactionName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for unique session id.
   *
   * @param  uniqueSessionId  String
   */
  public void setUniqueSessionId(String uniqueSessionId) {
    this.uniqueSessionId = uniqueSessionId;
  }
} // end class CmcMqRequest
