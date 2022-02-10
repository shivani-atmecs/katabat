package com.ozstrategy.credagility.el.context.operator;

import java.math.BigDecimal;


/**
 * Number Operator.
 *
 * @User:    Wang Yang
 * @Date:    13-5-27
 * @Time:    PM4:30
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public class NumberOperator implements Operator {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  protected BigDecimal result = new BigDecimal("0.00");

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  Operator#push(Object, int)
   */
  @Override public void push(Object value, int index) {
    if (value != null) {
      result = result.add(new BigDecimal(value.toString()));
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Operator#value()
   */
  @Override public Object value() {
    return result;
  }
} // end class NumberOperator
