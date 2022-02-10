package com.ozstrategy.credagility.el.processor;

/**
 * Created with IntelliJ IDEA.
 *
 * @User:    wangy
 * @Date:    12-8-27
 * @Time:    PM12:22 To change this template use File | Settings | File Templates.
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public class BasicExpressionProcessor extends ExpressionProcessor {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  ExpressionProcessor#process(DollarExpression)
   */
  @Override public String process(DollarExpression expression) {
    return expression.getExpression();
  }
}
