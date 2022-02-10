package com.cmc.credagility.core.domain.usb;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.type.CustomerType;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 15:53
 */
@Entity
@Table(name = "USBAccount")
public class USBAccount extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -8671060952844419934L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "accountNum",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @OneToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  protected Account account;


  /** account number PK. */
  @Column(
    name     = "usbAccountId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long usbAccountId;
  @Column(
    name      = "accountHighCredit",
    precision = 19,
    scale     = 4
  )
  private BigDecimal accountHighCredit;


  @Column(
    name      = "accruedInterest",
    precision = 19,
    scale     = 4
  )
  private BigDecimal accruedInterest;

  @Column(name = "acquisitionDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date acquisitionDate;

  @Column(
    name   = "addressOfEmployer",
    length = 50
  )
  private String addressOfEmployer;
  @Column(
    name   = "agentCode",
    length = 10
  )
  private String agentCode;

  @Column(
    name      = "associatedCosts",
    precision = 19,
    scale     = 4
  )
  private BigDecimal associatedCosts;


  @Column(
    name   = "attorneyCode",
    length = 10
  )
  private String attorneyCode;

  @Column(
    columnDefinition = "char",
    name             = "blockPaymentFlag",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean blockPaymentFlag;

  @Column(
    name   = "caseNumber",
    length = 20
  )
  private String caseNumber;


  @Column(
    name   = "clientDefined10CharCode1",
    length = 10
  )
  private String clientDefined10CharCode1;

  @Column(
    name   = "clientDefined10CharCode2",
    length = 10
  )
  private String clientDefined10CharCode2;

  @Column(
    name   = "clientDefined10CharCode3",
    length = 10
  )
  private String clientDefined10CharCode3;


  @Column(
    name   = "clientDefined20CharCode1",
    length = 20
  )
  private String clientDefined20CharCode1;

  @Column(
    name   = "clientDefined20CharCode2",
    length = 20
  )
  private String clientDefined20CharCode2;
  @Column(
    name   = "clientDefined20CharCode3",
    length = 20
  )
  private String clientDefined20CharCode3;
  @Column(
    name   = "clientDefined20CharCode4",
    length = 20
  )
  private String clientDefined20CharCode4;

  @Column(
    name   = "clientDefined20CharCode5",
    length = 20
  )
  private String clientDefined20CharCode5;

  @Column(
    name   = "clientDefined3CharCode1",
    length = 3
  )
  private String clientDefined3CharCode1;

  @Column(
    name   = "clientDefined3CharCode2",
    length = 3
  )
  private String clientDefined3CharCode2;
  @Column(
    name   = "clientDefined3CharCode3",
    length = 3
  )
  private String clientDefined3CharCode3;

  @Column(
    name   = "clientDefined3CharCode4",
    length = 3
  )
  private String clientDefined3CharCode4;

  @Column(
    name   = "clientDefined3CharCode5",
    length = 3
  )
  private String     clientDefined3CharCode5;
  @Column(name = "clientDefinedDecimal1")
  private BigDecimal clientDefinedDecimal1;

  @Column(name = "clientDefinedDecimal2")
  private BigDecimal clientDefinedDecimal2;

  @Column(name = "clientDefinedDecimal3")
  private BigDecimal clientDefinedDecimal3;


  @Column(name = "clientDefinedDecimal4")
  private BigDecimal clientDefinedDecimal4;

  @Column(name = "clientDefinedDecimal5")
  private BigDecimal clientDefinedDecimal5;

  @Column(
    name             = "clientDefinedFlag1",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedFlag1;

  @Column(
    name             = "clientDefinedFlag2",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedFlag2;

  @Column(
    name             = "clientDefinedFlag3",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedFlag3;

  @Column(
    name             = "clientDefinedFlag4",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedFlag4;

  @Column(
    name   = "clientDefinedInteger1",
    length = 5
  )
  private Integer clientDefinedInteger1;


  @Column(
    name   = "clientDefinedInteger2",
    length = 5
  )
  private Integer clientDefinedInteger2;


  @Column(
    name   = "clientDefinedInteger3",
    length = 5
  )
  private Integer clientDefinedInteger3;
  @Column(name = "cmcSentDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date    cmcSentDate;


  @Column(
    name      = "commissionPercentage",
    precision = 19,
    scale     = 4
  )
  private BigDecimal commissionPercentage;


  @Column(
    columnDefinition = "char",
    name             = "creditBureauReporting",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean creditBureauReporting;

  @Column(
    name   = "customerType",
    length = 1
  )
  @Enumerated(value = EnumType.STRING)
  private CustomerType customerType;

  @Column(
    name   = "cycleDate",
    length = 40
  )
  private String cycleDate;

  @Column(name = "dateAccountSold")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateAccountSold;

  @Column(name = "dateAssigned")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateAssigned;

  @Column(name = "dateOfDeath")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateOfDeath;

  @Column(name = "dateOfLastComments")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateOfLastComments;

  @Column(name = "dateReceived")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateReceived;
  @Column(name = "dateTransferredToDead")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateTransferredToDead;


  @Column(
    name   = "debtorPaymentNumber",
    length = 3
  )
  private Integer    debtorPaymentNumber;
  @Column(
    name      = "excessRecoveries",
    precision = 19,
    scale     = 4
  )
  private BigDecimal excessRecoveries;

  @Column(name = "expressConsentDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date expressConsentDate;

  @Column(
    name   = "fileLocation",
    length = 15
  )
  private String fileLocation;
  @Column(
    name   = "financialRecovererCode",
    length = 4
  )
  private String financialRecovererCode;

  @Column(
    name   = "frequencyIndicator",
    length = 1
  )
  private String frequencyIndicator;

  @Column(
    name   = "frequencyOfContact",
    length = 5
  )
  private Integer    frequencyOfContact;
  @Column(
    name   = "glSegment",
    length = 10
  )
  private String     glSegment;
  @Column(
    name      = "hostBalance",
    precision = 19,
    scale     = 4
  )
  private BigDecimal hostBalance;

  @Column(
    name   = "hotCommentsLine1",
    length = 50
  )
  private String hotCommentsLine1;
  @Column(
    name   = "hotCommentsLine2",
    length = 50
  )
  private String hotCommentsLine2;

  @Column(name = "initialDelinquencyDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date initialDelinquencyDate;

  @Column(name = "judgmentDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date judgmentDate;

  @Column(
    name   = "lastAgency1",
    length = 10
  )
  private String lastAgency1;
  @Column(
    name   = "lastAgency2",
    length = 10
  )
  private String lastAgency2;
  @Column(
    name   = "lastAgency3",
    length = 10
  )
  private String lastAgency3;
  @Column(
    name   = "lastAgency4",
    length = 10
  )
  private String lastAgency4;
  @Column(
    name   = "lastAgency5",
    length = 10
  )
  private String lastAgency5;

  @Column(name = "lastContactDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date lastContactDate;

  @Column(name = "lastInterestDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date lastInterestDate;

  @Column(name = "lastStatusChangeDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date lastStatusChangeDate;

  @Column(
    name   = "lastStatusCode",
    length = 10
  )
  private String     lastStatusCode;
  @Column(
    name      = "lateFees",
    precision = 19,
    scale     = 4
  )
  private BigDecimal lateFees;

  @Column(
    name      = "legalUserDefinedAmount3",
    precision = 19,
    scale     = 4
  )
  private BigDecimal legalUserDefinedAmount3;
  @Column(
    name      = "legalUserDefinedAmount4",
    precision = 19,
    scale     = 4
  )
  private BigDecimal legalUserDefinedAmount4;
  @Column(
    name      = "legalUserDefinedAmount6",
    precision = 19,
    scale     = 4
  )
  private BigDecimal legalUserDefinedAmount6;
  @Column(name = "legalUserDefinedDate2")
  @Temporal(TemporalType.TIMESTAMP)
  private Date       legalUserDefinedDate2;
  @Column(name = "legalUserDefinedDate4")
  @Temporal(TemporalType.TIMESTAMP)
  private Date       legalUserDefinedDate4;
  @Column(name = "legalUserDefinedDate5")
  @Temporal(TemporalType.TIMESTAMP)
  private Date       legalUserDefinedDate5;

  @Column(name = "legalUserDefinedDate6")
  @Temporal(TemporalType.TIMESTAMP)
  private Date   legalUserDefinedDate6;
  @Column(
    name   = "legalUserDefinedVariable10",
    length = 50
  )
  private String legalUserDefinedVariable10;

  @Column(name = "letterDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date letterDate;

  @Column(
    columnDefinition = "char",
    name             = "letterInhibitFlag",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean letterInhibitFlag;
  @Column(
    name   = "litigation",
    length = 10
  )
  private String  litigation;
  @Column(
    name   = "locationOrProductCode",
    length = 50
  )
  private String  locationOrProductCode;

  @Column(
    name      = "monthlyIncome",
    precision = 19,
    scale     = 4
  )
  private BigDecimal monthlyIncome;

  @Column(
    name      = "monthlyPayments",
    precision = 19,
    scale     = 4
  )
  private BigDecimal monthlyPayments;

  @Column(name = "nextContactDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date nextContactDate;

  @Column(name = "nextStatementDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date nextStatementDate;

  @Column(
    name   = "numberOfPayments",
    length = 3
  )
  private Integer    numberOfPayments;
  @Column(
    name      = "origCOAmt",
    precision = 19,
    scale     = 4
  )
  private BigDecimal origCOAmt;
  @Column(
    name      = "originalLoanAmount",
    precision = 19,
    scale     = 4
  )
  private BigDecimal originalLoanAmount;
  @Column(
    name      = "otherFees",
    precision = 19,
    scale     = 4
  )
  private BigDecimal otherFees;
  @Column(
    name      = "otherIncome",
    precision = 19,
    scale     = 4
  )
  private BigDecimal otherIncome;
  @Column(
    name      = "otherObligations",
    precision = 19,
    scale     = 4
  )
  private BigDecimal otherObligations;

  @Column(
    name   = "ownOrRentCode",
    length = 1
  )
  private String ownOrRentCode;

  @Column(
    name      = "pastDueAmount",
    precision = 19,
    scale     = 4
  )
  private BigDecimal pastDueAmount;

  @Column(
    name      = "paymentAmount",
    precision = 19,
    scale     = 4
  )
  private BigDecimal paymentAmount;
  @Column(
    name   = "paymentApplyCode",
    length = 10
  )
  private String     paymentApplyCode;

  @Column(name = "paymentDueDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date paymentDueDate;

  @Column(name = "paymentDueSuspenseDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date paymentDueSuspenseDate;

  @Column(
    name   = "paymentSchedule",
    length = 1
  )
  private String paymentSchedule;

  @Column(
    name   = "paymentTerm",
    length = 3
  )
  private Integer    paymentTerm;
  @Column(
    name   = "paymentType",
    length = 1
  )
  private String     paymentType;
  @Column(
    name   = "placeOfEmployment",
    length = 50
  )
  private String     placeOfEmployment;
  @Column(
    name      = "prevStmtBalance",
    precision = 19,
    scale     = 4
  )
  private BigDecimal prevStmtBalance;
  @Column(
    name      = "purchasePrice",
    precision = 19,
    scale     = 4
  )
  private BigDecimal purchasePrice;

  @Column(
    name      = "recoveredCosts",
    precision = 19,
    scale     = 4
  )
  private BigDecimal recoveredCosts;
  @Column(
    name      = "recoveredInterest",
    precision = 19,
    scale     = 4
  )
  private BigDecimal recoveredInterest;
  @Column(
    name      = "recoveredLateFees",
    precision = 19,
    scale     = 4
  )
  private BigDecimal recoveredLateFees;
  @Column(
    name      = "recoveredOtherFees",
    precision = 19,
    scale     = 4
  )
  private BigDecimal recoveredOtherFees;
  @Column(
    name      = "recoveredPrincipal",
    precision = 19,
    scale     = 4
  )
  private BigDecimal recoveredPrincipal;
  @Column(
    name   = "secondFirstName",
    length = 50
  )
  private String     secondFirstName;

  @Column(
    name   = "secondLastName",
    length = 50
  )
  private String secondLastName;

  @Column(
    name      = "settlementAmount",
    precision = 19,
    scale     = 4
  )
  private BigDecimal settlementAmount;

  @Column(
    name   = "settlementCode",
    length = 1
  )
  private String     settlementCode;
  @Column(
    name      = "settlementPercent",
    precision = 19,
    scale     = 4
  )
  private BigDecimal settlementPercent;

  @Column(
    name   = "settlementType",
    length = 1
  )
  private String settlementType;
  @Column(
    name   = "sourceCode",
    length = 50
  )
  private String sourceCode;

  @Column(
    name   = "userDefinedAlpha2",
    length = 50
  )
  private String userDefinedAlpha2;

  @Column(
    name   = "userDefinedAlpha4",
    length = 50
  )
  private String userDefinedAlpha4;

  @Column(
    name      = "userDefinedAmount1",
    precision = 19,
    scale     = 4
  )
  private BigDecimal userDefinedAmount1;
  @Column(
    name      = "userDefinedAmount3",
    precision = 19,
    scale     = 4
  )
  private BigDecimal userDefinedAmount3;

  @Column(name = "userDefinedDate1")
  @Temporal(TemporalType.TIMESTAMP)
  private Date userDefinedDate1;

  @Column(name = "userDefinedDate5")
  @Temporal(TemporalType.TIMESTAMP)
  private Date userDefinedDate5;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    USBAccount that = (USBAccount) o;

    if ((account != null) ? (!account.equals(that.account)) : (that.account != null)) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

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
   * getter method for account high credit.
   *
   * @return  BigDecimal
   */
  public BigDecimal getAccountHighCredit() {
    return accountHighCredit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for accrued interest.
   *
   * @return  BigDecimal
   */
  public BigDecimal getAccruedInterest() {
    return accruedInterest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for acquisition date.
   *
   * @return  Date
   */
  public Date getAcquisitionDate() {
    return acquisitionDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for address of employer.
   *
   * @return  String
   */
  public String getAddressOfEmployer() {
    return addressOfEmployer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agent code.
   *
   * @return  String
   */
  public String getAgentCode() {
    return agentCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for associated costs.
   *
   * @return  BigDecimal
   */
  public BigDecimal getAssociatedCosts() {
    return associatedCosts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for attorney code.
   *
   * @return  String
   */
  public String getAttorneyCode() {
    return attorneyCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for block payment flag.
   *
   * @return  Boolean
   */
  public Boolean getBlockPaymentFlag() {
    return blockPaymentFlag;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for case number.
   *
   * @return  String
   */
  public String getCaseNumber() {
    return caseNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined10 char code1.
   *
   * @return  String
   */
  public String getClientDefined10CharCode1() {
    return clientDefined10CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined10 char code2.
   *
   * @return  String
   */
  public String getClientDefined10CharCode2() {
    return clientDefined10CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined10 char code3.
   *
   * @return  String
   */
  public String getClientDefined10CharCode3() {
    return clientDefined10CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined20 char code1.
   *
   * @return  String
   */
  public String getClientDefined20CharCode1() {
    return clientDefined20CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined20 char code2.
   *
   * @return  String
   */
  public String getClientDefined20CharCode2() {
    return clientDefined20CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined20 char code3.
   *
   * @return  String
   */
  public String getClientDefined20CharCode3() {
    return clientDefined20CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined20 char code4.
   *
   * @return  String
   */
  public String getClientDefined20CharCode4() {
    return clientDefined20CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined20 char code5.
   *
   * @return  String
   */
  public String getClientDefined20CharCode5() {
    return clientDefined20CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined3 char code1.
   *
   * @return  String
   */
  public String getClientDefined3CharCode1() {
    return clientDefined3CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined3 char code2.
   *
   * @return  String
   */
  public String getClientDefined3CharCode2() {
    return clientDefined3CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined3 char code3.
   *
   * @return  String
   */
  public String getClientDefined3CharCode3() {
    return clientDefined3CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined3 char code4.
   *
   * @return  String
   */
  public String getClientDefined3CharCode4() {
    return clientDefined3CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined3 char code5.
   *
   * @return  String
   */
  public String getClientDefined3CharCode5() {
    return clientDefined3CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal1.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal1() {
    return clientDefinedDecimal1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal2.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal2() {
    return clientDefinedDecimal2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal3.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal3() {
    return clientDefinedDecimal3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal4.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal4() {
    return clientDefinedDecimal4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal5.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal5() {
    return clientDefinedDecimal5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined flag1.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedFlag1() {
    return clientDefinedFlag1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined flag2.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedFlag2() {
    return clientDefinedFlag2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined flag3.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedFlag3() {
    return clientDefinedFlag3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined flag4.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedFlag4() {
    return clientDefinedFlag4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer1.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger1() {
    return clientDefinedInteger1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer2.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger2() {
    return clientDefinedInteger2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer3.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger3() {
    return clientDefinedInteger3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for cmc sent date.
   *
   * @return  Date
   */
  public Date getCmcSentDate() {
    return cmcSentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for commission percentage.
   *
   * @return  BigDecimal
   */
  public BigDecimal getCommissionPercentage() {
    return commissionPercentage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for credit bureau reporting.
   *
   * @return  Boolean
   */
  public Boolean getCreditBureauReporting() {
    return creditBureauReporting;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for customer type.
   *
   * @return  CustomerType
   */
  public CustomerType getCustomerType() {
    return customerType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for customer type string.
   *
   * @return  String
   */
  public String getCustomerTypeString() {
    return (customerType != null) ? customerType.toString() : null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for cycle date.
   *
   * @return  String
   */
  public String getCycleDate() {
    return cycleDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for date account sold.
   *
   * @return  Date
   */
  public Date getDateAccountSold() {
    return dateAccountSold;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for date assigned.
   *
   * @return  Date
   */
  public Date getDateAssigned() {
    return dateAssigned;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for date of death.
   *
   * @return  Date
   */
  public Date getDateOfDeath() {
    return dateOfDeath;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for date of last comments.
   *
   * @return  Date
   */
  public Date getDateOfLastComments() {
    return dateOfLastComments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for date received.
   *
   * @return  Date
   */
  public Date getDateReceived() {
    return dateReceived;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for date transferred to dead.
   *
   * @return  Date
   */
  public Date getDateTransferredToDead() {
    return dateTransferredToDead;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for debtor payment number.
   *
   * @return  Integer
   */
  public Integer getDebtorPaymentNumber() {
    return debtorPaymentNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for excess recoveries.
   *
   * @return  BigDecimal
   */
  public BigDecimal getExcessRecoveries() {
    return excessRecoveries;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for express consent date.
   *
   * @return  Date
   */
  public Date getExpressConsentDate() {
    return expressConsentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for file location.
   *
   * @return  String
   */
  public String getFileLocation() {
    return fileLocation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for financial recoverer code.
   *
   * @return  String
   */
  public String getFinancialRecovererCode() {
    return financialRecovererCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for frequency indicator.
   *
   * @return  String
   */
  public String getFrequencyIndicator() {
    return frequencyIndicator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for frequency of contact.
   *
   * @return  Integer
   */
  public Integer getFrequencyOfContact() {
    return frequencyOfContact;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for gl segment.
   *
   * @return  String
   */
  public String getGlSegment() {
    return glSegment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for host balance.
   *
   * @return  BigDecimal
   */
  public BigDecimal getHostBalance() {
    return hostBalance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for hot comments line1.
   *
   * @return  String
   */
  public String getHotCommentsLine1() {
    return hotCommentsLine1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for hot comments line2.
   *
   * @return  String
   */
  public String getHotCommentsLine2() {
    return hotCommentsLine2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for initial delinquency date.
   *
   * @return  Date
   */
  public Date getInitialDelinquencyDate() {
    return initialDelinquencyDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for judgment date.
   *
   * @return  Date
   */
  public Date getJudgmentDate() {
    return judgmentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last agency1.
   *
   * @return  String
   */
  public String getLastAgency1() {
    return lastAgency1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last agency2.
   *
   * @return  String
   */
  public String getLastAgency2() {
    return lastAgency2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last agency3.
   *
   * @return  String
   */
  public String getLastAgency3() {
    return lastAgency3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last agency4.
   *
   * @return  String
   */
  public String getLastAgency4() {
    return lastAgency4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last agency5.
   *
   * @return  String
   */
  public String getLastAgency5() {
    return lastAgency5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last contact date.
   *
   * @return  Date
   */
  public Date getLastContactDate() {
    return lastContactDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last interest date.
   *
   * @return  Date
   */
  public Date getLastInterestDate() {
    return lastInterestDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last status change date.
   *
   * @return  Date
   */
  public Date getLastStatusChangeDate() {
    return lastStatusChangeDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last status code.
   *
   * @return  String
   */
  public String getLastStatusCode() {
    return lastStatusCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for late fees.
   *
   * @return  BigDecimal
   */
  public BigDecimal getLateFees() {
    return lateFees;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for legal user defined amount3.
   *
   * @return  BigDecimal
   */
  public BigDecimal getLegalUserDefinedAmount3() {
    return legalUserDefinedAmount3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for legal user defined amount4.
   *
   * @return  BigDecimal
   */
  public BigDecimal getLegalUserDefinedAmount4() {
    return legalUserDefinedAmount4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for legal user defined amount6.
   *
   * @return  BigDecimal
   */
  public BigDecimal getLegalUserDefinedAmount6() {
    return legalUserDefinedAmount6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for legal user defined date2.
   *
   * @return  Date
   */
  public Date getLegalUserDefinedDate2() {
    return legalUserDefinedDate2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for legal user defined date4.
   *
   * @return  Date
   */
  public Date getLegalUserDefinedDate4() {
    return legalUserDefinedDate4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for legal user defined date5.
   *
   * @return  Date
   */
  public Date getLegalUserDefinedDate5() {
    return legalUserDefinedDate5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for legal user defined date6.
   *
   * @return  Date
   */
  public Date getLegalUserDefinedDate6() {
    return legalUserDefinedDate6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for legal user defined variable10.
   *
   * @return  String
   */
  public String getLegalUserDefinedVariable10() {
    return legalUserDefinedVariable10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for letter date.
   *
   * @return  Date
   */
  public Date getLetterDate() {
    return letterDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for letter inhibit flag.
   *
   * @return  Boolean
   */
  public Boolean getLetterInhibitFlag() {
    return letterInhibitFlag;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for litigation.
   *
   * @return  String
   */
  public String getLitigation() {
    return litigation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for location or product code.
   *
   * @return  String
   */
  public String getLocationOrProductCode() {
    return locationOrProductCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for monthly income.
   *
   * @return  BigDecimal
   */
  public BigDecimal getMonthlyIncome() {
    return monthlyIncome;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for monthly payments.
   *
   * @return  BigDecimal
   */
  public BigDecimal getMonthlyPayments() {
    return monthlyPayments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for next contact date.
   *
   * @return  Date
   */
  public Date getNextContactDate() {
    return nextContactDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for next statement date.
   *
   * @return  Date
   */
  public Date getNextStatementDate() {
    return nextStatementDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for number of payments.
   *
   * @return  Integer
   */
  public Integer getNumberOfPayments() {
    return numberOfPayments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for orig COAmt.
   *
   * @return  BigDecimal
   */
  public BigDecimal getOrigCOAmt() {
    return origCOAmt;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for original loan amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getOriginalLoanAmount() {
    return originalLoanAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for other fees.
   *
   * @return  BigDecimal
   */
  public BigDecimal getOtherFees() {
    return otherFees;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for other income.
   *
   * @return  BigDecimal
   */
  public BigDecimal getOtherIncome() {
    return otherIncome;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for other obligations.
   *
   * @return  BigDecimal
   */
  public BigDecimal getOtherObligations() {
    return otherObligations;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for own or rent code.
   *
   * @return  String
   */
  public String getOwnOrRentCode() {
    return ownOrRentCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for past due amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPastDueAmount() {
    return pastDueAmount;
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
   * getter method for payment apply code.
   *
   * @return  String
   */
  public String getPaymentApplyCode() {
    return paymentApplyCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment due date.
   *
   * @return  Date
   */
  public Date getPaymentDueDate() {
    return paymentDueDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment due suspense date.
   *
   * @return  Date
   */
  public Date getPaymentDueSuspenseDate() {
    return paymentDueSuspenseDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment schedule.
   *
   * @return  String
   */
  public String getPaymentSchedule() {
    return paymentSchedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment term.
   *
   * @return  Integer
   */
  public Integer getPaymentTerm() {
    return paymentTerm;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment type.
   *
   * @return  String
   */
  public String getPaymentType() {
    return paymentType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for place of employment.
   *
   * @return  String
   */
  public String getPlaceOfEmployment() {
    return placeOfEmployment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for prev stmt balance.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPrevStmtBalance() {
    return prevStmtBalance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for purchase price.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPurchasePrice() {
    return purchasePrice;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for recovered costs.
   *
   * @return  BigDecimal
   */
  public BigDecimal getRecoveredCosts() {
    return recoveredCosts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for recovered interest.
   *
   * @return  BigDecimal
   */
  public BigDecimal getRecoveredInterest() {
    return recoveredInterest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for recovered late fees.
   *
   * @return  BigDecimal
   */
  public BigDecimal getRecoveredLateFees() {
    return recoveredLateFees;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for recovered other fees.
   *
   * @return  BigDecimal
   */
  public BigDecimal getRecoveredOtherFees() {
    return recoveredOtherFees;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for recovered principal.
   *
   * @return  BigDecimal
   */
  public BigDecimal getRecoveredPrincipal() {
    return recoveredPrincipal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for second first name.
   *
   * @return  String
   */
  public String getSecondFirstName() {
    return secondFirstName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for second last name.
   *
   * @return  String
   */
  public String getSecondLastName() {
    return secondLastName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for settlement amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getSettlementAmount() {
    return settlementAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for settlement code.
   *
   * @return  String
   */
  public String getSettlementCode() {
    return settlementCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for settlement percent.
   *
   * @return  BigDecimal
   */
  public BigDecimal getSettlementPercent() {
    return settlementPercent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for settlement type.
   *
   * @return  String
   */
  public String getSettlementType() {
    return settlementType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for source code.
   *
   * @return  String
   */
  public String getSourceCode() {
    return sourceCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for usb account id.
   *
   * @return  Long
   */
  public Long getUsbAccountId() {
    return usbAccountId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for user defined alpha2.
   *
   * @return  String
   */
  public String getUserDefinedAlpha2() {
    return userDefinedAlpha2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for user defined alpha4.
   *
   * @return  String
   */
  public String getUserDefinedAlpha4() {
    return userDefinedAlpha4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for user defined amount1.
   *
   * @return  BigDecimal
   */
  public BigDecimal getUserDefinedAmount1() {
    return userDefinedAmount1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for user defined amount3.
   *
   * @return  BigDecimal
   */
  public BigDecimal getUserDefinedAmount3() {
    return userDefinedAmount3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for user defined date1.
   *
   * @return  Date
   */
  public Date getUserDefinedDate1() {
    return userDefinedDate1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for user defined date5.
   *
   * @return  Date
   */
  public Date getUserDefinedDate5() {
    return userDefinedDate5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((account != null) ? account.hashCode() : 0);

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
   * setter method for account high credit.
   *
   * @param  accountHighCredit  BigDecimal
   */
  public void setAccountHighCredit(BigDecimal accountHighCredit) {
    this.accountHighCredit = accountHighCredit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for accrued interest.
   *
   * @param  accruedInterest  BigDecimal
   */
  public void setAccruedInterest(BigDecimal accruedInterest) {
    this.accruedInterest = accruedInterest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for acquisition date.
   *
   * @param  acquisitionDate  Date
   */
  public void setAcquisitionDate(Date acquisitionDate) {
    this.acquisitionDate = acquisitionDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for address of employer.
   *
   * @param  addressOfEmployer  String
   */
  public void setAddressOfEmployer(String addressOfEmployer) {
    this.addressOfEmployer = addressOfEmployer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agent code.
   *
   * @param  agentCode  String
   */
  public void setAgentCode(String agentCode) {
    this.agentCode = agentCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for associated costs.
   *
   * @param  associatedCosts  BigDecimal
   */
  public void setAssociatedCosts(BigDecimal associatedCosts) {
    this.associatedCosts = associatedCosts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for attorney code.
   *
   * @param  attorneyCode  String
   */
  public void setAttorneyCode(String attorneyCode) {
    this.attorneyCode = attorneyCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for block payment flag.
   *
   * @param  blockPaymentFlag  Boolean
   */
  public void setBlockPaymentFlag(Boolean blockPaymentFlag) {
    this.blockPaymentFlag = blockPaymentFlag;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for case number.
   *
   * @param  caseNumber  String
   */
  public void setCaseNumber(String caseNumber) {
    this.caseNumber = caseNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined10 char code1.
   *
   * @param  clientDefined10CharCode1  String
   */
  public void setClientDefined10CharCode1(String clientDefined10CharCode1) {
    this.clientDefined10CharCode1 = clientDefined10CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined10 char code2.
   *
   * @param  clientDefined10CharCode2  String
   */
  public void setClientDefined10CharCode2(String clientDefined10CharCode2) {
    this.clientDefined10CharCode2 = clientDefined10CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined10 char code3.
   *
   * @param  clientDefined10CharCode3  String
   */
  public void setClientDefined10CharCode3(String clientDefined10CharCode3) {
    this.clientDefined10CharCode3 = clientDefined10CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined20 char code1.
   *
   * @param  clientDefined20CharCode1  String
   */
  public void setClientDefined20CharCode1(String clientDefined20CharCode1) {
    this.clientDefined20CharCode1 = clientDefined20CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined20 char code2.
   *
   * @param  clientDefined20CharCode2  String
   */
  public void setClientDefined20CharCode2(String clientDefined20CharCode2) {
    this.clientDefined20CharCode2 = clientDefined20CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined20 char code3.
   *
   * @param  clientDefined20CharCode3  String
   */
  public void setClientDefined20CharCode3(String clientDefined20CharCode3) {
    this.clientDefined20CharCode3 = clientDefined20CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined20 char code4.
   *
   * @param  clientDefined20CharCode4  String
   */
  public void setClientDefined20CharCode4(String clientDefined20CharCode4) {
    this.clientDefined20CharCode4 = clientDefined20CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined20 char code5.
   *
   * @param  clientDefined20CharCode5  String
   */
  public void setClientDefined20CharCode5(String clientDefined20CharCode5) {
    this.clientDefined20CharCode5 = clientDefined20CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined3 char code1.
   *
   * @param  clientDefined3CharCode1  String
   */
  public void setClientDefined3CharCode1(String clientDefined3CharCode1) {
    this.clientDefined3CharCode1 = clientDefined3CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined3 char code2.
   *
   * @param  clientDefined3CharCode2  String
   */
  public void setClientDefined3CharCode2(String clientDefined3CharCode2) {
    this.clientDefined3CharCode2 = clientDefined3CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined3 char code3.
   *
   * @param  clientDefined3CharCode3  String
   */
  public void setClientDefined3CharCode3(String clientDefined3CharCode3) {
    this.clientDefined3CharCode3 = clientDefined3CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined3 char code4.
   *
   * @param  clientDefined3CharCode4  String
   */
  public void setClientDefined3CharCode4(String clientDefined3CharCode4) {
    this.clientDefined3CharCode4 = clientDefined3CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined3 char code5.
   *
   * @param  clientDefined3CharCode5  String
   */
  public void setClientDefined3CharCode5(String clientDefined3CharCode5) {
    this.clientDefined3CharCode5 = clientDefined3CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal1.
   *
   * @param  clientDefinedDecimal1  BigDecimal
   */
  public void setClientDefinedDecimal1(BigDecimal clientDefinedDecimal1) {
    this.clientDefinedDecimal1 = clientDefinedDecimal1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal2.
   *
   * @param  clientDefinedDecimal2  BigDecimal
   */
  public void setClientDefinedDecimal2(BigDecimal clientDefinedDecimal2) {
    this.clientDefinedDecimal2 = clientDefinedDecimal2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal3.
   *
   * @param  clientDefinedDecimal3  BigDecimal
   */
  public void setClientDefinedDecimal3(BigDecimal clientDefinedDecimal3) {
    this.clientDefinedDecimal3 = clientDefinedDecimal3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal4.
   *
   * @param  clientDefinedDecimal4  BigDecimal
   */
  public void setClientDefinedDecimal4(BigDecimal clientDefinedDecimal4) {
    this.clientDefinedDecimal4 = clientDefinedDecimal4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal5.
   *
   * @param  clientDefinedDecimal5  BigDecimal
   */
  public void setClientDefinedDecimal5(BigDecimal clientDefinedDecimal5) {
    this.clientDefinedDecimal5 = clientDefinedDecimal5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined flag1.
   *
   * @param  clientDefinedFlag1  Boolean
   */
  public void setClientDefinedFlag1(Boolean clientDefinedFlag1) {
    this.clientDefinedFlag1 = clientDefinedFlag1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined flag2.
   *
   * @param  clientDefinedFlag2  Boolean
   */
  public void setClientDefinedFlag2(Boolean clientDefinedFlag2) {
    this.clientDefinedFlag2 = clientDefinedFlag2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined flag3.
   *
   * @param  clientDefinedFlag3  Boolean
   */
  public void setClientDefinedFlag3(Boolean clientDefinedFlag3) {
    this.clientDefinedFlag3 = clientDefinedFlag3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined flag4.
   *
   * @param  clientDefinedFlag4  Boolean
   */
  public void setClientDefinedFlag4(Boolean clientDefinedFlag4) {
    this.clientDefinedFlag4 = clientDefinedFlag4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer1.
   *
   * @param  clientDefinedInteger1  Integer
   */
  public void setClientDefinedInteger1(Integer clientDefinedInteger1) {
    this.clientDefinedInteger1 = clientDefinedInteger1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer2.
   *
   * @param  clientDefinedInteger2  Integer
   */
  public void setClientDefinedInteger2(Integer clientDefinedInteger2) {
    this.clientDefinedInteger2 = clientDefinedInteger2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer3.
   *
   * @param  clientDefinedInteger3  Integer
   */
  public void setClientDefinedInteger3(Integer clientDefinedInteger3) {
    this.clientDefinedInteger3 = clientDefinedInteger3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for cmc sent date.
   *
   * @param  cmcSentDate  Date
   */
  public void setCmcSentDate(Date cmcSentDate) {
    this.cmcSentDate = cmcSentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for commission percentage.
   *
   * @param  commissionPercentage  BigDecimal
   */
  public void setCommissionPercentage(BigDecimal commissionPercentage) {
    this.commissionPercentage = commissionPercentage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for credit bureau reporting.
   *
   * @param  creditBureauReporting  Boolean
   */
  public void setCreditBureauReporting(Boolean creditBureauReporting) {
    this.creditBureauReporting = creditBureauReporting;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for customer type.
   *
   * @param  customerType  CustomerType
   */
  public void setCustomerType(CustomerType customerType) {
    this.customerType = customerType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for cycle date.
   *
   * @param  cycleDate  String
   */
  public void setCycleDate(String cycleDate) {
    this.cycleDate = cycleDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for date account sold.
   *
   * @param  dateAccountSold  Date
   */
  public void setDateAccountSold(Date dateAccountSold) {
    this.dateAccountSold = dateAccountSold;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for date assigned.
   *
   * @param  dateAssigned  Date
   */
  public void setDateAssigned(Date dateAssigned) {
    this.dateAssigned = dateAssigned;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for date of death.
   *
   * @param  dateOfDeath  Date
   */
  public void setDateOfDeath(Date dateOfDeath) {
    this.dateOfDeath = dateOfDeath;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for date of last comments.
   *
   * @param  dateOfLastComments  Date
   */
  public void setDateOfLastComments(Date dateOfLastComments) {
    this.dateOfLastComments = dateOfLastComments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for date received.
   *
   * @param  dateReceived  Date
   */
  public void setDateReceived(Date dateReceived) {
    this.dateReceived = dateReceived;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for date transferred to dead.
   *
   * @param  dateTransferredToDead  Date
   */
  public void setDateTransferredToDead(Date dateTransferredToDead) {
    this.dateTransferredToDead = dateTransferredToDead;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for debtor payment number.
   *
   * @param  debtorPaymentNumber  Integer
   */
  public void setDebtorPaymentNumber(Integer debtorPaymentNumber) {
    this.debtorPaymentNumber = debtorPaymentNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for excess recoveries.
   *
   * @param  excessRecoveries  BigDecimal
   */
  public void setExcessRecoveries(BigDecimal excessRecoveries) {
    this.excessRecoveries = excessRecoveries;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for express consent date.
   *
   * @param  expressConsentDate  Date
   */
  public void setExpressConsentDate(Date expressConsentDate) {
    this.expressConsentDate = expressConsentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for file location.
   *
   * @param  fileLocation  String
   */
  public void setFileLocation(String fileLocation) {
    this.fileLocation = fileLocation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for financial recoverer code.
   *
   * @param  financialRecovererCode  String
   */
  public void setFinancialRecovererCode(String financialRecovererCode) {
    this.financialRecovererCode = financialRecovererCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for frequency indicator.
   *
   * @param  frequencyIndicator  String
   */
  public void setFrequencyIndicator(String frequencyIndicator) {
    this.frequencyIndicator = frequencyIndicator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for frequency of contact.
   *
   * @param  frequencyOfContact  Integer
   */
  public void setFrequencyOfContact(Integer frequencyOfContact) {
    this.frequencyOfContact = frequencyOfContact;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for gl segment.
   *
   * @param  glSegment  String
   */
  public void setGlSegment(String glSegment) {
    this.glSegment = glSegment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for host balance.
   *
   * @param  hostBalance  BigDecimal
   */
  public void setHostBalance(BigDecimal hostBalance) {
    this.hostBalance = hostBalance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for hot comments line1.
   *
   * @param  hotCommentsLine1  String
   */
  public void setHotCommentsLine1(String hotCommentsLine1) {
    this.hotCommentsLine1 = hotCommentsLine1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for hot comments line2.
   *
   * @param  hotCommentsLine2  String
   */
  public void setHotCommentsLine2(String hotCommentsLine2) {
    this.hotCommentsLine2 = hotCommentsLine2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for initial delinquency date.
   *
   * @param  initialDelinquencyDate  Date
   */
  public void setInitialDelinquencyDate(Date initialDelinquencyDate) {
    this.initialDelinquencyDate = initialDelinquencyDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for judgment date.
   *
   * @param  judgmentDate  Date
   */
  public void setJudgmentDate(Date judgmentDate) {
    this.judgmentDate = judgmentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last agency1.
   *
   * @param  lastAgency1  String
   */
  public void setLastAgency1(String lastAgency1) {
    this.lastAgency1 = lastAgency1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last agency2.
   *
   * @param  lastAgency2  String
   */
  public void setLastAgency2(String lastAgency2) {
    this.lastAgency2 = lastAgency2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last agency3.
   *
   * @param  lastAgency3  String
   */
  public void setLastAgency3(String lastAgency3) {
    this.lastAgency3 = lastAgency3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last agency4.
   *
   * @param  lastAgency4  String
   */
  public void setLastAgency4(String lastAgency4) {
    this.lastAgency4 = lastAgency4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last agency5.
   *
   * @param  lastAgency5  String
   */
  public void setLastAgency5(String lastAgency5) {
    this.lastAgency5 = lastAgency5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last contact date.
   *
   * @param  lastContactDate  Date
   */
  public void setLastContactDate(Date lastContactDate) {
    this.lastContactDate = lastContactDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last interest date.
   *
   * @param  lastInterestDate  Date
   */
  public void setLastInterestDate(Date lastInterestDate) {
    this.lastInterestDate = lastInterestDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last status change date.
   *
   * @param  lastStatusChangeDate  Date
   */
  public void setLastStatusChangeDate(Date lastStatusChangeDate) {
    this.lastStatusChangeDate = lastStatusChangeDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last status code.
   *
   * @param  lastStatusCode  String
   */
  public void setLastStatusCode(String lastStatusCode) {
    this.lastStatusCode = lastStatusCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for late fees.
   *
   * @param  lateFees  BigDecimal
   */
  public void setLateFees(BigDecimal lateFees) {
    this.lateFees = lateFees;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for legal user defined amount3.
   *
   * @param  legalUserDefinedAmount3  BigDecimal
   */
  public void setLegalUserDefinedAmount3(BigDecimal legalUserDefinedAmount3) {
    this.legalUserDefinedAmount3 = legalUserDefinedAmount3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for legal user defined amount4.
   *
   * @param  legalUserDefinedAmount4  BigDecimal
   */
  public void setLegalUserDefinedAmount4(BigDecimal legalUserDefinedAmount4) {
    this.legalUserDefinedAmount4 = legalUserDefinedAmount4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for legal user defined amount6.
   *
   * @param  legalUserDefinedAmount6  BigDecimal
   */
  public void setLegalUserDefinedAmount6(BigDecimal legalUserDefinedAmount6) {
    this.legalUserDefinedAmount6 = legalUserDefinedAmount6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for legal user defined date2.
   *
   * @param  legalUserDefinedDate2  Date
   */
  public void setLegalUserDefinedDate2(Date legalUserDefinedDate2) {
    this.legalUserDefinedDate2 = legalUserDefinedDate2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for legal user defined date4.
   *
   * @param  legalUserDefinedDate4  Date
   */
  public void setLegalUserDefinedDate4(Date legalUserDefinedDate4) {
    this.legalUserDefinedDate4 = legalUserDefinedDate4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for legal user defined date5.
   *
   * @param  legalUserDefinedDate5  Date
   */
  public void setLegalUserDefinedDate5(Date legalUserDefinedDate5) {
    this.legalUserDefinedDate5 = legalUserDefinedDate5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for legal user defined date6.
   *
   * @param  legalUserDefinedDate6  Date
   */
  public void setLegalUserDefinedDate6(Date legalUserDefinedDate6) {
    this.legalUserDefinedDate6 = legalUserDefinedDate6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for legal user defined variable10.
   *
   * @param  legalUserDefinedVariable10  String
   */
  public void setLegalUserDefinedVariable10(String legalUserDefinedVariable10) {
    this.legalUserDefinedVariable10 = legalUserDefinedVariable10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for letter date.
   *
   * @param  letterDate  Date
   */
  public void setLetterDate(Date letterDate) {
    this.letterDate = letterDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for letter inhibit flag.
   *
   * @param  letterInhibitFlag  Boolean
   */
  public void setLetterInhibitFlag(Boolean letterInhibitFlag) {
    this.letterInhibitFlag = letterInhibitFlag;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for litigation.
   *
   * @param  litigation  String
   */
  public void setLitigation(String litigation) {
    this.litigation = litigation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for location or product code.
   *
   * @param  locationOrProductCode  String
   */
  public void setLocationOrProductCode(String locationOrProductCode) {
    this.locationOrProductCode = locationOrProductCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for monthly income.
   *
   * @param  monthlyIncome  BigDecimal
   */
  public void setMonthlyIncome(BigDecimal monthlyIncome) {
    this.monthlyIncome = monthlyIncome;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for monthly payments.
   *
   * @param  monthlyPayments  BigDecimal
   */
  public void setMonthlyPayments(BigDecimal monthlyPayments) {
    this.monthlyPayments = monthlyPayments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for next contact date.
   *
   * @param  nextContactDate  Date
   */
  public void setNextContactDate(Date nextContactDate) {
    this.nextContactDate = nextContactDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for next statement date.
   *
   * @param  nextStatementDate  Date
   */
  public void setNextStatementDate(Date nextStatementDate) {
    this.nextStatementDate = nextStatementDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for number of payments.
   *
   * @param  numberOfPayments  Integer
   */
  public void setNumberOfPayments(Integer numberOfPayments) {
    this.numberOfPayments = numberOfPayments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for orig COAmt.
   *
   * @param  origCOAmt  BigDecimal
   */
  public void setOrigCOAmt(BigDecimal origCOAmt) {
    this.origCOAmt = origCOAmt;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for original loan amount.
   *
   * @param  originalLoanAmount  BigDecimal
   */
  public void setOriginalLoanAmount(BigDecimal originalLoanAmount) {
    this.originalLoanAmount = originalLoanAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for other fees.
   *
   * @param  otherFees  BigDecimal
   */
  public void setOtherFees(BigDecimal otherFees) {
    this.otherFees = otherFees;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for other income.
   *
   * @param  otherIncome  BigDecimal
   */
  public void setOtherIncome(BigDecimal otherIncome) {
    this.otherIncome = otherIncome;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for other obligations.
   *
   * @param  otherObligations  BigDecimal
   */
  public void setOtherObligations(BigDecimal otherObligations) {
    this.otherObligations = otherObligations;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for own or rent code.
   *
   * @param  ownOrRentCode  String
   */
  public void setOwnOrRentCode(String ownOrRentCode) {
    this.ownOrRentCode = ownOrRentCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for past due amount.
   *
   * @param  pastDueAmount  BigDecimal
   */
  public void setPastDueAmount(BigDecimal pastDueAmount) {
    this.pastDueAmount = pastDueAmount;
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
   * setter method for payment apply code.
   *
   * @param  paymentApplyCode  String
   */
  public void setPaymentApplyCode(String paymentApplyCode) {
    this.paymentApplyCode = paymentApplyCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for payment due date.
   *
   * @param  paymentDueDate  Date
   */
  public void setPaymentDueDate(Date paymentDueDate) {
    this.paymentDueDate = paymentDueDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for payment due suspense date.
   *
   * @param  paymentDueSuspenseDate  Date
   */
  public void setPaymentDueSuspenseDate(Date paymentDueSuspenseDate) {
    this.paymentDueSuspenseDate = paymentDueSuspenseDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for payment schedule.
   *
   * @param  paymentSchedule  String
   */
  public void setPaymentSchedule(String paymentSchedule) {
    this.paymentSchedule = paymentSchedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for payment term.
   *
   * @param  paymentTerm  Integer
   */
  public void setPaymentTerm(Integer paymentTerm) {
    this.paymentTerm = paymentTerm;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for payment type.
   *
   * @param  paymentType  String
   */
  public void setPaymentType(String paymentType) {
    this.paymentType = paymentType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for place of employment.
   *
   * @param  placeOfEmployment  String
   */
  public void setPlaceOfEmployment(String placeOfEmployment) {
    this.placeOfEmployment = placeOfEmployment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for prev stmt balance.
   *
   * @param  prevStmtBalance  BigDecimal
   */
  public void setPrevStmtBalance(BigDecimal prevStmtBalance) {
    this.prevStmtBalance = prevStmtBalance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for purchase price.
   *
   * @param  purchasePrice  BigDecimal
   */
  public void setPurchasePrice(BigDecimal purchasePrice) {
    this.purchasePrice = purchasePrice;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for recovered costs.
   *
   * @param  recoveredCosts  BigDecimal
   */
  public void setRecoveredCosts(BigDecimal recoveredCosts) {
    this.recoveredCosts = recoveredCosts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for recovered interest.
   *
   * @param  recoveredInterest  BigDecimal
   */
  public void setRecoveredInterest(BigDecimal recoveredInterest) {
    this.recoveredInterest = recoveredInterest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for recovered late fees.
   *
   * @param  recoveredLateFees  BigDecimal
   */
  public void setRecoveredLateFees(BigDecimal recoveredLateFees) {
    this.recoveredLateFees = recoveredLateFees;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for recovered other fees.
   *
   * @param  recoveredOtherFees  BigDecimal
   */
  public void setRecoveredOtherFees(BigDecimal recoveredOtherFees) {
    this.recoveredOtherFees = recoveredOtherFees;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for recovered principal.
   *
   * @param  recoveredPrincipal  BigDecimal
   */
  public void setRecoveredPrincipal(BigDecimal recoveredPrincipal) {
    this.recoveredPrincipal = recoveredPrincipal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for second first name.
   *
   * @param  secondFirstName  String
   */
  public void setSecondFirstName(String secondFirstName) {
    this.secondFirstName = secondFirstName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for second last name.
   *
   * @param  secondLastName  String
   */
  public void setSecondLastName(String secondLastName) {
    this.secondLastName = secondLastName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for settlement amount.
   *
   * @param  settlementAmount  BigDecimal
   */
  public void setSettlementAmount(BigDecimal settlementAmount) {
    this.settlementAmount = settlementAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for settlement code.
   *
   * @param  settlementCode  String
   */
  public void setSettlementCode(String settlementCode) {
    this.settlementCode = settlementCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for settlement percent.
   *
   * @param  settlementPercent  BigDecimal
   */
  public void setSettlementPercent(BigDecimal settlementPercent) {
    this.settlementPercent = settlementPercent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for settlement type.
   *
   * @param  settlementType  String
   */
  public void setSettlementType(String settlementType) {
    this.settlementType = settlementType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for source code.
   *
   * @param  sourceCode  String
   */
  public void setSourceCode(String sourceCode) {
    this.sourceCode = sourceCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for usb account id.
   *
   * @param  usbAccountId  Long
   */
  public void setUsbAccountId(Long usbAccountId) {
    this.usbAccountId = usbAccountId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for user defined alpha2.
   *
   * @param  userDefinedAlpha2  String
   */
  public void setUserDefinedAlpha2(String userDefinedAlpha2) {
    this.userDefinedAlpha2 = userDefinedAlpha2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for user defined alpha4.
   *
   * @param  userDefinedAlpha4  String
   */
  public void setUserDefinedAlpha4(String userDefinedAlpha4) {
    this.userDefinedAlpha4 = userDefinedAlpha4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for user defined amount1.
   *
   * @param  userDefinedAmount1  BigDecimal
   */
  public void setUserDefinedAmount1(BigDecimal userDefinedAmount1) {
    this.userDefinedAmount1 = userDefinedAmount1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for user defined amount3.
   *
   * @param  userDefinedAmount3  BigDecimal
   */
  public void setUserDefinedAmount3(BigDecimal userDefinedAmount3) {
    this.userDefinedAmount3 = userDefinedAmount3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for user defined date1.
   *
   * @param  userDefinedDate1  Date
   */
  public void setUserDefinedDate1(Date userDefinedDate1) {
    this.userDefinedDate1 = userDefinedDate1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for user defined date5.
   *
   * @param  userDefinedDate5  Date
   */
  public void setUserDefinedDate5(Date userDefinedDate5) {
    this.userDefinedDate5 = userDefinedDate5;
  }

} // end class USBAccount
