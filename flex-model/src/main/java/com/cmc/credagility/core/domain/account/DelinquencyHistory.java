package com.cmc.credagility.core.domain.account;

import java.io.Serializable;

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

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:dongming.liao@ozstrategy.com">Dongming Liao</a>
 * @version  10/16/2014 12:06
 */
@Entity
@Table(name = "DelinquencyHistory")
public class DelinquencyHistory extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -2937721421491854511L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "accountNum",
    insertable = true,
    updatable  = false,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Account account;


  /** TODO: DOCUMENT ME! */
  @Column(name = "autoReageNumber")
  protected Integer autoReageNumber;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "autoReageReason",
    length = 100
  )
  protected String autoReageReason;


  /** TODO: DOCUMENT ME! */
  @Column(name = "bucketOrder")
  protected Integer bucketOrder;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "accountDelinquentId", /* unique = true, */
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long delinquencyHistoryId;


  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean lateFeeReceivedAtCycle;


  /** TODO: DOCUMENT ME! */
  @Column(name = "levelAltPastDue")
  protected Integer levelAltPastDue;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "levelPastDue",
    length = 1
  )
  protected Character levelPastDue;


  /** TODO: DOCUMENT ME! */
  @Column(name = "manualReageNumber")
  protected Integer manualReageNumber;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "manualReageReason",
    length = 100
  )
  protected String manualReageReason;


  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean overLimitFeeReceivedAtCycle;

  //~ Methods ----------------------------------------------------------------------------------------------------------

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
   * getter method for auto reage number.
   *
   * @return  Integer
   */
  public Integer getAutoReageNumber() {
    return autoReageNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for auto reage reason.
   *
   * @return  String
   */
  public String getAutoReageReason() {
    return autoReageReason;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bucket order.
   *
   * @return  Integer
   */
  public Integer getBucketOrder() {
    return bucketOrder;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for delinquency history id.
   *
   * @return  Long
   */
  public Long getDelinquencyHistoryId() {
    return delinquencyHistoryId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for late fee received at cycle.
   *
   * @return  Boolean
   */
  public Boolean getLateFeeReceivedAtCycle() {
    return lateFeeReceivedAtCycle;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for level alt past due.
   *
   * @return  Integer
   */
  public Integer getLevelAltPastDue() {
    return levelAltPastDue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for level past due.
   *
   * @return  Character
   */
  public Character getLevelPastDue() {
    return levelPastDue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for manual reage number.
   *
   * @return  Integer
   */
  public Integer getManualReageNumber() {
    return manualReageNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for manual reage reason.
   *
   * @return  String
   */
  public String getManualReageReason() {
    return manualReageReason;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for over limit fee received at cycle.
   *
   * @return  Boolean
   */
  public Boolean getOverLimitFeeReceivedAtCycle() {
    return overLimitFeeReceivedAtCycle;
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
   * setter method for auto reage number.
   *
   * @param  autoReageNumber  Integer
   */
  public void setAutoReageNumber(Integer autoReageNumber) {
    this.autoReageNumber = autoReageNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for auto reage reason.
   *
   * @param  autoReageReason  String
   */
  public void setAutoReageReason(String autoReageReason) {
    this.autoReageReason = autoReageReason;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bucket order.
   *
   * @param  bucketOrder  Integer
   */
  public void setBucketOrder(Integer bucketOrder) {
    this.bucketOrder = bucketOrder;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for delinquency history id.
   *
   * @param  delinquencyHistoryId  Long
   */
  public void setDelinquencyHistoryId(Long delinquencyHistoryId) {
    this.delinquencyHistoryId = delinquencyHistoryId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for late fee received at cycle.
   *
   * @param  lateFeeReceivedAtCycle  Boolean
   */
  public void setLateFeeReceivedAtCycle(Boolean lateFeeReceivedAtCycle) {
    this.lateFeeReceivedAtCycle = lateFeeReceivedAtCycle;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for level alt past due.
   *
   * @param  levelAltPastDue  Integer
   */
  public void setLevelAltPastDue(Integer levelAltPastDue) {
    this.levelAltPastDue = levelAltPastDue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for level past due.
   *
   * @param  levelPastDue  Character
   */
  public void setLevelPastDue(Character levelPastDue) {
    this.levelPastDue = levelPastDue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for manual reage number.
   *
   * @param  manualReageNumber  Integer
   */
  public void setManualReageNumber(Integer manualReageNumber) {
    this.manualReageNumber = manualReageNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for manual reage reason.
   *
   * @param  manualReageReason  String
   */
  public void setManualReageReason(String manualReageReason) {
    this.manualReageReason = manualReageReason;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for over limit fee received at cycle.
   *
   * @param  overLimitFeeReceivedAtCycle  Boolean
   */
  public void setOverLimitFeeReceivedAtCycle(Boolean overLimitFeeReceivedAtCycle) {
    this.overLimitFeeReceivedAtCycle = overLimitFeeReceivedAtCycle;
  }
} // end class DelinquencyHistory
