package com.ozstrategy.credagility.core.query;

/**
 * Created by wangy on 11/28/14.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  11/28/2014 11:25 AM
 */
public class OrCriteria extends RelationCriteria {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  QueryCriteria#getQuery()
   */
  @Override public String getQuery() {
    int len = items.size();

    if (len > 0) {
      StringBuilder sb = new StringBuilder("(");

      for (int i = 0; i < len; i++) {
        if (i != 0) {
          sb.append(" or ");
        }

        sb.append(items.get(i).getQuery());
      }

      sb.append(")");

      return sb.toString();
    }

    return "";
  }
} // end class OrCriteria
