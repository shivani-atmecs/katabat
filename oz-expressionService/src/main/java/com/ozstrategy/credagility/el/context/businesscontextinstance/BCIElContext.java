package com.ozstrategy.credagility.el.context.businesscontextinstance;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.businesscontext.BCVariable;
import com.cmc.credagility.core.domain.businesscontext.BusinessContext;
import com.cmc.credagility.core.domain.businesscontext.BusinessContextInstance;
import com.cmc.credagility.core.domain.customer.Customer;
import com.cmc.credagility.core.domain.portfolio.PortfolioVariable;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.domain.user.User;
import com.cmc.credagility.core.domain.variable.BaseVariable;
import com.cmc.credagility.core.domain.variable.UtilityHiddenVariable;
import com.cmc.credagility.core.domain.variable.Variable;

import com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject;
import com.ozstrategy.credagility.core.domain.workflow.bci.BCIWorkflowBusinessObject;
import com.ozstrategy.credagility.core.domain.workflow.bci.BCIWorkflowStep;
import com.ozstrategy.credagility.core.el.ElContext;
import com.ozstrategy.credagility.core.query.EqualCriteria;
import com.ozstrategy.credagility.core.query.InCriteria;
import com.ozstrategy.credagility.core.query.NotEqualCriteria;
import com.ozstrategy.credagility.core.query.SimpleCriteria;
import com.ozstrategy.credagility.core.el.repository.ExpressionVarRepository;


/**
 * Created by Yang Wang on 2/22/14.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public class BCIElContext extends ElContext {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  public static final String[] CONTEXT_TYPES = new String[] {
    "global",
    "customer",
    "account",
    "responsible",
    "business"
  };

  /** DOCUMENT ME! */
  @SuppressWarnings("unchecked")
  public static final Class<BaseVariable>[] VARIABLE_CLASSES = new Class[] {
    Variable.class,
    BCVariable.class,
    UtilityHiddenVariable.class
  };

  /** reserved words. */
  private static final Set<String> RESERVED_WORDS = new HashSet<String>();

  static {
    RESERVED_WORDS.add("businessContextInstance");
    RESERVED_WORDS.add("bci");
    RESERVED_WORDS.add("responsible");
    RESERVED_WORDS.add("account");
    RESERVED_WORDS.add("portfolio");
    RESERVED_WORDS.add("accountDetail");
    RESERVED_WORDS.add("accountIndex");
    RESERVED_WORDS.add("responsibleDetail");
    RESERVED_WORDS.add("eventInstance");
    RESERVED_WORDS.add("flowStep");
    RESERVED_WORDS.add("customer");
  }

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private Account                 account;
  private BusinessContext         businessContext;
  private Long                    businessContextId;
  private BusinessContextInstance businessContextInstance;
  private Customer                customer;
  private User                    executor;

  /** DOCUMENT ME! */
  private final transient Logger logger       = LoggerFactory.getLogger(getClass());
  private Responsible            responsible;
  private BCIWorkflowStep        workflowStep;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.el.ElContext#addBusinessObjectVariables(ExpressionVarRepository)
   */
  @Override public void addBusinessObjectVariables(ExpressionVarRepository ExpressionVarRepository) {
    if (logger.isDebugEnabled()) {
      logger.debug("Load related information Done...");
    }

// if (!OzEnv.isDisablePreFetch()) {
    businessContextInstance = ExpressionVarRepository.preFetchEntity(businessContextInstance);
// }

    if (businessContextInstance != null) {
      account     = businessContextInstance.getAccount();
      customer    = businessContextInstance.getCustomer();
      responsible = businessContextInstance.getResponsible();
    }

    super.addBusinessObjectVariables(ExpressionVarRepository);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.el.ElContext#bindEvalContextHolder()
   */
  @Override public void bindEvalContextHolder() {
    WorkflowBusinessObject    obj            = this.getBusinessObject();
    BCIWorkflowBusinessObject businessObject = null;

    if (obj == null) {
      businessObject = new BCIWorkflowBusinessObject();
      obj            = businessObject;
    } else {
      businessObject = (BCIWorkflowBusinessObject) obj;
    }

    businessObject.setBci(businessContextInstance);
    businessObject.setWorkflowStep(workflowStep);

    this.setBusinessObject(businessObject);
    obj.copyParam(getExtParams());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.el.ElContext#checkVarNameExistParams(String,Long, Long)
   */
  @Override public SimpleCriteria[] checkVarNameExistParams(String varName, Long varId, Long contextId) {
    List<SimpleCriteria>            params  = new ArrayList<SimpleCriteria>();
    Class<? extends BaseVariable>[] classes = getVariableClasses();

    for (Class<? extends BaseVariable> clazz : classes) {
      SimpleCriteria param = new SimpleCriteria(clazz);
      param.addCriterion(new InCriteria(Context_Column, getContextNames()));
      param.addCriterion(new EqualCriteria("name", varName, true));

      if (varId != null) {
        param.addCriterion(new NotEqualCriteria("id", varId));
      }

      if ((!Variable.class.equals(clazz)) && (contextId != null)) {
        param.addCriterion(new EqualCriteria("businessContext.id", contextId));
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
  public Account getAccount() {
    return account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BusinessContext getBusinessContext() {
    return businessContext;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getBusinessContextId() {
    return businessContextId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BusinessContextInstance getBusinessContextInstance() {
    return businessContextInstance;
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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Customer getCustomer() {
    return customer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for executor.
   *
   * @return  User
   */
  public User getExecutor() {
    return executor;
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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Responsible getResponsible() {
    return responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.el.ElContext#getVariable(String, ExpressionVarRepository)
   */
  @Override public BaseVariable getVariable(String name, ExpressionVarRepository expressionVarRepository) {
    Class<? extends BaseVariable>[] classes = getVariableClasses();

    for (Class<? extends BaseVariable> clazz : classes) {
      SimpleCriteria para1 = new SimpleCriteria(clazz);
      para1.addCriterion(new EqualCriteria("name", name, true));

      if (expressionVarRepository.getVariable(para1) != null) {
        return expressionVarRepository.getVariable(para1);
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.el.ElContext#getVariableCacheKey()
   */
  @Override public String getVariableCacheKey() {
    return "business-" + this.businessContextId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BCIWorkflowStep getWorkflowStep() {
    return workflowStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.el.ElContext#populateSuggestParams()
   */
  @Override public SimpleCriteria[] populateSuggestParams() {
    List<SimpleCriteria>            params  = new ArrayList<SimpleCriteria>();
    Class<? extends BaseVariable>[] classes = getVariableClasses();

    for (Class<? extends BaseVariable> clazz : classes) {
      SimpleCriteria param = new SimpleCriteria(clazz);
      param.addCriterion(new InCriteria(Context_Column, getContextNames()));

      if ((!(Variable.class.equals(clazz) || PortfolioVariable.class.equals(clazz)))
            && (this.businessContextId != null)) {
        param.addCriterion(new EqualCriteria("businessContext.id", this.businessContextId));
      }

      params.add(param);
    }

    return params.toArray(new SimpleCriteria[params.size()]);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  account  DOCUMENT ME!
   */
  public void setAccount(Account account) {
    this.account = account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  businessContext  DOCUMENT ME!
   */
  public void setBusinessContext(BusinessContext businessContext) {
    this.businessContext = businessContext;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  businessContextId  DOCUMENT ME!
   */
  public void setBusinessContextId(Long businessContextId) {
    this.businessContextId = businessContextId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  businessContextInstance  DOCUMENT ME!
   */
  public void setBusinessContextInstance(BusinessContextInstance businessContextInstance) {
    this.businessContextInstance = businessContextInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  customer  DOCUMENT ME!
   */
  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for executor.
   *
   * @param  executor  User
   */
  public void setExecutor(User executor) {
    this.executor = executor;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  responsible  DOCUMENT ME!
   */
  public void setResponsible(Responsible responsible) {
    this.responsible = responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  workflowStep  DOCUMENT ME!
   */
  public void setWorkflowStep(BCIWorkflowStep workflowStep) {
    this.workflowStep = workflowStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("Business Context Instance Level");
    sb.append("[businessContextInstanceId =").append((businessContextInstance != null) ? businessContextInstance
        .getId() : null);
    sb.append(']');

    return sb.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.el.ElContext#createEntityCacheKey()
   */
  @Override protected String createEntityCacheKey() {
    if (this.businessContextInstance != null) {
      return "business-" + businessContextInstance.getId();
    } else if (workflowStep != null) {
      return "business-wfins-" + workflowStep.getWorkflowInstance().getId();
    }

    return "business-" + businessContextId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.el.impl.ResolverContext#getExposedValueNames()
   */
  @Override protected String[] getExposedValueNames() {
    return new String[] {
        "businessObject",
        "businessContext",
        "businessContextInstance",
        "account",
        "responsible",
        "customer"
      };
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
    variables.addAll(ExpressionVarRepository.readUtilityVariables(getContextNames()));

    if (this.businessContextId != null) {
      variables.addAll(ExpressionVarRepository.readBCIVariables(this.businessContextId));
    }

    return variables;
  }
} // end class BCIElContext
