package com.ozstrategy.credagility.core.domain.workflow.agency;

import com.cmc.credagility.core.domain.user.Role;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessProcessAssignment;

import javax.persistence.*;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/16/2014 17:20
 */
@DiscriminatorValue("Agency")
@Entity public class AgencyWorkflowBusinessProcessAssignment extends WorkflowBusinessProcessAssignment {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 1852999935999189355L;

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
} // end class AgencyWorkflowBusinessProcessAssignment
