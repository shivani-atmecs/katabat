package com.ozstrategy.credagility.core.repository.impl;

import com.ozstrategy.credagility.core.repository.UniversalRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;


/**
 * Created by wangy on 11/22/14.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  11/22/2014 23:25 PM
 */
@Repository @Transactional public class UniversalRepositoryImpl implements UniversalRepository {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  @PersistenceContext private EntityManager em;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.UniversalRepository#executeUpdate(String, Object[])
   */
  @Override public int executeUpdate(String sql, Object... arguments) {
    Query query = em.createQuery(sql);

    for (int i = 0; i < arguments.length;) {
      Object argument = arguments[i];
      i++;
      query.setParameter(i, argument);
    }

    return query.executeUpdate();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.UniversalRepository#get(Class, java.io.Serializable)
   */
  @Override public <T> T get(Class<T> clazz, Serializable entityId) {
    return em.find(clazz, entityId);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.UniversalRepository#save(Object)
   */
  @Override public <T> T save(T entity) {
    return em.merge(entity);
  }
} // end class UniversalRepositoryImpl
