package com.ozstrategy.credagility.el.processor;

/**
 * Created with IntelliJ IDEA.
 *
 * @User:    wangy
 * @Date:    12-8-27
 * @Time:    PM12:24 To change this template use File | Settings | File Templates.
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public abstract class ExpressionProcessor {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   expression  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public abstract String process(DollarExpression expression);
}
