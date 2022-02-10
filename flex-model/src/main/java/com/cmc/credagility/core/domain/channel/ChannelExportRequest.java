package com.cmc.credagility.core.domain.channel;

import java.io.Serializable;


/**
 * Channel Export Request.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/15/2014 14:55
 */
public class ChannelExportRequest implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -8329234343678136765L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String  accountNum;
  private String  bcc;
  private String  cc;
  private String  channelResultId;
  private String  fileLocation;
  private String  fileName;
  private String  friendlyName;
  private String  from;
  private Boolean hasAttachment    = Boolean.FALSE;
  private String  htmlBody;
  private Boolean htmlEmail        = Boolean.FALSE;
  private Boolean isHighImportance = Boolean.FALSE;
  private Boolean isMraAccount     = Boolean.FALSE;
  private String  password;
  private String  portfolioId;
  private String  replyToEmail;
  private String  responsibleId;
  private String  smsCallbackUrl;
  private Long    smsProviderId    = 1L;
  private String  subject;
  private String  templateName;
  private String  textBody;
  private String  to;
  private String  userName;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof ChannelExportRequest)) {
      return false;
    }

    ChannelExportRequest that = (ChannelExportRequest) o;

    if ((accountNum != null) ? (!accountNum.equals(that.accountNum)) : (that.accountNum != null)) {
      return false;
    }

    if ((bcc != null) ? (!bcc.equals(that.bcc)) : (that.bcc != null)) {
      return false;
    }

    if ((cc != null) ? (!cc.equals(that.cc)) : (that.cc != null)) {
      return false;
    }

    if ((channelResultId != null) ? (!channelResultId.equals(that.channelResultId)) : (that.channelResultId != null)) {
      return false;
    }

    if ((fileLocation != null) ? (!fileLocation.equals(that.fileLocation)) : (that.fileLocation != null)) {
      return false;
    }

    if ((fileName != null) ? (!fileName.equals(that.fileName)) : (that.fileName != null)) {
      return false;
    }

    if ((from != null) ? (!from.equals(that.from)) : (that.from != null)) {
      return false;
    }

    if ((hasAttachment != null) ? (!hasAttachment.equals(that.hasAttachment)) : (that.hasAttachment != null)) {
      return false;
    }

    if ((htmlBody != null) ? (!htmlBody.equals(that.htmlBody)) : (that.htmlBody != null)) {
      return false;
    }

    if ((htmlEmail != null) ? (!htmlEmail.equals(that.htmlEmail)) : (that.htmlEmail != null)) {
      return false;
    }

    if ((isHighImportance != null) ? (!isHighImportance.equals(that.isHighImportance))
                                   : (that.isHighImportance != null)) {
      return false;
    }

    if ((isMraAccount != null) ? (!isMraAccount.equals(that.isMraAccount)) : (that.isMraAccount != null)) {
      return false;
    }

    if ((portfolioId != null) ? (!portfolioId.equals(that.portfolioId)) : (that.portfolioId != null)) {
      return false;
    }

    if ((responsibleId != null) ? (!responsibleId.equals(that.responsibleId)) : (that.responsibleId != null)) {
      return false;
    }

    if ((smsCallbackUrl != null) ? (!smsCallbackUrl.equals(that.smsCallbackUrl)) : (that.smsCallbackUrl != null)) {
      return false;
    }

    if ((subject != null) ? (!subject.equals(that.subject)) : (that.subject != null)) {
      return false;
    }

    if ((templateName != null) ? (!templateName.equals(that.templateName)) : (that.templateName != null)) {
      return false;
    }

    if ((textBody != null) ? (!textBody.equals(that.textBody)) : (that.textBody != null)) {
      return false;
    }

    if ((to != null) ? (!to.equals(that.to)) : (that.to != null)) {
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
   * getter method for bcc.
   *
   * @return  String
   */
  public String getBcc() {
    return bcc;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for cc.
   *
   * @return  String
   */
  public String getCc() {
    return cc;
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
   * getter method for file location.
   *
   * @return  String
   */
  public String getFileLocation() {
    return fileLocation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for file name.
   *
   * @return  String
   */
  public String getFileName() {
    return fileName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for friendly name.
   *
   * @return  String
   */
  public String getFriendlyName() {
    return friendlyName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for from.
   *
   * @return  String
   */
  public String getFrom() {
    return from;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for has attachment.
   *
   * @return  Boolean
   */
  public Boolean getHasAttachment() {
    return hasAttachment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for high importance.
   *
   * @return  Boolean
   */
  public Boolean getHighImportance() {
    return isHighImportance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for html body.
   *
   * @return  String
   */
  public String getHtmlBody() {
    return htmlBody;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for html email.
   *
   * @return  Boolean
   */
  public Boolean getHtmlEmail() {
    return htmlEmail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for is high importance.
   *
   * @return  Boolean
   */
  public Boolean getIsHighImportance() {
    return isHighImportance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for is mra account.
   *
   * @return  Boolean
   */
  public Boolean getIsMraAccount() {
    return isMraAccount;
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
   * getter method for password.
   *
   * @return  String
   */
  public String getPassword() {
    return password;
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
   * getter method for reply to email.
   *
   * @return  String
   */
  public String getReplyToEmail() {
    return replyToEmail;
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
   * getter method for sms callback url.
   *
   * @return  String
   */
  public String getSmsCallbackUrl() {
    return smsCallbackUrl;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for sms provider id.
   *
   * @return  Long
   */
  public Long getSmsProviderId() {
    return smsProviderId;
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
   * getter method for template name.
   *
   * @return  String
   */
  public String getTemplateName() {
    return templateName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for text body.
   *
   * @return  String
   */
  public String getTextBody() {
    return textBody;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for to.
   *
   * @return  String
   */
  public String getTo() {
    return to;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for user name.
   *
   * @return  String
   */
  public String getUserName() {
    return userName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    int result = (accountNum != null) ? accountNum.hashCode() : 0;
    result = (31 * result) + ((bcc != null) ? bcc.hashCode() : 0);
    result = (31 * result) + ((cc != null) ? cc.hashCode() : 0);
    result = (31 * result) + ((channelResultId != null) ? channelResultId.hashCode() : 0);
    result = (31 * result) + ((fileLocation != null) ? fileLocation.hashCode() : 0);
    result = (31 * result) + ((fileName != null) ? fileName.hashCode() : 0);
    result = (31 * result) + ((from != null) ? from.hashCode() : 0);
    result = (31 * result) + ((hasAttachment != null) ? hasAttachment.hashCode() : 0);
    result = (31 * result) + ((htmlBody != null) ? htmlBody.hashCode() : 0);
    result = (31 * result) + ((htmlEmail != null) ? htmlEmail.hashCode() : 0);
    result = (31 * result) + ((isHighImportance != null) ? isHighImportance.hashCode() : 0);
    result = (31 * result) + ((isMraAccount != null) ? isMraAccount.hashCode() : 0);
    result = (31 * result) + ((portfolioId != null) ? portfolioId.hashCode() : 0);
    result = (31 * result) + ((responsibleId != null) ? responsibleId.hashCode() : 0);
    result = (31 * result) + ((smsCallbackUrl != null) ? smsCallbackUrl.hashCode() : 0);
    result = (31 * result) + ((subject != null) ? subject.hashCode() : 0);
    result = (31 * result) + ((templateName != null) ? templateName.hashCode() : 0);
    result = (31 * result) + ((textBody != null) ? textBody.hashCode() : 0);
    result = (31 * result) + ((to != null) ? to.hashCode() : 0);

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
   * setter method for bcc.
   *
   * @param  bcc  String
   */
  public void setBcc(String bcc) {
    this.bcc = bcc;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for cc.
   *
   * @param  cc  String
   */
  public void setCc(String cc) {
    this.cc = cc;
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
   * setter method for file location.
   *
   * @param  fileLocation  String
   */
  public void setFileLocation(String fileLocation) {
    this.fileLocation = fileLocation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for file name.
   *
   * @param  fileName  String
   */
  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for friendly name.
   *
   * @param  friendlyName  String
   */
  public void setFriendlyName(String friendlyName) {
    this.friendlyName = friendlyName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for from.
   *
   * @param  from  String
   */
  public void setFrom(String from) {
    this.from = from;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for has attachment.
   *
   * @param  hasAttachment  Boolean
   */
  public void setHasAttachment(Boolean hasAttachment) {
    this.hasAttachment = hasAttachment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for high importance.
   *
   * @param  highImportance  Boolean
   */
  public void setHighImportance(Boolean highImportance) {
    isHighImportance = highImportance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for html body.
   *
   * @param  htmlBody  String
   */
  public void setHtmlBody(String htmlBody) {
    this.htmlBody = htmlBody;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for html email.
   *
   * @param  htmlEmail  Boolean
   */
  public void setHtmlEmail(Boolean htmlEmail) {
    this.htmlEmail = htmlEmail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for is high importance.
   *
   * @param  isHighImportance  Boolean
   */
  public void setIsHighImportance(Boolean isHighImportance) {
    this.isHighImportance = isHighImportance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for is mra account.
   *
   * @param  isMraAccount  Boolean
   */
  public void setIsMraAccount(Boolean isMraAccount) {
    this.isMraAccount = isMraAccount;
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
   * setter method for password.
   *
   * @param  password  String
   */
  public void setPassword(String password) {
    this.password = password;
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
   * setter method for reply to email.
   *
   * @param  replyToEmail  String
   */
  public void setReplyToEmail(String replyToEmail) {
    this.replyToEmail = replyToEmail;
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
   * setter method for sms callback url.
   *
   * @param  smsCallbackUrl  String
   */
  public void setSmsCallbackUrl(String smsCallbackUrl) {
    this.smsCallbackUrl = smsCallbackUrl;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for sms provider id.
   *
   * @param  smsProviderId  Long
   */
  public void setSmsProviderId(Long smsProviderId) {
    this.smsProviderId = smsProviderId;
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
   * setter method for text body.
   *
   * @param  textBody  String
   */
  public void setTextBody(String textBody) {
    this.textBody = textBody;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for to.
   *
   * @param  to  String
   */
  public void setTo(String to) {
    this.to = to;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for user name.
   *
   * @param  userName  String
   */
  public void setUserName(String userName) {
    this.userName = userName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#toString()
   */
  @Override public String toString() {
    return "ChannelExportRequest{"
      + "accountNum='" + accountNum + '\''
      + ", bcc='" + bcc + '\''
      + ", cc='" + cc + '\''
      + ", channelResultId='" + channelResultId + '\''
      + ", fileLocation='" + fileLocation + '\''
      + ", fileName='" + fileName + '\''
      + ", from='" + from + '\''
      + ", hasAttachment=" + hasAttachment
      + ", htmlBody='" + htmlBody + '\''
      + ", htmlEmail=" + htmlEmail
      + ", isHighImportance=" + isHighImportance
      + ", isMraAccount=" + isMraAccount
      + ", portfolioId='" + portfolioId + '\''
      + ", responsibleId='" + responsibleId + '\''
      + ", smsCallbackUrl='" + smsCallbackUrl + '\''
      + ", subject='" + subject + '\''
      + ", templateName='" + templateName + '\''
      + ", textBody='" + textBody + '\''
      + ", to='" + to + '\''
      + '}';
  }

} // end class ChannelExportRequest
