package com.cmc.credagility.core.domain.webactivity;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * Created by wangjp on 16/11/17.
 *
 * @author   <a href="mailto:jianping.wang@ozstrategy.com">Jianping Wang</a>
 * @version  11/17/2016 15:37
 */
@Entity
@Table(name = "WebServiceCallAudit")
public class WebServiceCallAudit implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -8346859306619034196L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(name = "accountNum")
  protected Long accountNum;

  /** TODO: DOCUMENT ME! */
  @Column(name = "customerId")
  protected Long customerId;


  /** TODO: DOCUMENT ME! */
  @Column(name = "errorMessage")
  protected String errorMessage;

  /** DOCUMENT ME! */
  @Column(
    name   = "name",
    length = 55
  )
  protected String name;

  /** TODO: DOCUMENT ME! */
  @Column @Lob protected String requestBody;

  /** TODO: DOCUMENT ME! */
  @Column(name = "requestHeaders")
  protected String requestHeaders;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "requestMethod",
    length = 10
  )
  protected String requestMethod;

  /** TODO: DOCUMENT ME! */
  @Column(name = "requestTime")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date requestTime;

  /** TODO: DOCUMENT ME! */
  @Column(name = "requestUrl")
  protected String requestUrl;

  /** TODO: DOCUMENT ME! */
  @Column(name = "responseCode")
  protected Integer responseCode;

  /** TODO: DOCUMENT ME! */
  @Column(name = "responseTime")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date responseTime;

  /** TODO: DOCUMENT ME! */
  @Column(name = "responsibleId")
  protected Long responsibleId;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "source",
    length = 10
  )
  protected String source;

  /** TODO: DOCUMENT ME! */
  @Column(name = "status")
  protected String status;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "type",
    length = 10
  )
  protected String type;

  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long webServiceCallAuditId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for account num.
   *
   * @return  Long
   */
  public Long getAccountNum() {
    return accountNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for customer id.
   *
   * @return  Long
   */
  public Long getCustomerId() {
    return customerId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for error message.
   *
   * @return  String
   */
  public String getErrorMessage() {
    return errorMessage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getName() {
    return name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for request body.
   *
   * @return  String
   */
  public String getRequestBody() {
    return requestBody;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for request headers.
   *
   * @return  String
   */
  public String getRequestHeaders() {
    return requestHeaders;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for request method.
   *
   * @return  String
   */
  public String getRequestMethod() {
    return requestMethod;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for request time.
   *
   * @return  Date
   */
  public Date getRequestTime() {
    return requestTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for request url.
   *
   * @return  String
   */
  public String getRequestUrl() {
    return requestUrl;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for response code.
   *
   * @return  Integer
   */
  public Integer getResponseCode() {
    return responseCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for response time.
   *
   * @return  Date
   */
  public Date getResponseTime() {
    return responseTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible id.
   *
   * @return  Long
   */
  public Long getResponsibleId() {
    return responsibleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for source.
   *
   * @return  String
   */
  public String getSource() {
    return source;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status.
   *
   * @return  String
   */
  public String getStatus() {
    return status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for type.
   *
   * @return  String
   */
  public String getType() {
    return type;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for web service call audit id.
   *
   * @return  Long
   */
  public Long getWebServiceCallAuditId() {
    return webServiceCallAuditId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account num.
   *
   * @param  accountNum  Long
   */
  public void setAccountNum(Long accountNum) {
    this.accountNum = accountNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for customer id.
   *
   * @param  customerId  Long
   */
  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for error message.
   *
   * @param  errorMessage  String
   */
  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  name  DOCUMENT ME!
   */
  public void setName(String name) {
    this.name = name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for request body.
   *
   * @param  requestBody  String
   */
  public void setRequestBody(String requestBody) {
    this.requestBody = requestBody;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for request headers.
   *
   * @param  requestHeaders  String
   */
  public void setRequestHeaders(String requestHeaders) {
    this.requestHeaders = requestHeaders;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for request method.
   *
   * @param  requestMethod  String
   */
  public void setRequestMethod(String requestMethod) {
    this.requestMethod = requestMethod;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for request time.
   *
   * @param  requestTime  Date
   */
  public void setRequestTime(Date requestTime) {
    this.requestTime = requestTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for request url.
   *
   * @param  requestUrl  String
   */
  public void setRequestUrl(String requestUrl) {
    this.requestUrl = requestUrl;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for response code.
   *
   * @param  responseCode  Integer
   */
  public void setResponseCode(Integer responseCode) {
    this.responseCode = responseCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for response time.
   *
   * @param  responseTime  Date
   */
  public void setResponseTime(Date responseTime) {
    this.responseTime = responseTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for responsible id.
   *
   * @param  responsibleId  Long
   */
  public void setResponsibleId(Long responsibleId) {
    this.responsibleId = responsibleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for source.
   *
   * @param  source  String
   */
  public void setSource(String source) {
    this.source = source;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for status.
   *
   * @param  status  String
   */
  public void setStatus(String status) {
    this.status = status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for type.
   *
   * @param  type  String
   */
  public void setType(String type) {
    this.type = type;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for web service call audit id.
   *
   * @param  webServiceCallAuditId  Long
   */
  public void setWebServiceCallAuditId(Long webServiceCallAuditId) {
    this.webServiceCallAuditId = webServiceCallAuditId;
  }
} // end class WebServiceCallAudit
