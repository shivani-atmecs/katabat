package com.ozstrategy.credagility.el.context.accountauthorizedcontact;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.account.AccountAuthorizedContact;
import com.cmc.credagility.core.domain.account.AccountDetail;
import com.cmc.credagility.core.domain.account.AccountIndex;
import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.cmc.credagility.core.domain.portfolio.PortfolioVariable;
import com.cmc.credagility.core.domain.survey.SurveyFlowVariable;
import com.cmc.credagility.core.domain.variable.BaseVariable;
import com.cmc.credagility.core.domain.variable.Variable;
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
public class AccountAuthContactElContext extends ElContext {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** reserved words. */
  private static final Set<String> RESERVED_WORDS = new HashSet<String>();

  static {
    RESERVED_WORDS.add("accountAuthorizedContact");
    RESERVED_WORDS.add("account");
    RESERVED_WORDS.add("accountDetail");
    RESERVED_WORDS.add("accountDetail");
    RESERVED_WORDS.add("accountIndex");
    RESERVED_WORDS.add("portfolio");
  }

  /** DOCUMENT ME! */
  public static final String[] CONTEXT_TYPES = new String[] { "global", "account", "responsible" };

  /** DOCUMENT ME! */
  @SuppressWarnings("unchecked")
  public static final Class<BaseVariable>[] VARIABLE_CLASSES = new Class[] { Variable.class, PortfolioVariable.class };

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  protected Account account;

  /** DOCUMENT ME! */
  protected AccountAuthorizedContact accountAuthorizedContact;

  /** DOCUMENT ME! */
  protected Portfolio   portfolio;
  private AccountDetail accountDetail;
  private AccountIndex  accountIndex;

  /** DOCUMENT ME! */
  private final transient Logger logger = LoggerFactory.getLogger(getClass());

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.el.ElContext#addBusinessObjectVariables(ExpressionVarRepository)
   */
  @Override public void addBusinessObjectVariables(ExpressionVarRepository ExpressionVarRepository) {
    if (accountAuthorizedContact != null) {
      if (!OzEnv.isDisablePreFetch()) {
        accountAuthorizedContact = ExpressionVarRepository.preFetchEntity(accountAuthorizedContact);
      }

      if (account == null) {
        account = accountAuthorizedContact.getAccount();
      }
    }

    if (account != null) {
      accountDetail = account.getAccountDetail();
      accountIndex  = account.getAccountIndex();

      if (portfolio == null) {
        portfolio = account.getPortfolio();
      }
    }

    super.addBusinessObjectVariables(ExpressionVarRepository);
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
  public AccountAuthorizedContact getAccountAuthorizedContact() {
    return accountAuthorizedContact;
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
   * @see  com.ozstrategy.credagility.core.el.ElContext#getVariable(String, ExpressionVarRepository)
   */
  @Override public BaseVariable getVariable(String name, ExpressionVarRepository expressionVarRepository) {
    SimpleCriteria para1 = new SimpleCriteria(Variable.class);
    para1.addCriterion(new EqualCriteria("name", name, true));

    SimpleCriteria para2 = new SimpleCriteria(
        PortfolioVariable.class);
    para2.addCriterion(new EqualCriteria("name", name, true));
    para2.addCriterion(new EqualCriteria("portfolio.portfolioId", portfolio.getPortfolioId()));

    SimpleCriteria para3 = new SimpleCriteria(SurveyFlowVariable.class);
    para3.addCriterion(new EqualCriteria("name", name, true));
    para3.addCriterion(new EqualCriteria("portfolio.portfolioId", portfolio.getPortfolioId()));

    return expressionVarRepository.getVariable(para1, para2, para3);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.el.ElContext#getVariableCacheKey()
   */
  @Override public String getVariableCacheKey() {
    if ((portfolio != null) && (portfolio.getPortfolioId() != null)) {
      return "portfolio-" + portfolio.getPortfolioId();
    }

    return "portfolio";
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
   * @param  accountAuthorizedContact  DOCUMENT ME!
   */
  public void setAccountAuthorizedContact(AccountAuthorizedContact accountAuthorizedContact) {
    this.accountAuthorizedContact = accountAuthorizedContact;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  accountDetail  DOCUMENT ME!
   */
  public void setAccountDetail(AccountDetail accountDetail) {
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
   * @param  portfolio  DOCUMENT ME!
   */
  public void setPortfolio(Portfolio portfolio) {
    this.portfolio = portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("Responsible Level");
    sb.append("[portfolioId=").append(portfolio.getPortfolioId());
    sb.append(", accountAuthorizedContact=").append(
      accountAuthorizedContact);

    if (accountAuthorizedContact != null) {
      sb.append(", accountAuthorizedContact='").append(
        accountAuthorizedContact.getAccountAuthorizedId()).append('\'');
    }

    sb.append(']');

    return sb.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.el.ElContext#createEntityCacheKey()
   */
  @Override protected String createEntityCacheKey() {
    if ((getAccountAuthorizedContact() != null) && (getAccountAuthorizedContact().getAccountAuthorizedId() != null)) {
      return "accountAuthorizedContact-" + getAccountAuthorizedContact().getAccountAuthorizedId();
    }

    return "accountAuthorizedContact";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.el.impl.ResolverContext#getExposedValueNames()
   */
  @Override protected String[] getExposedValueNames() {
    return new String[] {
        "businessObject",
        "accountAuthorizedContact",
        "account",
        "portfolio",
        "accountIndex",
        "accountDetail"
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

    if (this.portfolio != null) {
      variables.addAll(ExpressionVarRepository.readPortfolioVariables(portfolio.getPortfolioId(), getContextNames()));
    }

    return variables;
  }
} // end class AccountAuthContactElContext
