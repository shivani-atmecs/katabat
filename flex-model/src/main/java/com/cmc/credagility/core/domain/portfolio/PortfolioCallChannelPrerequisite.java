package com.cmc.credagility.core.domain.portfolio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.cmc.credagility.core.domain.base.BaseEntity;

import com.ozstrategy.credagility.core.el.ExpressionObject;


/**
 * Created with IntelliJ IDEA. User: cyberwym Date: 4/15/13 Time: 2:26 PM To change this template use File | Settings |
 * File Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity public class PortfolioCallChannelPrerequisite extends BaseEntity implements ExpressionObject {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -666026466721842862L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Primary key. */
  @Column(
    name     = "id", /*unique = true,*/
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** Description for portfolio call channel prerequisite. */
  @Column private String description;

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

  /** query sql. */
  @Column(
    name     = "querySql",
    nullable = false,
    length   = 10000
  )
  private String query;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static long getSerialVersionUID() {
    return serialVersionUID;
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
   * @see  com.ozstrategy.credagility.core.el.ExpressionObject#getExpression()
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
  public String getQuery() {
    return query;
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
   * @param  query  DOCUMENT ME!
   */
  public void setQuery(String query) {
    this.query = query;
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
} // end class PortfolioCallChannelPrerequisite
