package com.cmc.credagility.core.domain.contact;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.responsible.Responsible;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/14/2014 17:20
 */
@MappedSuperclass public class BaseContactAudit extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 8720936271161489151L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Account, Refers {@link Account}. */
  @JoinColumn(
    name      = "accountNum",
    updatable = false,
    nullable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private Account    account;
  @Column(name = "balance")
  private BigDecimal balance;
  @Column(name = "delinquencyDays")
  private Integer    delinquencyDays;

  /** Responsible, Refers {@link Responsible}. */
  @JoinColumn(
    name      = "responsibleId",
    updatable = false,
    nullable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private Responsible responsible;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * equals.
   *
   * @param   obj  Object
   *
   * @return  boolean
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    final BaseContactAudit other = (BaseContactAudit) obj;

    if (balance == null) {
      if (other.balance != null) {
        return false;
      }
    } else if (balance.compareTo(other.balance) != 0) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

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
   * getter method for balance.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBalance() {
    return balance;
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
   * getter method for responsible.
   *
   * @return  Responsible
   */
  public Responsible getResponsible() {
    return responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = 1;
    result = (prime * result) + ((balance == null) ? 0 : balance.hashCode());

    return result;
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
   * setter method for balance.
   *
   * @param  balance  BigDecimal
   */
  public void setBalance(BigDecimal balance) {
    this.balance = balance;
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
   * Constructs a <code>String</code> with all attributes in name = value format.
   *
   * @return  a <code>String</code> representation of this object.
   */
  @Override public String toString() {
    final String TAB = "    ";

    String retValue = "";

    retValue = "BaseContactAudit ( " + super.toString() + TAB + "account = "
      + this.account + TAB + "responsible = " + this.responsible + TAB
      + "balance = " + this.balance + TAB + " )";

    return retValue;
  }

} // end class BaseContactAudit
