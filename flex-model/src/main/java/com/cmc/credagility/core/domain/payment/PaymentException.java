package com.cmc.credagility.core.domain.payment;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by IntelliJ IDEA. User: knandyala Date: 9/12/11 Time: 1:52 PM To change this template use File | Settings |
 * File Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public class PaymentException {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Exception Message. */
  protected String exceptionMessage;

  /** Has error <code>true</code> contains error. */
  protected boolean hasError;


  /** Payment amount <code>BigDecimal.</code> */
  protected BigDecimal paymentAmount;

  /** The create date of payment. */
  protected Date paymentCreateDate;

  /** Payment ID. */
  protected Long paymentId;


  /** The date of payment schedule. */
  protected Date paymentScheduledDate;


  /** Which user logon in use. */
  protected String userLogon;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /* Constructors */
  public PaymentException() {}

  public PaymentException(Long paymentId, String exceptionMessage) {
    this.paymentId = paymentId;
    this.exceptionMessage = exceptionMessage;
    this.hasError = true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getExceptionMessage() {
    return exceptionMessage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getPaymentAmount() {
    return paymentAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getPaymentCreateDate() {
    return paymentCreateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */

  public Long getPaymentId() {
    return paymentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getPaymentScheduledDate() {
    return paymentScheduledDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getUserLogon() {
    return userLogon;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isHasError() {
    return hasError;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  exceptionMessage  DOCUMENT ME!
   */
  public void setExceptionMessage(String exceptionMessage) {
    this.exceptionMessage = exceptionMessage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  hasError  DOCUMENT ME!
   */
  public void setHasError(boolean hasError) {
    this.hasError = hasError;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentAmount  DOCUMENT ME!
   */
  public void setPaymentAmount(BigDecimal paymentAmount) {
    this.paymentAmount = paymentAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentCreateDate  DOCUMENT ME!
   */
  public void setPaymentCreateDate(Date paymentCreateDate) {
    this.paymentCreateDate = paymentCreateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentId  DOCUMENT ME!
   */
  public void setPaymentId(Long paymentId) {
    this.paymentId = paymentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentScheduledDate  DOCUMENT ME!
   */
  public void setPaymentScheduledDate(Date paymentScheduledDate) {
    this.paymentScheduledDate = paymentScheduledDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  userLogon  DOCUMENT ME!
   */
  public void setUserLogon(String userLogon) {
    this.userLogon = userLogon;
  }

} // end class PaymentException
