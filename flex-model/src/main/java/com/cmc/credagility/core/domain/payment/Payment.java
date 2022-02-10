package com.cmc.credagility.core.domain.payment;

import java.io.Serializable;

import java.math.BigDecimal;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.activity.AgentCallActivity;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.disclosure.DisclosureAudit;
import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.domain.type.BankAccountType;
import com.cmc.credagility.core.domain.type.CardType;
import com.cmc.credagility.core.domain.type.FundingAccountType;
import com.cmc.credagility.core.domain.type.PaymentChannel;
import com.cmc.credagility.core.domain.type.PaymentStatus;
import com.cmc.credagility.core.domain.type.PromiseToPayStatus;
import com.cmc.credagility.core.domain.type.ReminderType;
import com.cmc.credagility.core.domain.util.CompareUtil;
import com.cmc.credagility.core.domain.util.DateUtil;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


/**
 * This class is used to store Payment information.
 *
 * <p><a href="Payment.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 * @version  $Revision$, $Date$
 *
 *           <p>table = "Payment"</p>
 */
@Entity
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class,
  property  = "paymentId",
  scope     = Payment.class
)
@Table(
  name    = "Payment",
  indexes = {
    @Index(
      name = "txnReferenceNumberIndex",
      columnList = "transactionReferenceNumber"
    ),
    @Index(
      name = "paymentReferenceNumberIndex",
      columnList = "externalReferenceNumber"
    ),
    @Index(
      name = "postalCodeIndex",
      columnList = "postalCode"
    ),
    @Index(
      name = "idx_internalReferenceNumber",
      columnList = "internalReferenceNumber"
    )
  }
)
public class Payment extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -133146353288571506L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** agent id - used for performance tracking purpose. */
  @Column(name = "acceptAgentId")
  protected Long acceptAgentId;

  /** account id. */
  @JoinColumn(
    name      = "accountNum",
    nullable  = false,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Account account;

  /** account balance. */
  @Column(name = "accountBalance")
  protected BigDecimal accountBalance;

  /** account charge off amount. */
  @Column(name = "accountChargeOffAmount")
  protected BigDecimal accountChargeOffAmount;

  /** AgentCallActivity PK activityId. */
  @JoinColumn(
    name       = "activityId",
    insertable = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected AgentCallActivity agentCallActivity;

  /** Agent updated payment date. */
  @Column(name = "agentUpdatedPaymentDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date agentUpdatedPaymentDate;

  /** Batch creating payment. */
  @JoinColumn(
    name      = "aggregatedPaymentId",
    nullable  = true,
    updatable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected AggregatedPayment aggregatedPayment;


  // Added by EtisBew -- Fixed Jira # USB-10 -- START

  // npelleti 08/01 USB made column amount not null, add precision.
  /** payment amount. */
  @Column(
    name      = "amount",
    nullable  = false,
    precision = 19,
    scale     = 2
  )
  protected BigDecimal amount;

  /** <code>true</code> allow applied. */
  @Column(
    name             = "applied",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean applied = Boolean.FALSE;

  /** <code>true</code> allow applied amount. */
  @Column(
    name      = "appliedAmount",
    nullable  = true,
    precision = 19,
    scale     = 2
  )
  protected BigDecimal appliedAmount;

  /** Applied to program amount. */
  @Column(name = "appliedToProgramAmount")
  protected BigDecimal appliedToProgramAmount;

  /** Applied to promise to pay. */
  @JoinColumn(
    name     = "promiseId",
    unique   = false,
    nullable = true
  )
  @OneToOne(fetch = FetchType.LAZY)
  protected PromiseToPay appliedToPTP;

  // npelleti 08/01 USB Specified length 20 to authcode
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

  /** Billing group Id. */
  @Column(
    name     = "billingGroupId",
    nullable = true
  )
  protected Long billingGroupId;

  /** Cancellation letter sent date. */
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

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "currency",
    length = 255
  )
  protected String currency;

  /** DOCUMENT ME! */
  @Column(
    name       = "cvv",
    insertable = false,
    updatable  = false
  )
  @Transient protected String cvv;


  /** deleted agent. */
  @Column(
    name     = "deletedAgentId",
    nullable = true
  )
  protected Long deletedAgentId;

  /** Deleted status date. */
  @Column(name = "deletedStatusDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date deletedStatusDate;

  /** Disclosure audit. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "payment"
  )
  @OrderBy("disclosureAuditId asc")
  protected Set<DisclosureAudit> disclosureAudits = new LinkedHashSet<DisclosureAudit>();

  /** DOCUMENT ME! */
  @Column(name = "executePaymentGroup")
  protected String executePaymentGroup;

  /** External entity Id. */
  @Column(
    name     = "externalEntityId",
    nullable = true
  )
  protected Long externalEntityId;


  /** External reference number. */
  @Column(
    name   = "externalReferenceNumber",
    length = 125
  )
  protected String externalReferenceNumber;

  /** payment processing fee. */
  @Column(
    name      = "fee",
    nullable  = false,
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
  @Column(
    name     = "fundingAccountId",
    nullable = true
  )
  protected Long fundingAccountId;

  /** DOCUMENT ME! */
  @Column(
    name   = "fundingExternalReferenceNumber",
    length = 125
  )
  protected String fundingExternalReferenceNumber;

  /** Funding Object information, keep a copy from funding account. */
  @Embedded protected FundingInformation fundingInformation = new FundingInformation();

  /** insertby. */
  @Column(
    name   = "insertBy",
    length = 20
  )
  protected String insertBy = "WEB";

  /** Internal reference number. */
  @Column(
    name   = "internalReferenceNumber",
    length = 125
  )
  protected String internalReferenceNumber;


  /** Invoice commission. */
  @Column(name = "invoiceCommission")
  protected BigDecimal invoiceCommission;

  /** Invoice commission type. */
  @Column(
    name   = "invoiceCommissionType",
    length = 25
  )
  protected String invoiceCommissionType;


  /** Invoice date. */
  @Column(name = "invoiceDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date invoiceDate;

  /** responsible id. */
  @JoinColumn(
    name      = "lastUpdatedResponsibleId",
    updatable = true,
    nullable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Responsible lastUpdatedResponsible;

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

  /** Merchant account Id. */
  @Column(
    name   = "merchantAccountId",
    length = 200
  )
  protected String merchantAccountId;

  /** Order of the installment within payment program. Starting from 1. */
  @Column(
    name     = "installmentOrder",
    nullable = true
  )
  protected Integer order;

  /** Paid status date. */
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

  /** payment channel. */
  @Column(
    name      = "paymentChannel",
    nullable  = false,
    updatable = false,
    length    = 20
  )
  @Enumerated(EnumType.STRING)
  protected PaymentChannel paymentChannel;

  // npelleti 08/17 Made PaymentDate column not null
  /** payment date. */
  @Column(
    name     = "paymentDate",
    nullable = false
  )
  @Temporal(TemporalType.TIMESTAMP)
  protected Date paymentDate;

  /** Payment deleted source. */
  @Column(
    name   = "paymentDeletedSource",
    length = 20
  )
  @Enumerated(EnumType.STRING)
  protected PaymentChannel paymentDeletedSource;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "paymentDetail",
    length = 1000
  )
  protected String paymentDetail;

  /** DOCUMENT ME! */
  @JoinColumn(
    name     = "paymentGroupId",
// updatable = false,
    nullable = true
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected PaymentGroup paymentGroup;

  // npelleti 08/17 rem. unique constraint.
  /** payment PK paymentId. */
  @Column(
    name     = "paymentId",

    // unique   = true,
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long paymentId;

  /** payment program. */
  @JoinColumn(name = "programId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected PaymentProgram paymentProgram;

  /** payment program installment - nullable. */
  @JoinColumn(
    name      = "programInstallmentId",
    updatable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PaymentProgramInstallment paymentProgramInstallment;

  /**
   * @see  com.cmc.credagility.core.domain.payment.PaymentReminder
   */
  @Embedded protected PaymentReminder paymentReminder = new PaymentReminder();

  /** payment service provider. */
  @JoinColumn(name = "providerId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected PaymentServiceProvider paymentServiceProvider;

  // npelleti 08/11 made payment status not null
  /** payment status - Processed, Scheduled, Rejected, NSF. */
  @Column(
    name     = "paymentStatus",
    nullable = false,
    length   = 20
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

  /** Payment status link. */
  @Transient protected String paymentStatusLink;

  /** TODO: DOCUMENT ME! */
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

  /** PromiseToPay. */
  @OneToOne(
    fetch    = FetchType.LAZY,
    mappedBy = "payment"
  )
  protected PromiseToPay promiseToPay;


  /** Rejected at authorization date. */
  @Column(name = "rejectedAtAuthorizationDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date rejectedAtAuthorizationDate;

  /** Rejected status date. */
  @Column(name = "rejectedStatusDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date rejectedStatusDate;

  /** responsible id. */
  @JoinColumn(
    name      = "responsibleId",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Responsible responsible;

  /** count retry time. */
  @Column(name = "retryCount")
  protected Integer retryCount = 0;

  /** SplitPayment. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "payment",
    cascade  = { CascadeType.REMOVE, CascadeType.ALL }
  )
  @OrderBy("createDate asc")
  protected Set<SplitPayment> splitPayments = new LinkedHashSet<SplitPayment>();


  /** Status description. */
  @Column(
    name   = "statusDescription",
    length = 250
  )
  protected String statusDescription;

  /** shortcut to identify whether this is a test payment. all payment submitted to test accounts are test payment */
  @Column(
    name             = "testPayment",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean testPayment = false;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "thirdParty",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean thirdParty = false;

  /** Tranche info Id. */
  @Column(
    name     = "trancheInfoId",
    nullable = true
  )
  protected Long trancheInfoId;

  /** Transaction reference number. */
  @Column(
    name   = "transactionReferenceNumber",
    length = 50
  )
  protected String transactionReferenceNumber;
  // npelleti USB moved fee after commission,not null, specified precision

  /** TODO: DOCUMENT ME! */
  @Transient protected Long transientAccountNum;

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

  /** Update payment date. */
  @Column(name = "updatePaymentDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date updatePaymentDate;

  /** Fee charged to debtor by payment service provider. */
  @Column(name = "userServiceFee")
  protected BigDecimal userServiceFee = new BigDecimal("0.0");

  /** version if this payment is submitted by XML. no need to persist. */
  @Transient protected String xmlVersion = "";

  @Transient private Long disclosureAuditId;

  @Column(
    name     = "processOnlineBatch",
    nullable = true,
    length   = 6
  )
  private String processOnlineBatch = "INIT";

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  splitPayment  DOCUMENT ME!
   */
  public void addSplitPayment(SplitPayment splitPayment) {
    splitPayment.setPayment(this);
    getSplitPayments().add(splitPayment);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

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
   * @param   agentId                        DOCUMENT ME!
   * @param   responsible                    DOCUMENT ME!
   * @param   agentCallActivity              DOCUMENT ME!
   * @param   status                         DOCUMENT ME!
   * @param   createDate                     DOCUMENT ME!
   * @param   ptpPaymentMethodConfiguration  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PromiseToPay createPTP(Long agentId, Responsible responsible,
    AgentCallActivity agentCallActivity, PromiseToPayStatus status,
    Date createDate, PtpPaymentMethodConfiguration ptpPaymentMethodConfiguration) {
    PromiseToPay ptp = new PromiseToPay();
    ptp.setAcceptAgentId(agentId);
    ptp.setAccount(this.getAccount());
    ptp.setAgentCallActivity(agentCallActivity);
    ptp.setCreateDate(createDate);
    ptp.setPayment(this);
    ptp.setPaymentAmount(this.getAmount());
    ptp.setPaymentDate(this.getPaymentDate());
    ptp.setPaymentMethodConfiguration(ptpPaymentMethodConfiguration);
    ptp.setPaymentProgramInstallment(null);
    ptp.setPtpStatus(status);
    ptp.setResponsible(responsible);
    ptp.setSendDate(this.getPaymentDate());
    ptp.setBalance(this.getAccount().getBalance());
    ptp.setClientDefinedDecimal(this.getAccount().getClientDefinedDecimal1());

    Portfolio portfolio   = responsible.getAccount().getPortfolio();
    Date      arrivalDate = ptp.getSendDate();

    if ((portfolio != null) && (portfolio.getDefaultArrivalDate() != null)) {
      arrivalDate = DateUtil.addDays(arrivalDate, portfolio.getDefaultArrivalDate().intValue());
    }

    ptp.setArrivalDate(arrivalDate);

    if (PromiseToPayStatus.OUTSTANDING.equals(status)) {
      ptp.setOutstandingStatusDate(createDate);
    }

    this.setPromiseToPay(ptp);

    return ptp;
  } // end method createPTP

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Create lock box payment based on payment.
   *
   * @param  other  DOCUMENT ME!
   */
  public void creatLockboxPayment(Payment other) {
    this.amount                               = other.getAmount();
    this.fee                                  = new BigDecimal("0.00");
    this.paymentDate                          = new Date(other.getPaymentDate().getTime());
    this.fundingAccountId                     = null;
    this.fundingInformation.holderFullName    = other.getFundingInformation().getHolderFullName();
    this.fundingInformation.fundingAccountNum = other.getFundingInformation().getFundingAccountNum();
    this.fundingInformation.routingNumber     = other.getFundingInformation().getRoutingNumber();

    this.fundingInformation.ensureNickName(this.responsible.getAccount().getPortfolio().getPortfolioId());

    // always be checking account
    this.fundingInformation.type    = FundingAccountType.BANKACCOUNT.toString();
    this.fundingInformation.subType = BankAccountType.CHECKING.toString();
    this.checkNumber                = other.getCheckNumber();

    // always inprocess while create
    this.paymentStatus  = PaymentStatus.INPROCESS;
    this.paymentChannel = PaymentChannel.CHECKTOCMC;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * equals method needs to include super.equals. This is because we need to allow people make two identical payments
   * (only createDate is different).
   *
   * @param   obj  DOCUMENT ME!
   *
   * @return  equals method needs to include super.equals.
   *
   * @see     java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    if (!businessEquals(obj)) {
      return false;
    }

    final Payment other = (Payment) obj;

    if (this.transientAccountNum == null) {
      if (other.getTransientAccountNum() != null) {
        return false;
      }
    } else if (!this.transientAccountNum.equals(other.getTransientAccountNum())) {
      return false;
    }

    if (!super.equals(obj)) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The acceptAgentId.
   *
   * @return  the acceptAgentId
   *
   *          <p>not-null = "false"</p>
   */
  public Long getAcceptAgentId() {
    return this.acceptAgentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The account.
   *
   * @return  the account
   *
   *          <p>lazy = "proxy" column = "accountNum" not-null = "true" class = "com.cmc.credagility.Account" insert =
   *          "true" update = "false"</p>
   */
  public Account getAccount() {
    return account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The accountBalance.
   *
   * @return  the accountBalance
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getAccountBalance() {
    return this.accountBalance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The accountChargeOffAmount.
   *
   * @return  the accountChargeOffAmount
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getAccountChargeOffAmount() {
    return this.accountChargeOffAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public AgentCallActivity getAgentCallActivity() {
    return agentCallActivity;
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
   * getter method for aggregated payment.
   *
   * @return  AggregatedPayment
   */
  public AggregatedPayment getAggregatedPayment() {
    return aggregatedPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The amount.
   *
   * @return  the amount
   *
   *          <p>not-null = "true"</p>
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
  public String getAmountStr() {
    DecimalFormat f = new DecimalFormat("#####0.00");

    return f.format(this.getAmount());
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
  public PromiseToPay getAppliedToPTP() {
    return appliedToPTP;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The authCode.
   *
   * @return  the authCode
   *
   *          <p>not-null = "false" length = "20"</p>
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
  public BankAccountType getBankAccountType() {
    return fundingInformation.getBankAccountType();
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
  public String getCardExpirationDate4() {
    if (!isUsingCard()) {
      return null;
    }

    Date ed = fundingInformation.getExpirationDate();

    if (ed == null) {
      return null;
    }

    SimpleDateFormat sf = new SimpleDateFormat("MMyy");

    return sf.format(ed);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public CardType getCardType() {
    return fundingInformation.getCardType();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The checkNumber.
   *
   * @return  the checkNumber
   *
   *          <p>not-null = "false" length = "10"</p>
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
   * getter method for currency.
   *
   * @return  String
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
  public String getCvv() {
    return cvv;
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
  public Long getDisclosureAuditId() {
    return disclosureAuditId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<DisclosureAudit> getDisclosureAudits() {
    return disclosureAudits;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get DoNotContactUntil date caused by this payment. It equals paymentDate + retryConfirmDays (default to 7).
   *
   * <p>For premature calls (when paymentDate is null), this method returns current datetime to make sure it won't
   * affetc DoNotContact decision.</p>
   *
   * @return  get DoNotContactUntil date caused by this payment.
   */
  public Date getDoNotContactUntil() {
    if (paymentDate == null) {
      return new Date();
    }

    Integer days = getPaymentServiceProvider().getRetryConfirmDays();

    if (days == null) {
      days = 7; // default
    }

    Integer doNotContactPaymentDays = getAccount().getPortfolio().getDoNotContactPaymentDays();

    if ((doNotContactPaymentDays != null)
          && (doNotContactPaymentDays > days)) {
      days = doNotContactPaymentDays;
    }

    return DateUtil.addDays(getPaymentDate(), days);

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getExecutePaymentGroup() {
    return executePaymentGroup;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for expiration date.
   *
   * @return  Date
   */
  public Date getExpirationDate() {
    return this.fundingInformation.getExpirationDate();
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
   * The fee.
   *
   * @return  the fee
   *
   *          <p>not-null = "true"</p>
   */
  public BigDecimal getFee() {
    return this.fee;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public DisclosureAudit getFirstDisclosureAudit() {
    DisclosureAudit first = null;

    if (!disclosureAudits.isEmpty()) {
      first = disclosureAudits.iterator().next();
    }

    return first;
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
   * This is the funding account Id of the payment. Note that this is not linked to FundingAccount table because
   * customer may delete the funding account. This funding account Id is simply the funding account Id when this payment
   * is last edited.
   *
   * @return  this is the funding account Id of the payment.
   *
   *          <p>not-null = "false"</p>
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
  public String getFundingAccountNum() {
    return this.fundingInformation.getFundingAccountNum();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getFundingExternalReferenceNumber() {
    return fundingExternalReferenceNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The fundingInformation.
   *
   * @return  the fundingInformation
   */
  public FundingInformation getFundingInformation() {
    return this.fundingInformation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for holder full name.
   *
   * @return  String
   */
  public String getHolderFullName() {
    return this.fundingInformation.getHolderFullName();
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
   * getter method for last updated responsible.
   *
   * @return  Responsible
   */
  public Responsible getLastUpdatedResponsible() {
    return lastUpdatedResponsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for max payment date.
   *
   * @return  Date
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
   * getter method for payment allocated.
   *
   * @return  Boolean
   */
  public Boolean getPaymentAllocated() {
    if (null == paymentAllocated) {
      return Boolean.FALSE;
    }

    return paymentAllocated;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The paymentChannel.
   *
   * @return  the paymentChannel
   *
   *          <p>not-null = "true" length = "20" type = "com.cmc.dao.hibernate.support.PaymentChannelUserType"</p>
   */
  public PaymentChannel getPaymentChannel() {
    return paymentChannel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The paymentDate.
   *
   * @return  the paymentDate
   *
   *          <p>not-null = "true"</p>
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
   * getter method for payment detail.
   *
   * @return  String
   */
  public String getPaymentDetail() {
    return paymentDetail;
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
   * The paymentId.
   *
   * @return  the paymentId
   *
   *          <p>generator-class = "native" unsaved-value = "null"</p>
   */
  public Long getPaymentId() {
    return paymentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment funding Last 4 Of fundingAccountNum.
   *
   * @return  String
   */
  public String getPaymentLast4FundingAccountNumber() {
    String fundingAccountNum = this.fundingInformation.getFundingAccountNum();

    if (((fundingAccountNum) != null) && StringUtils.hasText(fundingAccountNum)) {
      return fundingAccountNum.substring(fundingAccountNum.length() - 4, fundingAccountNum.length());
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The paymentProgram.
   *
   * @return  the paymentProgram
   *
   *          <p>lazy = "proxy" column = "programId" not-null = "false" class = "com.cmc.credagility.PaymentProgram"
   *          insert = "true" update = "true"</p>
   */
  public PaymentProgram getPaymentProgram() {
    return paymentProgram;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * One to one relationship with programInstallment, could be null.
   *
   * @return  One to one relationship with programInstallment, could be null.
   *
   *          <p>lazy = "proxy" column = "programInstallmentId" not-null = "false" class =
   *          "com.cmc.credagility.PaymentProgramInstallment" insert = "true" update = "false"</p>
   */
  public PaymentProgramInstallment getPaymentProgramInstallment() {
    return paymentProgramInstallment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The payment reminder object.
   *
   * @return  the payment reminder object
   *
   *          <p>not-null = "false"</p>
   */
  public PaymentReminder getPaymentReminder() {
    return paymentReminder;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get payment service Id for this portfolio. If none, returns the default serviceId for this payment service
   * provider.
   *
   * @return  get payment service Id for this portfolio.
   */
  public String getPaymentServiceId() {
    String id = getAccount().getPortfolio().getPaymentServiceId();

    if (!StringUtils.hasText(id)) {
      PaymentServiceProvider provider = this.getPaymentServiceProvider();

      if (provider != null) {
        id = provider.getUserId();
      }
    }

    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The paymentServiceProvider.
   *
   * @return  the paymentServiceProvider
   *
   *          <p>column = "providerId" not-null = "false" class = "com.cmc.credagility.PaymentServiceProvider" insert =
   *          "true" update = "true"</p>
   */
  public PaymentServiceProvider getPaymentServiceProvider() {
    return paymentServiceProvider;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The paymentStatus.
   *
   * @return  the paymentStatus
   *
   *          <p>not-null = "true" length = "20" type = "com.cmc.dao.hibernate.support.PaymentStatusUserType"</p>
   */
  public PaymentStatus getPaymentStatus() {
    return paymentStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * This is the status code returned to CMC by payment processor, such as ITS.
   *
   * @return  the paymentStatusCode
   *
   *          <p>not-null = "false" length = "20"</p>
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
   * The paymentStatusStr.
   *
   * @return  the paymentStatusStr
   */
  public String getPaymentStatusStr() {
    return (paymentStatus != null) ? paymentStatus.name() : null;
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
  public Date getProcessDate() {
    return processDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The processedByBatch.
   *
   * @return  the processedByBatch
   *
   *          <p>type = "yes_no" not-null = "false"</p>
   */
  public Boolean getProcessedByBatch() {
    return processedByBatch;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for process online batch.
   *
   * @return  String
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
  public PromiseToPay getPromiseToPay() {
    return promiseToPay;
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
   * The responsible.
   *
   * @return  the responsible
   *
   *          <p>lazy = "proxy" column = "responsibleId" not-null = "true" class = "com.cmc.credagility.Responsible"
   *          insert = "true" update = "false"</p>
   */
  public Responsible getResponsible() {
    return this.responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getRetryConfirmDays() {
    if (this.paymentServiceProvider != null) {
      this.paymentServiceProvider.getRetryConfirmDays();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The retryCount.
   *
   * @return  the retryCount
   *
   *          <p>not-null = "false"</p>
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
  public Set<SplitPayment> getSplitPayments() {
    return splitPayments;
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
   *
   *          <p>type = "yes_no" not-null = "false"</p>
   */
  public Boolean getTestPayment() {
    return testPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for third party.
   *
   * @return  Boolean
   */
  public Boolean getThirdParty() {
    if (thirdParty == null) {
      return Boolean.FALSE;
    }

    return thirdParty;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Total payment amount = amount + fee.
   *
   * @return  total payment amount = amount + fee.
   */
  public BigDecimal getTotalAmount() {
    if (fee == null) {
      return amount;
    }

    return amount.add(fee);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTotalAmountStr() {
    DecimalFormat f = new DecimalFormat("#####0.00");

    return f.format(this.getTotalAmount());
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
   * getter method for transient account num.
   *
   * @return  Long
   */
  public Long getTransientAccountNum() {
    return transientAccountNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The updateAgentId.
   *
   * @return  the updateAgentId
   */
  public Long getUpdateAgentId() {
    return this.updateAgentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The updatePaymentChannel.
   *
   * @return  the updatePaymentChannel
   *
   *          <p>not-null = "false" length = "20" type = "com.cmc.dao.hibernate.support.PaymentChannelUserType"</p>
   */
  public PaymentChannel getUpdatePaymentChannel() {
    return this.updatePaymentChannel;
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

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    final int PRIME  = 31;
    int       result = super.hashCode();
    result = (PRIME * result)
      + ((this.paymentId == null) ? 0 : this.paymentId.hashCode());
    result = (PRIME * result)
      + ((this.amount == null) ? 0 : this.amount.hashCode());
    result = (PRIME * result)
      + ((this.fee == null) ? 0 : this.fee.hashCode());
    result = (PRIME * result)
      + ((this.fundingAccountId == null) ? 0 : this.fundingAccountId.hashCode());
    result = (PRIME * result)
      + ((this.fundingInformation == null) ? 0 : this.fundingInformation.hashCode());
    result = (PRIME * result)
      + ((this.paymentChannel == null) ? 0 : this.paymentChannel.hashCode());
    result = (PRIME * result)
      + ((this.paymentDate == null) ? 0 : this.paymentDate.hashCode());
    result = (PRIME * result)
      + ((this.paymentReminder == null) ? 0 : this.paymentReminder.hashCode());
    result = (PRIME * result)
      + ((this.createDate == null) ? 0 : this.createDate.hashCode());
    result = (PRIME * result)
      + ((this.order == null) ? 0 : this.order.hashCode());
    result = (PRIME * result)
      + (((this.paymentProgramInstallment == null)
          || (this.paymentProgramInstallment.getInstallmentId() == null))
        ? 0 : this.paymentProgramInstallment.getInstallmentId().hashCode());

    return result;
  } // end method hashCode

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Increase payment retry counter.
   */
  public void increaseRetryCount() {
    this.retryCount++;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean isCMCWebDeletedPayment() {
    return !PaymentChannel.CLIENT.equals(this.paymentDeletedSource);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean isCMCWebPayment() {
    return PaymentChannel.AGENCY.equals(this.paymentChannel)
      || PaymentChannel.DEBTORSITE.equals(this.paymentChannel);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean isCMCWebUpdatedPayment() {
    return !PaymentChannel.CLIENT.equals(this.updatePaymentChannel);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Compare the lockbox payment.
   *
   * @param   other  DOCUMENT ME!
   *
   * @return  compare the lockbox payment
   */
  public boolean isEqualLockboxPayment(Payment other) {
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

    if (this.paymentDate == null) {
      if (other.getPaymentDate() != null) {
        return false;
      }
    } else if (CompareUtil.compareDateOnly(this.paymentDate,
            other.getPaymentDate()) != 0) {
      return false;
    }

    if (this.fundingInformation == null) {
      if (other.getFundingInformation() != null) {
        return false;
      }
    } else {
      if (!this.fundingInformation.getHolderFullName().equals(
              other.getFundingInformation().getHolderFullName())) {
        return false;
      } else if (
        !this.fundingInformation.getFundingAccountNum().equals(
              other.getFundingInformation().getFundingAccountNum())) {
        return false;
      } else if (!this.fundingInformation.getRoutingNumber().equals(
              other.getFundingInformation().getRoutingNumber())) {
        return false;
      }
    }

    if (this.checkNumber == null) {
      if (other.getCheckNumber() != null) {
        return false;
      }
    } else if (!this.checkNumber.equals(other.getCheckNumber())) {
      return false;
    }

    return true;
  } // end method isEqualLockboxPayment

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isFundingInformationInitialized() {
    return (this.fundingInformation.getFundingAccountNum() != null);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean isFutureDated() {
    Date date1 = DateUtil.toDateOnly(paymentDate);
    Date date2 = DateUtil.toDateOnly(createDate);

    if ((date1 != null) && (date2 != null)) {
      return date1.compareTo(date2) > 0;
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Check if the payment is in process.
   *
   * @return  check if the payment is in process
   */
  public boolean isInProcessPayment() {
    return PaymentStatus.INPROCESS.equals(paymentStatus);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Check if payment is editable.
   *
   * @return  true if editable
   */
  public boolean isInProcessPaymentEditable() {
    Date pDate = DateUtil.getDateStart(paymentDate);
    Date today = DateUtil.getDateStart(new Date());

    return pDate.after(today) && PaymentStatus.INPROCESS.equals(paymentStatus);

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isMasedFundingAccountNum() {
    String fundingAccountNum = this.fundingInformation.getFundingAccountNum();

    if (StringUtils.hasText(fundingAccountNum)
          && fundingAccountNum.matches("X+\\-\\d+")) {
      // mask pattern is 'XXXXXXXXXXX-nnnn'
      return true;
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isNewPayment() {
    return paymentId == null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isPartiallyRejectedPayment() {
    if (CollectionUtils.isEmpty(this.splitPayments)) {
      return false;
    }

    boolean hasRejectedPayment = false;
    boolean hasOtherPayment    = false;

    for (SplitPayment sptPmt : this.splitPayments) {
      if (PaymentStatus.REJECTED.equals(sptPmt.getPaymentStatus())) {
        hasRejectedPayment = true;
      } else {
        hasOtherPayment = true;
      }
    }

    if (hasRejectedPayment && hasOtherPayment) {
      return true;
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Check if the payment could be delete.
   *
   * @return  check if the payment could be delete
   */
  public boolean isPaymentDeletable() {
    // Fixed  FLEX-784(delete payment)
    if (PaymentChannel.EXTERNALENTITY.equals(paymentChannel)) {
      return false;
    }

    return !PaymentStatus.INPROCESS.equals(paymentStatus)
      && !PaymentStatus.REJECTED.equals(paymentStatus)
      && !PaymentStatus.PAID.equals(paymentStatus);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Check if payment is editable.
   *
   * @return  true if editable
   */
  public boolean isPaymentEditable() {
    return !PaymentStatus.INPROCESS.equals(paymentStatus)
      && !PaymentStatus.PAID.equals(paymentStatus);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isPaymentOffer() {
    return paymentProgram != null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isPaymentOfferFirstInstallment() {
    return ((isPaymentOffer() && (order != null)) && (order.intValue() == 1));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean isProcessedByPTP() {
    return processedByPTP;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Check if the payment could be delete.
   *
   * @return  check if the payment could be delete
   */
  public boolean isTsysPaymentDeletable() {
    return !PaymentStatus.REJECTED.equals(paymentStatus)
      && !PaymentStatus.PAID.equals(paymentStatus);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isUsingAmex() {
    return fundingInformation.isAmex();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isUsingBankAccount() {
    return fundingInformation.isBankAccount();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isUsingCard() {
    return fundingInformation.isCardAccount();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isUsingCreditCard() {
    return fundingInformation.isCreditCard();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isUsingDebitCard() {
    return fundingInformation.isDebitCard();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isUsingDinersClub() {
    return fundingInformation.isDinersClub();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isUsingDiscover() {
    return fundingInformation.isDiscover();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isUsingJCB() {
    return fundingInformation.isJCB();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isUsingMasterCard() {
    return fundingInformation.isMasterCard();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isUsingMoneyMarket() {
    return fundingInformation.isMoneyMarket();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isUsingVisa() {
    return fundingInformation.isVisa();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  acceptAgentId  the acceptAgentId to set
   */
  public void setAcceptAgentId(Long acceptAgentId) {
    this.acceptAgentId = acceptAgentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  account  the account to set
   */
  public void setAccount(Account account) {
    this.account = account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  accountBalance  the accountBalance to set
   */
  public void setAccountBalance(BigDecimal accountBalance) {
    this.accountBalance = accountBalance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  accountChargeOffAmount  the accountChargeOffAmount to set
   */
  public void setAccountChargeOffAmount(BigDecimal accountChargeOffAmount) {
    this.accountChargeOffAmount = accountChargeOffAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  agentCallActivity  DOCUMENT ME!
   */
  public void setAgentCallActivity(AgentCallActivity agentCallActivity) {
    this.agentCallActivity = agentCallActivity;
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
   * @param  amount  the amount to set
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
   * @param  appliedToPTP  DOCUMENT ME!
   */
  public void setAppliedToPTP(PromiseToPay appliedToPTP) {
    this.appliedToPTP = appliedToPTP;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  authCode  the authCode to set
   */
  public void setAuthCode(String authCode) {
    // Auth Code length is 20 in DB
    if (StringUtils.hasText(authCode)) {
      if (authCode.length() > 20) {
        this.authCode = authCode.substring(0, 20);
      } else {
        this.authCode = authCode;
      }
    }
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
   * @param  checkNumber  the checkNumber to set
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
   * setter method for currency.
   *
   * @param  currency  String
   */
  public void setCurrency(String currency) {
    this.currency = currency;
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
   * @param  disclosureAudits  DOCUMENT ME!
   */
  public void setDisclosureAudit(Set<DisclosureAudit> disclosureAudits) {
    this.disclosureAudits.clear();
    this.disclosureAudits.addAll(disclosureAudits);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  disclosureAuditId  DOCUMENT ME!
   */
  public void setDisclosureAuditId(Long disclosureAuditId) {
    this.disclosureAuditId = disclosureAuditId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  executePaymentGroup  DOCUMENT ME!
   */
  public void setExecutePaymentGroup(String executePaymentGroup) {
    this.executePaymentGroup = executePaymentGroup;
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
   * @param  fee  the fee to set
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
   * @param  fundingExternalReferenceNumber  DOCUMENT ME!
   */
  public void setFundingExternalReferenceNumber(String fundingExternalReferenceNumber) {
    this.fundingExternalReferenceNumber = fundingExternalReferenceNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  fundingInformation  the fundingInformation to set
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
   * setter method for last updated responsible.
   *
   * @param  lastUpdatedResponsible  Responsible
   */
  public void setLastUpdatedResponsible(Responsible lastUpdatedResponsible) {
    this.lastUpdatedResponsible = lastUpdatedResponsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for max payment date.
   *
   * @param  maxPaymentDate  Date
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
   * setter method for payment allocated.
   *
   * @param  paymentAllocated  Boolean
   */
  public void setPaymentAllocated(Boolean paymentAllocated) {
    this.paymentAllocated = paymentAllocated;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentChannel  the paymentChannel to set
   */
  public void setPaymentChannel(PaymentChannel paymentChannel) {
    this.paymentChannel = paymentChannel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentDate  the paymentDate to set
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
   * setter method for payment detail.
   *
   * @param  paymentDetail  String
   */
  public void setPaymentDetail(String paymentDetail) {
    this.paymentDetail = paymentDetail;
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
   * @param  paymentId  the paymentId to set
   */
  public void setPaymentId(Long paymentId) {
    this.paymentId = paymentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentProgram  the paymentProgram to set
   */
  public void setPaymentProgram(PaymentProgram paymentProgram) {
    this.paymentProgram = paymentProgram;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentProgramInstallment  DOCUMENT ME!
   */
  public void setPaymentProgramInstallment(PaymentProgramInstallment paymentProgramInstallment) {
    this.paymentProgramInstallment = paymentProgramInstallment;
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
   * @param  paymentServiceProvider  the paymentServiceProvider to set
   */
  public void setPaymentServiceProvider(PaymentServiceProvider paymentServiceProvider) {
    this.paymentServiceProvider = paymentServiceProvider;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentStatus  the paymentStatus to set
   */
  public void setPaymentStatus(PaymentStatus paymentStatus) {
    this.paymentStatus = paymentStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentStatusCode  the paymentStatusCode to set
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
  // Added by EtisBew -- Fixed Jira # USB-10 -- END

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
   * @param  processDate  DOCUMENT ME!
   */
  public void setProcessDate(Date processDate) {
    this.processDate = processDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  processedByBatch  the processedByBatch to set
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
   * setter method for process online batch.
   *
   * @param  processOnlineBatch  String
   */
  public void setProcessOnlineBatch(String processOnlineBatch) {
    this.processOnlineBatch = processOnlineBatch;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  promiseToPay  DOCUMENT ME!
   */
  public void setPromiseToPay(PromiseToPay promiseToPay) {
    this.promiseToPay = promiseToPay;
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
   * @param  responsible  the responsible to set
   */
  public void setResponsible(Responsible responsible) {
    this.responsible = responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  retryCount  the retryCount to set
   */
  public void setRetryCount(Integer retryCount) {
    this.retryCount = retryCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  splitPayment  DOCUMENT ME!
   */
  public void setSplitPayment(Set<SplitPayment> splitPayment) {
    this.splitPayments = splitPayment;
  }
  // Added by Etisbew on 07/15/09 for SP payment basic information -- END

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
   * setter method for third party.
   *
   * @param  thirdParty  Boolean
   */
  public void setThirdParty(Boolean thirdParty) {
    this.thirdParty = thirdParty;
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
   * setter method for transient account num.
   *
   * @param  transientAccountNum  Long
   */
  public void setTransientAccountNum(Long transientAccountNum) {
    this.transientAccountNum = transientAccountNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  updateAgentId  the updateAgentId to set
   *
   *                        <p>not-null = "false"</p>
   */
  public void setUpdateAgentId(Long updateAgentId) {
    this.updateAgentId = updateAgentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  updatePaymentChannel  the updatePaymentChannel to set
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

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Constructs a <code>String</code> with all attributes in name = value format.
   *
   * @return  a <code>String</code> representation of this object.
   */
  @Override public String toString() {
    final String TAB = "    ";

    StringBuilder retValue = new StringBuilder();

    retValue.append("Payment ( ").append(super.toString()).append(TAB).append("acceptAgentId = ").append(
      this.acceptAgentId).append(TAB).append(TAB).append("accountBalance = ").append(this.accountBalance).append(TAB)
      .append("AccountId = ").append(this.account.getAccountNum()).append(TAB).append("accountChargeOffAmount = ")
      .append(this.accountChargeOffAmount).append(TAB).append("amount = ").append(this.amount).append(TAB).append(
      "fee = ").append(this.fee).append(TAB).append("fundingAccountId = ").append(this.fundingAccountId).append(TAB)
      .append("fundingInformation = ").append(this.fundingInformation).append(TAB).append("paymentChannel = ").append(
      this.paymentChannel).append(TAB).append("paymentDate = ").append(this.paymentDate).append(TAB).append(
      "paymentId = ").append(this.paymentId).append(TAB).append("paymentProgramId = ").append(
      (this.paymentProgram != null) ? this.paymentProgram.getProgramId() : null).append(
      TAB).append("paymentProgramInstallmentId = ").append((this.paymentProgramInstallment != null)
        ? this.paymentProgramInstallment.getInstallmentId() : null).append(TAB).append("paymentReminder = ").append(
      this.paymentReminder).append(TAB).append("paymentServiceProviderId = ").append(
      (this.getPaymentServiceProvider() != null) ? this.getPaymentServiceProvider().getProviderId() : null).append(TAB)
      .append("paymentStatus = ").append((this.paymentStatus != null) ? this.paymentStatus : "").append(TAB).append(
      "responsibleId = ").append((this.responsible != null) ? this.responsible.getResponsibleId() : "").append(TAB)
      .append("updateAgentId = ").append(this.updateAgentId).append(TAB).append("updatePaymentChannel = ").append(
      this.updatePaymentChannel).append(TAB).append(" )");

    return retValue.toString();
  } // end method toString

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updateAccount.
   *
   * @param  account  Account
   */
  public void updateAccount(Account account) {
    this.account = account;

    if (account != null) {
      this.setAccountBalance(account.getBalance());
      this.setAccountChargeOffAmount(account.getChargeOffAmount());
      this.setTransientAccountNum(account.getAccountNum());

      if (Boolean.TRUE.equals(account.getTestAccount())) {
        this.setTestPayment(Boolean.TRUE);
      } else {
        this.setTestPayment(Boolean.FALSE);
      }
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Update current lockbox payment.
   *
   * @param   other  DOCUMENT ME!
   *
   * @return  update current lockbox payment
   */
  public boolean updateLockboxPayment(Payment other) {
    if (!isEqualLockboxPayment(other)) {
      this.creatLockboxPayment(other);
      this.setLastUpdateDate(new Date());

      return true;
    } else {
      return false;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Update payemnt based on payment basic information.
   *
   * @param  payment  DOCUMENT ME!
   */
  public void updatePayment(Payment payment) {
    if (payment == null) {
      return; // null payment is not defined. do nothing.
    }

    this.amount = payment.getAmount();
    this.fee    = payment.getFee();

    if (payment.getPaymentDate() != null) {
      this.paymentDate = new Date(payment.getPaymentDate().getTime());
    }

    if (this.paymentReminder != null) {
      if ((payment.getPaymentReminder() == null)
            || ReminderType.NONE.equals(
              payment.getPaymentReminder().getReminderType())) {
        this.paymentReminder = null;
      } else {
        this.paymentReminder.deepCopy(payment.getPaymentReminder());
      }
    } else if (payment.getPaymentReminder() != null) {
      if (!ReminderType.NONE.equals(
              payment.getPaymentReminder().getReminderType())) {
        this.paymentReminder = new PaymentReminder();
        this.paymentReminder.deepCopy(payment.getPaymentReminder());
      }
    }

    this.updatePaymentChannel = payment.getUpdatePaymentChannel();

    if (payment.getFundingAccountId() != null) {
      this.fundingAccountId = payment.getFundingAccountId();
    }

    if (payment.getFundingInformation() != null) {
      this.fundingInformation.deepCopy(payment.getFundingInformation());
    }

    this.setExternalReferenceNumber(payment.getExternalReferenceNumber());
    this.setFundingExternalReferenceNumber(payment.getFundingExternalReferenceNumber());


    Date now = new Date();
    this.setUpdatePaymentDate(now);
    this.setLastUpdateDate(now);

    if (payment.getPaymentServiceProvider() != null) {
      this.setPaymentServiceProvider(payment.getPaymentServiceProvider());
    }
  } // end method updatePayment

  //~ ------------------------------------------------------------------------------------------------------------------

  // Added by Etisbew on 07/15/09 for SP payment basic information -- START
  /**
   * Update existing payment object based on response from querystring.
   *
   * @param  payment  DOCUMENT ME!
   */
  public void updateSPPayment(Payment payment) {
    if (payment == null) {
      return; // null payment is not defined. do nothing.
    }

    this.amount = payment.getAmount();
    this.fee    = payment.getFee();

    if (payment.getPaymentDate() != null) {
      this.paymentDate = new Date(payment.getPaymentDate().getTime());
    }

    if (payment.getPaymentStatus() != null) {
      this.paymentStatus = payment.getPaymentStatus();
    }

    if (payment.getPaidStatusDate() != null) {
      this.paidStatusDate = new Date(payment.getPaidStatusDate().getTime());
    }

    if (payment.getRejectedStatusDate() != null) {
      this.rejectedStatusDate = new Date(payment.getRejectedStatusDate().getTime());
    }

    if (this.paymentReminder != null) {
      if ((payment.getPaymentReminder() == null)
            || ReminderType.NONE.equals(
              payment.getPaymentReminder().getReminderType())) {
        this.paymentReminder = null;
      } else {
        this.paymentReminder.deepCopy(payment.getPaymentReminder());
      }
    } else if (payment.getPaymentReminder() != null) {
      if (!ReminderType.NONE.equals(
              payment.getPaymentReminder().getReminderType())) {
        this.paymentReminder = new PaymentReminder();
        this.paymentReminder.deepCopy(payment.getPaymentReminder());
      }
    }

    this.updatePaymentChannel = payment.getUpdatePaymentChannel();

    if (payment.getFundingAccountId() != null) {
      this.fundingAccountId = payment.getFundingAccountId();
    }

    if (payment.getFundingInformation() != null) {
      this.fundingInformation.deepCopy(payment.getFundingInformation());
    }

    this.setLastUpdateDate(new Date());
  } // end method updateSPPayment
} // end class Payment
