package com.ozstrategy.credagility.core.query;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Created by wangy on 11/28/14.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  11/28/2014 11:25 AM
 */
public abstract class RelationCriteria implements QueryCriteria {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  protected List<QueryCriteria> items = new ArrayList<>();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * add.
   *
   * @param  criteria  QueryCriteria
   */
  public void add(QueryCriteria criteria) {
    this.items.add(criteria);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for items.
   *
   * @return  List
   */
  public List<QueryCriteria> getItems() {
    return items;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for params.
   *
   * @return  Set
   */
  @Override public Set<CriteriaParam> getParams() {
    Set<CriteriaParam> params = new HashSet<>();

    for (QueryCriteria item : items) {
      params.addAll(item.getParams());
    }

    return params;
  }
} // end class RelationCriteria
