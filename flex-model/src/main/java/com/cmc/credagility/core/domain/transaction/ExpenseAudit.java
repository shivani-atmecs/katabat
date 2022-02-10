package com.cmc.credagility.core.domain.transaction;

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
import com.cmc.credagility.core.domain.payment.AbstractExpense;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/15/2014 15:38
 */
@Entity
@Table(
  name              = "ExpenseAudit",
  uniqueConstraints = { @UniqueConstraint(columnNames = "expenseAuditId") }
)
public class ExpenseAudit extends AbstractExpense {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "expenseAuditId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long expenseAuditId;

  /** transaction type. */
  @Column(
    name     = "transactionType",
    nullable = true,
    length   = 17
  )
  protected String transactionType;

  @JoinColumn(
    name   = "accountNum",
    unique = true
  )
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
   * getter method for expense audit id.
   *
   * @return  Long
   */
  public Long getExpenseAuditId() {
    return expenseAuditId;
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
   * setter method for expense audit id.
   *
   * @param  expenseAuditId  Long
   */
  public void setExpenseAuditId(Long expenseAuditId) {
    this.expenseAuditId = expenseAuditId;
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
} // end class ExpenseAudit
