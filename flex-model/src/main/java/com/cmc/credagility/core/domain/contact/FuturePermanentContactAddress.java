package com.cmc.credagility.core.domain.contact;

import java.util.Date;

import javax.persistence.Column;
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
import com.cmc.credagility.core.domain.type.ContactChannel;
import com.cmc.credagility.core.domain.type.ContactChannelType;


/**
 * This class is used to store FuturePermanentContactAddress information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/15/2014 11:18
 */
@Embeddable @Entity
@Table(
  name    = "FuturePermanentContactAddress",
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
public class FuturePermanentContactAddress extends BaseContactAddress {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 2220855794788992463L;

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


  /** Letter count. */
  @Column(name = "letterCount")
  protected Integer letterCount;


  /** Start date. */
  @Column(name = "startDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date startDate;

  @Transient private Long disclosure;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * Make copy for the contact address.
   *
   * @param  address  DOCUMENT ME!
   */

  public void deepCopy(FuturePermanentContactAddress address) {
    if (address != null) {
      super.deepCopy(address);
      this.address.deepCopy(address.getAddress());
      this.addressType.deepCopy(address.getAddressType());
      this.setStartDate(address.getStartDate());
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * equals.
   *
   * @param   o  Object
   *
   * @return  boolean
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

    FuturePermanentContactAddress that = (FuturePermanentContactAddress) o;

    if ((address != null) ? (!address.equals(that.address)) : (that.address != null)) {
      return false;
    }

    if ((addressId != null) ? (!addressId.equals(that.addressId)) : (that.addressId != null)) {
      return false;
    }

    if ((addressType != null) ? (!addressType.equals(that.addressType)) : (that.addressType != null)) {
      return false;
    }

    if ((disclosure != null) ? (!disclosure.equals(that.disclosure)) : (that.disclosure != null)) {
      return false;
    }

    if ((letterCount != null) ? (!letterCount.equals(that.letterCount)) : (that.letterCount != null)) {
      return false;
    }

    if ((startDate != null) ? (!startDate.equals(that.startDate)) : (that.startDate != null)) {
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
   * getter method for start date.
   *
   * @return  Date
   */
  public Date getStartDate() {
    return startDate;
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
    int result = super.hashCode();
    result = (31 * result) + ((address != null) ? address.hashCode() : 0);
    result = (31 * result) + ((addressId != null) ? addressId.hashCode() : 0);
    result = (31 * result) + ((addressType != null) ? addressType.hashCode() : 0);
    result = (31 * result) + ((letterCount != null) ? letterCount.hashCode() : 0);
    result = (31 * result) + ((disclosure != null) ? disclosure.hashCode() : 0);
    result = (31 * result) + ((startDate != null) ? startDate.hashCode() : 0);

    return result;
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
   * setter method for start date.
   *
   * @param  startDate  Date
   */
  public void setStartDate(Date startDate) {
    this.startDate = startDate;
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

    retValue.append("FuturePermanentContactAddress ( ").append(super.toString()).append(TAB).append("address = ")
      .append(this.address).append(TAB).append(
      "addressId = ").append(this.addressId).append(TAB).append(" )");

    return retValue.toString();
  }
} // end class FuturePermanentContactAddress
