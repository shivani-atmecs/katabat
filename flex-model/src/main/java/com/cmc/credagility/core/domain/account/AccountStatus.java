package com.cmc.credagility.core.domain.account;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
import com.cmc.credagility.core.domain.type.AccountStatusCode;
import com.cmc.credagility.core.domain.type.StatusSource;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:dongming.liao@ozstrategy.com">Dongming Liao</a>
 * @version  10/16/2014 11:40
 */
@Entity
@Table(name = "AccountStatus")
public class AccountStatus extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -3697553699586323296L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "accountNum",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Account account;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "statusId",
    insertable = true,
    updatable  = false,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected AccountStatusDetail accountStatusDetail;


  // npelleti, 07/30, USBank, Removed unique constraint

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "accountStatusLinkId",

    // unique   = true,
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long accountStatusLinkId;


  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean historical = Boolean.FALSE;


  /** TODO: DOCUMENT ME! */
  @Column(name = "removeDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date removeDate;

  /**
   * Please note that this is different than createDate. createDate is when the DB record is created and this date means
   * when the status is assigned. It is a business concept.
   */
  @Column(name = "statusDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date statusDate;

  /** where we get this status. */
  @Column(
    name   = "statusSource",
    length = 10
  )
  @Enumerated(EnumType.STRING)
  protected StatusSource statusSource;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new $class.name$ object.
   */
  public AccountStatus() { }

  /**
   * Creates a new $class.name$ object.
   *
   * @param  code  DOCUMENT ME!
   */
  public AccountStatus(AccountStatusCode code) {
    super();
    setAccountStatusDetail(code);
  }

  /**
   * Creates a new $class.name$ object.
   *
   * @param  account  DOCUMENT ME!
   * @param  code     DOCUMENT ME!
   */
  public AccountStatus(Account account, AccountStatusCode code) {
    super();
    setAccountStatusDetail(code);
    this.account = account;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }


    if (getClass() != obj.getClass()) {
      return false;
    }

    AccountStatus other = (AccountStatus) obj;

    if (accountStatusDetail == null) {
      if (other.accountStatusDetail != null) {
        return false;
      }
    } else if (accountStatusDetail.getStatusId() == null) {
      if (other.accountStatusDetail.getStatusId() != null) {
        return false;
      }
    } else {
      if (other.accountStatusDetail.getStatusId() == null) {
        return false;
      }

      if (!accountStatusDetail.getStatusId().equals(
              other.accountStatusDetail.getStatusId())) {
        return false;
      }
    }

    if (historical == null) {
      if (other.historical != null) {
        return false;
      }
    } else if (!historical.equals(other.historical)) {
      return false;
    }

    if (statusDate == null) {
      if (other.statusDate != null) {
        return false;
      }
    } else if (!statusDate.equals(other.statusDate)) {
      return false;
    }

    if (statusSource == null) {
      if (other.statusSource != null) {
        return false;
      }
    } else if (!statusSource.equals(other.statusSource)) {
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
   * getter method for account status code.
   *
   * @return  AccountStatusCode
   */
  public AccountStatusCode getAccountStatusCode() {
    if (accountStatusDetail == null) {
      return null;
    }

    return accountStatusDetail.getAccountStatusCode();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account status detail.
   *
   * @return  AccountStatusDetail
   */
  public AccountStatusDetail getAccountStatusDetail() {
    return accountStatusDetail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account status link id.
   *
   * @return  Long
   */
  public Long getAccountStatusLinkId() {
    return accountStatusLinkId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for historical.
   *
   * @return  Boolean
   */
  public Boolean getHistorical() {
    return historical;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for remove date.
   *
   * @return  Date
   */
  public Date getRemoveDate() {
    return removeDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status code.
   *
   * @return  String
   */
  public String getStatusCode() {
    if (accountStatusDetail == null) {
      return null;
    }

    return accountStatusDetail.getStatusCode();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status date.
   *
   * @return  Date
   */
  public Date getStatusDate() {
    return statusDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status source.
   *
   * @return  StatusSource
   */
  public StatusSource getStatusSource() {
    return statusSource;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = 1;
    result = (prime
        * result)
      + ((accountStatusDetail == null) ? 0 : accountStatusDetail.getStatusId().hashCode());
    result = (prime * result)
      + ((historical == null) ? 0 : historical.hashCode());
    result = (prime * result)
      + ((statusDate == null) ? 0 : statusDate.hashCode());
    result = (prime * result)
      + ((statusSource == null) ? 0 : statusSource.hashCode());

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
   * setter method for account status detail.
   *
   * @param  accountStatusDetail  AccountStatusDetail
   */
  public void setAccountStatusDetail(AccountStatusDetail accountStatusDetail) {
    this.accountStatusDetail = accountStatusDetail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account status detail.
   *
   * @param  code  AccountStatusCode
   */
  public void setAccountStatusDetail(AccountStatusCode code) {
    if (code != null) {
      AccountStatusDetail detail = new AccountStatusDetail();
      detail.setStatusCode(code.toString());
      detail.setStatusId(code.getStatusId());
      this.accountStatusDetail = detail;
    } else {
      this.accountStatusDetail = null;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account status link id.
   *
   * @param  accountStatusLinkId  Long
   */
  public void setAccountStatusLinkId(Long accountStatusLinkId) {
    this.accountStatusLinkId = accountStatusLinkId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for historical.
   *
   * @param  historical  Boolean
   */
  public void setHistorical(Boolean historical) {
    this.historical = historical;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for remove date.
   *
   * @param  removeDate  Date
   */
  public void setRemoveDate(Date removeDate) {
    this.removeDate = removeDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for status date.
   *
   * @param  statusDate  Date
   */
  public void setStatusDate(Date statusDate) {
    this.statusDate = statusDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for status source.
   *
   * @param  statusSource  StatusSource
   */
  public void setStatusSource(StatusSource statusSource) {
    this.statusSource = statusSource;
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

    retValue = "AccountStatus ( " + TAB + "accountStatusLinkId = "
      + this.accountStatusLinkId + TAB + "accountOverallStatusDetail = "
      + this.accountStatusDetail + TAB + "accountNum = "
      + this.account.getAccountNum() + TAB + " )";

    return retValue;
  }
} // end class AccountStatus
