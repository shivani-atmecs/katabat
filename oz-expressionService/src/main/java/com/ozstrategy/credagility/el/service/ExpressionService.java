package com.ozstrategy.credagility.el.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import com.cmc.credagility.core.domain.variable.BaseVariable;

import com.ozstrategy.credagility.core.el.ElObject;
import com.ozstrategy.credagility.core.el.ExpressionObject;
import com.ozstrategy.credagility.core.el.VarObj;
import com.ozstrategy.credagility.core.util.DataFormatter;
import com.ozstrategy.credagility.el.context.operator.Operator;
import com.ozstrategy.credagility.exceptions.KeyWordException;

import com.ozstrategy.strategy.exception.GenericException;


/**
 * Created with IntelliJ IDEA.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 * @User:    Wang Yang
 * @Date:    13-4-18
 * @Time:    PM4:55
 */
public interface ExpressionService {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   template  DOCUMENT ME!
   * @param   model     DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   * @throws  com.ozstrategy.strategy.exception.GenericException  DOCUMENT ME!
   * @throws  GenericException                                    exception
   */
  String applyTemplate(String template, final Map<String, String> model) throws GenericException;

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   template      DOCUMENT ME!
   * @param   unescapeHtml  DOCUMENT ME!
   * @param   model         DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   * @throws  GenericException  DOCUMENT ME!
   */
  String applyTemplate(String template, final boolean unescapeHtml, final Map<String, String> model)
    throws GenericException;

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   expressions  DOCUMENT ME!
   * @param   object       context DOCUMENT ME!
   * @param   extraValues  DOCUMENT ME!
   * @param   operator     DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   * @throws  GenericException  DOCUMENT ME!
   */
  Object calculate(String[] expressions, ElObject object, Map<String, Object> extraValues, Operator operator)
    throws GenericException;

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   */
  void clearVariables();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   expression  DOCUMENT ME!
   * @param   object      context DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   * @throws  GenericException  DOCUMENT ME!
   */
  Class detectReturnType(String expression, ElObject object) throws GenericException;

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   expression   DOCUMENT ME!
   * @param   object       context DOCUMENT ME!
   * @param   extraValues  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   * @throws  GenericException  DOCUMENT ME!
   */
  Class detectReturnType(String expression, ElObject object, Map<String, Object> extraValues) throws GenericException;

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  elObject  DOCUMENT ME!
   */
  void endBatch(ElObject elObject);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   expression  DOCUMENT ME!
   * @param   object      context DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   * @throws  GenericException  DOCUMENT ME!
   */
  Object evaluate(String expression, ElObject object) throws GenericException;

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   expressionObjects  DOCUMENT ME!
   * @param   object             context DOCUMENT ME!
   * @param   extraValues        DOCUMENT ME!
   *
   * @throws  GenericException  DOCUMENT ME!
   */
  void evaluate(Collection<? extends ExpressionObject> expressionObjects, ElObject object,
    Map<String, Object> extraValues) throws GenericException;

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   expression  DOCUMENT ME!
   * @param   object      context DOCUMENT ME!
   * @param   formatter   DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   * @throws  GenericException  DOCUMENT ME!
   */
  String evaluate(String expression, ElObject object, DataFormatter formatter) throws GenericException;

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   <T>         DOCUMENT ME!
   * @param   expression  DOCUMENT ME!
   * @param   object      context DOCUMENT ME!
   * @param   toType      DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   * @throws  GenericException  DOCUMENT ME!
   */
  <T> T evaluate(String expression, ElObject object, Class<T> toType) throws GenericException;

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   expressions  DOCUMENT ME!
   * @param   object       context DOCUMENT ME!
   * @param   extraValues  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   * @throws  GenericException  DOCUMENT ME!
   */
  List evaluate(String[] expressions, ElObject object, Map<String, Object> extraValues) throws GenericException;

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   expression   DOCUMENT ME!
   * @param   object       context DOCUMENT ME!
   * @param   extraValues  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   * @throws  GenericException  DOCUMENT ME!
   */
  Object evaluate(String expression, ElObject object, Map<String, Object> extraValues) throws GenericException;

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   <T>          DOCUMENT ME!
   * @param   expressions  DOCUMENT ME!
   * @param   object       context DOCUMENT ME!
   * @param   extraValues  DOCUMENT ME!
   * @param   toType       DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   * @throws  GenericException  DOCUMENT ME!
   */
  <T> List<T> evaluate(String[] expressions, ElObject object, Map<String, Object> extraValues, Class<T> toType)
    throws GenericException;

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   <T>          DOCUMENT ME!
   * @param   expression   DOCUMENT ME!
   * @param   object       DOCUMENT ME!
   * @param   extraValues  DOCUMENT ME!
   * @param   toType       DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   * @throws  GenericException  DOCUMENT ME!
   */
  <T> T evaluate(String expression, ElObject object, Map<String, Object> extraValues, Class<T> toType)
    throws GenericException;

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   expressionObjects  DOCUMENT ME!
   * @param   object             DOCUMENT ME!
   * @param   extraValues        DOCUMENT ME!
   * @param   haltOnError        DOCUMENT ME!
   *
   * @throws  GenericException  DOCUMENT ME!
   */
  void evaluate(Collection<? extends ExpressionObject> expressionObjects, ElObject object,
    Map<String, Object> extraValues, boolean haltOnError) throws GenericException;

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   expression   DOCUMENT ME!
   * @param   object       context DOCUMENT ME!
   * @param   extraValues  DOCUMENT ME!
   * @param   formatter    DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   * @throws  GenericException  DOCUMENT ME!
   */
  String evaluate(String expression, ElObject object, Map<String, Object> extraValues,
    DataFormatter formatter) throws GenericException;

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   expressionMap  DOCUMENT ME!
   * @param   object         context DOCUMENT ME!
   * @param   extraValues    DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   * @throws  GenericException  DOCUMENT ME!
   */
  Map<ExpressionObject, Object> evaluateExpressionMap(Map<ExpressionObject, Object> expressionMap,
    ElObject object, Map<String, Object> extraValues) throws GenericException;

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * evaluateFields.
   *
   * @param  object        ElObject
   * @param  obj           Object
   * @param  unescapeHtml  boolean
   * @param  extraValues   Map
   */
  void evaluateFields(ElObject object, Object obj, boolean unescapeHtml, Map<String, Object> extraValues);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   template  DOCUMENT ME!
   * @param   object    context DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   * @throws  GenericException  DOCUMENT ME!
   */
  String evaluateTemplate(String template, ElObject object) throws GenericException;

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   template      DOCUMENT ME!
   * @param   unescapeHtml  DOCUMENT ME!
   * @param   object        context DOCUMENT ME!
   * @param   extraValues   DOCUMENT ME!
   * @param   formatter     DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   * @throws  GenericException  DOCUMENT ME!
   */
  String evaluateTemplate(String template, boolean unescapeHtml, ElObject object, Map<String, Object> extraValues,
    DataFormatter formatter) throws GenericException;

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   template  DOCUMENT ME!
   * @param   object    context DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  Set<VarObj> getExpressionAndValueFromTemplate(String template, ElObject object);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   template      DOCUMENT ME!
   * @param   object        context DOCUMENT ME!
   * @param   unescapeHtml  DOCUMENT ME!
   * @param   extraValues   DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  Set<VarObj> getExpressionAndValueFromTemplate(String template, ElObject object,
    boolean unescapeHtml, Map<String, Object> extraValues);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   expression  DOCUMENT ME!
   * @param   object      context DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  Set<String> getExpressions(String expression, ElObject object);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   content  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  Set<? extends String> getExpressionsFromTemplate(String content);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   template      content DOCUMENT ME!
   * @param   unescapeHtml  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  Set<? extends String> getExpressionsFromTemplate(String template, boolean unescapeHtml);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   vars      DOCUMENT ME!
   * @param   elObject  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  List<Object> getRespDetails(Set<String> vars, ElObject elObject);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   variable  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  Set<BaseVariable> getUsedVariables(BaseVariable variable);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   expression  DOCUMENT ME!
   * @param   object      context DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  Set<BaseVariable> getUsedVariables(String expression, ElObject object);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   template  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  Set<String> getUsedVariablesFromTemplate(String template);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   template      DOCUMENT ME!
   * @param   unescapeHtml  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  Set<String> getUsedVariablesFromTemplate(String template, boolean unescapeHtml);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   object  context DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  List<BaseVariable> getVariables(ElObject object);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   variableName  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   * @throws  com.ozstrategy.credagility.exceptions.KeyWordException  DOCUMENT ME!
   */
  Boolean isKeyWord(String variableName) throws KeyWordException;

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  variable  DOCUMENT ME!
   */
  void lockUsedVariables(BaseVariable variable);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  expression  DOCUMENT ME!
   * @param  object      context DOCUMENT ME!
   */
  @Transactional void lockUsedVariables(String expression, ElObject object) // end method lockUsedVariables
  ;

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  expression   DOCUMENT ME!
   * @param  contextType  DOCUMENT ME!
   * @param  extendId     DOCUMENT ME!
   */
  void lockUsedVariables(String expression, String contextType, Long extendId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  baseVariable  DOCUMENT ME!
   */
  void lockVariable(BaseVariable baseVariable);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   <T>     DOCUMENT ME!
   * @param   entity  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  <T> T preFetchEntity(T entity);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   variable  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  BaseVariable saveAndLockUsedVariables(BaseVariable variable);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  elObject  DOCUMENT ME!
   */
  void startBatch(ElObject elObject);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  expression  DOCUMENT ME!
   * @param  object      context DOCUMENT ME!
   */
  void verify(String expression, ElObject object);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  expression   DOCUMENT ME!
   * @param  object       context DOCUMENT ME!
   * @param  extraValues  DOCUMENT ME!
   */
  void verify(String expression, ElObject object, Map<String, Object> extraValues);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   template  DOCUMENT ME!
   * @param   object    context DOCUMENT ME!
   *
   * @throws  GenericException  DOCUMENT ME!
   */
  void verifyTemplate(String template, ElObject object) throws GenericException;

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   template      DOCUMENT ME!
   * @param   unescapeHtml  DOCUMENT ME!
   * @param   object        context DOCUMENT ME!
   *
   * @throws  GenericException  DOCUMENT ME!
   */
  void verifyTemplate(String template, boolean unescapeHtml, ElObject object) throws GenericException;
} // end interface ExpressionService
