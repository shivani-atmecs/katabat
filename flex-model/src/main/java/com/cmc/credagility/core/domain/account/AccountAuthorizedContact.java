package com.cmc.credagility.core.domain.account;

import java.io.Serializable;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Where;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.util.StringUtils;

import com.cmc.credagility.core.domain.address.Address;
import com.cmc.credagility.core.domain.address.AddressType;
import com.cmc.credagility.core.domain.address.Timezone;
import com.cmc.credagility.core.domain.authorizedcontact.AuthorizedContactAddress;
import com.cmc.credagility.core.domain.authorizedcontact.AuthorizedContactEmail;
import com.cmc.credagility.core.domain.authorizedcontact.AuthorizedContactPhone;
import com.cmc.credagility.core.domain.channel.EmailType;
import com.cmc.credagility.core.domain.contact.ContactableBaseObject;
import com.cmc.credagility.core.domain.contact.PhoneType;
import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.cmc.credagility.core.domain.portfolio.PortfolioCallChannelPrerequisite;
import com.cmc.credagility.core.domain.portfolio.PortfolioJurisdictionCallTime;
import com.cmc.credagility.core.domain.type.ContactChannel;
import com.cmc.credagility.core.domain.type.ContactChannelType;
import com.cmc.credagility.core.domain.type.ContactSource;
import com.cmc.credagility.core.domain.type.ContactStatus;
import com.cmc.credagility.core.domain.type.DoNotContactReason;
import com.cmc.credagility.core.domain.util.DateUtil;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo</a>
 * @version  10/19/2014 00:08
 */
@Entity
@Table(
  indexes = {
    @Index(
      name = "doNotCallIndex",
      columnList = "doNotCall"
    ),
    @Index(
      name = "lastNameIndex",
      columnList = "lastName"
    ),
    @Index(
      name = "noCallablePhoneIndex",
      columnList = "noCallablePhone"
    ),
    @Index(
      name = "earliestEligibleCallDateIndex",
      columnList = "earliestEligibleCallDate"
    ),
    @Index(
      name = "endCallTimeIndex",
      columnList = "endCallTime"
    ),
    @Index(
      name = "startCallTimeIndex",
      columnList = "startCallTime"
    ),
    @Index(
      name = "callTimeCrossDayIndex",
      columnList = "callTimeCrossDay"
    )
  }
)
public class AccountAuthorizedContact extends ContactableBaseObject implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  protected static final transient Logger log              = LoggerFactory.getLogger(AccountAuthorizedContact.class);
  private static final long               serialVersionUID = 651057468727236477L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @JoinColumn(
    name      = "accountNum",
    updatable = false
  )
  @ManyToOne(cascade = CascadeType.ALL)
  private Account account;

  @Column(
    name     = "accountAuthorizedId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long accountAuthorizedId;

  @Column(
    name             = "activeStatus",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean activeStatus = true;

  @MapKeyColumn(name = "typeId")
  @OneToMany(
    cascade  = CascadeType.ALL,
    fetch    = FetchType.LAZY,
    mappedBy = "accountAuthorizedContact"
  )
  @Where(clause = "historical is null or historical='N'")
  private Map<String, AuthorizedContactAddress> addresses = new HashMap<String, AuthorizedContactAddress>();

  @JoinColumn(
    name       = "appliedEndCallTimeZoneId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private Timezone appliedEndCallTimeZone;

  @JoinColumn(
    name       = "appliedStartCallTimeZoneId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private Timezone appliedStartCallTimeZone;

  @JoinColumn(
    name       = "endCallTimeId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private PortfolioJurisdictionCallTime applyEndCallTime;

  @JoinColumn(
    name       = "startCallTimeId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private PortfolioJurisdictionCallTime applyStartCallTime;

  @Column(
    name             = "callTimeCrossDay",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean callTimeCrossDay;

  @Column(
    name             = "doNotCall",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean doNotCall = Boolean.FALSE;

  @Column(name = "earliestEligibleCallDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date earliestEligibleCallDate;

  @MapKeyColumn(name = "typeId")
  @OneToMany(
    cascade  = CascadeType.ALL,
    fetch    = FetchType.LAZY,
    mappedBy = "accountAuthorizedContact"
  )
  @Where(clause = "historical is null or historical='N'")
  private Map<String, AuthorizedContactEmail> emails = new HashMap<String, AuthorizedContactEmail>();

  @Column(name = "endCallTime")
  @Temporal(TemporalType.TIME)
  private Date endCallTime;

  /** first name. */
  @Column(
    name   = "firstName",
    length = 45
  )
  private String firstName;

  @OneToMany(
    cascade  = CascadeType.ALL,
    fetch    = FetchType.LAZY,
    mappedBy = "accountAuthorizedContact"
  )
  @Where(clause = "historical='Y'")
  private Set<AuthorizedContactAddress> historicalAddresses = new LinkedHashSet<AuthorizedContactAddress>();

  @OneToMany(
    cascade  = CascadeType.ALL,
    fetch    = FetchType.LAZY,
    mappedBy = "accountAuthorizedContact"
  )
  @Where(clause = "historical='Y'")
  private Set<AuthorizedContactEmail> historicalEmails = new LinkedHashSet<AuthorizedContactEmail>();

  @OneToMany(
    cascade  = CascadeType.ALL,
    fetch    = FetchType.LAZY,
    mappedBy = "accountAuthorizedContact"
  )
  @Where(clause = "historical='Y'")
  private Set<AuthorizedContactPhone> historicalPhones = new LinkedHashSet<AuthorizedContactPhone>();

  @Transient private boolean isZipRequiredFull = false;

  /** last name. */
  @Column(
    name   = "lastName",
    length = 55
  )
  private String lastName;


  @Column(
    name   = "localeString",
    length = 12
  )
  private String localeString;

  /** middle name. */
  @Column(
    name   = "middleName",
    length = 45
  )
  private String middleName;


  @Column(
    name             = "noCallablePhone",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean noCallablePhone = Boolean.FALSE;

  @MapKeyColumn(name = "typeId")
  @OneToMany(
    cascade  = CascadeType.ALL,
    fetch    = FetchType.LAZY,
    mappedBy = "accountAuthorizedContact"
  )
  @Where(clause = "historical is null or historical='N'")
  private Map<String, AuthorizedContactPhone> phones = new HashMap<String, AuthorizedContactPhone>();

  /** communication preference: Home Address */
  @Column(name = "preferHomeAddress")
  private Integer preferHomeAddress;

  /** communication preference: Home Email. Integer means the order of communication - not used for now */
  @Column(name = "preferHomeEmail")
  private Integer preferHomeEmail;

  /** communication preference: Home Phone */
  @Column(name = "preferHomePhone")
  private Integer preferHomePhone;

  /** communication preference: Mobile Phone */
  @Column(name = "preferMobilePhone")
  private Integer preferMobilePhone;

  /** communication preference: Text Message */
  @Column(name = "preferTextMessage")
  private Integer preferTextMessage;

  /** communication preference: Work Phone */
  @Column(name = "preferWorkPhone")
  private Integer preferWorkPhone;

  @JoinColumn(
    name       = "prerequisiteId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private PortfolioCallChannelPrerequisite prerequisite;

  @Column(name = "startCallTime")
  @Temporal(TemporalType.TIME)
  private Date startCallTime;

  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "accountAuthorizedContact"
  )
  @OrderBy("lastUpdateDate desc")
  @Where(clause = "source='AGENT' or source='DEBTOR'")
  private Set<AuthorizedContactAddress> webUpdateAddress = new LinkedHashSet<AuthorizedContactAddress>();

  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "accountAuthorizedContact"
  )
  @OrderBy("lastUpdateDate desc")
  @Where(clause = "source='AGENT' or source='DEBTOR'")
  private Set<AuthorizedContactEmail> webUpdateEmails = new LinkedHashSet<AuthorizedContactEmail>();

  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "accountAuthorizedContact"
  )
  @OrderBy("lastUpdateDate desc")
  @Where(clause = "source='AGENT' or source='DEBTOR'")
  private Set<AuthorizedContactPhone> webUpdatePhones = new LinkedHashSet<AuthorizedContactPhone>();

  /** zip code, for user login. */
  @Column(
    name   = "zipCode",
    length = 10
  )
  private String zipCode;


  /** zip code changed, user need to use the new zip code to login. */
  @Transient private boolean zipCodeChanged = false;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  address  DOCUMENT ME!
   */
  public void addAddress(AuthorizedContactAddress address) {
    getAddresses().put(address.getAddressType().getTypeId().toString(),
      address);
    address.setAccountAuthorizedContact(this);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  email  DOCUMENT ME!
   */
  public void addEmail(AuthorizedContactEmail email) {
    getEmails().put(email.getEmailType().getTypeId().toString(), email);
    email.setAccountAuthorizedContact(this);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  historicalAddress  DOCUMENT ME!
   */
  public void addHistoricalAddress(AuthorizedContactAddress historicalAddress) {
    historicalAddress.setAccountAuthorizedContact(this);
    historicalAddress.setHistorical(Boolean.TRUE);
    this.historicalAddresses.add(historicalAddress);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  phone  DOCUMENT ME!
   */
  public void addPhone(AuthorizedContactPhone phone) {
    getPhones().put(phone.getPhoneType().getTypeId().toString(), phone);
    phone.setAccountAuthorizedContact(this);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   phoneNum       DOCUMENT ME!
   * @param   channel        DOCUMENT ME!
   * @param   contactSource  DOCUMENT ME!
   * @param   contactStatus  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public AuthorizedContactPhone convertToContactPhone(String phoneNum, ContactChannel channel,
    ContactSource contactSource,
    ContactStatus contactStatus) {
    phoneNum = phoneNum.replaceAll("[^0-9]", "");

    if (StringUtils.hasText(phoneNum)) {
      AuthorizedContactPhone phone = new AuthorizedContactPhone();
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
   * Get the account relate to this card holder.
   *
   * @return  the account
   *
   *          <p>column = "accountNum"</p>
   */
  public Account getAccount() {
    return account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getAccountAuthorizedId() {
    return accountAuthorizedId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getActiveStatus() {
    return activeStatus;
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
  public AuthorizedContactAddress getAddress(String type) {
    return addresses.get(type);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   channel  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public AuthorizedContactAddress getAddress(ContactChannel channel) {
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
   * DOCUMENT ME!
   *
   * @param   addressType  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public AuthorizedContactAddress getAddressByType(AddressType addressType) {
    return getAddresses().get(addressType.getTypeId().toString());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Map<String, AuthorizedContactAddress> getAddresses() {
    return addresses;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<String> getAllPhoneNum() {
    Set<String> allPhoneNums = new LinkedHashSet<String>();

    for (AuthorizedContactPhone p : phones.values()) {
      if (StringUtils.hasText(p.getPhoneNum())) {
        allPhoneNums.add(p.getPhoneNum());
      }
    }

    return allPhoneNums;

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   typeId  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<String> getAllPhoneNum(String typeId) {
    Set<String> allPhoneNums = new LinkedHashSet<String>();

    if (getPhoneNum(typeId) != null) {
      allPhoneNums.add(getPhoneNum(typeId));
    }

    return allPhoneNums;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getAllPhoneNumbers() {
    String phoneString = "";

    // get all zip codes and kill the duplications
    Set<String> phoneNumbers = new LinkedHashSet<String>();

    for (AuthorizedContactPhone phone : phones.values()) {
      phoneNumbers.add(phone.getPhoneNum());
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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<String> getAllProvince() {
    Set<String> provinces = new LinkedHashSet<String>();
    provinces.addAll(getProvince());

    return provinces;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getAllZipCodes() {
    String zipString = "";

    // get all zip codes and kill the duplications
    Set<String> zips = new LinkedHashSet<String>();

    for (AuthorizedContactAddress address : addresses.values()) {
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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Timezone getAppliedEndCallTimeZone() {
    return appliedEndCallTimeZone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Timezone getAppliedStartCallTimeZone() {
    return appliedStartCallTimeZone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PortfolioJurisdictionCallTime getApplyEndCallTime() {
    return applyEndCallTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PortfolioJurisdictionCallTime getApplyStartCallTime() {
    return applyStartCallTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public AuthorizedContactPhone getAppointmentPhone() {
    return getPhone(ContactChannel.APPOINTMENTPHONE.getStringTypeId());
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for call time cross day.
   *
   * @return  Boolean
   */
  public Boolean getCallTimeCrossDay() {
    return callTimeCrossDay;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get contactable home phone number, return empty string if there is no such number or the phone is not contactable.
   *
   * @return  get contactable home phone number, return empty string if there is no such number or the phone is not
   *          contactable
   */
  public String getContactableHomePhoneStr() {
    if (Boolean.TRUE.equals(account.getDoNotContact())
          || Boolean.TRUE.equals(this.getDoNotContact())) {
      return "";
    }

    AuthorizedContactPhone contactPhone = getHomePhone();

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
  public AuthorizedContactPhone getContactableMobilePhone() {
    if (Boolean.TRUE.equals(account.getDoNotContact())
          || Boolean.TRUE.equals(this.getDoNotContact())) {
      return null;
    }

    AuthorizedContactPhone contactPhone = getMobilePhone();

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
    if (Boolean.TRUE.equals(account.getDoNotContact())
          || Boolean.TRUE.equals(this.getDoNotContact())) {
      return "";
    }

    AuthorizedContactPhone contactPhone = getMobilePhone();

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
    if (Boolean.TRUE.equals(account.getDoNotContact())
          || Boolean.TRUE.equals(this.getDoNotContact())) {
      return "";
    }

    AuthorizedContactPhone contactPhone = getOtherPhone();

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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public AuthorizedContactPhone getContactableReminderPhone() {
    if (Boolean.TRUE.equals(account.getDoNotContact())
          || Boolean.TRUE.equals(this.getDoNotContact())) {
      return null;
    }

    AuthorizedContactPhone contactPhone = getReminderPhone();

    if ((contactPhone == null) || (!contactPhone.isValidNumber())
          || Boolean.TRUE.equals(contactPhone.getDoNotContact())
          || Boolean.TRUE.equals(contactPhone.getWrongInfo())) {
      return null;
    }

    return contactPhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getContactableReminderPhoneStr() {
    if (Boolean.TRUE.equals(account.getDoNotContact())
          || Boolean.TRUE.equals(this.getDoNotContact())) {
      return "";
    }

    AuthorizedContactPhone contactPhone = getReminderPhone();

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
  public AuthorizedContactPhone getContactableSmsPhone() {
    if (Boolean.TRUE.equals(account.getDoNotContact())
          || Boolean.TRUE.equals(this.getDoNotContact())) {
      return null;
    }

    AuthorizedContactPhone contactPhone = getSMSPhone();

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
    if (Boolean.TRUE.equals(account.getDoNotContact())
          || Boolean.TRUE.equals(this.getDoNotContact())) {
      return "";
    }

    AuthorizedContactPhone contactPhone = getSMSPhone();

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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public AuthorizedContactPhone getContactableTextPhone() {
    if (Boolean.TRUE.equals(account.getDoNotContact())
          || Boolean.TRUE.equals(this.getDoNotContact())) {
      return null;
    }

    AuthorizedContactPhone contactPhone = getSMSPhone();

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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getContactableTextPhoneStr() {
    if (Boolean.TRUE.equals(account.getDoNotContact())
          || Boolean.TRUE.equals(this.getDoNotContact())) {
      return "";
    }

    AuthorizedContactPhone contactPhone = getSMSPhone();

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
    if (Boolean.TRUE.equals(account.getDoNotContact())
          || Boolean.TRUE.equals(this.getDoNotContact())) {
      return "";
    }

    AuthorizedContactPhone contactPhone = getWorkPhone();

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
  public Set<AuthorizedContactPhone> getContactPhonesbyPhoneNum(String phoneNum) {
    if (!StringUtils.hasText(phoneNum)) {
      return null;
    }

    Set<AuthorizedContactPhone> ps = new LinkedHashSet<AuthorizedContactPhone>();

    for (int i = 0; i < ContactChannel.PHONE_CHANNELS.length; i++) {
      AuthorizedContactPhone phone = getPhone(ContactChannel.PHONE_CHANNELS[i]);

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
  public AuthorizedContactAddress getDefaultAddress() {
    AuthorizedContactAddress contactAddress = getHomeAddress();

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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDefaultAddressAddress1() {
    AuthorizedContactAddress contactAddress = getDefaultAddress();

    if (contactAddress != null) {
      return contactAddress.getAddress().getAddress1();
    }

    return null;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDefaultAddressAddress2() {
    AuthorizedContactAddress contactAddress = getDefaultAddress();

    if (contactAddress != null) {
      return contactAddress.getAddress().getAddress2();
    }

    return null;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDefaultAddressCity() {
    AuthorizedContactAddress contactAddress = getDefaultAddress();

    if (contactAddress != null) {
      return contactAddress.getAddress().getCity();
    }

    return null;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDefaultAddressCountry() {
    AuthorizedContactAddress contactAddress = getDefaultAddress();

    if (contactAddress != null) {
      return contactAddress.getAddress().getCountry();
    }

    return null;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDefaultAddressPostalCode() {
    AuthorizedContactAddress contactAddress = getDefaultAddress();

    if (contactAddress != null) {
      return contactAddress.getAddress().getPostalCode();
    }

    return null;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDefaultAddressProvince() {
    AuthorizedContactAddress contactAddress = getDefaultAddress();

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
  public AuthorizedContactAddress getDefaultContactableAddress() {
    if (Boolean.TRUE.equals(account.getDoNotContact())
          || Boolean.TRUE.equals(this.getDoNotContact())) {
      return null;
    }

    AuthorizedContactAddress contactAddress = getHomeAddress();

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

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDefaultContactableAddressAddress1() {
    AuthorizedContactAddress contactAddress = getDefaultContactableAddress();

    if (contactAddress != null) {
      return contactAddress.getAddress().getAddress1();
    }

    return null;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDefaultContactableAddressAddress2() {
    AuthorizedContactAddress contactAddress = getDefaultContactableAddress();

    if (contactAddress != null) {
      return contactAddress.getAddress().getAddress2();
    }

    return null;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDefaultContactableAddressCity() {
    AuthorizedContactAddress contactAddress = getDefaultContactableAddress();

    if (contactAddress != null) {
      return contactAddress.getAddress().getCity();
    }

    return null;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDefaultContactableAddressCountry() {
    AuthorizedContactAddress contactAddress = getDefaultContactableAddress();

    if (contactAddress != null) {
      return contactAddress.getAddress().getCountry();
    }

    return null;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDefaultContactableAddressPostalCode() {
    AuthorizedContactAddress contactAddress = getDefaultContactableAddress();

    if (contactAddress != null) {
      return contactAddress.getAddress().getPostalCode();
    }

    return null;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDefaultContactableAddressProvince() {
    AuthorizedContactAddress contactAddress = getDefaultContactableAddress();

    if (contactAddress != null) {
      return contactAddress.getAddress().getProvince();
    }

    return null;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public AuthorizedContactEmail getDefaultContactableEmail() {
    if (Boolean.TRUE.equals(account.getDoNotContact())
          || Boolean.TRUE.equals(this.getDoNotContact())) {
      return null;
    }

    AuthorizedContactEmail contactEmail = getHomeEmail();

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

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDefaultContactableEmailStr() {
    AuthorizedContactEmail contactEmail = getDefaultContactableEmail();

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
  public AuthorizedContactPhone getDefaultContactablePhone() {
    if (Boolean.TRUE.equals(account.getDoNotContact())
          || Boolean.TRUE.equals(this.getDoNotContact())) {
      return null;
    }

    AuthorizedContactPhone contactPhone = getHomePhone();

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
  public AuthorizedContactEmail getDefaultEmail() {
    AuthorizedContactEmail contactEmail = getHomeEmail();

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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDefaultEmailStr() {
    AuthorizedContactEmail contactEmail = getDefaultEmail();

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
  public AuthorizedContactPhone getDefaultPhone() {
    AuthorizedContactPhone contactPhone = getHomePhone();

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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getDoNotCall() {
    if (doNotCall == null) {
      return Boolean.FALSE;
    }

    return doNotCall;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getEarliestEligibleCallDate() {
    return earliestEligibleCallDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get emailAddress by type.
   *
   * @param   type  DOCUMENT ME!
   *
   * @return  get emailAddress by type
   */
  public AuthorizedContactEmail getEmail(String type) {
    return emails.get(type);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   channel  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public AuthorizedContactEmail getEmail(ContactChannel channel) {
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
   * DOCUMENT ME!
   *
   * @param   type  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public AuthorizedContactEmail getEmailByType(EmailType type) {
    return getEmails().get(type.getTypeId().toString());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Map<String, AuthorizedContactEmail> getEmails() {
    return emails;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getEndCallTime() {
    return endCallTime;
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
  public AuthorizedContactPhone getFirstContactPhoneByPhoneNum(String phoneNum) {
    if (!StringUtils.hasText(phoneNum)) {
      return null;
    }

    AuthorizedContactPhone phone = null;

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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getFirstName() {
    return firstName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get full name, first name + middle name + last name.
   *
   * @return  get full name, first name + middle name + last name
   */
  public String getFullName() {
    String fullName = "";

    if ((null != firstName) && !"".equals(firstName)
          && (null != lastName) && !"".equals(lastName)) {
      if ((null != middleName) && !"".equals(middleName)) {
        fullName = firstName + " " + middleName + " " + lastName;
      } else {
        fullName = firstName + " " + lastName;
      }
    }

    return fullName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean getHasCurrentPhone() {
    for (AuthorizedContactPhone contactPhone : getPhones().values()) {
      if ((contactPhone != null)
            && (!Boolean.TRUE.equals(contactPhone.getHistorical()))) {
        if (log.isDebugEnabled()) {
          log.debug("Found a current phone number for contact phone id: " + contactPhone.getPhoneId()
            + " accountAuthorizedContact: "
            + this.getAccountAuthorizedId());
        }

        return true;
      }
    }

    if (log.isDebugEnabled()) {
      log.debug("No current phone number(s) for accountAuthorizedContact: " + this.getAccountAuthorizedId());
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean getHasEmail() {
    return (this.emails.size() > 0);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<AuthorizedContactAddress> getHistoricalAddresses() {
    return historicalAddresses;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<AuthorizedContactEmail> getHistoricalEmails() {
    return historicalEmails;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<AuthorizedContactPhone> getHistoricalPhones() {
    return historicalPhones;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Convenient method.
   *
   * @return  HomeAddress
   */
  public AuthorizedContactAddress getHomeAddress() {
    return getAddress(ContactChannel.HOMEADDRESS.getStringTypeId());
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getHomeAddress1() {
    AuthorizedContactAddress a = getHomeAddress();

    if ((a != null) && (a.getAddress() != null)) {
      return a.getAddress().getAddress1();
    }

    return null;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getHomeAddress2() {
    AuthorizedContactAddress a = getHomeAddress();

    if ((a != null) && (a.getAddress() != null)) {
      return a.getAddress().getAddress2();
    }

    return null;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getHomeAddress3() {
    AuthorizedContactAddress a = getHomeAddress();

    if ((a != null) && (a.getAddress() != null)) {
      return a.getAddress().getAddress3();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getHomeCity() {
    AuthorizedContactAddress contactAddress = getHomeAddress();

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
  public AuthorizedContactEmail getHomeEmail() {
    return getEmail(ContactChannel.HOMEEMAIL.getStringTypeId());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get home email string, return empty string if there is no such email.
   *
   * @return  get home email string, return empty string if there is no such email
   */
  public String getHomeEmailStr() {
    AuthorizedContactEmail contactEmail = getHomeEmail();

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
  public AuthorizedContactPhone getHomePhone() {
    return getPhone(ContactChannel.HOMEPHONE.getStringTypeId());
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get home phone number string, return empty string if there is no such number.
   *
   * @return  get home phone number string, return empty string if there is no such number
   */
  public String getHomePhoneStr() {
    AuthorizedContactPhone contactPhone = getHomePhone();

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
    AuthorizedContactAddress contactAddress = getHomeAddress();

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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getHomeZipCode() {
    AuthorizedContactAddress a = getHomeAddress();

    if ((a != null) && (a.getAddress() != null)) {
      return a.getAddress().getPostalCode();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean getIsContactable() {
    return (getIsContactableByAddress() || getIsContactableByEmail()
        || getIsContactableByPhone());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean getIsContactableByAddress() {
    if (Boolean.TRUE.equals(account.getDoNotContact())
          || Boolean.TRUE.equals(this.getDoNotContact())) {
      return false;
    }

    for (AuthorizedContactAddress contactAddress : getAddresses().values()) {
      if ((contactAddress != null) && contactAddress.isValidAddress()
            && (!Boolean.TRUE.equals(contactAddress.getDoNotContact()))) {
        return true;
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean getIsContactableByEmail() {
    if (Boolean.TRUE.equals(account.getDoNotContact())
          || Boolean.TRUE.equals(this.getDoNotContact())) {
      return false;
    }

    for (AuthorizedContactEmail contactEmail : getEmails().values()) {
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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean getIsContactableByMobilePhone() {
    return (getContactableMobilePhone() != null);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean getIsContactableByPhone() {
    if (Boolean.TRUE.equals(account.getDoNotContact())
          || Boolean.TRUE.equals(this.getDoNotContact())) {
      return false;
    }

    for (AuthorizedContactPhone contactPhone : getPhones().values()) {
      if ((contactPhone != null)
            && (contactPhone.isValidNumber()
              && (!Boolean.TRUE.equals(
                  contactPhone.getDoNotContact())))) {
        if (log.isDebugEnabled()) {
          log.debug("Found a valid phone number for contact phone id: " + contactPhone.getPhoneId()
            + " accountAuthorizedContact: "
            + this.getAccountAuthorizedId());
        }

        return true;
      }
    }

    if (log.isDebugEnabled()) {
      log.debug("No valid phone number for accountAuthorizedContact: " + this.getAccountAuthorizedId());
    }

    return false;
  } // end method getIsContactableByPhone

  //~ ------------------------------------------------------------------------------------------------------------------

  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean getIsContactableBySmsPhone() {
    return (getContactableSmsPhone() != null);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean getIsContactableByTextPhone() {
    return (getContactableTextPhone() != null);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean getIsNotContactable() {
    return !getIsContactable();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean getIsNotContactableByAddress() {
    return !getIsContactableByAddress();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean getIsNotContactableByEmail() {
    return !getIsContactableByEmail();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean getIsNotContactableByPhone() {
    return !getIsContactableByPhone();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean getIsNotContactableBySmsPhone() {
    return (getContactableSmsPhone() == null);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean getIsNotContactableByTextPhone() {
    return (getContactableTextPhone() == null);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getLastName() {
    return lastName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getLastWebUpdateAddressDate() {
    if ((this.webUpdateAddress != null) && (this.webUpdateAddress.size() > 0)) {
      Iterator<AuthorizedContactAddress> it = webUpdateAddress.iterator();

      return it.next().getLastUpdateDate();
    } else {
      return null;
    }

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getLastWebUpdateEmailDate() {
    if ((this.webUpdateEmails != null) && (this.webUpdateEmails.size() > 0)) {
      Iterator<AuthorizedContactEmail> it = webUpdateEmails.iterator();

      return it.next().getLastUpdateDate();
    } else {
      return null;
    }

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getLastWebUpdatePhoneDate() {
    if ((this.webUpdatePhones != null) && (this.webUpdatePhones.size() > 0)) {
      Iterator<AuthorizedContactPhone> it = webUpdatePhones.iterator();

      return it.next().getLastUpdateDate();
    } else {
      return null;
    }
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getLocaleString() {
    return localeString;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getMiddleName() {
    return middleName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Convenient method.
   *
   * @return  MobilePhone
   */
  public AuthorizedContactPhone getMobilePhone() {
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
    AuthorizedContactPhone contactPhone = getMobilePhone();

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
   * @return  DOCUMENT ME!
   */
  public Boolean getNoCallablePhone() {
    return noCallablePhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Convenient method.
   *
   * @return  OtherAddress
   */
  public AuthorizedContactAddress getOtherAddress() {
    return getAddress(ContactChannel.OTHERADDRESS.getStringTypeId());
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Convenient method.
   *
   * @return  OtherEmail
   */
  public AuthorizedContactEmail getOtherEmail() {
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
    AuthorizedContactEmail contactEmail = getOtherEmail();

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
  public AuthorizedContactPhone getOtherPhone() {
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
    AuthorizedContactPhone contactPhone = getOtherPhone();

    if (contactPhone != null) {
      return contactPhone.getPhoneNum();
    } else {
      return "";
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getOtherZipCode() {
    AuthorizedContactAddress contactAddress = getOtherAddress();

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
   * Get phone by type Id. Type id is the primary key of the PhoneType.
   *
   * @param   typeId  DOCUMENT ME!
   *
   * @return  get phone by type Id.
   */
  public AuthorizedContactPhone getPhone(String typeId) {
    return phones.get(typeId);

  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   channel  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public AuthorizedContactPhone getPhone(ContactChannel channel) {
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
   * DOCUMENT ME!
   *
   * @param   type  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public AuthorizedContactPhone getPhoneByType(PhoneType type) {
    return getPhones().get(type.getTypeId().toString());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   typeId  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPhoneNum(String typeId) {
    AuthorizedContactPhone phone = getPhone(typeId);

    if ((phone != null) && StringUtils.hasText(phone.getPhoneNum())) {
      return phone.getPhoneNum();
    }

    return null;

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Map<String, AuthorizedContactPhone> getPhones() {
    return phones;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPortfolioDescription() {
    return account.getPortfolio().getDescription();
  }

  // ------------------------------------------------------------------------------------------------------------------

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

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PortfolioCallChannelPrerequisite getPrerequisite() {
    return prerequisite;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
   * the following methods added by Yan for SLM return file --- START
   */
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public AuthorizedContactAddress getPreviousHomeAddress() {
    AuthorizedContactAddress previousAddress = null;

    if ((historicalAddresses != null) && (historicalAddresses.size() > 0)) {
      for (AuthorizedContactAddress ca : historicalAddresses) {
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

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPreviousHomeEmailStr() {
    AuthorizedContactEmail previousEmail = null;

    if ((historicalEmails != null) && (historicalEmails.size() > 0)) {
      for (AuthorizedContactEmail ce : historicalEmails) {
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

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPreviousHomePhoneStr() {
    AuthorizedContactPhone previousPhone = null;

    if ((historicalPhones != null) && (historicalPhones.size() > 0)) {
      for (AuthorizedContactPhone ch : historicalPhones) {
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

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPreviousMobilePhoneStr() {
    AuthorizedContactPhone previousPhone = null;

    if ((historicalPhones != null) && (historicalPhones.size() > 0)) {
      for (AuthorizedContactPhone ch : historicalPhones) {
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

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPreviousOtherPhoneStr() {
    AuthorizedContactPhone previousPhone = null;

    if ((historicalPhones != null) && (historicalPhones.size() > 0)) {
      for (AuthorizedContactPhone ch : historicalPhones) {
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

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPreviousSchoolPhoneStr() {
    AuthorizedContactPhone previousPhone = null;

    if ((historicalPhones != null) && (historicalPhones.size() > 0)) {
      for (AuthorizedContactPhone ch : historicalPhones) {
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

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPreviousSmsPhoneStr() {
    AuthorizedContactPhone previousPhone = null;

    if ((historicalPhones != null) && (historicalPhones.size() > 0)) {
      for (AuthorizedContactPhone ch : historicalPhones) {
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

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPreviousWorkPhoneStr() {
    AuthorizedContactPhone previousPhone = null;

    if ((historicalPhones != null) && (historicalPhones.size() > 0)) {
      for (AuthorizedContactPhone ch : historicalPhones) {
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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<String> getProvince() {
    Set<String> provinces = new LinkedHashSet<String>();
    Address     addr      = null;

    for (AuthorizedContactAddress a : addresses.values()) {
      addr = a.getAddress();

      if ((addr != null) && StringUtils.hasText(addr.getProvince())) {
        provinces.add(addr.getProvince());
      }
    }

    return provinces;

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public AuthorizedContactEmail getReminderEmail() {
    return getEmail(ContactChannel.REMINDEREMAIL.getStringTypeId());
  }
  // ~
  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public AuthorizedContactPhone getReminderPhone() {
    return getPhone(ContactChannel.REMINDERPHONE.getStringTypeId());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getReminderPhoneStr() {
    AuthorizedContactPhone contactPhone = getReminderPhone();

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
   * @return  DOCUMENT ME!
   */
  public AuthorizedContactPhone getSchoolPhone() {
    return getPhone(ContactChannel.SCHOOLPHONE.getStringTypeId());
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getSchoolPhoneStr() {
    AuthorizedContactPhone contactPhone = getSchoolPhone();

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
   * @return  SMSPhone
   */
  public AuthorizedContactPhone getSMSPhone() {
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
    AuthorizedContactPhone contactPhone = getSMSPhone();

    if (contactPhone != null) {
      return contactPhone.getPhoneNum();
    } else {
      return "";
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getStartCallTime() {
    return startCallTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<AuthorizedContactAddress> getWebUpdateAddress() {
    return webUpdateAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<AuthorizedContactEmail> getWebUpdateEmails() {
    return webUpdateEmails;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<AuthorizedContactPhone> getWebUpdatePhones() {
    return webUpdatePhones;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Convenient method.
   *
   * @return  WorkAddress
   */
  public AuthorizedContactAddress getWorkAddress() {
    return getAddress(ContactChannel.WORKADDRESS.getStringTypeId());
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Convenient method.
   *
   * @return  WorkEmail
   */
  public AuthorizedContactEmail getWorkEmail() {
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
    AuthorizedContactEmail contactEmail = getWorkEmail();

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
  public AuthorizedContactPhone getWorkPhone() {
    return getPhone(ContactChannel.WORKPHONE.getStringTypeId());
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get work phone number string, return empty string if there is no such number.
   *
   * @return  get work phone number string, return empty string if there is no such number
   */
  public String getWorkPhoneStr() {
    AuthorizedContactPhone contactPhone = getWorkPhone();

    if (contactPhone != null) {
      return contactPhone.getPhoneNum();
    } else {
      return "";
    }
  }

  // ------------------------------------------------------------------------------------------------------------------

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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isZipRequiredFull() {
    return isZipRequiredFull;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   address  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public AuthorizedContactAddress lookupHistoricalAddress(AuthorizedContactAddress address) {
    for (AuthorizedContactAddress a : this.historicalAddresses) {
      if (a.equals(address)) {
        return a;
      }
    }

    return null;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   email  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public AuthorizedContactEmail lookupHistoricalEmail(AuthorizedContactEmail email) {
    for (AuthorizedContactEmail a : this.historicalEmails) {
      if (a.equals(email)) {
        return a;
      }
    }

    return null;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   phone  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public AuthorizedContactPhone lookupHistoricalPhone(AuthorizedContactPhone phone) {
    for (AuthorizedContactPhone a : this.historicalPhones) {
      if (a.equals(phone)) {
        return a;
      }
    }

    return null;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   phoneNum           DOCUMENT ME!
   * @param   doNotContactUntil  DOCUMENT ME!
   * @param   reason             DOCUMENT ME!
   * @param   reasonId           DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean markDoNotContactPhoneNum(String phoneNum, Date doNotContactUntil, DoNotContactReason reason,
    String reasonId) {
    if (phoneNum == null) {
      return false;
    }

    for (AuthorizedContactPhone phone : phones.values()) {
      if (phoneNum.equalsIgnoreCase(phone.getPhoneNum())) {
        return Boolean.TRUE.equals(phone.markDoNotContact(
              doNotContactUntil, reason, reasonId));
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  phoneNum  DOCUMENT ME!
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
    Set<AuthorizedContactPhone> ps = getContactPhonesbyPhoneNum(phoneNum);

    if ((ps != null) && (ps.size() > 0)) {
      for (AuthorizedContactPhone p : ps) {
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
  public boolean removeAddress(AuthorizedContactAddress address) {
    if ((address == null) || (address.getAddressType() == null)
          || (address.getAddressType().getTypeId() == null)) {
      return false; // no update happened
    }

    AuthorizedContactAddress curAddress = addresses.remove(address.getAddressType().getTypeId().toString());

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
  public boolean removeEmail(AuthorizedContactEmail email) {
    if ((email == null) || (email.getEmailType() == null)
          || (email.getEmailType().getTypeId() == null)) {
      return false; // no update happened
    }

    AuthorizedContactEmail curEmail = emails.remove(email.getEmailType().getTypeId().toString());

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
   * Remove phone.
   *
   * @param   phone  type
   *
   * @return  remove phone
   */
  public boolean removePhone(AuthorizedContactPhone phone) {
    if ((phone == null) || (phone.getPhoneType() == null)
          || (phone.getPhoneType().getTypeId() == null)) {
      return false; // no update happened
    }

    AuthorizedContactPhone curPhone = phones.remove(phone.getPhoneType().getTypeId().toString());

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
   * Set the account which relate to this card holder.
   *
   * @param  account  the account to set
   */
  public void setAccount(Account account) {
    this.account = account;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  accountAuthorizedId  DOCUMENT ME!
   */
  public void setAccountAuthorizedId(Long accountAuthorizedId) {
    this.accountAuthorizedId = accountAuthorizedId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  activeStatus  DOCUMENT ME!
   */
  public void setActiveStatus(Boolean activeStatus) {
    this.activeStatus = activeStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  addresses  the addresses to set
   */
  public void setAddresses(Map<String, AuthorizedContactAddress> addresses) {
    this.addresses = addresses;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  appliedEndCallTimeZone  DOCUMENT ME!
   */
  public void setAppliedEndCallTimeZone(Timezone appliedEndCallTimeZone) {
    this.appliedEndCallTimeZone = appliedEndCallTimeZone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  appliedStartCallTimeZone  DOCUMENT ME!
   */
  public void setAppliedStartCallTimeZone(Timezone appliedStartCallTimeZone) {
    this.appliedStartCallTimeZone = appliedStartCallTimeZone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  applyEndCallTime  DOCUMENT ME!
   */
  public void setApplyEndCallTime(PortfolioJurisdictionCallTime applyEndCallTime) {
    this.applyEndCallTime = applyEndCallTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  applyStartCallTime  DOCUMENT ME!
   */
  public void setApplyStartCallTime(PortfolioJurisdictionCallTime applyStartCallTime) {
    this.applyStartCallTime = applyStartCallTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for call time cross day.
   *
   * @param  callTimeCrossDay  Boolean
   */
  public void setCallTimeCrossDay(Boolean callTimeCrossDay) {
    this.callTimeCrossDay = callTimeCrossDay;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  doNotCall  DOCUMENT ME!
   */
  public void setDoNotCall(Boolean doNotCall) {
    this.doNotCall = doNotCall;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  earliestEligibleCallDate  DOCUMENT ME!
   */
  public void setEarliestEligibleCallDate(Date earliestEligibleCallDate) {
    this.earliestEligibleCallDate = earliestEligibleCallDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  emails  the emails to set
   */
  public void setEmails(Map<String, AuthorizedContactEmail> emails) {
    this.emails = emails;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  endCallTime  DOCUMENT ME!
   */
  public void setEndCallTime(Date endCallTime) {
    this.endCallTime = endCallTime;
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
   * DOCUMENT ME!
   *
   * @param  historicalAddresses  DOCUMENT ME!
   */
  public void setHistoricalAddresses(Set<AuthorizedContactAddress> historicalAddresses) {
    this.historicalAddresses = historicalAddresses;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  historicalEmails  DOCUMENT ME!
   */
  public void setHistoricalEmails(Set<AuthorizedContactEmail> historicalEmails) {
    this.historicalEmails = historicalEmails;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  historicalPhones  DOCUMENT ME!
   */
  public void setHistoricalPhones(Set<AuthorizedContactPhone> historicalPhones) {
    this.historicalPhones = historicalPhones;
  }

  // ------------------------------------------------------------------------------------------------------------------

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
   * @param  localeString  DOCUMENT ME!
   */
  public void setLocaleString(String localeString) {
    this.localeString = localeString;
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
   * @param  noCallablePhone  DOCUMENT ME!
   */
  public void setNoCallablePhone(Boolean noCallablePhone) {
    this.noCallablePhone = noCallablePhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  phones  the phones to set
   */
  public void setPhones(Map<String, AuthorizedContactPhone> phones) {
    this.phones = phones;
  }

  // ------------------------------------------------------------------------------------------------------------------

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
   * @param  prerequisite  DOCUMENT ME!
   */
  public void setPrerequisite(PortfolioCallChannelPrerequisite prerequisite) {
    this.prerequisite = prerequisite;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  startCallTime  DOCUMENT ME!
   */
  public void setStartCallTime(Date startCallTime) {
    this.startCallTime = startCallTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  webUpdateAddress  DOCUMENT ME!
   */
  public void setWebUpdateAddress(Set<AuthorizedContactAddress> webUpdateAddress) {
    this.webUpdateAddress = webUpdateAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  webUpdateEmails  DOCUMENT ME!
   */
  public void setWebUpdateEmails(Set<AuthorizedContactEmail> webUpdateEmails) {
    this.webUpdateEmails = webUpdateEmails;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  webUpdatePhones  DOCUMENT ME!
   */
  public void setWebUpdatePhones(Set<AuthorizedContactPhone> webUpdatePhones) {
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
  public boolean updateAddress(AuthorizedContactAddress address) {
    // address and address type are needed
    if ((address == null) || (address.getAddressType() == null)
          || (address.getAddressType().getTypeId() == null)) {
      return false;
    }

    String                   typeId    = address.getAddressType().getTypeId().toString();
    AuthorizedContactAddress myAddress = this.addresses.get(typeId);
    Date                     now       = new Date();

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
        historicalAddresses.add(myAddress);

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
        myAddress = lookupHistoricalAddress(address);

        if (myAddress == null) {
          myAddress = new AuthorizedContactAddress();
          myAddress.setHistorical(Boolean.FALSE);
          myAddress.setAccountAuthorizedContact(this);
          myAddress.setEntryDate(now);
          myAddress.deepCopy(address);
        } else {
          this.historicalAddresses.remove(myAddress);
          myAddress.setExitDate(null);
          myAddress.setHistorical(Boolean.FALSE);
          myAddress.setLastUpdateDate(now);
          myAddress.setSource(address.getSource());
        }

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
        historicalAddresses.add(myAddress);

        AuthorizedContactAddress newAddress = lookupHistoricalAddress(address);

        if (newAddress == null) {
          newAddress = new AuthorizedContactAddress();
          newAddress.setHistorical(Boolean.FALSE);
          newAddress.setAccountAuthorizedContact(this);
          newAddress.setEntryDate(now);
          newAddress.deepCopy(address);
        } else {
          historicalAddresses.remove(newAddress);
          newAddress.setExitDate(null);
          newAddress.setHistorical(Boolean.FALSE);
          newAddress.setLastUpdateDate(now);
          newAddress.setSource(address.getSource());
        }

        this.addresses.put(typeId, newAddress);
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
  }   // end method updateAddress

  //~ ------------------------------------------------------------------------------------------------------------------

  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   address  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean updateAddressExpressConsent(AuthorizedContactAddress address) {
    // address and address type are needed
    if ((address == null) || (address.getAddressType() == null)
          || (address.getAddressType().getTypeId() == null)) {
      return false;
    }

    String                   typeId    = address.getAddressType().getTypeId().toString();
    AuthorizedContactAddress myAddress = this.addresses.get(typeId);
    Date                     now       = new Date();
    myAddress.setExpressConsent(address.getExpressConsent());
    myAddress.setLastExpressConsentAgent(address.getLastExpressConsentAgent());
    myAddress.setLastExpressConsentUpdateDate(now);
    this.addresses.put(typeId, myAddress);

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   contactChannel  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean updateCurrentPhoneToHistorical(ContactChannel contactChannel) {
    String                 typeId  = contactChannel.getStringTypeId();
    AuthorizedContactPhone myPhone = phones.get(typeId);
    Date                   now     = new Date();

    if (myPhone == null) {
      return false;
    } else {
      Account   account                     = this.getAccount();
      Portfolio portfolio                   = account.getPortfolio();
      Integer   updateContactNotAllowedDays = portfolio.getUpdateContactNotAllowedDays();
      Date      myPhoneCreateDate           = myPhone.getCreateDate();

      if ((updateContactNotAllowedDays != null)
            && DateUtil.hasDaysEarlierThanNow(myPhoneCreateDate, updateContactNotAllowedDays)) {
        // remove current phone since the number was cleared
        myPhone = this.phones.remove(typeId);
        myPhone.setHistorical(Boolean.TRUE);
        myPhone.setExitDate(now);
        myPhone.setLastUpdateDate(now);
        historicalPhones.add(myPhone);

        return true;
      }

      return false;
    } // end if-else
  }   // end method updateCurrentPhoneToHistorical

  //~ ------------------------------------------------------------------------------------------------------------------

  // ------------------------------------------------------------------------------------------------------------------

  /**
   * Update emailAddress.
   *
   * @param   email  DOCUMENT ME!
   *
   * @return  update emailAddress
   */
  public boolean updateEmail(AuthorizedContactEmail email) {
    // requires email and email type
    if ((email == null) || (email.getEmailType() == null)
          || (email.getEmailType().getTypeId() == null)) {
      return false;
    }

    // requires email address, otherwise refuse to update
    /*
     * if (!StringUtils.hasText(email.getEmailAddress())) return false;
     */

    String                 typeId  = email.getEmailType().getTypeId().toString();
    AuthorizedContactEmail myEmail = this.emails.get(typeId);
    Date                   now     = new Date();

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
        historicalEmails.add(myEmail);

        return true;
      }
    }

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
          myEmail = new AuthorizedContactEmail();
          myEmail.setHistorical(Boolean.FALSE);
          myEmail.setAccountAuthorizedContact(this);
          myEmail.setEntryDate(now);
          myEmail.deepCopy(email);
        } else {
          this.historicalEmails.remove(myEmail);
          myEmail.setExitDate(null);
          myEmail.setHistorical(Boolean.FALSE);
          myEmail.setLastUpdateDate(now);
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

        AuthorizedContactEmail newEmail = lookupHistoricalEmail(email);

        if (newEmail == null) {
          newEmail = new AuthorizedContactEmail();
          newEmail.setHistorical(Boolean.FALSE);
          newEmail.setAccountAuthorizedContact(this);
          newEmail.setEntryDate(now);
          newEmail.deepCopy(email);
        } else {
          historicalEmails.remove(newEmail);
          newEmail.setExitDate(null);
          newEmail.setHistorical(Boolean.FALSE);
          newEmail.setLastUpdateDate(now);
          newEmail.setSource(email.getSource());
        }

        this.emails.put(typeId, newEmail);
      } // end if-else

      return true;
    } // end if-else
  }   // end method updateEmail

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   email  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean updateEmailExpressConsent(AuthorizedContactEmail email) {
    // address and address type are needed
    if ((email == null) || (email.getEmailType() == null)
          || (email.getEmailType().getTypeId() == null)) {
      return false;
    }

    String                 typeId  = email.getEmailType().getTypeId().toString();
    AuthorizedContactEmail myEmail = this.emails.get(typeId);
    Date                   now     = new Date();
    myEmail.setExpressConsent(email.getExpressConsent());
    myEmail.setLastExpressConsentAgent(myEmail.getLastExpressConsentAgent());
    myEmail.setLastExpressConsentUpdateDate(now);
    this.emails.put(typeId, myEmail);

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Adding this for barclays pe account loader file to update the email address as empty.
   *
   * @param   email  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean updateOrRemoveEmail(AuthorizedContactEmail email) {
    // requires email and email type
    if ((email == null) || (email.getEmailType() == null)
          || (email.getEmailType().getTypeId() == null)) {
      return false;
    }

    // requires email address, otherwise refuse to update
    /*
     * if (!StringUtils.hasText(email.getEmailAddress())) return false;
     */

    String                 typeId  = email.getEmailType().getTypeId().toString();
    AuthorizedContactEmail myEmail = this.emails.get(typeId);
    Date                   now     = new Date();

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
          myEmail = new AuthorizedContactEmail();
          myEmail.setHistorical(Boolean.FALSE);
          myEmail.setAccountAuthorizedContact(this);
          myEmail.setEntryDate(now);
          myEmail.deepCopy(email);
        } else {
          this.historicalEmails.remove(myEmail);
          myEmail.setExitDate(null);
          myEmail.setHistorical(Boolean.FALSE);
          myEmail.setLastUpdateDate(now);
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

        AuthorizedContactEmail newEmail = lookupHistoricalEmail(email);

        if (newEmail == null) {
          newEmail = new AuthorizedContactEmail();
          newEmail.setHistorical(Boolean.FALSE);
          newEmail.setAccountAuthorizedContact(this);
          newEmail.setEntryDate(now);
          newEmail.deepCopy(email);
        } else {
          historicalEmails.remove(newEmail);
          newEmail.setExitDate(null);
          newEmail.setHistorical(Boolean.FALSE);
          newEmail.setLastUpdateDate(now);
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

    AuthorizedContactPhone phone = new AuthorizedContactPhone();
    phone.setPhoneType(new PhoneType(contactChannel.getTypeId(),
        contactChannel.toString()));
    phone.setPhoneNum(phoneNum);
    phone.setSource(contactSource);
    phone.setStatus(contactStatus);

    if (phone == null) {
      return false;
    }

    String                 typeId  = phone.getPhoneType().getTypeId().toString();
    AuthorizedContactPhone myPhone = this.phones.get(typeId);
    Date                   now     = new Date();

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
          myPhone = new AuthorizedContactPhone();
          myPhone.setHistorical(Boolean.FALSE);
          myPhone.setAccountAuthorizedContact(this);
          myPhone.setEntryDate(now);
          myPhone.deepCopy(phone);
        } else {
          this.historicalPhones.remove(myPhone);
          myPhone.setExitDate(null);
          myPhone.setHistorical(Boolean.FALSE);
          myPhone.setLastUpdateDate(now);
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

        AuthorizedContactPhone newPhone = lookupHistoricalPhone(phone);

        if (newPhone == null) {
          newPhone = new AuthorizedContactPhone();
          newPhone.setHistorical(Boolean.FALSE);
          newPhone.setAccountAuthorizedContact(this);
          newPhone.setEntryDate(now);
          newPhone.deepCopy(phone);
        } else {
          historicalPhones.remove(newPhone);
          newPhone.setExitDate(null);
          newPhone.setHistorical(Boolean.FALSE);
          newPhone.setLastUpdateDate(now);
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
   * @param   phone  DOCUMENT ME!
   *
   * @return  update phone
   */
  public boolean updatePhone(AuthorizedContactPhone phone) {
    // nothing to update or Delete the Phone
    if ((phone == null) || (phone.getPhoneType() == null)
          || (phone.getPhoneType().getTypeId() == null)) {
      return false;
    }

    String                 typeId  = phone.getPhoneType().getTypeId().toString();
    AuthorizedContactPhone myPhone = this.phones.get(typeId);
    Date                   now     = new Date();

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

      if (updateCurrentPhone) {
        myPhone.setLastUpdateDate(now);
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
          myPhone = new AuthorizedContactPhone();
          myPhone.setHistorical(Boolean.FALSE);
          myPhone.setAccountAuthorizedContact(this);
          myPhone.setEntryDate(now);
          myPhone.deepCopy(phone);
        } else {
          this.historicalPhones.remove(myPhone);
          myPhone.setExitDate(null);
          myPhone.setHistorical(Boolean.FALSE);
          myPhone.setLastUpdateDate(now);
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

        AuthorizedContactPhone newPhone = lookupHistoricalPhone(phone);

        if (newPhone == null) {
          newPhone = new AuthorizedContactPhone();
          newPhone.setHistorical(Boolean.FALSE);
          newPhone.setAccountAuthorizedContact(this);
          newPhone.setEntryDate(now);
          newPhone.deepCopy(phone);
        } else {
          historicalPhones.remove(newPhone);
          newPhone.setExitDate(null);
          newPhone.setHistorical(Boolean.FALSE);
          newPhone.setLastUpdateDate(now);
          newPhone.setSource(phone.getSource());
        }

        this.phones.put(typeId, newPhone);
      } // end if-else

      return true;
    } // end if-else
  }   // end method updatePhone

  //~ ------------------------------------------------------------------------------------------------------------------

  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   phoneNum        DOCUMENT ME!
   * @param   contactChannel  DOCUMENT ME!
   * @param   contactSource   DOCUMENT ME!
   * @param   contactStatus   DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean updatePhone(String phoneNum, ContactChannel contactChannel, ContactSource contactSource,
    ContactStatus contactStatus) {
    return updatePhone(convertToContactPhone(phoneNum, contactChannel,
          contactSource, contactStatus));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   phone  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean updatePhoneExpressConsent(AuthorizedContactPhone phone) {
    // nothing to update or Delete the Phone
    if ((phone == null) || (phone.getPhoneType() == null)
          || (phone.getPhoneType().getTypeId() == null)) {
      return false;
    }

    String                 typeId  = phone.getPhoneType().getTypeId().toString();
    AuthorizedContactPhone myPhone = this.phones.get(typeId);
    Date                   now     = new Date();
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
   * DOCUMENT ME!
   *
   * @param   phone  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean updatePhoneExpressConsentSMS(AuthorizedContactPhone phone) {
    // nothing to update or Delete the Phone
    if ((phone == null) || (phone.getPhoneType() == null)
          || (phone.getPhoneType().getTypeId() == null)) {
      return false;
    }

    String                 typeId  = phone.getPhoneType().getTypeId().toString();
    AuthorizedContactPhone myPhone = this.phones.get(typeId);
    Date                   now     = new Date();
    myPhone.setExpressConsentSMS(phone.getExpressConsentSMS());
    myPhone.setLastExpressConsentSMSAgent(phone.getLastExpressConsentSMSAgent());
    myPhone.setLastExpressConsentSMSUpdateDate(now);
    this.phones.put(typeId, myPhone);

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   phone  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean updatePhoneExpressConsentVoice(AuthorizedContactPhone phone) {
    // nothing to update or Delete the Phone
    if ((phone == null) || (phone.getPhoneType() == null)
          || (phone.getPhoneType().getTypeId() == null)) {
      return false;
    }

    String                 typeId  = phone.getPhoneType().getTypeId().toString();
    AuthorizedContactPhone myPhone = this.phones.get(typeId);
    Date                   now     = new Date();
    myPhone.setExpressConsentVoice(phone.getExpressConsentVoice());
    myPhone.setLastExpressConsentVoiceAgent(phone.getLastExpressConsentVoiceAgent());
    myPhone.setLastExpressConsentVoiceUpdateDate(now);
    this.phones.put(typeId, myPhone);

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

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Mark all Contact Phones having the given phonenumber for this AccountAuthorizedContact.
   *
   * @param  phoneNum  DOCUMENT ME!
   * @param  status    DOCUMENT ME!
   */
  protected void markPhoneNum(String phoneNum, ContactStatus status) {
    Set<AuthorizedContactPhone> ps = getContactPhonesbyPhoneNum(phoneNum);

    if ((ps != null) && (ps.size() > 0)) {
      for (AuthorizedContactPhone p : ps) {
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

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   zipCode  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
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
  } // end method updateZipCode


} // end class AccountAuthorizedContact
