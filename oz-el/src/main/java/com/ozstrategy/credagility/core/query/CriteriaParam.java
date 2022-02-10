package com.ozstrategy.credagility.core.query;

/**
 * Created by wangy on 11/28/14.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  11/28/2014 22:09 PM
 */
public class CriteriaParam {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String paramName;
  private Object value;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new CriteriaParam object.
   *
   * @param  paramName  String
   * @param  value      Object
   */
  public CriteriaParam(String paramName, Object value) {
    this.paramName = paramName;
    this.value     = value;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#equals(Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    CriteriaParam that = (CriteriaParam) o;

    if (!paramName.equals(that.paramName)) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for param name.
   *
   * @return  String
   */
  public String getParamName() {
    return paramName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for value.
   *
   * @return  Object
   */
  public Object getValue() {
    return value;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    return paramName.hashCode();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for param name.
   *
   * @param  paramName  String
   */
  public void setParamName(String paramName) {
    this.paramName = paramName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for value.
   *
   * @param  value  Object
   */
  public void setValue(Object value) {
    this.value = value;
  }
} // end class CriteriaParam
