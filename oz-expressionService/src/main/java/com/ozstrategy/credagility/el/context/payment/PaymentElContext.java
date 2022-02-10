package com.ozstrategy.credagility.el.context.payment;

import com.cmc.credagility.core.domain.payment.Payment;
import com.cmc.credagility.core.domain.variable.BaseVariable;
import com.cmc.credagility.core.domain.variable.Variable;
import com.ozstrategy.credagility.core.el.repository.ExpressionVarRepository;
import com.ozstrategy.credagility.core.util.OzEnv;
import com.ozstrategy.credagility.el.context.responsible.ResponsibleElContext;

import java.util.HashSet;
import java.util.Set;


/**
 * Created by Yang Wang on 2/22/14.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public class PaymentElContext extends ResponsibleElContext {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  public static final String[] CONTEXT_TYPES = new String[] { "global", "account", "responsible", "payment" };

  /** DOCUMENT ME! */
  @SuppressWarnings("unchecked")
  public static final Class<BaseVariable>[] VARIABLE_CLASSES = new Class[] { Variable.class };

  /** reserved words. */
  private static final Set<String> RESERVED_WORDS = new HashSet<String>();

  static {
    RESERVED_WORDS.add("payment");
  }

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private Payment payment;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.el.context.responsible.ResponsibleElContext#addBusinessObjectVariables(ExpressionVarRepository)
   */
  @Override public void addBusinessObjectVariables(ExpressionVarRepository ExpressionVarRepository) {
    if (!OzEnv.isDisablePreFetch()) {
      payment = ExpressionVarRepository.preFetchEntity(payment);
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
  public Payment getPayment() {
    return payment;
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
      return "payment-" + getPortfolio().getPortfolioId();
    }

    return "payment";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  payment  DOCUMENT ME!
   */
  public void setPayment(Payment payment) {
    this.payment = payment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.el.context.responsible.ResponsibleElContext#createEntityCacheKey()
   */
  @Override protected String createEntityCacheKey() {
    if ((getPayment() != null) && (getPayment().getPaymentId() != null)) {
      return "payment-" + getPayment().getPaymentId();
    }

    return "payment";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.el.context.responsible.ResponsibleElContext#getExposedValueNames()
   */
  @Override protected String[] getExposedValueNames() {
    return new String[] {
        "businessObject",
        "responsible",
        "account",
        "portfolio",
        "accountDetail",
        "accountIndex",
        "responsibleDetail",
        "eventInstance",
        "flowStep",
        "payment"
      };
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.el.context.responsible.ResponsibleElContext#getVariableClasses()
   */
  @Override protected Class<BaseVariable>[] getVariableClasses() {
    return VARIABLE_CLASSES;
  }
} // end class PaymentElContext
