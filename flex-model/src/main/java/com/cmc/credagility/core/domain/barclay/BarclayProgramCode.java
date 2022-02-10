package com.cmc.credagility.core.domain.barclay;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.portfolio.Portfolio;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 10:32
 */
@Entity
@Table(name = "BarclayProgramCode")
public class BarclayProgramCode extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "barclayProgramCodeId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long barclayProgramCodeId;


  /** TODO: DOCUMENT ME! */
  @Column(
    length = 10,
    name   = "dmActionCode"
  )
  protected String dmActionCode;

  /** TODO: DOCUMENT ME! */
  @Column(
    length = 10,
    name   = "earlyPayRule"
  )
  protected String earlyPayRule;

  /** TODO: DOCUMENT ME! */
  @Column(
    length = 10,
    name   = "fipCode"
  )
  protected String fipCode;

  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "minArrearsToBreak",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal minArrearsToBreak;

  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "minKeptPercentage",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal minKeptPercentage;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "portfolioId",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Portfolio portfolio;

  /** TODO: DOCUMENT ME! */
  @Column(name = "reversalDays")
  protected Integer reversalDays;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "templateDescription",
    length = 250
  )
  protected String templateDescription;

  /** TODO: DOCUMENT ME! */
  @Column(name = "toleranceDays")
  protected Integer toleranceDays;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (!super.equals(obj)) {
      return false;

    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    final BarclayProgramCode other = (BarclayProgramCode) obj;

    if (portfolio == null) {
      if (other.getPortfolio() != null) {
        return false;
      }
    } else if (!portfolio.getPortfolioId().equals(
            other.getPortfolio().getPortfolioId())) {
      return false;
    }

    if (barclayProgramCodeId == null) {
      if (other.getBarclayProgramCodeId() != null) {
        return false;
      }
    } else if (!barclayProgramCodeId.equals(other.getBarclayProgramCodeId())) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for barclay program code id.
   *
   * @return  Long
   */
  public Long getBarclayProgramCodeId() {
    return barclayProgramCodeId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for dm action code.
   *
   * @return  String
   */
  public String getDmActionCode() {
    return dmActionCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for early pay rule.
   *
   * @return  String
   */
  public String getEarlyPayRule() {
    return earlyPayRule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for fip code.
   *
   * @return  String
   */
  public String getFipCode() {
    return fipCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for min arrears to break.
   *
   * @return  BigDecimal
   */
  public BigDecimal getMinArrearsToBreak() {
    return minArrearsToBreak;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for min kept percentage.
   *
   * @return  BigDecimal
   */
  public BigDecimal getMinKeptPercentage() {
    return minKeptPercentage;
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
   * getter method for reversal days.
   *
   * @return  Integer
   */
  public Integer getReversalDays() {
    return reversalDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for template description.
   *
   * @return  String
   */
  public String getTemplateDescription() {
    return templateDescription;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for tolerance days.
   *
   * @return  Integer
   */
  public Integer getToleranceDays() {
    return toleranceDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = super.hashCode();
    result = (prime * result);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for barclay program code id.
   *
   * @param  barclayProgramCodeId  Long
   */
  public void setBarclayProgramCodeId(Long barclayProgramCodeId) {
    this.barclayProgramCodeId = barclayProgramCodeId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for dm action code.
   *
   * @param  dmActionCode  String
   */
  public void setDmActionCode(String dmActionCode) {
    this.dmActionCode = dmActionCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for early pay rule.
   *
   * @param  earlyPayRule  String
   */
  public void setEarlyPayRule(String earlyPayRule) {
    this.earlyPayRule = earlyPayRule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for fip code.
   *
   * @param  fipCode  String
   */
  public void setFipCode(String fipCode) {
    this.fipCode = fipCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for min arrears to break.
   *
   * @param  minArrearsToBreak  BigDecimal
   */
  public void setMinArrearsToBreak(BigDecimal minArrearsToBreak) {
    this.minArrearsToBreak = minArrearsToBreak;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for min kept percentage.
   *
   * @param  minKeptPercentage  BigDecimal
   */
  public void setMinKeptPercentage(BigDecimal minKeptPercentage) {
    this.minKeptPercentage = minKeptPercentage;
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
   * setter method for reversal days.
   *
   * @param  reversalDays  Integer
   */
  public void setReversalDays(Integer reversalDays) {
    this.reversalDays = reversalDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for template description.
   *
   * @param  templateDescription  String
   */
  public void setTemplateDescription(String templateDescription) {
    this.templateDescription = templateDescription;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for tolerance days.
   *
   * @param  toleranceDays  Integer
   */
  public void setToleranceDays(Integer toleranceDays) {
    this.toleranceDays = toleranceDays;
  }
} // end class BarclayProgramCode
