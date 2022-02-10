package com.ozstrategy.credagility.core.query;

import java.util.Set;


/**
 * Query Criteria.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  11/28/2014 11:18 AM
 */
public interface QueryCriteria {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for param.
   *
   * @return  Set
   */
  Set<CriteriaParam> getParams();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for query.
   *
   * @return  String
   */
  String getQuery();
}
