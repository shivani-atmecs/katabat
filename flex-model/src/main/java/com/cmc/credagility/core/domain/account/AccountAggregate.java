package com.cmc.credagility.core.domain.account;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:dongming.liao@ozstrategy.com">Dongming Liao</a>
 * @version  10/14/2014 16:40
 */
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="accountAggregateId", scope = AccountAggregate.class)
@Entity public class AccountAggregate extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 5862363270720673585L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Relations AccountAggregate AccountIndex : */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "accountAggregate",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  protected Set<AccountIndex> accountIndexes = new LinkedHashSet<AccountIndex>();


  @Column(
    name     = "accountAggregateId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long accountAggregateId;


  @Column(
    name      = "balance",
    nullable  = true,
    precision = 19,
    scale     = 2
  )
  private BigDecimal balance;

  @Column(name = "currentDue")
  private BigDecimal currentDue;

  @Column(name = "pastDue")
  private BigDecimal pastDue;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for account aggregate id.
   *
   * @return  Long
   */
  public Long getAccountAggregateId() {
    return accountAggregateId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account indexes.
   *
   * @return  Set
   */
  public Set<AccountIndex> getAccountIndexes() {
    return accountIndexes;
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
   * getter method for current due.
   *
   * @return  BigDecimal
   */
  public BigDecimal getCurrentDue() {
    return currentDue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for past due.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPastDue() {
    return pastDue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hasMRA.
   *
   * @return  Boolean
   */
  public Boolean hasMRA() {
    if ((accountIndexes != null) && (accountIndexes.size() > 1)) {
      return Boolean.TRUE;
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account aggregate id.
   *
   * @param  accountAggregateId  Long
   */
  public void setAccountAggregateId(Long accountAggregateId) {
    this.accountAggregateId = accountAggregateId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account indexes.
   *
   * @param  accountIndexes  Set
   */
  public void setAccountIndexes(Set<AccountIndex> accountIndexes) {
    this.accountIndexes = accountIndexes;
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
   * setter method for current due.
   *
   * @param  currentDue  BigDecimal
   */
  public void setCurrentDue(BigDecimal currentDue) {
    this.currentDue = currentDue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for past due.
   *
   * @param  pastDue  BigDecimal
   */
  public void setPastDue(BigDecimal pastDue) {
    this.pastDue = pastDue;
  }
} // end class AccountAggregate
