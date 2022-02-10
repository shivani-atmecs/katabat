package com.ozstrategy.credagility.el.context.global;

import com.cmc.credagility.core.domain.variable.BaseVariable;
import com.cmc.credagility.core.domain.variable.Variable;
import com.ozstrategy.credagility.core.el.ElContext;
import com.ozstrategy.credagility.core.query.EqualCriteria;
import com.ozstrategy.credagility.core.query.SimpleCriteria;
import com.ozstrategy.credagility.core.el.repository.ExpressionVarRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * Created by Yang Wang on 2/22/14.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public class GlobalElContext extends ElContext {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  public static final String[] CONTEXT_TYPES = new String[] { "global" };

  /** DOCUMENT ME! */
  @SuppressWarnings("unchecked")
  public static final Class<BaseVariable>[] VARIABLE_CLASSES = new Class[] { Variable.class };

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.el.ElContext#getContextNames()
   */
  @Override public String[] getContextNames() {
    return CONTEXT_TYPES;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.el.ElContext#getVariable(String, ExpressionVarRepository)
   */
  @Override public BaseVariable getVariable(String name, ExpressionVarRepository expressionVarRepository) {
    SimpleCriteria para = new SimpleCriteria(Variable.class);
    para.addCriterion(new EqualCriteria("name", name, true));

    return expressionVarRepository.getVariable(para);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.el.ElContext#getVariableCacheKey()
   */
  @Override public String getVariableCacheKey() {
    return "global";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.el.ElContext#createEntityCacheKey()
   */
  @Override protected String createEntityCacheKey() {
    return "global";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.el.impl.ResolverContext#getExposedValueNames()
   */
  @Override protected String[] getExposedValueNames() {
    return new String[0];
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.el.ElContext#getVariableClasses()
   */
  @Override protected Class<BaseVariable>[] getVariableClasses() {
    return VARIABLE_CLASSES;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.el.ElContext#loadVariables(ExpressionVarRepository)
   */
  @Override protected Collection<? extends BaseVariable> loadVariables(
    ExpressionVarRepository ExpressionVarRepository) {
    List<BaseVariable> variables = new ArrayList<BaseVariable>();

    variables.addAll(ExpressionVarRepository.readSystemVariables(getContextNames()));

    return variables;
  }
} // end class GlobalElContext
