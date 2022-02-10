package com.cmc.credagility.core.domain.customer;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.address.Address;
import com.cmc.credagility.core.domain.address.AddressType;
import com.cmc.credagility.core.domain.type.ContactChannel;
import com.cmc.credagility.core.domain.type.ContactChannelType;
import com.cmc.credagility.core.domain.user.User;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/14/2014 17:53
 */
@Entity
@Table(
  name    = "CustomerContactAddress",
  indexes = {
    @Index(
      name = "historicalIndex",
      columnList = "historical"
    ), @Index(
      name = "optOutIndex",
      columnList = "optOut"
    ), @Index(
      name = "postalCodeIndex",
      columnList = "postalCode"
    )
  }
)
public class CustomerContactAddress extends BaseCustomerContactAddress {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 1220839292347307610L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Address. */
  @Embedded protected Address address = new Address();

  /** Address contact PK addressId. */
  // npelleti, 07/30, USBank, Removed unique constraint
  @Column(
    name     = "addressId", /*unique = true,*/
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long addressId;

  /** Address Type. */
  @JoinColumn(
    name       = "typeId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected AddressType addressType = new AddressType();

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "assessment",
    nullable = true,
    length   = 2
  )
  protected String assessment;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "bureauAddressSource",
    nullable = true,
    length   = 20
  )
  protected String bureauAddressSource;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "bureauAddressType",
    nullable = true,
    length   = 1
  )
  protected String bureauAddressType;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientAddressUpdateDate")
  @Temporal(TemporalType.DATE)
  protected Date clientAddressUpdateDate;

  /** Create date. */
  @JoinColumn(
    name       = "creatorId",
    insertable = true,
    updatable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected User creator;

  /** Last Updater. */
  @JoinColumn(
    name       = "lastUpdaterId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected User lastUpdater;


  /** TODO: DOCUMENT ME! */
  @Column(name = "letterCount")
  protected Integer letterCount;

  /** TODO: DOCUMENT ME! */
  @Column(name = "postalIdentificationNumber")
  protected Integer postalIdentificationNumber;


  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "primaryAddress",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean primaryAddress = Boolean.FALSE;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "updated",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean updated = Boolean.FALSE;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * Make copy for the contact address.
   *
   * @param  address  DOCUMENT ME!
   */

  public void deepCopy(CustomerContactAddress address) {
    if (address != null) {
      super.deepCopy(address);
      this.address.deepCopy(address.getAddress());
      this.addressType.deepCopy(address.getAddressType());
      this.primaryAddress             = address.getPrimaryAddress();
      this.letterCount                = address.getLetterCount();
      this.clientAddressUpdateDate    = address.getClientAddressUpdateDate();
      this.updated                    = address.getUpdated();
      this.bureauAddressSource        = address.getBureauAddressSource();
      this.assessment                 = address.getAssessment();
      this.postalIdentificationNumber = address.getPostalIdentificationNumber();
      this.bureauAddressType          = address.getBureauAddressType();
    }
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

    if (!super.equals(obj)) {
      return false;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    final CustomerContactAddress other = (CustomerContactAddress) obj;

    if (address == null) {
      if (other.getAddress() != null) {
        return false;
      }
    } else if (!address.equals(other.getAddress())) {
      return false;
    }

    if (addressType == null) {
      if (other.getAddressType() != null) {
        return false;
      }
    } else if (!addressType.equals(other.getAddressType())) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for address.
   *
   * @return  Address
   */
  @Override public Address getAddress() {
    return address;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The addressId.
   *
   * @return  the addressId
   *
   *          <p>generator-class = "native" unsaved-value = "null"</p>
   */
  public Long getAddressId() {
    return addressId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The addressType.
   *
   * @return  the addressType
   *
   *          <p>lazy = "false" column = "typeId" not-null = "true" class = "com.cmc.credagility.AddressType" insert =
   *          "true" update = "true" length = "20"</p>
   */
  @Override public AddressType getAddressType() {
    return this.addressType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for assessment.
   *
   * @return  String
   */
  public String getAssessment() {
    return assessment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bureau address source.
   *
   * @return  String
   */
  public String getBureauAddressSource() {
    return bureauAddressSource;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bureau address type.
   *
   * @return  String
   */
  public String getBureauAddressType() {
    return bureauAddressType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client address update date.
   *
   * @return  Date
   */
  public Date getClientAddressUpdateDate() {
    return clientAddressUpdateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for contact channel.
   *
   * @return  ContactChannel
   */
  @Override public ContactChannel getContactChannel() {
    return ContactChannel.toContactChannel(getAddressType().getTypeId(),
        ContactChannelType.ADDRESS);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for creator.
   *
   * @return  User
   */
  public User getCreator() {
    return creator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for creator name.
   *
   * @return  String
   */
  public String getCreatorName() {
    if (getCreator() != null) {
      return getCreator().getFullName();
    } else {
      return "";
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last updater.
   *
   * @return  User
   */
  public User getLastUpdater() {
    return lastUpdater;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last updater name.
   *
   * @return  String
   */
  public String getLastUpdaterName() {
    if (getLastUpdater() != null) {
      return getLastUpdater().getFullName();
    } else {
      return "";
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for letter count.
   *
   * @return  Integer
   */
  public Integer getLetterCount() {
    return letterCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for postal identification number.
   *
   * @return  Integer
   */
  public Integer getPostalIdentificationNumber() {
    return postalIdentificationNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for primary address.
   *
   * @return  Boolean
   */
  public Boolean getPrimaryAddress() {
    return primaryAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get type lookup code.
   *
   * @return  get type lookup code.
   */
  public String getType() {
    return this.addressType.getTypeCode();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for updated.
   *
   * @return  Boolean
   */
  public Boolean getUpdated() {
    return updated;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hasAddress1Or2.
   *
   * @return  boolean
   */
  public boolean hasAddress1Or2() {
    return address.hasAddress1Or2();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hasAddressInfo.
   *
   * @return  boolean
   */
  public boolean hasAddressInfo() {
    return address.hasAddressInfo();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = super.hashCode();
    result = (prime * result) + ((address == null) ? 0 : address.hashCode());
    result = (prime * result)
      + ((addressType == null) ? 0 : addressType.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Increase letter count.
   */
  public void increaseLetterCount() {
    if ((letterCount == null) || (letterCount <= 0)) {
      letterCount = 1;
    } else {
      letterCount++;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Check if this is an empty or non-valid address.
   *
   * @return  check if this is an empty or non-valid address.
   */
  public boolean isValidAddress() {
    return this.getAddress().isValidAddress();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for address.
   *
   * @param  address  Address
   */
  @Override public void setAddress(Address address) {
    this.address = address;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for address id.
   *
   * @param  addressId  Long
   */
  public void setAddressId(Long addressId) {
    this.addressId = addressId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for address type.
   *
   * @param  addressType  AddressType
   */
  @Override public void setAddressType(AddressType addressType) {
    this.addressType = addressType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for assessment.
   *
   * @param  assessment  String
   */
  public void setAssessment(String assessment) {
    this.assessment = assessment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bureau address source.
   *
   * @param  bureauAddressSource  String
   */
  public void setBureauAddressSource(String bureauAddressSource) {
    this.bureauAddressSource = bureauAddressSource;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bureau address type.
   *
   * @param  bureauAddressType  String
   */
  public void setBureauAddressType(String bureauAddressType) {
    this.bureauAddressType = bureauAddressType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client address update date.
   *
   * @param  clientAddressUpdateDate  Date
   */
  public void setClientAddressUpdateDate(Date clientAddressUpdateDate) {
    this.clientAddressUpdateDate = clientAddressUpdateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for creator.
   *
   * @param  creator  User
   */
  public void setCreator(User creator) {
    this.creator = creator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for creator name.
   *
   * @param  name  String
   */
  public void setCreatorName(String name) { }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last updater.
   *
   * @param  lastUpdater  User
   */
  public void setLastUpdater(User lastUpdater) {
    this.lastUpdater = lastUpdater;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last updater name.
   *
   * @param  name  String
   */
  public void setLastUpdaterName(String name) { }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for letter count.
   *
   * @param  letterCount  Integer
   */
  public void setLetterCount(Integer letterCount) {
    this.letterCount = letterCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for postal identification number.
   *
   * @param  postalIdentificationNumber  Integer
   */
  public void setPostalIdentificationNumber(Integer postalIdentificationNumber) {
    this.postalIdentificationNumber = postalIdentificationNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for primary address.
   *
   * @param  primaryAddress  Boolean
   */
  public void setPrimaryAddress(Boolean primaryAddress) {
    this.primaryAddress = primaryAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for updated.
   *
   * @param  updated  Boolean
   */
  public void setUpdated(Boolean updated) {
    this.updated = updated;
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

    retValue.append("ContactAddress ( ").append(super.toString()).append(TAB).append("address = ").append(this.address)
      .append(TAB).append(
      "addressId = ").append(this.addressId).append(TAB).append(" )");

    return retValue.toString();
  }

} // end class CustomerContactAddress
