package com.cmc.credagility.core.domain.customer;

import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.address.Address;
import com.cmc.credagility.core.domain.address.AddressType;
import com.cmc.credagility.core.domain.type.ContactChannel;
import com.cmc.credagility.core.domain.type.ContactChannelType;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/14/2014 18:05
 */
@Entity
@Table(
  name    = "TemporaryCustomerContactAddress",
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
public class TemporaryCustomerContactAddress extends BaseCustomerContactAddress {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 5305381619651141982L;

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
  @Column(name = "endDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date endDate;


  /** TODO: DOCUMENT ME! */
  @Column(name = "letterCount")
  protected Integer letterCount;


  /** TODO: DOCUMENT ME! */
  @Column(name = "startDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date startDate;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * Make copy for the contact address.
   *
   * @param  address  DOCUMENT ME!
   */

  public void deepCopy(TemporaryCustomerContactAddress address) {
    if (address != null) {
      super.deepCopy(address);
      this.address.deepCopy(address.getAddress());
      this.addressType.deepCopy(address.getAddressType());
      this.setStartDate(address.getStartDate());
      this.setEndDate(address.getEndDate());
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.contact.AbstractBaseContact#equals(java.lang.Object)
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

    TemporaryCustomerContactAddress that = (TemporaryCustomerContactAddress) o;

    if ((address != null) ? (!address.equals(that.address)) : (that.address != null)) {
      return false;
    }

    if ((addressId != null) ? (!addressId.equals(that.addressId)) : (that.addressId != null)) {
      return false;
    }

    if ((addressType != null) ? (!addressType.equals(that.addressType)) : (that.addressType != null)) {
      return false;
    }

    if ((endDate != null) ? (!endDate.equals(that.endDate)) : (that.endDate != null)) {
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
   * getter method for end date.
   *
   * @return  Date
   */
  public Date getEndDate() {
    return endDate;
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
   * Get type lookup code.
   *
   * @return  get type lookup code.
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
    int result = super.hashCode();
    result = (31 * result) + ((address != null) ? address.hashCode() : 0);
    result = (31 * result) + ((addressId != null) ? addressId.hashCode() : 0);
    result = (31 * result) + ((addressType != null) ? addressType.hashCode() : 0);
    result = (31 * result) + ((letterCount != null) ? letterCount.hashCode() : 0);
    result = (31 * result) + ((startDate != null) ? startDate.hashCode() : 0);
    result = (31 * result) + ((endDate != null) ? endDate.hashCode() : 0);

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
   * setter method for end date.
   *
   * @param  endDate  Date
   */
  public void setEndDate(Date endDate) {
    this.endDate = endDate;
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

    retValue.append("TemporaryCustomerContactAddress ( ").append(super.toString()).append(TAB).append("address = ")
      .append(this.address).append(TAB).append(
      "addressId = ").append(this.addressId).append(TAB).append(" )");

    return retValue.toString();
  }

} // end class TemporaryCustomerContactAddress
