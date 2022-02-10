package com.cmc.credagility.core.domain.contact;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.cmc.credagility.core.domain.address.Address;
import com.cmc.credagility.core.domain.address.AddressType;
import com.cmc.credagility.core.domain.customer.CustomerContactAddress;
import com.cmc.credagility.core.domain.type.ContactChannel;
import com.cmc.credagility.core.domain.type.ContactChannelType;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * This class is used to store responsible address contact.
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 * @version  10/14/2014 17:28
 */
@Embeddable @Entity
@Table(
  name    = "ContactAddress",
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
public class ContactAddress extends BaseContactAddress {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 5726282642327071972L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Address. */
  @Embedded protected Address address = new Address();

  /** Address contact PK addressId. */
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long         addressId;

  /** Address type, Refers {@link AddressType}. */
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


  /** Client address update date. */
  @Column(name = "clientAddressUpdateDate")
  @Temporal(TemporalType.DATE)
  protected Date clientAddressUpdateDate;


  /** Letter count. */
  @Column(name = "letterCount")
  protected Integer letterCount;

  /** TODO: DOCUMENT ME! */
  @Column(name = "postalIdentificationNumber")
  protected Integer postalIdentificationNumber;


  /** If this address is the primary address. */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean primaryAddress = Boolean.FALSE;

  @Transient private Long disclosure;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * deepCopy.
   *
   * @param  address  ContactAddress
   */
  public void deepCopy(ContactAddress address) {
    if (address != null) {
      super.deepCopy(address);
      this.address.deepCopy(address.getAddress());
      this.addressType.deepCopy(address.getAddressType());
      this.assessment          = address.getAssessment();
      this.bureauAddressSource = address.getBureauAddressSource();
      this.bureauAddressType   = address.getBureauAddressType();
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * deepCopy.
   *
   * @param  address  CustomerContactAddress
   */
  public void deepCopy(CustomerContactAddress address) {
    if (address != null) {
      super.deepCopy(address);
      this.address.deepCopy(address.getAddress());
      this.addressType.deepCopy(address.getAddressType());
      this.assessment          = address.getAssessment();
      this.bureauAddressSource = address.getBureauAddressSource();
      this.bureauAddressType   = address.getBureauAddressType();
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * equals.
   *
   * @param   obj  Object
   *
   * @return  boolean
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

    final ContactAddress other = (ContactAddress) obj;

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
   * getter method for address id.
   *
   * @return  Long
   */
  public Long getAddressId() {
    return addressId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for address type.
   *
   * @return  AddressType
   */
  @Override public AddressType getAddressType() {
    return addressType;
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
   * getter method for disclosure.
   *
   * @return  Long
   */
  public Long getDisclosure() {
    return disclosure;
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
   * getter method for type.
   *
   * @return  String
   */
  public String getType() {
    return this.addressType.getTypeCode();
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

  /**
   * hashCode.
   *
   * @return  int
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
   * setter method for disclosure.
   *
   * @param  disclosure  Long
   */
  public void setDisclosure(Long disclosure) {
    this.disclosure = disclosure;
  }

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
} // end class ContactAddress
