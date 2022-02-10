package com.cmc.credagility.core.domain.slm;

import java.io.Serializable;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import com.cmc.credagility.core.domain.account.AccountDetail;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/15/2014 14:34
 */
@Entity
@Table(
  name              = "SlmSchoolStatus",
  uniqueConstraints = { @UniqueConstraint(columnNames = "schoolIdentifier") }
)
public class SlmSchoolStatus extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 8837346878745364062L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "slmSchoolStatus",
    cascade  = { CascadeType.ALL }
  )
  protected Set<AccountDetail> accountDetails = new LinkedHashSet<AccountDetail>();

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "schoolStatusId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long schoolStatusId;

  @Column(
    name   = "controlSwitch",
    length = 10
  )
  private String controlSwitch;
  @Column(
    name   = "distributedClientType",
    length = 10
  )
  private String distributedClientType;
  @Column(
    name   = "schoolAddress1",
    length = 50
  )
  private String schoolAddress1;
  @Column(
    name   = "schoolAddress2",
    length = 50
  )
  private String schoolAddress2;
  @Column(
    name   = "schoolAddressForeignIndicator",
    length = 1
  )
  private String schoolAddressForeignIndicator;

  @Column(
    name   = "schoolBranchID",
    length = 10
  )
  private String schoolBranchID;
  @Column(
    name   = "schoolCity",
    length = 50
  )
  private String schoolCity;

  @Column(
    name             = "schoolClearinghouseIndicator",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean schoolClearinghouseIndicator;

  @Column(name = "schoolCloseDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date   schoolCloseDate;
  @Column(
    name   = "schoolContactFirstName",
    length = 20
  )
  private String schoolContactFirstName;

  @Column(
    name   = "schoolContactLastName",
    length = 20
  )
  private String schoolContactLastName;

  @Column(
    name   = "schoolContactMiddleInitial",
    length = 1
  )
  private String schoolContactMiddleInitial;

  @Column(
    name   = "schoolEducationDeptNum",
    length = 10
  )
  private String schoolEducationDeptNum;
  @Column(
    name   = "schoolFAOForeignAddress1",
    length = 40
  )
  private String schoolFAOForeignAddress1;
  @Column(
    name   = "schoolFAOForeignAddress2",
    length = 40
  )
  private String schoolFAOForeignAddress2;
  @Column(
    name   = "schoolFAOForeignAddress3",
    length = 40
  )
  private String schoolFAOForeignAddress3;
  @Column(
    name   = "schoolFAOForeignCountry",
    length = 20
  )
  private String schoolFAOForeignCountry;
  @Column(
    name   = "schoolFAOPhoneAreaCode",
    length = 10
  )
  private String schoolFAOPhoneAreaCode;
  @Column(
    name   = "schoolFAOPhoneExchange",
    length = 10
  )
  private String schoolFAOPhoneExchange;
  @Column(
    name   = "schoolFAOPhoneExt",
    length = 5
  )
  private String schoolFAOPhoneExt;
  @Column(
    name   = "schoolFinancialAidAddress1",
    length = 40
  )
  private String schoolFinancialAidAddress1;
  @Column(
    name   = "schoolFinancialAidAddress2",
    length = 40
  )
  private String schoolFinancialAidAddress2;
  @Column(
    name   = "schoolFinancialAidCity",
    length = 40
  )
  private String schoolFinancialAidCity;
  @Column(
    name   = "schoolFinancialAidState",
    length = 10
  )
  private String schoolFinancialAidState;
  @Column(
    name   = "schoolFinancialAidZipCode",
    length = 10
  )
  private String schoolFinancialAidZipCode;
  @Column(
    name   = "schoolFinancialAidZipCodeExt",
    length = 5
  )
  private String schoolFinancialAidZipCodeExt;
  @Column(
    name   = "schoolForeignAddress1",
    length = 50
  )
  private String schoolForeignAddress1;
  @Column(
    name   = "schoolForeignAddress2",
    length = 50
  )
  private String schoolForeignAddress2;
  @Column(
    name   = "schoolForeignAddress3",
    length = 50
  )
  private String schoolForeignAddress3;
  @Column(
    name   = "schoolForeignCountry",
    length = 50
  )
  private String schoolForeignCountry;
  @Column(
    name   = "schoolId",
    length = 10
  )
  private String schoolId;
  @Column(
    name     = "schoolIdentifier",
    length   = 20,
    unique   = true,
    nullable = false
  )
  private String schoolIdentifier;

  @Column(
    name             = "schoolInvalidAddressIndicator",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean schoolInvalidAddressIndicator;

  @Column(name = "schoolMaintenanceDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date   schoolMaintenanceDate;
  @Column(
    name   = "schoolMaintenanceID",
    length = 16
  )
  private String schoolMaintenanceID;

  @Column(
    name   = "schoolName",
    length = 50
  )
  private String schoolName;
  @Column(
    name   = "schoolPhoneAreaCode",
    length = 10
  )
  private String schoolPhoneAreaCode;
  @Column(
    name   = "schoolPhoneExchange",
    length = 10
  )
  private String schoolPhoneExchange;
  @Column(
    name   = "schoolPhoneExt",
    length = 5
  )
  private String schoolPhoneExt;
  @Column(
    name   = "schoolState",
    length = 20
  )
  private String schoolState;
  @Column(
    name   = "schoolType",
    length = 1
  )
  private String schoolType;
  @Column(
    name   = "schoolZipCode",
    length = 10
  )
  private String schoolZipCode;
  @Column(
    name   = "schoolZipCodeExt",
    length = 10
  )
  private String schoolZipCodeExt;
  @Column(
    name   = "systemName",
    length = 10
  )
  private String systemName;

  @Column(
    name   = "titleIVEligibilityFlag",
    length = 1
  )
  private String titleIVEligibilityFlag;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for account details.
   *
   * @return  Set
   */
  public Set<AccountDetail> getAccountDetails() {
    return accountDetails;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for control switch.
   *
   * @return  String
   */
  public String getControlSwitch() {
    return controlSwitch;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for distributed client type.
   *
   * @return  String
   */
  public String getDistributedClientType() {
    return distributedClientType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for school address1.
   *
   * @return  String
   */
  public String getSchoolAddress1() {
    return schoolAddress1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for school address2.
   *
   * @return  String
   */
  public String getSchoolAddress2() {
    return schoolAddress2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for school address foreign indicator.
   *
   * @return  String
   */
  public String getSchoolAddressForeignIndicator() {
    return schoolAddressForeignIndicator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for school branch ID.
   *
   * @return  String
   */
  public String getSchoolBranchID() {
    return schoolBranchID;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for school city.
   *
   * @return  String
   */
  public String getSchoolCity() {
    return schoolCity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for school clearinghouse indicator.
   *
   * @return  Boolean
   */
  public Boolean getSchoolClearinghouseIndicator() {
    if (schoolClearinghouseIndicator == null) {
      return Boolean.FALSE;
    }

    return schoolClearinghouseIndicator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for school close date.
   *
   * @return  Date
   */
  public Date getSchoolCloseDate() {
    return schoolCloseDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for school contact first name.
   *
   * @return  String
   */
  public String getSchoolContactFirstName() {
    return schoolContactFirstName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for school contact last name.
   *
   * @return  String
   */
  public String getSchoolContactLastName() {
    return schoolContactLastName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for school contact middle initial.
   *
   * @return  String
   */
  public String getSchoolContactMiddleInitial() {
    return schoolContactMiddleInitial;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for school education dept num.
   *
   * @return  String
   */
  public String getSchoolEducationDeptNum() {
    return schoolEducationDeptNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for school FAOForeign address1.
   *
   * @return  String
   */
  public String getSchoolFAOForeignAddress1() {
    return schoolFAOForeignAddress1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for school FAOForeign address2.
   *
   * @return  String
   */
  public String getSchoolFAOForeignAddress2() {
    return schoolFAOForeignAddress2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for school FAOForeign address3.
   *
   * @return  String
   */
  public String getSchoolFAOForeignAddress3() {
    return schoolFAOForeignAddress3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for school FAOForeign country.
   *
   * @return  String
   */
  public String getSchoolFAOForeignCountry() {
    return schoolFAOForeignCountry;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for school FAOPhone area code.
   *
   * @return  String
   */
  public String getSchoolFAOPhoneAreaCode() {
    return schoolFAOPhoneAreaCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for school FAOPhone exchange.
   *
   * @return  String
   */
  public String getSchoolFAOPhoneExchange() {
    return schoolFAOPhoneExchange;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for school FAOPhone ext.
   *
   * @return  String
   */
  public String getSchoolFAOPhoneExt() {
    return schoolFAOPhoneExt;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for school financial aid address1.
   *
   * @return  String
   */
  public String getSchoolFinancialAidAddress1() {
    return schoolFinancialAidAddress1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for school financial aid address2.
   *
   * @return  String
   */
  public String getSchoolFinancialAidAddress2() {
    return schoolFinancialAidAddress2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for school financial aid city.
   *
   * @return  String
   */
  public String getSchoolFinancialAidCity() {
    return schoolFinancialAidCity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for school financial aid state.
   *
   * @return  String
   */
  public String getSchoolFinancialAidState() {
    return schoolFinancialAidState;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for school financial aid zip code.
   *
   * @return  String
   */
  public String getSchoolFinancialAidZipCode() {
    return schoolFinancialAidZipCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for school financial aid zip code ext.
   *
   * @return  String
   */
  public String getSchoolFinancialAidZipCodeExt() {
    return schoolFinancialAidZipCodeExt;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for school foreign address1.
   *
   * @return  String
   */
  public String getSchoolForeignAddress1() {
    return schoolForeignAddress1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for school foreign address2.
   *
   * @return  String
   */
  public String getSchoolForeignAddress2() {
    return schoolForeignAddress2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for school foreign address3.
   *
   * @return  String
   */
  public String getSchoolForeignAddress3() {
    return schoolForeignAddress3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for school foreign country.
   *
   * @return  String
   */
  public String getSchoolForeignCountry() {
    return schoolForeignCountry;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for school id.
   *
   * @return  String
   */
  public String getSchoolId() {
    return schoolId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for school identifier.
   *
   * @return  String
   */
  public String getSchoolIdentifier() {
    return schoolIdentifier;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for school invalid address indicator.
   *
   * @return  Boolean
   */
  public Boolean getSchoolInvalidAddressIndicator() {
    return schoolInvalidAddressIndicator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for school maintenance date.
   *
   * @return  Date
   */
  public Date getSchoolMaintenanceDate() {
    return schoolMaintenanceDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for school maintenance ID.
   *
   * @return  String
   */
  public String getSchoolMaintenanceID() {
    return schoolMaintenanceID;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for school name.
   *
   * @return  String
   */
  public String getSchoolName() {
    return schoolName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for school phone area code.
   *
   * @return  String
   */
  public String getSchoolPhoneAreaCode() {
    return schoolPhoneAreaCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for school phone exchange.
   *
   * @return  String
   */
  public String getSchoolPhoneExchange() {
    return schoolPhoneExchange;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for school phone ext.
   *
   * @return  String
   */
  public String getSchoolPhoneExt() {
    return schoolPhoneExt;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for school state.
   *
   * @return  String
   */
  public String getSchoolState() {
    return schoolState;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for school status id.
   *
   * @return  Long
   */
  public Long getSchoolStatusId() {
    return schoolStatusId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for school type.
   *
   * @return  String
   */
  public String getSchoolType() {
    return schoolType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for school zip code.
   *
   * @return  String
   */
  public String getSchoolZipCode() {
    return schoolZipCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for school zip code ext.
   *
   * @return  String
   */
  public String getSchoolZipCodeExt() {
    return schoolZipCodeExt;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for system name.
   *
   * @return  String
   */
  public String getSystemName() {
    return systemName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for title IVEligibility flag.
   *
   * @return  String
   */
  public String getTitleIVEligibilityFlag() {
    return titleIVEligibilityFlag;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = super.hashCode();
    result = (prime * result)
      + ((this.schoolStatusId == null) ? 0 : this.schoolStatusId.hashCode());
    result = (prime * result)
      + ((this.schoolIdentifier == null) ? 0 : this.schoolIdentifier.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account details.
   *
   * @param  accountDetails  Set
   */
  public void setAccountDetails(Set<AccountDetail> accountDetails) {
    this.accountDetails = accountDetails;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for control switch.
   *
   * @param  controlSwitch  String
   */
  public void setControlSwitch(String controlSwitch) {
    this.controlSwitch = controlSwitch;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for distributed client type.
   *
   * @param  distributedClientType  String
   */
  public void setDistributedClientType(String distributedClientType) {
    this.distributedClientType = distributedClientType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for school address1.
   *
   * @param  schoolAddress1  String
   */
  public void setSchoolAddress1(String schoolAddress1) {
    this.schoolAddress1 = schoolAddress1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for school address2.
   *
   * @param  schoolAddress2  String
   */
  public void setSchoolAddress2(String schoolAddress2) {
    this.schoolAddress2 = schoolAddress2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for school address foreign indicator.
   *
   * @param  schoolAddressForeignIndicator  String
   */
  public void setSchoolAddressForeignIndicator(
    String schoolAddressForeignIndicator) {
    this.schoolAddressForeignIndicator = schoolAddressForeignIndicator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for school branch ID.
   *
   * @param  schoolBranchID  String
   */
  public void setSchoolBranchID(String schoolBranchID) {
    this.schoolBranchID = schoolBranchID;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for school city.
   *
   * @param  schoolCity  String
   */
  public void setSchoolCity(String schoolCity) {
    this.schoolCity = schoolCity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for school clearinghouse indicator.
   *
   * @param  schoolClearinghouseIndicator  Boolean
   */
  public void setSchoolClearinghouseIndicator(
    Boolean schoolClearinghouseIndicator) {
    this.schoolClearinghouseIndicator = schoolClearinghouseIndicator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for school close date.
   *
   * @param  schoolCloseDate  Date
   */
  public void setSchoolCloseDate(Date schoolCloseDate) {
    this.schoolCloseDate = schoolCloseDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for school contact first name.
   *
   * @param  schoolContactFirstName  String
   */
  public void setSchoolContactFirstName(String schoolContactFirstName) {
    this.schoolContactFirstName = schoolContactFirstName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for school contact last name.
   *
   * @param  schoolContactLastName  String
   */
  public void setSchoolContactLastName(String schoolContactLastName) {
    this.schoolContactLastName = schoolContactLastName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for school contact middle initial.
   *
   * @param  schoolContactMiddleInitial  String
   */
  public void setSchoolContactMiddleInitial(
    String schoolContactMiddleInitial) {
    this.schoolContactMiddleInitial = schoolContactMiddleInitial;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for school education dept num.
   *
   * @param  schoolEducationDeptNum  String
   */
  public void setSchoolEducationDeptNum(String schoolEducationDeptNum) {
    this.schoolEducationDeptNum = schoolEducationDeptNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for school FAOForeign address1.
   *
   * @param  schoolFAOForeignAddress1  String
   */
  public void setSchoolFAOForeignAddress1(String schoolFAOForeignAddress1) {
    this.schoolFAOForeignAddress1 = schoolFAOForeignAddress1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for school FAOForeign address2.
   *
   * @param  schoolFAOForeignAddress2  String
   */
  public void setSchoolFAOForeignAddress2(String schoolFAOForeignAddress2) {
    this.schoolFAOForeignAddress2 = schoolFAOForeignAddress2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for school FAOForeign address3.
   *
   * @param  schoolFAOForeignAddress3  String
   */
  public void setSchoolFAOForeignAddress3(String schoolFAOForeignAddress3) {
    this.schoolFAOForeignAddress3 = schoolFAOForeignAddress3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for school FAOForeign country.
   *
   * @param  schoolFAOForeignCountry  String
   */
  public void setSchoolFAOForeignCountry(String schoolFAOForeignCountry) {
    this.schoolFAOForeignCountry = schoolFAOForeignCountry;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for school FAOPhone area code.
   *
   * @param  schoolFAOPhoneAreaCode  String
   */
  public void setSchoolFAOPhoneAreaCode(String schoolFAOPhoneAreaCode) {
    this.schoolFAOPhoneAreaCode = schoolFAOPhoneAreaCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for school FAOPhone exchange.
   *
   * @param  schoolFAOPhoneExchange  String
   */
  public void setSchoolFAOPhoneExchange(String schoolFAOPhoneExchange) {
    this.schoolFAOPhoneExchange = schoolFAOPhoneExchange;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for school FAOPhone ext.
   *
   * @param  schoolFAOPhoneExt  String
   */
  public void setSchoolFAOPhoneExt(String schoolFAOPhoneExt) {
    this.schoolFAOPhoneExt = schoolFAOPhoneExt;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for school financial aid address1.
   *
   * @param  schoolFinancialAidAddress1  String
   */
  public void setSchoolFinancialAidAddress1(
    String schoolFinancialAidAddress1) {
    this.schoolFinancialAidAddress1 = schoolFinancialAidAddress1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for school financial aid address2.
   *
   * @param  schoolFinancialAidAddress2  String
   */
  public void setSchoolFinancialAidAddress2(
    String schoolFinancialAidAddress2) {
    this.schoolFinancialAidAddress2 = schoolFinancialAidAddress2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for school financial aid city.
   *
   * @param  schoolFinancialAidCity  String
   */
  public void setSchoolFinancialAidCity(String schoolFinancialAidCity) {
    this.schoolFinancialAidCity = schoolFinancialAidCity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for school financial aid state.
   *
   * @param  schoolFinancialAidState  String
   */
  public void setSchoolFinancialAidState(String schoolFinancialAidState) {
    this.schoolFinancialAidState = schoolFinancialAidState;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for school financial aid zip code.
   *
   * @param  schoolFinancialAidZipCode  String
   */
  public void setSchoolFinancialAidZipCode(String schoolFinancialAidZipCode) {
    this.schoolFinancialAidZipCode = schoolFinancialAidZipCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for school financial aid zip code ext.
   *
   * @param  schoolFinancialAidZipCodeExt  String
   */
  public void setSchoolFinancialAidZipCodeExt(
    String schoolFinancialAidZipCodeExt) {
    this.schoolFinancialAidZipCodeExt = schoolFinancialAidZipCodeExt;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for school foreign address1.
   *
   * @param  schoolForeignAddress1  String
   */
  public void setSchoolForeignAddress1(String schoolForeignAddress1) {
    this.schoolForeignAddress1 = schoolForeignAddress1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for school foreign address2.
   *
   * @param  schoolForeignAddress2  String
   */
  public void setSchoolForeignAddress2(String schoolForeignAddress2) {
    this.schoolForeignAddress2 = schoolForeignAddress2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for school foreign address3.
   *
   * @param  schoolForeignAddress3  String
   */
  public void setSchoolForeignAddress3(String schoolForeignAddress3) {
    this.schoolForeignAddress3 = schoolForeignAddress3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for school foreign country.
   *
   * @param  schoolForeignCountry  String
   */
  public void setSchoolForeignCountry(String schoolForeignCountry) {
    this.schoolForeignCountry = schoolForeignCountry;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for school id.
   *
   * @param  schoolId  String
   */
  public void setSchoolId(String schoolId) {
    this.schoolId = schoolId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for school identifier.
   *
   * @param  schoolIdentifier  String
   */
  public void setSchoolIdentifier(String schoolIdentifier) {
    this.schoolIdentifier = schoolIdentifier;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for school invalid address indicator.
   *
   * @param  schoolInvalidAddressIndicator  Boolean
   */
  public void setSchoolInvalidAddressIndicator(
    Boolean schoolInvalidAddressIndicator) {
    this.schoolInvalidAddressIndicator = schoolInvalidAddressIndicator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for school maintenance date.
   *
   * @param  schoolMaintenanceDate  Date
   */
  public void setSchoolMaintenanceDate(Date schoolMaintenanceDate) {
    this.schoolMaintenanceDate = schoolMaintenanceDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for school maintenance ID.
   *
   * @param  schoolMaintenanceID  String
   */
  public void setSchoolMaintenanceID(String schoolMaintenanceID) {
    this.schoolMaintenanceID = schoolMaintenanceID;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for school name.
   *
   * @param  schoolName  String
   */
  public void setSchoolName(String schoolName) {
    this.schoolName = schoolName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for school phone area code.
   *
   * @param  schoolPhoneAreaCode  String
   */
  public void setSchoolPhoneAreaCode(String schoolPhoneAreaCode) {
    this.schoolPhoneAreaCode = schoolPhoneAreaCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for school phone exchange.
   *
   * @param  schoolPhoneExchange  String
   */
  public void setSchoolPhoneExchange(String schoolPhoneExchange) {
    this.schoolPhoneExchange = schoolPhoneExchange;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for school phone ext.
   *
   * @param  schoolPhoneExt  String
   */
  public void setSchoolPhoneExt(String schoolPhoneExt) {
    this.schoolPhoneExt = schoolPhoneExt;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for school state.
   *
   * @param  schoolState  String
   */
  public void setSchoolState(String schoolState) {
    this.schoolState = schoolState;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for school status id.
   *
   * @param  schoolStatusId  Long
   */
  public void setSchoolStatusId(Long schoolStatusId) {
    this.schoolStatusId = schoolStatusId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for school type.
   *
   * @param  schoolType  String
   */
  public void setSchoolType(String schoolType) {
    this.schoolType = schoolType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for school zip code.
   *
   * @param  schoolZipCode  String
   */
  public void setSchoolZipCode(String schoolZipCode) {
    this.schoolZipCode = schoolZipCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for school zip code ext.
   *
   * @param  schoolZipCodeExt  String
   */
  public void setSchoolZipCodeExt(String schoolZipCodeExt) {
    this.schoolZipCodeExt = schoolZipCodeExt;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for system name.
   *
   * @param  systemName  String
   */
  public void setSystemName(String systemName) {
    this.systemName = systemName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for title IVEligibility flag.
   *
   * @param  titleIVEligibilityFlag  String
   */
  public void setTitleIVEligibilityFlag(String titleIVEligibilityFlag) {
    this.titleIVEligibilityFlag = titleIVEligibilityFlag;
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

    retValue.append("SlmSchoolStatus ( ").append("schoolIdentifier = ").append(this.schoolIdentifier).append(TAB)
      .append(
        "schoolStatusId = ").append(this.schoolStatusId).append(TAB).append(
      "schoolBranchID = ").append(this.schoolBranchID).append(TAB).append(
      "schoolName = ").append(this.schoolName).append(TAB).append(
      "schoolClearinghouseIndicator = ").append(
      this.schoolClearinghouseIndicator).append(TAB).append(
      "schoolAddressForeignIndicator = ").append(
      this.schoolAddressForeignIndicator).append(TAB).append(" )");

    return retValue.toString();
  }


} // end class SlmSchoolStatus
