package com.cmc.credagility.core.domain.payment;

import java.io.Serializable;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.cmc.credagility.core.domain.type.PaymentResult;


/**
 * Payment result wrapper. It contains the payment result status and payment status code.
 *
 * @author   Ye Zhang
 * @version  $Revision$, $Date$
 */
public class PaymentResultWrapper implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -2021678562170704433L;

  /** TODO: DOCUMENT ME! */
  public static String SUCCESS_CODE = "000000";

  /** TODO: DOCUMENT ME! */
  public static String SUCCESS_WITH_ERROR_CODE = "000001";

  /** TODO: DOCUMENT ME! */
  public static String SUCCESS_WITH_ERROR = "Success with error";

  /** TODO: DOCUMENT ME! */
  public static String INVALID_XML = "XML is invalid";

  /** TODO: DOCUMENT ME! */
  public static String INVALID_XML_CODE = "200001";

  /** TODO: DOCUMENT ME! */
  public static String INVALID_VENDOR = "Vendor verification failed";

  /** TODO: DOCUMENT ME! */
  public static String INVALID_VENDOR_CODE = "200002";

  /** TODO: DOCUMENT ME! */
  public static String INVALID_AMOUNT = "Invalid Payment amount";

  /** TODO: DOCUMENT ME! */
  public static String INVALID_AMOUNT_CODE = "200003";

  /** TODO: DOCUMENT ME! */
  public static String INVALID_ACCTNUM = "Invalid account reference number";

  /** TODO: DOCUMENT ME! */
  public static String INVALID_ACCTNUM_CODE = "200004";

  /** TODO: DOCUMENT ME! */
  public static String DECLINE_INFORMATIONAL = "Informational payment is skipped";

  /** TODO: DOCUMENT ME! */
  public static String DECLINE_INFORMATIONAL_CODE = "200005";

  /** TODO: DOCUMENT ME! */
  public static String INVALID_FUNDACCTNUM = "Invalid funding account number";

  /** TODO: DOCUMENT ME! */
  public static String INVALID_FUNDACCTNUM_CODE = "200006";

  /** TODO: DOCUMENT ME! */
  public static String INVALID_PAYMENT_TYPE = "Invalid payment type";

  /** TODO: DOCUMENT ME! */
  public static String INVALID_PAYMENT_TYPE_CODE = "200007";

  /** TODO: DOCUMENT ME! */
  public static String NEED_CC_NUM = "Need valid credit card number";

  /** TODO: DOCUMENT ME! */
  public static String NEED_CC_NUM_CODE = "200008";

  /** TODO: DOCUMENT ME! */
  public static String NEED_CC_EXPDATE = "Need valid card expiration date";

  /** TODO: DOCUMENT ME! */
  public static String NEED_CC_EXPDATE_CODE = "200009";

  /** TODO: DOCUMENT ME! */
  public static String NEED_BANK_ACCTNUM = "Need valid bank acct number";

  /** TODO: DOCUMENT ME! */
  public static String NEED_BANK_ACCTNUM_CODE = "200010";

  /** TODO: DOCUMENT ME! */
  public static String WRONG_VERSION = "Need a valid version number";

  /** TODO: DOCUMENT ME! */
  public static String WRONG_VERSION_CODE = "200011";

  /** TODO: DOCUMENT ME! */
  public static String NEED_ABA_ROUTING = "Need valid bank acct number";

  /** TODO: DOCUMENT ME! */
  public static String NEED_ABA_ROUTING_CODE = "200012";

  /** TODO: DOCUMENT ME! */
  public static String INVALID_PROGRAM_AMOUNT = "Invalid program amount";

  /** TODO: DOCUMENT ME! */
  public static String INVALID_PROGRAM_AMOUNT_CODE = "200013";

  /** TODO: DOCUMENT ME! */
  public static String INVALID_PROGRAM_DURATION = "Invalid program duration";

  /** TODO: DOCUMENT ME! */
  public static String INVALID_PROGRAM_DURATION_CODE = "200014";

  /** TODO: DOCUMENT ME! */
  public static String FUND_ACCT_REJECTED = "Funding account provided for program rejected";

  /** TODO: DOCUMENT ME! */
  public static String FUND_ACCT_REJECTED_CODE = "200015";

  /** TODO: DOCUMENT ME! */
  public static String PROGRAM_SECURITY = "Program does not belong to account";

  /** TODO: DOCUMENT ME! */
  public static String PROGRAM_SECURITY_CODE = "200016";

  /** TODO: DOCUMENT ME! */
  public static String PROGRAM_EXPIRED = "Program expired";

  /** TODO: DOCUMENT ME! */
  public static String PROGRAM_EXPIRED_CODE = "200017";

  /** TODO: DOCUMENT ME! */
  public static String INVALID_PROGRAM_ID = "Invalid program ID";

  /** TODO: DOCUMENT ME! */
  public static String INVALID_PROGRAM_ID_CODE = "200018";

  /** TODO: DOCUMENT ME! */
  public static String PROGRAM_ACCEPTED = "This program has already been accepted";

  /** TODO: DOCUMENT ME! */
  public static String PROGRAM_ACCEPTED_CODE = "200019";

  /** TODO: DOCUMENT ME! */
  public static String ANOTHER_PROGRAM_ACCEPTED = "Another program has already been accepted";

  /** TODO: DOCUMENT ME! */
  public static String ANOTHER_PROGRAM_ACCEPTED_CODE = "200020";

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private AggregatedPayment aggregatedPayment = null;
  private String            errorDesc;

  private Map<String, String> errorMap = null;

  private Payment          payment          = null;
  private PaymentException paymentException = null;
  private PaymentGroup     paymentGroup     = null;
  private PaymentProgram   paymentProgram   = null;

  private PaymentResult paymentResult = null;
  private Set<Payment>  paymentSet    = new HashSet<Payment>();
  private SplitPayment  splitPayment  = null;
  private String        statusCode    = null;
  private String        statusText    = null;
  private String        version       = "1.0";

  //~ Methods ----------------------------------------------------------------------------------------------------------

  public PaymentResultWrapper() {}

  //~ ------------------------------------------------------------------------------------------------------------------

  public PaymentResultWrapper(PaymentResult paymentResult) {
    this.paymentResult = paymentResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for aggregated payment.
   *
   * @return  AggregatedPayment
   */
  public AggregatedPayment getAggregatedPayment() {
    return aggregatedPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for error desc.
   *
   * @return  String
   */
  public String getErrorDesc() {
    return errorDesc;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Map<String, String> getErrorMap() {
    return errorMap;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Payment getPayment() {
    return payment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PaymentException getPaymentException() {
    return paymentException;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment group.
   *
   * @return  PaymentGroup
   */
  public PaymentGroup getPaymentGroup() {
    return paymentGroup;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PaymentProgram getPaymentProgram() {
    return paymentProgram;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PaymentResult getPaymentResult() {
    return paymentResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment set.
   *
   * @return  Set
   */
  public Set<Payment> getPaymentSet() {
    return paymentSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public SplitPayment getSplitPayment() {
    return splitPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getStatusCode() {
    return statusCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getStatusText() {
    return statusText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getVersion() {
    return version;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isSuccess() {
    return SUCCESS_CODE.equalsIgnoreCase(statusCode);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for aggregated payment.
   *
   * @param  aggregatedPayment  AggregatedPayment
   */
  public void setAggregatedPayment(AggregatedPayment aggregatedPayment) {
    this.aggregatedPayment = aggregatedPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  id  DOCUMENT ME!
   */
  public void setAnotherProgramAlreadyAccepted(String id) {
    setStatusCode(ANOTHER_PROGRAM_ACCEPTED_CODE);
    setStatusText(ANOTHER_PROGRAM_ACCEPTED + " [" + id + "]");
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for error desc.
   *
   * @param  errorDesc  String
   */
  public void setErrorDesc(String errorDesc) {
    this.errorDesc = errorDesc;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  errorMap  DOCUMENT ME!
   */
  public void setErrorMap(Map<String, String> errorMap) {
    this.errorMap = errorMap;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   */
  public void setInformationalDeclined() {
    setStatusCode(DECLINE_INFORMATIONAL_CODE);
    setStatusText(DECLINE_INFORMATIONAL);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  acctNum  DOCUMENT ME!
   */
  public void setInvalidAcctNum(String acctNum) {
    setStatusCode(INVALID_ACCTNUM_CODE);
    setStatusText(INVALID_ACCTNUM + " [" + acctNum + "]");
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  amount  DOCUMENT ME!
   */
  public void setInvalidAmount(String amount) {
    setStatusCode(INVALID_AMOUNT_CODE);
    setStatusText(INVALID_AMOUNT + " [" + amount + "]");
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   */
  public void setInvalidFundingAccount() {
    setStatusCode(FUND_ACCT_REJECTED_CODE);
    setStatusText(FUND_ACCT_REJECTED);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  fundAcctNum  DOCUMENT ME!
   */
  public void setInvalidFundingAcctNum(String fundAcctNum) {
    setStatusCode(INVALID_FUNDACCTNUM_CODE);
    setStatusText(INVALID_FUNDACCTNUM + " [" + fundAcctNum + "]");
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  type  DOCUMENT ME!
   */
  public void setInvalidPaymentType(String type) {
    setStatusCode(INVALID_PAYMENT_TYPE_CODE);
    setStatusText(INVALID_PAYMENT_TYPE + " [" + type + "]");
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  amount  DOCUMENT ME!
   */
  public void setInvalidProgramAmount(String amount) {
    setStatusCode(INVALID_PROGRAM_AMOUNT_CODE);
    setStatusText(INVALID_PROGRAM_AMOUNT + " [" + amount + "]");
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  duration  DOCUMENT ME!
   */
  public void setInvalidProgramDuration(String duration) {
    setStatusCode(INVALID_PROGRAM_DURATION_CODE);
    setStatusText(INVALID_PROGRAM_DURATION + " [" + duration + "]");
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   */
  public void setInvalidProgramId() {
    setStatusCode(INVALID_PROGRAM_ID_CODE);
    setStatusText(INVALID_PROGRAM_ID);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   */
  public void setInvalidProgramSecurity() {
    setStatusCode(PROGRAM_SECURITY_CODE);
    setStatusText(PROGRAM_SECURITY);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  serviceId        DOCUMENT ME!
   * @param  servicePassword  DOCUMENT ME!
   */
  public void setInvalidVendor(String serviceId, String servicePassword) {
    setStatusCode(INVALID_VENDOR_CODE);
    setStatusText(INVALID_VENDOR + "[" + serviceId + "," + servicePassword
      + "]");
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   */
  public void setInvalidXml() {
    setStatusCode(INVALID_XML_CODE);
    setStatusText(INVALID_XML);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   */
  public void setNeedABARoutingNum() {
    setStatusCode(NEED_ABA_ROUTING_CODE);
    setStatusText(NEED_ABA_ROUTING);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   */
  public void setNeedBankAcctNumer() {
    setStatusCode(NEED_BANK_ACCTNUM_CODE);
    setStatusText(NEED_BANK_ACCTNUM);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   */
  public void setNeedCardExpirationDate() {
    setStatusCode(NEED_CC_EXPDATE_CODE);
    setStatusText(NEED_CC_EXPDATE);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   */
  public void setNeedCardNumer() {
    setStatusCode(NEED_CC_NUM_CODE);
    setStatusText(NEED_CC_NUM);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  payment  DOCUMENT ME!
   */
  public void setPayment(Payment payment) {
    this.payment = payment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentException  DOCUMENT ME!
   */
  public void setPaymentException(PaymentException paymentException) {
    this.paymentException = paymentException;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for payment group.
   *
   * @param  paymentGroup  PaymentGroup
   */
  public void setPaymentGroup(PaymentGroup paymentGroup) {
    this.paymentGroup = paymentGroup;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentProgram  DOCUMENT ME!
   */
  public void setPaymentProgram(PaymentProgram paymentProgram) {
    this.paymentProgram = paymentProgram;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentResult  DOCUMENT ME!
   */
  public void setPaymentResult(PaymentResult paymentResult) {
    this.paymentResult = paymentResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for payment set.
   *
   * @param  paymentSet  Set
   */
  public void setPaymentSet(Set<Payment> paymentSet) {
    this.paymentSet = paymentSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  id  DOCUMENT ME!
   */
  public void setProgramAlreadyAccepted(String id) {
    setStatusCode(PROGRAM_ACCEPTED_CODE);
    setStatusText(PROGRAM_ACCEPTED + " [" + id + "]");
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   */
  public void setProgramExpired() {
    setStatusCode(PROGRAM_EXPIRED_CODE);
    setStatusText(PROGRAM_EXPIRED);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  splitPayment  DOCUMENT ME!
   */
  public void setSplitPayment(SplitPayment splitPayment) {
    this.splitPayment = splitPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  statusCode  DOCUMENT ME!
   */
  public void setStatusCode(String statusCode) {
    this.statusCode = statusCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  statusText  DOCUMENT ME!
   */
  public void setStatusText(String statusText) {
    this.statusText = statusText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   */
  public void setSuccess() {
    setStatusCode(SUCCESS_CODE);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  errorCode  DOCUMENT ME!
   */
  public void setSuccessWithError(String errorCode) {
    setStatusCode(SUCCESS_WITH_ERROR_CODE);
    setStatusText(SUCCESS_WITH_ERROR + " [" + errorCode + "]");
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  version  DOCUMENT ME!
   */
  public void setVersion(String version) {
    this.version = version;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  version  DOCUMENT ME!
   */
  public void setWrongVersion(String version) {
    setStatusCode(WRONG_VERSION_CODE);
    setStatusText(WRONG_VERSION + " [" + version + "]");
  }
} // end class PaymentResultWrapper
