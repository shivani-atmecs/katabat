package com.ozstrategy.credagility.core.domain;

import com.ozstrategy.credagility.core.util.ActionResultComparator;

import java.util.Map;
import java.util.TreeMap;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/16/2014 11:36
 */
public class BusinessContextActionResult extends ActionResult {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  protected Map<String, BusinessContextActionTypeResult> actionResults = new TreeMap<>(
      new ActionResultComparator());


  /** TODO: DOCUMENT ME! */
  protected Long businessContextActionCounts;


  /** TODO: DOCUMENT ME! */
  protected String businessContextName;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addActionTypeResult.
   *
   * @param  actionType    String
   * @param  actionResult  BusinessContextProcessActionResult
   */
  public void addActionTypeResult(String actionType, BusinessContextProcessActionResult actionResult) {
    addActionTypeResult(actionType, "#NON#", actionResult);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addActionTypeResult.
   *
   * @param  actionType    String
   * @param  category      String
   * @param  actionResult  BusinessContextProcessActionResult
   */
  public void addActionTypeResult(String actionType, String category, BusinessContextProcessActionResult actionResult) {
    if (actionType == null) {
      return;
    }

    actionType = actionType.trim();

    if (actionType.isEmpty()) {
      return;
    }

    BusinessContextActionTypeResult actionTypeResult = actionResults.get(actionType);

    if (actionTypeResult == null) {
      actionTypeResult = new BusinessContextActionTypeResult();
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
  public Map<String, BusinessContextActionTypeResult> getActionResults() {
    return actionResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for business context action counts.
   *
   * @return  Long
   */
  public Long getBusinessContextActionCounts() {
    return businessContextActionCounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for business context name.
   *
   * @return  String
   */
  public String getBusinessContextName() {
    return businessContextName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for action results.
   *
   * @param  actionResults  Map
   */
  public void setActionResults(Map<String, BusinessContextActionTypeResult> actionResults) {
    this.actionResults = actionResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for action type counts.
   *
   * @param  actionType       String
   * @param  uniqueBciCounts  Long
   */
  public void setActionTypeCounts(String actionType, Long uniqueBciCounts) {
    BusinessContextActionTypeResult actionTypeResult = actionResults.get(actionType);

    if (actionTypeResult != null) {
      actionTypeResult.setUniqueBciCounts(uniqueBciCounts + actionTypeResult.getUniqueBciCounts());
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for business context action counts.
   *
   * @param  businessContextActionCounts  Long
   */
  public void setBusinessContextActionCounts(Long businessContextActionCounts) {
    this.businessContextActionCounts = businessContextActionCounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for business context name.
   *
   * @param  businessContextName  String
   */
  public void setBusinessContextName(String businessContextName) {
    this.businessContextName = businessContextName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * sortResults.
   */
  public void sortResults() {
    for (BusinessContextActionTypeResult actionResult : actionResults.values()) {
      actionResult.sortResults();
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("BusinessContextActionResult");
    sb.append("{actionResults=").append(actionResults);
    sb.append(", businessContextActionCounts=").append(businessContextActionCounts);
    sb.append(", businessContextName='").append(businessContextName).append('\'');
    sb.append('}');

    return sb.toString();
  }
} // end class BusinessContextActionResult
