package com.cmc.credagility.core.domain.tsys;

import java.io.Serializable;

import java.util.Date;

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
 * @version  10/16/2014 09:35
 */
@Entity
@Table(name = "TsysPromiseToPayHistory")
public class TsysPromiseToPayHistory extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -1383684402033768627L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "lastPTPCollector",
    length = 100
  )
  protected String lastPTPCollector;


  /** TODO: DOCUMENT ME! */
  @Column(name = "ptpDateTaken")
  protected Date ptpDateTaken;


  /** TODO: DOCUMENT ME! */
  @Column(name = "ptpDueDate")
  protected Date ptpDueDate;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "ptpPendingAmount",
    length = 50
  )
  protected String ptpPendingAmount;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "sequenceNumber",
    length = 50
  )
  protected String sequenceNumber;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "tsysAccountId",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected TsysAccount tsysAccount;


  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long tsysPromiseToPayHistoryId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for last PTPCollector.
   *
   * @return  String
   */
  public String getLastPTPCollector() {
    return lastPTPCollector;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ptp date taken.
   *
   * @return  Date
   */
  public Date getPtpDateTaken() {
    return ptpDateTaken;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ptp due date.
   *
   * @return  Date
   */
  public Date getPtpDueDate() {
    return ptpDueDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ptp pending amount.
   *
   * @return  String
   */
  public String getPtpPendingAmount() {
    return ptpPendingAmount;
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
   * getter method for tsys account.
   *
   * @return  TsysAccount
   */
  public TsysAccount getTsysAccount() {
    return tsysAccount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for tsys promise to pay history id.
   *
   * @return  Long
   */
  public Long getTsysPromiseToPayHistoryId() {
    return tsysPromiseToPayHistoryId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((tsysPromiseToPayHistoryId != null) ? tsysPromiseToPayHistoryId.hashCode() : 0);
    result = (31 * result) + ((tsysAccount != null) ? tsysAccount.hashCode() : 0);
    result = (31 * result) + ((sequenceNumber != null) ? sequenceNumber.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last PTPCollector.
   *
   * @param  lastPTPCollector  String
   */
  public void setLastPTPCollector(String lastPTPCollector) {
    this.lastPTPCollector = lastPTPCollector;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ptp date taken.
   *
   * @param  ptpDateTaken  Date
   */
  public void setPtpDateTaken(Date ptpDateTaken) {
    this.ptpDateTaken = ptpDateTaken;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ptp due date.
   *
   * @param  ptpDueDate  Date
   */
  public void setPtpDueDate(Date ptpDueDate) {
    this.ptpDueDate = ptpDueDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ptp pending amount.
   *
   * @param  ptpPendingAmount  String
   */
  public void setPtpPendingAmount(String ptpPendingAmount) {
    this.ptpPendingAmount = ptpPendingAmount;
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
   * setter method for tsys account.
   *
   * @param  tsysAccount  TsysAccount
   */
  public void setTsysAccount(TsysAccount tsysAccount) {
    this.tsysAccount = tsysAccount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for tsys promise to pay history id.
   *
   * @param  tsysPromiseToPayHistoryId  Long
   */
  public void setTsysPromiseToPayHistoryId(Long tsysPromiseToPayHistoryId) {
    this.tsysPromiseToPayHistoryId = tsysPromiseToPayHistoryId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("TsysPromiseToPayHistory");
    sb.append("{tsysPromiseToPayHistoryId=").append(tsysPromiseToPayHistoryId).append("   ");
    sb.append(", sequenceNumber=").append(sequenceNumber);
    sb.append('}');

    return sb.toString();
  }
} // end class TsysPromiseToPayHistory
