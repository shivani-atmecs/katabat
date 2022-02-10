package com.ozstrategy.credagility.core.query;

import java.util.Arrays;
import java.util.List;


/**
 * Created by wangy on 11/28/14.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  11/28/2014 22:08 PM
 */
public class InCriteria extends LogicCriteria {
  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new LogicCriteria object.
   *
   * @param  name   String
   * @param  value  Object
   */
  public InCriteria(String name, List<Object> value) {
    super(name, value);
  }

  /**
   * Creates a new InCriteria object.
   *
   * @param  name   String
   * @param  value  Object[]
   */
  public InCriteria(String name, Object[] value) {
    super(name, Arrays.asList(value));
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.query.QueryCriteria#getQuery()
   */
  @Override public String getQuery() {
    return this.name + " IN :" + this.paramKey;
  }
} // end class InCriteria
