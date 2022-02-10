package com.cmc.credagility.core.domain.program;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.payment.Payment;
import com.cmc.credagility.core.domain.payment.PaymentProgram;
import com.cmc.credagility.core.domain.payment.PaymentProgramInstallment;
import com.cmc.credagility.core.domain.type.InstallmentStatus;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/15/2014 10:31
 */
@Entity
@Table(name = "ProgramEnrollmentAudit")
public class ProgramEnrollmentAudit extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 1054116564364471800L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "installmentId",
    insertable = true,
    updatable  = false
  )
  @ManyToOne protected PaymentProgramInstallment installment;

  /** TODO: DOCUMENT ME! */
  protected BigDecimal installmentAmount;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "installmentStatus",
    length = 25
  )
  @Enumerated(value = EnumType.STRING)
  protected InstallmentStatus installmentStatus;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "paymentId",
    insertable = true,
    updatable  = false
  )
  @ManyToOne protected Payment payment;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "programId",
    insertable = true,
    updatable  = false
  )
  @ManyToOne protected PaymentProgram program;

  /** TODO: DOCUMENT ME! */
  protected BigDecimal receivedAmount;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new ProgramEnrollmentAudit object.
   */
  public ProgramEnrollmentAudit() { }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    ProgramEnrollmentAudit that = (ProgramEnrollmentAudit) o;

    if ((installment != null) ? (!installment.equals(that.installment)) : (that.installment != null)) {
      return false;
    }

    if ((installmentAmount != null) ? (!installmentAmount.equals(that.installmentAmount))
                                    : (that.installmentAmount != null)) {
      return false;
    }

    if ((installmentStatus != null) ? (!installmentStatus.equals(that.installmentStatus))
                                    : (that.installmentStatus != null)) {
      return false;
    }

    if ((payment != null) ? (!payment.equals(that.payment)) : (that.payment != null)) {
      return false;
    }

    if ((program != null) ? (!program.equals(that.program)) : (that.program != null)) {
      return false;
    }

    if ((receivedAmount != null) ? (!receivedAmount.equals(that.receivedAmount)) : (that.receivedAmount != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for id.
   *
   * @return  Long
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for installment.
   *
   * @return  PaymentProgramInstallment
   */
  public PaymentProgramInstallment getInstallment() {
    return installment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for installment amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getInstallmentAmount() {
    return installmentAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for installment status.
   *
   * @return  InstallmentStatus
   */
  public InstallmentStatus getInstallmentStatus() {
    return installmentStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment.
   *
   * @return  Payment
   */
  public Payment getPayment() {
    return payment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for program.
   *
   * @return  PaymentProgram
   */
  public PaymentProgram getProgram() {
    return program;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for received amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getReceivedAmount() {
    return receivedAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = 31;
    result = (31 * result) + ((installment != null) ? installment.hashCode() : 0);
    result = (31 * result) + ((installmentAmount != null) ? installmentAmount.hashCode() : 0);
    result = (31 * result) + ((installmentStatus != null) ? installmentStatus.hashCode() : 0);
    result = (31 * result) + ((payment != null) ? payment.hashCode() : 0);
    result = (31 * result) + ((program != null) ? program.hashCode() : 0);
    result = (31 * result) + ((receivedAmount != null) ? receivedAmount.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for id.
   *
   * @param  id  Long
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for installment.
   *
   * @param  installment  PaymentProgramInstallment
   */
  public void setInstallment(PaymentProgramInstallment installment) {
    this.installment = installment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for installment amount.
   *
   * @param  installmentAmount  BigDecimal
   */
  public void setInstallmentAmount(BigDecimal installmentAmount) {
    this.installmentAmount = installmentAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for installment status.
   *
   * @param  installmentStatus  InstallmentStatus
   */
  public void setInstallmentStatus(InstallmentStatus installmentStatus) {
    this.installmentStatus = installmentStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for payment.
   *
   * @param  payment  Payment
   */
  public void setPayment(Payment payment) {
    this.payment = payment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for program.
   *
   * @param  program  PaymentProgram
   */
  public void setProgram(PaymentProgram program) {
    this.program = program;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for received amount.
   *
   * @param  receivedAmount  BigDecimal
   */
  public void setReceivedAmount(BigDecimal receivedAmount) {
    this.receivedAmount = receivedAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#toString()
   */
  @Override public String toString() {
    return "ProgramEnrollment{"
      + "id=" + id
      + ", installment=" + installment
      + ", installmentAmount=" + installmentAmount
      + ", installmentStatus='" + installmentStatus + '\''
      + ", payment=" + payment
      + ", program=" + program
      + ", receivedAmount=" + receivedAmount
      + '}';
  }
} // end class ProgramEnrollmentAudit
