package com.cmc.credagility.core.domain.webhook;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.event.Event;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * Created by ozintel on 16/8/17.
 *
 * @author   <a href="mailto:jia.zhang@ozstrategy.com">Jia Zhang</a>
 * @version  08/17/2016 15:49
 */
@Entity
@Table(
  name              = "WebhookEventChannel",
  uniqueConstraints = @UniqueConstraint(columnNames = { "webhookId", "eventId", "channel" })
)
public class WebhookEventChannel extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  @Column(
    name     = "channel",
    length   = 20,
    nullable = false
  )
  private String channel;

  @JoinColumn(name = "eventId")
  @ManyToOne private Event event;

  @Column(name = "priority")
  private Integer priority;

  @JoinColumn(name = "webhookId")
  @ManyToOne private Webhook webhook;

  @Column(
    name     = "webhookEventChannelId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long webhookEventChannelId;

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

    WebhookEventChannel that = (WebhookEventChannel) o;

    if (channel != that.channel) {
      return false;
    }

    if ((event != null) ? (!event.equals(that.event)) : (that.event != null)) {
      return false;
    }

    return (webhook != null) ? webhook.equals(that.webhook) : (that.webhook == null);

  } // end method equals

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
   * getter method for event.
   *
   * @return  Event
   */
  public Event getEvent() {
    return event;
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
   * getter method for web hook.
   *
   * @return  Webhook
   */
  public Webhook getWebhook() {
    return webhook;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for web hook event channel id.
   *
   * @return  Long
   */
  public Long getWebhookEventChannelId() {
    return webhookEventChannelId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((channel != null) ? channel.hashCode() : 0);
    result = (31 * result) + ((event != null) ? event.hashCode() : 0);
    result = (31 * result) + ((webhook != null) ? webhook.hashCode() : 0);

    return result;
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
   * setter method for event.
   *
   * @param  event  Event
   */
  public void setEvent(Event event) {
    this.event = event;
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
   * setter method for web hook.
   *
   * @param  webhook  Webhook
   */
  public void setWebhook(Webhook webhook) {
    this.webhook = webhook;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for web hook event channel id.
   *
   * @param  webhookEventChannelId  Long
   */
  public void setWebhookEventChannelId(Long webhookEventChannelId) {
    this.webhookEventChannelId = webhookEventChannelId;
  }
} // end class WebhookEventChannel
