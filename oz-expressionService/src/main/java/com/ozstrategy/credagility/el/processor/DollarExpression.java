package com.ozstrategy.credagility.el.processor;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Expression like this: ${expression}
 *
 * @User:    wangy
 * @Date:    12-8-27
 * @Time:    AM10:07 To change this template use File | Settings | File Templates.
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public class DollarExpression {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  protected int endIndex = 1;

  /** DOCUMENT ME! */
  protected int startIndex = 2;

  private String content;
  private String expression;

  /** DOCUMENT ME! */
  private final transient Logger logger = LoggerFactory.getLogger(getClass());

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new DollarExpression object.
   *
   * @param  content  DOCUMENT ME!
   */
  public DollarExpression(String content) {
    initIndex();

    try {
      this.content    = content;
      this.expression = content.substring(startIndex, content.length() - endIndex);
    } catch (Exception e) {
      logger.error("Invalid expression:" + content);
    }
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getContent() {
    return content;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getExpression() {
    return expression;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  content  DOCUMENT ME!
   */
  public void setContent(String content) {
    this.content = content;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   */
  protected void initIndex() {
    this.startIndex = 2;
    this.endIndex   = 1;
  }
} // end class DollarExpression
