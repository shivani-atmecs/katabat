package com.ozstrategy.credagility.el.context.businesscontextinstance;

import java.util.Map;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.businesscontext.BusinessContext;
import com.cmc.credagility.core.domain.businesscontext.BusinessContextInstance;
import com.cmc.credagility.core.domain.customer.Customer;
import com.cmc.credagility.core.domain.responsible.Responsible;

import com.ozstrategy.credagility.core.domain.workflow.bci.BCIWorkflowStep;
import com.ozstrategy.credagility.core.el.ElObject;


/**
 * Created by Yang Wang on 2/24/14.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public class BCIElObject extends ElObject<BCIElContext> {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  private Account                 account;
  private BusinessContext         businessContext;
  private Long                    businessContextId;
  private BusinessContextInstance businessContextInstance;
  private Customer                customer;
  private Responsible             responsible;
  private BCIWorkflowStep         workflowStep;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new BCIElContext object.
   */
  public BCIElObject() { }

  /**
   * Creates a new BCIElObject object.
   *
   * @param  businessContext  DOCUMENT ME!
   */
  public BCIElObject(BusinessContext businessContext) {
    this.businessContext   = businessContext;
    this.businessContextId = businessContext.getId();
  }

  /**
   * Creates a new BCIElObject object.
   *
   * @param  businessContextInstance  DOCUMENT ME!
   */
  public BCIElObject(BusinessContextInstance businessContextInstance) {
    this.businessContextInstance = businessContextInstance;

    if (businessContextInstance != null) {
      this.businessContext = businessContextInstance.getBusinessContext();
    }

    if (this.businessContext != null) {
      this.businessContextId = this.businessContext.getId();
    }
  }

  /**
   * Creates a new BCIElObject object.
   *
   * @param  businessContextInstance  DOCUMENT ME!
   * @param  workflowStep             DOCUMENT ME!
   */
  public BCIElObject(BusinessContextInstance businessContextInstance, BCIWorkflowStep workflowStep) {
    this(null, businessContextInstance, workflowStep);
  }

  /**
   * Creates a new BCIElObject object.
   *
   * @param  context                  DOCUMENT ME!
   * @param  businessContextInstance  DOCUMENT ME!
   * @param  workflowStep             DOCUMENT ME!
   */
  public BCIElObject(BusinessContext context, BusinessContextInstance businessContextInstance,
    BCIWorkflowStep workflowStep) {
    this(businessContextInstance);

    if ((businessContextInstance == null) && (context != null)) {
      this.businessContext   = context;
      this.businessContextId = context.getId();
    }

    if ((workflowStep != null) && (this.businessContextId == null)) {
      this.businessContextId = workflowStep.getWorkflow().getSchedule().getBusinessContext().getId();
    }

    this.workflowStep = workflowStep;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.el.ElObject#createContext()
   */
  @Override public BCIElContext createContext() {
    BCIElContext context = new BCIElContext();
    context.setAccount(account);
    context.setBusinessContext(businessContext);
    context.setBusinessContextId(businessContextId);
    context.setBusinessContextInstance(businessContextInstance);
    context.setCustomer(customer);
    context.setResponsible(responsible);
    context.setWorkflowStep(workflowStep);
    context.setExecutor(this.getExecutor());

    return context;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.el.ElObject#exposeParams(java.util.Map)
   */
  @Override public void exposeParams(Map<String, Object> params) {
    params.put("businessContextInstance", businessContextInstance);
    params.put("responsible", businessContextInstance.getResponsible());
    params.put("account", businessContextInstance.getAccount());
    params.put("customer", businessContextInstance.getCustomer());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.el.ElObject#getCacheKey()
   */
  @Override public String getCacheKey() {
    if (businessContextInstance != null) {
      return "BCI-" + businessContextInstance.getId();
    } else if (workflowStep != null) {
      return "BCI-wfins-" + workflowStep.getWorkflowInstance().getId();
    }

    return "BCI-xxx";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getId() {
    if (businessContextInstance != null) {
      return businessContextInstance.getId();
    }

    return null;
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
} // end class BCIElObject
