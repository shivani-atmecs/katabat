package com.ozstrategy.credagility.el.context.agent;

import com.cmc.credagility.core.domain.user.User;
import com.cmc.credagility.core.domain.variable.BaseVariable;
import com.cmc.credagility.core.domain.variable.Variable;
import com.cmc.credagility.core.domain.variable.WorkflowVariable;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject;
import com.ozstrategy.credagility.core.domain.workflow.agent.AgentWorkflowBusinessObject;
import com.ozstrategy.credagility.core.domain.workflow.enterprise.WorkflowStep;
import com.ozstrategy.credagility.core.el.ElContext;
import com.ozstrategy.credagility.core.query.EqualCriteria;
import com.ozstrategy.credagility.core.query.SimpleCriteria;
import com.ozstrategy.credagility.core.el.repository.ExpressionVarRepository;
import com.ozstrategy.credagility.core.util.OzEnv;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Created by Yang Wang on 2/22/14.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public class AgentElContext extends ElContext {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** reserved words. */
  private static final Set<String> RESERVED_WORDS = new HashSet<String>();

  static {
    RESERVED_WORDS.add("agent");
  }

  /** DOCUMENT ME! */
  public static final String[] CONTEXT_TYPES = new String[] { "global", "agent" };

  /** DOCUMENT ME! */
  @SuppressWarnings("unchecked")
  public static final Class<BaseVariable>[] VARIABLE_CLASSES = new Class[] { Variable.class, WorkflowVariable.class };

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private User agent;

  /** DOCUMENT ME! */
  private final transient Logger logger       = LoggerFactory.getLogger(getClass());
  private WorkflowStep           workflowStep;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.el.ElContext#addBusinessObjectVariables(ExpressionVarRepository)
   */
  @Override public void addBusinessObjectVariables(ExpressionVarRepository ExpressionVarRepository) {
    if (!OzEnv.isDisablePreFetch()) {
      agent = ExpressionVarRepository.preFetchEntity(agent);
    }

    super.addBusinessObjectVariables(ExpressionVarRepository);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.el.ElContext#bindEvalContextHolder()
   */
  @Override public void bindEvalContextHolder() {
    WorkflowBusinessObject obj = this.getBusinessObject();

    if (obj == null) {
      obj = new AgentWorkflowBusinessObject();
      ((AgentWorkflowBusinessObject) obj).setAgent(agent);
    }

    obj.copyParam(getExtParams());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public User getAgent() {
    return agent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.el.ElContext#getContextNames()
   */
  @Override public String[] getContextNames() {
    return CONTEXT_TYPES;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.el.ElContext#getReservedWords()
   */
  @Override public Set<String> getReservedWords() {
    Set<String> words = new HashSet<String>();
    words.addAll(super.getReservedWords());
    words.addAll(RESERVED_WORDS);

    return words;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.el.ElContext#getVariable(String, ExpressionVarRepository)
   */
  @Override public BaseVariable getVariable(String name, ExpressionVarRepository expressionVarRepository) {
    SimpleCriteria para1 = new SimpleCriteria(Variable.class);
    para1.addCriterion(new EqualCriteria("name", name, true));

    SimpleCriteria para2 = new SimpleCriteria(WorkflowVariable.class);
    para2.addCriterion(new EqualCriteria("name", name, true));

    return expressionVarRepository.getVariable(para1, para2);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.el.ElContext#getVariableCacheKey()
   */
  @Override public String getVariableCacheKey() {
    return "agent";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public WorkflowStep getWorkflowStep() {
    return workflowStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  agent  DOCUMENT ME!
   */
  public void setAgent(User agent) {
    this.agent = agent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  workflowStep  DOCUMENT ME!
   */
  public void setWorkflowStep(WorkflowStep workflowStep) {
    this.workflowStep = workflowStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.el.ElContext#createEntityCacheKey()
   */
  @Override protected String createEntityCacheKey() {
    if ((agent != null) && (agent.getId() != null)) {
      return "agent-" + agent.getId();
    }

    return "agent";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.el.impl.ResolverContext#getExposedValueNames()
   */
  @Override protected String[] getExposedValueNames() {
    return new String[] { "businessObject", "agent", "workflowStep" };
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
} // end class AgentElContext
