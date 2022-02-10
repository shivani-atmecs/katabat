package com.cmc.credagility.core.domain.portfolio;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.contact.ContactResult;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * Created with IntelliJ IDEA. User: liaodongming Date: 13-3-29 Time: PM2:44 To change this template use File | Settings
 * | File Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */

@Entity
@Table(name = "PortfolioContactResultAccountLevelLimit")
public class PortfolioContactResultAccountLevelLimit extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "byCalendarDay",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean byCalendarDay = Boolean.FALSE;

  /** Portfolio PK portfolioId. */
  @JoinColumn(
    name       = "portfolioId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Portfolio portfolio;

  /** Contact result account level limit. */
  private Integer contactLimit;

  /** ContactResult PK contactResultId. */
  @JoinColumn(
    name       = "contactResultId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private ContactResult contactResult;
  @Column(
    name     = "contactResultLimitId",

    // unique = true,
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long      contactResultLimitId;

  @Column(name = "daysOfLimit")
  private Integer daysOfLimit;

  /** Contact result account level description. */
  @Column private String description;


  /** Contact result account level duration of limit. */
  private Integer durationOfLimit;

  /** Jurisdiction expression. */
  @Column(
    columnDefinition = "LONGTEXT",
    length           = 2147483647
  )
  @Lob private String jurisdictionExpression;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * equals.
   *
   * @param   o  Object
   *
   * @return  boolean
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof PortfolioContactResultAccountLevelLimit)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    PortfolioContactResultAccountLevelLimit that = (PortfolioContactResultAccountLevelLimit) o;

    if ((contactLimit != null) ? (!contactLimit.equals(that.contactLimit)) : (that.contactLimit != null)) {
      return false;
    }

    if ((contactResult != null) ? (!contactResult.equals(that.contactResult)) : (that.contactResult != null)) {
      return false;
    }

    if ((contactResultLimitId != null) ? (!contactResultLimitId.equals(that.contactResultLimitId))
                                       : (that.contactResultLimitId != null)) {
      return false;
    }

    if ((description != null) ? (!description.equals(that.description)) : (that.description != null)) {
      return false;
    }

    if ((durationOfLimit != null) ? (!durationOfLimit.equals(that.durationOfLimit)) : (that.durationOfLimit != null)) {
      return false;
    }

    if ((jurisdictionExpression != null) ? (!jurisdictionExpression.equals(that.jurisdictionExpression))
                                         : (that.jurisdictionExpression != null)) {
      return false;
    }

    if ((portfolio != null) ? (!portfolio.equals(that.portfolio)) : (that.portfolio != null)) {
      return false;
    }

    return true;
  } // end method equals

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
  public Integer getContactLimit() {
    return contactLimit;
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
  public Long getContactResultLimitId() {
    return contactResultLimitId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for days of limit.
   *
   * @return  Integer
   */
  public Integer getDaysOfLimit() {
    return daysOfLimit;
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
  public Integer getDurationOfLimit() {
    return durationOfLimit;
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
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((portfolio != null) ? portfolio.hashCode() : 0);
    result = (31 * result) + ((contactLimit != null) ? contactLimit.hashCode() : 0);
    result = (31 * result) + ((contactResult != null) ? contactResult.hashCode() : 0);
    result = (31 * result) + ((contactResultLimitId != null) ? contactResultLimitId.hashCode() : 0);
    result = (31 * result) + ((description != null) ? description.hashCode() : 0);
    result = (31 * result) + ((durationOfLimit != null) ? durationOfLimit.hashCode() : 0);
    result = (31 * result) + ((jurisdictionExpression != null) ? jurisdictionExpression.hashCode() : 0);

    return result;
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
   * @param  contactLimit  DOCUMENT ME!
   */
  public void setContactLimit(Integer contactLimit) {
    this.contactLimit = contactLimit;
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
   * @param  contactResultLimitId  DOCUMENT ME!
   */
  public void setContactResultLimitId(Long contactResultLimitId) {
    this.contactResultLimitId = contactResultLimitId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for days of limit.
   *
   * @param  daysOfLimit  Integer
   */
  public void setDaysOfLimit(Integer daysOfLimit) {
    this.daysOfLimit = daysOfLimit;
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
   * @param  durationOfLimit  DOCUMENT ME!
   */
  public void setDurationOfLimit(Integer durationOfLimit) {
    this.durationOfLimit = durationOfLimit;
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
   * DOCUMENT ME!
   *
   * @param   portfolioContactResultAccountLevelLimit  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PortfolioContactResultAccountLevelLimit update(
    PortfolioContactResultAccountLevelLimit portfolioContactResultAccountLevelLimit) {
    this.contactLimit    = portfolioContactResultAccountLevelLimit.getContactLimit();
    this.durationOfLimit = portfolioContactResultAccountLevelLimit.getDurationOfLimit();
    this.lastUpdateDate  = portfolioContactResultAccountLevelLimit.getLastUpdateDate();

    return this;
  }
} // end class PortfolioContactResultAccountLevelLimit
