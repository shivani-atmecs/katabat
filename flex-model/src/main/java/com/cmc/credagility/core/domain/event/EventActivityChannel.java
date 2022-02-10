package com.cmc.credagility.core.domain.event;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.type.WebActivityChannel;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/15/2014 15:49
 */
@Entity
@Table(
  name              = "EventActivityChannel",
  uniqueConstraints = { @UniqueConstraint(columnNames = { "eventActivityId", "channelType" }) }
)
public class EventActivityChannel extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "activityChannelId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long activityChannelId;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "channelType",
    length   = 20,
    nullable = false
  )
  @Enumerated(value = EnumType.STRING)
  protected WebActivityChannel channelType;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "eventActivityId",
    nullable = false
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  protected EventActivity eventActivity;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (obj == null) {
      return false;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    final EventActivityChannel other = (EventActivityChannel) obj;

    if (channelType == null) {
      if (other.getChannelType() != null) {
        return false;
      }
    } else if (!channelType.equals(
            other.getChannelType())) {
      return false;
    }


    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for activity channel id.
   *
   * @return  Long
   */
  public Long getActivityChannelId() {
    return activityChannelId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for channel type.
   *
   * @return  WebActivityChannel
   */
  public WebActivityChannel getChannelType() {
    return channelType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for event activity.
   *
   * @return  EventActivity
   */
  public EventActivity getEventActivity() {
    return eventActivity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = 1;
    result = (prime * result)
      + ((channelType == null) ? 0 : channelType.hashCode());
    result = (prime * result)
      + ((eventActivity == null) ? 0 : eventActivity.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for activity channel id.
   *
   * @param  activityChannelId  Long
   */
  public void setActivityChannelId(Long activityChannelId) {
    this.activityChannelId = activityChannelId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for channel type.
   *
   * @param  channelType  WebActivityChannel
   */
  public void setChannelType(WebActivityChannel channelType) {
    this.channelType = channelType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for event activity.
   *
   * @param  eventActivity  EventActivity
   */
  public void setEventActivity(EventActivity eventActivity) {
    this.eventActivity = eventActivity;
  }
} // end class EventActivityChannel
