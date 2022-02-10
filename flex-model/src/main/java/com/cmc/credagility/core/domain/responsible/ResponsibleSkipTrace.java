package com.cmc.credagility.core.domain.responsible;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.customer.Customer;
import com.cmc.credagility.core.domain.score.BaseScore;


/**
 * Created by wangjp on 16/11/21.
 *
 * @author   <a href="mailto:jianping.wang@ozstrategy.com">Jianping Wang</a>
 * @version  11/21/2016 10:02
 */
@Entity
@Table(name = "ResponsibleSkipTrace")
public class ResponsibleSkipTrace extends BaseScore {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -5850237984301998880L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "accountNum",
    nullable  = false,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Account accountNum;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "applicationCustomerName",
    length = 100
  )
  protected String applicationCustomerName;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "applicationNumber",
    length = 20
  )
  protected String applicationNumber;

  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "avgTransactionAmount",
    precision = 12,
    scale     = 2
  )
  protected BigDecimal avgTransactionAmount;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "contactAddress",
    length = 100
  )
  protected String contactAddress;

  /** TODO: DOCUMENT ME! */
  @Column(name = "contactEffectiveDate")
  @Temporal(TemporalType.DATE)
  protected Date contactEffectiveDate;

  /** TODO: DOCUMENT ME! */
  @Column(name = "contactExpiryDate")
  @Temporal(TemporalType.DATE)
  protected Date contactExpiryDate;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "contactPhoneNumber",
    length = 15
  )
  protected String contactPhoneNumber;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "contactType",
    length = 20
  )
  protected String contactType;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "customerId",
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Customer customer;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "description",
    length = 100
  )
  protected String description;

  /** TODO: DOCUMENT ME! */
  @Column(name = "effectiveDate")
  @Temporal(TemporalType.DATE)
  protected Date effectiveDate;

  /** TODO: DOCUMENT ME! */
  @Column(name = "employmentEndDate")
  @Temporal(TemporalType.DATE)
  protected Date employmentEndDate;


  /** TODO: DOCUMENT ME! */
  @Column(name = "employmentStartDate")
  @Temporal(TemporalType.DATE)
  protected Date employmentStartDate;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "employmentType",
    length = 50
  )
  protected String employmentType;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "externalUniqueId",
    length = 50
  )
  protected String externalUniqueId;

  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "last6MonthTransactionAmount",
    precision = 8
  )
  protected BigDecimal last6MonthTransactionAmount;

  /** TODO: DOCUMENT ME! */
  @Column(name = "mostRecentTransactionDate")
  @Temporal(TemporalType.DATE)
  protected Date mostRecentTransactionDate;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "name",
    length = 100
  )
  protected String name;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "occupation",
    length = 50
  )
  protected String occupation;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "outcome",
    length = 50
  )
  protected String outcome;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "rank",
    length = 15
  )
  protected String rank;


  /** TODO: DOCUMENT ME! */
  @Column(name = "recordCreateDate")
  @Temporal(TemporalType.DATE)
  protected Date recordCreateDate;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "relationship",
    length = 50
  )
  protected String relationship;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "relationshipIdentifier",
    length = 15
  )
  protected String relationshipIdentifier;

  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long skipTraceId;

  /** TODO: DOCUMENT ME! */
  @Column(name = "sourceBusinessKey")
  protected String sourceBusinessKey;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "sourceSystem",
    length = 10
  )
  protected String sourceSystem;

  /** TODO: DOCUMENT ME! */
  @Column(name = "sourceType")
  protected String sourceType;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "type",
    length = 20
  )
  protected String type;

  @JoinColumn(
    name     = "responsibleId",
    nullable = false
  )
  @ManyToOne private Responsible responsible;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.score.BaseScore#equals(java.lang.Object)
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

    ResponsibleSkipTrace skipTrace = (ResponsibleSkipTrace) o;

    if ((accountNum != null) ? (!accountNum.equals(skipTrace.accountNum)) : (skipTrace.accountNum != null)) {
      return false;
    }

    if ((applicationCustomerName != null) ? (!applicationCustomerName.equals(skipTrace.applicationCustomerName))
                                          : (skipTrace.applicationCustomerName != null)) {
      return false;
    }

    if ((applicationNumber != null) ? (!applicationNumber.equals(skipTrace.applicationNumber))
                                    : (skipTrace.applicationNumber != null)) {
      return false;
    }

    if ((avgTransactionAmount != null) ? (!avgTransactionAmount.equals(skipTrace.avgTransactionAmount))
                                       : (skipTrace.avgTransactionAmount != null)) {
      return false;
    }

    if ((contactAddress != null) ? (!contactAddress.equals(skipTrace.contactAddress))
                                 : (skipTrace.contactAddress != null)) {
      return false;
    }

    if ((contactEffectiveDate != null) ? (!contactEffectiveDate.equals(skipTrace.contactEffectiveDate))
                                       : (skipTrace.contactEffectiveDate != null)) {
      return false;
    }

    if ((contactExpiryDate != null) ? (!contactExpiryDate.equals(skipTrace.contactExpiryDate))
                                    : (skipTrace.contactExpiryDate != null)) {
      return false;
    }

    if ((contactPhoneNumber != null) ? (!contactPhoneNumber.equals(skipTrace.contactPhoneNumber))
                                     : (skipTrace.contactPhoneNumber != null)) {
      return false;
    }

    if ((contactType != null) ? (!contactType.equals(skipTrace.contactType)) : (skipTrace.contactType != null)) {
      return false;
    }

    if ((customer != null) ? (!customer.equals(skipTrace.customer)) : (skipTrace.customer != null)) {
      return false;
    }

    if ((description != null) ? (!description.equals(skipTrace.description)) : (skipTrace.description != null)) {
      return false;
    }

    if ((effectiveDate != null) ? (!effectiveDate.equals(skipTrace.effectiveDate))
                                : (skipTrace.effectiveDate != null)) {
      return false;
    }

    if ((employmentEndDate != null) ? (!employmentEndDate.equals(skipTrace.employmentEndDate))
                                    : (skipTrace.employmentEndDate != null)) {
      return false;
    }

    if ((employmentStartDate != null) ? (!employmentStartDate.equals(skipTrace.employmentStartDate))
                                      : (skipTrace.employmentStartDate != null)) {
      return false;
    }

    if ((employmentType != null) ? (!employmentType.equals(skipTrace.employmentType))
                                 : (skipTrace.employmentType != null)) {
      return false;
    }

    if ((externalUniqueId != null) ? (!externalUniqueId.equals(skipTrace.externalUniqueId))
                                   : (skipTrace.externalUniqueId != null)) {
      return false;
    }

    if ((last6MonthTransactionAmount != null)
          ? (!last6MonthTransactionAmount.equals(skipTrace.last6MonthTransactionAmount))
          : (skipTrace.last6MonthTransactionAmount != null)) {
      return false;
    }

    if ((mostRecentTransactionDate != null) ? (!mostRecentTransactionDate.equals(
              skipTrace.mostRecentTransactionDate)) : (skipTrace.mostRecentTransactionDate != null)) {
      return false;
    }

    if ((name != null) ? (!name.equals(skipTrace.name)) : (skipTrace.name != null)) {
      return false;
    }

    if ((occupation != null) ? (!occupation.equals(skipTrace.occupation)) : (skipTrace.occupation != null)) {
      return false;
    }

    if ((outcome != null) ? (!outcome.equals(skipTrace.outcome)) : (skipTrace.outcome != null)) {
      return false;
    }

    if ((rank != null) ? (!rank.equals(skipTrace.rank)) : (skipTrace.rank != null)) {
      return false;
    }

    if ((recordCreateDate != null) ? (!recordCreateDate.equals(skipTrace.recordCreateDate))
                                   : (skipTrace.recordCreateDate != null)) {
      return false;
    }

    if ((relationship != null) ? (!relationship.equals(skipTrace.relationship)) : (skipTrace.relationship != null)) {
      return false;
    }

    if ((relationshipIdentifier != null) ? (!relationshipIdentifier.equals(skipTrace.relationshipIdentifier))
                                         : (skipTrace.relationshipIdentifier != null)) {
      return false;
    }

    if ((skipTraceId != null) ? (!skipTraceId.equals(skipTrace.skipTraceId)) : (skipTrace.skipTraceId != null)) {
      return false;
    }

    if ((sourceBusinessKey != null) ? (!sourceBusinessKey.equals(skipTrace.sourceBusinessKey))
                                    : (skipTrace.sourceBusinessKey != null)) {
      return false;
    }

    if ((sourceSystem != null) ? (!sourceSystem.equals(skipTrace.sourceSystem)) : (skipTrace.sourceSystem != null)) {
      return false;
    }

    if ((sourceType != null) ? (!sourceType.equals(skipTrace.sourceType)) : (skipTrace.sourceType != null)) {
      return false;
    }

    if ((type != null) ? (!type.equals(skipTrace.type)) : (skipTrace.type != null)) {
      return false;
    }

    return (responsible != null) ? responsible.equals(skipTrace.responsible) : (skipTrace.responsible == null);

  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account num.
   *
   * @return  Account
   */
  public Account getAccountNum() {
    return accountNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for application customer name.
   *
   * @return  String
   */
  public String getApplicationCustomerName() {
    return applicationCustomerName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for application number.
   *
   * @return  String
   */
  public String getApplicationNumber() {
    return applicationNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for avg transaction amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getAvgTransactionAmount() {
    return avgTransactionAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for contact address.
   *
   * @return  String
   */
  public String getContactAddress() {
    return contactAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for contact effective date.
   *
   * @return  Date
   */
  public Date getContactEffectiveDate() {
    return contactEffectiveDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for contact expiry date.
   *
   * @return  Date
   */
  public Date getContactExpiryDate() {
    return contactExpiryDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for contact phone number.
   *
   * @return  String
   */
  public String getContactPhoneNumber() {
    return contactPhoneNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for contact type.
   *
   * @return  String
   */
  public String getContactType() {
    return contactType;
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
   * getter method for description.
   *
   * @return  String
   */
  public String getDescription() {
    return description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for effective date.
   *
   * @return  Date
   */
  public Date getEffectiveDate() {
    return effectiveDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for employment end date.
   *
   * @return  Date
   */
  public Date getEmploymentEndDate() {
    return employmentEndDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for employment start date.
   *
   * @return  Date
   */
  public Date getEmploymentStartDate() {
    return employmentStartDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for employment type.
   *
   * @return  String
   */
  public String getEmploymentType() {
    return employmentType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for external unique id.
   *
   * @return  String
   */
  public String getExternalUniqueId() {
    return externalUniqueId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last6 month transaction amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getLast6MonthTransactionAmount() {
    return last6MonthTransactionAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for most recent transaction date.
   *
   * @return  Date
   */
  public Date getMostRecentTransactionDate() {
    return mostRecentTransactionDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for name.
   *
   * @return  String
   */
  public String getName() {
    return name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for occupation.
   *
   * @return  String
   */
  public String getOccupation() {
    return occupation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for outcome.
   *
   * @return  String
   */
  public String getOutcome() {
    return outcome;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for rank.
   *
   * @return  String
   */
  public String getRank() {
    return rank;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for record create date.
   *
   * @return  Date
   */
  public Date getRecordCreateDate() {
    return recordCreateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for relationship.
   *
   * @return  String
   */
  public String getRelationship() {
    return relationship;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for relationship identifier.
   *
   * @return  String
   */
  public String getRelationshipIdentifier() {
    return relationshipIdentifier;
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
   * getter method for skip trace id.
   *
   * @return  Long
   */
  public Long getSkipTraceId() {
    return skipTraceId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for source business key.
   *
   * @return  String
   */
  public String getSourceBusinessKey() {
    return sourceBusinessKey;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for source system.
   *
   * @return  String
   */
  public String getSourceSystem() {
    return sourceSystem;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for source type.
   *
   * @return  String
   */
  public String getSourceType() {
    return sourceType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for type.
   *
   * @return  String
   */
  public String getType() {
    return type;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.score.BaseScore#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((accountNum != null) ? accountNum.hashCode() : 0);
    result = (31 * result) + ((applicationCustomerName != null) ? applicationCustomerName.hashCode() : 0);
    result = (31 * result) + ((applicationNumber != null) ? applicationNumber.hashCode() : 0);
    result = (31 * result) + ((avgTransactionAmount != null) ? avgTransactionAmount.hashCode() : 0);
    result = (31 * result) + ((contactAddress != null) ? contactAddress.hashCode() : 0);
    result = (31 * result) + ((contactEffectiveDate != null) ? contactEffectiveDate.hashCode() : 0);
    result = (31 * result) + ((contactExpiryDate != null) ? contactExpiryDate.hashCode() : 0);
    result = (31 * result) + ((contactPhoneNumber != null) ? contactPhoneNumber.hashCode() : 0);
    result = (31 * result) + ((contactType != null) ? contactType.hashCode() : 0);
    result = (31 * result) + ((customer != null) ? customer.hashCode() : 0);
    result = (31 * result) + ((description != null) ? description.hashCode() : 0);
    result = (31 * result) + ((effectiveDate != null) ? effectiveDate.hashCode() : 0);
    result = (31 * result) + ((employmentEndDate != null) ? employmentEndDate.hashCode() : 0);
    result = (31 * result) + ((employmentStartDate != null) ? employmentStartDate.hashCode() : 0);
    result = (31 * result) + ((employmentType != null) ? employmentType.hashCode() : 0);
    result = (31 * result) + ((externalUniqueId != null) ? externalUniqueId.hashCode() : 0);
    result = (31 * result) + ((last6MonthTransactionAmount != null) ? last6MonthTransactionAmount.hashCode() : 0);
    result = (31 * result) + ((mostRecentTransactionDate != null) ? mostRecentTransactionDate.hashCode() : 0);
    result = (31 * result) + ((name != null) ? name.hashCode() : 0);
    result = (31 * result) + ((occupation != null) ? occupation.hashCode() : 0);
    result = (31 * result) + ((outcome != null) ? outcome.hashCode() : 0);
    result = (31 * result) + ((rank != null) ? rank.hashCode() : 0);
    result = (31 * result) + ((recordCreateDate != null) ? recordCreateDate.hashCode() : 0);
    result = (31 * result) + ((relationship != null) ? relationship.hashCode() : 0);
    result = (31 * result) + ((relationshipIdentifier != null) ? relationshipIdentifier.hashCode() : 0);
    result = (31 * result) + ((skipTraceId != null) ? skipTraceId.hashCode() : 0);
    result = (31 * result) + ((sourceBusinessKey != null) ? sourceBusinessKey.hashCode() : 0);
    result = (31 * result) + ((sourceSystem != null) ? sourceSystem.hashCode() : 0);
    result = (31 * result) + ((sourceType != null) ? sourceType.hashCode() : 0);
    result = (31 * result) + ((type != null) ? type.hashCode() : 0);
    result = (31 * result) + ((responsible != null) ? responsible.hashCode() : 0);

    return result;
  } // end method hashCode

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account num.
   *
   * @param  accountNum  Account
   */
  public void setAccountNum(Account accountNum) {
    this.accountNum = accountNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for application customer name.
   *
   * @param  applicationCustomerName  String
   */
  public void setApplicationCustomerName(String applicationCustomerName) {
    this.applicationCustomerName = applicationCustomerName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for application number.
   *
   * @param  applicationNumber  String
   */
  public void setApplicationNumber(String applicationNumber) {
    this.applicationNumber = applicationNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for avg transaction amount.
   *
   * @param  avgTransactionAmount  BigDecimal
   */
  public void setAvgTransactionAmount(BigDecimal avgTransactionAmount) {
    this.avgTransactionAmount = avgTransactionAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for contact address.
   *
   * @param  contactAddress  String
   */
  public void setContactAddress(String contactAddress) {
    this.contactAddress = contactAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for contact effective date.
   *
   * @param  contactEffectiveDate  Date
   */
  public void setContactEffectiveDate(Date contactEffectiveDate) {
    this.contactEffectiveDate = contactEffectiveDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for contact expiry date.
   *
   * @param  contactExpiryDate  Date
   */
  public void setContactExpiryDate(Date contactExpiryDate) {
    this.contactExpiryDate = contactExpiryDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for contact phone number.
   *
   * @param  contactPhoneNumber  String
   */
  public void setContactPhoneNumber(String contactPhoneNumber) {
    this.contactPhoneNumber = contactPhoneNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for contact type.
   *
   * @param  contactType  String
   */
  public void setContactType(String contactType) {
    this.contactType = contactType;
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
   * setter method for description.
   *
   * @param  description  String
   */
  public void setDescription(String description) {
    this.description = description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for effective date.
   *
   * @param  effectiveDate  Date
   */
  public void setEffectiveDate(Date effectiveDate) {
    this.effectiveDate = effectiveDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for employment end date.
   *
   * @param  employmentEndDate  Date
   */
  public void setEmploymentEndDate(Date employmentEndDate) {
    this.employmentEndDate = employmentEndDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for employment start date.
   *
   * @param  employmentStartDate  Date
   */
  public void setEmploymentStartDate(Date employmentStartDate) {
    this.employmentStartDate = employmentStartDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for employment type.
   *
   * @param  employmentType  String
   */
  public void setEmploymentType(String employmentType) {
    this.employmentType = employmentType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for external unique id.
   *
   * @param  externalUniqueId  String
   */
  public void setExternalUniqueId(String externalUniqueId) {
    this.externalUniqueId = externalUniqueId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last6 month transaction amount.
   *
   * @param  last6MonthTransactionAmount  BigDecimal
   */
  public void setLast6MonthTransactionAmount(BigDecimal last6MonthTransactionAmount) {
    this.last6MonthTransactionAmount = last6MonthTransactionAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for most recent transaction date.
   *
   * @param  mostRecentTransactionDate  Date
   */
  public void setMostRecentTransactionDate(Date mostRecentTransactionDate) {
    this.mostRecentTransactionDate = mostRecentTransactionDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for name.
   *
   * @param  name  String
   */
  public void setName(String name) {
    this.name = name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for occupation.
   *
   * @param  occupation  String
   */
  public void setOccupation(String occupation) {
    this.occupation = occupation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for outcome.
   *
   * @param  outcome  String
   */
  public void setOutcome(String outcome) {
    this.outcome = outcome;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for rank.
   *
   * @param  rank  String
   */
  public void setRank(String rank) {
    this.rank = rank;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for record create date.
   *
   * @param  recordCreateDate  Date
   */
  public void setRecordCreateDate(Date recordCreateDate) {
    this.recordCreateDate = recordCreateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for relationship.
   *
   * @param  relationship  String
   */
  public void setRelationship(String relationship) {
    this.relationship = relationship;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for relationship identifier.
   *
   * @param  relationshipIdentifier  String
   */
  public void setRelationshipIdentifier(String relationshipIdentifier) {
    this.relationshipIdentifier = relationshipIdentifier;
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
   * setter method for skip trace id.
   *
   * @param  skipTraceId  Long
   */
  public void setSkipTraceId(Long skipTraceId) {
    this.skipTraceId = skipTraceId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for source business key.
   *
   * @param  sourceBusinessKey  String
   */
  public void setSourceBusinessKey(String sourceBusinessKey) {
    this.sourceBusinessKey = sourceBusinessKey;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for source system.
   *
   * @param  sourceSystem  String
   */
  public void setSourceSystem(String sourceSystem) {
    this.sourceSystem = sourceSystem;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for source type.
   *
   * @param  sourceType  String
   */
  public void setSourceType(String sourceType) {
    this.sourceType = sourceType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for type.
   *
   * @param  type  String
   */
  public void setType(String type) {
    this.type = type;
  }
} // end class ResponsibleSkipTrace
