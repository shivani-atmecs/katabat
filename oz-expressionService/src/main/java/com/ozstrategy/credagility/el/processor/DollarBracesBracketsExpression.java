package com.ozstrategy.credagility.el.processor;


/**
 * Expression like this: ${[expression]}
 *
 * @User:    wangy
 * @Date:    12-8-27
 * @Time:    AM10:07 To change this template use File | Settings | File Templates.
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public class DollarBracesBracketsExpression extends DollarExpression {
  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new DollarExpression object.
   *
   * @param  content  DOCUMENT ME!
   */
  public DollarBracesBracketsExpression(String content) {
    super(content);
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.el.processor.DollarExpression#initIndex()
   */
  @Override protected void initIndex() {
    this.startIndex = 3;
    this.endIndex   = 2;
  }
} // end class DollarBracesBracketsExpression
