package com.cmc.credagility.core.domain.payment;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  01/26/2015 14:41
 */
@Entity
@Table(
  name    = "RoutingNumber",
  indexes = {
    @Index(
      name = "idx_routingNumber",
      columnList = "routingNumber"
    )
  }
)
public class RoutingNumber extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 1149778121151035733L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "routingNumberId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long routingNumberId;

  @Column(
    name   = "address",
    length = 36
  )
  private String address;


  @Column(
    name   = "bankName",
    length = 36
  )
  private String bankName;

  @Column(name = "changeDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date changeDate;

  @Column(
    name   = "city",
    length = 20
  )
  private String city;

  @Column(
    name   = "dataViewCode",
    length = 1
  )
  private String dataViewCode;

  @Column(
    name   = "filler",
    length = 5
  )
  private String filler;

  @Column(
    name   = "institutionStatusCode",
    length = 1
  )
  private String institutionStatusCode;

  @Column(name = "newRoutingNumber",length = 255)
  private String newRoutingNumber;

  @Column(
    name   = "officeCode",
    length = 1
  )
  private String officeCode;

  @Column(
    name   = "recordTypeCode",
    length = 1
  )
  private String recordTypeCode;

  @Column(
    name     = "routingNumber",
      length = 255,
    nullable = false
  )
  private String routingNumber;

  @Column(
    name   = "servicingFRBNumber",
    length = 9
  )
  private String servicingFRBNumber;

  @Column(
    name   = "stateCode",
    length = 2
  )
  private String stateCode;


  @Column(
    name   = "telephoneAreaCode",
    length = 3
  )
  private String telephoneAreaCode;

  @Column(
    name   = "telephonePrefixNumber",
    length = 3
  )
  private String telephonePrefixNumber;

  @Column(
    name   = "telephoneSuffixNumber",
    length = 4
  )
  private String telephoneSuffixNumber;

  @Column(
    name   = "zipCode",
    length = 5
  )
  private String zipCode;

  @Column(
    name   = "zipCodeExtension",
    length = 4
  )
  private String zipCodeExtension;

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

    RoutingNumber that = (RoutingNumber) o;

    if ((routingNumber != null) ? (!routingNumber.equals(that.routingNumber)) : (that.routingNumber != null)) {
      return false;
    }

    if ((servicingFRBNumber != null) ? (!servicingFRBNumber.equals(that.servicingFRBNumber))
                                     : (that.servicingFRBNumber != null)) {
      return false;
    }

    if ((newRoutingNumber != null) ? (!newRoutingNumber.equals(that.newRoutingNumber))
                                   : (that.newRoutingNumber != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getAddress() {
    return address;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getBankName() {
    return bankName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getChangeDate() {
    return changeDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getCity() {
    return city;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDataViewCode() {
    return dataViewCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getFiller() {
    return filler;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getInstitutionStatusCode() {
    return institutionStatusCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getOfficeCode() {
    return officeCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getRecordTypeCode() {
    return recordTypeCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getStateCode() {
    return stateCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTelephoneAreaCode() {
    return telephoneAreaCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTelephonePrefixNumber() {
    return telephonePrefixNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTelephoneSuffixNumber() {
    return telephoneSuffixNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getZipCode() {
    return zipCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getZipCodeExtension() {
    return zipCodeExtension;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((routingNumber != null) ? routingNumber.hashCode() : 0);
    result = (31 * result) + ((servicingFRBNumber != null) ? servicingFRBNumber.hashCode() : 0);
    result = (31 * result) + ((newRoutingNumber != null) ? newRoutingNumber.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  address  DOCUMENT ME!
   */
  public void setAddress(String address) {
    this.address = address;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  bankName  DOCUMENT ME!
   */
  public void setBankName(String bankName) {
    this.bankName = bankName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  changeDate  DOCUMENT ME!
   */
  public void setChangeDate(Date changeDate) {
    this.changeDate = changeDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  city  DOCUMENT ME!
   */
  public void setCity(String city) {
    this.city = city;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  dataViewCode  DOCUMENT ME!
   */
  public void setDataViewCode(String dataViewCode) {
    this.dataViewCode = dataViewCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  filler  DOCUMENT ME!
   */
  public void setFiller(String filler) {
    this.filler = filler;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  institutionStatusCode  DOCUMENT ME!
   */
  public void setInstitutionStatusCode(String institutionStatusCode) {
    this.institutionStatusCode = institutionStatusCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  officeCode  DOCUMENT ME!
   */
  public void setOfficeCode(String officeCode) {
    this.officeCode = officeCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  recordTypeCode  DOCUMENT ME!
   */
  public void setRecordTypeCode(String recordTypeCode) {
    this.recordTypeCode = recordTypeCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  stateCode  DOCUMENT ME!
   */
  public void setStateCode(String stateCode) {
    this.stateCode = stateCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  telephoneAreaCode  DOCUMENT ME!
   */
  public void setTelephoneAreaCode(String telephoneAreaCode) {
    this.telephoneAreaCode = telephoneAreaCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  telephonePrefixNumber  DOCUMENT ME!
   */
  public void setTelephonePrefixNumber(String telephonePrefixNumber) {
    this.telephonePrefixNumber = telephonePrefixNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  telephoneSuffixNumber  DOCUMENT ME!
   */
  public void setTelephoneSuffixNumber(String telephoneSuffixNumber) {
    this.telephoneSuffixNumber = telephoneSuffixNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  zipCode  DOCUMENT ME!
   */
  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  zipCodeExtension  DOCUMENT ME!
   */
  public void setZipCodeExtension(String zipCodeExtension) {
    this.zipCodeExtension = zipCodeExtension;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#toString()
   */
  @Override public String toString() {
    return "RoutingNumber{"
      + "address='" + address + '\''
      + ", bankName='" + bankName + '\''
      + ", changeDate=" + changeDate
      + ", city='" + city + '\''
      + ", dataViewCode='" + dataViewCode + '\''
      + ", filler='" + filler + '\''
      + ", institutionStatusCode='" + institutionStatusCode + '\''
      + ", newRoutingNumber=" + newRoutingNumber
      + ", officeCode='" + officeCode + '\''
      + ", recordTypeCode='" + recordTypeCode + '\''
      + ", routingNumber=" + routingNumber
      + ", servicingFRBNumber=" + servicingFRBNumber
      + ", stateCode='" + stateCode + '\''
      + ", telephoneAreaCode='" + telephoneAreaCode + '\''
      + ", telephonePrefixNumber='" + telephonePrefixNumber + '\''
      + ", telephoneSuffixNumber='" + telephoneSuffixNumber + '\''
      + ", zipCode='" + zipCode + '\''
      + ", zipCodeExtension='" + zipCodeExtension + '\''
      + '}';
  }
} // end class RoutingNumber
