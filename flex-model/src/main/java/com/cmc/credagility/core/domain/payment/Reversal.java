package com.cmc.credagility.core.domain.payment;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;
import com.cmc.credagility.core.jpa.converter.StringEncryptionConverter;


/**
 * This class is used to represent a ITS Reversal.
 *
 * <p><a href="Reversal.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 *
 *           <p>table = "Reversal"</p>
 * @version  $Revision$, $Date$
 */
@Entity
@Table(name = "Reversal")
public class Reversal extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 1L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Account number which account in use. */
  @JoinColumn(
    name      = "accountNum",
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Account account;

  /** Responsible Id which responsible in use. */
  @JoinColumn(
    name      = "responsibleId",
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Responsible responsible;

  /** Amount Debited from Client : Always the same as the above "Amount Paid" field */
  @Column(
    name     = "amountDebit",
    nullable = false
  )
  private BigDecimal amountDebit;

  /** Amount Paid - . $100 All or nothing: If customer paid $100, then it should b $100. */
  @Column(
    name     = "amountPaid",
    nullable = false
  )
  private BigDecimal amountPaid;

  /** ITS Tracking Number . transfication_id returned by PayMyBill */
  @Column(
    name     = "authCode",
    nullable = false,
    length   = 20
  )
  private String authCode;

  @Column(
    name   = "bankCode",
    length = 20
  )
  private String bankCode;

  /** Special Charges to Client : Additional charges for CMC is $1.50 per presentment */
  @Column(name = "clientCharges")
  private BigDecimal clientCharges;

  /** 1st Presentment Date : when transaction was first preneted to th back */
  @Column(name = "firstPresentmentDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date firstPresentmentDate;

  @Column(
    name   = "fundingAccountNumber",
    length = 80
  )
// @Convert(converter = StringEncryptionConverter.class)
  private String fundingAccountNumber;

  /** Method of Payment . Check Currently no Credit or Debit, */
  @Column(
    name   = "paymentMethod",
    length = 20
  )
  private String paymentMethod;

  /** Presentment Counter: counter, first presentment is 1 */
  @Column(name = "presentmentCounter")
  private Integer presentmentCounter;

  @Column(name = "rejectionDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date rejectionDate;


// npelleti, 07/30, USBank, Removed unique constraint
  @Column(
    name     = "reversalId",

    // unique   = true,
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long reversalId;

  /** Whether this reversal record is used as a reason to reject a payment. */
  @Column(
    name             = "reversed",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean reversed;

  /** Status : founded - nsf, unfounded-nsf, etc. */
  @Column(
    name     = "status",
    nullable = false,
    length   = 255
  )
  private String status;

  /** Check Uncollectible Reason : Text reason. Could be something like "invalid routing #" etc. */
  @Column(
    name   = "uncollectibleReason",
    length = 1024
  )
  private String uncollectibleReason;

  /** Client's Tracking Number CMC customer user logon. */
  @Column(
    name   = "userLogon",
    length = 20
  )
  private String userLogon;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#equals(java.lang.Object)
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

    Reversal other = (Reversal) obj;

    if (authCode == null) {
      if (other.authCode != null) {
        return false;
      }
    } else if (!authCode.equals(other.authCode)) {
      return false;
    }

    if (clientCharges == null) {
      if (other.clientCharges != null) {
        return false;
      }
    } else if (!clientCharges.equals(other.clientCharges)) {
      return false;
    }

    if (amountDebit == null) {
      if (other.amountDebit != null) {
        return false;
      }
    } else if (!amountDebit.equals(other.amountDebit)) {
      return false;
    }

    if (firstPresentmentDate == null) {
      if (other.firstPresentmentDate != null) {
        return false;
      }
    } else if (!firstPresentmentDate.equals(other.firstPresentmentDate)) {
      return false;
    }

    if (amountPaid == null) {
      if (other.amountPaid != null) {
        return false;
      }
    } else if (!amountPaid.equals(other.amountPaid)) {
      return false;
    }

    if (paymentMethod == null) {
      if (other.paymentMethod != null) {
        return false;
      }
    } else if (!paymentMethod.equals(other.paymentMethod)) {
      return false;
    }

    if (presentmentCounter == null) {
      if (other.presentmentCounter != null) {
        return false;
      }
    } else if (!presentmentCounter.equals(other.presentmentCounter)) {
      return false;
    }

    if (status == null) {
      if (other.status != null) {
        return false;
      }
    } else if (!status.equals(other.status)) {
      return false;
    }

    if (uncollectibleReason == null) {
      if (other.uncollectibleReason != null) {
        return false;
      }
    } else if (!uncollectibleReason.equals(other.uncollectibleReason)) {
      return false;
    }

    if (userLogon == null) {
      if (other.userLogon != null) {
        return false;
      }
    } else if (!userLogon.equals(other.userLogon)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Account getAccount() {
    return account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The amountDebit.
   *
   * @return  the amountDebit
   *
   *          <p>not-null = "true"</p>
   */
  public BigDecimal getAmountDebit() {
    return amountDebit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The amountPaid.
   *
   * @return  the amountPaid
   *
   *          <p>not-null = "true"</p>
   */
  public BigDecimal getAmountPaid() {
    return amountPaid;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The authCode.
   *
   * @return  the authCode
   *
   *          <p>length = "20" not-null = "true"</p>
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
  public String getBankCode() {
    return bankCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientCharges.
   *
   * @return  the clientCharges
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getClientCharges() {
    return clientCharges;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The firstPresentmentDate.
   *
   * @return  the firstPresentmentDate
   */
  public Date getFirstPresentmentDate() {
    return firstPresentmentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getFundingAccountNumber() {
    return fundingAccountNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The paymentMethod.
   *
   * @return  the paymentMethod
   *
   *          <p>length = "20" not-null = "true"</p>
   */
  public String getPaymentMethod() {
    return paymentMethod;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The presentmentCounter.
   *
   * @return  the presentmentCounter
   */
  public Integer getPresentmentCounter() {
    return presentmentCounter;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getRejectionDate() {
    return rejectionDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Responsible getResponsible() {
    return responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The reversalId.
   *
   * @return  the reversalId
   *
   *          <p>generator-class = "native" unsaved-value = "null"</p>
   */
  public Long getReversalId() {
    return reversalId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   *          <p>type = "yes_no"</p>
   */
  public Boolean getReversed() {
    return reversed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The status.
   *
   * @return  the status
   *
   *          <p>length = "255" not-null = "true"</p>
   */
  public String getStatus() {
    return status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The uncollectibleReason.
   *
   * @return  the uncollectibleReason
   *
   *          <p>length = "256" not-null = "false"</p>
   */
  public String getUncollectibleReason() {
    return uncollectibleReason;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The userLogon.
   *
   * @return  the userLogon
   *
   *          <p>length = "20" not-null = "true"</p>
   */
  public String getUserLogon() {
    return userLogon;
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
    result = (prime * result) + ((authCode == null) ? 0 : authCode.hashCode());
    result = (prime * result)
      + ((clientCharges == null) ? 0 : clientCharges.hashCode());
    result = (prime * result)
      + ((amountDebit == null) ? 0 : amountDebit.hashCode());
    result = (prime
        * result)
      + ((firstPresentmentDate == null) ? 0 : firstPresentmentDate.hashCode());
    result = (prime * result)
      + ((amountPaid == null) ? 0 : amountPaid.hashCode());
    result = (prime * result)
      + ((paymentMethod == null) ? 0 : paymentMethod.hashCode());
    result = (prime * result)
      + ((presentmentCounter == null) ? 0 : presentmentCounter.hashCode());
    result = (prime * result) + ((status == null) ? 0 : status.hashCode());
    result = (prime * result)
      + ((uncollectibleReason == null) ? 0 : uncollectibleReason.hashCode());
    result = (prime * result) + ((userLogon == null) ? 0 : userLogon.hashCode());

    return result;
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
   * DOCUMENT ME!
   *
   * @param  debitedAmount  amountDebit the amountDebit to set
   */
  public void setAmountDebit(BigDecimal debitedAmount) {
    this.amountDebit = debitedAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paidAmount  amountPaid the amountPaid to set
   */
  public void setAmountPaid(BigDecimal paidAmount) {
    this.amountPaid = paidAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  itsTrackingNumber  authCode the authCode to set
   */
  public void setAuthCode(String itsTrackingNumber) {
    this.authCode = itsTrackingNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  bankCode  DOCUMENT ME!
   */
  public void setBankCode(String bankCode) {
    this.bankCode = bankCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  specialCharges  DOCUMENT ME! the clientCharges to set
   */
  public void setClientCharges(BigDecimal specialCharges) {
    this.clientCharges = specialCharges;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  firstPresentmentDate  the firstPresentmentDate to set
   */
  public void setFirstPresentmentDate(Date firstPresentmentDate) {
    this.firstPresentmentDate = firstPresentmentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  fundingAccountNumber  DOCUMENT ME!
   */
  public void setFundingAccountNumber(String fundingAccountNumber) {
    this.fundingAccountNumber = fundingAccountNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentMethod  the paymentMethod to set
   */
  public void setPaymentMethod(String paymentMethod) {
    this.paymentMethod = paymentMethod;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  presentmentCounter  the presentmentCounter to set
   */
  public void setPresentmentCounter(Integer presentmentCounter) {
    this.presentmentCounter = presentmentCounter;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  rejectionDate  DOCUMENT ME!
   */
  public void setRejectionDate(Date rejectionDate) {
    this.rejectionDate = rejectionDate;
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
   * @param  reversalId  the reversalId to set
   */
  public void setReversalId(Long reversalId) {
    this.reversalId = reversalId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  reversed  DOCUMENT ME!
   */
  public void setReversed(Boolean reversed) {
    this.reversed = reversed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  status  the status to set
   */
  public void setStatus(String status) {
    this.status = status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  uncollectibleReason  the uncollectibleReason to set
   */
  public void setUncollectibleReason(String uncollectibleReason) {
    this.uncollectibleReason = uncollectibleReason;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  userLogon  the userLogon to set
   */
  public void setUserLogon(String userLogon) {
    this.userLogon = userLogon;
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

    retValue.append("Reversal ( ").append(super.toString()).append(TAB).append(
      "authCode = ").append(this.authCode).append(TAB).append(
      "clientCharges = ").append(this.clientCharges).append(TAB).append(
      "amountDebit = ").append(this.amountDebit).append(TAB).append(
      "firstPresentmentDate = ").append(this.firstPresentmentDate).append(TAB).append("amountPaid = ").append(
      this.amountPaid).append(TAB).append("paymentMethod = ").append(this.paymentMethod).append(TAB).append(
      "presentmentCounter = ").append(
      this.presentmentCounter).append(TAB).append("reversalId = ").append(this.reversalId).append(TAB).append(
      "status = ").append(
      this.status).append(TAB).append("uncollectibleReason = ").append(
      this.uncollectibleReason).append(TAB).append("userLogon = ").append(this.userLogon).append(TAB).append(" )");

    return retValue.toString();
  }
} // end class Reversal
