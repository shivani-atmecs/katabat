package com.cmc.credagility.core.domain.payment;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

import org.hibernate.annotations.Target;
import org.hibernate.annotations.Type;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.type.PaymentChannel;
import com.cmc.credagility.core.domain.type.PaymentStatus;
import com.cmc.credagility.core.domain.util.CompareUtil;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * This class is used to store funding account change information.
 *
 * <p><a href="PaymentAudit.java.html"><i>View Source</i></a></p>
 *
 * @author   DOCUMENT ME!
 * @version  $Revision$, $Date$
 *
 * @hibernate.class
 *   table = "PaymentAudit"
 */
@Entity
@Table(name = "PaymentAudit")
public class PaymentAudit extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -9155076698123660415L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** agent id - used for performance tracking purpose. */
  @Column(name = "acceptAgentId")
  protected Long acceptAgentId;

  /** account balance. */
  @Column(name = "accountBalance")
  protected BigDecimal accountBalance;

  /** account charge off amount. */
  @Column(name = "accountChargeOffAmount")
  protected BigDecimal accountChargeOffAmount;

  /** DOCUMENT ME! */
  @Column(name = "accountNum")
  protected Long accountNum;

  /** DOCUMENT ME! */
  @Column(name = "agentCallActivityId")
  protected Long agentCallActivityId;

  /** DOCUMENT ME! */
  @Column(name = "agentUpdatedPaymentDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date agentUpdatedPaymentDate;


  /** DOCUMENT ME! */
  @Column(name = "aggregatedPaymentId")
  protected Long aggregatedPaymentId;

  /** payment amount. */
  @Column(
    name      = "amount",
    precision = 19,
    scale     = 2
  )
  protected BigDecimal amount;

  /** DOCUMENT ME! */
  @Column(
    name             = "applied",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean applied = Boolean.FALSE;

  /** DOCUMENT ME! */
  @Column(
    name      = "appliedAmount",
    precision = 19,
    scale     = 2
  )
  protected BigDecimal appliedAmount;

  /** DOCUMENT ME! */
  @Column(name = "appliedToProgramAmount")
  protected BigDecimal appliedToProgramAmount;


  /** payment auth Code. */
  @Column(
    name   = "authCode",
    length = 20
  )
  protected String authCode;

  /**
   * Payment could come from client batch file. Then it should have a batch date. batchDate is normally the date we
   * received the file
   */
  @Column(name = "batchDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date batchDate;

  /** batchRunTimeStamp is when the batch job was run for this particular batch file. */
  @Column(name = "batchRunTimeStamp")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date batchRunTimeStamp;

  /** Fee charged to CMC by payment service provider. */
  @Column(name = "billerServiceFee")
  protected BigDecimal billerServiceFee = new BigDecimal("0.0");

  /** DOCUMENT ME! */
  @Column(name = "billingGroupId")
  protected Long billingGroupId;

  /** DOCUMENT ME! */
  @Column(name = "cancellationLetterSentDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date cancellationLetterSentDate;

  /** Check number if it was the check payment. */
  @Column(
    name   = "checkNumber",
    length = 10
  )
  protected String checkNumber;

  /** commission money. */
  @Column(name = "commission")
  protected BigDecimal commission;


  /** DOCUMENT ME! */
  @Column(
    name   = "currency",
    length = 255
  )
  protected String currency;


  /** deleted agent. */
  @Column(name = "deletedAgentId")
  protected Long deletedAgentId;

  /** DOCUMENT ME! */
  @Column(name = "deletedStatusDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date deletedStatusDate;

  /** DOCUMENT ME! */
  @Column(name = "externalEntityId")
  protected Long externalEntityId;


  /** DOCUMENT ME! */

  /** DOCUMENT ME! */
  @Column(
    name   = "externalReferenceNumber",
    length = 125
  )
  protected String externalReferenceNumber;

  /** payment processing fee. */
  @Column(
    name      = "fee",
    precision = 19,
    scale     = 2
  )
  protected BigDecimal fee = new BigDecimal("0.0");

  /**
   * The date our payment processor deposit money into our account. We normally do not know that - we need to write a
   * program to load that.
   */
  @Column(name = "fundedDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date fundedDate;

  /** this will be persisted. */
  @Column(name = "fundingAccountId")
  protected Long fundingAccountId;

  /** Funding Object information, keep a copy from funding account. */
  @Embedded
  @Target(FundingInformation.class)
  protected FundingInformation           fundingInformation = new FundingInformation();

  /** insertby. */
  @Column(
    name   = "insertBy",
    length = 20
  )
  protected String insertBy = "WEB";

  /** DOCUMENT ME! */
  @Column(
    name   = "internalReferenceNumber",
    length = 125
  )
  protected String internalReferenceNumber;


  /** DOCUMENT ME! */
  @Column(name = "invoiceCommission")
  protected BigDecimal invoiceCommission;

  /** DOCUMENT ME! */
  @Column(
    name   = "invoiceCommissionType",
    length = 25
  )
  protected String invoiceCommissionType;

  /** DOCUMENT ME! */

  /** DOCUMENT ME! */
  @Column(name = "invoiceDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date invoiceDate;


  /** DOCUMENT ME! */
  @Column(name = "lastUpdatedResponsibleId")
  protected Long lastUpdatedResponsibleId;

  /**
   * Maximum Payment Date - the last day which the payment could be accepted, it should be initialized when the program
   * offer was accepted.This date is calculated as: = Date To Accept Program +
   * PaymentProgram.allowedInstallmentDateRange After this payment program is accepted and future installment payments
   * have been scheduled, if the debtor try to edit the payment date for this payment program, he can not choose a date
   * after installmentDueDate without unregister this payment program.
   *
   * <p>For Dev CA-5124 AC#8</p>
   */
  @Column(name = "maxPaymentDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date maxPaymentDate;

  /** DOCUMENT ME! */
  @Column(
    name   = "merchantAccountId",
    length = 200
  )
  protected String merchantAccountId;

  /** Order of the installment within payment program. Starting from 1. */
  @Column(name = "installmentOrder")
  protected Integer order;

  /** DOCUMENT ME! */
  @Column(name = "paidStatusDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date paidStatusDate;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "paymentAllocated",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean paymentAllocated = Boolean.FALSE;

  /** DOCUMENT ME! */
  @Column(
    name     = "paymentAuditId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long paymentAuditId;

  /** payment channel. */
  @Column(
    name   = "paymentChannel",
    length = 20
  )
  @Enumerated(EnumType.STRING)
  protected PaymentChannel paymentChannel;

  // npelleti 08/17 Made PaymentDate column not null
  /** payment date. */
  @Column(name = "paymentDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date paymentDate;

  /** DOCUMENT ME! */
  @Column(
    name   = "paymentDeletedSource",
    length = 20
  )
  @Enumerated(EnumType.STRING)
  protected PaymentChannel paymentDeletedSource;

  /** DOCUMENT ME! */
  @Column(
    name   = "paymentDetail",
    length = 1000
  )
  protected String paymentDetail;

  /** DOCUMENT ME! */


  @Column(name = "paymentGroupId")
  protected Long paymentGroupId;

  // npelleti 08/17 rem. unique constraint.
  /** payment PK paymentId. */
  @Column(name = "paymentId")
  protected Long paymentId;

  /** DOCUMENT ME! */
  @Embedded protected PaymentReminder paymentReminder = new PaymentReminder();

  // npelleti 08/11 made payment status not null
  /** payment status - Processed, Scheduled, Rejected, NSF. */
  @Column(
    name   = "paymentStatus",
    length = 20
  )
  @Enumerated(EnumType.STRING)
  protected PaymentStatus paymentStatus;

  // npelleti 08/16 specified length of of 20
  /** payment status code - returned to CMC by the payment processor. */
  @Column(
    name   = "paymentStatusCode",
    length = 20
  )
  protected String paymentStatusCode;

  /** DOCUMENT ME! */
  @Transient protected String paymentStatusLink;

  /** DOCUMENT ME! */
  @Column(
    name   = "paymentType",
    length = 255
  )
  protected String paymentType;

  /** File export date. This is required by COFS to post a payment file to FDR */
  @Column(name = "postDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date postDate;

  /** The exact date this payment is sent to ITS HTTPS interface. */
  @Column(name = "processDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date processDate;

  /** The flag showing that the payment was processed by batch job. */
  @Column(
    name             = "processedByBatch",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean processedByBatch;

  /** A flag to indicate that the payment has been taken into consideration towards evaluating a promise fulfilment. */
  @Column(
    name             = "processedByPTP",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean processedByPTP = Boolean.FALSE;

  /** payment program. */
  @Column(name = "programId")
  protected Long programId;

  /** payment program installment - nullable. */
  @Column(name = "programInstallmentId")
  protected Long programInstallmentId;

  /** DOCUMENT ME! */
  @Column(name = "promiseId")
  protected Long promiseId;

  /** payment service provider. */
  @Column(name = "providerId")
  protected Long providerId;


  /** DOCUMENT ME! */
  @Column(name = "rejectedAtAuthorizationDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date rejectedAtAuthorizationDate;

  /** DOCUMENT ME! */
  @Column(name = "rejectedStatusDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date rejectedStatusDate;

  /** DOCUMENT ME! */
  @Column(name = "responsibleId")
  protected Long responsibleId;

  /** count retry time. */
  @Column(name = "retryCount")
  protected Integer retryCount = 0;


  /** DOCUMENT ME! */
  @Column(
    name   = "statusDescription",
    length = 250
  )
  protected String statusDescription;

  /** shortcut to identify whether this is a test payment. all payment submitted to test accounts are test payment */
  @Column(name = "testPayment")
  @Type(type = "yes_no")
  protected Boolean testPayment = false;

  /** TODO: DOCUMENT ME! */
  @Column(name = "thirdParty")
  @Type(type = "yes_no")
  protected Boolean thirdParty = false;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "thirdPartyEmailAddress",
    length = 128
  )
  protected String thirdPartyEmailAddress;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "thirdPartyName",
    length = 150
  )
  protected String thirdPartyName;

  /** DOCUMENT ME! */
  @Column(name = "trancheInfoId")
  protected Long trancheInfoId;

  /** DOCUMENT ME! */


  /** DOCUMENT ME! */
  @Column(
    name   = "transactionReferenceNumber",
    length = 50
  )
  protected String transactionReferenceNumber;

  /** updated payment agent id - used for performance tracking purpose. */
  protected Long updateAgentId;

  // npelleti 08/17 specified length of 20
  /** updated payment channel. */
  @Column(
    name   = "updatePaymentChannel",
    length = 20
  )
  @Enumerated(value = EnumType.STRING)
  protected PaymentChannel updatePaymentChannel;

  /** DOCUMENT ME! */
  @Column(name = "updatePaymentDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date updatePaymentDate;

  /** Fee charged to debtor by payment service provider. */
  @Column(name = "userServiceFee")
  protected BigDecimal userServiceFee = new BigDecimal("0.0");

  /** version if this payment is submitted by XML. no need to persist. */
  @Transient protected String xmlVersion = "";

  @Column(name = "effectiveDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date effectiveDate;

  @Column(
    name      = "escrow",
    precision = 19,
    scale     = 2
  )
  private BigDecimal escrow;

  @Column(
    name      = "interest",
    precision = 19,
    scale     = 2
  )
  private BigDecimal interest;

  @Column(
    name      = "interestPastDue",
    precision = 19,
    scale     = 2
  )
  private BigDecimal interestPastDue;

  @Column(
    name      = "lateFees",
    precision = 19,
    scale     = 2
  )
  private BigDecimal lateFees;

  @Column(
    name   = "paymentAllocation",
    length = 25
  )
  private String paymentAllocation;

  @Column(
    name      = "penaltyFees",
    precision = 19,
    scale     = 2
  )
  private BigDecimal penaltyFees;

  @Column(
    name      = "penaltyInterest",
    precision = 19,
    scale     = 2
  )
  private BigDecimal penaltyInterest;

  @Column(
    name      = "principal",
    precision = 19,
    scale     = 2
  )
  private BigDecimal principal;

  @Column(
    name      = "principalPastDue",
    precision = 19,
    scale     = 2
  )
  private BigDecimal principalPastDue;

  @Column(
    name   = "processOnlineBatch",
    length = 6
  )
  private String processOnlineBatch = "INIT";

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * Business equals does not care about the createDate. It does not care about the java.util.Set contract. Only to
   * check if two payments are the identical from business perspective. This is perfect for dirty check when edit
   * payments.
   *
   * @param   obj  DOCUMENT ME!
   *
   * @return  business equals does not care about the createDate.
   */
  public boolean businessEquals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    final Payment other = (Payment) obj;

    if (this.amount == null) {
      if (other.getAmount() != null) {
        return false;
      }
    } else if (this.amount.compareTo(other.getAmount()) != 0) {
      return false;
    }

    if (this.fee == null) {
      if (other.getFee() != null) {
        return false;
      }
    } else if (this.fee.compareTo(other.getFee()) != 0) {
      return false;
    }

    if (this.fundingAccountId == null) {
      if (other.getFundingAccountId() != null) {
        return false;
      }
    } else if (!this.fundingAccountId.equals(other.getFundingAccountId())) {
      return false;
    }

    if (this.fundingInformation == null) {
      if (other.getFundingInformation() != null) {
        return false;
      }
    } else if (!this.fundingInformation.equals(other.getFundingInformation())) {
      return false;
    }

    if (this.paymentChannel == null) {
      if (other.getPaymentChannel() != null) {
        return false;
      }
    } else if (!this.paymentChannel.equals(other.getPaymentChannel())) {
      return false;
    }

    if (this.paymentDate == null) {
      if (other.getPaymentDate() != null) {
        return false;
      }
    } else if (CompareUtil.compareDateOnly(this.paymentDate,
            other.getPaymentDate()) != 0) {
      return false;
    }

    if (this.paymentReminder == null) {
      if (other.getPaymentReminder() != null) {
        return false;
      }
    } else if (!this.paymentReminder.businessEquals(other.getPaymentReminder())) {
      return false;
    }

    return true;
  } // end method businessEquals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getAcceptAgentId() {
    return acceptAgentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getAccountBalance() {
    return accountBalance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getAccountChargeOffAmount() {
    return accountChargeOffAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getAccountNum() {
    return accountNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getAgentCallActivityId() {
    return agentCallActivityId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getAgentUpdatedPaymentDate() {
    return agentUpdatedPaymentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getAggregatedPaymentId() {
    return aggregatedPaymentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getAmount() {
    return amount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getApplied() {
    return applied;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getAppliedAmount() {
    return appliedAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getAppliedToProgramAmount() {
    return appliedToProgramAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getAuthCode() {
    return authCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getBatchDate() {
    return batchDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getBatchRunTimeStamp() {
    return batchRunTimeStamp;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getBillerServiceFee() {
    return billerServiceFee;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getBillingGroupId() {
    return billingGroupId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getCancellationLetterSentDate() {
    return cancellationLetterSentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getCheckNumber() {
    return checkNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getCommission() {
    return commission;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getCurrency() {
    return currency;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getDeletedAgentId() {
    return deletedAgentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getDeletedStatusDate() {
    return deletedStatusDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getEffectiveDate() {
    return effectiveDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getEscrow() {
    return escrow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getExternalEntityId() {
    return externalEntityId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getExternalReferenceNumber() {
    return externalReferenceNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getFee() {
    return fee;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getFundedDate() {
    return fundedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getFundingAccountId() {
    return fundingAccountId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public FundingInformation getFundingInformation() {
    return fundingInformation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getInsertBy() {
    return insertBy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getInterest() {
    return interest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getInterestPastDue() {
    return interestPastDue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getInternalReferenceNumber() {
    return internalReferenceNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getInvoiceCommission() {
    return invoiceCommission;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getInvoiceCommissionType() {
    return invoiceCommissionType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getInvoiceDate() {
    return invoiceDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getLastUpdatedResponsibleId() {
    return lastUpdatedResponsibleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getLateFees() {
    return lateFees;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getMaxPaymentDate() {
    return maxPaymentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getMerchantAccountId() {
    return merchantAccountId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getOrder() {
    return order;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getPaidStatusDate() {
    return paidStatusDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getPaymentAllocated() {
    return paymentAllocated;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPaymentAllocation() {
    return paymentAllocation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getPaymentAuditId() {
    return paymentAuditId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PaymentChannel getPaymentChannel() {
    return paymentChannel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getPaymentDate() {
    return paymentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PaymentChannel getPaymentDeletedSource() {
    return paymentDeletedSource;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPaymentDetail() {
    return paymentDetail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getPaymentGroupId() {
    return paymentGroupId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getPaymentId() {
    return paymentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PaymentReminder getPaymentReminder() {
    return paymentReminder;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PaymentStatus getPaymentStatus() {
    return paymentStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPaymentStatusCode() {
    return paymentStatusCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPaymentStatusLink() {
    return paymentStatusLink;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPaymentType() {
    return paymentType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getPenaltyFees() {
    return penaltyFees;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getPenaltyInterest() {
    return penaltyInterest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getPostDate() {
    return postDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getPrincipal() {
    return principal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getPrincipalPastDue() {
    return principalPastDue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getProcessDate() {
    return processDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getProcessedByBatch() {
    return processedByBatch;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getProcessedByPTP() {
    return processedByPTP;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getProcessOnlineBatch() {
    return processOnlineBatch;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getProgramId() {
    return programId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getProgramInstallmentId() {
    return programInstallmentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getPromiseId() {
    return promiseId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getProviderId() {
    return providerId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getRejectedAtAuthorizationDate() {
    return rejectedAtAuthorizationDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getRejectedStatusDate() {
    return rejectedStatusDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getResponsibleId() {
    return responsibleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getRetryCount() {
    return retryCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getStatusDescription() {
    return statusDescription;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getTestPayment() {
    return testPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getThirdParty() {
    return thirdParty;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getThirdPartyEmailAddress() {
    return thirdPartyEmailAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getThirdPartyName() {
    return thirdPartyName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getTrancheInfoId() {
    return trancheInfoId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTransactionReferenceNumber() {
    return transactionReferenceNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getUpdateAgentId() {
    return updateAgentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PaymentChannel getUpdatePaymentChannel() {
    return updatePaymentChannel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getUpdatePaymentDate() {
    return updatePaymentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getUserServiceFee() {
    return userServiceFee;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getXmlVersion() {
    return xmlVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Override public int hashCode() {
    final int PRIME  = 31;
    int       result = super.hashCode();
    result = (PRIME * result)
      + ((this.acceptAgentId == null) ? 0 : this.acceptAgentId.hashCode());
    result = (PRIME * result)
      + ((this.accountBalance == null) ? 0 : this.accountBalance.hashCode());
    result = (PRIME * result)
      + ((this.accountChargeOffAmount == null) ? 0 : this.accountChargeOffAmount.hashCode());
    result = (PRIME * result)
      + ((this.accountNum == null) ? 0 : this.accountNum.hashCode());
    result = (PRIME * result)
      + ((this.agentCallActivityId == null) ? 0 : this.agentCallActivityId.hashCode());
    result = (PRIME * result)
      + ((this.agentUpdatedPaymentDate == null) ? 0 : this.agentUpdatedPaymentDate.hashCode());
    result = (PRIME * result)
      + ((this.aggregatedPaymentId == null) ? 0 : this.aggregatedPaymentId.hashCode());
    result = (PRIME * result)
      + ((this.amount == null) ? 0 : this.amount.hashCode());
    result = (PRIME * result)
      + ((this.applied == null) ? 0 : this.applied.hashCode());
    result = (PRIME * result)
      + ((this.appliedAmount == null) ? 0 : this.appliedAmount.hashCode());
    result = (PRIME * result)
      + ((this.appliedToProgramAmount == null) ? 0 : this.appliedToProgramAmount.hashCode());
    result = (PRIME * result)
      + ((this.authCode == null) ? 0 : this.authCode.hashCode());
    result = (PRIME * result)
      + ((this.batchDate == null) ? 0 : this.batchDate.hashCode());
    result = (PRIME * result)
      + ((this.batchRunTimeStamp == null) ? 0 : this.batchRunTimeStamp.hashCode());
    result = (PRIME * result)
      + ((this.billerServiceFee == null) ? 0 : this.billerServiceFee.hashCode());
    result = (PRIME * result)
      + ((this.billingGroupId == null) ? 0 : this.billingGroupId.hashCode());
    result = (PRIME * result)
      + ((this.cancellationLetterSentDate == null) ? 0 : this.cancellationLetterSentDate.hashCode());
    result = (PRIME * result)
      + ((this.checkNumber == null) ? 0 : this.checkNumber.hashCode());
    result = (PRIME * result)
      + ((this.commission == null) ? 0 : this.commission.hashCode());
    result = (PRIME * result)
      + ((this.currency == null) ? 0 : this.currency.hashCode());
    result = (PRIME * result)
      + ((this.deletedAgentId == null) ? 0 : this.deletedAgentId.hashCode());
    result = (PRIME * result)
      + ((this.deletedStatusDate == null) ? 0 : this.deletedStatusDate.hashCode());
    result = (PRIME * result)
      + ((this.externalEntityId == null) ? 0 : this.externalEntityId.hashCode());
    result = (PRIME * result)
      + ((this.externalReferenceNumber == null) ? 0 : this.externalReferenceNumber.hashCode());
    result = (PRIME * result)
      + ((this.fee == null) ? 0 : this.fee.hashCode());
    result = (PRIME * result)
      + ((this.fundedDate == null) ? 0 : this.fundedDate.hashCode());
    result = (PRIME * result)
      + ((this.fundingAccountId == null) ? 0 : this.fundingAccountId.hashCode());
    result = (PRIME * result)
      + ((this.fundingInformation == null) ? 0 : this.fundingInformation.hashCode());
    result = (PRIME * result)
      + ((this.insertBy == null) ? 0 : this.insertBy.hashCode());
    result = (PRIME * result)
      + ((this.internalReferenceNumber == null) ? 0 : this.internalReferenceNumber.hashCode());
    result = (PRIME * result)
      + ((this.invoiceCommission == null) ? 0 : this.invoiceCommission.hashCode());
    result = (PRIME * result)
      + ((this.invoiceCommissionType == null) ? 0 : this.invoiceCommissionType.hashCode());
    result = (PRIME * result)
      + ((this.invoiceDate == null) ? 0 : this.invoiceDate.hashCode());
    result = (PRIME * result)
      + ((this.lastUpdatedResponsibleId == null) ? 0 : this.lastUpdatedResponsibleId.hashCode());
    result = (PRIME * result)
      + ((this.maxPaymentDate == null) ? 0 : this.maxPaymentDate.hashCode());
    result = (PRIME * result)
      + ((this.merchantAccountId == null) ? 0 : this.merchantAccountId.hashCode());
    result = (PRIME * result)
      + ((this.order == null) ? 0 : this.order.hashCode());
    result = (PRIME * result)
      + ((this.paidStatusDate == null) ? 0 : this.paidStatusDate.hashCode());
    result = (PRIME * result)
      + ((this.paymentAllocated == null) ? 0 : this.paymentAllocated.hashCode());
    result = (PRIME * result)
      + ((this.paymentChannel == null) ? 0 : this.paymentChannel.hashCode());
    result = (PRIME * result)
      + ((this.paymentDate == null) ? 0 : this.paymentDate.hashCode());
    result = (PRIME * result)
      + ((this.paymentDeletedSource == null) ? 0 : this.paymentDeletedSource.hashCode());
    result = (PRIME * result)
      + ((this.paymentDetail == null) ? 0 : this.paymentDetail.hashCode());
    result = (PRIME * result)
      + ((this.paymentGroupId == null) ? 0 : this.paymentGroupId.hashCode());
    result = (PRIME * result)
      + ((this.paymentId == null) ? 0 : this.paymentId.hashCode());
    result = (PRIME * result)
      + ((this.paymentReminder == null) ? 0 : this.paymentReminder.hashCode());
    result = (PRIME * result)
      + ((this.paymentStatus == null) ? 0 : this.paymentStatus.hashCode());
    result = (PRIME * result)
      + ((this.paymentStatusCode == null) ? 0 : this.paymentStatusCode.hashCode());
    result = (PRIME * result)
      + ((this.paymentStatusLink == null) ? 0 : this.paymentStatusLink.hashCode());
    result = (PRIME * result)
      + ((this.paymentType == null) ? 0 : this.paymentType.hashCode());
    result = (PRIME * result)
      + ((this.postDate == null) ? 0 : this.postDate.hashCode());
    result = (PRIME * result)
      + ((this.processDate == null) ? 0 : this.processDate.hashCode());
    result = (PRIME * result)
      + ((this.processedByBatch == null) ? 0 : this.processedByBatch.hashCode());
    result = (PRIME * result)
      + ((this.processedByPTP == null) ? 0 : this.processedByPTP.hashCode());
    result = (PRIME * result)
      + ((this.programId == null) ? 0 : this.programId.hashCode());
    result = (PRIME * result)
      + ((this.programInstallmentId == null) ? 0 : this.programInstallmentId.hashCode());
    result = (PRIME * result)
      + ((this.promiseId == null) ? 0 : this.promiseId.hashCode());
    result = (PRIME * result)
      + ((this.providerId == null) ? 0 : this.providerId.hashCode());
    result = (PRIME * result)
      + ((this.rejectedAtAuthorizationDate == null) ? 0 : this.rejectedAtAuthorizationDate.hashCode());
    result = (PRIME * result)
      + ((this.rejectedStatusDate == null) ? 0 : this.rejectedStatusDate.hashCode());
    result = (PRIME * result)
      + ((this.responsibleId == null) ? 0 : this.responsibleId.hashCode());
    result = (PRIME * result)
      + ((this.retryCount == null) ? 0 : this.retryCount.hashCode());
    result = (PRIME * result)
      + ((this.statusDescription == null) ? 0 : this.statusDescription.hashCode());
    result = (PRIME * result)
      + ((this.testPayment == null) ? 0 : this.testPayment.hashCode());
    result = (PRIME * result)
      + ((this.thirdParty == null) ? 0 : this.thirdParty.hashCode());
    result = (PRIME * result)
      + ((this.thirdPartyEmailAddress == null) ? 0 : this.thirdPartyEmailAddress.hashCode());
    result = (PRIME * result)
      + ((this.thirdPartyName == null) ? 0 : this.thirdPartyName.hashCode());
    result = (PRIME * result)
      + ((this.trancheInfoId == null) ? 0 : this.trancheInfoId.hashCode());
    result = (PRIME * result)
      + ((this.transactionReferenceNumber == null) ? 0 : this.transactionReferenceNumber.hashCode());
    result = (PRIME * result)
      + ((this.updateAgentId == null) ? 0 : this.updateAgentId.hashCode());
    result = (PRIME * result)
      + ((this.updatePaymentChannel == null) ? 0 : this.updatePaymentChannel.hashCode());
    result = (PRIME * result)
      + ((this.updatePaymentDate == null) ? 0 : this.updatePaymentDate.hashCode());
    result = (PRIME * result)
      + ((this.userServiceFee == null) ? 0 : this.userServiceFee.hashCode());

    return result;
  } // end method hashCode

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  acceptAgentId  DOCUMENT ME!
   */
  public void setAcceptAgentId(Long acceptAgentId) {
    this.acceptAgentId = acceptAgentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  accountBalance  DOCUMENT ME!
   */
  public void setAccountBalance(BigDecimal accountBalance) {
    this.accountBalance = accountBalance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  accountChargeOffAmount  DOCUMENT ME!
   */
  public void setAccountChargeOffAmount(BigDecimal accountChargeOffAmount) {
    this.accountChargeOffAmount = accountChargeOffAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  accountNum  DOCUMENT ME!
   */
  public void setAccountNum(Long accountNum) {
    this.accountNum = accountNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  agentCallActivityId  DOCUMENT ME!
   */
  public void setAgentCallActivityId(Long agentCallActivityId) {
    this.agentCallActivityId = agentCallActivityId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  agentUpdatedPaymentDate  DOCUMENT ME!
   */
  public void setAgentUpdatedPaymentDate(Date agentUpdatedPaymentDate) {
    this.agentUpdatedPaymentDate = agentUpdatedPaymentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  aggregatedPaymentId  DOCUMENT ME!
   */
  public void setAggregatedPaymentId(Long aggregatedPaymentId) {
    this.aggregatedPaymentId = aggregatedPaymentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  amount  DOCUMENT ME!
   */
  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  applied  DOCUMENT ME!
   */
  public void setApplied(Boolean applied) {
    this.applied = applied;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  appliedAmount  DOCUMENT ME!
   */
  public void setAppliedAmount(BigDecimal appliedAmount) {
    this.appliedAmount = appliedAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  appliedToProgramAmount  DOCUMENT ME!
   */
  public void setAppliedToProgramAmount(BigDecimal appliedToProgramAmount) {
    this.appliedToProgramAmount = appliedToProgramAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  authCode  DOCUMENT ME!
   */
  public void setAuthCode(String authCode) {
    this.authCode = authCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  batchDate  DOCUMENT ME!
   */
  public void setBatchDate(Date batchDate) {
    this.batchDate = batchDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  batchRunTimeStamp  DOCUMENT ME!
   */
  public void setBatchRunTimeStamp(Date batchRunTimeStamp) {
    this.batchRunTimeStamp = batchRunTimeStamp;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  billerServiceFee  DOCUMENT ME!
   */
  public void setBillerServiceFee(BigDecimal billerServiceFee) {
    this.billerServiceFee = billerServiceFee;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  billingGroupId  DOCUMENT ME!
   */
  public void setBillingGroupId(Long billingGroupId) {
    this.billingGroupId = billingGroupId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  cancellationLetterSentDate  DOCUMENT ME!
   */
  public void setCancellationLetterSentDate(Date cancellationLetterSentDate) {
    this.cancellationLetterSentDate = cancellationLetterSentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  checkNumber  DOCUMENT ME!
   */
  public void setCheckNumber(String checkNumber) {
    this.checkNumber = checkNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  commission  DOCUMENT ME!
   */
  public void setCommission(BigDecimal commission) {
    this.commission = commission;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  currency  DOCUMENT ME!
   */
  public void setCurrency(String currency) {
    this.currency = currency;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  deletedAgentId  DOCUMENT ME!
   */
  public void setDeletedAgentId(Long deletedAgentId) {
    this.deletedAgentId = deletedAgentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  deletedStatusDate  DOCUMENT ME!
   */
  public void setDeletedStatusDate(Date deletedStatusDate) {
    this.deletedStatusDate = deletedStatusDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  effectiveDate  DOCUMENT ME!
   */
  public void setEffectiveDate(Date effectiveDate) {
    this.effectiveDate = effectiveDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  escrow  DOCUMENT ME!
   */
  public void setEscrow(BigDecimal escrow) {
    this.escrow = escrow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  externalEntityId  DOCUMENT ME!
   */
  public void setExternalEntityId(Long externalEntityId) {
    this.externalEntityId = externalEntityId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  externalReferenceNumber  DOCUMENT ME!
   */
  public void setExternalReferenceNumber(String externalReferenceNumber) {
    this.externalReferenceNumber = externalReferenceNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  fee  DOCUMENT ME!
   */
  public void setFee(BigDecimal fee) {
    this.fee = fee;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  fundedDate  DOCUMENT ME!
   */
  public void setFundedDate(Date fundedDate) {
    this.fundedDate = fundedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  fundingAccountId  DOCUMENT ME!
   */
  public void setFundingAccountId(Long fundingAccountId) {
    this.fundingAccountId = fundingAccountId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  fundingInformation  DOCUMENT ME!
   */
  public void setFundingInformation(FundingInformation fundingInformation) {
    this.fundingInformation = fundingInformation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  insertBy  DOCUMENT ME!
   */
  public void setInsertBy(String insertBy) {
    this.insertBy = insertBy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  interest  DOCUMENT ME!
   */
  public void setInterest(BigDecimal interest) {
    this.interest = interest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  interestPastDue  DOCUMENT ME!
   */
  public void setInterestPastDue(BigDecimal interestPastDue) {
    this.interestPastDue = interestPastDue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  internalReferenceNumber  DOCUMENT ME!
   */
  public void setInternalReferenceNumber(String internalReferenceNumber) {
    this.internalReferenceNumber = internalReferenceNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  invoiceCommission  DOCUMENT ME!
   */
  public void setInvoiceCommission(BigDecimal invoiceCommission) {
    this.invoiceCommission = invoiceCommission;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  invoiceCommissionType  DOCUMENT ME!
   */
  public void setInvoiceCommissionType(String invoiceCommissionType) {
    this.invoiceCommissionType = invoiceCommissionType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  invoiceDate  DOCUMENT ME!
   */
  public void setInvoiceDate(Date invoiceDate) {
    this.invoiceDate = invoiceDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  lastUpdatedResponsibleId  DOCUMENT ME!
   */
  public void setLastUpdatedResponsibleId(Long lastUpdatedResponsibleId) {
    this.lastUpdatedResponsibleId = lastUpdatedResponsibleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  lateFees  DOCUMENT ME!
   */
  public void setLateFees(BigDecimal lateFees) {
    this.lateFees = lateFees;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  maxPaymentDate  DOCUMENT ME!
   */
  public void setMaxPaymentDate(Date maxPaymentDate) {
    this.maxPaymentDate = maxPaymentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  merchantAccountId  DOCUMENT ME!
   */
  public void setMerchantAccountId(String merchantAccountId) {
    this.merchantAccountId = merchantAccountId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  order  DOCUMENT ME!
   */
  public void setOrder(Integer order) {
    this.order = order;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paidStatusDate  DOCUMENT ME!
   */
  public void setPaidStatusDate(Date paidStatusDate) {
    this.paidStatusDate = paidStatusDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentAllocated  DOCUMENT ME!
   */
  public void setPaymentAllocated(Boolean paymentAllocated) {
    this.paymentAllocated = paymentAllocated;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentAllocation  DOCUMENT ME!
   */
  public void setPaymentAllocation(String paymentAllocation) {
    this.paymentAllocation = paymentAllocation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentAuditId  DOCUMENT ME!
   */
  public void setPaymentAuditId(Long paymentAuditId) {
    this.paymentAuditId = paymentAuditId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentChannel  DOCUMENT ME!
   */
  public void setPaymentChannel(PaymentChannel paymentChannel) {
    this.paymentChannel = paymentChannel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentDate  DOCUMENT ME!
   */
  public void setPaymentDate(Date paymentDate) {
    this.paymentDate = paymentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentDeletedSource  DOCUMENT ME!
   */
  public void setPaymentDeletedSource(PaymentChannel paymentDeletedSource) {
    this.paymentDeletedSource = paymentDeletedSource;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentDetail  DOCUMENT ME!
   */
  public void setPaymentDetail(String paymentDetail) {
    this.paymentDetail = paymentDetail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentGroupId  DOCUMENT ME!
   */
  public void setPaymentGroupId(Long paymentGroupId) {
    this.paymentGroupId = paymentGroupId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentId  DOCUMENT ME!
   */
  public void setPaymentId(Long paymentId) {
    this.paymentId = paymentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentReminder  DOCUMENT ME!
   */
  public void setPaymentReminder(PaymentReminder paymentReminder) {
    this.paymentReminder = paymentReminder;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentStatus  DOCUMENT ME!
   */
  public void setPaymentStatus(PaymentStatus paymentStatus) {
    this.paymentStatus = paymentStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentStatusCode  DOCUMENT ME!
   */
  public void setPaymentStatusCode(String paymentStatusCode) {
    this.paymentStatusCode = paymentStatusCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentStatusLink  DOCUMENT ME!
   */
  public void setPaymentStatusLink(String paymentStatusLink) {
    this.paymentStatusLink = paymentStatusLink;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentType  DOCUMENT ME!
   */
  public void setPaymentType(String paymentType) {
    this.paymentType = paymentType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  penaltyFees  DOCUMENT ME!
   */
  public void setPenaltyFees(BigDecimal penaltyFees) {
    this.penaltyFees = penaltyFees;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  penaltyInterest  DOCUMENT ME!
   */
  public void setPenaltyInterest(BigDecimal penaltyInterest) {
    this.penaltyInterest = penaltyInterest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  postDate  DOCUMENT ME!
   */
  public void setPostDate(Date postDate) {
    this.postDate = postDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  principal  DOCUMENT ME!
   */
  public void setPrincipal(BigDecimal principal) {
    this.principal = principal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  principalPastDue  DOCUMENT ME!
   */
  public void setPrincipalPastDue(BigDecimal principalPastDue) {
    this.principalPastDue = principalPastDue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  processDate  DOCUMENT ME!
   */
  public void setProcessDate(Date processDate) {
    this.processDate = processDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  processedByBatch  DOCUMENT ME!
   */
  public void setProcessedByBatch(Boolean processedByBatch) {
    this.processedByBatch = processedByBatch;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  processedByPTP  DOCUMENT ME!
   */
  public void setProcessedByPTP(Boolean processedByPTP) {
    this.processedByPTP = processedByPTP;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  processOnlineBatch  DOCUMENT ME!
   */
  public void setProcessOnlineBatch(String processOnlineBatch) {
    this.processOnlineBatch = processOnlineBatch;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  programId  DOCUMENT ME!
   */
  public void setProgramId(Long programId) {
    this.programId = programId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  programInstallmentId  DOCUMENT ME!
   */
  public void setProgramInstallmentId(Long programInstallmentId) {
    this.programInstallmentId = programInstallmentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  promiseId  DOCUMENT ME!
   */
  public void setPromiseId(Long promiseId) {
    this.promiseId = promiseId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  providerId  DOCUMENT ME!
   */
  public void setProviderId(Long providerId) {
    this.providerId = providerId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  rejectedAtAuthorizationDate  DOCUMENT ME!
   */
  public void setRejectedAtAuthorizationDate(Date rejectedAtAuthorizationDate) {
    this.rejectedAtAuthorizationDate = rejectedAtAuthorizationDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  rejectedStatusDate  DOCUMENT ME!
   */
  public void setRejectedStatusDate(Date rejectedStatusDate) {
    this.rejectedStatusDate = rejectedStatusDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  responsibleId  DOCUMENT ME!
   */
  public void setResponsibleId(Long responsibleId) {
    this.responsibleId = responsibleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  retryCount  DOCUMENT ME!
   */
  public void setRetryCount(Integer retryCount) {
    this.retryCount = retryCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  statusDescription  DOCUMENT ME!
   */
  public void setStatusDescription(String statusDescription) {
    this.statusDescription = statusDescription;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  testPayment  DOCUMENT ME!
   */
  public void setTestPayment(Boolean testPayment) {
    this.testPayment = testPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  thirdParty  DOCUMENT ME!
   */
  public void setThirdParty(Boolean thirdParty) {
    this.thirdParty = thirdParty;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  thirdPartyEmailAddress  DOCUMENT ME!
   */
  public void setThirdPartyEmailAddress(String thirdPartyEmailAddress) {
    this.thirdPartyEmailAddress = thirdPartyEmailAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  thirdPartyName  DOCUMENT ME!
   */
  public void setThirdPartyName(String thirdPartyName) {
    this.thirdPartyName = thirdPartyName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  trancheInfoId  DOCUMENT ME!
   */
  public void setTrancheInfoId(Long trancheInfoId) {
    this.trancheInfoId = trancheInfoId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  transactionReferenceNumber  DOCUMENT ME!
   */
  public void setTransactionReferenceNumber(String transactionReferenceNumber) {
    this.transactionReferenceNumber = transactionReferenceNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  updateAgentId  DOCUMENT ME!
   */
  public void setUpdateAgentId(Long updateAgentId) {
    this.updateAgentId = updateAgentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  updatePaymentChannel  DOCUMENT ME!
   */
  public void setUpdatePaymentChannel(PaymentChannel updatePaymentChannel) {
    this.updatePaymentChannel = updatePaymentChannel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  updatePaymentDate  DOCUMENT ME!
   */
  public void setUpdatePaymentDate(Date updatePaymentDate) {
    this.updatePaymentDate = updatePaymentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  userServiceFee  DOCUMENT ME!
   */
  public void setUserServiceFee(BigDecimal userServiceFee) {
    this.userServiceFee = userServiceFee;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  xmlVersion  DOCUMENT ME!
   */
  public void setXmlVersion(String xmlVersion) {
    this.xmlVersion = xmlVersion;
  }
} // end class PaymentAudit
