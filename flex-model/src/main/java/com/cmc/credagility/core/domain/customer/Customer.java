package com.cmc.credagility.core.domain.customer;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.persistence.CascadeType;
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
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Where;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.util.StringUtils;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.address.AddressType;
import com.cmc.credagility.core.domain.channel.EmailType;
import com.cmc.credagility.core.domain.contact.ContactableBaseObject;
import com.cmc.credagility.core.domain.contact.FuturePermanentCustomerContactAddress;
import com.cmc.credagility.core.domain.contact.FuturePermanentCustomerContactPhone;
import com.cmc.credagility.core.domain.contact.PhoneType;
import com.cmc.credagility.core.domain.memo.MemoryMessage;
import com.cmc.credagility.core.domain.payment.FundingAccount;
import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.domain.responsible.ResponsibleIndex;
import com.cmc.credagility.core.domain.type.ContactChannel;
import com.cmc.credagility.core.domain.type.ContactChannelType;
import com.cmc.credagility.core.domain.type.ContactSource;
import com.cmc.credagility.core.domain.type.ContactStatus;
import com.cmc.credagility.core.domain.type.CustomerType;
import com.cmc.credagility.core.domain.type.DoNotContactReason;
import com.cmc.credagility.core.domain.type.FundingAccountType;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;
import com.cmc.credagility.core.jpa.converter.StringEncryptionConverter;

import com.ozstrategy.credagility.core.domain.PersonaAccount;
import com.ozstrategy.credagility.core.domain.PersonaAction;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/17/2014 11:21
 */
@Entity
@Table(
  name              = "Customer",
  uniqueConstraints = { @UniqueConstraint(columnNames = { "ucid", "portfolioId" }) },
  indexes           = {
    @Index(
      name          = "lastNameIndex",
      columnList    = "lastName"
    ),
    @Index(
      name          = "natureOfBusinessIndex",
      columnList    = "natureOfBusiness"
    ),
    @Index(
      name          = "ssnIndex",
      columnList    = "ssn"
    ),
    @Index(
      name          = "ucidIndex",
      columnList    = "ucid"
    ), @Index(
      name          = "cmcRandomDigitsIndex",
      columnList    = "cmcRandomDigits"
    )
  }
)
public class Customer extends ContactableBaseObject implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  protected static final transient Logger log              = LoggerFactory.getLogger(Customer.class);
  private static final long               serialVersionUID = -7856573603172528391L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "abn",
    length = 50
  )
  protected String abn;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "acn",
    length = 50
  )
  protected String acn;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "active",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean active = Boolean.TRUE;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "customer",
    cascade  = { CascadeType.REMOVE, CascadeType.ALL }
  )
  @Where(clause = "deleted is null or deleted='N'")
  protected Set<ResponsibleIndex> activeResponsibleIndexs = new LinkedHashSet<ResponsibleIndex>();

  /**
   * TODO: DOCUM
   *
   * <p>ENT ME!</p>
   */
  @MapKeyColumn(name = "typeId")
  @OneToMany(
    cascade  = CascadeType.ALL,
    fetch    = FetchType.LAZY,
    mappedBy = "customer"
  )
  @Where(clause = "historical is null or historical='N'")
  protected Map<String, CustomerContactAddress> addresses = new HashMap<String, CustomerContactAddress>();

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    cascade  = CascadeType.ALL,
    fetch    = FetchType.LAZY,
    mappedBy = "customer"
  )
  protected List<CustomerContactEmail> allEmails = new ArrayList<CustomerContactEmail>();

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    cascade  = CascadeType.ALL,
    fetch    = FetchType.LAZY,
    mappedBy = "customer"
  )
  protected List<CustomerContactPhone> allPhones = new ArrayList<CustomerContactPhone>();


  /** TODO: DOCUMENT ME! */
  @Column(name = "balance")
  protected BigDecimal balance;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "bannedMsg",
    length = 200
  )
  protected String bannedMsg;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientInfoCreateDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientInfoCreateDate;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientInfoUpdateDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientInfoUpdateDate;

  /** TODO: DOCUMENT ME! */
  @Column(name = "cmcRandomDigits")
  protected Integer cmcRandomDigits;


  /** TODO: DOCUMENT ME! */
  @Column(name = "commercialIncorpDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date commercialIncorpDate;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "commercialLegalName",
    length = 255
  )
  protected String commercialLegalName;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "commercialName",
    length = 255
  )
  protected String commercialName;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "commercialTradingAs",
    length = 255
  )
  protected String commercialTradingAs;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "complaintMsg",
    length = 200
  )
  protected String complaintMsg;

  /** TODO: DOCUMENT ME! */
  @OneToOne(
    fetch         = FetchType.LAZY,
    mappedBy      = "customer",
    cascade       = { CascadeType.ALL },
    orphanRemoval = true
  )
  protected CustomerAdditionalDetail customerAdditionalDetail;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "customerId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long customerId;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "customerName",
    length = 255
  )
  protected String customerName;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "customer",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @OrderBy("createDate desc")
  protected List<CustomerScore> customerScores = new ArrayList<CustomerScore>();

  /** Date of birth. */
  @Column(name = "dateOfBirth")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date dateOfBirth;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "defaultMRASortingToken",
    length = 45
  )
  protected String defaultMRASortingToken;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "dns",
    length = 30
  )
  protected Long dns;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "driversLicenceNo",
    length = 50
  )
  protected String driversLicenceNo;

  /** TODO: DOCUMENT ME! */
  @MapKeyColumn(name = "typeId")
  @OneToMany(
    cascade  = CascadeType.ALL,
    fetch    = FetchType.LAZY,
    mappedBy = "customer"
  )
  @Where(clause = "historical is null or historical='N'")
  protected Map<String, CustomerContactEmail> emails = new HashMap<String, CustomerContactEmail>();

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "employerName",
    length = 50
  )
  protected String employerName;

  /** TODO: DOCUMENT ME! */
  @Column(length = 50)
  protected String employmentStatus;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "firstName",
    length = 45
  )
  protected String firstName;

  /** The date of the FIRST time a customer ever logged into the Website. */
  @Column(name = "firstWebLoginDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date firstWebLoginDate;

  /** Relations Customer FundingAccount : */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "customer",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @OrderBy("customerDefault desc")
  protected Set<FundingAccount> fundingAccounts = new LinkedHashSet<FundingAccount>();


  /** TODO: DOCUMENT ME! */
  @MapKeyColumn(name = "typeId")
  @OneToMany(
    cascade  = CascadeType.ALL,
    fetch    = FetchType.LAZY,
    mappedBy = "customer"
  )
  @Where(clause = "historical is null or historical='N'")
  protected Map<String, FuturePermanentCustomerContactAddress> futurePermanentAddresses =
    new HashMap<String, FuturePermanentCustomerContactAddress>();


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    cascade  = CascadeType.ALL,
    fetch    = FetchType.LAZY,
    mappedBy = "customer"
  )
  @Where(clause = "historical='Y'")
  protected Set<FuturePermanentCustomerContactAddress> futurePermanentHistoricalAddresses =
    new LinkedHashSet<FuturePermanentCustomerContactAddress>();

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    cascade  = CascadeType.ALL,
    fetch    = FetchType.LAZY,
    mappedBy = "customer"
  )
  @Where(clause = "historical='Y'")
  protected Set<FuturePermanentCustomerContactPhone> futurePermanentHistoricalPhones =
    new LinkedHashSet<FuturePermanentCustomerContactPhone>();

  /** TODO: DOCUMENT ME! */
  @MapKeyColumn(name = "typeId")
  @OneToMany(
    cascade  = CascadeType.ALL,
    fetch    = FetchType.LAZY,
    mappedBy = "customer"
  )
  @Where(clause = "historical is null or historical='N'")
  protected Map<String, FuturePermanentCustomerContactPhone> futurePermanentPhones =
    new HashMap<String, FuturePermanentCustomerContactPhone>();

  /** gender. */
  @Column(
    name   = "gender",
    length = 1
  )
  protected String gender;

  /** TODO: DOCUMENT ME! */
  @Column protected BigDecimal grossAdditionalIncome;

  /** TODO: DOCUMENT ME! */
  @Column(name = "grossIndividualIncome")
  protected BigDecimal grossIndividualIncome;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "hasBankOwnedAccount",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean hasBankOwnedAccount;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    cascade  = CascadeType.ALL,
    fetch    = FetchType.LAZY,
    mappedBy = "customer"
  )
  @OrderBy("createDate desc")
  @Where(clause = "historical='Y'")
  protected Set<CustomerContactAddress> historicalAddresses = new LinkedHashSet<CustomerContactAddress>();

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    cascade  = CascadeType.ALL,
    fetch    = FetchType.LAZY,
    mappedBy = "customer"
  )
  @OrderBy("createDate desc")
  @Where(clause = "historical='Y'")
  protected Set<CustomerContactEmail> historicalEmails = new LinkedHashSet<CustomerContactEmail>();

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    cascade  = CascadeType.ALL,
    fetch    = FetchType.LAZY,
    mappedBy = "customer"
  )
  @OrderBy("createDate desc")
  @Where(clause = "historical='Y'")
  protected Set<CustomerContactPhone> historicalPhones = new LinkedHashSet<CustomerContactPhone>();

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "industry",
    length = 50
  )
  protected String industry;

  /** TODO: DOCUMENT ME! */
  @Transient protected boolean isZipRequiredFull = false;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "jobCode",
    length = 255
  )
  protected String jobCode;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "languageCode",
    length = 255
  )
  protected String languageCode;

  /** TODO: DOCUMENT ME! */
  @Column(name = "lastLoginDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date lastLoginDate;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "lastName",
    length = 55
  )
  protected String lastName;

  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "lastPaymentAmount",
    precision = 19,
    scale     = 2
  )
  protected BigDecimal lastPaymentAmount;

  /** TODO: DOCUMENT ME! */
  @Column(name = "lastPaymentDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date lastPaymentDate;

  /** TODO: DOCUMENT ME! */
  @Column(name = "leadAccountNum")
  protected Long leadAccountNum;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "maritalStatus",
    length = 50
  )
  protected String maritalStatus;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "matchConfidence",
    length = 250
  )
  protected String matchConfidence;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "customer",
    cascade  = { CascadeType.ALL, CascadeType.REMOVE }
  )
  protected Set<MemoryMessage> memoryMessages = new LinkedHashSet<MemoryMessage>();

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "middleName",
    length = 45
  )
  protected String middleName;

  /** TODO: DOCUMENT ME! */
  @Column(name = "minimumPayDue")
  protected BigDecimal minimumPayDue;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "motherMaidenName",
    length = 55
  )
  protected String motherMaidenName;

  /** TODO: DOCUMENT ME! */
  @Column(name = "natureOfBusiness")
  protected String natureOfBusiness;

  /** TODO: DOCUMENT ME! */
  @Column(name = "numberOfAccounts")
  protected Long numberOfAccounts;

  /** TODO: DOCUMENT ME! */
  @Column(name = "pastDue")
  protected BigDecimal pastDue;

  /** TODO: DOCUMENT ME! */
  @Column(name = "paymentDueDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date paymentDueDate;

  /** TODO: DOCUMENT ME! */
  @MapKeyColumn(name = "typeId")
  @OneToMany(
    cascade  = CascadeType.ALL,
    fetch    = FetchType.LAZY,
    mappedBy = "customer"
  )
  @Where(clause = "historical is null or historical='N'")
  protected Map<String, CustomerContactPhone> phones = new HashMap<String, CustomerContactPhone>();

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "placeOfBirth",
    length = 200
  )
  protected String placeOfBirth;

  /** DOCUMENT ME! */
  @JoinColumn(
    name      = "portfolioId",
    updatable = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected Portfolio portfolio;

  /** communication preference: Home Address */
  @Column(name = "preferHomeAddress")
  protected Integer preferHomeAddress;

  /** communication preference: Home Email. Integer means the order of communication - not used for now */
  @Column(name = "preferHomeEmail")
  protected Integer preferHomeEmail;

  /** communication preference: Home Phone */
  @Column(name = "preferHomePhone")
  protected Integer preferHomePhone;

  /** communication preference: Mobile Phone */
  @Column(name = "preferMobilePhone")
  protected Integer preferMobilePhone;

  /** communication preference: Text Message */
  @Column(name = "preferTextMessage")
  protected Integer preferTextMessage;

  /** communication preference: Work Phone */
  @Column(name = "preferWorkPhone")
  protected Integer preferWorkPhone;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "customer",
    cascade  = { CascadeType.REMOVE, CascadeType.ALL }
  )
  protected Set<ResponsibleIndex> responsibleIndexs = new LinkedHashSet<ResponsibleIndex>();

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "riskRating",
    length = 50
  )
  protected String riskRating;


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "customer",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @OrderBy("scoreOrder asc")
  protected List<CustomerScore> slmFicoScores = new ArrayList<CustomerScore>();

  /** TODO: DOCUMENT ME! */
  @OneToOne(
    fetch         = FetchType.LAZY,
    mappedBy      = "customer",
    cascade       = { CascadeType.ALL },
    orphanRemoval = true
  )
  protected SMWCustomerAdditionalDetail smwCustomerAdditionalDetail;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "socialInsuranceNumber",
    length = 255
  )
  protected String socialInsuranceNumber;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "sourceOfAdditionalIncome",
    length = 255
  )
  protected String sourceOfAdditionalIncome;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "sourceOfMainIncome",
    length = 255
  )
  protected String sourceOfMainIncome;

  /** S.S.N. */
  @Column(
    name   = "ssn",
    length = 50
  )
  @Convert(converter = StringEncryptionConverter.class)
  protected String ssn;

  /** TODO: DOCUMENT ME! */
  @MapKeyColumn(name = "typeId")
  @OneToMany(
    cascade  = CascadeType.ALL,
    fetch    = FetchType.LAZY,
    mappedBy = "customer"
  )
  @Where(clause = "historical is null or historical='N'")
  protected Map<String, TemporaryCustomerContactAddress> temporaryAddresses =
    new HashMap<String, TemporaryCustomerContactAddress>();

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    cascade  = CascadeType.ALL,
    fetch    = FetchType.LAZY,
    mappedBy = "customer"
  )
  @Where(clause = "historical='Y'")
  protected Set<TemporaryCustomerContactAddress> temporaryHistoricalAddresses =
    new LinkedHashSet<TemporaryCustomerContactAddress>();

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    cascade  = CascadeType.ALL,
    fetch    = FetchType.LAZY,
    mappedBy = "customer"
  )
  @Where(clause = "historical='Y'")
  protected Set<TemporaryCustomerContactPhone> temporaryHistoricalPhones =
    new LinkedHashSet<TemporaryCustomerContactPhone>();

  /** TODO: DOCUMENT ME! */
  @MapKeyColumn(name = "typeId")
  @OneToMany(
    cascade  = CascadeType.ALL,
    fetch    = FetchType.LAZY,
    mappedBy = "customer"
  )
  @Where(clause = "historical is null or historical='N'")
  protected Map<String, TemporaryCustomerContactPhone> temporaryPhones =
    new HashMap<String, TemporaryCustomerContactPhone>();

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "title",
    length = 255
  )
  protected String title;

  /** TODO: DOCUMENT ME! */
  @Column(name = "totalDue")
  protected BigDecimal totalDue;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "type",
    length = 1
  )
  protected String type;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "ucid",
    length = 100
  )
  protected String ucid;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "under18Msg",
    length = 200
  )
  protected String under18Msg;


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "customer"
  )
  @OrderBy("lastUpdateDate desc")
  @Where(clause = "source='AGENT' or source='DEBTOR'")
  protected Set<CustomerContactAddress> webUpdateAddress = new LinkedHashSet<CustomerContactAddress>();

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "customer"
  )
  @OrderBy("lastUpdateDate desc")
  @Where(clause = "source='AGENT' or source='DEBTOR'")
  protected Set<CustomerContactEmail> webUpdateEmails = new LinkedHashSet<CustomerContactEmail>();

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "customer"
  )
  @OrderBy("lastUpdateDate desc")
  @Where(clause = "source='AGENT' or source='DEBTOR'")
  protected Set<CustomerContactPhone> webUpdatePhones = new LinkedHashSet<CustomerContactPhone>();

  /** zip code, for user login. */
  @Column(
    name   = "zipCode",
    length = 25
  )
  protected String zipCode;

  /** zip code changed, user need to use the new zip code to login. */
  @Transient protected boolean zipCodeChanged = false;

  @Transient private List<Responsible> cosignedResponsibles = new ArrayList<Responsible>();

  @Transient private Responsible currentResponsible;

  @Transient private Date ficoScoreLastUpdateDate;

  @Transient private Boolean isCosigner;

  @Transient private Set<String> personaSet;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addAddress.
   *
   * @param  address  CustomerContactAddress
   */
  public void addAddress(CustomerContactAddress address) {
    getAddresses().put(address.getAddressType().getTypeId().toString(),
      address);
    address.setCustomer(this);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addCustomerAdditionalDetail.
   *
   * @param  customerAdditionalDetail  CustomerAdditionalDetail
   */
  public void addCustomerAdditionalDetail(CustomerAdditionalDetail customerAdditionalDetail) {
    customerAdditionalDetail.setCustomer(this);
    setCustomerAdditionalDetail(customerAdditionalDetail);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addCustomerScore.
   *
   * @param  customerScore  CustomerScore
   */
  public void addCustomerScore(CustomerScore customerScore) {
    getCustomerScores().add(customerScore);
    customerScore.setCustomer(this);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addEmail.
   *
   * @param  email  CustomerContactEmail
   */
  public void addEmail(CustomerContactEmail email) {
    getEmails().put(email.getEmailType().getTypeId().toString(), email);
    email.setCustomer(this);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addHistoricalAddress.
   *
   * @param  historicalAddress  CustomerContactAddress
   */
  public void addHistoricalAddress(CustomerContactAddress historicalAddress) {
    historicalAddress.setCustomer(this);
    historicalAddress.setHistorical(Boolean.TRUE);
    this.historicalAddresses.add(historicalAddress);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addPhone.
   *
   * @param  phone  CustomerContactPhone
   */
  public void addPhone(CustomerContactPhone phone) {
    getPhones().put(phone.getPhoneType().getTypeId().toString(), phone);
    phone.setCustomer(this);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * convertToContactPhone.
   *
   * @param   phoneNum       String
   * @param   channel        ContactChannel
   * @param   contactSource  ContactSource
   * @param   contactStatus  ContactStatus
   *
   * @return  CustomerContactPhone
   */
  public CustomerContactPhone convertToContactPhone(String phoneNum, ContactChannel channel,
    ContactSource contactSource,
    ContactStatus contactStatus) {
    phoneNum = phoneNum.replaceAll("[^0-9]", "");

    if (StringUtils.hasText(phoneNum)) {
      CustomerContactPhone phone = new CustomerContactPhone();
      phone.setPhoneType(new PhoneType(channel.getTypeId(),
          channel.toString()));
      phone.setPhoneNum(phoneNum);
      phone.setSource(contactSource);
      phone.setStatus(contactStatus);

      return phone;
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   obj  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (obj == null) {
      return false;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    final Customer other = (Customer) obj;

    if (ucid == null) {
      if (other.getUcid() != null) {
        return false;
      }
    } else if (!ucid.equals(
            other.getUcid())) {
      return false;
    }

    if (dateOfBirth == null) {
      if (other.getDateOfBirth() != null) {
        return false;
      }
    } else if (!dateOfBirth.equals(
            other.getDateOfBirth())) {
      return false;
    }

    if (portfolio == null) {
      if (other.getPortfolio() != null) {
        return false;
      }
    } else if (!portfolio.equals(other.getPortfolio())) {
      return false;
    }

    if (ssn == null) {
      if (other.getSsn() != null) {
        return false;
      }
    } else if (!ssn.equals(
            other.getSsn())) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findBusinessPhoneContainHistorical.
   *
   * @return  CustomerContactPhone
   */
  public CustomerContactPhone findBusinessPhoneContainHistorical() {
    CustomerContactPhone phone;
    phone = getPhone(ContactChannel.BUSINESSPHONE.getStringTypeId());

    if (null == phone) {
      for (CustomerContactPhone historicalPhone : historicalPhones) {
        if (historicalPhone.getPhoneType().getTypeId().equals(ContactChannel.BUSINESSPHONE.getTypeId())) {
          phone = historicalPhone;

          break;
        }
      }
    }

    return phone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findHomeAddressContainHistorical.
   *
   * @return  CustomerContactAddress
   */
  public CustomerContactAddress findHomeAddressContainHistorical() {
    CustomerContactAddress address;
    address = getAddress(ContactChannel.HOMEADDRESS.getStringTypeId());

    if (null == address) {
      for (CustomerContactAddress historicalAddress : historicalAddresses) {
        if (historicalAddress.getAddressType().getTypeId().equals(ContactChannel.HOMEADDRESS.getTypeId())) {
          address = historicalAddress;

          break;
        }
      }
    }

    return address;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findHomePhoneContainHistorical.
   *
   * @return  CustomerContactPhone
   */
  public CustomerContactPhone findHomePhoneContainHistorical() {
    CustomerContactPhone phone;
    phone = getPhone(ContactChannel.HOMEPHONE.getStringTypeId());

    if (null == phone) {
      for (CustomerContactPhone historicalPhone : historicalPhones) {
        if (historicalPhone.getPhoneType().getTypeId().equals(ContactChannel.HOMEPHONE.getTypeId())) {
          phone = historicalPhone;

          break;
        }
      }
    }

    return phone;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findWorkPhoneContainHistorical.
   *
   * @return  CustomerContactPhone
   */
  public CustomerContactPhone findWorkPhoneContainHistorical() {
    CustomerContactPhone phone;
    phone = getPhone(ContactChannel.WORKPHONE.getStringTypeId());

    if (null == phone) {
      for (CustomerContactPhone historicalPhone : historicalPhones) {
        if (historicalPhone.getPhoneType().getTypeId().equals(ContactChannel.WORKPHONE.getTypeId())) {
          phone = historicalPhone;

          break;
        }
      }
    }

    return phone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for abn.
   *
   * @return  String
   */
  public String getAbn() {
    return abn;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public List<String> getAccountPortfolios() {
    Set<String> portfolioIdsSet = new HashSet<String>();

    for (ResponsibleIndex responsibleIndex : getActiveResponsibleIndexs()) {
      if (responsibleIndex.getResponsible().getAccount() != null) {
        portfolioIdsSet.add(responsibleIndex.getResponsible().getAccount().getPortfolio().getPortfolioId().toString());
      }
    }

    List<String> portfolioIdsList = new ArrayList<String>();

    if (portfolioIdsSet.size() > 0) {
      portfolioIdsList.addAll(portfolioIdsSet);
    }

    log.info("portfolioIdsList: " + portfolioIdsList);

    return portfolioIdsList;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account primary funding account.
   *
   * @return  FundingAccount
   */
  public FundingAccount getAccountPrimaryFundingAccount() {
    if ((null != fundingAccounts) && (fundingAccounts.size() > 0)) {
      List<FundingAccount> fundingAccountList = new ArrayList<FundingAccount>();
      fundingAccountList.addAll(fundingAccounts);

      FundingAccount primaryFundingAccount = null;

      for (FundingAccount tempFundingAccount : fundingAccountList) {
        if (tempFundingAccount.getCustomerDefault()) {
          primaryFundingAccount = tempFundingAccount;

          break;
        }
      }

      if (null == primaryFundingAccount) {
        return fundingAccountList.get(0);
      } else {
        return primaryFundingAccount;
      }
    } // end if

    return null;
  } // end method getAccountPrimaryFundingAccount

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for acn.
   *
   * @return  String
   */
  public String getAcn() {
    return acn;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for active.
   *
   * @return  Boolean
   */
  public Boolean getActive() {
    if (active == null) {
      return Boolean.TRUE;
    }

    return active;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<Responsible> getActiveCustomerResponsibles() {
    Set<Responsible> responsibles = new LinkedHashSet<Responsible>();

    for (ResponsibleIndex responsibleIndex : this.activeResponsibleIndexs) {
      responsibles.add(responsibleIndex.getResponsible());
    }

    return responsibles;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible indexs.
   *
   * @return  Set
   */
  public Set<ResponsibleIndex> getActiveResponsibleIndexs() {
    return activeResponsibleIndexs;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Return address by type. The type is StringTypeId:
   *
   * <p>getAddress(ContactChannel.HOMEADDRESS.getStringTypeId())</p>
   *
   * @param   type  DOCUMENT ME!
   *
   * @return  return address by type.
   */
  public CustomerContactAddress getAddress(String type) {
    return addresses.get(type);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for address.
   *
   * @param   channel  ContactChannel
   *
   * @return  CustomerContactAddress
   */
  public CustomerContactAddress getAddress(ContactChannel channel) {
    if (channel == null) {
      return null;
    }

    if (ContactChannelType.ADDRESS.equals(channel.getChannelType())) {
      return addresses.get(channel.getStringTypeId());
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for address by type.
   *
   * @param   addressType  AddressType
   *
   * @return  CustomerContactAddress
   */
  public CustomerContactAddress getAddressByType(AddressType addressType) {
    return getAddresses().get(addressType.getTypeId().toString());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for addresses.
   *
   * @return  Map
   */
  public Map<String, CustomerContactAddress> getAddresses() {
    return addresses;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // end method updateZipCode
  /**
   * getter method for all bank accounts.
   *
   * @return  List
   */
  public List<FundingAccount> getAllBankAccounts() {
    ArrayList<FundingAccount> bankList = new ArrayList<FundingAccount>();

    for (FundingAccount fundingAccount : fundingAccounts) {
      String type = fundingAccount.getFundingInformation().getType();

      if (FundingAccountType.BANKACCOUNT.toString().equalsIgnoreCase(
              type)) {
        bankList.add(fundingAccount);
      }
    }

    return bankList;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for all card accounts.
   *
   * @return  List
   */
  public List<FundingAccount> getAllCardAccounts() {
    ArrayList<FundingAccount> cardList = new ArrayList<FundingAccount>();

    for (FundingAccount fundingAccount : fundingAccounts) {
      String type = fundingAccount.getFundingInformation().getType();

      if (FundingAccountType.CREDITCARD.toString().equalsIgnoreCase(
              type)
            || FundingAccountType.DEBITCARD.toString().equalsIgnoreCase(
              type)) {
        cardList.add(fundingAccount);
      }
    }

    return cardList;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for all emails.
   *
   * @return  List
   */
  public List<CustomerContactEmail> getAllEmails() {
    return allEmails;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for all phone numbers.
   *
   * @return  String
   */
  public String getAllPhoneNumbers() {
    String phoneString = "";

    // get all zip codes and kill the duplications
    Set<String> phoneNumbers = new LinkedHashSet<String>();

    for (CustomerContactPhone phone : phones.values()) {
      phoneNumbers.add(phone.phoneNum);
    }

    // compile the list to one string
    for (String string : phoneNumbers) {
      if (!phoneString.isEmpty()) {
        // skip the first one
        phoneString += ", ";
      }

      phoneString += string;
    }

    return phoneString;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for all phones.
   *
   * @return  List
   */
  public List<CustomerContactPhone> getAllPhones() {
    return allPhones;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for all zip codes.
   *
   * @return  String
   */
  public String getAllZipCodes() {
    String zipString = "";

    // get all zip codes and kill the duplications
    Set<String> zips = new LinkedHashSet<String>();

    for (CustomerContactAddress address : addresses.values()) {
      zips.add(address.getAddress().getPostalCode());
    }

    // compile the list to one string
    for (String string : zips) {
      if (!zipString.isEmpty()) {
        // skip the first one
        zipString += ", ";
      }

      zipString += string;
    }

    return zipString;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for appointment phone.
   *
   * @return  CustomerContactPhone
   */
  public CustomerContactPhone getAppointmentPhone() {
    return getPhone(ContactChannel.APPOINTMENTPHONE.getStringTypeId());
  }

  // ------------------------------------------------------------------------------------------------------------------

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
   * getter method for banned msg.
   *
   * @return  String
   */
  public String getBannedMsg() {
    return bannedMsg;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   portfolioId  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getBorrowerMaxDelinquencyDaysByPortfolio(String portfolioId) {
    int      maxDays  = 0;
    Iterator iterator = getActiveResponsibleIndexs().iterator();

    while (iterator.hasNext()) {
      ResponsibleIndex responsibleIndex = (ResponsibleIndex) iterator.next();
      Responsible      responsible      = responsibleIndex.getResponsible();

      if ((responsible != null) && responsible.getPrimaryHolder() && responsible.getAccount().getActive()
            && (portfolioId.indexOf(responsible.getAccount().getPortfolio().getPortfolioId().toString()) != -1)) {
        if (responsible.getAccount().getDelinquencyDays() > maxDays) {
          maxDays = responsible.getAccount().getDelinquencyDays();
        }
      }
    }

    return maxDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   portfolioId  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getBorrowerTotalBalanceByPortfolio(String portfolioId) {
    BigDecimal total    = new BigDecimal(0);
    Iterator   iterator = getResponsibleIndexs().iterator();

    while (iterator.hasNext()) {
      ResponsibleIndex responsibleIndex = (ResponsibleIndex) iterator.next();
      Responsible      responsible      = responsibleIndex.getResponsible();

      if ((responsible != null) && responsible.getPrimaryHolder() && responsible.getAccount().getActive()
            && (portfolioId.indexOf(responsible.getAccount().getPortfolio().getPortfolioId().toString()) != -1)) {
        total = total.add(responsible.getAccount().getBalance());
      }
    }

    return total;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   portfolioId  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getBorrowerTotalDueAmountByPortfolio(String portfolioId) {
    BigDecimal total    = new BigDecimal(0);
    Iterator   iterator = getResponsibleIndexs().iterator();

    while (iterator.hasNext()) {
      ResponsibleIndex responsibleIndex = (ResponsibleIndex) iterator.next();
      Responsible      responsible      = responsibleIndex.getResponsible();

      if ((responsible != null) && responsible.getPrimaryHolder() && responsible.getAccount().getActive()
            && (portfolioId.indexOf(responsible.getAccount().getPortfolio().getPortfolioId().toString()) != -1)) {
        total = total.add(responsible.getAccount().getClientDefinedDecimal1());
      }
    }

    return total;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   portfolioId  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getBorrowerTotalMinimumPaymentAmountByPortfolio(String portfolioId) {
    BigDecimal total    = new BigDecimal(0);
    Iterator   iterator = getResponsibleIndexs().iterator();

    while (iterator.hasNext()) {
      ResponsibleIndex responsibleIndex = (ResponsibleIndex) iterator.next();
      Responsible      responsible      = responsibleIndex.getResponsible();

      if ((responsible != null) && responsible.getPrimaryHolder() && responsible.getAccount().getActive()
            && (portfolioId.indexOf(responsible.getAccount().getPortfolio().getPortfolioId().toString()) != -1)) {
        total = total.add(responsible.getAccount().getMinimumPayDue());
      }
    }

    return total;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   portfolioId  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getBorrowerTotalPastDueAmountByPortfolio(String portfolioId) {
    BigDecimal total    = new BigDecimal(0);
    Iterator   iterator = getResponsibleIndexs().iterator();

    while (iterator.hasNext()) {
      ResponsibleIndex responsibleIndex = (ResponsibleIndex) iterator.next();
      Responsible      responsible      = responsibleIndex.getResponsible();

      if ((responsible != null) && responsible.getPrimaryHolder() && responsible.getAccount().getActive()
            && (portfolioId.indexOf(responsible.getAccount().getPortfolio().getPortfolioId().toString()) != -1)) {
        total = total.add(responsible.getAccount().getPastDue());
      }
    }

    return total;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bureau address1 assessment.
   *
   * @return  String
   */
  public String getBureauAddress1Assessment() {
    CustomerContactAddress contactAddress = getAddress(ContactChannel.BUREAUADDRESS1.getStringTypeId());

    if (contactAddress != null) {
      return contactAddress.getAssessment();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bureau address1 data source.
   *
   * @return  String
   */
  public String getBureauAddress1DataSource() {
    CustomerContactAddress contactAddress = getAddress(ContactChannel.BUREAUADDRESS1.getStringTypeId());

    if (contactAddress != null) {
      return contactAddress.getBureauAddressSource();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bureau address1 last verified.
   *
   * @return  Date
   */
  public Date getBureauAddress1LastVerified() {
    CustomerContactAddress contactAddress = getAddress(ContactChannel.BUREAUADDRESS1.getStringTypeId());

    if (contactAddress != null) {
      return contactAddress.getVerifiedDate();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bureau address1 output.
   *
   * @return  String
   */
  public String getBureauAddress1Output() {
    CustomerContactAddress contactAddress = getAddress(ContactChannel.BUREAUADDRESS1.getStringTypeId());

    if (contactAddress != null) {
      return contactAddress.getBureauAddressType();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bureau address2 data source.
   *
   * @return  String
   */
  public String getBureauAddress2DataSource() {
    CustomerContactAddress contactAddress = getAddress(ContactChannel.BUREAUADDRESS2.getStringTypeId());

    if (contactAddress != null) {
      return contactAddress.getBureauAddressSource();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bureau address2 last verified.
   *
   * @return  Date
   */
  public Date getBureauAddress2LastVerified() {
    CustomerContactAddress contactAddress = getAddress(ContactChannel.BUREAUADDRESS2.getStringTypeId());

    if (contactAddress != null) {
      return contactAddress.getVerifiedDate();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bureau address3 data source.
   *
   * @return  String
   */
  public String getBureauAddress3DataSource() {
    CustomerContactAddress contactAddress = getAddress(ContactChannel.BUREAUADDRESS3.getStringTypeId());

    if (contactAddress != null) {
      return contactAddress.getBureauAddressSource();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bureau address3 last verified.
   *
   * @return  Date
   */
  public Date getBureauAddress3LastVerified() {
    CustomerContactAddress contactAddress = getAddress(ContactChannel.BUREAUADDRESS3.getStringTypeId());

    if (contactAddress != null) {
      return contactAddress.getVerifiedDate();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bureau city address1.
   *
   * @return  String
   */
  public String getBureauCityAddress1() {
    CustomerContactAddress contactAddress = getAddress(ContactChannel.BUREAUADDRESS1.getStringTypeId());

    if (contactAddress != null) {
      return contactAddress.getAddress().getCity();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bureau city address2.
   *
   * @return  String
   */
  public String getBureauCityAddress2() {
    CustomerContactAddress contactAddress = getAddress(ContactChannel.BUREAUADDRESS2.getStringTypeId());

    if (contactAddress != null) {
      return contactAddress.getAddress().getCity();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bureau city address3.
   *
   * @return  String
   */
  public String getBureauCityAddress3() {
    CustomerContactAddress contactAddress = getAddress(ContactChannel.BUREAUADDRESS3.getStringTypeId());

    if (contactAddress != null) {
      return contactAddress.getAddress().getCity();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bureau DPID1.
   *
   * @return  String
   */
  public Integer getBureauDPID1() {
    CustomerContactAddress contactAddress = getAddress(ContactChannel.BUREAUADDRESS1.getStringTypeId());

    if (contactAddress != null) {
      return contactAddress.getPostalIdentificationNumber();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bureau DPID2.
   *
   * @return  Integer
   */
  public Integer getBureauDPID2() {
    CustomerContactAddress contactAddress = getAddress(ContactChannel.BUREAUADDRESS2.getStringTypeId());

    if (contactAddress != null) {
      return contactAddress.getPostalIdentificationNumber();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bureau DPID3.
   *
   * @return  Integer
   */
  public Integer getBureauDPID3() {
    CustomerContactAddress contactAddress = getAddress(ContactChannel.BUREAUADDRESS3.getStringTypeId());

    if (contactAddress != null) {
      return contactAddress.getPostalIdentificationNumber();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bureau phone1.
   *
   * @return  String
   */
  public String getBureauPhone1() {
    CustomerContactPhone contactPhone = getPhone(ContactChannel.BUREAUPHONE1.getStringTypeId());

    if (contactPhone != null) {
      return contactPhone.getPhoneNum();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bureau phone1 date.
   *
   * @return  Date
   */
  public Date getBureauPhone1Date() {
    CustomerContactPhone contactPhone = getPhone(ContactChannel.BUREAUPHONE1.getStringTypeId());

    if (contactPhone != null) {
      return contactPhone.getBureauUpdatedDate();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bureau phone1 source.
   *
   * @return  String
   */
  public String getBureauPhone1Source() {
    CustomerContactPhone contactPhone = getPhone(ContactChannel.BUREAUPHONE1.getStringTypeId());

    if (contactPhone != null) {
      return contactPhone.getBureauPhoneSource();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bureau phone2.
   *
   * @return  String
   */
  public String getBureauPhone2() {
    CustomerContactPhone contactPhone = getPhone(ContactChannel.BUREAUPHONE2.getStringTypeId());

    if (contactPhone != null) {
      return contactPhone.getPhoneNum();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bureau phone2 date.
   *
   * @return  Date
   */
  public Date getBureauPhone2Date() {
    CustomerContactPhone contactPhone = getPhone(ContactChannel.BUREAUPHONE2.getStringTypeId());

    if (contactPhone != null) {
      return contactPhone.getBureauUpdatedDate();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bureau phone2 source.
   *
   * @return  String
   */
  public String getBureauPhone2Source() {
    CustomerContactPhone contactPhone = getPhone(ContactChannel.BUREAUPHONE2.getStringTypeId());

    if (contactPhone != null) {
      return contactPhone.getBureauPhoneSource();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bureau phone3.
   *
   * @return  String
   */
  public String getBureauPhone3() {
    CustomerContactPhone contactPhone = getPhone(ContactChannel.BUREAUPHONE3.getStringTypeId());

    if (contactPhone != null) {
      return contactPhone.getPhoneNum();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bureau phone3 date.
   *
   * @return  Date
   */
  public Date getBureauPhone3Date() {
    CustomerContactPhone contactPhone = getPhone(ContactChannel.BUREAUPHONE3.getStringTypeId());

    if (contactPhone != null) {
      return contactPhone.getBureauUpdatedDate();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bureau phone3 source.
   *
   * @return  String
   */
  public String getBureauPhone3Source() {
    CustomerContactPhone contactPhone = getPhone(ContactChannel.BUREAUPHONE3.getStringTypeId());

    if (contactPhone != null) {
      return contactPhone.getBureauPhoneSource();
    }

    return null;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bureau postal code1.
   *
   * @return  String
   */
  public String getBureauPostalCode1() {
    CustomerContactAddress contactAddress = getAddress(ContactChannel.BUREAUADDRESS1.getStringTypeId());

    if (contactAddress != null) {
      return contactAddress.getAddress().getPostalCode();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bureau postal code2.
   *
   * @return  String
   */
  public String getBureauPostalCode2() {
    CustomerContactAddress contactAddress = getAddress(ContactChannel.BUREAUADDRESS2.getStringTypeId());

    if (contactAddress != null) {
      return contactAddress.getAddress().getPostalCode();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bureau postal code3.
   *
   * @return  String
   */
  public String getBureauPostalCode3() {
    CustomerContactAddress contactAddress = getAddress(ContactChannel.BUREAUADDRESS3.getStringTypeId());

    if (contactAddress != null) {
      return contactAddress.getAddress().getPostalCode();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bureau state address1.
   *
   * @return  String
   */
  public String getBureauStateAddress1() {
    CustomerContactAddress contactAddress = getAddress(ContactChannel.BUREAUADDRESS1.getStringTypeId());

    if (contactAddress != null) {
      return contactAddress.getAddress().getProvince();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bureau state address2.
   *
   * @return  String
   */
  public String getBureauStateAddress2() {
    CustomerContactAddress contactAddress = getAddress(ContactChannel.BUREAUADDRESS2.getStringTypeId());

    if (contactAddress != null) {
      return contactAddress.getAddress().getProvince();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bureau state address3.
   *
   * @return  String
   */
  public String getBureauStateAddress3() {
    CustomerContactAddress contactAddress = getAddress(ContactChannel.BUREAUADDRESS3.getStringTypeId());

    if (contactAddress != null) {
      return contactAddress.getAddress().getProvince();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bureau street address1.
   *
   * @return  String
   */
  public String getBureauStreetAddress1() {
    CustomerContactAddress contactAddress = getAddress(ContactChannel.BUREAUADDRESS1.getStringTypeId());

    if (contactAddress != null) {
      return contactAddress.getAddress().getAddress1();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bureau street address2.
   *
   * @return  String
   */
  public String getBureauStreetAddress2() {
    CustomerContactAddress contactAddress = getAddress(ContactChannel.BUREAUADDRESS2.getStringTypeId());

    if (contactAddress != null) {
      return contactAddress.getAddress().getAddress1();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bureau street address3.
   *
   * @return  String
   */
  public String getBureauStreetAddress3() {
    CustomerContactAddress contactAddress = getAddress(ContactChannel.BUREAUADDRESS3.getStringTypeId());

    if (contactAddress != null) {
      return contactAddress.getAddress().getAddress1();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for business phone.
   *
   * @return  CustomerContactPhone
   */
  public CustomerContactPhone getBusinessPhone() {
    return getPhone(ContactChannel.BUSINESSPHONE.getStringTypeId());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for business phone str.
   *
   * @return  String
   */
  public String getBusinessPhoneStr() {
    CustomerContactPhone contactPhone = getBusinessPhone();

    if (contactPhone != null) {
      return contactPhone.getPhoneNum();
    } else {
      return "";
    }
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client info create date.
   *
   * @return  Date
   */
  public Date getClientInfoCreateDate() {
    return clientInfoCreateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client info update date.
   *
   * @return  Date
   */
  public Date getClientInfoUpdateDate() {
    return clientInfoUpdateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for cmc random digits.
   *
   * @return  Integer
   */
  public Integer getCmcRandomDigits() {
    return cmcRandomDigits;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for commercial incorp date.
   *
   * @return  Date
   */
  public Date getCommercialIncorpDate() {
    return commercialIncorpDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for commercial legal name.
   *
   * @return  String
   */
  public String getCommercialLegalName() {
    return commercialLegalName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for commercial name.
   *
   * @return  String
   */
  public String getCommercialName() {
    return commercialName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for commercial trading as.
   *
   * @return  String
   */
  public String getCommercialTradingAs() {
    return commercialTradingAs;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for complaint msg.
   *
   * @return  String
   */
  public String getComplaintMsg() {
    return complaintMsg;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get contactable home phone number, return empty string if there is no such number or the phone is not contactable.
   *
   * @return  get contactable home phone number, return empty string if there is no such number or the phone is not
   *          contactable
   */
  public String getContactableHomePhoneStr() {
    if (Boolean.TRUE.equals(this.getDoNotContact())) {
      return "";
    }

    CustomerContactPhone contactPhone = getHomePhone();

    if ((contactPhone == null) || (!contactPhone.isValidNumber())
          || Boolean.TRUE.equals(contactPhone.getDoNotContact())
          || Boolean.TRUE.equals(contactPhone.getWrongInfo())) {
      return "";
    } else {
      return contactPhone.getPhoneNum();
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * Get contactable mobile phone.
   *
   * @return  get contactable mobile phone
   */
  public CustomerContactPhone getContactableMobilePhone() {
    if (Boolean.TRUE.equals(this.getDoNotContact())) {
      return null;
    }

    CustomerContactPhone contactPhone = getMobilePhone();

    if ((contactPhone == null) || (!contactPhone.isValidNumber())
          || Boolean.TRUE.equals(contactPhone.getDoNotContact())
          || Boolean.TRUE.equals(contactPhone.getWrongInfo())) {
      return null;
    }

    return contactPhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get contactable mobile phone number, return empty string if there is no such number or the phone is not
   * contactable.
   *
   * @return  get contactable mobile phone number, return empty string if there is no such number or the phone is not
   *          contactable
   */
  public String getContactableMobilePhoneStr() {
    if (Boolean.TRUE.equals(this.getDoNotContact())) {
      return "";
    }

    CustomerContactPhone contactPhone = getMobilePhone();

    if ((contactPhone == null) || (!contactPhone.isValidNumber())
          || Boolean.TRUE.equals(contactPhone.getDoNotContact())
          || Boolean.TRUE.equals(contactPhone.getWrongInfo())) {
      return "";
    } else {
      return contactPhone.getPhoneNum();
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * Get contactable other phone number, return empty string if there is no such number or the phone is not contactable.
   *
   * @return  get contactable other phone number, return empty string if there is no such number or the phone is not
   *          contactable
   */
  public String getContactableOtherPhoneStr() {
    if (Boolean.TRUE.equals(this.getDoNotContact())) {
      return "";
    }

    CustomerContactPhone contactPhone = getOtherPhone();

    if ((contactPhone == null) || (!contactPhone.isValidNumber())
          || Boolean.TRUE.equals(contactPhone.getDoNotContact())
          || Boolean.TRUE.equals(contactPhone.getWrongInfo())) {
      return "";
    } else {
      return contactPhone.getPhoneNum();
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for contactable reminder phone.
   *
   * @return  CustomerContactPhone
   */
  public CustomerContactPhone getContactableReminderPhone() {
    if (Boolean.TRUE.equals(this.getDoNotContact())) {
      return null;
    }

    CustomerContactPhone contactPhone = getReminderPhone();

    if ((contactPhone == null) || (!contactPhone.isValidNumber())
          || Boolean.TRUE.equals(contactPhone.getDoNotContact())
          || Boolean.TRUE.equals(contactPhone.getWrongInfo())) {
      return null;
    }

    return contactPhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for contactable reminder phone str.
   *
   * @return  String
   */
  public String getContactableReminderPhoneStr() {
    if (Boolean.TRUE.equals(this.getDoNotContact())) {
      return "";
    }

    CustomerContactPhone contactPhone = getReminderPhone();

    if ((contactPhone == null) || (!contactPhone.isValidNumber())
          || Boolean.TRUE.equals(contactPhone.getDoNotContact())
          || Boolean.TRUE.equals(contactPhone.getWrongInfo())) {
      return "";
    } else {
      return contactPhone.getPhoneNum();
    }
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get contactable sms phone.
   *
   * @return  get contactable sms phone
   */
  public CustomerContactPhone getContactableSmsPhone() {
    if (Boolean.TRUE.equals(this.getDoNotContact())) {
      return null;
    }

    CustomerContactPhone contactPhone = getSMSPhone();

    if ((contactPhone == null) || (!contactPhone.isValidNumber())
          || Boolean.TRUE.equals(contactPhone.getDoNotContact())
          || Boolean.TRUE.equals(contactPhone.getWrongInfo())) {
      return null;
    }

    return contactPhone;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get contactable sms phone number, return empty string if there is no such number or the phone is not contactable.
   *
   * @return  get contactable sms phone number, return empty string if there is no such number or the phone is not
   *          contactable
   */
  public String getContactableSmsPhoneStr() {
    if (Boolean.TRUE.equals(this.getDoNotContact())) {
      return "";
    }

    CustomerContactPhone contactPhone = getSMSPhone();

    if ((contactPhone == null) || (!contactPhone.isValidNumber())
          || Boolean.TRUE.equals(contactPhone.getDoNotContact())
          || Boolean.TRUE.equals(contactPhone.getWrongInfo())) {
      return "";
    }

    return contactPhone.getPhoneNum();
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for contactable text phone.
   *
   * @return  CustomerContactPhone
   */
  public CustomerContactPhone getContactableTextPhone() {
    if (Boolean.TRUE.equals(this.getDoNotContact())) {
      return null;
    }

    CustomerContactPhone contactPhone = getSMSPhone();

    if ((contactPhone == null) || (!contactPhone.isValidNumber())
          || Boolean.TRUE.equals(contactPhone.getDoNotContact())
          || Boolean.TRUE.equals(contactPhone.getWrongInfo())) {
      contactPhone = getMobilePhone();
    }

    if ((contactPhone == null) || (!contactPhone.isValidNumber())
          || Boolean.TRUE.equals(contactPhone.getDoNotContact())
          || Boolean.TRUE.equals(contactPhone.getWrongInfo())) {
      return null;
    }

    return contactPhone;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for contactable text phone str.
   *
   * @return  String
   */
  public String getContactableTextPhoneStr() {
    if (Boolean.TRUE.equals(this.getDoNotContact())) {
      return "";
    }

    CustomerContactPhone contactPhone = getSMSPhone();

    if (contactPhone == null) {
      contactPhone = getMobilePhone();
    }

    if ((contactPhone == null) || (!contactPhone.isValidNumber())
          || Boolean.TRUE.equals(contactPhone.getDoNotContact())
          || Boolean.TRUE.equals(contactPhone.getWrongInfo())) {
      return "";
    }

    return contactPhone.getPhoneNum();
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get contactable work phone number, return empty string if there is no such number or the phone is not contactable.
   *
   * @return  get contactable work phone number, return empty string if there is no such number or the phone is not
   *          contactable
   */
  public String getContactableWorkPhoneStr() {
    if (Boolean.TRUE.equals(this.getDoNotContact())) {
      return "";
    }

    CustomerContactPhone contactPhone = getWorkPhone();

    if ((contactPhone == null) || (!contactPhone.isValidNumber())
          || Boolean.TRUE.equals(contactPhone.getDoNotContact())
          || Boolean.TRUE.equals(contactPhone.getWrongInfo())) {
      return "";
    } else {
      return contactPhone.getPhoneNum();
    }
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get a set of Contact Phones based on phone num. This method returns all match for different phone types. The order
   * in the Set is guaranteed in the following order:
   *
   * <p>ContactChannel.HOMEPHONE, ContactChannel.HOMEPHONE2, ContactChannel.WORKPHONE, ContactChannel.MOBILEPHONE,
   * ContactChannel.SMSPHONE, ContactChannel.OTHERPHONE, ContactChannel.OTHERPHONE2, ContactChannel.OTHERPHONE3,
   * ContactChannel.OTHERPHONE4</p>
   *
   * @param   phoneNum  DOCUMENT ME!
   *
   * @return  get a set of Contact Phones based on phone num.
   */
  public Set<CustomerContactPhone> getContactPhonesbyPhoneNum(String phoneNum) {
    if (!StringUtils.hasText(phoneNum)) {
      return null;
    }

    Set<CustomerContactPhone> ps = new LinkedHashSet<CustomerContactPhone>();

    for (int i = 0; i < ContactChannel.PHONE_CHANNELS.length; i++) {
      CustomerContactPhone phone = getPhone(ContactChannel.PHONE_CHANNELS[i]);

      if ((phone != null)
            && phoneNum.equalsIgnoreCase(phone.getPhoneNum())) {
        ps.add(phone);
      }
    }

    if (ps.size() > 0) {
      return ps;
    }

    return null;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for cosigned responsibles.
   *
   * @return  List
   */
  public List<Responsible> getCosignedResponsibles() {
    return cosignedResponsibles;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for cosigner.
   *
   * @return  Boolean
   */
  public Boolean getCosigner() {
    return isCosigner;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for cosigner count.
   *
   * @return  Integer
   */
  public Integer getCosignerCount() {
    int      coSignerCount = 0;
    Iterator iterator      = getResponsibleIndexs().iterator();

    while (iterator.hasNext()) {
      ResponsibleIndex responsibleIndex = (ResponsibleIndex) iterator.next();
      Responsible      responsible      = responsibleIndex.getResponsible();

      if ((responsible != null) && !responsible.getPrimaryHolder() && responsible.getAccount().getActive()
            && StringUtils.hasText(responsible.getSsn())) {
        coSignerCount++;
      }
    }

    return coSignerCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   portfolioId  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getCosignerMaxDelinquencyDaysByPortfolio(String portfolioId) {
    int      maxDays  = 0;
    Iterator iterator = getResponsibleIndexs().iterator();

    while (iterator.hasNext()) {
      ResponsibleIndex responsibleIndex = (ResponsibleIndex) iterator.next();
      Responsible      responsible      = responsibleIndex.getResponsible();

      if ((responsible != null) && responsible.getCustomerType().equals(CustomerType.G)
            && responsible.getAccount().getActive()
            && (portfolioId.indexOf(responsible.getAccount().getPortfolio().getPortfolioId().toString()) != -1)) {
        if (responsible.getAccount().getDelinquencyDays() > maxDays) {
          maxDays = responsible.getAccount().getDelinquencyDays();
        }
      }
    }

    return maxDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   portfolioId  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getCosignerTotalBalanceByPortfolio(String portfolioId) {
    BigDecimal totalBalance = new BigDecimal(0);
    Iterator   iterator     = getResponsibleIndexs().iterator();

    while (iterator.hasNext()) {
      ResponsibleIndex responsibleIndex = (ResponsibleIndex) iterator.next();
      Responsible      responsible      = responsibleIndex.getResponsible();

      if ((responsible != null) && responsible.getCustomerType().equals(CustomerType.G)
            && responsible.getAccount().getActive()
            && (portfolioId.indexOf(responsible.getAccount().getPortfolio().getPortfolioId().toString()) != -1)) {
        totalBalance = totalBalance.add(responsible.getAccount().getBalance());
      }
    }

    return totalBalance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   portfolioId  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getCosignerTotalCurrentMonthlyDueAmountByPortfolio(String portfolioId) {
    BigDecimal total    = new BigDecimal(0);
    Iterator   iterator = getResponsibleIndexs().iterator();

    while (iterator.hasNext()) {
      ResponsibleIndex responsibleIndex = (ResponsibleIndex) iterator.next();
      Responsible      responsible      = responsibleIndex.getResponsible();

      if ((responsible != null) && responsible.getCustomerType().equals(CustomerType.G)
            && responsible.getAccount().getActive()
            && (portfolioId.indexOf(responsible.getAccount().getPortfolio().getPortfolioId().toString()) != -1)) {
        total = total.add(responsible.getAccount().getAccountAdditionalDetail().getClientDefinedDecimal5());
      }
    }

    return total;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   portfolioId  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getCosignerTotalDueAmountByPortfolio(String portfolioId) {
    BigDecimal total    = new BigDecimal(0);
    Iterator   iterator = getResponsibleIndexs().iterator();

    while (iterator.hasNext()) {
      ResponsibleIndex responsibleIndex = (ResponsibleIndex) iterator.next();
      Responsible      responsible      = responsibleIndex.getResponsible();

      if ((responsible != null) && responsible.getCustomerType().equals(CustomerType.G)
            && responsible.getAccount().getActive()
            && (portfolioId.indexOf(responsible.getAccount().getPortfolio().getPortfolioId().toString()) != -1)) {
        total = total.add(responsible.getAccount().getClientDefinedDecimal1());
      }
    }

    return total;
  }

  //~ ------------------------------------------------------------------------------------------------------------------


  /**
   * DOCUMENT ME!
   *
   * @param   portfolioId  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getCosignerTotalMinimumPaymentAmountByPortfolio(String portfolioId) {
    BigDecimal total    = new BigDecimal(0);
    Iterator   iterator = getResponsibleIndexs().iterator();

    while (iterator.hasNext()) {
      ResponsibleIndex responsibleIndex = (ResponsibleIndex) iterator.next();
      Responsible      responsible      = responsibleIndex.getResponsible();

      if ((responsible != null) && responsible.getCustomerType().equals(CustomerType.G)
            && responsible.getAccount().getActive()
            && (portfolioId.indexOf(responsible.getAccount().getPortfolio().getPortfolioId().toString()) != -1)) {
        total = total.add(responsible.getAccount().getMinimumPayDue());
      }
    }

    return total;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   portfolioId  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getCosignerTotalPastDueAmountByPortfolio(String portfolioId) {
    BigDecimal total    = new BigDecimal(0);
    Iterator   iterator = getResponsibleIndexs().iterator();

    while (iterator.hasNext()) {
      ResponsibleIndex responsibleIndex = (ResponsibleIndex) iterator.next();
      Responsible      responsible      = responsibleIndex.getResponsible();

      if ((responsible != null) && responsible.getCustomerType().equals(CustomerType.G)
            && responsible.getAccount().getActive()
            && (portfolioId.indexOf(responsible.getAccount().getPortfolio().getPortfolioId().toString()) != -1)) {
        total = total.add(responsible.getAccount().getPastDue());
      }
    }

    return total;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for current Responsible.
   *
   * @return  Responsible
   */
  public Responsible getCurrentResponsible() {
    return currentResponsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for customer additional detail.
   *
   * @return  CustomerAdditionalDetail
   */
  public CustomerAdditionalDetail getCustomerAdditionalDetail() {
    return customerAdditionalDetail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for customer full name.
   *
   * @return  String
   */
  public String getCustomerFullName() {
    StringBuffer customerName = new StringBuffer();

    customerName.append(getFirstName());
    customerName.append(" ");

    if (StringUtils.hasText(getMiddleName())) {
      customerName.append(getMiddleName());
      customerName.append(" ");
    }

    customerName.append(getLastName());

    return customerName.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for customer id.
   *
   * @return  Long
   */
  public Long getCustomerId() {
    return customerId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for customer name.
   *
   * @return  String
   */
  public String getCustomerName() {
    return customerName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get all the responsibles belong to the customer.
   *
   * @return  DOCUMENT ME!
   */
  public Set<Responsible> getCustomerResponsibles() {
    Set<Responsible> allResponsibles = new LinkedHashSet<Responsible>();

    for (ResponsibleIndex responsibleIndex : responsibleIndexs) {
      allResponsibles.add(responsibleIndex.getResponsible());
    }

    return allResponsibles;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for customer scores.
   *
   * @return  List
   */
  public List<CustomerScore> getCustomerScores() {
    return customerScores;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for date of birth.
   *
   * @return  Date
   */
  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the day of the month.
   *
   * @return  get the day of the month
   */
  public int getDateOfMonth() {
    Calendar cal = Calendar.getInstance();

    return cal.get(Calendar.DAY_OF_MONTH);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get default address.
   *
   * @return  get default address
   */
  public CustomerContactAddress getDefaultAddress() {
    CustomerContactAddress contactAddress = getHomeAddress();

    if (contactAddress == null) {
      // no home address, try work address
      contactAddress = getWorkAddress();

      if (contactAddress == null) {
        contactAddress = getOtherAddress();
      }
    }

    return contactAddress;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for default address address1.
   *
   * @return  String
   */
  public String getDefaultAddressAddress1() {
    CustomerContactAddress contactAddress = getDefaultAddress();

    if (contactAddress != null) {
      return contactAddress.getAddress().getAddress1();
    }

    return null;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for default address address2.
   *
   * @return  String
   */
  public String getDefaultAddressAddress2() {
    CustomerContactAddress contactAddress = getDefaultAddress();

    if (contactAddress != null) {
      return contactAddress.getAddress().getAddress2();
    }

    return null;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for default address city.
   *
   * @return  String
   */
  public String getDefaultAddressCity() {
    CustomerContactAddress contactAddress = getDefaultAddress();

    if (contactAddress != null) {
      return contactAddress.getAddress().getCity();
    }

    return null;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for default address country.
   *
   * @return  String
   */
  public String getDefaultAddressCountry() {
    CustomerContactAddress contactAddress = getDefaultAddress();

    if (contactAddress != null) {
      return contactAddress.getAddress().getCountry();
    }

    return null;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for default address postal code.
   *
   * @return  String
   */
  public String getDefaultAddressPostalCode() {
    CustomerContactAddress contactAddress = getDefaultAddress();

    if (contactAddress != null) {
      return contactAddress.getAddress().getPostalCode();
    }

    return null;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for default address province.
   *
   * @return  String
   */
  public String getDefaultAddressProvince() {
    CustomerContactAddress contactAddress = getDefaultAddress();

    if (contactAddress != null) {
      return contactAddress.getAddress().getProvince();
    }

    return null;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get default contactable address.
   *
   * @return  get default contactable address
   */
  public CustomerContactAddress getDefaultContactableAddress() {
    if (Boolean.TRUE.equals(this.getDoNotContact())) {
      return null;
    }

    CustomerContactAddress contactAddress = getHomeAddress();

    if ((contactAddress == null) || (!contactAddress.isValidAddress())
          || Boolean.TRUE.equals(contactAddress.getDoNotContact())
          || Boolean.TRUE.equals(contactAddress.getWrongInfo())) {
      // no home address, try work address
      contactAddress = getWorkAddress();

      if ((contactAddress == null)
            || (!contactAddress.isValidAddress())
            || Boolean.TRUE.equals(contactAddress.getDoNotContact())
            || Boolean.TRUE.equals(contactAddress.getWrongInfo())) {
        contactAddress = getOtherAddress();

        if ((contactAddress == null)
              || (!contactAddress.isValidAddress())
              || Boolean.TRUE.equals(contactAddress.getDoNotContact())
              || Boolean.TRUE.equals(contactAddress.getWrongInfo())) {
          return null;
        }
      }
    }

    return contactAddress;
  } // end method getDefaultContactableAddress

  //~ ------------------------------------------------------------------------------------------------------------------

  // ------------------------------------------------------------------------------------------------------------------

  // end method getDefaultContactableAddress

  // ------------------------------------------------------------------------------------------------------------------


  /**
   * getter method for default contactable address address1.
   *
   * @return  String
   */
  public String getDefaultContactableAddressAddress1() {
    CustomerContactAddress contactAddress = getDefaultContactableAddress();

    if (contactAddress != null) {
      return contactAddress.getAddress().getAddress1();
    }

    return null;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for default contactable address address2.
   *
   * @return  String
   */
  public String getDefaultContactableAddressAddress2() {
    CustomerContactAddress contactAddress = getDefaultContactableAddress();

    if (contactAddress != null) {
      return contactAddress.getAddress().getAddress2();
    }

    return null;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for default contactable address city.
   *
   * @return  String
   */
  public String getDefaultContactableAddressCity() {
    CustomerContactAddress contactAddress = getDefaultContactableAddress();

    if (contactAddress != null) {
      return contactAddress.getAddress().getCity();
    }

    return null;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for default contactable address country.
   *
   * @return  String
   */
  public String getDefaultContactableAddressCountry() {
    CustomerContactAddress contactAddress = getDefaultContactableAddress();

    if (contactAddress != null) {
      return contactAddress.getAddress().getCountry();
    }

    return null;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for default contactable address postal code.
   *
   * @return  String
   */
  public String getDefaultContactableAddressPostalCode() {
    CustomerContactAddress contactAddress = getDefaultContactableAddress();

    if (contactAddress != null) {
      return contactAddress.getAddress().getPostalCode();
    }

    return null;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for default contactable address province.
   *
   * @return  String
   */
  public String getDefaultContactableAddressProvince() {
    CustomerContactAddress contactAddress = getDefaultContactableAddress();

    if (contactAddress != null) {
      return contactAddress.getAddress().getProvince();
    }

    return null;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for default contactable email.
   *
   * @return  CustomerContactEmail
   */
  public CustomerContactEmail getDefaultContactableEmail() {
    if (Boolean.TRUE.equals(this.getDoNotContact())
          || Boolean.TRUE.equals(this.getDoNotContact())) {
      return null;
    }

    CustomerContactEmail contactEmail = getHomeEmail();

    if ((contactEmail == null)
          || Boolean.TRUE.equals(contactEmail.getDoNotContact())
          || Boolean.TRUE.equals(contactEmail.getWrongInfo())) {
      // no home address, try work address
      contactEmail = getWorkEmail();

      if ((contactEmail == null)
            || Boolean.TRUE.equals(contactEmail.getDoNotContact())
            || Boolean.TRUE.equals(contactEmail.getWrongInfo())) {
        contactEmail = getOtherEmail();

        if ((contactEmail == null)
              || Boolean.TRUE.equals(contactEmail.getDoNotContact())
              || Boolean.TRUE.equals(contactEmail.getWrongInfo())) {
          return null;
        }
      }
    }

    return contactEmail;
  } // end method getDefaultContactableEmail

  //~ ------------------------------------------------------------------------------------------------------------------

  // ------------------------------------------------------------------------------------------------------------------

  // end method getDefaultContactableEmail

  // ------------------------------------------------------------------------------------------------------------------


  /**
   * getter method for default contactable email str.
   *
   * @return  String
   */
  public String getDefaultContactableEmailStr() {
    CustomerContactEmail contactEmail = getDefaultContactableEmail();

    if (contactEmail != null) {
      return contactEmail.getEmailAddress();
    } else {
      return "";
    }
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get default phone.
   *
   * @return  get default phone
   */
  public CustomerContactPhone getDefaultContactablePhone() {
    if (Boolean.TRUE.equals(this.getDoNotContact())) {
      return null;
    }

    CustomerContactPhone contactPhone = getHomePhone();

    if ((contactPhone == null) || (!contactPhone.isValidNumber())
          || Boolean.TRUE.equals(contactPhone.getDoNotContact())
          || Boolean.TRUE.equals(contactPhone.getWrongInfo())) {
      // no home phone, try work phone
      contactPhone = getWorkPhone();

      if ((contactPhone == null) || (!contactPhone.isValidNumber())
            || Boolean.TRUE.equals(contactPhone.getDoNotContact())
            || Boolean.TRUE.equals(contactPhone.getWrongInfo())) {
        contactPhone = getMobilePhone();

        if ((contactPhone == null) || (!contactPhone.isValidNumber())
              || Boolean.TRUE.equals(contactPhone.getDoNotContact())
              || Boolean.TRUE.equals(contactPhone.getWrongInfo())) {
          contactPhone = getOtherPhone();

          if ((contactPhone == null)
                || (!contactPhone.isValidNumber())
                || Boolean.TRUE.equals(
                  contactPhone.getDoNotContact())
                || Boolean.TRUE.equals(contactPhone.getWrongInfo())) {
            return null;
          }
        }
      }
    } // end if

    return contactPhone;
  } // end method getDefaultContactablePhone

  //~ ------------------------------------------------------------------------------------------------------------------

  // ------------------------------------------------------------------------------------------------------------------

  /**
   * Get default email.
   *
   * @return  get default email
   */
  public CustomerContactEmail getDefaultEmail() {
    CustomerContactEmail contactEmail = getHomeEmail();

    if (contactEmail == null) {
      // no home address, try work address
      contactEmail = getWorkEmail();

      if (contactEmail == null) {
        contactEmail = getOtherEmail();
      }
    }

    return contactEmail;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for default email str.
   *
   * @return  String
   */
  public String getDefaultEmailStr() {
    CustomerContactEmail contactEmail = getDefaultEmail();

    if (contactEmail != null) {
      return contactEmail.getEmailAddress();
    } else {
      return "";
    }
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for default MRASorting token.
   *
   * @return  String
   */
  public String getDefaultMRASortingToken() {
    if (defaultMRASortingToken == null) {
      return "sortByBalance";
    }

    return defaultMRASortingToken;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get default phone.
   *
   * @return  get default phone
   */
  public CustomerContactPhone getDefaultPhone() {
    CustomerContactPhone contactPhone = getHomePhone();

    if (contactPhone == null) {
      // no home address, try work address
      contactPhone = getWorkPhone();

      if (contactPhone == null) {
        contactPhone = getMobilePhone();

        if (contactPhone == null) {
          contactPhone = getOtherPhone();
        }
      }
    }

    return contactPhone;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for dns.
   *
   * @return  Long
   */
  public Long getDns() {
    return dns;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for drivers licence no.
   *
   * @return  String
   */
  public String getDriversLicenceNo() {
    return driversLicenceNo;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get emailAddress by type.
   *
   * @param   type  DOCUMENT ME!
   *
   * @return  get emailAddress by type
   */
  public CustomerContactEmail getEmail(String type) {
    return emails.get(type);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for email.
   *
   * @param   channel  ContactChannel
   *
   * @return  CustomerContactEmail
   */
  public CustomerContactEmail getEmail(ContactChannel channel) {
    if (channel == null) {
      return null;
    }

    if (ContactChannelType.EMAIL.equals(channel.getChannelType())) {
      return emails.get(channel.getStringTypeId());
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for email by type.
   *
   * @param   type  EmailType
   *
   * @return  CustomerContactEmail
   */
  public CustomerContactEmail getEmailByType(EmailType type) {
    return getEmails().get(type.getTypeId().toString());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for emails.
   *
   * @return  Map
   */
  public Map<String, CustomerContactEmail> getEmails() {
    return emails;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for employer name.
   *
   * @return  String
   */
  public String getEmployerName() {
    return employerName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for employment status.
   *
   * @return  String
   */
  public String getEmploymentStatus() {
    return employmentStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for fico score last update date.
   *
   * @return  String
   */
  public Date getFicoScoreLastUpdateDate() {
    return ficoScoreLastUpdateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the first phone matching given phone number. The matching order is ContactChannel.HOMEPHONE,
   * ContactChannel.HOMEPHONE2, ContactChannel.WORKPHONE, ContactChannel.MOBILEPHONE, ContactChannel.SMSPHONE,
   * ContactChannel.OTHERPHONE, ContactChannel.OTHERPHONE2, ContactChannel.OTHERPHONE3, ContactChannel.OTHERPHONE4
   *
   * @param   phoneNum  DOCUMENT ME!
   *
   * @return  get the first phone matching given phone number.
   */
  public CustomerContactPhone getFirstContactPhoneByPhoneNum(String phoneNum) {
    if (!StringUtils.hasText(phoneNum)) {
      return null;
    }

    CustomerContactPhone phone = null;

    for (int i = 0; i < ContactChannel.PHONE_CHANNELS.length; i++) {
      phone = getPhone(ContactChannel.PHONE_CHANNELS[i]);

      if ((phone != null)
            && phoneNum.equalsIgnoreCase(phone.getPhoneNum())) {
        return phone;
      }
    }

    return null;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for first name.
   *
   * @return  String
   */
  public String getFirstName() {
    return firstName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for first web login date.
   *
   * @return  Date
   */
  public Date getFirstWebLoginDate() {
    return firstWebLoginDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get full name, first name + last name.
   *
   * @return  get full name, Customer.firstName + ' ' + Customer.middleName + ' ' + Customer.lastName
   */
  public String getFullName() {
    if (firstName == null) {
      firstName = "";
    }

    if (lastName == null) {
      lastName = "";
    }

    if (middleName == null) {
      middleName = "";
    }

    return firstName + " " + middleName + " " + lastName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for funding accounts.
   *
   * @return  Set
   */
  public Set<FundingAccount> getFundingAccounts() {
    return fundingAccounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for future permanent address.
   *
   * @param   type  String
   *
   * @return  FuturePermanentCustomerContactAddress
   */
  public FuturePermanentCustomerContactAddress getFuturePermanentAddress(String type) {
    return futurePermanentAddresses.get(type);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for future permanent address.
   *
   * @param   channel  ContactChannel
   *
   * @return  FuturePermanentCustomerContactAddress
   */
  public FuturePermanentCustomerContactAddress getFuturePermanentAddress(ContactChannel channel) {
    if (channel == null) {
      return null;
    }

    if (ContactChannelType.ADDRESS.equals(channel.getChannelType())) {
      return futurePermanentAddresses.get(channel.getStringTypeId());
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for future permanent addresses.
   *
   * @return  Map
   */
  public Map<String, FuturePermanentCustomerContactAddress> getFuturePermanentAddresses() {
    return futurePermanentAddresses;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for future permanent historical addresses.
   *
   * @return  Set
   */
  public Set<FuturePermanentCustomerContactAddress> getFuturePermanentHistoricalAddresses() {
    return futurePermanentHistoricalAddresses;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for future permanent historical phones.
   *
   * @return  Set
   */
  public Set<FuturePermanentCustomerContactPhone> getFuturePermanentHistoricalPhones() {
    return futurePermanentHistoricalPhones;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for future permanent phone.
   *
   * @param   typeId  String
   *
   * @return  FuturePermanentCustomerContactPhone
   */
  public FuturePermanentCustomerContactPhone getFuturePermanentPhone(String typeId) {
    return futurePermanentPhones.get(typeId);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for future permanent phone.
   *
   * @param   channel  ContactChannel
   *
   * @return  FuturePermanentCustomerContactPhone
   */
  public FuturePermanentCustomerContactPhone getFuturePermanentPhone(ContactChannel channel) {
    if (channel == null) {
      return null;
    }

    if (ContactChannelType.PHONE.equals(channel.getChannelType())) {
      return futurePermanentPhones.get(channel.getStringTypeId());
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for future permanent phones.
   *
   * @return  Map
   */
  public Map<String, FuturePermanentCustomerContactPhone> getFuturePermanentPhones() {
    return futurePermanentPhones;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for gender.
   *
   * @return  String
   */
  public String getGender() {
    return gender;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for gross additional income.
   *
   * @return  BigDecimal
   */
  public BigDecimal getGrossAdditionalIncome() {
    return grossAdditionalIncome;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for gross individual income.
   *
   * @return  BigDecimal
   */
  public BigDecimal getGrossIndividualIncome() {
    return grossIndividualIncome;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for has bank owned account.
   *
   * @return  Boolean
   */
  public Boolean getHasBankOwnedAccount() {
    return hasBankOwnedAccount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for has current phone.
   *
   * @return  boolean
   */
  public boolean getHasCurrentPhone() {
    for (CustomerContactPhone contactPhone : getPhones().values()) {
      if ((contactPhone != null)
            && (!Boolean.TRUE.equals(contactPhone.getHistorical()))) {
        if (log.isDebugEnabled()) {
          log.debug("Found a current phone number for contact phone id: " + contactPhone.getPhoneId()
            + " customer: "
            + this.getCustomerId());
        }

        return true;
      }
    }

    if (log.isDebugEnabled()) {
      log.debug("No current phone number(s) for customer: " + this.getCustomerId());
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for has email.
   *
   * @return  boolean
   */
  public boolean getHasEmail() {
    return (this.emails.size() > 0);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for historical addresses.
   *
   * @return  Set
   */
  public Set<CustomerContactAddress> getHistoricalAddresses() {
    return historicalAddresses;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for historical emails.
   *
   * @return  Set
   */
  public Set<CustomerContactEmail> getHistoricalEmails() {
    return historicalEmails;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for historical phones.
   *
   * @return  Set
   */
  public Set<CustomerContactPhone> getHistoricalPhones() {
    return historicalPhones;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Convenient method.
   *
   * @return  HomeAddress
   */
  public CustomerContactAddress getHomeAddress() {
    return getAddress(ContactChannel.HOMEADDRESS.getStringTypeId());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for home address1.
   *
   * @return  String
   */
  public String getHomeAddress1() {
    CustomerContactAddress a = getHomeAddress();

    if ((a != null) && (a.getAddress() != null)) {
      return a.getAddress().getAddress1();
    }

    return null;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for home address2.
   *
   * @return  String
   */
  public String getHomeAddress2() {
    CustomerContactAddress a = getHomeAddress();

    if ((a != null) && (a.getAddress() != null)) {
      return a.getAddress().getAddress2();
    }

    return null;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for home address3.
   *
   * @return  String
   */
  public String getHomeAddress3() {
    CustomerContactAddress a = getHomeAddress();

    if ((a != null) && (a.getAddress() != null)) {
      return a.getAddress().getAddress3();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for home city.
   *
   * @return  String
   */
  public String getHomeCity() {
    CustomerContactAddress contactAddress = getHomeAddress();

    if (contactAddress != null) {
      if (contactAddress.getAddress() != null) {
        return contactAddress.getAddress().getCity();
      }
    }

    return null;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Convenient method.
   *
   * @return  HomeEmail
   */
  public CustomerContactEmail getHomeEmail() {
    return getEmail(ContactChannel.HOMEEMAIL.getStringTypeId());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get home email string, return empty string if there is no such email.
   *
   * @return  get home email string, return empty string if there is no such email
   */
  public String getHomeEmailStr() {
    CustomerContactEmail contactEmail = getHomeEmail();

    if (contactEmail != null) {
      return contactEmail.getEmailAddress();
    } else {
      return "";
    }
  }
  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Convenient method.
   *
   * @return  HomePhone
   */
  public CustomerContactPhone getHomePhone() {
    return getPhone(ContactChannel.HOMEPHONE.getStringTypeId());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get home phone number string, return empty string if there is no such number.
   *
   * @return  get home phone number string, return empty string if there is no such number
   */
  public String getHomePhoneStr() {
    CustomerContactPhone contactPhone = getHomePhone();

    if (contactPhone != null) {
      return contactPhone.getPhoneNum();
    } else {
      return "";
    }
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Convenient method.
   *
   * @return  HomeProvince
   */
  public String getHomeProvince() {
    CustomerContactAddress contactAddress = getHomeAddress();

    if (contactAddress != null) {
      if (contactAddress.getAddress() != null) {
        return contactAddress.getAddress().getProvince();
      }
    }

    return null;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for home zip code.
   *
   * @return  String
   */
  public String getHomeZipCode() {
    CustomerContactAddress a = getHomeAddress();

    if ((a != null) && (a.getAddress() != null)) {
      return a.getAddress().getPostalCode();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for industry.
   *
   * @return  String
   */
  public String getIndustry() {
    return industry;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for is contactable.
   *
   * @return  boolean
   */
  public boolean getIsContactable() {
    return (getIsContactableByAddress() || getIsContactableByEmail()
        || getIsContactableByPhone());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for is contactable by address.
   *
   * @return  boolean
   */
  public boolean getIsContactableByAddress() {
    if (Boolean.TRUE.equals(this.getDoNotContact())) {
      return false;
    }

    for (CustomerContactAddress contactAddress : getAddresses().values()) {
      if ((contactAddress != null) && contactAddress.isValidAddress()
            && (!Boolean.TRUE.equals(contactAddress.getDoNotContact()))) {
        return true;
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for is contactable by email.
   *
   * @return  boolean
   */
  public boolean getIsContactableByEmail() {
    if (Boolean.TRUE.equals(this.getDoNotContact())) {
      return false;
    }

    for (CustomerContactEmail contactEmail : getEmails().values()) {
      if ((contactEmail != null)
            && (!Boolean.TRUE.equals(contactEmail.getDoNotContact()))
            && StringUtils.hasText(contactEmail.getEmailAddress())) {
        return true;
      }
    }

    return false;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for is contactable by mobile phone.
   *
   * @return  boolean
   */
  public boolean getIsContactableByMobilePhone() {
    return (getContactableMobilePhone() != null);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for is contactable by phone.
   *
   * @return  boolean
   */
  public boolean getIsContactableByPhone() {
    if (Boolean.TRUE.equals(this.getDoNotContact())) {
      return false;
    }

    for (CustomerContactPhone contactPhone : getPhones().values()) {
      if ((contactPhone != null)
            && (contactPhone.isValidNumber()
              && (!Boolean.TRUE.equals(
                  contactPhone.getDoNotContact())))) {
        if (log.isDebugEnabled()) {
          log.debug("Found a valid phone number for contact phone id: " + contactPhone.getPhoneId() + " customer: "
            + this.getCustomerId());
        }

        return true;
      }
    }

    if (log.isDebugEnabled()) {
      log.debug("No valid phone number for customer: " + this.getCustomerId());
    }

    return false;
  } // end method getIsContactableByPhone

  //~ ------------------------------------------------------------------------------------------------------------------

  // ------------------------------------------------------------------------------------------------------------------

  // end method getIsContactableByPhone

  // ------------------------------------------------------------------------------------------------------------------


  /**
   * getter method for is contactable by sms phone.
   *
   * @return  boolean
   */
  public boolean getIsContactableBySmsPhone() {
    return (getContactableSmsPhone() != null);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for is contactable by text phone.
   *
   * @return  boolean
   */
  public boolean getIsContactableByTextPhone() {
    return (getContactableTextPhone() != null);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for is cosigner.
   *
   * @return  Boolean
   */
  public Boolean getIsCosigner() {
    if (isCosigner == null) {
      return Boolean.FALSE;
    }

    return isCosigner;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for is not contactable.
   *
   * @return  boolean
   */
  public boolean getIsNotContactable() {
    return !getIsContactable();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for is not contactable by address.
   *
   * @return  boolean
   */
  public boolean getIsNotContactableByAddress() {
    return !getIsContactableByAddress();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for is not contactable by email.
   *
   * @return  boolean
   */
  public boolean getIsNotContactableByEmail() {
    return !getIsContactableByEmail();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for is not contactable by phone.
   *
   * @return  boolean
   */
  public boolean getIsNotContactableByPhone() {
    return !getIsContactableByPhone();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for is not contactable by sms phone.
   *
   * @return  boolean
   */
  public boolean getIsNotContactableBySmsPhone() {
    return (getContactableSmsPhone() == null);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for is not contactable by text phone.
   *
   * @return  boolean
   */
  public boolean getIsNotContactableByTextPhone() {
    return (getContactableTextPhone() == null);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for job code.
   *
   * @return  String
   */
  public String getJobCode() {
    return jobCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for language code.
   *
   * @return  String
   */
  public String getLanguageCode() {
    return languageCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last login date.
   *
   * @return  Date
   */
  public Date getLastLoginDate() {
    return lastLoginDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last name.
   *
   * @return  String
   */
  public String getLastName() {
    return lastName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last payment amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getLastPaymentAmount() {
    return lastPaymentAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last payment date.
   *
   * @return  Date
   */
  public Date getLastPaymentDate() {
    return lastPaymentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last web update address date.
   *
   * @return  Date
   */
  public Date getLastWebUpdateAddressDate() {
    if ((this.webUpdateAddress != null) && (this.webUpdateAddress.size() > 0)) {
      Iterator<CustomerContactAddress> it = webUpdateAddress.iterator();

      return it.next().getLastUpdateDate();
    } else {
      return null;
    }

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last web update email date.
   *
   * @return  Date
   */
  public Date getLastWebUpdateEmailDate() {
    if ((this.webUpdateEmails != null) && (this.webUpdateEmails.size() > 0)) {
      Iterator<CustomerContactEmail> it = webUpdateEmails.iterator();

      return it.next().getLastUpdateDate();
    } else {
      return null;
    }

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last web update phone date.
   *
   * @return  Date
   */
  public Date getLastWebUpdatePhoneDate() {
    if ((this.webUpdatePhones != null) && (this.webUpdatePhones.size() > 0)) {
      Iterator<CustomerContactPhone> it = webUpdatePhones.iterator();

      return it.next().getLastUpdateDate();
    } else {
      return null;
    }
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Returns the account with the highest AccountIndex.priorityScore.
   *
   * @return  the account with the highest AccountIndex.priorityScore.
   */
  public Account getLeadAccount() {
    if ((responsibleIndexs != null) && (responsibleIndexs.size() > 0)) {
      SortedMap<Long, Account> priorityScoreMap = new TreeMap<Long, Account>();

      for (ResponsibleIndex responsibleIndex : responsibleIndexs) {
        Account account = responsibleIndex.getResponsible().getAccount();

        if ((account != null) && (account.getAccountIndex() != null)) {
          priorityScoreMap.put(account.getAccountIndex().getPriorityScore(), account);
        }
      }

      return priorityScoreMap.get(priorityScoreMap.lastKey());
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for lead account num.
   *
   * @return  Long
   */
  public Long getLeadAccountNum() {
    return leadAccountNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for loan max delinquency days.
   *
   * @return  Integer
   */
  public Integer getLoanMaxDelinquencyDays() {
    int      maxDays  = 0;
    Iterator iterator = getResponsibleIndexs().iterator();

    while (iterator.hasNext()) {
      ResponsibleIndex responsibleIndex = (ResponsibleIndex) iterator.next();
      Responsible      responsible      = responsibleIndex.getResponsible();

      if ((responsible != null) && responsible.getPrimaryHolder() && responsible.getAccount().getActive()) {
        if (responsible.getAccount().getDelinquencyDays() > maxDays) {
          maxDays = responsible.getAccount().getDelinquencyDays();
        }
      }
    }

    return maxDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for loan modification agreement count.
   *
   * @return  Integer
   */
  public Integer getLoanModificationAgreementCount() {
    int      loanModificationAgreementCount = 0;
    Iterator iterator                       = getResponsibleIndexs().iterator();

    while (iterator.hasNext()) {
      ResponsibleIndex responsibleIndex = (ResponsibleIndex) iterator.next();
      Responsible      responsible      = responsibleIndex.getResponsible();

      if ((responsible != null) && responsible.getAccount().getActive() && responsible.getPrimaryHolder()
            && responsible.getAccount().getClientDefined1CharCode1().equalsIgnoreCase("Y")) {
        loanModificationAgreementCount++;
      }
    }

    return loanModificationAgreementCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for marital status.
   *
   * @return  String
   */
  public String getMaritalStatus() {
    return maritalStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for match confidence.
   *
   * @return  String
   */
  public String getMatchConfidence() {
    return matchConfidence;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   portfolioId  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getMaxDelinquencyDaysByPortfolio(String portfolioId) {
    int      maxDays  = 0;
    Iterator iterator = getResponsibleIndexs().iterator();

    while (iterator.hasNext()) {
      ResponsibleIndex responsibleIndex = (ResponsibleIndex) iterator.next();
      Responsible      responsible      = responsibleIndex.getResponsible();

      if ((responsible != null) && responsible.getAccount().getActive()
            && !responsible.getCustomerType().equals(CustomerType.S)
            && (portfolioId.indexOf(responsible.getAccount().getPortfolio().getPortfolioId().toString()) != -1)) {
        if (responsible.getAccount().getDelinquencyDays() > maxDays) {
          maxDays = responsible.getAccount().getDelinquencyDays();
        }
      }
    }

    return maxDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for memory messages.
   *
   * @return  Set
   */
  public Set<MemoryMessage> getMemoryMessages() {
    return memoryMessages;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for middle name.
   *
   * @return  String
   */
  public String getMiddleName() {
    return middleName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for minimum pay due.
   *
   * @return  BigDecimal
   */
  public BigDecimal getMinimumPayDue() {
    return minimumPayDue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Convenient method.
   *
   * @return  MobilePhone
   */
  public CustomerContactPhone getMobilePhone() {
    return getPhone(ContactChannel.MOBILEPHONE.getStringTypeId());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * Get mobile phone number string, return empty string if there is no such number.
   *
   * @return  get mobile phone number string, return empty string if there is no such number
   */
  public String getMobilePhoneStr() {
    CustomerContactPhone contactPhone = getMobilePhone();

    if (contactPhone != null) {
      return contactPhone.getPhoneNum();
    } else {
      return "";
    }
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for mother maiden name.
   *
   * @return  String
   */
  public String getMotherMaidenName() {
    return motherMaidenName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for nature of business.
   *
   * @return  String
   */
  public String getNatureOfBusiness() {
    return natureOfBusiness;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   portfolioId  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getNonStudentTotalBalanceByPortfolio(String portfolioId) {
    BigDecimal totalBalance = new BigDecimal(0);
    Iterator   iterator     = getResponsibleIndexs().iterator();

    while (iterator.hasNext()) {
      ResponsibleIndex responsibleIndex = (ResponsibleIndex) iterator.next();
      Responsible      responsible      = responsibleIndex.getResponsible();

      if ((responsible != null) && responsible.getAccount().getActive()
            && !responsible.getCustomerType().equals(CustomerType.S)
            && (portfolioId.indexOf(responsible.getAccount().getPortfolio().getPortfolioId().toString()) != -1)) {
        totalBalance = totalBalance.add(responsible.getAccount().getBalance());
      }
    }

    return totalBalance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for number of accounts.
   *
   * @return  Long
   */
  public Long getNumberOfAccounts() {
    return numberOfAccounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Convenient method.
   *
   * @return  OtherAddress
   */
  public CustomerContactAddress getOtherAddress() {
    return getAddress(ContactChannel.OTHERADDRESS.getStringTypeId());
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Convenient method.
   *
   * @return  OtherEmail
   */
  public CustomerContactEmail getOtherEmail() {
    return getEmail(ContactChannel.OTHEREMAIL.getStringTypeId());
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get other email string, return empty string if there is no such email.
   *
   * @return  get other email string, return empty string if there is no such email
   */
  public String getOtherEmailStr() {
    CustomerContactEmail contactEmail = getOtherEmail();

    if (contactEmail != null) {
      return contactEmail.getEmailAddress();
    } else {
      return "";
    }
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Convenient method.
   *
   * @return  OtherPhone
   */
  public CustomerContactPhone getOtherPhone() {
    return getPhone(ContactChannel.OTHERPHONE.getStringTypeId());
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get other phone number string, return empty string if there is no such number.
   *
   * @return  get other phone number string, return empty string if there is no such number
   */
  public String getOtherPhoneStr() {
    CustomerContactPhone contactPhone = getOtherPhone();

    if (contactPhone != null) {
      return contactPhone.getPhoneNum();
    } else {
      return "";
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for other zip code.
   *
   * @return  String
   */
  public String getOtherZipCode() {
    CustomerContactAddress contactAddress = getOtherAddress();

    if ((contactAddress == null) || (contactAddress.getAddress() == null)) {
      return null;
    }

    String otherZipCode = contactAddress.getAddress().getPostalCode();

    if (otherZipCode == null) {
      return null;
    }

    return otherZipCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for past due.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPastDue() {
    return pastDue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment due date.
   *
   * @return  Date
   */
  public Date getPaymentDueDate() {
    return paymentDueDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for persona list.
   *
   * @return  List
   */
  public List<String> getPersonaList() {
    List<String> personaList = new ArrayList<String>();

    if (null == personaSet) {
      if ((null != responsibleIndexs) && (responsibleIndexs.size() > 0)) {
        personaSet = new LinkedHashSet<String>();

        Set<PersonaAction> personaActions = new LinkedHashSet<PersonaAction>();

        for (ResponsibleIndex responsibleIndex : responsibleIndexs) {
          for (PersonaAccount personaAccount : responsibleIndex.getResponsible().getPersonaAccounts()) {
            personaActions.add(personaAccount.getPersonaAction());
          }
        }

        List<PersonaAction> personaActionList = new LinkedList<PersonaAction>();

        personaActionList.addAll(personaActions);

        personaActionList.sort(new Comparator<PersonaAction>() {
            @Override public int compare(PersonaAction o1, PersonaAction o2) {
              if ((o1.getPriority() == null) && (o2.getPriority() == null)) {
                return 0;
              } else if ((o1.getPriority() != null) && (o2.getPriority() != null)) {
                return o2.getPriority().compareTo(o1.getPriority());
              } else if (o1.getPriority() == null) {
                return 1;
              }

              return -1;
            }
          });

        for (PersonaAction personaAction : personaActionList) {
          personaSet.add(personaAction.getName());
        }

      } // end if

    } // end if

    if ((null != personaSet) && (personaSet.size() > 0)) {
      personaList.addAll(personaSet);
    }

    return personaList;
  } // end method getPersonaList

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get phone by type Id. Type id is the primary key of the PhoneType.
   *
   * @param   typeId  DOCUMENT ME!
   *
   * @return  get phone by type Id.
   */
  public CustomerContactPhone getPhone(String typeId) {
    return phones.get(typeId);

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for phone.
   *
   * @param   channel  ContactChannel
   *
   * @return  CustomerContactPhone
   */
  public CustomerContactPhone getPhone(ContactChannel channel) {
    if (channel == null) {
      return null;
    }

    if (ContactChannelType.PHONE.equals(channel.getChannelType())) {
      return phones.get(channel.getStringTypeId());
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for phone by type.
   *
   * @param   type  PhoneType
   *
   * @return  CustomerContactPhone
   */
  public CustomerContactPhone getPhoneByType(PhoneType type) {
    return getPhones().get(type.getTypeId().toString());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for phones.
   *
   * @return  Map
   */
  public Map<String, CustomerContactPhone> getPhones() {
    return phones;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for place of birth.
   *
   * @return  String
   */
  public String getPlaceOfBirth() {
    return placeOfBirth;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */

  public Portfolio getPortfolio() {
    return portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get communication preference 6: Home Address
   *
   * @return  the order of the preference
   *
   *          <p>not-null = "false"</p>
   */
  public Integer getPreferHomeAddress() {
    return this.preferHomeAddress;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get communication preference 1: Home Email
   *
   * @return  the order of the preference
   *
   *          <p>not-null = "false"</p>
   */
  public Integer getPreferHomeEmail() {
    return this.preferHomeEmail;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get communication preference 4: Home Phone
   *
   * @return  the order of the preference
   *
   *          <p>not-null = "false"</p>
   */
  public Integer getPreferHomePhone() {
    return this.preferHomePhone;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get communication preference 2: Mobile Phone
   *
   * @return  the order of the preference
   *
   *          <p>not-null = "false"</p>
   */
  public Integer getPreferMobilePhone() {
    return this.preferMobilePhone;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get communication preference 3: Text Message
   *
   * @return  the order of the preference
   *
   *          <p>not-null = "false"</p>
   */
  public Integer getPreferTextMessage() {
    return this.preferTextMessage;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get communication preference 5: Work Phone
   *
   * @return  the order of the preference
   *
   *          <p>not-null = "false"</p>
   */
  public Integer getPreferWorkPhone() {
    return this.preferWorkPhone;
  }
  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
   * the following methods added by Yan for SLM return file --- START
   */

  // ------------------------------------------------------------------------------------------------------------------

  /*
   * the following methods added by Yan for SLM return file --- START
   */

  /**
   * getter method for previous home address.
   *
   * @return  CustomerContactAddress
   */
  public CustomerContactAddress getPreviousHomeAddress() {
    CustomerContactAddress previousAddress = null;

    if ((historicalAddresses != null) && (historicalAddresses.size() > 0)) {
      for (CustomerContactAddress ca : historicalAddresses) {
        if ((previousAddress == null)
              && ca.getAddressType().getTypeId().toString().equals(
                ContactChannel.HOMEADDRESS.getTypeId().toString())) {
          previousAddress = ca;
        }

        // modified to extidate as we need to pull  the data based on the exit date.
        if ((previousAddress != null)
              && ca.getAddressType().getTypeId().toString().equals(
                ContactChannel.HOMEADDRESS.getTypeId().toString())
              && ca.getExitDate().after(previousAddress.getExitDate())) {
          previousAddress = ca;
        }
      }

      if (previousAddress != null) {
        return previousAddress;
      }
    }

    return null;
  } // end method getPreviousHomeAddress

  //~ ------------------------------------------------------------------------------------------------------------------

  // ------------------------------------------------------------------------------------------------------------------

  // end method getPreviousHomeAddress

  // ------------------------------------------------------------------------------------------------------------------


  /**
   * getter method for previous home email str.
   *
   * @return  String
   */
  public String getPreviousHomeEmailStr() {
    CustomerContactEmail previousEmail = null;

    if ((historicalEmails != null) && (historicalEmails.size() > 0)) {
      for (CustomerContactEmail ce : historicalEmails) {
        if ((previousEmail == null)
              && ce.getEmailType().getTypeId().toString().equals(
                ContactChannel.HOMEEMAIL.getTypeId().toString())) {
          previousEmail = ce;
        }

        if ((previousEmail != null)
              && ce.getEmailType().getTypeId().toString().equals(
                ContactChannel.HOMEEMAIL.getTypeId().toString())
              && ce.getExitDate().after(previousEmail.getExitDate())) {
          previousEmail = ce;
        }
      }

      if (previousEmail != null) {
        return previousEmail.getEmailAddress();
      }
    }

    return null;
  } // end method getPreviousHomeEmailStr

  //~ ------------------------------------------------------------------------------------------------------------------

  // ------------------------------------------------------------------------------------------------------------------

  // end method getPreviousHomeEmailStr

  // ------------------------------------------------------------------------------------------------------------------


  /**
   * getter method for previous home phone str.
   *
   * @return  String
   */
  public String getPreviousHomePhoneStr() {
    CustomerContactPhone previousPhone = null;

    if ((historicalPhones != null) && (historicalPhones.size() > 0)) {
      for (CustomerContactPhone ch : historicalPhones) {
        if ((previousPhone == null)
              && ch.getPhoneType().getTypeId().toString().equals(
                ContactChannel.HOMEPHONE.getTypeId().toString())) {
          previousPhone = ch;
        }

        if ((previousPhone != null)
              && ch.getPhoneType().getTypeId().toString().equals(
                ContactChannel.HOMEPHONE.getTypeId().toString())
              && ch.getExitDate().after(previousPhone.getExitDate())) {
          previousPhone = ch;
        }
      }

      if (previousPhone != null) {
        return previousPhone.getPhoneNum();
      }
    }

    return null;
  } // end method getPreviousHomePhoneStr

  //~ ------------------------------------------------------------------------------------------------------------------

  // ------------------------------------------------------------------------------------------------------------------

  // end method getPreviousHomePhoneStr

  // ------------------------------------------------------------------------------------------------------------------


  /**
   * getter method for previous mobile phone str.
   *
   * @return  String
   */
  public String getPreviousMobilePhoneStr() {
    CustomerContactPhone previousPhone = null;

    if ((historicalPhones != null) && (historicalPhones.size() > 0)) {
      for (CustomerContactPhone ch : historicalPhones) {
        if ((previousPhone == null)
              && ch.getPhoneType().getTypeId().toString().equals(
                ContactChannel.MOBILEPHONE.getTypeId().toString())) {
          previousPhone = ch;
        }

        if ((previousPhone != null)
              && ch.getPhoneType().getTypeId().toString().equals(
                ContactChannel.MOBILEPHONE.getTypeId().toString())
              && ch.getExitDate().after(previousPhone.getExitDate())) {
          previousPhone = ch;
        }
      }

      if (previousPhone != null) {
        return previousPhone.getPhoneNum();
      }
    }

    return null;
  } // end method getPreviousMobilePhoneStr

  //~ ------------------------------------------------------------------------------------------------------------------

  // ------------------------------------------------------------------------------------------------------------------

  // end method getPreviousMobilePhoneStr

  // ------------------------------------------------------------------------------------------------------------------


  /**
   * getter method for previous other phone str.
   *
   * @return  String
   */
  public String getPreviousOtherPhoneStr() {
    CustomerContactPhone previousPhone = null;

    if ((historicalPhones != null) && (historicalPhones.size() > 0)) {
      for (CustomerContactPhone ch : historicalPhones) {
        if ((previousPhone == null)
              && ch.getPhoneType().getTypeId().toString().equals(
                ContactChannel.OTHERPHONE.getTypeId().toString())) {
          previousPhone = ch;
        }

        if ((previousPhone != null)
              && ch.getPhoneType().getTypeId().toString().equals(
                ContactChannel.OTHERPHONE.getTypeId().toString())
              && ch.getExitDate().after(previousPhone.getExitDate())) {
          previousPhone = ch;
        }
      }

      if (previousPhone != null) {
        return previousPhone.getPhoneNum();
      }
    }

    return null;
  } // end method getPreviousOtherPhoneStr

  //~ ------------------------------------------------------------------------------------------------------------------

  // ------------------------------------------------------------------------------------------------------------------

  // end method getPreviousOtherPhoneStr

  // ------------------------------------------------------------------------------------------------------------------


  /**
   * getter method for previous school phone str.
   *
   * @return  String
   */
  public String getPreviousSchoolPhoneStr() {
    CustomerContactPhone previousPhone = null;

    if ((historicalPhones != null) && (historicalPhones.size() > 0)) {
      for (CustomerContactPhone ch : historicalPhones) {
        if ((previousPhone == null)
              && ch.getPhoneType().getTypeId().toString().equals(
                ContactChannel.SCHOOLPHONE.getTypeId().toString())) {
          previousPhone = ch;
        }

        if ((previousPhone != null)
              && ch.getPhoneType().getTypeId().toString().equals(
                ContactChannel.SCHOOLPHONE.getTypeId().toString())
              && ch.getExitDate().after(previousPhone.getExitDate())) {
          previousPhone = ch;
        }
      }

      if (previousPhone != null) {
        return previousPhone.getPhoneNum();
      }
    }

    return null;
  } // the following methods added by Yan for SLM return file --- END

  //~ ------------------------------------------------------------------------------------------------------------------

  // ------------------------------------------------------------------------------------------------------------------

  // the following methods added by Yan for SLM return file --- END

  // ------------------------------------------------------------------------------------------------------------------


  /**
   * getter method for previous sms phone str.
   *
   * @return  String
   */
  public String getPreviousSmsPhoneStr() {
    CustomerContactPhone previousPhone = null;

    if ((historicalPhones != null) && (historicalPhones.size() > 0)) {
      for (CustomerContactPhone ch : historicalPhones) {
        if ((previousPhone == null)
              && ch.getPhoneType().getTypeId().toString().equals(
                ContactChannel.SMSPHONE.getTypeId().toString())) {
          previousPhone = ch;
        }

        if ((previousPhone != null)
              && ch.getPhoneType().getTypeId().toString().equals(
                ContactChannel.SMSPHONE.getTypeId().toString())
              && ch.getExitDate().after(previousPhone.getExitDate())) {
          previousPhone = ch;
        }
      }

      if (previousPhone != null) {
        return previousPhone.getPhoneNum();
      }
    }

    return null;
  } // end method getPreviousSmsPhoneStr

  //~ ------------------------------------------------------------------------------------------------------------------

  // ------------------------------------------------------------------------------------------------------------------

  // end method getPreviousSmsPhoneStr

  // ------------------------------------------------------------------------------------------------------------------


  /**
   * getter method for previous work phone str.
   *
   * @return  String
   */
  public String getPreviousWorkPhoneStr() {
    CustomerContactPhone previousPhone = null;

    if ((historicalPhones != null) && (historicalPhones.size() > 0)) {
      for (CustomerContactPhone ch : historicalPhones) {
        if ((previousPhone == null)
              && ch.getPhoneType().getTypeId().toString().equals(
                ContactChannel.WORKPHONE.getTypeId().toString())) {
          previousPhone = ch;
        }

        if ((previousPhone != null)
              && ch.getPhoneType().getTypeId().toString().equals(
                ContactChannel.WORKPHONE.getTypeId().toString())
              && ch.getExitDate().after(previousPhone.getExitDate())) {
          previousPhone = ch;
        }
      }

      if (previousPhone != null) {
        return previousPhone.getPhoneNum();
      }
    }

    return null;
  } // end method getPreviousWorkPhoneStr

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for reminder email.
   *
   * @return  CustomerContactEmail
   */
  public CustomerContactEmail getReminderEmail() {
    return getEmail(ContactChannel.REMINDEREMAIL.getStringTypeId());
  }
  // ~
  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for reminder phone.
   *
   * @return  CustomerContactPhone
   */
  public CustomerContactPhone getReminderPhone() {
    return getPhone(ContactChannel.REMINDERPHONE.getStringTypeId());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for reminder phone str.
   *
   * @return  String
   */
  public String getReminderPhoneStr() {
    CustomerContactPhone contactPhone = getReminderPhone();

    if (contactPhone != null) {
      return contactPhone.getPhoneNum();
    } else {
      return "";
    }
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   account  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Responsible getResponsible(Account account) {
    for (ResponsibleIndex responsibleIndex : responsibleIndexs) {
      if (responsibleIndex.getResponsible().getAccount().equals(account)) {
        return responsibleIndex.getResponsible();
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible indexs.
   *
   * @return  Set
   */
  public Set<ResponsibleIndex> getResponsibleIndexs() {
    return responsibleIndexs;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for risk rating.
   *
   * @return  String
   */
  public String getRiskRating() {
    return riskRating;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for school phone.
   *
   * @return  CustomerContactPhone
   */
  public CustomerContactPhone getSchoolPhone() {
    return getPhone(ContactChannel.SCHOOLPHONE.getStringTypeId());
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for school phone str.
   *
   * @return  String
   */
  public String getSchoolPhoneStr() {
    CustomerContactPhone contactPhone = getSchoolPhone();

    if (contactPhone != null) {
      return contactPhone.getPhoneNum();
    } else {
      return "";
    }
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  // ------------------------------------------------------------------------------------------------------------------
  /**
   * getter method for service email address.
   *
   * @return  String
   */
  public String getServiceEmailAddress() {
    String               result       = null;
    CustomerContactEmail contactEmail = getEmail(ContactChannel.SERVICEEMAIL.getTypeId().toString());

    if (contactEmail != null) {
      result = contactEmail.getEmailAddress();
    }

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   index  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public CustomerScore getSlmFicoScore(Integer index) {
    log.info("get ficoScore of " + index);

    if ((slmFicoScores != null) && (slmFicoScores.size() > 0)) {
      return slmFicoScores.get(index);
    }

    log.info("there are no scores for this customer...");

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for slm fico scores.
   *
   * @return  List
   */
  public List<CustomerScore> getSlmFicoScores() {
    return slmFicoScores;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Convenient method.
   *
   * @return  SMSPhone
   */
  public CustomerContactPhone getSMSPhone() {
    return getPhone(ContactChannel.SMSPHONE.getStringTypeId());
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get sms phone number string, return empty string if there is no such number.
   *
   * @return  get sms phone number string, return empty string if there is no such number
   */
  public String getSMSPhoneStr() {
    CustomerContactPhone contactPhone = getSMSPhone();

    if (contactPhone != null) {
      return contactPhone.getPhoneNum();
    } else {
      return "";
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for smw customer additional detail.
   *
   * @return  SMWCustomerAdditionalDetail
   */
  public SMWCustomerAdditionalDetail getSmwCustomerAdditionalDetail() {
    return smwCustomerAdditionalDetail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for social insurance number.
   *
   * @return  String
   */
  public String getSocialInsuranceNumber() {
    return socialInsuranceNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for source of additional income.
   *
   * @return  String
   */
  public String getSourceOfAdditionalIncome() {
    return sourceOfAdditionalIncome;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for source of main income.
   *
   * @return  String
   */
  public String getSourceOfMainIncome() {
    return sourceOfMainIncome;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ssn.
   *
   * @return  String
   */
  public String getSsn() {
    if ((null != ssn) && !"".equals(ssn)) {
      ssn = ssn.trim();
    }

    return ssn;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for temporary address.
   *
   * @param   channel  ContactChannel
   *
   * @return  TemporaryCustomerContactAddress
   */
  public TemporaryCustomerContactAddress getTemporaryAddress(ContactChannel channel) {
    if (channel == null) {
      return null;
    }

    if (ContactChannelType.ADDRESS.equals(channel.getChannelType())) {
      return temporaryAddresses.get(channel.getStringTypeId());
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for temporary address.
   *
   * @param   type  String
   *
   * @return  TemporaryCustomerContactAddress
   */
  public TemporaryCustomerContactAddress getTemporaryAddress(String type) {
    return temporaryAddresses.get(type);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for temporary addresses.
   *
   * @return  Map
   */
  public Map<String, TemporaryCustomerContactAddress> getTemporaryAddresses() {
    return temporaryAddresses;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for temporary historical addresses.
   *
   * @return  Set
   */
  public Set<TemporaryCustomerContactAddress> getTemporaryHistoricalAddresses() {
    return temporaryHistoricalAddresses;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for temporary historical phones.
   *
   * @return  Set
   */
  public Set<TemporaryCustomerContactPhone> getTemporaryHistoricalPhones() {
    return temporaryHistoricalPhones;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for temporary phone.
   *
   * @param   channel  ContactChannel
   *
   * @return  TemporaryCustomerContactPhone
   */
  public TemporaryCustomerContactPhone getTemporaryPhone(ContactChannel channel) {
    if (channel == null) {
      return null;
    }

    if (ContactChannelType.PHONE.equals(channel.getChannelType())) {
      return temporaryPhones.get(channel.getStringTypeId());
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for temporary phone.
   *
   * @param   typeId  String
   *
   * @return  TemporaryCustomerContactPhone
   */
  public TemporaryCustomerContactPhone getTemporaryPhone(String typeId) {
    return temporaryPhones.get(typeId);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for temporary phones.
   *
   * @return  Map
   */
  public Map<String, TemporaryCustomerContactPhone> getTemporaryPhones() {
    return temporaryPhones;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for title.
   *
   * @return  String
   */
  public String getTitle() {
    return title;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for top persona.
   *
   * @return  String
   */
  public String getTopPersona() {
    List<String> list = getPersonaList();

    if (list.size() > 0) {
      return list.get(0);
    }

    return null;

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   portfolioId  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getTotalCurrentMonthlyDueAmountByPortfolio(String portfolioId) {
    BigDecimal total    = new BigDecimal(0);
    Iterator   iterator = getResponsibleIndexs().iterator();

    while (iterator.hasNext()) {
      ResponsibleIndex responsibleIndex = (ResponsibleIndex) iterator.next();
      Responsible      responsible      = responsibleIndex.getResponsible();

      if ((responsible != null) && responsible.getAccount().getActive()
            && !responsible.getCustomerType().equals(CustomerType.S)
            && (portfolioId.indexOf(responsible.getAccount().getPortfolio().getPortfolioId().toString()) != -1)) {
        total = total.add(responsible.getAccount().getAccountAdditionalDetail().getClientDefinedDecimal5());
      }
    }

    return total;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for total due.
   *
   * @return  BigDecimal
   */
  public BigDecimal getTotalDue() {
    return totalDue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   portfolioId  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getTotalDueAmountByPortfolio(String portfolioId) {
    BigDecimal total    = new BigDecimal(0);
    Iterator   iterator = getResponsibleIndexs().iterator();

    while (iterator.hasNext()) {
      ResponsibleIndex responsibleIndex = (ResponsibleIndex) iterator.next();
      Responsible      responsible      = responsibleIndex.getResponsible();

      if ((responsible != null) && responsible.getAccount().getActive()
            && !responsible.getCustomerType().equals(CustomerType.S)
            && (portfolioId.indexOf(responsible.getAccount().getPortfolio().getPortfolioId().toString()) != -1)) {
        total = total.add(responsible.getAccount().getClientDefinedDecimal1());
      }
    }

    return total;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   portfolioId  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getTotalMinimumPaymentAmountByPortfolio(String portfolioId) {
    BigDecimal total    = new BigDecimal(0);
    Iterator   iterator = getResponsibleIndexs().iterator();

    while (iterator.hasNext()) {
      ResponsibleIndex responsibleIndex = (ResponsibleIndex) iterator.next();
      Responsible      responsible      = responsibleIndex.getResponsible();

      if ((responsible != null) && responsible.getAccount().getActive()
            && !responsible.getCustomerType().equals(CustomerType.S)
            && (portfolioId.indexOf(responsible.getAccount().getPortfolio().getPortfolioId().toString()) != -1)) {
        total = total.add(responsible.getAccount().getMinimumPayDue());
      }
    }

    return total;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   portfolioId  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getTotalPastDueAmountByPortfolio(String portfolioId) {
    BigDecimal total    = new BigDecimal(0);
    Iterator   iterator = getResponsibleIndexs().iterator();

    while (iterator.hasNext()) {
      ResponsibleIndex responsibleIndex = (ResponsibleIndex) iterator.next();
      Responsible      responsible      = responsibleIndex.getResponsible();

      if ((responsible != null) && responsible.getAccount().getActive()
            && !responsible.getCustomerType().equals(CustomerType.S)
            && (portfolioId.indexOf(responsible.getAccount().getPortfolio().getPortfolioId().toString()) != -1)) {
        total = total.add(responsible.getAccount().getPastDue());
      }
    }

    return total;
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
   * getter method for ucid.
   *
   * @return  String
   */
  public String getUcid() {
    return ucid;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for under18 msg.
   *
   * @return  String
   */
  public String getUnder18Msg() {
    return under18Msg;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for web update address.
   *
   * @return  Set
   */
  public Set<CustomerContactAddress> getWebUpdateAddress() {
    return webUpdateAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for web update emails.
   *
   * @return  Set
   */
  public Set<CustomerContactEmail> getWebUpdateEmails() {
    return webUpdateEmails;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for web update phones.
   *
   * @return  Set
   */
  public Set<CustomerContactPhone> getWebUpdatePhones() {
    return webUpdatePhones;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Convenient method.
   *
   * @return  WorkAddress
   */
  public CustomerContactAddress getWorkAddress() {
    return getAddress(ContactChannel.WORKADDRESS.getStringTypeId());
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Convenient method.
   *
   * @return  WorkEmail
   */
  public CustomerContactEmail getWorkEmail() {
    return getEmail(ContactChannel.WORKEMAIL.getStringTypeId());
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get work email string, return empty string if there is no such email.
   *
   * @return  get work email string, return empty string if there is no such email
   */
  public String getWorkEmailStr() {
    CustomerContactEmail contactEmail = getWorkEmail();

    if (contactEmail != null) {
      return contactEmail.getEmailAddress();
    } else {
      return "";
    }
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Convenient method.
   *
   * @return  WorkPhone
   */
  public CustomerContactPhone getWorkPhone() {
    return getPhone(ContactChannel.WORKPHONE.getStringTypeId());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get work phone number string, return empty string if there is no such number.
   *
   * @return  get work phone number string, return empty string if there is no such number
   */
  public String getWorkPhoneStr() {
    CustomerContactPhone contactPhone = getWorkPhone();

    if (contactPhone != null) {
      return contactPhone.getPhoneNum();
    } else {
      return "";
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The zipCode.
   *
   * @return  the zipCode
   *
   *          <p>not-null = "false" length = "10"</p>
   */
  public String getZipCode() {
    return zipCode;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Override public int hashCode() {
    final int prime  = 71;
    int       result = super.hashCode();

    result = (prime * result)
      + ((ucid == null) ? 0 : ucid.hashCode());
    result = (prime * result)
      + ((createDate == null) ? 0 : createDate.hashCode());
    result = (prime * result)
      + ((ssn == null) ? 0 : ssn.hashCode());
    result = (prime * result)
      + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hasMultiAccounts.
   *
   * @return  Boolean
   */
  public Boolean hasMultiAccounts() {
    Set<Long> accountNumSet = new HashSet<Long>();

    for (ResponsibleIndex responsibleIndex : responsibleIndexs) {
      accountNumSet.add(responsibleIndex.getResponsible().getAccount().getAccountNum());
    }

    if (accountNumSet.size() > 1) {
      return Boolean.TRUE;
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The zipCodeChanged.
   *
   * @return  the zipCodeChanged
   */
  public boolean isZipCodeChanged() {
    return this.zipCodeChanged;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for zip required full.
   *
   * @return  boolean
   */
  public boolean isZipRequiredFull() {
    return isZipRequiredFull;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * lookupFuturePermanentHistoricalAddress.
   *
   * @param   address  FuturePermanentCustomerContactAddress
   *
   * @return  FuturePermanentCustomerContactAddress
   */
  public FuturePermanentCustomerContactAddress lookupFuturePermanentHistoricalAddress(
    FuturePermanentCustomerContactAddress address) {
    for (FuturePermanentCustomerContactAddress a : this.futurePermanentHistoricalAddresses) {
      if (a.equals(address)) {
        return a;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * lookupHistoricalAddress.
   *
   * @param   address  CustomerContactAddress
   *
   * @return  CustomerContactAddress
   */
  public CustomerContactAddress lookupHistoricalAddress(CustomerContactAddress address) {
    for (CustomerContactAddress a : this.historicalAddresses) {
      if (a.equals(address)) {
        return a;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * lookupHistoricalEmail.
   *
   * @param   email  CustomerContactEmail
   *
   * @return  CustomerContactEmail
   */
  public CustomerContactEmail lookupHistoricalEmail(CustomerContactEmail email) {
    for (CustomerContactEmail a : this.historicalEmails) {
      if (a.equals(email)) {
        return a;
      }
    }

    return null;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * lookupHistoricalPhone.
   *
   * @param   phone  CustomerContactPhone
   *
   * @return  CustomerContactPhone
   */
  public CustomerContactPhone lookupHistoricalPhone(CustomerContactPhone phone) {
    for (CustomerContactPhone a : this.historicalPhones) {
      if (a.equals(phone)) {
        return a;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * lookupHistoricalPhone.
   *
   * @param   phone  TemporaryCustomerContactPhone
   *
   * @return  TemporaryCustomerContactPhone
   */
  public TemporaryCustomerContactPhone lookupHistoricalPhone(TemporaryCustomerContactPhone phone) {
    for (TemporaryCustomerContactPhone a : this.temporaryHistoricalPhones) {
      if (a.equals(phone)) {
        return a;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * lookupHistoricalPhone.
   *
   * @param   phone  FuturePermanentCustomerContactPhone
   *
   * @return  FuturePermanentCustomerContactPhone
   */
  public FuturePermanentCustomerContactPhone lookupHistoricalPhone(FuturePermanentCustomerContactPhone phone) {
    for (FuturePermanentCustomerContactPhone a : this.futurePermanentHistoricalPhones) {
      if (a.equals(phone)) {
        return a;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * lookupTemporaryHistoricalAddress.
   *
   * @param   address  TemporaryCustomerContactAddress
   *
   * @return  TemporaryCustomerContactAddress
   */
  public TemporaryCustomerContactAddress lookupTemporaryHistoricalAddress(TemporaryCustomerContactAddress address) {
    for (TemporaryCustomerContactAddress a : this.temporaryHistoricalAddresses) {
      if (a.equals(address)) {
        return a;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * markDoNotContactPhoneNum.
   *
   * @param   phoneNum           String
   * @param   doNotContactUntil  Date
   * @param   reason             DoNotContactReason
   * @param   reasonId           String
   *
   * @return  boolean
   */
  public boolean markDoNotContactPhoneNum(String phoneNum, Date doNotContactUntil, DoNotContactReason reason,
    String reasonId) {
    if (phoneNum == null) {
      return false;
    }

    for (CustomerContactPhone phone : phones.values()) {
      if (phoneNum.equalsIgnoreCase(phone.getPhoneNum())) {
        return Boolean.TRUE.equals(phone.markDoNotContact(
              doNotContactUntil, reason, reasonId));
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * markPhoneNumBad.
   *
   * @param  phoneNum  String
   */
  public void markPhoneNumBad(String phoneNum) {
    markPhoneNum(phoneNum, ContactStatus.BAD);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  phoneNum  DOCUMENT ME!
   */
  public void markPhoneNumVerified(String phoneNum) {
    Set<CustomerContactPhone> ps = getContactPhonesbyPhoneNum(phoneNum);

    if ((ps != null) && (ps.size() > 0)) {
      for (CustomerContactPhone p : ps) {
        p.setStatus(ContactStatus.VERIFIED);
      }
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  phoneNum  DOCUMENT ME!
   */
  public void markPhoneNumWrong(String phoneNum) {
    markPhoneNum(phoneNum, ContactStatus.WRONG);
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Remove address.
   *
   * @param   address  type
   *
   * @return  remove address
   */
  public boolean removeAddress(CustomerContactAddress address) {
    if ((address == null) || (address.getAddressType() == null)
          || (address.getAddressType().getTypeId() == null)) {
      return false; // no update happened
    }

    CustomerContactAddress curAddress = addresses.remove(address.getAddressType().getTypeId().toString());

    if (curAddress != null) {
      curAddress.setHistorical(true);
      curAddress.setExitDate(new Date());
      historicalAddresses.add(curAddress);
    }

    return true;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Remove emailAddress.
   *
   * @param   email  DOCUMENT ME!
   *
   * @return  remove emailAddress
   */
  public boolean removeEmail(CustomerContactEmail email) {
    if ((email == null) || (email.getEmailType() == null)
          || (email.getEmailType().getTypeId() == null)) {
      return false; // no update happened
    }

    CustomerContactEmail curEmail = emails.remove(email.getEmailType().getTypeId().toString());

    if (curEmail != null) {
      curEmail.setHistorical(true);
      curEmail.setExitDate(new Date());
      historicalEmails.add(curEmail);
    }

    return true;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Remove funding account.
   *
   * @param   fundingAccountId  DOCUMENT ME!
   *
   * @return  remove funding account.
   */
  public String removeFundingAccount(Long fundingAccountId) {
    String                   fundAcctNickName = null;
    Iterator<FundingAccount> it               = getFundingAccounts().iterator();

    while (it.hasNext()) {
      FundingAccount fundingAccount = it.next();

      if (fundingAccount.getFundingAccountId().equals(fundingAccountId)) {
        fundAcctNickName = (fundingAccount.getFundingInformation() == null)
          ? null : fundingAccount.getFundingInformation().getNickName();

        it.remove();

        break;
      }
    }

    return fundAcctNickName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Remove phone.
   *
   * @param   phone  type
   *
   * @return  remove phone
   */
  public boolean removePhone(CustomerContactPhone phone) {
    if ((phone == null) || (phone.getPhoneType() == null)
          || (phone.getPhoneType().getTypeId() == null)) {
      return false; // no update happened
    }

    CustomerContactPhone curPhone = phones.remove(phone.getPhoneType().getTypeId().toString());

    if (curPhone != null) {
      curPhone.setHistorical(true);
      curPhone.setExitDate(new Date());
      historicalPhones.add(curPhone);
    }

    return true;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  abn  DOCUMENT ME!
   */
  public void setAbn(String abn) {
    this.abn = abn;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  acn  DOCUMENT ME!
   */
  public void setAcn(String acn) {
    this.acn = acn;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  active  DOCUMENT ME!
   */
  public void setActive(Boolean active) {
    this.active = active;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  activeResponsibleIndexs  DOCUMENT ME!
   */
  public void setActiveResponsibleIndexs(Set<ResponsibleIndex> activeResponsibleIndexs) {
    this.activeResponsibleIndexs = activeResponsibleIndexs;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  addresses  the addresses to set
   */
  public void setAddresses(Map<String, CustomerContactAddress> addresses) {
    this.addresses = addresses;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  allEmails  DOCUMENT ME!
   */
  public void setAllEmails(List<CustomerContactEmail> allEmails) {
    this.allEmails = allEmails;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  allPhones  DOCUMENT ME!
   */
  public void setAllPhones(List<CustomerContactPhone> allPhones) {
    this.allPhones = allPhones;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  balance  DOCUMENT ME!
   */
  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for banned msg.
   *
   * @param  bannedMsg  String
   */
  public void setBannedMsg(String bannedMsg) {
    this.bannedMsg = bannedMsg;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientInfoCreateDate  DOCUMENT ME!
   */
  public void setClientInfoCreateDate(Date clientInfoCreateDate) {
    this.clientInfoCreateDate = clientInfoCreateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientInfoUpdateDate  DOCUMENT ME!
   */
  public void setClientInfoUpdateDate(Date clientInfoUpdateDate) {
    this.clientInfoUpdateDate = clientInfoUpdateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for cmc random digits.
   *
   * @param  cmcRandomDigits  Integer
   */
  public void setCmcRandomDigits(Integer cmcRandomDigits) {
    this.cmcRandomDigits = cmcRandomDigits;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  commercialIncorpDate  DOCUMENT ME!
   */
  public void setCommercialIncorpDate(Date commercialIncorpDate) {
    this.commercialIncorpDate = commercialIncorpDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  commercialLegalName  DOCUMENT ME!
   */
  public void setCommercialLegalName(String commercialLegalName) {
    this.commercialLegalName = commercialLegalName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  commercialName  DOCUMENT ME!
   */
  public void setCommercialName(String commercialName) {
    this.commercialName = commercialName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  commercialTradingAs  DOCUMENT ME!
   */
  public void setCommercialTradingAs(String commercialTradingAs) {
    this.commercialTradingAs = commercialTradingAs;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for complaint msg.
   *
   * @param  complaintMsg  String
   */
  public void setComplaintMsg(String complaintMsg) {
    this.complaintMsg = complaintMsg;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for cosigned responsibles.
   *
   * @param  cosignedResponsibles  List
   */
  public void setCosignedResponsibles(List<Responsible> cosignedResponsibles) {
    this.cosignedResponsibles = cosignedResponsibles;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for cosigner.
   *
   * @param  cosigner  Boolean
   */
  public void setCosigner(Boolean cosigner) {
    isCosigner = cosigner;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for currentResponsible.
   *
   * @param  currentResponsible  Responsible
   */
  public void setCurrentResponsible(Responsible currentResponsible) {
    this.currentResponsible = currentResponsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for customer additional detail.
   *
   * @param  customerAdditionalDetail  CustomerAdditionalDetail
   */
  public void setCustomerAdditionalDetail(CustomerAdditionalDetail customerAdditionalDetail) {
    this.customerAdditionalDetail = customerAdditionalDetail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  customerId  DOCUMENT ME!
   */
  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  customerName  DOCUMENT ME!
   */
  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for customer scores.
   *
   * @param  customerScores  List
   */
  public void setCustomerScores(List<CustomerScore> customerScores) {
    this.customerScores = customerScores;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  dateOfBirth  DOCUMENT ME!
   */
  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for default MRASorting token.
   *
   * @param  defaultMRASortingToken  String
   */
  public void setDefaultMRASortingToken(String defaultMRASortingToken) {
    this.defaultMRASortingToken = defaultMRASortingToken;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for dns.
   *
   * @param  dns  Long
   */
  public void setDns(Long dns) {
    this.dns = dns;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  driversLicenceNo  DOCUMENT ME!
   */
  public void setDriversLicenceNo(String driversLicenceNo) {
    this.driversLicenceNo = driversLicenceNo;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  emails  the emails to set
   */
  public void setEmails(Map<String, CustomerContactEmail> emails) {
    this.emails = emails;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  employerName  DOCUMENT ME!
   */
  public void setEmployerName(String employerName) {
    this.employerName = employerName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  employmentStatus  DOCUMENT ME!
   */
  public void setEmploymentStatus(String employmentStatus) {
    this.employmentStatus = employmentStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for fico score last update date.
   *
   * @param  ficoScoreLastUpdateDate  String
   */
  public void setFicoScoreLastUpdateDate(Date ficoScoreLastUpdateDate) {
    this.ficoScoreLastUpdateDate = ficoScoreLastUpdateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  firstName  DOCUMENT ME!
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for first web login date.
   *
   * @param  firstWebLoginDate  Date
   */
  public void setFirstWebLoginDate(Date firstWebLoginDate) {
    this.firstWebLoginDate = firstWebLoginDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for funding accounts.
   *
   * @param  fundingAccounts  Set
   */
  public void setFundingAccounts(Set<FundingAccount> fundingAccounts) {
    this.fundingAccounts = fundingAccounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  futurePermanentAddresses  DOCUMENT ME!
   */
  public void setFuturePermanentAddresses(Map<String, FuturePermanentCustomerContactAddress> futurePermanentAddresses) {
    this.futurePermanentAddresses = futurePermanentAddresses;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  futurePermanentHistoricalAddresses  DOCUMENT ME!
   */
  public void setFuturePermanentHistoricalAddresses(
    Set<FuturePermanentCustomerContactAddress> futurePermanentHistoricalAddresses) {
    this.futurePermanentHistoricalAddresses = futurePermanentHistoricalAddresses;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  futurePermanentHistoricalPhones  DOCUMENT ME!
   */
  public void setFuturePermanentHistoricalPhones(
    Set<FuturePermanentCustomerContactPhone> futurePermanentHistoricalPhones) {
    this.futurePermanentHistoricalPhones = futurePermanentHistoricalPhones;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  futurePermanentPhones  DOCUMENT ME!
   */
  public void setFuturePermanentPhones(Map<String, FuturePermanentCustomerContactPhone> futurePermanentPhones) {
    this.futurePermanentPhones = futurePermanentPhones;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  gender  DOCUMENT ME!
   */
  public void setGender(String gender) {
    this.gender = gender;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  grossAdditionalIncome  DOCUMENT ME!
   */
  public void setGrossAdditionalIncome(BigDecimal grossAdditionalIncome) {
    this.grossAdditionalIncome = grossAdditionalIncome;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  grossIndividualIncome  DOCUMENT ME!
   */
  public void setGrossIndividualIncome(BigDecimal grossIndividualIncome) {
    this.grossIndividualIncome = grossIndividualIncome;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  hasBankOwnedAccount  DOCUMENT ME!
   */
  public void setHasBankOwnedAccount(Boolean hasBankOwnedAccount) {
    this.hasBankOwnedAccount = hasBankOwnedAccount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  historicalAddresses  DOCUMENT ME!
   */
  public void setHistoricalAddresses(Set<CustomerContactAddress> historicalAddresses) {
    this.historicalAddresses = historicalAddresses;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  historicalEmails  DOCUMENT ME!
   */
  public void setHistoricalEmails(Set<CustomerContactEmail> historicalEmails) {
    this.historicalEmails = historicalEmails;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  historicalPhones  DOCUMENT ME!
   */
  public void setHistoricalPhones(Set<CustomerContactPhone> historicalPhones) {
    this.historicalPhones = historicalPhones;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  industry  DOCUMENT ME!
   */
  public void setIndustry(String industry) {
    this.industry = industry;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for is cosigner.
   *
   * @param  isCosigner  Boolean
   */
  public void setIsCosigner(Boolean isCosigner) {
    this.isCosigner = isCosigner;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  jobCode  DOCUMENT ME!
   */
  public void setJobCode(String jobCode) {
    this.jobCode = jobCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  languageCode  DOCUMENT ME!
   */
  public void setLanguageCode(String languageCode) {
    this.languageCode = languageCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last login date.
   *
   * @param  lastLoginDate  Date
   */
  public void setLastLoginDate(Date lastLoginDate) {
    this.lastLoginDate = lastLoginDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  lastName  DOCUMENT ME!
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  lastPaymentAmount  DOCUMENT ME!
   */
  public void setLastPaymentAmount(BigDecimal lastPaymentAmount) {
    this.lastPaymentAmount = lastPaymentAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  lastPaymentDate  DOCUMENT ME!
   */
  public void setLastPaymentDate(Date lastPaymentDate) {
    this.lastPaymentDate = lastPaymentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for lead account num.
   *
   * @param  leadAccountNum  Long
   */
  public void setLeadAccountNum(Long leadAccountNum) {
    this.leadAccountNum = leadAccountNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  maritalStatus  DOCUMENT ME!
   */
  public void setMaritalStatus(String maritalStatus) {
    this.maritalStatus = maritalStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for match confidence.
   *
   * @param  matchConfidence  String
   */
  public void setMatchConfidence(String matchConfidence) {
    this.matchConfidence = matchConfidence;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  memoryMessages  DOCUMENT ME!
   */
  public void setMemoryMessages(Set<MemoryMessage> memoryMessages) {
    this.memoryMessages = memoryMessages;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  middleName  DOCUMENT ME!
   */
  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  minimumPayDue  currentDue DOCUMENT ME!
   */
  public void setMinimumPayDue(BigDecimal minimumPayDue) {
    this.minimumPayDue = minimumPayDue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  motherMaidenName  DOCUMENT ME!
   */
  public void setMotherMaidenName(String motherMaidenName) {
    this.motherMaidenName = motherMaidenName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  natureOfBusiness  DOCUMENT ME!
   */
  public void setNatureOfBusiness(String natureOfBusiness) {
    this.natureOfBusiness = natureOfBusiness;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  numberOfAccounts  DOCUMENT ME!
   */
  public void setNumberOfAccounts(Long numberOfAccounts) {
    this.numberOfAccounts = numberOfAccounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  pastDue  DOCUMENT ME!
   */
  public void setPastDue(BigDecimal pastDue) {
    this.pastDue = pastDue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentDueDate  DOCUMENT ME!
   */
  public void setPaymentDueDate(Date paymentDueDate) {
    this.paymentDueDate = paymentDueDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  phones  the phones to set
   */
  public void setPhones(Map<String, CustomerContactPhone> phones) {
    this.phones = phones;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  placeOfBirth  DOCUMENT ME!
   */
  public void setPlaceOfBirth(String placeOfBirth) {
    this.placeOfBirth = placeOfBirth;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  portfolio  DOCUMENT ME!
   */

  public void setPortfolio(Portfolio portfolio) {
    this.portfolio = portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  preferHomeAddress  DOCUMENT ME!
   */
  public void setPreferHomeAddress(Integer preferHomeAddress) {
    this.preferHomeAddress = preferHomeAddress;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  preferHomeEmail  DOCUMENT ME!
   */
  public void setPreferHomeEmail(Integer preferHomeEmail) {
    this.preferHomeEmail = preferHomeEmail;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  preferHomePhone  DOCUMENT ME!
   */
  public void setPreferHomePhone(Integer preferHomePhone) {
    this.preferHomePhone = preferHomePhone;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  preferMobilePhone  DOCUMENT ME!
   */
  public void setPreferMobilePhone(Integer preferMobilePhone) {
    this.preferMobilePhone = preferMobilePhone;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  preferTextMessage  DOCUMENT ME!
   */
  public void setPreferTextMessage(Integer preferTextMessage) {
    this.preferTextMessage = preferTextMessage;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  preferWorkPhone  DOCUMENT ME!
   */
  public void setPreferWorkPhone(Integer preferWorkPhone) {
    this.preferWorkPhone = preferWorkPhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  responsibleIndexs  DOCUMENT ME!
   */
  public void setResponsibleIndexs(Set<ResponsibleIndex> responsibleIndexs) {
    this.responsibleIndexs = responsibleIndexs;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  riskRating  DOCUMENT ME!
   */
  public void setRiskRating(String riskRating) {
    this.riskRating = riskRating;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for slm fico scores.
   *
   * @param  slmFicoScores  List
   */
  public void setSlmFicoScores(List<CustomerScore> slmFicoScores) {
    this.slmFicoScores = slmFicoScores;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for smw customer additional detail.
   *
   * @param  smwCustomerAdditionalDetail  SMWCustomerAdditionalDetail
   */
  public void setSmwCustomerAdditionalDetail(SMWCustomerAdditionalDetail smwCustomerAdditionalDetail) {
    this.smwCustomerAdditionalDetail = smwCustomerAdditionalDetail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  socialInsuranceNumber  DOCUMENT ME!
   */
  public void setSocialInsuranceNumber(String socialInsuranceNumber) {
    this.socialInsuranceNumber = socialInsuranceNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  sourceOfAdditionalIncome  DOCUMENT ME!
   */
  public void setSourceOfAdditionalIncome(String sourceOfAdditionalIncome) {
    this.sourceOfAdditionalIncome = sourceOfAdditionalIncome;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  sourceOfMainIncome  DOCUMENT ME!
   */
  public void setSourceOfMainIncome(String sourceOfMainIncome) {
    this.sourceOfMainIncome = sourceOfMainIncome;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  ssn  DOCUMENT ME!
   */
  public void setSsn(String ssn) {
    this.ssn = ssn;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  temporaryAddresses  DOCUMENT ME!
   */
  public void setTemporaryAddresses(Map<String, TemporaryCustomerContactAddress> temporaryAddresses) {
    this.temporaryAddresses = temporaryAddresses;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  temporaryHistoricalAddresses  DOCUMENT ME!
   */
  public void setTemporaryHistoricalAddresses(Set<TemporaryCustomerContactAddress> temporaryHistoricalAddresses) {
    this.temporaryHistoricalAddresses = temporaryHistoricalAddresses;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  temporaryHistoricalPhones  DOCUMENT ME!
   */
  public void setTemporaryHistoricalPhones(Set<TemporaryCustomerContactPhone> temporaryHistoricalPhones) {
    this.temporaryHistoricalPhones = temporaryHistoricalPhones;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  temporaryPhones  DOCUMENT ME!
   */
  public void setTemporaryPhones(Map<String, TemporaryCustomerContactPhone> temporaryPhones) {
    this.temporaryPhones = temporaryPhones;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  title  DOCUMENT ME!
   */
  public void setTitle(String title) {
    this.title = title;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  totalDue  DOCUMENT ME!
   */
  public void setTotalDue(BigDecimal totalDue) {
    this.totalDue = totalDue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  type  DOCUMENT ME!
   */
  public void setType(String type) {
    this.type = type;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  ucid  DOCUMENT ME!
   */
  public void setUcid(String ucid) {
    this.ucid = ucid;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for under18 msg.
   *
   * @param  under18Msg  String
   */
  public void setUnder18Msg(String under18Msg) {
    this.under18Msg = under18Msg;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  webUpdateAddress  DOCUMENT ME!
   */
  public void setWebUpdateAddress(Set<CustomerContactAddress> webUpdateAddress) {
    this.webUpdateAddress = webUpdateAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  webUpdateEmails  DOCUMENT ME!
   */
  public void setWebUpdateEmails(Set<CustomerContactEmail> webUpdateEmails) {
    this.webUpdateEmails = webUpdateEmails;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  webUpdatePhones  DOCUMENT ME!
   */
  public void setWebUpdatePhones(Set<CustomerContactPhone> webUpdatePhones) {
    this.webUpdatePhones = webUpdatePhones;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  zipCode  the zipCode to set
   */
  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  zipCodeChanged  DOCUMENT ME!
   */
  public void setZipCodeChanged(boolean zipCodeChanged) {
    this.zipCodeChanged = zipCodeChanged;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  isZipRequiredFull  DOCUMENT ME!
   */
  public void setZipRequiredFull(boolean isZipRequiredFull) {
    this.isZipRequiredFull = isZipRequiredFull;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Update address.
   *
   * @param   address  DOCUMENT ME!
   *
   * @return  update address
   */
  public boolean updateAddress(CustomerContactAddress address) {
    // address and address type are needed
    if ((address == null) || (address.getAddressType() == null)
          || (address.getAddressType().getTypeId() == null)) {
      return false;
    }

    String                 typeId    = address.getAddressType().getTypeId().toString();
    CustomerContactAddress myAddress = this.addresses.get(typeId);
    Date                   now       = new Date();

    // The address must have at least address1 or address 2 or city or
    // province.
    // requires email address, otherwise refuse to update
    if (!address.hasAddressInfo()) {
      if ((myAddress == null) || (myAddress.getAddressType() == null)
            || (myAddress.getAddressType().getTypeId() == null)
            || (!myAddress.hasAddressInfo())) {
        return false;
      } else {
        // remove current address since it was cleared
        myAddress = this.addresses.remove(typeId);
        myAddress.setHistorical(Boolean.TRUE);
        myAddress.setExitDate(now);
        myAddress.setLastUpdateDate(now);
        myAddress.setLastUpdater(address.getLastUpdater());
        historicalAddresses.add(myAddress);

        return true;
      }
    }

    if (address.equals(myAddress)) {
      // new address is same as old address, check the status changes for this address
      if (((address.getStatus() == null) && (myAddress.getStatus() != null))
            || !address.getStatus().equals(myAddress.getStatus())) {
        myAddress.setStatus(address.getStatus());
        myAddress.setLastUpdateDate(now);
        myAddress.setLastUpdater(address.getLastUpdater());
        this.addresses.put(typeId, myAddress);
      }

      if (((address.addressForeignFlag == null) && (myAddress.addressForeignFlag != null))
            || ((address.addressForeignFlag != null)
              && !address.addressForeignFlag.equals(myAddress.addressForeignFlag))) {
        myAddress.setAddressForeignFlag(address.getAddressForeignFlag());
        myAddress.setLastUpdateDate(now);
        myAddress.setLastUpdater(address.getLastUpdater());
        this.addresses.put(typeId, myAddress);
      }

      // the new address is the same,no need update
      return false;
    } else {
      if (myAddress == null) {
        // New address for this type - first look it up and see if the
        // passed in
        // address is already in historicalAddresses
        myAddress = lookupHistoricalAddress(address);

        if (myAddress == null) {
          myAddress = new CustomerContactAddress();
          myAddress.setHistorical(Boolean.FALSE);
          myAddress.setCustomer(this);
          myAddress.setEntryDate(now);
          myAddress.deepCopy(address);
          myAddress.setLastUpdater(address.getLastUpdater());
        } else {
          this.historicalAddresses.remove(myAddress);
          myAddress.setExitDate(null);
          myAddress.setHistorical(Boolean.FALSE);
          myAddress.setLastUpdateDate(now);
          myAddress.setLastUpdater(address.getLastUpdater());
          myAddress.setSource(address.getSource());
        }

        myAddress.setExternalReferenceId(address.getExternalReferenceId());
        this.addresses.put(typeId, myAddress);
      } else {
        // Already has an address for this type, and it is different -
        // move the
        // old address to historical address
        // NOTE: We are sure there is no address in historicalAddress
        // that
        // equals this address.

        myAddress = this.addresses.remove(typeId);
        myAddress.setHistorical(Boolean.TRUE);
        myAddress.setExitDate(now);
        myAddress.setLastUpdateDate(now);
        myAddress.setLastUpdater(address.getLastUpdater());
        historicalAddresses.add(myAddress);

        CustomerContactAddress newAddress = lookupHistoricalAddress(address);

        if (newAddress == null) {
          newAddress = new CustomerContactAddress();
          newAddress.setHistorical(Boolean.FALSE);
          newAddress.setCustomer(this);
          newAddress.setEntryDate(now);
          newAddress.deepCopy(address);
          newAddress.setLastUpdater(address.getLastUpdater());
        } else {
          historicalAddresses.remove(newAddress);
          newAddress.setExitDate(null);
          newAddress.setHistorical(Boolean.FALSE);
          newAddress.setLastUpdateDate(now);
          newAddress.setLastUpdater(address.getLastUpdater());
          newAddress.setSource(address.getSource());
        }

        newAddress.setExternalReferenceId(address.getExternalReferenceId());
        this.addresses.put(typeId, newAddress);
      } // end if-else

      if (typeId.equals(
              ContactChannel.HOMEADDRESS.getTypeId().toString())
            && !isZipRequiredFull) {
        updateZipCode(address.address.getPostalCode());
      } else if (typeId.equals(
              ContactChannel.HOMEADDRESS.getTypeId().toString())
            && isZipRequiredFull) {
        updateFullZipCode(address.address.getPostalCode());
      }

      return true;
    } // end if-else
  }   // end method updateAddress

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updateAddressExpressConsent.
   *
   * @param   address  CustomerContactAddress
   *
   * @return  boolean
   */
  public boolean updateAddressExpressConsent(CustomerContactAddress address) {
    // address and address type are needed
    if ((address == null) || (address.getAddressType() == null)
          || (address.getAddressType().getTypeId() == null)) {
      return false;
    }

    String                 typeId    = address.getAddressType().getTypeId().toString();
    CustomerContactAddress myAddress = this.addresses.get(typeId);
    Date                   now       = new Date();
    myAddress.setExpressConsent(address.getExpressConsent());
    myAddress.setLastExpressConsentAgent(address.getLastExpressConsentAgent());
    myAddress.setLastExpressConsentUpdateDate(now);
    this.addresses.put(typeId, myAddress);

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updateAddressExpressConsent.
   *
   * @param   address  TemporaryCustomerContactAddress
   *
   * @return  boolean
   */
  public boolean updateAddressExpressConsent(TemporaryCustomerContactAddress address) {
    // address and address type are needed
    if ((address == null) || (address.getAddressType() == null)
          || (address.getAddressType().getTypeId() == null)) {
      return false;
    }

    String                          typeId    = address.getAddressType().getTypeId().toString();
    TemporaryCustomerContactAddress myAddress = this.temporaryAddresses.get(typeId);
    Date                            now       = new Date();
    myAddress.setExpressConsent(address.getExpressConsent());
    myAddress.setLastExpressConsentAgent(address.getLastExpressConsentAgent());
    myAddress.setLastExpressConsentUpdateDate(now);
    this.temporaryAddresses.put(typeId, myAddress);

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updateAddressExpressConsent.
   *
   * @param   address  FuturePermanentCustomerContactAddress
   *
   * @return  boolean
   */
  public boolean updateAddressExpressConsent(FuturePermanentCustomerContactAddress address) {
    // address and address type are needed
    if ((address == null) || (address.getAddressType() == null)
          || (address.getAddressType().getTypeId() == null)) {
      return false;
    }

    String                                typeId    = address.getAddressType().getTypeId().toString();
    FuturePermanentCustomerContactAddress myAddress = this.futurePermanentAddresses.get(typeId);
    Date                                  now       = new Date();
    myAddress.setExpressConsent(address.getExpressConsent());
    myAddress.setLastExpressConsentAgent(address.getLastExpressConsentAgent());
    myAddress.setLastExpressConsentUpdateDate(now);
    this.futurePermanentAddresses.put(typeId, myAddress);

    return true;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Update emailAddress.
   *
   * @param   email  DOCUMENT ME!
   *
   * @return  update emailAddress
   */
  public boolean updateEmail(CustomerContactEmail email) {
    // requires email and email type
    if ((email == null) || (email.getEmailType() == null)
          || (email.getEmailType().getTypeId() == null)) {
      return false;
    }

    // requires email address, otherwise refuse to update
    /*
     * if (!StringUtils.hasText(email.getEmailAddress())) return false;
     */

    String               typeId  = email.getEmailType().getTypeId().toString();
    CustomerContactEmail myEmail = this.emails.get(typeId);
    Date                 now     = new Date();

    // requires email address, otherwise refuse to update
    if (!StringUtils.hasText(email.getEmailAddress())) {
      if ((myEmail == null) || (myEmail.getEmailType() == null)
            || (myEmail.getEmailType().getTypeId() == null)) {
        return false;
      } else {
        // remove current email address since it was cleared
        myEmail = this.emails.remove(typeId);
        myEmail.setHistorical(Boolean.TRUE);
        myEmail.setExitDate(now);
        myEmail.setLastUpdateDate(now);
        myEmail.setLastUpdater(email.getLastUpdater());
        historicalEmails.add(myEmail);

        return true;
      }
    }

    if (email.equals(myEmail)) {
      // new email is same as old email, check the status changes for this email
      if (((email.getStatus() == null) && (myEmail.getStatus() != null))
            || !email.getStatus().equals(myEmail.getStatus())) {
        myEmail.setStatus(email.getStatus());
        myEmail.setLastUpdateDate(now);
        myEmail.setLastUpdater(email.getLastUpdater());
        this.emails.put(typeId, myEmail);
      }

      // new email is same as old email, check the optOut changes for this email for portfolioId:330001
      if ((email.getOptOut() != null) && !email.getOptOut().equals(myEmail.getOptOut())) {
        myEmail.setOptOut(email.getOptOut());
        this.emails.put(typeId, myEmail);
      }

      // same,no need update
      return false;
    } else {
      if (myEmail == null) {
        // New email for this type - first look it up and see if the
        // passed in
        // email is already in historicalEmails
        myEmail = lookupHistoricalEmail(email);

        if (myEmail == null) {
          myEmail = new CustomerContactEmail();
          myEmail.setHistorical(Boolean.FALSE);
          myEmail.setCustomer(this);
          myEmail.setEntryDate(now);
          myEmail.deepCopy(email);
          myEmail.setLastUpdater(email.getLastUpdater());
        } else {
          this.historicalEmails.remove(myEmail);
          myEmail.setExitDate(null);
          myEmail.setHistorical(Boolean.FALSE);
          myEmail.setLastUpdateDate(now);
          myEmail.setLastUpdater(email.getLastUpdater());
          myEmail.setSource(email.getSource());
        }

        if (email.getOptOut() != null) {
          myEmail.setOptOut(email.getOptOut());
        }

        this.emails.put(typeId, myEmail);
      } else {
        // Already has an email for this type, and it is different -
        // move the
        // old email to historical email

        myEmail = this.emails.remove(typeId);
        myEmail.setHistorical(Boolean.TRUE);
        myEmail.setExitDate(now);
        myEmail.setLastUpdateDate(now);
        myEmail.setLastUpdater(email.getLastUpdater());
        historicalEmails.add(myEmail);

        CustomerContactEmail newEmail = lookupHistoricalEmail(email);

        if (newEmail == null) {
          newEmail = new CustomerContactEmail();
          newEmail.setHistorical(Boolean.FALSE);
          newEmail.setCustomer(this);
          newEmail.setEntryDate(now);
          newEmail.deepCopy(email);
          newEmail.setLastUpdater(email.getLastUpdater());
        } else {
          historicalEmails.remove(newEmail);
          newEmail.setExitDate(null);
          newEmail.setHistorical(Boolean.FALSE);
          newEmail.setLastUpdateDate(now);
          newEmail.setLastUpdater(email.getLastUpdater());
          newEmail.setSource(email.getSource());
        }

        if (email.getOptOut() != null) {
          newEmail.setOptOut(email.getOptOut());
        }

        this.emails.put(typeId, newEmail);
      } // end if-else

      return true;
    } // end if-else
  }   // end method updateEmail

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updateEmailExpressConsent.
   *
   * @param   email  CustomerContactEmail
   *
   * @return  boolean
   */
  public boolean updateEmailExpressConsent(CustomerContactEmail email) {
    // address and address type are needed
    if ((email == null) || (email.getEmailType() == null)
          || (email.getEmailType().getTypeId() == null)) {
      return false;
    }

    String               typeId  = email.getEmailType().getTypeId().toString();
    CustomerContactEmail myEmail = this.emails.get(typeId);
    Date                 now     = new Date();
    myEmail.setExpressConsent(email.getExpressConsent());
    myEmail.setLastExpressConsentAgent(myEmail.getLastExpressConsentAgent());
    myEmail.setLastExpressConsentUpdateDate(now);
    this.emails.put(typeId, myEmail);

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updateFuturePermanentAddress.
   *
   * @param   address  FuturePermanentCustomerContactAddress
   *
   * @return  boolean
   */
  public boolean updateFuturePermanentAddress(FuturePermanentCustomerContactAddress address) {
    // address and address type are needed
    if ((address == null) || (address.getAddressType() == null)
          || (address.getAddressType().getTypeId() == null)) {
      return false;
    }

    String                                typeId    = address.getAddressType().getTypeId().toString();
    FuturePermanentCustomerContactAddress myAddress = this.futurePermanentAddresses.get(typeId);
    Date                                  now       = new Date();

    // The address must have at least address1 or address 2 or city or
    // province.
    // requires email address, otherwise refuse to update
    if (!address.getAddress().hasAddressInfo()) {
      if ((myAddress == null) || (myAddress.getAddressType() == null)
            || (myAddress.getAddressType().getTypeId() == null)
            || (!myAddress.getAddress().hasAddressInfo())) {
        return false;
      } else {
        // remove current address since it was cleared
        myAddress = this.futurePermanentAddresses.remove(typeId);
        myAddress.setHistorical(Boolean.TRUE);
        myAddress.setExitDate(now);
        myAddress.setLastUpdateDate(now);
        futurePermanentHistoricalAddresses.add(myAddress);

        return true;
      }
    }

    if (address.equals(myAddress)) {
      // the new address is the same,no need update
      return false;
    } else {
      if (myAddress == null) {
        // New address for this type - first look it up and see if the
        // passed in
        // address is already in historicalAddresses
        myAddress = lookupFuturePermanentHistoricalAddress(address);

        if (myAddress == null) {
          myAddress = new FuturePermanentCustomerContactAddress();
          myAddress.setHistorical(Boolean.FALSE);
          myAddress.setCustomer(this);
          myAddress.setEntryDate(now);
          myAddress.deepCopy(address);
        } else {
          this.futurePermanentHistoricalAddresses.remove(myAddress);
          myAddress.setExitDate(null);
          myAddress.setHistorical(Boolean.FALSE);
          myAddress.setLastUpdateDate(now);
          myAddress.setSource(address.getSource());
        }

        this.futurePermanentAddresses.put(typeId, myAddress);
      } else {
        // Already has an address for this type, and it is different -
        // move the
        // old address to historical address
        // NOTE: We are sure there is no address in historicalAddress
        // that
        // equals this address.

        myAddress = this.futurePermanentAddresses.remove(typeId);
        myAddress.setHistorical(Boolean.TRUE);
        myAddress.setExitDate(now);
        myAddress.setLastUpdateDate(now);
        futurePermanentHistoricalAddresses.add(myAddress);

        FuturePermanentCustomerContactAddress newAddress = lookupFuturePermanentHistoricalAddress(address);

        if (newAddress == null) {
          newAddress = new FuturePermanentCustomerContactAddress();
          newAddress.setHistorical(Boolean.FALSE);
          newAddress.setCustomer(this);
          newAddress.setEntryDate(now);
          newAddress.deepCopy(address);
        } else {
          futurePermanentHistoricalAddresses.remove(newAddress);
          newAddress.setExitDate(null);
          newAddress.setHistorical(Boolean.FALSE);
          newAddress.setLastUpdateDate(now);
          newAddress.setSource(address.getSource());
        }

        this.futurePermanentAddresses.put(typeId, newAddress);
      } // end if-else

      if (typeId.equals(
              ContactChannel.HOMEADDRESS.getTypeId().toString())
            && !isZipRequiredFull) {
        updateZipCode(address.getAddress().getPostalCode());
      } else if (typeId.equals(
              ContactChannel.HOMEADDRESS.getTypeId().toString())
            && isZipRequiredFull) {
        updateFullZipCode(address.getAddress().getPostalCode());
      }

      return true;
    } // end if-else
  }   // end method updateFuturePermanentAddress

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Adding this for barclays pe account loader file to update the email address as empty.
   *
   * @param   email  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean updateOrRemoveEmail(CustomerContactEmail email) {
    // requires email and email type
    if ((email == null) || (email.getEmailType() == null)
          || (email.getEmailType().getTypeId() == null)) {
      return false;
    }

    // requires email address, otherwise refuse to update
    /*
     * if (!StringUtils.hasText(email.getEmailAddress())) return false;
     */

    String               typeId  = email.getEmailType().getTypeId().toString();
    CustomerContactEmail myEmail = this.emails.get(typeId);
    Date                 now     = new Date();

    if (email.equals(myEmail)) {
      // same,no need update
      return false;
    } else {
      if (myEmail == null) {
        // New email for this type - first look it up and see if the
        // passed in
        // email is already in historicalEmails
        myEmail = lookupHistoricalEmail(email);

        if (myEmail == null) {
          myEmail = new CustomerContactEmail();
          myEmail.setHistorical(Boolean.FALSE);
          myEmail.setCustomer(this);
          myEmail.setEntryDate(now);
          myEmail.deepCopy(email);
          myEmail.setLastUpdater(email.getLastUpdater());
        } else {
          this.historicalEmails.remove(myEmail);
          myEmail.setExitDate(null);
          myEmail.setHistorical(Boolean.FALSE);
          myEmail.setLastUpdateDate(now);
          myEmail.setLastUpdater(email.getLastUpdater());
          myEmail.setSource(email.getSource());
        }

        this.emails.put(typeId, myEmail);
      } else {
        // Already has an email for this type, and it is different -
        // move the
        // old email to historical email

        myEmail = this.emails.remove(typeId);
        myEmail.setHistorical(Boolean.TRUE);
        myEmail.setExitDate(now);
        myEmail.setLastUpdateDate(now);
        historicalEmails.add(myEmail);

        CustomerContactEmail newEmail = lookupHistoricalEmail(email);

        if (newEmail == null) {
          newEmail = new CustomerContactEmail();
          newEmail.setHistorical(Boolean.FALSE);
          newEmail.setCustomer(this);
          newEmail.setEntryDate(now);
          newEmail.deepCopy(email);
          newEmail.setLastUpdater(email.getLastUpdater());
        } else {
          historicalEmails.remove(newEmail);
          newEmail.setExitDate(null);
          newEmail.setHistorical(Boolean.FALSE);
          newEmail.setLastUpdateDate(now);
          newEmail.setLastUpdater(email.getLastUpdater());
          newEmail.setSource(email.getSource());
        }

        this.emails.put(typeId, newEmail);
      } // end if-else

      return true;
    } // end if-else
  }   // end method updateOrRemoveEmail

  //~ ------------------------------------------------------------------------------------------------------------------

  // ------------------------------------------------------------------------------------------------------------------
  // Added by Etisbew on 10/20/2009 for USB Phone (USB-124)-Start
  /**
   * To Update Phone Number for the USB/Elan portfolio.This method will update the Phonenumber to Empty if string passed
   * from placement file has No digits/All Zeros/Any Special Characters. If the Phone number passed is of 10 digits/less
   * than 10 digits then it will update phone umber as it is available.
   *
   * @param   phoneNum        DOCUMENT ME!
   * @param   contactChannel  DOCUMENT ME!
   * @param   contactSource   DOCUMENT ME!
   * @param   contactStatus   DOCUMENT ME!
   *
   * @return  to Update Phone Number for the USB/Elan portfolio.This method will update the Phonenumber to Empty if
   *          string passed from placement file has No digits/All Zeros/Any Special Characters.
   */
  public boolean updateOrRemovePhone(String phoneNum, ContactChannel contactChannel, ContactSource contactSource,
    ContactStatus contactStatus) {
    phoneNum = phoneNum.replaceAll("[^0-9]", "");

    CustomerContactPhone phone = new CustomerContactPhone();
    phone.setPhoneType(new PhoneType(contactChannel.getTypeId(),
        contactChannel.toString()));
    phone.setPhoneNum(phoneNum);
    phone.setSource(contactSource);
    phone.setStatus(contactStatus);

    if (phone == null) {
      return false;
    }

    String               typeId  = phone.getPhoneType().getTypeId().toString();
    CustomerContactPhone myPhone = this.phones.get(typeId);
    Date                 now     = new Date();

    // nothing to update or Delete the Phone
    if ((phone == null) || (phone.getPhoneType() == null)
          || (phone.getPhoneType().getTypeId() == null)) {
      return false;
    }

    // Format phone number: Should be number only in the DB.
    // US number should be 10 digits with area code.
    if (StringUtils.hasText(phone.getPhoneNum())) {
      phone.setPhoneNum(phone.getPhoneNum().replaceAll("[^0-9]", ""));
    }

    if (StringUtils.hasText(phone.getExtension())) {
      phone.setExtension(phone.getExtension().replaceAll("[^0-9]", ""));
    }

    if (phone.equals(myPhone)) {
      // just same,no need update
      return false;
    } else {
      if (myPhone == null) {
        // New phone for this type - first look it up and see if the
        // passed in
        // phone is already in historicalPhones
        myPhone = lookupHistoricalPhone(phone);

        if (myPhone == null) {
          myPhone = new CustomerContactPhone();
          myPhone.setHistorical(Boolean.FALSE);
          myPhone.setCustomer(this);
          myPhone.setEntryDate(now);
          myPhone.deepCopy(phone);
          myPhone.setLastUpdater(phone.getLastUpdater());
        } else {
          this.historicalPhones.remove(myPhone);
          myPhone.setExitDate(null);
          myPhone.setHistorical(Boolean.FALSE);
          myPhone.setLastUpdateDate(now);
          myPhone.setLastUpdater(phone.getLastUpdater());
          myPhone.setSource(phone.getSource());
        }

        this.phones.put(typeId, myPhone);
      } else {
        // Already has an phone for this type, and it is different -
        // move the
        // old phone to historical phone

        myPhone = this.phones.remove(typeId);
        myPhone.setHistorical(Boolean.TRUE);
        myPhone.setExitDate(now);
        myPhone.setLastUpdateDate(now);
        historicalPhones.add(myPhone);

        CustomerContactPhone newPhone = lookupHistoricalPhone(phone);

        if (newPhone == null) {
          newPhone = new CustomerContactPhone();
          newPhone.setHistorical(Boolean.FALSE);
          newPhone.setCustomer(this);
          newPhone.setEntryDate(now);
          newPhone.deepCopy(phone);
          newPhone.setLastUpdater(phone.getLastUpdater());
        } else {
          historicalPhones.remove(newPhone);
          newPhone.setExitDate(null);
          newPhone.setHistorical(Boolean.FALSE);
          newPhone.setLastUpdateDate(now);
          newPhone.setLastUpdater(phone.getLastUpdater());
          newPhone.setSource(phone.getSource());
        }

        this.phones.put(typeId, newPhone);
      } // end if-else

      return true;
    } // end if-else
  }   // end method updateOrRemovePhone

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Update phone.
   *
   * @param   phone          DOCUMENT ME!
   * @param   validCallType  DOCUMENT ME!
   *
   * @return  update phone
   */
  public boolean updatePhone(CustomerContactPhone phone, boolean validCallType) {
    // nothing to update or Delete the Phone
    if ((phone == null) || (phone.getPhoneType() == null)
          || (phone.getPhoneType().getTypeId() == null)) {
      return false;
    }

    String               typeId  = phone.getPhoneType().getTypeId().toString();
    CustomerContactPhone myPhone = this.phones.get(typeId);
    Date                 now     = new Date();

    // Format phone number: Should be number only in the DB.
    // US number should be 10 digits with area code.
    if (StringUtils.hasText(phone.getPhoneNum())) {
      phone.setPhoneNum(phone.getPhoneNum().replaceAll("[^0-9]", ""));
    }

    if (StringUtils.hasText(phone.getExtension())) {
      phone.setExtension(phone.getExtension().replaceAll("[^0-9]", ""));
    }

    // requires phone number, otherwise refuse to update
    if (!StringUtils.hasText(phone.getPhoneNum())) {
      if ((myPhone == null) || (myPhone.getPhoneType() == null)
            || (myPhone.getPhoneType().getTypeId() == null)) {
        return false;
      } else {
        // remove current phone since the number was cleared
        myPhone = this.phones.remove(typeId);
        myPhone.setHistorical(Boolean.TRUE);
        myPhone.setExitDate(now);
        myPhone.setLastUpdateDate(now);
        myPhone.setLastUpdater(phone.getLastUpdater());
        historicalPhones.add(myPhone);

        return true;
      }
    }

    if (phone.equals(myPhone)) {
      Boolean updateCurrentPhone = false;

      // both the phone numbers are same but we also need to check the badNumber and isMobile indicator.
      // adding this block for upc
      // 1) if we update the equals method in contact phone to compare badNumber & isMobile,
      // then it will insert a new record in the contact phone with same phoneNumber but with different badNumber or isMobile status which is not desired
      // 2)To avoid duplicate number insertion we will compare badNumber and isMobile from phone object and mypPhone objects and update the status
      // 3) for isMobile for UPC we have three statuses Y, N and NULL
      if ((phone.getBadNumber() == null) && (myPhone.getBadNumber() == null)) {
        /* same BadNumber value,no need to update*/
      } else if (((phone.getBadNumber() == null) && (myPhone.getBadNumber() != null))
            || !phone.getBadNumber().equals(myPhone.getBadNumber())) {
        // update the existing phone as there is change in BadNumber
        myPhone.setBadNumber(phone.getBadNumber());
        updateCurrentPhone = true;
      }

      if ((phone.getIsMobile() == null) && (myPhone.getIsMobile() == null)) {
        /* same isMobile value, no need update*/
      } else if (((phone.getIsMobile() == null) && (myPhone.getIsMobile() != null))
            || !phone.getIsMobile().equals(myPhone.getIsMobile())) {
        // update the existing phone as there is change in isMobile
        myPhone.setIsMobile(phone.getIsMobile());
        updateCurrentPhone = true;
      }

      // new phone number is same as old phone number, check the status changes for this phone number
      if (((phone.getStatus() == null) && (myPhone.getStatus() != null))
            || !phone.getStatus().equals(myPhone.getStatus())) {
        myPhone.setStatus(phone.getStatus());
        updateCurrentPhone = true;
      }

      if (updateCurrentPhone) {
        myPhone.setLastUpdateDate(now);
        myPhone.setLastUpdater(phone.getLastUpdater());
        this.phones.put(typeId, myPhone);

        return true;
      }

      // just same,no need update
      return updateCurrentPhone;
    } else {
      if (myPhone == null) {
        // New phone for this type - first look it up and see if the
        // passed in
        // phone is already in historicalPhones
        myPhone = lookupHistoricalPhone(phone);

        if (myPhone == null) {
          myPhone = new CustomerContactPhone();
          myPhone.setHistorical(Boolean.FALSE);
          myPhone.setCustomer(this);
          myPhone.setEntryDate(now);
          myPhone.deepCopy(phone);
          myPhone.setLastUpdater(phone.getLastUpdater());

          if (!validCallType) {
            myPhone.setCallType(null);
          }
        } else {
          this.historicalPhones.remove(myPhone);
          myPhone.setExitDate(null);
          myPhone.setHistorical(Boolean.FALSE);
          myPhone.setLastUpdateDate(now);
          myPhone.setLastUpdater(phone.getLastUpdater());
          myPhone.setSource(phone.getSource());
        }

        this.phones.put(typeId, myPhone);
      } else {
        // Already has an phone for this type, and it is different -
        // move the
        // old phone to historical phone

        myPhone = this.phones.remove(typeId);
        myPhone.setHistorical(Boolean.TRUE);
        myPhone.setExitDate(now);
        myPhone.setLastUpdateDate(now);
        myPhone.setLastUpdater(phone.getLastUpdater());
        historicalPhones.add(myPhone);

        CustomerContactPhone newPhone = lookupHistoricalPhone(phone);

        if (newPhone == null) {
          newPhone = new CustomerContactPhone();
          newPhone.setHistorical(Boolean.FALSE);
          newPhone.setCustomer(this);
          newPhone.setEntryDate(now);
          newPhone.deepCopy(phone);
          newPhone.setLastUpdater(phone.getLastUpdater());

          if (!validCallType) {
            newPhone.setCallType(myPhone.getCallType());
          }
        } else {
          historicalPhones.remove(newPhone);
          newPhone.setExitDate(null);
          newPhone.setHistorical(Boolean.FALSE);
          newPhone.setLastUpdateDate(now);
          newPhone.setLastUpdater(phone.getLastUpdater());
          newPhone.setSource(phone.getSource());
        }

        this.phones.put(typeId, newPhone);
      } // end if-else

      return true;
    } // end if-else
  }   // end method updatePhone

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updatePhone.
   *
   * @param   phone          TemporaryCustomerContactPhone
   * @param   validCallType  boolean
   *
   * @return  boolean
   */
  public boolean updatePhone(TemporaryCustomerContactPhone phone, boolean validCallType) {
    // nothing to update or Delete the Phone
    if ((phone == null) || (phone.getPhoneType() == null)
          || (phone.getPhoneType().getTypeId() == null)) {
      return false;
    }

    String                        typeId  = phone.getPhoneType().getTypeId().toString();
    TemporaryCustomerContactPhone myPhone = this.temporaryPhones.get(typeId);
    Date                          now     = new Date();

    // Format phone number: Should be number only in the DB.
    // US number should be 10 digits with area code.
    if (StringUtils.hasText(phone.getPhoneNum())) {
      phone.setPhoneNum(phone.getPhoneNum().replaceAll("[^0-9]", ""));
    }

    if (StringUtils.hasText(phone.getExtension())) {
      phone.setExtension(phone.getExtension().replaceAll("[^0-9]", ""));
    }

    // requires phone number, otherwise refuse to update
    if (!StringUtils.hasText(phone.getPhoneNum())) {
      if ((myPhone == null) || (myPhone.getPhoneType() == null)
            || (myPhone.getPhoneType().getTypeId() == null)) {
        return false;
      } else {
        // remove current phone since the number was cleared
        myPhone = this.temporaryPhones.remove(typeId);
        myPhone.setHistorical(Boolean.TRUE);
        myPhone.setExitDate(now);
        myPhone.setLastUpdateDate(now);
        temporaryHistoricalPhones.add(myPhone);

        return true;
      }
    }

    if (phone.equals(myPhone)) {
      Boolean updateCurrentPhone = false;

      // both the phone numbers are same but we also need to check the badNumber and isMobile indicator.
      // adding this block for upc
      // 1) if we update the equals method in contact phone to compare badNumber & isMobile,
      // then it will insert a new record in the contact phone with same phoneNumber but with different badNumber or isMobile status which is not desired
      // 2)To avoid duplicate number insertion we will compare badNumber and isMobile from phone object and mypPhone objects and update the status
      // 3) for isMobile for UPC we have three statuses Y, N and NULL
      if ((phone.getBadNumber() == null) && (myPhone.getBadNumber() == null)) {
        /* same BadNumber value,no need to update*/
      } else if (((phone.getBadNumber() == null) && (myPhone.getBadNumber() != null))
            || !phone.getBadNumber().equals(myPhone.getBadNumber())) {
        // update the existing phone as there is change in BadNumber
        myPhone.setBadNumber(phone.getBadNumber());
        updateCurrentPhone = true;
      }

      if ((phone.getIsMobile() == null) && (myPhone.getIsMobile() == null)) {
        /* same isMobile value, no need update*/
      } else if (((phone.getIsMobile() == null) && (myPhone.getIsMobile() != null))
            || !phone.getIsMobile().equals(myPhone.getIsMobile())) {
        // update the existing phone as there is change in isMobile
        myPhone.setIsMobile(phone.getIsMobile());
        updateCurrentPhone = true;
      }

      if (updateCurrentPhone) {
        myPhone.setLastUpdateDate(now);
        this.temporaryPhones.put(typeId, myPhone);

        return true;
      }

      // just same,no need update
      return updateCurrentPhone;
    } else {
      if (myPhone == null) {
        // New phone for this type - first look it up and see if the
        // passed in
        // phone is already in historicalPhones
        myPhone = lookupHistoricalPhone(phone);

        if (myPhone == null) {
          myPhone = new TemporaryCustomerContactPhone();
          myPhone.setHistorical(Boolean.FALSE);
          myPhone.setCustomer(this);
          myPhone.setEntryDate(now);
          myPhone.deepCopy(phone);

          if (!validCallType) {
            myPhone.setCallType(null);
          }
        } else {
          this.temporaryHistoricalPhones.remove(myPhone);
          myPhone.setExitDate(null);
          myPhone.setHistorical(Boolean.FALSE);
          myPhone.setLastUpdateDate(now);
          myPhone.setSource(phone.getSource());
        }

        this.temporaryPhones.put(typeId, myPhone);
      } else {
        // Already has an phone for this type, and it is different -
        // move the
        // old phone to historical phone

        myPhone = this.temporaryPhones.remove(typeId);
        myPhone.setHistorical(Boolean.TRUE);
        myPhone.setExitDate(now);
        myPhone.setLastUpdateDate(now);
        temporaryHistoricalPhones.add(myPhone);

        TemporaryCustomerContactPhone newPhone = lookupHistoricalPhone(phone);

        if (newPhone == null) {
          newPhone = new TemporaryCustomerContactPhone();
          newPhone.setHistorical(Boolean.FALSE);
          newPhone.setCustomer(this);
          newPhone.setEntryDate(now);
          newPhone.deepCopy(phone);

          if (!validCallType) {
            newPhone.setCallType(myPhone.getCallType());
          }
        } else {
          temporaryHistoricalPhones.remove(newPhone);
          newPhone.setExitDate(null);
          newPhone.setHistorical(Boolean.FALSE);
          newPhone.setLastUpdateDate(now);
          newPhone.setSource(phone.getSource());
        }

        this.temporaryPhones.put(typeId, newPhone);
      } // end if-else

      return true;
    } // end if-else
  }   // end method updatePhone

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updatePhone.
   *
   * @param   phone          FuturePermanentCustomerContactPhone
   * @param   validCallType  boolean
   *
   * @return  boolean
   */
  public boolean updatePhone(FuturePermanentCustomerContactPhone phone, boolean validCallType) {
    // nothing to update or Delete the Phone
    if ((phone == null) || (phone.getPhoneType() == null)
          || (phone.getPhoneType().getTypeId() == null)) {
      return false;
    }

    String                              typeId  = phone.getPhoneType().getTypeId().toString();
    FuturePermanentCustomerContactPhone myPhone = this.futurePermanentPhones.get(typeId);
    Date                                now     = new Date();

    // Format phone number: Should be number only in the DB.
    // US number should be 10 digits with area code.
    if (StringUtils.hasText(phone.getPhoneNum())) {
      phone.setPhoneNum(phone.getPhoneNum().replaceAll("[^0-9]", ""));
    }

    if (StringUtils.hasText(phone.getExtension())) {
      phone.setExtension(phone.getExtension().replaceAll("[^0-9]", ""));
    }

    // requires phone number, otherwise refuse to update
    if (!StringUtils.hasText(phone.getPhoneNum())) {
      if ((myPhone == null) || (myPhone.getPhoneType() == null)
            || (myPhone.getPhoneType().getTypeId() == null)) {
        return false;
      } else {
        // remove current phone since the number was cleared
        myPhone = this.futurePermanentPhones.remove(typeId);
        myPhone.setHistorical(Boolean.TRUE);
        myPhone.setExitDate(now);
        myPhone.setLastUpdateDate(now);
        futurePermanentHistoricalPhones.add(myPhone);

        return true;
      }
    }

    if (phone.equals(myPhone)) {
      Boolean updateCurrentPhone = false;

      // both the phone numbers are same but we also need to check the badNumber and isMobile indicator.
      // adding this block for upc
      // 1) if we update the equals method in contact phone to compare badNumber & isMobile,
      // then it will insert a new record in the contact phone with same phoneNumber but with different badNumber or isMobile status which is not desired
      // 2)To avoid duplicate number insertion we will compare badNumber and isMobile from phone object and mypPhone objects and update the status
      // 3) for isMobile for UPC we have three statuses Y, N and NULL
      if ((phone.getBadNumber() == null) && (myPhone.getBadNumber() == null)) {
        /* same BadNumber value,no need to update*/
      } else if (((phone.getBadNumber() == null) && (myPhone.getBadNumber() != null))
            || !phone.getBadNumber().equals(myPhone.getBadNumber())) {
        // update the existing phone as there is change in BadNumber
        myPhone.setBadNumber(phone.getBadNumber());
        updateCurrentPhone = true;
      }

      if ((phone.getIsMobile() == null) && (myPhone.getIsMobile() == null)) {
        /* same isMobile value, no need update*/
      } else if (((phone.getIsMobile() == null) && (myPhone.getIsMobile() != null))
            || !phone.getIsMobile().equals(myPhone.getIsMobile())) {
        // update the existing phone as there is change in isMobile
        myPhone.setIsMobile(phone.getIsMobile());
        updateCurrentPhone = true;
      }

      if (updateCurrentPhone) {
        myPhone.setLastUpdateDate(now);
        this.futurePermanentPhones.put(typeId, myPhone);

        return true;
      }

      // just same,no need update
      return updateCurrentPhone;
    } else {
      if (myPhone == null) {
        // New phone for this type - first look it up and see if the
        // passed in
        // phone is already in historicalPhones
        myPhone = lookupHistoricalPhone(phone);

        if (myPhone == null) {
          myPhone = new FuturePermanentCustomerContactPhone();
          myPhone.setHistorical(Boolean.FALSE);
          myPhone.setCustomer(this);
          myPhone.setEntryDate(now);
          myPhone.deepCopy(phone);

          if (!validCallType) {
            myPhone.setCallType(null);
          }
        } else {
          this.futurePermanentHistoricalPhones.remove(myPhone);
          myPhone.setExitDate(null);
          myPhone.setHistorical(Boolean.FALSE);
          myPhone.setLastUpdateDate(now);
          myPhone.setSource(phone.getSource());
        }

        this.futurePermanentPhones.put(typeId, myPhone);
      } else {
        // Already has an phone for this type, and it is different -
        // move the
        // old phone to historical phone

        myPhone = this.futurePermanentPhones.remove(typeId);
        myPhone.setHistorical(Boolean.TRUE);
        myPhone.setExitDate(now);
        myPhone.setLastUpdateDate(now);
        futurePermanentHistoricalPhones.add(myPhone);

        FuturePermanentCustomerContactPhone newPhone = lookupHistoricalPhone(phone);

        if (newPhone == null) {
          newPhone = new FuturePermanentCustomerContactPhone();
          newPhone.setHistorical(Boolean.FALSE);
          newPhone.setCustomer(this);
          newPhone.setEntryDate(now);
          newPhone.deepCopy(phone);

          if (!validCallType) {
            newPhone.setCallType(myPhone.getCallType());
          }
        } else {
          futurePermanentHistoricalPhones.remove(newPhone);
          newPhone.setExitDate(null);
          newPhone.setHistorical(Boolean.FALSE);
          newPhone.setLastUpdateDate(now);
          newPhone.setSource(phone.getSource());
        }

        this.futurePermanentPhones.put(typeId, newPhone);
      } // end if-else

      return true;
    } // end if-else
  }   // end method updatePhone

  //~ ------------------------------------------------------------------------------------------------------------------

  // ------------------------------------------------------------------------------------------------------------------

  // end method updatePhone

  // ------------------------------------------------------------------------------------------------------------------
  /**
   * updatePhone.
   *
   * @param   phoneNum        String
   * @param   contactChannel  ContactChannel
   * @param   contactSource   ContactSource
   * @param   contactStatus   ContactStatus
   *
   * @return  boolean
   */
  public boolean updatePhone(String phoneNum, ContactChannel contactChannel, ContactSource contactSource,
    ContactStatus contactStatus) {
    return updatePhone(convertToContactPhone(phoneNum, contactChannel,
          contactSource, contactStatus), true);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updatePhoneExpressConsent.
   *
   * @param   phone  CustomerContactPhone
   *
   * @return  boolean
   */
  public boolean updatePhoneExpressConsent(CustomerContactPhone phone) {
    // nothing to update or Delete the Phone
    if ((phone == null) || (phone.getPhoneType() == null)
          || (phone.getPhoneType().getTypeId() == null)) {
      return false;
    }

    String               typeId  = phone.getPhoneType().getTypeId().toString();
    CustomerContactPhone myPhone = this.phones.get(typeId);
    Date                 now     = new Date();
    myPhone.setExpressConsent(phone.getExpressConsent());
    myPhone.setLastExpressConsentAgent(phone.getLastExpressConsentAgent());
    myPhone.setLastExpressConsentUpdateDate(now);
    myPhone.setExpressConsentSMS(phone.getExpressConsent());
    myPhone.setLastExpressConsentSMSAgent(phone.getLastExpressConsentAgent());
    myPhone.setLastExpressConsentSMSUpdateDate(now);
    myPhone.setExpressConsentVoice(phone.getExpressConsent());
    myPhone.setLastExpressConsentVoiceAgent(phone.getLastExpressConsentAgent());
    myPhone.setLastExpressConsentVoiceUpdateDate(now);
    this.phones.put(typeId, myPhone);

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updatePhoneExpressConsent.
   *
   * @param   phone  TemporaryCustomerContactPhone
   *
   * @return  boolean
   */
  public boolean updatePhoneExpressConsent(TemporaryCustomerContactPhone phone) {
    // nothing to update or Delete the Phone
    if ((phone == null) || (phone.getPhoneType() == null)
          || (phone.getPhoneType().getTypeId() == null)) {
      return false;
    }

    String                        typeId  = phone.getPhoneType().getTypeId().toString();
    TemporaryCustomerContactPhone myPhone = this.temporaryPhones.get(typeId);
    Date                          now     = new Date();
    myPhone.setExpressConsent(phone.getExpressConsent());
    myPhone.setLastExpressConsentAgent(phone.getLastExpressConsentAgent());
    myPhone.setLastExpressConsentUpdateDate(now);
    myPhone.setExpressConsentSMS(phone.getExpressConsent());
    myPhone.setLastExpressConsentSMSAgent(phone.getLastExpressConsentAgent());
    myPhone.setLastExpressConsentSMSUpdateDate(now);
    myPhone.setExpressConsentVoice(phone.getExpressConsent());
    myPhone.setLastExpressConsentVoiceAgent(phone.getLastExpressConsentAgent());
    myPhone.setLastExpressConsentVoiceUpdateDate(now);
    this.temporaryPhones.put(typeId, myPhone);

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updatePhoneExpressConsent.
   *
   * @param   phone  FuturePermanentCustomerContactPhone
   *
   * @return  boolean
   */
  public boolean updatePhoneExpressConsent(FuturePermanentCustomerContactPhone phone) {
    // nothing to update or Delete the Phone
    if ((phone == null) || (phone.getPhoneType() == null)
          || (phone.getPhoneType().getTypeId() == null)) {
      return false;
    }

    String                              typeId  = phone.getPhoneType().getTypeId().toString();
    FuturePermanentCustomerContactPhone myPhone = this.futurePermanentPhones.get(typeId);
    Date                                now     = new Date();
    myPhone.setExpressConsent(phone.getExpressConsent());
    myPhone.setLastExpressConsentAgent(phone.getLastExpressConsentAgent());
    myPhone.setLastExpressConsentUpdateDate(now);
    myPhone.setExpressConsentSMS(phone.getExpressConsent());
    myPhone.setLastExpressConsentSMSAgent(phone.getLastExpressConsentAgent());
    myPhone.setLastExpressConsentSMSUpdateDate(now);
    myPhone.setExpressConsentVoice(phone.getExpressConsent());
    myPhone.setLastExpressConsentVoiceAgent(phone.getLastExpressConsentAgent());
    myPhone.setLastExpressConsentVoiceUpdateDate(now);
    this.futurePermanentPhones.put(typeId, myPhone);

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updatePhoneExpressConsentSMS.
   *
   * @param   phone  CustomerContactPhone
   *
   * @return  boolean
   */
  public boolean updatePhoneExpressConsentSMS(CustomerContactPhone phone) {
    // nothing to update or Delete the Phone
    if ((phone == null) || (phone.getPhoneType() == null)
          || (phone.getPhoneType().getTypeId() == null)) {
      return false;
    }

    String               typeId  = phone.getPhoneType().getTypeId().toString();
    CustomerContactPhone myPhone = this.phones.get(typeId);
    Date                 now     = new Date();
    myPhone.setExpressConsentSMS(phone.getExpressConsentSMS());
    myPhone.setLastExpressConsentSMSAgent(phone.getLastExpressConsentSMSAgent());
    myPhone.setLastExpressConsentSMSUpdateDate(now);
    this.phones.put(typeId, myPhone);

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updatePhoneExpressConsentSMS.
   *
   * @param   phone  TemporaryCustomerContactPhone
   *
   * @return  boolean
   */
  public boolean updatePhoneExpressConsentSMS(TemporaryCustomerContactPhone phone) {
    // nothing to update or Delete the Phone
    if ((phone == null) || (phone.getPhoneType() == null)
          || (phone.getPhoneType().getTypeId() == null)) {
      return false;
    }

    String                        typeId  = phone.getPhoneType().getTypeId().toString();
    TemporaryCustomerContactPhone myPhone = this.temporaryPhones.get(typeId);
    Date                          now     = new Date();
    myPhone.setExpressConsentSMS(phone.getExpressConsentSMS());
    myPhone.setLastExpressConsentSMSAgent(phone.getLastExpressConsentSMSAgent());
    myPhone.setLastExpressConsentSMSUpdateDate(now);
    this.temporaryPhones.put(typeId, myPhone);

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updatePhoneExpressConsentSMS.
   *
   * @param   phone  FuturePermanentCustomerContactPhone
   *
   * @return  boolean
   */
  public boolean updatePhoneExpressConsentSMS(FuturePermanentCustomerContactPhone phone) {
    // nothing to update or Delete the Phone
    if ((phone == null) || (phone.getPhoneType() == null)
          || (phone.getPhoneType().getTypeId() == null)) {
      return false;
    }

    String                              typeId  = phone.getPhoneType().getTypeId().toString();
    FuturePermanentCustomerContactPhone myPhone = this.futurePermanentPhones.get(typeId);
    Date                                now     = new Date();
    myPhone.setExpressConsentSMS(phone.getExpressConsentSMS());
    myPhone.setLastExpressConsentSMSAgent(phone.getLastExpressConsentSMSAgent());
    myPhone.setLastExpressConsentSMSUpdateDate(now);
    this.futurePermanentPhones.put(typeId, myPhone);

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updatePhoneExpressConsentVoice.
   *
   * @param   phone  CustomerContactPhone
   *
   * @return  boolean
   */
  public boolean updatePhoneExpressConsentVoice(CustomerContactPhone phone) {
    // nothing to update or Delete the Phone
    if ((phone == null) || (phone.getPhoneType() == null)
          || (phone.getPhoneType().getTypeId() == null)) {
      return false;
    }

    String               typeId  = phone.getPhoneType().getTypeId().toString();
    CustomerContactPhone myPhone = this.phones.get(typeId);
    Date                 now     = new Date();
    myPhone.setExpressConsentVoice(phone.getExpressConsentVoice());
    myPhone.setLastExpressConsentVoiceAgent(phone.getLastExpressConsentVoiceAgent());
    myPhone.setLastExpressConsentVoiceUpdateDate(now);
    this.phones.put(typeId, myPhone);

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updatePhoneExpressConsentVoice.
   *
   * @param   phone  TemporaryCustomerContactPhone
   *
   * @return  boolean
   */
  public boolean updatePhoneExpressConsentVoice(TemporaryCustomerContactPhone phone) {
    // nothing to update or Delete the Phone
    if ((phone == null) || (phone.getPhoneType() == null)
          || (phone.getPhoneType().getTypeId() == null)) {
      return false;
    }

    String                        typeId  = phone.getPhoneType().getTypeId().toString();
    TemporaryCustomerContactPhone myPhone = this.temporaryPhones.get(typeId);
    Date                          now     = new Date();
    myPhone.setExpressConsentVoice(phone.getExpressConsentVoice());
    myPhone.setLastExpressConsentVoiceAgent(phone.getLastExpressConsentVoiceAgent());
    myPhone.setLastExpressConsentVoiceUpdateDate(now);
    this.temporaryPhones.put(typeId, myPhone);

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updatePhoneExpressConsentVoice.
   *
   * @param   phone  FuturePermanentCustomerContactPhone
   *
   * @return  boolean
   */
  public boolean updatePhoneExpressConsentVoice(FuturePermanentCustomerContactPhone phone) {
    // nothing to update or Delete the Phone
    if ((phone == null) || (phone.getPhoneType() == null)
          || (phone.getPhoneType().getTypeId() == null)) {
      return false;
    }

    String                              typeId  = phone.getPhoneType().getTypeId().toString();
    FuturePermanentCustomerContactPhone myPhone = this.futurePermanentPhones.get(typeId);
    Date                                now     = new Date();
    myPhone.setExpressConsentVoice(phone.getExpressConsentVoice());
    myPhone.setLastExpressConsentVoiceAgent(phone.getLastExpressConsentVoiceAgent());
    myPhone.setLastExpressConsentVoiceUpdateDate(now);
    this.futurePermanentPhones.put(typeId, myPhone);

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // Added by Etisbew on 10/20/2009 for USB Phone Validation(USB-124)-End
  /**
   * Update preferHomeAddress.
   *
   * @param   preferHomeAddress  the preferHomeAddress to set
   *
   * @return  update preferHomeAddress
   */
  public boolean updatePreferHomeAddress(Integer preferHomeAddress) {
    if (isDifferent(preferHomeAddress, this.preferHomeAddress)) {
      this.preferHomeAddress = preferHomeAddress;

      return true;
    }

    return false;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Update preferHomeEmail.
   *
   * @param   preferHomeEmail  the preferHomeEmail to set
   *
   * @return  update preferHomeEmail
   */
  public boolean updatePreferHomeEmail(Integer preferHomeEmail) {
    if (isDifferent(preferHomeEmail, this.preferHomeEmail)) {
      this.preferHomeEmail = preferHomeEmail;

      return true;
    }

    return false;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Update preferHomePhone.
   *
   * @param   preferHomePhone  the preferHomePhone to set
   *
   * @return  update preferHomePhone
   */
  public boolean updatePreferHomePhone(Integer preferHomePhone) {
    if (isDifferent(preferHomePhone, this.preferHomePhone)) {
      this.preferHomePhone = preferHomePhone;

      return true;
    }

    return false;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Update preferMobilePhone.
   *
   * @param   preferMobilePhone  the preferMobilePhone to set
   *
   * @return  update preferMobilePhone
   */
  public boolean updatePreferMobilePhone(Integer preferMobilePhone) {
    if (isDifferent(preferMobilePhone, this.preferMobilePhone)) {
      this.preferMobilePhone = preferMobilePhone;

      return true;
    }

    return false;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Update preferTextMessage.
   *
   * @param   preferTextMessage  the preferTextMessage to set
   *
   * @return  update preferTextMessage
   */
  public boolean updatePreferTextMessage(Integer preferTextMessage) {
    if (isDifferent(preferTextMessage, this.preferTextMessage)) {
      this.preferTextMessage = preferTextMessage;

      return true;
    }

    return false;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Update preferWorkPhone.
   *
   * @param   preferWorkPhone  the preferWorkPhone to set
   *
   * @return  update preferWorkPhone
   */
  public boolean updatePreferWorkPhone(Integer preferWorkPhone) {
    if (isDifferent(preferWorkPhone, this.preferWorkPhone)) {
      this.preferWorkPhone = preferWorkPhone;

      return true;
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updateTemporaryAddress.
   *
   * @param   address  TemporaryCustomerContactAddress
   *
   * @return  boolean
   */
  public boolean updateTemporaryAddress(TemporaryCustomerContactAddress address) {
    // address and address type are needed
    if ((address == null) || (address.getAddressType() == null)
          || (address.getAddressType().getTypeId() == null)) {
      return false;
    }

    String                          typeId    = address.getAddressType().getTypeId().toString();
    TemporaryCustomerContactAddress myAddress = this.temporaryAddresses.get(typeId);
    Date                            now       = new Date();

    // The address must have at least address1 or address 2 or city or
    // province.
    // requires email address, otherwise refuse to update
    if (!address.hasAddressInfo()) {
      if ((myAddress == null) || (myAddress.getAddressType() == null)
            || (myAddress.getAddressType().getTypeId() == null)
            || (!myAddress.hasAddressInfo())) {
        return false;
      } else {
        // remove current address since it was cleared
        myAddress = this.temporaryAddresses.remove(typeId);
        myAddress.setHistorical(Boolean.TRUE);
        myAddress.setExitDate(now);
        myAddress.setLastUpdateDate(now);
        temporaryHistoricalAddresses.add(myAddress);

        return true;
      }
    }

    if (address.equals(myAddress)) {
      // the new address is the same,no need update
      return false;
    } else {
      if (myAddress == null) {
        // New address for this type - first look it up and see if the
        // passed in
        // address is already in historicalAddresses
        myAddress = lookupTemporaryHistoricalAddress(address);

        if (myAddress == null) {
          myAddress = new TemporaryCustomerContactAddress();
          myAddress.setHistorical(Boolean.FALSE);
          myAddress.setCustomer(this);
          myAddress.setEntryDate(now);
          myAddress.deepCopy(address);
        } else {
          this.temporaryHistoricalAddresses.remove(myAddress);
          myAddress.setExitDate(null);
          myAddress.setHistorical(Boolean.FALSE);
          myAddress.setLastUpdateDate(now);
          myAddress.setSource(address.getSource());
        }

        this.temporaryAddresses.put(typeId, myAddress);
      } else {
        // Already has an address for this type, and it is different -
        // move the
        // old address to historical address
        // NOTE: We are sure there is no address in historicalAddress
        // that
        // equals this address.

        myAddress = this.temporaryAddresses.remove(typeId);
        myAddress.setHistorical(Boolean.TRUE);
        myAddress.setExitDate(now);
        myAddress.setLastUpdateDate(now);
        temporaryHistoricalAddresses.add(myAddress);

        TemporaryCustomerContactAddress newAddress = lookupTemporaryHistoricalAddress(address);

        if (newAddress == null) {
          newAddress = new TemporaryCustomerContactAddress();
          newAddress.setHistorical(Boolean.FALSE);
          newAddress.setCustomer(this);
          newAddress.setEntryDate(now);
          newAddress.deepCopy(address);
        } else {
          temporaryHistoricalAddresses.remove(newAddress);
          newAddress.setExitDate(null);
          newAddress.setHistorical(Boolean.FALSE);
          newAddress.setLastUpdateDate(now);
          newAddress.setSource(address.getSource());
        }

        this.temporaryAddresses.put(typeId, newAddress);
      } // end if-else

      if (typeId.equals(
              ContactChannel.HOMEADDRESS.getTypeId().toString())
            && !isZipRequiredFull) {
        updateZipCode(address.address.getPostalCode());
      } else if (typeId.equals(
              ContactChannel.HOMEADDRESS.getTypeId().toString())
            && isZipRequiredFull) {
        updateFullZipCode(address.address.getPostalCode());
      }

      return true;
    } // end if-else
  }   // end method updateTemporaryAddress

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  phoneNum  DOCUMENT ME!
   * @param  status    DOCUMENT ME!
   */
  protected void markPhoneNum(String phoneNum, ContactStatus status) {
    Set<CustomerContactPhone> ps = getContactPhonesbyPhoneNum(phoneNum);

    if ((ps != null) && (ps.size() > 0)) {
      for (CustomerContactPhone p : ps) {
        p.setStatus(status);
      }
    }
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Check whether two Integers are different. nulls are considered the same.
   *
   * @param   i1  DOCUMENT ME!
   * @param   i2  DOCUMENT ME!
   *
   * @return  check whether two Integers are different.
   */
  private boolean isDifferent(Integer i1, Integer i2) {
    if (((i1 == null) && (i2 != null)) || ((i1 != null) && (i2 == null))) {
      return true;
    }

    if ((i1 == null) && (i2 == null)) {
      return false;
    }

    return i1.intValue() != i2.intValue();
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Check whether two string are equal, empty and null string consider equal.
   *
   * @param   str1  DOCUMENT ME!
   * @param   str2  DOCUMENT ME!
   *
   * @return  check whether two string are equal, empty and null string consider equal
   */
  private boolean isEqualString(String str1, String str2) {
    if ((str1 == null) || str1.equals("")) {
      // currently is empty
      if ((str2 == null) || str2.equals("")) {
        // consider same
        return true;
      }
    } else {
      // there is a value in the preference
      if (str1.equals(str2)) {
        // is same
        return true;
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private boolean updateFullZipCode(String zipCode) {
    // DB supports ten char zipCode , check if zipCode exceeds ten chars .
    String zip = StringUtils.hasText(zipCode) ? ((zipCode.length() > 10) ? zipCode.substring(0, 10) : zipCode) : "";

    if (isEqualString(this.zipCode, zip)) {
      return false;
    } else {
      this.zipCode        = zip;
      this.zipCodeChanged = true;

      return true;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private boolean updateZipCode(String zipCode) {
    String zip = ((zipCode == null) || (zipCode.length() <= 5)) ? zipCode : zipCode.substring(0, 5);

    if (isEqualString(this.zipCode, zip)) {
      return false;
    } else {
      if (StringUtils.hasText(zipCode)) {
        this.zipCode        = zipCode;
        this.zipCodeChanged = true;

        return true;
      }

      return false;
    }
  }


} // end class Customer
