package com.cmc.credagility.core.domain.portfolio;

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


/**
 * This class is used to store Portfolio Program Type information.
 *
 * <p><a href="PortfolioProgramType.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 *
 *           <p>table = "PortfolioOutcomeType"</p>
 * @version  10/16/2014 10:15
 */
@Entity
@Table(name = "PortfolioOutcomeType")
public class PortfolioOutcomeType extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 3236777952697374522L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** out come type. */
  @JoinColumn(
    name      = "resultId",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected OutcomeType outcomeType;

  /** Portfolio PK portfolioId. */
  @JoinColumn(
    name      = "portfolioId",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Portfolio portfolio;

  /** priority. */
  @Column(name = "priority")
  protected Integer priority;


  // npelleti, 07/30, USBank, Removed unique constraint
  /** Portfolio outcome result Id, PK. */
  @Column(
    name     = "typeId", /*unique = true,*/
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long typeId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#equals(java.lang.Object)
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

    final PortfolioOutcomeType other = (PortfolioOutcomeType) obj;

    if (outcomeType == null) {
      if (other.outcomeType != null) {
        return false;
      }
    } else if (!outcomeType.getResultId().equals(
            other.outcomeType.getResultId())) {
      return false;
    }

    if (priority == null) {
      if (other.priority != null) {
        return false;
      }
    } else if (!priority.equals(other.priority)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The outcomeType.
   *
   * @return  the outcomeType
   *
   *          <p>column = "resultId" not-null = "true" class = "com.cmc.credagility.OutcomeType" insert = "true" update
   *          = "false"</p>
   */
  public OutcomeType getOutcomeType() {
    return outcomeType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The portfolio.
   *
   * @return  the portfolio
   *
   *          <p>lazy = "proxy" column = "portfolioId" not-null = "true" class = "com.cmc.credagility.Portfolio" insert
   *          = "true" update = "false"</p>
   */
  public Portfolio getPortfolio() {
    return portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The priority.
   *
   * @return  the priority
   *
   *          <p>not-null = "false"</p>
   */
  public Integer getPriority() {
    return priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The resultId.
   *
   * @return  the resultId
   *
   *          <p>generator-class = "native" unsaved-value = "null"</p>
   */
  public Long getTypeId() {
    return this.typeId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = super.hashCode();
    result = (prime * result)
      + ((outcomeType == null) ? 0 : outcomeType.getResultId().hashCode());
    result = (prime * result) + ((priority == null) ? 0 : priority.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setOutcomeType.
   *
   * @param  outcomeType  the outcomeType to set
   */
  public void setOutcomeType(OutcomeType outcomeType) {
    this.outcomeType = outcomeType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setPortfolio.
   *
   * @param  portfolio  the portfolio to set
   */
  public void setPortfolio(Portfolio portfolio) {
    this.portfolio = portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setPriority.
   *
   * @param  priority  the priority to set
   */
  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setTypeId.
   *
   * @param  typeId  the typeId to set
   */
  public void setTypeId(Long typeId) {
    this.typeId = typeId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Constructs a <code>String</code> with all attributes in name = value format.
   *
   * @return  a <code>String</code> representation of this object.
   */
  @Override public String toString() {
    final String TAB = "    ";

    StringBuilder retValue = new StringBuilder();

    retValue.append("PortfolioOutcomeType ( ").append(super.toString()).append(
      TAB).append("portfolio = ").append(this.portfolio).append(TAB).append(
      "resultId = ").append(this.typeId).append(TAB).append(" )");

    return retValue.toString();
  }

} // end class PortfolioOutcomeType
