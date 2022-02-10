package com.cmc.credagility.core.domain.tsys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/16/2014 09:33
 */
@Entity
@Table(name = "TsysPaymentHistory")
public class TsysPaymentHistory extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -1388768396403108469L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "nsfReturns",
    length = 50
  )
  protected String nsfReturns;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "overLimitCategory",
    length = 50
  )
  protected String overLimitCategory;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "pastDueCategory",
    length = 50
  )
  protected String pastDueCategory;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "paymentStatus",
    length = 50
  )
  protected String paymentStatus;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "sequenceNumber",
    length = 50
  )
  protected String sequenceNumber;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "skipPayment",
    length = 50
  )
  protected String skipPayment;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "tsysAccountId",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected TsysAccount tsysAccount;


  /** Document PK. */
  @Column(
    unique   = true,
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long tsysPaymentHistoryId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for nsf returns.
   *
   * @return  String
   */
  public String getNsfReturns() {
    return nsfReturns;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for over limit category.
   *
   * @return  String
   */
  public String getOverLimitCategory() {
    return overLimitCategory;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for past due category.
   *
   * @return  String
   */
  public String getPastDueCategory() {
    return pastDueCategory;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment status.
   *
   * @return  String
   */
  public String getPaymentStatus() {
    return paymentStatus;
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
   * getter method for skip payment.
   *
   * @return  String
   */
  public String getSkipPayment() {
    return skipPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for tsys account.
   *
   * @return  TsysAccount
   */
  public TsysAccount getTsysAccount() {
    return tsysAccount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for tsys payment history id.
   *
   * @return  Long
   */
  public Long getTsysPaymentHistoryId() {
    return tsysPaymentHistoryId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((tsysPaymentHistoryId != null) ? tsysPaymentHistoryId.hashCode() : 0);
    result = (31 * result) + ((tsysAccount != null) ? tsysAccount.hashCode() : 0);
    result = (31 * result) + ((sequenceNumber != null) ? sequenceNumber.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for nsf returns.
   *
   * @param  nsfReturns  String
   */
  public void setNsfReturns(String nsfReturns) {
    this.nsfReturns = nsfReturns;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for over limit category.
   *
   * @param  overLimitCategory  String
   */
  public void setOverLimitCategory(String overLimitCategory) {
    this.overLimitCategory = overLimitCategory;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for past due category.
   *
   * @param  pastDueCategory  String
   */
  public void setPastDueCategory(String pastDueCategory) {
    this.pastDueCategory = pastDueCategory;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for payment status.
   *
   * @param  paymentStatus  String
   */
  public void setPaymentStatus(String paymentStatus) {
    this.paymentStatus = paymentStatus;
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
   * setter method for skip payment.
   *
   * @param  skipPayment  String
   */
  public void setSkipPayment(String skipPayment) {
    this.skipPayment = skipPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for tsys account.
   *
   * @param  tsysAccount  TsysAccount
   */
  public void setTsysAccount(TsysAccount tsysAccount) {
    this.tsysAccount = tsysAccount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for tsys payment history id.
   *
   * @param  tsysPaymentHistoryId  Long
   */
  public void setTsysPaymentHistoryId(Long tsysPaymentHistoryId) {
    this.tsysPaymentHistoryId = tsysPaymentHistoryId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("TsysPaymentHistory");
    sb.append("{tsysPaymentHistoryId=").append(tsysPaymentHistoryId).append("   ");
    sb.append(", sequenceNumber=").append(sequenceNumber);
    sb.append('}');

    return sb.toString();
  }
} // end class TsysPaymentHistory
