package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.variable.BaseVariable;
import com.ozstrategy.credagility.core.domain.entity.BaseEntity;
import com.ozstrategy.credagility.core.helper.EvaluateHelper;
import com.ozstrategy.credagility.core.util.ConvertableStringComparator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.*;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/16/2014 13:56
 */
@Entity public class PortfolioScoreVariable extends BaseEntity implements Calculatable {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    length   = 1024,
    nullable = false
  )
  protected String breakPoints;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "decisionVariableId")
  @ManyToOne protected BaseVariable decisionVariable = null;

  /** The scoreCard which scoreItem belong to. */
  @JoinColumn(
    name       = "portfolioScoreCardId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PortfolioScoreCard portfolioScoreCard = new PortfolioScoreCard();

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "portfolioScoreVariable",
    cascade       = { CascadeType.ALL, CascadeType.REMOVE },
    orphanRemoval = true
  )
  @OrderBy(value = "displayOrder asc")
  protected Set<PortfolioScoreDecision> portfolioScoreDecisions = new LinkedHashSet<PortfolioScoreDecision>();

  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long portfolioScoreVariableId;

  /** TODO: DOCUMENT ME! */
  @Transient protected String variableName;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addOrUpdateScoreDecision.
   *
   * @param  scoreDecision  PortfolioScoreDecision
   */
  public void addOrUpdateScoreDecision(PortfolioScoreDecision scoreDecision) {
    Long decisionId = scoreDecision.getPortfolioScoreDecisionId();

    if (decisionId != null) {
      PortfolioScoreDecision curScoreDecision = getScoreDecisionMap().get(decisionId);
      curScoreDecision.update(scoreDecision);
    } else {
      scoreDecision.setPortfolioScoreVariable(this);
      this.portfolioScoreDecisions.add(scoreDecision);
    }

    this.lastUpdateDate = new Date();
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
    Integer score = 0;

    for (PortfolioScoreDecision scoreDecision : portfolioScoreDecisions) {
      if (scoreDecision.evaluate(helper)) {
        score = scoreDecision.getDecisionScore();

        break;
      }
    }

    return score;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * clearAllDecisions.
   */
  public void clearAllDecisions() {
    this.portfolioScoreDecisions.clear();
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

    PortfolioScoreVariable that = (PortfolioScoreVariable) o;

    if ((breakPoints != null) ? (!breakPoints.equals(that.breakPoints)) : (that.breakPoints != null)) {
      return false;
    }

    if ((getVariableName() != null) ? (!getVariableName().equals(that.getVariableName()))
                                    : (that.getVariableName() != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * generateDecisions.
   *
   * @param   retType  Class
   *
   * @return  List
   */
  public List<PortfolioScoreDecision> generateDecisions(Class retType) {
    List<PortfolioScoreDecision> decisionList = new ArrayList<PortfolioScoreDecision>();

    Set<String> pointSet = new HashSet<String>();

    for (String part : breakPoints.split(",")) {
      pointSet.add(part);
    }

    List<String> points = new ArrayList<String>();
    points.addAll(pointSet);

    Collections.sort(points, new ConvertableStringComparator());

    try {
      this.clearAllDecisions();

      int order = 1;

      addOrUpdateScoreDecision(createNullDecision("{" + getVariableName() + "} is null", order++));

      if ((retType.equals(Long.class)) || (retType.equals(Integer.class)) || (retType.equals(BigDecimal.class))
            || (retType.equals(Date.class))) {
        int size = points.size();

        for (int i = 0; i < size; i++) {
          if (i == 0) {
            // first one
            addOrUpdateScoreDecision(createDecision("{" + getVariableName() + "} < " + points.get(i), order++));
          } else {
            addOrUpdateScoreDecision(createDecision(
                points.get(i - 1) + " < {" + getVariableName() + "} " + " and " + "{" + getVariableName() + "} < "
                + points.get(i), order++));
          }

          addOrUpdateScoreDecision(createDecision("{" + getVariableName() + "} = " + points.get(i), order++));

          if (i == (size - 1)) {
            // last one
            addOrUpdateScoreDecision(createDecision("{" + getVariableName() + "} > " + points.get(i), order++));
          }
        }
      } else if (retType.equals(Boolean.class)) {
        addOrUpdateScoreDecision(createDecision("{" + getVariableName() + "} = true", order++));
        addOrUpdateScoreDecision(createDecision("{" + getVariableName() + "} = false", order++));
      } // end if-else
      else if (retType.equals(String.class)) {
        for (String point : points) {
          addOrUpdateScoreDecision(createDecision("{" + getVariableName() + "} = '" + point + "'", order++));
        }

        addOrUpdateScoreDecision(createOtherDecision("Any other value", order++));
      } // end if-else

    } catch (Exception e) { } // end try-catch

    decisionList.addAll(this.portfolioScoreDecisions);

    return decisionList;
  } // end method generateDecisions

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for break points.
   *
   * @return  String
   */
  public String getBreakPoints() {
    return breakPoints;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for decision variable.
   *
   * @return  BaseVariable
   */
  public BaseVariable getDecisionVariable() {
    return decisionVariable;
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
    return portfolioScoreCard.getPortfolioScoreCardId();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio score decisions.
   *
   * @return  Set
   */
  public Set<PortfolioScoreDecision> getPortfolioScoreDecisions() {
    return portfolioScoreDecisions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio score variable id.
   *
   * @return  Long
   */
  public Long getPortfolioScoreVariableId() {
    return portfolioScoreVariableId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for score decision map.
   *
   * @return  Map
   */
  public Map<Long, PortfolioScoreDecision> getScoreDecisionMap() {
    Map<Long, PortfolioScoreDecision> map = new LinkedHashMap<Long, PortfolioScoreDecision>();

    for (PortfolioScoreDecision scoreDecision : portfolioScoreDecisions) {
      map.put(scoreDecision.getPortfolioScoreDecisionId(), scoreDecision);
    }

    return map;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for variable name.
   *
   * @return  String
   */
  public String getVariableName() {
    if (decisionVariable != null) {
      variableName = decisionVariable.getName();
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
    int result = 31;
    result = (31 * result) + ((breakPoints != null) ? breakPoints.hashCode() : 0);
    result = (31 * result) + ((getVariableName() != null) ? getVariableName().hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for break points.
   *
   * @param  breakPoints  String
   */
  public void setBreakPoints(String breakPoints) {
    this.breakPoints = breakPoints;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for decision variable.
   *
   * @param  decisionVariable  BaseVariable
   */
  public void setDecisionVariable(BaseVariable decisionVariable) {
    this.decisionVariable = decisionVariable;
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
   * @param  scoreCardId  Long
   */
  public void setPortfolioScoreCardId(Long scoreCardId) {
    if (scoreCardId != null) {
      this.portfolioScoreCard = new PortfolioScoreCard();
      this.portfolioScoreCard.setPortfolioScoreCardId(scoreCardId);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio score decisions.
   *
   * @param  portfolioScoreDecisions  Set
   */
  public void setPortfolioScoreDecisions(Set<PortfolioScoreDecision> portfolioScoreDecisions) {
    this.portfolioScoreDecisions = portfolioScoreDecisions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio score variable id.
   *
   * @param  portfolioScoreVariableId  Long
   */
  public void setPortfolioScoreVariableId(Long portfolioScoreVariableId) {
    this.portfolioScoreVariableId = portfolioScoreVariableId;
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
    sb.append("PortfolioScoreVariable");
    sb.append("{breakPoints='").append(breakPoints).append('\'');
    sb.append(", decisionVariable=").append(decisionVariable);
    sb.append(", portfolioScoreCard=").append(portfolioScoreCard);
    sb.append(", portfolioScoreDecisions=").append(portfolioScoreDecisions);
    sb.append(", portfolioScoreVariableId=").append(portfolioScoreVariableId);
    sb.append(", variableName='").append(variableName).append('\'');
    sb.append('}');

    return sb.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * update.
   *
   * @param  scoreVariable  PortfolioScoreVariable
   */
  public void update(PortfolioScoreVariable scoreVariable) {
    this.breakPoints      = scoreVariable.getBreakPoints();
    this.variableName     = scoreVariable.getVariableName();
    this.decisionVariable = scoreVariable.getDecisionVariable();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * createDecision.
   *
   * @param   condition  String
   * @param   order      int
   *
   * @return  PortfolioScoreDecision
   */
  protected PortfolioScoreDecision createDecision(String condition, int order) {
    PortfolioScoreDecision decision = new PortfolioScoreDecision();
    decision.setDecisionCondition(condition);
    decision.setDisplayOrder(order);

    return decision;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * createNullDecision.
   *
   * @param   condition  String
   * @param   order      int
   *
   * @return  PortfolioScoreDecision
   */
  protected PortfolioScoreDecision createNullDecision(String condition, int order) {
    PortfolioScoreDecision decision = new PortfolioScoreDecision();
    decision.setDecisionCondition(condition);
    decision.setType("null");
    decision.setDisplayOrder(order);

    return decision;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * createOtherDecision.
   *
   * @param   condition  String
   * @param   order      int
   *
   * @return  PortfolioScoreDecision
   */
  protected PortfolioScoreDecision createOtherDecision(String condition, int order) {
    PortfolioScoreDecision decision = new PortfolioScoreDecision();
    decision.setDecisionCondition(condition);
    decision.setType("other");
    decision.setDisplayOrder(order);

    return decision;
  }
} // end class PortfolioScoreVariable
