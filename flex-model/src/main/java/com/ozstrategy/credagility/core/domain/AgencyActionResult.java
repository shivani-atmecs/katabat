package com.ozstrategy.credagility.core.domain;

import com.ozstrategy.credagility.core.util.ActionResultComparator;

import java.util.Map;
import java.util.TreeMap;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/16/2014 10:18
 */
public class AgencyActionResult extends ActionResult {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  protected Map<String, AgencyActionTypeResult> actionResults = new TreeMap<>(
      new ActionResultComparator());


  /** TODO: DOCUMENT ME! */
  protected Long agencyActionCounts;


  /** TODO: DOCUMENT ME! */
  protected String agencyName;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addActionTypeResult.
   *
   * @param  actionType    String
   * @param  actionResult  AgencyProcessActionResult
   */
  public void addActionTypeResult(String actionType, AgencyProcessActionResult actionResult) {
    addActionTypeResult(actionType, "#NON#", actionResult);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addActionTypeResult.
   *
   * @param  actionType    String
   * @param  category      String
   * @param  actionResult  AgencyProcessActionResult
   */
  public void addActionTypeResult(String actionType, String category, AgencyProcessActionResult actionResult) {
    if (actionType == null) {
      return;
    }

    actionType = actionType.trim();

    if (actionType.isEmpty()) {
      return;
    }

    AgencyActionTypeResult actionTypeResult = actionResults.get(actionType);

    if (actionTypeResult == null) {
      actionTypeResult = new AgencyActionTypeResult();
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
  public Map<String, AgencyActionTypeResult> getActionResults() {
    return actionResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agency action counts.
   *
   * @return  Long
   */
  public Long getAgencyActionCounts() {
    return agencyActionCounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agency name.
   *
   * @return  String
   */
  public String getAgencyName() {
    return agencyName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for action results.
   *
   * @param  actionResults  Map
   */
  public void setActionResults(Map<String, AgencyActionTypeResult> actionResults) {
    this.actionResults = actionResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for action type counts.
   *
   * @param  actionType          String
   * @param  uniqueAgencyCounts  Long
   */
  public void setActionTypeCounts(String actionType, Long uniqueAgencyCounts) {
    AgencyActionTypeResult actionTypeResult = actionResults.get(actionType);

    if (actionTypeResult != null) {
      actionTypeResult.setUniqueAgencyCounts(uniqueAgencyCounts + actionTypeResult.getUniqueAgencyCounts());
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agency action counts.
   *
   * @param  agencyActionCounts  Long
   */
  public void setAgencyActionCounts(Long agencyActionCounts) {
    this.agencyActionCounts = agencyActionCounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agency name.
   *
   * @param  agencyName  String
   */
  public void setAgencyName(String agencyName) {
    this.agencyName = agencyName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * sortResults.
   */
  public void sortResults() {
    for (AgencyActionTypeResult actionResult : actionResults.values()) {
      actionResult.sortResults();
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("AgencyActionResult");
    sb.append("{actionResults=").append(actionResults);
    sb.append(", AgencyActionCounts=").append(agencyActionCounts);
    sb.append(", AgencyName='").append(agencyName).append('\'');
    sb.append('}');

    return sb.toString();
  }
} // end class AgencyActionResult
