package com.ozstrategy.credagility.core.domain.workflow.agent;

import com.cmc.credagility.core.domain.user.User;
import com.ozstrategy.credagility.core.domain.workflow.enterprise.WorkflowTaskElementTempAnswer;

import javax.persistence.*;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/17/2014 09:49
 */
@DiscriminatorValue("Agent")
@Entity public class AgentWorkflowTaskElementTempAnswer extends WorkflowTaskElementTempAnswer {
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
   * @see  com.ozstrategy.credagility.core.domain.workflow.enterprise.WorkflowTaskElementTempAnswer#getBusinessObject()
   */
  @Override public User getBusinessObject() {
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
   * @see  com.ozstrategy.credagility.core.domain.workflow.enterprise.WorkflowTaskElementTempAnswer#setBusinessObject(Object)
   */
  @Override public void setBusinessObject(Object businessObject) {
    setBusinessObject((User) businessObject);
  }
} // end class AgentWorkflowTaskElementTempAnswer
