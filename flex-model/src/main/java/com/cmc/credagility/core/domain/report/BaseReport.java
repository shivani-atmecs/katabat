package com.cmc.credagility.core.domain.report;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.portfolio.Portfolio;


/**
 * Base Report Class.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  10/20/2014 17:57 PM
 */
@MappedSuperclass public abstract class BaseReport extends BaseEntity implements Serializable {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  @JoinColumn(
    name      = "portfolioId",
    updatable = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected Portfolio portfolio;

  /** DOCUMENT ME! */
  @Column
  @Temporal(TemporalType.TIMESTAMP)
  protected Date         reportDate;

  /** DOCUMENT ME! */
  @Column(
    unique   = true,
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long reportId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    final BaseReport other = (BaseReport) obj;

    if ((this.portfolio != other.portfolio)
          && ((this.portfolio == null) || !this.portfolio.equals(other.portfolio))) {
      return false;
    }

    if ((this.reportDate != other.reportDate)
          && ((this.reportDate == null) || !this.reportDate.equals(other.reportDate))) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the portfolio for the account.
   *
   * @return  the portfolio
   *
   *          <p>lazy = "false" column = "portfolioId" not-null = "true" class = "com.cmc.model.Portfolio" insert =
   *          "true" update = "false"</p>
   */
  public Portfolio getPortfolio() {
    return portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   *          <p>not-null = "false"</p>
   */
  public Date getReportDate() {
    return reportDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Report ID, PK.
   *
   * @return  report ID, PK
   *
   *          <p>generator-class = "native" unsaved-value = "null"</p>
   */
  public Long getReportId() {
    return reportId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    int hash = 7;
    hash = (89 * hash) + ((this.portfolio != null) ? this.portfolio.hashCode() : 0);
    hash = (89 * hash)
      + ((this.reportDate != null) ? this.reportDate.hashCode() : 0);

    return hash;
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
   * @param  reportDate  DOCUMENT ME!
   */
  public void setReportDate(Date reportDate) {
    this.reportDate = reportDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  reportId  DOCUMENT ME!
   */
  public void setReportId(Long reportId) {
    this.reportId = reportId;
  }
} // end class BaseReport
