package com.ozstrategy.credagility.core.domain;

import java.util.*;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/16/2014 12:27
 */
public class BusinessContextActionTypeResult {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  protected String actionType;


  /** TODO: DOCUMENT ME! */
  protected Long totalBciCounts = 0L;


  /** TODO: DOCUMENT ME! */
  protected Long uniqueBciCounts = 0L;


  /** TODO: DOCUMENT ME! */
  Map<String, Long> categoryBciCounts = new HashMap<String, Long>();


  /** TODO: DOCUMENT ME! */
  Map<String, BusinessContextProcessActionResult> map = new HashMap<String, BusinessContextProcessActionResult>();


  /** TODO: DOCUMENT ME! */
  Map<String, List<BusinessContextProcessActionResult>> results = new HashMap<>();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addResult.
   *
   * @param  actionResult  BusinessContextProcessActionResult
   */
  public void addResult(BusinessContextProcessActionResult actionResult) {
    updateResult("", actionResult);
    this.totalBciCounts += actionResult.getActionBciCounts();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addResult.
   *
   * @param  category      String
   * @param  actionResult  BusinessContextProcessActionResult
   */
  public void addResult(String category, BusinessContextProcessActionResult actionResult) {
    updateResult(category, actionResult);
    this.totalBciCounts += actionResult.getActionBciCounts();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for action type.
   *
   * @return  String
   */
  public String getActionType() {
    return actionType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for category bci counts.
   *
   * @return  Map
   */
  public Map<String, Long> getCategoryBciCounts() {
    return categoryBciCounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for map.
   *
   * @return  Map
   */
  public Map<String, BusinessContextProcessActionResult> getMap() {
    return map;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for results.
   *
   * @return  Map
   */
  public Map<String, List<BusinessContextProcessActionResult>> getResults() {
    return results;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for total bci counts.
   *
   * @return  Long
   */
  public Long getTotalBciCounts() {
    return totalBciCounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for unique bci counts.
   *
   * @return  Long
   */
  public Long getUniqueBciCounts() {
    return uniqueBciCounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for action type.
   *
   * @param  actionType  String
   */
  public void setActionType(String actionType) {
    this.actionType = actionType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for category bci counts.
   *
   * @param  categoryBciCounts  Map
   */
  public void setCategoryBciCounts(Map<String, Long> categoryBciCounts) {
    this.categoryBciCounts = categoryBciCounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for map.
   *
   * @param  map  Map
   */
  public void setMap(Map<String, BusinessContextProcessActionResult> map) {
    this.map = map;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for results.
   *
   * @param  results  Map
   */
  public void setResults(Map<String, List<BusinessContextProcessActionResult>> results) {
    this.results = results;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for total bci counts.
   *
   * @param  totalBciCounts  Long
   */
  public void setTotalBciCounts(Long totalBciCounts) {
    this.totalBciCounts = totalBciCounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for unique bci counts.
   *
   * @param  uniqueBciCounts  Long
   */
  public void setUniqueBciCounts(Long uniqueBciCounts) {
    this.uniqueBciCounts = uniqueBciCounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * sortResults.
   */
  public void sortResults() {
    for (List<BusinessContextProcessActionResult> list : results.values()) {
      Collections.sort(list);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("ActionTypeResult");
    sb.append("{actionType='").append(actionType).append('\'');
    sb.append(", totalBciCounts=").append(totalBciCounts);
    sb.append(", categoryBciCounts=");

    for (String key : categoryBciCounts.keySet()) {
      Object value = categoryBciCounts.get(key);
      sb.append(key + "=" + value.toString() + "::");
    }

    sb.append(", results=");

    for (String key : results.keySet()) {
      Object value = results.get(key);
      sb.append(key + "=" + value.toString() + "::");
    }

    sb.append('}');

    return sb.toString();
  } // end method toString

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updateResult.
   *
   * @param  category      String
   * @param  actionResult  BusinessContextProcessActionResult
   */
  protected void updateResult(String category, BusinessContextProcessActionResult actionResult) {
    List<BusinessContextProcessActionResult> list = results.get(category);

    if (list == null) {
      list = new ArrayList<BusinessContextProcessActionResult>();
      results.put(category, list);
    }

    Long categoryBciCount = categoryBciCounts.get(category);
    Long actionBciCount   = actionResult.getActionBciCounts();

    if (categoryBciCount == null) {
      categoryBciCount = actionBciCount;
    } else {
      categoryBciCount += actionBciCount;
    }

    categoryBciCounts.put(category, actionBciCount);

    BaseNodeAction action   = actionResult.getAction();
    Long           actionId = action.getId();

    if (actionId != null) {
      String key = action.getActionType() + "#" + actionId;

      BusinessContextProcessActionResult curResult = map.get(key);

      if (curResult != null) {
        list.remove(curResult);
      }

      // update result
      map.put(key, actionResult);
      list.add(actionResult);
    }
  } // end method updateResult
} // end class BusinessContextActionTypeResult
