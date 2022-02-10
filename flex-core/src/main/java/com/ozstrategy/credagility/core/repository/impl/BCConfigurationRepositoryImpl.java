package com.ozstrategy.credagility.core.repository.impl;

import com.cmc.credagility.core.domain.businesscontext.BCFilterSorterVariable;
import com.ozstrategy.credagility.core.repository.BCConfigurationRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/31/2014 15:52
 */
@Repository("bcConfigurationRepository")
public class BCConfigurationRepositoryImpl implements BCConfigurationRepository {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  @PersistenceContext private EntityManager em;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCConfigurationRepository#getFilterVariablesByBusinessContext(Long)
   */
  @Override public List<BCFilterSorterVariable> getFilterVariablesByBusinessContext(Long businessContextId) {
    String hql = "From BCFilterSorterVariable fsVariable where fsVariable.businessContext.id = :id";

    return em.createQuery(hql).setParameter("id", businessContextId).getResultList();

  }
}
