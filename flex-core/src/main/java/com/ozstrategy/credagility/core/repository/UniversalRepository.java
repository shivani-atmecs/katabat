package com.ozstrategy.credagility.core.repository;

import java.io.Serializable;


/**
 * Created by wangy on 11/22/14.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  11/25/2014 23:16 PM
 */
public interface UniversalRepository {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * executeUpdate.
   *
   * @param   sql        String
   * @param   arguments  Object
   *
   * @return  int
   */
  int executeUpdate(String sql, Object... arguments);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * get.
   *
   * @param   <T>       Serializable
   * @param   clazz     Class
   * @param   entityId  Serializable
   *
   * @return  T
   */
  <T> T get(Class<T> clazz, Serializable entityId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * save.
   *
   * @param   <T>     T
   * @param   entity  T
   *
   * @return  T
   */
  <T> T save(T entity);
} // end interface UniversalRepository
