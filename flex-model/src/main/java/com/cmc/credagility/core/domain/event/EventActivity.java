package com.cmc.credagility.core.domain.event;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/15/2014 13:11
 */
@Entity
@Table(
  name              = "EventActivity",
  uniqueConstraints = { @UniqueConstraint(columnNames = { "eventId", "activityName" }) }
)
public class EventActivity extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "activityName",
    length   = 255,
    nullable = false
  )
  protected String activityName;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "eventId",
    nullable = false
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  protected Event event;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "eventActivityId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long eventActivityId;


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "eventActivity",
    cascade  = CascadeType.ALL
  )
  Set<EventActivityChannel> activityChannels = new LinkedHashSet<EventActivityChannel>();

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

    final EventActivity other = (EventActivity) obj;

    if (activityName == null) {
      if (other.getActivityName() != null) {
        return false;
      }
    } else if (!activityName.equals(
            other.getActivityName())) {
      return false;
    }


    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for activity channels.
   *
   * @return  Set
   */
  public Set<EventActivityChannel> getActivityChannels() {
    return activityChannels;
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
   * getter method for event.
   *
   * @return  Event
   */
  public Event getEvent() {
    return event;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for event activity id.
   *
   * @return  Long
   */
  public Long getEventActivityId() {
    return eventActivityId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = 1;
    result = (prime * result)
      + ((activityName == null) ? 0 : activityName.hashCode());
    result = (prime * result)
      + ((event == null) ? 0 : event.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for activity channels.
   *
   * @param  activityChannels  Set
   */
  public void setActivityChannels(Set<EventActivityChannel> activityChannels) {
    this.activityChannels = activityChannels;
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
   * setter method for event.
   *
   * @param  event  Event
   */
  public void setEvent(Event event) {
    this.event = event;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for event activity id.
   *
   * @param  eventActivityId  Long
   */
  public void setEventActivityId(Long eventActivityId) {
    this.eventActivityId = eventActivityId;
  }
} // end class EventActivity
