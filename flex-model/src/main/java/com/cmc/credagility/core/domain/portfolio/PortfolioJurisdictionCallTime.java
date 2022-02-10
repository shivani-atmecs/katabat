package com.cmc.credagility.core.domain.portfolio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.cmc.credagility.core.domain.base.BaseEntity;

import com.ozstrategy.credagility.core.el.ExpressionObject;


/**
 * Created with IntelliJ IDEA. User: cyberwym Date: 4/3/13 Time: 11:21 AM To change this template use File | Settings |
 * File Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity public class PortfolioJurisdictionCallTime extends BaseEntity implements ExpressionObject {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 1954091858735893148L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Jurisdiction call time description. */
  @Column private String description;

  /** Jurisdiction call end time. */
  @Column(name = "endCallTime")
  @Temporal(TemporalType.TIME)
  private Date endCallTime;

  /** Primary Key. */
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
    updatable  = false,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private Portfolio portfolio = new Portfolio();

  /** Jurisdiction call start time. */
  @Column(name = "startCallTime")
  @Temporal(TemporalType.TIME)
  private Date startCallTime;

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

    if (!(o instanceof PortfolioJurisdictionCallTime)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    PortfolioJurisdictionCallTime that = (PortfolioJurisdictionCallTime) o;

    if ((description != null) ? (!description.equals(that.description)) : (that.description != null)) {
      return false;
    }

    if ((endCallTime != null) ? (!endCallTime.equals(that.endCallTime)) : (that.endCallTime != null)) {
      return false;
    }

    if ((jurisdictionExpression != null) ? (!jurisdictionExpression.equals(that.jurisdictionExpression))
                                         : (that.jurisdictionExpression != null)) {
      return false;
    }

    if ((startCallTime != null) ? (!startCallTime.equals(that.startCallTime)) : (that.startCallTime != null)) {
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
  public String getDescription() {
    return description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getEndCallTime() {
    return endCallTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for expression.
   *
   * @return  String
   */
  @Override @Transient public String getExpression() {
    return this.getJurisdictionExpression();
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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getStartCallTime() {
    return startCallTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((description != null) ? description.hashCode() : 0);
    result = (31 * result) + ((endCallTime != null) ? endCallTime.hashCode() : 0);
    result = (31 * result) + ((jurisdictionExpression != null) ? jurisdictionExpression.hashCode() : 0);
    result = (31 * result) + ((startCallTime != null) ? startCallTime.hashCode() : 0);

    return result;
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
   * @param  endCallTime  DOCUMENT ME!
   */
  public void setEndCallTime(Date endCallTime) {
    this.endCallTime = endCallTime;
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
   * DOCUMENT ME!
   *
   * @param  startCallTime  DOCUMENT ME!
   */
  public void setStartCallTime(Date startCallTime) {
    this.startCallTime = startCallTime;
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

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#toString()
   */
  @Override public String toString() {
    return "PortfolioJurisdictionCallTime{"
      + "endCallTime=" + endCallTime
      + ", description='" + description + '\''
      + ", startCallTime=" + startCallTime
      + ", jurisdictionExpression='" + jurisdictionExpression + '\''
      + '}';
  }
} // end class PortfolioJurisdictionCallTime
