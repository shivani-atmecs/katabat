package com.cmc.credagility.core.domain.customer;

import com.cmc.credagility.core.domain.contact.GeneralContactPhone;
import com.cmc.credagility.core.domain.portfolio.PortfolioPhoneTypeDependency;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import java.util.Date;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/14/2014 16:23
 */
@MappedSuperclass public abstract class BaseCustomerPhone extends BaseCustomerContact implements GeneralContactPhone {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -7016819565055457092L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "countryCode",
    length = 3
  )
  protected String countryCode;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "doNotCall",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean doNotCall = Boolean.FALSE;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "lastDialerExportDate",
    nullable = true
  )
  protected Date lastDialerExportDate;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "nextEligibleCallDate",
    nullable = true
  )
  protected Date nextEligibleCallDate;

  /** TODO: DOCUMENT ME! */
  protected String nextEligibleReason;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "phoneTypeDependencyId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PortfolioPhoneTypeDependency phoneTypeDependency;

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
   * getter method for do not call.
   *
   * @return  Boolean
   */
  public Boolean getDoNotCall() {
    return doNotCall;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last dialer export date.
   *
   * @return  Date
   */
  public Date getLastDialerExportDate() {
    return lastDialerExportDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for next eligible call date.
   *
   * @return  Date
   */
  public Date getNextEligibleCallDate() {
    return nextEligibleCallDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for next eligible reason.
   *
   * @return  String
   */
  public String getNextEligibleReason() {
    return nextEligibleReason;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for phone type dependency.
   *
   * @return  PortfolioPhoneTypeDependency
   */
  public PortfolioPhoneTypeDependency getPhoneTypeDependency() {
    return phoneTypeDependency;
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
   * setter method for do not call.
   *
   * @param  doNotCall  Boolean
   */
  @Override public void setDoNotCall(Boolean doNotCall) {
    this.doNotCall = doNotCall;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last dialer export date.
   *
   * @param  lastDialerExportDate  Date
   */
  public void setLastDialerExportDate(Date lastDialerExportDate) {
    this.lastDialerExportDate = lastDialerExportDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for next eligible call date.
   *
   * @param  nextEligibleCallDate  Date
   */
  public void setNextEligibleCallDate(Date nextEligibleCallDate) {
    this.nextEligibleCallDate = nextEligibleCallDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for next eligible reason.
   *
   * @param  nextEligibleReason  String
   */
  public void setNextEligibleReason(String nextEligibleReason) {
    this.nextEligibleReason = nextEligibleReason;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for phone type dependency.
   *
   * @param  phoneTypeDependency  PortfolioPhoneTypeDependency
   */
  @Override public void setPhoneTypeDependency(PortfolioPhoneTypeDependency phoneTypeDependency) {
    this.phoneTypeDependency = phoneTypeDependency;
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
} // end class BaseCustomerPhone
