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
@Entity public class PortfolioJurisdictionSmsTime extends BaseEntity implements ExpressionObject {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -4918287402831296239L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Jurisdiction sms time description. */
  @Column private String description;

  /** Jurisdiction sms end time. */
  @Column(name = "endSmsTime")
  @Temporal(TemporalType.TIME)
  private Date endSmsTime;

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

  /** Jurisdiction sms start time. */
  @Column(name = "startSmsTime")
  @Temporal(TemporalType.TIME)
  private Date startSmsTime;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#equals(Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof PortfolioJurisdictionSmsTime)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    PortfolioJurisdictionSmsTime that = (PortfolioJurisdictionSmsTime) o;

    if ((description != null) ? (!description.equals(that.description)) : (that.description != null)) {
      return false;
    }

    if ((endSmsTime != null) ? (!endSmsTime.equals(that.endSmsTime)) : (that.endSmsTime != null)) {
      return false;
    }

    if ((jurisdictionExpression != null) ? (!jurisdictionExpression.equals(that.jurisdictionExpression))
                                         : (that.jurisdictionExpression != null)) {
      return false;
    }

    if ((startSmsTime != null) ? (!startSmsTime.equals(that.startSmsTime)) : (that.startSmsTime != null)) {
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
  public Date getEndSmsTime() {
    return endSmsTime;
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
  public Date getStartSmsTime() {
    return startSmsTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((description != null) ? description.hashCode() : 0);
    result = (31 * result) + ((endSmsTime != null) ? endSmsTime.hashCode() : 0);
    result = (31 * result) + ((jurisdictionExpression != null) ? jurisdictionExpression.hashCode() : 0);
    result = (31 * result) + ((startSmsTime != null) ? startSmsTime.hashCode() : 0);

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
   * @param  endSmsTime  DOCUMENT ME!
   */
  public void setEndSmsTime(Date endSmsTime) {
    this.endSmsTime = endSmsTime;
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
   * @param  startSmsTime  DOCUMENT ME!
   */
  public void setStartSmsTime(Date startSmsTime) {
    this.startSmsTime = startSmsTime;
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
   * @see  Object#toString()
   */
  @Override public String toString() {
    return "PortfolioJurisdictionCallTime{"
      + "endSmsTime=" + endSmsTime
      + ", description='" + description + '\''
      + ", startSmsTime=" + startSmsTime
      + ", jurisdictionExpression='" + jurisdictionExpression + '\''
      + '}';
  }
} // end class PortfolioJurisdictionSmsTime
