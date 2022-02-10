package com.cmc.credagility.core.domain.activity;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.responsible.Responsible;


/**
 * This class is used to present base activity.
 *
 * <p><a href="BaseActivity.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/16/2014 10:51
 */
@MappedSuperclass public abstract class BaseActivity extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 178435677472045623L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** account. */
  @JoinColumn(
    name      = "accountNum",
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Account account;

  /** balance. */
  @Column(name = "balance")
  protected BigDecimal balance;

  /** delinquency days. */
  @Column(name = "delinquencyDays")
  protected Integer delinquencyDays;

  /** TODO: DOCUMENT ME! */
  @Transient protected Date executeDate;

  /** responsible. */
  @JoinColumn(
    name      = "responsibleId",
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Responsible responsible;

  /** TODO: DOCUMENT ME! */
  @Transient protected String status;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * The activity type.
   *
   * @return  the activity type
   */
  public abstract String getChannel();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for name.
   *
   * @return  String
   */
  public abstract String getName();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (!super.equals(obj)) {
      return false;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    final BaseActivity other = (BaseActivity) obj;

    if (this.account == null) {
      if (other.getAccount() != null) {
        return false;
      }
    } else if (!this.account.equals(other.getAccount())) {
      return false;
    }

    if (this.balance == null) {
      if (other.getBalance() != null) {
        return false;
      }
    } else if (!this.balance.equals(other.getBalance())) {
      return false;
    }

    if (this.delinquencyDays == null) {
      if (other.getDelinquencyDays() != null) {
        return false;
      }
    } else if (!this.delinquencyDays.equals(other.getDelinquencyDays())) {
      return false;
    }

    if (this.responsible == null) {
      if (other.getResponsible() != null) {
        return false;
      }
    } else if (!this.responsible.equals(other.getResponsible())) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account.
   *
   * @return  Account
   */
  public Account getAccount() {
    return this.account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Activity date may not always be createDate. For example, CommentActivity's activity date is not createDate. This is
   * because CommentActivity may be imported (e.g., from ScoreNet) and the activity date is actually different than the
   * import date.
   *
   * @return  activity date may not always be createDate.
   */
  public Date getActivityDate() {
    return createDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for balance.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBalance() {
    return this.balance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The delinquencyDays.
   *
   * @return  the delinquencyDays
   */
  public Integer getDelinquencyDays() {
    return this.delinquencyDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The executeDate.
   *
   * @return  the executeDate
   */
  public Date getExecuteDate() {
    return this.executeDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible.
   *
   * @return  Responsible
   */
  public Responsible getResponsible() {
    return this.responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status.
   *
   * @return  String
   */
  public String getStatus() {
    return this.status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    final int PRIME  = 31;
    int       result = super.hashCode();
    result = (PRIME * result)
      + ((this.account == null) ? 0 : this.account.hashCode());
    result = (PRIME * result)
      + ((this.balance == null) ? 0 : this.balance.hashCode());
    result = (PRIME
        * result)
      + ((this.delinquencyDays == null) ? 0 : this.delinquencyDays.hashCode());
    result = (PRIME * result)
      + ((this.responsible == null) ? 0 : this.responsible.hashCode());

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
   * setter method for execute date.
   *
   * @param  executeDate  Date
   */
  public void setExecuteDate(Date executeDate) {
    this.executeDate = executeDate;
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
   * setter method for status.
   *
   * @param  status  String
   */
  public void setStatus(String status) {
    this.status = status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Constructs a <code>String</code> with all attributes in name = value format.
   *
   * @return  a <code>String</code> representation of this object.
   */
  @Override public String toString() {
    final String TAB = "    ";

    StringBuilder retValue = new StringBuilder();

    retValue.append("BaseActivity ( ").append(super.toString()).append(TAB).append("account = ").append(this.account)
      .append(TAB).append(
      "balance = ").append(this.balance).append(TAB).append(
      "delinquencyDays = ").append(this.delinquencyDays).append(TAB).append("responsible = ").append(this.responsible)
      .append(TAB).append(
      " )");

    return retValue.toString();
  }
} // end class BaseActivity
