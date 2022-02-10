package com.cmc.credagility.core.domain.event;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.businesscontext.BusinessContext;
import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.cmc.credagility.core.domain.webhook.WebhookEventChannel;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/15/2014 13:09
 */
@Entity
@Table(
  name              = "Event",
  uniqueConstraints = { @UniqueConstraint(columnNames = { "eventName", "portfolioId", "businessContextId" }) }
)
public class Event extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "businessContextId",
    updatable = false,
    nullable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BusinessContext businessContext;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "eventId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long eventId;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "eventName",
    length   = 250,
    nullable = false
  )
  protected String eventName;

  /** TODO: DOCUMENT ME! */
  @Column(
    name       = "eventType",
    length     = 50,
    updatable  = false,
    insertable = false
  )
  protected String eventType;


  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "isEvent",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean isEvent;

  /** TODO: DOCUMENT ME! */
  @Column(name = "maxRetryCount")
  protected Integer maxRetryCount;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "portfolioId",
    updatable = false,
    nullable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Portfolio portfolio;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "runMRA",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean runMRA;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "synchronous",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean synchronous;

  @Column(
          name             = "runAllPortfolios",
          columnDefinition = "char",
          length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean runAllPortfolios;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "event",
    cascade  = CascadeType.ALL
  )
  Set<EventActivity> eventActivities = new LinkedHashSet<EventActivity>();

  /** DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "event",
    cascade  = CascadeType.ALL
  )
  Set<WebhookEventChannel> webhookEventChannels = new LinkedHashSet();

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

    Event event = (Event) o;

    if ((businessContext != null) ? (!businessContext.equals(event.businessContext))
                                  : (event.businessContext != null)) {
      return false;
    }

    if ((eventName != null) ? (!eventName.equals(event.eventName)) : (event.eventName != null)) {
      return false;
    }

    return !((portfolio != null) ? (!portfolio.equals(event.portfolio)) : (event.portfolio != null));

  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for business context.
   *
   * @return  BusinessContext
   */
  public BusinessContext getBusinessContext() {
    return businessContext;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for event.
   *
   * @return  Boolean
   */
  public Boolean getEvent() {
    if (isEvent == null) {
      return Boolean.FALSE;
    }

    return isEvent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for event activities.
   *
   * @return  Set
   */
  public Set<EventActivity> getEventActivities() {
    return eventActivities;
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
   * getter method for event name.
   *
   * @return  String
   */
  public String getEventName() {
    return eventName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for event type.
   *
   * @return  String
   */
  public String getEventType() {
    return eventType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for is event.
   *
   * @return  Boolean
   */
  public Boolean getIsEvent() {
    return isEvent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for max retry count.
   *
   * @return  Integer
   */
  public Integer getMaxRetryCount() {
    return maxRetryCount;
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
   * getter method for run MRA.
   *
   * @return  Boolean
   */
  public Boolean getRunMRA() {
    if (null == runMRA) {
      return Boolean.FALSE;
    }

    return runMRA;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for synchronous.
   *
   * @return  Boolean
   */
  public Boolean getSynchronous() {
    if (synchronous == null) {
      return Boolean.FALSE;
    }

    return synchronous;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for webhook event channels.
   *
   * @return  Set
   */
  public Set<WebhookEventChannel> getWebhookEventChannels() {
    return webhookEventChannels;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((businessContext != null) ? businessContext.hashCode() : 0);
    result = (31 * result) + ((eventName != null) ? eventName.hashCode() : 0);
    result = (31 * result) + ((portfolio != null) ? portfolio.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for business context.
   *
   * @param  businessContext  BusinessContext
   */
  public void setBusinessContext(BusinessContext businessContext) {
    this.businessContext = businessContext;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for event.
   *
   * @param  event  Boolean
   */
  public void setEvent(Boolean event) {
    isEvent = event;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for event activities.
   *
   * @param  eventActivities  Set
   */
  public void setEventActivities(Set<EventActivity> eventActivities) {
    this.eventActivities = eventActivities;
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
   * setter method for event name.
   *
   * @param  eventName  String
   */
  public void setEventName(String eventName) {
    this.eventName = eventName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for event type.
   *
   * @param  eventType  String
   */
  public void setEventType(String eventType) {
    this.eventType = eventType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for is event.
   *
   * @param  isEvent  Boolean
   */
  public void setIsEvent(Boolean isEvent) {
    this.isEvent = isEvent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for max retry count.
   *
   * @param  maxRetryCount  Integer
   */
  public void setMaxRetryCount(Integer maxRetryCount) {
    this.maxRetryCount = maxRetryCount;
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
   * setter method for run MRA.
   *
   * @param  runMRA  Boolean
   */
  public void setRunMRA(Boolean runMRA) {
    this.runMRA = runMRA;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for synchronous.
   *
   * @param  synchronous  Boolean
   */
  public void setSynchronous(Boolean synchronous) {
    this.synchronous = synchronous;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for webhook event channels.
   *
   * @param  webhookEventChannels  Set
   */
  public void setWebhookEventChannels(Set<WebhookEventChannel> webhookEventChannels) {
    this.webhookEventChannels = webhookEventChannels;
  }

  public Boolean getRunAllPortfolios() {
    return runAllPortfolios;
  }

  public void setRunAllPortfolios(Boolean runAllPortfolios) {
    this.runAllPortfolios = runAllPortfolios;
  }
} // end class Event
