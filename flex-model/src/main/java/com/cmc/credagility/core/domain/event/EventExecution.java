package com.cmc.credagility.core.domain.event;

import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.type.EventStatus;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/15/2014 13:12
 */
@Entity
@Table(name = "EventExecution")
public class EventExecution extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "eventExecutionId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long eventExecutionId;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "eventInstanceId",
    nullable = false
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  protected EventInstance eventInstance;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "executionEndDate",
    nullable = true
  )
  @Temporal(TemporalType.TIMESTAMP)
  protected Date executionEndDate;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "executionStartDate",
    nullable = true
  )
  @Temporal(TemporalType.TIMESTAMP)
  protected Date executionStartDate;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "status",
    nullable = false,
    length   = 10
  )
  @Enumerated(value = EnumType.STRING)
  protected EventStatus status;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for event execution id.
   *
   * @return  Long
   */
  public Long getEventExecutionId() {
    return eventExecutionId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for event instance.
   *
   * @return  EventInstance
   */
  public EventInstance getEventInstance() {
    return eventInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for execution end date.
   *
   * @return  Date
   */
  public Date getExecutionEndDate() {
    return executionEndDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for execution start date.
   *
   * @return  Date
   */
  public Date getExecutionStartDate() {
    return executionStartDate;
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
   * setter method for event execution id.
   *
   * @param  eventExecutionId  Long
   */
  public void setEventExecutionId(Long eventExecutionId) {
    this.eventExecutionId = eventExecutionId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for event instance.
   *
   * @param  eventInstance  EventInstance
   */
  public void setEventInstance(EventInstance eventInstance) {
    this.eventInstance = eventInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for execution end date.
   *
   * @param  executionEndDate  Date
   */
  public void setExecutionEndDate(Date executionEndDate) {
    this.executionEndDate = executionEndDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for execution start date.
   *
   * @param  executionStartDate  Date
   */
  public void setExecutionStartDate(Date executionStartDate) {
    this.executionStartDate = executionStartDate;
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
} // end class EventExecution
