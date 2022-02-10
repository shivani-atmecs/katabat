package com.cmc.credagility.core.domain.webhook;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * Created by jizhang on 16/8/12.
 *
 * @author   <a href="mailto:jia.zhang@ozstrategy.com">Jia Zhang</a>
 * @version  08/12/2016 10:01
 */
@Entity
@Table(name = "Webhook")
public class Webhook extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  @Column(
    name     = "clientId",
    nullable = false,
    length   = 20
  )
  private String clientId;

  @Column(name = "effectiveDate")
  private Date effectiveDate;

  @Column(name = "maxRetryCount")
  private Integer maxRetryCount;

  @Column(
    name     = "status",
    nullable = false,
    length   = 25
  )
  @Enumerated(EnumType.STRING)
  private WebhookStatus status;

  @Column(name = "terminationDate")
  private Date terminationDate;

  @Column(
    name     = "url",
    nullable = false,
    length   = 255
  )
  private String url;

  @Column(name = "webhookId")
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long webhookId;

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

    Webhook webhook = (Webhook) o;

    if ((clientId != null) ? (!clientId.equals(webhook.clientId)) : (webhook.clientId != null)) {
      return false;
    }

    return (url != null) ? url.equals(webhook.url) : (webhook.url == null);

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client id.
   *
   * @return  String
   */
  public String getClientId() {
    return clientId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for effective date.
   *
   * @return  Date
   */
  public Date getEffectiveDate() {
    return effectiveDate;
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
   * getter method for status.
   *
   * @return  WebhookStatus
   */
  public WebhookStatus getStatus() {
    return status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for termination date.
   *
   * @return  Date
   */
  public Date getTerminationDate() {
    return terminationDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for url.
   *
   * @return  String
   */
  public String getUrl() {
    return url;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for webhook id.
   *
   * @return  Long
   */
  public Long getWebhookId() {
    return webhookId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((clientId != null) ? clientId.hashCode() : 0);
    result = (31 * result) + ((url != null) ? url.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client id.
   *
   * @param  clientId  String
   */
  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for effective date.
   *
   * @param  effectiveDate  Date
   */
  public void setEffectiveDate(Date effectiveDate) {
    this.effectiveDate = effectiveDate;
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
   * setter method for status.
   *
   * @param  status  WebhookStatus
   */
  public void setStatus(WebhookStatus status) {
    this.status = status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for termination date.
   *
   * @param  terminationDate  Date
   */
  public void setTerminationDate(Date terminationDate) {
    this.terminationDate = terminationDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for url.
   *
   * @param  url  String
   */
  public void setUrl(String url) {
    this.url = url;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for webhook id.
   *
   * @param  webhookId  Long
   */
  public void setWebhookId(Long webhookId) {
    this.webhookId = webhookId;
  }

} // end class Webhook
