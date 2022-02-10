package com.ozstrategy.credagility.el.service.impl;

import java.lang.reflect.Field;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringEscapeUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.util.StringUtils;

import com.cmc.credagility.core.domain.businesscontext.BCVariable;
import com.cmc.credagility.core.domain.businesscontext.BusinessContext;
import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.cmc.credagility.core.domain.portfolio.PortfolioVariable;
import com.cmc.credagility.core.domain.survey.SurveyFlowVariable;
import com.cmc.credagility.core.domain.variable.BaseVariable;
import com.cmc.credagility.core.domain.variable.Variable;
import com.cmc.credagility.core.domain.variable.VariableAudit;
import com.cmc.credagility.core.domain.variable.WorkflowVariable;

import com.ozstrategy.credagility.core.annotations.EvaluateMessageProperty;
import com.ozstrategy.credagility.core.domain.workflow.ContextType;
import com.ozstrategy.credagility.core.el.ELFunctionRegister;
import com.ozstrategy.credagility.core.el.ElContext;
import com.ozstrategy.credagility.core.el.ElObject;
import com.ozstrategy.credagility.core.el.ExpressionObject;
import com.ozstrategy.credagility.core.el.VarObj;
import com.ozstrategy.credagility.core.el.repository.ElVariableRepository;
import com.ozstrategy.credagility.core.el.repository.ExpressionVarRepository;
import com.ozstrategy.credagility.core.util.DataFormatter;
import com.ozstrategy.credagility.el.context.agency.AgencyElObject;
import com.ozstrategy.credagility.el.context.businesscontextinstance.BCIElObject;
import com.ozstrategy.credagility.el.context.global.GlobalElObject;
import com.ozstrategy.credagility.el.context.operator.Operator;
import com.ozstrategy.credagility.el.context.operator.StringOperator;
import com.ozstrategy.credagility.el.context.responsible.ResponsibleElObject;
import com.ozstrategy.credagility.el.processor.DollarExpression;
import com.ozstrategy.credagility.el.processor.ExpressionContentParser;
import com.ozstrategy.credagility.el.processor.ExpressionProcessor;
import com.ozstrategy.credagility.el.service.ExpressionService;
import com.ozstrategy.credagility.el.util.OZConstants;
import com.ozstrategy.credagility.exceptions.KeyWordException;

import com.ozstrategy.el.impl.ResolverContext;

import com.ozstrategy.strategy.exception.GenericException;


/**
 * Created with IntelliJ IDEA.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 * @User:    Wang Yang
 * @Date:    13-4-18
 * @Time:    PM4:56
 */
public class ExpressionServiceImpl implements ExpressionService, InitializingBean {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  public static final Set<String> reservedWords = new LinkedHashSet<String>();

  static {
    reservedWords.add("abstract");
    reservedWords.add("continue");
    reservedWords.add("for");
    reservedWords.add("new");
    reservedWords.add("switch");
    reservedWords.add("assert");
    reservedWords.add("default");
    reservedWords.add("goto");
    reservedWords.add("package");
    reservedWords.add("synchronized");
    reservedWords.add("boolean");
    reservedWords.add("do");
    reservedWords.add("if");
    reservedWords.add("private");
    reservedWords.add("this");
    reservedWords.add("break");
    reservedWords.add("double");
    reservedWords.add("implements");
    reservedWords.add("protected");
    reservedWords.add("throw");
    reservedWords.add("byte");
    reservedWords.add("else");
    reservedWords.add("import");
    reservedWords.add("public");
    reservedWords.add("throws");
    reservedWords.add("case");
    reservedWords.add("enum");
    reservedWords.add("instanceof");
    reservedWords.add("return");
    reservedWords.add("transient");
    reservedWords.add("catch");
    reservedWords.add("extends");
    reservedWords.add("int");
    reservedWords.add("short");
    reservedWords.add("try");
    reservedWords.add("char");
    reservedWords.add("final");
    reservedWords.add("interface");
    reservedWords.add("static");
    reservedWords.add("void");
    reservedWords.add("class");
    reservedWords.add("finally");
    reservedWords.add("long");
    reservedWords.add("strictfp");
    reservedWords.add("volatile");
    reservedWords.add("const");
    reservedWords.add("float");
    reservedWords.add("native");
    reservedWords.add("super");
    reservedWords.add("while");
    reservedWords.add("and");
    reservedWords.add("or");
    reservedWords.add("with");
    reservedWords.add("isdef");
    reservedWords.add("contains");
    reservedWords.add("soundslike");
    reservedWords.add("strsim");
    reservedWords.add("is");
    reservedWords.add("in");
    reservedWords.add("java");

    /** extra key word*/
    reservedWords.add("answer");
  }

  private static final Logger logger = LoggerFactory.getLogger(ExpressionServiceImpl.class);

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Always run compiled expression. */
  protected boolean compileMode = true;

  /** DOCUMENT ME! */
  @Autowired(required = false)
  protected ExpressionVarRepository expressionVarRepository;

  /** DOCUMENT ME! */
  protected Map<String, String> forceMapping;

  /** TODO: DOCUMENT ME! */
  @Autowired protected ElVariableRepository variableRepository;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @throws  Exception  DOCUMENT ME!
   */
  @Override public void afterPropertiesSet() throws Exception {
    ResolverContext.init();

    Set<Class> classes = ELFunctionRegister.getAllExposedClasses();

    for (Class clazz : classes) {
      ResolverContext.addExposedClass(clazz);
    }
  } // end method afterPropertiesSet

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.el.service.ExpressionService#applyTemplate(String, java.util.Map)
   */
  @Override public String applyTemplate(String template, Map<String, String> model) throws GenericException {
    return applyTemplate(template, true, model);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.el.service.ExpressionService#applyTemplate(String, boolean,
   *       java.util.Map)
   */
  @Override public String applyTemplate(String template, final boolean unescapeHtml, final Map<String, String> model)
    throws GenericException {
    return ExpressionContentParser.process(template, new ExpressionProcessor() {
          @Override public String process(DollarExpression expression) {
            String expr = null;

            if (unescapeHtml) {
              expr = StringEscapeUtils.unescapeHtml4(expression.getExpression());
            } else {
              expr = expression.getExpression();
            }

            String value = model.get(expr);

            if (value == null) {
              return "";
            }

            return value;
          }
        });
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.el.service.ExpressionService#calculate(String[], com.ozstrategy.credagility.core.el.ElObject,
   *       java.util.Map, com.ozstrategy.credagility.el.context.operator.Operator)
   */
  @Override public Object calculate(String[] expressions, ElObject object, Map<String, Object> extraValues,
    Operator operator) throws GenericException {
    if (operator == null) {
      operator = new StringOperator();
    }

    List values = evaluate(expressions, object, extraValues);

    int size = values.size();

    for (int i = 0; i < size; i++) {
      Object val = values.get(i);
      operator.push(val, i);
    }

    return operator.value();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.el.service.ExpressionService#clearVariables()
   */
  @Override // @TriggersRemove(
// cacheName = "variableCache",
// when      = When.AFTER_METHOD_INVOCATION,
// removeAll = true
// )
  public void clearVariables() {
    if (logger.isDebugEnabled()) {
      logger.debug("Clear All Variable Cache...");
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.el.service.ExpressionService#detectReturnType(String, com.ozstrategy.credagility.core.el.ElObject)
   */
  @Override public Class detectReturnType(String expression, ElObject object) throws GenericException {
    Map<String, Object> extraValues = new LinkedHashMap<String, Object>();

    if (forceMapping != null) {
      for (String key : forceMapping.keySet()) {
        Variable variable = new Variable();
        variable.setName(key);

        String type = forceMapping.get(key);

        if (StringUtils.hasText(type)) {
          variable.setDataType(type);
          extraValues.put(key, variable);
        }
      }
    }

    return detectReturnType(expression, object, extraValues);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.el.service.ExpressionService#detectReturnType(String, com.ozstrategy.credagility.core.el.ElObject,
   *       java.util.Map)
   */
  @Override public Class detectReturnType(String expression, ElObject object, Map<String, Object> extraValues)
    throws GenericException {
    try {
      ElContext context = initContext(object);
      context.putExtraValues(extraValues, true);

      return context.detectReturnType(expression);
    } catch (Exception e) {
      throw new GenericException(e.getMessage());
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.el.service.ExpressionService#endBatch(com.ozstrategy.credagility.core.el.ElObject)
   */
  @Override public void endBatch(ElObject elObject) {
    ElContext ctx = initContext(elObject);
    ctx.endBatch();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.el.service.ExpressionService#evaluate(String, com.ozstrategy.credagility.core.el.ElObject)
   */
  @Override public Object evaluate(String expression, ElObject object) throws GenericException {
    return evaluate(expression, object, new HashMap<String, Object>());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   expressionObjects  DOCUMENT ME!
   * @param   object             context evaObj DOCUMENT ME!
   * @param   extraValues        DOCUMENT ME!
   *
   * @throws  GenericException  DOCUMENT ME!
   */
  @Override public void evaluate(Collection<? extends ExpressionObject> expressionObjects,
    ElObject object, Map<String, Object> extraValues) throws GenericException {
    evaluate(expressionObjects, object, extraValues, false);
  } // end method evaluate

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.el.service.ExpressionService#evaluate(String, com.ozstrategy.credagility.core.el.ElObject,
   *       com.ozstrategy.credagility.core.util.DataFormatter)
   */
  @Override public String evaluate(String expression, ElObject object, DataFormatter formatter)
    throws GenericException {
    return evaluate(expression, object, null, formatter);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.el.service.ExpressionService#evaluate(String, com.ozstrategy.credagility.core.el.ElObject,
   *       Class)
   */
  @Override public <T> T evaluate(String expression, ElObject object, Class<T> toType) throws GenericException {
    return evaluate(expression, object, null, toType);
  }

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
  @Override public Object evaluate(String expression, ElObject object, Map<String, Object> extraValues)
    throws GenericException {
    if (logger.isDebugEnabled()) {
      logger.debug("evaluate:" + object);
    }

    try {
      ElContext context = initContext(object);
      context.putExtraValues(extraValues, true);

      return eval(expression, context);
    } catch (Exception e) {
      logger.error("Failed to evaluate expression: " + expression, e);
    } // end try-catch

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   expressions  DOCUMENT ME!
   * @param   object       DOCUMENT ME!
   * @param   extraValues  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   * @throws  GenericException  DOCUMENT ME!
   */
  @Override public List evaluate(String[] expressions, ElObject object, Map<String, Object> extraValues)
    throws GenericException {
    if (logger.isDebugEnabled()) {
      logger.debug("evaluate:" + object);
    }

    List<Object> list = new ArrayList<Object>(expressions.length);

    try {
      ElContext context = initContext(object);
      context.putExtraValues(extraValues, true);
      list.addAll(eval(expressions, context));
    } catch (Exception e) {
      logger.error("Failed to evaluate expressions: " + expressions, e);
    } // end try-catch

    return list;
  }

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
  @Override public void evaluate(Collection<? extends ExpressionObject> expressionObjects,
    ElObject object, Map<String, Object> extraValues, boolean haltOnError) throws GenericException {
    if (logger.isDebugEnabled()) {
      logger.debug("evaluate: " + object);
      logger.debug("expressionObjects: " + expressionObjects);
    }

    ElContext context = initContext(object);
    context.putExtraValues(extraValues, true);
    context.startBatch();

    for (ExpressionObject obj : expressionObjects) {
      Object val = null;

      try {
        if (logger.isDebugEnabled()) {
          logger.debug("Evaluating Expression: " + obj.getExpression());
        }

        val = eval(obj.getExpression(), context);
      } catch (Exception e) {
        logger.error("Failed to evaluate expression: " + obj.getExpression(), e);

        if (haltOnError) {
          throw (new GenericException(e.getMessage()));
        }
      }

      obj.setValue(val);
    }

    context.endBatch();
  } // end method evaluate

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.el.service.ExpressionService#evaluate(String, com.ozstrategy.credagility.core.el.ElObject,
   *       java.util.Map, Class)
   */
  @Override public <T> T evaluate(String expression, ElObject object, Map<String, Object> extraValues, Class<T> toType)
    throws GenericException {
    try {
      if (logger.isDebugEnabled()) {
        logger.debug("Initial Context to evaluate expression.");
      }

      ElContext context = initContext(object);

      if (logger.isDebugEnabled()) {
        logger.debug("Initialized Context to evaluate expression.");
      }

      context.putExtraValues(extraValues, true);

      if (logger.isDebugEnabled()) {
        logger.debug("Add extra values to evaluate expression.");
      }

      return eval(expression, context, toType);
    } catch (Exception e) {
      logger.error("Failed to evaluate expression: " + expression, e);
      throw new GenericException(e.getMessage());
    } // end try-catch
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   <T>          DOCUMENT ME!
   * @param   expressions  DOCUMENT ME!
   * @param   object       DOCUMENT ME!
   * @param   extraValues  DOCUMENT ME!
   * @param   toType       DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   * @throws  GenericException  DOCUMENT ME!
   */
  @Override public <T> List<T> evaluate(String[] expressions, ElObject object, Map<String, Object> extraValues,
    Class<T> toType) throws GenericException {
    if (logger.isDebugEnabled()) {
      logger.debug("evaluate:" + object);
    }

    List<T> list = new ArrayList<T>(expressions.length);

    try {
      ElContext context = initContext(object);
      context.putExtraValues(extraValues, true);

      for (String expression : expressions) {
        list.add(eval(expression, context, toType));
      }
    } catch (Exception e) {
      logger.error("Failed to evaluate expressions: " + expressions, e);
    } // end try-catch

    return list;
  } // end method evaluate

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
  @Override public String evaluate(String expression, ElObject object, Map<String, Object> extraValues,
    DataFormatter formatter) throws GenericException {
    Object obj = evaluate(expression, object, extraValues);

    if (formatter == null) {
      formatter = new DataFormatter();
    }

    return formatter.format(obj);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   expressionMap  DOCUMENT ME!
   * @param   object         DOCUMENT ME!
   * @param   extraValues    DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   * @throws  GenericException  DOCUMENT ME!
   */
  @Override public Map<ExpressionObject, Object> evaluateExpressionMap(Map<ExpressionObject, Object> expressionMap,
    ElObject object, Map<String, Object> extraValues) throws GenericException {
    if (logger.isDebugEnabled()) {
      logger.debug("evaluate: " + object);
      logger.debug("expressionMap: " + expressionMap);
    }

    String expression = null;

    try {
      ElContext context = initContext(object);

      Set<ExpressionObject> expressions = expressionMap.keySet();
      context.putExtraValues(extraValues, true);

      for (ExpressionObject expressionObject : expressions) {
        expression = expressionObject.getExpression();
        expressionMap.put(expressionObject, eval(expression, context));
      }
    } catch (Exception e) {
      if (expression != null) {
        logger.error("Failed to evaluate expression: " + expression, e);
      } else {
        logger.error(e.getMessage(), e);
      }
    } // end try-catch

    return expressionMap;
  } // end method evaluateExpressionMap

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.el.service.ExpressionService#evaluateFields(com.ozstrategy.credagility.core.el.ElObject,
   *       Object, boolean, java.util.Map)
   */
  @Override public void evaluateFields(ElObject object, Object entity, boolean unescapeHtml,
    Map<String, Object> extraValues) {
    Set<Field> fields = getAllFields(entity.getClass(), null);

    if (fields.size() > 0) {
      if (logger.isDebugEnabled()) {
        logger.debug("evaluating : " + object);
      }

      ElContext context = initContext(object);
      context.putExtraValues(extraValues, true);
      context.startBatch();

      for (Field field : fields) {
        EvaluateMessageProperty property = field.getAnnotation(EvaluateMessageProperty.class);

        if (property != null) {
          try {
            field.setAccessible(true);

            Object val = field.get(entity);

            if (val != null) {
              String text = evaluateTemplate(val.toString(), context, true, new DataFormatter());
              field.set(entity, text);
            }

            field.setAccessible(false);
          } catch (IllegalAccessException e) {
            // e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
          }
        }
      }

      context.endBatch();
    } // end if
  }   // end method evaluateFields

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.el.service.ExpressionService#evaluateTemplate(String, com.ozstrategy.credagility.core.el.ElObject)
   */
  @Override public String evaluateTemplate(String template, ElObject object) throws GenericException {
    return evaluateTemplate(template, false, object, null, new DataFormatter(DataFormatter.getDefaultDatePattern()));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.el.service.ExpressionService#evaluateTemplate(String, boolean,
   *       com.ozstrategy.credagility.core.el.ElObject, java.util.Map,
   *       com.ozstrategy.credagility.core.util.DataFormatter)
   */
  @Override public String evaluateTemplate(String template, final boolean unescapeHtml, final ElObject object,
    final Map<String, Object> extraValues, final DataFormatter formatter) throws GenericException {
    if (logger.isDebugEnabled()) {
      logger.debug("evaluate:" + object);
    }

    try {
      ElContext context = initContext(object);
      context.putExtraValues(extraValues, true);

      return evaluateTemplate(template, context, unescapeHtml, formatter);
    } catch (Exception e) {
      logger.error("Failed to evaluate template: " + template, e);
    } // end try-catch

    return null;
  } // end method evaluateTemplate

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   template  DOCUMENT ME!
   * @param   object    context DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Override public Set<VarObj> getExpressionAndValueFromTemplate(String template, ElObject object) {
    return getExpressionAndValueFromTemplate(template, object, false, null);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.el.service.ExpressionService#getExpressionAndValueFromTemplate(String, com.ozstrategy.credagility.core.el.ElObject,
   *       boolean, java.util.Map)
   */
  @Override public Set<VarObj> getExpressionAndValueFromTemplate(String template, ElObject object,
    boolean unescapeHtml, final Map<String, Object> extraValues) {
    Set<VarObj> variables   = new HashSet<VarObj>();
    Set<String> expressions = ExpressionContentParser.populateExpression(template, unescapeHtml);
    ElContext   context     = initContext(object);

    for (String expression : expressions) {
      BaseVariable variable = context.getVariable(expression, expressionVarRepository);

      if (variable != null) {
        Object value = evaluate(variable.getExpression(), object, extraValues);
        VarObj obj   = new VarObj(expression, value, variable.getDataType(), variable.getBusinessDataType(), variable);
        variables.add(obj);
      } else {
        Object value = evaluate(expression, object, extraValues);
        VarObj obj   = VarObj.generateObj(value, expression);

        if (obj != null) {
          variables.add(obj);
        }
      }
    }

    return variables;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.el.service.ExpressionService#getExpressions(String, com.ozstrategy.credagility.core.el.ElObject)
   */
  @Override public Set<String> getExpressions(String expression, ElObject object) {
    try {
      ElContext context = initContext(object);

      return context.getUsedVariables(expression);
    } catch (Exception e) {
      logger.warn(e.getMessage(), e);
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.el.service.ExpressionService#getExpressionsFromTemplate(String)
   */
  @Override public Set<? extends String> getExpressionsFromTemplate(String template) {
    return getExpressionsFromTemplate(template, false);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.el.service.ExpressionService#getExpressionsFromTemplate(String, boolean)
   */
  @Override public Set<? extends String> getExpressionsFromTemplate(String template, boolean unescapeHtml) {
    return ExpressionContentParser.populateExpression(template, unescapeHtml);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   vars      DOCUMENT ME!
   * @param   elObject  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Override public List<Object> getRespDetails(Set<String> vars, ElObject elObject) {
    List<Object> value = new ArrayList<Object>(vars.size());

    for (String var : vars) {
      Object val = evaluate(var, elObject);
      value.add(val);
      logger.info("Evaluated [" + var + "=" + val);
    }

    return value;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get list of used reference variables in this variable.
   *
   * @param   variable  to be analyzed
   *
   * @return  references list
   */
  @Override public Set<BaseVariable> getUsedVariables(BaseVariable variable) {
    ElObject          evaObj    = new GlobalElObject();
    Set<BaseVariable> variables = new LinkedHashSet<BaseVariable>();

    if (variable instanceof PortfolioVariable) {
      evaObj = new ResponsibleElObject(((PortfolioVariable) variable).getPortfolio());
    } else if (variable instanceof SurveyFlowVariable) {
      evaObj = new ResponsibleElObject(((SurveyFlowVariable) variable).getPortfolio());
    } else if (variable instanceof BCVariable) {
      evaObj = new BCIElObject(((BCVariable) variable).getBusinessContext());
    } else if (ContextType.convert(variable.getContext()).equals(ContextType.AGENCY)) {
      evaObj = new AgencyElObject();
    }

    try {
      ElContext context = initContext(evaObj);

      for (String name : context.getUsedVariables((variable).getExpression())) {
        BaseVariable baseVariable = context.getVariable(name, expressionVarRepository);

        if (baseVariable != null) {
          variables.add(baseVariable);
        }
      }
    } catch (Exception e) {
      if (logger.isDebugEnabled()) {
        logger.debug(e.getMessage(), e);
      }
    }

    return variables;
  } // end method getUsedVariables

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.el.service.ExpressionService#getUsedVariables(String, com.ozstrategy.credagility.core.el.ElObject)
   */
  @Override public Set<BaseVariable> getUsedVariables(String expression, ElObject object) {
    if (object == null) {
      object = new GlobalElObject();
    }

    try {
      Set<BaseVariable> variables = new LinkedHashSet<BaseVariable>();
      ElContext         context   = initContext(object);

      for (String name : context.getUsedVariables(expression)) {
        BaseVariable baseVariable = context.getVariable(name, expressionVarRepository);

        if (baseVariable != null) {
          variables.add(baseVariable);
        }
      }

      return variables;
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
    }

    return null;
  } // end method getUsedVariables

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   template  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Override public Set<String> getUsedVariablesFromTemplate(String template) {
    return getUsedVariablesFromTemplate(template, true);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   template      DOCUMENT ME!
   * @param   unescapeHtml  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Override public Set<String> getUsedVariablesFromTemplate(String template, final boolean unescapeHtml) {
    Set<String> variables   = new HashSet<String>();
    Set<String> expressions = ExpressionContentParser.populateExpression(template, unescapeHtml);

    ResolverContext resolverContext = new ResolverContext();

    for (String expression : expressions) {
      Set<String> vars = resolverContext.getUsedVariables(expression);

      for (String var : vars) {
        variables.add(var);
      }
    }

    return variables;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   object  context DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Override public List<BaseVariable> getVariables(ElObject object) {
    try {
      ElContext context = initContext(object);

      return expressionVarRepository.getVariables(context.populateSuggestParams());
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.el.service.ExpressionService#isKeyWord(String)
   */
  @Override public Boolean isKeyWord(String variableName) throws KeyWordException {
    if (reservedWords.contains(variableName.toLowerCase())) {
      throw new KeyWordException("The " + variableName + " is a key word.");
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Lock variable used variables.
   *
   * @param  variable  to search usages
   */
  @Override @Transactional public void lockUsedVariables(BaseVariable variable) {
    for (BaseVariable baseVariable : getUsedVariables(variable)) {
      lockVariable(baseVariable);
    } // end for
  }   // end method lockUsedVariables

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.el.service.ExpressionService#lockUsedVariables(String, com.ozstrategy.credagility.core.el.ElObject)
   */
  @Override @Transactional public void lockUsedVariables(String expression, ElObject object) {
    for (BaseVariable baseVariable : getUsedVariables(expression, object)) {
      if ((baseVariable != null) && (!baseVariable.isLocked())) {
        Boolean isLocked = baseVariable.getLocked();
        baseVariable.setLocked(true);

        boolean isUpdated = true;

        if (Boolean.TRUE.equals(isLocked)) {
          isUpdated = false;
        }

        if (baseVariable instanceof Variable) {
          variableRepository.saveVariable((Variable) baseVariable);
        } else if (baseVariable instanceof PortfolioVariable) {
          variableRepository.savePortfolioVariable((PortfolioVariable) baseVariable);
        } else if (baseVariable instanceof SurveyFlowVariable) {
          variableRepository.saveSurveyFlowVariable((SurveyFlowVariable) baseVariable);
        } else if (baseVariable instanceof WorkflowVariable) {
          variableRepository.saveWorkflowVariable((WorkflowVariable) baseVariable);
        } else if (baseVariable instanceof BCVariable) {
          variableRepository.saveBCVariable((BCVariable) baseVariable);
        }

        if (isUpdated) {
          VariableAudit va = new VariableAudit(baseVariable);
          va.setVariableId(baseVariable.getId());
          va.setAction("LOCK");
          variableRepository.saveAudit(va);
        }
      } // end if
    }   // end for
  }     // end method lockUsedVariables

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.el.service.ExpressionService#lockUsedVariables(String, String,
   *       Long)
   */
  @Override @Transactional public void lockUsedVariables(String expression, String contextType, Long scopeId) {
    ElObject object = new GlobalElObject();

    if (OZConstants.RES_TYPE.equalsIgnoreCase(contextType)) {
      Portfolio p = new Portfolio();
      p.setPortfolioId(scopeId);
      object = new ResponsibleElObject(p);
    } else {
      BusinessContext bc = new BusinessContext();
      bc.setId(scopeId);
      object = new BCIElObject(bc);
    }

    Set<BaseVariable> variables = new LinkedHashSet<BaseVariable>();

    for (BaseVariable baseVariable : getUsedVariables(expression, object)) {
      if (baseVariable != null) {
        variables.add(baseVariable);
      }
    }

    for (BaseVariable baseVariable : variables) {
      lockVariable(baseVariable);
    }
  } // end method lockUsedVariables

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.el.service.ExpressionService#lockVariable(com.cmc.credagility.core.domain.variable.BaseVariable)
   */
  @Override @Transactional public void lockVariable(BaseVariable baseVariable) {
    if (!baseVariable.isLocked()) {
      Boolean isLocked = baseVariable.getLocked();
      baseVariable.setLocked(true);

      boolean isUpdated = true;

      if (Boolean.TRUE.equals(isLocked)) {
        isUpdated = false;
      }

      if (baseVariable instanceof Variable) {
        variableRepository.saveVariable((Variable) baseVariable);
      } else if (baseVariable instanceof PortfolioVariable) {
        variableRepository.savePortfolioVariable((PortfolioVariable) baseVariable);
      } else if (baseVariable instanceof SurveyFlowVariable) {
        variableRepository.saveSurveyFlowVariable((SurveyFlowVariable) baseVariable);
      } else if (baseVariable instanceof BCVariable) {
        variableRepository.saveBCVariable((BCVariable) baseVariable);
      }

      if (isUpdated) {
        VariableAudit va = new VariableAudit(baseVariable);
        va.setVariableId(baseVariable.getId());
        va.setAction("LOCK");
        variableRepository.saveAudit(va);
      }


    } // end if
  }   // end method lockVariable

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.el.service.ExpressionService#preFetchEntity(Object)
   */
  @Override public <T> T preFetchEntity(T entity) {
    return expressionVarRepository.preFetchEntity(entity);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Save variable and lock used variables.
   *
   * @param   variable  to update and lock used
   *
   * @return  DOCUMENT ME!
   */
  @Override @Transactional public BaseVariable saveAndLockUsedVariables(BaseVariable variable) {
    lockUsedVariables(variable);

    boolean isNew = true;

    if ((variable.getId() != null) && (variable.getId() != 0)) {
      isNew = false;
    }

    if (variable instanceof Variable) {
      variable = variableRepository.saveVariable((Variable) variable);
    } else if (variable instanceof PortfolioVariable) {
      variable = variableRepository.savePortfolioVariable((PortfolioVariable) variable);
    } else if (variable instanceof SurveyFlowVariable) {
      variable = variableRepository.saveSurveyFlowVariable((SurveyFlowVariable) variable);
    } else if (variable instanceof WorkflowVariable) {
      variable = variableRepository.saveWorkflowVariable((WorkflowVariable) variable);
    } else if (variable instanceof BCVariable) {
      variable = variableRepository.saveBCVariable((BCVariable) variable);
    }

    VariableAudit va = new VariableAudit(variable);
    va.setVariableId(variable.getId());

    if (isNew) {
      va.setAction("CREATE");
    } else {
      va.setAction("UPDATE");
    }

    variableRepository.saveAudit(va);

    return variable;
  } // end method saveAndLockUsedVariables

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  forceMapping  DOCUMENT ME!
   */
  public void setForceMapping(Map<String, String> forceMapping) {
    this.forceMapping = forceMapping;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   elObject  DOCUMENT ME!
   *
   * @throws  GenericException  DOCUMENT ME!
   */
  @Override public void startBatch(ElObject elObject) {
    ElContext ctx = initContext(elObject);
    ctx.startBatch();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  expression  DOCUMENT ME!
   * @param  object      context DOCUMENT ME!
   */
  @Override public void verify(String expression, ElObject object) {
    verify(expression, object, null);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   expression   DOCUMENT ME!
   * @param   object       context DOCUMENT ME!
   * @param   extraValues  DOCUMENT ME!
   *
   * @throws  GenericException  DOCUMENT ME!
   */
  @Override public void verify(String expression, ElObject object, Map<String, Object> extraValues) {
    if (logger.isDebugEnabled()) {
      logger.debug("verify: " + object);
    }

    try {
      ElContext context = initContext(object);
      context.putExtraValues(extraValues, true);

      context.verify(expression);
    } catch (RuntimeException e) {
      throw (new GenericException(e.getMessage()));
    } catch (Exception e) {
      throw (new GenericException(e.getMessage()));
    } // end try-catch
  }   // end method verify

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   template  DOCUMENT ME!
   * @param   object    context DOCUMENT ME!
   *
   * @throws  GenericException  DOCUMENT ME!
   */
  @Override public void verifyTemplate(String template, ElObject object) throws GenericException {
    verifyTemplate(template, false, object);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.el.service.ExpressionService#verifyTemplate(String, boolean,
   *       com.ozstrategy.credagility.core.el.ElObject)
   */
  @Override public void verifyTemplate(String template, boolean unescapeHtml, ElObject object) throws GenericException {
    if (template != null) {
      Set<String> expressions = null;

      if (unescapeHtml) {
        expressions = ExpressionContentParser.listUnescapedHtmlExpressions(template);
      } else {
        expressions = ExpressionContentParser.listExpressions(template);
      }

      if (expressions != null) {
        for (String expression : expressions) {
          verify(expression, object);
        }
      }
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private static Set<Field> getAllFields(Class clazz, Set<Field> fields) {
    if (fields == null) {
      fields = new HashSet<Field>();
    }

    for (Field field : clazz.getDeclaredFields()) {
      fields.add(field);
    }

    Class superClazz = clazz.getSuperclass();

    if (superClazz != null) {
      getAllFields(superClazz, fields);
    }

    return fields;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private Object eval(String expression, ElContext context) {
    Object ret = context.eval(expression);

    logger.info("Cacheable Evaluated [Expression: " + expression + ", Result:" + ret + "].");

    return ret;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private List<Object> eval(String[] expressions, ElContext context) {
    return context.eval(expressions);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private <T> T eval(String expression, ElContext context, Class<T> clazz) {
    T ret = context.eval(expression, clazz);

    if (Boolean.class.equals(clazz)) {
      ret = (ret == null) ? (T) Boolean.FALSE : ret;
    }

    logger.info("Cacheable Evaluated [Expression: " + expression + ", Cast To:" + clazz.getName() + "Result:" + ret
      + "].");

    return ret;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private String evaluateTemplate(String template, ElContext context, boolean unescapeHtml, DataFormatter formatter) {
    return ExpressionContentParser.process(template, new ExpressionProcessor() {
          @Override public String process(DollarExpression expression) {
            String expr = null;

            if (unescapeHtml) {
              // com.ozstrategy.credagility.el.util.html.HtmlUtils
              // expr = StringEscapeUtils.unescapeHtml(expression.getExpression());
              expr = StringEscapeUtils.unescapeHtml4(expression.getExpression());
            } else {
              expr = expression.getExpression();
            }

            Object value = eval(expr, context);

            if (value == null) {
              return "";
            }

            if (formatter != null) {
              return formatter.format(value);
            }

            return value.toString();
          }
        });
  } // end method evaluateTemplate

  //~ ------------------------------------------------------------------------------------------------------------------

  private ElContext initContext(ElObject object) {
    ElContext context = expressionVarRepository.getElContext(object.getCacheKey(), object);

    if (!context.isInitial()) {
      if (logger.isDebugEnabled()) {
        logger.debug("Init context data");
      }

      context.initContext(expressionVarRepository);
    }

    return context;
  }
} // end class ExpressionServiceImpl
