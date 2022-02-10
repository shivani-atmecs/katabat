package com.cmc.credagility.core.domain.webactivity;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/16/2014 09:45
 */
public class DeletePaymentActivity extends BaseWebActivity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 7717870162211822780L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  protected String        paymentId;
  private BasePaymentInfo basePaymentInfo = new BasePaymentInfo();
  private boolean         partialPayment;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for base payment info.
   *
   * @return  BasePaymentInfo
   */
  public BasePaymentInfo getBasePaymentInfo() {
    return basePaymentInfo;
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
   * setter method for base payment info.
   *
   * @param  basePaymentInfo  BasePaymentInfo
   */
  public void setBasePaymentInfo(BasePaymentInfo basePaymentInfo) {
    this.basePaymentInfo = basePaymentInfo;
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
} // end class DeletePaymentActivity
