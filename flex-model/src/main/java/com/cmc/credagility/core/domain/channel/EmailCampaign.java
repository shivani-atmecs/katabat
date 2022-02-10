/*
 * Copyright (c) Katabat
 */

package com.cmc.credagility.core.domain.channel;

import java.io.Serializable;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.cmc.credagility.core.domain.type.CampaignStatus;
import com.cmc.credagility.core.domain.type.ChannelSource;


/**
 * EmailCampaign.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/15/2014 13:09
 */
@Entity
@Table(
  name              = "EmailCampaign",
  uniqueConstraints = { @UniqueConstraint(columnNames = "campaignName") },
  indexes           = {
    @Index(
      name          = "campaignNameIndex",
      columnList    = "campaignName"
    ),
    @Index(
      name          = "strategyDateIndex",
      columnList    = "strategyDate"
    )
  }
)
public class EmailCampaign extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -1592356925174336803L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(name = "actual")
  protected Integer actual;


  /** TODO: DOCUMENT ME! */
  @Column(name = "bounced")
  protected Integer bounced;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "campaignName",
    nullable = false,
    length   = 255
  )
  protected String campaignName;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "campaignStatus",
    nullable = false,
    length   = 20
  )
  @Enumerated(EnumType.STRING)
  protected CampaignStatus campaignStatus;


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "emailCampaign",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  protected Set<EmailChannelActualResult> channelActualResults = new LinkedHashSet<EmailChannelActualResult>();


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "emailCampaign",
    orphanRemoval = true,
    cascade       = CascadeType.ALL
  )
  protected Set<EmailChannelResult> channelResults = new LinkedHashSet<EmailChannelResult>();


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "channelSource",
    nullable  = false,
    updatable = false,
    length    = 20
  )
  @Enumerated(EnumType.STRING)
  protected ChannelSource channelSource;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clicked")
  protected Integer clicked;


  /** TODO: DOCUMENT ME! */
  @Column(name = "delivered")
  protected Integer delivered;

  /** TODO: DOCUMENT ME! */
  @Temporal(TemporalType.TIMESTAMP)
  protected Date deliveryFinishTime;

  /** DOCUMENT ME! */
  @Temporal(TemporalType.TIMESTAMP)
  protected Date deliveryPauseTime;

  /** DOCUMENT ME! */
  @Temporal(TemporalType.TIMESTAMP)
  protected Date deliveryResumeTime;

  /** DOCUMENT ME! */
  @Temporal(TemporalType.TIMESTAMP)
  protected Date deliveryStartTime;


  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long emailCampaignId;


  /** TODO: DOCUMENT ME! */
  @Column(name = "exported")
  protected Integer exported;


  /** TODO: DOCUMENT ME! */
  @Column(name = "exportFailed")
  protected Integer exportFailed;


  /** TODO: DOCUMENT ME! */
  @Column(name = "mailsPerHour")
  protected Integer mailsPerHour = 1800;


  /** TODO: DOCUMENT ME! */
  @Column(name = "opened")
  protected Integer opened;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "portfolioId",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Portfolio portfolio;


  /** TODO: DOCUMENT ME! */
  @Column(name = "sendFailed")
  protected Integer sendFailed;


  /** TODO: DOCUMENT ME! */
  @Column(name = "sent")
  protected Integer sent;


  /** TODO: DOCUMENT ME! */
  @Column(name = "skipped")
  protected Integer skipped;


  /** TODO: DOCUMENT ME! */
  @Column(name = "spamreported")
  protected Integer spamreported;


  /** TODO: DOCUMENT ME! */
  @Column(name = "strategized")
  protected Integer strategized;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "strategyDate",
    nullable = false
  )
  @Temporal(TemporalType.TIMESTAMP)
  protected Date strategyDate;


  /** TODO: DOCUMENT ME! */
  @Column(name = "unsubscribed")
  protected Integer unsubscribed;
  @Temporal(TemporalType.TIMESTAMP)
  private Date      lastNoRecordTime;

  @Temporal(TemporalType.TIMESTAMP)
  private Date speedChangeTime;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof EmailCampaign)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    EmailCampaign that = (EmailCampaign) o;

    if ((actual != null) ? (!actual.equals(that.actual)) : (that.actual != null)) {
      return false;
    }

    if ((bounced != null) ? (!bounced.equals(that.bounced)) : (that.bounced != null)) {
      return false;
    }

    if (!campaignName.equals(that.campaignName)) {
      return false;
    }

    if (campaignStatus != that.campaignStatus) {
      return false;
    }

    if ((channelActualResults != null) ? (!channelActualResults.equals(that.channelActualResults))
                                       : (that.channelActualResults != null)) {
      return false;
    }

    if ((channelResults != null) ? (!channelResults.equals(that.channelResults)) : (that.channelResults != null)) {
      return false;
    }

    if (channelSource != that.channelSource) {
      return false;
    }

    if ((clicked != null) ? (!clicked.equals(that.clicked)) : (that.clicked != null)) {
      return false;
    }

    if ((delivered != null) ? (!delivered.equals(that.delivered)) : (that.delivered != null)) {
      return false;
    }

    if ((emailCampaignId != null) ? (!emailCampaignId.equals(that.emailCampaignId)) : (that.emailCampaignId != null)) {
      return false;
    }

    if ((exported != null) ? (!exported.equals(that.exported)) : (that.exported != null)) {
      return false;
    }

    if ((exportFailed != null) ? (!exportFailed.equals(that.exportFailed)) : (that.exportFailed != null)) {
      return false;
    }

    if ((sendFailed != null) ? (!sendFailed.equals(that.sendFailed)) : (that.sendFailed != null)) {
      return false;
    }

    if ((mailsPerHour != null) ? (!mailsPerHour.equals(that.mailsPerHour)) : (that.mailsPerHour != null)) {
      return false;
    }

    if ((opened != null) ? (!opened.equals(that.opened)) : (that.opened != null)) {
      return false;
    }

    if ((skipped != null) ? (!skipped.equals(that.skipped)) : (that.skipped != null)) {
      return false;
    }

    if ((sent != null) ? (!sent.equals(that.sent)) : (that.sent != null)) {
      return false;
    }

    if ((strategized != null) ? (!strategized.equals(that.strategized)) : (that.strategized != null)) {
      return false;
    }

    if ((strategyDate != null) ? (!strategyDate.equals(that.strategyDate)) : (that.strategyDate != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for actual.
   *
   * @return  Integer
   */
  public Integer getActual() {
    return actual;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bounced.
   *
   * @return  Integer
   */
  public Integer getBounced() {
    return bounced;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for campaign name.
   *
   * @return  String
   */
  public String getCampaignName() {
    return campaignName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for campaign status.
   *
   * @return  CampaignStatus
   */
  public CampaignStatus getCampaignStatus() {
    return campaignStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for channel actual results.
   *
   * @return  Set
   */
  public Set<EmailChannelActualResult> getChannelActualResults() {
    return channelActualResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for channel results.
   *
   * @return  Set
   */
  public Set<EmailChannelResult> getChannelResults() {
    return channelResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for channel source.
   *
   * @return  ChannelSource
   */
  public ChannelSource getChannelSource() {
    return channelSource;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for clicked.
   *
   * @return  Integer
   */
  public Integer getClicked() {
    return clicked;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for delivered.
   *
   * @return  Integer
   */
  public Integer getDelivered() {
    return delivered;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for delivery finish time.
   *
   * @return  Date
   */
  public Date getDeliveryFinishTime() {
    return deliveryFinishTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for delivery pause time.
   *
   * @return  Date
   */
  public Date getDeliveryPauseTime() {
    return deliveryPauseTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for delivery resume time.
   *
   * @return  Date
   */
  public Date getDeliveryResumeTime() {
    return deliveryResumeTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for delivery start time.
   *
   * @return  Date
   */
  public Date getDeliveryStartTime() {
    return deliveryStartTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for email campaign id.
   *
   * @return  Long
   */
  public Long getEmailCampaignId() {
    return emailCampaignId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for exported.
   *
   * @return  Integer
   */
  public Integer getExported() {
    return exported;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for export failed.
   *
   * @return  Integer
   */
  public Integer getExportFailed() {
    return exportFailed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last no record time.
   *
   * @return  Date
   */
  public Date getLastNoRecordTime() {
    return lastNoRecordTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for mails per hour.
   *
   * @return  Integer
   */
  public Integer getMailsPerHour() {
    return mailsPerHour;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for opened.
   *
   * @return  Integer
   */
  public Integer getOpened() {
    return opened;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio.
   *
   * @return  Portfolio
   */
  public Portfolio getPortfolio() {
    return portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for send failed.
   *
   * @return  Integer
   */
  public Integer getSendFailed() {
    return sendFailed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for sent.
   *
   * @return  Integer
   */
  public Integer getSent() {
    return sent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for skipped.
   *
   * @return  Integer
   */
  public Integer getSkipped() {
    return skipped;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for spamreported.
   *
   * @return  Integer
   */
  public Integer getSpamreported() {
    return spamreported;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for speed change time.
   *
   * @return  Date
   */
  public Date getSpeedChangeTime() {
    return speedChangeTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for strategized.
   *
   * @return  Integer
   */
  public Integer getStrategized() {
    return strategized;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for strategy date.
   *
   * @return  Date
   */
  public Date getStrategyDate() {
    return strategyDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for unsubscribed.
   *
   * @return  Integer
   */
  public Integer getUnsubscribed() {
    return unsubscribed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((actual != null) ? actual.hashCode() : 0);
    result = (31 * result) + ((bounced != null) ? bounced.hashCode() : 0);
    result = (31 * result) + campaignName.hashCode();
    result = (31 * result) + ((campaignStatus != null) ? campaignStatus.hashCode() : 0);
    result = (31 * result) + ((channelActualResults != null) ? channelActualResults.hashCode() : 0);
    result = (31 * result) + ((channelResults != null) ? channelResults.hashCode() : 0);
    result = (31 * result) + ((channelSource != null) ? channelSource.hashCode() : 0);
    result = (31 * result) + ((clicked != null) ? clicked.hashCode() : 0);
    result = (31 * result) + ((delivered != null) ? delivered.hashCode() : 0);
    result = (31 * result) + ((emailCampaignId != null) ? emailCampaignId.hashCode() : 0);
    result = (31 * result) + ((exported != null) ? exported.hashCode() : 0);
    result = (31 * result) + ((exportFailed != null) ? exportFailed.hashCode() : 0);
    result = (31 * result) + ((sendFailed != null) ? sendFailed.hashCode() : 0);
    result = (31 * result) + ((mailsPerHour != null) ? mailsPerHour.hashCode() : 0);
    result = (31 * result) + ((opened != null) ? opened.hashCode() : 0);
    result = (31 * result) + ((skipped != null) ? skipped.hashCode() : 0);
    result = (31 * result) + ((sent != null) ? sent.hashCode() : 0);
    result = (31 * result) + ((strategized != null) ? strategized.hashCode() : 0);
    result = (31 * result) + ((strategyDate != null) ? strategyDate.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for actual.
   *
   * @param  actual  Integer
   */
  public void setActual(Integer actual) {
    this.actual = actual;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bounced.
   *
   * @param  bounced  Integer
   */
  public void setBounced(Integer bounced) {
    this.bounced = bounced;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for campaign name.
   *
   * @param  campaignName  String
   */
  public void setCampaignName(String campaignName) {
    this.campaignName = campaignName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for campaign status.
   *
   * @param  campaignStatus  CampaignStatus
   */
  public void setCampaignStatus(CampaignStatus campaignStatus) {
    this.campaignStatus = campaignStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for channel actual results.
   *
   * @param  channelActualResults  Set
   */
  public void setChannelActualResults(Set<EmailChannelActualResult> channelActualResults) {
    this.channelActualResults = channelActualResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  channelResults  DOCUMENT ME!
   */
  public void setChannelResults(Set<EmailChannelResult> channelResults) {
    this.channelResults = channelResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for channel source.
   *
   * @param  channelSource  ChannelSource
   */
  public void setChannelSource(ChannelSource channelSource) {
    this.channelSource = channelSource;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for clicked.
   *
   * @param  clicked  Integer
   */
  public void setClicked(Integer clicked) {
    this.clicked = clicked;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for delivered.
   *
   * @param  delivered  Integer
   */
  public void setDelivered(Integer delivered) {
    this.delivered = delivered;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for delivery finish time.
   *
   * @param  deliveryFinishTime  Date
   */
  public void setDeliveryFinishTime(Date deliveryFinishTime) {
    this.deliveryFinishTime = deliveryFinishTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for delivery pause time.
   *
   * @param  deliveryPauseTime  Date
   */
  public void setDeliveryPauseTime(Date deliveryPauseTime) {
    this.deliveryPauseTime = deliveryPauseTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for delivery resume time.
   *
   * @param  deliveryResumeTime  Date
   */
  public void setDeliveryResumeTime(Date deliveryResumeTime) {
    this.deliveryResumeTime = deliveryResumeTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for delivery start time.
   *
   * @param  deliveryStartTime  Date
   */
  public void setDeliveryStartTime(Date deliveryStartTime) {
    this.deliveryStartTime = deliveryStartTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for email campaign id.
   *
   * @param  emailCampaignId  Long
   */
  public void setEmailCampaignId(Long emailCampaignId) {
    this.emailCampaignId = emailCampaignId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for exported.
   *
   * @param  exported  Integer
   */
  public void setExported(Integer exported) {
    this.exported = exported;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  exportFailed  DOCUMENT ME!
   */
  public void setExportFailed(Integer exportFailed) {
    this.exportFailed = exportFailed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last no record time.
   *
   * @param  lastNoRecordTime  Date
   */
  public void setLastNoRecordTime(Date lastNoRecordTime) {
    this.lastNoRecordTime = lastNoRecordTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for mails per hour.
   *
   * @param  mailsPerHour  Integer
   */
  public void setMailsPerHour(Integer mailsPerHour) {
    this.mailsPerHour = mailsPerHour;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for opened.
   *
   * @param  opened  Integer
   */
  public void setOpened(Integer opened) {
    this.opened = opened;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio.
   *
   * @param  portfolio  Portfolio
   */
  public void setPortfolio(Portfolio portfolio) {
    this.portfolio = portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for send failed.
   *
   * @param  sendFailed  Integer
   */
  public void setSendFailed(Integer sendFailed) {
    this.sendFailed = sendFailed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for sent.
   *
   * @param  sent  Integer
   */
  public void setSent(Integer sent) {
    this.sent = sent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for skipped.
   *
   * @param  skipped  Integer
   */
  public void setSkipped(Integer skipped) {
    this.skipped = skipped;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for spamreported.
   *
   * @param  spamreported  Integer
   */
  public void setSpamreported(Integer spamreported) {
    this.spamreported = spamreported;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for speed change time.
   *
   * @param  speedChangeTime  Date
   */
  public void setSpeedChangeTime(Date speedChangeTime) {
    this.speedChangeTime = speedChangeTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for strategized.
   *
   * @param  strategized  Integer
   */
  public void setStrategized(Integer strategized) {
    this.strategized = strategized;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for strategy date.
   *
   * @param  strategyDate  Date
   */
  public void setStrategyDate(Date strategyDate) {
    this.strategyDate = strategyDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for unsubscribed.
   *
   * @param  unsubscribed  Integer
   */
  public void setUnsubscribed(Integer unsubscribed) {
    this.unsubscribed = unsubscribed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * toStatusString.
   *
   * @return  String
   */
  public String toStatusString() {
    final StringBuilder sb = new StringBuilder();
    sb.append(strategized);
    sb.append(exported);
    sb.append(exportFailed);
    sb.append(actual);
    sb.append(sent);
    sb.append(sendFailed);
    sb.append(opened);
    sb.append(skipped);
    sb.append(clicked);
    sb.append(delivered);
    sb.append(bounced);
    sb.append(unsubscribed);
    sb.append(spamreported);
    sb.append(campaignStatus);

    return sb.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("EmailCampaign");
    sb.append("{actual=").append(actual);
    sb.append(", bounced=").append(bounced);
    sb.append(", campaignName='").append(campaignName).append('\'');
    sb.append(", campaignStatus=").append(campaignStatus);
    sb.append(", channelSource=").append(channelSource);
    sb.append(", clicked=").append(clicked);
    sb.append(", delivered=").append(delivered);
    sb.append(", emailCampaignId=").append(emailCampaignId);
    sb.append(", exported=").append(exported);
    sb.append(", exportFailed=").append(exportFailed);
    sb.append(", mailsPerHour=").append(mailsPerHour);
    sb.append(", opened=").append(opened);
    sb.append(", skipped=").append(skipped);
    sb.append(", sendFailed=").append(sendFailed);
    sb.append(", sent=").append(sent);
    sb.append(", strategized=").append(strategized);
    sb.append(", unsuscribed=").append(unsubscribed);
    sb.append(", spamreported=").append(spamreported);
    sb.append(", strategyDate=").append(strategyDate);
    sb.append('}');

    return sb.toString();
  } // end method toString
} // end class EmailCampaign
