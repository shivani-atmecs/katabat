package com.ozstrategy.credagility.core.domain;

import java.util.*;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/16/2014 10:17
 */
public class ActionTypeResult {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  protected String actionType;


  /** TODO: DOCUMENT ME! */
  protected Long totalAccounts = 0L;


  /** TODO: DOCUMENT ME! */
  protected Long totalResponsibles = 0L;


  /** TODO: DOCUMENT ME! */
  protected Long uniqueAccounts = 0L;


  /** TODO: DOCUMENT ME! */
  protected Long uniqueResponsibles = 0L;


  /** TODO: DOCUMENT ME! */
  Map<String, Long> categoryAccounts = new HashMap<String, Long>();


  /** TODO: DOCUMENT ME! */
  Map<String, Long> categoryResponsibles = new HashMap<String, Long>();


  /** TODO: DOCUMENT ME! */
  Map<String, ProcessActionResult> map = new HashMap<String, ProcessActionResult>();


  /** TODO: DOCUMENT ME! */
  Map<String, List<ProcessActionResult>> results = new HashMap<>();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addResult.
   *
   * @param  actionResult  ProcessActionResult
   */
  public void addResult(ProcessActionResult actionResult) {
    updateResult("", actionResult);
    this.totalAccounts += actionResult.getActionAccounts();

    // this.uniqueAccounts = actionResult.getUniqueAccounts();
    this.totalResponsibles += actionResult.getActionResponsibles();

    // this.uniqueResponsibles = actionResult.getUniqueResponsibles();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addResult.
   *
   * @param  category      String
   * @param  actionResult  ProcessActionResult
   */
  public void addResult(String category, ProcessActionResult actionResult) {
    updateResult(category, actionResult);
    this.totalAccounts += actionResult.getActionAccounts();

    // this.uniqueAccounts = actionResult.getUniqueAccounts();
    this.totalResponsibles += actionResult.getActionResponsibles();

    // this.uniqueResponsibles = actionResult.getUniqueResponsibles();
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
   * getter method for category accounts.
   *
   * @return  Map
   */
  public Map<String, Long> getCategoryAccounts() {
    return categoryAccounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for category responsibles.
   *
   * @return  Map
   */
  public Map<String, Long> getCategoryResponsibles() {
    return categoryResponsibles;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for results.
   *
   * @return  Map
   */
  public Map<String, List<ProcessActionResult>> getResults() {
    return results;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // /**
  // * DOCUMENT ME!
  // *
  // * @param   category  DOCUMENT ME!
  // *
  // * @return  DOCUMENT ME!
  // */
  // public List<ProcessActionResult> getResults(String category) {
  // if (category == null) {
  // category = "";
  // }
  //
  // return results.get(category);
  // }


  /**
   * getter method for total accounts.
   *
   * @return  Long
   */
  public Long getTotalAccounts() {
    return totalAccounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for total responsibles.
   *
   * @return  Long
   */
  public Long getTotalResponsibles() {
    return totalResponsibles;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for unique accounts.
   *
   * @return  Long
   */
  public Long getUniqueAccounts() {
    return uniqueAccounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for unique responsibles.
   *
   * @return  Long
   */
  public Long getUniqueResponsibles() {
    return uniqueResponsibles;
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
   * setter method for total responsibles.
   *
   * @param  totalResponsibles  Long
   */
  public void setTotalResponsibles(Long totalResponsibles) {
    this.totalResponsibles = totalResponsibles;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for unique accounts.
   *
   * @param  uniqueAccounts  Long
   */
  public void setUniqueAccounts(Long uniqueAccounts) {
    this.uniqueAccounts = uniqueAccounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for unique responsibles.
   *
   * @param  uniqueResponsibles  Long
   */
  public void setUniqueResponsibles(Long uniqueResponsibles) {
    this.uniqueResponsibles = uniqueResponsibles;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // /**
  // * DOCUMENT ME!
  // *
  // * @param  results  DOCUMENT ME!
  // */
  // @Override
  // public void setResults(List<ProcessActionResult> results) {
  // this.results = results;
  // }
  //
  // //~ ------------------------------------------------------------------------------------------------------------------
  //
  // /**
  // * DOCUMENT ME!
  // *
  // * @param  totalAccounts  DOCUMENT ME!
  // */
  // @Override
  // public void setTotalAccounts(Long totalAccounts) {
  // this.totalAccounts = totalAccounts;
  // }
  //
  // //~ ------------------------------------------------------------------------------------------------------------------
  //
  // /**
  // * DOCUMENT ME!
  // *
  // * @param  uniqueAccounts  DOCUMENT ME!
  // */
  // @Override
  // public void setUniqueAccounts(Long uniqueAccounts) {
  // this.uniqueAccounts = uniqueAccounts;
  // }
  //

  /**
   * DOCUMENT ME!
   */
  public void sortResults() {
    for (List<ProcessActionResult> list : results.values()) {
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
    sb.append(", totalAccounts=").append(totalAccounts);
    sb.append(", totalResponsibles=").append(totalResponsibles);

    // sb.append(", uniqueAccounts=").append(uniqueAccounts);
    // sb.append(", uniqueResponsibles=").append(uniqueResponsibles);
    sb.append(", categoryAccounts=");

    for (String key : categoryAccounts.keySet()) {
      Object value = categoryAccounts.get(key);
      sb.append(key + "=" + value.toString() + "::");
    }

    sb.append(", categoryResponsibles=");

    for (String key : categoryResponsibles.keySet()) {
      Object value = categoryResponsibles.get(key);
      sb.append(key + "=" + value.toString() + "::");
    }

    sb.append(", results=");

    for (String key : results.keySet()) {
      Object value = results.get(key);
      sb.append(key + "=" + value.toString() + "::");
    }

    // sb.append(", map=").append(map);
    // sb.append(", results=").append(results);
    sb.append('}');

    return sb.toString();
  } // end method toString

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updateResult.
   *
   * @param  category      String
   * @param  actionResult  ProcessActionResult
   */
  protected void updateResult(String category, ProcessActionResult actionResult) {
    List<ProcessActionResult> list = results.get(category);

    if (list == null) {
      list = new ArrayList<ProcessActionResult>();
      results.put(category, list);
    }

    Long categoryAccount = categoryAccounts.get(category);
    Long actionAccount   = actionResult.getActionAccounts();

    if (categoryAccount == null) {
      categoryAccount = actionAccount;
    } else {
      categoryAccount += actionAccount;
    }

    categoryAccounts.put(category, categoryAccount);

    Long categoryResponsible = categoryResponsibles.get(category);
    Long actionRespsonsible  = actionResult.getActionResponsibles();

    if (categoryResponsible == null) {
      categoryResponsible = actionRespsonsible;
    } else {
      categoryResponsible += actionRespsonsible;
    }

    categoryResponsibles.put(category, categoryResponsible);

    BaseNodeAction action   = actionResult.getAction();
    Long           actionId = action.getId();
    Long           nodeId   = (actionResult.getNode() == null) ? 0L : actionResult.getNode().getId();

    if (actionId != null) {
      String key = action.actionType + "#" + actionId + "#" + nodeId;

      ProcessActionResult curResult = map.get(key);

      if (curResult != null) {
        list.remove(curResult);
      }

      // update result
      map.put(key, actionResult);
      list.add(actionResult);
    }
  } // end method updateResult
} // end class ActionTypeResult
