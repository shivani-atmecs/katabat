package com.ozstrategy.credagility.core.helper;

import com.ozstrategy.credagility.core.domain.Node;

import java.util.Collection;
import java.util.Map;
import java.util.Set;


/**
 * Created by IntelliJ IDEA. User: rojer Date: Sep 10, 2010 Time: 10:15:20 PM To change this template use File |
 * Settings | File Templates.
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo</a>
 * @version  10/18/2014 11:49
 */
public interface ExecuteHelper {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addCascadeObject.
   *
   * @param  objectName  String
   * @param  result      Object
   */
  void addCascadeObject(String objectName, Object result);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  result  DOCUMENT ME!
   */
  void addResult(Object result);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  result  DOCUMENT ME!
   */
  void addResult2(Object result);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  results  DOCUMENT ME!
   */
  void addResults(Collection results);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addSingleObject.
   *
   * @param  objectName  String
   * @param  result      Object
   */
  void addSingleObject(String objectName, Object result);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  Map<String, Object> getParameters();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  Set<Object> getResult2s();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  Set<Object> getResults();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for current node.
   *
   * @param  node  Node
   */
  void setCurrentNode(Node node);
} // end interface ExecuteHelper
