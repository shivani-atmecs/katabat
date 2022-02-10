package com.ozstrategy.credagility.core.domain.workflow.customer;

import com.cmc.credagility.core.domain.event.Event;
import com.ozstrategy.credagility.core.domain.BasicWorkflowEvent;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:wei.tang@ozstrategy.com">Wei Tang</a>
 * @version  06/27/2017 16:36
 */
@Entity
@Table(name = "CustomerWorkflowEvent")
public class CustomerWorkflowEvent extends BasicWorkflowEvent implements Serializable {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  @Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE })
  @JoinTable(
    name               = "CustomerFlowAssignEvent",
    joinColumns        = {
      @JoinColumn(
        name           = "customerFlowEventId",
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
  @ManyToMany protected Set<Event> events = new HashSet<Event>();

  @JoinColumn(
    name     = "customerFlowId",
    nullable = false,
    unique   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private CustomerWorkflow flow;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  event  DOCUMENT ME!
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

    CustomerWorkflowEvent that = (CustomerWorkflowEvent) o;

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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<Event> getEvents() {
    return events;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public CustomerWorkflow getFlow() {
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
   * DOCUMENT ME!
   */
  public void removeAllEvents() {
    for (Event event : events) {
      removeEvent(event);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  event  DOCUMENT ME!
   */
  public void removeEvent(Event event) {
    if ((events != null) && !events.isEmpty() && events.contains(event)) {
      events.remove(event);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  events  DOCUMENT ME!
   */
  public void setEvents(Set<Event> events) {
    this.events = events;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  flow  DOCUMENT ME!
   */
  public void setFlow(CustomerWorkflow flow) {
    this.flow = flow;
  }


} // end class CustomerWorkflowEvent
