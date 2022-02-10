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

import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;
import org.springframework.util.StringUtils;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.contact.PhoneType;
import com.cmc.credagility.core.domain.user.Role;
import com.cmc.credagility.core.jpa.converter.StringEncryptionConverter;


/**
 * The contact phone associated to agency.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  10/14/2014 17:53 PM
 */
@Entity
@Table(
  name    = "AgencyContactPhone",
  indexes = {
    @Index(
      name = "historicalIndex",
      columnList = "historical"
    ), @Index(
      name = "phoneNumIndex",
      columnList = "phoneNum"
    )
  }
)
public class AgencyContactPhone extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 3807003354818365736L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "countryCode",
    length = 3
  )
  protected String countryCode;

  /** phone number extension. */
  @Column(
    name   = "extension",
    length = 20
  )
  protected String extension;

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

  /** phone number. */
  @Column(
    name     = "phoneNum",
    length   = 20,
    nullable = false
  )
  protected String phoneNum;

  /** Phone type, Refers {@link PhoneType}. */
  @JoinColumn(
    name       = "phoneTypeId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected PhoneType phoneType = new PhoneType();

  /** This phone record belonged to. */
  @JoinColumn(
    name       = "roleId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected Role role = new Role();

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "telephoneCountryCode",
    length = 10
  )
  protected String telephoneCountryCode;

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

    AgencyContactPhone that = (AgencyContactPhone) o;

    if ((extension != null) ? (!extension.equals(that.extension)) : (that.extension != null)) {
      return false;
    }

    if ((historical != null) ? (!historical.equals(that.historical)) : (that.historical != null)) {
      return false;
    }

    if ((phoneNum != null) ? (!phoneNum.equals(that.phoneNum)) : (that.phoneNum != null)) {
      return false;
    }

    if ((phoneType != null) ? (!phoneType.equals(that.phoneType)) : (that.phoneType != null)) {
      return false;
    }

    if ((telephoneCountryCode != null) ? (!telephoneCountryCode.equals(that.telephoneCountryCode))
                                       : (that.telephoneCountryCode != null)) {
      return false;
    }

    return (countryCode != null) ? countryCode.equals(that.countryCode) : (that.countryCode == null);

  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for country code.
   *
   * @return  String
   */
  public String getCountryCode() {
    return countryCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for extension.
   *
   * @return  String
   */
  public String getExtension() {
    return extension;
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
   * getter method for phone num.
   *
   * @return  String
   */
  public String getPhoneNum() {
    return phoneNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for phone str.
   *
   * @return  String
   */
  public String getPhoneStr() {
    StringBuffer phoneStr = new StringBuffer();

    phoneStr.append(phoneNum);

    if (StringUtils.hasText(extension)) {
      phoneStr.append("--").append(this.extension);
    }

    return phoneStr.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for phone type.
   *
   * @return  PhoneType
   */
  public PhoneType getPhoneType() {
    return phoneType;
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
   * getter method for telephone country code.
   *
   * @return  String
   */
  public String getTelephoneCountryCode() {
    return telephoneCountryCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((extension != null) ? extension.hashCode() : 0);
    result = (31 * result) + ((historical != null) ? historical.hashCode() : 0);
    result = (31 * result) + ((phoneNum != null) ? phoneNum.hashCode() : 0);
    result = (31 * result) + ((phoneType != null) ? phoneType.hashCode() : 0);
    result = (31 * result) + ((telephoneCountryCode != null) ? telephoneCountryCode.hashCode() : 0);
    result = (31 * result) + ((countryCode != null) ? countryCode.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for country code.
   *
   * @param  countryCode  String
   */
  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for extension.
   *
   * @param  extension  String
   */
  public void setExtension(String extension) {
    this.extension = extension;
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
   * setter method for phone num.
   *
   * @param  phoneNum  String
   */
  public void setPhoneNum(String phoneNum) {
    this.phoneNum = phoneNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for phone type.
   *
   * @param  phoneType  PhoneType
   */
  public void setPhoneType(PhoneType phoneType) {
    this.phoneType = phoneType;
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
   * setter method for telephone country code.
   *
   * @param  telephoneCountryCode  String
   */
  public void setTelephoneCountryCode(String telephoneCountryCode) {
    this.telephoneCountryCode = telephoneCountryCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#toString()
   */
  @Override public String toString() {
    return "AgencyContactPhone{"
      + "extension='" + extension + '\''
      + ", historical=" + historical
      + ", phoneNum='" + phoneNum + '\''
      + ", phoneType=" + phoneType
      + ", telephoneCountryCode='" + telephoneCountryCode + '\''
      + ", countryCode='" + countryCode + '\''
      + '}';
  }
} // end class AgencyContactPhone
