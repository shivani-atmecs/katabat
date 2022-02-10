package com.cmc.credagility.core.domain.income;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.cmc.credagility.core.domain.account.Account;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:pan.kang@ozstrategy.com">Pan Kang</a>
 * @version  10/14/2014 16:19
 */
@Entity
@Table(
  name              = "IncomeAudit",
  uniqueConstraints = {
    @UniqueConstraint(columnNames = "incomeAuditId"),
    @UniqueConstraint(columnNames = { "accountNum", "borrowerPosition" })
  }
)
public class IncomeAudit extends AbstractIncome {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "incomeAuditId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long incomeAuditId;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "transactionType",
    nullable = true,
    length   = 17
  )
  protected String transactionType;


  @JoinColumn(name = "accountNum")
  @ManyToOne private Account account;

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
   * getter method for income audit id.
   *
   * @return  Long
   */
  public Long getIncomeAuditId() {
    return incomeAuditId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for transaction type.
   *
   * @return  String
   */
  public String getTransactionType() {
    return transactionType;
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
   * setter method for income audit id.
   *
   * @param  incomeAuditId  Long
   */
  public void setIncomeAuditId(Long incomeAuditId) {
    this.incomeAuditId = incomeAuditId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for transaction type.
   *
   * @param  transactionType  String
   */
  public void setTransactionType(String transactionType) {
    this.transactionType = transactionType;
  }
} // end class IncomeAudit
