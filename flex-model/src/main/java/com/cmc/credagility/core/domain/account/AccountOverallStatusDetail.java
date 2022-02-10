package com.cmc.credagility.core.domain.account;

import java.io.Serializable;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.portfolio.PortfolioAgentDispositionCode;
import com.cmc.credagility.core.domain.type.AccountStatusCode;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * Account overall status detail table is a set of statuses supported by the system. Note that the same business status
 * may have different codes depending on different portfolios.
 *
 * @author   <a href="mailto:dongming.liao@ozstrategy.com">Dongming Liao</a>
 * @version  10/16/2014 10:57
 */
@Entity
@Table(
  uniqueConstraints = { @UniqueConstraint(columnNames = "statusCode") },
  indexes           = {
    @Index(
      name          = "statusCode_2",
      columnList    = "statusCode",
      unique        = true
    )
  }
)
public class AccountOverallStatusDetail extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 2807048919255113301L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /**
   * The flag by default should be turned off (N), meaning if the Account Overall Status is assigned to an account, it
   * will not block financial transactions from being posted to that account.
   */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean blockFinancialTransactions = Boolean.FALSE;

  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean doNotContact = Boolean.FALSE;

  /** Relations Account Responsible : */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "accountOverallStatusDetail",
    cascade       = { CascadeType.ALL, CascadeType.REMOVE },
    orphanRemoval = true
  )
  protected Set<PortfolioAgentDispositionCode> portfolioAgentDispositionCodes =
    new LinkedHashSet<PortfolioAgentDispositionCode>();

  /** Relations Account Responsible : */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "statusDetail",
    cascade       = { CascadeType.ALL, CascadeType.REMOVE },
    orphanRemoval = true
  )
  protected Set<AccountOverallStatusRequiredDocument> requiredDocuments =
    new LinkedHashSet<AccountOverallStatusRequiredDocument>();

  /** DOCUMENT ME! */
  @Column(
    name     = "statusCode",
    unique   = true,
    nullable = false
  )
  protected String statusCode;

  /** DOCUMENT ME! */
  @Column(name = "statusDescription")
  protected String statusDescription;

  /** DOCUMENT ME! */
  @Column(
    name     = "statusId",
    unique   = true,
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long statusId;

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

    final AccountOverallStatusDetail other = (AccountOverallStatusDetail) obj;

    if (statusCode == null) {
      if (other.statusCode != null) {
        return false;
      }
    } else if (!statusCode.equals(other.statusCode)) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * An enum of AccountStatusCode.
   *
   * @return  An enum of AccountStatusCode.
   */
  public AccountStatusCode getAccountStatusCode() {
    AccountStatusCode codeEnum = AccountStatusCode.toAccountStatusCode(statusCode);

    if (codeEnum == null) {
      codeEnum = AccountStatusCode.toAccountStatusCode(statusId);
    }

    return codeEnum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for block financial transactions.
   *
   * @return  Boolean
   */
  public Boolean getBlockFinancialTransactions() {
    return (blockFinancialTransactions == null) ? Boolean.FALSE : blockFinancialTransactions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for do not contact.
   *
   * @return  Boolean
   */
  public Boolean getDoNotContact() {
    return doNotContact;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio agent disposition codes.
   *
   * @return  Set
   */
  public Set<PortfolioAgentDispositionCode> getPortfolioAgentDispositionCodes() {
    return portfolioAgentDispositionCodes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for required documents.
   *
   * @return  Set
   */
  public Set<AccountOverallStatusRequiredDocument> getRequiredDocuments() {
    return requiredDocuments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status code.
   *
   * @return  String
   */
  public String getStatusCode() {
    return statusCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status description.
   *
   * @return  String
   */
  public String getStatusDescription() {
    return statusDescription;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status id.
   *
   * @return  Long
   */
  public Long getStatusId() {
    return statusId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    return statusCode.hashCode();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for block financial transactions.
   *
   * @param  blockFinancialTransactions  Boolean
   */
  public void setBlockFinancialTransactions(Boolean blockFinancialTransactions) {
    this.blockFinancialTransactions = blockFinancialTransactions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for do not contact.
   *
   * @param  doNotContact  Boolean
   */
  public void setDoNotContact(Boolean doNotContact) {
    this.doNotContact = doNotContact;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio agent disposition codes.
   *
   * @param  portfolioAgentDispositionCodes  Set
   */
  public void setPortfolioAgentDispositionCodes(Set<PortfolioAgentDispositionCode> portfolioAgentDispositionCodes) {
    this.portfolioAgentDispositionCodes = portfolioAgentDispositionCodes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for required documents.
   *
   * @param  requiredDocumentOveralls  Set
   */
  public void setRequiredDocuments(Set<AccountOverallStatusRequiredDocument> requiredDocumentOveralls) {
    this.requiredDocuments = requiredDocumentOveralls;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for status code.
   *
   * @param  statusCode  String
   */
  public void setStatusCode(String statusCode) {
    this.statusCode = statusCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for status description.
   *
   * @param  statusDescription  String
   */
  public void setStatusDescription(String statusDescription) {
    this.statusDescription = statusDescription;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for status id.
   *
   * @param  statusId  Long
   */
  public void setStatusId(Long statusId) {
    this.statusId = statusId;
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

    retValue = "AccountStatusDetail ( " + TAB + "statusId = " + this.statusId + TAB + "statusCode = "
      + this.statusCode + TAB + "statusDescription = " + this.statusDescription + TAB + " )";

    return retValue;
  }

} // end class AccountOverallStatusDetail
