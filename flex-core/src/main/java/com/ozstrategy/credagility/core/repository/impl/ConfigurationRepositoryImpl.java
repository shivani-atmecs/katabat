package com.ozstrategy.credagility.core.repository.impl;

import com.cmc.credagility.core.domain.businesscontext.BCIGridConfig;
import com.cmc.credagility.core.domain.businesscontext.BCIStatusColorConfig;
import com.ozstrategy.credagility.core.repository.ConfigurationRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;



/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  03/27/2015 11:25
 */
@Repository("configurationRepository")
public class ConfigurationRepositoryImpl implements ConfigurationRepository {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  @PersistenceContext private EntityManager em;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.ConfigurationRepository#getBCIGridConfig(long)
   */
  @Override public List<BCIGridConfig> getBCIGridConfig(long businessContextId) {
    String hql = "from BCIGridConfig b where b.businessContext.id = :businessContextId order by b.priority";

    return em.createQuery(hql).setParameter("businessContextId", businessContextId).getResultList();

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.ConfigurationRepository#getBCIStatusColorConfig(long, int, int)
   */
  @Override public List<BCIStatusColorConfig> getBCIStatusColorConfig(long businessContextId, int start, int limit) {
    String hql   = "from BCIStatusColorConfig b where b.businessContext.id = :bId ";
    Query  query = em.createQuery(hql).setParameter("bId", businessContextId);

    if (limit > 0) {
      query.setFirstResult(start);
      query.setMaxResults(limit);
    }

    return query.getResultList();
  }
} // end class ConfigurationRepositoryImpl
