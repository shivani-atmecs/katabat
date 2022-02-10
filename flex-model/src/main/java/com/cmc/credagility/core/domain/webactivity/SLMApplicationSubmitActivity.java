package com.cmc.credagility.core.domain.webactivity;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/16/2014 09:54
 */
public class SLMApplicationSubmitActivity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String accountNumber;
  private String borrowerName;
  private String dateTimeStamp;
  private String formType;
  private String grossMonthlyIncome;
  private String ssn;
  private String transactionType;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for account number.
   *
   * @return  String
   */
  public String getAccountNumber() {
    return accountNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for borrower name.
   *
   * @return  String
   */
  public String getBorrowerName() {
    return borrowerName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for date time stamp.
   *
   * @return  String
   */
  public String getDateTimeStamp() {
    return dateTimeStamp;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for form type.
   *
   * @return  String
   */
  public String getFormType() {
    return formType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for gross monthly income.
   *
   * @return  String
   */
  public String getGrossMonthlyIncome() {
    return grossMonthlyIncome;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ssn.
   *
   * @return  String
   */
  public String getSsn() {
    return ssn;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for transaction type.
   *
   * @return  String
   */
  public String getTransactionType() {
    return transactionType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account number.
   *
   * @param  accountNumber  String
   */
  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for borrower name.
   *
   * @param  borrowerName  String
   */
  public void setBorrowerName(String borrowerName) {
    this.borrowerName = borrowerName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for date time stamp.
   *
   * @param  dateTimeStamp  String
   */
  public void setDateTimeStamp(String dateTimeStamp) {
    this.dateTimeStamp = dateTimeStamp;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for form type.
   *
   * @param  formType  String
   */
  public void setFormType(String formType) {
    this.formType = formType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for gross monthly income.
   *
   * @param  grossMonthlyIncome  String
   */
  public void setGrossMonthlyIncome(String grossMonthlyIncome) {
    this.grossMonthlyIncome = grossMonthlyIncome;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ssn.
   *
   * @param  ssn  String
   */
  public void setSsn(String ssn) {
    this.ssn = ssn;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for transaction type.
   *
   * @param  transactionType  String
   */
  public void setTransactionType(String transactionType) {
    this.transactionType = transactionType;
  }
} // end class SLMApplicationSubmitActivity
