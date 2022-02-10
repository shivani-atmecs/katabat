package com.ozstrategy.credagility.core.domain;

import com.ozstrategy.credagility.core.domain.entity.BaseEntity;
import com.ozstrategy.credagility.core.helper.EvaluateHelper;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/16/2014 13:51
 */
@Entity public class PortfolioScoreDecision extends BaseEntity implements Evaluable {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Transient protected String breakPoints;

  /** TODO: DOCUMENT ME! */
  @Column(
    length   = 256,
    nullable = true
  )
  protected String decisionCondition;

  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  protected Integer decisionScore = 0;

  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  protected Integer displayOrder = 1;

  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long portfolioScoreDecisionId;

  /** The scoreCard which scoreItem belong to. */
  @JoinColumn(
    name       = "portfolioScoreVariableId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PortfolioScoreVariable portfolioScoreVariable = new PortfolioScoreVariable();

  /** decision type: normal/null/other */
  @Column(
    nullable = false,
    length   = 16
  )
  protected String type = "normal";

  /** TODO: DOCUMENT ME! */
  @Transient protected String variableName;

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

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    PortfolioScoreDecision that = (PortfolioScoreDecision) o;

    if ((type != null) ? (!type.equals(that.type)) : (that.type != null)) {
      return false;
    }

    if ((decisionCondition != null) ? (!decisionCondition.equals(that.decisionCondition))
                                    : (that.decisionCondition != null)) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * evaluate.
   *
   * @param   helper  EvaluateHelper
   *
   * @return  boolean
   */
  @Override public boolean evaluate(EvaluateHelper helper) {
    return helper.evaluate(this);

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for break points.
   *
   * @return  String
   */
  public String getBreakPoints() {
    if (portfolioScoreVariable != null) {
      this.breakPoints = portfolioScoreVariable.getBreakPoints();
    }

    return breakPoints;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for decision condition.
   *
   * @return  String
   */
  public String getDecisionCondition() {
    return decisionCondition;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for decision score.
   *
   * @return  Integer
   */
  public Integer getDecisionScore() {
    return decisionScore;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for display order.
   *
   * @return  Integer
   */
  public Integer getDisplayOrder() {
    return displayOrder;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio score card id.
   *
   * @return  Long
   */
  public Long getPortfolioScoreCardId() {
    Long scoreCardId = null;

    if ((this.portfolioScoreVariable != null) && (this.portfolioScoreVariable.getPortfolioScoreCard() != null)) {
      scoreCardId = this.portfolioScoreVariable.getPortfolioScoreCard().getPortfolioScoreCardId();
    }

    return scoreCardId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio score decision id.
   *
   * @return  Long
   */
  public Long getPortfolioScoreDecisionId() {
    return portfolioScoreDecisionId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio score variable.
   *
   * @return  PortfolioScoreVariable
   */
  public PortfolioScoreVariable getPortfolioScoreVariable() {
    return portfolioScoreVariable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio score variable id.
   *
   * @return  Long
   */
  public Long getPortfolioScoreVariableId() {
    Long scoreVariableId = null;

    if (this.portfolioScoreVariable != null) {
      scoreVariableId = this.portfolioScoreVariable.getPortfolioScoreVariableId();
    }

    return scoreVariableId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for type.
   *
   * @return  String
   */
  public String getType() {
    return type;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for variable name.
   *
   * @return  String
   */
  public String getVariableName() {
    if (portfolioScoreVariable != null) {
      variableName = portfolioScoreVariable.getVariableName();
    }

    return variableName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((decisionCondition != null) ? decisionCondition.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for null decision.
   *
   * @return  boolean
   */
  public boolean isNullDecision() {
    return "null".equalsIgnoreCase(type);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for other decision.
   *
   * @return  boolean
   */
  public boolean isOtherDecision() {
    return "other".equalsIgnoreCase(type);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for break points.
   *
   * @param  breakPoints  String
   */
  public void setBreakPoints(String breakPoints) {
    this.breakPoints = breakPoints;
    portfolioScoreVariable.setBreakPoints(breakPoints);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for decision condition.
   *
   * @param  decisionCondition  String
   */
  public void setDecisionCondition(String decisionCondition) {
    this.decisionCondition = decisionCondition;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for decision score.
   *
   * @param  decisionScore  Integer
   */
  public void setDecisionScore(Integer decisionScore) {
    this.decisionScore = decisionScore;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for display order.
   *
   * @param  displayOrder  Integer
   */
  public void setDisplayOrder(Integer displayOrder) {
    this.displayOrder = displayOrder;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio score card id.
   *
   * @param  scoreCardId  Long
   */
  public void setPortfolioScoreCardId(Long scoreCardId) {
    getPortfolioScoreVariable().getPortfolioScoreCard().setPortfolioScoreCardId(scoreCardId);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio score decision id.
   *
   * @param  portfolioScoreDecisionId  Long
   */
  public void setPortfolioScoreDecisionId(Long portfolioScoreDecisionId) {
    this.portfolioScoreDecisionId = portfolioScoreDecisionId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio score variable.
   *
   * @param  portfolioScoreVariable  PortfolioScoreVariable
   */
  public void setPortfolioScoreVariable(PortfolioScoreVariable portfolioScoreVariable) {
    this.portfolioScoreVariable = portfolioScoreVariable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio score variable id.
   *
   * @param  portfolioScoreVariableId  Long
   */
  public void setPortfolioScoreVariableId(Long portfolioScoreVariableId) {
    this.portfolioScoreVariable.setPortfolioScoreVariableId(portfolioScoreVariableId);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for type.
   *
   * @param  type  String
   */
  public void setType(String type) {
    this.type = type;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for variable name.
   *
   * @param  variableName  String
   */
  public void setVariableName(String variableName) {
    this.variableName = variableName;
    this.portfolioScoreVariable.setVariableName(variableName);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * toString.
   *
   * @return  String
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("PortfolioScoreDecision");
    sb.append("{criteria='").append(decisionCondition).append('\'');
    sb.append(", decisionScore=").append(decisionScore);
    sb.append(", displayOrder=").append(displayOrder);
    sb.append(", scoreDecisionId=").append(portfolioScoreDecisionId);
    sb.append(", scoreItem=").append(portfolioScoreVariable);
    sb.append('}');

    return sb.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * update.
   *
   * @param  other  PortfolioScoreDecision
   */
  public void update(PortfolioScoreDecision other) {
    this.decisionCondition = other.getDecisionCondition();
    this.decisionScore     = other.getDecisionScore();
    this.displayOrder      = other.getDisplayOrder();

    this.lastUpdateDate = new Date();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * verify.
   *
   * @param  helper  EvaluateHelper
   */
  @Override public void verify(EvaluateHelper helper) {
    helper.verify(this);
  }
} // end class PortfolioScoreDecision
