package com.cmc.credagility.core.domain.tsys;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * TsysAccount.java is the class to create TsysAccount Table - to store the Record 100 from placement file.
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/15/2014 16:24
 */
@Entity
@Table(
  name    = "TsysAccount",
  indexes = {
    @Index(
      name = "tsysAccountIdentifierIndex",
      columnList = "tsysAccountIdentifier"
    )
  }
)
public class TsysAccount extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  // ~ Instance fields
  // --------------------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -5450314529169237468L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "accountNum",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @OneToOne(cascade = { CascadeType.ALL })
  protected Account account;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "accountType",
    length = 1
  )
  protected String accountType;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "acquisitionStrategyCode",
    length = 6
  )
  protected String acquisitionStrategyCode;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "agencyCode",
    length = 6
  )
  protected String agencyCode;

  /** TODO: DOCUMENT ME! */
  @Column(name = "availableCredit")
  protected BigDecimal availableCredit;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "bankGuaranteeFlag",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean bankGuaranteeFlag;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "branchNumber",
    length = 6
  )
  protected String branchNumber;

  /** TODO: DOCUMENT ME! */
  @Column(name = "brokenPromisesLTD")
  protected Integer brokenPromisesLTD;

  /** TODO: DOCUMENT ME! */
  @Column(name = "brokenPromisesYTD")
  protected Integer brokenPromisesYTD;

  /** TODO: DOCUMENT ME! */
  @Column(name = "cardExpirationDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date cardExpirationDate;

  /** TODO: DOCUMENT ME! */
  @Column(name = "cashAdvancesAmountCTD")
  protected BigDecimal cashAdvancesAmountCTD;

  /** TODO: DOCUMENT ME! */
  @Column(name = "cashAdvancesAmountYTD")
  protected BigDecimal cashAdvancesAmountYTD;

  /** TODO: DOCUMENT ME! */
  @Column(name = "chargeOffPrincipalAmount")
  protected BigDecimal chargeOffPrincipalAmount;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientProductCode",
    length = 3
  )
  protected String clientProductCode;

  /** TODO: DOCUMENT ME! */
  @Column(name = "creditLimitChangeDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date creditLimitChangeDate;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "currencyCode",
    length = 3
  )
  protected String currencyCode;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "customerCreditProtectionFlag",
    length = 1
  )
  protected String customerCreditProtectionFlag;

  /** TODO: DOCUMENT ME! */
  @Column(name = "delinquencyDaysReceivedDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date delinquencyDaysReceivedDate;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "disclosureGroup",
    length = 8
  )
  protected String disclosureGroup;

  /** TODO: DOCUMENT ME! */
  @Column(name = "highBalanceDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date highBalanceDate;

  /** TODO: DOCUMENT ME! */
  @Column(name = "lastAutoReageDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date lastAutoReageDate;

  /** TODO: DOCUMENT ME! */
  @Column(name = "lastCashAmount")
  protected BigDecimal lastCashAmount;

  /** TODO: DOCUMENT ME! */
  @Column(name = "lastCashDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date lastCashDate;

  /** TODO: DOCUMENT ME! */
  @Column(name = "lastNSFAmount")
  protected BigDecimal lastNSFAmount;

  /** TODO: DOCUMENT ME! */
  @Column(name = "lastPurchaseAmount")
  protected BigDecimal lastPurchaseAmount;

  /** TODO: DOCUMENT ME! */
  @Column(name = "lastPurchaseDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date lastPurchaseDate;

  /** TODO: DOCUMENT ME! */
  @Column(name = "lifetimeHighBalance")
  protected BigDecimal lifetimeHighBalance;

  /** TODO: DOCUMENT ME! */
  @Column(name = "numberNSFChecks")
  protected Integer numberNSFChecks;

  /** TODO: DOCUMENT ME! */
  @Column(name = "numCardsIssued")
  protected Integer numCardsIssued;

  /** TODO: DOCUMENT ME! */
  @Column(name = "originalBureauScore")
  protected Integer originalBureauScore;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "portfolioManagementLetterCode",
    length = 6
  )
  protected String portfolioManagementLetterCode;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "portfolioManagementQueue",
    length = 6
  )
  protected String portfolioManagementQueue;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "portfolioManagementScenario",
    length = 8
  )
  protected String portfolioManagementScenario;

  /** TODO: DOCUMENT ME! */
  @Column(name = "profitMaxRiskScore")
  protected Integer profitMaxRiskScore;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "providerId1",
    length = 6
  )
  protected String providerId1;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "providerId2",
    length = 6
  )
  protected String providerId2;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "providerId3",
    length = 6
  )
  protected String providerId3;

  /** TODO: DOCUMENT ME! */
  @Column(name = "purchasesAmountCTD")
  protected BigDecimal purchasesAmountCTD;

  /** TODO: DOCUMENT ME! */
  @Column(name = "purchasesAmountYTD")
  protected BigDecimal purchasesAmountYTD;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "queueId",
    length = 6
  )
  protected String queueId;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "regionCode",
    length = 3
  )
  protected String regionCode;

  /** TODO: DOCUMENT ME! */
  @Column(name = "returnsCurrentCycleAmount")
  protected BigDecimal returnsCurrentCycleAmount;

  /** TODO: DOCUMENT ME! */
  @Column(name = "score1")
  protected Integer score1;

  /** TODO: DOCUMENT ME! */
  @Column(name = "score2")
  protected Integer score2;

  /** TODO: DOCUMENT ME! */
  @Column(name = "score3")
  protected Integer score3;

  /** TODO: DOCUMENT ME! */
  @Column(name = "score4")
  protected Integer score4;

  /** TODO: DOCUMENT ME! */
  @Column(name = "score5")
  protected Integer score5;

  /** TODO: DOCUMENT ME! */
  @Column(name = "score6")
  protected Integer score6;

  /** TODO: DOCUMENT ME! */
  @Column(name = "score7")
  protected Integer score7;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "securitizationPoolID1",
    length = 6
  )
  protected String securitizationPoolID1;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "securitizationPoolID2",
    length = 6
  )
  protected String securitizationPoolID2;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "statementIndicator",
    length = 1
  )
  protected String statementIndicator;

  /** TODO: DOCUMENT ME! */
  @Column(name = "testDigit1")
  protected Integer testDigit1;

  /** TODO: DOCUMENT ME! */
  @Column(name = "testDigit10")
  protected Integer testDigit10;

  /** TODO: DOCUMENT ME! */
  @Column(name = "testDigit2")
  protected Integer testDigit2;

  /** TODO: DOCUMENT ME! */
  @Column(name = "testDigit3")
  protected Integer testDigit3;

  /** TODO: DOCUMENT ME! */
  @Column(name = "testDigit4")
  protected Integer testDigit4;

  /** TODO: DOCUMENT ME! */
  @Column(name = "testDigit5")
  protected Integer testDigit5;

  /** TODO: DOCUMENT ME! */
  @Column(name = "testDigit6")
  protected Integer testDigit6;

  /** TODO: DOCUMENT ME! */
  @Column(name = "testDigit7")
  protected Integer testDigit7;

  /** TODO: DOCUMENT ME! */
  @Column(name = "testDigit8")
  protected Integer testDigit8;

  /** TODO: DOCUMENT ME! */
  @Column(name = "testDigit9")
  protected Integer testDigit9;

  /** TODO: DOCUMENT ME! */
  @Column(name = "timesAutoReage")
  protected Integer timesAutoReage;

  /** TODO: DOCUMENT ME! */
  @Column(name = "totalDisputeAmount")
  protected BigDecimal totalDisputeAmount;

  /** TODO: DOCUMENT ME! */
  @Column(name = "totalDue")
  protected BigDecimal totalDue;

  /** account identifier PK. */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long tsysAccountId;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "tsysAccountIdentifier",
    nullable = false
  )
  protected Long tsysAccountIdentifier;

  /** TODO: DOCUMENT ME! */
  @OneToOne(
    fetch         = FetchType.LAZY,
    mappedBy      = "tsysAccount",
    cascade       = { CascadeType.ALL, CascadeType.REMOVE },
    orphanRemoval = true
  )
  protected TsysAggregatedPromiseToPayHistory tsysAggregatedPromiseToPayHistory;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "tsysAccount",
    cascade       = { CascadeType.ALL, CascadeType.REMOVE },
    orphanRemoval = true
  )
  @OrderBy("sequenceNumber asc")
  protected Set<TsysPaymentHistory> tsysPaymentHistory = new LinkedHashSet<TsysPaymentHistory>();

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "workflowId",
    length = 3
  )
  protected String workflowId;


  /** DOCUMENT ME! */
  @Column(name = "totalNumberMortgageTrade")
  protected BigDecimal totalNumberMortgageTrade;


  /** DOCUMENT ME! */
  @Column(name = "totalBalanceMortgageTrade")
  protected BigDecimal totalBalanceMortgageTrade;


  /** DOCUMENT ME! */
  @Column(name = "tsysEnrollmentIndicator")
  protected String  tsysEnrollmentIndicator;


  /** DOCUMENT ME! */
  @Column(name = "tsysLastNSFAmount")
  protected BigDecimal tsysLastNSFAmount;

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
   * getter method for account type.
   *
   * @return  String
   */
  public String getAccountType() {
    return accountType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for acquisition strategy code.
   *
   * @return  String
   */
  public String getAcquisitionStrategyCode() {
    return acquisitionStrategyCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agency code.
   *
   * @return  String
   */
  public String getAgencyCode() {
    return agencyCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for available credit.
   *
   * @return  BigDecimal
   */
  public BigDecimal getAvailableCredit() {
    return availableCredit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bank guarantee flag.
   *
   * @return  Boolean
   */
  public Boolean getBankGuaranteeFlag() {
    return bankGuaranteeFlag;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for branch number.
   *
   * @return  String
   */
  public String getBranchNumber() {
    return branchNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for broken promises LTD.
   *
   * @return  Integer
   */
  public Integer getBrokenPromisesLTD() {
    return brokenPromisesLTD;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for broken promises YTD.
   *
   * @return  Integer
   */
  public Integer getBrokenPromisesYTD() {
    return brokenPromisesYTD;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for card expiration date.
   *
   * @return  Date
   */
  public Date getCardExpirationDate() {
    return cardExpirationDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for cash advances amount CTD.
   *
   * @return  BigDecimal
   */
  public BigDecimal getCashAdvancesAmountCTD() {
    return cashAdvancesAmountCTD;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for cash advances amount YTD.
   *
   * @return  BigDecimal
   */
  public BigDecimal getCashAdvancesAmountYTD() {
    return cashAdvancesAmountYTD;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for charge off principal amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getChargeOffPrincipalAmount() {
    return chargeOffPrincipalAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client product code.
   *
   * @return  String
   */
  public String getClientProductCode() {
    return clientProductCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for credit limit change date.
   *
   * @return  Date
   */
  public Date getCreditLimitChangeDate() {
    return creditLimitChangeDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for currency code.
   *
   * @return  String
   */
  public String getCurrencyCode() {
    return currencyCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for customer credit protection flag.
   *
   * @return  String
   */
  public String getCustomerCreditProtectionFlag() {
    return customerCreditProtectionFlag;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for delinquency days received date.
   *
   * @return  Date
   */
  public Date getDelinquencyDaysReceivedDate() {
    return delinquencyDaysReceivedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for disclosure group.
   *
   * @return  String
   */
  public String getDisclosureGroup() {
    return disclosureGroup;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for high balance date.
   *
   * @return  Date
   */
  public Date getHighBalanceDate() {
    return highBalanceDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last auto reage date.
   *
   * @return  Date
   */
  public Date getLastAutoReageDate() {
    return lastAutoReageDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last cash amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getLastCashAmount() {
    return lastCashAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last cash date.
   *
   * @return  Date
   */
  public Date getLastCashDate() {
    return lastCashDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last NSFAmount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getLastNSFAmount() {
    return lastNSFAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last purchase amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getLastPurchaseAmount() {
    return lastPurchaseAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last purchase date.
   *
   * @return  Date
   */
  public Date getLastPurchaseDate() {
    return lastPurchaseDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for lifetime high balance.
   *
   * @return  BigDecimal
   */
  public BigDecimal getLifetimeHighBalance() {
    return lifetimeHighBalance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for number NSFChecks.
   *
   * @return  Integer
   */
  public Integer getNumberNSFChecks() {
    return numberNSFChecks;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for num cards issued.
   *
   * @return  Integer
   */
  public Integer getNumCardsIssued() {
    return numCardsIssued;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for original bureau score.
   *
   * @return  Integer
   */
  public Integer getOriginalBureauScore() {
    return originalBureauScore;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio management letter code.
   *
   * @return  String
   */
  public String getPortfolioManagementLetterCode() {
    return portfolioManagementLetterCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio management queue.
   *
   * @return  String
   */
  public String getPortfolioManagementQueue() {
    return portfolioManagementQueue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio management scenario.
   *
   * @return  String
   */
  public String getPortfolioManagementScenario() {
    return portfolioManagementScenario;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for profit max risk score.
   *
   * @return  Integer
   */
  public Integer getProfitMaxRiskScore() {
    return profitMaxRiskScore;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for provider id1.
   *
   * @return  String
   */
  public String getProviderId1() {
    return providerId1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for provider id2.
   *
   * @return  String
   */
  public String getProviderId2() {
    return providerId2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for provider id3.
   *
   * @return  String
   */
  public String getProviderId3() {
    return providerId3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for purchases amount CTD.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPurchasesAmountCTD() {
    return purchasesAmountCTD;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for purchases amount YTD.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPurchasesAmountYTD() {
    return purchasesAmountYTD;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for queue id.
   *
   * @return  String
   */
  public String getQueueId() {
    return queueId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for region code.
   *
   * @return  String
   */
  public String getRegionCode() {
    return regionCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for returns current cycle amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getReturnsCurrentCycleAmount() {
    return returnsCurrentCycleAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for score1.
   *
   * @return  Integer
   */
  public Integer getScore1() {
    return score1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for score2.
   *
   * @return  Integer
   */
  public Integer getScore2() {
    return score2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for score3.
   *
   * @return  Integer
   */
  public Integer getScore3() {
    return score3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for score4.
   *
   * @return  Integer
   */
  public Integer getScore4() {
    return score4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for score5.
   *
   * @return  Integer
   */
  public Integer getScore5() {
    return score5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for score6.
   *
   * @return  Integer
   */
  public Integer getScore6() {
    return score6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for score7.
   *
   * @return  Integer
   */
  public Integer getScore7() {
    return score7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for securitization pool ID1.
   *
   * @return  String
   */
  public String getSecuritizationPoolID1() {
    return securitizationPoolID1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for securitization pool ID2.
   *
   * @return  String
   */
  public String getSecuritizationPoolID2() {
    return securitizationPoolID2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for statement indicator.
   *
   * @return  String
   */
  public String getStatementIndicator() {
    return statementIndicator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for test digit1.
   *
   * @return  Integer
   */
  public Integer getTestDigit1() {
    return testDigit1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for test digit10.
   *
   * @return  Integer
   */
  public Integer getTestDigit10() {
    return testDigit10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for test digit2.
   *
   * @return  Integer
   */
  public Integer getTestDigit2() {
    return testDigit2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for test digit3.
   *
   * @return  Integer
   */
  public Integer getTestDigit3() {
    return testDigit3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for test digit4.
   *
   * @return  Integer
   */
  public Integer getTestDigit4() {
    return testDigit4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for test digit5.
   *
   * @return  Integer
   */
  public Integer getTestDigit5() {
    return testDigit5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for test digit6.
   *
   * @return  Integer
   */
  public Integer getTestDigit6() {
    return testDigit6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for test digit7.
   *
   * @return  Integer
   */
  public Integer getTestDigit7() {
    return testDigit7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for test digit8.
   *
   * @return  Integer
   */
  public Integer getTestDigit8() {
    return testDigit8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for test digit9.
   *
   * @return  Integer
   */
  public Integer getTestDigit9() {
    return testDigit9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for times auto reage.
   *
   * @return  Integer
   */
  public Integer getTimesAutoReage() {
    return timesAutoReage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for total dispute amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getTotalDisputeAmount() {
    return totalDisputeAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for total due.
   *
   * @return  BigDecimal
   */
  public BigDecimal getTotalDue() {
    return totalDue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for tsys account id.
   *
   * @return  Long
   */
  public Long getTsysAccountId() {
    return tsysAccountId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~ Methods
  // ----------------------------------------------------------------------------------------------------------


  /**
   * getter method for tsys account identifier.
   *
   * @return  Long
   */
  public Long getTsysAccountIdentifier() {
    return tsysAccountIdentifier;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for tsys aggregated promise to pay history.
   *
   * @return  TsysAggregatedPromiseToPayHistory
   */
  public TsysAggregatedPromiseToPayHistory getTsysAggregatedPromiseToPayHistory() {
    return tsysAggregatedPromiseToPayHistory;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for tsys payment history.
   *
   * @return  Set
   */
  public Set<TsysPaymentHistory> getTsysPaymentHistory() {
    return tsysPaymentHistory;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for workflow id.
   *
   * @return  String
   */
  public String getWorkflowId() {
    return workflowId;
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
   * setter method for account type.
   *
   * @param  accountType  String
   */
  public void setAccountType(String accountType) {
    this.accountType = accountType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for acquisition strategy code.
   *
   * @param  acquisitionStrategyCode  String
   */
  public void setAcquisitionStrategyCode(String acquisitionStrategyCode) {
    this.acquisitionStrategyCode = acquisitionStrategyCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agency code.
   *
   * @param  agencyCode  String
   */
  public void setAgencyCode(String agencyCode) {
    this.agencyCode = agencyCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for available credit.
   *
   * @param  availableCredit  BigDecimal
   */
  public void setAvailableCredit(BigDecimal availableCredit) {
    this.availableCredit = availableCredit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bank guarantee flag.
   *
   * @param  bankGuaranteeFlag  Boolean
   */
  public void setBankGuaranteeFlag(Boolean bankGuaranteeFlag) {
    this.bankGuaranteeFlag = bankGuaranteeFlag;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for branch number.
   *
   * @param  branchNumber  String
   */
  public void setBranchNumber(String branchNumber) {
    this.branchNumber = branchNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for broken promises LTD.
   *
   * @param  brokenPromisesLTD  Integer
   */
  public void setBrokenPromisesLTD(Integer brokenPromisesLTD) {
    this.brokenPromisesLTD = brokenPromisesLTD;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for broken promises YTD.
   *
   * @param  brokenPromisesYTD  Integer
   */
  public void setBrokenPromisesYTD(Integer brokenPromisesYTD) {
    this.brokenPromisesYTD = brokenPromisesYTD;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for card expiration date.
   *
   * @param  cardExpirationDate  Date
   */
  public void setCardExpirationDate(Date cardExpirationDate) {
    this.cardExpirationDate = cardExpirationDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for cash advances amount CTD.
   *
   * @param  cashAdvancesAmountCTD  BigDecimal
   */
  public void setCashAdvancesAmountCTD(BigDecimal cashAdvancesAmountCTD) {
    this.cashAdvancesAmountCTD = cashAdvancesAmountCTD;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for cash advances amount YTD.
   *
   * @param  cashAdvancesAmountYTD  BigDecimal
   */
  public void setCashAdvancesAmountYTD(BigDecimal cashAdvancesAmountYTD) {
    this.cashAdvancesAmountYTD = cashAdvancesAmountYTD;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for charge off principal amount.
   *
   * @param  chargeOffPrincipalAmount  BigDecimal
   */
  public void setChargeOffPrincipalAmount(BigDecimal chargeOffPrincipalAmount) {
    this.chargeOffPrincipalAmount = chargeOffPrincipalAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client product code.
   *
   * @param  clientProductCode  String
   */
  public void setClientProductCode(String clientProductCode) {
    this.clientProductCode = clientProductCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for credit limit change date.
   *
   * @param  creditLimitChangeDate  Date
   */
  public void setCreditLimitChangeDate(Date creditLimitChangeDate) {
    this.creditLimitChangeDate = creditLimitChangeDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for currency code.
   *
   * @param  currencyCode  String
   */
  public void setCurrencyCode(String currencyCode) {
    this.currencyCode = currencyCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for customer credit protection flag.
   *
   * @param  customerCreditProtectionFlag  String
   */
  public void setCustomerCreditProtectionFlag(String customerCreditProtectionFlag) {
    this.customerCreditProtectionFlag = customerCreditProtectionFlag;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for delinquency days received date.
   *
   * @param  delinquencyDaysReceivedDate  Date
   */
  public void setDelinquencyDaysReceivedDate(Date delinquencyDaysReceivedDate) {
    this.delinquencyDaysReceivedDate = delinquencyDaysReceivedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for disclosure group.
   *
   * @param  disclosureGroup  String
   */
  public void setDisclosureGroup(String disclosureGroup) {
    this.disclosureGroup = disclosureGroup;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for high balance date.
   *
   * @param  highBalanceDate  Date
   */
  public void setHighBalanceDate(Date highBalanceDate) {
    this.highBalanceDate = highBalanceDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last auto reage date.
   *
   * @param  lastAutoReageDate  Date
   */
  public void setLastAutoReageDate(Date lastAutoReageDate) {
    this.lastAutoReageDate = lastAutoReageDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last cash amount.
   *
   * @param  lastCashAmount  BigDecimal
   */
  public void setLastCashAmount(BigDecimal lastCashAmount) {
    this.lastCashAmount = lastCashAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last cash date.
   *
   * @param  lastCashDate  Date
   */
  public void setLastCashDate(Date lastCashDate) {
    this.lastCashDate = lastCashDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last NSFAmount.
   *
   * @param  lastNSFAmount  BigDecimal
   */
  public void setLastNSFAmount(BigDecimal lastNSFAmount) {
    this.lastNSFAmount = lastNSFAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last purchase amount.
   *
   * @param  lastPurchaseAmount  BigDecimal
   */
  public void setLastPurchaseAmount(BigDecimal lastPurchaseAmount) {
    this.lastPurchaseAmount = lastPurchaseAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last purchase date.
   *
   * @param  lastPurchaseDate  Date
   */
  public void setLastPurchaseDate(Date lastPurchaseDate) {
    this.lastPurchaseDate = lastPurchaseDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for lifetime high balance.
   *
   * @param  lifetimeHighBalance  BigDecimal
   */
  public void setLifetimeHighBalance(BigDecimal lifetimeHighBalance) {
    this.lifetimeHighBalance = lifetimeHighBalance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for number NSFChecks.
   *
   * @param  numberNSFChecks  Integer
   */
  public void setNumberNSFChecks(Integer numberNSFChecks) {
    this.numberNSFChecks = numberNSFChecks;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for num cards issued.
   *
   * @param  numCardsIssued  Integer
   */
  public void setNumCardsIssued(Integer numCardsIssued) {
    this.numCardsIssued = numCardsIssued;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for original bureau score.
   *
   * @param  originalBureauScore  Integer
   */
  public void setOriginalBureauScore(Integer originalBureauScore) {
    this.originalBureauScore = originalBureauScore;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio management letter code.
   *
   * @param  portfolioManagementLetterCode  String
   */
  public void setPortfolioManagementLetterCode(String portfolioManagementLetterCode) {
    this.portfolioManagementLetterCode = portfolioManagementLetterCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio management queue.
   *
   * @param  portfolioManagementQueue  String
   */
  public void setPortfolioManagementQueue(String portfolioManagementQueue) {
    this.portfolioManagementQueue = portfolioManagementQueue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio management scenario.
   *
   * @param  portfolioManagementScenario  String
   */
  public void setPortfolioManagementScenario(String portfolioManagementScenario) {
    this.portfolioManagementScenario = portfolioManagementScenario;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for profit max risk score.
   *
   * @param  profitMaxRiskScore  Integer
   */
  public void setProfitMaxRiskScore(Integer profitMaxRiskScore) {
    this.profitMaxRiskScore = profitMaxRiskScore;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for provider id1.
   *
   * @param  providerId1  String
   */
  public void setProviderId1(String providerId1) {
    this.providerId1 = providerId1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for provider id2.
   *
   * @param  providerId2  String
   */
  public void setProviderId2(String providerId2) {
    this.providerId2 = providerId2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for provider id3.
   *
   * @param  providerId3  String
   */
  public void setProviderId3(String providerId3) {
    this.providerId3 = providerId3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for purchases amount CTD.
   *
   * @param  purchasesAmountCTD  BigDecimal
   */
  public void setPurchasesAmountCTD(BigDecimal purchasesAmountCTD) {
    this.purchasesAmountCTD = purchasesAmountCTD;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for purchases amount YTD.
   *
   * @param  purchasesAmountYTD  BigDecimal
   */
  public void setPurchasesAmountYTD(BigDecimal purchasesAmountYTD) {
    this.purchasesAmountYTD = purchasesAmountYTD;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for queue id.
   *
   * @param  queueId  String
   */
  public void setQueueId(String queueId) {
    this.queueId = queueId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for region code.
   *
   * @param  regionCode  String
   */
  public void setRegionCode(String regionCode) {
    this.regionCode = regionCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for returns current cycle amount.
   *
   * @param  returnsCurrentCycleAmount  BigDecimal
   */
  public void setReturnsCurrentCycleAmount(BigDecimal returnsCurrentCycleAmount) {
    this.returnsCurrentCycleAmount = returnsCurrentCycleAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for score1.
   *
   * @param  score1  Integer
   */
  public void setScore1(Integer score1) {
    this.score1 = score1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for score2.
   *
   * @param  score2  Integer
   */
  public void setScore2(Integer score2) {
    this.score2 = score2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for score3.
   *
   * @param  score3  Integer
   */
  public void setScore3(Integer score3) {
    this.score3 = score3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for score4.
   *
   * @param  score4  Integer
   */
  public void setScore4(Integer score4) {
    this.score4 = score4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for score5.
   *
   * @param  score5  Integer
   */
  public void setScore5(Integer score5) {
    this.score5 = score5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for score6.
   *
   * @param  score6  Integer
   */
  public void setScore6(Integer score6) {
    this.score6 = score6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for score7.
   *
   * @param  score7  Integer
   */
  public void setScore7(Integer score7) {
    this.score7 = score7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for securitization pool ID1.
   *
   * @param  securitizationPoolID1  String
   */
  public void setSecuritizationPoolID1(String securitizationPoolID1) {
    this.securitizationPoolID1 = securitizationPoolID1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for securitization pool ID2.
   *
   * @param  securitizationPoolID2  String
   */
  public void setSecuritizationPoolID2(String securitizationPoolID2) {
    this.securitizationPoolID2 = securitizationPoolID2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for statement indicator.
   *
   * @param  statementIndicator  String
   */
  public void setStatementIndicator(String statementIndicator) {
    this.statementIndicator = statementIndicator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for test digit1.
   *
   * @param  testDigit1  Integer
   */
  public void setTestDigit1(Integer testDigit1) {
    this.testDigit1 = testDigit1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for test digit10.
   *
   * @param  testDigit10  Integer
   */
  public void setTestDigit10(Integer testDigit10) {
    this.testDigit10 = testDigit10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for test digit2.
   *
   * @param  testDigit2  Integer
   */
  public void setTestDigit2(Integer testDigit2) {
    this.testDigit2 = testDigit2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for test digit3.
   *
   * @param  testDigit3  Integer
   */
  public void setTestDigit3(Integer testDigit3) {
    this.testDigit3 = testDigit3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for test digit4.
   *
   * @param  testDigit4  Integer
   */
  public void setTestDigit4(Integer testDigit4) {
    this.testDigit4 = testDigit4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for test digit5.
   *
   * @param  testDigit5  Integer
   */
  public void setTestDigit5(Integer testDigit5) {
    this.testDigit5 = testDigit5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for test digit6.
   *
   * @param  testDigit6  Integer
   */
  public void setTestDigit6(Integer testDigit6) {
    this.testDigit6 = testDigit6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for test digit7.
   *
   * @param  testDigit7  Integer
   */
  public void setTestDigit7(Integer testDigit7) {
    this.testDigit7 = testDigit7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for test digit8.
   *
   * @param  testDigit8  Integer
   */
  public void setTestDigit8(Integer testDigit8) {
    this.testDigit8 = testDigit8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for test digit9.
   *
   * @param  testDigit9  Integer
   */
  public void setTestDigit9(Integer testDigit9) {
    this.testDigit9 = testDigit9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for times auto reage.
   *
   * @param  timesAutoReage  Integer
   */
  public void setTimesAutoReage(Integer timesAutoReage) {
    this.timesAutoReage = timesAutoReage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for total dispute amount.
   *
   * @param  totalDisputeAmount  BigDecimal
   */
  public void setTotalDisputeAmount(BigDecimal totalDisputeAmount) {
    this.totalDisputeAmount = totalDisputeAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for total due.
   *
   * @param  totalDue  BigDecimal
   */
  public void setTotalDue(BigDecimal totalDue) {
    this.totalDue = totalDue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for tsys account id.
   *
   * @param  tsysAccountId  Long
   */
  public void setTsysAccountId(Long tsysAccountId) {
    this.tsysAccountId = tsysAccountId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for tsys account identifier.
   *
   * @param  tsysAccountIdentifier  Long
   */
  public void setTsysAccountIdentifier(Long tsysAccountIdentifier) {
    this.tsysAccountIdentifier = tsysAccountIdentifier;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for tsys aggregated promise to pay history.
   *
   * @param  tsysAggregatedPromiseToPayHistory  TsysAggregatedPromiseToPayHistory
   */
  public void setTsysAggregatedPromiseToPayHistory(
    TsysAggregatedPromiseToPayHistory tsysAggregatedPromiseToPayHistory) {
    this.tsysAggregatedPromiseToPayHistory = tsysAggregatedPromiseToPayHistory;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for tsys payment history.
   *
   * @param  tsysPaymentHistory  Set
   */
  public void setTsysPaymentHistory(Set<TsysPaymentHistory> tsysPaymentHistory) {
    this.tsysPaymentHistory = tsysPaymentHistory;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for workflow id.
   *
   * @param  workflowId  String
   */
  public void setWorkflowId(String workflowId) {
    this.workflowId = workflowId;
  }


  public BigDecimal getTotalNumberMortgageTrade() {
    return totalNumberMortgageTrade;
  }

  public void setTotalNumberMortgageTrade(BigDecimal totalNumberMortgageTrade) {
    this.totalNumberMortgageTrade = totalNumberMortgageTrade;
  }

  public BigDecimal getTotalBalanceMortgageTrade() {
    return totalBalanceMortgageTrade;
  }

  public void setTotalBalanceMortgageTrade(BigDecimal totalBalanceMortgageTrade) {
    this.totalBalanceMortgageTrade = totalBalanceMortgageTrade;
  }

  public String getTsysEnrollmentIndicator() {
    return tsysEnrollmentIndicator;
  }

  public void setTsysEnrollmentIndicator(String tsysEnrollmentIndicator) {
    this.tsysEnrollmentIndicator = tsysEnrollmentIndicator;
  }

  public BigDecimal getTsysLastNSFAmount() {
    return tsysLastNSFAmount;
  }

  public void setTsysLastNSFAmount(BigDecimal tsysLastNSFAmount) {
    this.tsysLastNSFAmount = tsysLastNSFAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Constructs a <code>String</code> with all attributes in name = value format.
   *
   * @return  a <code>String</code> representation of this object.
   */
  @Override public String toString() {
    final String  TAB      = "    ";
    StringBuilder retValue = new StringBuilder();

    retValue.append("TsysAccount ( ").append("id = ").append(this.tsysAccountId).append(TAB).append(
      "tsysAccountIdentifier = ").append(
      this.tsysAccountIdentifier).append(TAB).append("clientProductCode = ").append(this.clientProductCode).append(
      TAB).append("providerId1 = ").append(this.providerId1).append(
      TAB).append("providerId2 = ").append(this.providerId2).append(TAB).append("providerId3 = ").append(
      this.providerId3).append(
      TAB).append("chargeOffPrincipalAmount = ").append(this.chargeOffPrincipalAmount).append(TAB).append(
      "availableCredit = ").append(this.availableCredit).append(TAB).append("creditLimitChangeDate = ").append(
      this.creditLimitChangeDate).append(TAB).append("totalNumberMortgageTrade = ").append(
      this.totalNumberMortgageTrade).append(TAB).append("tsysLastNSFAmount = ").append(
      this.totalBalanceMortgageTrade).append(
    this.tsysLastNSFAmount).append(TAB).append("tsysEnrollmentIndicator = ").append(
            this.tsysEnrollmentIndicator).append(" )");

    return retValue.toString();
  }
} // end class TsysAccount
