package com.ozstrategy.credagility.el.context.promise;

import com.cmc.credagility.core.domain.payment.PromiseToPay;
import com.cmc.credagility.core.domain.variable.BaseVariable;
import com.cmc.credagility.core.domain.variable.Variable;
import com.ozstrategy.credagility.core.el.repository.ExpressionVarRepository;
import com.ozstrategy.credagility.core.util.OzEnv;
import com.ozstrategy.credagility.el.context.responsible.ResponsibleElContext;

import java.util.HashSet;
import java.util.Set;


/**
 * Created with IntelliJ IDEA. User: weitang Date: 14-9-15 Time: PM4:20 To change this template use File | Settings |
 * File Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public class PromiseElContext extends ResponsibleElContext {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  public static final String[] CONTEXT_TYPES = new String[] { "global", "account", "responsible", "promise" };

  /** DOCUMENT ME! */
  @SuppressWarnings("unchecked")
  public static final Class<BaseVariable>[] VARIABLE_CLASSES = new Class[] { Variable.class };

  /** reserved words. */
  private static final Set<String> RESERVED_WORDS = new HashSet<String>();

  static {
    RESERVED_WORDS.add("promise");
  }

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private PromiseToPay promise;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.el.context.responsible.ResponsibleElContext#addBusinessObjectVariables(ExpressionVarRepository)
   */
  @Override public void addBusinessObjectVariables(ExpressionVarRepository ExpressionVarRepository) {
    if (!OzEnv.isDisablePreFetch()) {
      promise = ExpressionVarRepository.preFetchEntity(promise);
    }

    super.addBusinessObjectVariables(ExpressionVarRepository);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.el.context.responsible.ResponsibleElContext#getContextNames()
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
  public PromiseToPay getPromise() {
    return promise;
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
   * @see  com.ozstrategy.credagility.el.context.responsible.ResponsibleElContext#getVariableCacheKey()
   */
  @Override public String getVariableCacheKey() {
    if ((getPortfolio() != null) && (getPortfolio().getPortfolioId() != null)) {
      return "promise-" + getPortfolio().getPortfolioId();
    }

    return "promise";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  promise  DOCUMENT ME!
   */
  public void setPromise(PromiseToPay promise) {
    this.promise = promise;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.el.context.responsible.ResponsibleElContext#createEntityCacheKey()
   */
  @Override protected String createEntityCacheKey() {
    if ((getPromise() != null) && (getPromise().getPromiseId() != null)) {
      return "promise-" + getPromise().getPromiseId();
    }

    return "promise";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.el.context.responsible.ResponsibleElContext#getExposedValueNames()
   */
  @Override protected String[] getExposedValueNames() {
    return new String[] {
        "responsible",
        "account",
        "portfolio",
        "accountDetail",
        "accountIndex",
        "responsibleDetail",
        "eventInstance",
        "flowStep",
        "promise"
      };
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.el.context.responsible.ResponsibleElContext#getVariableClasses()
   */
  @Override protected Class<BaseVariable>[] getVariableClasses() {
    return VARIABLE_CLASSES;
  }
} // end class PromiseElContext
