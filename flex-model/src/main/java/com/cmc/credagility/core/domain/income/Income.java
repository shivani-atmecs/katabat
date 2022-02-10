package com.cmc.credagility.core.domain.income;

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
import com.cmc.credagility.core.domain.responsible.Responsible;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:pan.kang@ozstrategy.com">Pan Kang</a>
 * @version  10/14/2014 16:18
 */
@Entity
@Table(
  name              = "Income",
  uniqueConstraints = {
    @UniqueConstraint(
      name          = "incomeId",
      columnNames   = "incomeId"
    )
  }
)
public class Income extends AbstractIncome {
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
  @Column(
    name     = "incomeId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long incomeId;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "responsibleId",
    insertable = true,
    updatable  = false,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Responsible responsible;

  /** TODO: DOCUMENT ME! */
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
   * getter method for income id.
   *
   * @return  Long
   */
  public Long getIncomeId() {
    return incomeId;
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
   * getter method for income filled.
   *
   * @return  boolean
   */
  public boolean isIncomeFilled() {
    return (this.getMonthlyTakeHomePay() != null)
      || (this.getBonusIncome() != null) || (this.getUnemployment() != null)
      || (this.getDisability() != null) || (this.getChildSupport() != null)
      || (this.getAlimony() != null) || (this.getNetRentalIncome() != null)
      || (this.getPlan401K() != null) || (this.getStocksBonds() != null)
      || (this.getOther1Amount() != null) || (this.getOther2Amount() != null)
      || (this.getOther3Amount() != null) || (this.getOther4Amount() != null)
      || (this.getOther5Amount() != null) || (this.getOther6Amount() != null);
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
   * setter method for income id.
   *
   * @param  incomeId  Long
   */
  public void setIncomeId(Long incomeId) {
    this.incomeId = incomeId;
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
} // end class Income
