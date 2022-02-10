package com.cmc.credagility.core.domain.client;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;
import com.cmc.credagility.core.jpa.converter.StringEncryptionConverter;


/**
 * This class is used to store BankCoCivilReliefActRequestForm information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/15/2014 15:38
 */
@Entity
@Table(name = "BankCoCivilReliefActRequestForm")
public class BankCoCivilReliefActRequestForm extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 8638286734241006562L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Birthday. */
  @Column(name = "birthday")
  @Temporal(TemporalType.DATE)
  // protected Date dateOfBirth;
  /*@Column(
    name   = "birthday",
    nullable = false,
    length = 20
  )*/
  protected Date birthday;
  @Column(
    name     = "activeServiceStartDate",
    nullable = true
  )
  @Temporal(TemporalType.DATE)
  private Date   activeServiceStartDate;

  @Column(
    name     = "addressLine1",
    nullable = false,
    length   = 255
  )
  private String addressLine1;

  @Column(
    name   = "addressLine2",
    length = 255
  )
  private String addressLine2;

  @Column(
    name     = "city",
    nullable = false,
    length   = 20
  )
  private String city;

  @Column(
    name     = "country",
    nullable = false,
    length   = 20
  )
  private String country;

  @Column(name = "customerCIN")
  private String customerCIN;

  @Column(
    name   = "email",
    length = 128
  )
  private String email;

  @Column(
    name   = "fdrAccountNumber",
    length = 128
  )
  private String fdrAccountNumber;

  @Column(
    name     = "firstName",
    nullable = false,
    length   = 128
  )
  private String firstName;

  @Column(
    name     = "lastName",
    nullable = false,
    length   = 128
  )
  private String lastName;

  @Column(
    name   = "middleName",
    length = 128
  )
  private String middleName;

  @Column(
    name   = "phoneNumber",
    length = 50
  )
  private String phoneNumber;

  @Column(name = "portfolioId")
  private Long portfolioId;

  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long         requestFormId;

  @Column(
    name   = "requestorEmail",
    length = 128
  )
  private String requestorEmail;

  @Column(
    name   = "requestorName",
    length = 128
  )
  private String requestorName;

  @Column(
    name   = "requestorPhone",
    length = 128
  )
  private String requestorPhone;


  @Column(
    name             = "serviceMember",
    nullable         = false,
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean serviceMember;

  @Column(
    name     = "ssn",
    nullable = false,
    length   = 128
  )
  @Convert(converter = StringEncryptionConverter.class)
  private String ssn;
  @Column(
    name     = "state",
    nullable = false,
    length   = 20
  )
  private String state;

  @Column(
    name     = "zip",
    nullable = false,
    length   = 20
  )
  private String zip;

  @Column(
    name   = "zipExtension",
    length = 20
  )
  private String zipExtension;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for active service start date.
   *
   * @return  Date
   */
  public Date getActiveServiceStartDate() {
    return activeServiceStartDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for address line1.
   *
   * @return  String
   */
  public String getAddressLine1() {
    return addressLine1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for address line2.
   *
   * @return  String
   */
  public String getAddressLine2() {
    return addressLine2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for birthday.
   *
   * @return  Date
   */
  public Date getBirthday() {
    return birthday;
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
   * getter method for customer CIN.
   *
   * @return  String
   */
  public String getCustomerCIN() {
    return customerCIN;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for email.
   *
   * @return  String
   */
  public String getEmail() {
    return email;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for fdr account number.
   *
   * @return  String
   */
  public String getFdrAccountNumber() {
    return fdrAccountNumber;
  }

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
   * getter method for last name.
   *
   * @return  String
   */
  public String getLastName() {
    return lastName;
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
   * getter method for phone number.
   *
   * @return  String
   */
  public String getPhoneNumber() {
    return phoneNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio id.
   *
   * @return  Long
   */
  public Long getPortfolioId() {
    return portfolioId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for request form id.
   *
   * @return  Long
   */
  public Long getRequestFormId() {
    return requestFormId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for requestor email.
   *
   * @return  String
   */
  public String getRequestorEmail() {
    return requestorEmail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for requestor name.
   *
   * @return  String
   */
  public String getRequestorName() {
    return requestorName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for requestor phone.
   *
   * @return  String
   */
  public String getRequestorPhone() {
    return requestorPhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for service member.
   *
   * @return  Boolean
   */
  public Boolean getServiceMember() {
    return serviceMember;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ssn.
   *
   * @return  String
   */
  public String getSsn() {
    return ssn;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for state.
   *
   * @return  String
   */
  public String getState() {
    return state;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for zip.
   *
   * @return  String
   */
  public String getZip() {
    return zip;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for zip extension.
   *
   * @return  String
   */
  public String getZipExtension() {
    return zipExtension;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for active service start date.
   *
   * @param  activeServiceStartDate  Date
   */
  public void setActiveServiceStartDate(Date activeServiceStartDate) {
    this.activeServiceStartDate = activeServiceStartDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for address line1.
   *
   * @param  addressLine1  String
   */
  public void setAddressLine1(String addressLine1) {
    this.addressLine1 = addressLine1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for address line2.
   *
   * @param  addressLine2  String
   */
  public void setAddressLine2(String addressLine2) {
    this.addressLine2 = addressLine2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for birthday.
   *
   * @param  birthday  Date
   */
  public void setBirthday(Date birthday) {
    this.birthday = birthday;
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
   * setter method for customer CIN.
   *
   * @param  customerCIN  String
   */
  public void setCustomerCIN(String customerCIN) {
    this.customerCIN = customerCIN;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for email.
   *
   * @param  email  String
   */
  public void setEmail(String email) {
    this.email = email;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for fdr account number.
   *
   * @param  fdrAccountNumber  String
   */
  public void setFdrAccountNumber(String fdrAccountNumber) {
    this.fdrAccountNumber = fdrAccountNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for first name.
   *
   * @param  firstName  String
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last name.
   *
   * @param  lastName  String
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for middle name.
   *
   * @param  middleName  String
   */
  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for phone number.
   *
   * @param  phoneNumber  String
   */
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio id.
   *
   * @param  portfolioId  Long
   */
  public void setPortfolioId(Long portfolioId) {
    this.portfolioId = portfolioId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for request form id.
   *
   * @param  requestFormId  Long
   */
  public void setRequestFormId(Long requestFormId) {
    this.requestFormId = requestFormId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for requestor email.
   *
   * @param  requestorEmail  String
   */
  public void setRequestorEmail(String requestorEmail) {
    this.requestorEmail = requestorEmail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for requestor name.
   *
   * @param  requestorName  String
   */
  public void setRequestorName(String requestorName) {
    this.requestorName = requestorName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for requestor phone.
   *
   * @param  requestorPhone  String
   */
  public void setRequestorPhone(String requestorPhone) {
    this.requestorPhone = requestorPhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for service member.
   *
   * @param  serviceMember  Boolean
   */
  public void setServiceMember(Boolean serviceMember) {
    this.serviceMember = serviceMember;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ssn.
   *
   * @param  ssn  String
   */
  public void setSsn(String ssn) {
    this.ssn = ssn;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for state.
   *
   * @param  state  String
   */
  public void setState(String state) {
    this.state = state;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for zip.
   *
   * @param  zip  String
   */
  public void setZip(String zip) {
    this.zip = zip;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for zip extension.
   *
   * @param  zipExtension  String
   */
  public void setZipExtension(String zipExtension) {
    this.zipExtension = zipExtension;
  }
} // end class BankCoCivilReliefActRequestForm
