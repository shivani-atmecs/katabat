package com.cmc.credagility.core.domain.payment;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.customer.Customer;
import com.cmc.credagility.core.domain.disclosure.DisclosureAudit;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.domain.user.User;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * This class is used to store all funding account.
 *
 * <p><a href="FundingAccount.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 * @version  $Revision$, $Date$
 *
 *           <p>table = "FundingAccount"</p>
 */
@Embeddable @Entity
@Table(
  name    = "FundingAccount",
  indexes = {
    @Index(
      name = "facctReferenceNumberIndex",
      columnList = "externalReferenceNumber"
    ), @Index(
      name = "postalCodeIndex",
      columnList = "postalCode"
    )
  }
)
public class FundingAccount extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -1568220780153905237L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Account primary <code>true</code> primary account. */
  @Column(
    name             = "accountPrimary",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean accountPrimary;

  /** Creator id. */
  @JoinColumn(
    name       = "creatorId",
    insertable = true,
    updatable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected User creator;

  /** Customer id. When 'customerId' is not null, this funding account is belonged to customer. */
  @JoinColumn(
    name      = "customerId",
    updatable = false,
    nullable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Customer customer;

  /** Flag for customer level FundingAccount. */
  @Column(
    name             = "customerDefault",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean customerDefault;

  /** DisclosureAudit PK disclosureAuditId. */
  @JoinColumn(name = "disclosureAuditId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected DisclosureAudit disclosureAudit;

  /** External reference number. */
  @Column(
    name   = "externalReferenceNumber",
    length = 20
  )
  protected String externalReferenceNumber;

  // npelleti, 07/30, USBank, Removed unique constraint
  /** funding account PK fundingAccountId. */
  @Column(
    name     = "fundingAccountId", /*unique = true,*/
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long fundingAccountId;

  /** funding Object - contain account information. */
  @Embedded protected FundingInformation fundingInformation = new FundingInformation();

  /** responsible id. */
  @JoinColumn(
    name      = "responsibleId",
    updatable = false,
    nullable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Responsible responsible;

  @Column(
    name             = "accountDefault",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean accountDefault;

  @Column(
          name   = "fundingAccountSource",
          length = 10
  )
  protected String fundingAccountSource;

  @Transient private Long disclosureAuditId;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new $class.name$ object.
   */
  public FundingAccount() { }

  /**
   * Creates a new $class.name$ object.
   *
   * @param  fundingInformation  DOCUMENT ME!
   */
  public FundingAccount(FundingInformation fundingInformation) {
    fundingAccountId = null;
    responsible      = null;
    this.fundingInformation.deepCopy(fundingInformation);
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  f  DOCUMENT ME!
   */
  public void deepCopy(FundingAccount f) {
    this.externalReferenceNumber = f.getExternalReferenceNumber();
    this.fundingInformation.deepCopy(f.getFundingInformation());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   portfolioId  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean ensureNickName(Long portfolioId) {
    return this.fundingInformation.ensureNickName(portfolioId);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#equals(java.lang.Objecht)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    final FundingAccount other = (FundingAccount) obj;

    if (this.fundingInformation == null) {
      if (other.getFundingInformation() != null) {
        return false;
      }
    } else if (!this.fundingInformation.equals(other.getFundingInformation())) {
      return false;
    }

    if (this.fundingAccountSource == null) {
      if (other.getFundingAccountSource() != null) {
        return false;
      }
    } else if (!this.fundingAccountSource.equals(other.getFundingAccountSource())) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account default.
   *
   * @return  Boolean
   */
  public Boolean getAccountDefault() {
    return accountDefault;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAccountPrimary() {
    if (null == accountPrimary) {
      return Boolean.FALSE;
    }

    return accountPrimary;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public User getCreator() {
    return creator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for customer.
   *
   * @return  Customer
   */
  public Customer getCustomer() {
    return customer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for customer default.
   *
   * @return  Boolean
   */
  public Boolean getCustomerDefault() {
    if (customerDefault == null) {
      return Boolean.FALSE;
    }

    return customerDefault;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public DisclosureAudit getDisclosureAudit() {
    return disclosureAudit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getDisclosureAuditId() {
    return disclosureAuditId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getExternalReferenceNumber() {
    return externalReferenceNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The fundingAccountId.
   *
   * @return  the fundingAccountId
   *
   *          <p>generator-class = "native" unsaved-value = "null"</p>
   */
  public Long getFundingAccountId() {
    return fundingAccountId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The fundingInformation.
   *
   * @return  the fundingInformation
   */
  public FundingInformation getFundingInformation() {
    return this.fundingInformation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The responsible.
   *
   * @return  the responsible
   *
   *          <p>lazy = "proxy" column = "responsibleId" not-null = "true" class = "com.cmc.credagility.Responsible"
   *          insert = "true" update = "false"</p>
   */
  public Responsible getResponsible() {
    return responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    final int PRIME  = 31;
    int       result = 31;
    result = (PRIME * result) + ((this.fundingInformation == null) ? 0 : this.fundingInformation.hashCode());
    result = (PRIME * result) + ((this.fundingAccountSource == null) ? 0 : this.fundingAccountSource.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * return true if the account is a bank account.
   *
   * @return  return true if the account is a bank account
   */
  public boolean isBankAccount() {
    return fundingInformation.isBankAccount();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * return true if the account is a card account.
   *
   * @return  return true if the account is a card account
   */
  public boolean isCardAccount() {
    return fundingInformation.isCardAccount();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * return true if the account is a credit card account.
   *
   * @return  return true if the account is a credit card account
   */
  public boolean isCreditCard() {
    return fundingInformation.isCreditCard();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * return true if the account is a debit card account.
   *
   * @return  return true if the account is a debit card account
   */
  public boolean isDebitCard() {
    return fundingInformation.isDebitCard();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * return true if the account is money market.
   *
   * @return  return true if the account is money market
   */
  public boolean isMoneyMarket() {
    return fundingInformation.isMoneyMarket();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account default.
   *
   * @param  accountDefault  Boolean
   */
  public void setAccountDefault(Boolean accountDefault) {
    this.accountDefault = accountDefault;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  accountPrimary  DOCUMENT ME!
   */
  public void setAccountPrimary(Boolean accountPrimary) {
    this.accountPrimary = accountPrimary;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  creator  DOCUMENT ME!
   */
  public void setCreator(User creator) {
    this.creator = creator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for customer.
   *
   * @param  customer  Customer
   */
  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for customer default.
   *
   * @param  customerDefault  Boolean
   */
  public void setCustomerDefault(Boolean customerDefault) {
    this.customerDefault = customerDefault;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  disclosureAudit  DOCUMENT ME!
   */
  public void setDisclosureAudit(DisclosureAudit disclosureAudit) {
    this.disclosureAudit = disclosureAudit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  disclosureAuditId  DOCUMENT ME!
   */
  public void setDisclosureAuditId(Long disclosureAuditId) {
    this.disclosureAuditId = disclosureAuditId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  externalReferenceNumber  DOCUMENT ME!
   */
  public void setExternalReferenceNumber(String externalReferenceNumber) {
    this.externalReferenceNumber = externalReferenceNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  fundingAccountId  the fundingAccountId to set
   */
  public void setFundingAccountId(Long fundingAccountId) {
    this.fundingAccountId = fundingAccountId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  fundingInformation  the fundingInformation to set
   */
  public void setFundingInformation(FundingInformation fundingInformation) {
    this.fundingInformation = fundingInformation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  responisble  DOCUMENT ME! the responsible to set
   */
  public void setResponsible(Responsible responisble) {
    this.responsible = responisble;
  }

  public String getFundingAccountSource() {
    return fundingAccountSource;
  }

  public void setFundingAccountSource(String fundingAccountSource) {
    this.fundingAccountSource = fundingAccountSource;
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

    retValue.append("FundingAccount ( ").append("fundingAccountId = ").append(
      this.fundingAccountId).append(TAB).append("fundingInformation = ").append(this.fundingInformation).append(TAB)
      .append(" )");

    return retValue.toString();
  }
} // end class FundingAccount
