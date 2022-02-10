package com.ozstrategy.credagility.core.query;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by wangy on 11/29/14.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  11/29/2014 15:23 PM
 */
public class CriteriaBuilder {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final Logger logger = LoggerFactory.getLogger(CriteriaBuilder.class);

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * build.
   *
   * @param   em        EntityManager
   * @param   criteria  SimpleCriteria
   *
   * @return  build.
   */
  public static Query build(EntityManager em, SimpleCriteria criteria) {
    StringBuilder queryString = new StringBuilder("FROM ");
    queryString.append(criteria.getEntityClass().getName());

    RelationCriteria relationCriteria = criteria.getCriteria();

    if (relationCriteria != null) {
      queryString.append(" WHERE ");
      queryString.append(relationCriteria.getQuery());
    }

    if (logger.isDebugEnabled()) {
      logger.debug("Build query: " + queryString.toString());
    }

    Query query = em.createQuery(queryString.toString());

    if (relationCriteria != null) {
      for (CriteriaParam param : relationCriteria.getParams()) {
        if (logger.isDebugEnabled()) {
          logger.debug("Set Param: [" + param.getParamName() + " : " + param.getValue());
        }

        query.setParameter(param.getParamName(), param.getValue());
      }
    }

    return query;
  } // end method build
} // end class CriteriaBuilder
