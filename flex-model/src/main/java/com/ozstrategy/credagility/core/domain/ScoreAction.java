package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.ozstrategy.credagility.core.helper.EvaluateHelper;
import com.ozstrategy.credagility.core.helper.ExecuteHelper;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;


/**
 * This class is used to store score action information.
 *
 * <p><a href="ScoreAction.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 * @version  10/16/2014 14:58
 */
@Entity
@Table(
  indexes = {
    @Index(
      name = "actionNameIndex",
      columnList = "name"
    )
  }
)
public class ScoreAction extends PortfolioBaseNodeAction {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** PortfolioScoreType. */
  @JoinColumn(
    name       = "portfolioScoreCardId",
    nullable   = false,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PortfolioScoreCard portfolioScoreCard;


  /** TODO: DOCUMENT ME! */
  @Transient protected Long portfolioScoreCardId;


  /** TODO: DOCUMENT ME! */
  @ManyToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "nodeScoreActions"
  )
  protected Set<Node> scoreNodes = new LinkedHashSet<Node>();

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new ScoreAction object.
   */
  public ScoreAction() {
    actionType = BaseNodeAction.ActionType_Score;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * beforeExecute.
   */
  @Override public void beforeExecute() {
    // To change body of implemented methods use File | Settings | File Templates.
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * duplicate.
   *
   * @return  BaseNodeAction
   */
  @Override public BaseNodeAction duplicate() {
    ScoreAction scoreAction = new ScoreAction();
    scoreAction.updateNodeAction(this);
    scoreAction.setPortfolio(scoreAction.getPortfolio());
    scoreAction.setName(scoreAction.getName());
    scoreAction.setPortfolioScoreCard(this.getPortfolioScoreCard());

    return scoreAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * execute.
   *
   * @param  evaluateHelper  EvaluateHelper
   * @param  executeHelper   ExecuteHelper
   */
  @Override public void execute(EvaluateHelper evaluateHelper, ExecuteHelper executeHelper) {
    // To change body of implemented methods use File | Settings | File Templates.
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for complete criteria.
   *
   * @return  String
   */
  public String getCompleteCriteria() {
    return this.criteria;

  } // end method getCompleteCriteria

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio.
   *
   * @return  Portfolio
   */
  @Override public Portfolio getPortfolio() {
    return portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio score card.
   *
   * @return  PortfolioScoreCard
   */
  public PortfolioScoreCard getPortfolioScoreCard() {
    return portfolioScoreCard;
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
   * getter method for score nodes.
   *
   * @return  Set
   */
  public Set<Node> getScoreNodes() {
    return scoreNodes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio score card.
   *
   * @param  portfolioScoreCard  PortfolioScoreCard
   */
  public void setPortfolioScoreCard(PortfolioScoreCard portfolioScoreCard) {
    this.portfolioScoreCard = portfolioScoreCard;
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
   * setter method for score nodes.
   *
   * @param  scoreNodes  Set
   */
  public void setScoreNodes(Set<Node> scoreNodes) {
    this.scoreNodes = scoreNodes;
  }
} // end class ScoreAction
