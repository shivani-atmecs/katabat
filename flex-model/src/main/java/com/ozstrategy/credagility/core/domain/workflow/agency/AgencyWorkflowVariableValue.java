package com.ozstrategy.credagility.core.domain.workflow.agency;

import com.cmc.credagility.core.domain.user.Role;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject;
import com.ozstrategy.credagility.core.domain.workflow.enterprise.WorkflowVariableValue;

import javax.persistence.*;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/17/2014 11:33
 */
@DiscriminatorValue("Agency")
@Entity public class AgencyWorkflowVariableValue extends WorkflowVariableValue {
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
   * createBusinessObject.
   *
   * @return  WorkflowBusinessObject
   */
  @Override public WorkflowBusinessObject createBusinessObject() {
    AgencyWorkflowBusinessObject obj = new AgencyWorkflowBusinessObject();
    obj.setAgency(businessObject);

    return obj;
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
   * setter method for business object.
   *
   * @param  businessObject  Object
   */
  @Override public void setBusinessObject(Object businessObject) {
    setBusinessObject((Role) businessObject);
  }
} // end class AgencyWorkflowVariableValue
