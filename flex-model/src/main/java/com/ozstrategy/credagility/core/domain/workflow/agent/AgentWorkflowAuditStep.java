package com.ozstrategy.credagility.core.domain.workflow.agent;

import com.cmc.credagility.core.domain.user.User;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject;
import com.ozstrategy.credagility.core.domain.workflow.enterprise.WorkflowAuditStep;

import javax.persistence.*;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/17/2014 09:41
 */
@DiscriminatorValue("Agent")
@Entity public class AgentWorkflowAuditStep extends WorkflowAuditStep {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "agentBusinessObjectId",
    nullable   = true,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected User businessObject;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.enterprise.WorkflowAuditStep#createBusinessObject()
   */
  @Override public WorkflowBusinessObject createBusinessObject() {
    AgentWorkflowBusinessObject obj = new AgentWorkflowBusinessObject();
    obj.setAgent(businessObject);

    return obj;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for business object.
   *
   * @return  User
   */
  public User getBusinessObject() {
    return businessObject;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for business object.
   *
   * @param  businessObject  User
   */
  public void setBusinessObject(User businessObject) {
    this.businessObject = businessObject;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.enterprise.WorkflowAuditStep#setBusinessObject(Object)
   */
  @Override public void setBusinessObject(Object businessObject) {
    setBusinessObject((User) businessObject);
  }
} // end class AgentWorkflowAuditStep
