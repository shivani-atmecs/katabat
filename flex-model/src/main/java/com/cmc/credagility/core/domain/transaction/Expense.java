package com.cmc.credagility.core.domain.transaction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.payment.AbstractExpense;
import com.cmc.credagility.core.domain.responsible.Responsible;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/15/2014 15:37
 */
@Entity
@Table(
  name              = "Expense",
  uniqueConstraints = { @UniqueConstraint(columnNames = "expenseId") }
)
public class Expense extends AbstractExpense {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** account number. */
  @JoinColumn(
    name       = "accountNum",
    insertable = true,
    updatable  = false,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Account account;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "expenseId", /*unique = true,*/
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long expenseId;

  /** responsible Id. */
  @JoinColumn(
    name       = "responsibleId",
    insertable = true,
    updatable  = false,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Responsible responsible;

  /** transaction type. */
  @Column(
    name     = "transactionType",
    nullable = false,
    length   = 17
  )
  protected String transactionType;

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
   * getter method for expense id.
   *
   * @return  Long
   */
  public Long getExpenseId() {
    return expenseId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible.
   *
   * @return  Responsible
   */
  public Responsible getResponsible() {
    return responsible;
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
   * getter method for expense filled.
   *
   * @return  boolean
   */
  public boolean isExpenseFilled() {
    return (this.getFirstMortgage() != null) || (this.getSecondMortgage() != null)
      || (this.getPropertyTaxes() != null)
      || (this.getPropertyInsurance() != null)
      || (this.getOtherLoanPayments() != null) || (this.getOtherLiens() != null)
      || (this.getOtherPropPayments() != null)
      || (this.getAutoPayments() != null) || (this.getAutoFuelRepairs() != null)
      || (this.getAutoInsurance() != null)
      || (this.getTotalCreditCardPayments() != null)
      || (this.getChildCareTuition() != null)
      || (this.getChildSupportAlimony() != null) || (this.getFood() != null)
      || (this.getUtilities() != null) || (this.getTelephone() != null)
      || (this.getHoaDues() != null) || (this.getMedical() != null)
      || (this.getCableTV() != null) || (this.getCellPhone() != null)
      || (this.getInternet() != null) || (this.getPayrollDeductionLoan() != null)
      || (this.getOtherAmount1() != null) || (this.getOtherAmount2() != null)
      || (this.getOtherAmount3() != null) || (this.getOtherAmount4() != null)
      || (this.getOtherAmount5() != null) || (this.getOtherAmount6() != null);
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
   * setter method for expense id.
   *
   * @param  expenseId  Long
   */
  public void setExpenseId(Long expenseId) {
    this.expenseId = expenseId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for responsible.
   *
   * @param  responsible  Responsible
   */
  public void setResponsible(Responsible responsible) {
    this.responsible = responsible;
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
} // end class Expense
