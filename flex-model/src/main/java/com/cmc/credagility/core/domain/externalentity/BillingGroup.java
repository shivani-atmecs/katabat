package com.cmc.credagility.core.domain.externalentity;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/15/2014 13:24
 */
@Entity
@Table(name = "BillingGroup")
public class BillingGroup extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean activeStatus = true;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "commissionRate",
    precision = 19,
    scale     = 3
  )
  protected BigDecimal commissionRate;


  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 2147483647,
    columnDefinition = "LONGTEXT"
  )
  protected String criteria;


  /** TODO: DOCUMENT ME! */
  @Column(name = "disableDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date disableDate;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "externalEntityId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected ExternalEntity externalEntity;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "initialSalesPriceRate",
    precision = 19,
    scale     = 3
  )
  protected BigDecimal initialSalesPriceRate;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "name",
    length = 100
  )
  protected String name;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "portfolioId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected Portfolio portfolio = new Portfolio();


  /** TODO: DOCUMENT ME! */
  @Column(name = "priority")
  protected Long priority = 1L;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "proRataRetentionRate",
    precision = 19,
    scale     = 3
  )
  protected BigDecimal proRataRetentionRate;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "proRataSalesPriceRate",
    precision = 19,
    scale     = 3
  )
  protected BigDecimal proRataSalesPriceRate;


  /** TODO: DOCUMENT ME! */
  @Column(name = "releasePeriod")
  protected Long releasePeriod;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "residualCommissionRate ",
    precision = 19,
    scale     = 3
  )
  protected BigDecimal residualCommissionRate;


  /** TODO: DOCUMENT ME! */
  @Column(name = "ruleEffectiveDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date ruleEffectiveDate;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "ruleType",
    length = 100
  )
  protected String ruleType;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "salesRate",
    precision = 19,
    scale     = 3
  )
  protected BigDecimal salesRate;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long id;

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

    BillingGroup that = (BillingGroup) o;

    if ((activeStatus != null) ? (!activeStatus.equals(that.activeStatus)) : (that.activeStatus != null)) {
      return false;
    }

    if ((commissionRate != null) ? (!commissionRate.equals(that.commissionRate)) : (that.commissionRate != null)) {
      return false;
    }

    if ((ruleEffectiveDate != null) ? (!ruleEffectiveDate.equals(that.ruleEffectiveDate))
                                    : (that.ruleEffectiveDate != null)) {
      return false;
    }

    if ((criteria != null) ? (!criteria.equals(that.criteria)) : (that.criteria != null)) {
      return false;
    }

    if ((disableDate != null) ? (!disableDate.equals(that.disableDate)) : (that.disableDate != null)) {
      return false;
    }

    if ((externalEntity != null) ? (!externalEntity.equals(that.externalEntity)) : (that.externalEntity != null)) {
      return false;
    }

    if ((initialSalesPriceRate != null) ? (!initialSalesPriceRate.equals(that.initialSalesPriceRate))
                                        : (that.initialSalesPriceRate != null)) {
      return false;
    }

    if ((name != null) ? (!name.equals(that.name)) : (that.name != null)) {
      return false;
    }

    if ((portfolio != null) ? (!portfolio.equals(that.portfolio)) : (that.portfolio != null)) {
      return false;
    }

    if ((priority != null) ? (!priority.equals(that.priority)) : (that.priority != null)) {
      return false;
    }

    if ((proRataRetentionRate != null) ? (!proRataRetentionRate.equals(that.proRataRetentionRate))
                                       : (that.proRataRetentionRate != null)) {
      return false;
    }

    if ((proRataSalesPriceRate != null) ? (!proRataSalesPriceRate.equals(that.proRataSalesPriceRate))
                                        : (that.proRataSalesPriceRate != null)) {
      return false;
    }

    if ((releasePeriod != null) ? (!releasePeriod.equals(that.releasePeriod)) : (that.releasePeriod != null)) {
      return false;
    }

    if ((residualCommissionRate != null) ? (!residualCommissionRate.equals(that.residualCommissionRate))
                                         : (that.residualCommissionRate != null)) {
      return false;
    }

    if ((ruleType != null) ? (!ruleType.equals(that.ruleType)) : (that.ruleType != null)) {
      return false;
    }

    if ((salesRate != null) ? (!salesRate.equals(that.salesRate)) : (that.salesRate != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for active status.
   *
   * @return  Boolean
   */
  public Boolean getActiveStatus() {
    return activeStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for commission rate.
   *
   * @return  BigDecimal
   */
  public BigDecimal getCommissionRate() {
    return commissionRate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for criteria.
   *
   * @return  String
   */
  public String getCriteria() {
    return criteria;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for disable date.
   *
   * @return  Date
   */
  public Date getDisableDate() {
    return disableDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for external entity.
   *
   * @return  ExternalEntity
   */
  public ExternalEntity getExternalEntity() {
    return externalEntity;
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
   * getter method for initial sales price rate.
   *
   * @return  BigDecimal
   */
  public BigDecimal getInitialSalesPriceRate() {
    return initialSalesPriceRate;
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
   * getter method for portfolio.
   *
   * @return  Portfolio
   */
  public Portfolio getPortfolio() {
    return portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for priority.
   *
   * @return  Long
   */
  public Long getPriority() {
    return priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for pro rata retention rate.
   *
   * @return  BigDecimal
   */
  public BigDecimal getProRataRetentionRate() {
    return proRataRetentionRate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for pro rata sales price rate.
   *
   * @return  BigDecimal
   */
  public BigDecimal getProRataSalesPriceRate() {
    return proRataSalesPriceRate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for release period.
   *
   * @return  Long
   */
  public Long getReleasePeriod() {
    return releasePeriod;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for residual commission rate.
   *
   * @return  BigDecimal
   */
  public BigDecimal getResidualCommissionRate() {
    return residualCommissionRate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for rule effective date.
   *
   * @return  Date
   */
  public Date getRuleEffectiveDate() {
    return ruleEffectiveDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for rule type.
   *
   * @return  String
   */
  public String getRuleType() {
    return ruleType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for sales rate.
   *
   * @return  BigDecimal
   */
  public BigDecimal getSalesRate() {
    return salesRate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((activeStatus != null) ? activeStatus.hashCode() : 0);
    result = (31 * result) + ((commissionRate != null) ? commissionRate.hashCode() : 0);
    result = (31 * result) + ((ruleEffectiveDate != null) ? ruleEffectiveDate.hashCode() : 0);
    result = (31 * result) + ((criteria != null) ? criteria.hashCode() : 0);
    result = (31 * result) + ((disableDate != null) ? disableDate.hashCode() : 0);
    result = (31 * result) + ((externalEntity != null) ? externalEntity.hashCode() : 0);
    result = (31 * result) + ((initialSalesPriceRate != null) ? initialSalesPriceRate.hashCode() : 0);
    result = (31 * result) + ((name != null) ? name.hashCode() : 0);
    result = (31 * result) + ((portfolio != null) ? portfolio.hashCode() : 0);
    result = (31 * result) + ((priority != null) ? priority.hashCode() : 0);
    result = (31 * result) + ((proRataRetentionRate != null) ? proRataRetentionRate.hashCode() : 0);
    result = (31 * result) + ((proRataSalesPriceRate != null) ? proRataSalesPriceRate.hashCode() : 0);
    result = (31 * result) + ((releasePeriod != null) ? releasePeriod.hashCode() : 0);
    result = (31 * result) + ((residualCommissionRate != null) ? residualCommissionRate.hashCode() : 0);
    result = (31 * result) + ((ruleType != null) ? ruleType.hashCode() : 0);
    result = (31 * result) + ((salesRate != null) ? salesRate.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for active status.
   *
   * @param  activeStatus  Boolean
   */
  public void setActiveStatus(Boolean activeStatus) {
    this.activeStatus = activeStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for commission rate.
   *
   * @param  commissionRate  BigDecimal
   */
  public void setCommissionRate(BigDecimal commissionRate) {
    this.commissionRate = commissionRate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for criteria.
   *
   * @param  criteria  String
   */
  public void setCriteria(String criteria) {
    this.criteria = criteria;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for disable date.
   *
   * @param  disableDate  Date
   */
  public void setDisableDate(Date disableDate) {
    this.disableDate = disableDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for external entity.
   *
   * @param  externalEntity  ExternalEntity
   */
  public void setExternalEntity(ExternalEntity externalEntity) {
    this.externalEntity = externalEntity;
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
   * setter method for initial sales price rate.
   *
   * @param  initialSalesPriceRate  BigDecimal
   */
  public void setInitialSalesPriceRate(BigDecimal initialSalesPriceRate) {
    this.initialSalesPriceRate = initialSalesPriceRate;
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
   * setter method for portfolio.
   *
   * @param  portfolio  Portfolio
   */
  public void setPortfolio(Portfolio portfolio) {
    this.portfolio = portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for priority.
   *
   * @param  priority  Long
   */
  public void setPriority(Long priority) {
    this.priority = priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for pro rata retention rate.
   *
   * @param  proRataRetentionRate  BigDecimal
   */
  public void setProRataRetentionRate(BigDecimal proRataRetentionRate) {
    this.proRataRetentionRate = proRataRetentionRate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for pro rata sales price rate.
   *
   * @param  proRataSalesPriceRate  BigDecimal
   */
  public void setProRataSalesPriceRate(BigDecimal proRataSalesPriceRate) {
    this.proRataSalesPriceRate = proRataSalesPriceRate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for release period.
   *
   * @param  releasePeriod  Long
   */
  public void setReleasePeriod(Long releasePeriod) {
    this.releasePeriod = releasePeriod;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for residual commission rate.
   *
   * @param  residualCommissionRate  BigDecimal
   */
  public void setResidualCommissionRate(BigDecimal residualCommissionRate) {
    this.residualCommissionRate = residualCommissionRate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for rule effective date.
   *
   * @param  ruleEffectiveDate  Date
   */
  public void setRuleEffectiveDate(Date ruleEffectiveDate) {
    this.ruleEffectiveDate = ruleEffectiveDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for rule type.
   *
   * @param  ruleType  String
   */
  public void setRuleType(String ruleType) {
    this.ruleType = ruleType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for sales rate.
   *
   * @param  salesRate  BigDecimal
   */
  public void setSalesRate(BigDecimal salesRate) {
    this.salesRate = salesRate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#toString()
   */
  @Override public String toString() {
    return "BillingGroup{"
      + "activeStatus=" + activeStatus
      + ", commissionRate=" + commissionRate
      + ", criteria='" + criteria + '\''
      + ", disableDate=" + disableDate
      + ", initialSalesPriceRate=" + initialSalesPriceRate
      + ", name='" + name + '\''
      + ", priority=" + priority
      + ", proRataRetentionRate=" + proRataRetentionRate
      + ", proRataSalesPriceRate=" + proRataSalesPriceRate
      + ", releasePeriod=" + releasePeriod
      + ", residualCommissionRate=" + residualCommissionRate
      + ", ruleEffectiveDate=" + ruleEffectiveDate
      + ", ruleType='" + ruleType + '\''
      + ", salesRate=" + salesRate
      + ", id=" + id
      + '}';
  }

} // end class BillingGroup
