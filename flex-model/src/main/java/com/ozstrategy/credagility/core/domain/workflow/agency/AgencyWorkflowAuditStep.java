package com.ozstrategy.credagility.core.domain.workflow.agency;

import com.cmc.credagility.core.domain.user.Role;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject;
import com.ozstrategy.credagility.core.domain.workflow.enterprise.WorkflowAuditStep;

import javax.persistence.*;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/17/2014 11:31
 */
@DiscriminatorValue("Agency")
@Entity public class AgencyWorkflowAuditStep extends WorkflowAuditStep {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "agencyBusinessObjectId",
    nullable   = true,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Role businessObject;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.enterprise.WorkflowAuditStep#createBusinessObject()
   */
  @Override public WorkflowBusinessObject createBusinessObject() {
    AgencyWorkflowBusinessObject obj = new AgencyWorkflowBusinessObject();
    obj.setAgency(businessObject);

    return obj;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for business object.
   *
   * @return  Role
   */
  public Role getBusinessObject() {
    return businessObject;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for business object.
   *
   * @param  businessObject  Role
   */
  public void setBusinessObject(Role businessObject) {
    this.businessObject = businessObject;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.enterprise.WorkflowAuditStep#setBusinessObject(Object)
   */
  @Override public void setBusinessObject(Object businessObject) {
    setBusinessObject((Role) businessObject);
  }
} // end class AgencyWorkflowAuditStep
