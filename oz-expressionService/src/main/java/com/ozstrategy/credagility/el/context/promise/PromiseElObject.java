package com.ozstrategy.credagility.el.context.promise;

import com.cmc.credagility.core.domain.payment.PromiseToPay;
import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.ozstrategy.credagility.el.context.responsible.ResponsibleElContext;
import com.ozstrategy.credagility.el.context.responsible.ResponsibleElObject;


/**
 * Created with IntelliJ IDEA. User: weitang Date: 14-9-15 Time: PM4:34 To change this template use File | Settings |
 * File Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public class PromiseElObject extends ResponsibleElObject<PromiseElContext> {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  private PromiseToPay promise;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new ProgramElContext object.
   */
  public PromiseElObject() { }

  /**
   * Creates a new ProgramElObject object.
   *
   * @param  promise  DOCUMENT ME!
   */
  public PromiseElObject(PromiseToPay promise) {
    this.promise     = promise;
    this.responsible = promise.getResponsible();
    this.account     = promise.getAccount();
    this.portfolio   = this.account.getPortfolio();
  }

  /**
   * Creates a new ProgramElObject object.
   *
   * @param  portfolio  DOCUMENT ME!
   */
  public PromiseElObject(Portfolio portfolio) {
    super(portfolio);
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.el.context.responsible.ResponsibleElObject#createContext()
   */
  @Override public ResponsibleElContext createContext() {
    PromiseElContext context = new PromiseElContext();
    context.setResponsible(responsible);
    context.setResponsibleDetail(responsibleDetail);
    context.setAccount(account);
    context.setAccountDetails(accountDetail);
    context.setAccountIndex(accountIndex);
    context.setPortfolio(portfolio);
    context.setEventInstance(eventInstance);
    context.setFlowStep(flowStep);
    context.setPromise(promise);

    return context;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.el.context.responsible.ResponsibleElObject#getCacheKey()
   */
  @Override public String getCacheKey() {
    return "promise-" + getPromiseId();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getPromiseId() {
    if (promise != null) {
      return promise.getPromiseId();
    }

    return null;
  }
} // end class PromiseElObject
