package com.cmc.credagility.core.domain.payment;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.util.StringUtils;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.activity.AgentCallActivity;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.message.MessageStaging;
import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.domain.type.PaymentChannel;
import com.cmc.credagility.core.domain.type.PaymentMethod;
import com.cmc.credagility.core.domain.type.PaymentStatus;
import com.cmc.credagility.core.domain.type.PromiseToPayChannel;
import com.cmc.credagility.core.domain.type.PromiseToPayStatus;
import com.cmc.credagility.core.domain.util.DateUtil;


/**
 * This class is used to store Promise to pay information.
 *
 * <p><a href="PromiseToPay.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 * @version  $Revision$, $Date$
 *
 *           <p>table = "PromiseToPay"</p>
 */
@Entity
@Table(name = "PromiseToPay")
public class PromiseToPay extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  protected static final transient Logger log = LoggerFactory.getLogger(
      PromiseToPay.class);

  private static final long serialVersionUID = 5615768407587644942L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

// npelleti, 07/30, USBank, Made column not null
// npelleti 08/17, UBank made column nullable
  /** accept agent. */
  @Column(name = "acceptAgentId")
  protected Long acceptAgentId;

  /** Account Number which account in used. */
  @JoinColumn(
    name      = "accountNum",
    nullable  = false,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Account account;

  /** AgentCallActivity PK activityId. */
  @JoinColumn(
    name       = "activityId",
    insertable = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected AgentCallActivity agentCallActivity;

  /** PTP Arrival date. */
  @Column(
    name     = "arrivalDate",
    nullable = false
  )
  @Temporal(TemporalType.TIMESTAMP)
  protected Date arrivalDate;

  /** DOCUMENT ME! */
  @Column(
    name      = "balance",
    nullable  = true,
    precision = 19,
    scale     = 2
  )
  protected BigDecimal balance;

  /** Broken Status date. */
  @Column(
    name     = "brokenStatusDate",
    nullable = true
  )
  @Temporal(TemporalType.TIMESTAMP)
  protected Date brokenStatusDate;

  /** DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal",
    nullable  = true,
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal;

  /** deleted agent. */
  @Column(
    name     = "deletedAgentId",
    nullable = true
  )
  protected Long deletedAgentId;

  /** Deleted Status date. */
  @Column(
    name     = "deletedStatusDate",
    nullable = true
  )
  @Temporal(TemporalType.TIMESTAMP)
  protected Date deletedStatusDate;

  /** External agent Id. */
  @Column(
    name   = "externalAgentId",
    length = 255
  )
  protected String externalAgentId;

/*
 */
  /** Create date. */
  /*

  @Column(
  name      = "createDate",
  nullable  = false,
  updatable = false
  )
  @Index(name = "promiseToPayCreateDateIndex")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date createDate;
   */

  /** DOCUMENT ME! */
  @Column(
    name     = "externalReferenceNumber",
    nullable = true,
    length   = 20
  )
  protected String externalReferenceNumber;

  /** DOCUMENT ME! */
  @Column(
    name     = "externalStatus",
    nullable = true,
    length   = 50
  )
  /*@Enumerated(EnumType.STRING)*/
  protected String externalStatus;

  /** DOCUMENT ME! */
  @Column(
    name     = "externalStatusCode",
    nullable = true,
    length   = 20
  )
  protected String externalStatusCode;

  /** DOCUMENT ME! */
  @Column(
    name     = "externalStatusDescription",
    nullable = true,
    length   = 250
  )
  protected String externalStatusDescription;

  /** DOCUMENT ME! */
  @Column(
    name     = "externalStatusEffectiveDate",
    nullable = true
  )
  @Temporal(TemporalType.TIMESTAMP)
  protected Date externalStatusEffectiveDate;

  /** DOCUMENT ME! */
  @Column(
    name     = "frequency",
    nullable = true,
    length   = 25
  )
  protected String frequency;

  /** Inactive Status date. */
  @Column(
    name     = "inactiveStatusDate",
    nullable = true
  )
  @Temporal(TemporalType.TIMESTAMP)
  protected Date inactiveStatusDate;

  /** Kept Status Date. */
  @Column(
    name     = "keptStatusDate",
    nullable = true
  )
  @Temporal(TemporalType.TIMESTAMP)
  protected Date keptStatusDate;

  /** DOCUMENT ME! */
  @JoinColumn(
    name     = "messageStagingId",
    unique   = false,
    nullable = true
  )
  @OneToOne(fetch = FetchType.EAGER)
  protected MessageStaging messageStaging;

  /** DOCUMENT ME! */
  @Column(name = "numberOfPayments")
  protected Integer numberOfPayments;

  /** Outstanding Status Date. */
  @Column(
    name     = "outstandingStatusDate",
    nullable = true
  )
  @Temporal(TemporalType.TIMESTAMP)
  protected Date outstandingStatusDate;

  /** DOCUMENT ME! */
  @JoinColumn(
    name     = "paymentId",
    unique   = false,
    nullable = true
  )
  @OneToOne(fetch = FetchType.LAZY)
  /*@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)*/
  protected Payment payment;

  // npelleti, 07/30, USBank, Added NotNull Annotation
  /** payment amount. */
  @Column(
    name      = "paymentAmount",
    nullable  = false,
    precision = 19,
    scale     = 2
  )
  protected BigDecimal paymentAmount;

  /** payment date. */
  @Column(
    name     = "paymentDate",
    nullable = true
  )
  @Temporal(TemporalType.TIMESTAMP)
  protected Date paymentDate;

  /** payment method. */
  @JoinColumn(
    name     = "ptpPaymentMethodConfigurationId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected PtpPaymentMethodConfiguration paymentMethodConfiguration;

  /** DOCUMENT ME! */
  @JoinColumn(
    name     = "installmentId",
    unique   = true,
    nullable = true
  )
  @OneToOne(fetch = FetchType.LAZY)
  protected PaymentProgramInstallment paymentProgramInstallment;

  /** promise to pay service provider. */
  @JoinColumn(
    name     = "providerId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PaymentServiceProvider paymentServiceProvider;


// npelleti, 07/30, USBank, Removed unique constraint
  /** promise to pay PK promiseId. */
  @Column(
    name     = "promiseId",

    /*unique   = true,*/
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long promiseId;

  /** DOCUMENT ME! */
  @Column(
    name      = "ptpChannel",
    nullable  = true,
    updatable = false,
    length    = 20
  )
  @Enumerated(EnumType.STRING)
  protected PromiseToPayChannel ptpChannel;

  /** DOCUMENT ME! */
  @Column(
    name     = "ptpStatus",
    nullable = false,
    length   = 50
  )
  @Enumerated(value = EnumType.STRING)
  protected PromiseToPayStatus ptpStatus = PromiseToPayStatus.OUTSTANDING;

  /** DOCUMENT ME! */
  @Column(name = "realAmount")
  protected BigDecimal realAmount;

  /** caller responsible id. */
  @JoinColumn(
    name      = "responsibleId",
    nullable  = false,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Responsible responsible;

  /** PTP Arrival date. */
  @Column(
    name     = "sendDate",
    nullable = false
  )
  @Temporal(TemporalType.TIMESTAMP)
  protected Date sendDate;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "updatedByBatch",
    length   = 1,
    nullable = true
  )
  protected String updatedByBatch;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "updatedByBatchDate",
    nullable = true
  )
  @Temporal(TemporalType.TIMESTAMP)
  protected Date updatedByBatchDate;


  @Transient private String actionType;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Set createDate when new an object.
   */

  public PromiseToPay() {
    this.createDate     = new Date();
    this.lastUpdateDate = createDate;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (!super.equals(obj)) {
      return false;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    final PromiseToPay other = (PromiseToPay) obj;

    if (this.createDate == null) {
      if (other.getCreateDate() != null) {
        return false;
      }
    } else if (!this.createDate.equals(other.getCreateDate())) {
      return false;
    }

    if (this.getAcceptAgentId() == null) {
      if (other.getAcceptAgentId() != null) {
        return false;
      }
    } else if (!this.getAcceptAgentId().equals(other.getAcceptAgentId())) {
      return false;
    }

    if (this.getArrivalDate() == null) {
      if (other.getArrivalDate() != null) {
        return false;
      }
    } else if (!this.getArrivalDate().equals(other.getArrivalDate())) {
      return false;
    }

    if (this.getPaymentAmount() == null) {
      if (other.getPaymentAmount() != null) {
        return false;
      }
    } else if (!this.getPaymentAmount().equals(other.getPaymentAmount())) {
      return false;
    }

    if (this.getPaymentDate() == null) {
      if (other.getPaymentDate() != null) {
        return false;
      }
    } else if (!this.getPaymentDate().equals(other.getPaymentDate())) {
      return false;
    }

    if (this.getPaymentMethodConfiguration() == null) {
      if (other.getPaymentMethodConfiguration() != null) {
        return false;
      }
    } else if (!this.getPaymentMethodConfiguration().equals(
            other.getPaymentMethodConfiguration())) {
      return false;
    }

    if (this.getResponsible() == null) {
      if (other.getResponsible() != null) {
        return false;
      }
    } else if (!this.getResponsible().equals(other.getResponsible())) {
      return false;
    }

    if (this.payment == null) {
      if (other.getPayment() != null) {
        return false;
      }
    } else if (!payment.equals(other.getPayment())) {
      return false;
    }

    if (this.paymentProgramInstallment == null) {
      if (other.getPaymentProgramInstallment() != null) {
        return false;
      }
    } else if (!this.paymentProgramInstallment.equals(
            other.getPaymentProgramInstallment())) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  dOCUMENT ME!
   */
  public Boolean evaluate() {
    Date    today         = DateUtil.toDateOnly(new Date());
    Boolean statusChanged = Boolean.FALSE;

    Date                          now                        = new Date();
    BigDecimal                    realAmount                 = getRealAmount();
    BigDecimal                    paymentAmount              = getPaymentAmount();
    PtpPaymentMethodConfiguration method                     = getPaymentMethodConfiguration();
    BigDecimal                    minimumAmountRateToKeptPTP = null;

    if (method != null) {
      minimumAmountRateToKeptPTP = method.getMinimumAmountRateToKeptPTP();
    }

    if (minimumAmountRateToKeptPTP == null) {
      minimumAmountRateToKeptPTP = new BigDecimal(1);
    }

    BigDecimal minAmountToKepPTP = paymentAmount.multiply(minimumAmountRateToKeptPTP);

    if (log.isDebugEnabled()) {
      log.debug("Before PTP evaluation :: today=" + today
        + " getEvaluationDate()=" + getEvaluationDate() + " ptpStatus="
        + getPtpStatus() + " paymentAmount=" + paymentAmount
        + " realAmount=" + realAmount + " minimumAmountRateToKeptPTP=" + minimumAmountRateToKeptPTP
        + " minAmountToKepPTP=" + minAmountToKepPTP);
    }

    if (realAmount != null) {
      if (realAmount.compareTo(paymentAmount) >= 0) {
        setPtpStatus(PromiseToPayStatus.KEPT);
        setKeptStatusDate(now);
        statusChanged = Boolean.TRUE;

        if (log.isDebugEnabled()) {
          log.debug("After PTP evaluation :: today=" + today
            + " getEvaluationDate()=" + getEvaluationDate()
            + " ptpStatus=" + getPtpStatus() + " paymentAmount="
            + paymentAmount + " realAmount=" + realAmount
            + " statusChanged=" + statusChanged);
        }

        return statusChanged;
      }
    }

    if (!getEvaluationDate().after(today)) {
      setPtpStatus(PromiseToPayStatus.BROKEN);
      setBrokenStatusDate(now);
      statusChanged = Boolean.TRUE;
    }

    if (log.isDebugEnabled()) {
      log.debug("After PTP evaluation :: today=" + today
        + " getEvaluationDate()=" + getEvaluationDate() + " ptpStatus="
        + getPtpStatus() + " paymentAmount=" + paymentAmount
        + " realAmount=" + realAmount + " statusChanged="
        + statusChanged);
    }

    return statusChanged;
  } // end method evaluate

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   */
  public void evaluatePromiseFullfilment() {
    Date today               = DateUtil.toDateOnly(new Date());
    Date finalEvaluationDate = getEvaluationDate();
    finalEvaluationDate = DateUtil.toDateOnly(finalEvaluationDate);

    int diffTodayFinalEvalDate = DateUtil.getDayDifference(today,
        finalEvaluationDate);

    if (log.isDebugEnabled()) {
      log.debug(
        "PromiseToPay.evaluatePromiseFullfilment() :: finalEvaluationDate="
        + finalEvaluationDate);
    }

    if (PromiseToPayStatus.FUTURE.equals(getPtpStatus())) {
      if ((diffTodayFinalEvalDate > 0)
            && finalEvaluationDate.after(today)) {
        setPtpStatus(PromiseToPayStatus.OUTSTANDING);
      } else {
        setPtpStatus(PromiseToPayStatus.BROKEN);

        return;
      }
    }

    List<Payment> paymentsAgainstOutstandingPromises = getPaymentsAgainstOutstandingPromise();

    if ((paymentsAgainstOutstandingPromises != null)
          && (paymentsAgainstOutstandingPromises.size() > 0)) {
      BigDecimal paymentAmount = new BigDecimal(0);

      for (Payment payment : paymentsAgainstOutstandingPromises) {
        paymentAmount = paymentAmount.add(payment.getAmount());
      }

      BigDecimal difference = paymentAmount.subtract(getPaymentAmount());

      if (difference.doubleValue() >= 0) {
        setPtpStatus(PromiseToPayStatus.KEPT);
      } else {
        if ((diffTodayFinalEvalDate > 0)
              && finalEvaluationDate.after(today)) {
          setPtpStatus(PromiseToPayStatus.OUTSTANDING);
        } else {
          setPtpStatus(PromiseToPayStatus.BROKEN);
        }
      }
    } else {
      if (!finalEvaluationDate.before(today)) {
        setPtpStatus(PromiseToPayStatus.OUTSTANDING);
      } else {
        setPtpStatus(PromiseToPayStatus.BROKEN);
      }
    } // end if-else

    /*} else {*/
    if (!account.isActive()) {
      setPtpStatus(PromiseToPayStatus.INACTIVE);
    }
    /*} // end if-else*/

    setLastUpdateDate(new Date());
  } // end method evaluatePromiseFullfilment

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The acceptAgentId.
   *
   * @return  the acceptAgentId
   *
   *          <p>not-null = "true"</p>
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
   * getter method for action type.
   *
   * @return  String
   */
  public String getActionType() {
    return actionType;
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
  public BigDecimal getAllAmountSoFar() {
    return getAmountSoFar(PaymentStatus.PAID).add(getAmountSoFar(
          PaymentStatus.SCHEDULED).add(
          getAmountSoFar(PaymentStatus.INPROCESS)));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getArrivalDate() {
    return arrivalDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getBalance() {
    return balance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getBrokenStatusDate() {
    return brokenStatusDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getClientDefinedDecimal() {
    return clientDefinedDecimal;
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

/*  */
  /**
   * The createDate.
   *
   * @return  the createDate
   *
   *          <p>not-null = "true" update = "false"</p>
   */
  /*
  @Override public Date getCreateDate() {
  return createDate;
  }*/

  /**
   * Get DoNotContactUntil date caused by this promise. It equals paymentDate.
   *
   * <p>For premature calls (when paymentDate is null), this method returns current datetime to make sure it won't
   * affetc DoNotContact decision.</p>
   *
   * @return  get DoNotContactUntil date caused by this promise.
   */
  public Date getDoNotContactUntil() {
    Date d = null;

    if (paymentDate == null) {
      d = new Date();
    } else {
      d = paymentDate;
    }

    Integer days = getAccount().getPortfolio().getDoNotContactPTPDays();

    if ((getPaymentMethodConfiguration() != null)
          && (PaymentMethod.WESTERNUNION.toString().equalsIgnoreCase(
              getPaymentMethodConfiguration().getPaymentMethod())
            || PaymentMethod.MONEYGRAM.toString().equalsIgnoreCase(
              getPaymentMethodConfiguration().getPaymentMethod()))) {
      days = getAccount().getPortfolio().getDoNotContactWUPTPDays();
    }

    return DateUtil.addDays(d, days);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getEvaluationDate() {
    if ((account != null) && (arrivalDate != null)) {
      Portfolio portfolio = account.getPortfolio();

      if ((portfolio != null)
            && (portfolio.getPtpEvalToleranceDays() != null)) {
        int numberOfDaysToStopEvaluation = portfolio.getPtpEvalToleranceDays();

        return DateUtil.addDays(arrivalDate,
            numberOfDaysToStopEvaluation);
      }
    }

    Date finalEvaluationDate = DateUtil.addDays(arrivalDate, 2);

    finalEvaluationDate = DateUtil.toDateOnly(finalEvaluationDate);

/*
    finalEvaluationDate.setHours(23);
    finalEvaluationDate.setMinutes(59);
    finalEvaluationDate.setSeconds(59);
 */

    return finalEvaluationDate;
  } // end method getEvaluationDate

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getExternalAgentId() {
    return externalAgentId;
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
  public String getExternalStatus() {
    return externalStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getExternalStatusCode() {
    return externalStatusCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getExternalStatusDescription() {
    return externalStatusDescription;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getExternalStatusEffectiveDate() {
    return externalStatusEffectiveDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getFrequency() {
    return frequency;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getInactiveStatusDate() {
    return inactiveStatusDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getInProcessAmountSoFar() {
    return getAmountSoFar(PaymentStatus.INPROCESS);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getKeptStatusDate() {
    return keptStatusDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public MessageStaging getMessageStaging() {
    return messageStaging;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getNumberOfPayments() {
    return numberOfPayments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getOutstandingStatusDate() {
    return outstandingStatusDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getPaidAmountSoFar() {
    return getAmountSoFar(PaymentStatus.PAID);
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
   * The paymentAmount.
   *
   * @return  the paymentAmount
   *
   *          <p>not-null = "true"</p>
   */
  public BigDecimal getPaymentAmount() {
    return this.paymentAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   *          <p>not-null = "true" length = "20" type = "com.cmc.dao.hibernate.support.PaymentChannelUserType"</p>
   */
  public PaymentChannel getPaymentChannel() {
    PtpPaymentMethodConfiguration ptpPaymentMethodConfiguration = getPaymentMethodConfiguration();
    PaymentChannel                pmtChannel                    = null;

    if (ptpPaymentMethodConfiguration != null) {
      String paymentMethodStr = ptpPaymentMethodConfiguration.getPaymentMethod();

      if (StringUtils.hasText(paymentMethodStr)) {
        try {
          pmtChannel = PaymentChannel.valueOf(
              paymentMethodStr.toUpperCase());
        } catch (Throwable t) {
          log.warn(t.getMessage(), t);
        }
      }
    }

    return pmtChannel;
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
    return this.paymentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PtpPaymentMethodConfiguration getPaymentMethodConfiguration() {
    return paymentMethodConfiguration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PaymentProgramInstallment getPaymentProgramInstallment() {
    return paymentProgramInstallment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Aggregates all the payments between the start of evaluation and arrival date of the current promise. It checks for
   * the payment post date to be between these 2 dates.
   *
   * @return  DOCUMENT ME!
   */
  public List<Payment> getPaymentsAgainstOutstandingPromise() {
    Date startEvaluationDate = DateUtil.toDateOnly(
        getStartEvaluationDate());
    Date arrivalDueDate      = DateUtil.toDateOnly(getArrivalDate());
    Date stopEvaluationDate  = DateUtil.toDateOnly(getEvaluationDate());

    if (log.isDebugEnabled()) {
      log.debug(
        "PromiseToPay.getPaymentsAgainstOutstandingPromise() :: startEvaluationDate="
        + startEvaluationDate + " stopEvaluationDate="
        + stopEvaluationDate);
    }

    Set<Payment>  paymentSet                        = account.getPayments();
    List<Payment> paymentsAgainstOutstandingPromise = new ArrayList<Payment>();

    Date paymentDate                        = null;
    Date paymentPostedDate                  = null;
    int  startEvaluationPaymentDateDaysDiff = 0;
    int  paymentArrivalDueDateDaysDiff      = 0;

    for (Payment payment : paymentSet) {
      paymentPostedDate                  = payment.getPostDate();
      paymentDate                        = DateUtil.toDateOnly(payment.getPaymentDate());
      startEvaluationPaymentDateDaysDiff = 0;
      paymentArrivalDueDateDaysDiff      = 0;

      if (log.isDebugEnabled()) {
        log.debug(
          "PromiseToPay.getPaymentsAgainstOutstandingPromise() :: evaluating payment: "
          + payment);
      }

/*
      if (paymentPostedDate != null) {
        if (!paymentPostedDate.before(startEvaluationDate) && !paymentPostedDate.after(stopEvaluationDate)) {
          if (log.isDebugEnabled()) {
            log.debug(
              "PromiseToPay.getPaymentsAgainstOutstandingPromise() :: adding to paymentsAgainstOutstandingPromise: "
              + payment);
          }

          paymentsAgainstOutstandingPromise.add(payment);
        }
      }
 */
      if (paymentDate != null) {
        startEvaluationPaymentDateDaysDiff = DateUtil.getDayDifference(
            startEvaluationDate, paymentDate);
        paymentArrivalDueDateDaysDiff      = DateUtil.getDayDifference(
            paymentDate, arrivalDueDate);

        if ((startEvaluationPaymentDateDaysDiff != 0)
              && (paymentArrivalDueDateDaysDiff != 0)) {
          // Start Evaluation Date != Payment Date && Payment Date != Arrival Due Date
          if (!paymentDate.before(startEvaluationDate)
                && !paymentDate.after(arrivalDueDate)) {
            if (log.isDebugEnabled()) {
              log.debug(
                "PromiseToPay.getPaymentsAgainstOutstandingPromise() :: adding to paymentsAgainstOutstandingPromise: "
                + payment);
            }

            paymentsAgainstOutstandingPromise.add(payment);
          }
        } else if (startEvaluationPaymentDateDaysDiff != 0) {
          // Start Evaluation Date != Payment Date && Payment Date == Arrival Due Date
          if (!paymentDate.before(startEvaluationDate)) {
            if (log.isDebugEnabled()) {
              log.debug(
                "PromiseToPay.getPaymentsAgainstOutstandingPromise() :: adding to paymentsAgainstOutstandingPromise: "
                + payment);
            }

            paymentsAgainstOutstandingPromise.add(payment);
          }

        } else if (paymentArrivalDueDateDaysDiff != 0) {
          // Start Evaluation Date == Payment Date && Payment Date != Arrival Due Date
          if (!paymentDate.after(arrivalDueDate)) {
            if (log.isDebugEnabled()) {
              log.debug(
                "PromiseToPay.getPaymentsAgainstOutstandingPromise() :: adding to paymentsAgainstOutstandingPromise: "
                + payment);
            }

            paymentsAgainstOutstandingPromise.add(payment);
          }
        } else {
          // Start Evaluation Date == Payment Date == Arrival Due Date

          if (log.isDebugEnabled()) {
            log.debug(
              "PromiseToPay.getPaymentsAgainstOutstandingPromise() :: adding to paymentsAgainstOutstandingPromise: "
              + payment);
          }

          paymentsAgainstOutstandingPromise.add(payment);
        } // end if-else

/*        if (!paymentDate.before(startEvaluationDate) && !paymentDate.after(arrivalDueDate)) {
          if (log.isDebugEnabled()) {
            log.debug(
              "PromiseToPay.getPaymentsAgainstOutstandingPromise() :: adding to paymentsAgainstOutstandingPromise: "
              + payment);
          }

          paymentsAgainstOutstandingPromise.add(payment);
        }*/
      } // end if
    }   // end for

    return paymentsAgainstOutstandingPromise;
  } // end method getPaymentsAgainstOutstandingPromise

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PaymentServiceProvider getPaymentServiceProvider() {
    return paymentServiceProvider;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the arrival date of the previous promise in a set of multiple promises.
   *
   * @return  get the arrival date of the previous promise in a set of multiple promises.
   */
  public Date getPreviousPromiseArrivalDate() {
    PromiseToPay[] promises = account.getPromises(getCreateDate());

    if (promises != null) {
      int          daysDiff    = 0;
      PromiseToPay prevPromise = null;

      for (PromiseToPay promise : promises) {
        if ((!PromiseToPayStatus.DELETED.equals(promise.getPtpStatus()))
              && (!PromiseToPayStatus.INACTIVE.equals(
                  promise.getPtpStatus()))) {
          daysDiff = DateUtil.getDayDifference(getArrivalDate(),
              promise.getArrivalDate());

          if (daysDiff == 0) {
            if (prevPromise != null) {
              return prevPromise.getArrivalDate();
            } else {
              /**
              * Current promise is the first in the series
              */
              return null;
            }
          }

          prevPromise = promise;
        }
      }
    } // end if

    return null;
  } // end method getPreviousPromiseArrivalDate

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The promiseId.
   *
   * @return  the promiseId
   *
   *          <p>generator-class = "native" unsaved-value = "null"</p>
   */
  public Long getPromiseId() {
    return this.promiseId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PromiseToPayChannel getPtpChannel() {
    return ptpChannel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   *          <p>not-null = "true" length = "12" type = "com.cmc.dao.hibernate.support.PromiseToPayStatusUserType"</p>
   */
  public PromiseToPayStatus getPtpStatus() {
    return ptpStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getRealAmount() {
    return realAmount;
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
  public BigDecimal getScheduledAmountSoFar() {
    return getAmountSoFar(PaymentStatus.SCHEDULED);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getSendDate() {
    return sendDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The below condition is to populate startEvaluationDate based on: (1) if a Previous Promise exists on the account
   * then: (a) startEvaluationDate = Previous Promise KEPT Status Date + 1 (b) startEvaluationDate = Previous Promise
   * BROKEN Status Date + 1 = Previous Promise Arrival Due Date + 1 (since Previous Promise BROKEN status date =
   * Previous Promise Arrival Due Date) (2) if no Previous Promise exist on the account then: startEvaluationDate =
   * Create Date of the promise
   *
   * @return  the Start Evaluation Date
   */
  public Date getStartEvaluationDate() {
    Date startEvaluationDate = getCreateDate();

    PromiseToPay prevPromise = getAccount().getPreviousPromise(this);

    if ((prevPromise != null) && isPromiseInMultiplePTP(prevPromise)) {
      if (PromiseToPayStatus.KEPT.equals(prevPromise.getPtpStatus())) {
        Date previousPromiseKeptDate = prevPromise.getKeptStatusDate();

        if (previousPromiseKeptDate != null) {
          startEvaluationDate = DateUtil.addDays(
              previousPromiseKeptDate, 1);
        }
      } else {
        Date previousPromiseArrivalDate = prevPromise.getArrivalDate();

        if (previousPromiseArrivalDate != null) {
          startEvaluationDate = DateUtil.addDays(
              previousPromiseArrivalDate, 1);
        }
      }
    }

    return startEvaluationDate;
  } // end method getStartEvaluationDate

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for updated by batch.
   *
   * @return  Boolean
   */
  public String getUpdatedByBatch() {
    return updatedByBatch;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for updated by batch date.
   *
   * @return  Date
   */
  public Date getUpdatedByBatchDate() {
    return updatedByBatchDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = super.hashCode();

    result = (prime * result)
      + ((this.promiseId == null) ? 0 : this.promiseId.hashCode());
    result = (prime * result)
      + ((this.lastUpdateDate == null) ? 0 : this.lastUpdateDate.hashCode());
    result = (prime * result)
      + ((this.arrivalDate == null) ? 0 : this.arrivalDate.hashCode());
    result = (prime * result)
      + ((this.sendDate == null) ? 0 : this.sendDate.hashCode());
    result = (prime * result)
      + ((this.ptpStatus == null) ? 0 : this.ptpStatus.hashCode());
    result = (prime * result)
      + ((this.acceptAgentId == null) ? 0 : this.acceptAgentId.hashCode());
    result = (prime * result)
      + ((this.paymentAmount == null) ? 0 : this.paymentAmount.hashCode());
    result = (prime * result)
      + ((this.paymentDate == null) ? 0 : this.paymentDate.hashCode());
    result = (prime * result)
      + ((this.paymentMethodConfiguration == null) ? 0 : this.paymentMethodConfiguration.hashCode());
    result = (prime * result)
      + ((this.responsible == null) ? 0 : this.responsible.hashCode());

    result = (prime * result)
      + ((this.ptpChannel == null) ? 0 : this.ptpChannel.hashCode());

    result = (prime * result)
      + ((this.externalAgentId == null) ? 0 : this.externalAgentId.hashCode());

    return result;
  } // end method hashCode

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   prevPromise  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isPromiseInMultiplePTP(PromiseToPay prevPromise) {
    return prevPromise.getCreateDate().compareTo(getCreateDate()) == 0;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Returns true if startEvaluationDate date finalEvaluationDate else returns false;
   *
   * @param   date  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean isUnderEvaluationPeriod(Date date) {
    if (log.isDebugEnabled()) {
      log.debug("date: " + date);
    }

    if (date == null) {
      return null;
    }

    Date startEvaluationDate = getStartEvaluationDate();

    if (log.isDebugEnabled()) {
      log.debug("startEvaluationDate: " + startEvaluationDate);
    }

    Date finalEvaluationDate = getEvaluationDate();

    if (log.isDebugEnabled()) {
      log.debug("finalEvaluationDate: " + finalEvaluationDate);
    }

    date = DateUtil.toDateOnly(date);

    if (PromiseToPayStatus.KEPT.equals(getPtpStatus())) {
      finalEvaluationDate = getKeptStatusDate();
    }

    if ((startEvaluationDate != null) && (finalEvaluationDate != null)) {
      startEvaluationDate = DateUtil.toDateOnly(startEvaluationDate);
      finalEvaluationDate = DateUtil.toDateOnly(finalEvaluationDate);

      log.info("promiseId: " + getPromiseId()
        + " isUnderEvaluationPeriod(" + date
        + ") :: startEvaluationDate: " + startEvaluationDate
        + " finalEvaluationDate: " + finalEvaluationDate);

      /**
       * startEvaluationDate <= date <= finalEvaluationDate
       */
      if ((!startEvaluationDate.after(date))
            && (!finalEvaluationDate.before(date))) {
        log.info("promise id: " + getPromiseId() + " " + date
          + " is applicable to this");

        return Boolean.TRUE;
      }
    }

    return Boolean.FALSE;
  } // end method isUnderEvaluationPeriod

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
   * @param  account  DOCUMENT ME!
   */
  public void setAccount(Account account) {
    this.account = account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for action type.
   *
   * @param  actionType  String
   */
  public void setActionType(String actionType) {
    this.actionType = actionType;
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
   * @param  arrivalDate  DOCUMENT ME!
   */
  public void setArrivalDate(Date arrivalDate) {
    this.arrivalDate = arrivalDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  balance  DOCUMENT ME!
   */
  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  brokenStatusDate  DOCUMENT ME!
   */
  public void setBrokenStatusDate(Date brokenStatusDate) {
    this.brokenStatusDate = brokenStatusDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal  DOCUMENT ME!
   */
  public void setClientDefinedDecimal(BigDecimal clientDefinedDecimal) {
    this.clientDefinedDecimal = clientDefinedDecimal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   */
  public void setDefaultArrivalDate() {
    Date sendDate = getSendDate();

    if ((sendDate != null) && (getAccount() != null)) {
      Portfolio portfolio   = getAccount().getPortfolio();
      Date      arrivalDate = sendDate;

      if ((portfolio != null)
            && (portfolio.getDefaultArrivalDate() != null)) {
        Integer defaultDays = portfolio.getDefaultArrivalDate().intValue();
        arrivalDate = DateUtil.addDays(sendDate, defaultDays);
      }

      setArrivalDate(arrivalDate);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME! 8
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
   * @param  externalAgentId  DOCUMENT ME!
   */
  public void setExternalAgentId(String externalAgentId) {
    this.externalAgentId = externalAgentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

/*  */
  /**
   * DOCUMENT ME!
   *
   * @param  externalReferenceNumber  createDate the createDate to set
   */
  /*
  @Override public void setCreateDate(Date createDate) {
  this.createDate = createDate;
  }*/

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
   * @param  externalStatus  DOCUMENT ME!
   */
  public void setExternalStatus(String externalStatus) {
    this.externalStatus = externalStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  externalStatusCode  DOCUMENT ME!
   */
  public void setExternalStatusCode(String externalStatusCode) {
    this.externalStatusCode = externalStatusCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  externalStatusDescription  DOCUMENT ME!
   */
  public void setExternalStatusDescription(String externalStatusDescription) {
    this.externalStatusDescription = externalStatusDescription;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  externalStatusEffectiveDate  DOCUMENT ME!
   */
  public void setExternalStatusEffectiveDate(
    Date externalStatusEffectiveDate) {
    this.externalStatusEffectiveDate = externalStatusEffectiveDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  frequency  DOCUMENT ME!
   */
  public void setFrequency(String frequency) {
    this.frequency = frequency;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  inactiveStatusDate  DOCUMENT ME!
   */
  public void setInactiveStatusDate(Date inactiveStatusDate) {
    this.inactiveStatusDate = inactiveStatusDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  keptStatusDate  DOCUMENT ME!
   */
  public void setKeptStatusDate(Date keptStatusDate) {
    this.keptStatusDate = keptStatusDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  messageStaging  DOCUMENT ME!
   */
  public void setMessageStaging(MessageStaging messageStaging) {
    this.messageStaging = messageStaging;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  numberOfPayments  DOCUMENT ME!
   */
  public void setNumberOfPayments(Integer numberOfPayments) {
    this.numberOfPayments = numberOfPayments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  outstandingStatusDate  DOCUMENT ME!
   */
  public void setOutstandingStatusDate(Date outstandingStatusDate) {
    this.outstandingStatusDate = outstandingStatusDate;
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
   * @param  paymentAmount  DOCUMENT ME!
   */
  public void setPaymentAmount(BigDecimal paymentAmount) {
    this.paymentAmount = paymentAmount;
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
   * @param  paymentMethodConfiguration  DOCUMENT ME!
   */
  public void setPaymentMethodConfiguration(
    PtpPaymentMethodConfiguration paymentMethodConfiguration) {
    this.paymentMethodConfiguration = paymentMethodConfiguration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentProgramInstallment  DOCUMENT ME!
   */
  public void setPaymentProgramInstallment(
    PaymentProgramInstallment paymentProgramInstallment) {
    this.paymentProgramInstallment = paymentProgramInstallment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentServiceProvider  DOCUMENT ME!
   */
  public void setPaymentServiceProvider(
    PaymentServiceProvider paymentServiceProvider) {
    this.paymentServiceProvider = paymentServiceProvider;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  promiseId  the promiseId to set
   */
  public void setPromiseId(Long promiseId) {
    this.promiseId = promiseId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  ptpChannel  DOCUMENT ME!
   */
  public void setPtpChannel(PromiseToPayChannel ptpChannel) {
    this.ptpChannel = ptpChannel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  ptpStatus  DOCUMENT ME!
   */
  public void setPtpStatus(PromiseToPayStatus ptpStatus) {
    this.ptpStatus = ptpStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  realAmount  DOCUMENT ME!
   */
  public void setRealAmount(BigDecimal realAmount) {
    this.realAmount = realAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  callerResponsible  DOCUMENT ME! the responsible to set
   */
  public void setResponsible(Responsible callerResponsible) {
    this.responsible = callerResponsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  sendDate  DOCUMENT ME!
   */
  public void setSendDate(Date sendDate) {
    this.sendDate = sendDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for updated by batch.
   *
   * @param  updatedByBatch  Boolean
   */
  public void setUpdatedByBatch(String updatedByBatch) {
    this.updatedByBatch = updatedByBatch;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for updated by batch date.
   *
   * @param  updatedByBatchDate  Date
   */
  public void setUpdatedByBatchDate(Date updatedByBatchDate) {
    this.updatedByBatchDate = updatedByBatchDate;
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

    retValue.append("PromiseToPay ( ").append("createDate = ").append(
      this.createDate).append(TAB).append("updateDate = ").append(
      this.lastUpdateDate).append(TAB).append("acceptAgentId = ").append(
      this.acceptAgentId).append(TAB).append("responsible = ").append(
      this.responsible).append(TAB).append("paymentAmount = ").append(
      this.paymentAmount).append(TAB).append("paymentDate = ").append(
      this.paymentDate).append(TAB).append("paymentMethod = ").append(
      this.paymentMethodConfiguration).append(TAB).append("promiseId = ").append(this.promiseId).append(TAB).append(
      "payment = ").append(
      this.payment).append("paymentProgramInstallment = ").append(
      this.paymentProgramInstallment).append(" )");

    return retValue.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private BigDecimal getAmountSoFar(PaymentStatus status) {
    BigDecimal amount      = new BigDecimal("0");
    Date       createDate  = DateUtil.toDateOnly(getCreateDate());
    Date       promiseDate = DateUtil.toDateOnly(DateUtil.addDays(paymentDate,
          1));

    if (account.getPayments() != null) {
      for (Payment payment : account.getPayments()) {
        Date paymentDate = DateUtil.toDateOnly(
            payment.getPaymentDate());

        if (DateUtil.isInDateTimeRange(paymentDate, createDate,
                promiseDate)) {
          if (status.equals(payment.getPaymentStatus())) {
            amount.add(payment.getAmount());
          }
        }
      }
    }

    return amount;
  }
} // end class PromiseToPay
