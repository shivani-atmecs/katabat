package com.cmc.credagility.core.domain.webactivity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by wangjp on 16/11/17.
 *
 * @author   <a href="mailto:jianping.wang@ozstrategy.com">Jianping Wang</a>
 * @version  11/17/2016 15:41
 */
@Entity
@Table(name = "WebServiceCallResponseBodyAudit")
public class WebServiceCallResponseBodyAudit implements Serializable {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "responseId",
    unique   = true,
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long responseId;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "webServiceCallAuditId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected WebServiceCallAudit WebServiceCallAudit;

  /** TODO: DOCUMENT ME! */


  @Column(
    name             = "responseBody",
    columnDefinition = "LONGBLOB"
  )
  @Lob private byte[] responseBody;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for response body.
   *
   * @return  byte[]
   */
  public byte[] getResponseBody() {
    return responseBody;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for response id.
   *
   * @return  Long
   */
  public Long getResponseId() {
    return responseId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for web service call audit.
   *
   * @return  com.cmc.model.WebServiceCallAudit
   */
  public WebServiceCallAudit getWebServiceCallAudit() {
    return WebServiceCallAudit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for response body.
   *
   * @param  responseBody  byte[]
   */
  public void setResponseBody(byte[] responseBody) {
    this.responseBody = responseBody;
  }

  public void setResponseBody(String responseBody) {
    if (responseBody != null) {
      this.responseBody = responseBody.getBytes();
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for response id.
   *
   * @param  responseId  Long
   */
  public void setResponseId(Long responseId) {
    this.responseId = responseId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for web service call audit.
   *
   * @param  webServiceCallAudit  com.cmc.model.WebServiceCallAudit
   */
  public void setWebServiceCallAudit(WebServiceCallAudit webServiceCallAudit) {
    WebServiceCallAudit = webServiceCallAudit;
  }
} // end class WebServiceCallResponseBodyAudit
