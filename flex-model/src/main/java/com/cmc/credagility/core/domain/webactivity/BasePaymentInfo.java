package com.cmc.credagility.core.domain.webactivity;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/16/2014 09:40
 */
public class BasePaymentInfo implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 4161232071888701416L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  protected String fundingAccountId;

  /** TODO: DOCUMENT ME! */
  protected String fundingAccountNickName;

  /** TODO: DOCUMENT ME! */
  protected String installmentId;

  /** TODO: DOCUMENT ME! */
  protected BigDecimal paymentAmount;

  /** TODO: DOCUMENT ME! */
  protected Date paymentDate;

  /** TODO: DOCUMENT ME! */
  protected BigDecimal paymentFee;

  /** TODO: DOCUMENT ME! */
  protected String paymentStatus;

  /** TODO: DOCUMENT ME! */
  protected String programId;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new BasePaymentInfo object.
   */
  public BasePaymentInfo() { }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for funding account id.
   *
   * @return  String
   */
  public String getFundingAccountId() {
    return fundingAccountId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for funding account nick name.
   *
   * @return  String
   */
  public String getFundingAccountNickName() {
    return fundingAccountNickName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for installment id.
   *
   * @return  String
   */
  public String getInstallmentId() {
    return installmentId;
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
   * getter method for payment date.
   *
   * @return  Date
   */
  public Date getPaymentDate() {
    return paymentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment fee.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPaymentFee() {
    return paymentFee;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment status.
   *
   * @return  String
   */
  public String getPaymentStatus() {
    return paymentStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for program id.
   *
   * @return  String
   */
  public String getProgramId() {
    return programId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for funding account id.
   *
   * @param  fundingAccountId  String
   */
  public void setFundingAccountId(String fundingAccountId) {
    this.fundingAccountId = fundingAccountId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for funding account nick name.
   *
   * @param  fundingAccountNickName  String
   */
  public void setFundingAccountNickName(String fundingAccountNickName) {
    this.fundingAccountNickName = fundingAccountNickName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for installment id.
   *
   * @param  installmentId  String
   */
  public void setInstallmentId(String installmentId) {
    this.installmentId = installmentId;
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
   * setter method for payment date.
   *
   * @param  paymentDate  Date
   */
  public void setPaymentDate(Date paymentDate) {
    this.paymentDate = paymentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for payment fee.
   *
   * @param  paymentFee  BigDecimal
   */
  public void setPaymentFee(BigDecimal paymentFee) {
    this.paymentFee = paymentFee;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for payment status.
   *
   * @param  paymentStatus  String
   */
  public void setPaymentStatus(String paymentStatus) {
    this.paymentStatus = paymentStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for program id.
   *
   * @param  programId  String
   */
  public void setProgramId(String programId) {
    this.programId = programId;
  }

} // end class BasePaymentInfo
