package com.ozstrategy.credagility.core.el.repository;

/**
 * Created by coin on 6/29/16.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  06/29/2016 11:16
 */
public interface VariableValueAuditRepository {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * save.
   *
   * @param   <T>     T
   * @param   entity  T
   *
   * @return  T
   */
  <T> T save(T entity);

}
