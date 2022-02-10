package com.cmc.credagility.core.domain.payment;

import java.io.Serializable;

import java.math.BigDecimal;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import com.cmc.credagility.core.domain.activity.AgentCallActivity;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.domain.type.InstallmentStatus;
import com.cmc.credagility.core.domain.type.PaymentStatus;
import com.cmc.credagility.core.domain.type.PromiseToPayStatus;
import com.cmc.credagility.core.domain.util.DateUtil;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * This class is used to store Payment Program information.
 *
 * <p><a href="PaymentProgramInstallment.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:bshuai@ozstrategy.com">Bin Shuai</a>
 *
 *           <p>table = "PaymentProgramInstallment"</p>
 * @version  $Revision$, $Date$
 */
@Entity
@Table(
  name              = "PaymentProgramInstallment",
  uniqueConstraints = { @UniqueConstraint(columnNames = "paymentId") },
  indexes           = {
    @Index(
      name          = "FK42_paymentId",
      columnList    = "paymentId"
    ),
    @Index(
      name          = "endEffectiveDateIndex",
      columnList    = "endEffectiveDate"
    )
  }
)
public class PaymentProgramInstallment extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 8024268952244733311L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(name = "endEffectiveDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date endEffectiveDate;

  /** expected payment date <code>Date.</code> */
  @Column(name = "expectedPaymentDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date expectedPaymentDate;
  // npelleti, 07/30, USBank, Removed unique constraint

  /**
   * Is this a regular installment payment or a fixed payment prior to accept payment program - per Dawn, this fixed
   * payment amount is in addition to the payment program total amount.
   */
  @Column(
    name             = "fixedFee",
    columnDefinition = "char",
    length           = 1,
    nullable         = false
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean fixedFee;

  /**
   * The funding account Id that is used to fund this installment. This is not a persisted fields. Majorly used for
   * binding purpose in web command object. Important: Please note that you can not persist this field. If you persist
   * it, you may not be able to delete the fundingAccount.
   */
  @Transient protected Long fundingAccountId;

  /** TODO: DOCUMENT ME! */
  @Transient protected FundingInformation fundingInformation;

  /**
   * payment due date - the last day which the payment could be accepted , it should be initialized when the program was
   * accepted. This date is calculated as: = Date To Accept Program + PaymentProgram.allowedInstallmentDateRange After
   * this payment program is accepted and future installment payments have been scheduled, if the debtor try to edit the
   * payment date for this payment program, he can not choose a date after installmentDueDate without unregister this
   * payment program.
   */
  @Column(name = "installmentDueDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date installmentDueDate;

  /** Payment program installment PK. */
  @Column(
    name     = "installmentId",

    /*unique   = true,*/
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long installmentId;

  /**
   * A transient value that is set during PaymentProgram.initializeInstallmentDates. Normally used in command objects.
   */
  @Transient protected Date installmentStartDate;

  /** A transient value that is set during accepted Payment Program Offer, installment.installmentDueDate. */
  @Transient protected Date maxPaymentDate;

  /** Order of the installment within payment program. Starting from 1. */
  @Column(
    name     = "installmentOrder",
    nullable = false
  )
  protected Integer order;

  /**
   * Corresponding Payment Id, if any - you can get payment status from here. Could be null if this payment program has
   * not been accepted. One installment could have multiple payments due to program cancelling.
   */
  @JoinColumn(
    name =
      "paymentId"
// unique = true
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected Payment payment;

  /** Payment amount <code>BigDecimal.</code> */
  @Column(
    name     = "paymentAmount",
    nullable = false
  )
  protected BigDecimal paymentAmount;


  /**
   * paymentDate is not persisted. It is first calculated from paymentMonthOffset and paymentDateOffset, then it will be
   * automatically bound to wahtever user input is. This field is useful when leveraging Spring automatic binding. User
   * may change the default payment date to a new date. Validation will be performed on this field.
   */
  @Temporal(TemporalType.TIMESTAMP)
  @Transient protected Date paymentDate;

  /**
   * paymentDateOffset is used to calculate the payment date of this installment. The payment date of this installment
   * is calculated as today.add(Calendar.Month, paymentMonthOffset); today.add(Calendar.DAY_OF_YEAR, paymentDateOffset);
   * Pleae note the calculated date is not the real payment date - user has the chance to change it (typically within an
   * allowed range).
   */
  @Column(
    name     = "paymentDateOffset",
    nullable = false
  )
  protected Integer paymentDateOffset = 0;

  /**
   * This is the month offset. Payment date should be adjusted by month and then by date. Normally paymentDateOffset
   * should be 0.
   */
  @Column(
    name     = "paymentMonthOffset",
    nullable = false
  )
  protected Integer paymentMonthOffset = 0;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "programId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PaymentProgram paymentProgram;

  /** TODO: DOCUMENT ME! */
  @OneToOne(
    fetch    = FetchType.LAZY,
    mappedBy = "paymentProgramInstallment",
    cascade  = { CascadeType.ALL, CascadeType.REMOVE }
  )
  protected PromiseToPay promiseToPay = null;

  /** Only meaningful when the user has accepted this payment program <code>BigDecimal.</code> */
  @Column(name = "receivedAmount")
  protected BigDecimal receivedAmount;

  @Transient private Long checkNumber;

  @Column(
    name   = "currentInstallmentStatus",
    length = 25
  )
  @Enumerated(EnumType.STRING)
  private InstallmentStatus currentInstallmentStatus;

  /** <code>True</code> this payment program installment is required. */
  @Column(
    name             = "required",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean required = true;

  @Transient private Boolean requiredPayment = false;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public int businessHashCode() {
    final int prime  = 31;
    int       result = paymentAmount.hashCode() * order;
    result = (prime * result) + ((order == null) ? 0 : order.hashCode());
    result = (prime * result) + ((paymentAmount == null) ? 0 : paymentAmount.hashCode());
    result = (prime * result) + ((fixedFee == null) ? 0 : fixedFee.hashCode());
    result = (prime * result) + ((paymentDateOffset == null) ? 0 : paymentDateOffset.hashCode());
    result = (prime * result) + ((paymentMonthOffset == null) ? 0 : paymentMonthOffset.hashCode());

    return result;
  }

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
    ptp.setAccount(this.getPaymentProgram().getAccount());
    ptp.setAgentCallActivity(agentCallActivity);
    ptp.setCreateDate(createDate);
    ptp.setPayment(this.getPayment());
    ptp.setPaymentAmount(this.getPaymentAmount());
    ptp.setPaymentDate(this.getInstallmentDueDate());
    ptp.setPaymentMethodConfiguration(ptpPaymentMethodConfiguration);
    ptp.setPaymentProgramInstallment(this);
    ptp.setPtpStatus(status);
    ptp.setResponsible(responsible);
    ptp.setSendDate(this.getInstallmentDueDate());
    ptp.setBalance(responsible.getAccount().getBalance());
    ptp.setClientDefinedDecimal(responsible.getAccount().getClientDefinedDecimal1());

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

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#equals(java.lang.Object)
   */

  // end method createPTP

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }

    if (obj == null) {
      return false;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    final PaymentProgramInstallment other = (PaymentProgramInstallment) obj;

    if (paymentProgram == null) {
      if (other.getPaymentProgram() != null) {
        return false;
      }
    } else if (!paymentProgram.equals(other.getPaymentProgram())) {
      return false;
    }

    if (paymentAmount == null) {
      if (other.getPaymentAmount() != null) {
        return false;
      }
    } else if (!paymentAmount.equals(other.getPaymentAmount())) {
      return false;
    }

    if (order == null) {
      if (other.getOrder() != null) {
        return false;
      }
    } else if (!order.equals(other.getOrder())) {
      return false;
    }

    if (required == null) {
      if (other.getRequired() != null) {
        return false;
      }
    } else if (!required.equals(other.getRequired())) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Return payment date if program has been accepted, otherwise null.
   *
   * @return  payment date
   */
  public Date getActualPaymentDate() {
    if (payment != null) {
      return payment.getPaymentDate();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for available days.
   *
   * @return  String
   */
  public String getAvailableDays() {
    StringBuffer availableDates = new StringBuffer();

    for (Date date : getAvailableDate()) {
      availableDates.append(new SimpleDateFormat("yyyy-MM-dd").format(date));
      availableDates.append(";");
    }

    if (availableDates.length() > 0) {
      availableDates.deleteCharAt(availableDates.length() - 1);
    }

    return availableDates.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getBusinessCustomerDueDate() {
    return getInstallmentDueDate();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getBusinessInstallmentDueDate() {
    // handle Scottish Power Due Date
    Portfolio portfolio = this.getPaymentProgram().getAccount().getPortfolio();

    if (new Long(100L).equals(portfolio.getPortfolioId()) || new Long(100001L).equals(portfolio.getPortfolioId())) {
      if (expectedPaymentDate == null) {
        return getDueDateWithTolerance();
      }

      return DateUtil.addDays(expectedPaymentDate,
          this.getPaymentProgram().getInstallmentDateTolerence());
    }

    return getDueDateWithTolerance();

  } // end method getBusinessInstallmentDueDate

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getCheckNumber() {
    return checkNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public InstallmentStatus getCurrentInstallmentStatus() {
    return currentInstallmentStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getDueDateWithTolerance() {
    Date dueDate = null;

    try {
      if (this.getInstallmentDueDate() != null) {
        dueDate = DateUtil.toDateOnly(this.getInstallmentDueDate());
      } else {
        Date acceptedDate = null;

        if (paymentProgram.getAcceptDate() != null) {
          acceptedDate = DateUtil.toDateOnly(
              paymentProgram.getAcceptDate());

          GregorianCalendar cal = new GregorianCalendar();
          cal.setTime(acceptedDate);
          cal.add(Calendar.MONTH, this.getPaymentMonthOffset());
          cal.add(Calendar.DAY_OF_YEAR, this.getPaymentDateOffset());
          this.setPaymentDate(cal.getTime());
          cal.add(Calendar.DAY_OF_YEAR,
            paymentProgram.getAllowedInstallmentDateRange());
          this.setInstallmentDueDate(cal.getTime());
          dueDate = cal.getTime();
        }
      }

      Integer tolerance = this.paymentProgram.getInstallmentDateTolerence();

      if (tolerance != null) {
        dueDate = DateUtil.addDays(dueDate, tolerance);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } // end try-catch

    return dueDate;
  } // end method getDueDateWithTolerance

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for end effective date.
   *
   * @return  Date
   */
  public Date getEndEffectiveDate() {
    return endEffectiveDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getExpectedPaymentDate() {
    return expectedPaymentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Whether this is a fixed payment.
   *
   * @return  whether this is a fixed payment
   *
   *          <p>not-null = "true" type = "yes_no"</p>
   */
  public Boolean getFixedFee() {
    return fixedFee;
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
   * getter method for funding information.
   *
   * @return  FundingInformation
   */
  public FundingInformation getFundingInformation() {
    return fundingInformation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * return the payment due date.
   *
   * @return  the payment due date
   *
   *          <p>not-null = "false"</p>
   */
  public Date getInstallmentDueDate() {
    return installmentDueDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The installment PK.
   *
   * @return  the installment PK
   *
   *          <p>generator-class = "native" unsaved-value = "null"</p>
   */
  public Long getInstallmentId() {
    return installmentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PaymentStatus getInstallmentPaymentStatus() {
    if (this.payment != null) {
      return this.payment.getPaymentStatus();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getInstallmentStartDate() {
    if (installmentStartDate == null) {
      return DateUtil.toDateOnly(new Date());
    }

    return installmentStartDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public InstallmentStatus getInstallmentStatus() {
    Date today   = DateUtil.toDateOnly(new Date());
    long now     = today.getTime();
    Date dueDate = this.getBusinessInstallmentDueDate();
    long d       = Long.MAX_VALUE;

    if (dueDate != null) {
      d = dueDate.getTime();
    }

    if (paymentAmount == null) {
      return null;
    }

    if (d > now) {
      if ((receivedAmount == null)
            || (BigDecimal.ZERO.compareTo(receivedAmount) >= 0)) {
        return InstallmentStatus.INIT;
      }

      if (receivedAmount.compareTo(this.paymentAmount) < 0) {
        return InstallmentStatus.PARTIAL;
      } else {
        return InstallmentStatus.FULFILLED;
      }
    } else {
      if ((receivedAmount == null)
            || (receivedAmount.compareTo(this.paymentAmount) < 0)) {
        return InstallmentStatus.BROKEN;
      } else {
        return InstallmentStatus.FULFILLED;
      }

    }
  } // end method getInstallmentStatus

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
   * Order of this installment starting from 1.
   *
   * @return  order of this installment starting from 1
   *
   *          <p>not-null = "true" column = "installmentOrder"</p>
   */
  public Integer getOrder() {
    return order;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Return the corresponding payment object. Could be null if no payment is scheduled (program has not been accepted or
   * accepted by sending a check and no future payment has been schedueld).
   *
   * @return  payment object associated with the program payment
   *
   *          <p>lazy = "false" column = "paymentId" not-null = "false" class = "com.cmc.credagility.Payment" insert =
   *          "true" update = "true" unique = "true"</p>
   */
  public Payment getPayment() {
    return payment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The payment amount for this dateoffset.
   *
   * @return  the payment amount for this dateoffset
   *
   *          <p>not-null = "true"</p>
   */
  public BigDecimal getPaymentAmount() {
    return paymentAmount;
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
   * The offset date of this installment compared to the date user requests the payment, or program accepted date if
   * this is the first installment.
   *
   * @return  the offset date of this installment compared to the date user requests the payment, or program accepted
   *          date if this is the first installment.
   *
   *          <p>not-null = "true"</p>
   */
  public Integer getPaymentDateOffset() {
    return paymentDateOffset;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The offset month of this installment compared to the date user requests the payment, or program accepted date if
   * this is the first installment.
   *
   * @return  the offset month of this installment compared to the date user requests the payment, or program accepted
   *          date if this is the first installment.
   *
   *          <p>not-null = "true"</p>
   */
  public Integer getPaymentMonthOffset() {
    return paymentMonthOffset;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The payment program Id.
   *
   * @return  the payment program Id
   *
   *          <p>lazy = "proxy" column = "programId" not-null = "true" class = "com.cmc.credagility.PaymentProgram"</p>
   */
  public PaymentProgram getPaymentProgram() {
    return paymentProgram;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Return PaymentStatus if program has been accepted and payment has been scheduled, otherwise null.
   *
   * @return  PaymentStatus
   */
  public PaymentStatus getPaymentStatus() {
    if (this.payment != null) {
      return this.payment.getPaymentStatus();
    }

    return null;
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
  public BigDecimal getReceivedAmount() {
    return receivedAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Whether this payment is required.
   *
   * @return  whether this payment is required
   *
   *          <p>type = "yes_no"</p>
   */
  public Boolean getRequired() {
    return required;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getRequiredPayment() {
    if (requiredPayment == null) {
      return Boolean.FALSE;
    }

    return requiredPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getUnfulfilledPaymentAmount() {
    return paymentAmount.subtract((receivedAmount == null) ? BigDecimal.ZERO : receivedAmount);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = 1;
    result = (prime * result)
      + ((paymentProgram == null) ? 0 : paymentProgram.hashCode());
    result = (prime * result)
      + ((paymentAmount == null) ? 0 : paymentAmount.hashCode());
    result = (prime * result) + ((order == null) ? 0 : order.hashCode());
    result = (prime * result)
      + ((required == null) ? 0 : required.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  checknumber  DOCUMENT ME!
   */
  public void setCheckNumber(Long checknumber) {
    this.checkNumber = checknumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  currentInstallmentStatus  DOCUMENT ME!
   */
  public void setCurrentInstallmentStatus(InstallmentStatus currentInstallmentStatus) {
    this.currentInstallmentStatus = currentInstallmentStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for end effective date.
   *
   * @param  endEffectiveDate  Date
   */
  public void setEndEffectiveDate(Date endEffectiveDate) {
    this.endEffectiveDate = endEffectiveDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  expectedPaymentDate  DOCUMENT ME!
   */
  public void setExpectedPaymentDate(Date expectedPaymentDate) {
    this.expectedPaymentDate = expectedPaymentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  fixedFee  DOCUMENT ME!
   */
  public void setFixedFee(Boolean fixedFee) {
    this.fixedFee = fixedFee;
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
   * setter method for funding information.
   *
   * @param  fundingInformation  FundingInformation
   */
  public void setFundingInformation(FundingInformation fundingInformation) {
    this.fundingInformation = fundingInformation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  installmentDueDate  the installmentDueDate to set
   */
  public void setInstallmentDueDate(Date installmentDueDate) {
    this.installmentDueDate = installmentDueDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  installmentId  DOCUMENT ME!
   */
  public void setInstallmentId(final Long installmentId) {
    this.installmentId = installmentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  installmentStartDate  DOCUMENT ME!
   */
  public void setInstallmentStartDate(Date installmentStartDate) {
    this.installmentStartDate = installmentStartDate;
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
   * @param  order  DOCUMENT ME!
   */
  public void setOrder(Integer order) {
    this.order = order;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  payment  DOCUMENT ME!
   */
  public void setPayment(final Payment payment) {
    this.payment = payment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentAmount  DOCUMENT ME!
   */
  public void setPaymentAmount(final BigDecimal paymentAmount) {
    this.paymentAmount = paymentAmount;
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
   * @param  paymentDateOffset  DOCUMENT ME!
   */
  public void setPaymentDateOffset(final Integer paymentDateOffset) {
    this.paymentDateOffset = paymentDateOffset;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentMonthOffset  DOCUMENT ME!
   */
  public void setPaymentMonthOffset(final Integer paymentMonthOffset) {
    this.paymentMonthOffset = paymentMonthOffset;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentProgram  DOCUMENT ME!
   */
  public void setPaymentProgram(final PaymentProgram paymentProgram) {
    this.paymentProgram = paymentProgram;
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
   * @param  receivedAmount  DOCUMENT ME!
   */
  public void setReceivedAmount(BigDecimal receivedAmount) {
    this.receivedAmount = receivedAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  required  DOCUMENT ME!
   */
  public void setRequired(Boolean required) {
    this.required = required;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  requiredPayment  DOCUMENT ME!
   */
  public void setRequiredPayment(Boolean requiredPayment) {
    this.requiredPayment = requiredPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Constructs a <code>String</code> with all attributes in name = value format.
   *
   * @return  a <code>String</code> representation of this object.
   */
  @Override public String toString() {
    final String TAB = "    ";

    final StringBuilder retValue = new StringBuilder();

    retValue.append("PaymentProgramAmount ( ").append("PaymentProgramId = ").append(this.paymentProgram.getProgramId())
      .append(TAB).append(
      "paymentAmount = ").append(this.paymentAmount).append(TAB).append(
      "paymentDateOffset = ").append(this.paymentDateOffset).append(TAB).append("order = ").append(this.order).append(
      " )");

    return retValue.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private List<Date> getAvailableDate() {
    List<Date> availableDates = new ArrayList<>();
    Calendar   cal            = Calendar.getInstance();
    cal.setTime(this.getInstallmentStartDate());
    availableDates.add(this.getInstallmentStartDate());

    Calendar cal2 = Calendar.getInstance();
    cal2.setTime(installmentDueDate);

    while (cal.before(cal2)) {
      cal.add(Calendar.DAY_OF_YEAR, 1);

      availableDates.add(cal.getTime());
    }

    return availableDates;
  }
} // end class PaymentProgramInstallment
