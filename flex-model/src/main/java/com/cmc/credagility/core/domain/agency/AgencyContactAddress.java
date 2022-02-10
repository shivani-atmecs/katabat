package com.cmc.credagility.core.domain.agency;

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
import javax.persistence.Table;

import org.springframework.util.StringUtils;

import com.cmc.credagility.core.domain.address.AddressType;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.user.Role;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * The contact address associated to agency.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  10/14/2014 17:36 PM
 */
@Entity
@Table(
  name    = "AgencyContactAddress",
  indexes = {
    @Index(
      name = "historicalIndex",
      columnList = "historical"
    ),
    @Index(
      name = "postalCodeIndex",
      columnList = "postalCode"
    )
  }
)
public class AgencyContactAddress extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -3704952097379737453L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Address line 1. */
  @Column(
    name   = "address1",
    length = 150
  )
  protected String address1;

  /** Address line 2. */
  @Column(
    name   = "address2",
    length = 150
  )
  protected String address2;

  /** Address line 2. */
  @Column(
    name   = "address3",
    length = 150
  )
  protected String address3;

  /** Address type. Refers {@link AddressType} */
  @JoinColumn(
    name       = "addressTypeId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected AddressType addressType = new AddressType();

  /** City. */
  @Column(
    name   = "city",
    length = 50 /*, nullable=false*/
  )
  protected String city;

  /** country. */
  @Column(
    name   = "country",
    length = 100
  )
  protected String country;

  /** country. */
  @Column(
    name   = "county",
    length = 100
  )
  protected String county;

  /** If it is a historical record. */
  @Column(
    name             = "historical",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean historical = Boolean.FALSE;

  /** PK, identity property. */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** postal code. */
  @Column(
    name     = "postalCode",
    length   = 25,
    nullable = false
  )
  protected String postalCode;

  /** province. */
  @Column(
    name   = "province",
    length = 100
  )
  protected String province;

  /** this address record belonged to. */
  @JoinColumn(
    name       = "roleId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected Role role = new Role();

  //~ Methods ----------------------------------------------------------------------------------------------------------

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

    AgencyContactAddress that = (AgencyContactAddress) o;

    if ((address1 != null) ? (!address1.equals(that.address1)) : (that.address1 != null)) {
      return false;
    }

    if ((address2 != null) ? (!address2.equals(that.address2)) : (that.address2 != null)) {
      return false;
    }

    if ((address3 != null) ? (!address3.equals(that.address3)) : (that.address3 != null)) {
      return false;
    }

    if ((city != null) ? (!city.equals(that.city)) : (that.city != null)) {
      return false;
    }

    if ((country != null) ? (!country.equals(that.country)) : (that.country != null)) {
      return false;
    }

    if ((county != null) ? (!county.equals(that.county)) : (that.county != null)) {
      return false;
    }

    if ((historical != null) ? (!historical.equals(that.historical)) : (that.historical != null)) {
      return false;
    }

    if ((id != null) ? (!id.equals(that.id)) : (that.id != null)) {
      return false;
    }

    if ((postalCode != null) ? (!postalCode.equals(that.postalCode)) : (that.postalCode != null)) {
      return false;
    }

    return !((province != null) ? (!province.equals(that.province)) : (that.province != null));

  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for address1.
   *
   * @return  String
   */
  public String getAddress1() {
    return address1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for address2.
   *
   * @return  String
   */
  public String getAddress2() {
    return address2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for address3.
   *
   * @return  String
   */
  public String getAddress3() {
    return address3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for address str.
   *
   * @return  String
   */
  public String getAddressStr() {
    String[] strs = { address1, address2, address3, city, country, postalCode };

    StringBuffer str = new StringBuffer();

    for (String address : strs) {
      if (StringUtils.hasText(str) && StringUtils.hasText(address)) {
        str.append(",").append(address);
      } else {
        str.append(address);
      }
    }

    return str.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for address type.
   *
   * @return  AddressType
   */
  public AddressType getAddressType() {
    return addressType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for city.
   *
   * @return  String
   */
  public String getCity() {
    return city;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for country.
   *
   * @return  String
   */
  public String getCountry() {
    return country;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for county.
   *
   * @return  String
   */
  public String getCounty() {
    return county;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for historical.
   *
   * @return  Boolean
   */
  public Boolean getHistorical() {
    return historical;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for id.
   *
   * @return  Long
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for postal code.
   *
   * @return  String
   */
  public String getPostalCode() {
    return postalCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for province.
   *
   * @return  String
   */
  public String getProvince() {
    return province;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for role.
   *
   * @return  Role
   */
  public Role getRole() {
    return role;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((address1 != null) ? address1.hashCode() : 0);
    result = (31 * result) + ((address2 != null) ? address2.hashCode() : 0);
    result = (31 * result) + ((address3 != null) ? address3.hashCode() : 0);
    result = (31 * result) + ((city != null) ? city.hashCode() : 0);
    result = (31 * result) + ((country != null) ? country.hashCode() : 0);
    result = (31 * result) + ((county != null) ? county.hashCode() : 0);
    result = (31 * result) + ((historical != null) ? historical.hashCode() : 0);
    result = (31 * result) + ((id != null) ? id.hashCode() : 0);
    result = (31 * result) + ((postalCode != null) ? postalCode.hashCode() : 0);
    result = (31 * result) + ((province != null) ? province.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for address1.
   *
   * @param  address1  String
   */
  public void setAddress1(String address1) {
    this.address1 = address1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for address2.
   *
   * @param  address2  String
   */
  public void setAddress2(String address2) {
    this.address2 = address2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for address3.
   *
   * @param  address3  String
   */
  public void setAddress3(String address3) {
    this.address3 = address3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for address type.
   *
   * @param  addressType  AddressType
   */
  public void setAddressType(AddressType addressType) {
    this.addressType = addressType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for city.
   *
   * @param  city  String
   */
  public void setCity(String city) {
    this.city = city;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for country.
   *
   * @param  country  String
   */
  public void setCountry(String country) {
    this.country = country;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for county.
   *
   * @param  county  String
   */
  public void setCounty(String county) {
    this.county = county;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for historical.
   *
   * @param  historical  Boolean
   */
  public void setHistorical(Boolean historical) {
    this.historical = historical;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for id.
   *
   * @param  id  Long
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for postal code.
   *
   * @param  postalCode  String
   */
  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for province.
   *
   * @param  province  String
   */
  public void setProvince(String province) {
    this.province = province;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for role.
   *
   * @param  role  Role
   */
  public void setRole(Role role) {
    this.role = role;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#toString()
   */
  @Override public String toString() {
    return "AgencyContactAddress{"
      + "address1='" + address1 + '\''
      + ", address2='" + address2 + '\''
      + ", address3='" + address3 + '\''
      + ", city='" + city + '\''
      + ", country='" + country + '\''
      + ", county='" + county + '\''
      + ", historical=" + historical
      + ", id=" + id
      + ", postalCode='" + postalCode + '\''
      + ", province='" + province + '\''
      + '}';
  }


} // end class AgencyContactAddress
