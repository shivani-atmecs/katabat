package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.cmc.credagility.core.domain.portfolio.PortfolioVariable;
import com.ozstrategy.credagility.core.domain.entity.BaseEntity;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/16/2014 13:53
 */
@Entity public class PortfolioScoreType extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(length = 512)
  protected String description;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "portfolioId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Portfolio portfolio = new Portfolio();

  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long portfolioScoreTypeId;

  /** TODO: DOCUMENT ME! */
  @Column(
    length   = 128,
    nullable = false
  )
  protected String scoreName;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "scoreTypeVariableId",
    nullable = true
  )
  @ManyToOne(cascade = { javax.persistence.CascadeType.ALL, javax.persistence.CascadeType.REMOVE })
  protected PortfolioVariable scoreTypeVariable = null;

  /** TODO: DOCUMENT ME! */
  @Column(
    length   = 255,
    nullable = false
  )
  protected String variableName;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * createVariable.
   *
   * @return  PortfolioVariable
   */
  public PortfolioVariable createVariable() {
    if (this.portfolioScoreTypeId != null) {
      if (this.scoreTypeVariable == null) {
        scoreTypeVariable = new PortfolioVariable();

        scoreTypeVariable.setName(this.variableName);
        scoreTypeVariable.setDisplayName(this.scoreName);
        scoreTypeVariable.setCategory("scoreCard");
        scoreTypeVariable.setBuildType("source");
        scoreTypeVariable.setDataType("Integer");
        scoreTypeVariable.setBusinessDataType("Integer");
        scoreTypeVariable.setPortfolio(this.portfolio);
        scoreTypeVariable.setLocked(true);
        scoreTypeVariable.setDisplayPosition("holder");
      } else {
        this.scoreTypeVariable.setName(this.variableName);
        this.scoreTypeVariable.setDisplayName(this.scoreName);
        this.scoreTypeVariable.setPortfolio(this.portfolio);
        this.scoreTypeVariable.setLastUpdateDate(new Date());
        this.scoreTypeVariable.setLocked(true);
      }

      this.scoreTypeVariable.setExpression("responsible.getResponsiblePortfolioScore(" + portfolioScoreTypeId + ")");

      return this.scoreTypeVariable;
    } else {
      return null;
    } // end if-else
  }   // end method createVariable

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#equals(Object)
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

    PortfolioScoreType portfolioScoreType = (PortfolioScoreType) o;

    if ((scoreName != null) ? (!scoreName.equals(portfolioScoreType.scoreName))
                            : (portfolioScoreType.scoreName != null)) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for description.
   *
   * @return  String
   */
  public String getDescription() {
    return description;
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
   * getter method for portfolio score type id.
   *
   * @return  Long
   */
  public Long getPortfolioScoreTypeId() {
    return portfolioScoreTypeId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for score name.
   *
   * @return  String
   */
  public String getScoreName() {
    return scoreName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for score type variable.
   *
   * @return  PortfolioVariable
   */
  public PortfolioVariable getScoreTypeVariable() {
    return scoreTypeVariable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for variable name.
   *
   * @return  String
   */
  public String getVariableName() {
    return variableName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((scoreName != null) ? scoreName.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for description.
   *
   * @param  description  String
   */
  public void setDescription(String description) {
    this.description = description;
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
   * setter method for portfolio score type id.
   *
   * @param  portfolioScoreTypeId  Long
   */
  public void setPortfolioScoreTypeId(Long portfolioScoreTypeId) {
    this.portfolioScoreTypeId = portfolioScoreTypeId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for score name.
   *
   * @param  scoreName  String
   */
  public void setScoreName(String scoreName) {
    this.scoreName = scoreName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for score type variable.
   *
   * @param  scoreTypeVariable  PortfolioVariable
   */
  public void setScoreTypeVariable(PortfolioVariable scoreTypeVariable) {
    this.scoreTypeVariable = scoreTypeVariable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for variable name.
   *
   * @param  variableName  String
   */
  public void setVariableName(String variableName) {
    this.variableName = variableName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * toString.
   *
   * @return  String
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("ScoreCardType");
    sb.append("{description='").append(description).append('\'');
    sb.append(", scoreName='").append(scoreName).append('\'');
    sb.append(", scoreTypeId=").append(portfolioScoreTypeId);
    sb.append('}');

    return sb.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * update.
   *
   * @param  other  PortfolioScoreType
   */
  public void update(PortfolioScoreType other) {
    this.description  = other.getDescription();
    this.scoreName    = other.getScoreName();
    this.variableName = other.getVariableName();
  }
} // end class PortfolioScoreType
