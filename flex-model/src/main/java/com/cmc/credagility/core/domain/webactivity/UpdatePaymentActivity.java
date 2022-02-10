package com.cmc.credagility.core.domain.webactivity;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/16/2014 10:01
 */
public class UpdatePaymentActivity extends BaseWebActivity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 6476185409394891554L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  protected String        paymentId;
  private BasePaymentInfo newPaymentInfo;
  private BasePaymentInfo oldPaymentInfo;
  private boolean         partialPayment;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for new payment info.
   *
   * @return  BasePaymentInfo
   */
  public BasePaymentInfo getNewPaymentInfo() {
    return newPaymentInfo;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for old payment info.
   *
   * @return  BasePaymentInfo
   */
  public BasePaymentInfo getOldPaymentInfo() {
    return oldPaymentInfo;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment id.
   *
   * @return  String
   */
  public String getPaymentId() {
    return paymentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for partial payment.
   *
   * @return  boolean
   */
  public boolean isPartialPayment() {
    return partialPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for new payment info.
   *
   * @param  newPaymentInfo  BasePaymentInfo
   */
  public void setNewPaymentInfo(BasePaymentInfo newPaymentInfo) {
    this.newPaymentInfo = newPaymentInfo;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for old payment info.
   *
   * @param  oldPaymentInfo  BasePaymentInfo
   */
  public void setOldPaymentInfo(BasePaymentInfo oldPaymentInfo) {
    this.oldPaymentInfo = oldPaymentInfo;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for partial payment.
   *
   * @param  partialPayment  boolean
   */
  public void setPartialPayment(boolean partialPayment) {
    this.partialPayment = partialPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for payment id.
   *
   * @param  paymentId  String
   */
  public void setPaymentId(String paymentId) {
    this.paymentId = paymentId;
  }

} // end class UpdatePaymentActivity
