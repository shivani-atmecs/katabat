package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.event.Event;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


/**
 * SurveyFlow Event.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/16/2014 11:05
 */
@Entity
@Table(name = "SurveyFlowEvent")
public class SurveyFlowEvent extends BasicWorkflowEvent implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 6302659721618954552L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinTable(
    name               = "SurveyFlowAssignEvent",
    indexes            = { @Index(columnList = "flowEventId") },
    joinColumns        = {
      @JoinColumn(
        name           = "flowEventId",
        nullable       = false,
        updatable      = false
      )
    },
    inverseJoinColumns = {
      @JoinColumn(
        name           = "eventId",
        nullable       = false,
        updatable      = false
      )
    }
  )
  @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  protected Set<Event> events = new HashSet<Event>();

  @JoinColumn(
    name     = "surveyFlowId",
    nullable = false,
    unique   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private SurveyFlow flow;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addEvent.
   *
   * @param  event  Event
   */
  public void addEvent(Event event) {
    if ((events != null) && !events.isEmpty() && !events.contains(event)) {
      events.add(event);
    } else {
      events.add(event);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#equals(Object)
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

    SurveyFlowEvent that = (SurveyFlowEvent) o;

    if ((criteria != null) && !criteria.equals(that.criteria)) {
      return false;
    }

    if ((events != null) && !events.equals(that.events)) {
      return false;
    }

    if ((id != null) && !id.equals(that.id)) {
      return false;
    }

    if ((flow != null) && !flow.equals(that.flow)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for event ids.
   *
   * @return  String
   */
  public String getEventIds() {
    StringBuffer buffer = new StringBuffer();

    if ((events != null) && !events.isEmpty()) {
      for (Event event : events) {
        buffer.append(",").append(event.getEventId());
      }

      return buffer.substring(1);
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for events.
   *
   * @return  Set
   */
  public Set<Event> getEvents() {
    return events;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for flow.
   *
   * @return  SurveyFlow
   */
  public SurveyFlow getFlow() {
    return flow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((id != null) ? id.hashCode() : 0);
    result = (31 * result) + ((criteria != null) ? criteria.hashCode() : 0);
    result = (31 * result) + ((events != null) ? events.hashCode() : 0);
    result = (31 * result) + ((flow != null) ? flow.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * removeAllEvents.
   */
  public void removeAllEvents() {
    for (Event event : events) {
      removeEvent(event);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * removeEvent.
   *
   * @param  event  Event
   */
  public void removeEvent(Event event) {
    if ((events != null) && !events.isEmpty() && events.contains(event)) {
      events.remove(event);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for events.
   *
   * @param  events  Set
   */
  public void setEvents(Set<Event> events) {
    this.events = events;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for flow.
   *
   * @param  flow  SurveyFlow
   */
  public void setFlow(SurveyFlow flow) {
    this.flow = flow;
  }


} // end class SurveyFlowEvent
