package com.cmc.credagility.core.domain.payment;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

import org.springframework.data.annotation.LastModifiedDate;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.customer.Customer;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.domain.type.AutoDebitStatus;
import com.cmc.credagility.core.domain.type.Frequency;
import com.cmc.credagility.core.domain.type.PaymentChannel;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;
import com.cmc.credagility.core.jpa.converter.StringEncryptionConverter;


/**
 * Auto Debit detail.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  03/20/2015 15:52 PM
 */
@Entity
@Table(name = "AutoDebitDetail")
public class AutoDebitDetail extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -5919339992705465460L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
      name      = "accountNum",
      nullable  = false,
      updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Account account;

  /** payment amount. */
  @Column(
      name      = "amount",
      nullable  = false,
      precision = 19,
      scale     = 2
  )
  protected BigDecimal amount;

  /** TODO: DOCUMENT ME! */
  @Column(
      name     = "autoDebitDetailId",
      nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long autoDebitDetailId;

  /** enrollment request. */
  @JoinColumn(
      name      = "autoDebitEnrollmentId",
      nullable  = true,
      updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected AutoDebitEnrollment autoDebitEnrollment;

  /** TODO: DOCUMENT ME! */
  @Column(length = 100)
  protected String billingGroupId;

  /** TODO: DOCUMENT ME! */
  @Column(name = "cancelConfirmationDate")
  protected Date cancelConfirmationDate;

  /** TODO: DOCUMENT ME! */
  @Column(name = "cancelledDate")
  protected Date cancelledDate;

  /** payment channel. */
  @Column(
      name      = "paymentChannel",
      nullable  = false,
      updatable = false,
      length    = 20
  )
  @Enumerated(EnumType.STRING)
  protected PaymentChannel channel;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
      name      = "customerId",
      nullable  = false,
      updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Customer customer;

  /** TODO: DOCUMENT ME! */
  @Column(name = "dayOfMonth")
  protected Integer dayOfMonth;

  /** TODO: DOCUMENT ME! */
  @Column(name = "dayOfWeek")
  protected Integer dayOfWeek;

  /** TODO: DOCUMENT ME! */
  @Column(name = "endDate")
  protected Date endDate;

  /** TODO: DOCUMENT ME! */
  @Column(name = "enrollConfirmationDate")
  protected Date enrollConfirmationDate;

  /** TODO: DOCUMENT ME! */
  @Column(name = "enrolledDate")
  protected Date enrolledDate;

  /** TODO: DOCUMENT ME! */
  @Column(name = "enrollmentFlag")
  protected String enrollmentFlag;

  /** TODO: DOCUMENT ME! */
  @Column(name = "firstPaymentEffectiveDate")
  protected Date firstPaymentEffectiveDate;

  /** TODO: DOCUMENT ME! */
  @Column(
      name   = "frequency",
      length = 20
  )
  @Enumerated(EnumType.STRING)
  protected Frequency frequency;

  /** this will be persisted. */
  @Column(
      name     = "fundingAccountId",
      nullable = true
  )
  protected Long fundingAccountId;

  /** Update date. */
  @Column(name = "autoDebitUpdateDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date autoDebitUpdateDate;

  /** Funding Object information, keep a copy from funding account. */
  @Embedded protected FundingInformation fundingInformation = new FundingInformation();

  /** TODO: DOCUMENT ME! */
  @Column(
      length           = 1,
      columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean historical = Boolean.FALSE;

  /** TODO: DOCUMENT ME! */
  @Column(
      name     = "nextPaymentDueDate",
      nullable = true
  )
  protected Date nextPaymentDueDate;

  /** responsible id. */
  @JoinColumn(
      name      = "responsibleId",
      updatable = false,
      nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Responsible responsible;

  /** TODO: DOCUMENT ME! */
  @Column(name = "startDate")
  protected Date startDate;

  /** payment channel. */
  @Column(
      name      = "status",
      nullable  = false,
      updatable = true,
      length    = 20
  )
  @Enumerated(EnumType.STRING)
  protected AutoDebitStatus status;

  /** TODO: DOCUMENT ME! */
  @Column(
      name     = "updatedFundingAccountId",
      nullable = true
  )
  protected Long updatedFundingAccountId;

  /** TODO: DOCUMENT ME! */
  @Column(
      name     = "updatedFundingAccountNum",
      length   = 80,
      nullable = true
  )
  @Convert(converter = StringEncryptionConverter.class)
  protected String updatedFundingAccountNum;

  /** holder full name. */
  @Column(
      name     = "updatedHolderFullName",
      length   = 102,
      nullable = true
  )
  protected String updatedHolderFullName;


  /** funding account routing number. */
  @Column(
      name   = "updatedRoutingNumber",
      length = 20
  )
  protected String updatedRoutingNumber;

  /** funding account sub type. */
  @Column(
      name   = "updatedSubType",
      length = 20
  )
  protected String updatedSubType;

  @Column(
      name      = "updatedAmount",
      nullable  = true,
      precision = 19,
      scale     = 2
  )
  protected BigDecimal updatedAmount;

  @Column(
      name   = "autoDebitType",
      nullable = true,
      length = 20
  )
  protected String autoDebitType;

  @Column(
      name   = "updatedAutoDebitType",
      nullable = true,
      length = 20
  )
  protected String updatedAutoDebitType;

  @Column(name = "updatedfirstPaymentEffectiveDate")
  protected Date updatedfirstPaymentEffectiveDate;

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

    AutoDebitDetail that = (AutoDebitDetail) o;

    if ((account != null) ? (!account.equals(that.account)) : (that.account != null)) {
      return false;
    }

    if ((amount != null) ? (!amount.equals(that.amount)) : (that.amount != null)) {
      return false;
    }

    if ((autoDebitEnrollment != null) ? (!autoDebitEnrollment.equals(that.autoDebitEnrollment))
        : (that.autoDebitEnrollment != null)) {
      return false;
    }

    if ((billingGroupId != null) ? (!billingGroupId.equals(that.billingGroupId)) : (that.billingGroupId != null)) {
      return false;
    }

    if (channel != that.channel) {
      return false;
    }

    if ((customer != null) ? (!customer.equals(that.customer)) : (that.customer != null)) {
      return false;
    }

    if ((endDate != null) ? (!endDate.equals(that.endDate)) : (that.endDate != null)) {
      return false;
    }

    if ((enrolledDate != null) ? (!enrolledDate.equals(that.enrolledDate)) : (that.enrolledDate != null)) {
      return false;
    }

    if ((fundingInformation != null) ? (!fundingInformation.equals(that.fundingInformation))
        : (that.fundingInformation != null)) {
      return false;
    }

    if ((historical != null) ? (!historical.equals(that.historical)) : (that.historical != null)) {
      return false;
    }

    if ((nextPaymentDueDate != null) ? (!nextPaymentDueDate.equals(that.nextPaymentDueDate))
        : (that.nextPaymentDueDate != null)) {
      return false;
    }

    if ((responsible != null) ? (!responsible.equals(that.responsible)) : (that.responsible != null)) {
      return false;
    }

    if ((startDate != null) ? (!startDate.equals(that.startDate)) : (that.startDate != null)) {
      return false;
    }

    return status == that.status;

  } // end method equals

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
   * getter method for amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getAmount() {
    return amount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for auto debit detail id.
   *
   * @return  Long
   */
  public Long getAutoDebitDetailId() {
    return autoDebitDetailId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for auto debit enrollment.
   *
   * @return  AutoDebitEnrollment
   */
  public AutoDebitEnrollment getAutoDebitEnrollment() {
    return autoDebitEnrollment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for auto debit status str.
   *
   * @return  String
   */
  public String getAutoDebitStatusStr() {
    return (this.status == null) ? "" : this.status.name();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for billing group id.
   *
   * @return  String
   */
  public String getBillingGroupId() {
    return billingGroupId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for cancel confirmation date.
   *
   * @return  Date
   */
  public Date getCancelConfirmationDate() {
    return cancelConfirmationDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for cancelled date.
   *
   * @return  Date
   */
  public Date getCancelledDate() {
    return cancelledDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for channel.
   *
   * @return  PaymentChannel
   */
  public PaymentChannel getChannel() {
    return channel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for customer.
   *
   * @return  Customer
   */
  public Customer getCustomer() {
    return customer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for day of month.
   *
   * @return  Integer
   */
  public Integer getDayOfMonth() {
    return dayOfMonth;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for day of week.
   *
   * @return  Integer
   */
  public Integer getDayOfWeek() {
    return dayOfWeek;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for end date.
   *
   * @return  Date
   */
  public Date getEndDate() {
    return endDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for enroll confirmation date.
   *
   * @return  Date
   */
  public Date getEnrollConfirmationDate() {
    return enrollConfirmationDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for enrolled date.
   *
   * @return  Date
   */
  public Date getEnrolledDate() {
    return enrolledDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for enrollment flag.
   *
   * @return  String
   */
  public String getEnrollmentFlag() {
    return enrollmentFlag;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for first payment effective date.
   *
   * @return  Date
   */
  public Date getFirstPaymentEffectiveDate() {
    return firstPaymentEffectiveDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for frequency.
   *
   * @return  Frequency
   */
  public Frequency getFrequency() {
    return frequency;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for funding account id.
   *
   * @return  Long
   */
  public Long getFundingAccountId() {
    return fundingAccountId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for funding account update date.
   *
   * @return  Date
   */
  public Date getAutoDebitUpdateDate() {
    return autoDebitUpdateDate;
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
   * getter method for historical.
   *
   * @return  Boolean
   */
  public Boolean getHistorical() {
    if (historical == null) {
      return Boolean.FALSE;
    }

    return historical;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for next payment due date.
   *
   * @return  Date
   */
  public Date getNextPaymentDueDate() {
    return nextPaymentDueDate;
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
   * getter method for start date.
   *
   * @return  Date
   */
  public Date getStartDate() {
    return startDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status.
   *
   * @return  AutoDebitStatus
   */
  public AutoDebitStatus getStatus() {
    return status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for updated funding account id.
   *
   * @return  Long
   */
  public Long getUpdatedFundingAccountId() {
    return updatedFundingAccountId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for updated funding account num.
   *
   * @return  String
   */
  public String getUpdatedFundingAccountNum() {
    return updatedFundingAccountNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for updated holder full name.
   *
   * @return  String
   */
  public String getUpdatedHolderFullName() {
    return updatedHolderFullName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for updated routing number.
   *
   * @return  String
   */
  public String getUpdatedRoutingNumber() {
    return updatedRoutingNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for updated sub type.
   *
   * @return  String
   */
  public String getUpdatedSubType() {
    return updatedSubType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for updated Amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getUpdatedAmount() {
    return updatedAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for auto debit type.
   *
   * @return  String
   */
  public String getAutoDebitType() {
    return autoDebitType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for udpated auto debit type.
   *
   * @return  String
   */
  public String getUpdatedAutoDebitType() {
    return updatedAutoDebitType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for Updated firstPaymentEffective date.
   *
   * @return  Date
   */
  public Date getUpdatedfirstPaymentEffectiveDate() {
    return updatedfirstPaymentEffectiveDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((account != null) ? account.hashCode() : 0);
    result = (31 * result) + ((amount != null) ? amount.hashCode() : 0);
    result = (31 * result) + ((autoDebitEnrollment != null) ? autoDebitEnrollment.hashCode() : 0);
    result = (31 * result) + ((billingGroupId != null) ? billingGroupId.hashCode() : 0);
    result = (31 * result) + ((channel != null) ? channel.hashCode() : 0);
    result = (31 * result) + ((customer != null) ? customer.hashCode() : 0);
    result = (31 * result) + ((endDate != null) ? endDate.hashCode() : 0);
    result = (31 * result) + ((enrolledDate != null) ? enrolledDate.hashCode() : 0);
    result = (31 * result) + ((fundingInformation != null) ? fundingInformation.hashCode() : 0);
    result = (31 * result) + ((historical != null) ? historical.hashCode() : 0);
    result = (31 * result) + ((nextPaymentDueDate != null) ? nextPaymentDueDate.hashCode() : 0);
    result = (31 * result) + ((responsible != null) ? responsible.hashCode() : 0);
    result = (31 * result) + ((startDate != null) ? startDate.hashCode() : 0);
    result = (31 * result) + ((status != null) ? status.hashCode() : 0);

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
   * setter method for amount.
   *
   * @param  amount  BigDecimal
   */
  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for auto debit detail id.
   *
   * @param  autoDebitDetailId  Long
   */
  public void setAutoDebitDetailId(Long autoDebitDetailId) {
    this.autoDebitDetailId = autoDebitDetailId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for auto debit enrollment.
   *
   * @param  autoDebitEnrollment  AutoDebitEnrollment
   */
  public void setAutoDebitEnrollment(AutoDebitEnrollment autoDebitEnrollment) {
    this.autoDebitEnrollment = autoDebitEnrollment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for billing group id.
   *
   * @param  billingGroupId  String
   */
  public void setBillingGroupId(String billingGroupId) {
    this.billingGroupId = billingGroupId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for cancel confirmation date.
   *
   * @param  cancelConfirmationDate  Date
   */
  public void setCancelConfirmationDate(Date cancelConfirmationDate) {
    this.cancelConfirmationDate = cancelConfirmationDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for cancelled date.
   *
   * @param  cancelledDate  Date
   */
  public void setCancelledDate(Date cancelledDate) {
    this.cancelledDate = cancelledDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for channel.
   *
   * @param  channel  PaymentChannel
   */
  public void setChannel(PaymentChannel channel) {
    this.channel = channel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for customer.
   *
   * @param  customer  Customer
   */
  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for day of month.
   *
   * @param  dayOfMonth  Integer
   */
  public void setDayOfMonth(Integer dayOfMonth) {
    this.dayOfMonth = dayOfMonth;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for day of week.
   *
   * @param  dayOfWeek  Integer
   */
  public void setDayOfWeek(Integer dayOfWeek) {
    this.dayOfWeek = dayOfWeek;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for end date.
   *
   * @param  endDate  Date
   */
  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for enroll confirmation date.
   *
   * @param  enrollConfirmationDate  Date
   */
  public void setEnrollConfirmationDate(Date enrollConfirmationDate) {
    this.enrollConfirmationDate = enrollConfirmationDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for enrolled date.
   *
   * @param  enrolledDate  Date
   */
  public void setEnrolledDate(Date enrolledDate) {
    this.enrolledDate = enrolledDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for enrollment flag.
   *
   * @param  enrollmentFlag  String
   */
  public void setEnrollmentFlag(String enrollmentFlag) {
    this.enrollmentFlag = enrollmentFlag;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for first payment effective date.
   *
   * @param  firstPaymentEffectiveDate  Date
   */
  public void setFirstPaymentEffectiveDate(Date firstPaymentEffectiveDate) {
    this.firstPaymentEffectiveDate = firstPaymentEffectiveDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for frequency.
   *
   * @param  frequency  Frequency
   */
  public void setFrequency(Frequency frequency) {
    this.frequency = frequency;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for funding account id.
   *
   * @param  fundingAccountId  Long
   */
  public void setFundingAccountId(Long fundingAccountId) {
    this.fundingAccountId = fundingAccountId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for autodebit update date.
   *
   * @param  autoDebitUpdateDate  Date
   */
  public void setAutoDebitUpdateDate(Date autoDebitUpdateDate) {
    this.autoDebitUpdateDate = autoDebitUpdateDate;
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
   * setter method for historical.
   *
   * @param  historical  Boolean
   */
  public void setHistorical(Boolean historical) {
    this.historical = historical;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for next payment due date.
   *
   * @param  nextPaymentDueDate  Date
   */
  public void setNextPaymentDueDate(Date nextPaymentDueDate) {
    this.nextPaymentDueDate = nextPaymentDueDate;
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
   * setter method for start date.
   *
   * @param  startDate  Date
   */
  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for status.
   *
   * @param  status  AutoDebitStatus
   */
  public void setStatus(AutoDebitStatus status) {
    this.status = status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for updated funding account id.
   *
   * @param  updatedFundingAccountId  Long
   */
  public void setUpdatedFundingAccountId(Long updatedFundingAccountId) {
    this.updatedFundingAccountId = updatedFundingAccountId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for updated funding account num.
   *
   * @param  updatedFundingAccountNum  String
   */
  public void setUpdatedFundingAccountNum(String updatedFundingAccountNum) {
    this.updatedFundingAccountNum = updatedFundingAccountNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for updated holder full name.
   *
   * @param  updatedHolderFullName  String
   */
  public void setUpdatedHolderFullName(String updatedHolderFullName) {
    this.updatedHolderFullName = updatedHolderFullName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for updated routing number.
   *
   * @param  updatedRoutingNumber  String
   */
  public void setUpdatedRoutingNumber(String updatedRoutingNumber) {
    this.updatedRoutingNumber = updatedRoutingNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for updated sub type.
   *
   * @param  updatedSubType  String
   */
  public void setUpdatedSubType(String updatedSubType) {
    this.updatedSubType = updatedSubType;
  }


  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for updated amount.
   *
   * @param  updatedAmount  BigDecimal
   */
  public void setUpdatedAmount(BigDecimal updatedAmount) {
    this.updatedAmount = updatedAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for auto debit type.
   *
   * @param  autoDebitType  String
   */
  public void setAutoDebitType(String autoDebitType) {
    this.autoDebitType = autoDebitType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for auto debit type.
   *
   * @param  updatedAutoDebitType  String
   */
  public void setUpdatedAutoDebitType(String updatedAutoDebitType) {
    this.updatedAutoDebitType = updatedAutoDebitType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  cancelConfirmationDate  DOCUMENT ME!
   */
  public void setUpdatedfirstPaymentEffectiveDate(Date updatedfirstPaymentEffectiveDate) {
    this.updatedfirstPaymentEffectiveDate = updatedfirstPaymentEffectiveDate;
  }

} // end class AutoDebitDetail
