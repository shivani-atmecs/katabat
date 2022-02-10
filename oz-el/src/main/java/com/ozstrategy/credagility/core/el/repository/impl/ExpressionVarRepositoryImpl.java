package com.ozstrategy.credagility.core.el.repository.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Repository;

import com.cmc.credagility.core.domain.variable.BaseVariable;

import com.ozstrategy.credagility.core.el.ElContext;
import com.ozstrategy.credagility.core.el.ElObject;
import com.ozstrategy.credagility.core.query.CriteriaBuilder;
import com.ozstrategy.credagility.core.query.SimpleCriteria;
import com.ozstrategy.credagility.core.el.repository.ExpressionVarRepository;


/**
 * Created by wangy on 11/27/14.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  11/28/2014 00:42 AM
 */
@Repository public class ExpressionVarRepositoryImpl implements ExpressionVarRepository {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final Logger logger = LoggerFactory.getLogger(ExpressionVarRepositoryImpl.class);

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @PersistenceContext private EntityManager em;

  //~ Methods ----------------------------------------------------------------------------------------------------------

// @Cacheable(cacheName = "contextVariablesCache")
  /**
   * getter method for context variables.
   *
   * @param   cacheKey  String
   * @param   context   ElContext
   *
   * @return  Collection
   */
  @Override public Collection<? extends BaseVariable> getContextVariables(String cacheKey, ElContext context) {
    if (logger.isDebugEnabled()) {
      logger.debug("Load variables with key#" + cacheKey);
    }

    return context.getVariables(this);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for el context.
   *
   * @param   cacheKey  String
   * @param   object    ElObject
   *
   * @return  ElContext
   */
  @Override public ElContext getElContext(String cacheKey, ElObject object) {
    if (logger.isDebugEnabled()) {
      logger.debug("Create ElContext for key#" + cacheKey);
    }

    return object.getContext();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.el.repository.ExpressionVarRepository#getVariable(com.ozstrategy.credagility.core.query.SimpleCriteria[])
   */
  @Override public BaseVariable getVariable(SimpleCriteria... params) {
    for (SimpleCriteria param : params) {
      Query query = CriteriaBuilder.build(em, param);

      List list = query.getResultList();

      if (list.size() > 0) {
        return (BaseVariable) list.get(0);
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.el.repository.ExpressionVarRepository#getVariables(com.ozstrategy.credagility.core.query.SimpleCriteria[])
   */
  @Override public List<BaseVariable> getVariables(SimpleCriteria[] params) {
    List<BaseVariable> vars = new ArrayList<BaseVariable>();

    for (SimpleCriteria param : params) {
      Query query = CriteriaBuilder.build(em, param);
      List  list  = query.getResultList();
      vars.addAll(list);
    }

    return vars;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.el.repository.ExpressionVarRepository#preFetchEntity(Object)
   */
  @Override public <T> T preFetchEntity(T object) {
    return object;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.el.repository.ExpressionVarRepository#readBCIVariables(Long)
   */
  @Override public Collection<? extends BaseVariable> readBCIVariables(Long businessContextId) {
    return em.createQuery("from BCVariable where businessContext.id = :bcId").setParameter("bcId", businessContextId)
      .getResultList();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.el.repository.ExpressionVarRepository#readPortfolioVariables(Long, String[])
   */
  @Override public Collection<? extends BaseVariable> readPortfolioVariables(Long portfolioId, String[] contexts) {
    if (portfolioId == null) {
      return Collections.emptyList();
    }

    if (contexts == null) {
      return em.createQuery("from PortfolioVariable where portfolio.portfolioId=:portfolioId").setParameter(
          "portfolioId", portfolioId).getResultList();
    }

    return em.createQuery(
        "from PortfolioVariable where context in (:contexts) and portfolio.portfolioId=:portfolioId").setParameter(
        "portfolioId", portfolioId).setParameter("contexts", Arrays.asList(contexts)).getResultList();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.el.repository.ExpressionVarRepository#readSurveyFlowVariables(Long, String[])
   */
  @Override public Collection<? extends BaseVariable> readSurveyFlowVariables(Long portfolioId, String[] contexts) {
    if (portfolioId == null) {
      return Collections.emptyList();
    }

    if (contexts == null) {
      return em.createQuery("from SurveyFlowVariable where portfolio.portfolioId=:portfolioId").setParameter(
          "portfolioId", portfolioId).getResultList();
    }

    return em.createQuery(
        "from SurveyFlowVariable where context in (:contexts) and portfolio.portfolioId=:portfolioId").setParameter(
        "portfolioId", portfolioId).setParameter("contexts", Arrays.asList(contexts)).getResultList();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.el.repository.ExpressionVarRepository#readSystemVariables(String[])
   */
  @Override public Collection<? extends BaseVariable> readSystemVariables(String[] contexts) {
    if (contexts == null) {
      return em.createQuery("from Variable").getResultList();
    }

    return em.createQuery("from Variable where context in (:contexts)").setParameter("contexts",
        Arrays.asList(contexts)).getResultList();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.el.repository.ExpressionVarRepository#readUtilityVariables(String[])
   */
  @Override public Collection<? extends BaseVariable> readUtilityVariables(String[] contexts) {
    return em.createQuery("FROM UtilityHiddenVariable v WHERE v.context IN (:contexts) ").setParameter(
        "contexts", Arrays.asList(contexts)).getResultList();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.el.repository.ExpressionVarRepository#readVariables(Long, String[])
   */
  @Override public Collection<? extends BaseVariable> readVariables(Long portfolioId, String[] contexts) {
    StringBuffer sql = new StringBuffer();

    // load system variable.
    sql.append("SELECT v.* from Variable v where (v.variableType='System' OR v.variableType='UtilityHidden') ").append(
      (contexts != null) ? " AND v.context IN (:contexts) " : "");

    // load portfolio variable
    if (portfolioId != null) {
      sql.append(
        " UNION SELECT v.* FROM Variable v WHERE v.portfolioId=:portfolioId ");
      sql.append((contexts != null) ? " AND ( v.context IN (:contexts) ) " : "");
      sql.append("  AND (v.variableType='Portfolio' OR v.variableType='SurveyFlow') ");
    }

    Query query = em.createNativeQuery(sql.toString(), BaseVariable.class);

    if (contexts != null) {
      query.setParameter("contexts", Arrays.asList(contexts));
    }

    if (portfolioId != null) {
      query.setParameter("portfolioId", portfolioId);
    }

    return query.getResultList();
  } // end method readVariables

  //~ ------------------------------------------------------------------------------------------------------------------


  /**
   * @see  com.ozstrategy.credagility.core.el.repository.ExpressionVarRepository#readWorkflowVariables(String[])
   */
  @Override public Collection<? extends BaseVariable> readWorkflowVariables(String[] contexts) {
    if (contexts == null) {
      return em.createQuery("from WorkflowVariable").getResultList();
    }

    return em.createQuery("from WorkflowVariable where context in (:contexts)").setParameter("contexts",
        Arrays.asList(contexts)).getResultList();
  }
} // end class ExpressionVarRepositoryImpl
