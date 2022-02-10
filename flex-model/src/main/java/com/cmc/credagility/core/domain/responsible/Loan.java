package com.cmc.credagility.core.domain.responsible;

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.springframework.util.StringUtils;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;
import com.cmc.credagility.core.jpa.converter.StringEncryptionConverter;


/**
 * This class is used to store Loan information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/17/2014 10:29
 */
@Entity
@Table(
  name              = "Loan",
  uniqueConstraints = {
    @UniqueConstraint(
      name          = "loanIdentifier",
      columnNames   = { "loanIdentifier", "responsibleId" }
    )
  }
)
public class Loan extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 1L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Relations Loan Responsible : */
  @JoinColumn(name = "responsibleId")
  @ManyToOne(cascade = CascadeType.ALL)
  protected Responsible responsible;

  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean active;
  @Column(
    name   = "artivaState",
    length = 20
  )
  private String  artivaState;
  @Column(
    name   = "billingSequenceNumber",
    length = 4
  )
  private String  billingSequenceNumber;

  @Column(
    name   = "borrowerSuffix",
    length = 1
  )
  private String borrowerSuffix;
  @Column(
    name   = "category",
    length = 1
  )
  private String category;

  // npelleti 08/17 changed type to date.
  @Column(name = "chargeOffDate")
  @Temporal(TemporalType.DATE)
  private Date chargeOffDate;

  @Column(
    name   = "claimStatusCode",
    length = 6
  )
  private String claimStatusCode;

  @Column(
    name   = "claimTypeCode",
    length = 6
  )
  private String claimTypeCode;

  @Column(
    name   = "currentBalance",
    length = 11
  )
  private BigDecimal currentBalance;
  @Column(
    name   = "currentMonthlyDueAmount",
    length = 9
  )
  private BigDecimal currentMonthlyDueAmount;

  // npelleti 08/17 changed type to date.
  @Column(name = "delinquencyDate")
  @Temporal(TemporalType.DATE)
  private Date delinquencyDate;

  @Column(
    name   = "disbursementAmount",
    length = 11
  )
  private BigDecimal disbursementAmount;

  // npelleti 8/17 USB changed datatype to date
  @Column(name = "disbursementDate")
  @Temporal(TemporalType.DATE)
  private Date disbursementDate;

  @Column(
    name   = "fdrAccountNumber",
    length = 18
  )
  private String fdrAccountNumber;


  @Column(
    name      = "fdrDelinquentAllocation",
    precision = 19,
    scale     = 4
  )
  private BigDecimal fdrDelinquentAllocation;

  @Column(
    name   = "fdrGroupingNumber",
    length = 18
  )
  private String fdrGroupingNumber;

  @Column(
    name   = "fdrKeyAccountNumber",
    length = 18
  )
  private String fdrKeyAccountNumber;

  @Column(
    name      = "fdrPaymentAllocation",
    precision = 19,
    scale     = 4
  )
  private BigDecimal fdrPaymentAllocation;

  @Column(name = "forbearanceMonthsUsed")
  private Long forbearanceMonthsUsed;

  @Column(
    name   = "futureAgreement1",
    length = 1
  )
  private String futureAgreement1;
  @Column(
    name   = "futureAgreement2",
    length = 1
  )
  private String futureAgreement2;
  @Column(
    name   = "futureAgreement3",
    length = 1
  )
  private String futureAgreement3;

  @Column(
    name   = "futureSelecion1",
    length = 1
  )
  private String     futureSelecion1;
  @Column(
    name   = "futureSelecion2",
    length = 1
  )
  private String     futureSelecion2;
  @Column(
    name   = "futureSelecion3",
    length = 1
  )
  private String     futureSelecion3;
  @Column(
    name   = "lastPaymentAmount",
    length = 11
  )
  private BigDecimal lastPaymentAmount;

  // npelleti 08/17 changed type to date.
  @Column(name = "lastPaymentDate")
  @Temporal(TemporalType.DATE)
  private Date lastPaymentDate;

  @Column(
    name   = "lenderBranchID",
    length = 6
  )
  private String lenderBranchID;

  @Column(
    name   = "loanAccountNumber",
    length = 80
  )
  @Convert(converter = StringEncryptionConverter.class)
  private String loanAccountNumber;

  @Column(
    name     = "loanId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long loanId;

  @Column(
    name   = "loanIdentifier",
    length = 14
  )
  private String loanIdentifier;

  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean loanModification;

  @Column(
    name   = "loanProgramName",
    length = 50
  )
  private String loanProgramName;

  @Column(
    name   = "minPaymentAmount",
    length = 9
  )
  private BigDecimal minPaymentAmount;

  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean modificationAggreement;

  @Column(name = "nextPayDueDate")
  @Temporal(TemporalType.DATE)
  private Date       nextPayDueDate;
  @Column(
    name   = "pastDueAmount",
    length = 11
  )
  private BigDecimal pastDueAmount;

  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean selectStep;

  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean selectStepAggreeement;

  @Column(
    name   = "sequenceNumber",
    length = 4
  )
  private String sequenceNumber;
  @Column(
    name   = "servicerAddress",
    length = 150
  )
  private String servicerAddress;

  @Column(
    name   = "servicerName",
    length = 25
  )
  private String servicerName;

  @Column(
    name   = "servicerPhoneNum",
    length = 20
  )
  private String servicerPhoneNum;

  // added the below columns for FEELP - Pratibha
  @Column(
    name   = "servicingSystemIndicator",
    length = 1
  )
  private String servicingSystemIndicator;

  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean settlement;

  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean settlementAgreement;

  @Column(
    name   = "settlementPercentage",
    length = 7
  )
  private BigDecimal settlementPercentage;

  @Column(
    name   = "suggestedPayAmount",
    length = 9
  )
  private BigDecimal suggestedPayAmount;

  @Column(
    name   = "totalDue",
    length = 11
  )
  private BigDecimal totalDue;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for active.
   *
   * @return  Boolean
   */
  public Boolean getActive() {
    return active;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for artiva state.
   *
   * @return  String
   */
  public String getArtivaState() {
    return artivaState;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for billing sequence number.
   *
   * @return  String
   */
  public String getBillingSequenceNumber() {
    return billingSequenceNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for borrower suffix.
   *
   * @return  String
   */
  public String getBorrowerSuffix() {
    return borrowerSuffix;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for category.
   *
   * @return  String
   */
  public String getCategory() {
    return category;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for charge off date.
   *
   * @return  Date
   */
  public Date getChargeOffDate() {
    return chargeOffDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for claim status code.
   *
   * @return  String
   */
  public String getClaimStatusCode() {
    return claimStatusCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for claim type code.
   *
   * @return  String
   */
  public String getClaimTypeCode() {
    return claimTypeCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for current balance.
   *
   * @return  BigDecimal
   */
  public BigDecimal getCurrentBalance() {
    return currentBalance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for current monthly due amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getCurrentMonthlyDueAmount() {
    return currentMonthlyDueAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for delinquency date.
   *
   * @return  Date
   */
  public Date getDelinquencyDate() {
    return delinquencyDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for disbursement amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getDisbursementAmount() {
    return disbursementAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for disbursement date.
   *
   * @return  Date
   */
  public Date getDisbursementDate() {
    return disbursementDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for fdr account number.
   *
   * @return  String
   */
  public String getFdrAccountNumber() {
    return fdrAccountNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for fdr delinquent allocation.
   *
   * @return  BigDecimal
   */
  public BigDecimal getFdrDelinquentAllocation() {
    return fdrDelinquentAllocation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for fdr grouping number.
   *
   * @return  String
   */
  public String getFdrGroupingNumber() {
    return fdrGroupingNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for fdr key account number.
   *
   * @return  String
   */
  public String getFdrKeyAccountNumber() {
    return fdrKeyAccountNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for fdr payment allocation.
   *
   * @return  BigDecimal
   */
  public BigDecimal getFdrPaymentAllocation() {
    return fdrPaymentAllocation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for forbearance months used.
   *
   * @return  Long
   */
  public Long getForbearanceMonthsUsed() {
    return forbearanceMonthsUsed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for future agreement1.
   *
   * @return  String
   */
  public String getFutureAgreement1() {
    return futureAgreement1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for future agreement2.
   *
   * @return  String
   */
  public String getFutureAgreement2() {
    return futureAgreement2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for future agreement3.
   *
   * @return  String
   */
  public String getFutureAgreement3() {
    return futureAgreement3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for future selecion1.
   *
   * @return  String
   */
  public String getFutureSelecion1() {
    return futureSelecion1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for future selecion2.
   *
   * @return  String
   */
  public String getFutureSelecion2() {
    return futureSelecion2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for future selecion3.
   *
   * @return  String
   */
  public String getFutureSelecion3() {
    return futureSelecion3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last payment amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getLastPaymentAmount() {
    return lastPaymentAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last payment date.
   *
   * @return  Date
   */
  public Date getLastPaymentDate() {
    return lastPaymentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for lender branch ID.
   *
   * @return  String
   */
  public String getLenderBranchID() {
    return lenderBranchID;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for loan account number.
   *
   * @return  String
   */
  public String getLoanAccountNumber() {
    return loanAccountNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for loan id.
   *
   * @return  Long
   */
  public Long getLoanId() {
    return loanId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for loan identifier.
   *
   * @return  String
   */
  public String getLoanIdentifier() {
    return loanIdentifier;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for loan modification.
   *
   * @return  Boolean
   */
  public Boolean getLoanModification() {
    return loanModification;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for loan program name.
   *
   * @return  String
   */
  public String getLoanProgramName() {
    return loanProgramName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for loan type.
   *
   * @return  String
   */
  public String getLoanType() {
    String  loanBranchId    = getLenderBranchID();
    Integer loanBranchIdInt = null;

    if (StringUtils.hasText(loanBranchId)) {
      loanBranchIdInt = Integer.valueOf(loanBranchId);

      if ((getCurrentBalance() != null)
            && ((loanBranchIdInt < 4999)
              || ((loanBranchIdInt > 6000) && (loanBranchIdInt
                  < 9999)))) {
        return "SUBSIDIZED";
      }
    }

    return "UNSUBSIDIZED";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for min payment amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getMinPaymentAmount() {
    return minPaymentAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for modification aggreement.
   *
   * @return  Boolean
   */
  public Boolean getModificationAggreement() {
    return modificationAggreement;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for next pay due date.
   *
   * @return  Date
   */
  public Date getNextPayDueDate() {
    return nextPayDueDate;
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
   * getter method for responsible.
   *
   * @return  Responsible
   */
  public Responsible getResponsible() {
    return responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for select step.
   *
   * @return  Boolean
   */
  public Boolean getSelectStep() {
    return selectStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for select step aggreeement.
   *
   * @return  Boolean
   */
  public Boolean getSelectStepAggreeement() {
    return selectStepAggreeement;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for sequence number.
   *
   * @return  String
   */
  public String getSequenceNumber() {
    return sequenceNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for servicer address.
   *
   * @return  String
   */
  public String getServicerAddress() {
    return servicerAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for servicer name.
   *
   * @return  String
   */
  public String getServicerName() {
    return servicerName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for servicer phone num.
   *
   * @return  String
   */
  public String getServicerPhoneNum() {
    return servicerPhoneNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for servicing system indicator.
   *
   * @return  String
   */
  public String getServicingSystemIndicator() {
    return servicingSystemIndicator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for settlement.
   *
   * @return  Boolean
   */
  public Boolean getSettlement() {
    return settlement;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for settlement agreement.
   *
   * @return  Boolean
   */
  public Boolean getSettlementAgreement() {
    return settlementAgreement;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for settlement percentage.
   *
   * @return  BigDecimal
   */
  public BigDecimal getSettlementPercentage() {
    return settlementPercentage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for suggested pay amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getSuggestedPayAmount() {
    return suggestedPayAmount;
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
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = 1;
    result = (prime * result)
      + ((loanIdentifier == null) ? 0 : loanIdentifier.hashCode());
    result = (prime * result)
      + ((loanProgramName == null) ? 0 : loanProgramName.hashCode());
    result = (prime * result)
      + ((sequenceNumber == null) ? 0 : sequenceNumber.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for active.
   *
   * @param  active  Boolean
   */
  public void setActive(Boolean active) {
    this.active = active;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for artiva state.
   *
   * @param  artivaState  String
   */
  public void setArtivaState(String artivaState) {
    this.artivaState = artivaState;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for billing sequence number.
   *
   * @param  billingSequenceNumber  String
   */
  public void setBillingSequenceNumber(String billingSequenceNumber) {
    this.billingSequenceNumber = billingSequenceNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for borrower suffix.
   *
   * @param  borrowerSuffix  String
   */
  public void setBorrowerSuffix(String borrowerSuffix) {
    this.borrowerSuffix = borrowerSuffix;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for category.
   *
   * @param  category  String
   */
  public void setCategory(String category) {
    this.category = category;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for charge off date.
   *
   * @param  chargeOffDate  Date
   */
  public void setChargeOffDate(Date chargeOffDate) {
    this.chargeOffDate = chargeOffDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for claim status code.
   *
   * @param  claimStatusCode  String
   */
  public void setClaimStatusCode(String claimStatusCode) {
    this.claimStatusCode = claimStatusCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for claim type code.
   *
   * @param  claimTypeCode  String
   */
  public void setClaimTypeCode(String claimTypeCode) {
    this.claimTypeCode = claimTypeCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for current balance.
   *
   * @param  currentBalance  BigDecimal
   */
  public void setCurrentBalance(BigDecimal currentBalance) {
    this.currentBalance = currentBalance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for current monthly due amount.
   *
   * @param  currentMonthlyDueAmount  BigDecimal
   */
  public void setCurrentMonthlyDueAmount(BigDecimal currentMonthlyDueAmount) {
    this.currentMonthlyDueAmount = currentMonthlyDueAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for delinquency date.
   *
   * @param  delinquencyDate  Date
   */
  public void setDelinquencyDate(Date delinquencyDate) {
    this.delinquencyDate = delinquencyDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for disbursement amount.
   *
   * @param  disbursementAmount  BigDecimal
   */
  public void setDisbursementAmount(BigDecimal disbursementAmount) {
    this.disbursementAmount = disbursementAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for disbursement date.
   *
   * @param  disbursementDate  Date
   */
  public void setDisbursementDate(Date disbursementDate) {
    this.disbursementDate = disbursementDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for fdr account number.
   *
   * @param  fdrAccountNumber  String
   */
  public void setFdrAccountNumber(String fdrAccountNumber) {
    this.fdrAccountNumber = fdrAccountNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for fdr delinquent allocation.
   *
   * @param  fdrDelinquentAllocation  BigDecimal
   */
  public void setFdrDelinquentAllocation(BigDecimal fdrDelinquentAllocation) {
    this.fdrDelinquentAllocation = fdrDelinquentAllocation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for fdr grouping number.
   *
   * @param  fdrGroupingNumber  String
   */
  public void setFdrGroupingNumber(String fdrGroupingNumber) {
    this.fdrGroupingNumber = fdrGroupingNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for fdr key account number.
   *
   * @param  fdrKeyAccountNumber  String
   */
  public void setFdrKeyAccountNumber(String fdrKeyAccountNumber) {
    this.fdrKeyAccountNumber = fdrKeyAccountNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for fdr payment allocation.
   *
   * @param  fdrPaymentAllocation  BigDecimal
   */
  public void setFdrPaymentAllocation(BigDecimal fdrPaymentAllocation) {
    this.fdrPaymentAllocation = fdrPaymentAllocation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for forbearance months used.
   *
   * @param  forbearanceMonthsUsed  Long
   */
  public void setForbearanceMonthsUsed(Long forbearanceMonthsUsed) {
    this.forbearanceMonthsUsed = forbearanceMonthsUsed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for future agreement1.
   *
   * @param  futureAgreement1  String
   */
  public void setFutureAgreement1(String futureAgreement1) {
    this.futureAgreement1 = futureAgreement1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for future agreement2.
   *
   * @param  futureAgreement2  String
   */
  public void setFutureAgreement2(String futureAgreement2) {
    this.futureAgreement2 = futureAgreement2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for future agreement3.
   *
   * @param  futureAgreement3  String
   */
  public void setFutureAgreement3(String futureAgreement3) {
    this.futureAgreement3 = futureAgreement3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for future selecion1.
   *
   * @param  futureSelecion1  String
   */
  public void setFutureSelecion1(String futureSelecion1) {
    this.futureSelecion1 = futureSelecion1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for future selecion2.
   *
   * @param  futureSelecion2  String
   */
  public void setFutureSelecion2(String futureSelecion2) {
    this.futureSelecion2 = futureSelecion2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for future selecion3.
   *
   * @param  futureSelecion3  String
   */
  public void setFutureSelecion3(String futureSelecion3) {
    this.futureSelecion3 = futureSelecion3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last payment amount.
   *
   * @param  lastPaymentAmount  BigDecimal
   */
  public void setLastPaymentAmount(BigDecimal lastPaymentAmount) {
    this.lastPaymentAmount = lastPaymentAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last payment date.
   *
   * @param  lastPaymentDate  Date
   */
  public void setLastPaymentDate(Date lastPaymentDate) {
    this.lastPaymentDate = lastPaymentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for lender branch ID.
   *
   * @param  lenderBranchID  String
   */
  public void setLenderBranchID(String lenderBranchID) {
    this.lenderBranchID = lenderBranchID;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for loan account number.
   *
   * @param  loanAccountNumber  String
   */
  public void setLoanAccountNumber(String loanAccountNumber) {
    this.loanAccountNumber = loanAccountNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for loan id.
   *
   * @param  loanId  Long
   */
  public void setLoanId(Long loanId) {
    this.loanId = loanId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for loan identifier.
   *
   * @param  loanIdentifier  String
   */
  public void setLoanIdentifier(String loanIdentifier) {
    this.loanIdentifier = loanIdentifier;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for loan modification.
   *
   * @param  loanModification  Boolean
   */
  public void setLoanModification(Boolean loanModification) {
    this.loanModification = loanModification;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for loan program name.
   *
   * @param  loanProgramName  String
   */
  public void setLoanProgramName(String loanProgramName) {
    this.loanProgramName = loanProgramName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for min payment amount.
   *
   * @param  minPaymentAmount  BigDecimal
   */
  public void setMinPaymentAmount(BigDecimal minPaymentAmount) {
    this.minPaymentAmount = minPaymentAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for modification aggreement.
   *
   * @param  modificationAggreement  Boolean
   */
  public void setModificationAggreement(Boolean modificationAggreement) {
    this.modificationAggreement = modificationAggreement;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for next pay due date.
   *
   * @param  nextPayDueDate  Date
   */
  public void setNextPayDueDate(Date nextPayDueDate) {
    this.nextPayDueDate = nextPayDueDate;
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
   * setter method for responsible.
   *
   * @param  responsible  Responsible
   */
  public void setResponsible(Responsible responsible) {
    this.responsible = responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for select step.
   *
   * @param  selectStep  Boolean
   */
  public void setSelectStep(Boolean selectStep) {
    this.selectStep = selectStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for select step aggreeement.
   *
   * @param  selectStepAggreeement  Boolean
   */
  public void setSelectStepAggreeement(Boolean selectStepAggreeement) {
    this.selectStepAggreeement = selectStepAggreeement;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for sequence number.
   *
   * @param  sequenceNumber  String
   */
  public void setSequenceNumber(String sequenceNumber) {
    this.sequenceNumber = sequenceNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for servicer address.
   *
   * @param  servicerAddress  String
   */
  public void setServicerAddress(String servicerAddress) {
    this.servicerAddress = servicerAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for servicer name.
   *
   * @param  servicerName  String
   */
  public void setServicerName(String servicerName) {
    this.servicerName = servicerName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for servicer phone num.
   *
   * @param  servicerPhoneNum  String
   */
  public void setServicerPhoneNum(String servicerPhoneNum) {
    this.servicerPhoneNum = servicerPhoneNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for servicing system indicator.
   *
   * @param  servicingSystemIndicator  String
   */
  public void setServicingSystemIndicator(String servicingSystemIndicator) {
    this.servicingSystemIndicator = servicingSystemIndicator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for settlement.
   *
   * @param  settlement  Boolean
   */
  public void setSettlement(Boolean settlement) {
    this.settlement = settlement;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for settlement agreement.
   *
   * @param  settlementAgreement  Boolean
   */
  public void setSettlementAgreement(Boolean settlementAgreement) {
    this.settlementAgreement = settlementAgreement;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for settlement percentage.
   *
   * @param  settlementPercentage  BigDecimal
   */
  public void setSettlementPercentage(BigDecimal settlementPercentage) {
    this.settlementPercentage = settlementPercentage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for suggested pay amount.
   *
   * @param  suggestedPayAmount  BigDecimal
   */
  public void setSuggestedPayAmount(BigDecimal suggestedPayAmount) {
    this.suggestedPayAmount = suggestedPayAmount;
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
} // end class Loan
