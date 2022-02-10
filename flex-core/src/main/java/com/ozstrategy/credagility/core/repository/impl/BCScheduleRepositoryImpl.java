package com.ozstrategy.credagility.core.repository.impl;

import com.ozstrategy.credagility.core.domain.decisiontree.businesscontext.BCDefaultQueueSortCriteria;
import com.ozstrategy.credagility.core.domain.decisiontree.businesscontext.BCSchedule;
import com.ozstrategy.credagility.core.repository.BCScheduleRepository;
import com.ozstrategy.credagility.core.repository.OzHibernateDaoSupport;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  03/27/2015 11:52
 */
@Repository("bcScheduleRepository")
public class BCScheduleRepositoryImpl extends OzHibernateDaoSupport implements BCScheduleRepository {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCScheduleRepository#getActiveSchedules(Long)
   */
  @Override public List<BCSchedule> getActiveSchedules(Long businessContextId) {
    String queryString =
      "from BCSchedule s where s.businessContext.id = :id and s.scheduleStatus != 'DELETED' and s.scheduleStatus = 'ACTIVE'";

    List<BCSchedule> result = em.createQuery(queryString).setParameter("id",
        businessContextId).getResultList();

    for (BCSchedule schedule : result) {
      Hibernate.initialize(schedule.getStrategies());
    }

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCScheduleRepository#populateQueueOrderResultInBusinessContext(String)
   */
  @Override public void populateQueueOrderResultInBusinessContext(String context) throws SQLException {
    em.createNativeQuery(
      "{call usp_PopulateQueueOrderResultInBusinessContext(?)}").setParameter(1, context).executeUpdate();
    getHibernateTemplate().flush();
  }

  //~ ------------------------------------------------------------------------------------------------------------------
  
  /**
   * @see  com.ozstrategy.credagility.core.repository.BCScheduleRepository#populateQueueOrderResultInBusinessContextWithNewSession(String)
   */
  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void populateQueueOrderResultInBusinessContextWithNewSession(String context) throws SQLException {
    em.createNativeQuery(
      "{call usp_PopulateQueueOrderResultInBusinessContext(?)}").setParameter(1, context).executeUpdate();
    getHibernateTemplate().flush();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCScheduleRepository#queryQueueSortCriteria(String)
   */
  @Override public List<BCDefaultQueueSortCriteria> queryQueueSortCriteria(String businessContext) {
    try {
      String hql = "select distinct qos from BCDefaultQueueSortCriteria qos left join fetch qos.criteriaVariable"
        + " left join fetch qos.variableMetaDataField "
        + " left join fetch qos.bcAvailableMappingField "
        + " left join fetch qos.queueAction qAction"
        + " left join fetch qAction.assignAgents u"
        + " left join fetch u.roles"
        + " left join fetch qAction.assignRoles"
        + " where (qos.asMappingField = :mField or qos.asMappingField is null) and qos.queueAction.businessContext.context = :context ";

      return getSession().createQuery(hql).setParameter("mField", Boolean.FALSE).setParameter("context",
          businessContext).list();
    } catch (Exception e) {
      logger.error(e, e);
    }

    return null;
  }
} // end class BCScheduleRepositoryImpl
