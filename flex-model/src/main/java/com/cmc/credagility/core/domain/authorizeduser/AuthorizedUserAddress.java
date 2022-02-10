package com.cmc.credagility.core.domain.authorizeduser;

import javax.persistence.Column;
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

import com.cmc.credagility.core.domain.address.Address;
import com.cmc.credagility.core.domain.address.AddressType;
import com.cmc.credagility.core.domain.type.ContactChannel;
import com.cmc.credagility.core.domain.type.ContactChannelType;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/14/2014 18:03
 */
@Entity
@Table(
  name    = "AuthorizedUserAddress",
  indexes = {
    @Index(
      name = "historicalIndex",
      columnList = "historical"
    ),
    @Index(
      name = "optOutIndex",
      columnList = "optOut"
    ), @Index(
      name = "postalCodeIndex",
      columnList = "postalCode"
    )
  }
)
public class AuthorizedUserAddress extends BaseAuthorizedUserAddress {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 1220839292347307610L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Embedded protected Address address = new Address();

  /** Address contact PK addressId. */
  // npelleti, 07/30, USBank, Removed unique constraint
  @Column(
    name     = "addressId", /*unique = true,*/
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long addressId;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "typeId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected AddressType addressType = new AddressType();


  /** TODO: DOCUMENT ME! */
  @Column(name = "letterCount")
  protected Integer letterCount;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * Make copy for the contact address.
   *
   * @param  address  AuthorizedUserAddress
   */

  public void deepCopy(AuthorizedUserAddress address) {
    if (address != null) {
      super.deepCopy(address);
      this.address.deepCopy(address.getAddress());
      this.addressType.deepCopy(address.getAddressType());
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.contact.AbstractBaseContact#equals(java.lang.Object)
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

    final AuthorizedUserAddress other = (AuthorizedUserAddress) obj;

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
   * @see  com.cmc.credagility.core.domain.contact.GeneralContactAddress#getAddress()
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
   * @see  com.cmc.credagility.core.domain.contact.GeneralContactAddress#getAddressType()
   */
  @Override public AddressType getAddressType() {
    return this.addressType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for contact channel.
   *
   * @return  ContactChannel
   */
  public ContactChannel getContactChannel() {
    return ContactChannel.toContactChannel(getAddressType().getTypeId(),
        ContactChannelType.ADDRESS);
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
   * getter method for type.
   *
   * @return  String
   */
  public String getType() {
    return this.addressType.getTypeCode();
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

  /**
   * @see  com.cmc.credagility.core.domain.contact.AbstractBaseContact#hashCode()
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
   * increaseLetterCount.
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
   * @see  com.cmc.credagility.core.domain.contact.GeneralContactAddress#setAddress(com.cmc.credagility.core.domain.address.Address)
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
   * @see  com.cmc.credagility.core.domain.contact.GeneralContactAddress#setAddressType(com.cmc.credagility.core.domain.address.AddressType)
   */
  @Override public void setAddressType(AddressType addressType) {
    this.addressType = addressType;
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

} // end class AuthorizedUserAddress
