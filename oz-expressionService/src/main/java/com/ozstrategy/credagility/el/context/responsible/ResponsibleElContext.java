package com.ozstrategy.credagility.el.context.responsible;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.account.AccountDetail;
import com.cmc.credagility.core.domain.account.AccountIndex;
import com.cmc.credagility.core.domain.customer.Customer;
import com.cmc.credagility.core.domain.event.EventInstance;
import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.cmc.credagility.core.domain.portfolio.PortfolioVariable;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.domain.responsible.ResponsibleDetail;
import com.cmc.credagility.core.domain.survey.SurveyFlowVariable;
import com.cmc.credagility.core.domain.user.User;
import com.cmc.credagility.core.domain.variable.BaseVariable;
import com.cmc.credagility.core.domain.variable.UtilityHiddenVariable;
import com.cmc.credagility.core.domain.variable.Variable;
import com.cmc.credagility.core.domain.variable.WorkflowVariable;
import com.ozstrategy.credagility.core.domain.SurveyFlowStep;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject;
import com.ozstrategy.credagility.core.domain.workflow.responsible.ResponsibleWorkflowBusinessObject;
import com.ozstrategy.credagility.core.el.ElContext;
import com.ozstrategy.credagility.core.query.EqualCriteria;
import com.ozstrategy.credagility.core.query.InCriteria;
import com.ozstrategy.credagility.core.query.NotEqualCriteria;
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
public class ResponsibleElContext extends ElContext {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  public static final String[] CONTEXT_TYPES = new String[] { "global", "account", "responsible", "customer" };

  /** DOCUMENT ME! */
  @SuppressWarnings("unchecked")
  public static final Class<BaseVariable>[] VARIABLE_CLASSES = new Class[] {
    Variable.class,
    WorkflowVariable.class,
    PortfolioVariable.class,
    SurveyFlowVariable.class,
    UtilityHiddenVariable.class
  };

  /** reserved words. */
  private static final Set<String> RESERVED_WORDS = new HashSet<String>();

  static {
    RESERVED_WORDS.add("responsible");
    RESERVED_WORDS.add("account");
    RESERVED_WORDS.add("customer");
    RESERVED_WORDS.add("portfolio");
    RESERVED_WORDS.add("accountDetail");
    RESERVED_WORDS.add("accountIndex");
    RESERVED_WORDS.add("responsibleDetail");
    RESERVED_WORDS.add("eventInstance");
    RESERVED_WORDS.add("flowStep");
  }

  /** DOCUMENT ME! */
  private static final Logger logger = LoggerFactory.getLogger(ResponsibleElContext.class);

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  protected Account account;

  /** DOCUMENT ME! */
  protected AccountDetail accountDetail;

  /** DOCUMENT ME! */
  protected AccountIndex accountIndex;

  /** DOCUMENT ME! */
  protected EventInstance eventInstance;

  /** DOCUMENT ME! */
  protected SurveyFlowStep flowStep;

  /** DOCUMENT ME! */
  protected Portfolio portfolio;

  /** DOCUMENT ME! */
  protected Responsible responsible;

  /** DOCUMENT ME! */
  protected ResponsibleDetail responsibleDetail;

  private User                executor;

  /** TODO: DOCUMENT ME! */
  protected Customer customer;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addBusinessObjectVariables.
   *
   * @param  ExpressionVarRepository  ExpressionVarRepository
   */
  @Override public void addBusinessObjectVariables(ExpressionVarRepository ExpressionVarRepository) {
    if (logger.isDebugEnabled()) {
      logger.debug("The property @DisablePreFetch: " + OzEnv.isDisablePreFetch());
    }

    if (responsible != null) {
      if (!OzEnv.isDisablePreFetch()) {
        if (logger.isDebugEnabled()) {
          logger.debug("....Start to preFetch Entity by responsible.");
        }

        responsible = ExpressionVarRepository.preFetchEntity(responsible);

        if (logger.isDebugEnabled()) {
          logger.debug("....End to preFetch Entity by responsible");
        }

      }

      responsibleDetail = responsible.getResponsibleDetail();
      account           = responsible.getAccount();
      customer          = responsible.getCustomer();
    }

    if (account != null) {
      accountDetail = account.getAccountDetail();
      accountIndex  = account.getAccountIndex();
      portfolio     = account.getPortfolio();
    }

    if (logger.isDebugEnabled()) {
      logger.debug("Load related information Done...");
    }
  } // end method addBusinessObjectVariables

  public Customer getCustomer() {
    return customer;
  }
//~ ------------------------------------------------------------------------------------------------------------------

  /**
   * bindEvalContextHolder.
   */
  @Override public void bindEvalContextHolder() {
    WorkflowBusinessObject obj = this.getBusinessObject();

    if (obj == null) {
      obj = new ResponsibleWorkflowBusinessObject();
      obj.setObject(responsible);
    }

    obj.copyParam(getExtParams());
    this.setBusinessObject(obj);
  } // end method bindEvalContextHolder

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.el.ElContext#checkVarNameExistParams(String, Long,
   *       Long)
   */
  @Override public SimpleCriteria[] checkVarNameExistParams(String varName, Long varId, Long portfolioId) {
    List<SimpleCriteria>            params  = new ArrayList<SimpleCriteria>();
    Class<? extends BaseVariable>[] classes = getVariableClasses();

    for (Class<? extends BaseVariable> clazz : classes) {
      SimpleCriteria param = new SimpleCriteria(clazz);
      param.addCriterion(new InCriteria(Context_Column, getContextNames()));
      param.addCriterion(new EqualCriteria("name", varName, true));

      if (varId != null) {
        param.addCriterion(new NotEqualCriteria("id", varId));
      }

      if ((!(Variable.class.equals(clazz) || WorkflowVariable.class.equals(clazz)
                || UtilityHiddenVariable.class.equals(clazz)))
            && (portfolioId != null)) {
        param.addCriterion(new EqualCriteria("portfolio.portfolioId", portfolioId));
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
  public AccountDetail getAccountDetail() {
    return accountDetail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public AccountIndex getAccountIndex() {
    return accountIndex;
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
  public EventInstance getEventInstance() {
    return eventInstance;
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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public SurveyFlowStep getFlowStep() {
    return flowStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Portfolio getPortfolio() {
    return portfolio;
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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public ResponsibleDetail getResponsibleDetail() {
    return responsibleDetail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.el.ElContext#getVariable(String, ExpressionVarRepository)
   */
  @Override public BaseVariable getVariable(String name, ExpressionVarRepository expressionVarRepository) {
    SimpleCriteria para1 = new SimpleCriteria(Variable.class);
    para1.addCriterion(new EqualCriteria("name", name, true));

    SimpleCriteria para2 = new SimpleCriteria(
        PortfolioVariable.class);
    para2.addCriterion(new EqualCriteria("name", name, true));
    para2.addCriterion(new EqualCriteria("portfolio.portfolioId",
        getPortfolio().getPortfolioId()));

    SimpleCriteria para3 = new SimpleCriteria(
        SurveyFlowVariable.class);
    para3.addCriterion(new EqualCriteria("name", name, true));
    para3.addCriterion(new EqualCriteria("portfolio.portfolioId",
        getPortfolio().getPortfolioId()));

    SimpleCriteria para4 = new SimpleCriteria(UtilityHiddenVariable.class);
    para4.addCriterion(new EqualCriteria("name", name, true));

    return expressionVarRepository.getVariable(para1, para2, para3, para4);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.el.ElContext#getVariableCacheKey()
   */
  @Override public String getVariableCacheKey() {
    if ((getPortfolio() != null) && (getPortfolio().getPortfolioId() != null)) {
      return "portfolio-" + getPortfolio().getPortfolioId();
    }

    return "portfolio";
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

      if ((!(Variable.class.equals(clazz) || WorkflowVariable.class.equals(clazz)
                || UtilityHiddenVariable.class.equals(clazz))) && (getPortfolio() != null)) {
        param.addCriterion(new EqualCriteria("portfolio.portfolioId", getPortfolio().getPortfolioId()));
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
   * @param  accountDetail  DOCUMENT ME!
   */
  public void setAccountDetails(AccountDetail accountDetail) {
    this.accountDetail = accountDetail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  accountIndex  DOCUMENT ME!
   */
  public void setAccountIndex(AccountIndex accountIndex) {
    this.accountIndex = accountIndex;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  eventInstance  DOCUMENT ME!
   */
  public void setEventInstance(EventInstance eventInstance) {
    this.eventInstance = eventInstance;
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
   * @param  flowStep  DOCUMENT ME!
   */
  public void setFlowStep(SurveyFlowStep flowStep) {
    this.flowStep = flowStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  portfolio  DOCUMENT ME!
   */
  public void setPortfolio(Portfolio portfolio) {
    this.portfolio = portfolio;
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
   * @param  responsibleDetail  DOCUMENT ME!
   */
  public void setResponsibleDetail(ResponsibleDetail responsibleDetail) {
    this.responsibleDetail = responsibleDetail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.el.ElContext#createEntityCacheKey()
   */
  @Override protected String createEntityCacheKey() {
    if ((responsible != null) && (responsible.getResponsibleId() != null)) {
      return "responsible-" + responsible.getResponsibleId();
    }

    return "responsible";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.el.impl.ResolverContext#getExposedValueNames()
   */
  @Override protected String[] getExposedValueNames() {
    return new String[] {
        "businessObject",
        "responsible",
        "account",
        "customer",
        "portfolio",
        "accountDetail",
        "accountIndex",
        "responsibleDetail",
        "eventInstance",
        "flowStep"
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
    return ExpressionVarRepository.readVariables((this.portfolio != null) ? this.portfolio.getPortfolioId() : null,
        getContextNames());

// List<BaseVariable> variables = new ArrayList<BaseVariable>();
//
// variables.addAll(ExpressionVarRepository.readSystemVariables(getContextNames()));
//
// if (this.portfolio != null) {
// variables.addAll(ExpressionVarRepository.readPortfolioVariables(
// portfolio.getPortfolioId(), getContextNames()));
// variables.addAll(ExpressionVarRepository.readSurveyFlowVariables(
// portfolio.getPortfolioId(), getContextNames()));
// }
//
// return variables;
  }
} // end class ResponsibleElContext
