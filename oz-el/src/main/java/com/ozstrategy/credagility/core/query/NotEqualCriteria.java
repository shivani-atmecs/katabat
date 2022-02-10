package com.ozstrategy.credagility.core.query;

/**
 * Created by wangy on 11/28/14.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  11/28/2014 22:08 PM
 */
public class NotEqualCriteria extends LogicCriteria {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  private boolean ignoreCase;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new LogicCriteria object.
   *
   * @param  name   String
   * @param  value  Object
   */
  public NotEqualCriteria(String name, Object value) {
    super(name, value);
  }

  /**
   * Creates a new EqualCriteria object.
   *
   * @param  name        String
   * @param  value       Object
   * @param  ignoreCase  boolean
   */
  public NotEqualCriteria(String name, Object value, boolean ignoreCase) {
    super(name, value);
    this.ignoreCase = ignoreCase;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.query.QueryCriteria#getQuery()
   */
  @Override public String getQuery() {
    if (ignoreCase) {
      return "UPPER(" + this.name + ") != UPPER(:" + this.paramKey + ")";
    }

    return this.name + "!=:" + this.paramKey;
  }
} // end class NotEqualCriteria
