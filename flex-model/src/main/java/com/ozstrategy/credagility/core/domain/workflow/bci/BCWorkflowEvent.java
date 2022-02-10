package com.ozstrategy.credagility.core.domain.workflow.bci;

import com.cmc.credagility.core.domain.event.Event;
import com.ozstrategy.credagility.core.domain.BasicWorkflowEvent;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


/**
 * Created with IntelliJ IDEA. User: yongliu Date: 2/8/14 Time: 2:22 PM To change this template use File | Settings |
 * File Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(name = "BCWorkflowEvent")
public class BCWorkflowEvent extends BasicWorkflowEvent implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 8501862941639819548L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Many to many with table BCWorkflowAssignEvent. */
  @JoinColumn(
    name     = "bcWorkflowId",
    nullable = false,
    unique   = true
  )
  @JoinTable(
    name               = "BCWorkflowAssignEvent",
    indexes            = { @Index(columnList = "bcWorkflowEventId") },
    joinColumns        = {
      @JoinColumn(
        name           = "bcWorkflowEventId",
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
  @ManyToMany(cascade = { CascadeType.ALL })
  protected Set<Event> events = new HashSet<Event>();


  @JoinColumn(
    name     = "bcWorkflowId",
    nullable = false,
    unique   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private BCWorkflow workflow;

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
   * DOCUMENT ME!
   *
   * @param   o  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
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

    BCWorkflowEvent that = (BCWorkflowEvent) o;

    if ((criteria != null) && !criteria.equals(that.criteria)) {
      return false;
    }

    if ((events != null) && !events.equals(that.events)) {
      return false;
    }

    if ((id != null) && !id.equals(that.id)) {
      return false;
    }

    if ((workflow != null) && !workflow.equals(that.workflow)) {
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
  public BCWorkflow getWorkflow() {
    return workflow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((id != null) ? id.hashCode() : 0);
    result = (31 * result) + ((criteria != null) ? criteria.hashCode() : 0);
    result = (31 * result) + ((events != null) ? events.hashCode() : 0);
    result = (31 * result) + ((workflow != null) ? workflow.hashCode() : 0);

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
   * @param  workflow  DOCUMENT ME!
   */
  public void setWorkflow(BCWorkflow workflow) {
    this.workflow = workflow;
  }
} // end class BCWorkflowEvent
