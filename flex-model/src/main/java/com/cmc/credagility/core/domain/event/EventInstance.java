package com.cmc.credagility.core.domain.event;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.payment.Payment;
import com.cmc.credagility.core.domain.payment.PaymentProgram;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.domain.type.EventStatus;
import com.cmc.credagility.core.domain.webactivity.WebActivity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/15/2014 13:14
 */
@Entity
@Table(
  name    = "EventInstance",
  indexes = {
    @Index(
      name = "statusIndex",
      columnList = "status"
    )
  }
)
public class EventInstance extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "eventId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected Event event;

  /** DOCUMENT ME! */
  @Column(name = "eventDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date eventDate;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "eventInstanceId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long eventInstanceId;

  /** copy from Event.eventType. */
  @Column(
    name       = "eventType",
    length     = 50,
    updatable  = false,
    insertable = false
  )
  protected String eventType;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "paymentId",
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Payment payment;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "paymentProgramId",
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PaymentProgram paymentProgram;

  /** event resource id e.g. paymentId/fundAcctId etc... */
  @Column(name = "resourceId")
  protected Long resourceId;


  /** TODO: DOCUMENT ME! */
  @Transient protected Responsible responsible;


  /** TODO: DOCUMENT ME! */
  @Column(name = "retryCount")
  protected Integer retryCount;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "status",
    nullable = false,
    length   = 10
  )
  @Enumerated(value = EnumType.STRING)
  protected EventStatus status;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "webActivityId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected WebActivity webActivity;


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "eventInstance",
    cascade  = CascadeType.ALL
  )
  @OrderBy("createDate desc")
  Set<EventExecution> eventExecutions = new LinkedHashSet<EventExecution>();

  //~ Methods ----------------------------------------------------------------------------------------------------------

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
   * getter method for event date.
   *
   * @return  Date
   */
  public Date getEventDate() {
    return eventDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for event executions.
   *
   * @return  Set
   */
  public Set<EventExecution> getEventExecutions() {
    return eventExecutions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for event instance id.
   *
   * @return  Long
   */
  public Long getEventInstanceId() {
    return eventInstanceId;
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
   * getter method for payment.
   *
   * @return  Payment
   */
  public Payment getPayment() {
    return payment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment program.
   *
   * @return  PaymentProgram
   */
  public PaymentProgram getPaymentProgram() {
    return paymentProgram;
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
   * getter method for responsible.
   *
   * @return  Responsible
   */
  public Responsible getResponsible() {
    if ((responsible == null) && (webActivity != null)) {
      responsible = webActivity.getResponsible();
    }

    return responsible;
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
   * getter method for web activity.
   *
   * @return  WebActivity
   */
  public WebActivity getWebActivity() {
    return webActivity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  event  DOCUMENT ME!
   */
  public void setEvent(Event event) {
    this.event = event;
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
   * DOCUMENT ME!
   *
   * @param  eventExecutions  DOCUMENT ME!
   */
  public void setEventExecutions(Set<EventExecution> eventExecutions) {
    this.eventExecutions = eventExecutions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for event instance id.
   *
   * @param  eventInstanceId  Long
   */
  public void setEventInstanceId(Long eventInstanceId) {
    this.eventInstanceId = eventInstanceId;
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
   * setter method for payment.
   *
   * @param  payment  Payment
   */
  public void setPayment(Payment payment) {
    this.payment = payment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for payment program.
   *
   * @param  paymentProgram  PaymentProgram
   */
  public void setPaymentProgram(PaymentProgram paymentProgram) {
    this.paymentProgram = paymentProgram;
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
   * setter method for responsible.
   *
   * @param  responsible  Responsible
   */
  public void setResponsible(Responsible responsible) {
    this.responsible = responsible;
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
   * setter method for web activity.
   *
   * @param  webActivity  WebActivity
   */
  public void setWebActivity(WebActivity webActivity) {
    this.webActivity = webActivity;
  }
} // end class EventInstance
