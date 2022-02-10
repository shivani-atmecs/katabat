package com.cmc.credagility.core.domain.account;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.externalentity.BillingGroup;
import com.cmc.credagility.core.domain.tranche.TrancheInfo;
import com.cmc.credagility.core.domain.user.Role;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:dongming.liao@ozstrategy.com">Dongming Liao</a>
 * @version  10/16/2014 11:14
 */
@Entity
@Table(name = "AccountSaleInfo")
public class AccountSaleInfo extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "accountNum")
  @ManyToOne(fetch = FetchType.LAZY)
  protected Account account;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "balance",
    precision = 19,
    scale     = 2
  )
  protected BigDecimal balance;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "billingGroupId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected BillingGroup billingGroup;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "roleId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected Role role;


  /** TODO: DOCUMENT ME! */
  @Column(name = "salesDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date salesDate;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "salesPrice",
    precision = 19,
    scale     = 4
  )
  protected BigDecimal salesPrice;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "trancheId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected TrancheInfo trancheInfo;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long id;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new AccountSaleInfo object.
   */
  public AccountSaleInfo() { }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    AccountSaleInfo that = (AccountSaleInfo) o;

    if ((account != null) ? (!account.equals(that.account)) : (that.account != null)) {
      return false;
    }

    if ((balance != null) ? (!balance.equals(that.balance)) : (that.balance != null)) {
      return false;
    }

    if ((billingGroup != null) ? (!billingGroup.equals(that.billingGroup)) : (that.billingGroup != null)) {
      return false;
    }

    if ((role != null) ? (!role.equals(that.role)) : (that.role != null)) {
      return false;
    }

    if ((salesDate != null) ? (!salesDate.equals(that.salesDate)) : (that.salesDate != null)) {
      return false;
    }

    if ((salesPrice != null) ? (!salesPrice.equals(that.salesPrice)) : (that.salesPrice != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((account != null) ? account.hashCode() : 0);
    result = (31 * result) + ((balance != null) ? balance.hashCode() : 0);
    result = (31 * result) + ((billingGroup != null) ? billingGroup.hashCode() : 0);
    result = (31 * result) + ((role != null) ? role.hashCode() : 0);
    result = (31 * result) + ((salesDate != null) ? salesDate.hashCode() : 0);
    result = (31 * result) + ((salesPrice != null) ? salesPrice.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#toString()
   */
  @Override public String toString() {
    return "AccountSaleInfo{"
      + "account=" + account
      + ", balance=" + balance
      + ", billingGroup=" + billingGroup
      + ", role=" + role
      + ", salesDate=" + salesDate
      + ", salesPrice=" + salesPrice
      + ", trancheInfo=" + trancheInfo
      + ", id=" + id
      + '}';
  }

} // end class AccountSaleInfo
