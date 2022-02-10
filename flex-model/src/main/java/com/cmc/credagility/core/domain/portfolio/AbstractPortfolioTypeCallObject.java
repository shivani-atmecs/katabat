package com.cmc.credagility.core.domain.portfolio;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.cmc.credagility.core.domain.base.CreatorEntity;
import com.cmc.credagility.core.domain.contact.ContactResult;
import com.cmc.credagility.core.domain.contact.PhoneType;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * Created with IntelliJ IDEA. User: liaodongming Date: 13-3-29 Time: PM3:07 To change this template use File | Settings
 * | File Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@MappedSuperclass public abstract class AbstractPortfolioTypeCallObject extends CreatorEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  @Column(
    name             = "active",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean active = Boolean.TRUE;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "byCalendarDay",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean byCalendarDay = Boolean.FALSE;

  /** DOCUMENT ME! */
  @JoinColumn(
    name       = "contactResultId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected ContactResult contactResult;


  /** DOCUMENT ME! */
  @Column protected String description;

  /** Jurisdiction expression. */
  @Column(
    columnDefinition = "LONGTEXT",
    length           = 2147483647
  )
  @Lob protected String jurisdictionExpression;

  /** DOCUMENT ME! */
  @JoinColumn(
    name       = "phoneTypeId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PhoneType phoneType;

  /** DOCUMENT ME! */
  @JoinColumn(
    name       = "portfolioId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Portfolio portfolio;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getActive() {
    return active;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for by calendar day.
   *
   * @return  Boolean
   */
  public Boolean getByCalendarDay() {
    return byCalendarDay;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public ContactResult getContactResult() {
    return contactResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDescription() {
    return description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getJurisdictionExpression() {
    return jurisdictionExpression;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PhoneType getPhoneType() {
    return phoneType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Portfolio getPortfolio() {
    return portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  active  DOCUMENT ME!
   */
  public void setActive(Boolean active) {
    this.active = active;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for by calendar day.
   *
   * @param  byCalendarDay  Boolean
   */
  public void setByCalendarDay(Boolean byCalendarDay) {
    this.byCalendarDay = byCalendarDay;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  contactResult  DOCUMENT ME!
   */
  public void setContactResult(ContactResult contactResult) {
    this.contactResult = contactResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  description  DOCUMENT ME!
   */
  public void setDescription(String description) {
    this.description = description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  jurisdictionExpression  DOCUMENT ME!
   */
  public void setJurisdictionExpression(String jurisdictionExpression) {
    this.jurisdictionExpression = jurisdictionExpression;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  phoneType  DOCUMENT ME!
   */
  public void setPhoneType(PhoneType phoneType) {
    this.phoneType = phoneType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  portfolio  DOCUMENT ME!
   */
  public void setPortfolio(Portfolio portfolio) {
    this.portfolio = portfolio;
  }
} // end class AbstractPortfolioTypeCallObject
