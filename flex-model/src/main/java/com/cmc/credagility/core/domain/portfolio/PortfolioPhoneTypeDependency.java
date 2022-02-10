package com.cmc.credagility.core.domain.portfolio;

import com.cmc.credagility.core.domain.base.CreatorEntity;
import com.cmc.credagility.core.domain.contact.ContactResult;
import com.cmc.credagility.core.domain.contact.PhoneType;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.el.ExpressionObject;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * Created with IntelliJ IDEA. User: cyberwym Date: 4/16/13 Time: 12:21 PM To change this template use File | Settings |
 * File Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity public class PortfolioPhoneTypeDependency extends CreatorEntity implements ExpressionObject {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Phone type dependency calendar days. */
  @Column(name = "calendarDays")
  private Integer calendarDays;


  /** ContactResult PK dependingContactResultId. */
  @JoinColumn(
    name       = "dependingContactResultId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.EAGER)
  private ContactResult dependingContactResult;

  /** PhoneType PK dependingPhoneType. */
  @JoinColumn(
    name       = "dependingPhoneTypeId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.EAGER)
  private PhoneType dependingPhoneType;

  /** Phone type dependency description. */
  @Column(
    name   = "description",
    length = 200
  )
  private String description;

  /** <code>true</code> allow do not contact. */
  @Column(
    name             = "doNotContact",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean doNotContact;

  /** The reason of the do not contact. */
  @Column(
    name   = "doNotContactReason",
    length = 200
  )
  private String doNotContactReason;

  @Column(
    name     = "id", /*unique = true,*/
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long id;


  /** Jurisdiction expression. */
  @Column(
    columnDefinition = "LONGTEXT",
    length           = 2147483647
  )
  @Lob private String jurisdictionExpression;

  /** Portfolio PK portfolioId. */
  @JoinColumn(
    name       = "portfolioId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private Portfolio portfolio;

  @Column(name = "priority")
  private Integer priority;

  /** Phone type dependency query sql. */
  @Column(
    name     = "querySql",
    nullable = true,
    length   = 10000
  )
  private String query;

  /** PhoneType PK targetPhoneTypeId. */
  @JoinColumn(
    name       = "targetPhoneTypeId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.EAGER)
  private PhoneType targetPhoneType;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof PortfolioPhoneTypeDependency)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    PortfolioPhoneTypeDependency that = (PortfolioPhoneTypeDependency) o;

    if ((calendarDays != null) ? (!calendarDays.equals(that.calendarDays)) : (that.calendarDays != null)) {
      return false;
    }

    if ((dependingContactResult != null) ? (!dependingContactResult.equals(that.dependingContactResult))
                                         : (that.dependingContactResult != null)) {
      return false;
    }

    if ((dependingPhoneType != null) ? (!dependingPhoneType.equals(that.dependingPhoneType))
                                     : (that.dependingPhoneType != null)) {
      return false;
    }

    if ((description != null) ? (!description.equals(that.description)) : (that.description != null)) {
      return false;
    }

    if ((doNotContact != null) ? (!doNotContact.equals(that.doNotContact)) : (that.doNotContact != null)) {
      return false;
    }

    if ((doNotContactReason != null) ? (!doNotContactReason.equals(that.doNotContactReason))
                                     : (that.doNotContactReason != null)) {
      return false;
    }

    if ((jurisdictionExpression != null) ? (!jurisdictionExpression.equals(that.jurisdictionExpression))
                                         : (that.jurisdictionExpression != null)) {
      return false;
    }

    if ((portfolio != null) ? (!portfolio.equals(that.portfolio)) : (that.portfolio != null)) {
      return false;
    }

    if ((query != null) ? (!query.equals(that.query)) : (that.query != null)) {
      return false;
    }

    if ((targetPhoneType != null) ? (!targetPhoneType.equals(that.targetPhoneType)) : (that.targetPhoneType != null)) {
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
  public Integer getCalendarDays() {
    return calendarDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public ContactResult getDependingContactResult() {
    return dependingContactResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PhoneType getDependingPhoneType() {
    return dependingPhoneType;
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
  public Boolean getDoNotContact() {
    return doNotContact;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDoNotContactReason() {
    return doNotContactReason;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.el.ExpressionObject#getExpression()
   */
  @Override @Transient public String getExpression() {
    return this.getJurisdictionExpression(); // To change body of implemented methods use File | Settings | File Templates.
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getId() {
    return id;
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
  public Portfolio getPortfolio() {
    return portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for priority.
   *
   * @return  Integer
   */
  public Integer getPriority() {
    return priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getQuery() {
    return query;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PhoneType getTargetPhoneType() {
    return targetPhoneType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((calendarDays != null) ? calendarDays.hashCode() : 0);
    result = (31 * result) + ((dependingContactResult != null) ? dependingContactResult.hashCode() : 0);
    result = (31 * result) + ((dependingPhoneType != null) ? dependingPhoneType.hashCode() : 0);
    result = (31 * result) + ((description != null) ? description.hashCode() : 0);
    result = (31 * result) + ((doNotContact != null) ? doNotContact.hashCode() : 0);
    result = (31 * result) + ((doNotContactReason != null) ? doNotContactReason.hashCode() : 0);
    result = (31 * result) + ((jurisdictionExpression != null) ? jurisdictionExpression.hashCode() : 0);
    result = (31 * result) + ((portfolio != null) ? portfolio.hashCode() : 0);
    result = (31 * result) + ((query != null) ? query.hashCode() : 0);
    result = (31 * result) + ((targetPhoneType != null) ? targetPhoneType.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  calendarDays  DOCUMENT ME!
   */
  public void setCalendarDays(Integer calendarDays) {
    this.calendarDays = calendarDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  dependingContactResult  DOCUMENT ME!
   */
  public void setDependingContactResult(ContactResult dependingContactResult) {
    this.dependingContactResult = dependingContactResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  dependingPhoneType  DOCUMENT ME!
   */
  public void setDependingPhoneType(PhoneType dependingPhoneType) {
    this.dependingPhoneType = dependingPhoneType;
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
   * @param  doNotContact  DOCUMENT ME!
   */
  public void setDoNotContact(Boolean doNotContact) {
    this.doNotContact = doNotContact;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  doNotContactReason  DOCUMENT ME!
   */
  public void setDoNotContactReason(String doNotContactReason) {
    this.doNotContactReason = doNotContactReason;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  id  DOCUMENT ME!
   */
  public void setId(Long id) {
    this.id = id;
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
   * @param  portfolio  DOCUMENT ME!
   */
  public void setPortfolio(Portfolio portfolio) {
    this.portfolio = portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for priority.
   *
   * @param  priority  Integer
   */
  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  query  DOCUMENT ME!
   */
  public void setQuery(String query) {
    this.query = query;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  targetPhoneType  DOCUMENT ME!
   */
  public void setTargetPhoneType(PhoneType targetPhoneType) {
    this.targetPhoneType = targetPhoneType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  value  DOCUMENT ME!
   */
  @Override public void setValue(Object value) {
    // todo
  }
} // end class PortfolioPhoneTypeDependency
