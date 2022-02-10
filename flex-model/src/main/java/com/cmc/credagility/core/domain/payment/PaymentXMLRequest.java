package com.cmc.credagility.core.domain.payment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;

import org.springframework.util.StringUtils;


/**
 * DOCUMENT ME!
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public class PaymentXMLRequest {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String abaNumber;

  private String accountNumber;

  private String address;

  private String addToken;


  private String agree;

  private String amount;

  private String bankAccountNumber;

  private String bankAccountType;

  private String cardNumber;

  private String cvv;

  private String cvvIndicator;

  private String ecommIndicator;

  private String emailAddress;

  private String entryClass;

  private String expDate;

  private String expMonth;

  private String expYear;

  private String firstName;


  private String lastName;


  private String merchantId;

  private String merchantInitiated;

  private String MerchantTxnId;

  private String nickName;

  private String partnerId;

  private String paymentDate;

  private String pin;


  private String productCode;

  private String state;

  private String testMode;

  private String token;


  private String transactionType;

  private String userId;

  private String vendorId;

  private String zip;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getAbaNumber() {
    return abaNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getAccountNumber() {
    return accountNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getAddress() {
    return address;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getAddToken() {
    return addToken;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getAgree() {
    return agree;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getAmount() {
    return amount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getBankAccountNumber() {
    return bankAccountNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getBankAccountType() {
    return bankAccountType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getCardNumber() {
    return cardNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getCvv() {
    return cvv;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getCvvIndicator() {
    return cvvIndicator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getEcommIndicator() {
    return ecommIndicator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getEmailAddress() {
    return emailAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getEntryClass() {
    return entryClass;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getExpDate() {
    return expDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getExpMonth() {
    return expMonth;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getExpYear() {
    return expYear;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getFirstName() {
    return firstName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getLastName() {
    return lastName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getMerchantId() {
    return merchantId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getMerchantInitiated() {
    return merchantInitiated;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getMerchantTxnId() {
    return MerchantTxnId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getNickName() {
    return nickName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPartnerId() {
    return partnerId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPaymentDate() {
    return paymentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPin() {
    return pin;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getProductCode() {
    return productCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getState() {
    return state;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTestMode() {
    return testMode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getToken() {
    return token;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTransactionType() {
    return transactionType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getUserId() {
    return userId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getVendorId() {
    return vendorId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getZip() {
    return zip;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  abaNumber  DOCUMENT ME!
   */
  public void setAbaNumber(String abaNumber) {
    this.abaNumber = abaNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  accountNumber  DOCUMENT ME!
   */
  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  address  DOCUMENT ME!
   */
  public void setAddress(String address) {
    this.address = address;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  addToken  DOCUMENT ME!
   */
  public void setAddToken(String addToken) {
    this.addToken = addToken;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  agree  DOCUMENT ME!
   */
  public void setAgree(String agree) {
    this.agree = agree;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  amount  DOCUMENT ME!
   */
  public void setAmount(String amount) {
    this.amount = amount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  bankAccountNumber  DOCUMENT ME!
   */
  public void setBankAccountNumber(String bankAccountNumber) {
    this.bankAccountNumber = bankAccountNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  bankAccountType  DOCUMENT ME!
   */
  public void setBankAccountType(String bankAccountType) {
    this.bankAccountType = bankAccountType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  cardNumber  DOCUMENT ME!
   */
  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  cvv  DOCUMENT ME!
   */
  public void setCvv(String cvv) {
    this.cvv = cvv;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  cvvIndicator  DOCUMENT ME!
   */
  public void setCvvIndicator(String cvvIndicator) {
    this.cvvIndicator = cvvIndicator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  ecommIndicator  DOCUMENT ME!
   */
  public void setEcommIndicator(String ecommIndicator) {
    this.ecommIndicator = ecommIndicator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  emailAddress  DOCUMENT ME!
   */
  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  entryClass  DOCUMENT ME!
   */
  public void setEntryClass(String entryClass) {
    this.entryClass = entryClass;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  expDate  DOCUMENT ME!
   */
  public void setExpDate(String expDate) {
    this.expDate = expDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  expMonth  DOCUMENT ME!
   */
  public void setExpMonth(String expMonth) {
    this.expMonth = expMonth;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  expDate  DOCUMENT ME!
   * @param  pattern  DOCUMENT ME!
   */
  public void setExpMonth(Date expDate, String pattern) {
    DateFormat monthFormat = new SimpleDateFormat(pattern);

    if (StringUtils.hasText(pattern)) {
      monthFormat = new SimpleDateFormat(pattern);
    } else {
      monthFormat = new SimpleDateFormat("MM");
    }

    String month = monthFormat.format(expDate);
    this.expMonth = month;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  expYear  DOCUMENT ME!
   */
  public void setExpYear(String expYear) {
    this.expYear = expYear;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  expDate  DOCUMENT ME!
   * @param  pattern  DOCUMENT ME!
   */
  public void setExpYear(Date expDate, String pattern) {
    DateFormat yearFormat = null;

    if (StringUtils.hasText(pattern)) {
      yearFormat = new SimpleDateFormat(pattern);
    } else {
      yearFormat = new SimpleDateFormat("yyyy");
    }

    String year = yearFormat.format(expDate);
    this.expYear = year;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  firstName  DOCUMENT ME!
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  lastName  DOCUMENT ME!
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  merchantId  DOCUMENT ME!
   */
  public void setMerchantId(String merchantId) {
    this.merchantId = merchantId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  merchantInitiated  DOCUMENT ME!
   */
  public void setMerchantInitiated(String merchantInitiated) {
    this.merchantInitiated = merchantInitiated;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  merchantTxnId  DOCUMENT ME!
   */
  public void setMerchantTxnId(String merchantTxnId) {
    MerchantTxnId = merchantTxnId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  nickName  DOCUMENT ME!
   */
  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  partnerId  DOCUMENT ME!
   */
  public void setPartnerId(String partnerId) {
    this.partnerId = partnerId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentDate  DOCUMENT ME!
   */
  public void setPaymentDate(String paymentDate) {
    this.paymentDate = paymentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  pin  DOCUMENT ME!
   */
  public void setPin(String pin) {
    this.pin = pin;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  productCode  DOCUMENT ME!
   */
  public void setProductCode(String productCode) {
    this.productCode = productCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  state  DOCUMENT ME!
   */
  public void setState(String state) {
    this.state = state;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  testMode  DOCUMENT ME!
   */
  public void setTestMode(String testMode) {
    this.testMode = testMode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  token  DOCUMENT ME!
   */
  public void setToken(String token) {
    this.token = token;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  transactionType  DOCUMENT ME!
   */
  public void setTransactionType(String transactionType) {
    this.transactionType = transactionType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  userId  DOCUMENT ME!
   */
  public void setUserId(String userId) {
    this.userId = userId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  vendorId  DOCUMENT ME!
   */
  public void setVendorId(String vendorId) {
    this.vendorId = vendorId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  zip  DOCUMENT ME!
   */
  public void setZip(String zip) {
    this.zip = zip;
  }
} // end class PaymentXMLRequest
