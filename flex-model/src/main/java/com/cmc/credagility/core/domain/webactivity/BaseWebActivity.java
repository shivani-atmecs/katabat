package com.cmc.credagility.core.domain.webactivity;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/16/2014 09:41
 */
public abstract class BaseWebActivity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -3849478605749146991L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  protected String accountNum;

  /** TODO: DOCUMENT ME! */
  protected String activityId;

  /** TODO: DOCUMENT ME! */
  protected String activityName;

  /** TODO: DOCUMENT ME! */
  protected String agentId;

  /** TODO: DOCUMENT ME! */
  protected BigDecimal balance;

  /** TODO: DOCUMENT ME! */
  protected String browserLanguage;

  /** TODO: DOCUMENT ME! */
  protected Date createDate;

  /** TODO: DOCUMENT ME! */
  protected Integer delinquencyDays;

  /** TODO: DOCUMENT ME! */
  protected String ipAddress;

  /** TODO: DOCUMENT ME! */
  protected Date lastUpdateDate;

  /** TODO: DOCUMENT ME! */
  protected String locale;

  /** TODO: DOCUMENT ME! */
  protected String responsibleId;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new BaseWebActivity object.
   */
  public BaseWebActivity() { }

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
   * getter method for activity id.
   *
   * @return  String
   */
  public String getActivityId() {
    return activityId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for activity name.
   *
   * @return  String
   */
  public String getActivityName() {
    return activityName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agent id.
   *
   * @return  String
   */
  public String getAgentId() {
    return agentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for balance.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBalance() {
    return balance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for browser language.
   *
   * @return  String
   */
  public String getBrowserLanguage() {
    return browserLanguage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for create date.
   *
   * @return  Date
   */
  public Date getCreateDate() {
    return createDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for delinquency days.
   *
   * @return  Integer
   */
  public Integer getDelinquencyDays() {
    return delinquencyDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ip address.
   *
   * @return  String
   */
  public String getIpAddress() {
    return ipAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last update date.
   *
   * @return  Date
   */
  public Date getLastUpdateDate() {
    return lastUpdateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for locale.
   *
   * @return  String
   */
  public String getLocale() {
    return locale;
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
   * setter method for account num.
   *
   * @param  accountNum  String
   */
  public void setAccountNum(String accountNum) {
    this.accountNum = accountNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for activity id.
   *
   * @param  activityId  String
   */
  public void setActivityId(String activityId) {
    this.activityId = activityId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for activity name.
   *
   * @param  activityName  String
   */
  public void setActivityName(String activityName) {
    this.activityName = activityName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agent id.
   *
   * @param  agentId  String
   */
  public void setAgentId(String agentId) {
    this.agentId = agentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for balance.
   *
   * @param  balance  BigDecimal
   */
  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for browser language.
   *
   * @param  browserLanguage  String
   */
  public void setBrowserLanguage(String browserLanguage) {
    this.browserLanguage = browserLanguage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for create date.
   *
   * @param  createDate  Date
   */
  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for delinquency days.
   *
   * @param  delinquencyDays  Integer
   */
  public void setDelinquencyDays(Integer delinquencyDays) {
    this.delinquencyDays = delinquencyDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ip address.
   *
   * @param  ipAddress  String
   */
  public void setIpAddress(String ipAddress) {
    this.ipAddress = ipAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last update date.
   *
   * @param  lastUpdateDate  Date
   */
  public void setLastUpdateDate(Date lastUpdateDate) {
    this.lastUpdateDate = lastUpdateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for locale.
   *
   * @param  locale  String
   */
  public void setLocale(String locale) {
    this.locale = locale;
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

} // end class BaseWebActivity
