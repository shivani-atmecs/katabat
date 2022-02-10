package com.ozstrategy.credagility.core.el;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cmc.credagility.core.domain.variable.BaseVariable;

import com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject;
import com.ozstrategy.credagility.core.el.repository.ExpressionVarRepository;
import com.ozstrategy.credagility.core.query.EqualCriteria;
import com.ozstrategy.credagility.core.query.InCriteria;
import com.ozstrategy.credagility.core.query.NotEqualCriteria;
import com.ozstrategy.credagility.core.query.SimpleCriteria;

import com.ozstrategy.el.impl.ResolverContext;
import com.ozstrategy.el.util.CalculateUtil;


/**
 * Base Expression Context Object.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  10/28/2014 11:39 AM
 */
public abstract class ElContext extends ResolverContext {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  protected static final String Context_Column = "context";

  private static final Logger logger = LoggerFactory.getLogger(ElContext.class);

  /** reserved words. */
  private static final Set<String> RESERVED_WORDS = new HashSet<>();

  static {
    RESERVED_WORDS.add("abstract");
    RESERVED_WORDS.add("continue");
    RESERVED_WORDS.add("for");
    RESERVED_WORDS.add("new");
    RESERVED_WORDS.add("switch");
    RESERVED_WORDS.add("assert");
    RESERVED_WORDS.add("default");
    RESERVED_WORDS.add("goto");
    RESERVED_WORDS.add("package");
    RESERVED_WORDS.add("synchronized");
    RESERVED_WORDS.add("boolean");
    RESERVED_WORDS.add("do");
    RESERVED_WORDS.add("if");
    RESERVED_WORDS.add("private");
    RESERVED_WORDS.add("this");
    RESERVED_WORDS.add("break");
    RESERVED_WORDS.add("double");
    RESERVED_WORDS.add("implements");
    RESERVED_WORDS.add("protected");
    RESERVED_WORDS.add("throw");
    RESERVED_WORDS.add("byte");
    RESERVED_WORDS.add("else");
    RESERVED_WORDS.add("import");
    RESERVED_WORDS.add("public");
    RESERVED_WORDS.add("throws");
    RESERVED_WORDS.add("case");
    RESERVED_WORDS.add("enum");
    RESERVED_WORDS.add("instanceof");
    RESERVED_WORDS.add("return");
    RESERVED_WORDS.add("transient");
    RESERVED_WORDS.add("catch");
    RESERVED_WORDS.add("extends");
    RESERVED_WORDS.add("int");
    RESERVED_WORDS.add("short");
    RESERVED_WORDS.add("try");
    RESERVED_WORDS.add("char");
    RESERVED_WORDS.add("final");
    RESERVED_WORDS.add("interface");
    RESERVED_WORDS.add("static");
    RESERVED_WORDS.add("void");
    RESERVED_WORDS.add("class");
    RESERVED_WORDS.add("finally");
    RESERVED_WORDS.add("long");
    RESERVED_WORDS.add("strictfp");
    RESERVED_WORDS.add("volatile");
    RESERVED_WORDS.add("const");
    RESERVED_WORDS.add("float");
    RESERVED_WORDS.add("native");
    RESERVED_WORDS.add("super");
    RESERVED_WORDS.add("while");
    RESERVED_WORDS.add("and");
    RESERVED_WORDS.add("or");
    RESERVED_WORDS.add("with");
    RESERVED_WORDS.add("isdef");
    RESERVED_WORDS.add("contains");
    RESERVED_WORDS.add("soundslike");
    RESERVED_WORDS.add("strsim");
    RESERVED_WORDS.add("is");
    RESERVED_WORDS.add("in");
    RESERVED_WORDS.add("java");
    RESERVED_WORDS.add("currency");
    RESERVED_WORDS.add("decimal");

    RESERVED_WORDS.add("answer");
    RESERVED_WORDS.add("businessObject");

    ResolverContext.init();
  }

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  protected Map<String, Object> extParams = new HashMap<String, Object>();

  private WorkflowBusinessObject businessObject;
  private String                 entityCacheKey = null;
  private boolean                initial        = false;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public abstract String[] getContextNames();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   name    DOCUMENT ME!
   * @param   varDao  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public abstract BaseVariable getVariable(String name, ExpressionVarRepository varDao);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public abstract String getVariableCacheKey();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  varDao  DOCUMENT ME!
   */
  public void addBusinessObjectVariables(ExpressionVarRepository varDao) { }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  name   DOCUMENT ME!
   * @param  value  DOCUMENT ME!
   */
  public void addExtParam(String name, Object value) {
    extParams.put(name, value);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  params  DOCUMENT ME!
   */
  public void addExtParams(Map<String, Object> params) {
    extParams.putAll(params);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   */
  public void beforeCreateEvalMap() {
    // To change body of implemented methods use File | Settings | File Templates.
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   */
  public void bindEvalContextHolder() {
    // To change body of implemented methods use File | Settings | File Templates.
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   varName    DOCUMENT ME!
   * @param   varId      DOCUMENT ME!
   * @param   contextId  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public SimpleCriteria[] checkVarNameExistParams(String varName, Long varId, Long contextId) {
    List<SimpleCriteria>            params  = new ArrayList<SimpleCriteria>();
    Class<? extends BaseVariable>[] classes = getVariableClasses();

    for (Class<? extends BaseVariable> clazz : classes) {
      SimpleCriteria param = new SimpleCriteria(clazz);
      param.addCriterion(new InCriteria(Context_Column, getContextNames()));
      param.addCriterion(new EqualCriteria("name", varName, true));

      if (varId != null) {
        param.addCriterion(new NotEqualCriteria("id", varId));
      }

      params.add(param);
    }

    return params.toArray(new SimpleCriteria[params.size()]);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public WorkflowBusinessObject getBusinessObject() {
    return businessObject;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getEntityCacheKey() {
    if (entityCacheKey == null) {
      entityCacheKey = createEntityCacheKey();
    }

    return entityCacheKey;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Map<String, Object> getExtParams() {
    return extParams;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<String> getReservedWords() {
    return RESERVED_WORDS;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   varDao  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Collection<? extends BaseVariable> getVariables(ExpressionVarRepository varDao) {
    return loadVariables(varDao);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  varDao  DOCUMENT ME!
   */
  public void initContext(ExpressionVarRepository varDao) {
    addValue("CommonFunction", new CalculateUtil());

    ELFunctionRegister.getAllFunctions().forEach((key, value) -> addValue(key, value));

    if (logger.isDebugEnabled()) {
      logger.debug("Start addBusinessObjectVariables ");
    }

    addBusinessObjectVariables(varDao);

    if (logger.isDebugEnabled()) {
      logger.debug("End addBusinessObjectVariables.");
    }

    bindEvalContextHolder();

    if (logger.isDebugEnabled()) {
      logger.debug("Start to load Portfolio Variables.");
    }

    Collection<? extends BaseVariable> variables = varDao.getContextVariables(getVariableCacheKey(), this);

    if (logger.isDebugEnabled()) {
      logger.debug("End load variables and find: {} variables.", ((variables) != null) ? variables.size() : 0);
    }

    if (variables != null) {
      if (logger.isDebugEnabled()) {
        logger.debug("Start to process variables.");
      }

      for (BaseVariable baseVariable : variables) {
        String name = baseVariable.getName().toLowerCase(Locale.getDefault());
        String expr = baseVariable.getExpression();

        if ("property".equalsIgnoreCase(baseVariable.getCategory()) && (expr.indexOf("evalManager") > -1) && (expr.indexOf("(") < 0)) {
          expr = expr + "()";
        }

        if ("function".equalsIgnoreCase(baseVariable.getCategory())) {
          String[] strings = expr.split("\\(");
          addFunction(name, strings[0], baseVariable.getDataTypeClass());
        } else {
          addDefinition(name, expr, baseVariable.getDataTypeClass());
        }
      }

      if (logger.isDebugEnabled()) {
        logger.debug("End process " + variables.size() + " variables.");
      }
    }

    initial = true;
  } // end method initContext

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isInitial() {
    return initial;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public SimpleCriteria[] populateSuggestParams() {
    List<SimpleCriteria>            params  = new ArrayList<SimpleCriteria>();
    Class<? extends BaseVariable>[] classes = getVariableClasses();

    for (Class<? extends BaseVariable> clazz : classes) {
      SimpleCriteria param = new SimpleCriteria(clazz);
      param.addCriterion(new InCriteria(Context_Column, getContextNames()));
      params.add(param);
    }

    return params.toArray(new SimpleCriteria[params.size()]);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  extraValues  DOCUMENT ME!
   * @param  overwrite    DOCUMENT ME!
   */
  public void putExtraValues(Map<String, Object> extraValues, boolean overwrite) {
    // process extra value
    if (extraValues != null) {
      extraValues.forEach((name, value) -> {
        if (overwrite) {
          addValue(name, value);
        } else {
          if (!this.contains(name)) {
            this.addValue(name, value);
          }
        }
      });

    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  businessObject  DOCUMENT ME!
   */
  public void setBusinessObject(WorkflowBusinessObject businessObject) {
    this.businessObject = businessObject;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  protected abstract String createEntityCacheKey();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  protected abstract Class<BaseVariable>[] getVariableClasses();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   varDao  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  protected abstract Collection<? extends BaseVariable> loadVariables(ExpressionVarRepository varDao);
} // end class ElContext
