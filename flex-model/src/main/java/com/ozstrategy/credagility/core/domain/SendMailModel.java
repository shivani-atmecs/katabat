package com.ozstrategy.credagility.core.domain;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/16/2014 15:00
 */
public class SendMailModel {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String contentTemplate;
  private String createDate;
  private String createdBy;
  private String currentDate;
  private String emailCC;
  private String emailTo;
  private String emialBCC;
  private String lastupdateBy;
  private String lastUpdateDate;
  private String portfolio;
  private String publishedBy;
  private String scheduleDate;
  private String scheduleName;
  private String subject;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new SendMailModel object.
   *
   * @param  scheduleName  String
   * @param  subject       String
   * @param  scheduleDate  Date
   * @param  publishedBy   String
   * @param  notification  PortfolioEventNotification
   */
  public SendMailModel(String scheduleName, String subject, Date scheduleDate, String publishedBy,
    PortfolioEventNotification notification) {
    SimpleDateFormat sdf = new SimpleDateFormat();
    this.setPortfolio(notification.getPortfolio().getName());
    this.setSubject(subject);
    this.setCurrentDate(sdf.format(new Date()));
    this.setScheduleDate(sdf.format(scheduleDate));
    this.setScheduleName(scheduleName);
    this.setCreatedBy(notification.getCreator().getUsername());
    this.setCreateDate(sdf.format(notification.getCreateDate()));
    this.setLastupdateBy(notification.getLastUpdater().getUsername());
    this.setLastUpdateDate(sdf.format(notification.getLastUpdateDate()));
    this.setEmailTo(notification.getEmailTo());
    this.setEmailCC(notification.getEmailCC());
    this.setEmialBCC(notification.getEmailBCC());
    this.setContentTemplate(notification.getEmailTemplate());
    this.setPublishedBy(publishedBy);
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for content template.
   *
   * @return  String
   */
  public String getContentTemplate() {
    return contentTemplate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for create date.
   *
   * @return  String
   */
  public String getCreateDate() {
    return createDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for created by.
   *
   * @return  String
   */
  public String getCreatedBy() {
    return createdBy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for current date.
   *
   * @return  String
   */
  public String getCurrentDate() {
    return currentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for email CC.
   *
   * @return  String
   */
  public String getEmailCC() {
    return emailCC;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for email to.
   *
   * @return  String
   */
  public String getEmailTo() {
    return emailTo;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for emial BCC.
   *
   * @return  String
   */
  public String getEmialBCC() {
    return emialBCC;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for lastupdate by.
   *
   * @return  String
   */
  public String getLastupdateBy() {
    return lastupdateBy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last update date.
   *
   * @return  String
   */
  public String getLastUpdateDate() {
    return lastUpdateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio.
   *
   * @return  String
   */
  public String getPortfolio() {
    return portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for published by.
   *
   * @return  String
   */
  public String getPublishedBy() {
    return publishedBy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for schedule date.
   *
   * @return  String
   */
  public String getScheduleDate() {
    return scheduleDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for schedule name.
   *
   * @return  String
   */
  public String getScheduleName() {
    return scheduleName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for subject.
   *
   * @return  String
   */
  public String getSubject() {
    return subject;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for content template.
   *
   * @param  contentTemplate  String
   */
  public void setContentTemplate(String contentTemplate) {
    this.contentTemplate = contentTemplate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for create date.
   *
   * @param  createDate  String
   */
  public void setCreateDate(String createDate) {
    this.createDate = createDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for created by.
   *
   * @param  createdBy  String
   */
  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for current date.
   *
   * @param  currentDate  String
   */
  public void setCurrentDate(String currentDate) {
    this.currentDate = currentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for email CC.
   *
   * @param  emailCC  String
   */
  public void setEmailCC(String emailCC) {
    this.emailCC = emailCC;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for email to.
   *
   * @param  emailTo  String
   */
  public void setEmailTo(String emailTo) {
    this.emailTo = emailTo;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for emial BCC.
   *
   * @param  emialBCC  String
   */
  public void setEmialBCC(String emialBCC) {
    this.emialBCC = emialBCC;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for lastupdate by.
   *
   * @param  lastupdateBy  String
   */
  public void setLastupdateBy(String lastupdateBy) {
    this.lastupdateBy = lastupdateBy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last update date.
   *
   * @param  lastUpdateDate  String
   */
  public void setLastUpdateDate(String lastUpdateDate) {
    this.lastUpdateDate = lastUpdateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio.
   *
   * @param  portfolio  String
   */
  public void setPortfolio(String portfolio) {
    this.portfolio = portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for published by.
   *
   * @param  publishedBy  String
   */
  public void setPublishedBy(String publishedBy) {
    this.publishedBy = publishedBy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for schedule date.
   *
   * @param  scheduleDate  String
   */
  public void setScheduleDate(String scheduleDate) {
    this.scheduleDate = scheduleDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for schedule name.
   *
   * @param  scheduleName  String
   */
  public void setScheduleName(String scheduleName) {
    this.scheduleName = scheduleName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for subject.
   *
   * @param  subject  String
   */
  public void setSubject(String subject) {
    this.subject = subject;
  }
} // end class SendMailModel
