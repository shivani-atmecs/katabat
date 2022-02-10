package com.cmc.credagility.core.domain.webservice;

import com.cmc.credagility.core.domain.webservice.demographics.WSResponse;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:wenchao.yong@ozstrategy.com">Wenchao Yong</a>
 * @version  11/08/2016 14:27
 */
public class EmptyWSResponse implements WSResponse {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  private boolean error = false;

  private String errorMessage = null;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new EmptyWSResponse object.
   */
  public EmptyWSResponse() { }

  /**
   * Creates a new EmptyWSResponse object.
   *
   * @param  error  DOCUMENT ME!
   */
  public EmptyWSResponse(boolean error) {
    this.error = error;
  }

  /**
   * Creates a new EmptyWSResponse object.
   *
   * @param  error         DOCUMENT ME!
   * @param  errorMessage  DOCUMENT ME!
   */
  public EmptyWSResponse(boolean error, String errorMessage) {
    this.error        = error;
    this.errorMessage = errorMessage;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------


  /**
   * @see  com.cmc.credagility.core.domain.webservice.demographics.WSResponse#getDisplayErrorMessage()
   */
  @Override public String getDisplayErrorMessage() {
    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------


  /**
   * @see  com.cmc.credagility.core.domain.webservice.demographics.WSResponse#isError()
   */
  @Override public boolean isError() {
    return error;
  }
} // end class EmptyWSResponse
