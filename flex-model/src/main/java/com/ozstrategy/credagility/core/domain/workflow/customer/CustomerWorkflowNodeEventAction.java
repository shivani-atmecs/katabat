package com.ozstrategy.credagility.core.domain.workflow.customer;

import com.cmc.credagility.core.domain.event.Event;
import org.hibernate.annotations.Type;

import javax.persistence.*;


/**
 * Created by tangwei on 17/3/24.
 *
 * @author   <a href="mailto:wei.tang@ozstrategy.com">Wei Tang</a>
 * @version  03/24/2017 14:58
 */
@Entity
@Table(name = "CustomerWorkflowNodeEventAction")
public class CustomerWorkflowNodeEventAction extends CustomerWorkflowNodeAction {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -4661358174616810365L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** node . */
  @JoinColumn(
    name       = "eventId",
    nullable   = false,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Event event = new Event();

  /** TODO: DOCUMENT ME! */
  @Column
  @Type(type = "yes_no")
  protected Boolean synchronous;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  CustomerWorkflowNodeAction#equals(Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    CustomerWorkflowNodeEventAction that = (CustomerWorkflowNodeEventAction) o;

    if ((synchronous != null) ? (!synchronous.equals(that.synchronous)) : (that.synchronous != null)) {
      return false;
    }

    if ((event != null) ? (!event.equals(that.event)) : (that.event != null)) {
      return false;
    }


    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowNodeActionInterface#getActionName()
   */
  @Override public String getActionName() {
    if (this.getEvent() != null) {
      return this.getEvent().getEventName();
    }

    return null;
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
   * @see  CustomerWorkflowNodeAction#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((synchronous != null) ? synchronous.hashCode() : 0);
    result = (31 * result) + ((event != null) ? event.hashCode() : 0);

    return result;
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
   * setter method for synchronous.
   *
   * @param  synchronous  Boolean
   */
  public void setSynchronous(Boolean synchronous) {
    this.synchronous = synchronous;
  }

} // end class CustomerWorkflowNodeEventAction
