
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
 * SmsCampaign.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/15/2014 09:52
 */
@Entity
@Table(
  name              = "SmsCampaign",
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
public class SmsCampaign extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -5546597807628130723L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(name = "actual")
  protected Integer actual;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "campaignName",
    nullable = false,
    length   = 120
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
    mappedBy      = "smsCampaign",
    orphanRemoval = true,
    cascade       = CascadeType.ALL
  )
  protected Set<SmsChannelActualResult> channelActualResults = new LinkedHashSet<SmsChannelActualResult>();


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "smsCampaign",
    orphanRemoval = true,
    cascade       = CascadeType.ALL
  )
  protected Set<SmsChannelResult> channelResults = new LinkedHashSet<SmsChannelResult>();


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "channelSource",
    nullable  = false,
    updatable = false,
    length    = 20
  )
  @Enumerated(EnumType.STRING)
  protected ChannelSource channelSource;

  /** message is delivered to the customer. */
  @Column(name = "delivered")
  protected Integer delivered;

  /** TODO: DOCUMENT ME! */
  @Temporal(TemporalType.TIMESTAMP)
  protected Date    deliveryFinishTime;

  /** DOCUMENT ME! */
  @Temporal(TemporalType.TIMESTAMP)
  protected Date deliveryPauseTime;

  /** DOCUMENT ME! */
  @Temporal(TemporalType.TIMESTAMP)
  protected Date deliveryResumeTime;

  /** DOCUMENT ME! */
  @Temporal(TemporalType.TIMESTAMP)
  protected Date deliveryStartTime;

  /** from export job to mq. */
  @Column(name = "exported")
  protected Integer exported;

  /** failed to export to mq. */
  @Column(name = "exportFailed")
  protected Integer exportFailed;

  /** twiulio failed to send it to customer. */
  @Column(name = "failed")
  protected Integer failed;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "portfolioId",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Portfolio portfolio;

  /** mq failed to send it to twilio. */
  @Column(name = "sendFailed")
  protected Integer sendFailed;

  /** twilio is sending to the customer. */
  @Column(name = "sending")
  protected Integer sending;

  /** from mq to twilio. */
  @Column(name = "sent")
  protected Integer sent;


  /** TODO: DOCUMENT ME! */
  @Column(name = "skipped")
  protected Integer skipped;


  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long smsCampaignId;


  /** TODO: DOCUMENT ME! */
  @Column(name = "smsPerHour")
  protected Integer smsPerHour = 3600;


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

  /** custiomer unsubscrived the sms. */
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

    if (!(o instanceof SmsCampaign)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    SmsCampaign that = (SmsCampaign) o;

    if ((actual != null) ? (!actual.equals(that.actual)) : (that.actual != null)) {
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


    if ((delivered != null) ? (!delivered.equals(that.delivered)) : (that.delivered != null)) {
      return false;
    }

    if ((smsCampaignId != null) ? (!smsCampaignId.equals(that.smsCampaignId)) : (that.smsCampaignId != null)) {
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

    if ((smsPerHour != null) ? (!smsPerHour.equals(that.smsPerHour)) : (that.smsPerHour != null)) {
      return false;
    }

    if ((failed != null) ? (!failed.equals(that.failed)) : (that.failed != null)) {
      return false;
    }

    if ((sending != null) ? (!sending.equals(that.sending)) : (that.sending != null)) {
      return false;
    }


    if ((smsPerHour != null) ? (!smsPerHour.equals(that.smsPerHour)) : (that.smsPerHour != null)) {
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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getActual() {
    return actual;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getCampaignName() {
    return campaignName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public CampaignStatus getCampaignStatus() {
    return campaignStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<SmsChannelActualResult> getChannelActualResults() {
    return channelActualResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<SmsChannelResult> getChannelResults() {
    return channelResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public ChannelSource getChannelSource() {
    return channelSource;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getExported() {
    return exported;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getExportFailed() {
    return exportFailed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getFailed() {
    return failed;
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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Portfolio getPortfolio() {
    return portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getSendFailed() {
    return sendFailed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getSending() {
    return sending;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getSent() {
    return sent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getSkipped() {
    return skipped;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getSmsCampaignId() {
    return smsCampaignId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getSmsPerHour() {
    return smsPerHour;
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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getStrategized() {
    return strategized;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getStrategyDate() {
    return strategyDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getUnsubscribed() {
    return unsubscribed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((actual != null) ? actual.hashCode() : 0);
    result = (31 * result) + campaignName.hashCode();
    result = (31 * result) + ((campaignStatus != null) ? campaignStatus.hashCode() : 0);
    result = (31 * result) + ((channelActualResults != null) ? channelActualResults.hashCode() : 0);
    result = (31 * result) + ((channelResults != null) ? channelResults.hashCode() : 0);
    result = (31 * result) + ((channelSource != null) ? channelSource.hashCode() : 0);
    result = (31 * result) + ((delivered != null) ? delivered.hashCode() : 0);
    result = (31 * result) + ((smsCampaignId != null) ? smsCampaignId.hashCode() : 0);
    result = (31 * result) + ((exported != null) ? exported.hashCode() : 0);
    result = (31 * result) + ((exportFailed != null) ? exportFailed.hashCode() : 0);
    result = (31 * result) + ((sendFailed != null) ? sendFailed.hashCode() : 0);
    result = (31 * result) + ((smsPerHour != null) ? smsPerHour.hashCode() : 0);
    result = (31 * result) + ((sent != null) ? sent.hashCode() : 0);
    result = (31 * result) + ((skipped != null) ? skipped.hashCode() : 0);
    result = (31 * result) + ((strategized != null) ? strategized.hashCode() : 0);
    result = (31 * result) + ((strategyDate != null) ? strategyDate.hashCode() : 0);
    result = (31 * result) + ((failed != null) ? failed.hashCode() : 0);
    result = (31 * result) + ((sending != null) ? sending.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  actual  DOCUMENT ME!
   */
  public void setActual(Integer actual) {
    this.actual = actual;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  campaignName  DOCUMENT ME!
   */
  public void setCampaignName(String campaignName) {
    this.campaignName = campaignName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  campaignStatus  DOCUMENT ME!
   */
  public void setCampaignStatus(CampaignStatus campaignStatus) {
    this.campaignStatus = campaignStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  channelActualResults  DOCUMENT ME!
   */
  public void setChannelActualResults(Set<SmsChannelActualResult> channelActualResults) {
    this.channelActualResults = channelActualResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  channelResults  DOCUMENT ME!
   */
  public void setChannelResults(Set<SmsChannelResult> channelResults) {
    this.channelResults = channelResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  channelSource  DOCUMENT ME!
   */
  public void setChannelSource(ChannelSource channelSource) {
    this.channelSource = channelSource;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  delivered  DOCUMENT ME!
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
   * DOCUMENT ME!
   *
   * @param  exported  DOCUMENT ME!
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
   * DOCUMENT ME!
   *
   * @param  failed  DOCUMENT ME!
   */
  public void setFailed(Integer failed) {
    this.failed = failed;
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
   * DOCUMENT ME!
   *
   * @param  portfolio  DOCUMENT ME!
   */
  public void setPortfolio(Portfolio portfolio) {
    this.portfolio = portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  sendFailed  DOCUMENT ME!
   */
  public void setSendFailed(Integer sendFailed) {
    this.sendFailed = sendFailed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  sending  DOCUMENT ME!
   */
  public void setSending(Integer sending) {
    this.sending = sending;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  sent  DOCUMENT ME!
   */
  public void setSent(Integer sent) {
    this.sent = sent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  skipped  DOCUMENT ME!
   */
  public void setSkipped(Integer skipped) {
    this.skipped = skipped;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  smsCampaignId  DOCUMENT ME!
   */
  public void setSmsCampaignId(Long smsCampaignId) {
    this.smsCampaignId = smsCampaignId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  smsPerHour  DOCUMENT ME!
   */
  public void setSmsPerHour(Integer smsPerHour) {
    this.smsPerHour = smsPerHour;
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
   * DOCUMENT ME!
   *
   * @param  strategized  DOCUMENT ME!
   */
  public void setStrategized(Integer strategized) {
    this.strategized = strategized;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  strategyDate  DOCUMENT ME!
   */
  public void setStrategyDate(Date strategyDate) {
    this.strategyDate = strategyDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  unsubscribed  DOCUMENT ME!
   */
  public void setUnsubscribed(Integer unsubscribed) {
    this.unsubscribed = unsubscribed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String toStatusString() {
    final StringBuilder sb = new StringBuilder();
    sb.append(strategized);
    sb.append(exported);
    sb.append(exportFailed);
    sb.append(actual);
    sb.append(sent);
    sb.append(skipped);
    sb.append(sendFailed);
    sb.append(delivered);
    sb.append(unsubscribed);
    sb.append(campaignStatus);
    sb.append(failed);
    sb.append(sending);

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
    sb.append(", campaignName='").append(campaignName).append('\'');
    sb.append(", campaignStatus=").append(campaignStatus);
    sb.append(", channelSource=").append(channelSource);
    sb.append(", delivered=").append(delivered);
    sb.append(", smsCampaignId=").append(smsCampaignId);
    sb.append(", exported=").append(exported);
    sb.append(", exportFailed=").append(exportFailed);
    sb.append(", smsPerHout=").append(smsPerHour);
    sb.append(", sendFailed=").append(sendFailed);
    sb.append(", sent=").append(sent);
    sb.append(", skipped=").append(skipped);
    sb.append(", strategized=").append(strategized);
    sb.append(", unsuscribed=").append(unsubscribed);
    sb.append(", strategyDate=").append(strategyDate);
    sb.append('}');

    return sb.toString();
  } // end method toString
} // end class SmsCampaign
