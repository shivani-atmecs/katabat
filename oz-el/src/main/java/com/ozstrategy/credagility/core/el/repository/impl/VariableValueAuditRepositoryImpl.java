package com.ozstrategy.credagility.core.el.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ozstrategy.credagility.core.el.repository.VariableValueAuditRepository;


/**
 * Created by coin on 6/29/16.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  06/29/2016 11:17
 */
@Repository public class VariableValueAuditRepositoryImpl implements VariableValueAuditRepository {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  @PersistenceContext private EntityManager em;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.el.repository.VariableValueAuditRepository#save(Object)
   */
  @Override public <T> T save(T entity) {
    return em.merge(entity);
  }
}
