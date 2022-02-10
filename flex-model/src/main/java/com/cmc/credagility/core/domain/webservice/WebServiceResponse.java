package com.cmc.credagility.core.domain.webservice;

import java.io.Serializable;

import java.util.Map;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 17:41
 */
public class WebServiceResponse implements Serializable {
  //~ Static-fields/initializers ---------------------------------------------------------------------------------------

  /** serialVersionUID. */
  private static final long serialVersionUID = 5230773619332471430L;

  //~ Instance-fields --------------------------------------------------------------------------------------------------

  /** errorCode. */
  private String errorCode;

  /** errorMap. */
  private Map<String, String> errorMap;

  /** errorMessage. */
  private String errorMessage;

  /** processed. */
  private boolean processed;

  /** successful. */
  private Boolean successful = Boolean.TRUE;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for error code.
   *
   * @return  String
   */
  public String getErrorCode() {
    return errorCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for error map.
   *
   * @return  Map
   */
  public Map<String, String> getErrorMap() {
    return errorMap;
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
   * isProcessed.
   *
   * @return  boolean
   */
  public boolean isProcessed() {
    return processed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for successful.
   *
   * @return  Boolean
   */
  public Boolean isSuccessful() {
    return successful;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for error code.
   *
   * @param  errorCode  String
   */
  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for error map.
   *
   * @param  errorMap  Map
   */
  public void setErrorMap(Map<String, String> errorMap) {
    this.errorMap = errorMap;
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
   * setProcessed.
   *
   * @param  processed  - method parameter processed
   */
  public void setProcessed(boolean processed) {
    this.processed = processed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for successful.
   *
   * @param  successful  Boolean
   */
  public void setSuccessful(Boolean successful) {
    this.successful = successful;
  }

} // end class WebServiceResponse
