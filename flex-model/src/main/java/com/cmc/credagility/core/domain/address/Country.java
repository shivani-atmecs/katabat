package com.cmc.credagility.core.domain.address;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/17/2014 10:17
 */
@Entity
@Table(name = "Country")
public class Country extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -7104116290152830302L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "countryCode",
    length = 10
  )
  protected String countryCode;

  /** Document PK. */
  @Column(
    unique   = true,
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long countryId;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "name",
    length = 100
  )
  protected String name;

  /** DOCUMENT ME! */
  @Column(
    name   = "paymentVendorIdentifier ",
    length = 50
  )
  protected String paymentVendorIdentifier;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "telephoneCountryCode",
    length = 10
  )
  protected String telephoneCountryCode;

  //~ Methods ----------------------------------------------------------------------------------------------------------

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
   * getter method for country id.
   *
   * @return  Long
   */
  public Long getCountryId() {
    return countryId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for name.
   *
   * @return  String
   */
  public String getName() {
    return name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPaymentVendorIdentifier() {
    return paymentVendorIdentifier;
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
   * setter method for country code.
   *
   * @param  countryCode  String
   */
  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for country id.
   *
   * @param  countryId  Long
   */
  public void setCountryId(Long countryId) {
    this.countryId = countryId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for name.
   *
   * @param  name  String
   */
  public void setName(String name) {
    this.name = name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentVendorIdentifier  DOCUMENT ME!
   */
  public void setPaymentVendorIdentifier(String paymentVendorIdentifier) {
    this.paymentVendorIdentifier = paymentVendorIdentifier;
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
} // end class Country
