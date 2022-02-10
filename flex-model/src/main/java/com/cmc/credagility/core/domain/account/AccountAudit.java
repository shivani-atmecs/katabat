package com.cmc.credagility.core.domain.account;

import java.io.Serializable;

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

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:dongming.liao@ozstrategy.com">Dongming Liao</a>
 * @version  10/14/2014 16:47
 */
@Entity
@Table(name = "AccountAudit")
public class AccountAudit extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 5451069430435415443L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @JoinColumn(
    name      = "accountNum",
    nullable  = false,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private Account account;

  @Column(name = "accountAuditId")
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long accountAuditId;

  @Column(
    name             = "active",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean active;

  @Column(
    name      = "balance",
    nullable  = true,
    precision = 19,
    scale     = 2
  )
  private BigDecimal balance;

  @Column(name = "delinquencyDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date delinquencyDate;

  /** Days past due, delinquency days. */
  @Column(name = "delinquencyDays")
  private Integer delinquencyDays;

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
   * getter method for account audit id.
   *
   * @return  Long
   */
  public Long getAccountAuditId() {
    return accountAuditId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for active.
   *
   * @return  Boolean
   */
  public Boolean getActive() {
    return active;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for balance.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBalance() {
    return balance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for delinquency date.
   *
   * @return  Date
   */
  public Date getDelinquencyDate() {
    return delinquencyDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for delinquency days.
   *
   * @return  Integer
   */
  public Integer getDelinquencyDays() {
    return delinquencyDays;
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
   * setter method for account audit id.
   *
   * @param  accountAuditId  Long
   */
  public void setAccountAuditId(Long accountAuditId) {
    this.accountAuditId = accountAuditId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for active.
   *
   * @param  active  Boolean
   */
  public void setActive(Boolean active) {
    this.active = active;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for balance.
   *
   * @param  balance  BigDecimal
   */
  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for delinquency date.
   *
   * @param  delinquencyDate  Date
   */
  public void setDelinquencyDate(Date delinquencyDate) {
    this.delinquencyDate = delinquencyDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for delinquency days.
   *
   * @param  delinquencyDays  Integer
   */
  public void setDelinquencyDays(Integer delinquencyDays) {
    this.delinquencyDays = delinquencyDays;
  }
} // end class AccountAudit
