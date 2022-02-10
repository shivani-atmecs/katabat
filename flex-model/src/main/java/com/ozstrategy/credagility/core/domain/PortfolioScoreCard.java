package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.ozstrategy.credagility.core.helper.EvaluateHelper;

import javax.persistence.*;
import java.util.*;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/16/2014 13:47
 */
@Entity public class PortfolioScoreCard extends CreatorEntity implements Calculatable {
  //~ Enums ------------------------------------------------------------------------------------------------------------

  /**
   * TODO: DOCUMENT ME!
   *
   * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
   * @version  10/16/2014 13:47
   */
  public static enum PortfolioScoreCardStatus {
    //~ Enum constants -------------------------------------------------------------------------------------------------

    ACTIVE, DRAFT, PUBLISHED, RETIRED
  }

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = false,
    length   = 128
  )
  protected String cardName;

  /** TODO: DOCUMENT ME! */
  @Column(length = 512)
  protected String description;

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = false,
    length   = 65536
  )
  protected String finalScoreExpression;

  /** The portfolio which scoreCard belong to. */
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
  @Id protected Long portfolioScoreCardId;

  /** The Score Card Type. */
  @JoinColumn(
    name       = "portfolioScoreTypeId",
    insertable = true,
    updatable  = false,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PortfolioScoreType portfolioScoreType = new PortfolioScoreType();

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "portfolioScoreCard",
    cascade       = { CascadeType.ALL, CascadeType.REMOVE },
    orphanRemoval = true
  )
  @OrderBy("portfolioScoreVariableId asc")
  protected Set<PortfolioScoreVariable> portfolioScoreVariables = new LinkedHashSet<PortfolioScoreVariable>();

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = false,
    length   = 32
  )
  protected String status = "DRAFT";

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addOrUpdateScoreVariable.
   *
   * @param   scoreVariable  PortfolioScoreVariable
   *
   * @return  PortfolioScoreVariable
   */
  public PortfolioScoreVariable addOrUpdateScoreVariable(PortfolioScoreVariable scoreVariable) {
    Long variableId = scoreVariable.getPortfolioScoreVariableId();

    if (variableId != null) {
      PortfolioScoreVariable curScoreVariable = getScoreVariableMap().get(variableId);
      curScoreVariable.update(scoreVariable);

      scoreVariable = curScoreVariable;
    } else {
      scoreVariable.setPortfolioScoreCard(this);
      this.portfolioScoreVariables.add(scoreVariable);
    }

    this.lastUpdateDate = new Date();

    return scoreVariable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * calculate.
   *
   * @param   helper  EvaluateHelper
   *
   * @return  Object
   */
  @Override public Object calculate(EvaluateHelper helper) {
    return helper.calculate(this);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

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

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    PortfolioScoreCard that = (PortfolioScoreCard) o;

    if ((cardName != null) ? (!cardName.equals(that.cardName)) : (that.cardName != null)) {
      return false;
    }

    if ((portfolioScoreType != null) ? (!portfolioScoreType.equals(that.portfolioScoreType))
                                     : (that.portfolioScoreType != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findScoreItem.
   *
   * @param   scoreVariable  PortfolioScoreVariable
   *
   * @return  PortfolioScoreVariable
   */
  public PortfolioScoreVariable findScoreItem(PortfolioScoreVariable scoreVariable) {
    for (PortfolioScoreVariable variable : portfolioScoreVariables) {
      if (variable.equals(scoreVariable)) {
        return variable;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for card name.
   *
   * @return  String
   */
  public String getCardName() {
    return cardName;
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
   * getter method for final score expression.
   *
   * @return  String
   */
  public String getFinalScoreExpression() {
    return finalScoreExpression;
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
   * getter method for portfolio id.
   *
   * @return  Long
   */
  public Long getPortfolioId() {
    return portfolio.getPortfolioId();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio score card id.
   *
   * @return  Long
   */
  public Long getPortfolioScoreCardId() {
    return portfolioScoreCardId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio score type.
   *
   * @return  PortfolioScoreType
   */
  public PortfolioScoreType getPortfolioScoreType() {
    return portfolioScoreType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio score type id.
   *
   * @return  Long
   */
  public Long getPortfolioScoreTypeId() {
    return portfolioScoreType.getPortfolioScoreTypeId();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio score variables.
   *
   * @return  Set
   */
  public Set<PortfolioScoreVariable> getPortfolioScoreVariables() {
    return portfolioScoreVariables;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for score variable map.
   *
   * @return  Map
   */
  public Map<Long, PortfolioScoreVariable> getScoreVariableMap() {
    Map<Long, PortfolioScoreVariable> map = new LinkedHashMap<Long, PortfolioScoreVariable>();

    for (PortfolioScoreVariable variable : portfolioScoreVariables) {
      map.put(variable.getPortfolioScoreVariableId(), variable);
    }

    return map;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status.
   *
   * @return  String
   */
  public String getStatus() {
    return status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((cardName != null) ? cardName.hashCode() : 0);
    result = (31 * result) + ((portfolioScoreType != null) ? portfolioScoreType.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * removeScoreVariable.
   *
   * @param   scoreItemId  Long
   *
   * @return  PortfolioScoreVariable
   */
  public PortfolioScoreVariable removeScoreVariable(Long scoreItemId) {
    if (scoreItemId != null) {
      for (PortfolioScoreVariable variable : portfolioScoreVariables) {
        if (variable.getPortfolioScoreVariableId().equals(scoreItemId)) {
          this.portfolioScoreVariables.remove(variable);

          return variable;
        }
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for card name.
   *
   * @param  cardName  String
   */
  public void setCardName(String cardName) {
    this.cardName = cardName;
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
   * setter method for final score expression.
   *
   * @param  finalScoreExpression  String
   */
  public void setFinalScoreExpression(String finalScoreExpression) {
    this.finalScoreExpression = finalScoreExpression;
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
   * setter method for portfolio id.
   *
   * @param  portfolioId  Long
   */
  public void setPortfolioId(Long portfolioId) {
    this.portfolio.setPortfolioId(portfolioId);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio score card id.
   *
   * @param  portfolioScoreCardId  Long
   */
  public void setPortfolioScoreCardId(Long portfolioScoreCardId) {
    this.portfolioScoreCardId = portfolioScoreCardId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio score type.
   *
   * @param  portfolioScoreType  PortfolioScoreType
   */
  public void setPortfolioScoreType(PortfolioScoreType portfolioScoreType) {
    this.portfolioScoreType = portfolioScoreType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio score type id.
   *
   * @param  scoreCardTypeId  Long
   */
  public void setPortfolioScoreTypeId(Long scoreCardTypeId) {
    portfolioScoreType.setPortfolioScoreTypeId(scoreCardTypeId);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio score variables.
   *
   * @param  portfolioScoreVariables  Set
   */
  public void setPortfolioScoreVariables(Set<PortfolioScoreVariable> portfolioScoreVariables) {
    this.portfolioScoreVariables = portfolioScoreVariables;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for status.
   *
   * @param  status  String
   */
  public void setStatus(String status) {
    this.status = status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * toString.
   *
   * @return  String
   */
  @Override public String toString() {
    return "PortfolioScoreCard:{"
      + "portfolioScoreCardId: " + portfolioScoreCardId
      + ",cardName: " + cardName
      + ",description: " + description
      + ",finalScoreExpression: " + finalScoreExpression
      + ",portfolioId: " + portfolio.getPortfolioId()
      + ",portfolioScoreType: " + portfolioScoreType.getScoreName()
      + ",portfolioScoreVariables.size: " + portfolioScoreVariables.size()
      + ",status: " + status
      + "}";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * update.
   *
   * @param  other  PortfolioScoreCard
   */
  public void update(PortfolioScoreCard other) {
    this.cardName             = other.getCardName();
    this.description          = other.getDescription();
    this.finalScoreExpression = other.getFinalScoreExpression();
    this.status               = "DRAFT";
    this.portfolioScoreType   = other.getPortfolioScoreType();
  }
} // end class PortfolioScoreCard
