package com.cmc.credagility.core.domain.payment;

import java.io.Serializable;

import java.math.BigDecimal;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import java.util.Date;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.type.BankAccountType;
import com.cmc.credagility.core.domain.type.CardType;
import com.cmc.credagility.core.domain.type.FundingAccountType;
import com.cmc.credagility.core.domain.type.PaymentChannel;
import com.cmc.credagility.core.domain.type.PaymentStatus;
import com.cmc.credagility.core.domain.util.CompareUtil;
import com.cmc.credagility.core.domain.util.DateUtil;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * This class is used to store Split Payment information.
 *
 * <p>table = "SplitPayment"</p>
 *
 * @version  $Revision$, $Date$
 * @author   Knandyala
 */
@Entity
@Table(
  name    = "SplitPayment",
  indexes = {
    @Index(
      name = "postalCodeIndex",
      columnList = "postalCode"
    )
  }
)
public class SplitPayment extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -8939441162724270063L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** agent id - used for performance tracking purpose. */
  @Column(name = "acceptAgentId")
  protected Long acceptAgentId;


  // npelleti 08/01 USB made column amount not null, add precision.
  /** payment amount. */
  @Column(
    name      = "amount",
    nullable  = false,
    precision = 19,
    scale     = 2
  )
  protected BigDecimal amount;

  // npelleti 08/01 USB Specified length 20 to authcode
  /** payment auth Code. */
  @Column(
    name   = "authCode",
    length = 20
  )
  protected String authCode;


  /** batchRunTimeStamp is when the batch job was run for this particular batch file. */
  @Column(name = "batchRunTimeStamp")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date batchRunTimeStamp;

  /** Check number if it was the check payment. */
  @Column(
    name   = "checkNumber",
    length = 10
  )
  protected String checkNumber;

  /** commission money. */
  @Column(name = "commission")
  protected BigDecimal commission;

  /** The date of deleted status. */
  @Column(name = "deletedStatusDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date deletedStatusDate;

  /** External Reference number. */
  @Column(
    name   = "externalReferenceNumber",
    length = 20
  )
  protected String externalReferenceNumber;

  // npelleti USB moved fee after commission,not null, specified precision
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

  /** Funding Object information, keep a copy from funding account. */
  @Embedded protected FundingInformation fundingInformation = new FundingInformation();


  /** The date of paid status. */
  @Column(name = "paidStatusDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date paidStatusDate;

  /** payment id. */
  @JoinColumn(
    name      = "paymentId",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected Payment payment;


  // npelleti 08/17 Made PaymentDate column not null
  /** payment date. */
  @Column(
    name     = "paymentDate",
    nullable = false
  )
  @Temporal(TemporalType.TIMESTAMP)
  protected Date paymentDate;

  /**
   * Payment delete source <code>enum.</code>
   *
   * @see  com.cmc.credagility.core.domain.type.PaymentChannel
   */
  @Column(
    name   = "paymentDeletedSource",
    length = 20
  )
  @Enumerated(EnumType.STRING)
  protected PaymentChannel paymentDeletedSource;

  /** Payment note. */
  @Column(
    name   = "paymentNote",
    length = 250
  )
  protected String paymentNote;


  /** payment reference. */
  @Column(
    name   = "paymentReference",
    length = 250
  )
  protected String paymentReference;

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

  /** payment status link. */
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

/*
    @Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.ALL })
 */
  /**
   * Promise to pay.
   *
   * @see  com.cmc.credagility.core.domain.payment.PromiseToPay
   */
  @OneToOne(
    fetch    = FetchType.LAZY,
    mappedBy = "payment"
  )
  protected PromiseToPay promiseToPay;

  /** The date of reject authorization. */
  @Column(name = "rejectedAtAuthorizationDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date rejectedAtAuthorizationDate;

  /** The date of reject status. */
  @Column(name = "rejectedStatusDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date rejectedStatusDate;


  /** count retry time. */
  @Column(name = "retryCount")
  protected Integer retryCount = 0;

  /** splitPayment PK splitPaymentId. */
  @Column(
    name     = "spliPaymentId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long splitPaymentId;

  /** The description of status. */
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

  /** The date of update payment. */
  @Column(name = "updatePaymentDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date updatePaymentDate;

  /** Fee charged to debtor by payment service provider. */
  @Column(name = "userServiceFee")
  protected BigDecimal userServiceFee = new BigDecimal("0.0");


  /** version if this payment is submitted by XML. no need to persist. */
  @Transient protected String xmlVersion = "";

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

    final SplitPayment other = (SplitPayment) obj;

    if (this.paymentReference != null) {
      if (this.paymentReference.equalsIgnoreCase(other.getPaymentReference())) {
        return true;
      }

      return false;
    }

    return true;
  } // end method businessEquals

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
    this.fundingInformation.ensureNickName(this.payment.getAccount().getPortfolio().getPortfolioId());

    // always be checking account
    this.fundingInformation.type    = FundingAccountType.BANKACCOUNT.toString();
    this.fundingInformation.subType = BankAccountType.CHECKING.toString();
    this.checkNumber                = other.getCheckNumber();

    // always inprocess while create
    this.paymentStatus = PaymentStatus.INPROCESS;
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

    if (!super.equals(obj)) {
      return false;
    }

    return true;
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
  public Date getBatchRunTimeStamp() {
    return batchRunTimeStamp;
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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getDeletedStatusDate() {
    return deletedStatusDate;
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

    return DateUtil.addDays(getPaymentDate(), days);

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
   * @param   pReference  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public SplitPayment getFDRSplitPayment(String pReference) {
    // TODO  Logic for returning the FDR loans
    return null;
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
   * The fundingInformation.
   *
   * @return  the fundingInformation
   */
  public FundingInformation getFundingInformation() {
    return this.fundingInformation;
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
  public Payment getPayment() {
    return payment;
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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPaymentNote() {
    return paymentNote;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPaymentReference() {
    return paymentReference;
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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getSplitPaymentId() {
    return splitPaymentId;
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
      + ((this.amount == null) ? 0 : this.amount.hashCode());
    result = (PRIME * result)
      + ((this.fee == null) ? 0 : this.fee.hashCode());
    result = (PRIME * result)
      + ((this.fundingAccountId == null) ? 0 : this.fundingAccountId.hashCode());
    result = (PRIME * result)
      + ((this.fundingInformation == null) ? 0 : this.fundingInformation.hashCode());

    result = (PRIME * result)
      + ((this.paymentDate == null) ? 0 : this.paymentDate.hashCode());

    result = (PRIME * result)
      + ((this.createDate == null) ? 0 : this.createDate.hashCode());


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
  public boolean isClassPayment() {
    return StringUtils.equals("CLASS", this.paymentReference);
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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isGroupedFdrPayment() {
    return StringUtils.isNotEmpty(this.getPaymentNote());
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
    if (((paymentDate != null) && paymentDate.after(new Date()))
          && PaymentStatus.INPROCESS.equals(paymentStatus)) {
      return true;
    } else {
      return false;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isMasedFundingAccountNum() {
    String fundingAccountNum = this.fundingInformation.getFundingAccountNum();

    if (StringUtils.isNotEmpty(fundingAccountNum)
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
    return splitPaymentId == null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Check if the payment could be delete.
   *
   * @return  check if the payment could be delete
   */
  public boolean isPaymentDeletable() {
    return !PaymentStatus.INPROCESS.equals(paymentStatus)
      && !PaymentStatus.PAID.equals(paymentStatus)
      && !PaymentStatus.DELETED.equals(paymentStatus);
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
   * Check if the payment could be delete.
   *
   * @return  check if the payment could be delete
   */
  public boolean isTsysPaymentDeletable() {
    return !PaymentStatus.REJECTED.equals(paymentStatus)
      && !PaymentStatus.PAID.equals(paymentStatus)
      && !PaymentStatus.DELETED.equals(paymentStatus);
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
   * @param  amount  the amount to set
   */
  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  authCode  the authCode to set
   */
  public void setAuthCode(String authCode) {
    this.authCode = authCode;
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
   * @param  fundingInformation  the fundingInformation to set
   */
  public void setFundingInformation(FundingInformation fundingInformation) {
    this.fundingInformation = fundingInformation;
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
   * @param  payment  DOCUMENT ME!
   */
  public void setPayment(Payment payment) {
    this.payment = payment;
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
   * DOCUMENT ME!
   *
   * @param  paymentNote  DOCUMENT ME!
   */
  public void setPaymentNote(String paymentNote) {
    this.paymentNote = paymentNote;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentReference  DOCUMENT ME!
   */
  public void setPaymentReference(String paymentReference) {
    this.paymentReference = paymentReference;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentServiceProvider  the paymentServiceProvider to set
   */
  public void setPaymentServiceProvider(
    PaymentServiceProvider paymentServiceProvider) {
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
  public void setRejectedAtAuthorizationDate(
    Date rejectedAtAuthorizationDate) {
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
   * @param  retryCount  the retryCount to set
   */
  public void setRetryCount(Integer retryCount) {
    this.retryCount = retryCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  splitPaymentId  DOCUMENT ME!
   */
  public void setSplitPaymentId(Long splitPaymentId) {
    this.splitPaymentId = splitPaymentId;
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

    retValue.append("SplitPayment ( ").append(super.toString()).append(TAB).append(TAB).append("amount = ").append(
      this.amount).append(TAB).append(
      "fee = ").append(this.fee).append(TAB).append("fundingAccountId = ").append(
      this.fundingAccountId).append(TAB).append("fundingInformation = ").append(this.fundingInformation).append(TAB)
      .append(
        "paymentDate = ").append(this.paymentDate).append(TAB).append(
      "splitPaymentId = ").append(this.splitPaymentId).append(TAB).append(TAB).append(
      "paymentServiceProviderId = ").append(
      (this.getPaymentServiceProvider() != null) ? this.getPaymentServiceProvider().getProviderId() : null).append(TAB)
      .append("paymentStatus = ").append((this.paymentStatus != null) ? this.paymentStatus : "").append(TAB).append(
      "updateAgentId = ").append(
      this.updateAgentId).append(TAB).append("updatePaymentChannel = ").append(this.updatePaymentChannel).append(TAB)
      .append(" )");

    return retValue.toString();
  } // end method toString

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

    this.updatePaymentChannel = payment.getUpdatePaymentChannel();

    if (payment.getFundingAccountId() != null) {
      this.fundingAccountId = payment.getFundingAccountId();
    }

    if (payment.getFundingInformation() != null) {
      this.fundingInformation.deepCopy(payment.getFundingInformation());
    }

    this.setExternalReferenceNumber(payment.getExternalReferenceNumber());

    Date now = new Date();
    this.setUpdatePaymentDate(now);
    this.setLastUpdateDate(now);
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

    this.updatePaymentChannel = payment.getUpdatePaymentChannel();

    if (payment.getFundingAccountId() != null) {
      this.fundingAccountId = payment.getFundingAccountId();
    }

    if (payment.getFundingInformation() != null) {
      this.fundingInformation.deepCopy(payment.getFundingInformation());
    }

    this.setLastUpdateDate(new Date());
  } // end method updateSPPayment
} // end class SplitPayment
