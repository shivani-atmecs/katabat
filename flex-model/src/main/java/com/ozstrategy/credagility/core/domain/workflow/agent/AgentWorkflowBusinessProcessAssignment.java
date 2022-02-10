package com.ozstrategy.credagility.core.domain.workflow.agent;

import com.cmc.credagility.core.domain.user.User;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessProcessAssignment;

import javax.persistence.*;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/17/2014 09:44
 */
@DiscriminatorValue("Agent")
@Entity public class AgentWorkflowBusinessProcessAssignment extends WorkflowBusinessProcessAssignment {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -2778825338053435895L;

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
} // end class AgentWorkflowBusinessProcessAssignment
