package com.cmc.credagility.core.domain.common;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * This class is used to store SpeedTestLog information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/15/2014 15:07
 */
@Entity
@Table(name = "SpeedTestLog")
public class SpeedTestLog implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 5388096088280306701L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Agent id. */
  @Column(name = "agentId")
  protected long agentId;


  /** Browser headers. */
  @Column(
    name   = "browserHeaders",
    length = 1024
  )
  protected String browserHeaders;

  /** The datetime when server request data from database. */
  @Column(name = "dbRequestTime")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date dbRequestTime;

  /** The datetime when database response data to server. */
  @Column(name = "dbResponseTime")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date dbResponseTime;


  /** PK. */
  @Column(
    name     = "id",
    nullable = false,
    unique   = true
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected long id;


  /** Ip address. */
  @Column(
    name     = "ipAddress",
    nullable = false,
    length   = 50
  )
  protected String ipAddress;

  /** The datetime when server receive the speed testing request from client. */
  @Column(name = "requestReceivedTime")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date requestReceivedTime;

  /** The datetime when client the speed testing request to server. */
  @Column(name = "requestSentTime")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date requestSentTime;

  /** The datetime when client receive the response from server. */
  @Column(name = "responseReceivedTime")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date responseReceivedTime;

  /** The datetime when server response client. */
  @Column(name = "responseSentTime")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date responseSentTime;


  /** Test result. */
  @Column(
    name     = "result",
    nullable = false,
    length   = 2048
  )
  protected String result;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new SpeedTestLog object.
   */
  public SpeedTestLog() { }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for agent id.
   *
   * @return  long
   */
  public long getAgentId() {
    return agentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for browser headers.
   *
   * @return  String
   */
  public String getBrowserHeaders() {
    return browserHeaders;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for db request time.
   *
   * @return  Date
   */
  public Date getDbRequestTime() {
    return dbRequestTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for db response time.
   *
   * @return  Date
   */
  public Date getDbResponseTime() {
    return dbResponseTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for id.
   *
   * @return  long
   */
  public long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ip address.
   *
   * @return  String
   */
  public String getIpAddress() {
    return ipAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for request received time.
   *
   * @return  Date
   */
  public Date getRequestReceivedTime() {
    return requestReceivedTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for request sent time.
   *
   * @return  Date
   */
  public Date getRequestSentTime() {
    return requestSentTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for response received time.
   *
   * @return  Date
   */
  public Date getResponseReceivedTime() {
    return responseReceivedTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for response sent time.
   *
   * @return  Date
   */
  public Date getResponseSentTime() {
    return responseSentTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for result.
   *
   * @return  String
   */
  public String getResult() {
    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agent id.
   *
   * @param  agentId  long
   */
  public void setAgentId(long agentId) {
    this.agentId = agentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for browser headers.
   *
   * @param  browserHeaders  String
   */
  public void setBrowserHeaders(String browserHeaders) {
    this.browserHeaders = browserHeaders;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for db request time.
   *
   * @param  dbRequestTime  Date
   */
  public void setDbRequestTime(Date dbRequestTime) {
    this.dbRequestTime = dbRequestTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for db response time.
   *
   * @param  dbResponseTime  Date
   */
  public void setDbResponseTime(Date dbResponseTime) {
    this.dbResponseTime = dbResponseTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for id.
   *
   * @param  id  long
   */
  public void setId(long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ip address.
   *
   * @param  ipAddress  String
   */
  public void setIpAddress(String ipAddress) {
    this.ipAddress = ipAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for request received time.
   *
   * @param  requestReceivedTime  Date
   */
  public void setRequestReceivedTime(Date requestReceivedTime) {
    this.requestReceivedTime = requestReceivedTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for request sent time.
   *
   * @param  requestSentTime  Date
   */
  public void setRequestSentTime(Date requestSentTime) {
    this.requestSentTime = requestSentTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for response received time.
   *
   * @param  responseReceivedTime  Date
   */
  public void setResponseReceivedTime(Date responseReceivedTime) {
    this.responseReceivedTime = responseReceivedTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for response sent time.
   *
   * @param  responseSentTime  Date
   */
  public void setResponseSentTime(Date responseSentTime) {
    this.responseSentTime = responseSentTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for result.
   *
   * @param  result  String
   */
  public void setResult(String result) {
    this.result = result;
  }
} // end class SpeedTestLog
