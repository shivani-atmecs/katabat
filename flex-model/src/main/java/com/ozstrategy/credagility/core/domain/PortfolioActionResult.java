package com.ozstrategy.credagility.core.domain;

import com.ozstrategy.credagility.core.util.ActionResultComparator;

import java.util.Map;
import java.util.TreeMap;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/16/2014 13:40
 */
public class PortfolioActionResult extends ActionResult {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  protected Map<String, ActionTypeResult> actionResults = new TreeMap<>(
      new ActionResultComparator());


  /** TODO: DOCUMENT ME! */
  protected Long portfolioAccounts;


  /** TODO: DOCUMENT ME! */
  protected String portfolioName;


  /** TODO: DOCUMENT ME! */
  protected Long portfolioResponsibles;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addActionTypeResult.
   *
   * @param  actionType    String
   * @param  actionResult  ProcessActionResult
   */
  public void addActionTypeResult(String actionType, ProcessActionResult actionResult) {
    addActionTypeResult(actionType, "#NON#", actionResult);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addActionTypeResult.
   *
   * @param  actionType    String
   * @param  category      String
   * @param  actionResult  ProcessActionResult
   */
  public void addActionTypeResult(String actionType, String category, ProcessActionResult actionResult) {
    if (actionType == null) {
      return;
    }

    actionType = actionType.trim();

    if (actionType.isEmpty()) {
      return;
    }

    ActionTypeResult actionTypeResult = (ActionTypeResult) actionResults.get(actionType);

    if (actionTypeResult == null) {
      actionTypeResult = new ActionTypeResult();
      actionTypeResult.setActionType(actionType);
      actionResults.put(actionType, actionTypeResult);
    }

    actionTypeResult.addResult(category, actionResult);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for action results.
   *
   * @return  Map
   */
  public Map<String, ActionTypeResult> getActionResults() {
    return actionResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio accounts.
   *
   * @return  Long
   */
  public Long getPortfolioAccounts() {
    return portfolioAccounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio name.
   *
   * @return  String
   */
  public String getPortfolioName() {
    return portfolioName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio responsibles.
   *
   * @return  Long
   */
  public Long getPortfolioResponsibles() {
    return portfolioResponsibles;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for action results.
   *
   * @param  actionResults  Map
   */
  public void setActionResults(Map<String, ActionTypeResult> actionResults) {
    this.actionResults = actionResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for action type counts.
   *
   * @param  actionType          String
   * @param  uniqueAccounts      Long
   * @param  uniqueResponsibles  Long
   */
  public void setActionTypeCounts(String actionType, Long uniqueAccounts, Long uniqueResponsibles) {
    ActionTypeResult actionTypeResult = actionResults.get(actionType);

    if (actionTypeResult != null) {
      actionTypeResult.setUniqueAccounts(uniqueAccounts + actionTypeResult.getUniqueAccounts());
      actionTypeResult.setUniqueResponsibles(uniqueResponsibles + actionTypeResult.getUniqueResponsibles());
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio accounts.
   *
   * @param  portfolioAccounts  Long
   */
  public void setPortfolioAccounts(Long portfolioAccounts) {
    this.portfolioAccounts = portfolioAccounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio name.
   *
   * @param  portfolioName  String
   */
  public void setPortfolioName(String portfolioName) {
    this.portfolioName = portfolioName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio responsibles.
   *
   * @param  portfolioResponsibles  Long
   */
  public void setPortfolioResponsibles(Long portfolioResponsibles) {
    this.portfolioResponsibles = portfolioResponsibles;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * sortResults.
   */
  public void sortResults() {
    for (ActionTypeResult actionResult : actionResults.values()) {
      actionResult.sortResults();
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("PortfolioActionResult");
    sb.append("{actionResults=").append(actionResults);
    sb.append(", portfolioAccounts=").append(portfolioAccounts);
    sb.append(", portfolioName='").append(portfolioName).append('\'');
    sb.append(", portfolioResponsibles=").append(portfolioResponsibles);
    sb.append('}');

    return sb.toString();
  }
} // end class PortfolioActionResult
