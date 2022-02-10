package com.ozstrategy.credagility.el.context.responsible;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.account.AccountDetail;
import com.cmc.credagility.core.domain.account.AccountIndex;
import com.cmc.credagility.core.domain.event.EventInstance;
import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.domain.responsible.ResponsibleDetail;
import com.ozstrategy.credagility.core.domain.SurveyFlowStep;
import com.ozstrategy.credagility.core.el.ElObject;

import java.util.Map;


/**
 * Created by Yang Wang on 2/24/14.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public class ResponsibleElObject<C extends ResponsibleElContext> extends ElObject<ResponsibleElContext> {
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

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new ResponsibleElContext object.
   */
  public ResponsibleElObject() { }

  /**
   * Creates a new ResponsibleElObject object.
   *
   * @param  responsible  DOCUMENT ME!
   */
  public ResponsibleElObject(Responsible responsible) {
    this.responsible = responsible;
    this.account     = responsible.getAccount();

    if (this.account != null) {
      this.portfolio = this.account.getPortfolio();
    }
  }


  /**
   * Creates a new ResponsibleElObject object.
   *
   * @param  portfolio  DOCUMENT ME!
   */
  public ResponsibleElObject(Portfolio portfolio) {
    this.portfolio = portfolio;
  }

  /**
   * Creates a new ResponsibleElObject object.
   *
   * @param  account  DOCUMENT ME!
   */
  public ResponsibleElObject(Account account) {
    this.account     = account;
    this.responsible = account.getPrimaryResponsible();
    this.portfolio   = this.account.getPortfolio();
  }


  /**
   * Creates a new ResponsibleElObject object.
   *
   * @param  responsible    DOCUMENT ME!
   * @param  eventInstance  DOCUMENT ME!
   */
  public ResponsibleElObject(Responsible responsible, EventInstance eventInstance) {
    this.responsible   = responsible;
    this.eventInstance = eventInstance;
    this.account       = responsible.getAccount();

    if (this.account != null) {
      this.portfolio = this.account.getPortfolio();
    }
  }

  /**
   * Creates a new ResponsibleElObject object.
   *
   * @param  entity         DOCUMENT ME!
   * @param  flowStep       DOCUMENT ME!
   * @param  eventInstance  DOCUMENT ME!
   */
  public ResponsibleElObject(Responsible entity, SurveyFlowStep flowStep, EventInstance eventInstance) {
    this.responsible = entity;
    this.account     = entity.getAccount();

    if (this.account != null) {
      this.portfolio = this.account.getPortfolio();
    }

    this.flowStep      = flowStep;
    this.eventInstance = eventInstance;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Override public ResponsibleElContext createContext() {
    ResponsibleElContext context = new ResponsibleElContext();
    context.setResponsible(responsible);
    context.setResponsibleDetail(responsibleDetail);
    context.setAccount(account);
    context.setAccountDetails(accountDetail);
    context.setAccountIndex(accountIndex);
    context.setPortfolio(portfolio);
    context.setEventInstance(eventInstance);
    context.setFlowStep(flowStep);
    context.setExecutor(this.getExecutor());

    return context;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * exposeParams.
   *
   * @param  params  Map
   */
  @Override public void exposeParams(Map<String, Object> params) {
    params.put("responsible", responsible);
    params.put("account", responsible.getAccount());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for cache key.
   *
   * @return  String
   */
  @Override public String getCacheKey() {
    return "responsible-" + getPortfolioId() + "-" + getResponsibleId();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getResponsibleId() {
    if (responsible == null) {
      return null;
    }

    return responsible.getResponsibleId();
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

  private Long getPortfolioId() {
    if (portfolio == null) {
      return null;
    }

    return portfolio.getPortfolioId();
  }
} // end class ResponsibleElObject
