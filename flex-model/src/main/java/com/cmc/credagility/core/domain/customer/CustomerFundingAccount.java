package com.cmc.credagility.core.domain.customer;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.disclosure.DisclosureAudit;
import com.cmc.credagility.core.domain.payment.FundingInformation;
import com.cmc.credagility.core.domain.user.User;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * This class is used to store all customer funding account.
 *
 * <p><a href="FundingAccount.java.html"><i>View Source</i></a></p>
 *
 * <p>table = "CustomerFundingAccount"</p>
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  12/18/2014 13:21
 */
@Embeddable @Entity
@Table(
  name    = "CustomerFundingAccount",
  indexes = {
    @javax.persistence.Index(
      name = "facctReferenceNumberIndex",
      columnList = "externalReferenceNumber"
    ), @javax.persistence.Index(
      name = "postalCodeIndex",
      columnList = "postalCode"
    )
  }
)
public class CustomerFundingAccount extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -4952221061915847017L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  @Column(
    name             = "accountPrimary",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean accountPrimary;

  /** Create date. */
  @JoinColumn(
    name       = "creatorId",
    insertable = true,
    updatable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected User creator;

  /** customerId id. */
  @JoinColumn(
    name      = "customerId",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Customer customer;

  // npelleti, 07/30, USBank, Removed unique constraint
  /** funding account PK fundingAccountId. */
  @Column(
    name     = "customerFundingAccountId", /*unique = true,*/
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long customerFundingAccountId;

  /** disclosureAudit id. */
  @JoinColumn(name = "disclosureAuditId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected DisclosureAudit disclosureAudit;

  /** DOCUMENT ME! */
  @Column(
    name   = "externalReferenceNumber",
    length = 20
  )
  protected String externalReferenceNumber;

  @Column(
          name   = "fundingAccountSource",
          length = 10
  )
  protected String fundingAccountSource;

  /** funding Object - contain account information. */
  @Embedded protected FundingInformation fundingInformation = new FundingInformation();

  @Transient private Long disclosureAuditId;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new $class.name$ object.
   */
  public CustomerFundingAccount() { }

  /**
   * Creates a new $class.name$ object.
   *
   * @param  fundingInformation  DOCUMENT ME!
   */
  public CustomerFundingAccount(FundingInformation fundingInformation) {
    customerFundingAccountId = null;
    customer                 = null;
    this.fundingInformation.deepCopy(fundingInformation);
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  f  DOCUMENT ME!
   */
  public void deepCopy(CustomerFundingAccount f) {
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
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    final CustomerFundingAccount other = (CustomerFundingAccount) obj;

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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAccountPrimary() {
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
   * getter method for customer funding account id.
   *
   * @return  Long
   */
  public Long getCustomerFundingAccountId() {
    return customerFundingAccountId;
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
   * getter method for funding information.
   *
   * @return  FundingInformation
   */
  public FundingInformation getFundingInformation() {
    return this.fundingInformation;
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
   * DOCUMENT ME!
   *
   * @param  customer  DOCUMENT ME!
   */
  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  customerFundingAccountId  the fundingAccountId to set
   */
  public void setCustomerFundingAccountId(Long customerFundingAccountId) {
    this.customerFundingAccountId = customerFundingAccountId;
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
   * @param  fundingInformation  the fundingInformation to set
   */
  public void setFundingInformation(FundingInformation fundingInformation) {
    this.fundingInformation = fundingInformation;
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
      this.customerFundingAccountId).append(TAB).append("fundingInformation = ").append(this.fundingInformation).append(
      TAB).append(" )");

    return retValue.toString();
  }
} // end class CustomerFundingAccount
