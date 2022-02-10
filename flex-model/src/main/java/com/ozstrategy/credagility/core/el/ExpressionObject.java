package com.ozstrategy.credagility.core.el;

import java.io.Serializable;


/**
 * Created with IntelliJ IDEA. User: l_python Date: 11/9/13 Time: 5:43 PM To change this template use File | Settings |
 * File Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public interface ExpressionObject extends Serializable {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  String getExpression();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  value  DOCUMENT ME!
   */
  void setValue(Object value);
}
