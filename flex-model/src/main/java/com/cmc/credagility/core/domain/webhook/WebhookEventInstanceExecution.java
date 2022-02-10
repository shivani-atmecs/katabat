package com.cmc.credagility.core.domain.webhook;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.type.EventStatus;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * Created by jiazhang on 16/08/19.
 *
 * @author   <a href="mailto:jia.zhang@ozstrategy.com">Jia Zhang</a>
 * @version  08/19/2016 16:00
 */
@Entity
@Table(name = "WebhookEventInstanceExecution")
public class WebhookEventInstanceExecution extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  @Column(
    name     = "executionEndDate",
    nullable = true
  )
  protected Date executionEndDate;

  /** DOCUMENT ME! */
  @Column(
    name     = "executionStartDate",
    nullable = true
  )
  protected Date executionStartDate;

  /** DOCUMENT ME! */
  @Column(
    name     = "status",
    nullable = false,
    length   = 10
  )
  @Enumerated(EnumType.STRING)
  protected EventStatus status;

  /** DOCUMENT ME! */
  @JoinColumn(
    name     = "webhookEventInstanceId",
    nullable = false
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = { CascadeType.MERGE }
  )
  protected WebhookEventInstance webhookEventInstance;

  @Column(
          name = "requestReferenceNumber",
          nullable = true,
          length = 50
  )
  private String requestReferenceNumber;


  @Column(
          name="executionResult",
          nullable = true,
          length = 200
  )
  private String executionResult;

  /** DOCUMENT ME! */
  @Column(
    name     = "webhookEventInstanceExecutionId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id
  protected Long webhookEventInstanceExecutionId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

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
   * getter method for webhook event instance.
   *
   * @return  WebhookEventInstance
   */
  public WebhookEventInstance getWebhookEventInstance() {
    return webhookEventInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for webhook event instance execution id.
   *
   * @return  Long
   */
  public Long getWebhookEventInstanceExecutionId() {
    return webhookEventInstanceExecutionId;
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

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for webhook event instance.
   *
   * @param  webhookEventInstance  WebhookEventInstance
   */
  public void setWebhookEventInstance(WebhookEventInstance webhookEventInstance) {
    this.webhookEventInstance = webhookEventInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for webhook event instance execution id.
   *
   * @param  webhookEventInstanceExecutionId  Long
   */
  public void setWebhookEventInstanceExecutionId(Long webhookEventInstanceExecutionId) {
    this.webhookEventInstanceExecutionId = webhookEventInstanceExecutionId;
  }

  public String getRequestReferenceNumber() {
    return requestReferenceNumber;
  }

  public void setRequestReferenceNumber(String requestReferenceNumber) {
    this.requestReferenceNumber = requestReferenceNumber;
  }

  public String getExecutionResult() {
    return executionResult;
  }

  public void setExecutionResult(String executionResult) {
    this.executionResult = executionResult;
  }
} // end class WebhookEventInstanceExecution
