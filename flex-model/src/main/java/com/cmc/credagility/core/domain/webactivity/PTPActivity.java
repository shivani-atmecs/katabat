package com.cmc.credagility.core.domain.webactivity;

import java.math.BigDecimal;

import java.text.SimpleDateFormat;

import java.util.Date;

import com.cmc.credagility.core.domain.type.PaymentChannel;
import com.cmc.credagility.core.domain.type.PaymentMethod;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/16/2014 09:49
 */
public class PTPActivity extends BaseWebActivity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 9047516208584543773L;

  /** TODO: DOCUMENT ME! */
  public static SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat(
      "MM/dd/yyyy");

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String         acceptAgentId;
  private BigDecimal     paymentAmount;
  private PaymentChannel paymentChannel;
  private Date           paymentDate;
  private PaymentMethod  paymentMethod;

  private String promiseId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for accept agent id.
   *
   * @return  String
   */
  public String getAcceptAgentId() {
    return acceptAgentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPaymentAmount() {
    return paymentAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment channel.
   *
   * @return  PaymentChannel
   */
  public PaymentChannel getPaymentChannel() {
    return paymentChannel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment date.
   *
   * @return  Date
   */
  public Date getPaymentDate() {
    return paymentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment method.
   *
   * @return  PaymentMethod
   */
  public PaymentMethod getPaymentMethod() {
    return paymentMethod;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for promise id.
   *
   * @return  String
   */
  public String getPromiseId() {
    return promiseId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for accept agent id.
   *
   * @param  acceptAgentId  String
   */
  public void setAcceptAgentId(String acceptAgentId) {
    this.acceptAgentId = acceptAgentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for payment amount.
   *
   * @param  paymentAmount  BigDecimal
   */
  public void setPaymentAmount(BigDecimal paymentAmount) {
    this.paymentAmount = paymentAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for payment amount.
   *
   * @param  amountStr  String
   */
  public void setPaymentAmount(String amountStr) {
    this.paymentAmount = new BigDecimal(amountStr);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for payment channel.
   *
   * @param  paymentChannel  PaymentChannel
   */
  public void setPaymentChannel(PaymentChannel paymentChannel) {
    this.paymentChannel = paymentChannel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for payment date.
   *
   * @param  paymentDate  Date
   */
  public void setPaymentDate(Date paymentDate) {
    this.paymentDate = paymentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for payment date.
   *
   * @param  paymentDateStr  String
   */
  public void setPaymentDate(String paymentDateStr) {
    try {
      this.paymentDate = DATE_FORMATTER.parse(paymentDateStr);
    } catch (Exception e) { }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for payment method.
   *
   * @param  paymentMethod  PaymentMethod
   */
  public void setPaymentMethod(PaymentMethod paymentMethod) {
    this.paymentMethod = paymentMethod;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for promise id.
   *
   * @param  promiseId  String
   */
  public void setPromiseId(String promiseId) {
    this.promiseId = promiseId;
  }

} // end class PTPActivity
