package com.cmc.credagility.core.domain.channel;

import com.cmc.credagility.core.domain.contact.BaseContactAudit;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/15/2014 11:32
 */
@Entity
@Table(name = "EmailOutboundAudit")
public class EmailOutboundAudit extends BaseContactAudit {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 3588660436357491198L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Import batch job Id. */
  @Column(name = "batchId")
  protected Long batchId;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "bounceStatusCode",
    length = 20
  )
  protected String bounceStatusCode;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "bounceType",
    length = 20
  )
  protected String bounceType;


  /** browser. */
  @Column(
    name   = "browser",
    length = 50
  )
  protected String browser;


  /** browser Os. */
  @Column(
    name   = "browserOs",
    length = 50
  )
  protected String browserOs;


  /** category. */
  @Column(
    name   = "category",
    length = 120
  )
  protected String category;


  /** click url. */
  @Column(
    name   = "clickUrl",
    length = 250
  )
  protected String ClickUrl;


  /** TODO: DOCUMENT ME! */
  @Column(name = "deliveryAttempt")
  protected Integer deliveryAttempt;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "emailActualResultId",
    updatable = false
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  protected EmailChannelActualResult emailChannelActualResult;


  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long emailOutboundAuditId;


  /** TODO: DOCUMENT ME! */
  @Column(name = "eventTimestamp")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date eventTimestamp;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "ipAddress",
    length = 50
  )
  protected String ipAddress;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "mtaEventReason",
    length = 250
  )
  protected String mtaEventReason;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "mtaEventResponse",
    length = 150
  )
  protected String mtaEventResponse;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "recepientEmail",
    length = 120
  )
  protected String recepientEmail;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "smtpId",
    length = 250
  )
  protected String smtpId;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "userAgent",
    length = 250
  )
  protected String userAgent;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "vendorResultCodeId")
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  protected VendorChannelResultCode vendorChannelResultCode;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "vendorResultCode",
    length = 20
  )
  protected String vendorResultCode;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.contact.BaseContactAudit#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof EmailOutboundAudit)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    EmailOutboundAudit that = (EmailOutboundAudit) o;

    if ((ClickUrl != null) ? (!ClickUrl.equals(that.ClickUrl)) : (that.ClickUrl != null)) {
      return false;
    }

    if ((batchId != null) ? (!batchId.equals(that.batchId)) : (that.batchId != null)) {
      return false;
    }

    if ((bounceStatusCode != null) ? (!bounceStatusCode.equals(that.bounceStatusCode))
                                   : (that.bounceStatusCode != null)) {
      return false;
    }

    if ((bounceType != null) ? (!bounceType.equals(that.bounceType)) : (that.bounceType != null)) {
      return false;
    }

    if ((category != null) ? (!category.equals(that.category)) : (that.category != null)) {
      return false;
    }

    if ((deliveryAttempt != null) ? (!deliveryAttempt.equals(that.deliveryAttempt)) : (that.deliveryAttempt != null)) {
      return false;
    }

    if ((emailChannelActualResult != null) ? (!emailChannelActualResult.equals(that.emailChannelActualResult))
                                           : (that.emailChannelActualResult != null)) {
      return false;
    }

    if ((emailOutboundAuditId != null) ? (!emailOutboundAuditId.equals(that.emailOutboundAuditId))
                                       : (that.emailOutboundAuditId != null)) {
      return false;
    }

    if ((mtaEventReason != null) ? (!mtaEventReason.equals(that.mtaEventReason)) : (that.mtaEventReason != null)) {
      return false;
    }

    if ((mtaEventResponse != null) ? (!mtaEventResponse.equals(that.mtaEventResponse))
                                   : (that.mtaEventResponse != null)) {
      return false;
    }

    if ((recepientEmail != null) ? (!recepientEmail.equals(that.recepientEmail)) : (that.recepientEmail != null)) {
      return false;
    }

    if ((vendorChannelResultCode != null) ? (!vendorChannelResultCode.equals(that.vendorChannelResultCode))
                                          : (that.vendorChannelResultCode != null)) {
      return false;
    }

    if ((vendorResultCode != null) ? (!vendorResultCode.equals(that.vendorResultCode))
                                   : (that.vendorResultCode != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for batch id.
   *
   * @return  Long
   */
  public Long getBatchId() {
    return batchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bounce status code.
   *
   * @return  String
   */
  public String getBounceStatusCode() {
    return bounceStatusCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bounce type.
   *
   * @return  String
   */
  public String getBounceType() {
    return bounceType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for browser.
   *
   * @return  String
   */
  public String getBrowser() {
    return browser;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for browser os.
   *
   * @return  String
   */
  public String getBrowserOs() {
    return browserOs;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for category.
   *
   * @return  String
   */
  public String getCategory() {
    return category;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for click url.
   *
   * @return  String
   */
  public String getClickUrl() {
    return ClickUrl;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for delivery attempt.
   *
   * @return  Integer
   */
  public Integer getDeliveryAttempt() {
    return deliveryAttempt;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for email channel actual result.
   *
   * @return  EmailChannelActualResult
   */
  public EmailChannelActualResult getEmailChannelActualResult() {
    return emailChannelActualResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for email outbound audit id.
   *
   * @return  Long
   */
  public Long getEmailOutboundAuditId() {
    return emailOutboundAuditId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for event timestamp.
   *
   * @return  Date
   */
  public Date getEventTimestamp() {
    return eventTimestamp;
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
   * getter method for mta event reason.
   *
   * @return  String
   */
  public String getMtaEventReason() {
    return mtaEventReason;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for mta event response.
   *
   * @return  String
   */
  public String getMtaEventResponse() {
    return mtaEventResponse;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for recepient email.
   *
   * @return  String
   */
  public String getRecepientEmail() {
    return recepientEmail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for smtp id.
   *
   * @return  String
   */
  public String getSmtpId() {
    return smtpId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for user agent.
   *
   * @return  String
   */
  public String getUserAgent() {
    return userAgent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for vendor channel result code.
   *
   * @return  VendorChannelResultCode
   */
  public VendorChannelResultCode getVendorChannelResultCode() {
    return vendorChannelResultCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for vendor result code.
   *
   * @return  String
   */
  public String getVendorResultCode() {
    return vendorResultCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.contact.BaseContactAudit#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((batchId != null) ? batchId.hashCode() : 0);
    result = (31 * result) + ((category != null) ? category.hashCode() : 0);
    result = (31 * result) + ((ClickUrl != null) ? ClickUrl.hashCode() : 0);
    result = (31 * result) + ((deliveryAttempt != null) ? deliveryAttempt.hashCode() : 0);
    result = (31 * result) + ((emailChannelActualResult != null) ? emailChannelActualResult.hashCode() : 0);
    result = (31 * result) + ((emailOutboundAuditId != null) ? emailOutboundAuditId.hashCode() : 0);
    result = (31 * result) + ((mtaEventReason != null) ? mtaEventReason.hashCode() : 0);
    result = (31 * result) + ((mtaEventResponse != null) ? mtaEventResponse.hashCode() : 0);
    result = (31 * result) + ((bounceStatusCode != null) ? bounceStatusCode.hashCode() : 0);
    result = (31 * result) + ((bounceType != null) ? bounceType.hashCode() : 0);
    result = (31 * result) + ((recepientEmail != null) ? recepientEmail.hashCode() : 0);
    result = (31 * result) + ((vendorChannelResultCode != null) ? vendorChannelResultCode.hashCode() : 0);
    result = (31 * result) + ((vendorResultCode != null) ? vendorResultCode.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for batch id.
   *
   * @param  batchId  Long
   */
  public void setBatchId(Long batchId) {
    this.batchId = batchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bounce status code.
   *
   * @param  bounceStatusCode  String
   */
  public void setBounceStatusCode(String bounceStatusCode) {
    this.bounceStatusCode = bounceStatusCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bounce type.
   *
   * @param  bounceType  String
   */
  public void setBounceType(String bounceType) {
    this.bounceType = bounceType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for browser.
   *
   * @param  browser  String
   */
  public void setBrowser(String browser) {
    this.browser = browser;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for browser os.
   *
   * @param  browserOs  String
   */
  public void setBrowserOs(String browserOs) {
    this.browserOs = browserOs;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for category.
   *
   * @param  category  String
   */
  public void setCategory(String category) {
    this.category = category;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for click url.
   *
   * @param  clickUrl  String
   */
  public void setClickUrl(String clickUrl) {
    ClickUrl = clickUrl;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for delivery attempt.
   *
   * @param  deliveryAttempt  Integer
   */
  public void setDeliveryAttempt(Integer deliveryAttempt) {
    this.deliveryAttempt = deliveryAttempt;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for email channel actual result.
   *
   * @param  emailChannelActualResult  EmailChannelActualResult
   */
  public void setEmailChannelActualResult(EmailChannelActualResult emailChannelActualResult) {
    this.emailChannelActualResult = emailChannelActualResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for email outbound audit id.
   *
   * @param  emailOutboundAuditId  Long
   */
  public void setEmailOutboundAuditId(Long emailOutboundAuditId) {
    this.emailOutboundAuditId = emailOutboundAuditId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for event timestamp.
   *
   * @param  eventTimestamp  Date
   */
  public void setEventTimestamp(Date eventTimestamp) {
    this.eventTimestamp = eventTimestamp;
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
   * setter method for mta event reason.
   *
   * @param  mtaEventReason  String
   */
  public void setMtaEventReason(String mtaEventReason) {
    this.mtaEventReason = mtaEventReason;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for mta event response.
   *
   * @param  mtaEventResponse  String
   */
  public void setMtaEventResponse(String mtaEventResponse) {
    this.mtaEventResponse = mtaEventResponse;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for recepient email.
   *
   * @param  recepientEmail  String
   */
  public void setRecepientEmail(String recepientEmail) {
    this.recepientEmail = recepientEmail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for smtp id.
   *
   * @param  smtpId  String
   */
  public void setSmtpId(String smtpId) {
    this.smtpId = smtpId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for user agent.
   *
   * @param  userAgent  String
   */
  public void setUserAgent(String userAgent) {
    this.userAgent = userAgent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for vendor channel result code.
   *
   * @param  vendorChannelResultCode  VendorChannelResultCode
   */
  public void setVendorChannelResultCode(VendorChannelResultCode vendorChannelResultCode) {
    this.vendorChannelResultCode = vendorChannelResultCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for vendor result code.
   *
   * @param  vendorResultCode  String
   */
  public void setVendorResultCode(String vendorResultCode) {
    this.vendorResultCode = vendorResultCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.contact.BaseContactAudit#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("EmailOutboundAudit");
    sb.append("{batchId=").append(batchId);
    sb.append(", category='").append(category).append('\'');
    sb.append(", ClickUrl='").append(ClickUrl).append('\'');
    sb.append(", deliveryAttempt=").append(deliveryAttempt);
    sb.append(", emailChannelActualResult=").append(emailChannelActualResult);
    sb.append(", emailOutboundAuditId=").append(emailOutboundAuditId);
    sb.append(", mtaEventReason='").append(mtaEventReason).append('\'');
    sb.append(", mtaEventResponse='").append(mtaEventResponse).append('\'');
    sb.append(", bounceStatusCode='").append(bounceStatusCode).append('\'');
    sb.append(", bounceType='").append(bounceType).append('\'');
    sb.append(", recepientEmail='").append(recepientEmail).append('\'');
    sb.append(", vendorChannelResultCode=").append(vendorChannelResultCode);
    sb.append(", vendorResultCode='").append(vendorResultCode).append('\'');
    sb.append('}');

    return sb.toString();
  }
} // end class EmailOutboundAudit
