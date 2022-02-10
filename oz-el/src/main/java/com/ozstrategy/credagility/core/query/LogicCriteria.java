package com.ozstrategy.credagility.core.query;

import java.util.HashSet;
import java.util.Set;


/**
 * Created by wangy on 11/28/14.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  11/28/2014 22:27 PM
 */
public abstract class LogicCriteria implements QueryCriteria {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  protected String name;

  /** TODO: DOCUMENT ME! */
  protected String paramKey;

  /** TODO: DOCUMENT ME! */
  protected Object value;

  private CriteriaParam param;

  private Set<CriteriaParam> params = new HashSet<>();

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new LogicCriteria object.
   *
   * @param  name   String
   * @param  value  Object
   */
  public LogicCriteria(String name, Object value) {
    this.name     = name;
    this.value    = value;
    this.paramKey = this.name + "_" + System.currentTimeMillis();
    this.param    = new CriteriaParam(this.paramKey, this.value);
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for param.
   *
   * @return  CriteriaParam
   */
  public CriteriaParam getParam() {
    return param;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  QueryCriteria#getParams()
   */
  @Override public Set<CriteriaParam> getParams() {
    if (params.size() == 0) {
      params.add(getParam());
    }

    return params;
  }
} // end class LogicCriteria
