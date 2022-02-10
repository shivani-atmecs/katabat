package com.cmc.credagility.core.domain.account;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.jpa.converter.StringEncryptionConverter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:dongming.liao@ozstrategy.com">Dongming Liao</a>
 * @version  10/16/2014 10:48
 */
@Entity
@Table(
  name    = "AccountNumberAudit",
  indexes = {
    @Index(
      name = "oldOriginalAccountNumberHashIndex",
      columnList = "oldOriginalAccountNumberHash"
    )
  }
)
public class AccountNumberAudit extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 3305448793973323253L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "accountNum",
    nullable  = false,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Account account;

  /** TODO: DOCUMENT ME! */
  @Column(name = "accountNumberAuditId")
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long accountNumberAuditId;


  /** original account number. */
  @Column(
    name     = "oldOriginalAccountNumber",
    length   = 80,
    nullable = false
  )
  @Convert(converter = StringEncryptionConverter.class)
  protected String oldOriginalAccountNumber;

  /** original account number hash. */
  @Column(
    length   = 48,
    nullable = true
  )
  private String oldOriginalAccountNumberHash;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
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

    AccountNumberAudit that = (AccountNumberAudit) o;

    if ((account != null) ? (!account.equals(that.account)) : (that.account != null)) {
      return false;
    }

    if ((accountNumberAuditId != null) ? (!accountNumberAuditId.equals(that.accountNumberAuditId))
                                       : (that.accountNumberAuditId != null)) {
      return false;
    }

    if ((oldOriginalAccountNumber != null) ? (!oldOriginalAccountNumber.equals(that.oldOriginalAccountNumber))
                                           : (that.oldOriginalAccountNumber != null)) {
      return false;
    }

    if ((oldOriginalAccountNumberHash != null)
          ? (!oldOriginalAccountNumberHash.equals(that.oldOriginalAccountNumberHash))
          : (that.oldOriginalAccountNumberHash != null)) {
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
    return account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account number audit id.
   *
   * @return  Long
   */
  public Long getAccountNumberAuditId() {
    return accountNumberAuditId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for old original account number.
   *
   * @return  String
   */
  public String getOldOriginalAccountNumber() {
    return oldOriginalAccountNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for old original account number hash.
   *
   * @return  String
   */
  public String getOldOriginalAccountNumberHash() {
    return oldOriginalAccountNumberHash;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((account != null) ? account.hashCode() : 0);
    result = (31 * result) + ((oldOriginalAccountNumber != null) ? oldOriginalAccountNumber.hashCode() : 0);
    result = (31 * result) + ((oldOriginalAccountNumberHash != null) ? oldOriginalAccountNumberHash.hashCode() : 0);

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
   * setter method for account number audit id.
   *
   * @param  accountNumberAuditId  Long
   */
  public void setAccountNumberAuditId(Long accountNumberAuditId) {
    this.accountNumberAuditId = accountNumberAuditId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for old original account number.
   *
   * @param  oldOriginalAccountNumber  String
   */
  public void setOldOriginalAccountNumber(String oldOriginalAccountNumber) {
    this.oldOriginalAccountNumber = oldOriginalAccountNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for old original account number hash.
   *
   * @param  oldOriginalAccountNumberHash  String
   */
  public void setOldOriginalAccountNumberHash(String oldOriginalAccountNumberHash) {
    this.oldOriginalAccountNumberHash = oldOriginalAccountNumberHash;
  }
} // end class AccountNumberAudit
