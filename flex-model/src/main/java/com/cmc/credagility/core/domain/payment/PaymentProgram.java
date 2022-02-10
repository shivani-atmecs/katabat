package com.cmc.credagility.core.domain.payment;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
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
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.document.Document;
import com.cmc.credagility.core.domain.program.ProgramTemplate;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.domain.type.InstallmentStatus;
import com.cmc.credagility.core.domain.type.PaymentProgramMonitoringType;
import com.cmc.credagility.core.domain.type.PaymentProgramTypeCode;
import com.cmc.credagility.core.domain.type.PaymentStatus;
import com.cmc.credagility.core.domain.type.ProgramSource;
import com.cmc.credagility.core.domain.type.ProgramStatus;
import com.cmc.credagility.core.domain.type.PromiseToPayStatus;
import com.cmc.credagility.core.domain.util.CompareUtil;
import com.cmc.credagility.core.domain.util.DateUtil;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;

import com.ozstrategy.credagility.core.domain.ProgramAction;
import com.ozstrategy.credagility.core.domain.SurveyFlowStep;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowNodeActionTriggerType;


/**
 * This class is used to map Payment Program information.
 *
 * <p><a href="PaymentProgram.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 * @version  $Revision$, $Date$
 *
 *           <p>table = "PaymentProgram"</p>
 */
@Entity
@SuppressWarnings("unchecked")
@Table(
  name    = "PaymentProgram",
  indexes = {
    @Index(
      name = "ruleIndex",
      columnList = "ruleId"
    )
  }
)
public class PaymentProgram extends BaseEntity implements Serializable, Comparable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  // ~ Static fields/initializers
  // ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -6115332306808589552L;

  /** TODO: DOCUMENT ME! */
  public static final String Offer_Process_Status_None = "None";

  /** TODO: DOCUMENT ME! */
  public static final String Offer_Process_Status_Eligible = "Eligible";

  /** TODO: DOCUMENT ME! */
  public static final String Offer_Process_Status_Accepted = "Accepted";

  /** TODO: DOCUMENT ME! */
  public static final String Offer_Process_Status_Expired = "Expired";

  /** TODO: DOCUMENT ME! */
  public static final String Offer_Process_Status_Cancelled = "Cancelled";

  /** TODO: DOCUMENT ME! */
  public static final String Offer_Process_Status_Ended = "Ended";

  /** TODO: DOCUMENT ME! */
  public static final String Document_Process_Status_Outstanding = "Outstanding";

  /** TODO: DOCUMENT ME! */
  public static final String Document_Process_Status_Pending = "Pending";

  /** TODO: DOCUMENT ME! */
  public static final String Document_Process_Status_Approved = "Approved";

  /** TODO: DOCUMENT ME! */
  public static final String Offer_Process_Status_Determined = "Determined";

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /**
   * The agent Id if this program is accepted by an CMC or agency user on the fly. Could be null. This is normallyused
   * as aperformance tracking tool.
   */
  @Column(name = "acceptAgentId")
  protected Long acceptAgentId;

  /** The timestamp when the payment program is accepted. */
  @Column(name = "acceptDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date acceptDate;

  /** TODO Move these two properties rewardPoint and rewardCode to Responsible table. */
  /** Reward Point for this payment program. Responsible table should have a rewardPoint column too */
  // protected Integer rewardPoint;
  // /** Reward Code for this payment program - what types of reward are
  // eligible */
  // protected String rewardCode;
  /** The payment. */
  @JoinColumn(
    name      = "accountNum",
    nullable  = false,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Account account;

  /**
   * Action Data are reserved fields for the results of different program types. For example, ReduceAPR program may have
   * a "5%" saved as actionData1 which means the APR will be reduced to 5% after payment program has been fulfilled.
   * These fields are only meaningful when you consider it with different payment program types. The description of
   * these fields should be found in the resource bundle for internationalization purpose.
   */
  @Column(
    name   = "actionData1",
    length = 128
  )
  protected String actionData1 = "1";

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "actionData2",
    length = 128
  )
  protected String actionData2;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "actionData3",
    length = 128
  )
  protected String actionData3;


  /**
   * Whether this payment program is current active. Every day a payment program will be created by strategy engine. If
   * a program is not generated then we will put it as inactive.
   */
  @Column(
    name             = "active",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean active;

  /** <code>true</code> is allow eager payment. */
  @Column(
    name             = "allowEagerPayment",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowEagerPayment;

  /** installment allowed due days. */
  @Column(name = "allowedInstallmentDateRange")
  protected Integer allowedInstallmentDateRange = 7;

  /** <code>true</code> is approved. */
  @Column(
    name             = "approved",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean approved = false;

  /** Annual Percentage rate - very likely this will never be used. */
  @Column(name = "apr")
  protected BigDecimal apr;

  /** TODO: DOCUMENT ME! */
  @Column(name = "balanceWhenAccepted")
  protected BigDecimal balanceWhenAccepted;

  /** The date of cancelled status. */
  @Column(
    name     = "cancelledStatusDate",
    nullable = true
  )
  @Temporal(TemporalType.TIMESTAMP)
  protected Date cancelledStatusDate;

  /** Th agent Id if this program is created by an CMC or agency user on the fly. Could be null. */
  @Column(name = "creatorAgentId")
  protected Long creatorAgentId;

  /** How many times this payment program has been declined. */
  @Column(name = "declineCount")
  protected Integer declineCount;

  /** How many times the detail of this payment program has been viewed. */
  @Column(name = "detailViewCount")
  protected Integer detailViewCount;

  /** Payment duration. */
  @Column(name = "duration")
  protected Integer duration;

  /** The expiration date of this program. This field has to be set by the person who create this program. */
  @Column(name = "expirationDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date expirationDate;

  /**
   * The grace period of expirationDate. Program will not really expire until expirationDate + expirationDateTolerence.
   */
  @Column(name = "expirationDateTolerence")
  protected Integer expirationDateTolerence = 0;

  // ~ Instance fields
  // --------------------------------------------------------------------------------------------------
  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "externalReferenceNumber",
    nullable = true,
    length   = 20
  )
  protected String externalReferenceNumber;

  /** TODO: DOCUMENT ME! */
  @Column(name = "fee1WhenAccepted")
  protected BigDecimal fee1WhenAccepted;

  /** TODO: DOCUMENT ME! */
  @Column(name = "fee2WhenAccepted")
  protected BigDecimal fee2WhenAccepted;

  /** TODO: DOCUMENT ME! */
  @Column(name = "fee3WhenAccepted")
  protected BigDecimal fee3WhenAccepted;

  /** TODO: DOCUMENT ME! */
  @Column(name = "fee4WhenAccepted")
  protected BigDecimal fee4WhenAccepted;

  /** The amount of fixed fee. */
  @Column(name = "fixedFeeAmount")
  protected BigDecimal fixedFeeAmount;

  /**
   * The following two are redundancy fields for payment program. It shows whether this payment program requires a fixed
   * payment prior to accepting this payment program, and how much is this fixed fee - per Dawn, this fixed payment
   * amount is in addition to the payment program total amount.
   */
  @Column(
    name             = "fixedFeeOn",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean fixedFeeOn = false;

  /** Frequency. */
  @Column protected Integer frequency;

  /**
   * The grace period of installmentDate. If payment for installment has not been received by scheduledDate +
   * installmentDateTolerence, the program will be cancelled due to installment fail.
   */
  @Column(name = "installmentDateTolerence")
  protected Integer installmentDateTolerence = 0;

  /**
   * If the debtor has not enrolled in any payment program and he receives a letter offering him this program and he
   * make a payment before expirationDate. If the payment amount is greater than firstInstallment - dollarTolerence,
   * then this user is considered enrolled into this payment program. If the debtor has enrolled in one payment program
   * and installment amount1 is due on date1. All the amount he sends to CMC before date1 will be credited towards the
   * next installment (if he sends more than installment amount, credit to next installment). On date1, if amount1 has
   * not been satisfied, he should have until date1 + installmentDateTolerence to pay no less than amount1 -
   * installmentDollarTolerence. Otherwise the program will be cancelled.
   */
  @Column(name = "installmentDollarTolerence")
  protected BigDecimal installmentDollarTolerence = new BigDecimal(1.00);

  /** Individual installments for this program. Sorted by DB order-by. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "paymentProgram",
    cascade  = { CascadeType.ALL, CascadeType.REMOVE }
  )
  @OrderBy(value = "installmentOrder asc")
  protected Set<PaymentProgramInstallment> installments = new LinkedHashSet<PaymentProgramInstallment>();

  /** TODO: DOCUMENT ME! */
  @Column(name = "interestWhenAccepted")
  protected BigDecimal interestWhenAccepted;

  /** How many times this payment program has been offered in letter. */
  @Column(name = "letterCount")
  protected Integer letterCount;

  /** The Date of maturity. */
  @Transient protected Date maturityDate;

  /** TODO: DOCUMENT ME! */
  @Column(length = 50)
  @Enumerated(EnumType.STRING)
  protected PaymentProgramMonitoringType monitoringType;

  /** Percentage of principal. */

  @Column(
    name      = "percentage",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal percentage;

  /**
   * The principal type used to calculate the payment amount. Could be totalDue, pastDue, currentDue, overLimit,
   * balance, etc.
   */
  @Column(
    name   = "principalType",
    length = 64
  )
  protected String principalType;

  /** The principal when this payment program is accepted (normally on a daily basis). */
  @Column(name = "principalWhenAccepted")
  protected BigDecimal principalWhenAccepted;

  /** Moneytary value of the principal when this payment program is generated (normally on a daily basis). */
  @Column(name = "principalWhenCreated")
  protected BigDecimal principalWhenCreated;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "actionId",
    nullable  = true,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected ProgramAction programAction;

  /** payment program amount - sum of individual monthly payments excluding fixed fee payment. */
  @Column(name = "programAmount")
  protected BigDecimal programAmount;

  /** The hascode of program. */
  @Column(name = "programHashCode")
  protected Integer programHashCode;

  /** Payment program PK. */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long programId;

  /** Order of the payment program. Starting from 1. */
  @Column(
    name     = "programOrder",
    length   = 11,
    nullable = false
  )
  protected Integer programOrder;

  /**
   * The status of this program. It could be: INIT("Init"), ACCEPTED("Accepted"), BROKENPROMISE("BrokenPromise"), or
   * FULFILLED("Fulfilled").
   */
  @Column(
    name   = "programStatus",
    length = 25
  )
  @Enumerated(EnumType.STRING)
  protected ProgramStatus programStatus;

  /** Program temp status. */
  @Transient protected String programTempStatus;


  /** Individual installments for this program. Sorted by DB order-by. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "paymentProgram",
    cascade  = { CascadeType.ALL, CascadeType.REMOVE }
  )
  @OrderBy(value = "id asc")
  protected Set<Document> requiredDocuments = new LinkedHashSet<Document>();

  /** Required Payment. */
  @Column(name = "requiredPayments")
  protected Integer requiredPayments;

  /** Required promise to pay. */
  @Column(name = "requiredPTPs")
  protected Integer requiredPTPs;

  /**
   * The responsible party that accepted this program. This is only meaningful when the program status is ACCEPTED.
   * Otherwise it should be null.
   */
  @JoinColumn(name = "responsibleId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected Responsible responsible;

  /** The ID of rule batch. */
  @Column(name = "ruleBatchId")
  protected Long ruleBatchId;


  /**
   * TODO: Maybe it should be changed to Rule object? - no need because this app should run without rule engine ? The
   * rule that generates this payment program. Could be null. This rule Id can also be used as a brand variable because
   * it provide finer level of control based on individual payment programs
   */
  @Column(name = "ruleId")
  protected Long ruleId;


  /**
   * Whether this program is generated by strategy or an agent from agent workstation. Please note that CMC officers has
   * access to the workstation so being generated by the workstation does not mean it is generated by agency - could be
   * CMC officers.
   */
  @Column(
    name   = "source",
    length = 20
  )
  @Enumerated(EnumType.STRING)
  protected ProgramSource source;

  /** TODO: DOCUMENT ME! */
  @Column(name = "statusChangeDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date statusChangeDate;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "surveyFlowMode",
    length   = 32,
    nullable = true
  )
  @Enumerated(value = EnumType.STRING)
  protected WorkflowNodeActionTriggerType surveyFlowMode;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "surveyFlowStepId",
    nullable = true
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = { CascadeType.ALL }
  )
  protected SurveyFlowStep surveyFlowStep;

  /** Total payment amount - sum of payment amount with fixed fee payment. */
  @Column(name = "totalAmount")
  protected BigDecimal totalAmount;

  /** Payment Program Type. */
  @JoinColumn(
    name     = "programTypeId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected PaymentProgramType type;

  /** How many times the summary of this payment program has been viewed. */
  @Column(name = "viewCount")
  protected Integer viewCount;

  /** account id. */
  @JoinColumn(
    name      = "programTemplateId",
    nullable  = true,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private ProgramTemplate programTemplate;

  @Transient private Set<PaymentProgramInstallment> requiredInstallments =
    new LinkedHashSet<PaymentProgramInstallment>();

  @Column(
    name     = "weekday",
    nullable = true
  )
  private Integer weekday;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * Add fixed fee installment to the top of the installments set.
   *
   * @param  installment  the fixed fee installment to add
   */
  public void addFixedFeeInstallment(PaymentProgramInstallment installment) {
    // In case the flag was not set
    installment.setFixedFee(true);
    this.setFixedFeeAmount(installment.getPaymentAmount());
    this.setFixedFeeOn(true);
    this.installments.add(installment);
    installment.setPaymentProgram(this);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  installment  the installment to add
   */
  public void addInstallment(PaymentProgramInstallment installment) {
    this.installments.add(installment);
    installment.setPaymentProgram(this);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   */
  public void addOneDeclineCount() {
    if (this.declineCount == null) {
      this.declineCount = 0;
    }

    this.declineCount = this.declineCount + 1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   */
  public void addOneDetailViewCount() {
    if (this.detailViewCount == null) {
      this.detailViewCount = 0;
    }

    this.detailViewCount = this.detailViewCount + 1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   */
  public void addOneLetterCount() {
    if (this.letterCount == null) {
      this.letterCount = 0;
    }

    this.letterCount = this.letterCount + 1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   */
  public void addOneViewCount() {
    if (this.viewCount == null) {
      this.viewCount = 0;
    }

    this.viewCount = this.viewCount + 1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Adjust the payment program to the new amount. 1. SCHEDULED amount will be adjusted. The sum of all Scheduled
   * amounts should be equal to the newAmount minus sum of all inprocess Amounts.
   *
   * @param  newAmount  DOCUMENT ME!
   */
  public void adjustProgramToNewAmount(BigDecimal newAmount) {
    if (newAmount == null) {
      return;
    }

    PaymentProgramInstallment lastInstallment = getLastInstallment();

    // First, process INPROCESS payments
    for (PaymentProgramInstallment installment : installments) {
      Payment payment = installment.getPayment();

      if (payment != null) {
        if (PaymentStatus.INPROCESS.equals(
                payment.getPaymentStatus())) {
          newAmount = newAmount.subtract(payment.getAmount());
        }
      }
    }

    // Second, process SCHEDULED payments
    totalAmount = BigDecimal.ZERO;
    duration    = 0;

    LinkedHashSet<PaymentProgramInstallment> newInstallments = new LinkedHashSet<PaymentProgramInstallment>();
    boolean                                  needRemove      = false;
    Iterator<PaymentProgramInstallment>      it              = installments.iterator();

    while (it.hasNext()) {
      PaymentProgramInstallment installment = it.next();
      Payment                   payment     = installment.getPayment();

      if (payment != null) {
        // adjust the payment and installment
        if (PaymentStatus.SCHEDULED.equals(
                payment.getPaymentStatus())) {
          if (BigDecimal.ZERO.compareTo(newAmount) >= 0) {
            payment.setPaymentStatus(PaymentStatus.REMOVED);
            payment.setPaymentProgramInstallment(null);
            installment.setPayment(null);

            // it.remove();
            needRemove = true;

            continue;
          } else {
            if (newAmount.compareTo(payment.getAmount()) < 0) {
              installment.setPaymentAmount(newAmount);
              payment.setAmount(newAmount);
            } else if (isLastInstallment(lastInstallment,
                    installment)) {
              installment.setPaymentAmount(newAmount);
              payment.setAmount(newAmount);
            }

            newAmount = newAmount.subtract(payment.getAmount());
          }
        } // end if
      } else {
        // Only adjust the installment
        if (BigDecimal.ZERO.compareTo(newAmount) >= 0) {
          // it.remove();
          needRemove = true;

          continue;
        } else {
          if (newAmount.compareTo(installment.getPaymentAmount())
                < 0) {
            installment.setPaymentAmount(newAmount);
          } else if (isLastInstallment(lastInstallment,
                  installment)) {
            installment.setPaymentAmount(newAmount);
          }

          newAmount = newAmount.subtract(
              installment.getPaymentAmount());
        }
      } // end if-else

      newInstallments.add(installment);
      totalAmount = totalAmount.add(installment.getPaymentAmount());
      duration++;
    } // end while

    // Set the new installments collection
    if (needRemove) {
      installments.clear();
      installments.addAll(newInstallments);
    }
  } // end method adjustProgramToNewAmount

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

    if (obj == null) {
      return false;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    final PaymentProgram other = (PaymentProgram) obj;


    if (apr == null) {
      if (other.getApr() != null) {
        return false;
      }
    } else if ((other.getApr() != null)
          && (apr.compareTo(other.getApr()) != 0)) {
      return false;
    }

    if (duration == null) {
      if (other.getDuration() != null) {
        return false;
      }
    } else if (!duration.equals(other.getDuration())) {
      return false;
    }

    if (frequency == null) {
      if (other.getFrequency() != null) {
        return false;
      }
    } else if (!frequency.equals(other.getFrequency())) {
      return false;
    }

    if (programAmount == null) {
      if (other.getProgramAmount() != null) {
        return false;
      }
    } else if ((other.getProgramAmount() != null)
          && (programAmount.compareTo(other.getProgramAmount()) != 0)) {
      return false;
    }

    if (fixedFeeAmount == null) {
      if (other.getFixedFeeAmount() != null) {
        return false;
      }
    } else if ((other.getFixedFeeAmount() != null)
          && (fixedFeeAmount.compareTo(other.getFixedFeeAmount()) != 0)) {
      return false;
    }

    if (type == null) {
      if (other.getType() != null) {
        return false;
      }
    } else if (!type.equals(
            other.getType())) {
      return false;
    }

    if (ruleId == null) {
      if (other.getRuleId() != null) {
        return false;
      }
    } else if (!ruleId.equals(other.getRuleId())) {
      return false;
    }

    if (programAction == null) {
      if (other.getProgramAction() != null) {
        return false;
      }
    } else if (other.getProgramAction() != null) {
      if (!programAction.getId().equals(other.getProgramAction().getId())) {
        return false;
      }
    }

    if (programOrder == null) {
      if (other.getProgramOrder() != null) {
        return false;
      }
    } else if (!programOrder.equals(other.getProgramOrder())) {
      return false;
    }

    if (requiredPayments == null) {
      if (other.getRequiredPayments() != null) {
        return false;
      }
    } else if (!requiredPayments.equals(other.getRequiredPayments())) {
      return false;
    }

    if (percentage == null) {
      if (other.getPercentage() != null) {
        return false;
      }
    } else if (percentage.compareTo(other.getPercentage()) != 0) {
      return false;
    }

    if (requiredPTPs == null) {
      if (other.getRequiredPTPs() != null) {
        return false;
      }
    } else if (!requiredPTPs.equals(other.getRequiredPTPs())) {
      return false;
    }

    if (allowEagerPayment == null) {
      if (other.getAllowEagerPayment().equals(Boolean.FALSE)) {
        return false;
      }
    } else if (!allowEagerPayment.equals(other.getAllowEagerPayment())) {
      return false;
    }

    if (programStatus == null) {
      if (other.getProgramStatus() != null) {
        return false;
      }
    } else if (!programStatus.equals(other.getProgramStatus())) {
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
  public int businessHashCode() {
    final int prime  = 31;
    int       result = 1;
    result = (prime * result) + ((apr == null) ? 0 : apr.hashCode());
    result = (prime * result) + ((duration == null) ? 0 : duration.hashCode());
    result = (prime * result) + ((frequency == null) ? 0 : frequency.hashCode());
    result = (prime * result) + ((programAmount == null) ? 0 : programAmount.hashCode());
    result = (prime * result) + ((fixedFeeAmount == null) ? 0 : fixedFeeAmount.hashCode());
    result = (prime * result) + ((type == null) ? 0 : type.hashCode());
    result = (prime * result) + ((ruleId == null) ? 0 : ruleId.hashCode());
    result = (prime * result) + ((programAction == null) ? 0 : programAction.hashCode());
    result = (prime * result) + ((programOrder == null) ? 0 : programOrder.hashCode());
    result = (prime * result) + ((requiredPayments == null) ? 0 : requiredPayments.hashCode());
    result = (prime * result) + ((percentage == null) ? 0 : percentage.hashCode());
    result = (prime * result) + ((requiredPTPs == null) ? 0 : requiredPTPs.hashCode());
    result = (prime * result) + ((allowEagerPayment == null) ? 0 : allowEagerPayment.hashCode());
    result = (prime * result) + ((programStatus == null) ? 0 : programStatus.toString().hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Comparator so we can sort payment program.
   *
   * @param   p  DOCUMENT ME!
   *
   * @return  comparator so we can sort payment program
   */
  @Override public int compareTo(Object p) {
    return this.programOrder.compareTo(((PaymentProgram) p).getProgramOrder());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    if (!super.equals(obj)) {
      return false;
    }

    return businessEquals(obj);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * flexBusinessHashCode.
   *
   * @return  int
   */
  public int flexBusinessHashCode() {
    final int prime  = 31;
    int       result = 1;
    result = (prime * result) + ((frequency == null) ? 0 : frequency.hashCode());
    result = (prime * result) + ((programAmount == null) ? 0 : programAmount.hashCode());
    result = (prime * result) + ((fixedFeeAmount == null) ? 0 : fixedFeeAmount.hashCode());
    result = (prime * result) + ((type == null) ? 0 : type.hashCode());
    result = (prime * result) + ((ruleId == null) ? 0 : ruleId.hashCode());
    result = (prime * result) + ((programAction == null) ? 0 : programAction.hashCode());
    result = (prime * result) + ((programOrder == null) ? 0 : programOrder.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Id of the agent who accepted this program on behalf of customer, if any.
   *
   * @return  Id of the agent who accepted this program on behalf of customer, if any.
   *
   *          <p>not-null = "false"</p>
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
  public Date getAcceptDate() {
    return acceptDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The account.
   *
   * @return  the account
   *
   *          <p>lazy = "proxy" column = "accountNum" "true" class = "com.cmc.credagility.Account" "true" update =
   *          "false"</p>
   */
  public Account getAccount() {
    return account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Action data 1 for payment program. The business meaning depends on the program type.
   *
   * @return  action data 1 for payment program. The business meaning depends on the program type.
   *
   *          <p>length = "128"</p>
   */
  public String getActionData1() {
    return actionData1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Action data 2 for payment program. The business meaning depends on the program type.
   *
   * @return  action data 2 for payment program. The business meaning depends on the program type.
   *
   *          <p>length = "128"</p>
   */
  public String getActionData2() {
    return actionData2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Action data 3 for payment program. The business meaning depends on the program type.
   *
   * @return  action data 3 for payment program. The business meaning depends on the program type.
   *
   *          <p>length = "128"</p>
   */
  public String getActionData3() {
    return actionData3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The active.
   *
   * @return  the active
   *
   *          <p>not-null = "true" type = "yes_no"</p>
   */
  public Boolean getActive() {
    return active;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The fixed fee payment date if a payment has been processed/scheduled. Otherwise returns null.
   *
   * @return  the fixed fee payment date if a payment has been processed/scheduled. Otherwise returns null.
   */
  public Date getActualFixedFeePaymentDate() {
    PaymentProgramInstallment fixed = this.getFixedPayment();

    if (fixed != null) {
      return fixed.getActualPaymentDate();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAllowEagerPayment() {
    if (allowEagerPayment == null) {
      return Boolean.TRUE;
    }

    return allowEagerPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The allowedInstallmentDateRange.
   *
   * @return  the allowedInstallmentDateRange
   *
   *          <p>not-null = "true"</p>
   */
  public Integer getAllowedInstallmentDateRange() {
    return this.allowedInstallmentDateRange;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getApproved() {
    return approved;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The apr.
   *
   * @return  the apr
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getApr() {
    return apr;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for balance when accepted.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBalanceWhenAccepted() {
    return balanceWhenAccepted;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Due to historical reason, we may not have accept date in Payment Program. In that case, we need to make best
   * efforts.
   *
   * @return  due to historical reason, we may not have accept date in Payment Program.
   */
  public Date getBestAcceptDate() {
    Date d = null;

    if (acceptDate != null) {
      d = acceptDate;
    } else if (account.getAcceptProgramDate() != null) {
      d = account.getAcceptProgramDate();
    } else {
      Iterator<PaymentProgramInstallment> it          = installments.iterator();
      PaymentProgramInstallment           installment = null;

      if (it.hasNext()) {
        installment = it.next();
      }

      if ((installment != null) && (installment.getPayment() != null)) {
        // Use createDate of the first payment as program date
        d = installment.getPayment().getCreateDate();
      }
    }

    if (d != null) {
      return DateUtil.toDateOnly(d);
    }

    return null;
  } // end method getBestAcceptDate

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getBusinessNextCustomerDueDate() {
    PaymentProgramInstallment installment = getNextInstallment();

    if (installment != null) {
      return installment.getBusinessCustomerDueDate();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getBusinessNextInstallmentDueDate() {
    PaymentProgramInstallment installment = getNextInstallment();

    if (installment != null) {
      return installment.getBusinessInstallmentDueDate();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for business next installment due date for RAM.
   *
   * @return  Date
   */
  public Date getBusinessNextInstallmentDueDateForRAM() {
    PaymentProgramInstallment installment = getNextInstallmentForRAM();

    if (installment != null) {
      return installment.getBusinessInstallmentDueDate();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getBusinessPreviousCustomerDueDate() {
    PaymentProgramInstallment installment = getPreviousInstallment();

    if (installment != null) {
      return installment.getBusinessCustomerDueDate();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getBusinessPreviousInstallmentDueDate() {
    PaymentProgramInstallment installment = getPreviousInstallment();

    if (installment != null) {
      return installment.getBusinessInstallmentDueDate();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the final installment due date, which is the program end date.
   *
   * @return  get the final installment due date, which is the program end date.
   */
  public Date getCalculatedFinalInstallmentDueDate() {
    Iterator<PaymentProgramInstallment> it = installments.iterator();
    Date                                d  = null;

    while (it.hasNext()) {
      d = it.next().getInstallmentDueDate();
    }

    return d;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getCancelledStatusDate() {
    return cancelledStatusDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Id of the agent who created this program, if any.
   *
   * @return  Id of the agent who created this program, if any.
   *
   *          <p>not-null = "false"</p>
   */
  public Long getCreatorAgentId() {
    return creatorAgentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * How many times this payment program has been declined explicitly (by user clicking "Decline").
   *
   * @return  how many times this payment program has been declined explicitly (by user clicking "Decline")
   *
   *          <p>not-null = "false"</p>
   */
  public Integer getDeclineCount() {
    return declineCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The detailViewCount.
   *
   * @return  the detailViewCount
   *
   *          <p>not-null = "false"</p>
   */
  public Integer getDetailViewCount() {
    return this.detailViewCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getDisplayInstallmentAmount() {
    Iterator it = installments.iterator();

    if ((it != null) && it.hasNext()) {
      PaymentProgramInstallment installment = (PaymentProgramInstallment) it.next();

      if (installment != null) {
        return installment.getPaymentAmount();
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get DoNotContactUntil date caused by this paymentprogram. It equals calculatedFinalInstallmentDueDate, on which we
   * should have received the payment.
   *
   * <p>For premature calls (when calculatedFinalInstallmentDueDate is null), this method returns current datetime to
   * make sure it won't affetc DoNotContact decision.</p>
   *
   * @return  get DoNotContactUntil date caused by this paymentprogram.
   */
  public Date getDoNotContactUntil() {
    Date d = getCalculatedFinalInstallmentDueDate();

    return (d == null) ? new Date() : d;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Only makes sense for accepted payment program.
   *
   * <p>Get how much is due for this payment program, considering money tolerance.</p>
   *
   * @return  only makes sense for accepted payment program.
   */
  public BigDecimal getDueAmountWithTolerance() {
    BigDecimal dueAmount = new BigDecimal("0.0");
    Date       dueDate   = null;
    Date       now       = DateUtil.toDateOnly(new Date());

    for (PaymentProgramInstallment installment : installments) {
      // Must have installment Due Date
      if (installment.getInstallmentDueDate() != null) {
        Date installmentDueDate = DateUtil.toDateOnly(
            installment.getInstallmentDueDate());

        if (this.installmentDateTolerence != null) {
          installmentDueDate = DateUtil.addDays(installmentDueDate,
              this.installmentDateTolerence);
        }

        if (installmentDueDate.getTime() <= now.getTime()) {
          BigDecimal installmentAmount = installment.getPaymentAmount();

          if (this.installmentDollarTolerence != null) {
            installmentAmount = installmentAmount.subtract(
                this.installmentDollarTolerence);
          }

          if (installmentAmount.compareTo(new BigDecimal("0")) > 0) {
            dueAmount.add(installmentAmount);
          }

          if ((dueDate == null)
                || (dueDate.getTime()
                  < installmentDueDate.getTime())) {
            dueDate = installmentDueDate;
          }
        }
      } // end if
    }   // end for

    return dueAmount;

  } // end method getDueAmountWithTolerance

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The duration.
   *
   * @return  the duration
   *
   *          <p>not-null = "true"</p>
   */
  public Integer getDuration() {
    return duration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The expirationDate.
   *
   * @return  the expirationDate
   *
   *          <p>not-null = "true"</p>
   */
  public Date getExpirationDate() {
    return this.expirationDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The expirationDateTolerence.
   *
   * @return  the expirationDateTolerence
   *
   *          <p>not-null = "true"</p>
   */
  public Integer getExpirationDateTolerence() {
    return this.expirationDateTolerence;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for external reference number.
   *
   * @return  String
   */
  public String getExternalReferenceNumber() {
    return externalReferenceNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for fee1 when accepted.
   *
   * @return  BigDecimal
   */
  public BigDecimal getFee1WhenAccepted() {
    return fee1WhenAccepted;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for fee2 when accepted.
   *
   * @return  BigDecimal
   */
  public BigDecimal getFee2WhenAccepted() {
    return fee2WhenAccepted;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for fee3 when accepted.
   *
   * @return  BigDecimal
   */
  public BigDecimal getFee3WhenAccepted() {
    return fee3WhenAccepted;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for fee4 when accepted.
   *
   * @return  BigDecimal
   */
  public BigDecimal getFee4WhenAccepted() {
    return fee4WhenAccepted;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PaymentProgramInstallment getFinalInstallment() {
    long                      order = 0;
    PaymentProgramInstallment ret   = null;

    for (PaymentProgramInstallment installment : this.installments) {
      if ((installment != null) && (installment.getOrder() != null)
            && (installment.getOrder() > order)) {
        ret   = installment;
        order = installment.getOrder();
      }
    }

    return ret;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * This method is returns the First Installment for the Program.
   *
   * @return  this method is returns the First Installment for the Program.
   *
   * @author  kpalanivelu
   */
  public PaymentProgramInstallment getFirstInstallment() {
    PaymentProgramInstallment ret = null;

    for (PaymentProgramInstallment installment : installments) {
      ret = installment;

      break;
    }

    return ret;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Fixed fee amount of the payment program. Could be null.
   *
   * @return  fixed fee amount of the payment program. Could be null.
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getFixedFeeAmount() {
    return fixedFeeAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The fixedFeeOn.
   *
   * @return  the fixedFeeOn
   *
   *          <p>not-null = "true" type = "yes_no"</p>
   */
  public Boolean getFixedFeeOn() {
    return fixedFeeOn;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The fixed payment installment. If none, return null.
   *
   * @return  the fixed payment installment. If none, return null.
   */
  public PaymentProgramInstallment getFixedPayment() {
    if ((this.installments != null) && !this.installments.isEmpty()) {
      Iterator<PaymentProgramInstallment> it = this.installments.iterator();

      while (it.hasNext()) {
        PaymentProgramInstallment installment = it.next();

        if (installment.getFixedFee()) {
          return installment;
        }
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The duration.
   *
   * @return  the duration
   */
  public Integer getFrequency() {
    return frequency;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getFrequencyDuration() {
    if ((frequency != null) && !new Integer(0).equals(frequency) && !new Integer(7).equals(frequency)
          && !new Integer(14).equals(frequency)) {
      return duration * frequency;
    }

    return duration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getFrequencyStr() {
    if ((frequency != null) && !new Integer(0).equals(frequency) && !new Integer(7).equals(frequency)
          && !new Integer(14).equals(frequency)) {
      return "-2";
    }

    return frequency.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getHasBrokenPromise() {
    if (this.installments != null) {
      for (PaymentProgramInstallment installment : this.installments) {
        if ((installment != null) && (installment.getPromiseToPay() != null)
              && PromiseToPayStatus.BROKEN.equals(installment.getPromiseToPay().getPtpStatus())) {
          return Boolean.TRUE;
        }
      }
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get installment amount by index.
   *
   * @param   index  DOCUMENT ME!
   *
   * @return  get installment amount by index
   */
  public BigDecimal getInstallmentAmount(int index) {
    PaymentProgramInstallment[] installments = this.installments.toArray(
        new PaymentProgramInstallment[0]);

    if ((installments.length > index) && (installments[index] != null)) {
      return installments[index].getPaymentAmount();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Date.
   *
   * @param   installmentNumber  $param.type$
   *
   * @return  Date.
   */
  public Date getInstallmentDate(Integer installmentNumber) {
    Date date = null;

    if (installmentNumber != null) {
      if ((null != this.programStatus) && "ACCEPTED".equalsIgnoreCase(this.programStatus.toString())) {
        for (PaymentProgramInstallment installment : installments) {
          if ((null != installment) && (installmentNumber.intValue() == installment.getOrder())) {
            date = installment.getInstallmentDueDate();

            break;
          }
        }
      }
    }

    return date;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The installmentDateTolerence.
   *
   * @return  the installmentDateTolerence
   *
   *          <p>not-null = "true"</p>
   */
  public Integer getInstallmentDateTolerence() {
    return this.installmentDateTolerence;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The installmentDollarTolerence.
   *
   * @return  the installmentDollarTolerence
   *
   *          <p>not-null = "true"</p>
   */
  public BigDecimal getInstallmentDollarTolerence() {
    return this.installmentDollarTolerence;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get Installments in Map.
   *
   * @return  get Installments in Map
   */
  public Map<Long, PaymentProgramInstallment> getInstallmentMap() {
    Map<Long, PaymentProgramInstallment> map = new LinkedHashMap<Long, PaymentProgramInstallment>();

    for (PaymentProgramInstallment installment : installments) {
      map.put(installment.getInstallmentId(), installment);
    }

    return map;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The set of installments.
   *
   * @return  the set of installments
   *
   *          <p>column = "programId" xStreamConvert4EnterpriseTaskElements
   *          "com.cmc.credagility.PaymentProgramInstallment"</p>
   *
   *          <p>lazy = "false" table = "PaymentProgramInstallment" "true" cascade = "all-delete-orphan"
   *          "installmentOrder asc"</p>
   */
  public Set<PaymentProgramInstallment> getInstallments() {
    return installments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for interest when accepted.
   *
   * @return  BigDecimal
   */
  public BigDecimal getInterestWhenAccepted() {
    return interestWhenAccepted;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PaymentProgramInstallment getLastInstallment() {
    Integer                   order = -1;
    PaymentProgramInstallment ret   = null;

    for (PaymentProgramInstallment installment : installments) {
      if (installment.getOrder() == null) {
        continue;
      }

      if (order.compareTo(installment.getOrder()) <= 0) {
        order = installment.getOrder();
        ret   = installment;
      }
    }

    return ret;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getLetterCount() {
    return letterCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getMaturityDate() {
    maturityDate = this.getAccount().getNCCMaturityDate();

    return maturityDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for monitoring type.
   *
   * @return  PaymentProgramMonitoringType
   */
  public PaymentProgramMonitoringType getMonitoringType() {
    if (monitoringType == null) {
      return PaymentProgramMonitoringType.NONMONITORING;
    }

    return monitoringType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PaymentProgramInstallment getNextInstallment() {
    Date today = DateUtil.toDateOnly(new Date());
    long nt    = today.getTime();

    for (PaymentProgramInstallment installment : this.installments) {
      if (installment != null) {
        Date installmentDueDate = installment.getInstallmentDueDate();

        if ((installmentDueDate != null)
              && (installmentDueDate.getTime() >= nt)) {
          return installment;
        }
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getNextInstallmentAmount() {
    PaymentProgramInstallment installment = getNextInstallment();

    if (installment != null) {
      return installment.getPaymentAmount();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getNextInstallmentAmountByExpectedPaymentDate() {
    PaymentProgramInstallment installment = getNextInstallmentByExpectedPaymentDate();

    if (installment != null) {
      return installment.getPaymentAmount();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for next installment amount for RAM.
   *
   * @return  BigDecimal
   */
  public BigDecimal getNextInstallmentAmountForRAM() {
    PaymentProgramInstallment installment = getNextInstallmentForRAM();

    if (installment != null) {
      return installment.getPaymentAmount();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PaymentProgramInstallment getNextInstallmentByExpectedPaymentDate() {
    Date today = DateUtil.toDateOnly(new Date());
    long nt    = today.getTime();

    for (PaymentProgramInstallment installment : this.installments) {
      if (installment != null) {
        Date expectedPaymentDate = installment.getExpectedPaymentDate();

        if ((expectedPaymentDate != null)
              && (expectedPaymentDate.getTime() >= nt)) {
          return installment;
        }
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getNextInstallmentDueDate() {
    PaymentProgramInstallment installment = getNextInstallment();

    if (installment != null) {
      return installment.getInstallmentDueDate();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getNextInstallmentDueDateWithTolerance() {
    PaymentProgramInstallment installment = getNextInstallment();

    if (installment != null) {
      return installment.getDueDateWithTolerance();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getNextInstallmentExpectedPaymentDate() {
    PaymentProgramInstallment installment = getNextInstallmentByExpectedPaymentDate();

    if (installment != null) {
      return installment.getExpectedPaymentDate();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for next installment for RAM.
   *
   * @return  PaymentProgramInstallment
   */
  public PaymentProgramInstallment getNextInstallmentForRAM() {
    Date                                today               = DateUtil.toDateOnly(new Date());
    long                                nt                  = today.getTime();
    Optional<PaymentProgramInstallment> installmentOptional = this.installments.stream().filter(nextInstallment ->
          (nextInstallment.getInstallmentDueDate() != null) && (nextInstallment.getInstallmentDueDate().getTime() >= nt)
          && !InstallmentStatus.FULFILLED.equals(nextInstallment.getCurrentInstallmentStatus())).findFirst();

    return installmentOptional.isPresent() ? installmentOptional.get() : null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PaymentProgramInstallment getNextUnpaidInstallmentByExpectedPaymentDate() {
    Date today = DateUtil.toDateOnly(new Date());
    long nt    = today.getTime();

    for (PaymentProgramInstallment installment : this.installments) {
      if (installment != null) {
        Date expectedPaymentDate = installment.getExpectedPaymentDate();

        if ((expectedPaymentDate != null)
              && (expectedPaymentDate.getTime() >= nt)) {
          Payment payment = installment.getPayment();

          if ((payment == null) || PaymentStatus.SCHEDULED.equals(payment.getPaymentStatus())) {
            return installment;
          }
        }
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getOfferProcessStatus() {
    ProgramStatus entityStatus       = this.getProgramStatus();
    String        offerProcessStatus = Offer_Process_Status_None;

    if ((ProgramStatus.INIT == entityStatus) && isInEffect()) {
      offerProcessStatus = Offer_Process_Status_Eligible;
    } else if (ProgramStatus.ACCEPTED == entityStatus) {
      offerProcessStatus = Offer_Process_Status_Accepted;
    } else if (entityStatus.isCancelled()) {
      offerProcessStatus = Offer_Process_Status_Cancelled;
    } else if (ProgramStatus.ENDED == entityStatus) {
      offerProcessStatus = Offer_Process_Status_Ended;
    } else if (isExpired()) {
      offerProcessStatus = Offer_Process_Status_Expired;
    }

    return offerProcessStatus;
  } // end method getOfferProcessStatus

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get how much has been paid for this program so far. Please note that we consider all payments on this account AFTER
   * program acceptance date as payments towards the whole program amount.
   *
   * @return  get how much has been paid for this program so far.
   */
  public BigDecimal getPaidAmountSoFar() {
    BigDecimal paymentForProgram = new BigDecimal("0.0");
    Date       acceptDate        = getBestAcceptDate();

    if (acceptDate == null) {
      return paymentForProgram;
    }

    // We should get all payments after the program acceptDate
    for (Payment payment : account.getPayments()) {
      if (DateUtil.toDateOnly(payment.getPaymentDate()).getTime()
            >= acceptDate.getTime()) {
        if (PaymentStatus.PAID.equals(payment.getPaymentStatus())) {
          paymentForProgram.add(payment.getAmount());
        }
      }
    }

    return paymentForProgram;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * In theory, this percentage equals programAmount divided by principalWhenCreated. In practice, when we strategize a
   * payment program, we specify the percentage. However, However the totlAmount may not be divisible by the duration.
   * Say, if balance is $1,000 and we want to offer a 70% settlement and a duration of 3. Then we get $700/3 =
   * $233.33333333... So in practice, we re-adjust the program: 1. Mathmatically round installment amount of
   * $233.33333333... to $233.33 2. Readjust the total amount to $233.33 * 3 = $699.99 (not $700 any more) 3. Keep the
   * percentage as 70% (no need to adjust to 69.99%)
   *
   * @return  the percentage of the principalWhenCreated for payment program
   *
   *          <p>not-null = "true"</p>
   */
  public BigDecimal getPercentage() {
    return percentage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PaymentProgramInstallment getPreviousInstallment() {
    Date                      today        = DateUtil.toDateOnly(new Date());
    long                      nt           = today.getTime();
    long                      pt           = 0;
    PaymentProgramInstallment pInstallment = null;

    for (PaymentProgramInstallment installment : this.installments) {
      if (installment != null) {
        Date installmentDueDate = installment.getInstallmentDueDate();

        if ((installmentDueDate != null)
              && (installmentDueDate.getTime() > pt)
              && (installmentDueDate.getTime() < nt)) {
          pt           = installmentDueDate.getTime();
          pInstallment = installment;
        }
      }
    }

    return pInstallment;
  } // end method getPreviousInstallment

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getPreviousInstallmentAmount() {
    PaymentProgramInstallment installment = getPreviousInstallment();

    if (installment != null) {
      return installment.getPaymentAmount();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getPreviousInstallmentAmountByExpectedPaymentDate() {
    PaymentProgramInstallment installment = getPreviousInstallmentByExpectedPaymentDate();

    if (installment != null) {
      return installment.getPaymentAmount();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PaymentProgramInstallment getPreviousInstallmentByExpectedPaymentDate() {
    Date                      today        = DateUtil.toDateOnly(new Date());
    long                      nt           = today.getTime();
    long                      pt           = 0;
    PaymentProgramInstallment pInstallment = null;

    for (PaymentProgramInstallment installment : this.installments) {
      if (installment != null) {
        Date expectedPaymentDate = installment.getExpectedPaymentDate();


        if ((expectedPaymentDate != null)
              && (expectedPaymentDate.getTime() > pt)
              && (expectedPaymentDate.getTime() < nt)) {
          pt           = expectedPaymentDate.getTime();
          pInstallment = installment;
        }
      }
    }

    return pInstallment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getPreviousInstallmentDueDate() {
    PaymentProgramInstallment installment = getPreviousInstallment();

    if (installment != null) {
      return installment.getInstallmentDueDate();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getPreviousInstallmentDueDateWithTolerance() {
    PaymentProgramInstallment installment = getPreviousInstallment();

    if (installment != null) {
      return installment.getDueDateWithTolerance();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The type of the principalWhenCreated used to calculate the total amount of the program. Could be "balance",
   * "totalDue", etc.
   *
   * @return  the type of the principalWhenCreated used to calculate the total amount of the program. Could be
   *          "balance", "totalDue", etc.
   *
   *          <p>not-null = "true" length = "64"</p>
   */
  public String getPrincipalType() {
    return principalType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The snapshot of the monetary value of the principal when program was accepted used for calculating payment program
   * amount.
   *
   * @return  the snapshot of the monetary value of the principal when program was accepted used for calculating payment
   *          program amount
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getPrincipalWhenAccepted() {
    return principalWhenAccepted;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The snapshot of the monetary value of the principal when program was created used for calculating payment program
   * amount.
   *
   * @return  the snapshot of the monetary value of the principal when program was created used for calculating payment
   *          program amount
   *
   *          <p>not-null = "true"</p>
   */
  public BigDecimal getPrincipalWhenCreated() {
    return principalWhenCreated;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public ProgramAction getProgramAction() {
    return programAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The total programAmount.
   *
   * @return  the total programAmount
   *
   *          <p>not-null = "true"</p>
   */
  public BigDecimal getProgramAmount() {
    return programAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getProgramHashCode() {
    return programHashCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The programId.
   *
   * @return  the programId
   *
   *          <p>generator-class = "native" unsaved-value = "null"</p>
   */
  public Long getProgramId() {
    return programId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The programOrder of payment program.
   *
   * @return  the programOrder of payment program
   *
   *          <p>not-null = "true" column = "programOrder"</p>
   */
  public Integer getProgramOrder() {
    return programOrder;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Status of the program. Could be "Init", "InProgress", "BrokenPromise", "Fulfilled", etc.
   *
   * @return  status of the program. Could be "Init", "InProgress", "BrokenPromise", "Fulfilled", etc.
   *
   *          <p>not-null = "true" length = "20" "com.cmc.dao.hibernate.support.ProgramStatusUserType"</p>
   */
  public ProgramStatus getProgramStatus() {
    return programStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public ProgramTemplate getProgramTemplate() {
    return programTemplate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getProgramTempStatus() {
    return programTempStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<Document> getRequiredDocuments() {
    return requiredDocuments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<PaymentProgramInstallment> getRequiredInstallments() {
    if (getDuration().intValue() > getRequiredPayments().intValue()) {
      Iterator<PaymentProgramInstallment> it = installments.iterator();

      for (int i = 0; i < getRequiredPayments().intValue(); i++) {
        requiredInstallments.add(it.next());
      }

      return requiredInstallments;
    } else {
      return getInstallments();
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The requiredPayments.
   *
   * @return  the requiredPayments
   *
   *          <p>not-null = "false"</p>
   */
  public Integer getRequiredPayments() {
    if (requiredPayments == null) {
      requiredPayments = duration;
    }

    return requiredPayments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getRequiredPTPs() {
    return requiredPTPs;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The responsible party that accepts this payment program. Normally one responsible party can only accept one payment
   * program so it seems make sense to set unique = "true". But actually it is one account that can only accept one
   * program. No need to set unique here just in case multiple accounts have the same responsible.
   *
   * @return  the responsible party that accepts this payment program.
   *
   *          <p>lazy = "proxy" column = "responsibleId" "false" class = "com.cmc.credagility.Responsible" "true"</p>
   */
  public Responsible getResponsible() {
    return responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The ruleBatchId.
   *
   * @return  the ruleBatchId
   *
   *          <p>not-null = "false"</p>
   */
  public Long getRuleBatchId() {
    return ruleBatchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The Id of the rule creating this payment program. Could be null if this payment program is generated manually.
   *
   * @return  the Id of the rule creating this payment program. Could be null if this payment program is generated
   *          manually.
   *
   *          <p>not-null = "false"</p>
   */
  public Long getRuleId() {
    return ruleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
   * This methods returns the Second Installment amount for the program if exist
   * or returns the firstInstallment amount.
   *
   * @author kpalanivelu
   *
   * @return BigDecimal
   */
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getSecondInstallmentAmount() {
    PaymentProgramInstallment ret   = null;
    Integer                   order = 1;

    for (PaymentProgramInstallment installment : installments) {
      if (installment.getOrder() == null) {
        continue;
      }

      if (order.compareTo(installment.getOrder()) == 0) {
        ret = installment;
      }

      if (new Integer(2).compareTo(installment.getOrder()) == 0) {
        ret = installment;

        break;
      }
    }

    return (ret != null) ? ret.getPaymentAmount() : null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the last installment payment date if this is a settlement program.
   *
   * @return  get the last installment payment date if this is a settlement program.
   */
  public Date getSettlementDate() {
    if ((this.type == null)
          || !PaymentProgramTypeCode.SETTLEMENT.equals(
            PaymentProgramTypeCode.toPaymentProgramTypeCode(
              getType().getProgramTypeId()))) {
      return null;
    }

    Iterator<PaymentProgramInstallment> it   = installments.iterator();
    Date                                d    = null;
    PaymentProgramInstallment           last = null;

    while (it.hasNext()) {
      last = it.next();
    }

    if (last != null) {
      Payment payment = last.getPayment();

      if (payment != null) {
        d = payment.getPaymentDate();
      }
    }

    return d;
  } // end method getSettlementDate

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Possible values include: Agent or Startegy. "Agent" means program is created manually by CMC or Agency agents.
   * "Strategy" means it is created by business rule engine.
   *
   * @return  how the program is created
   *
   *          <p>not-null = "true" length = "20" "com.cmc.dao.hibernate.support.ProgramSourceUserType"</p>
   */
  public ProgramSource getSource() {
    return source;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status change date.
   *
   * @return  Date
   */
  public Date getStatusChangeDate() {
    return statusChangeDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public WorkflowNodeActionTriggerType getSurveyFlowMode() {
    return surveyFlowMode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public SurveyFlowStep getSurveyFlowStep() {
    return surveyFlowStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The totalAmount.
   *
   * @return  the totalAmount
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getTotalAmount() {
    return this.totalAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The type.
   *
   * @return  the type
   *
   *          <p>lazy = "false" column = "programTypeId" "true" class = "com.cmc.credagility.PaymentProgramType" insert
   *          = "true" update = "true"</p>
   */
  public PaymentProgramType getType() {
    return type;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * How many times this payment program has been viewed by user.
   *
   * @return  how many times this payment program has been viewed by user
   *
   *          <p>not-null = "false"</p>
   */
  public Integer getViewCount() {
    return viewCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for weekday.
   *
   * @return  Integer
   */
  public Integer getWeekday() {
    return weekday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = super.hashCode();
    result = (prime * result) + businessHashCode();

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * initializeInstallmentDates.
   */
  public void initializeInstallmentDates() {
    for (PaymentProgramInstallment installment : installments) {
      installment.setPaymentDate(installment.getInstallmentDueDate());
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isAccepted() {
    return responsible != null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isAllRequiredDocumentApproved() {
    boolean flag = true;

    for (Document document : requiredDocuments) {
      if (!Document_Process_Status_Approved.equals(document.getDocumentStatus().getName())) {
        flag = false;

        break;
      }
    }

    return flag;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isAllRequiredDocumentReceived() {
    boolean flag = true;

    for (Document document : requiredDocuments) {
      if (Document_Process_Status_Outstanding.equals(document.getDocumentStatus().getName())) {
        flag = false;

        break;
      }
    }

    return flag;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Only makes sense for accepted payment program.
   *
   * <p>Determine whether a payment program has been broken.</p>
   *
   * @return  only makes sense for accepted payment program.
   */
  public boolean isBroken() {
    if (this.getPaidAmountSoFar().compareTo(
            this.getDueAmountWithTolerance()) < 0) {
      return true;
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Check if a payment program is expired.
   *
   * @return  true if a payment program is expired.
   */
  public boolean isExpired() {
    if (this.expirationDate == null) {
      return false; // never expire
    }

    return CompareUtil.compareDateOnly(new Date(), getExpirationDate()) > 0;


  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isFullfilled() {
    if (this.getPaidAmountSoFar().compareTo(this.getTotalAmount()) >= 0) {
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
  public boolean isInEffect() {
    return !Boolean.FALSE.equals(getActive()) && !isExpired();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  amount  DOCUMENT ME!
   */
  public void receivedNewPayment(BigDecimal amount) {
    receivedNewPayment(amount, null);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  amount    DOCUMENT ME!
   * @param  paidDate  DOCUMENT ME!
   */
  public void receivedNewPayment(BigDecimal amount, Date paidDate) {
    if (amount == null) {
      return;
    }

    Date       now = new Date();
    BigDecimal all = BigDecimal.ZERO;

    for (PaymentProgramInstallment installment : installments) {
      // ascending by installment order
      if (paidDate != null) {
        Date bizInstallmentDueDate = installment.getBusinessInstallmentDueDate();

        if (bizInstallmentDueDate.getTime() < paidDate.getTime()) {
          continue;
        }
      }

      BigDecimal receivedAmount = installment.getReceivedAmount();

      if (receivedAmount == null) {
        receivedAmount = BigDecimal.ZERO;
      }

      BigDecimal installmentAmount = installment.getPaymentAmount();

      if (installmentAmount.compareTo(receivedAmount) > 0) {
        BigDecimal temp = receivedAmount.add(amount);

        if (temp.compareTo(installmentAmount) > 0) {
          installment.setReceivedAmount(installmentAmount);
          installment.setLastUpdateDate(now);
          amount = temp.subtract(installmentAmount);
        } else if (temp.compareTo(installmentAmount) == 0) {
          installment.setReceivedAmount(installmentAmount);
          amount = BigDecimal.ZERO;
        } else {
          installment.setReceivedAmount(temp);
          amount = BigDecimal.ZERO;
        }
      }

      receivedAmount = installment.getReceivedAmount();

      if (receivedAmount != null) {
        all = all.add(receivedAmount);
      }
    } // end for

    if (all.compareTo(this.getProgramAmount()) >= 0) {
      this.setProgramStatus(ProgramStatus.FULFILLED);
    }
  } // end method receivedNewPayment

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
   * @param  acceptDate  DOCUMENT ME!
   */
  public void setAcceptDate(Date acceptDate) {
    this.acceptDate = acceptDate;
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
   * @param  actionData1  DOCUMENT ME!
   */
  public void setActionData1(String actionData1) {
    this.actionData1 = actionData1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  actionData2  DOCUMENT ME!
   */
  public void setActionData2(String actionData2) {
    this.actionData2 = actionData2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  actionData3  DOCUMENT ME!
   */
  public void setActionData3(String actionData3) {
    this.actionData3 = actionData3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  active  the active to set
   */
  public void setActive(Boolean active) {
    this.active = active;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  allowEagerPayment  DOCUMENT ME!
   */
  public void setAllowEagerPayment(Boolean allowEagerPayment) {
    this.allowEagerPayment = allowEagerPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  allowedInstallmentDateRange  the allowedInstallmentDateRange to set
   */
  public void setAllowedInstallmentDateRange(Integer allowedInstallmentDateRange) {
    this.allowedInstallmentDateRange = allowedInstallmentDateRange;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  approved  DOCUMENT ME!
   */
  public void setApproved(Boolean approved) {
    this.approved = approved;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  apr  the apr to set
   */
  public void setApr(BigDecimal apr) {
    this.apr = apr;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for balance when accepted.
   *
   * @param  balanceWhenAccepted  BigDecimal
   */
  public void setBalanceWhenAccepted(BigDecimal balanceWhenAccepted) {
    this.balanceWhenAccepted = balanceWhenAccepted;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  cancelledStatusDate  DOCUMENT ME!
   */
  public void setCancelledStatusDate(Date cancelledStatusDate) {
    this.cancelledStatusDate = cancelledStatusDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  creatorAgentId  DOCUMENT ME!
   */
  public void setCreatorAgentId(Long creatorAgentId) {
    this.creatorAgentId = creatorAgentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  declineCount  DOCUMENT ME!
   */
  public void setDeclineCount(Integer declineCount) {
    this.declineCount = declineCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  detailViewCount  the detailViewCount to set
   */
  public void setDetailViewCount(Integer detailViewCount) {
    this.detailViewCount = detailViewCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  duration  the duration to set
   */
  public void setDuration(Integer duration) {
    this.duration = duration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  expirationDate  the expirationDate to set
   */
  public void setExpirationDate(Date expirationDate) {
    this.expirationDate = expirationDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  expirationDateTolerence  the expirationDateTolerence to set
   */
  public void setExpirationDateTolerence(Integer expirationDateTolerence) {
    this.expirationDateTolerence = expirationDateTolerence;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for external reference number.
   *
   * @param  externalReferenceNumber  String
   */
  public void setExternalReferenceNumber(String externalReferenceNumber) {
    this.externalReferenceNumber = externalReferenceNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for fee1 when accepted.
   *
   * @param  fee1WhenAccepted  BigDecimal
   */
  public void setFee1WhenAccepted(BigDecimal fee1WhenAccepted) {
    this.fee1WhenAccepted = fee1WhenAccepted;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for fee2 when accepted.
   *
   * @param  fee2WhenAccepted  BigDecimal
   */
  public void setFee2WhenAccepted(BigDecimal fee2WhenAccepted) {
    this.fee2WhenAccepted = fee2WhenAccepted;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for fee3 when accepted.
   *
   * @param  fee3WhenAccepted  BigDecimal
   */
  public void setFee3WhenAccepted(BigDecimal fee3WhenAccepted) {
    this.fee3WhenAccepted = fee3WhenAccepted;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for fee4 when accepted.
   *
   * @param  fee4WhenAccepted  BigDecimal
   */
  public void setFee4WhenAccepted(BigDecimal fee4WhenAccepted) {
    this.fee4WhenAccepted = fee4WhenAccepted;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  fixedFeeAmount  DOCUMENT ME!
   */
  public void setFixedFeeAmount(BigDecimal fixedFeeAmount) {
    this.fixedFeeAmount = fixedFeeAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  fixedFeeOn  the fixedFeeOn to set
   */
  public void setFixedFeeOn(Boolean fixedFeeOn) {
    this.fixedFeeOn = fixedFeeOn;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  frequency  DOCUMENT ME!
   */
  public void setFrequency(Integer frequency) {
    this.frequency = frequency;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  installmentDateTolerence  the installmentDateTolerence to set
   */
  public void setInstallmentDateTolerence(Integer installmentDateTolerence) {
    this.installmentDateTolerence = installmentDateTolerence;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  installmentDollarTolerence  the installmentDollarTolerence to set
   */
  public void setInstallmentDollarTolerence(BigDecimal installmentDollarTolerence) {
    this.installmentDollarTolerence = installmentDollarTolerence;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  installments  DOCUMENT ME!
   */
  public void setInstallments(Set<PaymentProgramInstallment> installments) {
    this.installments = installments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for interest when accepted.
   *
   * @param  interestWhenAccepted  BigDecimal
   */
  public void setInterestWhenAccepted(BigDecimal interestWhenAccepted) {
    this.interestWhenAccepted = interestWhenAccepted;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  letterCount  DOCUMENT ME!
   */
  public void setLetterCount(Integer letterCount) {
    this.letterCount = letterCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  maturityDate  DOCUMENT ME!
   */
  public void setMaturityDate(Date maturityDate) {
    this.maturityDate = maturityDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for monitoring type.
   *
   * @param  monitoringType  PaymentProgramMonitoringType
   */
  public void setMonitoringType(PaymentProgramMonitoringType monitoringType) {
    this.monitoringType = monitoringType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  percentage  DOCUMENT ME!
   */
  public void setPercentage(BigDecimal percentage) {
    this.percentage = percentage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  principalType  DOCUMENT ME!
   */
  public void setPrincipalType(String principalType) {
    this.principalType = principalType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  principalWhenAccepted  DOCUMENT ME!
   */
  public void setPrincipalWhenAccepted(BigDecimal principalWhenAccepted) {
    this.principalWhenAccepted = principalWhenAccepted;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  principalWhenCreated  DOCUMENT ME!
   */
  public void setPrincipalWhenCreated(BigDecimal principalWhenCreated) {
    this.principalWhenCreated = principalWhenCreated;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  programAction  DOCUMENT ME!
   */
  public void setProgramAction(ProgramAction programAction) {
    this.programAction = programAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  totalAmount  the programAmount to set
   */
  public void setProgramAmount(BigDecimal totalAmount) {
    this.programAmount = totalAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  programHashCode  DOCUMENT ME!
   */
  public void setProgramHashCode(Integer programHashCode) {
    this.programHashCode = programHashCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  programId  the programId to set
   */
  public void setProgramId(Long programId) {
    this.programId = programId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  programOrder  the programOrder to set
   */
  public void setProgramOrder(Integer programOrder) {
    this.programOrder = programOrder;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  programStatus  DOCUMENT ME!
   */
  public void setProgramStatus(ProgramStatus programStatus) {
    this.programStatus = programStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  programTemplate  DOCUMENT ME!
   */
  public void setProgramTemplate(ProgramTemplate programTemplate) {
    this.programTemplate = programTemplate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  programTempStatus  DOCUMENT ME!
   */
  public void setProgramTempStatus(String programTempStatus) {
    this.programTempStatus = programTempStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  requiredDocuments  DOCUMENT ME!
   */
  public void setRequiredDocuments(Set<Document> requiredDocuments) {
    this.requiredDocuments = requiredDocuments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  requiredInstallments  DOCUMENT ME!
   */
  public void setRequiredInstallments(Set<PaymentProgramInstallment> requiredInstallments) {
    this.requiredInstallments = requiredInstallments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  requiredPayments  the requiredPayments to set
   */
  public void setRequiredPayments(Integer requiredPayments) {
    this.requiredPayments = requiredPayments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  requiredPTPs  DOCUMENT ME!
   */
  public void setRequiredPTPs(Integer requiredPTPs) {
    this.requiredPTPs = requiredPTPs;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  responsible  DOCUMENT ME!
   */
  public void setResponsible(Responsible responsible) {
    this.responsible = responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  ruleBatchId  the ruleBatchId to set
   */
  public void setRuleBatchId(Long ruleBatchId) {
    this.ruleBatchId = ruleBatchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  ruleId  DOCUMENT ME!
   */
  public void setRuleId(Long ruleId) {
    this.ruleId = ruleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  source  DOCUMENT ME!
   */
  public void setSource(ProgramSource source) {
    this.source = source;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for status change date.
   *
   * @param  statusChangeDate  Date
   */
  public void setStatusChangeDate(Date statusChangeDate) {
    this.statusChangeDate = statusChangeDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  surveyFlowMode  DOCUMENT ME!
   */
  public void setSurveyFlowMode(WorkflowNodeActionTriggerType surveyFlowMode) {
    this.surveyFlowMode = surveyFlowMode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  surveyFlowStep  DOCUMENT ME!
   */
  public void setSurveyFlowStep(SurveyFlowStep surveyFlowStep) {
    this.surveyFlowStep = surveyFlowStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  totalAmount  the totalAmount to set
   */
  public void setTotalAmount(BigDecimal totalAmount) {
    this.totalAmount = totalAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  type  the type to set
   */
  public void setType(PaymentProgramType type) {
    this.type = type;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  viewCount  DOCUMENT ME!
   */
  public void setViewCount(Integer viewCount) {
    this.viewCount = viewCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for weekday.
   *
   * @param  weekday  Integer
   */
  public void setWeekday(Integer weekday) {
    this.weekday = weekday;
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

    retValue.append("PaymentProgram ( ").append("programId = ").append(
      this.programId).append(TAB).append("account = ").append(
      this.account).append(TAB).append("apr = ").append(this.apr).append(
      TAB).append("duration = ").append(this.duration).append(TAB).append(
      "frequency = ").append(this.frequency).append(TAB).append(
      "programAmount = ").append(this.programAmount).append(TAB).append(
      "fixedFeeAmount = ").append(this.programAmount).append(TAB).append(
      "order = ").append(this.programOrder).append(TAB).append("type = ").append(this.type).append(TAB).append(" )");

    return retValue.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updateFlexPaymentProgram.
   *
   * @param  other          PaymentProgram
   * @param  programAction  ProgramAction
   */
  public void updateFlexPaymentProgram(PaymentProgram other, ProgramAction programAction) {
    if (other.getRuleId() != null) {
      this.ruleId = other.getRuleId().longValue();
    }

    this.ruleBatchId = other.getRuleBatchId();

    this.actionData1 = other.getActionData1();
    this.actionData2 = other.getActionData2();
    this.actionData3 = other.getActionData3();
// this.apr            = other.getApr();
    this.expirationDate = other.getExpirationDate();

    this.fixedFeeAmount = other.getFixedFeeAmount();
    this.fixedFeeOn     = other.getFixedFeeOn();

    this.programOrder = other.getProgramOrder();

    if (other.getExpirationDate() != null) {
      Date d = other.getExpirationDate();
      this.expirationDate = new Date(d.getTime());

      if (d.after(new Date())) {
        this.active = Boolean.TRUE;
      }
    } else {
      this.active = Boolean.TRUE;
    }

    this.lastUpdateDate   = new Date();
    this.monitoringType   = programAction.getMonitoringType();
    this.statusChangeDate = new Date();
  } // end method updateFlexPaymentProgram

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * update current payment program extra info with the input program.
   *
   * @param  other          DOCUMENT ME!
   * @param  programAction  ProgramAction
   */
  public void updatePaymentProgram(PaymentProgram other, ProgramAction programAction) {
    if (other.getRuleId() != null) {
      this.ruleId = other.getRuleId().longValue();
    }

    this.ruleBatchId = other.getRuleBatchId();
    // this.source      = other.getSource();

    this.allowedInstallmentDateRange = other.getAllowedInstallmentDateRange();
    this.installmentDateTolerence    = other.getInstallmentDateTolerence();
    this.installmentDollarTolerence  = other.getInstallmentDollarTolerence();

    this.actionData1    = other.getActionData1();
    this.actionData2    = other.getActionData2();
    this.actionData3    = other.getActionData3();
    this.apr            = other.getApr();
    this.expirationDate = other.getExpirationDate();

    // this.expirationDateTolerence = this.getExpirationDateTolerence();
    this.fixedFeeAmount = other.getFixedFeeAmount();
    this.fixedFeeOn     = other.getFixedFeeOn();

    // update order if it was smaller
    // if (other.getProgramOrder() != null
    // && this.programOrder > other.getProgramOrder()) {
    // this.programOrder = other.getProgramOrder().intValue();
    // }

    this.programOrder = other.getProgramOrder();

    if (other.getExpirationDate() != null) {
      Date d = other.getExpirationDate();
      this.expirationDate = new Date(d.getTime());

      if (d.after(new Date())) {
        this.active = Boolean.TRUE;
      }
    } else {
      this.active = Boolean.TRUE;
    }

    this.requiredPayments = other.getRequiredPayments().intValue();
    this.percentage       = other.getPercentage();
    this.lastUpdateDate   = new Date();
    this.monitoringType   = programAction.getMonitoringType();
    this.statusChangeDate = new Date();
  } // end method updatePaymentProgram

  //~ ------------------------------------------------------------------------------------------------------------------

  private boolean isLastInstallment(PaymentProgramInstallment lastInstallment,
    PaymentProgramInstallment currentInstallment) {
    return lastInstallment.getInstallmentId().equals(
        currentInstallment.getInstallmentId());
  }
} // end class PaymentProgram
