package com.cmc.credagility.core.domain.account;

import java.io.Serializable;

import java.math.BigDecimal;

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
 * SPReportHistory.java maintains a set of account statuses for each account. It supports Active / Inactive account
 * status
 *
 * @author   <a href="mailto:dongming.liao@ozstrategy.com">Dongming Liao</a>
 * @version  10/16/2014 14:23
 */
@Entity
@Table(name = "SPReportHistory")
public class SPReportHistory extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -3697553699586323296L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "accountNum",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Account account;


  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean accountActive = Boolean.TRUE;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "accountProfileCode",
    length = 2
  )
  protected String accountProfileCode;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "accountType",
    length = 12
  )
  protected String accountType;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "electricity",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal electricity;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "gas",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal gas;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "liveOrFinal",
    length = 1
  )
  protected String liveOrFinal;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "spReportHistoryId",

    // unique = true,
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long spReportHistoryId;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new $class.name$ object.
   */
  public SPReportHistory() { }

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
   * getter method for account active.
   *
   * @return  Boolean
   */
  public Boolean getAccountActive() {
    return accountActive;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account profile code.
   *
   * @return  String
   */
  public String getAccountProfileCode() {
    return accountProfileCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account type.
   *
   * @return  String
   */
  public String getAccountType() {
    return accountType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for electricity.
   *
   * @return  BigDecimal
   */
  public BigDecimal getElectricity() {
    return electricity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for gas.
   *
   * @return  BigDecimal
   */
  public BigDecimal getGas() {
    return gas;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for live or final.
   *
   * @return  String
   */
  public String getLiveOrFinal() {
    return liveOrFinal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for sp report history id.
   *
   * @return  Long
   */
  public Long getSpReportHistoryId() {
    return spReportHistoryId;
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
   * setter method for account active.
   *
   * @param  accountActive  Boolean
   */
  public void setAccountActive(Boolean accountActive) {
    this.accountActive = accountActive;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account profile code.
   *
   * @param  accountProfileCode  String
   */
  public void setAccountProfileCode(String accountProfileCode) {
    this.accountProfileCode = accountProfileCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account type.
   *
   * @param  accountType  String
   */
  public void setAccountType(String accountType) {
    this.accountType = accountType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for electricity.
   *
   * @param  electricity  BigDecimal
   */
  public void setElectricity(BigDecimal electricity) {
    this.electricity = electricity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for gas.
   *
   * @param  gas  BigDecimal
   */
  public void setGas(BigDecimal gas) {
    this.gas = gas;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for live or final.
   *
   * @param  liveOrFinal  String
   */
  public void setLiveOrFinal(String liveOrFinal) {
    this.liveOrFinal = liveOrFinal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for sp report history id.
   *
   * @param  spReportHistoryId  Long
   */
  public void setSpReportHistoryId(Long spReportHistoryId) {
    this.spReportHistoryId = spReportHistoryId;
  }
} // end class SPReportHistory
