package com.ozstrategy.credagility.el.context.program;

import com.cmc.credagility.core.domain.payment.PaymentProgram;
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
public class ProgramElContext extends ResponsibleElContext {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  public static final String[] CONTEXT_TYPES = new String[] { "global", "account", "responsible", "program" };

  /** DOCUMENT ME! */
  @SuppressWarnings("unchecked")
  public static final Class<BaseVariable>[] VARIABLE_CLASSES = new Class[] { Variable.class };

  /** reserved words. */
  private static final Set<String> RESERVED_WORDS = new HashSet<String>();

  static {
    RESERVED_WORDS.add("program");
  }

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private PaymentProgram program;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.el.context.responsible.ResponsibleElContext#addBusinessObjectVariables(ExpressionVarRepository)
   */
  @Override public void addBusinessObjectVariables(ExpressionVarRepository ExpressionVarRepository) {
    if (!OzEnv.isDisablePreFetch()) {
      program = ExpressionVarRepository.preFetchEntity(program);
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
  public PaymentProgram getProgram() {
    return program;
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
      return "program-" + getPortfolio().getPortfolioId();
    }

    return "program";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  program  DOCUMENT ME!
   */
  public void setProgram(PaymentProgram program) {
    this.program = program;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.el.context.responsible.ResponsibleElContext#createEntityCacheKey()
   */
  @Override protected String createEntityCacheKey() {
    if ((getProgram() != null) && (getProgram().getProgramId() != null)) {
      return "program-" + getProgram().getProgramId();
    }

    return "program";
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
        "program"
      };
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.el.context.responsible.ResponsibleElContext#getVariableClasses()
   */
  @Override protected Class<BaseVariable>[] getVariableClasses() {
    return VARIABLE_CLASSES;
  }
} // end class ProgramElContext
