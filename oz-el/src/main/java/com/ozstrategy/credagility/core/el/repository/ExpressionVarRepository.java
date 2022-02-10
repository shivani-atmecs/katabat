package com.ozstrategy.credagility.core.el.repository;

import java.util.Collection;
import java.util.List;

import com.cmc.credagility.core.domain.variable.BaseVariable;

import com.ozstrategy.credagility.core.el.ElContext;
import com.ozstrategy.credagility.core.el.ElObject;
import com.ozstrategy.credagility.core.query.SimpleCriteria;


/**
 * Created by wangyang on 10/28/14.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  10/28/2014 11:04 AM
 */
public interface ExpressionVarRepository {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for context variables.
   *
   * @param   variableCacheKey  String
   * @param   elContext         ElContext
   *
   * @return  Collection
   */
  Collection<? extends BaseVariable> getContextVariables(String variableCacheKey, ElContext elContext);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for el context.
   *
   * @param   cacheKey  String
   * @param   object    ElObject
   *
   * @return  ElContext
   */
  ElContext getElContext(String cacheKey, ElObject object);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for variable.
   *
   * @param   paras  SimpleCriteria
   *
   * @return  BaseVariable
   */
  BaseVariable getVariable(SimpleCriteria... paras);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for variables.
   *
   * @param   varHQLSearchParams  SimpleCriteria[]
   *
   * @return  List
   */
  List<BaseVariable> getVariables(SimpleCriteria[] varHQLSearchParams);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * preFetchEntity.
   *
   * @param   <T>     T
   * @param   object  Object
   *
   * @return  Object
   */
  <T> T preFetchEntity(T object);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * readBCIVariables.
   *
   * @param   businessContextId  Long
   *
   * @return  Collection
   */
  Collection<? extends BaseVariable> readBCIVariables(Long businessContextId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * readPortfolioVariables.
   *
   * @param   portfolioId   Long
   * @param   contextNames  String[]
   *
   * @return  Collection
   */
  Collection<? extends BaseVariable> readPortfolioVariables(Long portfolioId, String[] contextNames);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * readSurveyFlowVariables.
   *
   * @param   portfolioId   Long
   * @param   contextNames  String[]
   *
   * @return  Collection
   */
  Collection<? extends BaseVariable> readSurveyFlowVariables(Long portfolioId, String[] contextNames);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * readSystemVariables.
   *
   * @param   contextNames  String[]
   *
   * @return  Collection
   */
  Collection<? extends BaseVariable> readSystemVariables(String[] contextNames);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * readUtilityVariables.
   *
   * @param   contextNames  String[]
   *
   * @return  Collection
   */
  Collection<? extends BaseVariable> readUtilityVariables(String[] contextNames);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * readVariables.
   *
   * @param   portfolioId   Long
   * @param   contextNames  String[]
   *
   * @return  Collection
   */
  Collection<? extends BaseVariable> readVariables(Long portfolioId, String[] contextNames);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * readWorkflowVariables.
   *
   * @param   contextNames  String[]
   *
   * @return  Collection
   */
  Collection<? extends BaseVariable> readWorkflowVariables(String[] contextNames);
} // end interface ExpressionVarRepository
