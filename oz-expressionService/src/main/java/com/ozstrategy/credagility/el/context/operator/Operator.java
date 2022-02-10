package com.ozstrategy.credagility.el.context.operator;

/**
 * Operator for expression.
 *
 * @User:    Wang Yang
 * @Date:    13-5-27
 * @Time:    PM4:17
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public interface Operator {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  value  DOCUMENT ME!
   * @param  index  DOCUMENT ME!
   */
  void push(Object value, int index);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  Object value();
}
