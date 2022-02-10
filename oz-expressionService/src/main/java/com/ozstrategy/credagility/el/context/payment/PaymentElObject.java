package com.ozstrategy.credagility.el.context.payment;

import com.cmc.credagility.core.domain.payment.Payment;
import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.ozstrategy.credagility.el.context.responsible.ResponsibleElContext;
import com.ozstrategy.credagility.el.context.responsible.ResponsibleElObject;


/**
 * Created by Yang Wang on 2/24/14.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public class PaymentElObject extends ResponsibleElObject<PaymentElContext> {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  private Payment payment;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new PaymentElContext object.
   */
  public PaymentElObject() { }

  /**
   * Creates a new PaymentElObject object.
   *
   * @param  payment  DOCUMENT ME!
   */
  public PaymentElObject(Payment payment) {
    this.payment     = payment;
    this.responsible = payment.getResponsible();
    this.account     = this.responsible.getAccount();
    this.portfolio   = this.account.getPortfolio();
  }

  /**
   * Creates a new PaymentElObject object.
   *
   * @param  portfolio  DOCUMENT ME!
   */
  public PaymentElObject(Portfolio portfolio) {
    super(portfolio);
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.el.context.responsible.ResponsibleElObject#createContext()
   */
  @Override public ResponsibleElContext createContext() {
    PaymentElContext context = new PaymentElContext();
    context.setResponsible(responsible);
    context.setResponsibleDetail(responsibleDetail);
    context.setAccount(account);
    context.setAccountDetails(accountDetail);
    context.setAccountIndex(accountIndex);
    context.setPortfolio(portfolio);
    context.setEventInstance(eventInstance);
    context.setFlowStep(flowStep);
    context.setPayment(payment);

    return context;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.el.context.responsible.ResponsibleElObject#getCacheKey()
   */
  @Override public String getCacheKey() {
    return "program-" + getPaymentId();
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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getPaymentId() {
    if (payment != null) {
      return payment.getPaymentId();
    }

    return null;
  }
} // end class PaymentElObject
