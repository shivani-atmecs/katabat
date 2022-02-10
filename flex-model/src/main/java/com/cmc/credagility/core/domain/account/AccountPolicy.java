package com.cmc.credagility.core.domain.account;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.responsible.ResponsiblePolicy;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:dongming.liao@ozstrategy.com">Dongming Liao</a>
 * @version  10/16/2014 11:02
 */
@Entity
@Table(
  name    = "AccountPolicy",
  indexes = {
    @Index(
      name = "idx_policyNumber",
      columnList = "policyNumber"
    ), @Index(
      name = "idx_policyTypeCode",
      columnList = "policyTypeCode"
    )
  }
)
public class AccountPolicy extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 7861043335071433674L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "accountNum")
  @ManyToOne(fetch = FetchType.LAZY)
  protected Account account;

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long accountPolicyId;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "companyName",
    nullable = true,
    length   = 50
  )
  protected String companyName;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "partyIdentifier",
    length = 32
  )
  protected String partyIdentifier;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "accountPolicy",
    cascade       = { CascadeType.ALL, CascadeType.REMOVE },
    orphanRemoval = true
  )
  @OrderBy("createDate desc")
  protected Set<PolicyClaim> policyClaims = new LinkedHashSet<PolicyClaim>();

  /** TODO: DOCUMENT ME! */
  @Column(name = "policyCloseDate")
  protected Date policyCloseDate;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "policyNumber",
    nullable = false,
    length   = 50
  )
  protected String policyNumber;

  /** TODO: DOCUMENT ME! */
  @Column(name = "policyOpenDate")
  protected Date policyOpenDate;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "policyStatus",
    length = 20
  )
  protected String policyStatus;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "policyTypeCode",
    length = 50
  )
  protected String policyTypeCode;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "premiumAmount",
    nullable = true
  )
  protected BigDecimal premiumAmount;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "accountPolicy",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @OrderBy("createDate desc")
  protected Set<ResponsiblePolicy> responsiblePolicies = new LinkedHashSet<ResponsiblePolicy>();

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "secondPartyIdentifier",
    length = 32
  )
  protected String secondPartyIdentifier;

  @Column(
    name             = "clientDefinedFlag1",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedFlag1;

  @Column(
    name             = "clientDefinedFlag2",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedFlag2;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addPolicyClaim.
   *
   * @param   policyClaim  PolicyClaim
   *
   * @return  boolean
   */
  public boolean addPolicyClaim(PolicyClaim policyClaim) {
    policyClaim.setAccountPolicy(this);

    return getPolicyClaims().add(policyClaim);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addResponsiblePolicy.
   *
   * @param   responsiblePolicy  ResponsiblePolicy
   *
   * @return  boolean
   */
  public boolean addResponsiblePolicy(ResponsiblePolicy responsiblePolicy) {
    responsiblePolicy.setAccountPolicy(this);

    return getResponsiblePolicies().add(responsiblePolicy);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

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

    AccountPolicy that = (AccountPolicy) o;

    if (!account.equals(that.account)) {
      return false;
    }

    if ((accountPolicyId != null) ? (!accountPolicyId.equals(that.accountPolicyId)) : (that.accountPolicyId != null)) {
      return false;
    }

    if ((partyIdentifier != null) ? (!partyIdentifier.equals(that.partyIdentifier)) : (that.partyIdentifier != null)) {
      return false;
    }

    if ((policyClaims != null) ? (!policyClaims.equals(that.policyClaims)) : (that.policyClaims != null)) {
      return false;
    }

    if ((policyCloseDate != null) ? (!policyCloseDate.equals(that.policyCloseDate)) : (that.policyCloseDate != null)) {
      return false;
    }

    if (!policyNumber.equals(that.policyNumber)) {
      return false;
    }

    if ((policyOpenDate != null) ? (!policyOpenDate.equals(that.policyOpenDate)) : (that.policyOpenDate != null)) {
      return false;
    }

    if ((policyStatus != null) ? (!policyStatus.equals(that.policyStatus)) : (that.policyStatus != null)) {
      return false;
    }

    if ((policyTypeCode != null) ? (!policyTypeCode.equals(that.policyTypeCode)) : (that.policyTypeCode != null)) {
      return false;
    }

    if ((secondPartyIdentifier != null) ? (!secondPartyIdentifier.equals(that.secondPartyIdentifier))
                                        : (that.secondPartyIdentifier != null)) {
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
   * getter method for account policy id.
   *
   * @return  Long
   */
  public Long getAccountPolicyId() {
    return accountPolicyId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined flag1.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedFlag1() {
    return clientDefinedFlag1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined flag2.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedFlag2() {
    return clientDefinedFlag2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for company name.
   *
   * @return  String
   */
  public String getCompanyName() {
    return companyName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for party identifier.
   *
   * @return  String
   */
  public String getPartyIdentifier() {
    return partyIdentifier;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for policy claims.
   *
   * @return  Set
   */
  public Set<PolicyClaim> getPolicyClaims() {
    return policyClaims;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for policy close date.
   *
   * @return  Date
   */
  public Date getPolicyCloseDate() {
    return policyCloseDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for policy number.
   *
   * @return  String
   */
  public String getPolicyNumber() {
    return policyNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for policy open date.
   *
   * @return  Date
   */
  public Date getPolicyOpenDate() {
    return policyOpenDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for policy status.
   *
   * @return  String
   */
  public String getPolicyStatus() {
    return policyStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for policy type code.
   *
   * @return  String
   */
  public String getPolicyTypeCode() {
    return policyTypeCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for premium amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPremiumAmount() {
    return premiumAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible policies.
   *
   * @return  Set
   */
  public Set<ResponsiblePolicy> getResponsiblePolicies() {
    return responsiblePolicies;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for second party identifier.
   *
   * @return  String
   */
  public String getSecondPartyIdentifier() {
    return secondPartyIdentifier;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + account.hashCode();
    result = (31 * result) + ((accountPolicyId != null) ? accountPolicyId.hashCode() : 0);
    result = (31 * result) + ((partyIdentifier != null) ? partyIdentifier.hashCode() : 0);
    result = (31 * result) + ((policyClaims != null) ? policyClaims.hashCode() : 0);
    result = (31 * result) + ((policyCloseDate != null) ? policyCloseDate.hashCode() : 0);
    result = (31 * result) + policyNumber.hashCode();
    result = (31 * result) + ((policyOpenDate != null) ? policyOpenDate.hashCode() : 0);
    result = (31 * result) + ((policyStatus != null) ? policyStatus.hashCode() : 0);
    result = (31 * result) + ((policyTypeCode != null) ? policyTypeCode.hashCode() : 0);
    result = (31 * result) + ((secondPartyIdentifier != null) ? secondPartyIdentifier.hashCode() : 0);

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
   * setter method for account policy id.
   *
   * @param  accountPolicyId  Long
   */
  public void setAccountPolicyId(Long accountPolicyId) {
    this.accountPolicyId = accountPolicyId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined flag1.
   *
   * @param  clientDefinedFlag1  Boolean
   */
  public void setClientDefinedFlag1(Boolean clientDefinedFlag1) {
    this.clientDefinedFlag1 = clientDefinedFlag1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined flag2.
   *
   * @param  clientDefinedFlag2  Boolean
   */
  public void setClientDefinedFlag2(Boolean clientDefinedFlag2) {
    this.clientDefinedFlag2 = clientDefinedFlag2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for company name.
   *
   * @param  companyName  String
   */
  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for party identifier.
   *
   * @param  partyIdentifier  String
   */
  public void setPartyIdentifier(String partyIdentifier) {
    this.partyIdentifier = partyIdentifier;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for policy claims.
   *
   * @param  policyClaims  Set
   */
  public void setPolicyClaims(Set<PolicyClaim> policyClaims) {
    this.policyClaims = policyClaims;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for policy close date.
   *
   * @param  policyCloseDate  Date
   */
  public void setPolicyCloseDate(Date policyCloseDate) {
    this.policyCloseDate = policyCloseDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for policy number.
   *
   * @param  policyNumber  String
   */
  public void setPolicyNumber(String policyNumber) {
    this.policyNumber = policyNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for policy open date.
   *
   * @param  policyOpenDate  Date
   */
  public void setPolicyOpenDate(Date policyOpenDate) {
    this.policyOpenDate = policyOpenDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for policy status.
   *
   * @param  policyStatus  String
   */
  public void setPolicyStatus(String policyStatus) {
    this.policyStatus = policyStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for policy type code.
   *
   * @param  policyTypeCode  String
   */
  public void setPolicyTypeCode(String policyTypeCode) {
    this.policyTypeCode = policyTypeCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for premium amount.
   *
   * @param  premiumAmount  BigDecimal
   */
  public void setPremiumAmount(BigDecimal premiumAmount) {
    this.premiumAmount = premiumAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for responsible policies.
   *
   * @param  responsiblePolicies  Set
   */
  public void setResponsiblePolicies(Set<ResponsiblePolicy> responsiblePolicies) {
    this.responsiblePolicies = responsiblePolicies;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for second party identifier.
   *
   * @param  secondPartyIdentifier  String
   */
  public void setSecondPartyIdentifier(String secondPartyIdentifier) {
    this.secondPartyIdentifier = secondPartyIdentifier;
  }
} // end class AccountPolicy
