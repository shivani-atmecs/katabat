package com.ozstrategy.credagility.el.context.program;

import com.cmc.credagility.core.domain.payment.PaymentProgram;
import com.cmc.credagility.core.domain.portfolio.Portfolio;

import com.ozstrategy.credagility.el.context.responsible.ResponsibleElContext;
import com.ozstrategy.credagility.el.context.responsible.ResponsibleElObject;


/**
 * Created by Yang Wang on 2/24/14.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public class ProgramElObject extends ResponsibleElObject<ProgramElContext> {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  private PaymentProgram program;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new ProgramElContext object.
   */
  public ProgramElObject() { }

  /**
   * Creates a new ProgramElObject object.
   *
   * @param  program  DOCUMENT ME!
   */
  public ProgramElObject(PaymentProgram program) {
    this.program     = program;
    this.responsible = (program.getResponsible() != null) ? program.getResponsible()
                                                          : program.getAccount().getPrimaryResponsible();
    this.account     = program.getAccount();
    this.portfolio   = this.account.getPortfolio();
  }

  /**
   * Creates a new ProgramElObject object.
   *
   * @param  portfolio  DOCUMENT ME!
   */
  public ProgramElObject(Portfolio portfolio) {
    super(portfolio);
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.el.context.responsible.ResponsibleElObject#createContext()
   */
  @Override public ResponsibleElContext createContext() {
    ProgramElContext context = new ProgramElContext();
    context.setResponsible(responsible);
    context.setResponsibleDetail(responsibleDetail);
    context.setAccount(account);
    context.setAccountDetails(accountDetail);
    context.setAccountIndex(accountIndex);
    context.setPortfolio(portfolio);
    context.setEventInstance(eventInstance);
    context.setFlowStep(flowStep);
    context.setProgram(program);

    return context;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.el.context.responsible.ResponsibleElObject#getCacheKey()
   */
  @Override public String getCacheKey() {
    return "program-" + getProgramId();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getProgramId() {
    if (program != null) {
      return program.getProgramId();
    }

    return null;
  }
} // end class ProgramElObject
