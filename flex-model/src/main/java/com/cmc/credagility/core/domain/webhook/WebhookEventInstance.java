package com.cmc.credagility.core.domain.webhook;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.type.EventStatus;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * Created by ozintel on 16/8/17.
 *
 * @author   <a href="mailto:jia.zhang@ozstrategy.com">Jia Zhang</a>
 * @version  08/17/2016 15:50
 */
@Entity
@Table(
  name              = "WebhookEventInstance",
  uniqueConstraints = @UniqueConstraint(columnNames = { "resourceId", "webhookEventChannelId", "eventDate" })
)
public class WebhookEventInstance extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(name = "retryCount")
  protected Integer retryCount;

  @Column(name = "eventDate")
  private Date eventDate;

  @Column(
    name     = "eventId",
    nullable = false
  )
  private Long eventId;

  @Column(name = "priority")
  private Integer priority;

  @Column(name = "resourceId")
  private Long resourceId;

  @Column(
    name     = "status",
    nullable = false,
    length   = 10
  )
  @Enumerated(EnumType.STRING)
  private EventStatus status;

  @JoinColumn(name = "webhookEventChannelId")
  @ManyToOne(
    cascade  = CascadeType.REFRESH,
    fetch    = FetchType.LAZY,
    optional = false
  )
  private WebhookEventChannel webhookEventChannel;


  @Column(
    name     = "webhookEventInstanceId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long webhookEventInstanceId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    WebhookEventInstance that = (WebhookEventInstance) o;

    if ((eventId != null) ? (!eventId.equals(that.eventId)) : (that.eventId != null)) {
      return false;
    }

    if ((resourceId != null) ? (!resourceId.equals(that.resourceId)) : (that.resourceId != null)) {
      return false;
    }

    if ((webhookEventChannel != null) ? (!webhookEventChannel.equals(that.webhookEventChannel))
                                      : (that.webhookEventChannel != null)) {
      return false;
    }

    return (webhookEventInstanceId != null) ? webhookEventInstanceId.equals(that.webhookEventInstanceId)
                                            : (that.webhookEventInstanceId == null);

  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for event date.
   *
   * @return  Date
   */
  public Date getEventDate() {
    return eventDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for event id.
   *
   * @return  Long
   */
  public Long getEventId() {
    return eventId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for priority.
   *
   * @return  Integer
   */
  public Integer getPriority() {
    return priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for resource id.
   *
   * @return  Long
   */
  public Long getResourceId() {
    return resourceId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for retry count.
   *
   * @return  Integer
   */
  public Integer getRetryCount() {
    return retryCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status.
   *
   * @return  EventStatus
   */
  public EventStatus getStatus() {
    return status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for web hook event channel.
   *
   * @return  WebhookEventChannel
   */
  public WebhookEventChannel getWebhookEventChannel() {
    return webhookEventChannel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for webhook event instance id.
   *
   * @return  Long
   */
  public Long getWebhookEventInstanceId() {
    return webhookEventInstanceId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((eventId != null) ? eventId.hashCode() : 0);
    result = (31 * result) + ((resourceId != null) ? resourceId.hashCode() : 0);
    result = (31 * result) + ((webhookEventChannel != null) ? webhookEventChannel.hashCode() : 0);
    result = (31 * result) + ((webhookEventInstanceId != null) ? webhookEventInstanceId.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for event date.
   *
   * @param  eventDate  Date
   */
  public void setEventDate(Date eventDate) {
    this.eventDate = eventDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for event id.
   *
   * @param  eventId  Long
   */
  public void setEventId(Long eventId) {
    this.eventId = eventId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for priority.
   *
   * @param  priority  Integer
   */
  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for resource id.
   *
   * @param  resourceId  Long
   */
  public void setResourceId(Long resourceId) {
    this.resourceId = resourceId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for retry count.
   *
   * @param  retryCount  Integer
   */
  public void setRetryCount(Integer retryCount) {
    this.retryCount = retryCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for status.
   *
   * @param  status  EventStatus
   */
  public void setStatus(EventStatus status) {
    this.status = status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for web hook event channel.
   *
   * @param  webhookEventChannel  WebhookEventChannel
   */
  public void setWebhookEventChannel(WebhookEventChannel webhookEventChannel) {
    this.webhookEventChannel = webhookEventChannel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for webhook event instance id.
   *
   * @param  webhookEventInstanceId  Long
   */
  public void setWebhookEventInstanceId(Long webhookEventInstanceId) {
    this.webhookEventInstanceId = webhookEventInstanceId;
  }
} // end class WebhookEventInstance
