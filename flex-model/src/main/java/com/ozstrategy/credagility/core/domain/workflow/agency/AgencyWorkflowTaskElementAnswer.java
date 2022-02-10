package com.ozstrategy.credagility.core.domain.workflow.agency;

import com.cmc.credagility.core.domain.user.Role;
import com.ozstrategy.credagility.core.domain.workflow.enterprise.WorkflowTaskElementAnswer;

import javax.persistence.*;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/16/2014 17:24
 */
@DiscriminatorValue("Agency")
@Entity public class AgencyWorkflowTaskElementAnswer extends WorkflowTaskElementAnswer {
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
   * @see  com.ozstrategy.credagility.core.domain.workflow.enterprise.WorkflowTaskElementAnswer#getBusinessObject()
   */
  @Override public Role getBusinessObject() {
    return businessObject;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.enterprise.WorkflowTaskElementAnswer#setBusinessObject(Object)
   */
  @Override public void setBusinessObject(Object businessObject) {
    setBusinessObject((Role) businessObject);
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
} // end class AgencyWorkflowTaskElementAnswer
