package com.cmc.credagility.core.domain.barclay;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;
import com.cmc.credagility.core.jpa.converter.StringEncryptionConverter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 10:27
 */
@Entity
@Table(
  name    = "BarclayAccount",
  indexes = {
    @Index(
      columnList = "additionalCardNumberHash",
      name = "additionalCardNumberHashIndex"
    ),
    @Index(
      columnList = "barclayAccountIdentifierHash",
      name = "barclayAccountIdentifierHashIndex"
    )
  }
)
public class BarclayAccount extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -2579077120055286860L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "accountNum",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @OneToOne(cascade = CascadeType.ALL)
  protected Account account;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "activePlanIndicator",
    length = 1
  )
  protected String activePlanIndicator;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "additionalCardNumber",
    length   = 150,
    nullable = true
  )
  @Convert(converter = StringEncryptionConverter.class)
  protected String additionalCardNumber;

  /** TODO: DOCUMENT ME! */
  @Column(
    length   = 200,
    nullable = true,
    name     = "additionalCardNumberHash"
  )
  protected String additionalCardNumberHash;

  /** TODO: DOCUMENT ME! */
  @Column(
    length   = 20,
    nullable = true,
    name     = "additionalCardProductCode"
  )
  protected String additionalCardProductCode;


  /** TODO: DOCUMENT ME! */
  @Column(name = "alertSegment")
  protected BigDecimal alertSegment;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "bankDetails",
    length = 50
  )
  protected String bankDetails;

  /** Barclay Account id PK. */
  @Column(name = "barclayAccountId")
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long barclayAccountId;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "barclayAccountIdentifier",
    length   = 150,
    nullable = false
  )
  @Convert(converter = StringEncryptionConverter.class)
  protected String barclayAccountIdentifier;

  /** TODO: DOCUMENT ME! */
  @Column(
    length   = 200,
    nullable = false,
    name     = "barclayAccountIdentifierHash"
  )
  protected String barclayAccountIdentifierHash;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "barclayAllowWeb",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean barclayAllowWeb;

  /** TODO: DOCUMENT ME! */
  @Column(
    length = 10,
    name   = "barclayProgramCode"
  )
  protected String barclayProgramCode;

  /** TODO: DOCUMENT ME! */
  @Column(name = "baselModelSegmentIndicator")
  protected BigDecimal baselModelSegmentIndicator;

  /** TODO: DOCUMENT ME! */
  @Column(name = "bblProgramAcceptDate")
  protected Date bblProgramAcceptDate;

  /** TODO: DOCUMENT ME! */
  @Column(name = "cii2")
  protected BigDecimal cii2;


  /** TODO: DOCUMENT ME! */
  @Column(name = "cumPmntLast3Mnth")
  protected BigDecimal cumPmntLast3Mnth;


  /** TODO: DOCUMENT ME! */
  @Column(name = "cumPmntSinceCO")
  protected BigDecimal cumPmntSinceCO;


  /** TODO: DOCUMENT ME! */
  @Column(name = "currentReageAmount")
  protected BigDecimal currentReageAmount;


  /** TODO: DOCUMENT ME! */
  @Column(name = "dateCanReage")
  protected Date dateCanReage;

  /** TODO: DOCUMENT ME! */
  @Column(name = "expectedLoss")
  protected BigDecimal expectedLoss;

  /** TODO: DOCUMENT ME! */
  @Column(name = "extRepPlan")
  protected BigDecimal extRepPlan;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "fipCreatedBy",
    length = 30
  )
  protected String fipCreatedBy;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "hasBarclayProgram",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean hasBarclayProgram;


  /** TODO: DOCUMENT ME! */
  @Column(name = "insurancePremium")
  protected BigDecimal insurancePremium;

  /** TODO: DOCUMENT ME! */
  @Column(name = "insurancePremiumPercentage")
  protected BigDecimal insurancePremiumPercentage;


  /** TODO: DOCUMENT ME! */
  @Column(
    length = 50,
    name   = "logicalAcctId"
  )
  protected String logicalAcctId;

  /** TODO: DOCUMENT ME! */
  @Column(name = "matchPayLast6Mnth")
  protected BigDecimal matchPayLast6Mnth;

  /** TODO: DOCUMENT ME! */
  @Column(name = "outBalForCAISAcct")
  protected BigDecimal outBalForCAISAcct;


  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "paymentProtectionInsurance",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean paymentProtectionInsurance;

  /** TODO: DOCUMENT ME! */
  @Column(name = "pdBarLiveAdj")
  protected BigDecimal pdBarLiveAdj;

  /** TODO: DOCUMENT ME! */
  @Column(name = "pdLiveAdj")
  protected BigDecimal pdLiveAdj;

  /** TODO: DOCUMENT ME! */
  @Column(name = "planAcceptDate")
  protected Date planAcceptDate;

  /** TODO: DOCUMENT ME! */
  @Column(name = "planDate1")
  protected Date planDate1;

  /** TODO: DOCUMENT ME! */
  @Column(name = "planDate2")
  protected Date planDate2;

  /** TODO: DOCUMENT ME! */
  @Column(name = "planDate3")
  protected Date planDate3;

  /** TODO: DOCUMENT ME! */
  @Column(name = "planDate4")
  protected Date planDate4;

  /** TODO: DOCUMENT ME! */
  @Column(name = "pmntInLast18Mnth")
  protected BigDecimal pmntInLast18Mnth;

  /** TODO: DOCUMENT ME! */
  @Column(name = "pmntsInLast3Mnth")
  protected BigDecimal pmntsInLast3Mnth;

  /** TODO: DOCUMENT ME! */
  @Column(name = "productMinimumPercentage")
  protected BigDecimal productMinimumPercentage;

  /** TODO: DOCUMENT ME! */
  @Column(name = "propensToPay")
  protected BigDecimal propensToPay;

  /** TODO: DOCUMENT ME! */
  @Column(name = "recBookPayAmount")
  protected BigDecimal recBookPayAmount;

  /** TODO: DOCUMENT ME! */
  @Column(name = "recBookPayProb")
  protected BigDecimal recBookPayProb;

  /** TODO: DOCUMENT ME! */
  @Column(name = "recOfPmntImpCust")
  protected BigDecimal recOfPmntImpCust;

  /** TODO: DOCUMENT ME! */
  @Column(name = "recPayExpectedPay")
  protected BigDecimal recPayExpectedPay;

  /** TODO: DOCUMENT ME! */
  @Column(name = "recPayExpectedPmnt")
  protected BigDecimal recPayExpectedPmnt;

  /** TODO: DOCUMENT ME! */
  @Column(name = "revolvingDebtRatio")
  protected BigDecimal revolvingDebtRatio;

  /** TODO: DOCUMENT ME! */
  @Column(name = "revPmntLast3Mnth")
  protected BigDecimal revPmntLast3Mnth;

  /** TODO: DOCUMENT ME! */
  @Column(name = "rightPartyContact")
  protected BigDecimal rightPartyContact;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "routerAccountNumber",
    nullable = false
  )
  protected Long routerAccountNumber;

  /** TODO: DOCUMENT ME! */
  @Column(name = "routerSequence")
  protected BigDecimal routerSequence;

  /** TODO: DOCUMENT ME! */
  @Column(
    length = 10,
    name   = "routerType"
  )
  protected String routerType;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "sendToCMC",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean sendToCMC;

  /** TODO: DOCUMENT ME! */
  @Column(
    length = 50,
    name   = "subProdLevel3"
  )
  protected String subProdLevel3;

  /** TODO: DOCUMENT ME! */
  @Column(name = "timeOnBook")
  protected BigDecimal timeOnBook;

  /** TODO: DOCUMENT ME! */
  @Column(name = "timeSinceLastIBRPC")
  protected BigDecimal timeSinceLastIBRPC;

  /** TODO: DOCUMENT ME! */
  @Column(name = "timeSinceLastOBRPC")
  protected BigDecimal timeSinceLastOBRPC;

  /** TODO: DOCUMENT ME! */
  @Column(name = "timeSinceLastPTP")
  protected BigDecimal timeSinceLastPTP;

  /** TODO: DOCUMENT ME! */
  @Column(name = "timesSinceIBRPC")
  protected BigDecimal timesSinceIBRPC;

  /** TODO: DOCUMENT ME! */
  @Column(name = "timesSinceOBRPC")
  protected BigDecimal timesSinceOBRPC;

  /** TODO: DOCUMENT ME! */
  @Column(
    length = 50,
    name   = "traceFlag"
  )
  protected String traceFlag;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "triumphAccountNumber",
    length   = 150,
    nullable = true
  )
  @Convert(converter = StringEncryptionConverter.class)
  protected String triumphAccountNumber;

  /** TODO: DOCUMENT ME! */
  @Column(
    length   = 200,
    nullable = false,
    name     = "triumphAccountNumberHash"
  )
  protected String triumphAccountNumberHash;

  /** TODO: DOCUMENT ME! */
  @Column(name = "writeOffAmount")
  protected BigDecimal writeOffAmount;

  /** TODO: DOCUMENT ME! */
  @Column(name = "writeOffDate")
  protected Date writeOffDate;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for account.
   *
   * @return  Account
   */
  public Account getAccount() {
    return account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for active plan indicator.
   *
   * @return  String
   */
  public String getActivePlanIndicator() {
    return activePlanIndicator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for additional card number.
   *
   * @return  String
   */
  public String getAdditionalCardNumber() {
    return additionalCardNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for additional card number hash.
   *
   * @return  String
   */
  public String getAdditionalCardNumberHash() {
    return additionalCardNumberHash;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for additional card product code.
   *
   * @return  String
   */
  public String getAdditionalCardProductCode() {
    return additionalCardProductCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for alert segment.
   *
   * @return  BigDecimal
   */
  public BigDecimal getAlertSegment() {
    return alertSegment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bank details.
   *
   * @return  String
   */
  public String getBankDetails() {
    return bankDetails;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for barclay account id.
   *
   * @return  Long
   */
  public Long getBarclayAccountId() {
    return barclayAccountId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for barclay account identifier.
   *
   * @return  String
   */
  public String getBarclayAccountIdentifier() {
    return barclayAccountIdentifier;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for barclay account identifier hash.
   *
   * @return  String
   */
  public String getBarclayAccountIdentifierHash() {
    return barclayAccountIdentifierHash;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for barclay allow web.
   *
   * @return  Boolean
   */
  public Boolean getBarclayAllowWeb() {
    return barclayAllowWeb;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for barclay program code.
   *
   * @return  String
   */
  public String getBarclayProgramCode() {
    return barclayProgramCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for basel model segment indicator.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBaselModelSegmentIndicator() {
    return baselModelSegmentIndicator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bbl program accept date.
   *
   * @return  Date
   */
  public Date getBblProgramAcceptDate() {
    return bblProgramAcceptDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for cii2.
   *
   * @return  BigDecimal
   */
  public BigDecimal getCii2() {
    return cii2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for cum pmnt last3 mnth.
   *
   * @return  BigDecimal
   */
  public BigDecimal getCumPmntLast3Mnth() {
    return cumPmntLast3Mnth;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for cum pmnt since CO.
   *
   * @return  BigDecimal
   */
  public BigDecimal getCumPmntSinceCO() {
    return cumPmntSinceCO;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for current reage amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getCurrentReageAmount() {
    return currentReageAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for date can reage.
   *
   * @return  Date
   */
  public Date getDateCanReage() {
    return dateCanReage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for expected loss.
   *
   * @return  BigDecimal
   */
  public BigDecimal getExpectedLoss() {
    return expectedLoss;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ext rep plan.
   *
   * @return  BigDecimal
   */
  public BigDecimal getExtRepPlan() {
    return extRepPlan;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for fip created by.
   *
   * @return  String
   */
  public String getFipCreatedBy() {
    return fipCreatedBy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for has barclay program.
   *
   * @return  Boolean
   */
  public Boolean getHasBarclayProgram() {
    if (hasBarclayProgram == null) {
      return Boolean.FALSE;
    }

    return hasBarclayProgram;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for insurance premium.
   *
   * @return  BigDecimal
   */
  public BigDecimal getInsurancePremium() {
    return insurancePremium;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for insurance premium percentage.
   *
   * @return  BigDecimal
   */
  public BigDecimal getInsurancePremiumPercentage() {
    return insurancePremiumPercentage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for logical acct id.
   *
   * @return  String
   */
  public String getLogicalAcctId() {
    return logicalAcctId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for match pay last6 mnth.
   *
   * @return  BigDecimal
   */
  public BigDecimal getMatchPayLast6Mnth() {
    return matchPayLast6Mnth;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for out bal for CAISAcct.
   *
   * @return  BigDecimal
   */
  public BigDecimal getOutBalForCAISAcct() {
    return outBalForCAISAcct;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment protection insurance.
   *
   * @return  Boolean
   */
  public Boolean getPaymentProtectionInsurance() {
    return paymentProtectionInsurance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for pd bar live adj.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPdBarLiveAdj() {
    return pdBarLiveAdj;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for pd live adj.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPdLiveAdj() {
    return pdLiveAdj;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for plan accept date.
   *
   * @return  Date
   */
  public Date getPlanAcceptDate() {
    return planAcceptDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for plan date1.
   *
   * @return  Date
   */
  public Date getPlanDate1() {
    return planDate1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for plan date2.
   *
   * @return  Date
   */
  public Date getPlanDate2() {
    return planDate2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for plan date3.
   *
   * @return  Date
   */
  public Date getPlanDate3() {
    return planDate3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for plan date4.
   *
   * @return  Date
   */
  public Date getPlanDate4() {
    return planDate4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for pmnt in last18 mnth.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPmntInLast18Mnth() {
    return pmntInLast18Mnth;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for pmnts in last3 mnth.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPmntsInLast3Mnth() {
    return pmntsInLast3Mnth;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for product minimum percentage.
   *
   * @return  BigDecimal
   */
  public BigDecimal getProductMinimumPercentage() {
    return productMinimumPercentage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for propens to pay.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPropensToPay() {
    return propensToPay;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for rec book pay amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getRecBookPayAmount() {
    return recBookPayAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for rec book pay prob.
   *
   * @return  BigDecimal
   */
  public BigDecimal getRecBookPayProb() {
    return recBookPayProb;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for rec of pmnt imp cust.
   *
   * @return  BigDecimal
   */
  public BigDecimal getRecOfPmntImpCust() {
    return recOfPmntImpCust;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for rec pay expected pay.
   *
   * @return  BigDecimal
   */
  public BigDecimal getRecPayExpectedPay() {
    return recPayExpectedPay;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for rec pay expected pmnt.
   *
   * @return  BigDecimal
   */
  public BigDecimal getRecPayExpectedPmnt() {
    return recPayExpectedPmnt;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for revolving debt ratio.
   *
   * @return  BigDecimal
   */
  public BigDecimal getRevolvingDebtRatio() {
    return revolvingDebtRatio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for rev pmnt last3 mnth.
   *
   * @return  BigDecimal
   */
  public BigDecimal getRevPmntLast3Mnth() {
    return revPmntLast3Mnth;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for right party contact.
   *
   * @return  BigDecimal
   */
  public BigDecimal getRightPartyContact() {
    return rightPartyContact;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for router account number.
   *
   * @return  Long
   */
  public Long getRouterAccountNumber() {
    return routerAccountNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for router sequence.
   *
   * @return  BigDecimal
   */
  public BigDecimal getRouterSequence() {
    return routerSequence;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for router type.
   *
   * @return  String
   */
  public String getRouterType() {
    return routerType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for send to CMC.
   *
   * @return  Boolean
   */
  public Boolean getSendToCMC() {
    return sendToCMC;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for sub prod level3.
   *
   * @return  String
   */
  public String getSubProdLevel3() {
    return subProdLevel3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for time on book.
   *
   * @return  BigDecimal
   */
  public BigDecimal getTimeOnBook() {
    return timeOnBook;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for time since last IBRPC.
   *
   * @return  BigDecimal
   */
  public BigDecimal getTimeSinceLastIBRPC() {
    return timeSinceLastIBRPC;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for time since last OBRPC.
   *
   * @return  BigDecimal
   */
  public BigDecimal getTimeSinceLastOBRPC() {
    return timeSinceLastOBRPC;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for time since last PTP.
   *
   * @return  BigDecimal
   */
  public BigDecimal getTimeSinceLastPTP() {
    return timeSinceLastPTP;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for times since IBRPC.
   *
   * @return  BigDecimal
   */
  public BigDecimal getTimesSinceIBRPC() {
    return timesSinceIBRPC;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for times since OBRPC.
   *
   * @return  BigDecimal
   */
  public BigDecimal getTimesSinceOBRPC() {
    return timesSinceOBRPC;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for trace flag.
   *
   * @return  String
   */
  public String getTraceFlag() {
    return traceFlag;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for triumph account number.
   *
   * @return  String
   */
  public String getTriumphAccountNumber() {
    return triumphAccountNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for triumph account number hash.
   *
   * @return  String
   */
  public String getTriumphAccountNumberHash() {
    return triumphAccountNumberHash;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for write off amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getWriteOffAmount() {
    return writeOffAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for write off date.
   *
   * @return  Date
   */
  public Date getWriteOffDate() {
    return writeOffDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = 1;
    result = (prime * result)
      + (StringUtils.isEmpty(this.barclayAccountIdentifier) ? 0 : this.barclayAccountIdentifier.hashCode());
    result = (prime * result)
      + ((this.createDate == null) ? 0 : this.createDate.hashCode());
    result = (prime * result)
      + ((this.routerAccountNumber == null) ? 0 : this.routerAccountNumber.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account.
   *
   * @param  account  Account
   */
  public void setAccount(Account account) {
    this.account = account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for active plan indicator.
   *
   * @param  activePlanIndicator  String
   */
  public void setActivePlanIndicator(String activePlanIndicator) {
    this.activePlanIndicator = activePlanIndicator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for additional card number.
   *
   * @param  additionalCardNumber  String
   */
  public void setAdditionalCardNumber(String additionalCardNumber) {
    this.additionalCardNumber = additionalCardNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for additional card number hash.
   *
   * @param  additionalCardNumberHash  String
   */
  public void setAdditionalCardNumberHash(String additionalCardNumberHash) {
    this.additionalCardNumberHash = additionalCardNumberHash;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for additional card product code.
   *
   * @param  additionalCardProductCode  String
   */
  public void setAdditionalCardProductCode(String additionalCardProductCode) {
    this.additionalCardProductCode = additionalCardProductCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for alert segment.
   *
   * @param  alertSegment  BigDecimal
   */
  public void setAlertSegment(BigDecimal alertSegment) {
    this.alertSegment = alertSegment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bank details.
   *
   * @param  bankDetails  String
   */
  public void setBankDetails(String bankDetails) {
    this.bankDetails = bankDetails;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for barclay account id.
   *
   * @param  barclayAccountId  Long
   */
  public void setBarclayAccountId(Long barclayAccountId) {
    this.barclayAccountId = barclayAccountId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for barclay account identifier.
   *
   * @param  barclayAccountIdentifier  String
   */
  public void setBarclayAccountIdentifier(String barclayAccountIdentifier) {
    this.barclayAccountIdentifier = barclayAccountIdentifier;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for barclay account identifier hash.
   *
   * @param  barclayAccountIdentifierHash  String
   */
  public void setBarclayAccountIdentifierHash(String barclayAccountIdentifierHash) {
    this.barclayAccountIdentifierHash = barclayAccountIdentifierHash;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for barclay allow web.
   *
   * @param  barclayAllowWeb  Boolean
   */
  public void setBarclayAllowWeb(Boolean barclayAllowWeb) {
    this.barclayAllowWeb = barclayAllowWeb;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for barclay program code.
   *
   * @param  barclayProgramCode  String
   */
  public void setBarclayProgramCode(String barclayProgramCode) {
    this.barclayProgramCode = barclayProgramCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for basel model segment indicator.
   *
   * @param  baselModelSegmentIndicator  BigDecimal
   */
  public void setBaselModelSegmentIndicator(BigDecimal baselModelSegmentIndicator) {
    this.baselModelSegmentIndicator = baselModelSegmentIndicator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bbl program accept date.
   *
   * @param  bblProgramAcceptDate  Date
   */
  public void setBblProgramAcceptDate(Date bblProgramAcceptDate) {
    this.bblProgramAcceptDate = bblProgramAcceptDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for cii2.
   *
   * @param  cii2  BigDecimal
   */
  public void setCii2(BigDecimal cii2) {
    this.cii2 = cii2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for cum pmnt last3 mnth.
   *
   * @param  cumPmntLast3Mnth  BigDecimal
   */
  public void setCumPmntLast3Mnth(BigDecimal cumPmntLast3Mnth) {
    this.cumPmntLast3Mnth = cumPmntLast3Mnth;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for cum pmnt since CO.
   *
   * @param  cumPmntSinceCO  BigDecimal
   */
  public void setCumPmntSinceCO(BigDecimal cumPmntSinceCO) {
    this.cumPmntSinceCO = cumPmntSinceCO;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for current reage amount.
   *
   * @param  currentReageAmount  BigDecimal
   */
  public void setCurrentReageAmount(BigDecimal currentReageAmount) {
    this.currentReageAmount = currentReageAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for date can reage.
   *
   * @param  dateCanReage  Date
   */
  public void setDateCanReage(Date dateCanReage) {
    this.dateCanReage = dateCanReage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for expected loss.
   *
   * @param  expectedLoss  BigDecimal
   */
  public void setExpectedLoss(BigDecimal expectedLoss) {
    this.expectedLoss = expectedLoss;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ext rep plan.
   *
   * @param  extRepPlan  BigDecimal
   */
  public void setExtRepPlan(BigDecimal extRepPlan) {
    this.extRepPlan = extRepPlan;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for fip created by.
   *
   * @param  fipCreatedBy  String
   */
  public void setFipCreatedBy(String fipCreatedBy) {
    this.fipCreatedBy = fipCreatedBy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for has barclay program.
   *
   * @param  hasBarclayProgram  Boolean
   */
  public void setHasBarclayProgram(Boolean hasBarclayProgram) {
    this.hasBarclayProgram = hasBarclayProgram;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for insurance premium.
   *
   * @param  insurancePremium  BigDecimal
   */
  public void setInsurancePremium(BigDecimal insurancePremium) {
    this.insurancePremium = insurancePremium;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for insurance premium percentage.
   *
   * @param  insurancePremiumPercentage  BigDecimal
   */
  public void setInsurancePremiumPercentage(BigDecimal insurancePremiumPercentage) {
    this.insurancePremiumPercentage = insurancePremiumPercentage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for logical acct id.
   *
   * @param  logicalAcctId  String
   */
  public void setLogicalAcctId(String logicalAcctId) {
    this.logicalAcctId = logicalAcctId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for match pay last6 mnth.
   *
   * @param  matchPayLast6Mnth  BigDecimal
   */
  public void setMatchPayLast6Mnth(BigDecimal matchPayLast6Mnth) {
    this.matchPayLast6Mnth = matchPayLast6Mnth;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for out bal for CAISAcct.
   *
   * @param  outBalForCAISAcct  BigDecimal
   */
  public void setOutBalForCAISAcct(BigDecimal outBalForCAISAcct) {
    this.outBalForCAISAcct = outBalForCAISAcct;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for payment protection insurance.
   *
   * @param  paymentProtectionInsurance  Boolean
   */
  public void setPaymentProtectionInsurance(Boolean paymentProtectionInsurance) {
    this.paymentProtectionInsurance = paymentProtectionInsurance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for pd bar live adj.
   *
   * @param  pdBarLiveAdj  BigDecimal
   */
  public void setPdBarLiveAdj(BigDecimal pdBarLiveAdj) {
    this.pdBarLiveAdj = pdBarLiveAdj;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for pd live adj.
   *
   * @param  pdLiveAdj  BigDecimal
   */
  public void setPdLiveAdj(BigDecimal pdLiveAdj) {
    this.pdLiveAdj = pdLiveAdj;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for plan accept date.
   *
   * @param  planAcceptDate  Date
   */
  public void setPlanAcceptDate(Date planAcceptDate) {
    this.planAcceptDate = planAcceptDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for plan date1.
   *
   * @param  planDate1  Date
   */
  public void setPlanDate1(Date planDate1) {
    this.planDate1 = planDate1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for plan date2.
   *
   * @param  planDate2  Date
   */
  public void setPlanDate2(Date planDate2) {
    this.planDate2 = planDate2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for plan date3.
   *
   * @param  planDate3  Date
   */
  public void setPlanDate3(Date planDate3) {
    this.planDate3 = planDate3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for plan date4.
   *
   * @param  planDate4  Date
   */
  public void setPlanDate4(Date planDate4) {
    this.planDate4 = planDate4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for pmnt in last18 mnth.
   *
   * @param  pmntInLast18Mnth  BigDecimal
   */
  public void setPmntInLast18Mnth(BigDecimal pmntInLast18Mnth) {
    this.pmntInLast18Mnth = pmntInLast18Mnth;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for pmnts in last3 mnth.
   *
   * @param  pmntsInLast3Mnth  BigDecimal
   */
  public void setPmntsInLast3Mnth(BigDecimal pmntsInLast3Mnth) {
    this.pmntsInLast3Mnth = pmntsInLast3Mnth;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for product minimum percentage.
   *
   * @param  productMinimumPercentage  BigDecimal
   */
  public void setProductMinimumPercentage(BigDecimal productMinimumPercentage) {
    this.productMinimumPercentage = productMinimumPercentage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for propens to pay.
   *
   * @param  propensToPay  BigDecimal
   */
  public void setPropensToPay(BigDecimal propensToPay) {
    this.propensToPay = propensToPay;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for rec book pay amount.
   *
   * @param  recBookPayAmount  BigDecimal
   */
  public void setRecBookPayAmount(BigDecimal recBookPayAmount) {
    this.recBookPayAmount = recBookPayAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for rec book pay prob.
   *
   * @param  recBookPayProb  BigDecimal
   */
  public void setRecBookPayProb(BigDecimal recBookPayProb) {
    this.recBookPayProb = recBookPayProb;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for rec of pmnt imp cust.
   *
   * @param  recOfPmntImpCust  BigDecimal
   */
  public void setRecOfPmntImpCust(BigDecimal recOfPmntImpCust) {
    this.recOfPmntImpCust = recOfPmntImpCust;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for rec pay expected pay.
   *
   * @param  recPayExpectedPay  BigDecimal
   */
  public void setRecPayExpectedPay(BigDecimal recPayExpectedPay) {
    this.recPayExpectedPay = recPayExpectedPay;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for rec pay expected pmnt.
   *
   * @param  recPayExpectedPmnt  BigDecimal
   */
  public void setRecPayExpectedPmnt(BigDecimal recPayExpectedPmnt) {
    this.recPayExpectedPmnt = recPayExpectedPmnt;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for revolving debt ratio.
   *
   * @param  revolvingDebtRatio  BigDecimal
   */
  public void setRevolvingDebtRatio(BigDecimal revolvingDebtRatio) {
    this.revolvingDebtRatio = revolvingDebtRatio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for rev pmnt last3 mnth.
   *
   * @param  revPmntLast3Mnth  BigDecimal
   */
  public void setRevPmntLast3Mnth(BigDecimal revPmntLast3Mnth) {
    this.revPmntLast3Mnth = revPmntLast3Mnth;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for right party contact.
   *
   * @param  rightPartyContact  BigDecimal
   */
  public void setRightPartyContact(BigDecimal rightPartyContact) {
    this.rightPartyContact = rightPartyContact;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for router account number.
   *
   * @param  routerAccountNumber  Long
   */
  public void setRouterAccountNumber(Long routerAccountNumber) {
    this.routerAccountNumber = routerAccountNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for router sequence.
   *
   * @param  routerSequence  BigDecimal
   */
  public void setRouterSequence(BigDecimal routerSequence) {
    this.routerSequence = routerSequence;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for router type.
   *
   * @param  routerType  String
   */
  public void setRouterType(String routerType) {
    this.routerType = routerType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for send to CMC.
   *
   * @param  sendToCMC  Boolean
   */
  public void setSendToCMC(Boolean sendToCMC) {
    this.sendToCMC = sendToCMC;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for sub prod level3.
   *
   * @param  subProdLevel3  String
   */
  public void setSubProdLevel3(String subProdLevel3) {
    this.subProdLevel3 = subProdLevel3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for time on book.
   *
   * @param  timeOnBook  BigDecimal
   */
  public void setTimeOnBook(BigDecimal timeOnBook) {
    this.timeOnBook = timeOnBook;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for time since last IBRPC.
   *
   * @param  timeSinceLastIBRPC  BigDecimal
   */
  public void setTimeSinceLastIBRPC(BigDecimal timeSinceLastIBRPC) {
    this.timeSinceLastIBRPC = timeSinceLastIBRPC;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for time since last OBRPC.
   *
   * @param  timeSinceLastOBRPC  BigDecimal
   */
  public void setTimeSinceLastOBRPC(BigDecimal timeSinceLastOBRPC) {
    this.timeSinceLastOBRPC = timeSinceLastOBRPC;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for time since last PTP.
   *
   * @param  timeSinceLastPTP  BigDecimal
   */
  public void setTimeSinceLastPTP(BigDecimal timeSinceLastPTP) {
    this.timeSinceLastPTP = timeSinceLastPTP;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for times since IBRPC.
   *
   * @param  timesSinceIBRPC  BigDecimal
   */
  public void setTimesSinceIBRPC(BigDecimal timesSinceIBRPC) {
    this.timesSinceIBRPC = timesSinceIBRPC;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for times since OBRPC.
   *
   * @param  timesSinceOBRPC  BigDecimal
   */
  public void setTimesSinceOBRPC(BigDecimal timesSinceOBRPC) {
    this.timesSinceOBRPC = timesSinceOBRPC;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for trace flag.
   *
   * @param  traceFlag  String
   */
  public void setTraceFlag(String traceFlag) {
    this.traceFlag = traceFlag;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for triumph account number.
   *
   * @param  triumphAccountNumber  String
   */
  public void setTriumphAccountNumber(String triumphAccountNumber) {
    this.triumphAccountNumber = triumphAccountNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for triumph account number hash.
   *
   * @param  triumphAccountNumberHash  String
   */
  public void setTriumphAccountNumberHash(String triumphAccountNumberHash) {
    this.triumphAccountNumberHash = triumphAccountNumberHash;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for write off amount.
   *
   * @param  writeOffAmount  BigDecimal
   */
  public void setWriteOffAmount(BigDecimal writeOffAmount) {
    this.writeOffAmount = writeOffAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for write off date.
   *
   * @param  writeOffDate  Date
   */
  public void setWriteOffDate(Date writeOffDate) {
    this.writeOffDate = writeOffDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#toString()
   */
  @Override public String toString() {
    final String  TAB      = "    ";
    StringBuilder retValue = new StringBuilder();

    retValue.append("BarclayAccount ( ").append("barclayAccountId = ").append(this.barclayAccountId).append(TAB).append(
      "routerAccountNumber = ").append(
      this.routerAccountNumber).append(TAB).append("writeOffAmount = ").append(this.writeOffAmount).append(TAB).append(
      "writeOffDate = ").append(this.writeOffDate).append(TAB).append("traceFlag = ").append(
      this.traceFlag).append(" )");

    return retValue.toString();
  }
} // end class BarclayAccount
