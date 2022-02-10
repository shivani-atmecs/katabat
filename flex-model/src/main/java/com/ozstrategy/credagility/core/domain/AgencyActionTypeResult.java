package com.ozstrategy.credagility.core.domain;

import java.util.*;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/16/2014 10:19
 */
public class AgencyActionTypeResult {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  protected String actionType;


  /** TODO: DOCUMENT ME! */
  protected Long totalAgencyCounts = 0L;


  /** TODO: DOCUMENT ME! */
  protected Long uniqueAgencyCounts = 0L;


  /** TODO: DOCUMENT ME! */
  Map<String, Long> categoryAgencyCounts = new HashMap<String, Long>();


  /** TODO: DOCUMENT ME! */
  Map<String, AgencyProcessActionResult> map = new HashMap<String, AgencyProcessActionResult>();


  /** TODO: DOCUMENT ME! */
  Map<String, List<AgencyProcessActionResult>> results = new HashMap<>();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addResult.
   *
   * @param  actionResult  AgencyProcessActionResult
   */
  public void addResult(AgencyProcessActionResult actionResult) {
    updateResult("", actionResult);
    this.totalAgencyCounts += actionResult.getActionAgencyCounts();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addResult.
   *
   * @param  category      String
   * @param  actionResult  AgencyProcessActionResult
   */
  public void addResult(String category, AgencyProcessActionResult actionResult) {
    updateResult(category, actionResult);
    this.totalAgencyCounts += actionResult.getActionAgencyCounts();
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
   * getter method for category agency counts.
   *
   * @return  Map
   */
  public Map<String, Long> getCategoryAgencyCounts() {
    return categoryAgencyCounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for map.
   *
   * @return  Map
   */
  public Map<String, AgencyProcessActionResult> getMap() {
    return map;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Map<String, List<AgencyProcessActionResult>> getResults() {
    return results;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for total agency counts.
   *
   * @return  Long
   */
  public Long getTotalAgencyCounts() {
    return totalAgencyCounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for unique agency counts.
   *
   * @return  Long
   */
  public Long getUniqueAgencyCounts() {
    return uniqueAgencyCounts;
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
   * setter method for category agency counts.
   *
   * @param  categoryAgencyCounts  Map
   */
  public void setCategoryAgencyCounts(Map<String, Long> categoryAgencyCounts) {
    this.categoryAgencyCounts = categoryAgencyCounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for map.
   *
   * @param  map  Map
   */
  public void setMap(Map<String, AgencyProcessActionResult> map) {
    this.map = map;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for results.
   *
   * @param  results  Map
   */
  public void setResults(Map<String, List<AgencyProcessActionResult>> results) {
    this.results = results;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for total agency counts.
   *
   * @param  totalAgencyCounts  Long
   */
  public void setTotalAgencyCounts(Long totalAgencyCounts) {
    this.totalAgencyCounts = totalAgencyCounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for unique agency counts.
   *
   * @param  uniqueAgencyCounts  Long
   */
  public void setUniqueAgencyCounts(Long uniqueAgencyCounts) {
    this.uniqueAgencyCounts = uniqueAgencyCounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * sortResults.
   */
  public void sortResults() {
    for (List<AgencyProcessActionResult> list : results.values()) {
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
    sb.append(", totalAgencyCounts=").append(totalAgencyCounts);
    sb.append(", categoryAgencyCounts=");

    for (String key : categoryAgencyCounts.keySet()) {
      Object value = categoryAgencyCounts.get(key);
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
   * @param  actionResult  AgencyProcessActionResult
   */
  protected void updateResult(String category, AgencyProcessActionResult actionResult) {
    List<AgencyProcessActionResult> list = results.get(category);

    if (list == null) {
      list = new ArrayList<AgencyProcessActionResult>();
      results.put(category, list);
    }

    Long categoryAgencyCount = categoryAgencyCounts.get(category);
    Long actionAgencyCount   = actionResult.getActionAgencyCounts();

    if (categoryAgencyCount == null) {
      categoryAgencyCount = actionAgencyCount;
    } else {
      categoryAgencyCount += actionAgencyCount;
    }

    categoryAgencyCounts.put(category, actionAgencyCount);

    BaseNodeAction action   = actionResult.getAction();
    Long           actionId = action.getId();

    if (actionId != null) {
      String key = action.getActionType() + "#" + actionId;

      AgencyProcessActionResult curResult = map.get(key);

      if (curResult != null) {
        list.remove(curResult);
      }

      // update result
      map.put(key, actionResult);
      list.add(actionResult);
    }
  } // end method updateResult
} // end class AgencyActionTypeResult
