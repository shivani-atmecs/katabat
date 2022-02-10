package com.ozstrategy.credagility.core.util;

import java.io.Serializable;
import java.util.Comparator;


/**
 * Created by IntelliJ IDEA. User: liaodongming Date: 11-8-1 Time: PM6:46 To change this template use File | Settings |
 * File Templates.
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo</a>
 * @version  10/18/2014 11:49
 */
public class ActionResultComparator implements Comparator<String>, Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 3064999550854394971L;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.util.Comparator#compare(Object, Object)
   */
  @Override public int compare(String o, String o1) {
    // it used to sort keys to QueueProgramChannel
    String so  = (String) o;
    String so1 = (String) o1;

    return so1.compareTo(so);
  }
} // end class ActionResultComparator
