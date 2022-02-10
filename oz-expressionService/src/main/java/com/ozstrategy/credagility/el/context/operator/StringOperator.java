package com.ozstrategy.credagility.el.context.operator;


/**
 * Created with IntelliJ IDEA.
 *
 * @User:    Wang Yang
 * @Date:    13-5-27
 * @Time:    PM4:41
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public class StringOperator implements Operator {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  protected StringBuilder result = new StringBuilder();

  /** DOCUMENT ME! */
  protected String separator = "";

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new StringOperator object.
   */
  public StringOperator() { }

  /**
   * Creates a new StringOperator object.
   *
   * @param  separator  DOCUMENT ME!
   */
  public StringOperator(String separator) {
    this.separator = separator;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  Operator#push(Object, int)
   */
  @Override public void push(Object value, int index) {
    if (value != null) {
      if (index != 0) {
        result.append(separator);
      }

      result.append(value.toString());
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Operator#value()
   */
  @Override public Object value() {
    return result.toString();
  }
} // end class StringOperator
