package com.ozstrategy.credagility.core.domain.workflow.agent;

import com.cmc.credagility.core.domain.user.User;
import com.ozstrategy.credagility.core.domain.workflow.enterprise.EntWorkflowBusinessObject;
import com.ozstrategy.credagility.core.domain.workflow.enterprise.WorkflowStep;

import javax.persistence.*;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/17/2014 09:46
 */
@DiscriminatorValue("Agent")
@Entity public class AgentWorkflowStep extends WorkflowStep {
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
   * @see  com.ozstrategy.credagility.core.domain.workflow.enterprise.WorkflowStep#copy()
   */
  @Override public WorkflowStep copy() {
    AgentWorkflowStep step = new AgentWorkflowStep();
    paste(step);

    return step;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.enterprise.WorkflowStep#createBusinessObject()
   */
  @Override public EntWorkflowBusinessObject createBusinessObject() {
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
   * @see  com.ozstrategy.credagility.core.domain.workflow.enterprise.WorkflowStep#setBusinessObject(Object)
   */
  @Override public void setBusinessObject(Object businessObject) {
    setBusinessObject((User) businessObject);
  }
} // end class AgentWorkflowStep
